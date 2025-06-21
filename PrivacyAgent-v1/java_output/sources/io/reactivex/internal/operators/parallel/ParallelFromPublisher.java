package io.reactivex.internal.operators.parallel;

/* loaded from: classes13.dex */
public final class ParallelFromPublisher<T> extends io.reactivex.parallel.ParallelFlowable<T> {
    public final org.reactivestreams.Publisher<? extends T> a;
    public final int b;
    public final int c;

    public static final class ParallelDispatcher<T> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.FlowableSubscriber<T> {
        private static final long serialVersionUID = -4470634016609963609L;
        volatile boolean cancelled;
        volatile boolean done;
        final long[] emissions;
        java.lang.Throwable error;
        int index;
        final int limit;
        final int prefetch;
        int produced;
        io.reactivex.internal.fuseable.SimpleQueue<T> queue;
        final java.util.concurrent.atomic.AtomicLongArray requests;
        int sourceMode;
        final java.util.concurrent.atomic.AtomicInteger subscriberCount = new java.util.concurrent.atomic.AtomicInteger();
        final org.reactivestreams.Subscriber<? super T>[] subscribers;
        org.reactivestreams.Subscription upstream;

        public final class RailSubscription implements org.reactivestreams.Subscription {
            public final int n;
            public final int t;

            public RailSubscription(int i, int i2) {
                this.n = i;
                this.t = i2;
            }

            @Override // org.reactivestreams.Subscription
            public void cancel() {
                if (io.reactivex.internal.operators.parallel.ParallelFromPublisher.ParallelDispatcher.this.requests.compareAndSet(this.n + this.t, 0L, 1L)) {
                    io.reactivex.internal.operators.parallel.ParallelFromPublisher.ParallelDispatcher parallelDispatcher = io.reactivex.internal.operators.parallel.ParallelFromPublisher.ParallelDispatcher.this;
                    int i = this.t;
                    parallelDispatcher.cancel(i + i);
                }
            }

            @Override // org.reactivestreams.Subscription
            public void request(long j) {
                long j2;
                if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                    java.util.concurrent.atomic.AtomicLongArray atomicLongArray = io.reactivex.internal.operators.parallel.ParallelFromPublisher.ParallelDispatcher.this.requests;
                    do {
                        j2 = atomicLongArray.get(this.n);
                        if (j2 == Long.MAX_VALUE) {
                            return;
                        }
                    } while (!atomicLongArray.compareAndSet(this.n, j2, io.reactivex.internal.util.BackpressureHelper.addCap(j2, j)));
                    if (io.reactivex.internal.operators.parallel.ParallelFromPublisher.ParallelDispatcher.this.subscriberCount.get() == this.t) {
                        io.reactivex.internal.operators.parallel.ParallelFromPublisher.ParallelDispatcher.this.drain();
                    }
                }
            }
        }

        public ParallelDispatcher(org.reactivestreams.Subscriber<? super T>[] subscriberArr, int i) {
            this.subscribers = subscriberArr;
            this.prefetch = i;
            this.limit = i - (i >> 2);
            int length = subscriberArr.length;
            int i2 = length + length;
            java.util.concurrent.atomic.AtomicLongArray atomicLongArray = new java.util.concurrent.atomic.AtomicLongArray(i2 + 1);
            this.requests = atomicLongArray;
            atomicLongArray.lazySet(i2, length);
            this.emissions = new long[length];
        }

