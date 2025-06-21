package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableFlatMap<T, U> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, U> {
    public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends U>> n;
    public final boolean t;
    public final int u;
    public final int v;

    public static final class InnerObserver<T, U> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.Observer<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;
        final long id;
        final io.reactivex.internal.operators.observable.ObservableFlatMap.MergeObserver<T, U> parent;
        volatile io.reactivex.internal.fuseable.SimpleQueue<U> queue;

        public InnerObserver(io.reactivex.internal.operators.observable.ObservableFlatMap.MergeObserver<T, U> mergeObserver, long j) {
            this.id = j;
            this.parent = mergeObserver;
        }

        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (!this.parent.errors.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            io.reactivex.internal.operators.observable.ObservableFlatMap.MergeObserver<T, U> mergeObserver = this.parent;
            if (!mergeObserver.delayErrors) {
                mergeObserver.disposeAll();
            }
            this.done = true;
            this.parent.drain();
        }

        @Override // io.reactivex.Observer
        public void onNext(U u) {
            if (this.fusionMode == 0) {
                this.parent.tryEmit(u, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable) && (disposable instanceof io.reactivex.internal.fuseable.QueueDisposable)) {
                io.reactivex.internal.fuseable.QueueDisposable queueDisposable = (io.reactivex.internal.fuseable.QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(7);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = queueDisposable;
                    this.done = true;
                    this.parent.drain();
                    return;
                }
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = queueDisposable;
                }
            }
        }
    }

    public static final class MergeObserver<T, U> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.disposables.Disposable, io.reactivex.Observer<T> {
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final io.reactivex.Observer<? super U> downstream;
        final io.reactivex.internal.util.AtomicThrowable errors = new io.reactivex.internal.util.AtomicThrowable();
        long lastId;
        int lastIndex;
        final io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends U>> mapper;
        final int maxConcurrency;
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver<?, ?>[]> observers;
        volatile io.reactivex.internal.fuseable.SimplePlainQueue<U> queue;
        java.util.Queue<io.reactivex.ObservableSource<? extends U>> sources;
        long uniqueId;
        io.reactivex.disposables.Disposable upstream;
        int wip;
        static final io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver<?, ?>[] EMPTY = new io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver[0];
        static final io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver<?, ?>[] CANCELLED = new io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver[0];

        public MergeObserver(io.reactivex.Observer<? super U> observer, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends U>> function, boolean z, int i, int i2) {
            this.downstream = observer;
            this.mapper = function;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.bufferSize = i2;
            if (i != Integer.MAX_VALUE) {
                this.sources = new java.util.ArrayDeque(i);
            }
            this.observers = new java.util.concurrent.atomic.AtomicReference<>(EMPTY);
        }

        public boolean addInner(io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver<T, U> innerObserver) {
            io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver<?, ?>[] innerObserverArr;
            io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                if (innerObserverArr == CANCELLED) {
                    innerObserver.dispose();
                    return false;
                }
                int length = innerObserverArr.length;
                innerObserverArr2 = new io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver[length + 1];
                java.lang.System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                innerObserverArr2[length] = innerObserver;
            } while (!defpackage.xv0.a(this.observers, innerObserverArr, innerObserverArr2));
            return true;
        }

        public boolean checkTerminate() {
            if (this.cancelled) {
                return true;
            }
            java.lang.Throwable th = this.errors.get();
            if (this.delayErrors || th == null) {
                return false;
            }
            disposeAll();
            java.lang.Throwable terminate = this.errors.terminate();
            if (terminate != io.reactivex.internal.util.ExceptionHelper.TERMINATED) {
                this.downstream.onError(terminate);
            }
            return true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            java.lang.Throwable terminate;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (!disposeAll() || (terminate = this.errors.terminate()) == null || terminate == io.reactivex.internal.util.ExceptionHelper.TERMINATED) {
                return;
            }
            io.reactivex.plugins.RxJavaPlugins.onError(terminate);
        }

        public boolean disposeAll() {
            io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver<?, ?>[] andSet;
            this.upstream.dispose();
            io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver<?, ?>[] innerObserverArr = this.observers.get();
            io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver<?, ?>[] innerObserverArr2 = CANCELLED;
            if (innerObserverArr == innerObserverArr2 || (andSet = this.observers.getAndSet(innerObserverArr2)) == innerObserverArr2) {
                return false;
            }
            for (io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver<?, ?> innerObserver : andSet) {
                innerObserver.dispose();
            }
            return true;
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:131:0x0004, code lost:
        
            continue;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drainLoop() {
            int i;
            int i2;
            io.reactivex.Observer<? super U> observer = this.downstream;
            int i3 = 1;
            while (!checkTerminate()) {
                io.reactivex.internal.fuseable.SimplePlainQueue<U> simplePlainQueue = this.queue;
                if (simplePlainQueue != null) {
                    while (!checkTerminate()) {
                        U poll = simplePlainQueue.poll();
                        if (poll != null) {
                            observer.onNext(poll);
                        }
                    }
                    return;
                }
                boolean z = this.done;
                io.reactivex.internal.fuseable.SimplePlainQueue<U> simplePlainQueue2 = this.queue;
                io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver<?, ?>[] innerObserverArr = this.observers.get();
                int length = innerObserverArr.length;
                int i4 = 0;
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        i = this.sources.size();
                    }
                } else {
                    i = 0;
                }
                if (z && ((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0 && i == 0)) {
                    java.lang.Throwable terminate = this.errors.terminate();
                    if (terminate != io.reactivex.internal.util.ExceptionHelper.TERMINATED) {
                        if (terminate == null) {
                            observer.onComplete();
                            return;
                        } else {
                            observer.onError(terminate);
                            return;
                        }
                    }
                    return;
                }
                if (length != 0) {
                    long j = this.lastId;
                    int i5 = this.lastIndex;
                    if (length <= i5 || innerObserverArr[i5].id != j) {
                        if (length <= i5) {
                            i5 = 0;
                        }
                        for (int i6 = 0; i6 < length && innerObserverArr[i5].id != j; i6++) {
                            i5++;
                            if (i5 == length) {
                                i5 = 0;
                            }
                        }
                        this.lastIndex = i5;
                        this.lastId = innerObserverArr[i5].id;
                    }
                    int i7 = 0;
                    while (i2 < length) {
                        if (checkTerminate()) {
                            return;
                        }
                        io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver<T, U> innerObserver = innerObserverArr[i5];
                        io.reactivex.internal.fuseable.SimpleQueue<U> simpleQueue = innerObserver.queue;
                        if (simpleQueue != null) {
                            do {
                                try {
                                    U poll2 = simpleQueue.poll();
                                    if (poll2 != null) {
                                        observer.onNext(poll2);
                                    }
                                } catch (java.lang.Throwable th) {
                                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                                    innerObserver.dispose();
                                    this.errors.addThrowable(th);
                                    if (checkTerminate()) {
                                        return;
                                    }
                                    removeInner(innerObserver);
                                    i7++;
                                    i5++;
                                    if (i5 != length) {
                                    }
                                }
                            } while (!checkTerminate());
                            return;
                        }
                        boolean z2 = innerObserver.done;
                        io.reactivex.internal.fuseable.SimpleQueue<U> simpleQueue2 = innerObserver.queue;
                        if (z2 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                            removeInner(innerObserver);
                            if (checkTerminate()) {
                                return;
                            } else {
                                i7++;
                            }
                        }
                        i5++;
                        i2 = i5 != length ? i2 + 1 : 0;
                        i5 = 0;
                    }
                    this.lastIndex = i5;
                    this.lastId = innerObserverArr[i5].id;
                    i4 = i7;
                }
                if (i4 == 0) {
                    i3 = addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                    while (true) {
                        int i8 = i4 - 1;
                        if (i4 != 0) {
                            synchronized (this) {
                                io.reactivex.ObservableSource<? extends U> poll3 = this.sources.poll();
                                if (poll3 == null) {
                                    this.wip--;
                                } else {
                                    subscribeInner(poll3);
                                }
                            }
                            i4 = i8;
                        }
                    }
                } else {
                    continue;
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.done) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else if (!this.errors.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                io.reactivex.ObservableSource<? extends U> observableSource = (io.reactivex.ObservableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null ObservableSource");
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        int i = this.wip;
                        if (i == this.maxConcurrency) {
                            this.sources.offer(observableSource);
                            return;
                        }
                        this.wip = i + 1;
                    }
                }
                subscribeInner(observableSource);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.upstream.dispose();
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

        /* JADX WARN: Multi-variable type inference failed */
        public void removeInner(io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver<T, U> innerObserver) {
            io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver<?, ?>[] innerObserverArr;
            io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver<?, ?>[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                int length = innerObserverArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (innerObserverArr[i] == innerObserver) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerObserverArr2 = EMPTY;
                } else {
                    io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver<?, ?>[] innerObserverArr3 = new io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver[length - 1];
                    java.lang.System.arraycopy(innerObserverArr, 0, innerObserverArr3, 0, i);
                    java.lang.System.arraycopy(innerObserverArr, i + 1, innerObserverArr3, i, (length - i) - 1);
                    innerObserverArr2 = innerObserverArr3;
                }
            } while (!defpackage.xv0.a(this.observers, innerObserverArr, innerObserverArr2));
        }

        public void subscribeInner(io.reactivex.ObservableSource<? extends U> observableSource) {
            boolean z;
            while (observableSource instanceof java.util.concurrent.Callable) {
                if (!tryEmitScalar((java.util.concurrent.Callable) observableSource) || this.maxConcurrency == Integer.MAX_VALUE) {
                    return;
                }
                synchronized (this) {
                    observableSource = this.sources.poll();
                    if (observableSource == null) {
                        z = true;
                        this.wip--;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    drain();
                    return;
                }
            }
            long j = this.uniqueId;
            this.uniqueId = 1 + j;
            io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver<T, U> innerObserver = new io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver<>(this, j);
            if (addInner(innerObserver)) {
                observableSource.subscribe(innerObserver);
            }
        }

        public void tryEmit(U u, io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver<T, U> innerObserver) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.downstream.onNext(u);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                io.reactivex.internal.fuseable.SimpleQueue simpleQueue = innerObserver.queue;
                if (simpleQueue == null) {
                    simpleQueue = new io.reactivex.internal.queue.SpscLinkedArrayQueue(this.bufferSize);
                    innerObserver.queue = simpleQueue;
                }
                simpleQueue.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        public boolean tryEmitScalar(java.util.concurrent.Callable<? extends U> callable) {
            try {
                U call = callable.call();
                if (call == null) {
                    return true;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.downstream.onNext(call);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                } else {
                    io.reactivex.internal.fuseable.SimplePlainQueue<U> simplePlainQueue = this.queue;
                    if (simplePlainQueue == null) {
                        simplePlainQueue = this.maxConcurrency == Integer.MAX_VALUE ? new io.reactivex.internal.queue.SpscLinkedArrayQueue<>(this.bufferSize) : new io.reactivex.internal.queue.SpscArrayQueue<>(this.maxConcurrency);
                        this.queue = simplePlainQueue;
                    }
                    if (!simplePlainQueue.offer(call)) {
                        onError(new java.lang.IllegalStateException("Scalar queue full?!"));
                        return true;
                    }
                    if (getAndIncrement() != 0) {
                        return false;
                    }
                }
                drainLoop();
                return true;
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.errors.addThrowable(th);
                drain();
                return true;
            }
        }
    }

    public ObservableFlatMap(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends U>> function, boolean z, int i, int i2) {
        super(observableSource);
        this.n = function;
        this.t = z;
        this.u = i;
        this.v = i2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super U> observer) {
        if (io.reactivex.internal.operators.observable.ObservableScalarXMap.tryScalarXMapSubscribe(this.source, observer, this.n)) {
            return;
        }
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableFlatMap.MergeObserver(observer, this.n, this.t, this.u, this.v));
    }
}
