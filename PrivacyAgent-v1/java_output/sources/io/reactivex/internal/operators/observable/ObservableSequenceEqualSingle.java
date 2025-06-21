package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableSequenceEqualSingle<T> extends io.reactivex.Single<java.lang.Boolean> implements io.reactivex.internal.fuseable.FuseToObservable<java.lang.Boolean> {
    public final io.reactivex.ObservableSource<? extends T> n;
    public final io.reactivex.ObservableSource<? extends T> t;
    public final io.reactivex.functions.BiPredicate<? super T, ? super T> u;
    public final int v;

    public static final class EqualCoordinator<T> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -6178010334400373240L;
        volatile boolean cancelled;
        final io.reactivex.functions.BiPredicate<? super T, ? super T> comparer;
        final io.reactivex.SingleObserver<? super java.lang.Boolean> downstream;
        final io.reactivex.ObservableSource<? extends T> first;
        final io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle.EqualObserver<T>[] observers;
        final io.reactivex.internal.disposables.ArrayCompositeDisposable resources = new io.reactivex.internal.disposables.ArrayCompositeDisposable(2);
        final io.reactivex.ObservableSource<? extends T> second;
        T v1;
        T v2;

        public EqualCoordinator(io.reactivex.SingleObserver<? super java.lang.Boolean> singleObserver, int i, io.reactivex.ObservableSource<? extends T> observableSource, io.reactivex.ObservableSource<? extends T> observableSource2, io.reactivex.functions.BiPredicate<? super T, ? super T> biPredicate) {
            this.downstream = singleObserver;
            this.first = observableSource;
            this.second = observableSource2;
            this.comparer = biPredicate;
            this.observers = new io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle.EqualObserver[]{new io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle.EqualObserver<>(this, 0, i), new io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle.EqualObserver<>(this, 1, i)};
        }

        public void cancel(io.reactivex.internal.queue.SpscLinkedArrayQueue<T> spscLinkedArrayQueue, io.reactivex.internal.queue.SpscLinkedArrayQueue<T> spscLinkedArrayQueue2) {
            this.cancelled = true;
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.resources.dispose();
            if (getAndIncrement() == 0) {
                io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle.EqualObserver<T>[] equalObserverArr = this.observers;
                equalObserverArr[0].t.clear();
                equalObserverArr[1].t.clear();
            }
        }

        public void drain() {
            java.lang.Throwable th;
            java.lang.Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle.EqualObserver<T>[] equalObserverArr = this.observers;
            io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle.EqualObserver<T> equalObserver = equalObserverArr[0];
            io.reactivex.internal.queue.SpscLinkedArrayQueue<T> spscLinkedArrayQueue = equalObserver.t;
            io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle.EqualObserver<T> equalObserver2 = equalObserverArr[1];
            io.reactivex.internal.queue.SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = equalObserver2.t;
            int i = 1;
            while (!this.cancelled) {
                boolean z = equalObserver.v;
                if (z && (th2 = equalObserver.w) != null) {
                    cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.downstream.onError(th2);
                    return;
                }
                boolean z2 = equalObserver2.v;
                if (z2 && (th = equalObserver2.w) != null) {
                    cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.downstream.onError(th);
                    return;
                }
                if (this.v1 == null) {
                    this.v1 = spscLinkedArrayQueue.poll();
                }
                boolean z3 = this.v1 == null;
                if (this.v2 == null) {
                    this.v2 = spscLinkedArrayQueue2.poll();
                }
                T t = this.v2;
                boolean z4 = t == null;
                if (z && z2 && z3 && z4) {
                    this.downstream.onSuccess(java.lang.Boolean.TRUE);
                    return;
                }
                if (z && z2 && z3 != z4) {
                    cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.downstream.onSuccess(java.lang.Boolean.FALSE);
                    return;
                }
                if (!z3 && !z4) {
                    try {
                        if (!this.comparer.test(this.v1, t)) {
                            cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.downstream.onSuccess(java.lang.Boolean.FALSE);
                            return;
                        } else {
                            this.v1 = null;
                            this.v2 = null;
                        }
                    } catch (java.lang.Throwable th3) {
                        io.reactivex.exceptions.Exceptions.throwIfFatal(th3);
                        cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                        this.downstream.onError(th3);
                        return;
                    }
                }
                if (z3 || z4) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        public boolean setDisposable(io.reactivex.disposables.Disposable disposable, int i) {
            return this.resources.setResource(i, disposable);
        }

        public void subscribe() {
            io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle.EqualObserver<T>[] equalObserverArr = this.observers;
            this.first.subscribe(equalObserverArr[0]);
            this.second.subscribe(equalObserverArr[1]);
        }
    }

    public static final class EqualObserver<T> implements io.reactivex.Observer<T> {
        public final io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle.EqualCoordinator<T> n;
        public final io.reactivex.internal.queue.SpscLinkedArrayQueue<T> t;
        public final int u;
        public volatile boolean v;
        public java.lang.Throwable w;

        public EqualObserver(io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle.EqualCoordinator<T> equalCoordinator, int i, int i2) {
            this.n = equalCoordinator;
            this.u = i;
            this.t = new io.reactivex.internal.queue.SpscLinkedArrayQueue<>(i2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.v = true;
            this.n.drain();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.w = th;
            this.v = true;
            this.n.drain();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.t.offer(t);
            this.n.drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.n.setDisposable(disposable, this.u);
        }
    }

    public ObservableSequenceEqualSingle(io.reactivex.ObservableSource<? extends T> observableSource, io.reactivex.ObservableSource<? extends T> observableSource2, io.reactivex.functions.BiPredicate<? super T, ? super T> biPredicate, int i) {
        this.n = observableSource;
        this.t = observableSource2;
        this.u = biPredicate;
        this.v = i;
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public io.reactivex.Observable<java.lang.Boolean> fuseToObservable() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSequenceEqual(this.n, this.t, this.u, this.v));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super java.lang.Boolean> singleObserver) {
        io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle.EqualCoordinator equalCoordinator = new io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle.EqualCoordinator(singleObserver, this.v, this.n, this.t, this.u);
        singleObserver.onSubscribe(equalCoordinator);
        equalCoordinator.subscribe();
    }
}
