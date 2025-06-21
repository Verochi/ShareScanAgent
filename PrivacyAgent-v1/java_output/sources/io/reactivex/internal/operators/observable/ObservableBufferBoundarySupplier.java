package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableBufferBoundarySupplier<T, U extends java.util.Collection<? super T>, B> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, U> {
    public final java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<B>> n;
    public final java.util.concurrent.Callable<U> t;

    public static final class BufferBoundaryObserver<T, U extends java.util.Collection<? super T>, B> extends io.reactivex.observers.DisposableObserver<B> {
        public final io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier.BufferBoundarySupplierObserver<T, U, B> t;
        public boolean u;

        public BufferBoundaryObserver(io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier.BufferBoundarySupplierObserver<T, U, B> bufferBoundarySupplierObserver) {
            this.t = bufferBoundarySupplierObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.u) {
                return;
            }
            this.u = true;
            this.t.c();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.u) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.u = true;
                this.t.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(B b) {
            if (this.u) {
                return;
            }
            this.u = true;
            dispose();
            this.t.c();
        }
    }

    public static final class BufferBoundarySupplierObserver<T, U extends java.util.Collection<? super T>, B> extends io.reactivex.internal.observers.QueueDrainObserver<T, U, U> implements io.reactivex.disposables.Disposable {
        public final java.util.concurrent.Callable<U> t;
        public final java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<B>> u;
        public io.reactivex.disposables.Disposable v;
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> w;
        public U x;

        public BufferBoundarySupplierObserver(io.reactivex.Observer<? super U> observer, java.util.concurrent.Callable<U> callable, java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<B>> callable2) {
            super(observer, new io.reactivex.internal.queue.MpscLinkedQueue());
            this.w = new java.util.concurrent.atomic.AtomicReference<>();
            this.t = callable;
            this.u = callable2;
        }

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(io.reactivex.Observer<? super U> observer, U u) {
            this.downstream.onNext(u);
        }

        public void b() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.w);
        }

        public void c() {
            try {
                U u = (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The buffer supplied is null");
                try {
                    io.reactivex.ObservableSource observableSource = (io.reactivex.ObservableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.u.call(), "The boundary ObservableSource supplied is null");
                    io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier.BufferBoundaryObserver bufferBoundaryObserver = new io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier.BufferBoundaryObserver(this);
                    if (io.reactivex.internal.disposables.DisposableHelper.replace(this.w, bufferBoundaryObserver)) {
                        synchronized (this) {
                            U u2 = this.x;
                            if (u2 == null) {
                                return;
                            }
                            this.x = u;
                            observableSource.subscribe(bufferBoundaryObserver);
                            fastPathEmit(u2, false, this);
                        }
                    }
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    this.cancelled = true;
                    this.v.dispose();
                    this.downstream.onError(th);
                }
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                dispose();
                this.downstream.onError(th2);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.v.dispose();
            b();
            if (enter()) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            synchronized (this) {
                U u = this.x;
                if (u == null) {
                    return;
                }
                this.x = null;
                this.queue.offer(u);
                this.done = true;
                if (enter()) {
                    io.reactivex.internal.util.QueueDrainHelper.drainLoop(this.queue, this.downstream, false, this, this);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            dispose();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            synchronized (this) {
                U u = this.x;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.v, disposable)) {
                this.v = disposable;
                io.reactivex.Observer<? super V> observer = this.downstream;
                try {
                    this.x = (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The buffer supplied is null");
                    try {
                        io.reactivex.ObservableSource observableSource = (io.reactivex.ObservableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.u.call(), "The boundary ObservableSource supplied is null");
                        io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier.BufferBoundaryObserver bufferBoundaryObserver = new io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier.BufferBoundaryObserver(this);
                        this.w.set(bufferBoundaryObserver);
                        observer.onSubscribe(this);
                        if (this.cancelled) {
                            return;
                        }
                        observableSource.subscribe(bufferBoundaryObserver);
                    } catch (java.lang.Throwable th) {
                        io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                        this.cancelled = true;
                        disposable.dispose();
                        io.reactivex.internal.disposables.EmptyDisposable.error(th, observer);
                    }
                } catch (java.lang.Throwable th2) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                    this.cancelled = true;
                    disposable.dispose();
                    io.reactivex.internal.disposables.EmptyDisposable.error(th2, observer);
                }
            }
        }
    }

    public ObservableBufferBoundarySupplier(io.reactivex.ObservableSource<T> observableSource, java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<B>> callable, java.util.concurrent.Callable<U> callable2) {
        super(observableSource);
        this.n = callable;
        this.t = callable2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super U> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier.BufferBoundarySupplierObserver(new io.reactivex.observers.SerializedObserver(observer), this.t, this.n));
    }
}
