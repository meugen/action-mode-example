package meugeninua.examples.actionmode.app.di.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.support.AndroidSupportInjectionModule;
import meugeninua.examples.actionmode.app.ActionModeApp;

/**
 * @author meugen
 */
@Module(includes = {AndroidSupportInjectionModule.class,
        ComponentsModule.class})
public abstract class AppModule {

    public static final String APP_CONTEXT = "app_context";

    @Binds @Singleton
    abstract Application bindApplication(final ActionModeApp actionModeApp);

    @Binds @Named(APP_CONTEXT) @Singleton
    abstract Context bindAppContext(final Context context);
}
