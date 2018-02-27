package def.meugeninua.defaultandroid.ui.activities.main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import def.meugeninua.defaultandroid.app.di.PerActivity;
import def.meugeninua.defaultandroid.app.di.PerFragment;
import def.meugeninua.defaultandroid.ui.activities.base.BaseActivityModule;
import def.meugeninua.defaultandroid.ui.activities.main.fragment.MainFragment;
import def.meugeninua.defaultandroid.ui.activities.main.fragment.MainFragmentModule;

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
