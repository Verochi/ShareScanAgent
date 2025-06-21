package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableCombineLatest<T, R> extends io.reactivex.Observable<R> {
    public final io.reactivex.ObservableSource<? extends T>[] n;
    public final java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> t;
    public final io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> u;
    public final int v;
    public final boolean w;

    public static final class CombinerObserver<T, R> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.Observer<T> {
        private static final long serialVersionUID = -4823716997131257941L;
        final int index;
        final io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator<T, R> parent;

        public CombinerObserver(io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator<T, R> latestCoordinator, int i) {
            this.parent = latestCoordinator;
            this.index = i;
        }

        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.parent.innerNext(this.index, t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
        }
    }

    public static final class LatestCoordinator<T, R> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        volatile boolean cancelled;
        final io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final io.reactivex.Observer<? super R> downstream;
        final io.reactivex.internal.util.AtomicThrowable errors = new io.reactivex.internal.util.AtomicThrowable();
        java.lang.Object[] latest;
        final io.reactivex.internal.operators.observable.ObservableCombineLatest.CombinerObserver<T, R>[] observers;
        final io.reactivex.internal.queue.SpscLinkedArrayQueue<java.lang.Object[]> queue;

        public LatestCoordinator(io.reactivex.Observer<? super R> observer, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, int i, int i2, boolean z) {
            this.downstream = observer;
            this.combiner = function;
            this.delayError = z;
            this.latest = new java.lang.Object[i];
            io.reactivex.internal.operators.observable.ObservableCombineLatest.CombinerObserver<T, R>[] combinerObserverArr = new io.reactivex.internal.operators.observable.ObservableCombineLatest.CombinerObserver[i];
            for (int i3 = 0; i3 < i; i3++) {
                combinerObserverArr[i3] = new io.reactivex.internal.operators.observable.ObservableCombineLatest.CombinerObserver<>(this, i3);
            }
            this.observers = combinerObserverArr;
            this.queue = new io.reactivex.internal.queue.SpscLinkedArrayQueue<>(i2);
        }

        public void cancelSources() {
            for (io.reactivex.internal.operators.observable.ObservableCombineLatest.CombinerObserver<T, R> combinerObserver : this.observers) {
                combinerObserver.dispose();
            }
        }

        public void clear(io.reactivex.internal.queue.SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            synchronized (this) {
                this.latest = null;
            }
            spscLinkedArrayQueue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelSources();
            if (getAndIncrement() == 0) {
                clear(this.queue);
            }
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.internal.queue.SpscLinkedArrayQueue<java.lang.Object[]> spscLinkedArrayQueue = this.queue;
            io.reactivex.Observer<? super R> observer = this.downstream;
            boolean z = this.delayError;
            int i = 1;
            while (!this.cancelled) {
                if (!z && this.errors.get() != null) {
                    cancelSources();
                    clear(spscLinkedArrayQueue);
                    observer.onError(this.errors.terminate());
                    return;
                }
                boolean z2 = this.done;
                java.lang.Object[] poll = spscLinkedArrayQueue.poll();
                boolean z3 = poll == null;
                if (z2 && z3) {
                    clear(spscLinkedArrayQueue);
                    java.lang.Throwable terminate = this.errors.terminate();
                    if (terminate == null) {
                        observer.onComplete();
                        return;
                    } else {
                        observer.onError(terminate);
                        return;
                    }
                }
                if (z3) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    try {
                        observer.onNext((java.lang.Object) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.combiner.apply(poll), "The combiner returned a null value"));
                    } catch (java.lang.Throwable th) {
                        io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                        this.errors.addThrowable(th);
                        cancelSources();
                        clear(spscLinkedArrayQueue);
                        observer.onError(this.errors.terminate());
                        return;
                    }
                }
            }
            clear(spscLinkedArrayQueue);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0017, code lost:
        
            if (r2 == r0.length) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void innerComplete(int i) {
            synchronized (this) {
                java.lang.Object[] objArr = this.latest;
                if (objArr == null) {
                    return;
                }
                boolean z = objArr[i] == null;
                if (!z) {
                    int i2 = this.complete + 1;
                    this.complete = i2;
                }
                this.done = true;
                if (z) {
                    cancelSources();
                }
                drain();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
        
            if (r1 == r4.length) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void innerError(int i, java.lang.Throwable th) {
            if (!this.errors.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            boolean z = true;
            if (this.delayError) {
                synchronized (this) {
                    java.lang.Object[] objArr = this.latest;
                    if (objArr == null) {
                        return;
                    }
                    boolean z2 = objArr[i] == null;
                    if (!z2) {
                        int i2 = this.complete + 1;
                        this.complete = i2;
                    }
                    this.done = true;
                    z = z2;
                }
            }
            if (z) {
                cancelSources();
            }
            drain();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void innerNext(int i, T t) {
            boolean z;
            synchronized (this) {
                java.lang.Object[] objArr = this.latest;
                if (objArr == null) {
                    return;
                }
                java.lang.Object obj = objArr[i];
                int i2 = this.active;
                if (obj == null) {
                    i2++;
                    this.active = i2;
                }
                objArr[i] = t;
                if (i2 == objArr.length) {
                    this.queue.offer(objArr.clone());
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    drain();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void subscribe(io.reactivex.ObservableSource<? extends T>[] observableSourceArr) {
            io.reactivex.internal.operators.observable.ObservableCombineLatest.CombinerObserver<T, R>[] combinerObserverArr = this.observers;
            int length = combinerObserverArr.length;
            this.downstream.onSubscribe(this);
            for (int i = 0; i < length && !this.done && !this.cancelled; i++) {
                observableSourceArr[i].subscribe(combinerObserverArr[i]);
            }
        }
    }

    public ObservableCombineLatest(io.reactivex.ObservableSource<? extends T>[] observableSourceArr, java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> iterable, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, int i, boolean z) {
        this.n = observableSourceArr;
        this.t = iterable;
        this.u = function;
        this.v = i;
        this.w = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super R> observer) {
        int length;
        io.reactivex.ObservableSource<? extends T>[] observableSourceArr = this.n;
        if (observableSourceArr == null) {
            observableSourceArr = new io.reactivex.ObservableSource[8];
            length = 0;
            for (io.reactivex.ObservableSource<? extends T> observableSource : this.t) {
                if (length == observableSourceArr.length) {
                    io.reactivex.ObservableSource<? extends T>[] observableSourceArr2 = new io.reactivex.ObservableSource[(length >> 2) + length];
                    java.lang.System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                    observableSourceArr = observableSourceArr2;
                }
                observableSourceArr[length] = observableSource;
                length++;
            }
        } else {
            length = observableSourceArr.length;
        }
        int i = length;
        if (i == 0) {
            io.reactivex.internal.disposables.EmptyDisposable.complete(observer);
        } else {
            new io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator(observer, this.u, i, this.v, this.w).subscribe(observableSourceArr);
        }
    }
}
