package io.reactivex.processors;

/* loaded from: classes13.dex */
public final class UnicastProcessor<T> extends io.reactivex.processors.FlowableProcessor<T> {
    public final java.util.concurrent.atomic.AtomicBoolean A;
    public final io.reactivex.internal.subscriptions.BasicIntQueueSubscription<T> B;
    public final java.util.concurrent.atomic.AtomicLong C;
    public boolean D;
    public final io.reactivex.internal.queue.SpscLinkedArrayQueue<T> t;
    public final java.util.concurrent.atomic.AtomicReference<java.lang.Runnable> u;
    public final boolean v;
    public volatile boolean w;
    public java.lang.Throwable x;
    public final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscriber<? super T>> y;
    public volatile boolean z;

    public final class UnicastQueueSubscription extends io.reactivex.internal.subscriptions.BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        public UnicastQueueSubscription() {
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (io.reactivex.processors.UnicastProcessor.this.z) {
                return;
            }
            io.reactivex.processors.UnicastProcessor.this.z = true;
            io.reactivex.processors.UnicastProcessor.this.f();
            io.reactivex.processors.UnicastProcessor.this.y.lazySet(null);
            if (io.reactivex.processors.UnicastProcessor.this.B.getAndIncrement() == 0) {
                io.reactivex.processors.UnicastProcessor.this.y.lazySet(null);
                io.reactivex.processors.UnicastProcessor unicastProcessor = io.reactivex.processors.UnicastProcessor.this;
                if (unicastProcessor.D) {
                    return;
                }
                unicastProcessor.t.clear();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            io.reactivex.processors.UnicastProcessor.this.t.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return io.reactivex.processors.UnicastProcessor.this.t.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public T poll() {
            return io.reactivex.processors.UnicastProcessor.this.t.poll();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.BackpressureHelper.add(io.reactivex.processors.UnicastProcessor.this.C, j);
                io.reactivex.processors.UnicastProcessor.this.g();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            io.reactivex.processors.UnicastProcessor.this.D = true;
            return 2;
        }
    }

    public UnicastProcessor(int i) {
        this(i, null, true);
    }

    public UnicastProcessor(int i, java.lang.Runnable runnable) {
        this(i, runnable, true);
    }

    public UnicastProcessor(int i, java.lang.Runnable runnable, boolean z) {
        this.t = new io.reactivex.internal.queue.SpscLinkedArrayQueue<>(io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "capacityHint"));
        this.u = new java.util.concurrent.atomic.AtomicReference<>(runnable);
        this.v = z;
        this.y = new java.util.concurrent.atomic.AtomicReference<>();
        this.A = new java.util.concurrent.atomic.AtomicBoolean();
        this.B = new io.reactivex.processors.UnicastProcessor.UnicastQueueSubscription();
        this.C = new java.util.concurrent.atomic.AtomicLong();
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.processors.UnicastProcessor<T> create() {
        return new io.reactivex.processors.UnicastProcessor<>(io.reactivex.Flowable.bufferSize());
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.processors.UnicastProcessor<T> create(int i) {
        return new io.reactivex.processors.UnicastProcessor<>(i);
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.processors.UnicastProcessor<T> create(int i, java.lang.Runnable runnable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new io.reactivex.processors.UnicastProcessor<>(i, runnable);
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.processors.UnicastProcessor<T> create(int i, java.lang.Runnable runnable, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new io.reactivex.processors.UnicastProcessor<>(i, runnable, z);
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.processors.UnicastProcessor<T> create(boolean z) {
        return new io.reactivex.processors.UnicastProcessor<>(io.reactivex.Flowable.bufferSize(), null, z);
    }

    public boolean e(boolean z, boolean z2, boolean z3, org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.internal.queue.SpscLinkedArrayQueue<T> spscLinkedArrayQueue) {
        if (this.z) {
            spscLinkedArrayQueue.clear();
            this.y.lazySet(null);
            return true;
        }
        if (!z2) {
            return false;
        }
        if (z && this.x != null) {
            spscLinkedArrayQueue.clear();
            this.y.lazySet(null);
            subscriber.onError(this.x);
            return true;
        }
        if (!z3) {
            return false;
        }
        java.lang.Throwable th = this.x;
        this.y.lazySet(null);
        if (th != null) {
            subscriber.onError(th);
        } else {
            subscriber.onComplete();
        }
        return true;
    }

    public void f() {
        java.lang.Runnable andSet = this.u.getAndSet(null);
        if (andSet != null) {
            andSet.run();
        }
    }

    public void g() {
        if (this.B.getAndIncrement() != 0) {
            return;
        }
        org.reactivestreams.Subscriber<? super T> subscriber = this.y.get();
        int i = 1;
        while (subscriber == null) {
            i = this.B.addAndGet(-i);
            if (i == 0) {
                return;
            } else {
                subscriber = this.y.get();
            }
        }
        if (this.D) {
            h(subscriber);
        } else {
            i(subscriber);
        }
    }

    @Override // io.reactivex.processors.FlowableProcessor
    @io.reactivex.annotations.Nullable
    public java.lang.Throwable getThrowable() {
        if (this.w) {
            return this.x;
        }
        return null;
    }

    public void h(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.internal.queue.SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.t;
        int i = 1;
        boolean z = !this.v;
        while (!this.z) {
            boolean z2 = this.w;
            if (z && z2 && this.x != null) {
                spscLinkedArrayQueue.clear();
                this.y.lazySet(null);
                subscriber.onError(this.x);
                return;
            }
            subscriber.onNext(null);
            if (z2) {
                this.y.lazySet(null);
                java.lang.Throwable th = this.x;
                if (th != null) {
                    subscriber.onError(th);
                    return;
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            i = this.B.addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        this.y.lazySet(null);
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return this.w && this.x == null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.y.get() != null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return this.w && this.x != null;
    }

    public void i(org.reactivestreams.Subscriber<? super T> subscriber) {
        long j;
        io.reactivex.internal.queue.SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.t;
        boolean z = !this.v;
        int i = 1;
        do {
            long j2 = this.C.get();
            long j3 = 0;
            while (true) {
                if (j2 == j3) {
                    j = j3;
                    break;
                }
                boolean z2 = this.w;
                T poll = spscLinkedArrayQueue.poll();
                boolean z3 = poll == null;
                j = j3;
                if (e(z, z2, z3, subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (z3) {
                    break;
                }
                subscriber.onNext(poll);
                j3 = 1 + j;
            }
            if (j2 == j3 && e(z, this.w, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                return;
            }
            if (j != 0 && j2 != Long.MAX_VALUE) {
                this.C.addAndGet(-j);
            }
            i = this.B.addAndGet(-i);
        } while (i != 0);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.w || this.z) {
            return;
        }
        this.w = true;
        f();
        g();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(java.lang.Throwable th) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.w || this.z) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            return;
        }
        this.x = th;
        this.w = true;
        f();
        g();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.w || this.z) {
            return;
        }
        this.t.offer(t);
        g();
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(org.reactivestreams.Subscription subscription) {
        if (this.w || this.z) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        if (this.A.get() || !this.A.compareAndSet(false, true)) {
            io.reactivex.internal.subscriptions.EmptySubscription.error(new java.lang.IllegalStateException("This processor allows only a single Subscriber"), subscriber);
            return;
        }
        subscriber.onSubscribe(this.B);
        this.y.set(subscriber);
        if (this.z) {
            this.y.lazySet(null);
        } else {
            g();
        }
    }
}
