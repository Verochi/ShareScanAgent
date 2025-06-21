package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableConcatArray<T> extends io.reactivex.Flowable<T> {
    public final org.reactivestreams.Publisher<? extends T>[] t;
    public final boolean u;

    public static final class ConcatArraySubscriber<T> extends io.reactivex.internal.subscriptions.SubscriptionArbiter implements io.reactivex.FlowableSubscriber<T> {
        private static final long serialVersionUID = -8158322871608889516L;
        final boolean delayError;
        final org.reactivestreams.Subscriber<? super T> downstream;
        java.util.List<java.lang.Throwable> errors;
        int index;
        long produced;
        final org.reactivestreams.Publisher<? extends T>[] sources;
        final java.util.concurrent.atomic.AtomicInteger wip;

        public ConcatArraySubscriber(org.reactivestreams.Publisher<? extends T>[] publisherArr, boolean z, org.reactivestreams.Subscriber<? super T> subscriber) {
            super(false);
            this.downstream = subscriber;
            this.sources = publisherArr;
            this.delayError = z;
            this.wip = new java.util.concurrent.atomic.AtomicInteger();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.wip.getAndIncrement() == 0) {
                org.reactivestreams.Publisher<? extends T>[] publisherArr = this.sources;
                int length = publisherArr.length;
                int i = this.index;
                while (i != length) {
                    org.reactivestreams.Publisher<? extends T> publisher = publisherArr[i];
                    if (publisher == null) {
                        java.lang.NullPointerException nullPointerException = new java.lang.NullPointerException("A Publisher entry is null");
                        if (!this.delayError) {
                            this.downstream.onError(nullPointerException);
                            return;
                        }
                        java.util.List list = this.errors;
                        if (list == null) {
                            list = new java.util.ArrayList((length - i) + 1);
                            this.errors = list;
                        }
                        list.add(nullPointerException);
                        i++;
                    } else {
                        long j = this.produced;
                        if (j != 0) {
                            this.produced = 0L;
                            produced(j);
                        }
                        publisher.subscribe(this);
                        i++;
                        this.index = i;
                        if (this.wip.decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
                java.util.List<java.lang.Throwable> list2 = this.errors;
                if (list2 == null) {
                    this.downstream.onComplete();
                } else if (list2.size() == 1) {
                    this.downstream.onError(list2.get(0));
                } else {
                    this.downstream.onError(new io.reactivex.exceptions.CompositeException(list2));
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (!this.delayError) {
                this.downstream.onError(th);
                return;
            }
            java.util.List list = this.errors;
            if (list == null) {
                list = new java.util.ArrayList((this.sources.length - this.index) + 1);
                this.errors = list;
            }
            list.add(th);
            onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.produced++;
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            setSubscription(subscription);
        }
    }

    public FlowableConcatArray(org.reactivestreams.Publisher<? extends T>[] publisherArr, boolean z) {
        this.t = publisherArr;
        this.u = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.internal.operators.flowable.FlowableConcatArray.ConcatArraySubscriber concatArraySubscriber = new io.reactivex.internal.operators.flowable.FlowableConcatArray.ConcatArraySubscriber(this.t, this.u, subscriber);
        subscriber.onSubscribe(concatArraySubscriber);
        concatArraySubscriber.onComplete();
    }
}
