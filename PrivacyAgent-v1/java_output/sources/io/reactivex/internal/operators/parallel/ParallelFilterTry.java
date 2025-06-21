package io.reactivex.internal.operators.parallel;

/* loaded from: classes13.dex */
public final class ParallelFilterTry<T> extends io.reactivex.parallel.ParallelFlowable<T> {
    public final io.reactivex.parallel.ParallelFlowable<T> a;
    public final io.reactivex.functions.Predicate<? super T> b;
    public final io.reactivex.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.parallel.ParallelFailureHandling> c;

    /* renamed from: io.reactivex.internal.operators.parallel.ParallelFilterTry$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[io.reactivex.parallel.ParallelFailureHandling.values().length];
            a = iArr;
            try {
                iArr[io.reactivex.parallel.ParallelFailureHandling.RETRY.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[io.reactivex.parallel.ParallelFailureHandling.SKIP.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[io.reactivex.parallel.ParallelFailureHandling.STOP.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public static abstract class BaseFilterSubscriber<T> implements io.reactivex.internal.fuseable.ConditionalSubscriber<T>, org.reactivestreams.Subscription {
        public final io.reactivex.functions.Predicate<? super T> n;
        public final io.reactivex.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.parallel.ParallelFailureHandling> t;
        public org.reactivestreams.Subscription u;
        public boolean v;

        public BaseFilterSubscriber(io.reactivex.functions.Predicate<? super T> predicate, io.reactivex.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.parallel.ParallelFailureHandling> biFunction) {
            this.n = predicate;
            this.t = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.u.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (tryOnNext(t) || this.v) {
                return;
            }
            this.u.request(1L);
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            this.u.request(j);
        }
    }

    public static final class ParallelFilterConditionalSubscriber<T> extends io.reactivex.internal.operators.parallel.ParallelFilterTry.BaseFilterSubscriber<T> {
        public final io.reactivex.internal.fuseable.ConditionalSubscriber<? super T> w;

        public ParallelFilterConditionalSubscriber(io.reactivex.internal.fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, io.reactivex.functions.Predicate<? super T> predicate, io.reactivex.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.parallel.ParallelFailureHandling> biFunction) {
            super(predicate, biFunction);
            this.w = conditionalSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.v) {
                return;
            }
            this.v = true;
            this.w.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.v) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.v = true;
                this.w.onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.u, subscription)) {
                this.u = subscription;
                this.w.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            int i;
            if (!this.v) {
                long j = 0;
                do {
                    try {
                        return this.n.test(t) && this.w.tryOnNext(t);
                    } catch (java.lang.Throwable th) {
                        io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                        try {
                            j++;
                            i = io.reactivex.internal.operators.parallel.ParallelFilterTry.AnonymousClass1.a[((io.reactivex.parallel.ParallelFailureHandling) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(java.lang.Long.valueOf(j), th), "The errorHandler returned a null item")).ordinal()];
                        } catch (java.lang.Throwable th2) {
                            io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                            cancel();
                            onError(new io.reactivex.exceptions.CompositeException(th, th2));
                        }
                    }
                } while (i == 1);
                if (i != 2) {
                    if (i != 3) {
                        cancel();
                        onError(th);
                        return false;
                    }
                    cancel();
                    onComplete();
                }
                return false;
            }
            return false;
        }
    }

    public static final class ParallelFilterSubscriber<T> extends io.reactivex.internal.operators.parallel.ParallelFilterTry.BaseFilterSubscriber<T> {
        public final org.reactivestreams.Subscriber<? super T> w;

        public ParallelFilterSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.functions.Predicate<? super T> predicate, io.reactivex.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.parallel.ParallelFailureHandling> biFunction) {
            super(predicate, biFunction);
            this.w = subscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.v) {
                return;
            }
            this.v = true;
            this.w.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.v) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.v = true;
                this.w.onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.u, subscription)) {
                this.u = subscription;
                this.w.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            int i;
            if (!this.v) {
                long j = 0;
                do {
                    try {
                        if (!this.n.test(t)) {
                            return false;
                        }
                        this.w.onNext(t);
                        return true;
                    } catch (java.lang.Throwable th) {
                        io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                        try {
                            j++;
                            i = io.reactivex.internal.operators.parallel.ParallelFilterTry.AnonymousClass1.a[((io.reactivex.parallel.ParallelFailureHandling) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(java.lang.Long.valueOf(j), th), "The errorHandler returned a null item")).ordinal()];
                        } catch (java.lang.Throwable th2) {
                            io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                            cancel();
                            onError(new io.reactivex.exceptions.CompositeException(th, th2));
                        }
                    }
                } while (i == 1);
                if (i != 2) {
                    if (i != 3) {
                        cancel();
                        onError(th);
                        return false;
                    }
                    cancel();
                    onComplete();
                }
                return false;
            }
            return false;
        }
    }

    public ParallelFilterTry(io.reactivex.parallel.ParallelFlowable<T> parallelFlowable, io.reactivex.functions.Predicate<? super T> predicate, io.reactivex.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.parallel.ParallelFailureHandling> biFunction) {
        this.a = parallelFlowable;
        this.b = predicate;
        this.c = biFunction;
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
                    subscriberArr2[i] = new io.reactivex.internal.operators.parallel.ParallelFilterTry.ParallelFilterConditionalSubscriber((io.reactivex.internal.fuseable.ConditionalSubscriber) subscriber, this.b, this.c);
                } else {
                    subscriberArr2[i] = new io.reactivex.internal.operators.parallel.ParallelFilterTry.ParallelFilterSubscriber(subscriber, this.b, this.c);
                }
            }
            this.a.subscribe(subscriberArr2);
        }
    }
}
