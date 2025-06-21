package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeDetach<T> extends io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream<T, T> {

    public static final class DetachMaybeObserver<T> implements io.reactivex.MaybeObserver<T>, io.reactivex.disposables.Disposable {
        public io.reactivex.MaybeObserver<? super T> n;
        public io.reactivex.disposables.Disposable t;

        public DetachMaybeObserver(io.reactivex.MaybeObserver<? super T> maybeObserver) {
            this.n = maybeObserver;
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

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            io.reactivex.MaybeObserver<? super T> maybeObserver = this.n;
            if (maybeObserver != null) {
                this.n = null;
                maybeObserver.onComplete();
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            io.reactivex.MaybeObserver<? super T> maybeObserver = this.n;
            if (maybeObserver != null) {
                this.n = null;
                maybeObserver.onError(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.t, disposable)) {
                this.t = disposable;
                this.n.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            io.reactivex.MaybeObserver<? super T> maybeObserver = this.n;
            if (maybeObserver != null) {
                this.n = null;
                maybeObserver.onSuccess(t);
            }
        }
    }

    public MaybeDetach(io.reactivex.MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new io.reactivex.internal.operators.maybe.MaybeDetach.DetachMaybeObserver(maybeObserver));
    }
}
