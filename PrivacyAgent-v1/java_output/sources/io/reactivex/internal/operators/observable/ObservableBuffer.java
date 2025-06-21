package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableBuffer<T, U extends java.util.Collection<? super T>> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, U> {
    public final int n;
    public final int t;
    public final java.util.concurrent.Callable<U> u;

    public static final class BufferExactObserver<T, U extends java.util.Collection<? super T>> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super U> n;
        public final int t;
        public final java.util.concurrent.Callable<U> u;
        public U v;
        public int w;
        public io.reactivex.disposables.Disposable x;

        public BufferExactObserver(io.reactivex.Observer<? super U> observer, int i, java.util.concurrent.Callable<U> callable) {
            this.n = observer;
            this.t = i;
            this.u = callable;
        }

        public boolean a() {
            try {
                this.v = (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.u.call(), "Empty buffer supplied");
                return true;
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.v = null;
                io.reactivex.disposables.Disposable disposable = this.x;
                if (disposable == null) {
                    io.reactivex.internal.disposables.EmptyDisposable.error(th, this.n);
                    return false;
                }
                disposable.dispose();
                this.n.onError(th);
                return false;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.x.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.x.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u = this.v;
            if (u != null) {
                this.v = null;
                if (!u.isEmpty()) {
                    this.n.onNext(u);
                }
                this.n.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.v = null;
            this.n.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            U u = this.v;
            if (u != null) {
                u.add(t);
                int i = this.w + 1;
                this.w = i;
                if (i >= this.t) {
                    this.n.onNext(u);
                    this.w = 0;
                    a();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.x, disposable)) {
                this.x = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public static final class BufferSkipObserver<T, U extends java.util.Collection<? super T>> extends java.util.concurrent.atomic.AtomicBoolean implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -8223395059921494546L;
        final java.util.concurrent.Callable<U> bufferSupplier;
        final java.util.ArrayDeque<U> buffers = new java.util.ArrayDeque<>();
        final int count;
        final io.reactivex.Observer<? super U> downstream;
        long index;
        final int skip;
        io.reactivex.disposables.Disposable upstream;

        public BufferSkipObserver(io.reactivex.Observer<? super U> observer, int i, int i2, java.util.concurrent.Callable<U> callable) {
            this.downstream = observer;
            this.count = i;
            this.skip = i2;
            this.bufferSupplier = callable;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            while (!this.buffers.isEmpty()) {
                this.downstream.onNext(this.buffers.poll());
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.buffers.clear();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            long j = this.index;
            this.index = 1 + j;
            if (j % this.skip == 0) {
                try {
                    this.buffers.offer((java.util.Collection) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."));
                } catch (java.lang.Throwable th) {
                    this.buffers.clear();
                    this.upstream.dispose();
                    this.downstream.onError(th);
                    return;
                }
            }
            java.util.Iterator<U> it = this.buffers.iterator();
            while (it.hasNext()) {
                U next = it.next();
                next.add(t);
                if (this.count <= next.size()) {
                    it.remove();
                    this.downstream.onNext(next);
                }
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

    public ObservableBuffer(io.reactivex.ObservableSource<T> observableSource, int i, int i2, java.util.concurrent.Callable<U> callable) {
        super(observableSource);
        this.n = i;
        this.t = i2;
        this.u = callable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super U> observer) {
        int i = this.t;
        int i2 = this.n;
        if (i != i2) {
            this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableBuffer.BufferSkipObserver(observer, this.n, this.t, this.u));
            return;
        }
        io.reactivex.internal.operators.observable.ObservableBuffer.BufferExactObserver bufferExactObserver = new io.reactivex.internal.operators.observable.ObservableBuffer.BufferExactObserver(observer, i2, this.u);
        if (bufferExactObserver.a()) {
            this.source.subscribe(bufferExactObserver);
        }
    }
}
