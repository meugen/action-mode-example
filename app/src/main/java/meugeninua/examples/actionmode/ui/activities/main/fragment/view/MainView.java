package meugeninua.examples.actionmode.ui.activities.main.fragment.view;

import java.util.List;

import meugeninua.examples.actionmode.model.db.entities.SimpleEntity;
import meugeninua.examples.actionmode.ui.activities.base.fragment.view.MvpView;

/**
 * @author meugen
 */
public interface MainView extends MvpView {

    void displaySimples(List<SimpleEntity> simples);
}
