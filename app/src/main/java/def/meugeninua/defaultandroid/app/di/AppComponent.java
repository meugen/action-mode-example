package def.meugeninua.defaultandroid.app.di;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import def.meugeninua.defaultandroid.app.DefAndroid;
import def.meugeninua.defaultandroid.app.di.modules.AppModule;

/**
 * @author meugen
 */
@Component(modules = AppModule.class)
@Singleton
public interface AppComponent extends AndroidInjector<DefAndroid> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<DefAndroid> {}
}
