package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableDelaySubscriptionOther<T, U> extends io.reactivex.Observable<T> {
    public final io.reactivex.ObservableSource<? extends T> n;
    public final io.reactivex.ObservableSource<U> t;

    public final class DelayObserver implements io.reactivex.Observer<U> {
        public final io.reactivex.internal.disposables.SequentialDisposable n;
        public final io.reactivex.Observer<? super T> t;
        public boolean u;

        public final class OnComplete implements io.reactivex.Observer<T> {
            public OnComplete() {
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther.DelayObserver.this.t.onComplete();
            }

            @Override // io.reactivex.Observer
            public void onError(java.lang.Throwable th) {
                io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther.DelayObserver.this.t.onError(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(T t) {
                io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther.DelayObserver.this.t.onNext(t);
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
                io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther.DelayObserver.this.n.update(disposable);
            }
        }

        public DelayObserver(io.reactivex.internal.disposables.SequentialDisposable sequentialDisposable, io.reactivex.Observer<? super T> observer) {
            this.n = sequentialDisposable;
            this.t = observer;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.u) {
                return;
            }
            this.u = true;
            io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther.this.n.subscribe(new io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther.DelayObserver.OnComplete());
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.u) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.u = true;
                this.t.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(U u) {
            onComplete();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.n.update(disposable);
        }
    }

    public ObservableDelaySubscriptionOther(io.reactivex.ObservableSource<? extends T> observableSource, io.reactivex.ObservableSource<U> observableSource2) {
        this.n = observableSource;
        this.t = observableSource2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.internal.disposables.SequentialDisposable sequentialDisposable = new io.reactivex.internal.disposables.SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        this.t.subscribe(new io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther.DelayObserver(sequentialDisposable, observer));
    }
}
