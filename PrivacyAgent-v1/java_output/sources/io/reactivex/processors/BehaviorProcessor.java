package io.reactivex.processors;

/* loaded from: classes13.dex */
public final class BehaviorProcessor<T> extends io.reactivex.processors.FlowableProcessor<T> {
    public static final java.lang.Object[] A = new java.lang.Object[0];
    public static final io.reactivex.processors.BehaviorProcessor.BehaviorSubscription[] B = new io.reactivex.processors.BehaviorProcessor.BehaviorSubscription[0];
    public static final io.reactivex.processors.BehaviorProcessor.BehaviorSubscription[] C = new io.reactivex.processors.BehaviorProcessor.BehaviorSubscription[0];
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.processors.BehaviorProcessor.BehaviorSubscription<T>[]> t;
    public final java.util.concurrent.locks.ReadWriteLock u;
    public final java.util.concurrent.locks.Lock v;
    public final java.util.concurrent.locks.Lock w;
    public final java.util.concurrent.atomic.AtomicReference<java.lang.Object> x;
    public final java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> y;
    public long z;

    public static final class BehaviorSubscription<T> extends java.util.concurrent.atomic.AtomicLong implements org.reactivestreams.Subscription, io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate<java.lang.Object> {
        private static final long serialVersionUID = 3293175281126227086L;
        volatile boolean cancelled;
        final org.reactivestreams.Subscriber<? super T> downstream;
        boolean emitting;
        boolean fastPath;
        long index;
        boolean next;
        io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> queue;
        final io.reactivex.processors.BehaviorProcessor<T> state;

        public BehaviorSubscription(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.processors.BehaviorProcessor<T> behaviorProcessor) {
            this.downstream = subscriber;
            this.state = behaviorProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.f(this);
        }

        public void emitFirst() {
            if (this.cancelled) {
                return;
            }
            synchronized (this) {
                if (this.cancelled) {
                    return;
                }
                if (this.next) {
                    return;
                }
                io.reactivex.processors.BehaviorProcessor<T> behaviorProcessor = this.state;
                java.util.concurrent.locks.Lock lock = behaviorProcessor.v;
                lock.lock();
                this.index = behaviorProcessor.z;
                java.lang.Object obj = behaviorProcessor.x.get();
                lock.unlock();
                this.emitting = obj != null;
                this.next = true;
                if (obj == null || test(obj)) {
                    return;
                }
                emitLoop();
            }
        }

        public void emitLoop() {
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> appendOnlyLinkedArrayList;
            while (!this.cancelled) {
                synchronized (this) {
                    appendOnlyLinkedArrayList = this.queue;
                    if (appendOnlyLinkedArrayList == null) {
                        this.emitting = false;
                        return;
                    }
                    this.queue = null;
                }
                appendOnlyLinkedArrayList.forEachWhile(this);
            }
        }

        public void emitNext(java.lang.Object obj, long j) {
            if (this.cancelled) {
                return;
            }
            if (!this.fastPath) {
                synchronized (this) {
                    if (this.cancelled) {
                        return;
                    }
                    if (this.index == j) {
                        return;
                    }
                    if (this.emitting) {
                        io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> appendOnlyLinkedArrayList = this.queue;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new io.reactivex.internal.util.AppendOnlyLinkedArrayList<>(4);
                            this.queue = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(obj);
                        return;
                    }
                    this.next = true;
                    this.fastPath = true;
                }
            }
            test(obj);
        }

        public boolean isFull() {
            return get() == 0;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.BackpressureHelper.add(this, j);
            }
        }

