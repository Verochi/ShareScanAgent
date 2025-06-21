package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableWithLatestFromMany<T, R> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, R> {

    @io.reactivex.annotations.Nullable
    public final io.reactivex.ObservableSource<?>[] n;

    @io.reactivex.annotations.Nullable
    public final java.lang.Iterable<? extends io.reactivex.ObservableSource<?>> t;

    @io.reactivex.annotations.NonNull
    public final io.reactivex.functions.Function<? super java.lang.Object[], R> u;

    public final class SingletonArrayFunc implements io.reactivex.functions.Function<T, R> {
        public SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // io.reactivex.functions.Function
        public R apply(T t) throws java.lang.Exception {
            return (R) io.reactivex.internal.functions.ObjectHelper.requireNonNull(io.reactivex.internal.operators.observable.ObservableWithLatestFromMany.this.u.apply(new java.lang.Object[]{t}), "The combiner returned a null value");
        }
    }

    public static final class WithLatestFromObserver<T, R> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 1577321883966341961L;
        final io.reactivex.functions.Function<? super java.lang.Object[], R> combiner;
        volatile boolean done;
        final io.reactivex.Observer<? super R> downstream;
        final io.reactivex.internal.util.AtomicThrowable error;
        final io.reactivex.internal.operators.observable.ObservableWithLatestFromMany.WithLatestInnerObserver[] observers;
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> upstream;
        final java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> values;

        public WithLatestFromObserver(io.reactivex.Observer<? super R> observer, io.reactivex.functions.Function<? super java.lang.Object[], R> function, int i) {
            this.downstream = observer;
            this.combiner = function;
            io.reactivex.internal.operators.observable.ObservableWithLatestFromMany.WithLatestInnerObserver[] withLatestInnerObserverArr = new io.reactivex.internal.operators.observable.ObservableWithLatestFromMany.WithLatestInnerObserver[i];
            for (int i2 = 0; i2 < i; i2++) {
                withLatestInnerObserverArr[i2] = new io.reactivex.internal.operators.observable.ObservableWithLatestFromMany.WithLatestInnerObserver(this, i2);
            }
            this.observers = withLatestInnerObserverArr;
            this.values = new java.util.concurrent.atomic.AtomicReferenceArray<>(i);
            this.upstream = new java.util.concurrent.atomic.AtomicReference<>();
            this.error = new io.reactivex.internal.util.AtomicThrowable();
        }

        public void cancelAllBut(int i) {
            io.reactivex.internal.operators.observable.ObservableWithLatestFromMany.WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
            for (int i2 = 0; i2 < withLatestInnerObserverArr.length; i2++) {
                if (i2 != i) {
                    withLatestInnerObserverArr[i2].dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.upstream);
            for (io.reactivex.internal.operators.observable.ObservableWithLatestFromMany.WithLatestInnerObserver withLatestInnerObserver : this.observers) {
                withLatestInnerObserver.dispose();
            }
        }

        public void innerComplete(int i, boolean z) {
            if (z) {
                return;
            }
            this.done = true;
            cancelAllBut(i);
            io.reactivex.internal.util.HalfSerializer.onComplete(this.downstream, this, this.error);
        }

        public void innerError(int i, java.lang.Throwable th) {
            this.done = true;
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.upstream);
            cancelAllBut(i);
            io.reactivex.internal.util.HalfSerializer.onError(this.downstream, th, this, this.error);
        }

        public void innerNext(int i, java.lang.Object obj) {
            this.values.set(i, obj);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            io.reactivex.internal.util.HalfSerializer.onComplete(this.downstream, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.done) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            io.reactivex.internal.util.HalfSerializer.onError(this.downstream, th, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            java.lang.Object[] objArr = new java.lang.Object[length + 1];
            int i = 0;
            objArr[0] = t;
            while (i < length) {
                java.lang.Object obj = atomicReferenceArray.get(i);
                if (obj == null) {
                    return;
                }
                i++;
                objArr[i] = obj;
            }
            try {
                io.reactivex.internal.util.HalfSerializer.onNext(this.downstream, io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.combiner.apply(objArr), "combiner returned a null value"), this, this.error);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this.upstream, disposable);
        }

        public void subscribe(io.reactivex.ObservableSource<?>[] observableSourceArr, int i) {
            io.reactivex.internal.operators.observable.ObservableWithLatestFromMany.WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
            java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> atomicReference = this.upstream;
            for (int i2 = 0; i2 < i && !io.reactivex.internal.disposables.DisposableHelper.isDisposed(atomicReference.get()) && !this.done; i2++) {
                observableSourceArr[i2].subscribe(withLatestInnerObserverArr[i2]);
            }
        }
    }

    public static final class WithLatestInnerObserver extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.Observer<java.lang.Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final io.reactivex.internal.operators.observable.ObservableWithLatestFromMany.WithLatestFromObserver<?, ?> parent;

        public WithLatestInnerObserver(io.reactivex.internal.operators.observable.ObservableWithLatestFromMany.WithLatestFromObserver<?, ?> withLatestFromObserver, int i) {
            this.parent = withLatestFromObserver;
            this.index = i;
        }

        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // io.reactivex.Observer
        public void onNext(java.lang.Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.innerNext(this.index, obj);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableWithLatestFromMany(@io.reactivex.annotations.NonNull io.reactivex.ObservableSource<T> observableSource, @io.reactivex.annotations.NonNull java.lang.Iterable<? extends io.reactivex.ObservableSource<?>> iterable, @io.reactivex.annotations.NonNull io.reactivex.functions.Function<? super java.lang.Object[], R> function) {
        super(observableSource);
        this.n = null;
        this.t = iterable;
        this.u = function;
    }

    public ObservableWithLatestFromMany(@io.reactivex.annotations.NonNull io.reactivex.ObservableSource<T> observableSource, @io.reactivex.annotations.NonNull io.reactivex.ObservableSource<?>[] observableSourceArr, @io.reactivex.annotations.NonNull io.reactivex.functions.Function<? super java.lang.Object[], R> function) {
        super(observableSource);
        this.n = observableSourceArr;
        this.t = null;
        this.u = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super R> observer) {
        int length;
        io.reactivex.ObservableSource<?>[] observableSourceArr = this.n;
        if (observableSourceArr == null) {
            observableSourceArr = new io.reactivex.ObservableSource[8];
            try {
                length = 0;
                for (io.reactivex.ObservableSource<?> observableSource : this.t) {
                    if (length == observableSourceArr.length) {
                        observableSourceArr = (io.reactivex.ObservableSource[]) java.util.Arrays.copyOf(observableSourceArr, (length >> 1) + length);
                    }
                    int i = length + 1;
                    observableSourceArr[length] = observableSource;
                    length = i;
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.internal.disposables.EmptyDisposable.error(th, observer);
                return;
            }
        } else {
            length = observableSourceArr.length;
        }
        if (length == 0) {
            new io.reactivex.internal.operators.observable.ObservableMap(this.source, new io.reactivex.internal.operators.observable.ObservableWithLatestFromMany.SingletonArrayFunc()).subscribeActual(observer);
            return;
        }
        io.reactivex.internal.operators.observable.ObservableWithLatestFromMany.WithLatestFromObserver withLatestFromObserver = new io.reactivex.internal.operators.observable.ObservableWithLatestFromMany.WithLatestFromObserver(observer, this.u, length);
        observer.onSubscribe(withLatestFromObserver);
        withLatestFromObserver.subscribe(observableSourceArr, length);
        this.source.subscribe(withLatestFromObserver);
    }
}
