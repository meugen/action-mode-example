package def.meugeninua.defaultandroid.ui.activities.main.fragment.presenter;

import java.math.BigInteger;
import java.util.Random;

import javax.inject.Inject;

import def.meugeninua.defaultandroid.ui.activities.base.fragment.presenter.BasePresenter;
import def.meugeninua.defaultandroid.ui.activities.main.fragment.state.MainState;
import def.meugeninua.defaultandroid.ui.activities.main.fragment.view.MainView;

/**
 * @author meugen
 */
public class MainPresenterImpl extends BasePresenter<MainState> implements MainPresenter {

    private static final Random RANDOM = new Random();

    private String text;

    @Inject MainView view;

    @Inject
    MainPresenterImpl() {}

    @Override
    public void setup() {
        if (text == null) {
            text = new BigInteger(100, RANDOM).toString(26);
        }
        view.displayText(text);
    }

    @Override
    public void onRestoreState(final MainState state) {
        super.onRestoreState(state);
        text = state.getText();
    }

    @Override
    public void onSaveState(final MainState state) {
        super.onSaveState(state);
        state.setText(text);
    }
}