        public void cancel(int i) {
            if (this.requests.decrementAndGet(i) == 0) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.sourceMode == 1) {
                drainSync();
            } else {
                drainAsync();
            }
        }

        public void drainAsync() {
            java.lang.Throwable th;
            io.reactivex.internal.fuseable.SimpleQueue<T> simpleQueue = this.queue;
            org.reactivestreams.Subscriber<? super T>[] subscriberArr = this.subscribers;
            java.util.concurrent.atomic.AtomicLongArray atomicLongArray = this.requests;
            long[] jArr = this.emissions;
            int length = jArr.length;
            int i = this.index;
            int i2 = this.produced;
            int i3 = 1;
            while (true) {
                int i4 = 0;
                int i5 = 0;
                while (!this.cancelled) {
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        simpleQueue.clear();
                        int length2 = subscriberArr.length;
                        while (i4 < length2) {
                            subscriberArr[i4].onError(th);
                            i4++;
                        }
                        return;
                    }
                    boolean isEmpty = simpleQueue.isEmpty();
                    if (z && isEmpty) {
                        int length3 = subscriberArr.length;
                        while (i4 < length3) {
                            subscriberArr[i4].onComplete();
                            i4++;
                        }
                        return;
                    }
                    if (!isEmpty) {
                        long j = atomicLongArray.get(i);
                        long j2 = jArr[i];
                        if (j == j2 || atomicLongArray.get(length + i) != 0) {
                            i5++;
                        } else {
                            try {
                                T poll = simpleQueue.poll();
                                if (poll != null) {
                                    subscriberArr[i].onNext(poll);
                                    jArr[i] = j2 + 1;
                                    i2++;
                                    if (i2 == this.limit) {
                                        this.upstream.request(i2);
                                        i2 = 0;
                                    }
                                    i5 = 0;
                                }
                            } catch (java.lang.Throwable th2) {
                                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                                this.upstream.cancel();
                                int length4 = subscriberArr.length;
                                while (i4 < length4) {
                                    subscriberArr[i4].onError(th2);
                                    i4++;
                                }
                                return;
                            }
                        }
                        i++;
                        if (i == length) {
                            i = 0;
                        }
                        if (i5 == length) {
                        }
                    }
                    int i6 = get();
                    if (i6 == i3) {
                        this.index = i;
                        this.produced = i2;
                        i3 = addAndGet(-i3);
                        if (i3 == 0) {
                            return;
                        }
                    } else {
                        i3 = i6;
                    }
                }
                simpleQueue.clear();
                return;
            }
        }

        public void drainSync() {
            io.reactivex.internal.fuseable.SimpleQueue<T> simpleQueue = this.queue;
            org.reactivestreams.Subscriber<? super T>[] subscriberArr = this.subscribers;
            java.util.concurrent.atomic.AtomicLongArray atomicLongArray = this.requests;
            long[] jArr = this.emissions;
            int length = jArr.length;
            int i = this.index;
            int i2 = 1;
            while (true) {
                int i3 = 0;
                int i4 = 0;
                while (!this.cancelled) {
                    if (simpleQueue.isEmpty()) {
                        int length2 = subscriberArr.length;
                        while (i3 < length2) {
                            subscriberArr[i3].onComplete();
                            i3++;
                        }
                        return;
                    }
                    long j = atomicLongArray.get(i);
                    long j2 = jArr[i];
                    if (j == j2 || atomicLongArray.get(length + i) != 0) {
                        i4++;
                    } else {
                        try {
                            T poll = simpleQueue.poll();
                            if (poll == null) {
                                int length3 = subscriberArr.length;
                                while (i3 < length3) {
                                    subscriberArr[i3].onComplete();
                                    i3++;
                                }
                                return;
                            }
                            subscriberArr[i].onNext(poll);
                            jArr[i] = j2 + 1;
                            i4 = 0;
                        } catch (java.lang.Throwable th) {
                            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                            this.upstream.cancel();
                            int length4 = subscriberArr.length;
                            while (i3 < length4) {
                                subscriberArr[i3].onError(th);
                                i3++;
                            }
                            return;
                        }
                    }
                    i++;
                    if (i == length) {
                        i = 0;
                    }
                    if (i4 == length) {
                        int i5 = get();
                        if (i5 == i2) {
                            this.index = i;
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            i2 = i5;
                        }
                    }
                }
                simpleQueue.clear();
                return;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                drain();
            } else {
                this.upstream.cancel();
                onError(new io.reactivex.exceptions.MissingBackpressureException("Queue is full?"));
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                if (subscription instanceof io.reactivex.internal.fuseable.QueueSubscription) {
                    io.reactivex.internal.fuseable.QueueSubscription queueSubscription = (io.reactivex.internal.fuseable.QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        setupSubscribers();
                        drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        setupSubscribers();
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.SpscArrayQueue(this.prefetch);
                setupSubscribers();
                subscription.request(this.prefetch);
            }
        }

        public void setupSubscribers() {
            org.reactivestreams.Subscriber<? super T>[] subscriberArr = this.subscribers;
            int length = subscriberArr.length;
            int i = 0;
            while (i < length && !this.cancelled) {
                int i2 = i + 1;
                this.subscriberCount.lazySet(i2);
                subscriberArr[i].onSubscribe(new io.reactivex.internal.operators.parallel.ParallelFromPublisher.ParallelDispatcher.RailSubscription(i, length));
                i = i2;
            }
        }
    }

    public ParallelFromPublisher(org.reactivestreams.Publisher<? extends T> publisher, int i, int i2) {
        this.a = publisher;
        this.b = i;
        this.c = i2;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.b;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(org.reactivestreams.Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            this.a.subscribe(new io.reactivex.internal.operators.parallel.ParallelFromPublisher.ParallelDispatcher(subscriberArr, this.c));
        }
    }
}
