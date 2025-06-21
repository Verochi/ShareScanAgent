package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeFlatMapBiSelector<T, U, R> extends io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream<T, R> {
    public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends U>> n;
    public final io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> t;

    public static final class FlatMapBiMainObserver<T, U, R> implements io.reactivex.MaybeObserver<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends U>> n;
        public final io.reactivex.internal.operators.maybe.MaybeFlatMapBiSelector.FlatMapBiMainObserver.InnerObserver<T, U, R> t;

        public static final class InnerObserver<T, U, R> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.MaybeObserver<U> {
            private static final long serialVersionUID = -2897979525538174559L;
            final io.reactivex.MaybeObserver<? super R> downstream;
            final io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> resultSelector;
            T value;

            public InnerObserver(io.reactivex.MaybeObserver<? super R> maybeObserver, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction) {
                this.downstream = maybeObserver;
                this.resultSelector = biFunction;
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.downstream.onComplete();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(java.lang.Throwable th) {
                this.downstream.onError(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
                io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(U u) {
                T t = this.value;
                this.value = null;
                try {
                    this.downstream.onSuccess(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.resultSelector.apply(t, u), "The resultSelector returned a null value"));
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    this.downstream.onError(th);
                }
            }
        }

        public FlatMapBiMainObserver(io.reactivex.MaybeObserver<? super R> maybeObserver, io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends U>> function, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.t = new io.reactivex.internal.operators.maybe.MaybeFlatMapBiSelector.FlatMapBiMainObserver.InnerObserver<>(maybeObserver, biFunction);
            this.n = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.t);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(this.t.get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.t.downstream.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
            this.t.downstream.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.setOnce(this.t, disposable)) {
                this.t.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            try {
                io.reactivex.MaybeSource maybeSource = (io.reactivex.MaybeSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.apply(t), "The mapper returned a null MaybeSource");
                if (io.reactivex.internal.disposables.DisposableHelper.replace(this.t, null)) {
                    io.reactivex.internal.operators.maybe.MaybeFlatMapBiSelector.FlatMapBiMainObserver.InnerObserver<T, U, R> innerObserver = this.t;
                    innerObserver.value = t;
                    maybeSource.subscribe(innerObserver);
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.t.downstream.onError(th);
            }
        }
    }

    public MaybeFlatMapBiSelector(io.reactivex.MaybeSource<T> maybeSource, io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends U>> function, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction) {
        super(maybeSource);
        this.n = function;
        this.t = biFunction;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super R> maybeObserver) {
        this.source.subscribe(new io.reactivex.internal.operators.maybe.MaybeFlatMapBiSelector.FlatMapBiMainObserver(maybeObserver, this.n, this.t));
    }
}
