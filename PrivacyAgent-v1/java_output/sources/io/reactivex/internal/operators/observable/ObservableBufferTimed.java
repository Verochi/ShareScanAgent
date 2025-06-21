package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableBufferTimed<T, U extends java.util.Collection<? super T>> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, U> {
    public final long n;
    public final long t;
    public final java.util.concurrent.TimeUnit u;
    public final io.reactivex.Scheduler v;
    public final java.util.concurrent.Callable<U> w;
    public final int x;
    public final boolean y;

    public static final class BufferExactBoundedObserver<T, U extends java.util.Collection<? super T>> extends io.reactivex.internal.observers.QueueDrainObserver<T, U, U> implements java.lang.Runnable, io.reactivex.disposables.Disposable {
        public io.reactivex.disposables.Disposable A;
        public io.reactivex.disposables.Disposable B;
        public long C;
        public long D;
        public final java.util.concurrent.Callable<U> t;
        public final long u;
        public final java.util.concurrent.TimeUnit v;
        public final int w;
        public final boolean x;
        public final io.reactivex.Scheduler.Worker y;
        public U z;

        public BufferExactBoundedObserver(io.reactivex.Observer<? super U> observer, java.util.concurrent.Callable<U> callable, long j, java.util.concurrent.TimeUnit timeUnit, int i, boolean z, io.reactivex.Scheduler.Worker worker) {
            super(observer, new io.reactivex.internal.queue.MpscLinkedQueue());
            this.t = callable;
            this.u = j;
            this.v = timeUnit;
            this.w = i;
            this.x = z;
            this.y = worker;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(io.reactivex.Observer<? super U> observer, U u) {
            observer.onNext(u);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.B.dispose();
            this.y.dispose();
            synchronized (this) {
                this.z = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u;
            this.y.dispose();
            synchronized (this) {
                u = this.z;
                this.z = null;
            }
            if (u != null) {
                this.queue.offer(u);
                this.done = true;
                if (enter()) {
                    io.reactivex.internal.util.QueueDrainHelper.drainLoop(this.queue, this.downstream, false, this, this);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            synchronized (this) {
                this.z = null;
            }
            this.downstream.onError(th);
            this.y.dispose();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            synchronized (this) {
                U u = this.z;
                if (u == null) {
                    return;
                }
                u.add(t);
                if (u.size() < this.w) {
                    return;
                }
                this.z = null;
                this.C++;
                if (this.x) {
                    this.A.dispose();
                }
                fastPathOrderedEmit(u, false, this);
                try {
                    U u2 = (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The buffer supplied is null");
                    synchronized (this) {
                        this.z = u2;
                        this.D++;
                    }
                    if (this.x) {
                        io.reactivex.Scheduler.Worker worker = this.y;
                        long j = this.u;
                        this.A = worker.schedulePeriodically(this, j, j, this.v);
                    }
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    this.downstream.onError(th);
                    dispose();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.B, disposable)) {
                this.B = disposable;
                try {
                    this.z = (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The buffer supplied is null");
                    this.downstream.onSubscribe(this);
                    io.reactivex.Scheduler.Worker worker = this.y;
                    long j = this.u;
                    this.A = worker.schedulePeriodically(this, j, j, this.v);
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    disposable.dispose();
                    io.reactivex.internal.disposables.EmptyDisposable.error(th, this.downstream);
                    this.y.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    U u2 = this.z;
                    if (u2 != null && this.C == this.D) {
                        this.z = u;
                        fastPathOrderedEmit(u2, false, this);
                    }
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                dispose();
                this.downstream.onError(th);
            }
        }
    }

    public static final class BufferExactUnboundedObserver<T, U extends java.util.Collection<? super T>> extends io.reactivex.internal.observers.QueueDrainObserver<T, U, U> implements java.lang.Runnable, io.reactivex.disposables.Disposable {
        public final java.util.concurrent.Callable<U> t;
        public final long u;
        public final java.util.concurrent.TimeUnit v;
        public final io.reactivex.Scheduler w;
        public io.reactivex.disposables.Disposable x;
        public U y;
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> z;

        public BufferExactUnboundedObserver(io.reactivex.Observer<? super U> observer, java.util.concurrent.Callable<U> callable, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
            super(observer, new io.reactivex.internal.queue.MpscLinkedQueue());
            this.z = new java.util.concurrent.atomic.AtomicReference<>();
            this.t = callable;
            this.u = j;
            this.v = timeUnit;
            this.w = scheduler;
        }

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(io.reactivex.Observer<? super U> observer, U u) {
            this.downstream.onNext(u);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.z);
            this.x.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.z.get() == io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.y;
                this.y = null;
            }
            if (u != null) {
                this.queue.offer(u);
                this.done = true;
                if (enter()) {
                    io.reactivex.internal.util.QueueDrainHelper.drainLoop(this.queue, this.downstream, false, null, this);
                }
            }
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.z);
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            synchronized (this) {
                this.y = null;
            }
            this.downstream.onError(th);
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.z);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            synchronized (this) {
                U u = this.y;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.x, disposable)) {
                this.x = disposable;
                try {
                    this.y = (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The buffer supplied is null");
                    this.downstream.onSubscribe(this);
                    if (this.cancelled) {
                        return;
                    }
                    io.reactivex.Scheduler scheduler = this.w;
                    long j = this.u;
                    io.reactivex.disposables.Disposable schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(this, j, j, this.v);
                    if (defpackage.xv0.a(this.z, null, schedulePeriodicallyDirect)) {
                        return;
                    }
                    schedulePeriodicallyDirect.dispose();
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    dispose();
                    io.reactivex.internal.disposables.EmptyDisposable.error(th, this.downstream);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            U u;
            try {
                U u2 = (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    u = this.y;
                    if (u != null) {
                        this.y = u2;
                    }
                }
                if (u == null) {
                    io.reactivex.internal.disposables.DisposableHelper.dispose(this.z);
                } else {
                    fastPathEmit(u, false, this);
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
                dispose();
            }
        }
    }

    public static final class BufferSkipBoundedObserver<T, U extends java.util.Collection<? super T>> extends io.reactivex.internal.observers.QueueDrainObserver<T, U, U> implements java.lang.Runnable, io.reactivex.disposables.Disposable {
        public final java.util.concurrent.Callable<U> t;
        public final long u;
        public final long v;
        public final java.util.concurrent.TimeUnit w;
        public final io.reactivex.Scheduler.Worker x;
        public final java.util.List<U> y;
        public io.reactivex.disposables.Disposable z;

        public final class RemoveFromBuffer implements java.lang.Runnable {
            public final U n;

            public RemoveFromBuffer(U u) {
                this.n = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferSkipBoundedObserver.this) {
                    io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferSkipBoundedObserver.this.y.remove(this.n);
                }
                io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferSkipBoundedObserver bufferSkipBoundedObserver = io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferSkipBoundedObserver.this;
                bufferSkipBoundedObserver.fastPathOrderedEmit(this.n, false, bufferSkipBoundedObserver.x);
            }
        }

        public final class RemoveFromBufferEmit implements java.lang.Runnable {
            public final U n;

            public RemoveFromBufferEmit(U u) {
                this.n = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferSkipBoundedObserver.this) {
                    io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferSkipBoundedObserver.this.y.remove(this.n);
                }
                io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferSkipBoundedObserver bufferSkipBoundedObserver = io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferSkipBoundedObserver.this;
                bufferSkipBoundedObserver.fastPathOrderedEmit(this.n, false, bufferSkipBoundedObserver.x);
            }
        }

        public BufferSkipBoundedObserver(io.reactivex.Observer<? super U> observer, java.util.concurrent.Callable<U> callable, long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler.Worker worker) {
            super(observer, new io.reactivex.internal.queue.MpscLinkedQueue());
            this.t = callable;
            this.u = j;
            this.v = j2;
            this.w = timeUnit;
            this.x = worker;
            this.y = new java.util.LinkedList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(io.reactivex.Observer<? super U> observer, U u) {
            observer.onNext(u);
        }

        public void d() {
            synchronized (this) {
                this.y.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            d();
            this.z.dispose();
            this.x.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            java.util.ArrayList arrayList;
            synchronized (this) {
                arrayList = new java.util.ArrayList(this.y);
                this.y.clear();
            }
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.queue.offer((java.util.Collection) it.next());
            }
            this.done = true;
            if (enter()) {
                io.reactivex.internal.util.QueueDrainHelper.drainLoop(this.queue, this.downstream, false, this.x, this);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.done = true;
            d();
            this.downstream.onError(th);
            this.x.dispose();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            synchronized (this) {
                java.util.Iterator<U> it = this.y.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.z, disposable)) {
                this.z = disposable;
                try {
                    java.util.Collection collection = (java.util.Collection) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The buffer supplied is null");
                    this.y.add(collection);
                    this.downstream.onSubscribe(this);
                    io.reactivex.Scheduler.Worker worker = this.x;
                    long j = this.v;
                    worker.schedulePeriodically(this, j, j, this.w);
                    this.x.schedule(new io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferSkipBoundedObserver.RemoveFromBufferEmit(collection), this.u, this.w);
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    disposable.dispose();
                    io.reactivex.internal.disposables.EmptyDisposable.error(th, this.downstream);
                    this.x.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                return;
            }
            try {
                java.util.Collection collection = (java.util.Collection) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    if (this.cancelled) {
                        return;
                    }
                    this.y.add(collection);
                    this.x.schedule(new io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferSkipBoundedObserver.RemoveFromBuffer(collection), this.u, this.w);
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
                dispose();
            }
        }
    }

    public ObservableBufferTimed(io.reactivex.ObservableSource<T> observableSource, long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, java.util.concurrent.Callable<U> callable, int i, boolean z) {
        super(observableSource);
        this.n = j;
        this.t = j2;
        this.u = timeUnit;
        this.v = scheduler;
        this.w = callable;
        this.x = i;
        this.y = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super U> observer) {
        if (this.n == this.t && this.x == Integer.MAX_VALUE) {
            this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferExactUnboundedObserver(new io.reactivex.observers.SerializedObserver(observer), this.w, this.n, this.u, this.v));
            return;
        }
        io.reactivex.Scheduler.Worker createWorker = this.v.createWorker();
        if (this.n == this.t) {
            this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferExactBoundedObserver(new io.reactivex.observers.SerializedObserver(observer), this.w, this.n, this.u, this.x, this.y, createWorker));
        } else {
            this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferSkipBoundedObserver(new io.reactivex.observers.SerializedObserver(observer), this.w, this.n, this.t, this.u, createWorker));
        }
    }
}
