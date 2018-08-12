package meugeninua.examples.actionmode.ui.activities.base.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import meugeninua.examples.actionmode.ui.rxloader.LifecycleHandler;
import meugeninua.examples.actionmode.ui.rxloader.LoaderLifecycleHandler;

@Module
public abstract class LifecycleModule {

    @Provides
    static LoaderManager provideLoaderManager(final Fragment fragment) {
        return fragment.getLoaderManager();
    }

    @Binds
    abstract LifecycleHandler bindLifecycleHandler(
            final LoaderLifecycleHandler handler);
}
