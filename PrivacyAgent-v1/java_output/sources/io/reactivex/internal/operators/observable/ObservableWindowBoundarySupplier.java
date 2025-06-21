package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableWindowBoundarySupplier<T, B> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, io.reactivex.Observable<T>> {
    public final java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<B>> n;
    public final int t;

    public static final class WindowBoundaryInnerObserver<T, B> extends io.reactivex.observers.DisposableObserver<B> {
        public final io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier.WindowBoundaryMainObserver<T, B> t;
        public boolean u;

        public WindowBoundaryInnerObserver(io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier.WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.t = windowBoundaryMainObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.u) {
                return;
            }
            this.u = true;
            this.t.innerComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.u) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.u = true;
                this.t.innerError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(B b) {
            if (this.u) {
                return;
            }
            this.u = true;
            dispose();
            this.t.innerNext(this);
        }
    }

    public static final class WindowBoundaryMainObserver<T, B> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable, java.lang.Runnable {
        static final io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier.WindowBoundaryInnerObserver<java.lang.Object, java.lang.Object> BOUNDARY_DISPOSED = new io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier.WindowBoundaryInnerObserver<>(null);
        static final java.lang.Object NEXT_WINDOW = new java.lang.Object();
        private static final long serialVersionUID = 2233020065421370272L;
        final int capacityHint;
        volatile boolean done;
        final io.reactivex.Observer<? super io.reactivex.Observable<T>> downstream;
        final java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<B>> other;
        io.reactivex.disposables.Disposable upstream;
        io.reactivex.subjects.UnicastSubject<T> window;
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier.WindowBoundaryInnerObserver<T, B>> boundaryObserver = new java.util.concurrent.atomic.AtomicReference<>();
        final java.util.concurrent.atomic.AtomicInteger windows = new java.util.concurrent.atomic.AtomicInteger(1);
        final io.reactivex.internal.queue.MpscLinkedQueue<java.lang.Object> queue = new io.reactivex.internal.queue.MpscLinkedQueue<>();
        final io.reactivex.internal.util.AtomicThrowable errors = new io.reactivex.internal.util.AtomicThrowable();
        final java.util.concurrent.atomic.AtomicBoolean stopWindows = new java.util.concurrent.atomic.AtomicBoolean();

        public WindowBoundaryMainObserver(io.reactivex.Observer<? super io.reactivex.Observable<T>> observer, int i, java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<B>> callable) {
            this.downstream = observer;
            this.capacityHint = i;
            this.other = callable;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.stopWindows.compareAndSet(false, true)) {
                disposeBoundary();
                if (this.windows.decrementAndGet() == 0) {
                    this.upstream.dispose();
                }
            }
        }

        public void disposeBoundary() {
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier.WindowBoundaryInnerObserver<T, B>> atomicReference = this.boundaryObserver;
            io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier.WindowBoundaryInnerObserver<java.lang.Object, java.lang.Object> windowBoundaryInnerObserver = BOUNDARY_DISPOSED;
            io.reactivex.disposables.Disposable disposable = (io.reactivex.disposables.Disposable) atomicReference.getAndSet(windowBoundaryInnerObserver);
            if (disposable == null || disposable == windowBoundaryInnerObserver) {
                return;
            }
            disposable.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.Observer<? super io.reactivex.Observable<T>> observer = this.downstream;
            io.reactivex.internal.queue.MpscLinkedQueue<java.lang.Object> mpscLinkedQueue = this.queue;
            io.reactivex.internal.util.AtomicThrowable atomicThrowable = this.errors;
            int i = 1;
            while (this.windows.get() != 0) {
                io.reactivex.subjects.UnicastSubject<T> unicastSubject = this.window;
                boolean z = this.done;
                if (z && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    java.lang.Throwable terminate = atomicThrowable.terminate();
                    if (unicastSubject != 0) {
                        this.window = null;
                        unicastSubject.onError(terminate);
                    }
                    observer.onError(terminate);
                    return;
                }
                java.lang.Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    java.lang.Throwable terminate2 = atomicThrowable.terminate();
                    if (terminate2 == null) {
                        if (unicastSubject != 0) {
                            this.window = null;
                            unicastSubject.onComplete();
                        }
                        observer.onComplete();
                        return;
                    }
                    if (unicastSubject != 0) {
                        this.window = null;
                        unicastSubject.onError(terminate2);
                    }
                    observer.onError(terminate2);
                    return;
                }
                if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (poll != NEXT_WINDOW) {
                    unicastSubject.onNext(poll);
                } else {
                    if (unicastSubject != 0) {
                        this.window = null;
                        unicastSubject.onComplete();
                    }
                    if (!this.stopWindows.get()) {
                        io.reactivex.subjects.UnicastSubject<T> create = io.reactivex.subjects.UnicastSubject.create(this.capacityHint, this);
                        this.window = create;
                        this.windows.getAndIncrement();
                        try {
                            io.reactivex.ObservableSource observableSource = (io.reactivex.ObservableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.other.call(), "The other Callable returned a null ObservableSource");
                            io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier.WindowBoundaryInnerObserver windowBoundaryInnerObserver = new io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier.WindowBoundaryInnerObserver(this);
                            if (defpackage.xv0.a(this.boundaryObserver, null, windowBoundaryInnerObserver)) {
                                observableSource.subscribe(windowBoundaryInnerObserver);
                                observer.onNext(create);
                            }
                        } catch (java.lang.Throwable th) {
                            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                            atomicThrowable.addThrowable(th);
                            this.done = true;
                        }
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.window = null;
        }

        public void innerComplete() {
            this.upstream.dispose();
            this.done = true;
            drain();
        }

        public void innerError(java.lang.Throwable th) {
            this.upstream.dispose();
            if (!this.errors.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                drain();
            }
        }

        public void innerNext(io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier.WindowBoundaryInnerObserver<T, B> windowBoundaryInnerObserver) {
            defpackage.xv0.a(this.boundaryObserver, windowBoundaryInnerObserver, null);
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.stopWindows.get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            disposeBoundary();
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            disposeBoundary();
            if (!this.errors.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
                this.queue.offer(NEXT_WINDOW);
                drain();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }
    }

    public ObservableWindowBoundarySupplier(io.reactivex.ObservableSource<T> observableSource, java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<B>> callable, int i) {
        super(observableSource);
        this.n = callable;
        this.t = i;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super io.reactivex.Observable<T>> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier.WindowBoundaryMainObserver(observer, this.t, this.n));
    }
}
