package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeDoOnEvent<T> extends io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream<T, T> {
    public final io.reactivex.functions.BiConsumer<? super T, ? super java.lang.Throwable> n;

    public static final class DoOnEventMaybeObserver<T> implements io.reactivex.MaybeObserver<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.MaybeObserver<? super T> n;
        public final io.reactivex.functions.BiConsumer<? super T, ? super java.lang.Throwable> t;
        public io.reactivex.disposables.Disposable u;

        public DoOnEventMaybeObserver(io.reactivex.MaybeObserver<? super T> maybeObserver, io.reactivex.functions.BiConsumer<? super T, ? super java.lang.Throwable> biConsumer) {
            this.n = maybeObserver;
            this.t = biConsumer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.u.dispose();
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.u.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            try {
                this.t.accept(null, null);
                this.n.onComplete();
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.n.onError(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            try {
                this.t.accept(null, th);
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                th = new io.reactivex.exceptions.CompositeException(th, th2);
            }
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
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            try {
                this.t.accept(t, null);
                this.n.onSuccess(t);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.n.onError(th);
            }
        }
    }

    public MaybeDoOnEvent(io.reactivex.MaybeSource<T> maybeSource, io.reactivex.functions.BiConsumer<? super T, ? super java.lang.Throwable> biConsumer) {
        super(maybeSource);
        this.n = biConsumer;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new io.reactivex.internal.operators.maybe.MaybeDoOnEvent.DoOnEventMaybeObserver(maybeObserver, this.n));
    }
}
