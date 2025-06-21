package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeDoAfterSuccess<T> extends io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream<T, T> {
    public final io.reactivex.functions.Consumer<? super T> n;

    public static final class DoAfterObserver<T> implements io.reactivex.MaybeObserver<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.MaybeObserver<? super T> n;
        public final io.reactivex.functions.Consumer<? super T> t;
        public io.reactivex.disposables.Disposable u;

        public DoAfterObserver(io.reactivex.MaybeObserver<? super T> maybeObserver, io.reactivex.functions.Consumer<? super T> consumer) {
            this.n = maybeObserver;
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

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.n.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
            this.n.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.u, disposable)) {
                this.u = disposable;
                this.n.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
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

    public MaybeDoAfterSuccess(io.reactivex.MaybeSource<T> maybeSource, io.reactivex.functions.Consumer<? super T> consumer) {
        super(maybeSource);
        this.n = consumer;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new io.reactivex.internal.operators.maybe.MaybeDoAfterSuccess.DoAfterObserver(maybeObserver, this.n));
    }
}
