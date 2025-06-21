package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableReplay<T> extends io.reactivex.observables.ConnectableObservable<T> implements io.reactivex.internal.fuseable.HasUpstreamObservableSource<T>, io.reactivex.internal.disposables.ResettableConnectable {
    public static final io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier w = new io.reactivex.internal.operators.observable.ObservableReplay.UnBoundedFactory();
    public final io.reactivex.ObservableSource<T> n;
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver<T>> t;
    public final io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier<T> u;
    public final io.reactivex.ObservableSource<T> v;

    public static abstract class BoundedReplayBuffer<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay.Node> implements io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        int size;
        io.reactivex.internal.operators.observable.ObservableReplay.Node tail;

        public BoundedReplayBuffer() {
            io.reactivex.internal.operators.observable.ObservableReplay.Node node = new io.reactivex.internal.operators.observable.ObservableReplay.Node(null);
            this.tail = node;
            set(node);
        }

        public final void addLast(io.reactivex.internal.operators.observable.ObservableReplay.Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        public final void collect(java.util.Collection<? super T> collection) {
            io.reactivex.internal.operators.observable.ObservableReplay.Node head = getHead();
            while (true) {
                head = head.get();
                if (head == null) {
                    return;
                }
                java.lang.Object leaveTransform = leaveTransform(head.value);
                if (io.reactivex.internal.util.NotificationLite.isComplete(leaveTransform) || io.reactivex.internal.util.NotificationLite.isError(leaveTransform)) {
                    return;
                } else {
                    collection.add((java.lang.Object) io.reactivex.internal.util.NotificationLite.getValue(leaveTransform));
                }
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void complete() {
            addLast(new io.reactivex.internal.operators.observable.ObservableReplay.Node(enterTransform(io.reactivex.internal.util.NotificationLite.complete())));
            truncateFinal();
        }

        public java.lang.Object enterTransform(java.lang.Object obj) {
            return obj;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void error(java.lang.Throwable th) {
            addLast(new io.reactivex.internal.operators.observable.ObservableReplay.Node(enterTransform(io.reactivex.internal.util.NotificationLite.error(th))));
            truncateFinal();
        }

        public io.reactivex.internal.operators.observable.ObservableReplay.Node getHead() {
            return get();
        }

        public boolean hasCompleted() {
            java.lang.Object obj = this.tail.value;
            return obj != null && io.reactivex.internal.util.NotificationLite.isComplete(leaveTransform(obj));
        }

        public boolean hasError() {
            java.lang.Object obj = this.tail.value;
            return obj != null && io.reactivex.internal.util.NotificationLite.isError(leaveTransform(obj));
        }

        public java.lang.Object leaveTransform(java.lang.Object obj) {
            return obj;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void next(T t) {
            addLast(new io.reactivex.internal.operators.observable.ObservableReplay.Node(enterTransform(io.reactivex.internal.util.NotificationLite.next(t))));
            truncate();
        }

        public final void removeFirst() {
            this.size--;
            setFirst(get().get());
        }

        public final void removeSome(int i) {
            io.reactivex.internal.operators.observable.ObservableReplay.Node node = get();
            while (i > 0) {
                node = node.get();
                i--;
                this.size--;
            }
            setFirst(node);
            io.reactivex.internal.operators.observable.ObservableReplay.Node node2 = get();
            if (node2.get() == null) {
                this.tail = node2;
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void replay(io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            int i = 1;
            do {
                io.reactivex.internal.operators.observable.ObservableReplay.Node node = (io.reactivex.internal.operators.observable.ObservableReplay.Node) innerDisposable.index();
                if (node == null) {
                    node = getHead();
                    innerDisposable.index = node;
                }
                while (!innerDisposable.isDisposed()) {
                    io.reactivex.internal.operators.observable.ObservableReplay.Node node2 = node.get();
                    if (node2 == null) {
                        innerDisposable.index = node;
                        i = innerDisposable.addAndGet(-i);
                    } else {
                        if (io.reactivex.internal.util.NotificationLite.accept(leaveTransform(node2.value), innerDisposable.child)) {
                            innerDisposable.index = null;
                            return;
                        }
                        node = node2;
                    }
                }
                innerDisposable.index = null;
                return;
            } while (i != 0);
        }

        public final void setFirst(io.reactivex.internal.operators.observable.ObservableReplay.Node node) {
            set(node);
        }

        public final void trimHead() {
            io.reactivex.internal.operators.observable.ObservableReplay.Node node = get();
            if (node.value != null) {
                io.reactivex.internal.operators.observable.ObservableReplay.Node node2 = new io.reactivex.internal.operators.observable.ObservableReplay.Node(null);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        public abstract void truncate();

        public void truncateFinal() {
            trimHead();
        }
    }

    public interface BufferSupplier<T> {
        io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer<T> call();
    }

    public static final class DisposeConsumer<R> implements io.reactivex.functions.Consumer<io.reactivex.disposables.Disposable> {
        public final io.reactivex.internal.operators.observable.ObserverResourceWrapper<R> n;

        public DisposeConsumer(io.reactivex.internal.operators.observable.ObserverResourceWrapper<R> observerResourceWrapper) {
            this.n = observerResourceWrapper;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(io.reactivex.disposables.Disposable disposable) {
            this.n.setResource(disposable);
        }
    }

    public static final class InnerDisposable<T> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 2728361546769921047L;
        volatile boolean cancelled;
        final io.reactivex.Observer<? super T> child;
        java.lang.Object index;
        final io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver<T> parent;

        public InnerDisposable(io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver<T> replayObserver, io.reactivex.Observer<? super T> observer) {
            this.parent = replayObserver;
            this.child = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.parent.remove(this);
            this.index = null;
        }

        public <U> U index() {
            return (U) this.index;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    public static final class MulticastReplay<R, U> extends io.reactivex.Observable<R> {
        public final java.util.concurrent.Callable<? extends io.reactivex.observables.ConnectableObservable<U>> n;
        public final io.reactivex.functions.Function<? super io.reactivex.Observable<U>, ? extends io.reactivex.ObservableSource<R>> t;

        public MulticastReplay(java.util.concurrent.Callable<? extends io.reactivex.observables.ConnectableObservable<U>> callable, io.reactivex.functions.Function<? super io.reactivex.Observable<U>, ? extends io.reactivex.ObservableSource<R>> function) {
            this.n = callable;
            this.t = function;
        }

        @Override // io.reactivex.Observable
        public void subscribeActual(io.reactivex.Observer<? super R> observer) {
            try {
                io.reactivex.observables.ConnectableObservable connectableObservable = (io.reactivex.observables.ConnectableObservable) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.call(), "The connectableFactory returned a null ConnectableObservable");
                io.reactivex.ObservableSource observableSource = (io.reactivex.ObservableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(connectableObservable), "The selector returned a null ObservableSource");
                io.reactivex.internal.operators.observable.ObserverResourceWrapper observerResourceWrapper = new io.reactivex.internal.operators.observable.ObserverResourceWrapper(observer);
                observableSource.subscribe(observerResourceWrapper);
                connectableObservable.connect(new io.reactivex.internal.operators.observable.ObservableReplay.DisposeConsumer(observerResourceWrapper));
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.internal.disposables.EmptyDisposable.error(th, observer);
            }
        }
    }

    public static final class Node extends java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay.Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final java.lang.Object value;

        public Node(java.lang.Object obj) {
            this.value = obj;
        }
    }

    public static final class Replay<T> extends io.reactivex.observables.ConnectableObservable<T> {
        public final io.reactivex.observables.ConnectableObservable<T> n;
        public final io.reactivex.Observable<T> t;

        public Replay(io.reactivex.observables.ConnectableObservable<T> connectableObservable, io.reactivex.Observable<T> observable) {
            this.n = connectableObservable;
            this.t = observable;
        }

        @Override // io.reactivex.observables.ConnectableObservable
        public void connect(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer) {
            this.n.connect(consumer);
        }

        @Override // io.reactivex.Observable
        public void subscribeActual(io.reactivex.Observer<? super T> observer) {
            this.t.subscribe(observer);
        }
    }

    public interface ReplayBuffer<T> {
        void complete();

        void error(java.lang.Throwable th);

        void next(T t);

        void replay(io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable<T> innerDisposable);
    }

    public static final class ReplayBufferSupplier<T> implements io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier<T> {
        public final int a;

        public ReplayBufferSupplier(int i) {
            this.a = i;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer<T> call() {
            return new io.reactivex.internal.operators.observable.ObservableReplay.SizeBoundReplayBuffer(this.a);
        }
    }

    public static final class ReplayObserver<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        static final io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable[] EMPTY = new io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable[0];
        static final io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable[] TERMINATED = new io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable[0];
        private static final long serialVersionUID = -533785617179540163L;
        final io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer<T> buffer;
        boolean done;
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable[]> observers = new java.util.concurrent.atomic.AtomicReference<>(EMPTY);
        final java.util.concurrent.atomic.AtomicBoolean shouldConnect = new java.util.concurrent.atomic.AtomicBoolean();

        public ReplayObserver(io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer<T> replayBuffer) {
            this.buffer = replayBuffer;
        }

        public boolean add(io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable<T> innerDisposable) {
            io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable[] innerDisposableArr;
            io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                if (innerDisposableArr == TERMINATED) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable[length + 1];
                java.lang.System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!defpackage.xv0.a(this.observers, innerDisposableArr, innerDisposableArr2));
            return true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.observers.set(TERMINATED);
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.observers.get() == TERMINATED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.buffer.complete();
            replayFinal();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.done) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.buffer.error(th);
            replayFinal();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            this.buffer.next(t);
            replay();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable)) {
                replay();
            }
        }

        public void remove(io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable<T> innerDisposable) {
            io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable[] innerDisposableArr;
            io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (innerDisposableArr[i].equals(innerDisposable)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr2 = EMPTY;
                } else {
                    io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable[] innerDisposableArr3 = new io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable[length - 1];
                    java.lang.System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i);
                    java.lang.System.arraycopy(innerDisposableArr, i + 1, innerDisposableArr3, i, (length - i) - 1);
                    innerDisposableArr2 = innerDisposableArr3;
                }
            } while (!defpackage.xv0.a(this.observers, innerDisposableArr, innerDisposableArr2));
        }

        public void replay() {
            for (io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable<T> innerDisposable : this.observers.get()) {
                this.buffer.replay(innerDisposable);
            }
        }

        public void replayFinal() {
            for (io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable<T> innerDisposable : this.observers.getAndSet(TERMINATED)) {
                this.buffer.replay(innerDisposable);
            }
        }
    }

    public static final class ReplaySource<T> implements io.reactivex.ObservableSource<T> {
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver<T>> n;
        public final io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier<T> t;

        public ReplaySource(java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver<T>> atomicReference, io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier<T> bufferSupplier) {
            this.n = atomicReference;
            this.t = bufferSupplier;
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(io.reactivex.Observer<? super T> observer) {
            io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver<T> replayObserver;
            while (true) {
                replayObserver = this.n.get();
                if (replayObserver != null) {
                    break;
                }
                io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver<T> replayObserver2 = new io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver<>(this.t.call());
                if (defpackage.xv0.a(this.n, null, replayObserver2)) {
                    replayObserver = replayObserver2;
                    break;
                }
            }
            io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable<T> innerDisposable = new io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable<>(replayObserver, observer);
            observer.onSubscribe(innerDisposable);
            replayObserver.add(innerDisposable);
            if (innerDisposable.isDisposed()) {
                replayObserver.remove(innerDisposable);
            } else {
                replayObserver.buffer.replay(innerDisposable);
            }
        }
    }

    public static final class ScheduledReplaySupplier<T> implements io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier<T> {
        public final int a;
        public final long b;
        public final java.util.concurrent.TimeUnit c;
        public final io.reactivex.Scheduler d;

        public ScheduledReplaySupplier(int i, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
            this.a = i;
            this.b = j;
            this.c = timeUnit;
            this.d = scheduler;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer<T> call() {
            return new io.reactivex.internal.operators.observable.ObservableReplay.SizeAndTimeBoundReplayBuffer(this.a, this.b, this.c, this.d);
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final io.reactivex.Scheduler scheduler;
        final java.util.concurrent.TimeUnit unit;

        public SizeAndTimeBoundReplayBuffer(int i, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
            this.scheduler = scheduler;
            this.limit = i;
            this.maxAge = j;
            this.unit = timeUnit;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public java.lang.Object enterTransform(java.lang.Object obj) {
            return new io.reactivex.schedulers.Timed(obj, this.scheduler.now(this.unit), this.unit);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public io.reactivex.internal.operators.observable.ObservableReplay.Node getHead() {
            io.reactivex.internal.operators.observable.ObservableReplay.Node node;
            long now = this.scheduler.now(this.unit) - this.maxAge;
            io.reactivex.internal.operators.observable.ObservableReplay.Node node2 = get();
            io.reactivex.internal.operators.observable.ObservableReplay.Node node3 = node2.get();
            while (true) {
                io.reactivex.internal.operators.observable.ObservableReplay.Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 != null) {
                    io.reactivex.schedulers.Timed timed = (io.reactivex.schedulers.Timed) node2.value;
                    if (io.reactivex.internal.util.NotificationLite.isComplete(timed.value()) || io.reactivex.internal.util.NotificationLite.isError(timed.value()) || timed.time() > now) {
                        break;
                    }
                    node3 = node2.get();
                } else {
                    break;
                }
            }
            return node;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public java.lang.Object leaveTransform(java.lang.Object obj) {
            return ((io.reactivex.schedulers.Timed) obj).value();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public void truncate() {
            io.reactivex.internal.operators.observable.ObservableReplay.Node node;
            long now = this.scheduler.now(this.unit) - this.maxAge;
            io.reactivex.internal.operators.observable.ObservableReplay.Node node2 = get();
            io.reactivex.internal.operators.observable.ObservableReplay.Node node3 = node2.get();
            int i = 0;
            while (true) {
                io.reactivex.internal.operators.observable.ObservableReplay.Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null) {
                    break;
                }
                int i2 = this.size;
                if (i2 > this.limit && i2 > 1) {
                    i++;
                    this.size = i2 - 1;
                    node3 = node2.get();
                } else {
                    if (((io.reactivex.schedulers.Timed) node2.value).time() > now) {
                        break;
                    }
                    i++;
                    this.size--;
                    node3 = node2.get();
                }
            }
            if (i != 0) {
                setFirst(node);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
        
            setFirst(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
        
            return;
         */
        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void truncateFinal() {
            long now = this.scheduler.now(this.unit) - this.maxAge;
            io.reactivex.internal.operators.observable.ObservableReplay.Node node = get();
            io.reactivex.internal.operators.observable.ObservableReplay.Node node2 = node.get();
            int i = 0;
            while (true) {
                io.reactivex.internal.operators.observable.ObservableReplay.Node node3 = node2;
                io.reactivex.internal.operators.observable.ObservableReplay.Node node4 = node;
                node = node3;
                if (node == null || this.size <= 1 || ((io.reactivex.schedulers.Timed) node.value).time() > now) {
                    break;
                }
                i++;
                this.size--;
                node2 = node.get();
            }
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        public SizeBoundReplayBuffer(int i) {
            this.limit = i;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    public static final class UnBoundedFactory implements io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier<java.lang.Object> {
        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer<java.lang.Object> call() {
            return new io.reactivex.internal.operators.observable.ObservableReplay.UnboundedReplayBuffer(16);
        }
    }

    public static final class UnboundedReplayBuffer<T> extends java.util.ArrayList<java.lang.Object> implements io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        public UnboundedReplayBuffer(int i) {
            super(i);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void complete() {
            add(io.reactivex.internal.util.NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void error(java.lang.Throwable th) {
            add(io.reactivex.internal.util.NotificationLite.error(th));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void next(T t) {
            add(io.reactivex.internal.util.NotificationLite.next(t));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void replay(io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            io.reactivex.Observer<? super T> observer = innerDisposable.child;
            int i = 1;
            while (!innerDisposable.isDisposed()) {
                int i2 = this.size;
                java.lang.Integer num = (java.lang.Integer) innerDisposable.index();
                int intValue = num != null ? num.intValue() : 0;
                while (intValue < i2) {
                    if (io.reactivex.internal.util.NotificationLite.accept(get(intValue), observer) || innerDisposable.isDisposed()) {
                        return;
                    } else {
                        intValue++;
                    }
                }
                innerDisposable.index = java.lang.Integer.valueOf(intValue);
                i = innerDisposable.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    public ObservableReplay(io.reactivex.ObservableSource<T> observableSource, io.reactivex.ObservableSource<T> observableSource2, java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver<T>> atomicReference, io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier<T> bufferSupplier) {
        this.v = observableSource;
        this.n = observableSource2;
        this.t = atomicReference;
        this.u = bufferSupplier;
    }

    public static <T> io.reactivex.observables.ConnectableObservable<T> create(io.reactivex.ObservableSource<T> observableSource, int i) {
        return i == Integer.MAX_VALUE ? createFrom(observableSource) : e(observableSource, new io.reactivex.internal.operators.observable.ObservableReplay.ReplayBufferSupplier(i));
    }

    public static <T> io.reactivex.observables.ConnectableObservable<T> create(io.reactivex.ObservableSource<T> observableSource, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return create(observableSource, j, timeUnit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> io.reactivex.observables.ConnectableObservable<T> create(io.reactivex.ObservableSource<T> observableSource, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, int i) {
        return e(observableSource, new io.reactivex.internal.operators.observable.ObservableReplay.ScheduledReplaySupplier(i, j, timeUnit, scheduler));
    }

    public static <T> io.reactivex.observables.ConnectableObservable<T> createFrom(io.reactivex.ObservableSource<? extends T> observableSource) {
        return e(observableSource, w);
    }

    public static <T> io.reactivex.observables.ConnectableObservable<T> e(io.reactivex.ObservableSource<T> observableSource, io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier<T> bufferSupplier) {
        java.util.concurrent.atomic.AtomicReference atomicReference = new java.util.concurrent.atomic.AtomicReference();
        return io.reactivex.plugins.RxJavaPlugins.onAssembly((io.reactivex.observables.ConnectableObservable) new io.reactivex.internal.operators.observable.ObservableReplay(new io.reactivex.internal.operators.observable.ObservableReplay.ReplaySource(atomicReference, bufferSupplier), observableSource, atomicReference, bufferSupplier));
    }

    public static <U, R> io.reactivex.Observable<R> multicastSelector(java.util.concurrent.Callable<? extends io.reactivex.observables.ConnectableObservable<U>> callable, io.reactivex.functions.Function<? super io.reactivex.Observable<U>, ? extends io.reactivex.ObservableSource<R>> function) {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableReplay.MulticastReplay(callable, function));
    }

    public static <T> io.reactivex.observables.ConnectableObservable<T> observeOn(io.reactivex.observables.ConnectableObservable<T> connectableObservable, io.reactivex.Scheduler scheduler) {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly((io.reactivex.observables.ConnectableObservable) new io.reactivex.internal.operators.observable.ObservableReplay.Replay(connectableObservable, connectableObservable.observeOn(scheduler)));
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public void connect(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer) {
        io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver<T> replayObserver;
        while (true) {
            replayObserver = this.t.get();
            if (replayObserver != null && !replayObserver.isDisposed()) {
                break;
            }
            io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver<T> replayObserver2 = new io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver<>(this.u.call());
            if (defpackage.xv0.a(this.t, replayObserver, replayObserver2)) {
                replayObserver = replayObserver2;
                break;
            }
        }
        boolean z = !replayObserver.shouldConnect.get() && replayObserver.shouldConnect.compareAndSet(false, true);
        try {
            consumer.accept(replayObserver);
            if (z) {
                this.n.subscribe(replayObserver);
            }
        } catch (java.lang.Throwable th) {
            if (z) {
                replayObserver.shouldConnect.compareAndSet(true, false);
            }
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.internal.disposables.ResettableConnectable
    public void resetIf(io.reactivex.disposables.Disposable disposable) {
        defpackage.xv0.a(this.t, (io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver) disposable, null);
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamObservableSource
    public io.reactivex.ObservableSource<T> source() {
        return this.n;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.v.subscribe(observer);
    }
}
