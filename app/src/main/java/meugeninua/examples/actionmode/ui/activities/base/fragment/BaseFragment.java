package meugeninua.examples.actionmode.ui.activities.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import meugeninua.examples.actionmode.ui.activities.base.fragment.presenter.MvpPresenter;
import meugeninua.examples.actionmode.ui.activities.base.fragment.state.BaseState;
import meugeninua.examples.actionmode.ui.activities.base.fragment.state.MvpState;
import meugeninua.examples.actionmode.ui.activities.base.fragment.view.MvpView;

/**
 * @author meugen
 */
public abstract class BaseFragment<S extends MvpState, P extends MvpPresenter<S>> extends Fragment
        implements MvpView {

    @Inject protected P presenter;
    @Inject protected S state;

    @Override
    public void onAttach(final Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            ((BaseState) state).attachBundle(getArguments());
        } else {
            ((BaseState) state).attachBundle(savedInstanceState);
        }
        presenter.onRestoreState(state);
        ((BaseState) state).detachBundle();
    }

    @Override
    public void onSaveInstanceState(@NonNull final Bundle outState) {
        super.onSaveInstanceState(outState);
        ((BaseState) state).attachBundle(outState);
        presenter.onSaveState(state);
        ((BaseState) state).detachBundle();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onClear();
    }
}