package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableMergeWithCompletable<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final io.reactivex.CompletableSource t;

    public static final class MergeWithSubscriber<T> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        private static final long serialVersionUID = -4592979584110982903L;
        final org.reactivestreams.Subscriber<? super T> downstream;
        volatile boolean mainDone;
        volatile boolean otherDone;
        final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> mainSubscription = new java.util.concurrent.atomic.AtomicReference<>();
        final io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable.MergeWithSubscriber.OtherObserver otherObserver = new io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable.MergeWithSubscriber.OtherObserver(this);
        final io.reactivex.internal.util.AtomicThrowable error = new io.reactivex.internal.util.AtomicThrowable();
        final java.util.concurrent.atomic.AtomicLong requested = new java.util.concurrent.atomic.AtomicLong();

        public static final class OtherObserver extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.CompletableObserver {
            private static final long serialVersionUID = -2935427570954647017L;
            final io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable.MergeWithSubscriber<?> parent;

            public OtherObserver(io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable.MergeWithSubscriber<?> mergeWithSubscriber) {
                this.parent = mergeWithSubscriber;
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.parent.otherComplete();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(java.lang.Throwable th) {
                this.parent.otherError(th);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
                io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
            }
        }

        public MergeWithSubscriber(org.reactivestreams.Subscriber<? super T> subscriber) {
            this.downstream = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.mainSubscription);
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.otherObserver);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.mainDone = true;
            if (this.otherDone) {
                io.reactivex.internal.util.HalfSerializer.onComplete(this.downstream, this, this.error);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.otherObserver);
            io.reactivex.internal.util.HalfSerializer.onError(this.downstream, th, this, this.error);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            io.reactivex.internal.util.HalfSerializer.onNext(this.downstream, t, this, this.error);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.deferredSetOnce(this.mainSubscription, this.requested, subscription);
        }

        public void otherComplete() {
            this.otherDone = true;
            if (this.mainDone) {
                io.reactivex.internal.util.HalfSerializer.onComplete(this.downstream, this, this.error);
            }
        }

        public void otherError(java.lang.Throwable th) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.mainSubscription);
            io.reactivex.internal.util.HalfSerializer.onError(this.downstream, th, this, this.error);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.deferredRequest(this.mainSubscription, this.requested, j);
        }
    }

    public FlowableMergeWithCompletable(io.reactivex.Flowable<T> flowable, io.reactivex.CompletableSource completableSource) {
        super(flowable);
        this.t = completableSource;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable.MergeWithSubscriber mergeWithSubscriber = new io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable.MergeWithSubscriber(subscriber);
        subscriber.onSubscribe(mergeWithSubscriber);
        this.source.subscribe((io.reactivex.FlowableSubscriber) mergeWithSubscriber);
        this.t.subscribe(mergeWithSubscriber.otherObserver);
    }
}
