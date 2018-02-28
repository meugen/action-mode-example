package meugeninua.examples.actionmode.ui.activities.main.fragment.state;

import java.util.Collection;

import javax.inject.Inject;

import meugeninua.examples.actionmode.model.utils.CollectionUtils;
import meugeninua.examples.actionmode.ui.activities.base.fragment.state.BaseState;

/**
 * @author meugen
 */
public class MainStateImpl extends BaseState implements MainState {

    @Inject
    MainStateImpl() {}

    @Override
    public Collection<Integer> getSelectedIds() {
        return bundle.getIntegerArrayList(PARAM_SELECTED_IDS);
    }

    @Override
    public void setSelectedIds(final Collection<Integer> selectedIds) {
        bundle.putIntegerArrayList(PARAM_SELECTED_IDS,
                CollectionUtils.toArrayList(selectedIds));
    }
}
