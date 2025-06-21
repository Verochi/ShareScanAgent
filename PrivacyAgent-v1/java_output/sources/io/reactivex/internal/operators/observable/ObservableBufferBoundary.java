package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableBufferBoundary<T, U extends java.util.Collection<? super T>, Open, Close> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, U> {
    public final java.util.concurrent.Callable<U> n;
    public final io.reactivex.ObservableSource<? extends Open> t;
    public final io.reactivex.functions.Function<? super Open, ? extends io.reactivex.ObservableSource<? extends Close>> u;

    public static final class BufferBoundaryObserver<T, C extends java.util.Collection<? super T>, Open, Close> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -8466418554264089604L;
        final io.reactivex.functions.Function<? super Open, ? extends io.reactivex.ObservableSource<? extends Close>> bufferClose;
        final io.reactivex.ObservableSource<? extends Open> bufferOpen;
        final java.util.concurrent.Callable<C> bufferSupplier;
        volatile boolean cancelled;
        volatile boolean done;
        final io.reactivex.Observer<? super C> downstream;
        long index;
        final io.reactivex.internal.queue.SpscLinkedArrayQueue<C> queue = new io.reactivex.internal.queue.SpscLinkedArrayQueue<>(io.reactivex.Observable.bufferSize());
        final io.reactivex.disposables.CompositeDisposable observers = new io.reactivex.disposables.CompositeDisposable();
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> upstream = new java.util.concurrent.atomic.AtomicReference<>();
        java.util.Map<java.lang.Long, C> buffers = new java.util.LinkedHashMap();
        final io.reactivex.internal.util.AtomicThrowable errors = new io.reactivex.internal.util.AtomicThrowable();

        public static final class BufferOpenObserver<Open> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.Observer<Open>, io.reactivex.disposables.Disposable {
            private static final long serialVersionUID = -8498650778633225126L;
            final io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferBoundaryObserver<?, ?, Open, ?> parent;

            public BufferOpenObserver(io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferBoundaryObserver<?, ?, Open, ?> bufferBoundaryObserver) {
                this.parent = bufferBoundaryObserver;
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                io.reactivex.internal.disposables.DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return get() == io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                lazySet(io.reactivex.internal.disposables.DisposableHelper.DISPOSED);
                this.parent.openComplete(this);
            }

            @Override // io.reactivex.Observer
            public void onError(java.lang.Throwable th) {
                lazySet(io.reactivex.internal.disposables.DisposableHelper.DISPOSED);
                this.parent.boundaryError(this, th);
            }

            @Override // io.reactivex.Observer
            public void onNext(Open open) {
                this.parent.open(open);
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
                io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
            }
        }

        public BufferBoundaryObserver(io.reactivex.Observer<? super C> observer, io.reactivex.ObservableSource<? extends Open> observableSource, io.reactivex.functions.Function<? super Open, ? extends io.reactivex.ObservableSource<? extends Close>> function, java.util.concurrent.Callable<C> callable) {
            this.downstream = observer;
            this.bufferSupplier = callable;
            this.bufferOpen = observableSource;
            this.bufferClose = function;
        }

        public void boundaryError(io.reactivex.disposables.Disposable disposable, java.lang.Throwable th) {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.upstream);
            this.observers.delete(disposable);
            onError(th);
        }

        public void close(io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferCloseObserver<T, C> bufferCloseObserver, long j) {
            boolean z;
            this.observers.delete(bufferCloseObserver);
            if (this.observers.size() == 0) {
                io.reactivex.internal.disposables.DisposableHelper.dispose(this.upstream);
                z = true;
            } else {
                z = false;
            }
            synchronized (this) {
                java.util.Map<java.lang.Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                this.queue.offer(map.remove(java.lang.Long.valueOf(j)));
                if (z) {
                    this.done = true;
                }
                drain();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (io.reactivex.internal.disposables.DisposableHelper.dispose(this.upstream)) {
                this.cancelled = true;
                this.observers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                if (getAndIncrement() != 0) {
                    this.queue.clear();
                }
            }
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.Observer<? super C> observer = this.downstream;
            io.reactivex.internal.queue.SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.queue;
            int i = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                if (z && this.errors.get() != null) {
                    spscLinkedArrayQueue.clear();
                    observer.onError(this.errors.terminate());
                    return;
                }
                C poll = spscLinkedArrayQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    observer.onComplete();
                    return;
                } else if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    observer.onNext(poll);
                }
            }
            spscLinkedArrayQueue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.observers.dispose();
            synchronized (this) {
                java.util.Map<java.lang.Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                java.util.Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    this.queue.offer(it.next());
                }
                this.buffers = null;
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (!this.errors.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.observers.dispose();
            synchronized (this) {
                this.buffers = null;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            synchronized (this) {
                java.util.Map<java.lang.Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                java.util.Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.setOnce(this.upstream, disposable)) {
                io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferBoundaryObserver.BufferOpenObserver bufferOpenObserver = new io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferBoundaryObserver.BufferOpenObserver(this);
                this.observers.add(bufferOpenObserver);
                this.bufferOpen.subscribe(bufferOpenObserver);
            }
        }

        public void open(Open open) {
            try {
                java.util.Collection collection = (java.util.Collection) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");
                io.reactivex.ObservableSource observableSource = (io.reactivex.ObservableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.bufferClose.apply(open), "The bufferClose returned a null ObservableSource");
                long j = this.index;
                this.index = 1 + j;
                synchronized (this) {
                    java.util.Map<java.lang.Long, C> map = this.buffers;
                    if (map == null) {
                        return;
                    }
                    map.put(java.lang.Long.valueOf(j), collection);
                    io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferCloseObserver bufferCloseObserver = new io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferCloseObserver(this, j);
                    this.observers.add(bufferCloseObserver);
                    observableSource.subscribe(bufferCloseObserver);
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.internal.disposables.DisposableHelper.dispose(this.upstream);
                onError(th);
            }
        }

        public void openComplete(io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferBoundaryObserver.BufferOpenObserver<Open> bufferOpenObserver) {
            this.observers.delete(bufferOpenObserver);
            if (this.observers.size() == 0) {
                io.reactivex.internal.disposables.DisposableHelper.dispose(this.upstream);
                this.done = true;
                drain();
            }
        }
    }

    public static final class BufferCloseObserver<T, C extends java.util.Collection<? super T>> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.Observer<java.lang.Object>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -8498650778633225126L;
        final long index;
        final io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferBoundaryObserver<T, C, ?, ?> parent;

        public BufferCloseObserver(io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferBoundaryObserver<T, C, ?, ?> bufferBoundaryObserver, long j) {
            this.parent = bufferBoundaryObserver;
            this.index = j;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            io.reactivex.disposables.Disposable disposable = get();
            io.reactivex.internal.disposables.DisposableHelper disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                lazySet(disposableHelper);
                this.parent.close(this, this.index);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            io.reactivex.disposables.Disposable disposable = get();
            io.reactivex.internal.disposables.DisposableHelper disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                lazySet(disposableHelper);
                this.parent.boundaryError(this, th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(java.lang.Object obj) {
            io.reactivex.disposables.Disposable disposable = get();
            io.reactivex.internal.disposables.DisposableHelper disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                lazySet(disposableHelper);
                disposable.dispose();
                this.parent.close(this, this.index);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableBufferBoundary(io.reactivex.ObservableSource<T> observableSource, io.reactivex.ObservableSource<? extends Open> observableSource2, io.reactivex.functions.Function<? super Open, ? extends io.reactivex.ObservableSource<? extends Close>> function, java.util.concurrent.Callable<U> callable) {
        super(observableSource);
        this.t = observableSource2;
        this.u = function;
        this.n = callable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super U> observer) {
        io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferBoundaryObserver bufferBoundaryObserver = new io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferBoundaryObserver(observer, this.t, this.u, this.n);
        observer.onSubscribe(bufferBoundaryObserver);
        this.source.subscribe(bufferBoundaryObserver);
    }
}
