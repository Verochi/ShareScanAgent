package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleContains<T> extends io.reactivex.Single<java.lang.Boolean> {
    public final io.reactivex.SingleSource<T> n;
    public final java.lang.Object t;
    public final io.reactivex.functions.BiPredicate<java.lang.Object, java.lang.Object> u;

    public final class ContainsSingleObserver implements io.reactivex.SingleObserver<T> {
        public final io.reactivex.SingleObserver<? super java.lang.Boolean> n;

        public ContainsSingleObserver(io.reactivex.SingleObserver<? super java.lang.Boolean> singleObserver) {
            this.n = singleObserver;
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
                io.reactivex.internal.operators.single.SingleContains singleContains = io.reactivex.internal.operators.single.SingleContains.this;
                this.n.onSuccess(java.lang.Boolean.valueOf(singleContains.u.test(t, singleContains.t)));
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.n.onError(th);
            }
        }
    }

    public SingleContains(io.reactivex.SingleSource<T> singleSource, java.lang.Object obj, io.reactivex.functions.BiPredicate<java.lang.Object, java.lang.Object> biPredicate) {
        this.n = singleSource;
        this.t = obj;
        this.u = biPredicate;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super java.lang.Boolean> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.single.SingleContains.ContainsSingleObserver(singleObserver));
    }
}
