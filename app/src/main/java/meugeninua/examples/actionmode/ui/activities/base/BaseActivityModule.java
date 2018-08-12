package meugeninua.examples.actionmode.ui.activities.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import meugeninua.examples.actionmode.app.di.qualifiers.ActivityContext;

/**
 * @author meugen
 */
@Module
public abstract class BaseActivityModule {

    @Binds @ActivityContext
    abstract Context bindContext(final AppCompatActivity activity);
}
