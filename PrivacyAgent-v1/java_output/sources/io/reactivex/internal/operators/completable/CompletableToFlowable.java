package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableToFlowable<T> extends io.reactivex.Flowable<T> {
    public final io.reactivex.CompletableSource t;

    public CompletableToFlowable(io.reactivex.CompletableSource completableSource) {
        this.t = completableSource;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.t.subscribe(new io.reactivex.internal.observers.SubscriberCompletableObserver(subscriber));
    }
}
