package meugeninua.examples.actionmode.app.di;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import meugeninua.examples.actionmode.app.ActionModeApp;
import meugeninua.examples.actionmode.app.di.modules.AppModule;

/**
 * @author meugen
 */
@Component(modules = AppModule.class)
@Singleton
public interface AppComponent extends AndroidInjector<ActionModeApp> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<ActionModeApp> {}
}
