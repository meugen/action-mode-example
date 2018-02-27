package def.meugeninua.defaultandroid.app.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import def.meugeninua.defaultandroid.app.di.PerActivity;
import def.meugeninua.defaultandroid.ui.activities.main.MainActivity;
import def.meugeninua.defaultandroid.ui.activities.main.MainActivityModule;

/**
 * @author meugen
 */
@Module
public abstract class ComponentsModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    @PerActivity
    abstract MainActivity contributeMainActivity();
}
