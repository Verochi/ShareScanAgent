package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableIgnoreElementsCompletable<T> extends io.reactivex.Completable implements io.reactivex.internal.fuseable.FuseToObservable<T> {
    public final io.reactivex.ObservableSource<T> n;

    public static final class IgnoreObservable<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.CompletableObserver n;
        public io.reactivex.disposables.Disposable t;

        public IgnoreObservable(io.reactivex.CompletableObserver completableObserver) {
            this.n = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.t.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.t.isDisposed();
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
            this.t = disposable;
            this.n.onSubscribe(this);
        }
    }

    public ObservableIgnoreElementsCompletable(io.reactivex.ObservableSource<T> observableSource) {
        this.n = observableSource;
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public io.reactivex.Observable<T> fuseToObservable() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableIgnoreElements(this.n));
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable.IgnoreObservable(completableObserver));
    }
}
