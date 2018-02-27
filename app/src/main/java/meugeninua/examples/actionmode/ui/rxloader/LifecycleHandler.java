package meugeninua.examples.actionmode.ui.rxloader;

import io.reactivex.ObservableTransformer;

public interface LifecycleHandler {

    <T> ObservableTransformer<T, T> load(int id);

    <T> ObservableTransformer<T, T> reload(int id);

    boolean hasLoader(int id);

    void destroyLoader(int id);

    void clear(int id);
}
