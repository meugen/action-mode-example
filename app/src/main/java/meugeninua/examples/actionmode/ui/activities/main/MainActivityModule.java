package meugeninua.examples.actionmode.ui.activities.main;

import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import meugeninua.examples.actionmode.app.di.scopes.PerActivity;
import meugeninua.examples.actionmode.app.di.scopes.PerFragment;
import meugeninua.examples.actionmode.ui.activities.base.BaseActivityModule;
import meugeninua.examples.actionmode.ui.activities.main.fragment.MainFragment;
import meugeninua.examples.actionmode.ui.activities.main.fragment.MainFragmentModule;

/**
 * @author meugen
 */
@Module(includes = BaseActivityModule.class)
public abstract class MainActivityModule {

    @Binds @PerActivity
    abstract AppCompatActivity bindActivity(final MainActivity activity);

    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    @PerFragment
    abstract MainFragment contributeMainFragment();
}
