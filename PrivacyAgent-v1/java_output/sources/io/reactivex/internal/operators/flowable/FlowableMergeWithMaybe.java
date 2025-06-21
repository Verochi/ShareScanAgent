package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableMergeWithMaybe<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final io.reactivex.MaybeSource<? extends T> t;

    public static final class MergeWithObserver<T> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
        static final int OTHER_STATE_HAS_VALUE = 1;
        private static final long serialVersionUID = -4592979584110982903L;
        volatile boolean cancelled;
        int consumed;
        final org.reactivestreams.Subscriber<? super T> downstream;
        long emitted;
        final int limit;
        volatile boolean mainDone;
        volatile int otherState;
        final int prefetch;
        volatile io.reactivex.internal.fuseable.SimplePlainQueue<T> queue;
        T singleItem;
        final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> mainSubscription = new java.util.concurrent.atomic.AtomicReference<>();
        final io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe.MergeWithObserver.OtherObserver<T> otherObserver = new io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe.MergeWithObserver.OtherObserver<>(this);
        final io.reactivex.internal.util.AtomicThrowable error = new io.reactivex.internal.util.AtomicThrowable();
        final java.util.concurrent.atomic.AtomicLong requested = new java.util.concurrent.atomic.AtomicLong();

        public static final class OtherObserver<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.MaybeObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            final io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe.MergeWithObserver<T> parent;

            public OtherObserver(io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe.MergeWithObserver<T> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.parent.otherComplete();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(java.lang.Throwable th) {
                this.parent.otherError(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
                io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(T t) {
                this.parent.otherSuccess(t);
            }
        }

        public MergeWithObserver(org.reactivestreams.Subscriber<? super T> subscriber) {
            this.downstream = subscriber;
            int bufferSize = io.reactivex.Flowable.bufferSize();
            this.prefetch = bufferSize;
            this.limit = bufferSize - (bufferSize >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.mainSubscription);
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.otherObserver);
            if (getAndIncrement() == 0) {
                this.queue = null;
                this.singleItem = null;
            }
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        public void drainLoop() {
            org.reactivestreams.Subscriber<? super T> subscriber = this.downstream;
            long j = this.emitted;
            int i = this.consumed;
            int i2 = this.limit;
            int i3 = 1;
            int i4 = 1;
            while (true) {
                long j2 = this.requested.get();
                while (j != j2) {
                    if (this.cancelled) {
                        this.singleItem = null;
                        this.queue = null;
                        return;
                    }
                    if (this.error.get() != null) {
                        this.singleItem = null;
                        this.queue = null;
                        subscriber.onError(this.error.terminate());
                        return;
                    }
                    int i5 = this.otherState;
                    if (i5 == i3) {
                        T t = this.singleItem;
                        this.singleItem = null;
                        this.otherState = 2;
                        subscriber.onNext(t);
                        j++;
                    } else {
                        boolean z = this.mainDone;
                        io.reactivex.internal.fuseable.SimplePlainQueue<T> simplePlainQueue = this.queue;
                        defpackage.a poll = simplePlainQueue != null ? simplePlainQueue.poll() : null;
                        boolean z2 = poll == null;
                        if (z && z2 && i5 == 2) {
                            this.queue = null;
                            subscriber.onComplete();
                            return;
                        } else {
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j++;
                            i++;
                            if (i == i2) {
                                this.mainSubscription.get().request(i2);
                                i = 0;
                            }
                            i3 = 1;
                        }
                    }
                }
                if (j == j2) {
                    if (this.cancelled) {
                        this.singleItem = null;
                        this.queue = null;
                        return;
                    }
                    if (this.error.get() != null) {
                        this.singleItem = null;
                        this.queue = null;
                        subscriber.onError(this.error.terminate());
                        return;
                    }
                    boolean z3 = this.mainDone;
                    io.reactivex.internal.fuseable.SimplePlainQueue<T> simplePlainQueue2 = this.queue;
                    boolean z4 = simplePlainQueue2 == null || simplePlainQueue2.isEmpty();
                    if (z3 && z4 && this.otherState == 2) {
                        this.queue = null;
                        subscriber.onComplete();
                        return;
                    }
                }
                this.emitted = j;
                this.consumed = i;
                i4 = addAndGet(-i4);
                if (i4 == 0) {
                    return;
                } else {
                    i3 = 1;
                }
            }
        }

        public io.reactivex.internal.fuseable.SimplePlainQueue<T> getOrCreateQueue() {
            io.reactivex.internal.fuseable.SimplePlainQueue<T> simplePlainQueue = this.queue;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            io.reactivex.internal.queue.SpscArrayQueue spscArrayQueue = new io.reactivex.internal.queue.SpscArrayQueue(io.reactivex.Flowable.bufferSize());
            this.queue = spscArrayQueue;
            return spscArrayQueue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.mainDone = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (!this.error.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                io.reactivex.internal.disposables.DisposableHelper.dispose(this.otherObserver);
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                long j = this.emitted;
                if (this.requested.get() != j) {
                    io.reactivex.internal.fuseable.SimplePlainQueue<T> simplePlainQueue = this.queue;
                    if (simplePlainQueue == null || simplePlainQueue.isEmpty()) {
                        this.emitted = j + 1;
                        this.downstream.onNext(t);
                        int i = this.consumed + 1;
                        if (i == this.limit) {
                            this.consumed = 0;
                            this.mainSubscription.get().request(i);
                        } else {
                            this.consumed = i;
                        }
                    } else {
                        simplePlainQueue.offer(t);
                    }
                } else {
                    getOrCreateQueue().offer(t);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                getOrCreateQueue().offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this.mainSubscription, subscription, this.prefetch);
        }

        public void otherComplete() {
            this.otherState = 2;
            drain();
        }

        public void otherError(java.lang.Throwable th) {
            if (!this.error.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.mainSubscription);
                drain();
            }
        }

        public void otherSuccess(T t) {
            if (compareAndSet(0, 1)) {
                long j = this.emitted;
                if (this.requested.get() != j) {
                    this.emitted = j + 1;
                    this.downstream.onNext(t);
                    this.otherState = 2;
                } else {
                    this.singleItem = t;
                    this.otherState = 1;
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            } else {
                this.singleItem = t;
                this.otherState = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            io.reactivex.internal.util.BackpressureHelper.add(this.requested, j);
            drain();
        }
    }

    public FlowableMergeWithMaybe(io.reactivex.Flowable<T> flowable, io.reactivex.MaybeSource<? extends T> maybeSource) {
        super(flowable);
        this.t = maybeSource;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe.MergeWithObserver mergeWithObserver = new io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe.MergeWithObserver(subscriber);
        subscriber.onSubscribe(mergeWithObserver);
        this.source.subscribe((io.reactivex.FlowableSubscriber) mergeWithObserver);
        this.t.subscribe(mergeWithObserver.otherObserver);
    }
}
