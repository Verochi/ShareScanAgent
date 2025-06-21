package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletablePeek extends io.reactivex.Completable {
    public final io.reactivex.CompletableSource n;
    public final io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> t;
    public final io.reactivex.functions.Consumer<? super java.lang.Throwable> u;
    public final io.reactivex.functions.Action v;
    public final io.reactivex.functions.Action w;
    public final io.reactivex.functions.Action x;
    public final io.reactivex.functions.Action y;

    public final class CompletableObserverImplementation implements io.reactivex.CompletableObserver, io.reactivex.disposables.Disposable {
        public final io.reactivex.CompletableObserver n;
        public io.reactivex.disposables.Disposable t;

        public CompletableObserverImplementation(io.reactivex.CompletableObserver completableObserver) {
            this.n = completableObserver;
        }

        public void a() {
            try {
                io.reactivex.internal.operators.completable.CompletablePeek.this.x.run();
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            try {
                io.reactivex.internal.operators.completable.CompletablePeek.this.y.run();
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
            this.t.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.t.isDisposed();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.t == io.reactivex.internal.disposables.DisposableHelper.DISPOSED) {
                return;
            }
            try {
                io.reactivex.internal.operators.completable.CompletablePeek.this.v.run();
                io.reactivex.internal.operators.completable.CompletablePeek.this.w.run();
                this.n.onComplete();
                a();
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.n.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
            if (this.t == io.reactivex.internal.disposables.DisposableHelper.DISPOSED) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            try {
                io.reactivex.internal.operators.completable.CompletablePeek.this.u.accept(th);
                io.reactivex.internal.operators.completable.CompletablePeek.this.w.run();
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                th = new io.reactivex.exceptions.CompositeException(th, th2);
            }
            this.n.onError(th);
            a();
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            try {
                io.reactivex.internal.operators.completable.CompletablePeek.this.t.accept(disposable);
                if (io.reactivex.internal.disposables.DisposableHelper.validate(this.t, disposable)) {
                    this.t = disposable;
                    this.n.onSubscribe(this);
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                disposable.dispose();
                this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
                io.reactivex.internal.disposables.EmptyDisposable.error(th, this.n);
            }
        }
    }

    public CompletablePeek(io.reactivex.CompletableSource completableSource, io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2, io.reactivex.functions.Action action, io.reactivex.functions.Action action2, io.reactivex.functions.Action action3, io.reactivex.functions.Action action4) {
        this.n = completableSource;
        this.t = consumer;
        this.u = consumer2;
        this.v = action;
        this.w = action2;
        this.x = action3;
        this.y = action4;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.completable.CompletablePeek.CompletableObserverImplementation(completableObserver));
    }
}
