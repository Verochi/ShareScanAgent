package io.reactivex.internal.subscribers;

/* loaded from: classes13.dex */
public final class BlockingFirstSubscriber<T> extends io.reactivex.internal.subscribers.BlockingBaseSubscriber<T> {
    @Override // org.reactivestreams.Subscriber
    public void onError(java.lang.Throwable th) {
        if (this.n == null) {
            this.t = th;
        } else {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
        }
        countDown();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.n == null) {
            this.n = t;
            this.u.cancel();
            countDown();
        }
    }
}
