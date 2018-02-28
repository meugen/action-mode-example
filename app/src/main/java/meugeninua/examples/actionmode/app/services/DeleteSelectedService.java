package meugeninua.examples.actionmode.app.services;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import meugeninua.examples.actionmode.app.managers.events.AppEventManager;
import meugeninua.examples.actionmode.app.managers.events.SimplesChangedEvent;
import meugeninua.examples.actionmode.model.db.dao.SimpleEntityDao;
import meugeninua.examples.actionmode.model.utils.CollectionUtils;


public class DeleteSelectedService extends JobIntentService {

    private static final String PARAM_SELECTED_IDS = "selected_ids";

    public static void enqueueWork(
            final Context context,
            final Collection<Integer> selectedIds) {
        final Intent intent = new Intent(context,
                DeleteSelectedService.class);
        intent.putIntegerArrayListExtra(PARAM_SELECTED_IDS,
                CollectionUtils.toArrayList(selectedIds));
        enqueueWork(context, DeleteSelectedService.class, 0, intent);
    }

    @Inject SimpleEntityDao simpleEntityDao;
    @Inject AppEventManager eventManager;

    @Override
    public void onCreate() {
        AndroidInjection.inject(this);
        super.onCreate();
    }

    @Override
    protected void onHandleWork(@NonNull final Intent intent) {
        final List<Integer> selectedIds = intent
                .getIntegerArrayListExtra(PARAM_SELECTED_IDS);
        simpleEntityDao.deleteById(selectedIds);
        eventManager.post(new SimplesChangedEvent());
    }
}
