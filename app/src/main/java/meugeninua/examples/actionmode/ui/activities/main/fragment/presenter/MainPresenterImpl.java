package meugeninua.examples.actionmode.ui.activities.main.fragment.presenter;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import meugeninua.examples.actionmode.app.managers.events.SimplesChangedEvent;
import meugeninua.examples.actionmode.model.api.AppActionApi;
import meugeninua.examples.actionmode.model.db.entities.SimpleEntity;
import meugeninua.examples.actionmode.ui.activities.base.fragment.presenter.BasePresenter;
import meugeninua.examples.actionmode.ui.activities.main.fragment.state.MainState;
import meugeninua.examples.actionmode.ui.activities.main.fragment.view.MainView;
import meugeninua.examples.actionmode.ui.rxloader.LifecycleHandler;
import timber.log.Timber;

/**
 * @author meugen
 */
public class MainPresenterImpl extends BasePresenter<MainState> implements MainPresenter {

    @Inject LifecycleHandler lifecycleHandler;
    @Inject AppActionApi<Void, List<SimpleEntity>> simplesActionApi;
    @Inject Observable<SimplesChangedEvent> simplesChangedObservable;
    @Inject MainView view;

    @Inject
    MainPresenterImpl() {}

    @Override
    public void setup() {
        _load();
        subscribeToSimplesChanged();
    }

    @Override
    public void onRestoreState(final MainState state) {
        super.onRestoreState(state);
    }

    @Override
    public void onSaveState(final MainState state) {
        super.onSaveState(state);
    }

    private void subscribeToSimplesChanged() {
        final Disposable disposable = simplesChangedObservable
                .subscribe(event -> reload());
        getCompositeDisposable().add(disposable);
    }

    private void reload() {
        lifecycleHandler.destroyLoader(LOADER_ID);
        _load();
    }

    private void _load() {
        final Disposable disposable = simplesActionApi
                .action(null)
                .compose(lifecycleHandler.load(LOADER_ID))
                .subscribe(view::displaySimples, Timber::d);
        getCompositeDisposable().add(disposable);
    }
}
