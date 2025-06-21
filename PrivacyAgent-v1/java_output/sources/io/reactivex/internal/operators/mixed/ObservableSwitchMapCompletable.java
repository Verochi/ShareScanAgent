package io.reactivex.internal.operators.mixed;

/* loaded from: classes11.dex */
public final class ObservableSwitchMapCompletable<T> extends io.reactivex.Completable {
    public final io.reactivex.Observable<T> n;
    public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> t;
    public final boolean u;

    public static final class SwitchMapCompletableObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public static final io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable.SwitchMapCompletableObserver.SwitchMapInnerObserver z = new io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable.SwitchMapCompletableObserver.SwitchMapInnerObserver(null);
        public final io.reactivex.CompletableObserver n;
        public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> t;
        public final boolean u;
        public final io.reactivex.internal.util.AtomicThrowable v = new io.reactivex.internal.util.AtomicThrowable();
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable.SwitchMapCompletableObserver.SwitchMapInnerObserver> w = new java.util.concurrent.atomic.AtomicReference<>();
        public volatile boolean x;
        public io.reactivex.disposables.Disposable y;

        public static final class SwitchMapInnerObserver extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.CompletableObserver {
            private static final long serialVersionUID = -8003404460084760287L;
            final io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable.SwitchMapCompletableObserver<?> parent;

            public SwitchMapInnerObserver(io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable.SwitchMapCompletableObserver<?> switchMapCompletableObserver) {
                this.parent = switchMapCompletableObserver;
            }

            public void dispose() {
                io.reactivex.internal.disposables.DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.parent.b(this);
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(java.lang.Throwable th) {
                this.parent.c(this, th);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
                io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
            }
        }

        public SwitchMapCompletableObserver(io.reactivex.CompletableObserver completableObserver, io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function, boolean z2) {
            this.n = completableObserver;
            this.t = function;
            this.u = z2;
        }

        public void a() {
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable.SwitchMapCompletableObserver.SwitchMapInnerObserver> atomicReference = this.w;
            io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable.SwitchMapCompletableObserver.SwitchMapInnerObserver switchMapInnerObserver = z;
            io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable.SwitchMapCompletableObserver.SwitchMapInnerObserver andSet = atomicReference.getAndSet(switchMapInnerObserver);
            if (andSet == null || andSet == switchMapInnerObserver) {
                return;
            }
            andSet.dispose();
        }

        public void b(io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable.SwitchMapCompletableObserver.SwitchMapInnerObserver switchMapInnerObserver) {
            if (defpackage.xv0.a(this.w, switchMapInnerObserver, null) && this.x) {
                java.lang.Throwable terminate = this.v.terminate();
                if (terminate == null) {
                    this.n.onComplete();
                } else {
                    this.n.onError(terminate);
                }
            }
        }

        public void c(io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable.SwitchMapCompletableObserver.SwitchMapInnerObserver switchMapInnerObserver, java.lang.Throwable th) {
            if (!defpackage.xv0.a(this.w, switchMapInnerObserver, null) || !this.v.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            if (this.u) {
                if (this.x) {
                    this.n.onError(this.v.terminate());
                    return;
                }
                return;
            }
            dispose();
            java.lang.Throwable terminate = this.v.terminate();
            if (terminate != io.reactivex.internal.util.ExceptionHelper.TERMINATED) {
                this.n.onError(terminate);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.y.dispose();
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.w.get() == z;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.x = true;
            if (this.w.get() == null) {
                java.lang.Throwable terminate = this.v.terminate();
                if (terminate == null) {
                    this.n.onComplete();
                } else {
                    this.n.onError(terminate);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (!this.v.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            if (this.u) {
                onComplete();
                return;
            }
            a();
            java.lang.Throwable terminate = this.v.terminate();
            if (terminate != io.reactivex.internal.util.ExceptionHelper.TERMINATED) {
                this.n.onError(terminate);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable.SwitchMapCompletableObserver.SwitchMapInnerObserver switchMapInnerObserver;
            try {
                io.reactivex.CompletableSource completableSource = (io.reactivex.CompletableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(t), "The mapper returned a null CompletableSource");
                io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable.SwitchMapCompletableObserver.SwitchMapInnerObserver switchMapInnerObserver2 = new io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable.SwitchMapCompletableObserver.SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = this.w.get();
                    if (switchMapInnerObserver == z) {
                        return;
                    }
                } while (!defpackage.xv0.a(this.w, switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.dispose();
                }
                completableSource.subscribe(switchMapInnerObserver2);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.y.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.y, disposable)) {
                this.y = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapCompletable(io.reactivex.Observable<T> observable, io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function, boolean z) {
        this.n = observable;
        this.t = function;
        this.u = z;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        if (io.reactivex.internal.operators.mixed.ScalarXMapZHelper.a(this.n, this.t, completableObserver)) {
            return;
        }
        this.n.subscribe(new io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable.SwitchMapCompletableObserver(completableObserver, this.t, this.u));
    }
}
