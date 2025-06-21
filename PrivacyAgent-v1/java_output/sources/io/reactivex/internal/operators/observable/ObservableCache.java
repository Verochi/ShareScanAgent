package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableCache<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> implements io.reactivex.Observer<T> {
    public static final io.reactivex.internal.operators.observable.ObservableCache.CacheDisposable[] B = new io.reactivex.internal.operators.observable.ObservableCache.CacheDisposable[0];
    public static final io.reactivex.internal.operators.observable.ObservableCache.CacheDisposable[] C = new io.reactivex.internal.operators.observable.ObservableCache.CacheDisposable[0];
    public volatile boolean A;
    public final java.util.concurrent.atomic.AtomicBoolean n;
    public final int t;
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableCache.CacheDisposable<T>[]> u;
    public volatile long v;
    public final io.reactivex.internal.operators.observable.ObservableCache.Node<T> w;
    public io.reactivex.internal.operators.observable.ObservableCache.Node<T> x;
    public int y;
    public java.lang.Throwable z;

    public static final class CacheDisposable<T> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 6770240836423125754L;
        volatile boolean disposed;
        final io.reactivex.Observer<? super T> downstream;
        long index;
        io.reactivex.internal.operators.observable.ObservableCache.Node<T> node;
        int offset;
        final io.reactivex.internal.operators.observable.ObservableCache<T> parent;

        public CacheDisposable(io.reactivex.Observer<? super T> observer, io.reactivex.internal.operators.observable.ObservableCache<T> observableCache) {
            this.downstream = observer;
            this.parent = observableCache;
            this.node = observableCache.w;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            this.parent.e(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    public static final class Node<T> {
        public final T[] a;
        public volatile io.reactivex.internal.operators.observable.ObservableCache.Node<T> b;

        public Node(int i) {
            this.a = (T[]) new java.lang.Object[i];
        }
    }

    public ObservableCache(io.reactivex.Observable<T> observable, int i) {
        super(observable);
        this.t = i;
        this.n = new java.util.concurrent.atomic.AtomicBoolean();
        io.reactivex.internal.operators.observable.ObservableCache.Node<T> node = new io.reactivex.internal.operators.observable.ObservableCache.Node<>(i);
        this.w = node;
        this.x = node;
        this.u = new java.util.concurrent.atomic.AtomicReference<>(B);
    }

    public void d(io.reactivex.internal.operators.observable.ObservableCache.CacheDisposable<T> cacheDisposable) {
        io.reactivex.internal.operators.observable.ObservableCache.CacheDisposable<T>[] cacheDisposableArr;
        io.reactivex.internal.operators.observable.ObservableCache.CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.u.get();
            if (cacheDisposableArr == C) {
                return;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new io.reactivex.internal.operators.observable.ObservableCache.CacheDisposable[length + 1];
            java.lang.System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!defpackage.xv0.a(this.u, cacheDisposableArr, cacheDisposableArr2));
    }

    public void e(io.reactivex.internal.operators.observable.ObservableCache.CacheDisposable<T> cacheDisposable) {
        io.reactivex.internal.operators.observable.ObservableCache.CacheDisposable<T>[] cacheDisposableArr;
        io.reactivex.internal.operators.observable.ObservableCache.CacheDisposable[] cacheDisposableArr2;
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
                cacheDisposableArr2 = B;
            } else {
                io.reactivex.internal.operators.observable.ObservableCache.CacheDisposable[] cacheDisposableArr3 = new io.reactivex.internal.operators.observable.ObservableCache.CacheDisposable[length - 1];
                java.lang.System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i);
                java.lang.System.arraycopy(cacheDisposableArr, i + 1, cacheDisposableArr3, i, (length - i) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!defpackage.xv0.a(this.u, cacheDisposableArr, cacheDisposableArr2));
    }

    public void f(io.reactivex.internal.operators.observable.ObservableCache.CacheDisposable<T> cacheDisposable) {
        if (cacheDisposable.getAndIncrement() != 0) {
            return;
        }
        long j = cacheDisposable.index;
        int i = cacheDisposable.offset;
        io.reactivex.internal.operators.observable.ObservableCache.Node<T> node = cacheDisposable.node;
        io.reactivex.Observer<? super T> observer = cacheDisposable.downstream;
        int i2 = this.t;
        int i3 = 1;
        while (!cacheDisposable.disposed) {
            boolean z = this.A;
            boolean z2 = this.v == j;
            if (z && z2) {
                cacheDisposable.node = null;
                java.lang.Throwable th = this.z;
                if (th != null) {
                    observer.onError(th);
                    return;
                } else {
                    observer.onComplete();
                    return;
                }
            }
            if (z2) {
                cacheDisposable.index = j;
                cacheDisposable.offset = i;
                cacheDisposable.node = node;
                i3 = cacheDisposable.addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            } else {
                if (i == i2) {
                    node = node.b;
                    i = 0;
                }
                observer.onNext(node.a[i]);
                i++;
                j++;
            }
        }
        cacheDisposable.node = null;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.A = true;
        for (io.reactivex.internal.operators.observable.ObservableCache.CacheDisposable<T> cacheDisposable : this.u.getAndSet(C)) {
            f(cacheDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(java.lang.Throwable th) {
        this.z = th;
        this.A = true;
        for (io.reactivex.internal.operators.observable.ObservableCache.CacheDisposable<T> cacheDisposable : this.u.getAndSet(C)) {
            f(cacheDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        int i = this.y;
        if (i == this.t) {
            io.reactivex.internal.operators.observable.ObservableCache.Node<T> node = new io.reactivex.internal.operators.observable.ObservableCache.Node<>(i);
            node.a[0] = t;
            this.y = 1;
            this.x.b = node;
            this.x = node;
        } else {
            this.x.a[i] = t;
            this.y = i + 1;
        }
        this.v++;
        for (io.reactivex.internal.operators.observable.ObservableCache.CacheDisposable<T> cacheDisposable : this.u.get()) {
            f(cacheDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.internal.operators.observable.ObservableCache.CacheDisposable<T> cacheDisposable = new io.reactivex.internal.operators.observable.ObservableCache.CacheDisposable<>(observer, this);
        observer.onSubscribe(cacheDisposable);
        d(cacheDisposable);
        if (this.n.get() || !this.n.compareAndSet(false, true)) {
            f(cacheDisposable);
        } else {
            this.source.subscribe(this);
        }
    }
}
