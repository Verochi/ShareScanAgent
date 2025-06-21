package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeCreate<T> extends io.reactivex.Maybe<T> {
    public final io.reactivex.MaybeOnSubscribe<T> n;

    public static final class Emitter<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.MaybeEmitter<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -2467358622224974244L;
        final io.reactivex.MaybeObserver<? super T> downstream;

        public Emitter(io.reactivex.MaybeObserver<? super T> maybeObserver) {
            this.downstream = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.MaybeEmitter, io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.MaybeEmitter
        public void onComplete() {
            io.reactivex.disposables.Disposable andSet;
            io.reactivex.disposables.Disposable disposable = get();
            io.reactivex.internal.disposables.DisposableHelper disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            if (disposable == disposableHelper || (andSet = getAndSet(disposableHelper)) == disposableHelper) {
                return;
            }
            try {
                this.downstream.onComplete();
            } finally {
                if (andSet != null) {
                    andSet.dispose();
                }
            }
        }

        @Override // io.reactivex.MaybeEmitter
        public void onError(java.lang.Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            io.reactivex.plugins.RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.MaybeEmitter
        public void onSuccess(T t) {
            io.reactivex.disposables.Disposable andSet;
            io.reactivex.disposables.Disposable disposable = get();
            io.reactivex.internal.disposables.DisposableHelper disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            if (disposable == disposableHelper || (andSet = getAndSet(disposableHelper)) == disposableHelper) {
                return;
            }
            try {
                if (t == null) {
                    this.downstream.onError(new java.lang.NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else {
                    this.downstream.onSuccess(t);
                }
                if (andSet != null) {
                    andSet.dispose();
                }
            } catch (java.lang.Throwable th) {
                if (andSet != null) {
                    andSet.dispose();
                }
                throw th;
            }
        }

        @Override // io.reactivex.MaybeEmitter
        public void setCancellable(io.reactivex.functions.Cancellable cancellable) {
            setDisposable(new io.reactivex.internal.disposables.CancellableDisposable(cancellable));
        }

        @Override // io.reactivex.MaybeEmitter
        public void setDisposable(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.set(this, disposable);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public java.lang.String toString() {
            return java.lang.String.format("%s{%s}", io.reactivex.internal.operators.maybe.MaybeCreate.Emitter.class.getSimpleName(), super.toString());
        }

        @Override // io.reactivex.MaybeEmitter
        public boolean tryOnError(java.lang.Throwable th) {
            io.reactivex.disposables.Disposable andSet;
            if (th == null) {
                th = new java.lang.NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            io.reactivex.disposables.Disposable disposable = get();
            io.reactivex.internal.disposables.DisposableHelper disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            if (disposable == disposableHelper || (andSet = getAndSet(disposableHelper)) == disposableHelper) {
                return false;
            }
            try {
                this.downstream.onError(th);
            } finally {
                if (andSet != null) {
                    andSet.dispose();
                }
            }
        }
    }

    public MaybeCreate(io.reactivex.MaybeOnSubscribe<T> maybeOnSubscribe) {
        this.n = maybeOnSubscribe;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        io.reactivex.internal.operators.maybe.MaybeCreate.Emitter emitter = new io.reactivex.internal.operators.maybe.MaybeCreate.Emitter(maybeObserver);
        maybeObserver.onSubscribe(emitter);
        try {
            this.n.subscribe(emitter);
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            emitter.onError(th);
        }
    }
}
