package meugeninua.examples.actionmode.model.api.simples;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import meugeninua.examples.actionmode.model.api.AppActionApi;
import meugeninua.examples.actionmode.model.db.dao.SimpleEntityDao;
import meugeninua.examples.actionmode.model.db.entities.SimpleEntity;

public class SimplesActionApi implements AppActionApi<Void, List<SimpleEntity>> {

    @Inject SimpleEntityDao simpleEntityDao;

    @Inject
    SimplesActionApi() {}

    @Override
    public Observable<List<SimpleEntity>> action(final Void aVoid) {
        return Observable.fromCallable(() -> simpleEntityDao.all());
    }
}
