package io.reactivex.internal.observers;

/* loaded from: classes9.dex */
public final class FutureSingleObserver<T> extends java.util.concurrent.CountDownLatch implements io.reactivex.SingleObserver<T>, java.util.concurrent.Future<T>, io.reactivex.disposables.Disposable {
    public T n;
    public java.lang.Throwable t;
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> u;

    public FutureSingleObserver() {
        super(1);
        this.u = new java.util.concurrent.atomic.AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        io.reactivex.disposables.Disposable disposable;
        io.reactivex.internal.disposables.DisposableHelper disposableHelper;
        do {
            disposable = this.u.get();
            if (disposable == this || disposable == (disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!defpackage.xv0.a(this.u, disposable, disposableHelper));
        if (disposable != null) {
            disposable.dispose();
        }
        countDown();
        return true;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // java.util.concurrent.Future
    public T get() throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        if (getCount() != 0) {
            io.reactivex.internal.util.BlockingHelper.verifyNonBlocking();
            await();
        }
        if (isCancelled()) {
            throw new java.util.concurrent.CancellationException();
        }
        java.lang.Throwable th = this.t;
        if (th == null) {
            return this.n;
        }
        throw new java.util.concurrent.ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public T get(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        if (getCount() != 0) {
            io.reactivex.internal.util.BlockingHelper.verifyNonBlocking();
            if (!await(j, timeUnit)) {
                throw new java.util.concurrent.TimeoutException(io.reactivex.internal.util.ExceptionHelper.timeoutMessage(j, timeUnit));
            }
        }
        if (isCancelled()) {
            throw new java.util.concurrent.CancellationException();
        }
        java.lang.Throwable th = this.t;
        if (th == null) {
            return this.n;
        }
        throw new java.util.concurrent.ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return io.reactivex.internal.disposables.DisposableHelper.isDisposed(this.u.get());
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // io.reactivex.SingleObserver
    public void onError(java.lang.Throwable th) {
        io.reactivex.disposables.Disposable disposable;
        do {
            disposable = this.u.get();
            if (disposable == io.reactivex.internal.disposables.DisposableHelper.DISPOSED) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.t = th;
        } while (!defpackage.xv0.a(this.u, disposable, this));
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
        io.reactivex.internal.disposables.DisposableHelper.setOnce(this.u, disposable);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T t) {
        io.reactivex.disposables.Disposable disposable = this.u.get();
        if (disposable == io.reactivex.internal.disposables.DisposableHelper.DISPOSED) {
            return;
        }
        this.n = t;
        defpackage.xv0.a(this.u, disposable, this);
        countDown();
    }
}
