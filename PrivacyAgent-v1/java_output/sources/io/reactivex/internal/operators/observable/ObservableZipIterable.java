package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableZipIterable<T, U, V> extends io.reactivex.Observable<V> {
    public final io.reactivex.Observable<? extends T> n;
    public final java.lang.Iterable<U> t;
    public final io.reactivex.functions.BiFunction<? super T, ? super U, ? extends V> u;

    public static final class ZipIterableObserver<T, U, V> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super V> n;
        public final java.util.Iterator<U> t;
        public final io.reactivex.functions.BiFunction<? super T, ? super U, ? extends V> u;
        public io.reactivex.disposables.Disposable v;
        public boolean w;

        public ZipIterableObserver(io.reactivex.Observer<? super V> observer, java.util.Iterator<U> it, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends V> biFunction) {
            this.n = observer;
            this.t = it;
            this.u = biFunction;
        }

        public void a(java.lang.Throwable th) {
            this.w = true;
            this.v.dispose();
            this.n.onError(th);
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
                try {
                    this.n.onNext(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.u.apply(t, io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (this.t.hasNext()) {
                            return;
                        }
                        this.w = true;
                        this.v.dispose();
                        this.n.onComplete();
                    } catch (java.lang.Throwable th) {
                        io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                        a(th);
                    }
                } catch (java.lang.Throwable th2) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                    a(th2);
                }
            } catch (java.lang.Throwable th3) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th3);
                a(th3);
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

    public ObservableZipIterable(io.reactivex.Observable<? extends T> observable, java.lang.Iterable<U> iterable, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends V> biFunction) {
        this.n = observable;
        this.t = iterable;
        this.u = biFunction;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super V> observer) {
        try {
            java.util.Iterator it = (java.util.Iterator) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.iterator(), "The iterator returned by other is null");
            try {
                if (it.hasNext()) {
                    this.n.subscribe(new io.reactivex.internal.operators.observable.ObservableZipIterable.ZipIterableObserver(observer, it, this.u));
                } else {
                    io.reactivex.internal.disposables.EmptyDisposable.complete(observer);
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.internal.disposables.EmptyDisposable.error(th, observer);
            }
        } catch (java.lang.Throwable th2) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
            io.reactivex.internal.disposables.EmptyDisposable.error(th2, observer);
        }
    }
}
