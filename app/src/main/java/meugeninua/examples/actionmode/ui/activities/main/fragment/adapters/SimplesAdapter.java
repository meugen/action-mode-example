package meugeninua.examples.actionmode.ui.activities.main.fragment.adapters;

import android.content.Context;
import android.support.v4.util.ArraySet;
import android.support.v4.util.ObjectsCompat;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import meugeninua.examples.actionmode.app.di.qualifiers.ActivityContext;
import meugeninua.examples.actionmode.app.di.scopes.PerFragment;
import meugeninua.examples.actionmode.databinding.ItemSimpleBinding;
import meugeninua.examples.actionmode.model.db.entities.SimpleEntity;

@PerFragment
public class SimplesAdapter extends RecyclerView.Adapter<SimplesAdapter.Holder> {

    private final LayoutInflater inflater;
    private final OnSimpleActionListener listener;
    private List<SimpleEntity> simples;
    private Set<Integer> selectedIds;

    @Inject
    SimplesAdapter(
            @ActivityContext final Context context,
            final OnSimpleActionListener listener) {
        this.inflater = LayoutInflater.from(context);
        this.listener = listener;
        this.simples = Collections.emptyList();
        selectedIds = new ArraySet<>();
    }

    public void swapSimples(
            final List<SimpleEntity> simples) {
        final DiffUtil.DiffResult result = DiffUtil.calculateDiff(
                new SimpleDiffCallback(this.simples, simples));
        this.simples = simples;
        result.dispatchUpdatesTo(this);
    }

    public void setSelected(final Collection<Integer> selectedIds) {
        this.selectedIds.clear();
        this.selectedIds.addAll(selectedIds);
        notifyDataSetChanged();
    }

    public void markSelected(final int position, final SimpleEntity entity) {
        selectedIds.add(entity.id);
        notifyItemChanged(position);
    }

    public void clearSelected() {
        setSelected(Collections.emptyList());
    }

    @Override
    public Holder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final ItemSimpleBinding binding = ItemSimpleBinding
                .inflate(inflater, parent, false);
        return new Holder(binding, listener);
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {
        final SimpleEntity entity = simples.get(position);
        holder.binding.setEntity(entity);
        holder.itemView.setSelected(selectedIds.contains(entity.id));
    }

    @Override
    public int getItemCount() {
        return simples.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        final ItemSimpleBinding binding;
        final OnSimpleActionListener listener;

        Holder(final ItemSimpleBinding binding, final OnSimpleActionListener listener) {
            super(binding.getRoot());
            this.binding = binding;
            this.listener = listener;
            this.binding.setHolder(this);
        }

        public void onClick() {
            listener.onSimpleClick(getAdapterPosition(), binding.getEntity());
        }

        public boolean onLongClick() {
            return listener.onSimpleLongClick(getAdapterPosition(), binding.getEntity());
        }
    }

    private static class SimpleDiffCallback extends DiffUtil.Callback {

        private final List<SimpleEntity> oldItems;
        private final List<SimpleEntity> newItems;

        SimpleDiffCallback(
                final List<SimpleEntity> oldItems,
                final List<SimpleEntity> newItems) {
            this.oldItems = oldItems;
            this.newItems = newItems;
        }

        @Override
        public int getOldListSize() {
            return oldItems.size();
        }

        @Override
        public int getNewListSize() {
            return newItems.size();
        }

        @Override
        public boolean areItemsTheSame(
                final int oldItemPosition,
                final int newItemPosition) {
            return oldItems.get(oldItemPosition).id
                    == newItems.get(newItemPosition).id;
        }

        @Override
        public boolean areContentsTheSame(final int oldItemPosition, final int newItemPosition) {
            return ObjectsCompat.equals(
                    oldItems.get(oldItemPosition),
                    newItems.get(newItemPosition));
        }
    }
}
