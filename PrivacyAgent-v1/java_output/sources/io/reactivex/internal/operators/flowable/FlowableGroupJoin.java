package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<TLeft, R> {
    public final org.reactivestreams.Publisher<? extends TRight> t;
    public final io.reactivex.functions.Function<? super TLeft, ? extends org.reactivestreams.Publisher<TLeftEnd>> u;
    public final io.reactivex.functions.Function<? super TRight, ? extends org.reactivestreams.Publisher<TRightEnd>> v;
    public final io.reactivex.functions.BiFunction<? super TLeft, ? super io.reactivex.Flowable<TRight>, ? extends R> w;

    public static final class GroupJoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends java.util.concurrent.atomic.AtomicInteger implements org.reactivestreams.Subscription, io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport {
        private static final long serialVersionUID = -6071216598687999801L;
        volatile boolean cancelled;
        final org.reactivestreams.Subscriber<? super R> downstream;
        final io.reactivex.functions.Function<? super TLeft, ? extends org.reactivestreams.Publisher<TLeftEnd>> leftEnd;
        int leftIndex;
        final io.reactivex.functions.BiFunction<? super TLeft, ? super io.reactivex.Flowable<TRight>, ? extends R> resultSelector;
        final io.reactivex.functions.Function<? super TRight, ? extends org.reactivestreams.Publisher<TRightEnd>> rightEnd;
        int rightIndex;
        static final java.lang.Integer LEFT_VALUE = 1;
        static final java.lang.Integer RIGHT_VALUE = 2;
        static final java.lang.Integer LEFT_CLOSE = 3;
        static final java.lang.Integer RIGHT_CLOSE = 4;
        final java.util.concurrent.atomic.AtomicLong requested = new java.util.concurrent.atomic.AtomicLong();
        final io.reactivex.disposables.CompositeDisposable disposables = new io.reactivex.disposables.CompositeDisposable();
        final io.reactivex.internal.queue.SpscLinkedArrayQueue<java.lang.Object> queue = new io.reactivex.internal.queue.SpscLinkedArrayQueue<>(io.reactivex.Flowable.bufferSize());
        final java.util.Map<java.lang.Integer, io.reactivex.processors.UnicastProcessor<TRight>> lefts = new java.util.LinkedHashMap();
        final java.util.Map<java.lang.Integer, TRight> rights = new java.util.LinkedHashMap();
        final java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> error = new java.util.concurrent.atomic.AtomicReference<>();
        final java.util.concurrent.atomic.AtomicInteger active = new java.util.concurrent.atomic.AtomicInteger(2);

        public GroupJoinSubscription(org.reactivestreams.Subscriber<? super R> subscriber, io.reactivex.functions.Function<? super TLeft, ? extends org.reactivestreams.Publisher<TLeftEnd>> function, io.reactivex.functions.Function<? super TRight, ? extends org.reactivestreams.Publisher<TRightEnd>> function2, io.reactivex.functions.BiFunction<? super TLeft, ? super io.reactivex.Flowable<TRight>, ? extends R> biFunction) {
            this.downstream = subscriber;
            this.leftEnd = function;
            this.rightEnd = function2;
            this.resultSelector = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public void cancelAll() {
            this.disposables.dispose();
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.internal.queue.SpscLinkedArrayQueue<java.lang.Object> spscLinkedArrayQueue = this.queue;
            org.reactivestreams.Subscriber<? super R> subscriber = this.downstream;
            int i = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    spscLinkedArrayQueue.clear();
                    cancelAll();
                    errorAll(subscriber);
                    return;
                }
                boolean z = this.active.get() == 0;
                java.lang.Integer num = (java.lang.Integer) spscLinkedArrayQueue.poll();
                boolean z2 = num == null;
                if (z && z2) {
                    java.util.Iterator<io.reactivex.processors.UnicastProcessor<TRight>> it = this.lefts.values().iterator();
                    while (it.hasNext()) {
                        it.next().onComplete();
                    }
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    subscriber.onComplete();
                    return;
                }
                if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    java.lang.Object poll = spscLinkedArrayQueue.poll();
                    if (num == LEFT_VALUE) {
                        io.reactivex.processors.UnicastProcessor create = io.reactivex.processors.UnicastProcessor.create();
                        int i2 = this.leftIndex;
                        this.leftIndex = i2 + 1;
                        this.lefts.put(java.lang.Integer.valueOf(i2), create);
                        try {
                            org.reactivestreams.Publisher publisher = (org.reactivestreams.Publisher) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.leftEnd.apply(poll), "The leftEnd returned a null Publisher");
                            io.reactivex.internal.operators.flowable.FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber = new io.reactivex.internal.operators.flowable.FlowableGroupJoin.LeftRightEndSubscriber(this, true, i2);
                            this.disposables.add(leftRightEndSubscriber);
                            publisher.subscribe(leftRightEndSubscriber);
                            if (this.error.get() != null) {
                                spscLinkedArrayQueue.clear();
                                cancelAll();
                                errorAll(subscriber);
                                return;
                            }
                            try {
                                defpackage.a aVar = (java.lang.Object) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.resultSelector.apply(poll, create), "The resultSelector returned a null value");
                                if (this.requested.get() == 0) {
                                    fail(new io.reactivex.exceptions.MissingBackpressureException("Could not emit value due to lack of requests"), subscriber, spscLinkedArrayQueue);
                                    return;
                                }
                                subscriber.onNext(aVar);
                                io.reactivex.internal.util.BackpressureHelper.produced(this.requested, 1L);
                                java.util.Iterator<TRight> it2 = this.rights.values().iterator();
                                while (it2.hasNext()) {
                                    create.onNext(it2.next());
                                }
                            } catch (java.lang.Throwable th) {
                                fail(th, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } catch (java.lang.Throwable th2) {
                            fail(th2, subscriber, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == RIGHT_VALUE) {
                        int i3 = this.rightIndex;
                        this.rightIndex = i3 + 1;
                        this.rights.put(java.lang.Integer.valueOf(i3), poll);
                        try {
                            org.reactivestreams.Publisher publisher2 = (org.reactivestreams.Publisher) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.rightEnd.apply(poll), "The rightEnd returned a null Publisher");
                            io.reactivex.internal.operators.flowable.FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber2 = new io.reactivex.internal.operators.flowable.FlowableGroupJoin.LeftRightEndSubscriber(this, false, i3);
                            this.disposables.add(leftRightEndSubscriber2);
                            publisher2.subscribe(leftRightEndSubscriber2);
                            if (this.error.get() != null) {
                                spscLinkedArrayQueue.clear();
                                cancelAll();
                                errorAll(subscriber);
                                return;
                            } else {
                                java.util.Iterator<io.reactivex.processors.UnicastProcessor<TRight>> it3 = this.lefts.values().iterator();
                                while (it3.hasNext()) {
                                    it3.next().onNext(poll);
                                }
                            }
                        } catch (java.lang.Throwable th3) {
                            fail(th3, subscriber, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        io.reactivex.internal.operators.flowable.FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber3 = (io.reactivex.internal.operators.flowable.FlowableGroupJoin.LeftRightEndSubscriber) poll;
                        io.reactivex.processors.UnicastProcessor<TRight> remove = this.lefts.remove(java.lang.Integer.valueOf(leftRightEndSubscriber3.index));
                        this.disposables.remove(leftRightEndSubscriber3);
                        if (remove != null) {
                            remove.onComplete();
                        }
                    } else if (num == RIGHT_CLOSE) {
                        io.reactivex.internal.operators.flowable.FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber4 = (io.reactivex.internal.operators.flowable.FlowableGroupJoin.LeftRightEndSubscriber) poll;
                        this.rights.remove(java.lang.Integer.valueOf(leftRightEndSubscriber4.index));
                        this.disposables.remove(leftRightEndSubscriber4);
                    }
                }
            }
            spscLinkedArrayQueue.clear();
        }

        public void errorAll(org.reactivestreams.Subscriber<?> subscriber) {
            java.lang.Throwable terminate = io.reactivex.internal.util.ExceptionHelper.terminate(this.error);
            java.util.Iterator<io.reactivex.processors.UnicastProcessor<TRight>> it = this.lefts.values().iterator();
            while (it.hasNext()) {
                it.next().onError(terminate);
            }
            this.lefts.clear();
            this.rights.clear();
            subscriber.onError(terminate);
        }

        public void fail(java.lang.Throwable th, org.reactivestreams.Subscriber<?> subscriber, io.reactivex.internal.fuseable.SimpleQueue<?> simpleQueue) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.util.ExceptionHelper.addThrowable(this.error, th);
            simpleQueue.clear();
            cancelAll();
            errorAll(subscriber);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerClose(boolean z, io.reactivex.internal.operators.flowable.FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_CLOSE : RIGHT_CLOSE, leftRightEndSubscriber);
            }
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerCloseError(java.lang.Throwable th) {
            if (io.reactivex.internal.util.ExceptionHelper.addThrowable(this.error, th)) {
                drain();
            } else {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerComplete(io.reactivex.internal.operators.flowable.FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber) {
            this.disposables.delete(leftRightSubscriber);
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerError(java.lang.Throwable th) {
            if (!io.reactivex.internal.util.ExceptionHelper.addThrowable(this.error, th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.active.decrementAndGet();
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerValue(boolean z, java.lang.Object obj) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_VALUE : RIGHT_VALUE, obj);
            }
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.BackpressureHelper.add(this.requested, j);
            }
        }
    }

    public interface JoinSupport {
        void innerClose(boolean z, io.reactivex.internal.operators.flowable.FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber);

        void innerCloseError(java.lang.Throwable th);

        void innerComplete(io.reactivex.internal.operators.flowable.FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber);

        void innerError(java.lang.Throwable th);

        void innerValue(boolean z, java.lang.Object obj);
    }

    public static final class LeftRightEndSubscriber extends java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> implements io.reactivex.FlowableSubscriber<java.lang.Object>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 1883890389173668373L;
        final int index;
        final boolean isLeft;
        final io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport parent;

        public LeftRightEndSubscriber(io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport joinSupport, boolean z, int i) {
            this.parent = joinSupport;
            this.isLeft = z;
            this.index = i;
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
            this.parent.innerClose(this.isLeft, this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.parent.innerCloseError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(java.lang.Object obj) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this)) {
                this.parent.innerClose(this.isLeft, this);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public static final class LeftRightSubscriber extends java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> implements io.reactivex.FlowableSubscriber<java.lang.Object>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 1883890389173668373L;
        final boolean isLeft;
        final io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport parent;

        public LeftRightSubscriber(io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport joinSupport, boolean z) {
            this.parent = joinSupport;
            this.isLeft = z;
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
            this.parent.innerComplete(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.parent.innerError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(java.lang.Object obj) {
            this.parent.innerValue(this.isLeft, obj);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public FlowableGroupJoin(io.reactivex.Flowable<TLeft> flowable, org.reactivestreams.Publisher<? extends TRight> publisher, io.reactivex.functions.Function<? super TLeft, ? extends org.reactivestreams.Publisher<TLeftEnd>> function, io.reactivex.functions.Function<? super TRight, ? extends org.reactivestreams.Publisher<TRightEnd>> function2, io.reactivex.functions.BiFunction<? super TLeft, ? super io.reactivex.Flowable<TRight>, ? extends R> biFunction) {
        super(flowable);
        this.t = publisher;
        this.u = function;
        this.v = function2;
        this.w = biFunction;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super R> subscriber) {
        io.reactivex.internal.operators.flowable.FlowableGroupJoin.GroupJoinSubscription groupJoinSubscription = new io.reactivex.internal.operators.flowable.FlowableGroupJoin.GroupJoinSubscription(subscriber, this.u, this.v, this.w);
        subscriber.onSubscribe(groupJoinSubscription);
        io.reactivex.internal.operators.flowable.FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber = new io.reactivex.internal.operators.flowable.FlowableGroupJoin.LeftRightSubscriber(groupJoinSubscription, true);
        groupJoinSubscription.disposables.add(leftRightSubscriber);
        io.reactivex.internal.operators.flowable.FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber2 = new io.reactivex.internal.operators.flowable.FlowableGroupJoin.LeftRightSubscriber(groupJoinSubscription, false);
        groupJoinSubscription.disposables.add(leftRightSubscriber2);
        this.source.subscribe((io.reactivex.FlowableSubscriber) leftRightSubscriber);
        this.t.subscribe(leftRightSubscriber2);
    }
}
