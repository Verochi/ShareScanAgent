package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleOnErrorReturn<T> extends io.reactivex.Single<T> {
    public final io.reactivex.SingleSource<? extends T> n;
    public final io.reactivex.functions.Function<? super java.lang.Throwable, ? extends T> t;
    public final T u;

    public final class OnErrorReturn implements io.reactivex.SingleObserver<T> {
        public final io.reactivex.SingleObserver<? super T> n;

        public OnErrorReturn(io.reactivex.SingleObserver<? super T> singleObserver) {
            this.n = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(java.lang.Throwable th) {
            T apply;
            io.reactivex.internal.operators.single.SingleOnErrorReturn singleOnErrorReturn = io.reactivex.internal.operators.single.SingleOnErrorReturn.this;
            io.reactivex.functions.Function<? super java.lang.Throwable, ? extends T> function = singleOnErrorReturn.t;
            if (function != null) {
                try {
                    apply = function.apply(th);
                } catch (java.lang.Throwable th2) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                    this.n.onError(new io.reactivex.exceptions.CompositeException(th, th2));
                    return;
                }
            } else {
                apply = singleOnErrorReturn.u;
            }
            if (apply != null) {
                this.n.onSuccess(apply);
                return;
            }
            java.lang.NullPointerException nullPointerException = new java.lang.NullPointerException("Value supplied was null");
            nullPointerException.initCause(th);
            this.n.onError(nullPointerException);
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

    public SingleOnErrorReturn(io.reactivex.SingleSource<? extends T> singleSource, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends T> function, T t) {
        this.n = singleSource;
        this.t = function;
        this.u = t;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.single.SingleOnErrorReturn.OnErrorReturn(singleObserver));
    }
}
