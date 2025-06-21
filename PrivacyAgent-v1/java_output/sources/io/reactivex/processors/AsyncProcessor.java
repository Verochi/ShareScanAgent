package io.reactivex.processors;

/* loaded from: classes13.dex */
public final class AsyncProcessor<T> extends io.reactivex.processors.FlowableProcessor<T> {
    public static final io.reactivex.processors.AsyncProcessor.AsyncSubscription[] w = new io.reactivex.processors.AsyncProcessor.AsyncSubscription[0];
    public static final io.reactivex.processors.AsyncProcessor.AsyncSubscription[] x = new io.reactivex.processors.AsyncProcessor.AsyncSubscription[0];
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.processors.AsyncProcessor.AsyncSubscription<T>[]> t = new java.util.concurrent.atomic.AtomicReference<>(w);
    public java.lang.Throwable u;
    public T v;

    public static final class AsyncSubscription<T> extends io.reactivex.internal.subscriptions.DeferredScalarSubscription<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final io.reactivex.processors.AsyncProcessor<T> parent;

        public AsyncSubscription(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.processors.AsyncProcessor<T> asyncProcessor) {
            super(subscriber);
            this.parent = asyncProcessor;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            if (super.tryCancel()) {
                this.parent.f(this);
            }
        }

        public void onComplete() {
            if (isCancelled()) {
                return;
            }
            this.downstream.onComplete();
        }

        public void onError(java.lang.Throwable th) {
            if (isCancelled()) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.downstream.onError(th);
            }
        }
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.processors.AsyncProcessor<T> create() {
        return new io.reactivex.processors.AsyncProcessor<>();
    }

    public boolean e(io.reactivex.processors.AsyncProcessor.AsyncSubscription<T> asyncSubscription) {
        io.reactivex.processors.AsyncProcessor.AsyncSubscription<T>[] asyncSubscriptionArr;
        io.reactivex.processors.AsyncProcessor.AsyncSubscription[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = this.t.get();
            if (asyncSubscriptionArr == x) {
                return false;
            }
            int length = asyncSubscriptionArr.length;
            asyncSubscriptionArr2 = new io.reactivex.processors.AsyncProcessor.AsyncSubscription[length + 1];
            java.lang.System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr2, 0, length);
            asyncSubscriptionArr2[length] = asyncSubscription;
        } while (!defpackage.xv0.a(this.t, asyncSubscriptionArr, asyncSubscriptionArr2));
        return true;
    }

    public void f(io.reactivex.processors.AsyncProcessor.AsyncSubscription<T> asyncSubscription) {
        io.reactivex.processors.AsyncProcessor.AsyncSubscription<T>[] asyncSubscriptionArr;
        io.reactivex.processors.AsyncProcessor.AsyncSubscription[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = this.t.get();
            int length = asyncSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (asyncSubscriptionArr[i] == asyncSubscription) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                asyncSubscriptionArr2 = w;
            } else {
                io.reactivex.processors.AsyncProcessor.AsyncSubscription[] asyncSubscriptionArr3 = new io.reactivex.processors.AsyncProcessor.AsyncSubscription[length - 1];
                java.lang.System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr3, 0, i);
                java.lang.System.arraycopy(asyncSubscriptionArr, i + 1, asyncSubscriptionArr3, i, (length - i) - 1);
                asyncSubscriptionArr2 = asyncSubscriptionArr3;
            }
        } while (!defpackage.xv0.a(this.t, asyncSubscriptionArr, asyncSubscriptionArr2));
    }

    @Override // io.reactivex.processors.FlowableProcessor
    @io.reactivex.annotations.Nullable
    public java.lang.Throwable getThrowable() {
        if (this.t.get() == x) {
            return this.u;
        }
        return null;
    }

    @io.reactivex.annotations.Nullable
    public T getValue() {
        if (this.t.get() == x) {
            return this.v;
        }
        return null;
    }

    @java.lang.Deprecated
    public java.lang.Object[] getValues() {
        T value = getValue();
        return value != null ? new java.lang.Object[]{value} : new java.lang.Object[0];
    }

    @java.lang.Deprecated
    public T[] getValues(T[] tArr) {
        T value = getValue();
        if (value == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = (T[]) java.util.Arrays.copyOf(tArr, 1);
        }
        tArr[0] = value;
        if (tArr.length != 1) {
            tArr[1] = null;
        }
        return tArr;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return this.t.get() == x && this.u == null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.t.get().length != 0;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return this.t.get() == x && this.u != null;
    }

    public boolean hasValue() {
        return this.t.get() == x && this.v != null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        io.reactivex.processors.AsyncProcessor.AsyncSubscription<T>[] asyncSubscriptionArr = this.t.get();
        io.reactivex.processors.AsyncProcessor.AsyncSubscription<T>[] asyncSubscriptionArr2 = x;
        if (asyncSubscriptionArr == asyncSubscriptionArr2) {
            return;
        }
        T t = this.v;
        io.reactivex.processors.AsyncProcessor.AsyncSubscription<T>[] andSet = this.t.getAndSet(asyncSubscriptionArr2);
        int i = 0;
        if (t == null) {
            int length = andSet.length;
            while (i < length) {
                andSet[i].onComplete();
                i++;
            }
            return;
        }
        int length2 = andSet.length;
        while (i < length2) {
            andSet[i].complete(t);
            i++;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(java.lang.Throwable th) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        io.reactivex.processors.AsyncProcessor.AsyncSubscription<T>[] asyncSubscriptionArr = this.t.get();
        io.reactivex.processors.AsyncProcessor.AsyncSubscription<T>[] asyncSubscriptionArr2 = x;
        if (asyncSubscriptionArr == asyncSubscriptionArr2) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            return;
        }
        this.v = null;
        this.u = th;
        for (io.reactivex.processors.AsyncProcessor.AsyncSubscription<T> asyncSubscription : this.t.getAndSet(asyncSubscriptionArr2)) {
            asyncSubscription.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.t.get() == x) {
            return;
        }
        this.v = t;
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(org.reactivestreams.Subscription subscription) {
        if (this.t.get() == x) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.processors.AsyncProcessor.AsyncSubscription<T> asyncSubscription = new io.reactivex.processors.AsyncProcessor.AsyncSubscription<>(subscriber, this);
        subscriber.onSubscribe(asyncSubscription);
        if (e(asyncSubscription)) {
            if (asyncSubscription.isCancelled()) {
                f(asyncSubscription);
                return;
            }
            return;
        }
        java.lang.Throwable th = this.u;
        if (th != null) {
            subscriber.onError(th);
            return;
        }
        T t = this.v;
        if (t != null) {
            asyncSubscription.complete(t);
        } else {
            asyncSubscription.onComplete();
        }
    }
}
