package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableBufferExactBoundary<T, U extends java.util.Collection<? super T>, B> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, U> {
    public final io.reactivex.ObservableSource<B> n;
    public final java.util.concurrent.Callable<U> t;

    public static final class BufferBoundaryObserver<T, U extends java.util.Collection<? super T>, B> extends io.reactivex.observers.DisposableObserver<B> {
        public final io.reactivex.internal.operators.observable.ObservableBufferExactBoundary.BufferExactBoundaryObserver<T, U, B> t;

        public BufferBoundaryObserver(io.reactivex.internal.operators.observable.ObservableBufferExactBoundary.BufferExactBoundaryObserver<T, U, B> bufferExactBoundaryObserver) {
            this.t = bufferExactBoundaryObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.t.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.t.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(B b) {
            this.t.b();
        }
    }

    public static final class BufferExactBoundaryObserver<T, U extends java.util.Collection<? super T>, B> extends io.reactivex.internal.observers.QueueDrainObserver<T, U, U> implements io.reactivex.disposables.Disposable {
        public final java.util.concurrent.Callable<U> t;
        public final io.reactivex.ObservableSource<B> u;
        public io.reactivex.disposables.Disposable v;
        public io.reactivex.disposables.Disposable w;
        public U x;

        public BufferExactBoundaryObserver(io.reactivex.Observer<? super U> observer, java.util.concurrent.Callable<U> callable, io.reactivex.ObservableSource<B> observableSource) {
            super(observer, new io.reactivex.internal.queue.MpscLinkedQueue());
            this.t = callable;
            this.u = observableSource;
        }

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(io.reactivex.Observer<? super U> observer, U u) {
            this.downstream.onNext(u);
        }

        public void b() {
            try {
                U u = (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.x;
                    if (u2 == null) {
                        return;
                    }
                    this.x = u;
                    fastPathEmit(u2, false, this);
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                dispose();
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.w.dispose();
            this.v.dispose();
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
                try {
                    this.x = (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The buffer supplied is null");
                    io.reactivex.internal.operators.observable.ObservableBufferExactBoundary.BufferBoundaryObserver bufferBoundaryObserver = new io.reactivex.internal.operators.observable.ObservableBufferExactBoundary.BufferBoundaryObserver(this);
                    this.w = bufferBoundaryObserver;
                    this.downstream.onSubscribe(this);
                    if (this.cancelled) {
                        return;
                    }
                    this.u.subscribe(bufferBoundaryObserver);
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    this.cancelled = true;
                    disposable.dispose();
                    io.reactivex.internal.disposables.EmptyDisposable.error(th, this.downstream);
                }
            }
        }
    }

    public ObservableBufferExactBoundary(io.reactivex.ObservableSource<T> observableSource, io.reactivex.ObservableSource<B> observableSource2, java.util.concurrent.Callable<U> callable) {
        super(observableSource);
        this.n = observableSource2;
        this.t = callable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super U> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableBufferExactBoundary.BufferExactBoundaryObserver(new io.reactivex.observers.SerializedObserver(observer), this.t, this.n));
    }
}
