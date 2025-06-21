package io.reactivex.internal.operators.parallel;

/* loaded from: classes13.dex */
public final class ParallelSortedJoin<T> extends io.reactivex.Flowable<T> {
    public final io.reactivex.parallel.ParallelFlowable<java.util.List<T>> t;
    public final java.util.Comparator<? super T> u;

    public static final class SortedJoinInnerSubscriber<T> extends java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> implements io.reactivex.FlowableSubscriber<java.util.List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;
        final int index;
        final io.reactivex.internal.operators.parallel.ParallelSortedJoin.SortedJoinSubscription<T> parent;

        public SortedJoinInnerSubscriber(io.reactivex.internal.operators.parallel.ParallelSortedJoin.SortedJoinSubscription<T> sortedJoinSubscription, int i) {
            this.parent = sortedJoinSubscription;
            this.index = i;
        }

        public void cancel() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.parent.innerError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(java.util.List<T> list) {
            this.parent.innerNext(list, this.index);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public static final class SortedJoinSubscription<T> extends java.util.concurrent.atomic.AtomicInteger implements org.reactivestreams.Subscription {
        private static final long serialVersionUID = 3481980673745556697L;
        volatile boolean cancelled;
        final java.util.Comparator<? super T> comparator;
        final org.reactivestreams.Subscriber<? super T> downstream;
        final int[] indexes;
        final java.util.List<T>[] lists;
        final io.reactivex.internal.operators.parallel.ParallelSortedJoin.SortedJoinInnerSubscriber<T>[] subscribers;
        final java.util.concurrent.atomic.AtomicLong requested = new java.util.concurrent.atomic.AtomicLong();
        final java.util.concurrent.atomic.AtomicInteger remaining = new java.util.concurrent.atomic.AtomicInteger();
        final java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> error = new java.util.concurrent.atomic.AtomicReference<>();

        public SortedJoinSubscription(org.reactivestreams.Subscriber<? super T> subscriber, int i, java.util.Comparator<? super T> comparator) {
            this.downstream = subscriber;
            this.comparator = comparator;
            io.reactivex.internal.operators.parallel.ParallelSortedJoin.SortedJoinInnerSubscriber<T>[] sortedJoinInnerSubscriberArr = new io.reactivex.internal.operators.parallel.ParallelSortedJoin.SortedJoinInnerSubscriber[i];
            for (int i2 = 0; i2 < i; i2++) {
                sortedJoinInnerSubscriberArr[i2] = new io.reactivex.internal.operators.parallel.ParallelSortedJoin.SortedJoinInnerSubscriber<>(this, i2);
            }
            this.subscribers = sortedJoinInnerSubscriberArr;
            this.lists = new java.util.List[i];
            this.indexes = new int[i];
            this.remaining.lazySet(i);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                java.util.Arrays.fill(this.lists, (java.lang.Object) null);
            }
        }

        public void cancelAll() {
            for (io.reactivex.internal.operators.parallel.ParallelSortedJoin.SortedJoinInnerSubscriber<T> sortedJoinInnerSubscriber : this.subscribers) {
                sortedJoinInnerSubscriber.cancel();
            }
        }

        public void drain() {
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            org.reactivestreams.Subscriber<? super T> subscriber = this.downstream;
            java.util.List<T>[] listArr = this.lists;
            int[] iArr = this.indexes;
            int length = iArr.length;
            int i = 1;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        java.util.Arrays.fill(listArr, (java.lang.Object) null);
                        return;
                    }
                    java.lang.Throwable th = this.error.get();
                    if (th != null) {
                        cancelAll();
                        java.util.Arrays.fill(listArr, (java.lang.Object) null);
                        subscriber.onError(th);
                        return;
                    }
                    int i2 = -1;
                    T t = null;
                    for (int i3 = 0; i3 < length; i3++) {
                        java.util.List<T> list = listArr[i3];
                        int i4 = iArr[i3];
                        if (list.size() != i4) {
                            if (t == null) {
                                t = list.get(i4);
                            } else {
                                T t2 = list.get(i4);
                                try {
                                    if (this.comparator.compare(t, t2) > 0) {
                                        t = t2;
                                    }
                                } catch (java.lang.Throwable th2) {
                                    io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                                    cancelAll();
                                    java.util.Arrays.fill(listArr, (java.lang.Object) null);
                                    if (!defpackage.xv0.a(this.error, null, th2)) {
                                        io.reactivex.plugins.RxJavaPlugins.onError(th2);
                                    }
                                    subscriber.onError(this.error.get());
                                    return;
                                }
                            }
                            i2 = i3;
                        }
                    }
                    if (t == null) {
                        java.util.Arrays.fill(listArr, (java.lang.Object) null);
                        subscriber.onComplete();
                        return;
                    } else {
                        subscriber.onNext(t);
                        iArr[i2] = iArr[i2] + 1;
                        j2++;
                    }
                }
                if (j2 == j) {
                    if (this.cancelled) {
                        java.util.Arrays.fill(listArr, (java.lang.Object) null);
                        return;
                    }
                    java.lang.Throwable th3 = this.error.get();
                    if (th3 != null) {
                        cancelAll();
                        java.util.Arrays.fill(listArr, (java.lang.Object) null);
                        subscriber.onError(th3);
                        return;
                    }
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            z = true;
                            break;
                        } else {
                            if (iArr[i5] != listArr[i5].size()) {
                                z = false;
                                break;
                            }
                            i5++;
                        }
                    }
                    if (z) {
                        java.util.Arrays.fill(listArr, (java.lang.Object) null);
                        subscriber.onComplete();
                        return;
                    }
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                int i6 = get();
                if (i6 == i && (i6 = addAndGet(-i)) == 0) {
                    return;
                } else {
                    i = i6;
                }
            }
        }

        public void innerError(java.lang.Throwable th) {
            if (defpackage.xv0.a(this.error, null, th)) {
                drain();
            } else if (th != this.error.get()) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
        }

        public void innerNext(java.util.List<T> list, int i) {
            this.lists[i] = list;
            if (this.remaining.decrementAndGet() == 0) {
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.BackpressureHelper.add(this.requested, j);
                if (this.remaining.get() == 0) {
                    drain();
                }
            }
        }
    }

    public ParallelSortedJoin(io.reactivex.parallel.ParallelFlowable<java.util.List<T>> parallelFlowable, java.util.Comparator<? super T> comparator) {
        this.t = parallelFlowable;
        this.u = comparator;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.internal.operators.parallel.ParallelSortedJoin.SortedJoinSubscription sortedJoinSubscription = new io.reactivex.internal.operators.parallel.ParallelSortedJoin.SortedJoinSubscription(subscriber, this.t.parallelism(), this.u);
        subscriber.onSubscribe(sortedJoinSubscription);
        this.t.subscribe(sortedJoinSubscription.subscribers);
    }
}
