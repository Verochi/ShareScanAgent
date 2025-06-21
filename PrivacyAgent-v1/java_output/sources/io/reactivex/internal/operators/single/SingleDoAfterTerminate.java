package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleDoAfterTerminate<T> extends io.reactivex.Single<T> {
    public final io.reactivex.SingleSource<T> n;
    public final io.reactivex.functions.Action t;

    public static final class DoAfterTerminateObserver<T> implements io.reactivex.SingleObserver<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super T> n;
        public final io.reactivex.functions.Action t;
        public io.reactivex.disposables.Disposable u;

        public DoAfterTerminateObserver(io.reactivex.SingleObserver<? super T> singleObserver, io.reactivex.functions.Action action) {
            this.n = singleObserver;
            this.t = action;
        }

        public final void a() {
            try {
                this.t.run();
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.u.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.u.isDisposed();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(java.lang.Throwable th) {
            this.n.onError(th);
            a();
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.u, disposable)) {
                this.u = disposable;
                this.n.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.n.onSuccess(t);
            a();
        }
    }

    public SingleDoAfterTerminate(io.reactivex.SingleSource<T> singleSource, io.reactivex.functions.Action action) {
        this.n = singleSource;
        this.t = action;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.single.SingleDoAfterTerminate.DoAfterTerminateObserver(singleObserver, this.t));
    }
}
