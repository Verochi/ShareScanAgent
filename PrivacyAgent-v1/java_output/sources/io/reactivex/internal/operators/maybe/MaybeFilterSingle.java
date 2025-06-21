package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeFilterSingle<T> extends io.reactivex.Maybe<T> {
    public final io.reactivex.SingleSource<T> n;
    public final io.reactivex.functions.Predicate<? super T> t;

    public static final class FilterMaybeObserver<T> implements io.reactivex.SingleObserver<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.MaybeObserver<? super T> n;
        public final io.reactivex.functions.Predicate<? super T> t;
        public io.reactivex.disposables.Disposable u;

        public FilterMaybeObserver(io.reactivex.MaybeObserver<? super T> maybeObserver, io.reactivex.functions.Predicate<? super T> predicate) {
            this.n = maybeObserver;
            this.t = predicate;
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
                if (this.t.test(t)) {
                    this.n.onSuccess(t);
                } else {
                    this.n.onComplete();
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.n.onError(th);
            }
        }
    }

    public MaybeFilterSingle(io.reactivex.SingleSource<T> singleSource, io.reactivex.functions.Predicate<? super T> predicate) {
        this.n = singleSource;
        this.t = predicate;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.maybe.MaybeFilterSingle.FilterMaybeObserver(maybeObserver, this.t));
    }
}
