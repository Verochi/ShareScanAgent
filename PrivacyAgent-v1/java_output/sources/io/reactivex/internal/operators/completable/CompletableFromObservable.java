package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableFromObservable<T> extends io.reactivex.Completable {
    public final io.reactivex.ObservableSource<T> n;

    public static final class CompletableFromObservableObserver<T> implements io.reactivex.Observer<T> {
        public final io.reactivex.CompletableObserver n;

        public CompletableFromObservableObserver(io.reactivex.CompletableObserver completableObserver) {
            this.n = completableObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.n.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.n.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.n.onSubscribe(disposable);
        }
    }

    public CompletableFromObservable(io.reactivex.ObservableSource<T> observableSource) {
        this.n = observableSource;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.completable.CompletableFromObservable.CompletableFromObservableObserver(completableObserver));
    }
}
