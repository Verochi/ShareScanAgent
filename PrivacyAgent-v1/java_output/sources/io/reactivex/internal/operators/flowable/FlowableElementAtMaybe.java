package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableElementAtMaybe<T> extends io.reactivex.Maybe<T> implements io.reactivex.internal.fuseable.FuseToFlowable<T> {
    public final io.reactivex.Flowable<T> n;
    public final long t;

    public static final class ElementAtSubscriber<T> implements io.reactivex.FlowableSubscriber<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.MaybeObserver<? super T> n;
        public final long t;
        public org.reactivestreams.Subscription u;
        public long v;
        public boolean w;

        public ElementAtSubscriber(io.reactivex.MaybeObserver<? super T> maybeObserver, long j) {
            this.n = maybeObserver;
            this.t = j;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.u.cancel();
            this.u = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.u == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.u = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            if (this.w) {
                return;
            }
            this.w = true;
            this.n.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.w) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.w = true;
            this.u = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            this.n.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.w) {
                return;
            }
            long j = this.v;
            if (j != this.t) {
                this.v = j + 1;
                return;
            }
            this.w = true;
            this.u.cancel();
            this.u = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            this.n.onSuccess(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.u, subscription)) {
                this.u = subscription;
                this.n.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableElementAtMaybe(io.reactivex.Flowable<T> flowable, long j) {
        this.n = flowable;
        this.t = j;
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public io.reactivex.Flowable<T> fuseToFlowable() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableElementAt(this.n, this.t, null, false));
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.n.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableElementAtMaybe.ElementAtSubscriber(maybeObserver, this.t));
    }
}
