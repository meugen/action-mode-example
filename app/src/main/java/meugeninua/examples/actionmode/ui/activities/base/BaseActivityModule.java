package meugeninua.examples.actionmode.ui.activities.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import meugeninua.examples.actionmode.app.di.qualifiers.ActivityContext;
import meugeninua.examples.actionmode.app.di.scopes.PerActivity;

/**
 * @author meugen
 */
@Module
public abstract class BaseActivityModule {

    @Binds @ActivityContext @PerActivity
    abstract Context bindContext(final AppCompatActivity activity);
}
