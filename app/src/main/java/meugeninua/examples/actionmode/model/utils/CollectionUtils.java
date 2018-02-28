package meugeninua.examples.actionmode.model.utils;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionUtils {

    public static <T> ArrayList<T> toArrayList(
            final Collection<T> c) {
        return c instanceof ArrayList
                ? (ArrayList<T>) c
                : new ArrayList<>(c);
    }

    private CollectionUtils() {}
}
