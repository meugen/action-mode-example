package def.meugeninua.defaultandroid.ui.activities.base.fragment.presenter;

import def.meugeninua.defaultandroid.ui.activities.base.fragment.state.MvpState;
import io.reactivex.disposables.CompositeDisposable;

/**
 * @author meugen
 */
public abstract class BasePresenter<S extends MvpState> implements MvpPresenter<S> {

    private CompositeDisposable compositeDisposable;

    @Override
    public void onRestoreState(final S state) {}

    @Override
    public void onSaveState(final S state) {}

    @Override
    public void onClear() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    public CompositeDisposable getCompositeDisposable() {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        return compositeDisposable;
    }
}
