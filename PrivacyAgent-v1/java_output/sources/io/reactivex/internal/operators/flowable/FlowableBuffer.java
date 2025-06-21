package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableBuffer<T, C extends java.util.Collection<? super T>> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, C> {
    public final int t;
    public final int u;
    public final java.util.concurrent.Callable<C> v;

    public static final class PublisherBufferExactSubscriber<T, C extends java.util.Collection<? super T>> implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        public final org.reactivestreams.Subscriber<? super C> n;
        public final java.util.concurrent.Callable<C> t;
        public final int u;
        public C v;
        public org.reactivestreams.Subscription w;
        public boolean x;
        public int y;

        public PublisherBufferExactSubscriber(org.reactivestreams.Subscriber<? super C> subscriber, int i, java.util.concurrent.Callable<C> callable) {
            this.n = subscriber;
            this.u = i;
            this.t = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.w.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.x) {
                return;
            }
            this.x = true;
            C c = this.v;
            if (c != null && !c.isEmpty()) {
                this.n.onNext(c);
            }
            this.n.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.x) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.x = true;
                this.n.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.x) {
                return;
            }
            C c = this.v;
            if (c == null) {
                try {
                    c = (C) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The bufferSupplier returned a null buffer");
                    this.v = c;
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            c.add(t);
            int i = this.y + 1;
            if (i != this.u) {
                this.y = i;
                return;
            }
            this.y = 0;
            this.v = null;
            this.n.onNext(c);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.w, subscription)) {
                this.w = subscription;
                this.n.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                this.w.request(io.reactivex.internal.util.BackpressureHelper.multiplyCap(j, this.u));
            }
        }
    }

    public static final class PublisherBufferOverlappingSubscriber<T, C extends java.util.Collection<? super T>> extends java.util.concurrent.atomic.AtomicLong implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription, io.reactivex.functions.BooleanSupplier {
        private static final long serialVersionUID = -7370244972039324525L;
        final java.util.concurrent.Callable<C> bufferSupplier;
        volatile boolean cancelled;
        boolean done;
        final org.reactivestreams.Subscriber<? super C> downstream;
        int index;
        long produced;
        final int size;
        final int skip;
        org.reactivestreams.Subscription upstream;
        final java.util.concurrent.atomic.AtomicBoolean once = new java.util.concurrent.atomic.AtomicBoolean();
        final java.util.ArrayDeque<C> buffers = new java.util.ArrayDeque<>();

        public PublisherBufferOverlappingSubscriber(org.reactivestreams.Subscriber<? super C> subscriber, int i, int i2, java.util.concurrent.Callable<C> callable) {
            this.downstream = subscriber;
            this.size = i;
            this.skip = i2;
            this.bufferSupplier = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
        }

        @Override // io.reactivex.functions.BooleanSupplier
        public boolean getAsBoolean() {
            return this.cancelled;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            long j = this.produced;
            if (j != 0) {
                io.reactivex.internal.util.BackpressureHelper.produced(this, j);
            }
            io.reactivex.internal.util.QueueDrainHelper.postComplete(this.downstream, this.buffers, this, this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.done) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.buffers.clear();
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            java.util.ArrayDeque<C> arrayDeque = this.buffers;
            int i = this.index;
            int i2 = i + 1;
            if (i == 0) {
                try {
                    arrayDeque.offer((java.util.Collection) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer"));
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            java.util.Collection collection = (java.util.Collection) arrayDeque.peek();
            if (collection != null && collection.size() + 1 == this.size) {
                arrayDeque.poll();
                collection.add(t);
                this.produced++;
                this.downstream.onNext(collection);
            }
            java.util.Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                ((java.util.Collection) it.next()).add(t);
            }
            if (i2 == this.skip) {
                i2 = 0;
            }
            this.index = i2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (!io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j) || io.reactivex.internal.util.QueueDrainHelper.postCompleteRequest(j, this.downstream, this.buffers, this, this)) {
                return;
            }
            if (this.once.get() || !this.once.compareAndSet(false, true)) {
                this.upstream.request(io.reactivex.internal.util.BackpressureHelper.multiplyCap(this.skip, j));
            } else {
                this.upstream.request(io.reactivex.internal.util.BackpressureHelper.addCap(this.size, io.reactivex.internal.util.BackpressureHelper.multiplyCap(this.skip, j - 1)));
            }
        }
    }

    public static final class PublisherBufferSkipSubscriber<T, C extends java.util.Collection<? super T>> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        private static final long serialVersionUID = -5616169793639412593L;
        C buffer;
        final java.util.concurrent.Callable<C> bufferSupplier;
        boolean done;
        final org.reactivestreams.Subscriber<? super C> downstream;
        int index;
        final int size;
        final int skip;
        org.reactivestreams.Subscription upstream;

        public PublisherBufferSkipSubscriber(org.reactivestreams.Subscriber<? super C> subscriber, int i, int i2, java.util.concurrent.Callable<C> callable) {
            this.downstream = subscriber;
            this.size = i;
            this.skip = i2;
            this.bufferSupplier = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C c = this.buffer;
            this.buffer = null;
            if (c != null) {
                this.downstream.onNext(c);
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.done) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.buffer = null;
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            C c = this.buffer;
            int i = this.index;
            int i2 = i + 1;
            if (i == 0) {
                try {
                    c = (C) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
                    this.buffer = c;
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            if (c != null) {
                c.add(t);
                if (c.size() == this.size) {
                    this.buffer = null;
                    this.downstream.onNext(c);
                }
            }
            if (i2 == this.skip) {
                i2 = 0;
            }
            this.index = i2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                if (get() != 0 || !compareAndSet(0, 1)) {
                    this.upstream.request(io.reactivex.internal.util.BackpressureHelper.multiplyCap(this.skip, j));
                    return;
                }
                this.upstream.request(io.reactivex.internal.util.BackpressureHelper.addCap(io.reactivex.internal.util.BackpressureHelper.multiplyCap(j, this.size), io.reactivex.internal.util.BackpressureHelper.multiplyCap(this.skip - this.size, j - 1)));
            }
        }
    }

    public FlowableBuffer(io.reactivex.Flowable<T> flowable, int i, int i2, java.util.concurrent.Callable<C> callable) {
        super(flowable);
        this.t = i;
        this.u = i2;
        this.v = callable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super C> subscriber) {
        int i = this.t;
        int i2 = this.u;
        if (i == i2) {
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableBuffer.PublisherBufferExactSubscriber(subscriber, i, this.v));
        } else if (i2 > i) {
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableBuffer.PublisherBufferSkipSubscriber(subscriber, this.t, this.u, this.v));
        } else {
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableBuffer.PublisherBufferOverlappingSubscriber(subscriber, this.t, this.u, this.v));
        }
    }
}
