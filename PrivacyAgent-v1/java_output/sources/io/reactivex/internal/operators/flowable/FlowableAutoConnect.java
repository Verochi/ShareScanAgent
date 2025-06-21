package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableAutoConnect<T> extends io.reactivex.Flowable<T> {
    public final io.reactivex.flowables.ConnectableFlowable<? extends T> t;
    public final int u;
    public final io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> v;
    public final java.util.concurrent.atomic.AtomicInteger w = new java.util.concurrent.atomic.AtomicInteger();

    public FlowableAutoConnect(io.reactivex.flowables.ConnectableFlowable<? extends T> connectableFlowable, int i, io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer) {
        this.t = connectableFlowable;
        this.u = i;
        this.v = consumer;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.t.subscribe((org.reactivestreams.Subscriber<? super java.lang.Object>) subscriber);
        if (this.w.incrementAndGet() == this.u) {
            this.t.connect(this.v);
        }
    }
}
