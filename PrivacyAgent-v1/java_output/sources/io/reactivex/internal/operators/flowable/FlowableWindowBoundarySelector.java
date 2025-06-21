package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableWindowBoundarySelector<T, B, V> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, io.reactivex.Flowable<T>> {
    public final org.reactivestreams.Publisher<B> t;
    public final io.reactivex.functions.Function<? super B, ? extends org.reactivestreams.Publisher<V>> u;
    public final int v;

    public static final class OperatorWindowBoundaryCloseSubscriber<T, V> extends io.reactivex.subscribers.DisposableSubscriber<V> {
        public final io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector.WindowBoundaryMainSubscriber<T, ?, V> t;
        public final io.reactivex.processors.UnicastProcessor<T> u;
        public boolean v;

        public OperatorWindowBoundaryCloseSubscriber(io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector.WindowBoundaryMainSubscriber<T, ?, V> windowBoundaryMainSubscriber, io.reactivex.processors.UnicastProcessor<T> unicastProcessor) {
            this.t = windowBoundaryMainSubscriber;
            this.u = unicastProcessor;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.v) {
                return;
            }
            this.v = true;
            this.t.a(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.v) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.v = true;
                this.t.c(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(V v) {
            cancel();
            onComplete();
        }
    }

    public static final class OperatorWindowBoundaryOpenSubscriber<T, B> extends io.reactivex.subscribers.DisposableSubscriber<B> {
        public final io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector.WindowBoundaryMainSubscriber<T, B, ?> t;

        public OperatorWindowBoundaryOpenSubscriber(io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector.WindowBoundaryMainSubscriber<T, B, ?> windowBoundaryMainSubscriber) {
            this.t = windowBoundaryMainSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.t.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.t.c(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B b) {
            this.t.d(b);
        }
    }

    public static final class WindowBoundaryMainSubscriber<T, B, V> extends io.reactivex.internal.subscribers.QueueDrainSubscriber<T, java.lang.Object, io.reactivex.Flowable<T>> implements org.reactivestreams.Subscription {
        public final java.util.List<io.reactivex.processors.UnicastProcessor<T>> A;
        public final java.util.concurrent.atomic.AtomicLong B;
        public final java.util.concurrent.atomic.AtomicBoolean C;
        public final org.reactivestreams.Publisher<B> u;
        public final io.reactivex.functions.Function<? super B, ? extends org.reactivestreams.Publisher<V>> v;
        public final int w;
        public final io.reactivex.disposables.CompositeDisposable x;
        public org.reactivestreams.Subscription y;
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> z;

        public WindowBoundaryMainSubscriber(org.reactivestreams.Subscriber<? super io.reactivex.Flowable<T>> subscriber, org.reactivestreams.Publisher<B> publisher, io.reactivex.functions.Function<? super B, ? extends org.reactivestreams.Publisher<V>> function, int i) {
            super(subscriber, new io.reactivex.internal.queue.MpscLinkedQueue());
            this.z = new java.util.concurrent.atomic.AtomicReference<>();
            java.util.concurrent.atomic.AtomicLong atomicLong = new java.util.concurrent.atomic.AtomicLong();
            this.B = atomicLong;
            this.C = new java.util.concurrent.atomic.AtomicBoolean();
            this.u = publisher;
            this.v = function;
            this.w = i;
            this.x = new io.reactivex.disposables.CompositeDisposable();
            this.A = new java.util.ArrayList();
            atomicLong.lazySet(1L);
        }

        public void a(io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector.OperatorWindowBoundaryCloseSubscriber<T, V> operatorWindowBoundaryCloseSubscriber) {
            this.x.delete(operatorWindowBoundaryCloseSubscriber);
            this.queue.offer(new io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector.WindowOperation(operatorWindowBoundaryCloseSubscriber.u, null));
            if (enter()) {
                b();
            }
        }

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public boolean accept(org.reactivestreams.Subscriber<? super io.reactivex.Flowable<T>> subscriber, java.lang.Object obj) {
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void b() {
            io.reactivex.internal.fuseable.SimpleQueue simpleQueue = this.queue;
            org.reactivestreams.Subscriber<? super V> subscriber = this.downstream;
            java.util.List<io.reactivex.processors.UnicastProcessor<T>> list = this.A;
            int i = 1;
            while (true) {
                boolean z = this.done;
                java.lang.Object poll = simpleQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    dispose();
                    java.lang.Throwable th = this.error;
                    if (th != null) {
                        java.util.Iterator<io.reactivex.processors.UnicastProcessor<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        java.util.Iterator<io.reactivex.processors.UnicastProcessor<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    return;
                }
                if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (poll instanceof io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector.WindowOperation) {
                    io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector.WindowOperation windowOperation = (io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector.WindowOperation) poll;
                    io.reactivex.processors.UnicastProcessor<T> unicastProcessor = windowOperation.a;
                    if (unicastProcessor != null) {
                        if (list.remove(unicastProcessor)) {
                            windowOperation.a.onComplete();
                            if (this.B.decrementAndGet() == 0) {
                                dispose();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.C.get()) {
                        io.reactivex.processors.UnicastProcessor<T> create = io.reactivex.processors.UnicastProcessor.create(this.w);
                        long requested = requested();
                        if (requested != 0) {
                            list.add(create);
                            subscriber.onNext(create);
                            if (requested != Long.MAX_VALUE) {
                                produced(1L);
                            }
                            try {
                                org.reactivestreams.Publisher publisher = (org.reactivestreams.Publisher) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.v.apply(windowOperation.b), "The publisher supplied is null");
                                io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector.OperatorWindowBoundaryCloseSubscriber operatorWindowBoundaryCloseSubscriber = new io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector.OperatorWindowBoundaryCloseSubscriber(this, create);
                                if (this.x.add(operatorWindowBoundaryCloseSubscriber)) {
                                    this.B.getAndIncrement();
                                    publisher.subscribe(operatorWindowBoundaryCloseSubscriber);
                                }
                            } catch (java.lang.Throwable th2) {
                                cancel();
                                subscriber.onError(th2);
                            }
                        } else {
                            cancel();
                            subscriber.onError(new io.reactivex.exceptions.MissingBackpressureException("Could not deliver new window due to lack of requests"));
                        }
                    }
                } else {
                    java.util.Iterator<io.reactivex.processors.UnicastProcessor<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(io.reactivex.internal.util.NotificationLite.getValue(poll));
                    }
                }
            }
        }

        public void c(java.lang.Throwable th) {
            this.y.cancel();
            this.x.dispose();
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.z);
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.C.compareAndSet(false, true)) {
                io.reactivex.internal.disposables.DisposableHelper.dispose(this.z);
                if (this.B.decrementAndGet() == 0) {
                    this.y.cancel();
                }
            }
        }

        public void d(B b) {
            this.queue.offer(new io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector.WindowOperation(null, b));
            if (enter()) {
                b();
            }
        }

        public void dispose() {
            this.x.dispose();
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.z);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            if (enter()) {
                b();
            }
            if (this.B.decrementAndGet() == 0) {
                this.x.dispose();
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.done) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            if (enter()) {
                b();
            }
            if (this.B.decrementAndGet() == 0) {
                this.x.dispose();
            }
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (fastEnter()) {
                java.util.Iterator<io.reactivex.processors.UnicastProcessor<T>> it = this.A.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(io.reactivex.internal.util.NotificationLite.next(t));
                if (!enter()) {
                    return;
                }
            }
            b();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.y, subscription)) {
                this.y = subscription;
                this.downstream.onSubscribe(this);
                if (this.C.get()) {
                    return;
                }
                io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector.OperatorWindowBoundaryOpenSubscriber operatorWindowBoundaryOpenSubscriber = new io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector.OperatorWindowBoundaryOpenSubscriber(this);
                if (defpackage.xv0.a(this.z, null, operatorWindowBoundaryOpenSubscriber)) {
                    subscription.request(Long.MAX_VALUE);
                    this.u.subscribe(operatorWindowBoundaryOpenSubscriber);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }
    }

    public static final class WindowOperation<T, B> {
        public final io.reactivex.processors.UnicastProcessor<T> a;
        public final B b;

        public WindowOperation(io.reactivex.processors.UnicastProcessor<T> unicastProcessor, B b) {
            this.a = unicastProcessor;
            this.b = b;
        }
    }

    public FlowableWindowBoundarySelector(io.reactivex.Flowable<T> flowable, org.reactivestreams.Publisher<B> publisher, io.reactivex.functions.Function<? super B, ? extends org.reactivestreams.Publisher<V>> function, int i) {
        super(flowable);
        this.t = publisher;
        this.u = function;
        this.v = i;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super io.reactivex.Flowable<T>> subscriber) {
        this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector.WindowBoundaryMainSubscriber(new io.reactivex.subscribers.SerializedSubscriber(subscriber), this.t, this.u, this.v));
    }
}
