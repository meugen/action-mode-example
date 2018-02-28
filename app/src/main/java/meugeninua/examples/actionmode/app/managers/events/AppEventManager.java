package meugeninua.examples.actionmode.app.managers.events;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

@Singleton
public class AppEventManager {

    private final Subject<Object> subject;

    @Inject
    AppEventManager() {
        this.subject = PublishSubject.create();
    }

    public <T> void post(final T event) {
        subject.onNext(event);
    }

    public <T> Observable<T> getObservable(final Class<T> clazz) {
        return subject.hide()
                .filter(clazz::isInstance)
                .map(clazz::cast);
    }
}
