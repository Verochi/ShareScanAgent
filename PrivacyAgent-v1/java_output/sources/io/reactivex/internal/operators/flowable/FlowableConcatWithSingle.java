package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableConcatWithSingle<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final io.reactivex.SingleSource<? extends T> t;

    public static final class ConcatWithSubscriber<T> extends io.reactivex.internal.subscribers.SinglePostCompleteSubscriber<T, T> implements io.reactivex.SingleObserver<T> {
        private static final long serialVersionUID = -7346385463600070225L;
        io.reactivex.SingleSource<? extends T> other;
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> otherDisposable;

        public ConcatWithSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.SingleSource<? extends T> singleSource) {
            super(subscriber);
            this.other = singleSource;
            this.otherDisposable = new java.util.concurrent.atomic.AtomicReference<>();
        }

        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.otherDisposable);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.upstream = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            io.reactivex.SingleSource<? extends T> singleSource = this.other;
            this.other = null;
            singleSource.subscribe(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.produced++;
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this.otherDisposable, disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public FlowableConcatWithSingle(io.reactivex.Flowable<T> flowable, io.reactivex.SingleSource<? extends T> singleSource) {
        super(flowable);
        this.t = singleSource;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableConcatWithSingle.ConcatWithSubscriber(subscriber, this.t));
    }
}
