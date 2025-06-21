package io.reactivex.subjects;

/* loaded from: classes14.dex */
public final class UnicastSubject<T> extends io.reactivex.subjects.Subject<T> {
    public final io.reactivex.internal.observers.BasicIntQueueDisposable<T> A;
    public boolean B;
    public final io.reactivex.internal.queue.SpscLinkedArrayQueue<T> n;
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.Observer<? super T>> t;
    public final java.util.concurrent.atomic.AtomicReference<java.lang.Runnable> u;
    public final boolean v;
    public volatile boolean w;
    public volatile boolean x;
    public java.lang.Throwable y;
    public final java.util.concurrent.atomic.AtomicBoolean z;

    public final class UnicastQueueDisposable extends io.reactivex.internal.observers.BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        public UnicastQueueDisposable() {
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            io.reactivex.subjects.UnicastSubject.this.n.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (io.reactivex.subjects.UnicastSubject.this.w) {
                return;
            }
            io.reactivex.subjects.UnicastSubject.this.w = true;
            io.reactivex.subjects.UnicastSubject.this.d();
            io.reactivex.subjects.UnicastSubject.this.t.lazySet(null);
            if (io.reactivex.subjects.UnicastSubject.this.A.getAndIncrement() == 0) {
                io.reactivex.subjects.UnicastSubject.this.t.lazySet(null);
                io.reactivex.subjects.UnicastSubject unicastSubject = io.reactivex.subjects.UnicastSubject.this;
                if (unicastSubject.B) {
                    return;
                }
                unicastSubject.n.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.subjects.UnicastSubject.this.w;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return io.reactivex.subjects.UnicastSubject.this.n.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public T poll() throws java.lang.Exception {
            return io.reactivex.subjects.UnicastSubject.this.n.poll();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            io.reactivex.subjects.UnicastSubject.this.B = true;
            return 2;
        }
    }

    public UnicastSubject(int i, java.lang.Runnable runnable, boolean z) {
        this.n = new io.reactivex.internal.queue.SpscLinkedArrayQueue<>(io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "capacityHint"));
        this.u = new java.util.concurrent.atomic.AtomicReference<>(io.reactivex.internal.functions.ObjectHelper.requireNonNull(runnable, "onTerminate"));
        this.v = z;
        this.t = new java.util.concurrent.atomic.AtomicReference<>();
        this.z = new java.util.concurrent.atomic.AtomicBoolean();
        this.A = new io.reactivex.subjects.UnicastSubject.UnicastQueueDisposable();
    }

    public UnicastSubject(int i, boolean z) {
        this.n = new io.reactivex.internal.queue.SpscLinkedArrayQueue<>(io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "capacityHint"));
        this.u = new java.util.concurrent.atomic.AtomicReference<>();
        this.v = z;
        this.t = new java.util.concurrent.atomic.AtomicReference<>();
        this.z = new java.util.concurrent.atomic.AtomicBoolean();
        this.A = new io.reactivex.subjects.UnicastSubject.UnicastQueueDisposable();
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.subjects.UnicastSubject<T> create() {
        return new io.reactivex.subjects.UnicastSubject<>(io.reactivex.Observable.bufferSize(), true);
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.subjects.UnicastSubject<T> create(int i) {
        return new io.reactivex.subjects.UnicastSubject<>(i, true);
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.subjects.UnicastSubject<T> create(int i, java.lang.Runnable runnable) {
        return new io.reactivex.subjects.UnicastSubject<>(i, runnable, true);
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.subjects.UnicastSubject<T> create(int i, java.lang.Runnable runnable, boolean z) {
        return new io.reactivex.subjects.UnicastSubject<>(i, runnable, z);
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.subjects.UnicastSubject<T> create(boolean z) {
        return new io.reactivex.subjects.UnicastSubject<>(io.reactivex.Observable.bufferSize(), z);
    }

    public void d() {
        java.lang.Runnable runnable = this.u.get();
        if (runnable == null || !defpackage.xv0.a(this.u, runnable, null)) {
            return;
        }
        runnable.run();
    }

    public void e() {
        if (this.A.getAndIncrement() != 0) {
            return;
        }
        io.reactivex.Observer<? super T> observer = this.t.get();
        int i = 1;
        while (observer == null) {
            i = this.A.addAndGet(-i);
            if (i == 0) {
                return;
            } else {
                observer = this.t.get();
            }
        }
        if (this.B) {
            f(observer);
        } else {
            g(observer);
        }
    }

    public void f(io.reactivex.Observer<? super T> observer) {
        io.reactivex.internal.queue.SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.n;
        int i = 1;
        boolean z = !this.v;
        while (!this.w) {
            boolean z2 = this.x;
            if (z && z2 && i(spscLinkedArrayQueue, observer)) {
                return;
            }
            observer.onNext(null);
            if (z2) {
                h(observer);
                return;
            } else {
                i = this.A.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
        this.t.lazySet(null);
    }

    public void g(io.reactivex.Observer<? super T> observer) {
        io.reactivex.internal.queue.SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.n;
        boolean z = !this.v;
        boolean z2 = true;
        int i = 1;
        while (!this.w) {
            boolean z3 = this.x;
            T poll = this.n.poll();
            boolean z4 = poll == null;
            if (z3) {
                if (z && z2) {
                    if (i(spscLinkedArrayQueue, observer)) {
                        return;
                    } else {
                        z2 = false;
                    }
                }
                if (z4) {
                    h(observer);
                    return;
                }
            }
            if (z4) {
                i = this.A.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                observer.onNext(poll);
            }
        }
        this.t.lazySet(null);
        spscLinkedArrayQueue.clear();
    }

    @Override // io.reactivex.subjects.Subject
    @io.reactivex.annotations.Nullable
    public java.lang.Throwable getThrowable() {
        if (this.x) {
            return this.y;
        }
        return null;
    }

    public void h(io.reactivex.Observer<? super T> observer) {
        this.t.lazySet(null);
        java.lang.Throwable th = this.y;
        if (th != null) {
            observer.onError(th);
        } else {
            observer.onComplete();
        }
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return this.x && this.y == null;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        return this.t.get() != null;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return this.x && this.y != null;
    }

    public boolean i(io.reactivex.internal.fuseable.SimpleQueue<T> simpleQueue, io.reactivex.Observer<? super T> observer) {
        java.lang.Throwable th = this.y;
        if (th == null) {
            return false;
        }
        this.t.lazySet(null);
        simpleQueue.clear();
        observer.onError(th);
        return true;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.x || this.w) {
            return;
        }
        this.x = true;
        d();
        e();
    }

    @Override // io.reactivex.Observer
    public void onError(java.lang.Throwable th) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.x || this.w) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            return;
        }
        this.y = th;
        this.x = true;
        d();
        e();
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.x || this.w) {
            return;
        }
        this.n.offer(t);
        e();
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
        if (this.x || this.w) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        if (this.z.get() || !this.z.compareAndSet(false, true)) {
            io.reactivex.internal.disposables.EmptyDisposable.error(new java.lang.IllegalStateException("Only a single observer allowed."), observer);
            return;
        }
        observer.onSubscribe(this.A);
        this.t.lazySet(observer);
        if (this.w) {
            this.t.lazySet(null);
        } else {
            e();
        }
    }
}
