package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableMapNotification<T, R> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, R> {
    public final io.reactivex.functions.Function<? super T, ? extends R> t;
    public final io.reactivex.functions.Function<? super java.lang.Throwable, ? extends R> u;
    public final java.util.concurrent.Callable<? extends R> v;

    public static final class MapNotificationSubscriber<T, R> extends io.reactivex.internal.subscribers.SinglePostCompleteSubscriber<T, R> {
        private static final long serialVersionUID = 2757120512858778108L;
        final java.util.concurrent.Callable<? extends R> onCompleteSupplier;
        final io.reactivex.functions.Function<? super java.lang.Throwable, ? extends R> onErrorMapper;
        final io.reactivex.functions.Function<? super T, ? extends R> onNextMapper;

        public MapNotificationSubscriber(org.reactivestreams.Subscriber<? super R> subscriber, io.reactivex.functions.Function<? super T, ? extends R> function, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends R> function2, java.util.concurrent.Callable<? extends R> callable) {
            super(subscriber);
            this.onNextMapper = function;
            this.onErrorMapper = function2;
            this.onCompleteSupplier = callable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            try {
                complete(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.onCompleteSupplier.call(), "The onComplete publisher returned is null"));
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            try {
                complete(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.onErrorMapper.apply(th), "The onError publisher returned is null"));
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                this.downstream.onError(new io.reactivex.exceptions.CompositeException(th, th2));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                java.lang.Object requireNonNull = io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.onNextMapper.apply(t), "The onNext publisher returned is null");
                this.produced++;
                this.downstream.onNext(requireNonNull);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }
        }
    }

    public FlowableMapNotification(io.reactivex.Flowable<T> flowable, io.reactivex.functions.Function<? super T, ? extends R> function, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends R> function2, java.util.concurrent.Callable<? extends R> callable) {
        super(flowable);
        this.t = function;
        this.u = function2;
        this.v = callable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super R> subscriber) {
        this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableMapNotification.MapNotificationSubscriber(subscriber, this.t, this.u, this.v));
    }
}
