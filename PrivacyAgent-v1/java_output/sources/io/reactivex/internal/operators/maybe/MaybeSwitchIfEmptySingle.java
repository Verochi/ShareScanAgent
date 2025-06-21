package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeSwitchIfEmptySingle<T> extends io.reactivex.Single<T> implements io.reactivex.internal.fuseable.HasUpstreamMaybeSource<T> {
    public final io.reactivex.MaybeSource<T> n;
    public final io.reactivex.SingleSource<? extends T> t;

    public static final class SwitchIfEmptyMaybeObserver<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.MaybeObserver<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 4603919676453758899L;
        final io.reactivex.SingleObserver<? super T> downstream;
        final io.reactivex.SingleSource<? extends T> other;

        public static final class OtherSingleObserver<T> implements io.reactivex.SingleObserver<T> {
            public final io.reactivex.SingleObserver<? super T> n;
            public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> t;

            public OtherSingleObserver(io.reactivex.SingleObserver<? super T> singleObserver, java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> atomicReference) {
                this.n = singleObserver;
                this.t = atomicReference;
            }

            @Override // io.reactivex.SingleObserver
            public void onError(java.lang.Throwable th) {
                this.n.onError(th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
                io.reactivex.internal.disposables.DisposableHelper.setOnce(this.t, disposable);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(T t) {
                this.n.onSuccess(t);
            }
        }

        public SwitchIfEmptyMaybeObserver(io.reactivex.SingleObserver<? super T> singleObserver, io.reactivex.SingleSource<? extends T> singleSource) {
            this.downstream = singleObserver;
            this.other = singleSource;
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
            this.other.subscribe(new io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle.SwitchIfEmptyMaybeObserver.OtherSingleObserver(this.downstream, this));
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

    public MaybeSwitchIfEmptySingle(io.reactivex.MaybeSource<T> maybeSource, io.reactivex.SingleSource<? extends T> singleSource) {
        this.n = maybeSource;
        this.t = singleSource;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamMaybeSource
    public io.reactivex.MaybeSource<T> source() {
        return this.n;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle.SwitchIfEmptyMaybeObserver(singleObserver, this.t));
    }
}
