package meugeninua.examples.actionmode.ui.rxloader;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import meugeninua.examples.actionmode.app.di.qualifiers.ActivityContext;
import meugeninua.examples.actionmode.app.utils.RxUtils;

public class LoaderLifecycleHandler implements LifecycleHandler {

    @Inject @ActivityContext Context context;
    @Inject LoaderManager manager;

    @Inject
    LoaderLifecycleHandler() {}

    private <T> ObservableSource<T> load(
            final Observable<T> upstream,
            final int id, final boolean reload) {
        final Observable<T> ob = upstream.compose(RxUtils.async());
        if (reload) {
            manager.destroyLoader(id);
        }
        manager.initLoader(id, Bundle.EMPTY,
                new RxLoaderCallbacks<>(context, ob));
        RxLoader<T> loader = (RxLoader<T>) manager.getLoader(id);
        return loader.createObservable();
    }

    @Override
    public <T> ObservableTransformer<T, T> load(final int id) {
        return upstream -> load(upstream, id, false);
    }

    @Override
    public <T> ObservableTransformer<T, T> reload(final int id) {
        return upstream -> load(upstream, id, true);
    }

    @Override
    public boolean hasLoader(final int id) {
        return manager.getLoader(id) != null;
    }

    @Override
    public void destroyLoader(final int id) {
        manager.destroyLoader(id);
    }

    @Override
    public void clear(final int id) {
        manager.destroyLoader(id);
    }

    private static class RxLoaderCallbacks<T> implements LoaderManager.LoaderCallbacks<T> {

        private final Context context;
        private final Observable<T> observable;

        RxLoaderCallbacks(final Context context, final Observable<T> observable) {
            this.context = context;
            this.observable = observable;
        }

        @Override
        public Loader<T> onCreateLoader(final int id, final Bundle args) {
            return new RxLoader<>(context, observable);
        }

        @Override
        public void onLoadFinished(final Loader<T> loader, final T data) {}

        @Override
        public void onLoaderReset(final Loader<T> loader) {}
    }
}
