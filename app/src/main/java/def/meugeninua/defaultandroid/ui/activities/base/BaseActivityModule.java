package def.meugeninua.defaultandroid.ui.activities.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import def.meugeninua.defaultandroid.app.di.PerActivity;

/**
 * @author meugen
 */
@Module
public abstract class BaseActivityModule {

    public static final String ACTIVITY_CONTEXT = "activity_context";

    @Binds @PerActivity
    abstract Context bindContext(final AppCompatActivity activity);
}
