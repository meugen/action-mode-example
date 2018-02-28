package meugeninua.examples.actionmode.ui.activities.main.fragment.adapters;

import meugeninua.examples.actionmode.model.db.entities.SimpleEntity;

/**
 * @author meugen
 */
public interface OnSimpleActionListener {

    void onSimpleClick(int position, SimpleEntity entity);

    boolean onSimpleLongClick(int position, SimpleEntity entity);
}
