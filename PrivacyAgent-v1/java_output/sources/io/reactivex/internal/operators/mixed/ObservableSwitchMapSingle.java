package io.reactivex.internal.operators.mixed;

/* loaded from: classes11.dex */
public final class ObservableSwitchMapSingle<T, R> extends io.reactivex.Observable<R> {
    public final io.reactivex.Observable<T> n;
    public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> t;
    public final boolean u;

    public static final class SwitchMapSingleMainObserver<T, R> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        static final io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle.SwitchMapSingleMainObserver.SwitchMapSingleObserver<java.lang.Object> INNER_DISPOSED = new io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle.SwitchMapSingleMainObserver.SwitchMapSingleObserver<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final io.reactivex.Observer<? super R> downstream;
        final io.reactivex.internal.util.AtomicThrowable errors = new io.reactivex.internal.util.AtomicThrowable();
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle.SwitchMapSingleMainObserver.SwitchMapSingleObserver<R>> inner = new java.util.concurrent.atomic.AtomicReference<>();
        final io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> mapper;
        io.reactivex.disposables.Disposable upstream;

        public static final class SwitchMapSingleObserver<R> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.SingleObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            volatile R item;
            final io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle.SwitchMapSingleMainObserver<?, R> parent;

            public SwitchMapSingleObserver(io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle.SwitchMapSingleMainObserver<?, R> switchMapSingleMainObserver) {
                this.parent = switchMapSingleMainObserver;
            }

            public void dispose() {
                io.reactivex.internal.disposables.DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.SingleObserver
            public void onError(java.lang.Throwable th) {
                this.parent.innerError(this, th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
                io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(R r) {
                this.item = r;
                this.parent.drain();
            }
        }

        public SwitchMapSingleMainObserver(io.reactivex.Observer<? super R> observer, io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function, boolean z) {
            this.downstream = observer;
            this.mapper = function;
            this.delayErrors = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            disposeInner();
        }

        public void disposeInner() {
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle.SwitchMapSingleMainObserver.SwitchMapSingleObserver<R>> atomicReference = this.inner;
            io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle.SwitchMapSingleMainObserver.SwitchMapSingleObserver<java.lang.Object> switchMapSingleObserver = INNER_DISPOSED;
            io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle.SwitchMapSingleMainObserver.SwitchMapSingleObserver<java.lang.Object> switchMapSingleObserver2 = (io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle.SwitchMapSingleMainObserver.SwitchMapSingleObserver) atomicReference.getAndSet(switchMapSingleObserver);
            if (switchMapSingleObserver2 == null || switchMapSingleObserver2 == switchMapSingleObserver) {
                return;
            }
            switchMapSingleObserver2.dispose();
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.Observer<? super R> observer = this.downstream;
            io.reactivex.internal.util.AtomicThrowable atomicThrowable = this.errors;
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle.SwitchMapSingleMainObserver.SwitchMapSingleObserver<R>> atomicReference = this.inner;
            int i = 1;
            while (!this.cancelled) {
                if (atomicThrowable.get() != null && !this.delayErrors) {
                    observer.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z = this.done;
                io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle.SwitchMapSingleMainObserver.SwitchMapSingleObserver<R> switchMapSingleObserver = atomicReference.get();
                boolean z2 = switchMapSingleObserver == null;
                if (z && z2) {
                    java.lang.Throwable terminate = atomicThrowable.terminate();
                    if (terminate != null) {
                        observer.onError(terminate);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                }
                if (z2 || switchMapSingleObserver.item == null) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    defpackage.xv0.a(atomicReference, switchMapSingleObserver, null);
                    observer.onNext(switchMapSingleObserver.item);
                }
            }
        }

        public void innerError(io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle.SwitchMapSingleMainObserver.SwitchMapSingleObserver<R> switchMapSingleObserver, java.lang.Throwable th) {
            if (!defpackage.xv0.a(this.inner, switchMapSingleObserver, null) || !this.errors.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.dispose();
                disposeInner();
            }
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (!this.errors.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            if (!this.delayErrors) {
                disposeInner();
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle.SwitchMapSingleMainObserver.SwitchMapSingleObserver<R> switchMapSingleObserver;
            io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle.SwitchMapSingleMainObserver.SwitchMapSingleObserver<R> switchMapSingleObserver2 = this.inner.get();
            if (switchMapSingleObserver2 != null) {
                switchMapSingleObserver2.dispose();
            }
            try {
                io.reactivex.SingleSource singleSource = (io.reactivex.SingleSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null SingleSource");
                io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle.SwitchMapSingleMainObserver.SwitchMapSingleObserver switchMapSingleObserver3 = new io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle.SwitchMapSingleMainObserver.SwitchMapSingleObserver(this);
                do {
                    switchMapSingleObserver = this.inner.get();
                    if (switchMapSingleObserver == INNER_DISPOSED) {
                        return;
                    }
                } while (!defpackage.xv0.a(this.inner, switchMapSingleObserver, switchMapSingleObserver3));
                singleSource.subscribe(switchMapSingleObserver3);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.upstream.dispose();
                this.inner.getAndSet(INNER_DISPOSED);
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapSingle(io.reactivex.Observable<T> observable, io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function, boolean z) {
        this.n = observable;
        this.t = function;
        this.u = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super R> observer) {
        if (io.reactivex.internal.operators.mixed.ScalarXMapZHelper.c(this.n, this.t, observer)) {
            return;
        }
        this.n.subscribe(new io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle.SwitchMapSingleMainObserver(observer, this.t, this.u));
    }
}
