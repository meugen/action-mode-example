package meugeninua.examples.actionmode.ui.activities.base.fragment.presenter;

import meugeninua.examples.actionmode.ui.activities.base.fragment.state.MvpState;

/**
 * @author meugen
 */
public interface MvpPresenter<S extends MvpState> {

    void onRestoreState(S state);

    void onSaveState(S state);

    void onClear();
}
