package meugeninua.examples.actionmode.ui.activities.main.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import meugeninua.examples.actionmode.app.di.qualifiers.ActivityContext;
import meugeninua.examples.actionmode.model.db.entities.SimpleEntity;
import meugeninua.examples.actionmode.ui.activities.base.fragment.BaseFragment;
import meugeninua.examples.actionmode.ui.activities.main.fragment.adapters.SimplesAdapter;
import meugeninua.examples.actionmode.ui.activities.main.fragment.presenter.MainPresenter;
import meugeninua.examples.actionmode.ui.activities.main.fragment.state.MainState;
import meugeninua.examples.actionmode.ui.activities.main.fragment.view.MainView;
import meugeninua.examples.actionmode.databinding.FragmentMainBinding;

/**
 * @author meugen
 */
public class MainFragment extends BaseFragment<MainState, MainPresenter>
        implements MainView {

    private FragmentMainBinding binding;

    @Inject @ActivityContext Context context;
    @Inject SimplesAdapter adapter;

    @Override
    public View onCreateView(
            final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(
            @NonNull final View view,
            @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recycler.addItemDecoration(new DividerItemDecoration(
                context, DividerItemDecoration.VERTICAL));
        binding.recycler.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.setup();
    }

    @Override
    public void displaySimples(final List<SimpleEntity> simples) {
        adapter.swapSimples(simples);
    }
}
