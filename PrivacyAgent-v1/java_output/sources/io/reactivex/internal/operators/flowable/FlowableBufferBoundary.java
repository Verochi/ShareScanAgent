package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableBufferBoundary<T, U extends java.util.Collection<? super T>, Open, Close> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, U> {
    public final java.util.concurrent.Callable<U> t;
    public final org.reactivestreams.Publisher<? extends Open> u;
    public final io.reactivex.functions.Function<? super Open, ? extends org.reactivestreams.Publisher<? extends Close>> v;

    public static final class BufferBoundarySubscriber<T, C extends java.util.Collection<? super T>, Open, Close> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        private static final long serialVersionUID = -8466418554264089604L;
        final io.reactivex.functions.Function<? super Open, ? extends org.reactivestreams.Publisher<? extends Close>> bufferClose;
        final org.reactivestreams.Publisher<? extends Open> bufferOpen;
        final java.util.concurrent.Callable<C> bufferSupplier;
        volatile boolean cancelled;
        volatile boolean done;
        final org.reactivestreams.Subscriber<? super C> downstream;
        long emitted;
        long index;
        final io.reactivex.internal.queue.SpscLinkedArrayQueue<C> queue = new io.reactivex.internal.queue.SpscLinkedArrayQueue<>(io.reactivex.Flowable.bufferSize());
        final io.reactivex.disposables.CompositeDisposable subscribers = new io.reactivex.disposables.CompositeDisposable();
        final java.util.concurrent.atomic.AtomicLong requested = new java.util.concurrent.atomic.AtomicLong();
        final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> upstream = new java.util.concurrent.atomic.AtomicReference<>();
        java.util.Map<java.lang.Long, C> buffers = new java.util.LinkedHashMap();
        final io.reactivex.internal.util.AtomicThrowable errors = new io.reactivex.internal.util.AtomicThrowable();

        public static final class BufferOpenSubscriber<Open> extends java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> implements io.reactivex.FlowableSubscriber<Open>, io.reactivex.disposables.Disposable {
            private static final long serialVersionUID = -8498650778633225126L;
            final io.reactivex.internal.operators.flowable.FlowableBufferBoundary.BufferBoundarySubscriber<?, ?, Open, ?> parent;

            public BufferOpenSubscriber(io.reactivex.internal.operators.flowable.FlowableBufferBoundary.BufferBoundarySubscriber<?, ?, Open, ?> bufferBoundarySubscriber) {
                this.parent = bufferBoundarySubscriber;
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
                lazySet(io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED);
                this.parent.openComplete(this);
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(java.lang.Throwable th) {
                lazySet(io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED);
                this.parent.boundaryError(this, th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Open open) {
                this.parent.open(open);
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(org.reactivestreams.Subscription subscription) {
                io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }

        public BufferBoundarySubscriber(org.reactivestreams.Subscriber<? super C> subscriber, org.reactivestreams.Publisher<? extends Open> publisher, io.reactivex.functions.Function<? super Open, ? extends org.reactivestreams.Publisher<? extends Close>> function, java.util.concurrent.Callable<C> callable) {
            this.downstream = subscriber;
            this.bufferSupplier = callable;
            this.bufferOpen = publisher;
            this.bufferClose = function;
        }

        public void boundaryError(io.reactivex.disposables.Disposable disposable, java.lang.Throwable th) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
            this.subscribers.delete(disposable);
            onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream)) {
                this.cancelled = true;
                this.subscribers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                if (getAndIncrement() != 0) {
                    this.queue.clear();
                }
            }
        }

        public void close(io.reactivex.internal.operators.flowable.FlowableBufferBoundary.BufferCloseSubscriber<T, C> bufferCloseSubscriber, long j) {
            boolean z;
            this.subscribers.delete(bufferCloseSubscriber);
            if (this.subscribers.size() == 0) {
                io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
                z = true;
            } else {
                z = false;
            }
            synchronized (this) {
                java.util.Map<java.lang.Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                this.queue.offer(map.remove(java.lang.Long.valueOf(j)));
                if (z) {
                    this.done = true;
                }
                drain();
            }
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            long j = this.emitted;
            org.reactivestreams.Subscriber<? super C> subscriber = this.downstream;
            io.reactivex.internal.queue.SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.queue;
            int i = 1;
            do {
                long j2 = this.requested.get();
                while (j != j2) {
                    if (this.cancelled) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && this.errors.get() != null) {
                        spscLinkedArrayQueue.clear();
                        subscriber.onError(this.errors.terminate());
                        return;
                    }
                    C poll = spscLinkedArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        subscriber.onComplete();
                        return;
                    } else {
                        if (z2) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j++;
                    }
                }
                if (j == j2) {
                    if (this.cancelled) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    if (this.done) {
                        if (this.errors.get() != null) {
                            spscLinkedArrayQueue.clear();
                            subscriber.onError(this.errors.terminate());
                            return;
                        } else if (spscLinkedArrayQueue.isEmpty()) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                this.emitted = j;
                i = addAndGet(-i);
            } while (i != 0);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.subscribers.dispose();
            synchronized (this) {
                java.util.Map<java.lang.Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                java.util.Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    this.queue.offer(it.next());
                }
                this.buffers = null;
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (!this.errors.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.subscribers.dispose();
            synchronized (this) {
                this.buffers = null;
            }
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                java.util.Map<java.lang.Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                java.util.Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this.upstream, subscription)) {
                io.reactivex.internal.operators.flowable.FlowableBufferBoundary.BufferBoundarySubscriber.BufferOpenSubscriber bufferOpenSubscriber = new io.reactivex.internal.operators.flowable.FlowableBufferBoundary.BufferBoundarySubscriber.BufferOpenSubscriber(this);
                this.subscribers.add(bufferOpenSubscriber);
                this.bufferOpen.subscribe(bufferOpenSubscriber);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void open(Open open) {
            try {
                java.util.Collection collection = (java.util.Collection) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");
                org.reactivestreams.Publisher publisher = (org.reactivestreams.Publisher) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.bufferClose.apply(open), "The bufferClose returned a null Publisher");
                long j = this.index;
                this.index = 1 + j;
                synchronized (this) {
                    java.util.Map<java.lang.Long, C> map = this.buffers;
                    if (map == null) {
                        return;
                    }
                    map.put(java.lang.Long.valueOf(j), collection);
                    io.reactivex.internal.operators.flowable.FlowableBufferBoundary.BufferCloseSubscriber bufferCloseSubscriber = new io.reactivex.internal.operators.flowable.FlowableBufferBoundary.BufferCloseSubscriber(this, j);
                    this.subscribers.add(bufferCloseSubscriber);
                    publisher.subscribe(bufferCloseSubscriber);
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
                onError(th);
            }
        }

        public void openComplete(io.reactivex.internal.operators.flowable.FlowableBufferBoundary.BufferBoundarySubscriber.BufferOpenSubscriber<Open> bufferOpenSubscriber) {
            this.subscribers.delete(bufferOpenSubscriber);
            if (this.subscribers.size() == 0) {
                io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            io.reactivex.internal.util.BackpressureHelper.add(this.requested, j);
            drain();
        }
    }

    public static final class BufferCloseSubscriber<T, C extends java.util.Collection<? super T>> extends java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> implements io.reactivex.FlowableSubscriber<java.lang.Object>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -8498650778633225126L;
        final long index;
        final io.reactivex.internal.operators.flowable.FlowableBufferBoundary.BufferBoundarySubscriber<T, C, ?, ?> parent;

        public BufferCloseSubscriber(io.reactivex.internal.operators.flowable.FlowableBufferBoundary.BufferBoundarySubscriber<T, C, ?, ?> bufferBoundarySubscriber, long j) {
            this.parent = bufferBoundarySubscriber;
            this.index = j;
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
            org.reactivestreams.Subscription subscription = get();
            io.reactivex.internal.subscriptions.SubscriptionHelper subscriptionHelper = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.parent.close(this, this.index);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            org.reactivestreams.Subscription subscription = get();
            io.reactivex.internal.subscriptions.SubscriptionHelper subscriptionHelper = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            if (subscription == subscriptionHelper) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                lazySet(subscriptionHelper);
                this.parent.boundaryError(this, th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(java.lang.Object obj) {
            org.reactivestreams.Subscription subscription = get();
            io.reactivex.internal.subscriptions.SubscriptionHelper subscriptionHelper = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                subscription.cancel();
                this.parent.close(this, this.index);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public FlowableBufferBoundary(io.reactivex.Flowable<T> flowable, org.reactivestreams.Publisher<? extends Open> publisher, io.reactivex.functions.Function<? super Open, ? extends org.reactivestreams.Publisher<? extends Close>> function, java.util.concurrent.Callable<U> callable) {
        super(flowable);
        this.u = publisher;
        this.v = function;
        this.t = callable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super U> subscriber) {
        io.reactivex.internal.operators.flowable.FlowableBufferBoundary.BufferBoundarySubscriber bufferBoundarySubscriber = new io.reactivex.internal.operators.flowable.FlowableBufferBoundary.BufferBoundarySubscriber(subscriber, this.u, this.v, this.t);
        subscriber.onSubscribe(bufferBoundarySubscriber);
        this.source.subscribe((io.reactivex.FlowableSubscriber) bufferBoundarySubscriber);
    }
}
