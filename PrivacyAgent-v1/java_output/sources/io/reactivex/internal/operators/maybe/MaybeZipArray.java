package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeZipArray<T, R> extends io.reactivex.Maybe<R> {
    public final io.reactivex.MaybeSource<? extends T>[] n;
    public final io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> t;

    public final class SingletonArrayFunc implements io.reactivex.functions.Function<T, R> {
        public SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // io.reactivex.functions.Function
        public R apply(T t) throws java.lang.Exception {
            return (R) io.reactivex.internal.functions.ObjectHelper.requireNonNull(io.reactivex.internal.operators.maybe.MaybeZipArray.this.t.apply(new java.lang.Object[]{t}), "The zipper returned a null value");
        }
    }

    public static final class ZipCoordinator<T, R> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -5556924161382950569L;
        final io.reactivex.MaybeObserver<? super R> downstream;
        final io.reactivex.internal.operators.maybe.MaybeZipArray.ZipMaybeObserver<T>[] observers;
        final java.lang.Object[] values;
        final io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> zipper;

        public ZipCoordinator(io.reactivex.MaybeObserver<? super R> maybeObserver, int i, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
            super(i);
            this.downstream = maybeObserver;
            this.zipper = function;
            io.reactivex.internal.operators.maybe.MaybeZipArray.ZipMaybeObserver<T>[] zipMaybeObserverArr = new io.reactivex.internal.operators.maybe.MaybeZipArray.ZipMaybeObserver[i];
            for (int i2 = 0; i2 < i; i2++) {
                zipMaybeObserverArr[i2] = new io.reactivex.internal.operators.maybe.MaybeZipArray.ZipMaybeObserver<>(this, i2);
            }
            this.observers = zipMaybeObserverArr;
            this.values = new java.lang.Object[i];
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (io.reactivex.internal.operators.maybe.MaybeZipArray.ZipMaybeObserver<T> zipMaybeObserver : this.observers) {
                    zipMaybeObserver.dispose();
                }
            }
        }

        public void disposeExcept(int i) {
            io.reactivex.internal.operators.maybe.MaybeZipArray.ZipMaybeObserver<T>[] zipMaybeObserverArr = this.observers;
            int length = zipMaybeObserverArr.length;
            for (int i2 = 0; i2 < i; i2++) {
                zipMaybeObserverArr[i2].dispose();
            }
            while (true) {
                i++;
                if (i >= length) {
                    return;
                } else {
                    zipMaybeObserverArr[i].dispose();
                }
            }
        }

        public void innerComplete(int i) {
            if (getAndSet(0) > 0) {
                disposeExcept(i);
                this.downstream.onComplete();
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

    public static final class ZipMaybeObserver<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.MaybeObserver<T> {
        private static final long serialVersionUID = 3323743579927613702L;
        final int index;
        final io.reactivex.internal.operators.maybe.MaybeZipArray.ZipCoordinator<T, ?> parent;

        public ZipMaybeObserver(io.reactivex.internal.operators.maybe.MaybeZipArray.ZipCoordinator<T, ?> zipCoordinator, int i) {
            this.parent = zipCoordinator;
            this.index = i;
        }

        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
            this.parent.innerError(th, this.index);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.parent.innerSuccess(t, this.index);
        }
    }

    public MaybeZipArray(io.reactivex.MaybeSource<? extends T>[] maybeSourceArr, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
        this.n = maybeSourceArr;
        this.t = function;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super R> maybeObserver) {
        io.reactivex.MaybeSource<? extends T>[] maybeSourceArr = this.n;
        int length = maybeSourceArr.length;
        if (length == 1) {
            maybeSourceArr[0].subscribe(new io.reactivex.internal.operators.maybe.MaybeMap.MapMaybeObserver(maybeObserver, new io.reactivex.internal.operators.maybe.MaybeZipArray.SingletonArrayFunc()));
            return;
        }
        io.reactivex.internal.operators.maybe.MaybeZipArray.ZipCoordinator zipCoordinator = new io.reactivex.internal.operators.maybe.MaybeZipArray.ZipCoordinator(maybeObserver, length, this.t);
        maybeObserver.onSubscribe(zipCoordinator);
        for (int i = 0; i < length && !zipCoordinator.isDisposed(); i++) {
            io.reactivex.MaybeSource<? extends T> maybeSource = maybeSourceArr[i];
            if (maybeSource == null) {
                zipCoordinator.innerError(new java.lang.NullPointerException("One of the sources is null"), i);
                return;
            }
            maybeSource.subscribe(zipCoordinator.observers[i]);
        }
    }
}
