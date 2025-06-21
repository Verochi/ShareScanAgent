package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableGroupBy<T, K, V> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, io.reactivex.flowables.GroupedFlowable<K, V>> {
    public final io.reactivex.functions.Function<? super T, ? extends K> t;
    public final io.reactivex.functions.Function<? super T, ? extends V> u;
    public final int v;
    public final boolean w;
    public final io.reactivex.functions.Function<? super io.reactivex.functions.Consumer<java.lang.Object>, ? extends java.util.Map<K, java.lang.Object>> x;

    public static final class EvictionAction<K, V> implements io.reactivex.functions.Consumer<io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupedUnicast<K, V>> {
        public final java.util.Queue<io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupedUnicast<K, V>> n;

        public EvictionAction(java.util.Queue<io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupedUnicast<K, V>> queue) {
            this.n = queue;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupedUnicast<K, V> groupedUnicast) {
            this.n.offer(groupedUnicast);
        }
    }

    public static final class GroupBySubscriber<T, K, V> extends io.reactivex.internal.subscriptions.BasicIntQueueSubscription<io.reactivex.flowables.GroupedFlowable<K, V>> implements io.reactivex.FlowableSubscriber<T> {
        static final java.lang.Object NULL_KEY = new java.lang.Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final int bufferSize;
        final boolean delayError;
        boolean done;
        final org.reactivestreams.Subscriber<? super io.reactivex.flowables.GroupedFlowable<K, V>> downstream;
        java.lang.Throwable error;
        final java.util.Queue<io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupedUnicast<K, V>> evictedGroups;
        volatile boolean finished;
        final java.util.Map<java.lang.Object, io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupedUnicast<K, V>> groups;
        final io.reactivex.functions.Function<? super T, ? extends K> keySelector;
        boolean outputFused;
        final io.reactivex.internal.queue.SpscLinkedArrayQueue<io.reactivex.flowables.GroupedFlowable<K, V>> queue;
        org.reactivestreams.Subscription upstream;
        final io.reactivex.functions.Function<? super T, ? extends V> valueSelector;
        final java.util.concurrent.atomic.AtomicBoolean cancelled = new java.util.concurrent.atomic.AtomicBoolean();
        final java.util.concurrent.atomic.AtomicLong requested = new java.util.concurrent.atomic.AtomicLong();
        final java.util.concurrent.atomic.AtomicInteger groupCount = new java.util.concurrent.atomic.AtomicInteger(1);

        public GroupBySubscriber(org.reactivestreams.Subscriber<? super io.reactivex.flowables.GroupedFlowable<K, V>> subscriber, io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2, int i, boolean z, java.util.Map<java.lang.Object, io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupedUnicast<K, V>> map, java.util.Queue<io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupedUnicast<K, V>> queue) {
            this.downstream = subscriber;
            this.keySelector = function;
            this.valueSelector = function2;
            this.bufferSize = i;
            this.delayError = z;
            this.groups = map;
            this.evictedGroups = queue;
            this.queue = new io.reactivex.internal.queue.SpscLinkedArrayQueue<>(i);
        }

        private void completeEvictions() {
            if (this.evictedGroups != null) {
                int i = 0;
                while (true) {
                    io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupedUnicast<K, V> poll = this.evictedGroups.poll();
                    if (poll == null) {
                        break;
                    }
                    poll.onComplete();
                    i++;
                }
                if (i != 0) {
                    this.groupCount.addAndGet(-i);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled.compareAndSet(false, true)) {
                completeEvictions();
                if (this.groupCount.decrementAndGet() == 0) {
                    this.upstream.cancel();
                }
            }
        }

        public void cancel(K k) {
            if (k == null) {
                k = (K) NULL_KEY;
            }
            this.groups.remove(k);
            if (this.groupCount.decrementAndGet() == 0) {
                this.upstream.cancel();
                if (this.outputFused || getAndIncrement() != 0) {
                    return;
                }
                this.queue.clear();
            }
        }

        public boolean checkTerminated(boolean z, boolean z2, org.reactivestreams.Subscriber<?> subscriber, io.reactivex.internal.queue.SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.cancelled.get()) {
                spscLinkedArrayQueue.clear();
                return true;
            }
            if (this.delayError) {
                if (!z || !z2) {
                    return false;
                }
                java.lang.Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            if (!z) {
                return false;
            }
            java.lang.Throwable th2 = this.error;
            if (th2 != null) {
                spscLinkedArrayQueue.clear();
                subscriber.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.queue.clear();
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        public void drainFused() {
            java.lang.Throwable th;
            io.reactivex.internal.queue.SpscLinkedArrayQueue<io.reactivex.flowables.GroupedFlowable<K, V>> spscLinkedArrayQueue = this.queue;
            org.reactivestreams.Subscriber<? super io.reactivex.flowables.GroupedFlowable<K, V>> subscriber = this.downstream;
            int i = 1;
            while (!this.cancelled.get()) {
                boolean z = this.finished;
                if (z && !this.delayError && (th = this.error) != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th);
                    return;
                }
                subscriber.onNext(null);
                if (z) {
                    java.lang.Throwable th2 = this.error;
                    if (th2 != null) {
                        subscriber.onError(th2);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        public void drainNormal() {
            io.reactivex.internal.queue.SpscLinkedArrayQueue<io.reactivex.flowables.GroupedFlowable<K, V>> spscLinkedArrayQueue = this.queue;
            org.reactivestreams.Subscriber<? super io.reactivex.flowables.GroupedFlowable<K, V>> subscriber = this.downstream;
            int i = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.finished;
                    io.reactivex.flowables.GroupedFlowable<K, V> poll = spscLinkedArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (checkTerminated(z, z2, subscriber, spscLinkedArrayQueue)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j2++;
                }
                if (j2 == j && checkTerminated(this.finished, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (j2 != 0) {
                    if (j != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j2);
                    }
                    this.upstream.request(j2);
                }
                i = addAndGet(-i);
            } while (i != 0);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            java.util.Iterator<io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupedUnicast<K, V>> it = this.groups.values().iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.groups.clear();
            java.util.Queue<io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupedUnicast<K, V>> queue = this.evictedGroups;
            if (queue != null) {
                queue.clear();
            }
            this.done = true;
            this.finished = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.done) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            java.util.Iterator<io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupedUnicast<K, V>> it = this.groups.values().iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.groups.clear();
            java.util.Queue<io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupedUnicast<K, V>> queue = this.evictedGroups;
            if (queue != null) {
                queue.clear();
            }
            this.error = th;
            this.finished = true;
            drain();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            boolean z;
            io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupedUnicast groupedUnicast;
            if (this.done) {
                return;
            }
            io.reactivex.internal.queue.SpscLinkedArrayQueue<io.reactivex.flowables.GroupedFlowable<K, V>> spscLinkedArrayQueue = this.queue;
            try {
                K apply = this.keySelector.apply(t);
                java.lang.Object obj = apply != null ? apply : NULL_KEY;
                io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupedUnicast<K, V> groupedUnicast2 = this.groups.get(obj);
                if (groupedUnicast2 != null) {
                    z = false;
                    groupedUnicast = groupedUnicast2;
                } else {
                    if (this.cancelled.get()) {
                        return;
                    }
                    io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupedUnicast e = io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupedUnicast.e(apply, this.bufferSize, this, this.delayError);
                    this.groups.put(obj, e);
                    this.groupCount.getAndIncrement();
                    z = true;
                    groupedUnicast = e;
                }
                try {
                    groupedUnicast.onNext(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.valueSelector.apply(t), "The valueSelector returned null"));
                    completeEvictions();
                    if (z) {
                        spscLinkedArrayQueue.offer(groupedUnicast);
                        drain();
                    }
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    this.upstream.cancel();
                    onError(th);
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
                subscription.request(this.bufferSize);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public io.reactivex.flowables.GroupedFlowable<K, V> poll() {
            return this.queue.poll();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public static final class GroupedUnicast<K, T> extends io.reactivex.flowables.GroupedFlowable<K, T> {
        public final io.reactivex.internal.operators.flowable.FlowableGroupBy.State<T, K> u;

        public GroupedUnicast(K k, io.reactivex.internal.operators.flowable.FlowableGroupBy.State<T, K> state) {
            super(k);
            this.u = state;
        }

        public static <T, K> io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupedUnicast<K, T> e(K k, int i, io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupBySubscriber<?, K, T> groupBySubscriber, boolean z) {
            return new io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupedUnicast<>(k, new io.reactivex.internal.operators.flowable.FlowableGroupBy.State(i, groupBySubscriber, k, z));
        }

        public void onComplete() {
            this.u.onComplete();
        }

        public void onError(java.lang.Throwable th) {
            this.u.onError(th);
        }

        public void onNext(T t) {
            this.u.onNext(t);
        }

        @Override // io.reactivex.Flowable
        public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
            this.u.subscribe(subscriber);
        }
    }

    public static final class State<T, K> extends io.reactivex.internal.subscriptions.BasicIntQueueSubscription<T> implements org.reactivestreams.Publisher<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final boolean delayError;
        volatile boolean done;
        java.lang.Throwable error;
        final K key;
        boolean outputFused;
        final io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupBySubscriber<?, K, T> parent;
        int produced;
        final io.reactivex.internal.queue.SpscLinkedArrayQueue<T> queue;
        final java.util.concurrent.atomic.AtomicLong requested = new java.util.concurrent.atomic.AtomicLong();
        final java.util.concurrent.atomic.AtomicBoolean cancelled = new java.util.concurrent.atomic.AtomicBoolean();
        final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscriber<? super T>> actual = new java.util.concurrent.atomic.AtomicReference<>();
        final java.util.concurrent.atomic.AtomicBoolean once = new java.util.concurrent.atomic.AtomicBoolean();

        public State(int i, io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupBySubscriber<?, K, T> groupBySubscriber, K k, boolean z) {
            this.queue = new io.reactivex.internal.queue.SpscLinkedArrayQueue<>(i);
            this.parent = groupBySubscriber;
            this.key = k;
            this.delayError = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled.compareAndSet(false, true)) {
                this.parent.cancel(this.key);
                drain();
            }
        }

        public boolean checkTerminated(boolean z, boolean z2, org.reactivestreams.Subscriber<? super T> subscriber, boolean z3, long j) {
            if (this.cancelled.get()) {
                while (this.queue.poll() != null) {
                    j++;
                }
                if (j != 0) {
                    this.parent.upstream.request(j);
                }
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                java.lang.Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            java.lang.Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                subscriber.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            io.reactivex.internal.queue.SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
            while (spscLinkedArrayQueue.poll() != null) {
                this.produced++;
            }
            tryReplenish();
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        public void drainFused() {
            java.lang.Throwable th;
            io.reactivex.internal.queue.SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
            org.reactivestreams.Subscriber<? super T> subscriber = this.actual.get();
            int i = 1;
            while (true) {
                if (subscriber != null) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    boolean z = this.done;
                    if (z && !this.delayError && (th = this.error) != null) {
                        spscLinkedArrayQueue.clear();
                        subscriber.onError(th);
                        return;
                    }
                    subscriber.onNext(null);
                    if (z) {
                        java.lang.Throwable th2 = this.error;
                        if (th2 != null) {
                            subscriber.onError(th2);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
                if (subscriber == null) {
                    subscriber = this.actual.get();
                }
            }
        }

        public void drainNormal() {
            io.reactivex.internal.queue.SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
            boolean z = this.delayError;
            org.reactivestreams.Subscriber<? super T> subscriber = this.actual.get();
            int i = 1;
            while (true) {
                if (subscriber != null) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        if (j2 == j) {
                            break;
                        }
                        boolean z2 = this.done;
                        T poll = spscLinkedArrayQueue.poll();
                        boolean z3 = poll == null;
                        long j3 = j2;
                        if (checkTerminated(z2, z3, subscriber, z, j2)) {
                            return;
                        }
                        if (z3) {
                            j2 = j3;
                            break;
                        } else {
                            subscriber.onNext(poll);
                            j2 = j3 + 1;
                        }
                    }
                    if (j2 == j) {
                        long j4 = j2;
                        if (checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, z, j2)) {
                            return;
                        } else {
                            j2 = j4;
                        }
                    }
                    if (j2 != 0) {
                        if (j != Long.MAX_VALUE) {
                            this.requested.addAndGet(-j2);
                        }
                        this.parent.upstream.request(j2);
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
                if (subscriber == null) {
                    subscriber = this.actual.get();
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            if (!this.queue.isEmpty()) {
                return false;
            }
            tryReplenish();
            return true;
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void onError(java.lang.Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public T poll() {
            T poll = this.queue.poll();
            if (poll != null) {
                this.produced++;
                return poll;
            }
            tryReplenish();
            return null;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(org.reactivestreams.Subscriber<? super T> subscriber) {
            if (!this.once.compareAndSet(false, true)) {
                io.reactivex.internal.subscriptions.EmptySubscription.error(new java.lang.IllegalStateException("Only one Subscriber allowed!"), subscriber);
                return;
            }
            subscriber.onSubscribe(this);
            this.actual.lazySet(subscriber);
            drain();
        }

        public void tryReplenish() {
            int i = this.produced;
            if (i != 0) {
                this.produced = 0;
                this.parent.upstream.request(i);
            }
        }
    }

    public FlowableGroupBy(io.reactivex.Flowable<T> flowable, io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2, int i, boolean z, io.reactivex.functions.Function<? super io.reactivex.functions.Consumer<java.lang.Object>, ? extends java.util.Map<K, java.lang.Object>> function3) {
        super(flowable);
        this.t = function;
        this.u = function2;
        this.v = i;
        this.w = z;
        this.x = function3;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super io.reactivex.flowables.GroupedFlowable<K, V>> subscriber) {
        java.util.concurrent.ConcurrentLinkedQueue concurrentLinkedQueue;
        java.util.Map<K, java.lang.Object> apply;
        try {
            if (this.x == null) {
                apply = new java.util.concurrent.ConcurrentHashMap<>();
                concurrentLinkedQueue = null;
            } else {
                concurrentLinkedQueue = new java.util.concurrent.ConcurrentLinkedQueue();
                apply = this.x.apply(new io.reactivex.internal.operators.flowable.FlowableGroupBy.EvictionAction(concurrentLinkedQueue));
            }
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableGroupBy.GroupBySubscriber(subscriber, this.t, this.u, this.v, this.w, apply, concurrentLinkedQueue));
        } catch (java.lang.Exception e) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(e);
            subscriber.onSubscribe(io.reactivex.internal.util.EmptyComponent.INSTANCE);
            subscriber.onError(e);
        }
    }
}
