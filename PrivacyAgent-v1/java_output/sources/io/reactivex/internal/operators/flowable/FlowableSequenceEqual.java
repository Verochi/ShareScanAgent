package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableSequenceEqual<T> extends io.reactivex.Flowable<java.lang.Boolean> {
    public final org.reactivestreams.Publisher<? extends T> t;
    public final org.reactivestreams.Publisher<? extends T> u;
    public final io.reactivex.functions.BiPredicate<? super T, ? super T> v;
    public final int w;

    public static final class EqualCoordinator<T> extends io.reactivex.internal.subscriptions.DeferredScalarSubscription<java.lang.Boolean> implements io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper {
        private static final long serialVersionUID = -6178010334400373240L;
        final io.reactivex.functions.BiPredicate<? super T, ? super T> comparer;
        final io.reactivex.internal.util.AtomicThrowable error;
        final io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualSubscriber<T> first;
        final io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualSubscriber<T> second;
        T v1;
        T v2;
        final java.util.concurrent.atomic.AtomicInteger wip;

        public EqualCoordinator(org.reactivestreams.Subscriber<? super java.lang.Boolean> subscriber, int i, io.reactivex.functions.BiPredicate<? super T, ? super T> biPredicate) {
            super(subscriber);
            this.comparer = biPredicate;
            this.wip = new java.util.concurrent.atomic.AtomicInteger();
            this.first = new io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualSubscriber<>(this, i);
            this.second = new io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualSubscriber<>(this, i);
            this.error = new io.reactivex.internal.util.AtomicThrowable();
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.first.cancel();
            this.second.cancel();
            if (this.wip.getAndIncrement() == 0) {
                this.first.clear();
                this.second.clear();
            }
        }

        public void cancelAndClear() {
            this.first.cancel();
            this.first.clear();
            this.second.cancel();
            this.second.clear();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            int i = 1;
            do {
                io.reactivex.internal.fuseable.SimpleQueue<T> simpleQueue = this.first.queue;
                io.reactivex.internal.fuseable.SimpleQueue<T> simpleQueue2 = this.second.queue;
                if (simpleQueue != null && simpleQueue2 != null) {
                    while (!isCancelled()) {
                        if (this.error.get() != null) {
                            cancelAndClear();
                            this.downstream.onError(this.error.terminate());
                            return;
                        }
                        boolean z = this.first.done;
                        T t = this.v1;
                        if (t == null) {
                            try {
                                t = simpleQueue.poll();
                                this.v1 = t;
                            } catch (java.lang.Throwable th) {
                                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                                cancelAndClear();
                                this.error.addThrowable(th);
                                this.downstream.onError(this.error.terminate());
                                return;
                            }
                        }
                        boolean z2 = t == null;
                        boolean z3 = this.second.done;
                        T t2 = this.v2;
                        if (t2 == null) {
                            try {
                                t2 = simpleQueue2.poll();
                                this.v2 = t2;
                            } catch (java.lang.Throwable th2) {
                                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                                cancelAndClear();
                                this.error.addThrowable(th2);
                                this.downstream.onError(this.error.terminate());
                                return;
                            }
                        }
                        boolean z4 = t2 == null;
                        if (z && z3 && z2 && z4) {
                            complete(java.lang.Boolean.TRUE);
                            return;
                        }
                        if (z && z3 && z2 != z4) {
                            cancelAndClear();
                            complete(java.lang.Boolean.FALSE);
                            return;
                        }
                        if (!z2 && !z4) {
                            try {
                                if (!this.comparer.test(t, t2)) {
                                    cancelAndClear();
                                    complete(java.lang.Boolean.FALSE);
                                    return;
                                } else {
                                    this.v1 = null;
                                    this.v2 = null;
                                    this.first.request();
                                    this.second.request();
                                }
                            } catch (java.lang.Throwable th3) {
                                io.reactivex.exceptions.Exceptions.throwIfFatal(th3);
                                cancelAndClear();
                                this.error.addThrowable(th3);
                                this.downstream.onError(this.error.terminate());
                                return;
                            }
                        }
                    }
                    this.first.clear();
                    this.second.clear();
                    return;
                }
                if (isCancelled()) {
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (this.error.get() != null) {
                    cancelAndClear();
                    this.downstream.onError(this.error.terminate());
                    return;
                }
                i = this.wip.addAndGet(-i);
            } while (i != 0);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public void innerError(java.lang.Throwable th) {
            if (this.error.addThrowable(th)) {
                drain();
            } else {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
        }

        public void subscribe(org.reactivestreams.Publisher<? extends T> publisher, org.reactivestreams.Publisher<? extends T> publisher2) {
            publisher.subscribe(this.first);
            publisher2.subscribe(this.second);
        }
    }

    public interface EqualCoordinatorHelper {
        void drain();

        void innerError(java.lang.Throwable th);
    }

    public static final class EqualSubscriber<T> extends java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> implements io.reactivex.FlowableSubscriber<T> {
        private static final long serialVersionUID = 4804128302091633067L;
        volatile boolean done;
        final int limit;
        final io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper parent;
        final int prefetch;
        long produced;
        volatile io.reactivex.internal.fuseable.SimpleQueue<T> queue;
        int sourceMode;

        public EqualSubscriber(io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper equalCoordinatorHelper, int i) {
            this.parent = equalCoordinatorHelper;
            this.limit = i - (i >> 2);
            this.prefetch = i;
        }

        public void cancel() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this);
        }

        public void clear() {
            io.reactivex.internal.fuseable.SimpleQueue<T> simpleQueue = this.queue;
            if (simpleQueue != null) {
                simpleQueue.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.parent.innerError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                this.parent.drain();
            } else {
                onError(new io.reactivex.exceptions.MissingBackpressureException());
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof io.reactivex.internal.fuseable.QueueSubscription) {
                    io.reactivex.internal.fuseable.QueueSubscription queueSubscription = (io.reactivex.internal.fuseable.QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.SpscArrayQueue(this.prefetch);
                subscription.request(this.prefetch);
            }
        }

        public void request() {
            if (this.sourceMode != 1) {
                long j = this.produced + 1;
                if (j < this.limit) {
                    this.produced = j;
                } else {
                    this.produced = 0L;
                    get().request(j);
                }
            }
        }
    }

    public FlowableSequenceEqual(org.reactivestreams.Publisher<? extends T> publisher, org.reactivestreams.Publisher<? extends T> publisher2, io.reactivex.functions.BiPredicate<? super T, ? super T> biPredicate, int i) {
        this.t = publisher;
        this.u = publisher2;
        this.v = biPredicate;
        this.w = i;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super java.lang.Boolean> subscriber) {
        io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinator equalCoordinator = new io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinator(subscriber, this.w, this.v);
        subscriber.onSubscribe(equalCoordinator);
        equalCoordinator.subscribe(this.t, this.u);
    }
}
