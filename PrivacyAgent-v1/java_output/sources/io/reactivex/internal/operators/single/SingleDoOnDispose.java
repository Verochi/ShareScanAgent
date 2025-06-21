package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleDoOnDispose<T> extends io.reactivex.Single<T> {
    public final io.reactivex.SingleSource<T> n;
    public final io.reactivex.functions.Action t;

    public static final class DoOnDisposeObserver<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.functions.Action> implements io.reactivex.SingleObserver<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -8583764624474935784L;
        final io.reactivex.SingleObserver<? super T> downstream;
        io.reactivex.disposables.Disposable upstream;

        public DoOnDisposeObserver(io.reactivex.SingleObserver<? super T> singleObserver, io.reactivex.functions.Action action) {
            this.downstream = singleObserver;
            lazySet(action);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.functions.Action andSet = getAndSet(null);
            if (andSet != null) {
                try {
                    andSet.run();
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    io.reactivex.plugins.RxJavaPlugins.onError(th);
                }
                this.upstream.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(java.lang.Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }

    public SingleDoOnDispose(io.reactivex.SingleSource<T> singleSource, io.reactivex.functions.Action action) {
        this.n = singleSource;
        this.t = action;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.single.SingleDoOnDispose.DoOnDisposeObserver(singleObserver, this.t));
    }
}
