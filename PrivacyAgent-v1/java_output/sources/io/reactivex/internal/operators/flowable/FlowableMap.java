package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableMap<T, U> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, U> {
    public final io.reactivex.functions.Function<? super T, ? extends U> t;

    public static final class MapConditionalSubscriber<T, U> extends io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber<T, U> {
        public final io.reactivex.functions.Function<? super T, ? extends U> n;

        public MapConditionalSubscriber(io.reactivex.internal.fuseable.ConditionalSubscriber<? super U> conditionalSubscriber, io.reactivex.functions.Function<? super T, ? extends U> function) {
            super(conditionalSubscriber);
            this.n = function;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 0) {
                this.downstream.onNext(null);
                return;
            }
            try {
                this.downstream.onNext(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.apply(t), "The mapper function returned a null value."));
            } catch (java.lang.Throwable th) {
                fail(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public U poll() throws java.lang.Exception {
            T poll = this.qs.poll();
            if (poll != null) {
                return (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            try {
                return this.downstream.tryOnNext(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.apply(t), "The mapper function returned a null value."));
            } catch (java.lang.Throwable th) {
                fail(th);
                return true;
            }
        }
    }

    public static final class MapSubscriber<T, U> extends io.reactivex.internal.subscribers.BasicFuseableSubscriber<T, U> {
        public final io.reactivex.functions.Function<? super T, ? extends U> n;

        public MapSubscriber(org.reactivestreams.Subscriber<? super U> subscriber, io.reactivex.functions.Function<? super T, ? extends U> function) {
            super(subscriber);
            this.n = function;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 0) {
                this.downstream.onNext(null);
                return;
            }
            try {
                this.downstream.onNext(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.apply(t), "The mapper function returned a null value."));
            } catch (java.lang.Throwable th) {
                fail(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public U poll() throws java.lang.Exception {
            T poll = this.qs.poll();
            if (poll != null) {
                return (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }
    }

    public FlowableMap(io.reactivex.Flowable<T> flowable, io.reactivex.functions.Function<? super T, ? extends U> function) {
        super(flowable);
        this.t = function;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super U> subscriber) {
        if (subscriber instanceof io.reactivex.internal.fuseable.ConditionalSubscriber) {
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableMap.MapConditionalSubscriber((io.reactivex.internal.fuseable.ConditionalSubscriber) subscriber, this.t));
        } else {
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableMap.MapSubscriber(subscriber, this.t));
        }
    }
}
