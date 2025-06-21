package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableSkipUntil<T, U> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final io.reactivex.ObservableSource<U> n;

    public final class SkipUntil implements io.reactivex.Observer<U> {
        public final io.reactivex.internal.disposables.ArrayCompositeDisposable n;
        public final io.reactivex.internal.operators.observable.ObservableSkipUntil.SkipUntilObserver<T> t;
        public final io.reactivex.observers.SerializedObserver<T> u;
        public io.reactivex.disposables.Disposable v;

        public SkipUntil(io.reactivex.internal.disposables.ArrayCompositeDisposable arrayCompositeDisposable, io.reactivex.internal.operators.observable.ObservableSkipUntil.SkipUntilObserver<T> skipUntilObserver, io.reactivex.observers.SerializedObserver<T> serializedObserver) {
            this.n = arrayCompositeDisposable;
            this.t = skipUntilObserver;
            this.u = serializedObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.t.v = true;
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.n.dispose();
            this.u.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(U u) {
            this.v.dispose();
            this.t.v = true;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.v, disposable)) {
                this.v = disposable;
                this.n.setResource(1, disposable);
            }
        }
    }

    public static final class SkipUntilObserver<T> implements io.reactivex.Observer<T> {
        public final io.reactivex.Observer<? super T> n;
        public final io.reactivex.internal.disposables.ArrayCompositeDisposable t;
        public io.reactivex.disposables.Disposable u;
        public volatile boolean v;
        public boolean w;

        public SkipUntilObserver(io.reactivex.Observer<? super T> observer, io.reactivex.internal.disposables.ArrayCompositeDisposable arrayCompositeDisposable) {
            this.n = observer;
            this.t = arrayCompositeDisposable;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.t.dispose();
            this.n.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.t.dispose();
            this.n.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.w) {
                this.n.onNext(t);
            } else if (this.v) {
                this.w = true;
                this.n.onNext(t);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.u, disposable)) {
                this.u = disposable;
                this.t.setResource(0, disposable);
            }
        }
    }

    public ObservableSkipUntil(io.reactivex.ObservableSource<T> observableSource, io.reactivex.ObservableSource<U> observableSource2) {
        super(observableSource);
        this.n = observableSource2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.observers.SerializedObserver serializedObserver = new io.reactivex.observers.SerializedObserver(observer);
        io.reactivex.internal.disposables.ArrayCompositeDisposable arrayCompositeDisposable = new io.reactivex.internal.disposables.ArrayCompositeDisposable(2);
        serializedObserver.onSubscribe(arrayCompositeDisposable);
        io.reactivex.internal.operators.observable.ObservableSkipUntil.SkipUntilObserver skipUntilObserver = new io.reactivex.internal.operators.observable.ObservableSkipUntil.SkipUntilObserver(serializedObserver, arrayCompositeDisposable);
        this.n.subscribe(new io.reactivex.internal.operators.observable.ObservableSkipUntil.SkipUntil(arrayCompositeDisposable, skipUntilObserver, serializedObserver));
        this.source.subscribe(skipUntilObserver);
    }
}
