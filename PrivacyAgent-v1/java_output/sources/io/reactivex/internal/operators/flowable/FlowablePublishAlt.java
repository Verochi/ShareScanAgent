package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowablePublishAlt<T> extends io.reactivex.flowables.ConnectableFlowable<T> implements io.reactivex.internal.fuseable.HasUpstreamPublisher<T>, io.reactivex.internal.disposables.ResettableConnectable {
    public final org.reactivestreams.Publisher<T> t;
    public final int u;
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublishAlt.PublishConnection<T>> v = new java.util.concurrent.atomic.AtomicReference<>();

    public static final class InnerSubscription<T> extends java.util.concurrent.atomic.AtomicLong implements org.reactivestreams.Subscription {
        private static final long serialVersionUID = 2845000326761540265L;
        final org.reactivestreams.Subscriber<? super T> downstream;
        long emitted;
        final io.reactivex.internal.operators.flowable.FlowablePublishAlt.PublishConnection<T> parent;

        public InnerSubscription(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.internal.operators.flowable.FlowablePublishAlt.PublishConnection<T> publishConnection) {
            this.downstream = subscriber;
            this.parent = publishConnection;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.drain();
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            io.reactivex.internal.util.BackpressureHelper.addCancel(this, j);
            this.parent.drain();
        }
    }

    public static final class PublishConnection<T> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.FlowableSubscriber<T>, io.reactivex.disposables.Disposable {
        static final io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription[] EMPTY = new io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription[0];
        static final io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription[] TERMINATED = new io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription[0];
        private static final long serialVersionUID = -1672047311619175801L;
        final int bufferSize;
        int consumed;
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublishAlt.PublishConnection<T>> current;
        volatile boolean done;
        java.lang.Throwable error;
        volatile io.reactivex.internal.fuseable.SimpleQueue<T> queue;
        int sourceMode;
        final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> upstream = new java.util.concurrent.atomic.AtomicReference<>();
        final java.util.concurrent.atomic.AtomicBoolean connect = new java.util.concurrent.atomic.AtomicBoolean();
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription<T>[]> subscribers = new java.util.concurrent.atomic.AtomicReference<>(EMPTY);

        public PublishConnection(java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublishAlt.PublishConnection<T>> atomicReference, int i) {
            this.current = atomicReference;
            this.bufferSize = i;
        }

        public boolean add(io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription<T> innerSubscription) {
            io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription<T>[] innerSubscriptionArr;
            io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.subscribers.get();
                if (innerSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription[length + 1];
                java.lang.System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!defpackage.xv0.a(this.subscribers, innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        public boolean checkTerminated(boolean z, boolean z2) {
            if (!z || !z2) {
                return false;
            }
            java.lang.Throwable th = this.error;
            if (th != null) {
                signalError(th);
                return true;
            }
            for (io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                if (!innerSubscription.isCancelled()) {
                    innerSubscription.downstream.onComplete();
                }
            }
            return true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.subscribers.getAndSet(TERMINATED);
            defpackage.xv0.a(this.current, this, null);
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.internal.fuseable.SimpleQueue<T> simpleQueue = this.queue;
            int i = this.consumed;
            int i2 = this.bufferSize;
            int i3 = i2 - (i2 >> 2);
            boolean z = this.sourceMode != 1;
            int i4 = 1;
            io.reactivex.internal.fuseable.SimpleQueue<T> simpleQueue2 = simpleQueue;
            int i5 = i;
            while (true) {
                if (simpleQueue2 != null) {
                    io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription<T>[] innerSubscriptionArr = this.subscribers.get();
                    long j = Long.MAX_VALUE;
                    boolean z2 = false;
                    for (io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription<T> innerSubscription : innerSubscriptionArr) {
                        long j2 = innerSubscription.get();
                        if (j2 != Long.MIN_VALUE) {
                            j = java.lang.Math.min(j2 - innerSubscription.emitted, j);
                            z2 = true;
                        }
                    }
                    if (!z2) {
                        j = 0;
                    }
                    for (long j3 = 0; j != j3; j3 = 0) {
                        boolean z3 = this.done;
                        try {
                            T poll = simpleQueue2.poll();
                            boolean z4 = poll == null;
                            if (checkTerminated(z3, z4)) {
                                return;
                            }
                            if (z4) {
                                break;
                            }
                            for (io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription<T> innerSubscription2 : innerSubscriptionArr) {
                                if (!innerSubscription2.isCancelled()) {
                                    innerSubscription2.downstream.onNext(poll);
                                    innerSubscription2.emitted++;
                                }
                            }
                            if (z && (i5 = i5 + 1) == i3) {
                                this.upstream.get().request(i3);
                                i5 = 0;
                            }
                            j--;
                            if (innerSubscriptionArr != this.subscribers.get()) {
                                break;
                            }
                        } catch (java.lang.Throwable th) {
                            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                            this.upstream.get().cancel();
                            simpleQueue2.clear();
                            this.done = true;
                            signalError(th);
                            return;
                        }
                    }
                    if (checkTerminated(this.done, simpleQueue2.isEmpty())) {
                        return;
                    }
                }
                this.consumed = i5;
                i4 = addAndGet(-i4);
                if (i4 == 0) {
                    return;
                }
                if (simpleQueue2 == null) {
                    simpleQueue2 = this.queue;
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.done) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                drain();
            } else {
                onError(new io.reactivex.exceptions.MissingBackpressureException("Prefetch queue is full?!"));
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this.upstream, subscription)) {
                if (subscription instanceof io.reactivex.internal.fuseable.QueueSubscription) {
                    io.reactivex.internal.fuseable.QueueSubscription queueSubscription = (io.reactivex.internal.fuseable.QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        subscription.request(this.bufferSize);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.SpscArrayQueue(this.bufferSize);
                subscription.request(this.bufferSize);
            }
        }

        public void remove(io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription<T> innerSubscription) {
            io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription<T>[] innerSubscriptionArr;
            io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.subscribers.get();
                int length = innerSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (innerSubscriptionArr[i] == innerSubscription) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriptionArr2 = EMPTY;
                } else {
                    io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription[] innerSubscriptionArr3 = new io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription[length - 1];
                    java.lang.System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i);
                    java.lang.System.arraycopy(innerSubscriptionArr, i + 1, innerSubscriptionArr3, i, (length - i) - 1);
                    innerSubscriptionArr2 = innerSubscriptionArr3;
                }
            } while (!defpackage.xv0.a(this.subscribers, innerSubscriptionArr, innerSubscriptionArr2));
        }

        public void signalError(java.lang.Throwable th) {
            for (io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                if (!innerSubscription.isCancelled()) {
                    innerSubscription.downstream.onError(th);
                }
            }
        }
    }

    public FlowablePublishAlt(org.reactivestreams.Publisher<T> publisher, int i) {
        this.t = publisher;
        this.u = i;
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public void connect(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer) {
        io.reactivex.internal.operators.flowable.FlowablePublishAlt.PublishConnection<T> publishConnection;
        while (true) {
            publishConnection = this.v.get();
            if (publishConnection != null && !publishConnection.isDisposed()) {
                break;
            }
            io.reactivex.internal.operators.flowable.FlowablePublishAlt.PublishConnection<T> publishConnection2 = new io.reactivex.internal.operators.flowable.FlowablePublishAlt.PublishConnection<>(this.v, this.u);
            if (defpackage.xv0.a(this.v, publishConnection, publishConnection2)) {
                publishConnection = publishConnection2;
                break;
            }
        }
        boolean z = false;
        if (!publishConnection.connect.get() && publishConnection.connect.compareAndSet(false, true)) {
            z = true;
        }
        try {
            consumer.accept(publishConnection);
            if (z) {
                this.t.subscribe(publishConnection);
            }
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
    }

    public int publishBufferSize() {
        return this.u;
    }

    @Override // io.reactivex.internal.disposables.ResettableConnectable
    public void resetIf(io.reactivex.disposables.Disposable disposable) {
        defpackage.xv0.a(this.v, (io.reactivex.internal.operators.flowable.FlowablePublishAlt.PublishConnection) disposable, null);
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public org.reactivestreams.Publisher<T> source() {
        return this.t;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.internal.operators.flowable.FlowablePublishAlt.PublishConnection<T> publishConnection;
        while (true) {
            publishConnection = this.v.get();
            if (publishConnection != null) {
                break;
            }
            io.reactivex.internal.operators.flowable.FlowablePublishAlt.PublishConnection<T> publishConnection2 = new io.reactivex.internal.operators.flowable.FlowablePublishAlt.PublishConnection<>(this.v, this.u);
            if (defpackage.xv0.a(this.v, publishConnection, publishConnection2)) {
                publishConnection = publishConnection2;
                break;
            }
        }
        io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription<T> innerSubscription = new io.reactivex.internal.operators.flowable.FlowablePublishAlt.InnerSubscription<>(subscriber, publishConnection);
        subscriber.onSubscribe(innerSubscription);
        if (publishConnection.add(innerSubscription)) {
            if (innerSubscription.isCancelled()) {
                publishConnection.remove(innerSubscription);
                return;
            } else {
                publishConnection.drain();
                return;
            }
        }
        java.lang.Throwable th = publishConnection.error;
        if (th != null) {
            subscriber.onError(th);
        } else {
            subscriber.onComplete();
        }
    }
}
