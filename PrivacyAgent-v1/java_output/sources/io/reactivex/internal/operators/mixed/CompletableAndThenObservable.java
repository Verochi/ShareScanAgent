package io.reactivex.internal.operators.mixed;

/* loaded from: classes11.dex */
public final class CompletableAndThenObservable<R> extends io.reactivex.Observable<R> {
    public final io.reactivex.CompletableSource n;
    public final io.reactivex.ObservableSource<? extends R> t;

    public static final class AndThenObservableObserver<R> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.Observer<R>, io.reactivex.CompletableObserver, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -8948264376121066672L;
        final io.reactivex.Observer<? super R> downstream;
        io.reactivex.ObservableSource<? extends R> other;

        public AndThenObservableObserver(io.reactivex.Observer<? super R> observer, io.reactivex.ObservableSource<? extends R> observableSource) {
            this.other = observableSource;
            this.downstream = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            io.reactivex.ObservableSource<? extends R> observableSource = this.other;
            if (observableSource == null) {
                this.downstream.onComplete();
            } else {
                this.other = null;
                observableSource.subscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.replace(this, disposable);
        }
    }

    public CompletableAndThenObservable(io.reactivex.CompletableSource completableSource, io.reactivex.ObservableSource<? extends R> observableSource) {
        this.n = completableSource;
        this.t = observableSource;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super R> observer) {
        io.reactivex.internal.operators.mixed.CompletableAndThenObservable.AndThenObservableObserver andThenObservableObserver = new io.reactivex.internal.operators.mixed.CompletableAndThenObservable.AndThenObservableObserver(observer, this.t);
        observer.onSubscribe(andThenObservableObserver);
        this.n.subscribe(andThenObservableObserver);
    }
}
