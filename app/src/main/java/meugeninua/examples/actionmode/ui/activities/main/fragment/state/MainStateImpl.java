package meugeninua.examples.actionmode.ui.activities.main.fragment.state;

import javax.inject.Inject;

import meugeninua.examples.actionmode.ui.activities.base.fragment.state.BaseState;

/**
 * @author meugen
 */
public class MainStateImpl extends BaseState implements MainState {

    @Inject
    MainStateImpl() {}

    @Override
    public String getText() {
        return bundle.getString(PARAM_TEXT);
    }

    @Override
    public void setText(final String text) {
        bundle.putString(PARAM_TEXT, text);
    }
}
