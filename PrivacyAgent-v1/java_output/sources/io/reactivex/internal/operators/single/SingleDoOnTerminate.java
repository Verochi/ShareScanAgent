package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleDoOnTerminate<T> extends io.reactivex.Single<T> {
    public final io.reactivex.SingleSource<T> n;
    public final io.reactivex.functions.Action t;

    public final class DoOnTerminate implements io.reactivex.SingleObserver<T> {
        public final io.reactivex.SingleObserver<? super T> n;

        public DoOnTerminate(io.reactivex.SingleObserver<? super T> singleObserver) {
            this.n = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(java.lang.Throwable th) {
            try {
                io.reactivex.internal.operators.single.SingleDoOnTerminate.this.t.run();
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
                io.reactivex.internal.operators.single.SingleDoOnTerminate.this.t.run();
                this.n.onSuccess(t);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.n.onError(th);
            }
        }
    }

    public SingleDoOnTerminate(io.reactivex.SingleSource<T> singleSource, io.reactivex.functions.Action action) {
        this.n = singleSource;
        this.t = action;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.single.SingleDoOnTerminate.DoOnTerminate(singleObserver));
    }
}
