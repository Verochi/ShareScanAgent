package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleDoAfterSuccess<T> extends io.reactivex.Single<T> {
    public final io.reactivex.SingleSource<T> n;
    public final io.reactivex.functions.Consumer<? super T> t;

    public static final class DoAfterObserver<T> implements io.reactivex.SingleObserver<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super T> n;
        public final io.reactivex.functions.Consumer<? super T> t;
        public io.reactivex.disposables.Disposable u;

        public DoAfterObserver(io.reactivex.SingleObserver<? super T> singleObserver, io.reactivex.functions.Consumer<? super T> consumer) {
            this.n = singleObserver;
            this.t = consumer;
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
            try {
                this.t.accept(t);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
        }
    }

    public SingleDoAfterSuccess(io.reactivex.SingleSource<T> singleSource, io.reactivex.functions.Consumer<? super T> consumer) {
        this.n = singleSource;
        this.t = consumer;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.single.SingleDoAfterSuccess.DoAfterObserver(singleObserver, this.t));
    }
}
