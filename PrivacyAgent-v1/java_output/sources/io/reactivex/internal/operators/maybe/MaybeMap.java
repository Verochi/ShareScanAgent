package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeMap<T, R> extends io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream<T, R> {
    public final io.reactivex.functions.Function<? super T, ? extends R> n;

    public static final class MapMaybeObserver<T, R> implements io.reactivex.MaybeObserver<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.MaybeObserver<? super R> n;
        public final io.reactivex.functions.Function<? super T, ? extends R> t;
        public io.reactivex.disposables.Disposable u;

        public MapMaybeObserver(io.reactivex.MaybeObserver<? super R> maybeObserver, io.reactivex.functions.Function<? super T, ? extends R> function) {
            this.n = maybeObserver;
            this.t = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.disposables.Disposable disposable = this.u;
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.u.isDisposed();
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
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.u, disposable)) {
                this.u = disposable;
                this.n.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            try {
                this.n.onSuccess(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(t), "The mapper returned a null item"));
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.n.onError(th);
            }
        }
    }

    public MaybeMap(io.reactivex.MaybeSource<T> maybeSource, io.reactivex.functions.Function<? super T, ? extends R> function) {
        super(maybeSource);
        this.n = function;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super R> maybeObserver) {
        this.source.subscribe(new io.reactivex.internal.operators.maybe.MaybeMap.MapMaybeObserver(maybeObserver, this.n));
    }
}
