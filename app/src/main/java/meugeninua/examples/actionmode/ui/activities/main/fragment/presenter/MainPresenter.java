package meugeninua.examples.actionmode.ui.activities.main.fragment.presenter;

import java.util.Collection;

import meugeninua.examples.actionmode.ui.activities.base.fragment.presenter.MvpPresenter;
import meugeninua.examples.actionmode.ui.activities.main.fragment.state.MainState;

/**
 * @author meugen
 */
public interface MainPresenter extends MvpPresenter<MainState> {

    int LOADER_ID = 1;

    void setup();

    void addIdToSelected(int id);

    void clearSelected();

    Collection<Integer> getSelectedIds();
}
