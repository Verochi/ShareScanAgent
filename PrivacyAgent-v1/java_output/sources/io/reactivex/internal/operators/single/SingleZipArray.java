package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleZipArray<T, R> extends io.reactivex.Single<R> {
    public final io.reactivex.SingleSource<? extends T>[] n;
    public final io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> t;

    public final class SingletonArrayFunc implements io.reactivex.functions.Function<T, R> {
        public SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // io.reactivex.functions.Function
        public R apply(T t) throws java.lang.Exception {
            return (R) io.reactivex.internal.functions.ObjectHelper.requireNonNull(io.reactivex.internal.operators.single.SingleZipArray.this.t.apply(new java.lang.Object[]{t}), "The zipper returned a null value");
        }
    }

    public static final class ZipCoordinator<T, R> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -5556924161382950569L;
        final io.reactivex.SingleObserver<? super R> downstream;
        final io.reactivex.internal.operators.single.SingleZipArray.ZipSingleObserver<T>[] observers;
        final java.lang.Object[] values;
        final io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> zipper;

        public ZipCoordinator(io.reactivex.SingleObserver<? super R> singleObserver, int i, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
            super(i);
            this.downstream = singleObserver;
            this.zipper = function;
            io.reactivex.internal.operators.single.SingleZipArray.ZipSingleObserver<T>[] zipSingleObserverArr = new io.reactivex.internal.operators.single.SingleZipArray.ZipSingleObserver[i];
            for (int i2 = 0; i2 < i; i2++) {
                zipSingleObserverArr[i2] = new io.reactivex.internal.operators.single.SingleZipArray.ZipSingleObserver<>(this, i2);
            }
            this.observers = zipSingleObserverArr;
            this.values = new java.lang.Object[i];
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (io.reactivex.internal.operators.single.SingleZipArray.ZipSingleObserver<T> zipSingleObserver : this.observers) {
                    zipSingleObserver.dispose();
                }
            }
        }

        public void disposeExcept(int i) {
            io.reactivex.internal.operators.single.SingleZipArray.ZipSingleObserver<T>[] zipSingleObserverArr = this.observers;
            int length = zipSingleObserverArr.length;
            for (int i2 = 0; i2 < i; i2++) {
                zipSingleObserverArr[i2].dispose();
            }
            while (true) {
                i++;
                if (i >= length) {
                    return;
                } else {
                    zipSingleObserverArr[i].dispose();
                }
            }
        }

        public void innerError(java.lang.Throwable th, int i) {
            if (getAndSet(0) <= 0) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                disposeExcept(i);
                this.downstream.onError(th);
            }
        }

        public void innerSuccess(T t, int i) {
            this.values[i] = t;
            if (decrementAndGet() == 0) {
                try {
                    this.downstream.onSuccess(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.zipper.apply(this.values), "The zipper returned a null value"));
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    this.downstream.onError(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() <= 0;
        }
    }

    public static final class ZipSingleObserver<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.SingleObserver<T> {
        private static final long serialVersionUID = 3323743579927613702L;
        final int index;
        final io.reactivex.internal.operators.single.SingleZipArray.ZipCoordinator<T, ?> parent;

        public ZipSingleObserver(io.reactivex.internal.operators.single.SingleZipArray.ZipCoordinator<T, ?> zipCoordinator, int i) {
            this.parent = zipCoordinator;
            this.index = i;
        }

        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(java.lang.Throwable th) {
            this.parent.innerError(th, this.index);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.parent.innerSuccess(t, this.index);
        }
    }

    public SingleZipArray(io.reactivex.SingleSource<? extends T>[] singleSourceArr, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
        this.n = singleSourceArr;
        this.t = function;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super R> singleObserver) {
        io.reactivex.SingleSource<? extends T>[] singleSourceArr = this.n;
        int length = singleSourceArr.length;
        if (length == 1) {
            singleSourceArr[0].subscribe(new io.reactivex.internal.operators.single.SingleMap.MapSingleObserver(singleObserver, new io.reactivex.internal.operators.single.SingleZipArray.SingletonArrayFunc()));
            return;
        }
        io.reactivex.internal.operators.single.SingleZipArray.ZipCoordinator zipCoordinator = new io.reactivex.internal.operators.single.SingleZipArray.ZipCoordinator(singleObserver, length, this.t);
        singleObserver.onSubscribe(zipCoordinator);
        for (int i = 0; i < length && !zipCoordinator.isDisposed(); i++) {
            io.reactivex.SingleSource<? extends T> singleSource = singleSourceArr[i];
            if (singleSource == null) {
                zipCoordinator.innerError(new java.lang.NullPointerException("One of the sources is null"), i);
                return;
            }
            singleSource.subscribe(zipCoordinator.observers[i]);
        }
    }
}
