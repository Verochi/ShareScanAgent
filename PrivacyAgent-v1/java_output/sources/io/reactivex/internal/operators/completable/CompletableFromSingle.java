package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableFromSingle<T> extends io.reactivex.Completable {
    public final io.reactivex.SingleSource<T> n;

    public static final class CompletableFromSingleObserver<T> implements io.reactivex.SingleObserver<T> {
        public final io.reactivex.CompletableObserver n;

        public CompletableFromSingleObserver(io.reactivex.CompletableObserver completableObserver) {
            this.n = completableObserver;
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
            this.n.onComplete();
        }
    }

    public CompletableFromSingle(io.reactivex.SingleSource<T> singleSource) {
        this.n = singleSource;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.completable.CompletableFromSingle.CompletableFromSingleObserver(completableObserver));
    }
}
