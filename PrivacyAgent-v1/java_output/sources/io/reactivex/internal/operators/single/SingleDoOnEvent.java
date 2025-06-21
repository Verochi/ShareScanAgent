package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleDoOnEvent<T> extends io.reactivex.Single<T> {
    public final io.reactivex.SingleSource<T> n;
    public final io.reactivex.functions.BiConsumer<? super T, ? super java.lang.Throwable> t;

    public final class DoOnEvent implements io.reactivex.SingleObserver<T> {
        public final io.reactivex.SingleObserver<? super T> n;

        public DoOnEvent(io.reactivex.SingleObserver<? super T> singleObserver) {
            this.n = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(java.lang.Throwable th) {
            try {
                io.reactivex.internal.operators.single.SingleDoOnEvent.this.t.accept(null, th);
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
            try {
                io.reactivex.internal.operators.single.SingleDoOnEvent.this.t.accept(t, null);
                this.n.onSuccess(t);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.n.onError(th);
            }
        }
    }

    public SingleDoOnEvent(io.reactivex.SingleSource<T> singleSource, io.reactivex.functions.BiConsumer<? super T, ? super java.lang.Throwable> biConsumer) {
        this.n = singleSource;
        this.t = biConsumer;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.single.SingleDoOnEvent.DoOnEvent(singleObserver));
    }
}
