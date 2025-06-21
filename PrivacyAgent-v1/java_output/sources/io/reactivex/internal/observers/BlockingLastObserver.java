package io.reactivex.internal.observers;

/* loaded from: classes9.dex */
public final class BlockingLastObserver<T> extends io.reactivex.internal.observers.BlockingBaseObserver<T> {
    @Override // io.reactivex.Observer
    public void onError(java.lang.Throwable th) {
        this.n = null;
        this.t = th;
        countDown();
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        this.n = t;
    }
}
