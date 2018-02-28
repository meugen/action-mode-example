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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final SimpleEntity that = (SimpleEntity) o;

        if (id != that.id) return false;
        return data.equals(that.data);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + data.hashCode();
        return result;
    }
}
