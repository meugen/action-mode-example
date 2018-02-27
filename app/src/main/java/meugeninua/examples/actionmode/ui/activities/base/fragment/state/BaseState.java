package meugeninua.examples.actionmode.ui.activities.base.fragment.state;

import android.os.Bundle;

/**
 * @author meugen
 */
public abstract class BaseState implements MvpState {

    protected Bundle bundle;

    public final void attachBundle(final Bundle bundle) {
        this.bundle = bundle == null ? Bundle.EMPTY : bundle;
    }

    public final void detachBundle() {
        this.bundle = null;
    }
}
