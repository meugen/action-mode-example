package meugeninua.examples.actionmode.model.api;

import io.reactivex.Observable;

public interface AppActionApi<Req, Resp> {

    Observable<Resp> action(Req req);
}
