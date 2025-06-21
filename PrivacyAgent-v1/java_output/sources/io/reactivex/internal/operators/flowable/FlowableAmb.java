package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableAmb<T> extends io.reactivex.Flowable<T> {
    public final org.reactivestreams.Publisher<? extends T>[] t;
    public final java.lang.Iterable<? extends org.reactivestreams.Publisher<? extends T>> u;

    public static final class AmbCoordinator<T> implements org.reactivestreams.Subscription {
        public final org.reactivestreams.Subscriber<? super T> n;
        public final io.reactivex.internal.operators.flowable.FlowableAmb.AmbInnerSubscriber<T>[] t;
        public final java.util.concurrent.atomic.AtomicInteger u = new java.util.concurrent.atomic.AtomicInteger();

        public AmbCoordinator(org.reactivestreams.Subscriber<? super T> subscriber, int i) {
            this.n = subscriber;
            this.t = new io.reactivex.internal.operators.flowable.FlowableAmb.AmbInnerSubscriber[i];
        }

        public void a(org.reactivestreams.Publisher<? extends T>[] publisherArr) {
            io.reactivex.internal.operators.flowable.FlowableAmb.AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.t;
            int length = ambInnerSubscriberArr.length;
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                ambInnerSubscriberArr[i] = new io.reactivex.internal.operators.flowable.FlowableAmb.AmbInnerSubscriber<>(this, i2, this.n);
                i = i2;
            }
            this.u.lazySet(0);
            this.n.onSubscribe(this);
            for (int i3 = 0; i3 < length && this.u.get() == 0; i3++) {
                publisherArr[i3].subscribe(ambInnerSubscriberArr[i3]);
            }
        }

        public boolean b(int i) {
            int i2 = 0;
            if (this.u.get() != 0 || !this.u.compareAndSet(0, i)) {
                return false;
            }
            io.reactivex.internal.operators.flowable.FlowableAmb.AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.t;
            int length = ambInnerSubscriberArr.length;
            while (i2 < length) {
                int i3 = i2 + 1;
                if (i3 != i) {
                    ambInnerSubscriberArr[i2].cancel();
                }
                i2 = i3;
            }
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.u.get() != -1) {
                this.u.lazySet(-1);
                for (io.reactivex.internal.operators.flowable.FlowableAmb.AmbInnerSubscriber<T> ambInnerSubscriber : this.t) {
                    ambInnerSubscriber.cancel();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                int i = this.u.get();
                if (i > 0) {
                    this.t[i - 1].request(j);
                    return;
                }
                if (i == 0) {
                    for (io.reactivex.internal.operators.flowable.FlowableAmb.AmbInnerSubscriber<T> ambInnerSubscriber : this.t) {
                        ambInnerSubscriber.request(j);
                    }
                }
            }
        }
    }

    public static final class AmbInnerSubscriber<T> extends java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        private static final long serialVersionUID = -1185974347409665484L;
        final org.reactivestreams.Subscriber<? super T> downstream;
        final int index;
        final java.util.concurrent.atomic.AtomicLong missedRequested = new java.util.concurrent.atomic.AtomicLong();
        final io.reactivex.internal.operators.flowable.FlowableAmb.AmbCoordinator<T> parent;
        boolean won;

        public AmbInnerSubscriber(io.reactivex.internal.operators.flowable.FlowableAmb.AmbCoordinator<T> ambCoordinator, int i, org.reactivestreams.Subscriber<? super T> subscriber) {
            this.parent = ambCoordinator;
            this.index = i;
            this.downstream = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.won) {
                this.downstream.onComplete();
            } else if (!this.parent.b(this.index)) {
                get().cancel();
            } else {
                this.won = true;
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.won) {
                this.downstream.onError(th);
            } else if (this.parent.b(this.index)) {
                this.won = true;
                this.downstream.onError(th);
            } else {
                get().cancel();
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.won) {
                this.downstream.onNext(t);
            } else if (!this.parent.b(this.index)) {
                get().cancel();
            } else {
                this.won = true;
                this.downstream.onNext(t);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.deferredSetOnce(this, this.missedRequested, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.deferredRequest(this, this.missedRequested, j);
        }
    }

    public FlowableAmb(org.reactivestreams.Publisher<? extends T>[] publisherArr, java.lang.Iterable<? extends org.reactivestreams.Publisher<? extends T>> iterable) {
        this.t = publisherArr;
        this.u = iterable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        int length;
        org.reactivestreams.Publisher<? extends T>[] publisherArr = this.t;
        if (publisherArr == null) {
            publisherArr = new org.reactivestreams.Publisher[8];
            try {
                length = 0;
                for (org.reactivestreams.Publisher<? extends T> publisher : this.u) {
                    if (publisher == null) {
                        io.reactivex.internal.subscriptions.EmptySubscription.error(new java.lang.NullPointerException("One of the sources is null"), subscriber);
                        return;
                    }
                    if (length == publisherArr.length) {
                        org.reactivestreams.Publisher<? extends T>[] publisherArr2 = new org.reactivestreams.Publisher[(length >> 2) + length];
                        java.lang.System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                        publisherArr = publisherArr2;
                    }
                    int i = length + 1;
                    publisherArr[length] = publisher;
                    length = i;
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.internal.subscriptions.EmptySubscription.error(th, subscriber);
                return;
            }
        } else {
            length = publisherArr.length;
        }
        if (length == 0) {
            io.reactivex.internal.subscriptions.EmptySubscription.complete(subscriber);
        } else if (length == 1) {
            publisherArr[0].subscribe(subscriber);
        } else {
            new io.reactivex.internal.operators.flowable.FlowableAmb.AmbCoordinator(subscriber, length).a(publisherArr);
        }
    }
}
