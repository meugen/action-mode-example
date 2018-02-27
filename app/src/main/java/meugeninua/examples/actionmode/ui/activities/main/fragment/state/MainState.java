package meugeninua.examples.actionmode.ui.activities.main.fragment.state;

import meugeninua.examples.actionmode.ui.activities.base.fragment.state.MvpState;

/**
 * @author meugen
 */
public interface MainState extends MvpState {

    String PARAM_TEXT = "text";

    String getText();

    void setText(String text);
}
