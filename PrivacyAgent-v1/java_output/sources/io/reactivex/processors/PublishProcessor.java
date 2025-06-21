package io.reactivex.processors;

/* loaded from: classes13.dex */
public final class PublishProcessor<T> extends io.reactivex.processors.FlowableProcessor<T> {
    public static final io.reactivex.processors.PublishProcessor.PublishSubscription[] v = new io.reactivex.processors.PublishProcessor.PublishSubscription[0];
    public static final io.reactivex.processors.PublishProcessor.PublishSubscription[] w = new io.reactivex.processors.PublishProcessor.PublishSubscription[0];
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.processors.PublishProcessor.PublishSubscription<T>[]> t = new java.util.concurrent.atomic.AtomicReference<>(w);
    public java.lang.Throwable u;

    public static final class PublishSubscription<T> extends java.util.concurrent.atomic.AtomicLong implements org.reactivestreams.Subscription {
        private static final long serialVersionUID = 3562861878281475070L;
        final org.reactivestreams.Subscriber<? super T> downstream;
        final io.reactivex.processors.PublishProcessor<T> parent;

        public PublishSubscription(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.processors.PublishProcessor<T> publishProcessor) {
            this.downstream = subscriber;
            this.parent = publishProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.f(this);
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        public boolean isFull() {
            return get() == 0;
        }

        public void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onComplete();
            }
        }

        public void onError(java.lang.Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onError(th);
            } else {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
        }

        public void onNext(T t) {
            long j = get();
            if (j == Long.MIN_VALUE) {
                return;
            }
            if (j != 0) {
                this.downstream.onNext(t);
                io.reactivex.internal.util.BackpressureHelper.producedCancel(this, 1L);
            } else {
                cancel();
                this.downstream.onError(new io.reactivex.exceptions.MissingBackpressureException("Could not emit value due to lack of requests"));
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.BackpressureHelper.addCancel(this, j);
            }
        }
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.processors.PublishProcessor<T> create() {
        return new io.reactivex.processors.PublishProcessor<>();
    }

    public boolean e(io.reactivex.processors.PublishProcessor.PublishSubscription<T> publishSubscription) {
        io.reactivex.processors.PublishProcessor.PublishSubscription<T>[] publishSubscriptionArr;
        io.reactivex.processors.PublishProcessor.PublishSubscription[] publishSubscriptionArr2;
        do {
            publishSubscriptionArr = this.t.get();
            if (publishSubscriptionArr == v) {
                return false;
            }
            int length = publishSubscriptionArr.length;
            publishSubscriptionArr2 = new io.reactivex.processors.PublishProcessor.PublishSubscription[length + 1];
            java.lang.System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr2, 0, length);
            publishSubscriptionArr2[length] = publishSubscription;
        } while (!defpackage.xv0.a(this.t, publishSubscriptionArr, publishSubscriptionArr2));
        return true;
    }

    public void f(io.reactivex.processors.PublishProcessor.PublishSubscription<T> publishSubscription) {
        io.reactivex.processors.PublishProcessor.PublishSubscription<T>[] publishSubscriptionArr;
        io.reactivex.processors.PublishProcessor.PublishSubscription[] publishSubscriptionArr2;
        do {
            publishSubscriptionArr = this.t.get();
            if (publishSubscriptionArr == v || publishSubscriptionArr == w) {
                return;
            }
            int length = publishSubscriptionArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (publishSubscriptionArr[i] == publishSubscription) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                publishSubscriptionArr2 = w;
            } else {
                io.reactivex.processors.PublishProcessor.PublishSubscription[] publishSubscriptionArr3 = new io.reactivex.processors.PublishProcessor.PublishSubscription[length - 1];
                java.lang.System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr3, 0, i);
                java.lang.System.arraycopy(publishSubscriptionArr, i + 1, publishSubscriptionArr3, i, (length - i) - 1);
                publishSubscriptionArr2 = publishSubscriptionArr3;
            }
        } while (!defpackage.xv0.a(this.t, publishSubscriptionArr, publishSubscriptionArr2));
    }

    @Override // io.reactivex.processors.FlowableProcessor
    @io.reactivex.annotations.Nullable
    public java.lang.Throwable getThrowable() {
        if (this.t.get() == v) {
            return this.u;
        }
        return null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return this.t.get() == v && this.u == null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.t.get().length != 0;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return this.t.get() == v && this.u != null;
    }

    public boolean offer(T t) {
        if (t == null) {
            onError(new java.lang.NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return true;
        }
        io.reactivex.processors.PublishProcessor.PublishSubscription<T>[] publishSubscriptionArr = this.t.get();
        for (io.reactivex.processors.PublishProcessor.PublishSubscription<T> publishSubscription : publishSubscriptionArr) {
            if (publishSubscription.isFull()) {
                return false;
            }
        }
        for (io.reactivex.processors.PublishProcessor.PublishSubscription<T> publishSubscription2 : publishSubscriptionArr) {
            publishSubscription2.onNext(t);
        }
        return true;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        io.reactivex.processors.PublishProcessor.PublishSubscription<T>[] publishSubscriptionArr = this.t.get();
        io.reactivex.processors.PublishProcessor.PublishSubscription<T>[] publishSubscriptionArr2 = v;
        if (publishSubscriptionArr == publishSubscriptionArr2) {
            return;
        }
        for (io.reactivex.processors.PublishProcessor.PublishSubscription<T> publishSubscription : this.t.getAndSet(publishSubscriptionArr2)) {
            publishSubscription.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(java.lang.Throwable th) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        io.reactivex.processors.PublishProcessor.PublishSubscription<T>[] publishSubscriptionArr = this.t.get();
        io.reactivex.processors.PublishProcessor.PublishSubscription<T>[] publishSubscriptionArr2 = v;
        if (publishSubscriptionArr == publishSubscriptionArr2) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            return;
        }
        this.u = th;
        for (io.reactivex.processors.PublishProcessor.PublishSubscription<T> publishSubscription : this.t.getAndSet(publishSubscriptionArr2)) {
            publishSubscription.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (io.reactivex.processors.PublishProcessor.PublishSubscription<T> publishSubscription : this.t.get()) {
            publishSubscription.onNext(t);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(org.reactivestreams.Subscription subscription) {
        if (this.t.get() == v) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.processors.PublishProcessor.PublishSubscription<T> publishSubscription = new io.reactivex.processors.PublishProcessor.PublishSubscription<>(subscriber, this);
        subscriber.onSubscribe(publishSubscription);
        if (e(publishSubscription)) {
            if (publishSubscription.isCancelled()) {
                f(publishSubscription);
            }
        } else {
            java.lang.Throwable th = this.u;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onComplete();
            }
        }
    }
}
