package def.meugeninua.defaultandroid.ui.activities.main.fragment.state;

import def.meugeninua.defaultandroid.ui.activities.base.fragment.state.MvpState;

/**
 * @author meugen
 */
public interface MainState extends MvpState {

    String PARAM_TEXT = "text";

    String getText();

    void setText(String text);
}
