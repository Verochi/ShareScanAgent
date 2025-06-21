package io.reactivex.processors;

@io.reactivex.annotations.SchedulerSupport("none")
@io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
/* loaded from: classes13.dex */
public final class MulticastProcessor<T> extends io.reactivex.processors.FlowableProcessor<T> {
    public static final io.reactivex.processors.MulticastProcessor.MulticastSubscription[] F = new io.reactivex.processors.MulticastProcessor.MulticastSubscription[0];
    public static final io.reactivex.processors.MulticastProcessor.MulticastSubscription[] G = new io.reactivex.processors.MulticastProcessor.MulticastSubscription[0];
    public volatile io.reactivex.internal.fuseable.SimpleQueue<T> A;
    public volatile boolean B;
    public volatile java.lang.Throwable C;
    public int D;
    public int E;
    public final java.util.concurrent.atomic.AtomicInteger t;
    public final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> u;
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.processors.MulticastProcessor.MulticastSubscription<T>[]> v;
    public final java.util.concurrent.atomic.AtomicBoolean w;
    public final int x;
    public final int y;
    public final boolean z;

    public static final class MulticastSubscription<T> extends java.util.concurrent.atomic.AtomicLong implements org.reactivestreams.Subscription {
        private static final long serialVersionUID = -363282618957264509L;
        final org.reactivestreams.Subscriber<? super T> downstream;
        long emitted;
        final io.reactivex.processors.MulticastProcessor<T> parent;

        public MulticastSubscription(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.processors.MulticastProcessor<T> multicastProcessor) {
            this.downstream = subscriber;
            this.parent = multicastProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.g(this);
            }
        }

