package meugeninua.examples.actionmode.ui.activities.main.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import meugeninua.examples.actionmode.R;
import meugeninua.examples.actionmode.app.services.DeleteSelectedService;
import meugeninua.examples.actionmode.model.db.entities.SimpleEntity;
import meugeninua.examples.actionmode.ui.activities.base.fragment.BaseFragment;
import meugeninua.examples.actionmode.ui.activities.main.fragment.adapters.OnSimpleActionListener;
import meugeninua.examples.actionmode.ui.activities.main.fragment.adapters.SimplesAdapter;
import meugeninua.examples.actionmode.ui.activities.main.fragment.binding.MainBinding;
import meugeninua.examples.actionmode.ui.activities.main.fragment.presenter.MainPresenter;
import meugeninua.examples.actionmode.ui.activities.main.fragment.state.MainState;
import meugeninua.examples.actionmode.ui.activities.main.fragment.view.MainView;

/**
 * @author meugen
 */
public class MainFragment extends BaseFragment<MainState, MainPresenter, MainBinding>
        implements MainView, OnSimpleActionListener, ActionMode.Callback {

    private ActionMode actionMode;

    @Inject AppCompatActivity activity;
    @Inject SimplesAdapter adapter;

    @Override
    public View onCreateView(
            @NonNull final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,
                container, false);
    }

    @Override
    public void onViewCreated(
            @NonNull final View view,
            @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setupRecycler(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.setup();
    }

    @Override
    public void displaySimples(
            final List<SimpleEntity> simples,
            final Collection<Integer> selectedIds) {
        adapter.swapSimples(simples, selectedIds);
        if (!selectedIds.isEmpty() && actionMode == null) {
            activity.startSupportActionMode(this);
        }
    }

    @Override
    public void onSimpleClick(final int position, final SimpleEntity entity) {
        if (actionMode == null) {
            return;
        }
        adapter.markSelected(position, entity);
        presenter.addIdToSelected(entity.id);
    }

    @Override
    public boolean onSimpleLongClick(final int position, final SimpleEntity entity) {
        if (actionMode != null) {
            return false;
        }
        activity.startSupportActionMode(this);
        adapter.markSelected(position, entity);
        presenter.addIdToSelected(entity.id);
        return true;
    }

    @Override
    public boolean onCreateActionMode(final ActionMode mode, final Menu menu) {
        this.actionMode = mode;
        activity.getMenuInflater().inflate(R.menu.main_action_mode, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(final ActionMode mode, final Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(final ActionMode mode, final MenuItem item) {
        final int itemId = item.getItemId();
        if (itemId == R.id.delete) {
            DeleteSelectedService.enqueueWork(activity, presenter.getSelectedIds());
            actionMode.finish();
            return true;
        }
        return false;
    }

    @Override
    public void onDestroyActionMode(final ActionMode mode) {
        this.actionMode = null;
        presenter.clearSelected();
        adapter.clearSelected();
    }
}
