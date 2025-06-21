package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableCreate extends io.reactivex.Completable {
    public final io.reactivex.CompletableOnSubscribe n;

    public static final class Emitter extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.CompletableEmitter, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -2467358622224974244L;
        final io.reactivex.CompletableObserver downstream;

        public Emitter(io.reactivex.CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.CompletableEmitter, io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.CompletableEmitter
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

        @Override // io.reactivex.CompletableEmitter
        public void onError(java.lang.Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            io.reactivex.plugins.RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.CompletableEmitter
        public void setCancellable(io.reactivex.functions.Cancellable cancellable) {
            setDisposable(new io.reactivex.internal.disposables.CancellableDisposable(cancellable));
        }

        @Override // io.reactivex.CompletableEmitter
        public void setDisposable(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.set(this, disposable);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public java.lang.String toString() {
            return java.lang.String.format("%s{%s}", io.reactivex.internal.operators.completable.CompletableCreate.Emitter.class.getSimpleName(), super.toString());
        }

        @Override // io.reactivex.CompletableEmitter
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

    public CompletableCreate(io.reactivex.CompletableOnSubscribe completableOnSubscribe) {
        this.n = completableOnSubscribe;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        io.reactivex.internal.operators.completable.CompletableCreate.Emitter emitter = new io.reactivex.internal.operators.completable.CompletableCreate.Emitter(completableObserver);
        completableObserver.onSubscribe(emitter);
        try {
            this.n.subscribe(emitter);
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            emitter.onError(th);
        }
    }
}
