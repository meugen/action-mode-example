package meugeninua.examples.actionmode.ui.activities.main.fragment.state;

import java.util.Collection;

import meugeninua.examples.actionmode.ui.activities.base.fragment.state.MvpState;

/**
 * @author meugen
 */
public interface MainState extends MvpState {

    String PARAM_SELECTED_IDS = "selected_ids";

    Collection<Integer> getSelectedIds();

    void setSelectedIds(Collection<Integer> selectedIds);
}
