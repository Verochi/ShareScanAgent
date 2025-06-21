package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleZipIterable<T, R> extends io.reactivex.Single<R> {
    public final java.lang.Iterable<? extends io.reactivex.SingleSource<? extends T>> n;
    public final io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> t;

    public final class SingletonArrayFunc implements io.reactivex.functions.Function<T, R> {
        public SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // io.reactivex.functions.Function
        public R apply(T t) throws java.lang.Exception {
            return (R) io.reactivex.internal.functions.ObjectHelper.requireNonNull(io.reactivex.internal.operators.single.SingleZipIterable.this.t.apply(new java.lang.Object[]{t}), "The zipper returned a null value");
        }
    }

    public SingleZipIterable(java.lang.Iterable<? extends io.reactivex.SingleSource<? extends T>> iterable, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
        this.n = iterable;
        this.t = function;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super R> singleObserver) {
        io.reactivex.SingleSource[] singleSourceArr = new io.reactivex.SingleSource[8];
        try {
            int i = 0;
            for (io.reactivex.SingleSource<? extends T> singleSource : this.n) {
                if (singleSource == null) {
                    io.reactivex.internal.disposables.EmptyDisposable.error(new java.lang.NullPointerException("One of the sources is null"), singleObserver);
                    return;
                }
                if (i == singleSourceArr.length) {
                    singleSourceArr = (io.reactivex.SingleSource[]) java.util.Arrays.copyOf(singleSourceArr, (i >> 2) + i);
                }
                int i2 = i + 1;
                singleSourceArr[i] = singleSource;
                i = i2;
            }
            if (i == 0) {
                io.reactivex.internal.disposables.EmptyDisposable.error(new java.util.NoSuchElementException(), singleObserver);
                return;
            }
            if (i == 1) {
                singleSourceArr[0].subscribe(new io.reactivex.internal.operators.single.SingleMap.MapSingleObserver(singleObserver, new io.reactivex.internal.operators.single.SingleZipIterable.SingletonArrayFunc()));
                return;
            }
            io.reactivex.internal.operators.single.SingleZipArray.ZipCoordinator zipCoordinator = new io.reactivex.internal.operators.single.SingleZipArray.ZipCoordinator(singleObserver, i, this.t);
            singleObserver.onSubscribe(zipCoordinator);
            for (int i3 = 0; i3 < i && !zipCoordinator.isDisposed(); i3++) {
                singleSourceArr[i3].subscribe(zipCoordinator.observers[i3]);
            }
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, singleObserver);
        }
    }
}
