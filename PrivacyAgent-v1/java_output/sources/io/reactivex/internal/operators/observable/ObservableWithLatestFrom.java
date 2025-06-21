package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableWithLatestFrom<T, U, R> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, R> {
    public final io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> n;
    public final io.reactivex.ObservableSource<? extends U> t;

    public static final class WithLatestFromObserver<T, U, R> extends java.util.concurrent.atomic.AtomicReference<U> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -312246233408980075L;
        final io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> combiner;
        final io.reactivex.Observer<? super R> downstream;
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> upstream = new java.util.concurrent.atomic.AtomicReference<>();
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> other = new java.util.concurrent.atomic.AtomicReference<>();

        public WithLatestFromObserver(io.reactivex.Observer<? super R> observer, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.downstream = observer;
            this.combiner = biFunction;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.upstream);
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.other);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.other);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.other);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            U u = get();
            if (u != null) {
                try {
                    this.downstream.onNext(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.combiner.apply(t, u), "The combiner returned a null value"));
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    dispose();
                    this.downstream.onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this.upstream, disposable);
        }

        public void otherError(java.lang.Throwable th) {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.upstream);
            this.downstream.onError(th);
        }

        public boolean setOther(io.reactivex.disposables.Disposable disposable) {
            return io.reactivex.internal.disposables.DisposableHelper.setOnce(this.other, disposable);
        }
    }

    public final class WithLatestFromOtherObserver implements io.reactivex.Observer<U> {
        public final io.reactivex.internal.operators.observable.ObservableWithLatestFrom.WithLatestFromObserver<T, U, R> n;

        public WithLatestFromOtherObserver(io.reactivex.internal.operators.observable.ObservableWithLatestFrom.WithLatestFromObserver<T, U, R> withLatestFromObserver) {
            this.n = withLatestFromObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.n.otherError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(U u) {
            this.n.lazySet(u);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.n.setOther(disposable);
        }
    }

    public ObservableWithLatestFrom(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction, io.reactivex.ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.n = biFunction;
        this.t = observableSource2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super R> observer) {
        io.reactivex.observers.SerializedObserver serializedObserver = new io.reactivex.observers.SerializedObserver(observer);
        io.reactivex.internal.operators.observable.ObservableWithLatestFrom.WithLatestFromObserver withLatestFromObserver = new io.reactivex.internal.operators.observable.ObservableWithLatestFrom.WithLatestFromObserver(serializedObserver, this.n);
        serializedObserver.onSubscribe(withLatestFromObserver);
        this.t.subscribe(new io.reactivex.internal.operators.observable.ObservableWithLatestFrom.WithLatestFromOtherObserver(withLatestFromObserver));
        this.source.subscribe(withLatestFromObserver);
    }
}
