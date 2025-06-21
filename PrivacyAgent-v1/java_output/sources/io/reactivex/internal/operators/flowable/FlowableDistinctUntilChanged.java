package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableDistinctUntilChanged<T, K> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final io.reactivex.functions.Function<? super T, K> t;
    public final io.reactivex.functions.BiPredicate<? super K, ? super K> u;

    public static final class DistinctUntilChangedConditionalSubscriber<T, K> extends io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber<T, T> {
        public final io.reactivex.functions.Function<? super T, K> n;
        public final io.reactivex.functions.BiPredicate<? super K, ? super K> t;
        public K u;
        public boolean v;

        public DistinctUntilChangedConditionalSubscriber(io.reactivex.internal.fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, io.reactivex.functions.Function<? super T, K> function, io.reactivex.functions.BiPredicate<? super K, ? super K> biPredicate) {
            super(conditionalSubscriber);
            this.n = function;
            this.t = biPredicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.upstream.request(1L);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public T poll() throws java.lang.Exception {
            while (true) {
                T poll = this.qs.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.n.apply(poll);
                if (!this.v) {
                    this.v = true;
                    this.u = apply;
                    return poll;
                }
                if (!this.t.test(this.u, apply)) {
                    this.u = apply;
                    return poll;
                }
                this.u = apply;
                if (this.sourceMode != 1) {
                    this.upstream.request(1L);
                }
            }
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
            if (this.sourceMode != 0) {
                return this.downstream.tryOnNext(t);
            }
            try {
                K apply = this.n.apply(t);
                if (this.v) {
                    boolean test = this.t.test(this.u, apply);
                    this.u = apply;
                    if (test) {
                        return false;
                    }
                } else {
                    this.v = true;
                    this.u = apply;
                }
                this.downstream.onNext(t);
                return true;
            } catch (java.lang.Throwable th) {
                fail(th);
                return true;
            }
        }
    }

    public static final class DistinctUntilChangedSubscriber<T, K> extends io.reactivex.internal.subscribers.BasicFuseableSubscriber<T, T> implements io.reactivex.internal.fuseable.ConditionalSubscriber<T> {
        public final io.reactivex.functions.Function<? super T, K> n;
        public final io.reactivex.functions.BiPredicate<? super K, ? super K> t;
        public K u;
        public boolean v;

        public DistinctUntilChangedSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.functions.Function<? super T, K> function, io.reactivex.functions.BiPredicate<? super K, ? super K> biPredicate) {
            super(subscriber);
            this.n = function;
            this.t = biPredicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.upstream.request(1L);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public T poll() throws java.lang.Exception {
            while (true) {
                T poll = this.qs.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.n.apply(poll);
                if (!this.v) {
                    this.v = true;
                    this.u = apply;
                    return poll;
                }
                if (!this.t.test(this.u, apply)) {
                    this.u = apply;
                    return poll;
                }
                this.u = apply;
                if (this.sourceMode != 1) {
                    this.upstream.request(1L);
                }
            }
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
            if (this.sourceMode != 0) {
                this.downstream.onNext(t);
                return true;
            }
            try {
                K apply = this.n.apply(t);
                if (this.v) {
                    boolean test = this.t.test(this.u, apply);
                    this.u = apply;
                    if (test) {
                        return false;
                    }
                } else {
                    this.v = true;
                    this.u = apply;
                }
                this.downstream.onNext(t);
                return true;
            } catch (java.lang.Throwable th) {
                fail(th);
                return true;
            }
        }
    }

    public FlowableDistinctUntilChanged(io.reactivex.Flowable<T> flowable, io.reactivex.functions.Function<? super T, K> function, io.reactivex.functions.BiPredicate<? super K, ? super K> biPredicate) {
        super(flowable);
        this.t = function;
        this.u = biPredicate;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        if (subscriber instanceof io.reactivex.internal.fuseable.ConditionalSubscriber) {
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableDistinctUntilChanged.DistinctUntilChangedConditionalSubscriber((io.reactivex.internal.fuseable.ConditionalSubscriber) subscriber, this.t, this.u));
        } else {
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableDistinctUntilChanged.DistinctUntilChangedSubscriber(subscriber, this.t, this.u));
        }
    }
}
