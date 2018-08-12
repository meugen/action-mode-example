package meugeninua.examples.actionmode.ui.activities.main.fragment.binding;

import android.support.v7.widget.RecyclerView;

import meugeninua.examples.actionmode.ui.activities.base.fragment.binding.Binding;

public interface MainBinding extends Binding {

    void setupRecycler(RecyclerView.Adapter<?> adapter);
}
