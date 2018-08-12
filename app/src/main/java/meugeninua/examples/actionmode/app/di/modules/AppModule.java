package meugeninua.examples.actionmode.app.di.modules;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;
import dagger.android.support.AndroidSupportInjectionModule;
import meugeninua.examples.actionmode.app.ActionModeApp;
import meugeninua.examples.actionmode.app.di.qualifiers.AppContext;

/**
 * @author meugen
 */
@Module(includes = {AndroidSupportInjectionModule.class,
        ComponentsModule.class, DbModule.class})
public abstract class AppModule {

    @Binds
    abstract Application bindApplication(final ActionModeApp app);

    @Binds @AppContext
    abstract Context bindAppContext(final Application application);
}
