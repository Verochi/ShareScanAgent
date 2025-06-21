package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeDoOnTerminate<T> extends io.reactivex.Maybe<T> {
    public final io.reactivex.MaybeSource<T> n;
    public final io.reactivex.functions.Action t;

    public final class DoOnTerminate implements io.reactivex.MaybeObserver<T> {
        public final io.reactivex.MaybeObserver<? super T> n;

        public DoOnTerminate(io.reactivex.MaybeObserver<? super T> maybeObserver) {
            this.n = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            try {
                io.reactivex.internal.operators.maybe.MaybeDoOnTerminate.this.t.run();
                this.n.onComplete();
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.n.onError(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
            try {
                io.reactivex.internal.operators.maybe.MaybeDoOnTerminate.this.t.run();
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                th = new io.reactivex.exceptions.CompositeException(th, th2);
            }
            this.n.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.n.onSubscribe(disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            try {
                io.reactivex.internal.operators.maybe.MaybeDoOnTerminate.this.t.run();
                this.n.onSuccess(t);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.n.onError(th);
            }
        }
    }

    public MaybeDoOnTerminate(io.reactivex.MaybeSource<T> maybeSource, io.reactivex.functions.Action action) {
        this.n = maybeSource;
        this.t = action;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.maybe.MaybeDoOnTerminate.DoOnTerminate(maybeObserver));
    }
}
