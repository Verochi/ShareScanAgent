package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeOnErrorComplete<T> extends io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream<T, T> {
    public final io.reactivex.functions.Predicate<? super java.lang.Throwable> n;

    public static final class OnErrorCompleteMaybeObserver<T> implements io.reactivex.MaybeObserver<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.MaybeObserver<? super T> n;
        public final io.reactivex.functions.Predicate<? super java.lang.Throwable> t;
        public io.reactivex.disposables.Disposable u;

        public OnErrorCompleteMaybeObserver(io.reactivex.MaybeObserver<? super T> maybeObserver, io.reactivex.functions.Predicate<? super java.lang.Throwable> predicate) {
            this.n = maybeObserver;
            this.t = predicate;
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
            try {
                if (this.t.test(th)) {
                    this.n.onComplete();
                } else {
                    this.n.onError(th);
                }
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                this.n.onError(new io.reactivex.exceptions.CompositeException(th, th2));
            }
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
        }
    }

    public MaybeOnErrorComplete(io.reactivex.MaybeSource<T> maybeSource, io.reactivex.functions.Predicate<? super java.lang.Throwable> predicate) {
        super(maybeSource);
        this.n = predicate;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new io.reactivex.internal.operators.maybe.MaybeOnErrorComplete.OnErrorCompleteMaybeObserver(maybeObserver, this.n));
    }
}
