package io.reactivex.internal.observers;

/* loaded from: classes9.dex */
public abstract class BlockingBaseObserver<T> extends java.util.concurrent.CountDownLatch implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
    public T n;
    public java.lang.Throwable t;
    public io.reactivex.disposables.Disposable u;
    public volatile boolean v;

    public BlockingBaseObserver() {
        super(1);
    }

    public final T blockingGet() {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.BlockingHelper.verifyNonBlocking();
                await();
            } catch (java.lang.InterruptedException e) {
                dispose();
                throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(e);
            }
        }
        java.lang.Throwable th = this.t;
        if (th == null) {
            return this.n;
        }
        throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.v = true;
        io.reactivex.disposables.Disposable disposable = this.u;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.v;
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(io.reactivex.disposables.Disposable disposable) {
        this.u = disposable;
        if (this.v) {
            disposable.dispose();
        }
    }
}
