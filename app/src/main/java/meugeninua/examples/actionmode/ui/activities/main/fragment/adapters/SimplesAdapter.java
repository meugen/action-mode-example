package meugeninua.examples.actionmode.ui.activities.main.fragment.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.util.ArraySet;
import android.support.v4.util.ObjectsCompat;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import meugeninua.examples.actionmode.R;
import meugeninua.examples.actionmode.app.di.qualifiers.ActivityContext;
import meugeninua.examples.actionmode.model.db.entities.SimpleEntity;
import meugeninua.examples.actionmode.model.utils.CollectionUtils;

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
            final List<SimpleEntity> simples,
            final Collection<Integer> selectedIds) {
        final Collection<Integer> selectedChanges = CollectionUtils.xor(
                this.selectedIds, selectedIds);
        final DiffUtil.DiffResult result = DiffUtil.calculateDiff(
                new SimpleDiffCallback(this.simples, simples, selectedChanges));
        this.simples = simples;
        result.dispatchUpdatesTo(this);
    }

    private void setSelected(final Collection<Integer> selectedIds) {
        final Collection<Integer> selectedChanges = CollectionUtils.xor(
                this.selectedIds, selectedIds);
        final DiffUtil.DiffResult result = DiffUtil.calculateDiff(
                new SimpleDiffCallback(simples, simples, selectedChanges));
        this.selectedIds.clear();
        this.selectedIds.addAll(selectedIds);
        result.dispatchUpdatesTo(this);
    }

    public void markSelected(final int position, final SimpleEntity entity) {
        selectedIds.add(entity.id);
        notifyItemChanged(position);
    }

    public void clearSelected() {
        setSelected(Collections.emptyList());
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        final View view = inflater.inflate(R.layout.item_simple, parent, false);
        return new Holder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int position) {
        final SimpleEntity entity = simples.get(position);
        holder.bind(entity, selectedIds);
    }

    @Override
    public int getItemCount() {
        return simples.size();
    }

    public static class Holder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        private final TextView textView;
        private final OnSimpleActionListener listener;

        private SimpleEntity entity;

        Holder(final View view, final OnSimpleActionListener listener) {
            super(view);
            this.textView = view.findViewById(R.id.text);
            this.listener = listener;
            this.textView.setOnClickListener(this);
            this.textView.setOnLongClickListener(this);

        }

        @Override
        public void onClick(final View v) {
            listener.onSimpleClick(getAdapterPosition(), entity);
        }

        @Override
        public boolean onLongClick(final View v) {
            return listener.onSimpleLongClick(getAdapterPosition(), entity);
        }

        void bind(final SimpleEntity entity, final Set<Integer> selectedIds) {
            this.entity = entity;
            textView.setText(entity.data);
            textView.setSelected(selectedIds.contains(entity.id));
        }
    }

    private static class SimpleDiffCallback extends DiffUtil.Callback {

        private final List<SimpleEntity> oldItems;
        private final List<SimpleEntity> newItems;
        private final Collection<Integer> selectedChanges;

        SimpleDiffCallback(
                final List<SimpleEntity> oldItems,
                final List<SimpleEntity> newItems,
                final Collection<Integer> selectedChanges) {
            this.oldItems = oldItems;
            this.newItems = newItems;
            this.selectedChanges = selectedChanges;
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
        public boolean areContentsTheSame(
                final int oldItemPosition,
                final int newItemPosition) {
            final SimpleEntity oldItem = oldItems.get(oldItemPosition);
            final SimpleEntity newItem = newItems.get(newItemPosition);
            return !selectedChanges.contains(oldItem.id)
                    // According to javadocs of base method oldItem.id and newItem.id are equals
                    // so we don't need to check next line
                    // && !selectedChanges.contains(newItem.id)
                    && ObjectsCompat.equals(oldItem, newItem);
        }
    }
}
