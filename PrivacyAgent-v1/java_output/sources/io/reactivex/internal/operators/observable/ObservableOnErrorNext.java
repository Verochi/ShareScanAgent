package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableOnErrorNext<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.ObservableSource<? extends T>> n;
    public final boolean t;

    public static final class OnErrorNextObserver<T> implements io.reactivex.Observer<T> {
        public final io.reactivex.Observer<? super T> n;
        public final io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.ObservableSource<? extends T>> t;
        public final boolean u;
        public final io.reactivex.internal.disposables.SequentialDisposable v = new io.reactivex.internal.disposables.SequentialDisposable();
        public boolean w;
        public boolean x;

        public OnErrorNextObserver(io.reactivex.Observer<? super T> observer, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.ObservableSource<? extends T>> function, boolean z) {
            this.n = observer;
            this.t = function;
            this.u = z;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.x) {
                return;
            }
            this.x = true;
            this.w = true;
            this.n.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.w) {
                if (this.x) {
                    io.reactivex.plugins.RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.n.onError(th);
                    return;
                }
            }
            this.w = true;
            if (this.u && !(th instanceof java.lang.Exception)) {
                this.n.onError(th);
                return;
            }
            try {
                io.reactivex.ObservableSource<? extends T> apply = this.t.apply(th);
                if (apply != null) {
                    apply.subscribe(this);
                    return;
                }
                java.lang.NullPointerException nullPointerException = new java.lang.NullPointerException("Observable is null");
                nullPointerException.initCause(th);
                this.n.onError(nullPointerException);
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                this.n.onError(new io.reactivex.exceptions.CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.x) {
                return;
            }
            this.n.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.v.replace(disposable);
        }
    }

    public ObservableOnErrorNext(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.ObservableSource<? extends T>> function, boolean z) {
        super(observableSource);
        this.n = function;
        this.t = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.internal.operators.observable.ObservableOnErrorNext.OnErrorNextObserver onErrorNextObserver = new io.reactivex.internal.operators.observable.ObservableOnErrorNext.OnErrorNextObserver(observer, this.n, this.t);
        observer.onSubscribe(onErrorNextObserver.v);
        this.source.subscribe(onErrorNextObserver);
    }
}
