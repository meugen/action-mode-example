package meugeninua.examples.actionmode.app.services;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;

import java.math.BigInteger;
import java.util.Random;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import meugeninua.examples.actionmode.app.managers.events.AppEventManager;
import meugeninua.examples.actionmode.app.managers.events.SimplesChangedEvent;
import meugeninua.examples.actionmode.model.db.AppDatabase;
import meugeninua.examples.actionmode.model.db.dao.SimpleEntityDao;
import meugeninua.examples.actionmode.model.db.data.CountData;
import meugeninua.examples.actionmode.model.db.entities.SimpleEntity;


public class LoadDefaultsService extends JobIntentService {

    private static final Random RANDOM = new Random();
    private static final int COUNT = 10;

    public static void enqueueWork(final Context context) {
        final Intent intent = new Intent(context, LoadDefaultsService.class);
        enqueueWork(context, LoadDefaultsService.class, 0, intent);
    }

    @Inject AppDatabase database;
    @Inject SimpleEntityDao simpleEntityDao;
    @Inject AppEventManager eventManager;

    @Override
    public void onCreate() {
        AndroidInjection.inject(this);
        super.onCreate();
    }

    @Override
    protected void onHandleWork(@NonNull final Intent intent) {
        final CountData data = simpleEntityDao.count();
        if (data.count > 0) {
            return;
        }
        database.beginTransaction();
        try {
            for (int i = 0; i < COUNT; i++) {
                final SimpleEntity entity = new SimpleEntity();
                entity.data = "" + i + ". " +
                        new BigInteger(100, RANDOM).toString(26);
                simpleEntityDao.insert(entity);
            }
            database.setTransactionSuccessful();

            eventManager.post(new SimplesChangedEvent());
        } finally {
            database.endTransaction();
        }
    }
}
