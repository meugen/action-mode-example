package def.meugeninua.defaultandroid.app.di.modules;

import android.app.Application;
import android.content.Context;
import android.support.v4.content.ContextCompat;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.support.AndroidSupportInjectionModule;
import def.meugeninua.defaultandroid.app.DefAndroid;

/**
 * @author meugen
 */
@Module(includes = {AndroidSupportInjectionModule.class,
        ComponentsModule.class})
public abstract class AppModule {

    public static final String APP_CONTEXT = "app_context";

    @Binds @Singleton
    abstract Application bindApplication(final DefAndroid defAndroid);

    @Binds @Named(APP_CONTEXT) @Singleton
    abstract Context bindAppContext(final Context context);
}
