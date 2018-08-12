package meugeninua.examples.actionmode.ui.activities.base.fragment.binding;

import android.view.View;

public interface Binding {

    void attachView(View view);

    void detachView();

    <V extends View> V get(int id);

    boolean has(int id);
}
