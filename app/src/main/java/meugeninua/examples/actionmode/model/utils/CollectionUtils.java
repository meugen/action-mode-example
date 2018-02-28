package meugeninua.examples.actionmode.model.utils;

import android.support.v4.util.ArraySet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class CollectionUtils {

    public static <T> ArrayList<T> toArrayList(
            final Collection<T> c) {
        return c instanceof ArrayList
                ? (ArrayList<T>) c
                : new ArrayList<>(c);
    }

    public static <T> Collection<T> xor(
            final Collection<T> a, final Collection<T> b) {
        final Set<T> result = new ArraySet<>();
        result.addAll(a);
        result.addAll(b);

        final Iterator<T> iterator = result.iterator();
        while (iterator.hasNext()) {
            final T item = iterator.next();
            if (a.contains(item) && b.contains(item)) {
                iterator.remove();
            }
        }
        return result;
    }

    private CollectionUtils() {}
}
