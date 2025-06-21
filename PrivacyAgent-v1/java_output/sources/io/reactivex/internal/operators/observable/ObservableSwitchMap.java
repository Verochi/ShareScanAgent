package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableSwitchMap<T, R> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, R> {
    public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> n;
    public final int t;
    public final boolean u;

    public static final class SwitchMapInnerObserver<T, R> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.Observer<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        final long index;
        final io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapObserver<T, R> parent;
        volatile io.reactivex.internal.fuseable.SimpleQueue<R> queue;

        public SwitchMapInnerObserver(io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapObserver<T, R> switchMapObserver, long j, int i) {
            this.parent = switchMapObserver;
            this.index = j;
            this.bufferSize = i;
        }

        public void cancel() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.index == this.parent.unique) {
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.parent.innerError(this, th);
        }

        @Override // io.reactivex.Observer
        public void onNext(R r) {
            if (this.index == this.parent.unique) {
                if (r != null) {
                    this.queue.offer(r);
                }
                this.parent.drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable)) {
                if (disposable instanceof io.reactivex.internal.fuseable.QueueDisposable) {
                    io.reactivex.internal.fuseable.QueueDisposable queueDisposable = (io.reactivex.internal.fuseable.QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(7);
                    if (requestFusion == 1) {
                        this.queue = queueDisposable;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.queue = queueDisposable;
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.SpscLinkedArrayQueue(this.bufferSize);
            }
        }
    }

    public static final class SwitchMapObserver<T, R> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        static final io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver<java.lang.Object, java.lang.Object> CANCELLED;
        private static final long serialVersionUID = -3491074160481096299L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final io.reactivex.Observer<? super R> downstream;
        final io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> mapper;
        volatile long unique;
        io.reactivex.disposables.Disposable upstream;
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver<T, R>> active = new java.util.concurrent.atomic.AtomicReference<>();
        final io.reactivex.internal.util.AtomicThrowable errors = new io.reactivex.internal.util.AtomicThrowable();

        static {
            io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver<java.lang.Object, java.lang.Object> switchMapInnerObserver = new io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver<>(null, -1L, 1);
            CANCELLED = switchMapInnerObserver;
            switchMapInnerObserver.cancel();
        }

        public SwitchMapObserver(io.reactivex.Observer<? super R> observer, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function, int i, boolean z) {
            this.downstream = observer;
            this.mapper = function;
            this.bufferSize = i;
            this.delayErrors = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.dispose();
            disposeInner();
        }

        public void disposeInner() {
            io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver<java.lang.Object, java.lang.Object> switchMapInnerObserver;
            io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver<T, R> switchMapInnerObserver2 = this.active.get();
            io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver<java.lang.Object, java.lang.Object> switchMapInnerObserver3 = CANCELLED;
            if (switchMapInnerObserver2 == switchMapInnerObserver3 || (switchMapInnerObserver = (io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver) this.active.getAndSet(switchMapInnerObserver3)) == switchMapInnerObserver3 || switchMapInnerObserver == null) {
                return;
            }
            switchMapInnerObserver.cancel();
        }

        /* JADX WARN: Removed duplicated region for block: B:71:0x00e9 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x000f A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            io.reactivex.internal.fuseable.SimpleQueue<R> simpleQueue;
            defpackage.a aVar;
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.Observer<? super R> observer = this.downstream;
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver<T, R>> atomicReference = this.active;
            boolean z = this.delayErrors;
            int i = 1;
            while (!this.cancelled) {
                if (this.done) {
                    boolean z2 = atomicReference.get() == null;
                    if (z) {
                        if (z2) {
                            java.lang.Throwable th = this.errors.get();
                            if (th != null) {
                                observer.onError(th);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        }
                    } else if (this.errors.get() != null) {
                        observer.onError(this.errors.terminate());
                        return;
                    } else if (z2) {
                        observer.onComplete();
                        return;
                    }
                }
                io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver<T, R> switchMapInnerObserver = atomicReference.get();
                if (switchMapInnerObserver != null && (simpleQueue = switchMapInnerObserver.queue) != null) {
                    if (switchMapInnerObserver.done) {
                        boolean isEmpty = simpleQueue.isEmpty();
                        if (z) {
                            if (isEmpty) {
                                defpackage.xv0.a(atomicReference, switchMapInnerObserver, null);
                            }
                        } else if (this.errors.get() != null) {
                            observer.onError(this.errors.terminate());
                            return;
                        } else if (isEmpty) {
                            defpackage.xv0.a(atomicReference, switchMapInnerObserver, null);
                        }
                    }
                    boolean z3 = false;
                    while (!this.cancelled) {
                        if (switchMapInnerObserver == atomicReference.get()) {
                            if (!z && this.errors.get() != null) {
                                observer.onError(this.errors.terminate());
                                return;
                            }
                            boolean z4 = switchMapInnerObserver.done;
                            try {
                                aVar = simpleQueue.poll();
                            } catch (java.lang.Throwable th2) {
                                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                                this.errors.addThrowable(th2);
                                defpackage.xv0.a(atomicReference, switchMapInnerObserver, null);
                                if (z) {
                                    switchMapInnerObserver.cancel();
                                } else {
                                    disposeInner();
                                    this.upstream.dispose();
                                    this.done = true;
                                }
                                aVar = null;
                                z3 = true;
                            }
                            boolean z5 = aVar == null;
                            if (z4 && z5) {
                                defpackage.xv0.a(atomicReference, switchMapInnerObserver, null);
                            } else if (!z5) {
                                observer.onNext(aVar);
                            } else if (!z3) {
                                continue;
                            }
                        }
                        z3 = true;
                        if (!z3) {
                        }
                    }
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        public void innerError(io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver<T, R> switchMapInnerObserver, java.lang.Throwable th) {
            if (switchMapInnerObserver.index != this.unique || !this.errors.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.dispose();
                this.done = true;
            }
            switchMapInnerObserver.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.done || !this.errors.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            if (!this.delayErrors) {
                disposeInner();
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver<T, R> switchMapInnerObserver;
            long j = this.unique + 1;
            this.unique = j;
            io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver<T, R> switchMapInnerObserver2 = this.active.get();
            if (switchMapInnerObserver2 != null) {
                switchMapInnerObserver2.cancel();
            }
            try {
                io.reactivex.ObservableSource observableSource = (io.reactivex.ObservableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.mapper.apply(t), "The ObservableSource returned is null");
                io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver switchMapInnerObserver3 = new io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver(this, j, this.bufferSize);
                do {
                    switchMapInnerObserver = this.active.get();
                    if (switchMapInnerObserver == CANCELLED) {
                        return;
                    }
                } while (!defpackage.xv0.a(this.active, switchMapInnerObserver, switchMapInnerObserver3));
                observableSource.subscribe(switchMapInnerObserver3);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMap(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function, int i, boolean z) {
        super(observableSource);
        this.n = function;
        this.t = i;
        this.u = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super R> observer) {
        if (io.reactivex.internal.operators.observable.ObservableScalarXMap.tryScalarXMapSubscribe(this.source, observer, this.n)) {
            return;
        }
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapObserver(observer, this.n, this.t, this.u));
    }
}
