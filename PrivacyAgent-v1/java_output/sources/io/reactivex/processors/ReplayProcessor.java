package io.reactivex.processors;

/* loaded from: classes13.dex */
public final class ReplayProcessor<T> extends io.reactivex.processors.FlowableProcessor<T> {
    public static final java.lang.Object[] w = new java.lang.Object[0];
    public static final io.reactivex.processors.ReplayProcessor.ReplaySubscription[] x = new io.reactivex.processors.ReplayProcessor.ReplaySubscription[0];
    public static final io.reactivex.processors.ReplayProcessor.ReplaySubscription[] y = new io.reactivex.processors.ReplayProcessor.ReplaySubscription[0];
    public final io.reactivex.processors.ReplayProcessor.ReplayBuffer<T> t;
    public boolean u;
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.processors.ReplayProcessor.ReplaySubscription<T>[]> v = new java.util.concurrent.atomic.AtomicReference<>(x);

    public static final class Node<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.processors.ReplayProcessor.Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        public Node(T t) {
            this.value = t;
        }
    }

    public interface ReplayBuffer<T> {
        void a(io.reactivex.processors.ReplayProcessor.ReplaySubscription<T> replaySubscription);

        void complete();

        void error(java.lang.Throwable th);

        java.lang.Throwable getError();

        @io.reactivex.annotations.Nullable
        T getValue();

        T[] getValues(T[] tArr);

        boolean isDone();

        void next(T t);

        int size();

        void trimHead();
    }

    public static final class ReplaySubscription<T> extends java.util.concurrent.atomic.AtomicInteger implements org.reactivestreams.Subscription {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final org.reactivestreams.Subscriber<? super T> downstream;
        long emitted;
        java.lang.Object index;
        final java.util.concurrent.atomic.AtomicLong requested = new java.util.concurrent.atomic.AtomicLong();
        final io.reactivex.processors.ReplayProcessor<T> state;

        public ReplaySubscription(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.processors.ReplayProcessor<T> replayProcessor) {
            this.downstream = subscriber;
            this.state = replayProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.f(this);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.BackpressureHelper.add(this.requested, j);
                this.state.t.a(this);
            }
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> implements io.reactivex.processors.ReplayProcessor.ReplayBuffer<T> {
        public final int a;
        public final long b;
        public final java.util.concurrent.TimeUnit c;
        public final io.reactivex.Scheduler d;
        public int e;
        public volatile io.reactivex.processors.ReplayProcessor.TimedNode<T> f;
        public io.reactivex.processors.ReplayProcessor.TimedNode<T> g;
        public java.lang.Throwable h;
        public volatile boolean i;

        public SizeAndTimeBoundReplayBuffer(int i, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
            this.a = io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxSize");
            this.b = io.reactivex.internal.functions.ObjectHelper.verifyPositive(j, "maxAge");
            this.c = (java.util.concurrent.TimeUnit) io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
            this.d = (io.reactivex.Scheduler) io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            io.reactivex.processors.ReplayProcessor.TimedNode<T> timedNode = new io.reactivex.processors.ReplayProcessor.TimedNode<>(null, 0L);
            this.g = timedNode;
            this.f = timedNode;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void a(io.reactivex.processors.ReplayProcessor.ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.getAndIncrement() != 0) {
                return;
            }
            org.reactivestreams.Subscriber<? super T> subscriber = replaySubscription.downstream;
            io.reactivex.processors.ReplayProcessor.TimedNode<T> timedNode = (io.reactivex.processors.ReplayProcessor.TimedNode) replaySubscription.index;
            if (timedNode == null) {
                timedNode = b();
            }
            long j = replaySubscription.emitted;
            int i = 1;
            do {
                long j2 = replaySubscription.requested.get();
                while (j != j2) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    boolean z = this.i;
                    io.reactivex.processors.ReplayProcessor.TimedNode<T> timedNode2 = timedNode.get();
                    boolean z2 = timedNode2 == null;
                    if (z && z2) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        java.lang.Throwable th = this.h;
                        if (th == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th);
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(timedNode2.value);
                    j++;
                    timedNode = timedNode2;
                }
                if (j == j2) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    if (this.i && timedNode.get() == null) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        java.lang.Throwable th2 = this.h;
                        if (th2 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                replaySubscription.index = timedNode;
                replaySubscription.emitted = j;
                i = replaySubscription.addAndGet(-i);
            } while (i != 0);
        }

        public io.reactivex.processors.ReplayProcessor.TimedNode<T> b() {
            io.reactivex.processors.ReplayProcessor.TimedNode<T> timedNode;
            io.reactivex.processors.ReplayProcessor.TimedNode<T> timedNode2 = this.f;
            long now = this.d.now(this.c) - this.b;
            io.reactivex.processors.ReplayProcessor.TimedNode<T> timedNode3 = timedNode2.get();
            while (true) {
                io.reactivex.processors.ReplayProcessor.TimedNode<T> timedNode4 = timedNode3;
                timedNode = timedNode2;
                timedNode2 = timedNode4;
                if (timedNode2 == null || timedNode2.time > now) {
                    break;
                }
                timedNode3 = timedNode2.get();
            }
            return timedNode;
        }

        public int c(io.reactivex.processors.ReplayProcessor.TimedNode<T> timedNode) {
            int i = 0;
            while (i != Integer.MAX_VALUE && (timedNode = timedNode.get()) != null) {
                i++;
            }
            return i;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            e();
            this.i = true;
        }

        public void d() {
            int i = this.e;
            if (i > this.a) {
                this.e = i - 1;
                this.f = this.f.get();
            }
            long now = this.d.now(this.c) - this.b;
            io.reactivex.processors.ReplayProcessor.TimedNode<T> timedNode = this.f;
            while (this.e > 1) {
                io.reactivex.processors.ReplayProcessor.TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    this.f = timedNode;
                    return;
                } else if (timedNode2.time > now) {
                    this.f = timedNode;
                    return;
                } else {
                    this.e--;
                    timedNode = timedNode2;
                }
            }
            this.f = timedNode;
        }

        public void e() {
            long now = this.d.now(this.c) - this.b;
            io.reactivex.processors.ReplayProcessor.TimedNode<T> timedNode = this.f;
            while (true) {
                io.reactivex.processors.ReplayProcessor.TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    if (timedNode.value != null) {
                        this.f = new io.reactivex.processors.ReplayProcessor.TimedNode<>(null, 0L);
                        return;
                    } else {
                        this.f = timedNode;
                        return;
                    }
                }
                if (timedNode2.time > now) {
                    if (timedNode.value == null) {
                        this.f = timedNode;
                        return;
                    }
                    io.reactivex.processors.ReplayProcessor.TimedNode<T> timedNode3 = new io.reactivex.processors.ReplayProcessor.TimedNode<>(null, 0L);
                    timedNode3.lazySet(timedNode.get());
                    this.f = timedNode3;
                    return;
                }
                timedNode = timedNode2;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void error(java.lang.Throwable th) {
            e();
            this.h = th;
            this.i = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public java.lang.Throwable getError() {
            return this.h;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        @io.reactivex.annotations.Nullable
        public T getValue() {
            io.reactivex.processors.ReplayProcessor.TimedNode<T> timedNode = this.f;
            while (true) {
                io.reactivex.processors.ReplayProcessor.TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    break;
                }
                timedNode = timedNode2;
            }
            if (timedNode.time < this.d.now(this.c) - this.b) {
                return null;
            }
            return timedNode.value;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] tArr) {
            io.reactivex.processors.ReplayProcessor.TimedNode<T> b = b();
            int c = c(b);
            if (c != 0) {
                if (tArr.length < c) {
                    tArr = (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), c));
                }
                for (int i = 0; i != c; i++) {
                    b = b.get();
                    tArr[i] = b.value;
                }
                if (tArr.length > c) {
                    tArr[c] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            return this.i;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void next(T t) {
            io.reactivex.processors.ReplayProcessor.TimedNode<T> timedNode = new io.reactivex.processors.ReplayProcessor.TimedNode<>(t, this.d.now(this.c));
            io.reactivex.processors.ReplayProcessor.TimedNode<T> timedNode2 = this.g;
            this.g = timedNode;
            this.e++;
            timedNode2.set(timedNode);
            d();
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            return c(b());
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
            if (this.f.value != null) {
                io.reactivex.processors.ReplayProcessor.TimedNode<T> timedNode = new io.reactivex.processors.ReplayProcessor.TimedNode<>(null, 0L);
                timedNode.lazySet(this.f.get());
                this.f = timedNode;
            }
        }
    }

    public static final class SizeBoundReplayBuffer<T> implements io.reactivex.processors.ReplayProcessor.ReplayBuffer<T> {
        public final int a;
        public int b;
        public volatile io.reactivex.processors.ReplayProcessor.Node<T> c;
        public io.reactivex.processors.ReplayProcessor.Node<T> d;
        public java.lang.Throwable e;
        public volatile boolean f;

        public SizeBoundReplayBuffer(int i) {
            this.a = io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxSize");
            io.reactivex.processors.ReplayProcessor.Node<T> node = new io.reactivex.processors.ReplayProcessor.Node<>(null);
            this.d = node;
            this.c = node;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void a(io.reactivex.processors.ReplayProcessor.ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.getAndIncrement() != 0) {
                return;
            }
            org.reactivestreams.Subscriber<? super T> subscriber = replaySubscription.downstream;
            io.reactivex.processors.ReplayProcessor.Node<T> node = (io.reactivex.processors.ReplayProcessor.Node) replaySubscription.index;
            if (node == null) {
                node = this.c;
            }
            long j = replaySubscription.emitted;
            int i = 1;
            do {
                long j2 = replaySubscription.requested.get();
                while (j != j2) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    boolean z = this.f;
                    io.reactivex.processors.ReplayProcessor.Node<T> node2 = node.get();
                    boolean z2 = node2 == null;
                    if (z && z2) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        java.lang.Throwable th = this.e;
                        if (th == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th);
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(node2.value);
                    j++;
                    node = node2;
                }
                if (j == j2) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    if (this.f && node.get() == null) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        java.lang.Throwable th2 = this.e;
                        if (th2 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                replaySubscription.index = node;
                replaySubscription.emitted = j;
                i = replaySubscription.addAndGet(-i);
            } while (i != 0);
        }

        public void b() {
            int i = this.b;
            if (i > this.a) {
                this.b = i - 1;
                this.c = this.c.get();
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            trimHead();
            this.f = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void error(java.lang.Throwable th) {
            this.e = th;
            trimHead();
            this.f = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public java.lang.Throwable getError() {
            return this.e;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T getValue() {
            io.reactivex.processors.ReplayProcessor.Node<T> node = this.c;
            while (true) {
                io.reactivex.processors.ReplayProcessor.Node<T> node2 = node.get();
                if (node2 == null) {
                    return node.value;
                }
                node = node2;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] tArr) {
            io.reactivex.processors.ReplayProcessor.Node<T> node = this.c;
            io.reactivex.processors.ReplayProcessor.Node<T> node2 = node;
            int i = 0;
            while (true) {
                node2 = node2.get();
                if (node2 == null) {
                    break;
                }
                i++;
            }
            if (tArr.length < i) {
                tArr = (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), i));
            }
            for (int i2 = 0; i2 < i; i2++) {
                node = node.get();
                tArr[i2] = node.value;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            return this.f;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void next(T t) {
            io.reactivex.processors.ReplayProcessor.Node<T> node = new io.reactivex.processors.ReplayProcessor.Node<>(t);
            io.reactivex.processors.ReplayProcessor.Node<T> node2 = this.d;
            this.d = node;
            this.b++;
            node2.set(node);
            b();
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            io.reactivex.processors.ReplayProcessor.Node<T> node = this.c;
            int i = 0;
            while (i != Integer.MAX_VALUE && (node = node.get()) != null) {
                i++;
            }
            return i;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
            if (this.c.value != null) {
                io.reactivex.processors.ReplayProcessor.Node<T> node = new io.reactivex.processors.ReplayProcessor.Node<>(null);
                node.lazySet(this.c.get());
                this.c = node;
            }
        }
    }

    public static final class TimedNode<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.processors.ReplayProcessor.TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        public TimedNode(T t, long j) {
            this.value = t;
            this.time = j;
        }
    }

    public static final class UnboundedReplayBuffer<T> implements io.reactivex.processors.ReplayProcessor.ReplayBuffer<T> {
        public final java.util.List<T> a;
        public java.lang.Throwable b;
        public volatile boolean c;
        public volatile int d;

        public UnboundedReplayBuffer(int i) {
            this.a = new java.util.ArrayList(io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "capacityHint"));
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void a(io.reactivex.processors.ReplayProcessor.ReplaySubscription<T> replaySubscription) {
            int i;
            if (replaySubscription.getAndIncrement() != 0) {
                return;
            }
            java.util.List<T> list = this.a;
            org.reactivestreams.Subscriber<? super T> subscriber = replaySubscription.downstream;
            java.lang.Integer num = (java.lang.Integer) replaySubscription.index;
            if (num != null) {
                i = num.intValue();
            } else {
                i = 0;
                replaySubscription.index = 0;
            }
            long j = replaySubscription.emitted;
            int i2 = 1;
            do {
                long j2 = replaySubscription.requested.get();
                while (j != j2) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    boolean z = this.c;
                    int i3 = this.d;
                    if (z && i == i3) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        java.lang.Throwable th = this.b;
                        if (th == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th);
                            return;
                        }
                    }
                    if (i == i3) {
                        break;
                    }
                    subscriber.onNext(list.get(i));
                    i++;
                    j++;
                }
                if (j == j2) {
                    if (replaySubscription.cancelled) {
                        replaySubscription.index = null;
                        return;
                    }
                    boolean z2 = this.c;
                    int i4 = this.d;
                    if (z2 && i == i4) {
                        replaySubscription.index = null;
                        replaySubscription.cancelled = true;
                        java.lang.Throwable th2 = this.b;
                        if (th2 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                replaySubscription.index = java.lang.Integer.valueOf(i);
                replaySubscription.emitted = j;
                i2 = replaySubscription.addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            this.c = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void error(java.lang.Throwable th) {
            this.b = th;
            this.c = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public java.lang.Throwable getError() {
            return this.b;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        @io.reactivex.annotations.Nullable
        public T getValue() {
            int i = this.d;
            if (i == 0) {
                return null;
            }
            return this.a.get(i - 1);
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] tArr) {
            int i = this.d;
            if (i == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            java.util.List<T> list = this.a;
            if (tArr.length < i) {
                tArr = (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), i));
            }
            for (int i2 = 0; i2 < i; i2++) {
                tArr[i2] = list.get(i2);
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            return this.c;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void next(T t) {
            this.a.add(t);
            this.d++;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            return this.d;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
        }
    }

    public ReplayProcessor(io.reactivex.processors.ReplayProcessor.ReplayBuffer<T> replayBuffer) {
        this.t = replayBuffer;
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.processors.ReplayProcessor<T> create() {
        return new io.reactivex.processors.ReplayProcessor<>(new io.reactivex.processors.ReplayProcessor.UnboundedReplayBuffer(16));
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.processors.ReplayProcessor<T> create(int i) {
        return new io.reactivex.processors.ReplayProcessor<>(new io.reactivex.processors.ReplayProcessor.UnboundedReplayBuffer(i));
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.processors.ReplayProcessor<T> createWithSize(int i) {
        return new io.reactivex.processors.ReplayProcessor<>(new io.reactivex.processors.ReplayProcessor.SizeBoundReplayBuffer(i));
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.processors.ReplayProcessor<T> createWithTime(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return new io.reactivex.processors.ReplayProcessor<>(new io.reactivex.processors.ReplayProcessor.SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, j, timeUnit, scheduler));
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.processors.ReplayProcessor<T> createWithTimeAndSize(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, int i) {
        return new io.reactivex.processors.ReplayProcessor<>(new io.reactivex.processors.ReplayProcessor.SizeAndTimeBoundReplayBuffer(i, j, timeUnit, scheduler));
    }

    public void cleanupBuffer() {
        this.t.trimHead();
    }

    public boolean e(io.reactivex.processors.ReplayProcessor.ReplaySubscription<T> replaySubscription) {
        io.reactivex.processors.ReplayProcessor.ReplaySubscription<T>[] replaySubscriptionArr;
        io.reactivex.processors.ReplayProcessor.ReplaySubscription[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = this.v.get();
            if (replaySubscriptionArr == y) {
                return false;
            }
            int length = replaySubscriptionArr.length;
            replaySubscriptionArr2 = new io.reactivex.processors.ReplayProcessor.ReplaySubscription[length + 1];
            java.lang.System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
            replaySubscriptionArr2[length] = replaySubscription;
        } while (!defpackage.xv0.a(this.v, replaySubscriptionArr, replaySubscriptionArr2));
        return true;
    }

    public void f(io.reactivex.processors.ReplayProcessor.ReplaySubscription<T> replaySubscription) {
        io.reactivex.processors.ReplayProcessor.ReplaySubscription<T>[] replaySubscriptionArr;
        io.reactivex.processors.ReplayProcessor.ReplaySubscription[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = this.v.get();
            if (replaySubscriptionArr == y || replaySubscriptionArr == x) {
                return;
            }
            int length = replaySubscriptionArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (replaySubscriptionArr[i] == replaySubscription) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                replaySubscriptionArr2 = x;
            } else {
                io.reactivex.processors.ReplayProcessor.ReplaySubscription[] replaySubscriptionArr3 = new io.reactivex.processors.ReplayProcessor.ReplaySubscription[length - 1];
                java.lang.System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr3, 0, i);
                java.lang.System.arraycopy(replaySubscriptionArr, i + 1, replaySubscriptionArr3, i, (length - i) - 1);
                replaySubscriptionArr2 = replaySubscriptionArr3;
            }
        } while (!defpackage.xv0.a(this.v, replaySubscriptionArr, replaySubscriptionArr2));
    }

    @Override // io.reactivex.processors.FlowableProcessor
    @io.reactivex.annotations.Nullable
    public java.lang.Throwable getThrowable() {
        io.reactivex.processors.ReplayProcessor.ReplayBuffer<T> replayBuffer = this.t;
        if (replayBuffer.isDone()) {
            return replayBuffer.getError();
        }
        return null;
    }

    public T getValue() {
        return this.t.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public java.lang.Object[] getValues() {
        java.lang.Object[] objArr = w;
        java.lang.Object[] values = getValues(objArr);
        return values == objArr ? new java.lang.Object[0] : values;
    }

    public T[] getValues(T[] tArr) {
        return this.t.getValues(tArr);
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        io.reactivex.processors.ReplayProcessor.ReplayBuffer<T> replayBuffer = this.t;
        return replayBuffer.isDone() && replayBuffer.getError() == null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.v.get().length != 0;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        io.reactivex.processors.ReplayProcessor.ReplayBuffer<T> replayBuffer = this.t;
        return replayBuffer.isDone() && replayBuffer.getError() != null;
    }

    public boolean hasValue() {
        return this.t.size() != 0;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.u) {
            return;
        }
        this.u = true;
        io.reactivex.processors.ReplayProcessor.ReplayBuffer<T> replayBuffer = this.t;
        replayBuffer.complete();
        for (io.reactivex.processors.ReplayProcessor.ReplaySubscription<T> replaySubscription : this.v.getAndSet(y)) {
            replayBuffer.a(replaySubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(java.lang.Throwable th) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.u) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            return;
        }
        this.u = true;
        io.reactivex.processors.ReplayProcessor.ReplayBuffer<T> replayBuffer = this.t;
        replayBuffer.error(th);
        for (io.reactivex.processors.ReplayProcessor.ReplaySubscription<T> replaySubscription : this.v.getAndSet(y)) {
            replayBuffer.a(replaySubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.u) {
            return;
        }
        io.reactivex.processors.ReplayProcessor.ReplayBuffer<T> replayBuffer = this.t;
        replayBuffer.next(t);
        for (io.reactivex.processors.ReplayProcessor.ReplaySubscription<T> replaySubscription : this.v.get()) {
            replayBuffer.a(replaySubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(org.reactivestreams.Subscription subscription) {
        if (this.u) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.processors.ReplayProcessor.ReplaySubscription<T> replaySubscription = new io.reactivex.processors.ReplayProcessor.ReplaySubscription<>(subscriber, this);
        subscriber.onSubscribe(replaySubscription);
        if (e(replaySubscription) && replaySubscription.cancelled) {
            f(replaySubscription);
        } else {
            this.t.a(replaySubscription);
        }
    }
}
