package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeOnErrorNext<T> extends io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream<T, T> {
    public final io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.MaybeSource<? extends T>> n;
    public final boolean t;

    public static final class OnErrorNextMaybeObserver<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.MaybeObserver<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 2026620218879969836L;
        final boolean allowFatal;
        final io.reactivex.MaybeObserver<? super T> downstream;
        final io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.MaybeSource<? extends T>> resumeFunction;

        public static final class NextMaybeObserver<T> implements io.reactivex.MaybeObserver<T> {
            public final io.reactivex.MaybeObserver<? super T> n;
            public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> t;

            public NextMaybeObserver(io.reactivex.MaybeObserver<? super T> maybeObserver, java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> atomicReference) {
                this.n = maybeObserver;
                this.t = atomicReference;
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.n.onComplete();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(java.lang.Throwable th) {
                this.n.onError(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
                io.reactivex.internal.disposables.DisposableHelper.setOnce(this.t, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(T t) {
                this.n.onSuccess(t);
            }
        }

        public OnErrorNextMaybeObserver(io.reactivex.MaybeObserver<? super T> maybeObserver, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.MaybeSource<? extends T>> function, boolean z) {
            this.downstream = maybeObserver;
            this.resumeFunction = function;
            this.allowFatal = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
            if (!this.allowFatal && !(th instanceof java.lang.Exception)) {
                this.downstream.onError(th);
                return;
            }
            try {
                io.reactivex.MaybeSource maybeSource = (io.reactivex.MaybeSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.resumeFunction.apply(th), "The resumeFunction returned a null MaybeSource");
                io.reactivex.internal.disposables.DisposableHelper.replace(this, null);
                maybeSource.subscribe(new io.reactivex.internal.operators.maybe.MaybeOnErrorNext.OnErrorNextMaybeObserver.NextMaybeObserver(this.downstream, this));
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                this.downstream.onError(new io.reactivex.exceptions.CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }

    public MaybeOnErrorNext(io.reactivex.MaybeSource<T> maybeSource, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.MaybeSource<? extends T>> function, boolean z) {
        super(maybeSource);
        this.n = function;
        this.t = z;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new io.reactivex.internal.operators.maybe.MaybeOnErrorNext.OnErrorNextMaybeObserver(maybeObserver, this.n, this.t));
    }
}
