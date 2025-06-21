package io.reactivex.subjects;

/* loaded from: classes14.dex */
public final class ReplaySubject<T> extends io.reactivex.subjects.Subject<T> {
    public static final io.reactivex.subjects.ReplaySubject.ReplayDisposable[] v = new io.reactivex.subjects.ReplaySubject.ReplayDisposable[0];
    public static final io.reactivex.subjects.ReplaySubject.ReplayDisposable[] w = new io.reactivex.subjects.ReplaySubject.ReplayDisposable[0];
    public static final java.lang.Object[] x = new java.lang.Object[0];
    public final io.reactivex.subjects.ReplaySubject.ReplayBuffer<T> n;
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.ReplaySubject.ReplayDisposable<T>[]> t = new java.util.concurrent.atomic.AtomicReference<>(v);
    public boolean u;

    public static final class Node<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.ReplaySubject.Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        public Node(T t) {
            this.value = t;
        }
    }

    public interface ReplayBuffer<T> {
        void add(T t);

        void addFinal(java.lang.Object obj);

        boolean compareAndSet(java.lang.Object obj, java.lang.Object obj2);

        java.lang.Object get();

        @io.reactivex.annotations.Nullable
        T getValue();

        T[] getValues(T[] tArr);

        void replay(io.reactivex.subjects.ReplaySubject.ReplayDisposable<T> replayDisposable);

        int size();

        void trimHead();
    }

    public static final class ReplayDisposable<T> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final io.reactivex.Observer<? super T> downstream;
        java.lang.Object index;
        final io.reactivex.subjects.ReplaySubject<T> state;

        public ReplayDisposable(io.reactivex.Observer<? super T> observer, io.reactivex.subjects.ReplaySubject<T> replaySubject) {
            this.downstream = observer;
            this.state = replaySubject;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.e(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends java.util.concurrent.atomic.AtomicReference<java.lang.Object> implements io.reactivex.subjects.ReplaySubject.ReplayBuffer<T> {
        private static final long serialVersionUID = -8056260896137901749L;
        volatile boolean done;
        volatile io.reactivex.subjects.ReplaySubject.TimedNode<java.lang.Object> head;
        final long maxAge;
        final int maxSize;
        final io.reactivex.Scheduler scheduler;
        int size;
        io.reactivex.subjects.ReplaySubject.TimedNode<java.lang.Object> tail;
        final java.util.concurrent.TimeUnit unit;

        public SizeAndTimeBoundReplayBuffer(int i, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
            this.maxSize = io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxSize");
            this.maxAge = io.reactivex.internal.functions.ObjectHelper.verifyPositive(j, "maxAge");
            this.unit = (java.util.concurrent.TimeUnit) io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
            this.scheduler = (io.reactivex.Scheduler) io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            io.reactivex.subjects.ReplaySubject.TimedNode<java.lang.Object> timedNode = new io.reactivex.subjects.ReplaySubject.TimedNode<>(null, 0L);
            this.tail = timedNode;
            this.head = timedNode;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(T t) {
            io.reactivex.subjects.ReplaySubject.TimedNode<java.lang.Object> timedNode = new io.reactivex.subjects.ReplaySubject.TimedNode<>(t, this.scheduler.now(this.unit));
            io.reactivex.subjects.ReplaySubject.TimedNode<java.lang.Object> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.set(timedNode);
            trim();
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(java.lang.Object obj) {
            io.reactivex.subjects.ReplaySubject.TimedNode<java.lang.Object> timedNode = new io.reactivex.subjects.ReplaySubject.TimedNode<>(obj, Long.MAX_VALUE);
            io.reactivex.subjects.ReplaySubject.TimedNode<java.lang.Object> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.lazySet(timedNode);
            trimFinal();
            this.done = true;
        }

        public io.reactivex.subjects.ReplaySubject.TimedNode<java.lang.Object> getHead() {
            io.reactivex.subjects.ReplaySubject.TimedNode<java.lang.Object> timedNode;
            io.reactivex.subjects.ReplaySubject.TimedNode<java.lang.Object> timedNode2 = this.head;
            long now = this.scheduler.now(this.unit) - this.maxAge;
            io.reactivex.subjects.ReplaySubject.TimedNode<T> timedNode3 = timedNode2.get();
            while (true) {
                io.reactivex.subjects.ReplaySubject.TimedNode<T> timedNode4 = timedNode3;
                timedNode = timedNode2;
                timedNode2 = timedNode4;
                if (timedNode2 == null || timedNode2.time > now) {
                    break;
                }
                timedNode3 = timedNode2.get();
            }
            return timedNode;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        @io.reactivex.annotations.Nullable
        public T getValue() {
            T t;
            io.reactivex.subjects.ReplaySubject.TimedNode<java.lang.Object> timedNode = this.head;
            io.reactivex.subjects.ReplaySubject.TimedNode<java.lang.Object> timedNode2 = null;
            while (true) {
                io.reactivex.subjects.ReplaySubject.TimedNode<T> timedNode3 = timedNode.get();
                if (timedNode3 == null) {
                    break;
                }
                timedNode2 = timedNode;
                timedNode = timedNode3;
            }
            if (timedNode.time >= this.scheduler.now(this.unit) - this.maxAge && (t = (T) timedNode.value) != null) {
                return (io.reactivex.internal.util.NotificationLite.isComplete(t) || io.reactivex.internal.util.NotificationLite.isError(t)) ? (T) timedNode2.value : t;
            }
            return null;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public T[] getValues(T[] tArr) {
            io.reactivex.subjects.ReplaySubject.TimedNode<T> head = getHead();
            int size = size(head);
            if (size != 0) {
                if (tArr.length < size) {
                    tArr = (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), size));
                }
                for (int i = 0; i != size; i++) {
                    head = head.get();
                    tArr[i] = head.value;
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(io.reactivex.subjects.ReplaySubject.ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            io.reactivex.Observer<? super T> observer = replayDisposable.downstream;
            io.reactivex.subjects.ReplaySubject.TimedNode<java.lang.Object> timedNode = (io.reactivex.subjects.ReplaySubject.TimedNode) replayDisposable.index;
            if (timedNode == null) {
                timedNode = getHead();
            }
            int i = 1;
            while (!replayDisposable.cancelled) {
                while (!replayDisposable.cancelled) {
                    io.reactivex.subjects.ReplaySubject.TimedNode<T> timedNode2 = timedNode.get();
                    if (timedNode2 != null) {
                        T t = timedNode2.value;
                        if (this.done && timedNode2.get() == null) {
                            if (io.reactivex.internal.util.NotificationLite.isComplete(t)) {
                                observer.onComplete();
                            } else {
                                observer.onError(io.reactivex.internal.util.NotificationLite.getError(t));
                            }
                            replayDisposable.index = null;
                            replayDisposable.cancelled = true;
                            return;
                        }
                        observer.onNext(t);
                        timedNode = timedNode2;
                    } else if (timedNode.get() == null) {
                        replayDisposable.index = timedNode;
                        i = replayDisposable.addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.index = null;
                return;
            }
            replayDisposable.index = null;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            return size(getHead());
        }

        public int size(io.reactivex.subjects.ReplaySubject.TimedNode<java.lang.Object> timedNode) {
            int i = 0;
            while (i != Integer.MAX_VALUE) {
                io.reactivex.subjects.ReplaySubject.TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    java.lang.Object obj = timedNode.value;
                    return (io.reactivex.internal.util.NotificationLite.isComplete(obj) || io.reactivex.internal.util.NotificationLite.isError(obj)) ? i - 1 : i;
                }
                i++;
                timedNode = timedNode2;
            }
            return i;
        }

        public void trim() {
            int i = this.size;
            if (i > this.maxSize) {
                this.size = i - 1;
                this.head = this.head.get();
            }
            long now = this.scheduler.now(this.unit) - this.maxAge;
            io.reactivex.subjects.ReplaySubject.TimedNode<java.lang.Object> timedNode = this.head;
            while (this.size > 1) {
                io.reactivex.subjects.ReplaySubject.TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    this.head = timedNode;
                    return;
                } else if (timedNode2.time > now) {
                    this.head = timedNode;
                    return;
                } else {
                    this.size--;
                    timedNode = timedNode2;
                }
            }
            this.head = timedNode;
        }

        public void trimFinal() {
            long now = this.scheduler.now(this.unit) - this.maxAge;
            io.reactivex.subjects.ReplaySubject.TimedNode<java.lang.Object> timedNode = this.head;
            while (true) {
                io.reactivex.subjects.ReplaySubject.TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2.get() == null) {
                    if (timedNode.value == null) {
                        this.head = timedNode;
                        return;
                    }
                    io.reactivex.subjects.ReplaySubject.TimedNode<java.lang.Object> timedNode3 = new io.reactivex.subjects.ReplaySubject.TimedNode<>(null, 0L);
                    timedNode3.lazySet(timedNode.get());
                    this.head = timedNode3;
                    return;
                }
                if (timedNode2.time > now) {
                    if (timedNode.value == null) {
                        this.head = timedNode;
                        return;
                    }
                    io.reactivex.subjects.ReplaySubject.TimedNode<java.lang.Object> timedNode4 = new io.reactivex.subjects.ReplaySubject.TimedNode<>(null, 0L);
                    timedNode4.lazySet(timedNode.get());
                    this.head = timedNode4;
                    return;
                }
                timedNode = timedNode2;
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
            io.reactivex.subjects.ReplaySubject.TimedNode<java.lang.Object> timedNode = this.head;
            if (timedNode.value != null) {
                io.reactivex.subjects.ReplaySubject.TimedNode<java.lang.Object> timedNode2 = new io.reactivex.subjects.ReplaySubject.TimedNode<>(null, 0L);
                timedNode2.lazySet(timedNode.get());
                this.head = timedNode2;
            }
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends java.util.concurrent.atomic.AtomicReference<java.lang.Object> implements io.reactivex.subjects.ReplaySubject.ReplayBuffer<T> {
        private static final long serialVersionUID = 1107649250281456395L;
        volatile boolean done;
        volatile io.reactivex.subjects.ReplaySubject.Node<java.lang.Object> head;
        final int maxSize;
        int size;
        io.reactivex.subjects.ReplaySubject.Node<java.lang.Object> tail;

        public SizeBoundReplayBuffer(int i) {
            this.maxSize = io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxSize");
            io.reactivex.subjects.ReplaySubject.Node<java.lang.Object> node = new io.reactivex.subjects.ReplaySubject.Node<>(null);
            this.tail = node;
            this.head = node;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(T t) {
            io.reactivex.subjects.ReplaySubject.Node<java.lang.Object> node = new io.reactivex.subjects.ReplaySubject.Node<>(t);
            io.reactivex.subjects.ReplaySubject.Node<java.lang.Object> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.set(node);
            trim();
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(java.lang.Object obj) {
            io.reactivex.subjects.ReplaySubject.Node<java.lang.Object> node = new io.reactivex.subjects.ReplaySubject.Node<>(obj);
            io.reactivex.subjects.ReplaySubject.Node<java.lang.Object> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.lazySet(node);
            trimHead();
            this.done = true;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        @io.reactivex.annotations.Nullable
        public T getValue() {
            io.reactivex.subjects.ReplaySubject.Node<java.lang.Object> node = this.head;
            io.reactivex.subjects.ReplaySubject.Node<java.lang.Object> node2 = null;
            while (true) {
                io.reactivex.subjects.ReplaySubject.Node<T> node3 = node.get();
                if (node3 == null) {
                    break;
                }
                node2 = node;
                node = node3;
            }
            T t = (T) node.value;
            if (t == null) {
                return null;
            }
            return (io.reactivex.internal.util.NotificationLite.isComplete(t) || io.reactivex.internal.util.NotificationLite.isError(t)) ? (T) node2.value : t;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public T[] getValues(T[] tArr) {
            io.reactivex.subjects.ReplaySubject.Node<T> node = this.head;
            int size = size();
            if (size != 0) {
                if (tArr.length < size) {
                    tArr = (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), size));
                }
                for (int i = 0; i != size; i++) {
                    node = node.get();
                    tArr[i] = node.value;
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(io.reactivex.subjects.ReplaySubject.ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            io.reactivex.Observer<? super T> observer = replayDisposable.downstream;
            io.reactivex.subjects.ReplaySubject.Node<java.lang.Object> node = (io.reactivex.subjects.ReplaySubject.Node) replayDisposable.index;
            if (node == null) {
                node = this.head;
            }
            int i = 1;
            while (!replayDisposable.cancelled) {
                io.reactivex.subjects.ReplaySubject.Node<T> node2 = node.get();
                if (node2 != null) {
                    T t = node2.value;
                    if (this.done && node2.get() == null) {
                        if (io.reactivex.internal.util.NotificationLite.isComplete(t)) {
                            observer.onComplete();
                        } else {
                            observer.onError(io.reactivex.internal.util.NotificationLite.getError(t));
                        }
                        replayDisposable.index = null;
                        replayDisposable.cancelled = true;
                        return;
                    }
                    observer.onNext(t);
                    node = node2;
                } else if (node.get() != null) {
                    continue;
                } else {
                    replayDisposable.index = node;
                    i = replayDisposable.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
            replayDisposable.index = null;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            io.reactivex.subjects.ReplaySubject.Node<java.lang.Object> node = this.head;
            int i = 0;
            while (i != Integer.MAX_VALUE) {
                io.reactivex.subjects.ReplaySubject.Node<T> node2 = node.get();
                if (node2 == null) {
                    java.lang.Object obj = node.value;
                    return (io.reactivex.internal.util.NotificationLite.isComplete(obj) || io.reactivex.internal.util.NotificationLite.isError(obj)) ? i - 1 : i;
                }
                i++;
                node = node2;
            }
            return i;
        }

        public void trim() {
            int i = this.size;
            if (i > this.maxSize) {
                this.size = i - 1;
                this.head = this.head.get();
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
            io.reactivex.subjects.ReplaySubject.Node<java.lang.Object> node = this.head;
            if (node.value != null) {
                io.reactivex.subjects.ReplaySubject.Node<java.lang.Object> node2 = new io.reactivex.subjects.ReplaySubject.Node<>(null);
                node2.lazySet(node.get());
                this.head = node2;
            }
        }
    }

    public static final class TimedNode<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.ReplaySubject.TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        public TimedNode(T t, long j) {
            this.value = t;
            this.time = j;
        }
    }

    public static final class UnboundedReplayBuffer<T> extends java.util.concurrent.atomic.AtomicReference<java.lang.Object> implements io.reactivex.subjects.ReplaySubject.ReplayBuffer<T> {
        private static final long serialVersionUID = -733876083048047795L;
        final java.util.List<java.lang.Object> buffer;
        volatile boolean done;
        volatile int size;

        public UnboundedReplayBuffer(int i) {
            this.buffer = new java.util.ArrayList(io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "capacityHint"));
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(T t) {
            this.buffer.add(t);
            this.size++;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(java.lang.Object obj) {
            this.buffer.add(obj);
            trimHead();
            this.size++;
            this.done = true;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        @io.reactivex.annotations.Nullable
        public T getValue() {
            int i = this.size;
            if (i == 0) {
                return null;
            }
            java.util.List<java.lang.Object> list = this.buffer;
            T t = (T) list.get(i - 1);
            if (!io.reactivex.internal.util.NotificationLite.isComplete(t) && !io.reactivex.internal.util.NotificationLite.isError(t)) {
                return t;
            }
            if (i == 1) {
                return null;
            }
            return (T) list.get(i - 2);
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public T[] getValues(T[] tArr) {
            int i = this.size;
            if (i == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            java.util.List<java.lang.Object> list = this.buffer;
            java.lang.Object obj = list.get(i - 1);
            if ((io.reactivex.internal.util.NotificationLite.isComplete(obj) || io.reactivex.internal.util.NotificationLite.isError(obj)) && i - 1 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
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

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(io.reactivex.subjects.ReplaySubject.ReplayDisposable<T> replayDisposable) {
            int i;
            int i2;
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            java.util.List<java.lang.Object> list = this.buffer;
            io.reactivex.Observer<? super T> observer = replayDisposable.downstream;
            java.lang.Integer num = (java.lang.Integer) replayDisposable.index;
            if (num != null) {
                i = num.intValue();
            } else {
                i = 0;
                replayDisposable.index = 0;
            }
            int i3 = 1;
            while (!replayDisposable.cancelled) {
                int i4 = this.size;
                while (i4 != i) {
                    if (replayDisposable.cancelled) {
                        replayDisposable.index = null;
                        return;
                    }
                    java.lang.Object obj = list.get(i);
                    if (this.done && (i2 = i + 1) == i4 && i2 == (i4 = this.size)) {
                        if (io.reactivex.internal.util.NotificationLite.isComplete(obj)) {
                            observer.onComplete();
                        } else {
                            observer.onError(io.reactivex.internal.util.NotificationLite.getError(obj));
                        }
                        replayDisposable.index = null;
                        replayDisposable.cancelled = true;
                        return;
                    }
                    observer.onNext(obj);
                    i++;
                }
                if (i == this.size) {
                    replayDisposable.index = java.lang.Integer.valueOf(i);
                    i3 = replayDisposable.addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                }
            }
            replayDisposable.index = null;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            int i = this.size;
            if (i == 0) {
                return 0;
            }
            int i2 = i - 1;
            java.lang.Object obj = this.buffer.get(i2);
            return (io.reactivex.internal.util.NotificationLite.isComplete(obj) || io.reactivex.internal.util.NotificationLite.isError(obj)) ? i2 : i;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
        }
    }

    public ReplaySubject(io.reactivex.subjects.ReplaySubject.ReplayBuffer<T> replayBuffer) {
        this.n = replayBuffer;
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.subjects.ReplaySubject<T> create() {
        return new io.reactivex.subjects.ReplaySubject<>(new io.reactivex.subjects.ReplaySubject.UnboundedReplayBuffer(16));
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.subjects.ReplaySubject<T> create(int i) {
        return new io.reactivex.subjects.ReplaySubject<>(new io.reactivex.subjects.ReplaySubject.UnboundedReplayBuffer(i));
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.subjects.ReplaySubject<T> createWithSize(int i) {
        return new io.reactivex.subjects.ReplaySubject<>(new io.reactivex.subjects.ReplaySubject.SizeBoundReplayBuffer(i));
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.subjects.ReplaySubject<T> createWithTime(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return new io.reactivex.subjects.ReplaySubject<>(new io.reactivex.subjects.ReplaySubject.SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, j, timeUnit, scheduler));
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.subjects.ReplaySubject<T> createWithTimeAndSize(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, int i) {
        return new io.reactivex.subjects.ReplaySubject<>(new io.reactivex.subjects.ReplaySubject.SizeAndTimeBoundReplayBuffer(i, j, timeUnit, scheduler));
    }

    public void cleanupBuffer() {
        this.n.trimHead();
    }

    public boolean d(io.reactivex.subjects.ReplaySubject.ReplayDisposable<T> replayDisposable) {
        io.reactivex.subjects.ReplaySubject.ReplayDisposable<T>[] replayDisposableArr;
        io.reactivex.subjects.ReplaySubject.ReplayDisposable[] replayDisposableArr2;
        do {
            replayDisposableArr = this.t.get();
            if (replayDisposableArr == w) {
                return false;
            }
            int length = replayDisposableArr.length;
            replayDisposableArr2 = new io.reactivex.subjects.ReplaySubject.ReplayDisposable[length + 1];
            java.lang.System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, length);
            replayDisposableArr2[length] = replayDisposable;
        } while (!defpackage.xv0.a(this.t, replayDisposableArr, replayDisposableArr2));
        return true;
    }

    public void e(io.reactivex.subjects.ReplaySubject.ReplayDisposable<T> replayDisposable) {
        io.reactivex.subjects.ReplaySubject.ReplayDisposable<T>[] replayDisposableArr;
        io.reactivex.subjects.ReplaySubject.ReplayDisposable[] replayDisposableArr2;
        do {
            replayDisposableArr = this.t.get();
            if (replayDisposableArr == w || replayDisposableArr == v) {
                return;
            }
            int length = replayDisposableArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (replayDisposableArr[i] == replayDisposable) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                replayDisposableArr2 = v;
            } else {
                io.reactivex.subjects.ReplaySubject.ReplayDisposable[] replayDisposableArr3 = new io.reactivex.subjects.ReplaySubject.ReplayDisposable[length - 1];
                java.lang.System.arraycopy(replayDisposableArr, 0, replayDisposableArr3, 0, i);
                java.lang.System.arraycopy(replayDisposableArr, i + 1, replayDisposableArr3, i, (length - i) - 1);
                replayDisposableArr2 = replayDisposableArr3;
            }
        } while (!defpackage.xv0.a(this.t, replayDisposableArr, replayDisposableArr2));
    }

    public io.reactivex.subjects.ReplaySubject.ReplayDisposable<T>[] f(java.lang.Object obj) {
        return this.n.compareAndSet(null, obj) ? this.t.getAndSet(w) : w;
    }

    @Override // io.reactivex.subjects.Subject
    @io.reactivex.annotations.Nullable
    public java.lang.Throwable getThrowable() {
        java.lang.Object obj = this.n.get();
        if (io.reactivex.internal.util.NotificationLite.isError(obj)) {
            return io.reactivex.internal.util.NotificationLite.getError(obj);
        }
        return null;
    }

    @io.reactivex.annotations.Nullable
    public T getValue() {
        return this.n.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public java.lang.Object[] getValues() {
        java.lang.Object[] objArr = x;
        java.lang.Object[] values = getValues(objArr);
        return values == objArr ? new java.lang.Object[0] : values;
    }

    public T[] getValues(T[] tArr) {
        return this.n.getValues(tArr);
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return io.reactivex.internal.util.NotificationLite.isComplete(this.n.get());
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        return this.t.get().length != 0;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return io.reactivex.internal.util.NotificationLite.isError(this.n.get());
    }

    public boolean hasValue() {
        return this.n.size() != 0;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.u) {
            return;
        }
        this.u = true;
        java.lang.Object complete = io.reactivex.internal.util.NotificationLite.complete();
        io.reactivex.subjects.ReplaySubject.ReplayBuffer<T> replayBuffer = this.n;
        replayBuffer.addFinal(complete);
        for (io.reactivex.subjects.ReplaySubject.ReplayDisposable<T> replayDisposable : f(complete)) {
            replayBuffer.replay(replayDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(java.lang.Throwable th) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.u) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            return;
        }
        this.u = true;
        java.lang.Object error = io.reactivex.internal.util.NotificationLite.error(th);
        io.reactivex.subjects.ReplaySubject.ReplayBuffer<T> replayBuffer = this.n;
        replayBuffer.addFinal(error);
        for (io.reactivex.subjects.ReplaySubject.ReplayDisposable<T> replayDisposable : f(error)) {
            replayBuffer.replay(replayDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.u) {
            return;
        }
        io.reactivex.subjects.ReplaySubject.ReplayBuffer<T> replayBuffer = this.n;
        replayBuffer.add(t);
        for (io.reactivex.subjects.ReplaySubject.ReplayDisposable<T> replayDisposable : this.t.get()) {
            replayBuffer.replay(replayDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
        if (this.u) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.subjects.ReplaySubject.ReplayDisposable<T> replayDisposable = new io.reactivex.subjects.ReplaySubject.ReplayDisposable<>(observer, this);
        observer.onSubscribe(replayDisposable);
        if (replayDisposable.cancelled) {
            return;
        }
        if (d(replayDisposable) && replayDisposable.cancelled) {
            e(replayDisposable);
        } else {
            this.n.replay(replayDisposable);
        }
    }
}
