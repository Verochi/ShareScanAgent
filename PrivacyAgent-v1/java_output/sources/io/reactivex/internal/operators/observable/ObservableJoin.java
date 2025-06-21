package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<TLeft, R> {
    public final io.reactivex.ObservableSource<? extends TRight> n;
    public final io.reactivex.functions.Function<? super TLeft, ? extends io.reactivex.ObservableSource<TLeftEnd>> t;
    public final io.reactivex.functions.Function<? super TRight, ? extends io.reactivex.ObservableSource<TRightEnd>> u;
    public final io.reactivex.functions.BiFunction<? super TLeft, ? super TRight, ? extends R> v;

    public static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.disposables.Disposable, io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport {
        private static final long serialVersionUID = -6071216598687999801L;
        volatile boolean cancelled;
        final io.reactivex.Observer<? super R> downstream;
        final io.reactivex.functions.Function<? super TLeft, ? extends io.reactivex.ObservableSource<TLeftEnd>> leftEnd;
        int leftIndex;
        final io.reactivex.functions.BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
        final io.reactivex.functions.Function<? super TRight, ? extends io.reactivex.ObservableSource<TRightEnd>> rightEnd;
        int rightIndex;
        static final java.lang.Integer LEFT_VALUE = 1;
        static final java.lang.Integer RIGHT_VALUE = 2;
        static final java.lang.Integer LEFT_CLOSE = 3;
        static final java.lang.Integer RIGHT_CLOSE = 4;
        final io.reactivex.disposables.CompositeDisposable disposables = new io.reactivex.disposables.CompositeDisposable();
        final io.reactivex.internal.queue.SpscLinkedArrayQueue<java.lang.Object> queue = new io.reactivex.internal.queue.SpscLinkedArrayQueue<>(io.reactivex.Observable.bufferSize());
        final java.util.Map<java.lang.Integer, TLeft> lefts = new java.util.LinkedHashMap();
        final java.util.Map<java.lang.Integer, TRight> rights = new java.util.LinkedHashMap();
        final java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> error = new java.util.concurrent.atomic.AtomicReference<>();
        final java.util.concurrent.atomic.AtomicInteger active = new java.util.concurrent.atomic.AtomicInteger(2);

        public JoinDisposable(io.reactivex.Observer<? super R> observer, io.reactivex.functions.Function<? super TLeft, ? extends io.reactivex.ObservableSource<TLeftEnd>> function, io.reactivex.functions.Function<? super TRight, ? extends io.reactivex.ObservableSource<TRightEnd>> function2, io.reactivex.functions.BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
            this.downstream = observer;
            this.leftEnd = function;
            this.rightEnd = function2;
            this.resultSelector = biFunction;
        }

        public void cancelAll() {
            this.disposables.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.internal.queue.SpscLinkedArrayQueue<?> spscLinkedArrayQueue = this.queue;
            io.reactivex.Observer<? super R> observer = this.downstream;
            int i = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    spscLinkedArrayQueue.clear();
                    cancelAll();
                    errorAll(observer);
                    return;
                }
                boolean z = this.active.get() == 0;
                java.lang.Integer num = (java.lang.Integer) spscLinkedArrayQueue.poll();
                boolean z2 = num == null;
                if (z && z2) {
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    observer.onComplete();
                    return;
                }
                if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    java.lang.Object poll = spscLinkedArrayQueue.poll();
                    if (num == LEFT_VALUE) {
                        int i2 = this.leftIndex;
                        this.leftIndex = i2 + 1;
                        this.lefts.put(java.lang.Integer.valueOf(i2), poll);
                        try {
                            io.reactivex.ObservableSource observableSource = (io.reactivex.ObservableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.leftEnd.apply(poll), "The leftEnd returned a null ObservableSource");
                            io.reactivex.internal.operators.observable.ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver = new io.reactivex.internal.operators.observable.ObservableGroupJoin.LeftRightEndObserver(this, true, i2);
                            this.disposables.add(leftRightEndObserver);
                            observableSource.subscribe(leftRightEndObserver);
                            if (this.error.get() != null) {
                                spscLinkedArrayQueue.clear();
                                cancelAll();
                                errorAll(observer);
                                return;
                            } else {
                                java.util.Iterator<TRight> it = this.rights.values().iterator();
                                while (it.hasNext()) {
                                    try {
                                        observer.onNext((java.lang.Object) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.resultSelector.apply(poll, it.next()), "The resultSelector returned a null value"));
                                    } catch (java.lang.Throwable th) {
                                        fail(th, observer, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                            }
                        } catch (java.lang.Throwable th2) {
                            fail(th2, observer, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == RIGHT_VALUE) {
                        int i3 = this.rightIndex;
                        this.rightIndex = i3 + 1;
                        this.rights.put(java.lang.Integer.valueOf(i3), poll);
                        try {
                            io.reactivex.ObservableSource observableSource2 = (io.reactivex.ObservableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.rightEnd.apply(poll), "The rightEnd returned a null ObservableSource");
                            io.reactivex.internal.operators.observable.ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver2 = new io.reactivex.internal.operators.observable.ObservableGroupJoin.LeftRightEndObserver(this, false, i3);
                            this.disposables.add(leftRightEndObserver2);
                            observableSource2.subscribe(leftRightEndObserver2);
                            if (this.error.get() != null) {
                                spscLinkedArrayQueue.clear();
                                cancelAll();
                                errorAll(observer);
                                return;
                            } else {
                                java.util.Iterator<TLeft> it2 = this.lefts.values().iterator();
                                while (it2.hasNext()) {
                                    try {
                                        observer.onNext((java.lang.Object) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.resultSelector.apply(it2.next(), poll), "The resultSelector returned a null value"));
                                    } catch (java.lang.Throwable th3) {
                                        fail(th3, observer, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                            }
                        } catch (java.lang.Throwable th4) {
                            fail(th4, observer, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        io.reactivex.internal.operators.observable.ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver3 = (io.reactivex.internal.operators.observable.ObservableGroupJoin.LeftRightEndObserver) poll;
                        this.lefts.remove(java.lang.Integer.valueOf(leftRightEndObserver3.index));
                        this.disposables.remove(leftRightEndObserver3);
                    } else {
                        io.reactivex.internal.operators.observable.ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver4 = (io.reactivex.internal.operators.observable.ObservableGroupJoin.LeftRightEndObserver) poll;
                        this.rights.remove(java.lang.Integer.valueOf(leftRightEndObserver4.index));
                        this.disposables.remove(leftRightEndObserver4);
                    }
                }
            }
            spscLinkedArrayQueue.clear();
        }

        public void errorAll(io.reactivex.Observer<?> observer) {
            java.lang.Throwable terminate = io.reactivex.internal.util.ExceptionHelper.terminate(this.error);
            this.lefts.clear();
            this.rights.clear();
            observer.onError(terminate);
        }

        public void fail(java.lang.Throwable th, io.reactivex.Observer<?> observer, io.reactivex.internal.queue.SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.util.ExceptionHelper.addThrowable(this.error, th);
            spscLinkedArrayQueue.clear();
            cancelAll();
            errorAll(observer);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerClose(boolean z, io.reactivex.internal.operators.observable.ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_CLOSE : RIGHT_CLOSE, leftRightEndObserver);
            }
            drain();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerCloseError(java.lang.Throwable th) {
            if (io.reactivex.internal.util.ExceptionHelper.addThrowable(this.error, th)) {
                drain();
            } else {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerComplete(io.reactivex.internal.operators.observable.ObservableGroupJoin.LeftRightObserver leftRightObserver) {
            this.disposables.delete(leftRightObserver);
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerError(java.lang.Throwable th) {
            if (!io.reactivex.internal.util.ExceptionHelper.addThrowable(this.error, th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.active.decrementAndGet();
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerValue(boolean z, java.lang.Object obj) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_VALUE : RIGHT_VALUE, obj);
            }
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    public ObservableJoin(io.reactivex.ObservableSource<TLeft> observableSource, io.reactivex.ObservableSource<? extends TRight> observableSource2, io.reactivex.functions.Function<? super TLeft, ? extends io.reactivex.ObservableSource<TLeftEnd>> function, io.reactivex.functions.Function<? super TRight, ? extends io.reactivex.ObservableSource<TRightEnd>> function2, io.reactivex.functions.BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(observableSource);
        this.n = observableSource2;
        this.t = function;
        this.u = function2;
        this.v = biFunction;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super R> observer) {
        io.reactivex.internal.operators.observable.ObservableJoin.JoinDisposable joinDisposable = new io.reactivex.internal.operators.observable.ObservableJoin.JoinDisposable(observer, this.t, this.u, this.v);
        observer.onSubscribe(joinDisposable);
        io.reactivex.internal.operators.observable.ObservableGroupJoin.LeftRightObserver leftRightObserver = new io.reactivex.internal.operators.observable.ObservableGroupJoin.LeftRightObserver(joinDisposable, true);
        joinDisposable.disposables.add(leftRightObserver);
        io.reactivex.internal.operators.observable.ObservableGroupJoin.LeftRightObserver leftRightObserver2 = new io.reactivex.internal.operators.observable.ObservableGroupJoin.LeftRightObserver(joinDisposable, false);
        joinDisposable.disposables.add(leftRightObserver2);
        this.source.subscribe(leftRightObserver);
        this.n.subscribe(leftRightObserver2);
    }
}
