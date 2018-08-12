package meugeninua.examples.actionmode.app.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import meugeninua.examples.actionmode.app.services.DeleteSelectedService;
import meugeninua.examples.actionmode.app.services.LoadDefaultsService;
import meugeninua.examples.actionmode.ui.activities.main.MainActivity;
import meugeninua.examples.actionmode.ui.activities.main.MainActivityModule;

/**
 * @author meugen
 */
@Module
public abstract class ComponentsModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector
    abstract LoadDefaultsService contributeLoadDefaultsService();

    @ContributesAndroidInjector
    abstract DeleteSelectedService contributeDeletedSelectedService();
}
