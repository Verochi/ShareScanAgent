package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableCache<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> implements io.reactivex.FlowableSubscriber<T> {
    public static final io.reactivex.internal.operators.flowable.FlowableCache.CacheSubscription[] C = new io.reactivex.internal.operators.flowable.FlowableCache.CacheSubscription[0];
    public static final io.reactivex.internal.operators.flowable.FlowableCache.CacheSubscription[] D = new io.reactivex.internal.operators.flowable.FlowableCache.CacheSubscription[0];
    public java.lang.Throwable A;
    public volatile boolean B;
    public final java.util.concurrent.atomic.AtomicBoolean t;
    public final int u;
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableCache.CacheSubscription<T>[]> v;
    public volatile long w;
    public final io.reactivex.internal.operators.flowable.FlowableCache.Node<T> x;
    public io.reactivex.internal.operators.flowable.FlowableCache.Node<T> y;
    public int z;

    public static final class CacheSubscription<T> extends java.util.concurrent.atomic.AtomicInteger implements org.reactivestreams.Subscription {
        private static final long serialVersionUID = 6770240836423125754L;
        final org.reactivestreams.Subscriber<? super T> downstream;
        long index;
        io.reactivex.internal.operators.flowable.FlowableCache.Node<T> node;
        int offset;
        final io.reactivex.internal.operators.flowable.FlowableCache<T> parent;
        final java.util.concurrent.atomic.AtomicLong requested = new java.util.concurrent.atomic.AtomicLong();

        public CacheSubscription(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.internal.operators.flowable.FlowableCache<T> flowableCache) {
            this.downstream = subscriber;
            this.parent = flowableCache;
            this.node = flowableCache.x;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.requested.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.f(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.BackpressureHelper.addCancel(this.requested, j);
                this.parent.g(this);
            }
        }
    }

    public static final class Node<T> {
        public final T[] a;
        public volatile io.reactivex.internal.operators.flowable.FlowableCache.Node<T> b;

        public Node(int i) {
            this.a = (T[]) new java.lang.Object[i];
        }
    }

    public FlowableCache(io.reactivex.Flowable<T> flowable, int i) {
        super(flowable);
        this.u = i;
        this.t = new java.util.concurrent.atomic.AtomicBoolean();
        io.reactivex.internal.operators.flowable.FlowableCache.Node<T> node = new io.reactivex.internal.operators.flowable.FlowableCache.Node<>(i);
        this.x = node;
        this.y = node;
        this.v = new java.util.concurrent.atomic.AtomicReference<>(C);
    }

    public void e(io.reactivex.internal.operators.flowable.FlowableCache.CacheSubscription<T> cacheSubscription) {
        io.reactivex.internal.operators.flowable.FlowableCache.CacheSubscription<T>[] cacheSubscriptionArr;
        io.reactivex.internal.operators.flowable.FlowableCache.CacheSubscription[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = this.v.get();
            if (cacheSubscriptionArr == D) {
                return;
            }
            int length = cacheSubscriptionArr.length;
            cacheSubscriptionArr2 = new io.reactivex.internal.operators.flowable.FlowableCache.CacheSubscription[length + 1];
            java.lang.System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr2, 0, length);
            cacheSubscriptionArr2[length] = cacheSubscription;
        } while (!defpackage.xv0.a(this.v, cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    public void f(io.reactivex.internal.operators.flowable.FlowableCache.CacheSubscription<T> cacheSubscription) {
        io.reactivex.internal.operators.flowable.FlowableCache.CacheSubscription<T>[] cacheSubscriptionArr;
        io.reactivex.internal.operators.flowable.FlowableCache.CacheSubscription[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = this.v.get();
            int length = cacheSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (cacheSubscriptionArr[i] == cacheSubscription) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                cacheSubscriptionArr2 = C;
            } else {
                io.reactivex.internal.operators.flowable.FlowableCache.CacheSubscription[] cacheSubscriptionArr3 = new io.reactivex.internal.operators.flowable.FlowableCache.CacheSubscription[length - 1];
                java.lang.System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr3, 0, i);
                java.lang.System.arraycopy(cacheSubscriptionArr, i + 1, cacheSubscriptionArr3, i, (length - i) - 1);
                cacheSubscriptionArr2 = cacheSubscriptionArr3;
            }
        } while (!defpackage.xv0.a(this.v, cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    public void g(io.reactivex.internal.operators.flowable.FlowableCache.CacheSubscription<T> cacheSubscription) {
        if (cacheSubscription.getAndIncrement() != 0) {
            return;
        }
        long j = cacheSubscription.index;
        int i = cacheSubscription.offset;
        io.reactivex.internal.operators.flowable.FlowableCache.Node<T> node = cacheSubscription.node;
        java.util.concurrent.atomic.AtomicLong atomicLong = cacheSubscription.requested;
        org.reactivestreams.Subscriber<? super T> subscriber = cacheSubscription.downstream;
        int i2 = this.u;
        int i3 = 1;
        while (true) {
            boolean z = this.B;
            boolean z2 = this.w == j;
            if (z && z2) {
                cacheSubscription.node = null;
                java.lang.Throwable th = this.A;
                if (th != null) {
                    subscriber.onError(th);
                    return;
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            if (!z2) {
                long j2 = atomicLong.get();
                if (j2 == Long.MIN_VALUE) {
                    cacheSubscription.node = null;
                    return;
                } else if (j2 != j) {
                    if (i == i2) {
                        node = node.b;
                        i = 0;
                    }
                    subscriber.onNext(node.a[i]);
                    i++;
                    j++;
                }
            }
            cacheSubscription.index = j;
            cacheSubscription.offset = i;
            cacheSubscription.node = node;
            i3 = cacheSubscription.addAndGet(-i3);
            if (i3 == 0) {
                return;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.B = true;
        for (io.reactivex.internal.operators.flowable.FlowableCache.CacheSubscription<T> cacheSubscription : this.v.getAndSet(D)) {
            g(cacheSubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(java.lang.Throwable th) {
        if (this.B) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            return;
        }
        this.A = th;
        this.B = true;
        for (io.reactivex.internal.operators.flowable.FlowableCache.CacheSubscription<T> cacheSubscription : this.v.getAndSet(D)) {
            g(cacheSubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        int i = this.z;
        if (i == this.u) {
            io.reactivex.internal.operators.flowable.FlowableCache.Node<T> node = new io.reactivex.internal.operators.flowable.FlowableCache.Node<>(i);
            node.a[0] = t;
            this.z = 1;
            this.y.b = node;
            this.y = node;
        } else {
            this.y.a[i] = t;
            this.z = i + 1;
        }
        this.w++;
        for (io.reactivex.internal.operators.flowable.FlowableCache.CacheSubscription<T> cacheSubscription : this.v.get()) {
            g(cacheSubscription);
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(org.reactivestreams.Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.internal.operators.flowable.FlowableCache.CacheSubscription<T> cacheSubscription = new io.reactivex.internal.operators.flowable.FlowableCache.CacheSubscription<>(subscriber, this);
        subscriber.onSubscribe(cacheSubscription);
        e(cacheSubscription);
        if (this.t.get() || !this.t.compareAndSet(false, true)) {
            g(cacheSubscription);
        } else {
            this.source.subscribe((io.reactivex.FlowableSubscriber) this);
        }
    }
}
