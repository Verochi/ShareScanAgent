package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableDoOnEach<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final io.reactivex.functions.Consumer<? super T> t;
    public final io.reactivex.functions.Consumer<? super java.lang.Throwable> u;
    public final io.reactivex.functions.Action v;
    public final io.reactivex.functions.Action w;

    public static final class DoOnEachConditionalSubscriber<T> extends io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber<T, T> {
        public final io.reactivex.functions.Consumer<? super T> n;
        public final io.reactivex.functions.Consumer<? super java.lang.Throwable> t;
        public final io.reactivex.functions.Action u;
        public final io.reactivex.functions.Action v;

        public DoOnEachConditionalSubscriber(io.reactivex.internal.fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2, io.reactivex.functions.Action action, io.reactivex.functions.Action action2) {
            super(conditionalSubscriber);
            this.n = consumer;
            this.t = consumer2;
            this.u = action;
            this.v = action2;
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            try {
                this.u.run();
                this.done = true;
                this.downstream.onComplete();
                try {
                    this.v.run();
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    io.reactivex.plugins.RxJavaPlugins.onError(th);
                }
            } catch (java.lang.Throwable th2) {
                fail(th2);
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.done) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            boolean z = true;
            this.done = true;
            try {
                this.t.accept(th);
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                this.downstream.onError(new io.reactivex.exceptions.CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.downstream.onError(th);
            }
            try {
                this.v.run();
            } catch (java.lang.Throwable th3) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th3);
                io.reactivex.plugins.RxJavaPlugins.onError(th3);
            }
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
                this.n.accept(t);
                this.downstream.onNext(t);
            } catch (java.lang.Throwable th) {
                fail(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public T poll() throws java.lang.Exception {
            try {
                T poll = this.qs.poll();
                if (poll != null) {
                    try {
                        this.n.accept(poll);
                    } catch (java.lang.Throwable th) {
                        try {
                            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                            try {
                                this.t.accept(th);
                                throw io.reactivex.internal.util.ExceptionHelper.throwIfThrowable(th);
                            } catch (java.lang.Throwable th2) {
                                throw new io.reactivex.exceptions.CompositeException(th, th2);
                            }
                        } finally {
                            this.v.run();
                        }
                    }
                } else if (this.sourceMode == 1) {
                    this.u.run();
                }
                return poll;
            } catch (java.lang.Throwable th3) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th3);
                try {
                    this.t.accept(th3);
                    throw io.reactivex.internal.util.ExceptionHelper.throwIfThrowable(th3);
                } catch (java.lang.Throwable th4) {
                    throw new io.reactivex.exceptions.CompositeException(th3, th4);
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
            try {
                this.n.accept(t);
                return this.downstream.tryOnNext(t);
            } catch (java.lang.Throwable th) {
                fail(th);
                return false;
            }
        }
    }

    public static final class DoOnEachSubscriber<T> extends io.reactivex.internal.subscribers.BasicFuseableSubscriber<T, T> {
        public final io.reactivex.functions.Consumer<? super T> n;
        public final io.reactivex.functions.Consumer<? super java.lang.Throwable> t;
        public final io.reactivex.functions.Action u;
        public final io.reactivex.functions.Action v;

        public DoOnEachSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2, io.reactivex.functions.Action action, io.reactivex.functions.Action action2) {
            super(subscriber);
            this.n = consumer;
            this.t = consumer2;
            this.u = action;
            this.v = action2;
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            try {
                this.u.run();
                this.done = true;
                this.downstream.onComplete();
                try {
                    this.v.run();
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    io.reactivex.plugins.RxJavaPlugins.onError(th);
                }
            } catch (java.lang.Throwable th2) {
                fail(th2);
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.done) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            boolean z = true;
            this.done = true;
            try {
                this.t.accept(th);
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                this.downstream.onError(new io.reactivex.exceptions.CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.downstream.onError(th);
            }
            try {
                this.v.run();
            } catch (java.lang.Throwable th3) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th3);
                io.reactivex.plugins.RxJavaPlugins.onError(th3);
            }
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
                this.n.accept(t);
                this.downstream.onNext(t);
            } catch (java.lang.Throwable th) {
                fail(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public T poll() throws java.lang.Exception {
            try {
                T poll = this.qs.poll();
                if (poll != null) {
                    try {
                        this.n.accept(poll);
                    } catch (java.lang.Throwable th) {
                        try {
                            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                            try {
                                this.t.accept(th);
                                throw io.reactivex.internal.util.ExceptionHelper.throwIfThrowable(th);
                            } catch (java.lang.Throwable th2) {
                                throw new io.reactivex.exceptions.CompositeException(th, th2);
                            }
                        } finally {
                            this.v.run();
                        }
                    }
                } else if (this.sourceMode == 1) {
                    this.u.run();
                }
                return poll;
            } catch (java.lang.Throwable th3) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th3);
                try {
                    this.t.accept(th3);
                    throw io.reactivex.internal.util.ExceptionHelper.throwIfThrowable(th3);
                } catch (java.lang.Throwable th4) {
                    throw new io.reactivex.exceptions.CompositeException(th3, th4);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }
    }

    public FlowableDoOnEach(io.reactivex.Flowable<T> flowable, io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2, io.reactivex.functions.Action action, io.reactivex.functions.Action action2) {
        super(flowable);
        this.t = consumer;
        this.u = consumer2;
        this.v = action;
        this.w = action2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        if (subscriber instanceof io.reactivex.internal.fuseable.ConditionalSubscriber) {
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableDoOnEach.DoOnEachConditionalSubscriber((io.reactivex.internal.fuseable.ConditionalSubscriber) subscriber, this.t, this.u, this.v, this.w));
        } else {
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableDoOnEach.DoOnEachSubscriber(subscriber, this.t, this.u, this.v, this.w));
        }
    }
}
