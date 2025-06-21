package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableSwitchIfEmpty<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final io.reactivex.ObservableSource<? extends T> n;

    public static final class SwitchIfEmptyObserver<T> implements io.reactivex.Observer<T> {
        public final io.reactivex.Observer<? super T> n;
        public final io.reactivex.ObservableSource<? extends T> t;
        public boolean v = true;
        public final io.reactivex.internal.disposables.SequentialDisposable u = new io.reactivex.internal.disposables.SequentialDisposable();

        public SwitchIfEmptyObserver(io.reactivex.Observer<? super T> observer, io.reactivex.ObservableSource<? extends T> observableSource) {
            this.n = observer;
            this.t = observableSource;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.v) {
                this.n.onComplete();
            } else {
                this.v = false;
                this.t.subscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.n.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.v) {
                this.v = false;
            }
            this.n.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.u.update(disposable);
        }
    }

    public ObservableSwitchIfEmpty(io.reactivex.ObservableSource<T> observableSource, io.reactivex.ObservableSource<? extends T> observableSource2) {
        super(observableSource);
        this.n = observableSource2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.internal.operators.observable.ObservableSwitchIfEmpty.SwitchIfEmptyObserver switchIfEmptyObserver = new io.reactivex.internal.operators.observable.ObservableSwitchIfEmpty.SwitchIfEmptyObserver(observer, this.n);
        observer.onSubscribe(switchIfEmptyObserver.u);
        this.source.subscribe(switchIfEmptyObserver);
    }
}
