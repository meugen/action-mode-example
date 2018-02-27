package meugeninua.examples.actionmode.model.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "simples")
public class SimpleEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "data")
    public String data;
}
