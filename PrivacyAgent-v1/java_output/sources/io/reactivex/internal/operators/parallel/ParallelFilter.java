package io.reactivex.internal.operators.parallel;

/* loaded from: classes13.dex */
public final class ParallelFilter<T> extends io.reactivex.parallel.ParallelFlowable<T> {
    public final io.reactivex.parallel.ParallelFlowable<T> a;
    public final io.reactivex.functions.Predicate<? super T> b;

    public static abstract class BaseFilterSubscriber<T> implements io.reactivex.internal.fuseable.ConditionalSubscriber<T>, org.reactivestreams.Subscription {
        public final io.reactivex.functions.Predicate<? super T> n;
        public org.reactivestreams.Subscription t;
        public boolean u;

        public BaseFilterSubscriber(io.reactivex.functions.Predicate<? super T> predicate) {
            this.n = predicate;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.t.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (tryOnNext(t) || this.u) {
                return;
            }
            this.t.request(1L);
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            this.t.request(j);
        }
    }

    public static final class ParallelFilterConditionalSubscriber<T> extends io.reactivex.internal.operators.parallel.ParallelFilter.BaseFilterSubscriber<T> {
        public final io.reactivex.internal.fuseable.ConditionalSubscriber<? super T> v;

        public ParallelFilterConditionalSubscriber(io.reactivex.internal.fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, io.reactivex.functions.Predicate<? super T> predicate) {
            super(predicate);
            this.v = conditionalSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.u) {
                return;
            }
            this.u = true;
            this.v.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.u) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.u = true;
                this.v.onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.t, subscription)) {
                this.t = subscription;
                this.v.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (!this.u) {
                try {
                    if (this.n.test(t)) {
                        return this.v.tryOnNext(t);
                    }
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                }
            }
            return false;
        }
    }

    public static final class ParallelFilterSubscriber<T> extends io.reactivex.internal.operators.parallel.ParallelFilter.BaseFilterSubscriber<T> {
        public final org.reactivestreams.Subscriber<? super T> v;

        public ParallelFilterSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.functions.Predicate<? super T> predicate) {
            super(predicate);
            this.v = subscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.u) {
                return;
            }
            this.u = true;
            this.v.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.u) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.u = true;
                this.v.onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.t, subscription)) {
                this.t = subscription;
                this.v.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (!this.u) {
                try {
                    if (this.n.test(t)) {
                        this.v.onNext(t);
                        return true;
                    }
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                }
            }
            return false;
        }
    }

    public ParallelFilter(io.reactivex.parallel.ParallelFlowable<T> parallelFlowable, io.reactivex.functions.Predicate<? super T> predicate) {
        this.a = parallelFlowable;
        this.b = predicate;
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
                org.reactivestreams.Subscriber<? super T> subscriber = subscriberArr[i];
                if (subscriber instanceof io.reactivex.internal.fuseable.ConditionalSubscriber) {
                    subscriberArr2[i] = new io.reactivex.internal.operators.parallel.ParallelFilter.ParallelFilterConditionalSubscriber((io.reactivex.internal.fuseable.ConditionalSubscriber) subscriber, this.b);
                } else {
                    subscriberArr2[i] = new io.reactivex.internal.operators.parallel.ParallelFilter.ParallelFilterSubscriber(subscriber, this.b);
                }
            }
            this.a.subscribe(subscriberArr2);
        }
    }
}
