package meugeninua.examples.actionmode.model.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import meugeninua.examples.actionmode.model.db.dao.SimpleEntityDao;
import meugeninua.examples.actionmode.model.db.entities.SimpleEntity;


@Database(entities = {SimpleEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract SimpleEntityDao simpleEntityDao();
}
