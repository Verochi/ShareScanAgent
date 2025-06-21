package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableFlattenIterable<T, R> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, R> {
    public final io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends R>> n;

    public static final class FlattenIterableObserver<T, R> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super R> n;
        public final io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends R>> t;
        public io.reactivex.disposables.Disposable u;

        public FlattenIterableObserver(io.reactivex.Observer<? super R> observer, io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends R>> function) {
            this.n = observer;
            this.t = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.u.dispose();
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.u.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            io.reactivex.disposables.Disposable disposable = this.u;
            io.reactivex.internal.disposables.DisposableHelper disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                return;
            }
            this.u = disposableHelper;
            this.n.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            io.reactivex.disposables.Disposable disposable = this.u;
            io.reactivex.internal.disposables.DisposableHelper disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.u = disposableHelper;
                this.n.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.u == io.reactivex.internal.disposables.DisposableHelper.DISPOSED) {
                return;
            }
            try {
                java.util.Iterator<? extends R> it = this.t.apply(t).iterator();
                io.reactivex.Observer<? super R> observer = this.n;
                while (it.hasNext()) {
                    try {
                        try {
                            observer.onNext((java.lang.Object) io.reactivex.internal.functions.ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value"));
                        } catch (java.lang.Throwable th) {
                            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                            this.u.dispose();
                            onError(th);
                            return;
                        }
                    } catch (java.lang.Throwable th2) {
                        io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                        this.u.dispose();
                        onError(th2);
                        return;
                    }
                }
            } catch (java.lang.Throwable th3) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th3);
                this.u.dispose();
                onError(th3);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.u, disposable)) {
                this.u = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableFlattenIterable(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends R>> function) {
        super(observableSource);
        this.n = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super R> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableFlattenIterable.FlattenIterableObserver(observer, this.n));
    }
}
