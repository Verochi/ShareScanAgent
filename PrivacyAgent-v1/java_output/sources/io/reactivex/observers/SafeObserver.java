package io.reactivex.observers;

/* loaded from: classes13.dex */
public final class SafeObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
    public final io.reactivex.Observer<? super T> n;
    public io.reactivex.disposables.Disposable t;
    public boolean u;

    public SafeObserver(@io.reactivex.annotations.NonNull io.reactivex.Observer<? super T> observer) {
        this.n = observer;
    }

    public void a() {
        java.lang.NullPointerException nullPointerException = new java.lang.NullPointerException("Subscription not set!");
        try {
            this.n.onSubscribe(io.reactivex.internal.disposables.EmptyDisposable.INSTANCE);
            try {
                this.n.onError(nullPointerException);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.plugins.RxJavaPlugins.onError(new io.reactivex.exceptions.CompositeException(nullPointerException, th));
            }
        } catch (java.lang.Throwable th2) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
            io.reactivex.plugins.RxJavaPlugins.onError(new io.reactivex.exceptions.CompositeException(nullPointerException, th2));
        }
    }

    public void b() {
        this.u = true;
        java.lang.NullPointerException nullPointerException = new java.lang.NullPointerException("Subscription not set!");
        try {
            this.n.onSubscribe(io.reactivex.internal.disposables.EmptyDisposable.INSTANCE);
            try {
                this.n.onError(nullPointerException);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.plugins.RxJavaPlugins.onError(new io.reactivex.exceptions.CompositeException(nullPointerException, th));
            }
        } catch (java.lang.Throwable th2) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
            io.reactivex.plugins.RxJavaPlugins.onError(new io.reactivex.exceptions.CompositeException(nullPointerException, th2));
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.t.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.t.isDisposed();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.u) {
            return;
        }
        this.u = true;
        if (this.t == null) {
            a();
            return;
        }
        try {
            this.n.onComplete();
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.plugins.RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(@io.reactivex.annotations.NonNull java.lang.Throwable th) {
        if (this.u) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            return;
        }
        this.u = true;
        if (this.t != null) {
            if (th == null) {
                th = new java.lang.NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.n.onError(th);
                return;
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                io.reactivex.plugins.RxJavaPlugins.onError(new io.reactivex.exceptions.CompositeException(th, th2));
                return;
            }
        }
        java.lang.NullPointerException nullPointerException = new java.lang.NullPointerException("Subscription not set!");
        try {
            this.n.onSubscribe(io.reactivex.internal.disposables.EmptyDisposable.INSTANCE);
            try {
                this.n.onError(new io.reactivex.exceptions.CompositeException(th, nullPointerException));
            } catch (java.lang.Throwable th3) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th3);
                io.reactivex.plugins.RxJavaPlugins.onError(new io.reactivex.exceptions.CompositeException(th, nullPointerException, th3));
            }
        } catch (java.lang.Throwable th4) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th4);
            io.reactivex.plugins.RxJavaPlugins.onError(new io.reactivex.exceptions.CompositeException(th, nullPointerException, th4));
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(@io.reactivex.annotations.NonNull T t) {
        if (this.u) {
            return;
        }
        if (this.t == null) {
            b();
            return;
        }
        if (t == null) {
            java.lang.NullPointerException nullPointerException = new java.lang.NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.t.dispose();
                onError(nullPointerException);
                return;
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                onError(new io.reactivex.exceptions.CompositeException(nullPointerException, th));
                return;
            }
        }
        try {
            this.n.onNext(t);
        } catch (java.lang.Throwable th2) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
            try {
                this.t.dispose();
                onError(th2);
            } catch (java.lang.Throwable th3) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th3);
                onError(new io.reactivex.exceptions.CompositeException(th2, th3));
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(@io.reactivex.annotations.NonNull io.reactivex.disposables.Disposable disposable) {
        if (io.reactivex.internal.disposables.DisposableHelper.validate(this.t, disposable)) {
            this.t = disposable;
            try {
                this.n.onSubscribe(this);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.u = true;
                try {
                    disposable.dispose();
                    io.reactivex.plugins.RxJavaPlugins.onError(th);
                } catch (java.lang.Throwable th2) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                    io.reactivex.plugins.RxJavaPlugins.onError(new io.reactivex.exceptions.CompositeException(th, th2));
                }
            }
        }
    }
}
