package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeZipIterable<T, R> extends io.reactivex.Maybe<R> {
    public final java.lang.Iterable<? extends io.reactivex.MaybeSource<? extends T>> n;
    public final io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> t;

    public final class SingletonArrayFunc implements io.reactivex.functions.Function<T, R> {
        public SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // io.reactivex.functions.Function
        public R apply(T t) throws java.lang.Exception {
            return (R) io.reactivex.internal.functions.ObjectHelper.requireNonNull(io.reactivex.internal.operators.maybe.MaybeZipIterable.this.t.apply(new java.lang.Object[]{t}), "The zipper returned a null value");
        }
    }

    public MaybeZipIterable(java.lang.Iterable<? extends io.reactivex.MaybeSource<? extends T>> iterable, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
        this.n = iterable;
        this.t = function;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super R> maybeObserver) {
        io.reactivex.MaybeSource[] maybeSourceArr = new io.reactivex.MaybeSource[8];
        try {
            int i = 0;
            for (io.reactivex.MaybeSource<? extends T> maybeSource : this.n) {
                if (maybeSource == null) {
                    io.reactivex.internal.disposables.EmptyDisposable.error(new java.lang.NullPointerException("One of the sources is null"), maybeObserver);
                    return;
                }
                if (i == maybeSourceArr.length) {
                    maybeSourceArr = (io.reactivex.MaybeSource[]) java.util.Arrays.copyOf(maybeSourceArr, (i >> 2) + i);
                }
                int i2 = i + 1;
                maybeSourceArr[i] = maybeSource;
                i = i2;
            }
            if (i == 0) {
                io.reactivex.internal.disposables.EmptyDisposable.complete(maybeObserver);
                return;
            }
            if (i == 1) {
                maybeSourceArr[0].subscribe(new io.reactivex.internal.operators.maybe.MaybeMap.MapMaybeObserver(maybeObserver, new io.reactivex.internal.operators.maybe.MaybeZipIterable.SingletonArrayFunc()));
                return;
            }
            io.reactivex.internal.operators.maybe.MaybeZipArray.ZipCoordinator zipCoordinator = new io.reactivex.internal.operators.maybe.MaybeZipArray.ZipCoordinator(maybeObserver, i, this.t);
            maybeObserver.onSubscribe(zipCoordinator);
            for (int i3 = 0; i3 < i && !zipCoordinator.isDisposed(); i3++) {
                maybeSourceArr[i3].subscribe(zipCoordinator.observers[i3]);
            }
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, maybeObserver);
        }
    }
}
