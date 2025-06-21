package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleCache<T> extends io.reactivex.Single<T> implements io.reactivex.SingleObserver<T> {
    public static final io.reactivex.internal.operators.single.SingleCache.CacheDisposable[] x = new io.reactivex.internal.operators.single.SingleCache.CacheDisposable[0];
    public static final io.reactivex.internal.operators.single.SingleCache.CacheDisposable[] y = new io.reactivex.internal.operators.single.SingleCache.CacheDisposable[0];
    public final io.reactivex.SingleSource<? extends T> n;
    public final java.util.concurrent.atomic.AtomicInteger t = new java.util.concurrent.atomic.AtomicInteger();
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.single.SingleCache.CacheDisposable<T>[]> u = new java.util.concurrent.atomic.AtomicReference<>(x);
    public T v;
    public java.lang.Throwable w;

    public static final class CacheDisposable<T> extends java.util.concurrent.atomic.AtomicBoolean implements io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 7514387411091976596L;
        final io.reactivex.SingleObserver<? super T> downstream;
        final io.reactivex.internal.operators.single.SingleCache<T> parent;

        public CacheDisposable(io.reactivex.SingleObserver<? super T> singleObserver, io.reactivex.internal.operators.single.SingleCache<T> singleCache) {
            this.downstream = singleObserver;
            this.parent = singleCache;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.d(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }
    }

    public SingleCache(io.reactivex.SingleSource<? extends T> singleSource) {
        this.n = singleSource;
    }

    public boolean c(io.reactivex.internal.operators.single.SingleCache.CacheDisposable<T> cacheDisposable) {
        io.reactivex.internal.operators.single.SingleCache.CacheDisposable<T>[] cacheDisposableArr;
        io.reactivex.internal.operators.single.SingleCache.CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.u.get();
            if (cacheDisposableArr == y) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new io.reactivex.internal.operators.single.SingleCache.CacheDisposable[length + 1];
            java.lang.System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!defpackage.xv0.a(this.u, cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    public void d(io.reactivex.internal.operators.single.SingleCache.CacheDisposable<T> cacheDisposable) {
        io.reactivex.internal.operators.single.SingleCache.CacheDisposable<T>[] cacheDisposableArr;
        io.reactivex.internal.operators.single.SingleCache.CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.u.get();
            int length = cacheDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (cacheDisposableArr[i] == cacheDisposable) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                cacheDisposableArr2 = x;
            } else {
                io.reactivex.internal.operators.single.SingleCache.CacheDisposable[] cacheDisposableArr3 = new io.reactivex.internal.operators.single.SingleCache.CacheDisposable[length - 1];
                java.lang.System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i);
                java.lang.System.arraycopy(cacheDisposableArr, i + 1, cacheDisposableArr3, i, (length - i) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!defpackage.xv0.a(this.u, cacheDisposableArr, cacheDisposableArr2));
    }

    @Override // io.reactivex.SingleObserver
    public void onError(java.lang.Throwable th) {
        this.w = th;
        for (io.reactivex.internal.operators.single.SingleCache.CacheDisposable<T> cacheDisposable : this.u.getAndSet(y)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onError(th);
            }
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T t) {
        this.v = t;
        for (io.reactivex.internal.operators.single.SingleCache.CacheDisposable<T> cacheDisposable : this.u.getAndSet(y)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onSuccess(t);
            }
        }
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        io.reactivex.internal.operators.single.SingleCache.CacheDisposable<T> cacheDisposable = new io.reactivex.internal.operators.single.SingleCache.CacheDisposable<>(singleObserver, this);
        singleObserver.onSubscribe(cacheDisposable);
        if (c(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                d(cacheDisposable);
            }
            if (this.t.getAndIncrement() == 0) {
                this.n.subscribe(this);
                return;
            }
            return;
        }
        java.lang.Throwable th = this.w;
        if (th != null) {
            singleObserver.onError(th);
        } else {
            singleObserver.onSuccess(this.v);
        }
    }
}
