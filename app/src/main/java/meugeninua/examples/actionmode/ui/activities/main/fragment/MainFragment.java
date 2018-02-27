package meugeninua.examples.actionmode.ui.activities.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import meugeninua.examples.actionmode.ui.activities.base.fragment.BaseFragment;
import meugeninua.examples.actionmode.ui.activities.main.fragment.presenter.MainPresenter;
import meugeninua.examples.actionmode.ui.activities.main.fragment.state.MainState;
import meugeninua.examples.actionmode.ui.activities.main.fragment.view.MainView;
import meugeninua.examples.actionmode.databinding.FragmentMainBinding;

/**
 * @author meugen
 */
public class MainFragment extends BaseFragment<MainState, MainPresenter> implements MainView {

    private FragmentMainBinding binding;

    @Override
    public View onCreateView(
            final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.setup();
    }

    @Override
    public void displayText(final String text) {
        binding.setText(text);
    }
}
