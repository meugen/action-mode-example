package def.meugeninua.defaultandroid.ui.activities.main.fragment.presenter;

import def.meugeninua.defaultandroid.ui.activities.base.fragment.presenter.MvpPresenter;
import def.meugeninua.defaultandroid.ui.activities.main.fragment.state.MainState;

/**
 * @author meugen
 */
public interface MainPresenter extends MvpPresenter<MainState> {

    void setup();
}
