package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleDetach<T> extends io.reactivex.Single<T> {
    public final io.reactivex.SingleSource<T> n;

    public static final class DetachSingleObserver<T> implements io.reactivex.SingleObserver<T>, io.reactivex.disposables.Disposable {
        public io.reactivex.SingleObserver<? super T> n;
        public io.reactivex.disposables.Disposable t;

        public DetachSingleObserver(io.reactivex.SingleObserver<? super T> singleObserver) {
            this.n = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.n = null;
            this.t.dispose();
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.t.isDisposed();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(java.lang.Throwable th) {
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            io.reactivex.SingleObserver<? super T> singleObserver = this.n;
            if (singleObserver != null) {
                this.n = null;
                singleObserver.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.t, disposable)) {
                this.t = disposable;
                this.n.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            io.reactivex.SingleObserver<? super T> singleObserver = this.n;
            if (singleObserver != null) {
                this.n = null;
                singleObserver.onSuccess(t);
            }
        }
    }

    public SingleDetach(io.reactivex.SingleSource<T> singleSource) {
        this.n = singleSource;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.single.SingleDetach.DetachSingleObserver(singleObserver));
    }
}
