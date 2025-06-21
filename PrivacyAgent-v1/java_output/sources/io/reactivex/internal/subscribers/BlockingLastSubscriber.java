package io.reactivex.internal.subscribers;

/* loaded from: classes13.dex */
public final class BlockingLastSubscriber<T> extends io.reactivex.internal.subscribers.BlockingBaseSubscriber<T> {
    @Override // org.reactivestreams.Subscriber
    public void onError(java.lang.Throwable th) {
        this.n = null;
        this.t = th;
        countDown();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        this.n = t;
    }
}
