package io.reactivex.internal.operators.parallel;

/* loaded from: classes13.dex */
public final class ParallelReduceFull<T> extends io.reactivex.Flowable<T> {
    public final io.reactivex.parallel.ParallelFlowable<? extends T> t;
    public final io.reactivex.functions.BiFunction<T, T, T> u;

    public static final class ParallelReduceFullInnerSubscriber<T> extends java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> implements io.reactivex.FlowableSubscriber<T> {
        private static final long serialVersionUID = -7954444275102466525L;
        boolean done;
        final io.reactivex.internal.operators.parallel.ParallelReduceFull.ParallelReduceFullMainSubscriber<T> parent;
        final io.reactivex.functions.BiFunction<T, T, T> reducer;
        T value;

        public ParallelReduceFullInnerSubscriber(io.reactivex.internal.operators.parallel.ParallelReduceFull.ParallelReduceFullMainSubscriber<T> parallelReduceFullMainSubscriber, io.reactivex.functions.BiFunction<T, T, T> biFunction) {
            this.parent = parallelReduceFullMainSubscriber;
            this.reducer = biFunction;
        }

        public void cancel() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.innerComplete(this.value);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.done) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.parent.innerError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            T t2 = this.value;
            if (t2 == null) {
                this.value = t;
                return;
            }
            try {
                this.value = (T) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.reducer.apply(t2, t), "The reducer returned a null value");
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                get().cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public static final class ParallelReduceFullMainSubscriber<T> extends io.reactivex.internal.subscriptions.DeferredScalarSubscription<T> {
        private static final long serialVersionUID = -5370107872170712765L;
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.parallel.ParallelReduceFull.SlotPair<T>> current;
        final java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> error;
        final io.reactivex.functions.BiFunction<T, T, T> reducer;
        final java.util.concurrent.atomic.AtomicInteger remaining;
        final io.reactivex.internal.operators.parallel.ParallelReduceFull.ParallelReduceFullInnerSubscriber<T>[] subscribers;

        public ParallelReduceFullMainSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, int i, io.reactivex.functions.BiFunction<T, T, T> biFunction) {
            super(subscriber);
            this.current = new java.util.concurrent.atomic.AtomicReference<>();
            this.remaining = new java.util.concurrent.atomic.AtomicInteger();
            this.error = new java.util.concurrent.atomic.AtomicReference<>();
            io.reactivex.internal.operators.parallel.ParallelReduceFull.ParallelReduceFullInnerSubscriber<T>[] parallelReduceFullInnerSubscriberArr = new io.reactivex.internal.operators.parallel.ParallelReduceFull.ParallelReduceFullInnerSubscriber[i];
            for (int i2 = 0; i2 < i; i2++) {
                parallelReduceFullInnerSubscriberArr[i2] = new io.reactivex.internal.operators.parallel.ParallelReduceFull.ParallelReduceFullInnerSubscriber<>(this, biFunction);
            }
            this.subscribers = parallelReduceFullInnerSubscriberArr;
            this.reducer = biFunction;
            this.remaining.lazySet(i);
        }

        public io.reactivex.internal.operators.parallel.ParallelReduceFull.SlotPair<T> addValue(T t) {
            io.reactivex.internal.operators.parallel.ParallelReduceFull.SlotPair<T> slotPair;
            int tryAcquireSlot;
            while (true) {
                slotPair = this.current.get();
                if (slotPair == null) {
                    slotPair = new io.reactivex.internal.operators.parallel.ParallelReduceFull.SlotPair<>();
                    if (!defpackage.xv0.a(this.current, null, slotPair)) {
                        continue;
                    }
                }
                tryAcquireSlot = slotPair.tryAcquireSlot();
                if (tryAcquireSlot >= 0) {
                    break;
                }
                defpackage.xv0.a(this.current, slotPair, null);
            }
            if (tryAcquireSlot == 0) {
                slotPair.first = t;
            } else {
                slotPair.second = t;
            }
            if (!slotPair.releaseSlot()) {
                return null;
            }
            defpackage.xv0.a(this.current, slotPair, null);
            return slotPair;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            for (io.reactivex.internal.operators.parallel.ParallelReduceFull.ParallelReduceFullInnerSubscriber<T> parallelReduceFullInnerSubscriber : this.subscribers) {
                parallelReduceFullInnerSubscriber.cancel();
            }
        }

        public void innerComplete(T t) {
            if (t != null) {
                while (true) {
                    io.reactivex.internal.operators.parallel.ParallelReduceFull.SlotPair<T> addValue = addValue(t);
                    if (addValue == null) {
                        break;
                    }
                    try {
                        t = (T) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.reducer.apply(addValue.first, addValue.second), "The reducer returned a null value");
                    } catch (java.lang.Throwable th) {
                        io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                        innerError(th);
                        return;
                    }
                }
            }
            if (this.remaining.decrementAndGet() == 0) {
                io.reactivex.internal.operators.parallel.ParallelReduceFull.SlotPair<T> slotPair = this.current.get();
                this.current.lazySet(null);
                if (slotPair != null) {
                    complete(slotPair.first);
                } else {
                    this.downstream.onComplete();
                }
            }
        }

        public void innerError(java.lang.Throwable th) {
            if (defpackage.xv0.a(this.error, null, th)) {
                cancel();
                this.downstream.onError(th);
            } else if (th != this.error.get()) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
        }
    }

    public static final class SlotPair<T> extends java.util.concurrent.atomic.AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;
        T first;
        final java.util.concurrent.atomic.AtomicInteger releaseIndex = new java.util.concurrent.atomic.AtomicInteger();
        T second;

        public boolean releaseSlot() {
            return this.releaseIndex.incrementAndGet() == 2;
        }

        public int tryAcquireSlot() {
            int i;
            do {
                i = get();
                if (i >= 2) {
                    return -1;
                }
            } while (!compareAndSet(i, i + 1));
            return i;
        }
    }

    public ParallelReduceFull(io.reactivex.parallel.ParallelFlowable<? extends T> parallelFlowable, io.reactivex.functions.BiFunction<T, T, T> biFunction) {
        this.t = parallelFlowable;
        this.u = biFunction;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.internal.operators.parallel.ParallelReduceFull.ParallelReduceFullMainSubscriber parallelReduceFullMainSubscriber = new io.reactivex.internal.operators.parallel.ParallelReduceFull.ParallelReduceFullMainSubscriber(subscriber, this.t.parallelism(), this.u);
        subscriber.onSubscribe(parallelReduceFullMainSubscriber);
        this.t.subscribe(parallelReduceFullMainSubscriber.subscribers);
    }
}
