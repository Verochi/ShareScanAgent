package io.reactivex.internal.operators.single;

@io.reactivex.annotations.Experimental
/* loaded from: classes13.dex */
public final class SingleDematerialize<T, R> extends io.reactivex.Maybe<R> {
    public final io.reactivex.Single<T> n;
    public final io.reactivex.functions.Function<? super T, io.reactivex.Notification<R>> t;

    public static final class DematerializeObserver<T, R> implements io.reactivex.SingleObserver<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.MaybeObserver<? super R> n;
        public final io.reactivex.functions.Function<? super T, io.reactivex.Notification<R>> t;
        public io.reactivex.disposables.Disposable u;

        public DematerializeObserver(io.reactivex.MaybeObserver<? super R> maybeObserver, io.reactivex.functions.Function<? super T, io.reactivex.Notification<R>> function) {
            this.n = maybeObserver;
            this.t = function;
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
            try {
                io.reactivex.Notification notification = (io.reactivex.Notification) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(t), "The selector returned a null Notification");
                if (notification.isOnNext()) {
                    this.n.onSuccess((java.lang.Object) notification.getValue());
                } else if (notification.isOnComplete()) {
                    this.n.onComplete();
                } else {
                    this.n.onError(notification.getError());
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.n.onError(th);
            }
        }
    }

    public SingleDematerialize(io.reactivex.Single<T> single, io.reactivex.functions.Function<? super T, io.reactivex.Notification<R>> function) {
        this.n = single;
        this.t = function;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super R> maybeObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.single.SingleDematerialize.DematerializeObserver(maybeObserver, this.t));
    }
}
