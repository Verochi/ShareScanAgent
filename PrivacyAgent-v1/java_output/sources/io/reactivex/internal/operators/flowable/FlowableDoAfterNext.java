package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableDoAfterNext<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final io.reactivex.functions.Consumer<? super T> t;

    public static final class DoAfterConditionalSubscriber<T> extends io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber<T, T> {
        public final io.reactivex.functions.Consumer<? super T> n;

        public DoAfterConditionalSubscriber(io.reactivex.internal.fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, io.reactivex.functions.Consumer<? super T> consumer) {
            super(conditionalSubscriber);
            this.n = consumer;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.downstream.onNext(t);
            if (this.sourceMode == 0) {
                try {
                    this.n.accept(t);
                } catch (java.lang.Throwable th) {
                    fail(th);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public T poll() throws java.lang.Exception {
            T poll = this.qs.poll();
            if (poll != null) {
                this.n.accept(poll);
            }
            return poll;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            boolean tryOnNext = this.downstream.tryOnNext(t);
            try {
                this.n.accept(t);
            } catch (java.lang.Throwable th) {
                fail(th);
            }
            return tryOnNext;
        }
    }

    public static final class DoAfterSubscriber<T> extends io.reactivex.internal.subscribers.BasicFuseableSubscriber<T, T> {
        public final io.reactivex.functions.Consumer<? super T> n;

        public DoAfterSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.functions.Consumer<? super T> consumer) {
            super(subscriber);
            this.n = consumer;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            this.downstream.onNext(t);
            if (this.sourceMode == 0) {
                try {
                    this.n.accept(t);
                } catch (java.lang.Throwable th) {
                    fail(th);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public T poll() throws java.lang.Exception {
            T poll = this.qs.poll();
            if (poll != null) {
                this.n.accept(poll);
            }
            return poll;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }
    }

    public FlowableDoAfterNext(io.reactivex.Flowable<T> flowable, io.reactivex.functions.Consumer<? super T> consumer) {
        super(flowable);
        this.t = consumer;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        if (subscriber instanceof io.reactivex.internal.fuseable.ConditionalSubscriber) {
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableDoAfterNext.DoAfterConditionalSubscriber((io.reactivex.internal.fuseable.ConditionalSubscriber) subscriber, this.t));
        } else {
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableDoAfterNext.DoAfterSubscriber(subscriber, this.t));
        }
    }
}
