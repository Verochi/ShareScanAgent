package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableToSingle<T> extends io.reactivex.Single<T> {
    public final io.reactivex.CompletableSource n;
    public final java.util.concurrent.Callable<? extends T> t;
    public final T u;

    public final class ToSingle implements io.reactivex.CompletableObserver {
        public final io.reactivex.SingleObserver<? super T> n;

        public ToSingle(io.reactivex.SingleObserver<? super T> singleObserver) {
            this.n = singleObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            T call;
            io.reactivex.internal.operators.completable.CompletableToSingle completableToSingle = io.reactivex.internal.operators.completable.CompletableToSingle.this;
            java.util.concurrent.Callable<? extends T> callable = completableToSingle.t;
            if (callable != null) {
                try {
                    call = callable.call();
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    this.n.onError(th);
                    return;
                }
            } else {
                call = completableToSingle.u;
            }
            if (call == null) {
                this.n.onError(new java.lang.NullPointerException("The value supplied is null"));
            } else {
                this.n.onSuccess(call);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
            this.n.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.n.onSubscribe(disposable);
        }
    }

    public CompletableToSingle(io.reactivex.CompletableSource completableSource, java.util.concurrent.Callable<? extends T> callable, T t) {
        this.n = completableSource;
        this.u = t;
        this.t = callable;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.completable.CompletableToSingle.ToSingle(singleObserver));
    }
}
