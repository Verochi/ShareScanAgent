package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableGenerate<T, S> extends io.reactivex.Flowable<T> {
    public final java.util.concurrent.Callable<S> t;
    public final io.reactivex.functions.BiFunction<S, io.reactivex.Emitter<T>, S> u;
    public final io.reactivex.functions.Consumer<? super S> v;

    public static final class GeneratorSubscription<T, S> extends java.util.concurrent.atomic.AtomicLong implements io.reactivex.Emitter<T>, org.reactivestreams.Subscription {
        private static final long serialVersionUID = 7565982551505011832L;
        volatile boolean cancelled;
        final io.reactivex.functions.Consumer<? super S> disposeState;
        final org.reactivestreams.Subscriber<? super T> downstream;
        final io.reactivex.functions.BiFunction<S, ? super io.reactivex.Emitter<T>, S> generator;
        boolean hasNext;
        S state;
        boolean terminate;

        public GeneratorSubscription(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.functions.BiFunction<S, ? super io.reactivex.Emitter<T>, S> biFunction, io.reactivex.functions.Consumer<? super S> consumer, S s2) {
            this.downstream = subscriber;
            this.generator = biFunction;
            this.disposeState = consumer;
            this.state = s2;
        }

        private void dispose(S s2) {
            try {
                this.disposeState.accept(s2);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (io.reactivex.internal.util.BackpressureHelper.add(this, 1L) == 0) {
                S s2 = this.state;
                this.state = null;
                dispose(s2);
            }
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            if (this.terminate) {
                return;
            }
            this.terminate = true;
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Emitter
        public void onError(java.lang.Throwable th) {
            if (this.terminate) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            if (th == null) {
                th = new java.lang.NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.terminate = true;
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t) {
            if (this.terminate) {
                return;
            }
            if (this.hasNext) {
                onError(new java.lang.IllegalStateException("onNext already called in this generate turn"));
            } else if (t == null) {
                onError(new java.lang.NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.hasNext = true;
                this.downstream.onNext(t);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
        
            r9.state = r0;
            r10 = addAndGet(-r4);
         */
        @Override // org.reactivestreams.Subscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j) && io.reactivex.internal.util.BackpressureHelper.add(this, j) == 0) {
                S s2 = this.state;
                io.reactivex.functions.BiFunction<S, ? super io.reactivex.Emitter<T>, S> biFunction = this.generator;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 == j) {
                            j = get();
                            if (j2 == j) {
                                break;
                            }
                        } else {
                            if (this.cancelled) {
                                this.state = null;
                                dispose(s2);
                                return;
                            }
                            this.hasNext = false;
                            try {
                                s2 = biFunction.apply(s2, this);
                                if (this.terminate) {
                                    this.cancelled = true;
                                    this.state = null;
                                    dispose(s2);
                                    return;
                                }
                                j2++;
                            } catch (java.lang.Throwable th) {
                                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                                this.cancelled = true;
                                this.state = null;
                                onError(th);
                                dispose(s2);
                                return;
                            }
                        }
                    }
                } while (j != 0);
            }
        }
    }

    public FlowableGenerate(java.util.concurrent.Callable<S> callable, io.reactivex.functions.BiFunction<S, io.reactivex.Emitter<T>, S> biFunction, io.reactivex.functions.Consumer<? super S> consumer) {
        this.t = callable;
        this.u = biFunction;
        this.v = consumer;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        try {
            subscriber.onSubscribe(new io.reactivex.internal.operators.flowable.FlowableGenerate.GeneratorSubscription(subscriber, this.u, this.v, this.t.call()));
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.subscriptions.EmptySubscription.error(th, subscriber);
        }
    }
}
