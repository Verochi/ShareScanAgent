package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableMergeArray extends io.reactivex.Completable {
    public final io.reactivex.CompletableSource[] n;

    public static final class InnerCompletableObserver extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.CompletableObserver {
        private static final long serialVersionUID = -8360547806504310570L;
        final io.reactivex.CompletableObserver downstream;
        final java.util.concurrent.atomic.AtomicBoolean once;
        final io.reactivex.disposables.CompositeDisposable set;

        public InnerCompletableObserver(io.reactivex.CompletableObserver completableObserver, java.util.concurrent.atomic.AtomicBoolean atomicBoolean, io.reactivex.disposables.CompositeDisposable compositeDisposable, int i) {
            this.downstream = completableObserver;
            this.once = atomicBoolean;
            this.set = compositeDisposable;
            lazySet(i);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (decrementAndGet() == 0 && this.once.compareAndSet(false, true)) {
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
            this.set.dispose();
            if (this.once.compareAndSet(false, true)) {
                this.downstream.onError(th);
            } else {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.set.add(disposable);
        }
    }

    public CompletableMergeArray(io.reactivex.CompletableSource[] completableSourceArr) {
        this.n = completableSourceArr;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        io.reactivex.disposables.CompositeDisposable compositeDisposable = new io.reactivex.disposables.CompositeDisposable();
        io.reactivex.internal.operators.completable.CompletableMergeArray.InnerCompletableObserver innerCompletableObserver = new io.reactivex.internal.operators.completable.CompletableMergeArray.InnerCompletableObserver(completableObserver, new java.util.concurrent.atomic.AtomicBoolean(), compositeDisposable, this.n.length + 1);
        completableObserver.onSubscribe(compositeDisposable);
        for (io.reactivex.CompletableSource completableSource : this.n) {
            if (compositeDisposable.isDisposed()) {
                return;
            }
            if (completableSource == null) {
                compositeDisposable.dispose();
                innerCompletableObserver.onError(new java.lang.NullPointerException("A completable source is null"));
                return;
            }
            completableSource.subscribe(innerCompletableObserver);
        }
        innerCompletableObserver.onComplete();
    }
}
