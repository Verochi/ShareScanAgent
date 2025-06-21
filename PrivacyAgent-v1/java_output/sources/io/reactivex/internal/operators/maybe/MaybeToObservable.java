package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeToObservable<T> extends io.reactivex.Observable<T> implements io.reactivex.internal.fuseable.HasUpstreamMaybeSource<T> {
    public final io.reactivex.MaybeSource<T> n;

    public static final class MaybeToObservableObserver<T> extends io.reactivex.internal.observers.DeferredScalarDisposable<T> implements io.reactivex.MaybeObserver<T> {
        private static final long serialVersionUID = 7603343402964826922L;
        io.reactivex.disposables.Disposable upstream;

        public MaybeToObservableObserver(io.reactivex.Observer<? super T> observer) {
            super(observer);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public void dispose() {
            super.dispose();
            this.upstream.dispose();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            complete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
            error(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public MaybeToObservable(io.reactivex.MaybeSource<T> maybeSource) {
        this.n = maybeSource;
    }

    public static <T> io.reactivex.MaybeObserver<T> create(io.reactivex.Observer<? super T> observer) {
        return new io.reactivex.internal.operators.maybe.MaybeToObservable.MaybeToObservableObserver(observer);
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamMaybeSource
    public io.reactivex.MaybeSource<T> source() {
        return this.n;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.n.subscribe(create(observer));
    }
}
