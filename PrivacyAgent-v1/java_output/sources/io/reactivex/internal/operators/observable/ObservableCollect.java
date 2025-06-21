package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableCollect<T, U> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, U> {
    public final java.util.concurrent.Callable<? extends U> n;
    public final io.reactivex.functions.BiConsumer<? super U, ? super T> t;

    public static final class CollectObserver<T, U> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super U> n;
        public final io.reactivex.functions.BiConsumer<? super U, ? super T> t;
        public final U u;
        public io.reactivex.disposables.Disposable v;
        public boolean w;

        public CollectObserver(io.reactivex.Observer<? super U> observer, U u, io.reactivex.functions.BiConsumer<? super U, ? super T> biConsumer) {
            this.n = observer;
            this.t = biConsumer;
            this.u = u;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.v.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.v.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.w) {
                return;
            }
            this.w = true;
            this.n.onNext(this.u);
            this.n.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.w) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.w = true;
                this.n.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.w) {
                return;
            }
            try {
                this.t.accept(this.u, t);
            } catch (java.lang.Throwable th) {
                this.v.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.v, disposable)) {
                this.v = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableCollect(io.reactivex.ObservableSource<T> observableSource, java.util.concurrent.Callable<? extends U> callable, io.reactivex.functions.BiConsumer<? super U, ? super T> biConsumer) {
        super(observableSource);
        this.n = callable;
        this.t = biConsumer;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super U> observer) {
        try {
            this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableCollect.CollectObserver(observer, io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.call(), "The initialSupplier returned a null value"), this.t));
        } catch (java.lang.Throwable th) {
            io.reactivex.internal.disposables.EmptyDisposable.error(th, observer);
        }
    }
}
