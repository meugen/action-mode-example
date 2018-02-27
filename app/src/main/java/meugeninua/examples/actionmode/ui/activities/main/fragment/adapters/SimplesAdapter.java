package meugeninua.examples.actionmode.ui.activities.main.fragment.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import meugeninua.examples.actionmode.app.di.qualifiers.ActivityContext;
import meugeninua.examples.actionmode.app.di.scopes.PerFragment;
import meugeninua.examples.actionmode.databinding.ItemSimpleBinding;
import meugeninua.examples.actionmode.model.db.entities.SimpleEntity;

@PerFragment
public class SimplesAdapter extends RecyclerView.Adapter<SimplesAdapter.Holder> {

    private final LayoutInflater inflater;
    private List<SimpleEntity> simples;

    @Inject
    public SimplesAdapter(@ActivityContext final Context context) {
        this.inflater = LayoutInflater.from(context);
        this.simples = Collections.emptyList();
    }

    public void swapSimples(final List<SimpleEntity> simples) {
        this.simples = simples;
        notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final ItemSimpleBinding binding = ItemSimpleBinding
                .inflate(inflater, parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {
        holder.binding.setEntity(simples.get(position));
    }

    @Override
    public int getItemCount() {
        return simples.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        public final ItemSimpleBinding binding;

        public Holder(final ItemSimpleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
