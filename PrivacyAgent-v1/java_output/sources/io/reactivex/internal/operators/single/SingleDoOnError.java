package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleDoOnError<T> extends io.reactivex.Single<T> {
    public final io.reactivex.SingleSource<T> n;
    public final io.reactivex.functions.Consumer<? super java.lang.Throwable> t;

    public final class DoOnError implements io.reactivex.SingleObserver<T> {
        public final io.reactivex.SingleObserver<? super T> n;

        public DoOnError(io.reactivex.SingleObserver<? super T> singleObserver) {
            this.n = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(java.lang.Throwable th) {
            try {
                io.reactivex.internal.operators.single.SingleDoOnError.this.t.accept(th);
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                th = new io.reactivex.exceptions.CompositeException(th, th2);
            }
            this.n.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.n.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.n.onSuccess(t);
        }
    }

    public SingleDoOnError(io.reactivex.SingleSource<T> singleSource, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer) {
        this.n = singleSource;
        this.t = consumer;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.single.SingleDoOnError.DoOnError(singleObserver));
    }
}
