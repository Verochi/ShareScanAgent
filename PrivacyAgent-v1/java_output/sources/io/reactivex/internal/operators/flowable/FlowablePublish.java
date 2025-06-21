package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowablePublish<T> extends io.reactivex.flowables.ConnectableFlowable<T> implements io.reactivex.internal.fuseable.HasUpstreamPublisher<T>, io.reactivex.internal.operators.flowable.FlowablePublishClassic<T> {
    public final io.reactivex.Flowable<T> t;
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber<T>> u;
    public final int v;
    public final org.reactivestreams.Publisher<T> w;

    public static final class FlowablePublisher<T> implements org.reactivestreams.Publisher<T> {
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber<T>> n;
        public final int t;

        public FlowablePublisher(java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber<T>> atomicReference, int i) {
            this.n = atomicReference;
            this.t = i;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(org.reactivestreams.Subscriber<? super T> subscriber) {
            io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber<T> publishSubscriber;
            io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber<T> innerSubscriber = new io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber<>(subscriber);
            subscriber.onSubscribe(innerSubscriber);
            while (true) {
                publishSubscriber = this.n.get();
                if (publishSubscriber == null || publishSubscriber.isDisposed()) {
                    io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber<T> publishSubscriber2 = new io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber<>(this.n, this.t);
                    if (defpackage.xv0.a(this.n, publishSubscriber, publishSubscriber2)) {
                        publishSubscriber = publishSubscriber2;
                    } else {
                        continue;
                    }
                }
                if (publishSubscriber.add(innerSubscriber)) {
                    break;
                }
            }
            if (innerSubscriber.get() == Long.MIN_VALUE) {
                publishSubscriber.remove(innerSubscriber);
            } else {
                innerSubscriber.parent = publishSubscriber;
            }
            publishSubscriber.dispatch();
        }
    }

    public static final class InnerSubscriber<T> extends java.util.concurrent.atomic.AtomicLong implements org.reactivestreams.Subscription {
        private static final long serialVersionUID = -4453897557930727610L;
        final org.reactivestreams.Subscriber<? super T> child;
        long emitted;
        volatile io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber<T> parent;

        public InnerSubscriber(org.reactivestreams.Subscriber<? super T> subscriber) {
            this.child = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber<T> publishSubscriber;
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE || (publishSubscriber = this.parent) == null) {
                return;
            }
            publishSubscriber.remove(this);
            publishSubscriber.dispatch();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.BackpressureHelper.addCancel(this, j);
                io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber<T> publishSubscriber = this.parent;
                if (publishSubscriber != null) {
                    publishSubscriber.dispatch();
                }
            }
        }
    }

    public static final class PublishSubscriber<T> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.FlowableSubscriber<T>, io.reactivex.disposables.Disposable {
        static final io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber[] EMPTY = new io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber[0];
        static final io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber[] TERMINATED = new io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber[0];
        private static final long serialVersionUID = -202316842419149694L;
        final int bufferSize;
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber<T>> current;
        volatile io.reactivex.internal.fuseable.SimpleQueue<T> queue;
        int sourceMode;
        volatile java.lang.Object terminalEvent;
        final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> upstream = new java.util.concurrent.atomic.AtomicReference<>();
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber<T>[]> subscribers = new java.util.concurrent.atomic.AtomicReference<>(EMPTY);
        final java.util.concurrent.atomic.AtomicBoolean shouldConnect = new java.util.concurrent.atomic.AtomicBoolean();

        public PublishSubscriber(java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber<T>> atomicReference, int i) {
            this.current = atomicReference;
            this.bufferSize = i;
        }

        public boolean add(io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber<T> innerSubscriber) {
            io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber<T>[] innerSubscriberArr;
            io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                if (innerSubscriberArr == TERMINATED) {
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber[length + 1];
                java.lang.System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!defpackage.xv0.a(this.subscribers, innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        public boolean checkTerminated(java.lang.Object obj, boolean z) {
            int i = 0;
            if (obj != null) {
                if (!io.reactivex.internal.util.NotificationLite.isComplete(obj)) {
                    java.lang.Throwable error = io.reactivex.internal.util.NotificationLite.getError(obj);
                    defpackage.xv0.a(this.current, this, null);
                    io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber<T>[] andSet = this.subscribers.getAndSet(TERMINATED);
                    if (andSet.length != 0) {
                        int length = andSet.length;
                        while (i < length) {
                            andSet[i].child.onError(error);
                            i++;
                        }
                    } else {
                        io.reactivex.plugins.RxJavaPlugins.onError(error);
                    }
                    return true;
                }
                if (z) {
                    defpackage.xv0.a(this.current, this, null);
                    io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber<T>[] andSet2 = this.subscribers.getAndSet(TERMINATED);
                    int length2 = andSet2.length;
                    while (i < length2) {
                        andSet2[i].child.onComplete();
                        i++;
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:57:0x011f, code lost:
        
            if (r11 == 0) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0124, code lost:
        
            if (r25.sourceMode == 1) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0126, code lost:
        
            r25.upstream.get().request(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0132, code lost:
        
            r4 = r0;
            r3 = 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0136, code lost:
        
            if (r11 == 0) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0138, code lost:
        
            r3 = 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x013b, code lost:
        
            if (r25.sourceMode == 1) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x013d, code lost:
        
            r25.upstream.get().request(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x014e, code lost:
        
            if (r14 == 0) goto L105;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0150, code lost:
        
            if (r8 != false) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0014, code lost:
        
            continue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0149, code lost:
        
            r3 = 1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void dispatch() {
            T t;
            T t2;
            io.reactivex.internal.fuseable.SimpleQueue<T> simpleQueue;
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber<T>[]> atomicReference = this.subscribers;
            int i = 1;
            io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber<T>[] innerSubscriberArr = atomicReference.get();
            int i2 = 1;
            while (true) {
                java.lang.Object obj = this.terminalEvent;
                io.reactivex.internal.fuseable.SimpleQueue<T> simpleQueue2 = this.queue;
                boolean z2 = simpleQueue2 == null || simpleQueue2.isEmpty();
                if (checkTerminated(obj, z2)) {
                    return;
                }
                if (!z2) {
                    int length = innerSubscriberArr.length;
                    int i3 = 0;
                    long j = Long.MAX_VALUE;
                    for (io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber<T> innerSubscriber : innerSubscriberArr) {
                        long j2 = innerSubscriber.get();
                        if (j2 != Long.MIN_VALUE) {
                            j = java.lang.Math.min(j, j2 - innerSubscriber.emitted);
                        } else {
                            i3++;
                        }
                    }
                    if (length != i3) {
                        int i4 = 0;
                        while (true) {
                            long j3 = i4;
                            if (j3 >= j) {
                                break;
                            }
                            java.lang.Object obj2 = this.terminalEvent;
                            try {
                                t2 = simpleQueue2.poll();
                            } catch (java.lang.Throwable th) {
                                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                                this.upstream.get().cancel();
                                obj2 = io.reactivex.internal.util.NotificationLite.error(th);
                                this.terminalEvent = obj2;
                                t2 = null;
                            }
                            boolean z3 = t2 == null;
                            if (checkTerminated(obj2, z3)) {
                                return;
                            }
                            if (z3) {
                                z2 = z3;
                                break;
                            }
                            java.lang.Object value = io.reactivex.internal.util.NotificationLite.getValue(t2);
                            int length2 = innerSubscriberArr.length;
                            int i5 = 0;
                            boolean z4 = false;
                            while (i5 < length2) {
                                io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber<T> innerSubscriber2 = innerSubscriberArr[i5];
                                long j4 = innerSubscriber2.get();
                                if (j4 != Long.MIN_VALUE) {
                                    simpleQueue = simpleQueue2;
                                    z = z3;
                                    if (j4 != Long.MAX_VALUE) {
                                        innerSubscriber2.emitted++;
                                    }
                                    innerSubscriber2.child.onNext(value);
                                } else {
                                    simpleQueue = simpleQueue2;
                                    z = z3;
                                    z4 = true;
                                }
                                i5++;
                                simpleQueue2 = simpleQueue;
                                z3 = z;
                            }
                            io.reactivex.internal.fuseable.SimpleQueue<T> simpleQueue3 = simpleQueue2;
                            boolean z5 = z3;
                            i4++;
                            io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber<T>[] innerSubscriberArr2 = atomicReference.get();
                            if (z4 || innerSubscriberArr2 != innerSubscriberArr) {
                                break;
                            }
                            simpleQueue2 = simpleQueue3;
                            z2 = z5;
                        }
                    } else {
                        java.lang.Object obj3 = this.terminalEvent;
                        try {
                            t = simpleQueue2.poll();
                        } catch (java.lang.Throwable th2) {
                            io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                            this.upstream.get().cancel();
                            obj3 = io.reactivex.internal.util.NotificationLite.error(th2);
                            this.terminalEvent = obj3;
                            t = null;
                        }
                        if (checkTerminated(obj3, t == null)) {
                            return;
                        }
                        if (this.sourceMode != i) {
                            this.upstream.get().request(1L);
                        }
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                } else {
                    innerSubscriberArr = atomicReference.get();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber<T>[] innerSubscriberArr = this.subscribers.get();
            io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber<T>[] innerSubscriberArr2 = TERMINATED;
            if (innerSubscriberArr == innerSubscriberArr2 || this.subscribers.getAndSet(innerSubscriberArr2) == innerSubscriberArr2) {
                return;
            }
            defpackage.xv0.a(this.current, this, null);
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.terminalEvent == null) {
                this.terminalEvent = io.reactivex.internal.util.NotificationLite.complete();
                dispatch();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.terminalEvent != null) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.terminalEvent = io.reactivex.internal.util.NotificationLite.error(th);
                dispatch();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                dispatch();
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
                        this.terminalEvent = io.reactivex.internal.util.NotificationLite.complete();
                        dispatch();
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

        public void remove(io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber<T> innerSubscriber) {
            io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber<T>[] innerSubscriberArr;
            io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber[] innerSubscriberArr2;
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
                    } else if (innerSubscriberArr[i].equals(innerSubscriber)) {
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
                    io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber[] innerSubscriberArr3 = new io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber[length - 1];
                    java.lang.System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i);
                    java.lang.System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr3, i, (length - i) - 1);
                    innerSubscriberArr2 = innerSubscriberArr3;
                }
            } while (!defpackage.xv0.a(this.subscribers, innerSubscriberArr, innerSubscriberArr2));
        }
    }

    public FlowablePublish(org.reactivestreams.Publisher<T> publisher, io.reactivex.Flowable<T> flowable, java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber<T>> atomicReference, int i) {
        this.w = publisher;
        this.t = flowable;
        this.u = atomicReference;
        this.v = i;
    }

    public static <T> io.reactivex.flowables.ConnectableFlowable<T> create(io.reactivex.Flowable<T> flowable, int i) {
        java.util.concurrent.atomic.AtomicReference atomicReference = new java.util.concurrent.atomic.AtomicReference();
        return io.reactivex.plugins.RxJavaPlugins.onAssembly((io.reactivex.flowables.ConnectableFlowable) new io.reactivex.internal.operators.flowable.FlowablePublish(new io.reactivex.internal.operators.flowable.FlowablePublish.FlowablePublisher(atomicReference, i), flowable, atomicReference, i));
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public void connect(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer) {
        io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber<T> publishSubscriber;
        while (true) {
            publishSubscriber = this.u.get();
            if (publishSubscriber != null && !publishSubscriber.isDisposed()) {
                break;
            }
            io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber<T> publishSubscriber2 = new io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber<>(this.u, this.v);
            if (defpackage.xv0.a(this.u, publishSubscriber, publishSubscriber2)) {
                publishSubscriber = publishSubscriber2;
                break;
            }
        }
        boolean z = false;
        if (!publishSubscriber.shouldConnect.get() && publishSubscriber.shouldConnect.compareAndSet(false, true)) {
            z = true;
        }
        try {
            consumer.accept(publishSubscriber);
            if (z) {
                this.t.subscribe((io.reactivex.FlowableSubscriber) publishSubscriber);
            }
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.internal.operators.flowable.FlowablePublishClassic
    public int publishBufferSize() {
        return this.v;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowablePublishClassic
    public org.reactivestreams.Publisher<T> publishSource() {
        return this.t;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public org.reactivestreams.Publisher<T> source() {
        return this.t;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.w.subscribe(subscriber);
    }
}
