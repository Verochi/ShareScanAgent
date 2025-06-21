package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableMapNotification<T, R> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, io.reactivex.ObservableSource<? extends R>> {
    public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> n;
    public final io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.ObservableSource<? extends R>> t;
    public final java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<? extends R>> u;

    public static final class MapNotificationObserver<T, R> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super io.reactivex.ObservableSource<? extends R>> n;
        public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> t;
        public final io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.ObservableSource<? extends R>> u;
        public final java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<? extends R>> v;
        public io.reactivex.disposables.Disposable w;

        public MapNotificationObserver(io.reactivex.Observer<? super io.reactivex.ObservableSource<? extends R>> observer, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.ObservableSource<? extends R>> function2, java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<? extends R>> callable) {
            this.n = observer;
            this.t = function;
            this.u = function2;
            this.v = callable;
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
            try {
                this.n.onNext((io.reactivex.ObservableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.v.call(), "The onComplete ObservableSource returned is null"));
                this.n.onComplete();
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.n.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            try {
                this.n.onNext((io.reactivex.ObservableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.u.apply(th), "The onError ObservableSource returned is null"));
                this.n.onComplete();
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                this.n.onError(new io.reactivex.exceptions.CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            try {
                this.n.onNext((io.reactivex.ObservableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(t), "The onNext ObservableSource returned is null"));
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.n.onError(th);
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

    public ObservableMapNotification(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.ObservableSource<? extends R>> function2, java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<? extends R>> callable) {
        super(observableSource);
        this.n = function;
        this.t = function2;
        this.u = callable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super io.reactivex.ObservableSource<? extends R>> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableMapNotification.MapNotificationObserver(observer, this.n, this.t, this.u));
    }
}
