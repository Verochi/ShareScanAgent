package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleMap<T, R> extends io.reactivex.Single<R> {
    public final io.reactivex.SingleSource<? extends T> n;
    public final io.reactivex.functions.Function<? super T, ? extends R> t;

    public static final class MapSingleObserver<T, R> implements io.reactivex.SingleObserver<T> {
        public final io.reactivex.SingleObserver<? super R> n;
        public final io.reactivex.functions.Function<? super T, ? extends R> t;

        public MapSingleObserver(io.reactivex.SingleObserver<? super R> singleObserver, io.reactivex.functions.Function<? super T, ? extends R> function) {
            this.n = singleObserver;
            this.t = function;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(java.lang.Throwable th) {
            this.n.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.n.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            try {
                this.n.onSuccess(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(t), "The mapper function returned a null value."));
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                onError(th);
            }
        }
    }

    public SingleMap(io.reactivex.SingleSource<? extends T> singleSource, io.reactivex.functions.Function<? super T, ? extends R> function) {
        this.n = singleSource;
        this.t = function;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super R> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.single.SingleMap.MapSingleObserver(singleObserver, this.t));
    }
}
