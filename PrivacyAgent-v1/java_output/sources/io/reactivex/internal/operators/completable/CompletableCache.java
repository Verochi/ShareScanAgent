package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableCache extends io.reactivex.Completable implements io.reactivex.CompletableObserver {
    public static final io.reactivex.internal.operators.completable.CompletableCache.InnerCompletableCache[] w = new io.reactivex.internal.operators.completable.CompletableCache.InnerCompletableCache[0];
    public static final io.reactivex.internal.operators.completable.CompletableCache.InnerCompletableCache[] x = new io.reactivex.internal.operators.completable.CompletableCache.InnerCompletableCache[0];
    public final io.reactivex.CompletableSource n;
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.completable.CompletableCache.InnerCompletableCache[]> t = new java.util.concurrent.atomic.AtomicReference<>(w);
    public final java.util.concurrent.atomic.AtomicBoolean u = new java.util.concurrent.atomic.AtomicBoolean();
    public java.lang.Throwable v;

    public final class InnerCompletableCache extends java.util.concurrent.atomic.AtomicBoolean implements io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 8943152917179642732L;
        final io.reactivex.CompletableObserver downstream;

        public InnerCompletableCache(io.reactivex.CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                io.reactivex.internal.operators.completable.CompletableCache.this.f(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }
    }

    public CompletableCache(io.reactivex.CompletableSource completableSource) {
        this.n = completableSource;
    }

    public boolean e(io.reactivex.internal.operators.completable.CompletableCache.InnerCompletableCache innerCompletableCache) {
        io.reactivex.internal.operators.completable.CompletableCache.InnerCompletableCache[] innerCompletableCacheArr;
        io.reactivex.internal.operators.completable.CompletableCache.InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.t.get();
            if (innerCompletableCacheArr == x) {
                return false;
            }
            int length = innerCompletableCacheArr.length;
            innerCompletableCacheArr2 = new io.reactivex.internal.operators.completable.CompletableCache.InnerCompletableCache[length + 1];
            java.lang.System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr2, 0, length);
            innerCompletableCacheArr2[length] = innerCompletableCache;
        } while (!defpackage.xv0.a(this.t, innerCompletableCacheArr, innerCompletableCacheArr2));
        return true;
    }

    public void f(io.reactivex.internal.operators.completable.CompletableCache.InnerCompletableCache innerCompletableCache) {
        io.reactivex.internal.operators.completable.CompletableCache.InnerCompletableCache[] innerCompletableCacheArr;
        io.reactivex.internal.operators.completable.CompletableCache.InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.t.get();
            int length = innerCompletableCacheArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (innerCompletableCacheArr[i] == innerCompletableCache) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                innerCompletableCacheArr2 = w;
            } else {
                io.reactivex.internal.operators.completable.CompletableCache.InnerCompletableCache[] innerCompletableCacheArr3 = new io.reactivex.internal.operators.completable.CompletableCache.InnerCompletableCache[length - 1];
                java.lang.System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr3, 0, i);
                java.lang.System.arraycopy(innerCompletableCacheArr, i + 1, innerCompletableCacheArr3, i, (length - i) - 1);
                innerCompletableCacheArr2 = innerCompletableCacheArr3;
            }
        } while (!defpackage.xv0.a(this.t, innerCompletableCacheArr, innerCompletableCacheArr2));
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        for (io.reactivex.internal.operators.completable.CompletableCache.InnerCompletableCache innerCompletableCache : this.t.getAndSet(x)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.downstream.onComplete();
            }
        }
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(java.lang.Throwable th) {
        this.v = th;
        for (io.reactivex.internal.operators.completable.CompletableCache.InnerCompletableCache innerCompletableCache : this.t.getAndSet(x)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.downstream.onError(th);
            }
        }
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        io.reactivex.internal.operators.completable.CompletableCache.InnerCompletableCache innerCompletableCache = new io.reactivex.internal.operators.completable.CompletableCache.InnerCompletableCache(completableObserver);
        completableObserver.onSubscribe(innerCompletableCache);
        if (e(innerCompletableCache)) {
            if (innerCompletableCache.isDisposed()) {
                f(innerCompletableCache);
            }
            if (this.u.compareAndSet(false, true)) {
                this.n.subscribe(this);
                return;
            }
            return;
        }
        java.lang.Throwable th = this.v;
        if (th != null) {
            completableObserver.onError(th);
        } else {
            completableObserver.onComplete();
        }
    }
}
