package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleDelayWithSingle<T, U> extends io.reactivex.Single<T> {
    public final io.reactivex.SingleSource<T> n;
    public final io.reactivex.SingleSource<U> t;

    public static final class OtherObserver<T, U> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.SingleObserver<U>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -8565274649390031272L;
        final io.reactivex.SingleObserver<? super T> downstream;
        final io.reactivex.SingleSource<T> source;

        public OtherObserver(io.reactivex.SingleObserver<? super T> singleObserver, io.reactivex.SingleSource<T> singleSource) {
            this.downstream = singleObserver;
            this.source = singleSource;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.SingleObserver
        public void onError(java.lang.Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(U u) {
            this.source.subscribe(new io.reactivex.internal.observers.ResumeSingleObserver(this, this.downstream));
        }
    }

    public SingleDelayWithSingle(io.reactivex.SingleSource<T> singleSource, io.reactivex.SingleSource<U> singleSource2) {
        this.n = singleSource;
        this.t = singleSource2;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.t.subscribe(new io.reactivex.internal.operators.single.SingleDelayWithSingle.OtherObserver(singleObserver, this.n));
    }
}
