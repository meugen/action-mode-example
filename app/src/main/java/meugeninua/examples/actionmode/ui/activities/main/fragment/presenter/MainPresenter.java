package meugeninua.examples.actionmode.ui.activities.main.fragment.presenter;

import meugeninua.examples.actionmode.ui.activities.base.fragment.presenter.MvpPresenter;
import meugeninua.examples.actionmode.ui.activities.main.fragment.state.MainState;

/**
 * @author meugen
 */
public interface MainPresenter extends MvpPresenter<MainState> {

    int LOADER_ID = 1;

    void setup();
}
