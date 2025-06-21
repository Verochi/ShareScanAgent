package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleUsing<T, U> extends io.reactivex.Single<T> {
    public final java.util.concurrent.Callable<U> n;
    public final io.reactivex.functions.Function<? super U, ? extends io.reactivex.SingleSource<? extends T>> t;
    public final io.reactivex.functions.Consumer<? super U> u;
    public final boolean v;

    public static final class UsingSingleObserver<T, U> extends java.util.concurrent.atomic.AtomicReference<java.lang.Object> implements io.reactivex.SingleObserver<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -5331524057054083935L;
        final io.reactivex.functions.Consumer<? super U> disposer;
        final io.reactivex.SingleObserver<? super T> downstream;
        final boolean eager;
        io.reactivex.disposables.Disposable upstream;

        public UsingSingleObserver(io.reactivex.SingleObserver<? super T> singleObserver, U u, boolean z, io.reactivex.functions.Consumer<? super U> consumer) {
            super(u);
            this.downstream = singleObserver;
            this.eager = z;
            this.disposer = consumer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            this.upstream = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            disposeAfter();
        }

        public void disposeAfter() {
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

        @Override // io.reactivex.SingleObserver
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
            disposeAfter();
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
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
            this.downstream.onSuccess(t);
            if (this.eager) {
                return;
            }
            disposeAfter();
        }
    }

    public SingleUsing(java.util.concurrent.Callable<U> callable, io.reactivex.functions.Function<? super U, ? extends io.reactivex.SingleSource<? extends T>> function, io.reactivex.functions.Consumer<? super U> consumer, boolean z) {
        this.n = callable;
        this.t = function;
        this.u = consumer;
        this.v = z;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        try {
            U call = this.n.call();
            try {
                ((io.reactivex.SingleSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(call), "The singleFunction returned a null SingleSource")).subscribe(new io.reactivex.internal.operators.single.SingleUsing.UsingSingleObserver(singleObserver, call, this.v, this.u));
            } catch (java.lang.Throwable th) {
                th = th;
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                if (this.v) {
                    try {
                        this.u.accept(call);
                    } catch (java.lang.Throwable th2) {
                        io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                        th = new io.reactivex.exceptions.CompositeException(th, th2);
                    }
                }
                io.reactivex.internal.disposables.EmptyDisposable.error(th, singleObserver);
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
            io.reactivex.internal.disposables.EmptyDisposable.error(th4, singleObserver);
        }
    }
}
