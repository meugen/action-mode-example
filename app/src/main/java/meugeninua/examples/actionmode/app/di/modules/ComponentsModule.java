package meugeninua.examples.actionmode.app.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import meugeninua.examples.actionmode.app.di.PerActivity;
import meugeninua.examples.actionmode.ui.activities.main.MainActivity;
import meugeninua.examples.actionmode.ui.activities.main.MainActivityModule;

/**
 * @author meugen
 */
@Module
public abstract class ComponentsModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    @PerActivity
    abstract MainActivity contributeMainActivity();
}
