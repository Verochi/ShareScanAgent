package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeSwitchIfEmpty<T> extends io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream<T, T> {
    public final io.reactivex.MaybeSource<? extends T> n;

    public static final class SwitchIfEmptyMaybeObserver<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.MaybeObserver<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -2223459372976438024L;
        final io.reactivex.MaybeObserver<? super T> downstream;
        final io.reactivex.MaybeSource<? extends T> other;

        public static final class OtherMaybeObserver<T> implements io.reactivex.MaybeObserver<T> {
            public final io.reactivex.MaybeObserver<? super T> n;
            public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> t;

            public OtherMaybeObserver(io.reactivex.MaybeObserver<? super T> maybeObserver, java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> atomicReference) {
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

        public SwitchIfEmptyMaybeObserver(io.reactivex.MaybeObserver<? super T> maybeObserver, io.reactivex.MaybeSource<? extends T> maybeSource) {
            this.downstream = maybeObserver;
            this.other = maybeSource;
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
            io.reactivex.disposables.Disposable disposable = get();
            if (disposable == io.reactivex.internal.disposables.DisposableHelper.DISPOSED || !compareAndSet(disposable, null)) {
                return;
            }
            this.other.subscribe(new io.reactivex.internal.operators.maybe.MaybeSwitchIfEmpty.SwitchIfEmptyMaybeObserver.OtherMaybeObserver(this.downstream, this));
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
            this.downstream.onError(th);
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

    public MaybeSwitchIfEmpty(io.reactivex.MaybeSource<T> maybeSource, io.reactivex.MaybeSource<? extends T> maybeSource2) {
        super(maybeSource);
        this.n = maybeSource2;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new io.reactivex.internal.operators.maybe.MaybeSwitchIfEmpty.SwitchIfEmptyMaybeObserver(maybeObserver, this.n));
    }
}
