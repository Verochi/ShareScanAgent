package io.reactivex.internal.observers;

/* loaded from: classes9.dex */
public final class BlockingFirstObserver<T> extends io.reactivex.internal.observers.BlockingBaseObserver<T> {
    @Override // io.reactivex.Observer
    public void onError(java.lang.Throwable th) {
        if (this.n == null) {
            this.t = th;
        }
        countDown();
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        if (this.n == null) {
            this.n = t;
            this.u.dispose();
            countDown();
        }
    }
}
