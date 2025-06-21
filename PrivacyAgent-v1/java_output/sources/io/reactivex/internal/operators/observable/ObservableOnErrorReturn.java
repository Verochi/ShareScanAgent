package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableOnErrorReturn<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final io.reactivex.functions.Function<? super java.lang.Throwable, ? extends T> n;

    public static final class OnErrorReturnObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super T> n;
        public final io.reactivex.functions.Function<? super java.lang.Throwable, ? extends T> t;
        public io.reactivex.disposables.Disposable u;

        public OnErrorReturnObserver(io.reactivex.Observer<? super T> observer, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends T> function) {
            this.n = observer;
            this.t = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.u.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.u.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.n.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            try {
                T apply = this.t.apply(th);
                if (apply != null) {
                    this.n.onNext(apply);
                    this.n.onComplete();
                } else {
                    java.lang.NullPointerException nullPointerException = new java.lang.NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.n.onError(nullPointerException);
                }
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                this.n.onError(new io.reactivex.exceptions.CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.n.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.u, disposable)) {
                this.u = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableOnErrorReturn(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends T> function) {
        super(observableSource);
        this.n = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableOnErrorReturn.OnErrorReturnObserver(observer, this.n));
    }
}
