package meugeninua.examples.actionmode.app.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import meugeninua.examples.actionmode.app.di.qualifiers.AppContext;
import meugeninua.examples.actionmode.model.db.AppDatabase;
import meugeninua.examples.actionmode.model.db.dao.SimpleEntityDao;

@Module
public abstract class DbModule {

    @Provides @Singleton
    static AppDatabase provideAppDatabase(@AppContext Context context) {
        return Room
                .databaseBuilder(context, AppDatabase.class, "actionmode")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides @Singleton
    static SimpleEntityDao provideSimpleEntityDao(final AppDatabase database) {
        return database.simpleEntityDao();
    }
}
