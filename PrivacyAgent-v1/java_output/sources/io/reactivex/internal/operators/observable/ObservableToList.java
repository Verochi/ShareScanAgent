package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableToList<T, U extends java.util.Collection<? super T>> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, U> {
    public final java.util.concurrent.Callable<U> n;

    public static final class ToListObserver<T, U extends java.util.Collection<? super T>> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super U> n;
        public io.reactivex.disposables.Disposable t;
        public U u;

        public ToListObserver(io.reactivex.Observer<? super U> observer, U u) {
            this.n = observer;
            this.u = u;
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
            U u = this.u;
            this.u = null;
            this.n.onNext(u);
            this.n.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.u = null;
            this.n.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.u.add(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.t, disposable)) {
                this.t = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableToList(io.reactivex.ObservableSource<T> observableSource, int i) {
        super(observableSource);
        this.n = io.reactivex.internal.functions.Functions.createArrayList(i);
    }

    public ObservableToList(io.reactivex.ObservableSource<T> observableSource, java.util.concurrent.Callable<U> callable) {
        super(observableSource);
        this.n = callable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super U> observer) {
        try {
            this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableToList.ToListObserver(observer, (java.util.Collection) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, observer);
        }
    }
}
