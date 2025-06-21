package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowablePublishMulticast<T, R> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, R> {
    public final io.reactivex.functions.Function<? super io.reactivex.Flowable<T>, ? extends org.reactivestreams.Publisher<? extends R>> t;
    public final int u;
    public final boolean v;

    public static final class MulticastProcessor<T> extends io.reactivex.Flowable<T> implements io.reactivex.FlowableSubscriber<T>, io.reactivex.disposables.Disposable {
        public static final io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[] E = new io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[0];
        public static final io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[] F = new io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[0];
        public int A;
        public volatile boolean B;
        public java.lang.Throwable C;
        public int D;
        public final int v;
        public final int w;
        public final boolean x;
        public volatile io.reactivex.internal.fuseable.SimpleQueue<T> z;
        public final java.util.concurrent.atomic.AtomicInteger t = new java.util.concurrent.atomic.AtomicInteger();
        public final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> y = new java.util.concurrent.atomic.AtomicReference<>();
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription<T>[]> u = new java.util.concurrent.atomic.AtomicReference<>(E);

        public MulticastProcessor(int i, boolean z) {
            this.v = i;
            this.w = i - (i >> 2);
            this.x = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.fuseable.SimpleQueue<T> simpleQueue;
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.y);
            if (this.t.getAndIncrement() != 0 || (simpleQueue = this.z) == null) {
                return;
            }
            simpleQueue.clear();
        }

        public boolean e(io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription<T> multicastSubscription) {
            io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription<T>[] multicastSubscriptionArr;
            io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = this.u.get();
                if (multicastSubscriptionArr == F) {
                    return false;
                }
                int length = multicastSubscriptionArr.length;
                multicastSubscriptionArr2 = new io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[length + 1];
                java.lang.System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
                multicastSubscriptionArr2[length] = multicastSubscription;
            } while (!defpackage.xv0.a(this.u, multicastSubscriptionArr, multicastSubscriptionArr2));
            return true;
        }

        public void f() {
            for (io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription<T> multicastSubscription : this.u.getAndSet(F)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.downstream.onComplete();
                }
            }
        }

        public void g() {
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription<T>[]> atomicReference;
            java.lang.Throwable th;
            java.lang.Throwable th2;
            if (this.t.getAndIncrement() != 0) {
                return;
            }
            io.reactivex.internal.fuseable.SimpleQueue<T> simpleQueue = this.z;
            int i = this.D;
            int i2 = this.w;
            boolean z = this.A != 1;
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription<T>[]> atomicReference2 = this.u;
            io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription<T>[] multicastSubscriptionArr = atomicReference2.get();
            int i3 = 1;
            while (true) {
                int length = multicastSubscriptionArr.length;
                if (simpleQueue == null || length == 0) {
                    atomicReference = atomicReference2;
                } else {
                    int length2 = multicastSubscriptionArr.length;
                    long j = Long.MAX_VALUE;
                    long j2 = Long.MAX_VALUE;
                    int i4 = 0;
                    while (i4 < length2) {
                        io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription<T> multicastSubscription = multicastSubscriptionArr[i4];
                        java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription<T>[]> atomicReference3 = atomicReference2;
                        long j3 = multicastSubscription.get() - multicastSubscription.emitted;
                        if (j3 == Long.MIN_VALUE) {
                            length--;
                        } else if (j2 > j3) {
                            j2 = j3;
                        }
                        i4++;
                        atomicReference2 = atomicReference3;
                    }
                    atomicReference = atomicReference2;
                    long j4 = 0;
                    if (length == 0) {
                        j2 = 0;
                    }
                    while (j2 != j4) {
                        if (isDisposed()) {
                            simpleQueue.clear();
                            return;
                        }
                        boolean z2 = this.B;
                        if (z2 && !this.x && (th2 = this.C) != null) {
                            h(th2);
                            return;
                        }
                        try {
                            T poll = simpleQueue.poll();
                            boolean z3 = poll == null;
                            if (z2 && z3) {
                                java.lang.Throwable th3 = this.C;
                                if (th3 != null) {
                                    h(th3);
                                    return;
                                } else {
                                    f();
                                    return;
                                }
                            }
                            if (z3) {
                                break;
                            }
                            int length3 = multicastSubscriptionArr.length;
                            int i5 = 0;
                            boolean z4 = false;
                            while (i5 < length3) {
                                io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription<T> multicastSubscription2 = multicastSubscriptionArr[i5];
                                long j5 = multicastSubscription2.get();
                                if (j5 != Long.MIN_VALUE) {
                                    if (j5 != j) {
                                        multicastSubscription2.emitted++;
                                    }
                                    multicastSubscription2.downstream.onNext(poll);
                                } else {
                                    z4 = true;
                                }
                                i5++;
                                j = Long.MAX_VALUE;
                            }
                            j2--;
                            if (z && (i = i + 1) == i2) {
                                this.y.get().request(i2);
                                i = 0;
                            }
                            io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription<T>[] multicastSubscriptionArr2 = atomicReference.get();
                            if (z4 || multicastSubscriptionArr2 != multicastSubscriptionArr) {
                                multicastSubscriptionArr = multicastSubscriptionArr2;
                                break;
                            } else {
                                j4 = 0;
                                j = Long.MAX_VALUE;
                            }
                        } catch (java.lang.Throwable th4) {
                            io.reactivex.exceptions.Exceptions.throwIfFatal(th4);
                            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.y);
                            h(th4);
                            return;
                        }
                    }
                    if (j2 == j4) {
                        if (isDisposed()) {
                            simpleQueue.clear();
                            return;
                        }
                        boolean z5 = this.B;
                        if (z5 && !this.x && (th = this.C) != null) {
                            h(th);
                            return;
                        }
                        if (z5 && simpleQueue.isEmpty()) {
                            java.lang.Throwable th5 = this.C;
                            if (th5 != null) {
                                h(th5);
                                return;
                            } else {
                                f();
                                return;
                            }
                        }
                    }
                }
                this.D = i;
                i3 = this.t.addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
                if (simpleQueue == null) {
                    simpleQueue = this.z;
                }
                multicastSubscriptionArr = atomicReference.get();
                atomicReference2 = atomicReference;
            }
        }

        public void h(java.lang.Throwable th) {
            for (io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription<T> multicastSubscription : this.u.getAndSet(F)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.downstream.onError(th);
                }
            }
        }

        public void i(io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription<T> multicastSubscription) {
            io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription<T>[] multicastSubscriptionArr;
            io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = this.u.get();
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
                if (length == 1) {
                    multicastSubscriptionArr2 = E;
                } else {
                    io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[] multicastSubscriptionArr3 = new io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[length - 1];
                    java.lang.System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr3, 0, i);
                    java.lang.System.arraycopy(multicastSubscriptionArr, i + 1, multicastSubscriptionArr3, i, (length - i) - 1);
                    multicastSubscriptionArr2 = multicastSubscriptionArr3;
                }
            } while (!defpackage.xv0.a(this.u, multicastSubscriptionArr, multicastSubscriptionArr2));
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.y.get() == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.B) {
                return;
            }
            this.B = true;
            g();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.B) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.C = th;
            this.B = true;
            g();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.B) {
                return;
            }
            if (this.A != 0 || this.z.offer(t)) {
                g();
            } else {
                this.y.get().cancel();
                onError(new io.reactivex.exceptions.MissingBackpressureException());
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this.y, subscription)) {
                if (subscription instanceof io.reactivex.internal.fuseable.QueueSubscription) {
                    io.reactivex.internal.fuseable.QueueSubscription queueSubscription = (io.reactivex.internal.fuseable.QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.A = requestFusion;
                        this.z = queueSubscription;
                        this.B = true;
                        g();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.A = requestFusion;
                        this.z = queueSubscription;
                        io.reactivex.internal.util.QueueDrainHelper.request(subscription, this.v);
                        return;
                    }
                }
                this.z = io.reactivex.internal.util.QueueDrainHelper.createQueue(this.v);
                io.reactivex.internal.util.QueueDrainHelper.request(subscription, this.v);
            }
        }

        @Override // io.reactivex.Flowable
        public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
            io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription<T> multicastSubscription = new io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription<>(subscriber, this);
            subscriber.onSubscribe(multicastSubscription);
            if (e(multicastSubscription)) {
                if (multicastSubscription.isCancelled()) {
                    i(multicastSubscription);
                    return;
                } else {
                    g();
                    return;
                }
            }
            java.lang.Throwable th = this.C;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onComplete();
            }
        }
    }

    public static final class MulticastSubscription<T> extends java.util.concurrent.atomic.AtomicLong implements org.reactivestreams.Subscription {
        private static final long serialVersionUID = 8664815189257569791L;
        final org.reactivestreams.Subscriber<? super T> downstream;
        long emitted;
        final io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastProcessor<T> parent;

        public MulticastSubscription(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastProcessor<T> multicastProcessor) {
            this.downstream = subscriber;
            this.parent = multicastProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.i(this);
                this.parent.g();
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.BackpressureHelper.addCancel(this, j);
                this.parent.g();
            }
        }
    }

    public static final class OutputCanceller<R> implements io.reactivex.FlowableSubscriber<R>, org.reactivestreams.Subscription {
        public final org.reactivestreams.Subscriber<? super R> n;
        public final io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastProcessor<?> t;
        public org.reactivestreams.Subscription u;

        public OutputCanceller(org.reactivestreams.Subscriber<? super R> subscriber, io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastProcessor<?> multicastProcessor) {
            this.n = subscriber;
            this.t = multicastProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.u.cancel();
            this.t.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.n.onComplete();
            this.t.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.n.onError(th);
            this.t.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r) {
            this.n.onNext(r);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.u, subscription)) {
                this.u = subscription;
                this.n.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.u.request(j);
        }
    }

    public FlowablePublishMulticast(io.reactivex.Flowable<T> flowable, io.reactivex.functions.Function<? super io.reactivex.Flowable<T>, ? extends org.reactivestreams.Publisher<? extends R>> function, int i, boolean z) {
        super(flowable);
        this.t = function;
        this.u = i;
        this.v = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super R> subscriber) {
        io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastProcessor multicastProcessor = new io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastProcessor(this.u, this.v);
        try {
            ((org.reactivestreams.Publisher) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(multicastProcessor), "selector returned a null Publisher")).subscribe(new io.reactivex.internal.operators.flowable.FlowablePublishMulticast.OutputCanceller(subscriber, multicastProcessor));
            this.source.subscribe((io.reactivex.FlowableSubscriber) multicastProcessor);
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.subscriptions.EmptySubscription.error(th, subscriber);
        }
    }
}
