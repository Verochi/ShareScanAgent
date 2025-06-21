package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableDematerialize<T, R> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, R> {
    public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.Notification<R>> t;

    public static final class DematerializeSubscriber<T, R> implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        public final org.reactivestreams.Subscriber<? super R> n;
        public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.Notification<R>> t;
        public boolean u;
        public org.reactivestreams.Subscription v;

        public DematerializeSubscriber(org.reactivestreams.Subscriber<? super R> subscriber, io.reactivex.functions.Function<? super T, ? extends io.reactivex.Notification<R>> function) {
            this.n = subscriber;
            this.t = function;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.v.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.u) {
                return;
            }
            this.u = true;
            this.n.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.u) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.u = true;
                this.n.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.u) {
                if (t instanceof io.reactivex.Notification) {
                    io.reactivex.Notification notification = (io.reactivex.Notification) t;
                    if (notification.isOnError()) {
                        io.reactivex.plugins.RxJavaPlugins.onError(notification.getError());
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                io.reactivex.Notification notification2 = (io.reactivex.Notification) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(t), "The selector returned a null Notification");
                if (notification2.isOnError()) {
                    this.v.cancel();
                    onError(notification2.getError());
                } else if (!notification2.isOnComplete()) {
                    this.n.onNext((java.lang.Object) notification2.getValue());
                } else {
                    this.v.cancel();
                    onComplete();
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.v.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.v, subscription)) {
                this.v = subscription;
                this.n.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.v.request(j);
        }
    }

    public FlowableDematerialize(io.reactivex.Flowable<T> flowable, io.reactivex.functions.Function<? super T, ? extends io.reactivex.Notification<R>> function) {
        super(flowable);
        this.t = function;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super R> subscriber) {
        this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableDematerialize.DematerializeSubscriber(subscriber, this.t));
    }
}
