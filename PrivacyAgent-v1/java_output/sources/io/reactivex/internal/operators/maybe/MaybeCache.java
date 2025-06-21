package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeCache<T> extends io.reactivex.Maybe<T> implements io.reactivex.MaybeObserver<T> {
    public static final io.reactivex.internal.operators.maybe.MaybeCache.CacheDisposable[] w = new io.reactivex.internal.operators.maybe.MaybeCache.CacheDisposable[0];
    public static final io.reactivex.internal.operators.maybe.MaybeCache.CacheDisposable[] x = new io.reactivex.internal.operators.maybe.MaybeCache.CacheDisposable[0];
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.MaybeSource<T>> n;
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.maybe.MaybeCache.CacheDisposable<T>[]> t = new java.util.concurrent.atomic.AtomicReference<>(w);
    public T u;
    public java.lang.Throwable v;

    public static final class CacheDisposable<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.maybe.MaybeCache<T>> implements io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -5791853038359966195L;
        final io.reactivex.MaybeObserver<? super T> downstream;

        public CacheDisposable(io.reactivex.MaybeObserver<? super T> maybeObserver, io.reactivex.internal.operators.maybe.MaybeCache<T> maybeCache) {
            super(maybeCache);
            this.downstream = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.operators.maybe.MaybeCache<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.b(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }
    }

    public MaybeCache(io.reactivex.MaybeSource<T> maybeSource) {
        this.n = new java.util.concurrent.atomic.AtomicReference<>(maybeSource);
    }

    public boolean a(io.reactivex.internal.operators.maybe.MaybeCache.CacheDisposable<T> cacheDisposable) {
        io.reactivex.internal.operators.maybe.MaybeCache.CacheDisposable<T>[] cacheDisposableArr;
        io.reactivex.internal.operators.maybe.MaybeCache.CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.t.get();
            if (cacheDisposableArr == x) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new io.reactivex.internal.operators.maybe.MaybeCache.CacheDisposable[length + 1];
            java.lang.System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!defpackage.xv0.a(this.t, cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    public void b(io.reactivex.internal.operators.maybe.MaybeCache.CacheDisposable<T> cacheDisposable) {
        io.reactivex.internal.operators.maybe.MaybeCache.CacheDisposable<T>[] cacheDisposableArr;
        io.reactivex.internal.operators.maybe.MaybeCache.CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.t.get();
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
                cacheDisposableArr2 = w;
            } else {
                io.reactivex.internal.operators.maybe.MaybeCache.CacheDisposable[] cacheDisposableArr3 = new io.reactivex.internal.operators.maybe.MaybeCache.CacheDisposable[length - 1];
                java.lang.System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i);
                java.lang.System.arraycopy(cacheDisposableArr, i + 1, cacheDisposableArr3, i, (length - i) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!defpackage.xv0.a(this.t, cacheDisposableArr, cacheDisposableArr2));
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        for (io.reactivex.internal.operators.maybe.MaybeCache.CacheDisposable<T> cacheDisposable : this.t.getAndSet(x)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onComplete();
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(java.lang.Throwable th) {
        this.v = th;
        for (io.reactivex.internal.operators.maybe.MaybeCache.CacheDisposable<T> cacheDisposable : this.t.getAndSet(x)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onError(th);
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T t) {
        this.u = t;
        for (io.reactivex.internal.operators.maybe.MaybeCache.CacheDisposable<T> cacheDisposable : this.t.getAndSet(x)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onSuccess(t);
            }
        }
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        io.reactivex.internal.operators.maybe.MaybeCache.CacheDisposable<T> cacheDisposable = new io.reactivex.internal.operators.maybe.MaybeCache.CacheDisposable<>(maybeObserver, this);
        maybeObserver.onSubscribe(cacheDisposable);
        if (a(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                b(cacheDisposable);
                return;
            }
            io.reactivex.MaybeSource<T> andSet = this.n.getAndSet(null);
            if (andSet != null) {
                andSet.subscribe(this);
                return;
            }
            return;
        }
        if (cacheDisposable.isDisposed()) {
            return;
        }
        java.lang.Throwable th = this.v;
        if (th != null) {
            maybeObserver.onError(th);
            return;
        }
        T t = this.u;
        if (t != null) {
            maybeObserver.onSuccess(t);
        } else {
            maybeObserver.onComplete();
        }
    }
}
