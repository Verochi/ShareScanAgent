package io.reactivex.internal.operators.parallel;

/* loaded from: classes13.dex */
public final class ParallelPeek<T> extends io.reactivex.parallel.ParallelFlowable<T> {
    public final io.reactivex.parallel.ParallelFlowable<T> a;
    public final io.reactivex.functions.Consumer<? super T> b;
    public final io.reactivex.functions.Consumer<? super T> c;
    public final io.reactivex.functions.Consumer<? super java.lang.Throwable> d;
    public final io.reactivex.functions.Action e;
    public final io.reactivex.functions.Action f;
    public final io.reactivex.functions.Consumer<? super org.reactivestreams.Subscription> g;
    public final io.reactivex.functions.LongConsumer h;
    public final io.reactivex.functions.Action i;

    public static final class ParallelPeekSubscriber<T> implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        public final org.reactivestreams.Subscriber<? super T> n;
        public final io.reactivex.internal.operators.parallel.ParallelPeek<T> t;
        public org.reactivestreams.Subscription u;
        public boolean v;

        public ParallelPeekSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.internal.operators.parallel.ParallelPeek<T> parallelPeek) {
            this.n = subscriber;
            this.t = parallelPeek;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            try {
                this.t.i.run();
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
            this.u.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.v) {
                return;
            }
            this.v = true;
            try {
                this.t.e.run();
                this.n.onComplete();
                try {
                    this.t.f.run();
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    io.reactivex.plugins.RxJavaPlugins.onError(th);
                }
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                this.n.onError(th2);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.v) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.v = true;
            try {
                this.t.d.accept(th);
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                th = new io.reactivex.exceptions.CompositeException(th, th2);
            }
            this.n.onError(th);
            try {
                this.t.f.run();
            } catch (java.lang.Throwable th3) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th3);
                io.reactivex.plugins.RxJavaPlugins.onError(th3);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.v) {
                return;
            }
            try {
                this.t.b.accept(t);
                this.n.onNext(t);
                try {
                    this.t.c.accept(t);
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    onError(th);
                }
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                onError(th2);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.u, subscription)) {
                this.u = subscription;
                try {
                    this.t.g.accept(subscription);
                    this.n.onSubscribe(this);
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    subscription.cancel();
                    this.n.onSubscribe(io.reactivex.internal.subscriptions.EmptySubscription.INSTANCE);
                    onError(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            try {
                this.t.h.accept(j);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
            this.u.request(j);
        }
    }

    public ParallelPeek(io.reactivex.parallel.ParallelFlowable<T> parallelFlowable, io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super T> consumer2, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer3, io.reactivex.functions.Action action, io.reactivex.functions.Action action2, io.reactivex.functions.Consumer<? super org.reactivestreams.Subscription> consumer4, io.reactivex.functions.LongConsumer longConsumer, io.reactivex.functions.Action action3) {
        this.a = parallelFlowable;
        this.b = (io.reactivex.functions.Consumer) io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onNext is null");
        this.c = (io.reactivex.functions.Consumer) io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer2, "onAfterNext is null");
        this.d = (io.reactivex.functions.Consumer) io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer3, "onError is null");
        this.e = (io.reactivex.functions.Action) io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onComplete is null");
        this.f = (io.reactivex.functions.Action) io.reactivex.internal.functions.ObjectHelper.requireNonNull(action2, "onAfterTerminated is null");
        this.g = (io.reactivex.functions.Consumer) io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer4, "onSubscribe is null");
        this.h = (io.reactivex.functions.LongConsumer) io.reactivex.internal.functions.ObjectHelper.requireNonNull(longConsumer, "onRequest is null");
        this.i = (io.reactivex.functions.Action) io.reactivex.internal.functions.ObjectHelper.requireNonNull(action3, "onCancel is null");
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(org.reactivestreams.Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            org.reactivestreams.Subscriber<? super T>[] subscriberArr2 = new org.reactivestreams.Subscriber[length];
            for (int i = 0; i < length; i++) {
                subscriberArr2[i] = new io.reactivex.internal.operators.parallel.ParallelPeek.ParallelPeekSubscriber(subscriberArr[i], this);
            }
            this.a.subscribe(subscriberArr2);
        }
    }
}
