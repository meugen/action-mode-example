package meugeninua.examples.actionmode.ui.activities.main.fragment.presenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
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
public class MainPresenterImpl extends BasePresenter<MainState>
        implements MainPresenter {

    @Inject LifecycleHandler lifecycleHandler;
    @Inject AppActionApi<Void, List<SimpleEntity>> simplesActionApi;
    @Inject Observable<SimplesChangedEvent> simplesChangedObservable;
    @Inject MainView view;

    private Collection<Integer> selectedIds;

    @Inject
    MainPresenterImpl() {}

    @Override
    public void setup() {
        _load();
        subscribeToSimplesChanged();
    }

    @Override
    public void addIdToSelected(final int id) {
        selectedIds.add(id);
    }

    @Override
    public void clearSelected() {
        selectedIds.clear();
    }

    @Override
    public Collection<Integer> getSelectedIds() {
        return selectedIds;
    }

    @Override
    public void onRestoreState(final MainState state) {
        super.onRestoreState(state);
        this.selectedIds = state.getSelectedIds();
    }

    @Override
    public void onSaveState(final MainState state) {
        super.onSaveState(state);
        state.setSelectedIds(selectedIds);
    }

    private void subscribeToSimplesChanged() {
        final Disposable disposable = simplesChangedObservable
                .observeOn(AndroidSchedulers.mainThread())
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
                .subscribe(this::displaySimples, Timber::d);
        getCompositeDisposable().add(disposable);
    }

    private void displaySimples(final List<SimpleEntity> simples) {
        if (selectedIds == null) {
            selectedIds = new ArrayList<>();
        }
        view.displaySimples(simples, selectedIds);
    }
}
