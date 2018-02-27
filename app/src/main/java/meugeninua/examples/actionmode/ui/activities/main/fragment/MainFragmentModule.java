package meugeninua.examples.actionmode.ui.activities.main.fragment;

import android.support.v4.app.Fragment;

import java.util.List;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import meugeninua.examples.actionmode.app.di.scopes.PerFragment;
import meugeninua.examples.actionmode.app.managers.events.AppEventManager;
import meugeninua.examples.actionmode.app.managers.events.SimplesChangedEvent;
import meugeninua.examples.actionmode.model.api.AppActionApi;
import meugeninua.examples.actionmode.model.api.simples.SimplesActionApi;
import meugeninua.examples.actionmode.model.db.entities.SimpleEntity;
import meugeninua.examples.actionmode.ui.activities.base.fragment.BaseFragmentModule;
import meugeninua.examples.actionmode.ui.activities.base.fragment.LifecycleModule;
import meugeninua.examples.actionmode.ui.activities.main.fragment.presenter.MainPresenter;
import meugeninua.examples.actionmode.ui.activities.main.fragment.presenter.MainPresenterImpl;
import meugeninua.examples.actionmode.ui.activities.main.fragment.state.MainState;
import meugeninua.examples.actionmode.ui.activities.main.fragment.state.MainStateImpl;
import meugeninua.examples.actionmode.ui.activities.main.fragment.view.MainView;

/**
 * @author meugen
 */
@Module(includes = {BaseFragmentModule.class, LifecycleModule.class})
public abstract class MainFragmentModule {

    @Binds @PerFragment
    abstract Fragment bindFragment(final MainFragment fragment);

    @Binds @PerFragment
    abstract MainPresenter bindPresenter(final MainPresenterImpl impl);

    @Binds @PerFragment
    abstract MainState bindState(final MainStateImpl impl);

    @Binds @PerFragment
    abstract MainView bindView(final MainFragment fragment);

    @Binds @PerFragment
    abstract AppActionApi<Void, List<SimpleEntity>> bindSimplesActionApi(
            final SimplesActionApi api);

    @Provides @PerFragment
    static Observable<SimplesChangedEvent> provideSimplesChangedObservable(
            final AppEventManager manager) {
        return manager.getObservable(SimplesChangedEvent.class);
    }
}
