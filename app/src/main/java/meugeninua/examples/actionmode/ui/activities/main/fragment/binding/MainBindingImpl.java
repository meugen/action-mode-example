package meugeninua.examples.actionmode.ui.activities.main.fragment.binding;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import meugeninua.examples.actionmode.R;
import meugeninua.examples.actionmode.app.di.qualifiers.ActivityContext;
import meugeninua.examples.actionmode.ui.activities.base.fragment.binding.BaseBinding;

public class MainBindingImpl extends BaseBinding
        implements MainBinding {

    @Inject @ActivityContext Context context;

    @Inject
    MainBindingImpl() {}

    @Override
    public void setupRecycler(final RecyclerView.Adapter<?> adapter) {
        final RecyclerView recycler = get(R.id.recycler);
        recycler.addItemDecoration(new DividerItemDecoration(context,
                DividerItemDecoration.VERTICAL));
        recycler.setAdapter(adapter);
    }
}
