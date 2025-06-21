package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeFlatMapNotification<T, R> extends io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream<T, R> {
    public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> n;
    public final io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.MaybeSource<? extends R>> t;
    public final java.util.concurrent.Callable<? extends io.reactivex.MaybeSource<? extends R>> u;

    public static final class FlatMapMaybeObserver<T, R> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.MaybeObserver<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 4375739915521278546L;
        final io.reactivex.MaybeObserver<? super R> downstream;
        final java.util.concurrent.Callable<? extends io.reactivex.MaybeSource<? extends R>> onCompleteSupplier;
        final io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.MaybeSource<? extends R>> onErrorMapper;
        final io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> onSuccessMapper;
        io.reactivex.disposables.Disposable upstream;

        public final class InnerObserver implements io.reactivex.MaybeObserver<R> {
            public InnerObserver() {
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                io.reactivex.internal.operators.maybe.MaybeFlatMapNotification.FlatMapMaybeObserver.this.downstream.onComplete();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(java.lang.Throwable th) {
                io.reactivex.internal.operators.maybe.MaybeFlatMapNotification.FlatMapMaybeObserver.this.downstream.onError(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
                io.reactivex.internal.disposables.DisposableHelper.setOnce(io.reactivex.internal.operators.maybe.MaybeFlatMapNotification.FlatMapMaybeObserver.this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r) {
                io.reactivex.internal.operators.maybe.MaybeFlatMapNotification.FlatMapMaybeObserver.this.downstream.onSuccess(r);
            }
        }

        public FlatMapMaybeObserver(io.reactivex.MaybeObserver<? super R> maybeObserver, io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.MaybeSource<? extends R>> function2, java.util.concurrent.Callable<? extends io.reactivex.MaybeSource<? extends R>> callable) {
            this.downstream = maybeObserver;
            this.onSuccessMapper = function;
            this.onErrorMapper = function2;
            this.onCompleteSupplier = callable;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            try {
                ((io.reactivex.MaybeSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.onCompleteSupplier.call(), "The onCompleteSupplier returned a null MaybeSource")).subscribe(new io.reactivex.internal.operators.maybe.MaybeFlatMapNotification.FlatMapMaybeObserver.InnerObserver());
            } catch (java.lang.Exception e) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(e);
                this.downstream.onError(e);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
            try {
                ((io.reactivex.MaybeSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.onErrorMapper.apply(th), "The onErrorMapper returned a null MaybeSource")).subscribe(new io.reactivex.internal.operators.maybe.MaybeFlatMapNotification.FlatMapMaybeObserver.InnerObserver());
            } catch (java.lang.Exception e) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(e);
                this.downstream.onError(new io.reactivex.exceptions.CompositeException(th, e));
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            try {
                ((io.reactivex.MaybeSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.onSuccessMapper.apply(t), "The onSuccessMapper returned a null MaybeSource")).subscribe(new io.reactivex.internal.operators.maybe.MaybeFlatMapNotification.FlatMapMaybeObserver.InnerObserver());
            } catch (java.lang.Exception e) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(e);
                this.downstream.onError(e);
            }
        }
    }

    public MaybeFlatMapNotification(io.reactivex.MaybeSource<T> maybeSource, io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.MaybeSource<? extends R>> function2, java.util.concurrent.Callable<? extends io.reactivex.MaybeSource<? extends R>> callable) {
        super(maybeSource);
        this.n = function;
        this.t = function2;
        this.u = callable;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super R> maybeObserver) {
        this.source.subscribe(new io.reactivex.internal.operators.maybe.MaybeFlatMapNotification.FlatMapMaybeObserver(maybeObserver, this.n, this.t, this.u));
    }
}