        public void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onComplete();
            }
        }

        public void onError(java.lang.Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onError(th);
            }
        }

        public void onNext(T t) {
            if (get() != Long.MIN_VALUE) {
                this.emitted++;
                this.downstream.onNext(t);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            long j2;
            long j3;
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                do {
                    j2 = get();
                    if (j2 == Long.MIN_VALUE) {
                        return;
                    }
                    if (j2 == Long.MAX_VALUE) {
                        return;
                    } else {
                        j3 = j2 + j;
                    }
                } while (!compareAndSet(j2, j3 >= 0 ? j3 : Long.MAX_VALUE));
                this.parent.f();
            }
        }
    }

    public MulticastProcessor(int i, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        this.x = i;
        this.y = i - (i >> 2);
        this.t = new java.util.concurrent.atomic.AtomicInteger();
        this.v = new java.util.concurrent.atomic.AtomicReference<>(F);
        this.u = new java.util.concurrent.atomic.AtomicReference<>();
        this.z = z;
        this.w = new java.util.concurrent.atomic.AtomicBoolean();
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.processors.MulticastProcessor<T> create() {
        return new io.reactivex.processors.MulticastProcessor<>(io.reactivex.Flowable.bufferSize(), false);
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.processors.MulticastProcessor<T> create(int i) {
        return new io.reactivex.processors.MulticastProcessor<>(i, false);
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.processors.MulticastProcessor<T> create(int i, boolean z) {
        return new io.reactivex.processors.MulticastProcessor<>(i, z);
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.processors.MulticastProcessor<T> create(boolean z) {
        return new io.reactivex.processors.MulticastProcessor<>(io.reactivex.Flowable.bufferSize(), z);
    }

    public boolean e(io.reactivex.processors.MulticastProcessor.MulticastSubscription<T> multicastSubscription) {
        io.reactivex.processors.MulticastProcessor.MulticastSubscription<T>[] multicastSubscriptionArr;
        io.reactivex.processors.MulticastProcessor.MulticastSubscription[] multicastSubscriptionArr2;
        do {
            multicastSubscriptionArr = this.v.get();
            if (multicastSubscriptionArr == G) {
                return false;
            }
            int length = multicastSubscriptionArr.length;
            multicastSubscriptionArr2 = new io.reactivex.processors.MulticastProcessor.MulticastSubscription[length + 1];
            java.lang.System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
            multicastSubscriptionArr2[length] = multicastSubscription;
        } while (!defpackage.xv0.a(this.v, multicastSubscriptionArr, multicastSubscriptionArr2));
        return true;
    }

    public void f() {
        T t;
        if (this.t.getAndIncrement() != 0) {
            return;
        }
        java.util.concurrent.atomic.AtomicReference<io.reactivex.processors.MulticastProcessor.MulticastSubscription<T>[]> atomicReference = this.v;
        int i = this.D;
        int i2 = this.y;
        int i3 = this.E;
        int i4 = 1;
        while (true) {
            io.reactivex.internal.fuseable.SimpleQueue<T> simpleQueue = this.A;
            if (simpleQueue != null) {
                io.reactivex.processors.MulticastProcessor.MulticastSubscription<T>[] multicastSubscriptionArr = atomicReference.get();
                if (multicastSubscriptionArr.length != 0) {
                    int length = multicastSubscriptionArr.length;
                    long j = -1;
                    long j2 = -1;
                    int i5 = 0;
                    while (i5 < length) {
                        io.reactivex.processors.MulticastProcessor.MulticastSubscription<T> multicastSubscription = multicastSubscriptionArr[i5];
                        long j3 = multicastSubscription.get();
                        if (j3 >= 0) {
                            j2 = j2 == j ? j3 - multicastSubscription.emitted : java.lang.Math.min(j2, j3 - multicastSubscription.emitted);
                        }
                        i5++;
                        j = -1;
                    }
                    int i6 = i;
                    while (j2 > 0) {
                        io.reactivex.processors.MulticastProcessor.MulticastSubscription<T>[] multicastSubscriptionArr2 = atomicReference.get();
                        if (multicastSubscriptionArr2 == G) {
                            simpleQueue.clear();
                            return;
                        }
                        if (multicastSubscriptionArr != multicastSubscriptionArr2) {
                            break;
                        }
                        boolean z = this.B;
                        try {
                            t = simpleQueue.poll();
                        } catch (java.lang.Throwable th) {
                            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.u);
                            this.C = th;
                            this.B = true;
                            t = null;
                            z = true;
                        }
                        boolean z2 = t == null;
                        if (z && z2) {
                            java.lang.Throwable th2 = this.C;
                            if (th2 != null) {
                                for (io.reactivex.processors.MulticastProcessor.MulticastSubscription<T> multicastSubscription2 : atomicReference.getAndSet(G)) {
                                    multicastSubscription2.onError(th2);
                                }
                                return;
                            }
                            for (io.reactivex.processors.MulticastProcessor.MulticastSubscription<T> multicastSubscription3 : atomicReference.getAndSet(G)) {
                                multicastSubscription3.onComplete();
                            }
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        for (io.reactivex.processors.MulticastProcessor.MulticastSubscription<T> multicastSubscription4 : multicastSubscriptionArr) {
                            multicastSubscription4.onNext(t);
                        }
                        j2--;
                        if (i3 != 1 && (i6 = i6 + 1) == i2) {
                            this.u.get().request(i2);
                            i6 = 0;
                        }
                    }
                    if (j2 == 0) {
                        io.reactivex.processors.MulticastProcessor.MulticastSubscription<T>[] multicastSubscriptionArr3 = atomicReference.get();
                        io.reactivex.processors.MulticastProcessor.MulticastSubscription<T>[] multicastSubscriptionArr4 = G;
                        if (multicastSubscriptionArr3 == multicastSubscriptionArr4) {
                            simpleQueue.clear();
                            return;
                        }
                        if (multicastSubscriptionArr != multicastSubscriptionArr3) {
                            i = i6;
                        } else if (this.B && simpleQueue.isEmpty()) {
                            java.lang.Throwable th3 = this.C;
                            if (th3 != null) {
                                for (io.reactivex.processors.MulticastProcessor.MulticastSubscription<T> multicastSubscription5 : atomicReference.getAndSet(multicastSubscriptionArr4)) {
                                    multicastSubscription5.onError(th3);
                                }
                                return;
                            }
                            for (io.reactivex.processors.MulticastProcessor.MulticastSubscription<T> multicastSubscription6 : atomicReference.getAndSet(multicastSubscriptionArr4)) {
                                multicastSubscription6.onComplete();
                            }
                            return;
                        }
                    }
                    i = i6;
                }
            }
            this.D = i;
            i4 = this.t.addAndGet(-i4);
            if (i4 == 0) {
                return;
            }
        }
    }

    public void g(io.reactivex.processors.MulticastProcessor.MulticastSubscription<T> multicastSubscription) {
        while (true) {
            io.reactivex.processors.MulticastProcessor.MulticastSubscription<T>[] multicastSubscriptionArr = this.v.get();
            int length = multicastSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (multicastSubscriptionArr[i] == multicastSubscription) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length != 1) {
                io.reactivex.processors.MulticastProcessor.MulticastSubscription[] multicastSubscriptionArr2 = new io.reactivex.processors.MulticastProcessor.MulticastSubscription[length - 1];
                java.lang.System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, i);
                java.lang.System.arraycopy(multicastSubscriptionArr, i + 1, multicastSubscriptionArr2, i, (length - i) - 1);
                if (defpackage.xv0.a(this.v, multicastSubscriptionArr, multicastSubscriptionArr2)) {
                    return;
                }
            } else if (this.z) {
                if (defpackage.xv0.a(this.v, multicastSubscriptionArr, G)) {
                    io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.u);
                    this.w.set(true);
                    return;
                }
            } else if (defpackage.xv0.a(this.v, multicastSubscriptionArr, F)) {
                return;
            }
        }
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public java.lang.Throwable getThrowable() {
        if (this.w.get()) {
            return this.C;
        }
        return null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return this.w.get() && this.C == null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.v.get().length != 0;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return this.w.get() && this.C != null;
    }

    public boolean offer(T t) {
        if (this.w.get()) {
            return false;
        }
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "offer called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.E != 0 || !this.A.offer(t)) {
            return false;
        }
        f();
        return true;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.w.compareAndSet(false, true)) {
            this.B = true;
            f();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(java.lang.Throwable th) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.w.compareAndSet(false, true)) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            return;
        }
        this.C = th;
        this.B = true;
        f();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.w.get()) {
            return;
        }
        if (this.E == 0) {
            io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (!this.A.offer(t)) {
                io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.u);
                onError(new io.reactivex.exceptions.MissingBackpressureException());
                return;
            }
        }
        f();
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(org.reactivestreams.Subscription subscription) {
        if (io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this.u, subscription)) {
            if (subscription instanceof io.reactivex.internal.fuseable.QueueSubscription) {
                io.reactivex.internal.fuseable.QueueSubscription queueSubscription = (io.reactivex.internal.fuseable.QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.E = requestFusion;
                    this.A = queueSubscription;
                    this.B = true;
                    f();
                    return;
                }
                if (requestFusion == 2) {
                    this.E = requestFusion;
                    this.A = queueSubscription;
                    subscription.request(this.x);
                    return;
                }
            }
            this.A = new io.reactivex.internal.queue.SpscArrayQueue(this.x);
            subscription.request(this.x);
        }
    }

    public void start() {
        if (io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this.u, io.reactivex.internal.subscriptions.EmptySubscription.INSTANCE)) {
            this.A = new io.reactivex.internal.queue.SpscArrayQueue(this.x);
        }
    }

    public void startUnbounded() {
        if (io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this.u, io.reactivex.internal.subscriptions.EmptySubscription.INSTANCE)) {
            this.A = new io.reactivex.internal.queue.SpscLinkedArrayQueue(this.x);
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        java.lang.Throwable th;
        io.reactivex.processors.MulticastProcessor.MulticastSubscription<T> multicastSubscription = new io.reactivex.processors.MulticastProcessor.MulticastSubscription<>(subscriber, this);
        subscriber.onSubscribe(multicastSubscription);
        if (e(multicastSubscription)) {
            if (multicastSubscription.get() == Long.MIN_VALUE) {
                g(multicastSubscription);
                return;
            } else {
                f();
                return;
            }
        }
        if ((this.w.get() || !this.z) && (th = this.C) != null) {
            subscriber.onError(th);
        } else {
            subscriber.onComplete();
        }
    }
}
