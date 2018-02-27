package meugeninua.examples.actionmode.ui.activities.main.fragment;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import meugeninua.examples.actionmode.app.di.PerFragment;
import meugeninua.examples.actionmode.ui.activities.base.fragment.BaseFragmentModule;
import meugeninua.examples.actionmode.ui.activities.main.fragment.presenter.MainPresenter;
import meugeninua.examples.actionmode.ui.activities.main.fragment.presenter.MainPresenterImpl;
import meugeninua.examples.actionmode.ui.activities.main.fragment.state.MainState;
import meugeninua.examples.actionmode.ui.activities.main.fragment.state.MainStateImpl;
import meugeninua.examples.actionmode.ui.activities.main.fragment.view.MainView;

/**
 * @author meugen
 */
@Module(includes = BaseFragmentModule.class)
public abstract class MainFragmentModule {

    @Binds @PerFragment
    abstract Fragment bindFragment(final MainFragment fragment);

    @Binds @PerFragment
    abstract MainPresenter bindPresenter(final MainPresenterImpl impl);

    @Binds @PerFragment
    abstract MainState bindState(final MainStateImpl impl);

    @Binds @PerFragment
    abstract MainView bindView(final MainFragment fragment);
}
