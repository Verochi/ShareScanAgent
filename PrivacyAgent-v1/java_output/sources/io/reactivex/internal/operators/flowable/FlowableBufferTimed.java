package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableBufferTimed<T, U extends java.util.Collection<? super T>> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, U> {
    public final long t;
    public final long u;
    public final java.util.concurrent.TimeUnit v;
    public final io.reactivex.Scheduler w;
    public final java.util.concurrent.Callable<U> x;
    public final int y;
    public final boolean z;

    public static final class BufferExactBoundedSubscriber<T, U extends java.util.Collection<? super T>> extends io.reactivex.internal.subscribers.QueueDrainSubscriber<T, U, U> implements org.reactivestreams.Subscription, java.lang.Runnable, io.reactivex.disposables.Disposable {
        public U A;
        public io.reactivex.disposables.Disposable B;
        public org.reactivestreams.Subscription C;
        public long D;
        public long E;
        public final java.util.concurrent.Callable<U> u;
        public final long v;
        public final java.util.concurrent.TimeUnit w;
        public final int x;
        public final boolean y;
        public final io.reactivex.Scheduler.Worker z;

        public BufferExactBoundedSubscriber(org.reactivestreams.Subscriber<? super U> subscriber, java.util.concurrent.Callable<U> callable, long j, java.util.concurrent.TimeUnit timeUnit, int i, boolean z, io.reactivex.Scheduler.Worker worker) {
            super(subscriber, new io.reactivex.internal.queue.MpscLinkedQueue());
            this.u = callable;
            this.v = j;
            this.w = timeUnit;
            this.x = i;
            this.y = z;
            this.z = worker;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean accept(org.reactivestreams.Subscriber<? super U> subscriber, U u) {
            subscriber.onNext(u);
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            synchronized (this) {
                this.A = null;
            }
            this.C.cancel();
            this.z.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.z.isDisposed();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.A;
                this.A = null;
            }
            if (u != null) {
                this.queue.offer(u);
                this.done = true;
                if (enter()) {
                    io.reactivex.internal.util.QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this, this);
                }
                this.z.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            synchronized (this) {
                this.A = null;
            }
            this.downstream.onError(th);
            this.z.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                U u = this.A;
                if (u == null) {
                    return;
                }
                u.add(t);
                if (u.size() < this.x) {
                    return;
                }
                this.A = null;
                this.D++;
                if (this.y) {
                    this.B.dispose();
                }
                fastPathOrderedEmitMax(u, false, this);
                try {
                    U u2 = (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.u.call(), "The supplied buffer is null");
                    synchronized (this) {
                        this.A = u2;
                        this.E++;
                    }
                    if (this.y) {
                        io.reactivex.Scheduler.Worker worker = this.z;
                        long j = this.v;
                        this.B = worker.schedulePeriodically(this, j, j, this.w);
                    }
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    cancel();
                    this.downstream.onError(th);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.C, subscription)) {
                this.C = subscription;
                try {
                    this.A = (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.u.call(), "The supplied buffer is null");
                    this.downstream.onSubscribe(this);
                    io.reactivex.Scheduler.Worker worker = this.z;
                    long j = this.v;
                    this.B = worker.schedulePeriodically(this, j, j, this.w);
                    subscription.request(Long.MAX_VALUE);
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    this.z.dispose();
                    subscription.cancel();
                    io.reactivex.internal.subscriptions.EmptySubscription.error(th, this.downstream);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.u.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u2 = this.A;
                    if (u2 != null && this.D == this.E) {
                        this.A = u;
                        fastPathOrderedEmitMax(u2, false, this);
                    }
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                cancel();
                this.downstream.onError(th);
            }
        }
    }

    public static final class BufferExactUnboundedSubscriber<T, U extends java.util.Collection<? super T>> extends io.reactivex.internal.subscribers.QueueDrainSubscriber<T, U, U> implements org.reactivestreams.Subscription, java.lang.Runnable, io.reactivex.disposables.Disposable {
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> A;
        public final java.util.concurrent.Callable<U> u;
        public final long v;
        public final java.util.concurrent.TimeUnit w;
        public final io.reactivex.Scheduler x;
        public org.reactivestreams.Subscription y;
        public U z;

        public BufferExactUnboundedSubscriber(org.reactivestreams.Subscriber<? super U> subscriber, java.util.concurrent.Callable<U> callable, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
            super(subscriber, new io.reactivex.internal.queue.MpscLinkedQueue());
            this.A = new java.util.concurrent.atomic.AtomicReference<>();
            this.u = callable;
            this.v = j;
            this.w = timeUnit;
            this.x = scheduler;
        }

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean accept(org.reactivestreams.Subscriber<? super U> subscriber, U u) {
            this.downstream.onNext(u);
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.y.cancel();
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.A);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.A.get() == io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.A);
            synchronized (this) {
                U u = this.z;
                if (u == null) {
                    return;
                }
                this.z = null;
                this.queue.offer(u);
                this.done = true;
                if (enter()) {
                    io.reactivex.internal.util.QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, null, this);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.A);
            synchronized (this) {
                this.z = null;
            }
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                U u = this.z;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.y, subscription)) {
                this.y = subscription;
                try {
                    this.z = (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.u.call(), "The supplied buffer is null");
                    this.downstream.onSubscribe(this);
                    if (this.cancelled) {
                        return;
                    }
                    subscription.request(Long.MAX_VALUE);
                    io.reactivex.Scheduler scheduler = this.x;
                    long j = this.v;
                    io.reactivex.disposables.Disposable schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(this, j, j, this.w);
                    if (defpackage.xv0.a(this.A, null, schedulePeriodicallyDirect)) {
                        return;
                    }
                    schedulePeriodicallyDirect.dispose();
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    cancel();
                    io.reactivex.internal.subscriptions.EmptySubscription.error(th, this.downstream);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.u.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u2 = this.z;
                    if (u2 == null) {
                        return;
                    }
                    this.z = u;
                    fastPathEmitMax(u2, false, this);
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                cancel();
                this.downstream.onError(th);
            }
        }
    }

    public static final class BufferSkipBoundedSubscriber<T, U extends java.util.Collection<? super T>> extends io.reactivex.internal.subscribers.QueueDrainSubscriber<T, U, U> implements org.reactivestreams.Subscription, java.lang.Runnable {
        public org.reactivestreams.Subscription A;
        public final java.util.concurrent.Callable<U> u;
        public final long v;
        public final long w;
        public final java.util.concurrent.TimeUnit x;
        public final io.reactivex.Scheduler.Worker y;
        public final java.util.List<U> z;

        public final class RemoveFromBuffer implements java.lang.Runnable {
            public final U n;

            public RemoveFromBuffer(U u) {
                this.n = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferSkipBoundedSubscriber.this) {
                    io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferSkipBoundedSubscriber.this.z.remove(this.n);
                }
                io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferSkipBoundedSubscriber bufferSkipBoundedSubscriber = io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferSkipBoundedSubscriber.this;
                bufferSkipBoundedSubscriber.fastPathOrderedEmitMax(this.n, false, bufferSkipBoundedSubscriber.y);
            }
        }

        public BufferSkipBoundedSubscriber(org.reactivestreams.Subscriber<? super U> subscriber, java.util.concurrent.Callable<U> callable, long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler.Worker worker) {
            super(subscriber, new io.reactivex.internal.queue.MpscLinkedQueue());
            this.u = callable;
            this.v = j;
            this.w = j2;
            this.x = timeUnit;
            this.y = worker;
            this.z = new java.util.LinkedList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean accept(org.reactivestreams.Subscriber<? super U> subscriber, U u) {
            subscriber.onNext(u);
            return true;
        }

        public void c() {
            synchronized (this) {
                this.z.clear();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.A.cancel();
            this.y.dispose();
            c();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            java.util.ArrayList arrayList;
            synchronized (this) {
                arrayList = new java.util.ArrayList(this.z);
                this.z.clear();
            }
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.queue.offer((java.util.Collection) it.next());
            }
            this.done = true;
            if (enter()) {
                io.reactivex.internal.util.QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this.y, this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.done = true;
            this.y.dispose();
            c();
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                java.util.Iterator<U> it = this.z.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.A, subscription)) {
                this.A = subscription;
                try {
                    java.util.Collection collection = (java.util.Collection) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.u.call(), "The supplied buffer is null");
                    this.z.add(collection);
                    this.downstream.onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    io.reactivex.Scheduler.Worker worker = this.y;
                    long j = this.w;
                    worker.schedulePeriodically(this, j, j, this.x);
                    this.y.schedule(new io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferSkipBoundedSubscriber.RemoveFromBuffer(collection), this.v, this.x);
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    this.y.dispose();
                    subscription.cancel();
                    io.reactivex.internal.subscriptions.EmptySubscription.error(th, this.downstream);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                return;
            }
            try {
                java.util.Collection collection = (java.util.Collection) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.u.call(), "The supplied buffer is null");
                synchronized (this) {
                    if (this.cancelled) {
                        return;
                    }
                    this.z.add(collection);
                    this.y.schedule(new io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferSkipBoundedSubscriber.RemoveFromBuffer(collection), this.v, this.x);
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                cancel();
                this.downstream.onError(th);
            }
        }
    }

    public FlowableBufferTimed(io.reactivex.Flowable<T> flowable, long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, java.util.concurrent.Callable<U> callable, int i, boolean z) {
        super(flowable);
        this.t = j;
        this.u = j2;
        this.v = timeUnit;
        this.w = scheduler;
        this.x = callable;
        this.y = i;
        this.z = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super U> subscriber) {
        if (this.t == this.u && this.y == Integer.MAX_VALUE) {
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferExactUnboundedSubscriber(new io.reactivex.subscribers.SerializedSubscriber(subscriber), this.x, this.t, this.v, this.w));
            return;
        }
        io.reactivex.Scheduler.Worker createWorker = this.w.createWorker();
        if (this.t == this.u) {
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferExactBoundedSubscriber(new io.reactivex.subscribers.SerializedSubscriber(subscriber), this.x, this.t, this.v, this.y, this.z, createWorker));
        } else {
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferSkipBoundedSubscriber(new io.reactivex.subscribers.SerializedSubscriber(subscriber), this.x, this.t, this.u, this.v, createWorker));
        }
    }
}
