package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableUsing<R> extends io.reactivex.Completable {
    public final java.util.concurrent.Callable<R> n;
    public final io.reactivex.functions.Function<? super R, ? extends io.reactivex.CompletableSource> t;
    public final io.reactivex.functions.Consumer<? super R> u;
    public final boolean v;

    public static final class UsingObserver<R> extends java.util.concurrent.atomic.AtomicReference<java.lang.Object> implements io.reactivex.CompletableObserver, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -674404550052917487L;
        final io.reactivex.functions.Consumer<? super R> disposer;
        final io.reactivex.CompletableObserver downstream;
        final boolean eager;
        io.reactivex.disposables.Disposable upstream;

        public UsingObserver(io.reactivex.CompletableObserver completableObserver, R r, io.reactivex.functions.Consumer<? super R> consumer, boolean z) {
            super(r);
            this.downstream = completableObserver;
            this.disposer = consumer;
            this.eager = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            this.upstream = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            disposeResourceAfter();
        }

        public void disposeResourceAfter() {
            java.lang.Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.disposer.accept(andSet);
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    io.reactivex.plugins.RxJavaPlugins.onError(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.upstream = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            if (this.eager) {
                java.lang.Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.disposer.accept(andSet);
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    this.downstream.onError(th);
                    return;
                }
            }
            this.downstream.onComplete();
            if (this.eager) {
                return;
            }
            disposeResourceAfter();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
            this.upstream = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            if (this.eager) {
                java.lang.Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.disposer.accept(andSet);
                } catch (java.lang.Throwable th2) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                    th = new io.reactivex.exceptions.CompositeException(th, th2);
                }
            }
            this.downstream.onError(th);
            if (this.eager) {
                return;
            }
            disposeResourceAfter();
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public CompletableUsing(java.util.concurrent.Callable<R> callable, io.reactivex.functions.Function<? super R, ? extends io.reactivex.CompletableSource> function, io.reactivex.functions.Consumer<? super R> consumer, boolean z) {
        this.n = callable;
        this.t = function;
        this.u = consumer;
        this.v = z;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        try {
            R call = this.n.call();
            try {
                ((io.reactivex.CompletableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(call), "The completableFunction returned a null CompletableSource")).subscribe(new io.reactivex.internal.operators.completable.CompletableUsing.UsingObserver(completableObserver, call, this.u, this.v));
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                if (this.v) {
                    try {
                        this.u.accept(call);
                    } catch (java.lang.Throwable th2) {
                        io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                        io.reactivex.internal.disposables.EmptyDisposable.error(new io.reactivex.exceptions.CompositeException(th, th2), completableObserver);
                        return;
                    }
                }
                io.reactivex.internal.disposables.EmptyDisposable.error(th, completableObserver);
                if (this.v) {
                    return;
                }
                try {
                    this.u.accept(call);
                } catch (java.lang.Throwable th3) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th3);
                    io.reactivex.plugins.RxJavaPlugins.onError(th3);
                }
            }
        } catch (java.lang.Throwable th4) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th4);
            io.reactivex.internal.disposables.EmptyDisposable.error(th4, completableObserver);
        }
    }
}
