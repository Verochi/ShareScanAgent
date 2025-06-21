package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableReduceMaybe<T> extends io.reactivex.Maybe<T> {
    public final io.reactivex.ObservableSource<T> n;
    public final io.reactivex.functions.BiFunction<T, T, T> t;

    public static final class ReduceObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.MaybeObserver<? super T> n;
        public final io.reactivex.functions.BiFunction<T, T, T> t;
        public boolean u;
        public T v;
        public io.reactivex.disposables.Disposable w;

        public ReduceObserver(io.reactivex.MaybeObserver<? super T> maybeObserver, io.reactivex.functions.BiFunction<T, T, T> biFunction) {
            this.n = maybeObserver;
            this.t = biFunction;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.w.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.u) {
                return;
            }
            this.u = true;
            T t = this.v;
            this.v = null;
            if (t != null) {
                this.n.onSuccess(t);
            } else {
                this.n.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.u) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.u = true;
            this.v = null;
            this.n.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.u) {
                return;
            }
            T t2 = this.v;
            if (t2 == null) {
                this.v = t;
                return;
            }
            try {
                this.v = (T) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(t2, t), "The reducer returned a null value");
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.w.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.w, disposable)) {
                this.w = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableReduceMaybe(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.BiFunction<T, T, T> biFunction) {
        this.n = observableSource;
        this.t = biFunction;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.observable.ObservableReduceMaybe.ReduceObserver(maybeObserver, this.t));
    }
}
