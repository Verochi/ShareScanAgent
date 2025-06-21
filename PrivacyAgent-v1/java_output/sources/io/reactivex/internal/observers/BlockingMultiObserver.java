package io.reactivex.internal.observers;

/* loaded from: classes9.dex */
public final class BlockingMultiObserver<T> extends java.util.concurrent.CountDownLatch implements io.reactivex.SingleObserver<T>, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver<T> {
    public T n;
    public java.lang.Throwable t;
    public io.reactivex.disposables.Disposable u;
    public volatile boolean v;

    public BlockingMultiObserver() {
        super(1);
    }

    public void a() {
        this.v = true;
        io.reactivex.disposables.Disposable disposable = this.u;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public boolean blockingAwait(long j, java.util.concurrent.TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.BlockingHelper.verifyNonBlocking();
                if (!await(j, timeUnit)) {
                    a();
                    return false;
                }
            } catch (java.lang.InterruptedException e) {
                a();
                throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(e);
            }
        }
        java.lang.Throwable th = this.t;
        if (th == null) {
            return true;
        }
        throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
    }

    public T blockingGet() {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.BlockingHelper.verifyNonBlocking();
                await();
            } catch (java.lang.InterruptedException e) {
                a();
                throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(e);
            }
        }
        java.lang.Throwable th = this.t;
        if (th == null) {
            return this.n;
        }
        throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
    }

    public T blockingGet(T t) {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.BlockingHelper.verifyNonBlocking();
                await();
            } catch (java.lang.InterruptedException e) {
                a();
                throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(e);
            }
        }
        java.lang.Throwable th = this.t;
        if (th != null) {
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
        T t2 = this.n;
        return t2 != null ? t2 : t;
    }

    public java.lang.Throwable blockingGetError() {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.BlockingHelper.verifyNonBlocking();
                await();
            } catch (java.lang.InterruptedException e) {
                a();
                return e;
            }
        }
        return this.t;
    }

    public java.lang.Throwable blockingGetError(long j, java.util.concurrent.TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.BlockingHelper.verifyNonBlocking();
                if (!await(j, timeUnit)) {
                    a();
                    throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(new java.util.concurrent.TimeoutException(io.reactivex.internal.util.ExceptionHelper.timeoutMessage(j, timeUnit)));
                }
            } catch (java.lang.InterruptedException e) {
                a();
                throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(e);
            }
        }
        return this.t;
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public void onError(java.lang.Throwable th) {
        this.t = th;
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
        this.u = disposable;
        if (this.v) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T t) {
        this.n = t;
        countDown();
    }
}
