package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableWindowBoundarySelector<T, B, V> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, io.reactivex.Observable<T>> {
    public final io.reactivex.ObservableSource<B> n;
    public final io.reactivex.functions.Function<? super B, ? extends io.reactivex.ObservableSource<V>> t;
    public final int u;

    public static final class OperatorWindowBoundaryCloseObserver<T, V> extends io.reactivex.observers.DisposableObserver<V> {
        public final io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector.WindowBoundaryMainObserver<T, ?, V> t;
        public final io.reactivex.subjects.UnicastSubject<T> u;
        public boolean v;

        public OperatorWindowBoundaryCloseObserver(io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector.WindowBoundaryMainObserver<T, ?, V> windowBoundaryMainObserver, io.reactivex.subjects.UnicastSubject<T> unicastSubject) {
            this.t = windowBoundaryMainObserver;
            this.u = unicastSubject;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.v) {
                return;
            }
            this.v = true;
            this.t.a(this);
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.v) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.v = true;
                this.t.d(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(V v) {
            dispose();
            onComplete();
        }
    }

    public static final class OperatorWindowBoundaryOpenObserver<T, B> extends io.reactivex.observers.DisposableObserver<B> {
        public final io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector.WindowBoundaryMainObserver<T, B, ?> t;

        public OperatorWindowBoundaryOpenObserver(io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector.WindowBoundaryMainObserver<T, B, ?> windowBoundaryMainObserver) {
            this.t = windowBoundaryMainObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.t.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.t.d(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(B b) {
            this.t.e(b);
        }
    }

    public static final class WindowBoundaryMainObserver<T, B, V> extends io.reactivex.internal.observers.QueueDrainObserver<T, java.lang.Object, io.reactivex.Observable<T>> implements io.reactivex.disposables.Disposable {
        public final java.util.concurrent.atomic.AtomicLong A;
        public final java.util.concurrent.atomic.AtomicBoolean B;
        public final io.reactivex.ObservableSource<B> t;
        public final io.reactivex.functions.Function<? super B, ? extends io.reactivex.ObservableSource<V>> u;
        public final int v;
        public final io.reactivex.disposables.CompositeDisposable w;
        public io.reactivex.disposables.Disposable x;
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> y;
        public final java.util.List<io.reactivex.subjects.UnicastSubject<T>> z;

        public WindowBoundaryMainObserver(io.reactivex.Observer<? super io.reactivex.Observable<T>> observer, io.reactivex.ObservableSource<B> observableSource, io.reactivex.functions.Function<? super B, ? extends io.reactivex.ObservableSource<V>> function, int i) {
            super(observer, new io.reactivex.internal.queue.MpscLinkedQueue());
            this.y = new java.util.concurrent.atomic.AtomicReference<>();
            java.util.concurrent.atomic.AtomicLong atomicLong = new java.util.concurrent.atomic.AtomicLong();
            this.A = atomicLong;
            this.B = new java.util.concurrent.atomic.AtomicBoolean();
            this.t = observableSource;
            this.u = function;
            this.v = i;
            this.w = new io.reactivex.disposables.CompositeDisposable();
            this.z = new java.util.ArrayList();
            atomicLong.lazySet(1L);
        }

        public void a(io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector.OperatorWindowBoundaryCloseObserver<T, V> operatorWindowBoundaryCloseObserver) {
            this.w.delete(operatorWindowBoundaryCloseObserver);
            this.queue.offer(new io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector.WindowOperation(operatorWindowBoundaryCloseObserver.u, null));
            if (enter()) {
                c();
            }
        }

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public void accept(io.reactivex.Observer<? super io.reactivex.Observable<T>> observer, java.lang.Object obj) {
        }

        public void b() {
            this.w.dispose();
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.y);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void c() {
            io.reactivex.internal.queue.MpscLinkedQueue mpscLinkedQueue = (io.reactivex.internal.queue.MpscLinkedQueue) this.queue;
            io.reactivex.Observer<? super V> observer = this.downstream;
            java.util.List<io.reactivex.subjects.UnicastSubject<T>> list = this.z;
            int i = 1;
            while (true) {
                boolean z = this.done;
                java.lang.Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    b();
                    java.lang.Throwable th = this.error;
                    if (th != null) {
                        java.util.Iterator<io.reactivex.subjects.UnicastSubject<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        java.util.Iterator<io.reactivex.subjects.UnicastSubject<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    return;
                }
                if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (poll instanceof io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector.WindowOperation) {
                    io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector.WindowOperation windowOperation = (io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector.WindowOperation) poll;
                    io.reactivex.subjects.UnicastSubject<T> unicastSubject = windowOperation.a;
                    if (unicastSubject != null) {
                        if (list.remove(unicastSubject)) {
                            windowOperation.a.onComplete();
                            if (this.A.decrementAndGet() == 0) {
                                b();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.B.get()) {
                        io.reactivex.subjects.UnicastSubject<T> create = io.reactivex.subjects.UnicastSubject.create(this.v);
                        list.add(create);
                        observer.onNext(create);
                        try {
                            io.reactivex.ObservableSource observableSource = (io.reactivex.ObservableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.u.apply(windowOperation.b), "The ObservableSource supplied is null");
                            io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector.OperatorWindowBoundaryCloseObserver operatorWindowBoundaryCloseObserver = new io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector.OperatorWindowBoundaryCloseObserver(this, create);
                            if (this.w.add(operatorWindowBoundaryCloseObserver)) {
                                this.A.getAndIncrement();
                                observableSource.subscribe(operatorWindowBoundaryCloseObserver);
                            }
                        } catch (java.lang.Throwable th2) {
                            io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                            this.B.set(true);
                            observer.onError(th2);
                        }
                    }
                } else {
                    java.util.Iterator<io.reactivex.subjects.UnicastSubject<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(io.reactivex.internal.util.NotificationLite.getValue(poll));
                    }
                }
            }
        }

        public void d(java.lang.Throwable th) {
            this.x.dispose();
            this.w.dispose();
            onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.B.compareAndSet(false, true)) {
                io.reactivex.internal.disposables.DisposableHelper.dispose(this.y);
                if (this.A.decrementAndGet() == 0) {
                    this.x.dispose();
                }
            }
        }

        public void e(B b) {
            this.queue.offer(new io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector.WindowOperation(null, b));
            if (enter()) {
                c();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.B.get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            if (enter()) {
                c();
            }
            if (this.A.decrementAndGet() == 0) {
                this.w.dispose();
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.done) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            if (enter()) {
                c();
            }
            if (this.A.decrementAndGet() == 0) {
                this.w.dispose();
            }
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (fastEnter()) {
                java.util.Iterator<io.reactivex.subjects.UnicastSubject<T>> it = this.z.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(io.reactivex.internal.util.NotificationLite.next(t));
                if (!enter()) {
                    return;
                }
            }
            c();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.x, disposable)) {
                this.x = disposable;
                this.downstream.onSubscribe(this);
                if (this.B.get()) {
                    return;
                }
                io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector.OperatorWindowBoundaryOpenObserver operatorWindowBoundaryOpenObserver = new io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector.OperatorWindowBoundaryOpenObserver(this);
                if (defpackage.xv0.a(this.y, null, operatorWindowBoundaryOpenObserver)) {
                    this.t.subscribe(operatorWindowBoundaryOpenObserver);
                }
            }
        }
    }

    public static final class WindowOperation<T, B> {
        public final io.reactivex.subjects.UnicastSubject<T> a;
        public final B b;

        public WindowOperation(io.reactivex.subjects.UnicastSubject<T> unicastSubject, B b) {
            this.a = unicastSubject;
            this.b = b;
        }
    }

    public ObservableWindowBoundarySelector(io.reactivex.ObservableSource<T> observableSource, io.reactivex.ObservableSource<B> observableSource2, io.reactivex.functions.Function<? super B, ? extends io.reactivex.ObservableSource<V>> function, int i) {
        super(observableSource);
        this.n = observableSource2;
        this.t = function;
        this.u = i;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super io.reactivex.Observable<T>> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector.WindowBoundaryMainObserver(new io.reactivex.observers.SerializedObserver(observer), this.n, this.t, this.u));
    }
}