        @Override // io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
        public boolean test(java.lang.Object obj) {
            if (this.cancelled) {
                return true;
            }
            if (io.reactivex.internal.util.NotificationLite.isComplete(obj)) {
                this.downstream.onComplete();
                return true;
            }
            if (io.reactivex.internal.util.NotificationLite.isError(obj)) {
                this.downstream.onError(io.reactivex.internal.util.NotificationLite.getError(obj));
                return true;
            }
            long j = get();
            if (j == 0) {
                cancel();
                this.downstream.onError(new io.reactivex.exceptions.MissingBackpressureException("Could not deliver value due to lack of requests"));
                return true;
            }
            this.downstream.onNext((java.lang.Object) io.reactivex.internal.util.NotificationLite.getValue(obj));
            if (j == Long.MAX_VALUE) {
                return false;
            }
            decrementAndGet();
            return false;
        }
    }

    public BehaviorProcessor() {
        this.x = new java.util.concurrent.atomic.AtomicReference<>();
        java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
        this.u = reentrantReadWriteLock;
        this.v = reentrantReadWriteLock.readLock();
        this.w = reentrantReadWriteLock.writeLock();
        this.t = new java.util.concurrent.atomic.AtomicReference<>(B);
        this.y = new java.util.concurrent.atomic.AtomicReference<>();
    }

    public BehaviorProcessor(T t) {
        this();
        this.x.lazySet(io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "defaultValue is null"));
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.processors.BehaviorProcessor<T> create() {
        return new io.reactivex.processors.BehaviorProcessor<>();
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.processors.BehaviorProcessor<T> createDefault(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "defaultValue is null");
        return new io.reactivex.processors.BehaviorProcessor<>(t);
    }

    public boolean e(io.reactivex.processors.BehaviorProcessor.BehaviorSubscription<T> behaviorSubscription) {
        io.reactivex.processors.BehaviorProcessor.BehaviorSubscription<T>[] behaviorSubscriptionArr;
        io.reactivex.processors.BehaviorProcessor.BehaviorSubscription[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = this.t.get();
            if (behaviorSubscriptionArr == C) {
                return false;
            }
            int length = behaviorSubscriptionArr.length;
            behaviorSubscriptionArr2 = new io.reactivex.processors.BehaviorProcessor.BehaviorSubscription[length + 1];
            java.lang.System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr2, 0, length);
            behaviorSubscriptionArr2[length] = behaviorSubscription;
        } while (!defpackage.xv0.a(this.t, behaviorSubscriptionArr, behaviorSubscriptionArr2));
        return true;
    }

    public void f(io.reactivex.processors.BehaviorProcessor.BehaviorSubscription<T> behaviorSubscription) {
        io.reactivex.processors.BehaviorProcessor.BehaviorSubscription<T>[] behaviorSubscriptionArr;
        io.reactivex.processors.BehaviorProcessor.BehaviorSubscription[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = this.t.get();
            int length = behaviorSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (behaviorSubscriptionArr[i] == behaviorSubscription) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                behaviorSubscriptionArr2 = B;
            } else {
                io.reactivex.processors.BehaviorProcessor.BehaviorSubscription[] behaviorSubscriptionArr3 = new io.reactivex.processors.BehaviorProcessor.BehaviorSubscription[length - 1];
                java.lang.System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr3, 0, i);
                java.lang.System.arraycopy(behaviorSubscriptionArr, i + 1, behaviorSubscriptionArr3, i, (length - i) - 1);
                behaviorSubscriptionArr2 = behaviorSubscriptionArr3;
            }
        } while (!defpackage.xv0.a(this.t, behaviorSubscriptionArr, behaviorSubscriptionArr2));
    }

    public void g(java.lang.Object obj) {
        java.util.concurrent.locks.Lock lock = this.w;
        lock.lock();
        this.z++;
        this.x.lazySet(obj);
        lock.unlock();
    }

    @Override // io.reactivex.processors.FlowableProcessor
    @io.reactivex.annotations.Nullable
    public java.lang.Throwable getThrowable() {
        java.lang.Object obj = this.x.get();
        if (io.reactivex.internal.util.NotificationLite.isError(obj)) {
            return io.reactivex.internal.util.NotificationLite.getError(obj);
        }
        return null;
    }

    @io.reactivex.annotations.Nullable
    public T getValue() {
        java.lang.Object obj = this.x.get();
        if (io.reactivex.internal.util.NotificationLite.isComplete(obj) || io.reactivex.internal.util.NotificationLite.isError(obj)) {
            return null;
        }
        return (T) io.reactivex.internal.util.NotificationLite.getValue(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @java.lang.Deprecated
    public java.lang.Object[] getValues() {
        java.lang.Object[] objArr = A;
        java.lang.Object[] values = getValues(objArr);
        return values == objArr ? new java.lang.Object[0] : values;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @java.lang.Deprecated
    public T[] getValues(T[] tArr) {
        java.lang.Object obj = this.x.get();
        if (obj == null || io.reactivex.internal.util.NotificationLite.isComplete(obj) || io.reactivex.internal.util.NotificationLite.isError(obj)) {
            if (tArr.length != 0) {
                tArr[0] = 0;
            }
            return tArr;
        }
        java.lang.Object value = io.reactivex.internal.util.NotificationLite.getValue(obj);
        if (tArr.length == 0) {
            T[] tArr2 = (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), 1));
            tArr2[0] = value;
            return tArr2;
        }
        tArr[0] = value;
        if (tArr.length == 1) {
            return tArr;
        }
        tArr[1] = 0;
        return tArr;
    }

    public io.reactivex.processors.BehaviorProcessor.BehaviorSubscription<T>[] h(java.lang.Object obj) {
        io.reactivex.processors.BehaviorProcessor.BehaviorSubscription<T>[] behaviorSubscriptionArr = this.t.get();
        io.reactivex.processors.BehaviorProcessor.BehaviorSubscription<T>[] behaviorSubscriptionArr2 = C;
        if (behaviorSubscriptionArr != behaviorSubscriptionArr2 && (behaviorSubscriptionArr = this.t.getAndSet(behaviorSubscriptionArr2)) != behaviorSubscriptionArr2) {
            g(obj);
        }
        return behaviorSubscriptionArr;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return io.reactivex.internal.util.NotificationLite.isComplete(this.x.get());
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.t.get().length != 0;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return io.reactivex.internal.util.NotificationLite.isError(this.x.get());
    }

    public boolean hasValue() {
        java.lang.Object obj = this.x.get();
        return (obj == null || io.reactivex.internal.util.NotificationLite.isComplete(obj) || io.reactivex.internal.util.NotificationLite.isError(obj)) ? false : true;
    }

    public boolean offer(T t) {
        if (t == null) {
            onError(new java.lang.NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return true;
        }
        io.reactivex.processors.BehaviorProcessor.BehaviorSubscription<T>[] behaviorSubscriptionArr = this.t.get();
        for (io.reactivex.processors.BehaviorProcessor.BehaviorSubscription<T> behaviorSubscription : behaviorSubscriptionArr) {
            if (behaviorSubscription.isFull()) {
                return false;
            }
        }
        java.lang.Object next = io.reactivex.internal.util.NotificationLite.next(t);
        g(next);
        for (io.reactivex.processors.BehaviorProcessor.BehaviorSubscription<T> behaviorSubscription2 : behaviorSubscriptionArr) {
            behaviorSubscription2.emitNext(next, this.z);
        }
        return true;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (defpackage.xv0.a(this.y, null, io.reactivex.internal.util.ExceptionHelper.TERMINATED)) {
            java.lang.Object complete = io.reactivex.internal.util.NotificationLite.complete();
            for (io.reactivex.processors.BehaviorProcessor.BehaviorSubscription<T> behaviorSubscription : h(complete)) {
                behaviorSubscription.emitNext(complete, this.z);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(java.lang.Throwable th) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!defpackage.xv0.a(this.y, null, th)) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            return;
        }
        java.lang.Object error = io.reactivex.internal.util.NotificationLite.error(th);
        for (io.reactivex.processors.BehaviorProcessor.BehaviorSubscription<T> behaviorSubscription : h(error)) {
            behaviorSubscription.emitNext(error, this.z);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.y.get() != null) {
            return;
        }
        java.lang.Object next = io.reactivex.internal.util.NotificationLite.next(t);
        g(next);
        for (io.reactivex.processors.BehaviorProcessor.BehaviorSubscription<T> behaviorSubscription : this.t.get()) {
            behaviorSubscription.emitNext(next, this.z);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(org.reactivestreams.Subscription subscription) {
        if (this.y.get() != null) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.processors.BehaviorProcessor.BehaviorSubscription<T> behaviorSubscription = new io.reactivex.processors.BehaviorProcessor.BehaviorSubscription<>(subscriber, this);
        subscriber.onSubscribe(behaviorSubscription);
        if (e(behaviorSubscription)) {
            if (behaviorSubscription.cancelled) {
                f(behaviorSubscription);
                return;
            } else {
                behaviorSubscription.emitFirst();
                return;
            }
        }
        java.lang.Throwable th = this.y.get();
        if (th == io.reactivex.internal.util.ExceptionHelper.TERMINATED) {
            subscriber.onComplete();
        } else {
            subscriber.onError(th);
        }
    }
}
