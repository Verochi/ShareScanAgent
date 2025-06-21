package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableFlatMap<T, U> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, U> {
    public final io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends U>> t;
    public final boolean u;
    public final int v;
    public final int w;

    public static final class InnerSubscriber<T, U> extends java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> implements io.reactivex.FlowableSubscriber<U>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -4606175640614850599L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long id;
        final int limit;
        final io.reactivex.internal.operators.flowable.FlowableFlatMap.MergeSubscriber<T, U> parent;
        long produced;
        volatile io.reactivex.internal.fuseable.SimpleQueue<U> queue;

        public InnerSubscriber(io.reactivex.internal.operators.flowable.FlowableFlatMap.MergeSubscriber<T, U> mergeSubscriber, long j) {
            this.id = j;
            this.parent = mergeSubscriber;
            int i = mergeSubscriber.bufferSize;
            this.bufferSize = i;
            this.limit = i >> 2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            lazySet(io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED);
            this.parent.innerError(this, th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(U u) {
            if (this.fusionMode != 2) {
                this.parent.tryEmit(u, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof io.reactivex.internal.fuseable.QueueSubscription) {
                    io.reactivex.internal.fuseable.QueueSubscription queueSubscription = (io.reactivex.internal.fuseable.QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                    }
                }
                subscription.request(this.bufferSize);
            }
        }

        public void requestMore(long j) {
            if (this.fusionMode != 1) {
                long j2 = this.produced + j;
                if (j2 < this.limit) {
                    this.produced = j2;
                } else {
                    this.produced = 0L;
                    get().request(j2);
                }
            }
        }
    }

    public static final class MergeSubscriber<T, U> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final org.reactivestreams.Subscriber<? super U> downstream;
        final io.reactivex.internal.util.AtomicThrowable errs = new io.reactivex.internal.util.AtomicThrowable();
        long lastId;
        int lastIndex;
        final io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends U>> mapper;
        final int maxConcurrency;
        volatile io.reactivex.internal.fuseable.SimplePlainQueue<U> queue;
        final java.util.concurrent.atomic.AtomicLong requested;
        int scalarEmitted;
        final int scalarLimit;
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<?, ?>[]> subscribers;
        long uniqueId;
        org.reactivestreams.Subscription upstream;
        static final io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<?, ?>[] EMPTY = new io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber[0];
        static final io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<?, ?>[] CANCELLED = new io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber[0];

        public MergeSubscriber(org.reactivestreams.Subscriber<? super U> subscriber, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends U>> function, boolean z, int i, int i2) {
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<?, ?>[]> atomicReference = new java.util.concurrent.atomic.AtomicReference<>();
            this.subscribers = atomicReference;
            this.requested = new java.util.concurrent.atomic.AtomicLong();
            this.downstream = subscriber;
            this.mapper = function;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.bufferSize = i2;
            this.scalarLimit = java.lang.Math.max(1, i >> 1);
            atomicReference.lazySet(EMPTY);
        }

        public boolean addInner(io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<T, U> innerSubscriber) {
            io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<?, ?>[] innerSubscriberArr;
            io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                if (innerSubscriberArr == CANCELLED) {
                    innerSubscriber.dispose();
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber[length + 1];
                java.lang.System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!defpackage.xv0.a(this.subscribers, innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            io.reactivex.internal.fuseable.SimplePlainQueue<U> simplePlainQueue;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            disposeAll();
            if (getAndIncrement() != 0 || (simplePlainQueue = this.queue) == null) {
                return;
            }
            simplePlainQueue.clear();
        }

        public boolean checkTerminate() {
            if (this.cancelled) {
                clearScalarQueue();
                return true;
            }
            if (this.delayErrors || this.errs.get() == null) {
                return false;
            }
            clearScalarQueue();
            java.lang.Throwable terminate = this.errs.terminate();
            if (terminate != io.reactivex.internal.util.ExceptionHelper.TERMINATED) {
                this.downstream.onError(terminate);
            }
            return true;
        }

        public void clearScalarQueue() {
            io.reactivex.internal.fuseable.SimplePlainQueue<U> simplePlainQueue = this.queue;
            if (simplePlainQueue != null) {
                simplePlainQueue.clear();
            }
        }

        public void disposeAll() {
            io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<?, ?>[] andSet;
            io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<?, ?>[] innerSubscriberArr = this.subscribers.get();
            io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<?, ?>[] innerSubscriberArr2 = CANCELLED;
            if (innerSubscriberArr == innerSubscriberArr2 || (andSet = this.subscribers.getAndSet(innerSubscriberArr2)) == innerSubscriberArr2) {
                return;
            }
            for (io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<?, ?> innerSubscriber : andSet) {
                innerSubscriber.dispose();
            }
            java.lang.Throwable terminate = this.errs.terminate();
            if (terminate == null || terminate == io.reactivex.internal.util.ExceptionHelper.TERMINATED) {
                return;
            }
            io.reactivex.plugins.RxJavaPlugins.onError(terminate);
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:103:0x018f, code lost:
        
            r24.lastIndex = r3;
            r24.lastId = r13[r3].id;
            r3 = r16;
            r5 = 0;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drainLoop() {
            long j;
            long j2;
            boolean z;
            io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<T, U>[] innerSubscriberArr;
            int i;
            long j3;
            java.lang.Object obj;
            org.reactivestreams.Subscriber<? super U> subscriber = this.downstream;
            int i2 = 1;
            while (!checkTerminate()) {
                io.reactivex.internal.fuseable.SimplePlainQueue<U> simplePlainQueue = this.queue;
                long j4 = this.requested.get();
                boolean z2 = j4 == Long.MAX_VALUE;
                long j5 = 0;
                long j6 = 0;
                if (simplePlainQueue != null) {
                    do {
                        long j7 = 0;
                        obj = null;
                        while (true) {
                            if (j4 == 0) {
                                break;
                            }
                            U poll = simplePlainQueue.poll();
                            if (checkTerminate()) {
                                return;
                            }
                            if (poll == null) {
                                obj = poll;
                                break;
                            }
                            subscriber.onNext(poll);
                            j6++;
                            j7++;
                            j4--;
                            obj = poll;
                        }
                        if (j7 != 0) {
                            j4 = z2 ? Long.MAX_VALUE : this.requested.addAndGet(-j7);
                        }
                        if (j4 == 0) {
                            break;
                        }
                    } while (obj != null);
                }
                boolean z3 = this.done;
                io.reactivex.internal.fuseable.SimplePlainQueue<U> simplePlainQueue2 = this.queue;
                io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<?, ?>[] innerSubscriberArr2 = this.subscribers.get();
                int length = innerSubscriberArr2.length;
                if (z3 && ((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0)) {
                    java.lang.Throwable terminate = this.errs.terminate();
                    if (terminate != io.reactivex.internal.util.ExceptionHelper.TERMINATED) {
                        if (terminate == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(terminate);
                            return;
                        }
                    }
                    return;
                }
                int i3 = i2;
                if (length != 0) {
                    long j8 = this.lastId;
                    int i4 = this.lastIndex;
                    if (length <= i4 || innerSubscriberArr2[i4].id != j8) {
                        if (length <= i4) {
                            i4 = 0;
                        }
                        for (int i5 = 0; i5 < length && innerSubscriberArr2[i4].id != j8; i5++) {
                            i4++;
                            if (i4 == length) {
                                i4 = 0;
                            }
                        }
                        this.lastIndex = i4;
                        this.lastId = innerSubscriberArr2[i4].id;
                    }
                    int i6 = i4;
                    boolean z4 = false;
                    int i7 = 0;
                    while (true) {
                        if (i7 >= length) {
                            innerSubscriberArr = innerSubscriberArr2;
                            z = z4;
                            break;
                        }
                        if (checkTerminate()) {
                            return;
                        }
                        io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<T, U> innerSubscriber = innerSubscriberArr2[i6];
                        U u = null;
                        while (!checkTerminate()) {
                            io.reactivex.internal.fuseable.SimpleQueue<U> simpleQueue = innerSubscriber.queue;
                            if (simpleQueue == null) {
                                innerSubscriberArr = innerSubscriberArr2;
                                i = length;
                            } else {
                                innerSubscriberArr = innerSubscriberArr2;
                                i = length;
                                long j9 = j5;
                                while (j4 != j5) {
                                    try {
                                        u = simpleQueue.poll();
                                        if (u == null) {
                                            break;
                                        }
                                        subscriber.onNext(u);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        j4--;
                                        j9++;
                                    } catch (java.lang.Throwable th) {
                                        io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                                        innerSubscriber.dispose();
                                        this.errs.addThrowable(th);
                                        if (!this.delayErrors) {
                                            this.upstream.cancel();
                                        }
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        removeInner(innerSubscriber);
                                        i7++;
                                        length = i;
                                        z4 = true;
                                    }
                                }
                                if (j9 != j5) {
                                    j4 = !z2 ? this.requested.addAndGet(-j9) : Long.MAX_VALUE;
                                    innerSubscriber.requestMore(j9);
                                    j3 = 0;
                                } else {
                                    j3 = j5;
                                }
                                if (j4 != j3 && u != null) {
                                    innerSubscriberArr2 = innerSubscriberArr;
                                    length = i;
                                    j5 = 0;
                                }
                            }
                            boolean z5 = innerSubscriber.done;
                            io.reactivex.internal.fuseable.SimpleQueue<U> simpleQueue2 = innerSubscriber.queue;
                            if (z5 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                removeInner(innerSubscriber);
                                if (checkTerminate()) {
                                    return;
                                }
                                j6++;
                                z4 = true;
                            }
                            if (j4 == 0) {
                                z = z4;
                                break;
                            }
                            i6++;
                            length = i;
                            if (i6 == length) {
                                i6 = 0;
                            }
                            i7++;
                            innerSubscriberArr2 = innerSubscriberArr;
                            j5 = 0;
                        }
                        return;
                    }
                }
                j = 0;
                j2 = j6;
                z = false;
                if (j2 != j && !this.cancelled) {
                    this.upstream.request(j2);
                }
                if (z) {
                    i2 = i3;
                } else {
                    i2 = addAndGet(-i3);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        public io.reactivex.internal.fuseable.SimpleQueue<U> getInnerQueue(io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<T, U> innerSubscriber) {
            io.reactivex.internal.fuseable.SimpleQueue<U> simpleQueue = innerSubscriber.queue;
            if (simpleQueue != null) {
                return simpleQueue;
            }
            io.reactivex.internal.queue.SpscArrayQueue spscArrayQueue = new io.reactivex.internal.queue.SpscArrayQueue(this.bufferSize);
            innerSubscriber.queue = spscArrayQueue;
            return spscArrayQueue;
        }

        public io.reactivex.internal.fuseable.SimpleQueue<U> getMainQueue() {
            io.reactivex.internal.fuseable.SimplePlainQueue<U> simplePlainQueue = this.queue;
            if (simplePlainQueue == null) {
                simplePlainQueue = this.maxConcurrency == Integer.MAX_VALUE ? new io.reactivex.internal.queue.SpscLinkedArrayQueue<>(this.bufferSize) : new io.reactivex.internal.queue.SpscArrayQueue<>(this.maxConcurrency);
                this.queue = simplePlainQueue;
            }
            return simplePlainQueue;
        }

        public void innerError(io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<T, U> innerSubscriber, java.lang.Throwable th) {
            if (!this.errs.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            innerSubscriber.done = true;
            if (!this.delayErrors) {
                this.upstream.cancel();
                for (io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<?, ?> innerSubscriber2 : this.subscribers.getAndSet(CANCELLED)) {
                    innerSubscriber2.dispose();
                }
            }
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.done) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            if (!this.errs.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            if (!this.delayErrors) {
                for (io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<?, ?> innerSubscriber : this.subscribers.getAndSet(CANCELLED)) {
                    innerSubscriber.dispose();
                }
            }
            drain();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                org.reactivestreams.Publisher publisher = (org.reactivestreams.Publisher) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher");
                if (!(publisher instanceof java.util.concurrent.Callable)) {
                    long j = this.uniqueId;
                    this.uniqueId = 1 + j;
                    io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber innerSubscriber = new io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber(this, j);
                    if (addInner(innerSubscriber)) {
                        publisher.subscribe(innerSubscriber);
                        return;
                    }
                    return;
                }
                try {
                    java.lang.Object call = ((java.util.concurrent.Callable) publisher).call();
                    if (call != null) {
                        tryEmitScalar(call);
                        return;
                    }
                    if (this.maxConcurrency == Integer.MAX_VALUE || this.cancelled) {
                        return;
                    }
                    int i = this.scalarEmitted + 1;
                    this.scalarEmitted = i;
                    int i2 = this.scalarLimit;
                    if (i == i2) {
                        this.scalarEmitted = 0;
                        this.upstream.request(i2);
                    }
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    this.errs.addThrowable(th);
                    drain();
                }
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                this.upstream.cancel();
                onError(th2);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                int i = this.maxConcurrency;
                if (i == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request(i);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void removeInner(io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<T, U> innerSubscriber) {
            io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<?, ?>[] innerSubscriberArr;
            io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<?, ?>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (innerSubscriberArr[i] == innerSubscriber) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriberArr2 = EMPTY;
                } else {
                    io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<?, ?>[] innerSubscriberArr3 = new io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber[length - 1];
                    java.lang.System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i);
                    java.lang.System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr3, i, (length - i) - 1);
                    innerSubscriberArr2 = innerSubscriberArr3;
                }
            } while (!defpackage.xv0.a(this.subscribers, innerSubscriberArr, innerSubscriberArr2));
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public void tryEmit(U u, io.reactivex.internal.operators.flowable.FlowableFlatMap.InnerSubscriber<T, U> innerSubscriber) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.requested.get();
                io.reactivex.internal.fuseable.SimpleQueue<U> simpleQueue = innerSubscriber.queue;
                if (j == 0 || !(simpleQueue == null || simpleQueue.isEmpty())) {
                    if (simpleQueue == null) {
                        simpleQueue = getInnerQueue(innerSubscriber);
                    }
                    if (!simpleQueue.offer(u)) {
                        onError(new io.reactivex.exceptions.MissingBackpressureException("Inner queue full?!"));
                        return;
                    }
                } else {
                    this.downstream.onNext(u);
                    if (j != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    innerSubscriber.requestMore(1L);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                io.reactivex.internal.fuseable.SimpleQueue simpleQueue2 = innerSubscriber.queue;
                if (simpleQueue2 == null) {
                    simpleQueue2 = new io.reactivex.internal.queue.SpscArrayQueue(this.bufferSize);
                    innerSubscriber.queue = simpleQueue2;
                }
                if (!simpleQueue2.offer(u)) {
                    onError(new io.reactivex.exceptions.MissingBackpressureException("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        public void tryEmitScalar(U u) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.requested.get();
                io.reactivex.internal.fuseable.SimpleQueue<U> simpleQueue = this.queue;
                if (j == 0 || !(simpleQueue == null || simpleQueue.isEmpty())) {
                    if (simpleQueue == null) {
                        simpleQueue = getMainQueue();
                    }
                    if (!simpleQueue.offer(u)) {
                        onError(new java.lang.IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                } else {
                    this.downstream.onNext(u);
                    if (j != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                        int i = this.scalarEmitted + 1;
                        this.scalarEmitted = i;
                        int i2 = this.scalarLimit;
                        if (i == i2) {
                            this.scalarEmitted = 0;
                            this.upstream.request(i2);
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!getMainQueue().offer(u)) {
                onError(new java.lang.IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }
    }

    public FlowableFlatMap(io.reactivex.Flowable<T> flowable, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends U>> function, boolean z, int i, int i2) {
        super(flowable);
        this.t = function;
        this.u = z;
        this.v = i;
        this.w = i2;
    }

    public static <T, U> io.reactivex.FlowableSubscriber<T> subscribe(org.reactivestreams.Subscriber<? super U> subscriber, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends U>> function, boolean z, int i, int i2) {
        return new io.reactivex.internal.operators.flowable.FlowableFlatMap.MergeSubscriber(subscriber, function, z, i, i2);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super U> subscriber) {
        if (io.reactivex.internal.operators.flowable.FlowableScalarXMap.tryScalarXMapSubscribe(this.source, subscriber, this.t)) {
            return;
        }
        this.source.subscribe((io.reactivex.FlowableSubscriber) subscribe(subscriber, this.t, this.u, this.v, this.w));
    }
}
