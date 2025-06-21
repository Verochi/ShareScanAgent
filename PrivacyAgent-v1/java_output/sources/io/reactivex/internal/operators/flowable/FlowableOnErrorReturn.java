package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableOnErrorReturn<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final io.reactivex.functions.Function<? super java.lang.Throwable, ? extends T> t;

    public static final class OnErrorReturnSubscriber<T> extends io.reactivex.internal.subscribers.SinglePostCompleteSubscriber<T, T> {
        private static final long serialVersionUID = -3740826063558713822L;
        final io.reactivex.functions.Function<? super java.lang.Throwable, ? extends T> valueSupplier;

        public OnErrorReturnSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends T> function) {
            super(subscriber);
            this.valueSupplier = function;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            try {
                complete(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.valueSupplier.apply(th), "The valueSupplier returned a null value"));
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                this.downstream.onError(new io.reactivex.exceptions.CompositeException(th, th2));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.produced++;
            this.downstream.onNext(t);
        }
    }

    public FlowableOnErrorReturn(io.reactivex.Flowable<T> flowable, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends T> function) {
        super(flowable);
        this.t = function;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableOnErrorReturn.OnErrorReturnSubscriber(subscriber, this.t));
    }
}
