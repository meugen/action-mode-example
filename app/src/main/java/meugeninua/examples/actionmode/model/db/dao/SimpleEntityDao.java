package meugeninua.examples.actionmode.model.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.Collection;
import java.util.List;

import javax.inject.Qualifier;

import meugeninua.examples.actionmode.model.db.data.CountData;
import meugeninua.examples.actionmode.model.db.entities.SimpleEntity;

@Dao
public interface SimpleEntityDao {

    @Insert
    void insert(SimpleEntity entity);

    @Query("SELECT count(id) c FROM simples")
    CountData count();

    @Query("DELETE FROM simples WHERE id IN (:ids)")
    void deleteById(List<Integer> ids);

    @Query("SELECT * FROM simples")
    List<SimpleEntity> all();
}
