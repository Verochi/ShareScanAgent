package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableReduceMaybe<T> extends io.reactivex.Maybe<T> implements io.reactivex.internal.fuseable.HasUpstreamPublisher<T>, io.reactivex.internal.fuseable.FuseToFlowable<T> {
    public final io.reactivex.Flowable<T> n;
    public final io.reactivex.functions.BiFunction<T, T, T> t;

    public static final class ReduceSubscriber<T> implements io.reactivex.FlowableSubscriber<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.MaybeObserver<? super T> n;
        public final io.reactivex.functions.BiFunction<T, T, T> t;
        public T u;
        public org.reactivestreams.Subscription v;
        public boolean w;

        public ReduceSubscriber(io.reactivex.MaybeObserver<? super T> maybeObserver, io.reactivex.functions.BiFunction<T, T, T> biFunction) {
            this.n = maybeObserver;
            this.t = biFunction;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.v.cancel();
            this.w = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.w;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.w) {
                return;
            }
            this.w = true;
            T t = this.u;
            if (t != null) {
                this.n.onSuccess(t);
            } else {
                this.n.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.w) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.w = true;
                this.n.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.w) {
                return;
            }
            T t2 = this.u;
            if (t2 == null) {
                this.u = t;
                return;
            }
            try {
                this.u = (T) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(t2, t), "The reducer returned a null value");
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
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableReduceMaybe(io.reactivex.Flowable<T> flowable, io.reactivex.functions.BiFunction<T, T, T> biFunction) {
        this.n = flowable;
        this.t = biFunction;
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public io.reactivex.Flowable<T> fuseToFlowable() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableReduce(this.n, this.t));
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public org.reactivestreams.Publisher<T> source() {
        return this.n;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.n.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableReduceMaybe.ReduceSubscriber(maybeObserver, this.t));
    }
}
