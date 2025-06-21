package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableReplay<T> extends io.reactivex.flowables.ConnectableFlowable<T> implements io.reactivex.internal.fuseable.HasUpstreamPublisher<T>, io.reactivex.internal.disposables.ResettableConnectable {
    public static final java.util.concurrent.Callable x = new io.reactivex.internal.operators.flowable.FlowableReplay.DefaultUnboundedFactory();
    public final io.reactivex.Flowable<T> t;
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableReplay.ReplaySubscriber<T>> u;
    public final java.util.concurrent.Callable<? extends io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer<T>> v;
    public final org.reactivestreams.Publisher<T> w;

    public static class BoundedReplayBuffer<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableReplay.Node> implements io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        long index;
        int size;
        io.reactivex.internal.operators.flowable.FlowableReplay.Node tail;

        public BoundedReplayBuffer() {
            io.reactivex.internal.operators.flowable.FlowableReplay.Node node = new io.reactivex.internal.operators.flowable.FlowableReplay.Node(null, 0L);
            this.tail = node;
            set(node);
        }

        public final void addLast(io.reactivex.internal.operators.flowable.FlowableReplay.Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        public final void collect(java.util.Collection<? super T> collection) {
            io.reactivex.internal.operators.flowable.FlowableReplay.Node head = getHead();
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

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void complete() {
            java.lang.Object enterTransform = enterTransform(io.reactivex.internal.util.NotificationLite.complete());
            long j = this.index + 1;
            this.index = j;
            addLast(new io.reactivex.internal.operators.flowable.FlowableReplay.Node(enterTransform, j));
            truncateFinal();
        }

        public java.lang.Object enterTransform(java.lang.Object obj) {
            return obj;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void error(java.lang.Throwable th) {
            java.lang.Object enterTransform = enterTransform(io.reactivex.internal.util.NotificationLite.error(th));
            long j = this.index + 1;
            this.index = j;
            addLast(new io.reactivex.internal.operators.flowable.FlowableReplay.Node(enterTransform, j));
            truncateFinal();
        }

        public io.reactivex.internal.operators.flowable.FlowableReplay.Node getHead() {
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

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void next(T t) {
            java.lang.Object enterTransform = enterTransform(io.reactivex.internal.util.NotificationLite.next(t));
            long j = this.index + 1;
            this.index = j;
            addLast(new io.reactivex.internal.operators.flowable.FlowableReplay.Node(enterTransform, j));
            truncate();
        }

        public final void removeFirst() {
            io.reactivex.internal.operators.flowable.FlowableReplay.Node node = get().get();
            if (node == null) {
                throw new java.lang.IllegalStateException("Empty list!");
            }
            this.size--;
            setFirst(node);
        }

        public final void removeSome(int i) {
            io.reactivex.internal.operators.flowable.FlowableReplay.Node node = get();
            while (i > 0) {
                node = node.get();
                i--;
                this.size--;
            }
            setFirst(node);
            io.reactivex.internal.operators.flowable.FlowableReplay.Node node2 = get();
            if (node2.get() == null) {
                this.tail = node2;
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void replay(io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T> innerSubscription) {
            io.reactivex.internal.operators.flowable.FlowableReplay.Node node;
            synchronized (innerSubscription) {
                if (innerSubscription.emitting) {
                    innerSubscription.missed = true;
                    return;
                }
                innerSubscription.emitting = true;
                while (!innerSubscription.isDisposed()) {
                    long j = innerSubscription.get();
                    boolean z = j == Long.MAX_VALUE;
                    io.reactivex.internal.operators.flowable.FlowableReplay.Node node2 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) innerSubscription.index();
                    if (node2 == null) {
                        node2 = getHead();
                        innerSubscription.index = node2;
                        io.reactivex.internal.util.BackpressureHelper.add(innerSubscription.totalRequested, node2.index);
                    }
                    long j2 = 0;
                    while (j != 0 && (node = node2.get()) != null) {
                        java.lang.Object leaveTransform = leaveTransform(node.value);
                        try {
                            if (io.reactivex.internal.util.NotificationLite.accept(leaveTransform, innerSubscription.child)) {
                                innerSubscription.index = null;
                                return;
                            }
                            j2++;
                            j--;
                            if (innerSubscription.isDisposed()) {
                                innerSubscription.index = null;
                                return;
                            }
                            node2 = node;
                        } catch (java.lang.Throwable th) {
                            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                            innerSubscription.index = null;
                            innerSubscription.dispose();
                            if (io.reactivex.internal.util.NotificationLite.isError(leaveTransform) || io.reactivex.internal.util.NotificationLite.isComplete(leaveTransform)) {
                                return;
                            }
                            innerSubscription.child.onError(th);
                            return;
                        }
                    }
                    if (j2 != 0) {
                        innerSubscription.index = node2;
                        if (!z) {
                            innerSubscription.produced(j2);
                        }
                    }
                    synchronized (innerSubscription) {
                        if (!innerSubscription.missed) {
                            innerSubscription.emitting = false;
                            return;
                        }
                        innerSubscription.missed = false;
                    }
                }
                innerSubscription.index = null;
            }
        }

        public final void setFirst(io.reactivex.internal.operators.flowable.FlowableReplay.Node node) {
            set(node);
        }

        public final void trimHead() {
            io.reactivex.internal.operators.flowable.FlowableReplay.Node node = get();
            if (node.value != null) {
                io.reactivex.internal.operators.flowable.FlowableReplay.Node node2 = new io.reactivex.internal.operators.flowable.FlowableReplay.Node(null, 0L);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        public void truncate() {
        }

        public void truncateFinal() {
            trimHead();
        }
    }

    public static final class ConnectableFlowableReplay<T> extends io.reactivex.flowables.ConnectableFlowable<T> {
        public final io.reactivex.flowables.ConnectableFlowable<T> t;
        public final io.reactivex.Flowable<T> u;

        public ConnectableFlowableReplay(io.reactivex.flowables.ConnectableFlowable<T> connectableFlowable, io.reactivex.Flowable<T> flowable) {
            this.t = connectableFlowable;
            this.u = flowable;
        }

        @Override // io.reactivex.flowables.ConnectableFlowable
        public void connect(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer) {
            this.t.connect(consumer);
        }

        @Override // io.reactivex.Flowable
        public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
            this.u.subscribe(subscriber);
        }
    }

    public static final class DefaultUnboundedFactory implements java.util.concurrent.Callable<java.lang.Object> {
        @Override // java.util.concurrent.Callable
        public java.lang.Object call() {
            return new io.reactivex.internal.operators.flowable.FlowableReplay.UnboundedReplayBuffer(16);
        }
    }

    public static final class InnerSubscription<T> extends java.util.concurrent.atomic.AtomicLong implements org.reactivestreams.Subscription, io.reactivex.disposables.Disposable {
        static final long CANCELLED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final org.reactivestreams.Subscriber<? super T> child;
        boolean emitting;
        java.lang.Object index;
        boolean missed;
        final io.reactivex.internal.operators.flowable.FlowableReplay.ReplaySubscriber<T> parent;
        final java.util.concurrent.atomic.AtomicLong totalRequested = new java.util.concurrent.atomic.AtomicLong();

        public InnerSubscription(io.reactivex.internal.operators.flowable.FlowableReplay.ReplaySubscriber<T> replaySubscriber, org.reactivestreams.Subscriber<? super T> subscriber) {
            this.parent = replaySubscriber;
            this.child = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.manageRequests();
                this.index = null;
            }
        }

        public <U> U index() {
            return (U) this.index;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == Long.MIN_VALUE;
        }

        public long produced(long j) {
            return io.reactivex.internal.util.BackpressureHelper.producedCancel(this, j);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (!io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j) || io.reactivex.internal.util.BackpressureHelper.addCancel(this, j) == Long.MIN_VALUE) {
                return;
            }
            io.reactivex.internal.util.BackpressureHelper.add(this.totalRequested, j);
            this.parent.manageRequests();
            this.parent.buffer.replay(this);
        }
    }

    public static final class MulticastFlowable<R, U> extends io.reactivex.Flowable<R> {
        public final java.util.concurrent.Callable<? extends io.reactivex.flowables.ConnectableFlowable<U>> t;
        public final io.reactivex.functions.Function<? super io.reactivex.Flowable<U>, ? extends org.reactivestreams.Publisher<R>> u;

        public final class DisposableConsumer implements io.reactivex.functions.Consumer<io.reactivex.disposables.Disposable> {
            public final io.reactivex.internal.subscribers.SubscriberResourceWrapper<R> n;

            public DisposableConsumer(io.reactivex.internal.subscribers.SubscriberResourceWrapper<R> subscriberResourceWrapper) {
                this.n = subscriberResourceWrapper;
            }

            @Override // io.reactivex.functions.Consumer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(io.reactivex.disposables.Disposable disposable) {
                this.n.setResource(disposable);
            }
        }

        public MulticastFlowable(java.util.concurrent.Callable<? extends io.reactivex.flowables.ConnectableFlowable<U>> callable, io.reactivex.functions.Function<? super io.reactivex.Flowable<U>, ? extends org.reactivestreams.Publisher<R>> function) {
            this.t = callable;
            this.u = function;
        }

        @Override // io.reactivex.Flowable
        public void subscribeActual(org.reactivestreams.Subscriber<? super R> subscriber) {
            try {
                io.reactivex.flowables.ConnectableFlowable connectableFlowable = (io.reactivex.flowables.ConnectableFlowable) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The connectableFactory returned null");
                try {
                    org.reactivestreams.Publisher publisher = (org.reactivestreams.Publisher) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.u.apply(connectableFlowable), "The selector returned a null Publisher");
                    io.reactivex.internal.subscribers.SubscriberResourceWrapper subscriberResourceWrapper = new io.reactivex.internal.subscribers.SubscriberResourceWrapper(subscriber);
                    publisher.subscribe(subscriberResourceWrapper);
                    connectableFlowable.connect(new io.reactivex.internal.operators.flowable.FlowableReplay.MulticastFlowable.DisposableConsumer(subscriberResourceWrapper));
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    io.reactivex.internal.subscriptions.EmptySubscription.error(th, subscriber);
                }
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                io.reactivex.internal.subscriptions.EmptySubscription.error(th2, subscriber);
            }
        }
    }

    public static final class Node extends java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableReplay.Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final java.lang.Object value;

        public Node(java.lang.Object obj, long j) {
            this.value = obj;
            this.index = j;
        }
    }

    public interface ReplayBuffer<T> {
        void complete();

        void error(java.lang.Throwable th);

        void next(T t);

        void replay(io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T> innerSubscription);
    }

    public static final class ReplayBufferTask<T> implements java.util.concurrent.Callable<io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer<T>> {
        public final int n;

        public ReplayBufferTask(int i) {
            this.n = i;
        }

        @Override // java.util.concurrent.Callable
        public io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer<T> call() {
            return new io.reactivex.internal.operators.flowable.FlowableReplay.SizeBoundReplayBuffer(this.n);
        }
    }

    public static final class ReplayPublisher<T> implements org.reactivestreams.Publisher<T> {
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableReplay.ReplaySubscriber<T>> n;
        public final java.util.concurrent.Callable<? extends io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer<T>> t;

        public ReplayPublisher(java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableReplay.ReplaySubscriber<T>> atomicReference, java.util.concurrent.Callable<? extends io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer<T>> callable) {
            this.n = atomicReference;
            this.t = callable;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(org.reactivestreams.Subscriber<? super T> subscriber) {
            io.reactivex.internal.operators.flowable.FlowableReplay.ReplaySubscriber<T> replaySubscriber;
            while (true) {
                replaySubscriber = this.n.get();
                if (replaySubscriber != null) {
                    break;
                }
                try {
                    io.reactivex.internal.operators.flowable.FlowableReplay.ReplaySubscriber<T> replaySubscriber2 = new io.reactivex.internal.operators.flowable.FlowableReplay.ReplaySubscriber<>(this.t.call());
                    if (defpackage.xv0.a(this.n, null, replaySubscriber2)) {
                        replaySubscriber = replaySubscriber2;
                        break;
                    }
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    io.reactivex.internal.subscriptions.EmptySubscription.error(th, subscriber);
                    return;
                }
            }
            io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T> innerSubscription = new io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<>(replaySubscriber, subscriber);
            subscriber.onSubscribe(innerSubscription);
            replaySubscriber.add(innerSubscription);
            if (innerSubscription.isDisposed()) {
                replaySubscriber.remove(innerSubscription);
            } else {
                replaySubscriber.manageRequests();
                replaySubscriber.buffer.replay(innerSubscription);
            }
        }
    }

    public static final class ReplaySubscriber<T> extends java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> implements io.reactivex.FlowableSubscriber<T>, io.reactivex.disposables.Disposable {
        static final io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription[] EMPTY = new io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription[0];
        static final io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription[] TERMINATED = new io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription[0];
        private static final long serialVersionUID = 7224554242710036740L;
        final io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer<T> buffer;
        boolean done;
        long maxChildRequested;
        long maxUpstreamRequested;
        final java.util.concurrent.atomic.AtomicInteger management = new java.util.concurrent.atomic.AtomicInteger();
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T>[]> subscribers = new java.util.concurrent.atomic.AtomicReference<>(EMPTY);
        final java.util.concurrent.atomic.AtomicBoolean shouldConnect = new java.util.concurrent.atomic.AtomicBoolean();

        public ReplaySubscriber(io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer<T> replayBuffer) {
            this.buffer = replayBuffer;
        }

        public boolean add(io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T> innerSubscription) {
            io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T>[] innerSubscriptionArr;
            io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription[] innerSubscriptionArr2;
            innerSubscription.getClass();
            do {
                innerSubscriptionArr = this.subscribers.get();
                if (innerSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription[length + 1];
                java.lang.System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!defpackage.xv0.a(this.subscribers, innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.subscribers.set(TERMINATED);
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        public void manageRequests() {
            if (this.management.getAndIncrement() != 0) {
                return;
            }
            int i = 1;
            while (!isDisposed()) {
                io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T>[] innerSubscriptionArr = this.subscribers.get();
                long j = this.maxChildRequested;
                long j2 = j;
                for (io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T> innerSubscription : innerSubscriptionArr) {
                    j2 = java.lang.Math.max(j2, innerSubscription.totalRequested.get());
                }
                long j3 = this.maxUpstreamRequested;
                org.reactivestreams.Subscription subscription = get();
                long j4 = j2 - j;
                if (j4 != 0) {
                    this.maxChildRequested = j2;
                    if (subscription == null) {
                        long j5 = j3 + j4;
                        if (j5 < 0) {
                            j5 = Long.MAX_VALUE;
                        }
                        this.maxUpstreamRequested = j5;
                    } else if (j3 != 0) {
                        this.maxUpstreamRequested = 0L;
                        subscription.request(j3 + j4);
                    } else {
                        subscription.request(j4);
                    }
                } else if (j3 != 0 && subscription != null) {
                    this.maxUpstreamRequested = 0L;
                    subscription.request(j3);
                }
                i = this.management.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.buffer.complete();
            for (io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                this.buffer.replay(innerSubscription);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.done) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.buffer.error(th);
            for (io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                this.buffer.replay(innerSubscription);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            this.buffer.next(t);
            for (io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                this.buffer.replay(innerSubscription);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this, subscription)) {
                manageRequests();
                for (io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                    this.buffer.replay(innerSubscription);
                }
            }
        }

        public void remove(io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T> innerSubscription) {
            io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T>[] innerSubscriptionArr;
            io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.subscribers.get();
                int length = innerSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (innerSubscriptionArr[i].equals(innerSubscription)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriptionArr2 = EMPTY;
                } else {
                    io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription[] innerSubscriptionArr3 = new io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription[length - 1];
                    java.lang.System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i);
                    java.lang.System.arraycopy(innerSubscriptionArr, i + 1, innerSubscriptionArr3, i, (length - i) - 1);
                    innerSubscriptionArr2 = innerSubscriptionArr3;
                }
            } while (!defpackage.xv0.a(this.subscribers, innerSubscriptionArr, innerSubscriptionArr2));
        }
    }

    public static final class ScheduledReplayBufferTask<T> implements java.util.concurrent.Callable<io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer<T>> {
        public final int n;
        public final long t;
        public final java.util.concurrent.TimeUnit u;
        public final io.reactivex.Scheduler v;

        public ScheduledReplayBufferTask(int i, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
            this.n = i;
            this.t = j;
            this.u = timeUnit;
            this.v = scheduler;
        }

        @Override // java.util.concurrent.Callable
        public io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer<T> call() {
            return new io.reactivex.internal.operators.flowable.FlowableReplay.SizeAndTimeBoundReplayBuffer(this.n, this.t, this.u, this.v);
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer<T> {
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

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public java.lang.Object enterTransform(java.lang.Object obj) {
            return new io.reactivex.schedulers.Timed(obj, this.scheduler.now(this.unit), this.unit);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public io.reactivex.internal.operators.flowable.FlowableReplay.Node getHead() {
            io.reactivex.internal.operators.flowable.FlowableReplay.Node node;
            long now = this.scheduler.now(this.unit) - this.maxAge;
            io.reactivex.internal.operators.flowable.FlowableReplay.Node node2 = get();
            io.reactivex.internal.operators.flowable.FlowableReplay.Node node3 = node2.get();
            while (true) {
                io.reactivex.internal.operators.flowable.FlowableReplay.Node node4 = node3;
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

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public java.lang.Object leaveTransform(java.lang.Object obj) {
            return ((io.reactivex.schedulers.Timed) obj).value();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public void truncate() {
            io.reactivex.internal.operators.flowable.FlowableReplay.Node node;
            long now = this.scheduler.now(this.unit) - this.maxAge;
            io.reactivex.internal.operators.flowable.FlowableReplay.Node node2 = get();
            io.reactivex.internal.operators.flowable.FlowableReplay.Node node3 = node2.get();
            int i = 0;
            while (true) {
                io.reactivex.internal.operators.flowable.FlowableReplay.Node node4 = node3;
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
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void truncateFinal() {
            long now = this.scheduler.now(this.unit) - this.maxAge;
            io.reactivex.internal.operators.flowable.FlowableReplay.Node node = get();
            io.reactivex.internal.operators.flowable.FlowableReplay.Node node2 = node.get();
            int i = 0;
            while (true) {
                io.reactivex.internal.operators.flowable.FlowableReplay.Node node3 = node2;
                io.reactivex.internal.operators.flowable.FlowableReplay.Node node4 = node;
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

    public static final class SizeBoundReplayBuffer<T> extends io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        public SizeBoundReplayBuffer(int i) {
            this.limit = i;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        public void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    public static final class UnboundedReplayBuffer<T> extends java.util.ArrayList<java.lang.Object> implements io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        public UnboundedReplayBuffer(int i) {
            super(i);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void complete() {
            add(io.reactivex.internal.util.NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void error(java.lang.Throwable th) {
            add(io.reactivex.internal.util.NotificationLite.error(th));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void next(T t) {
            add(io.reactivex.internal.util.NotificationLite.next(t));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void replay(io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription<T> innerSubscription) {
            synchronized (innerSubscription) {
                if (innerSubscription.emitting) {
                    innerSubscription.missed = true;
                    return;
                }
                innerSubscription.emitting = true;
                org.reactivestreams.Subscriber<? super T> subscriber = innerSubscription.child;
                while (!innerSubscription.isDisposed()) {
                    int i = this.size;
                    java.lang.Integer num = (java.lang.Integer) innerSubscription.index();
                    int intValue = num != null ? num.intValue() : 0;
                    long j = innerSubscription.get();
                    long j2 = j;
                    long j3 = 0;
                    while (j2 != 0 && intValue < i) {
                        java.lang.Object obj = get(intValue);
                        try {
                            if (io.reactivex.internal.util.NotificationLite.accept(obj, subscriber) || innerSubscription.isDisposed()) {
                                return;
                            }
                            intValue++;
                            j2--;
                            j3++;
                        } catch (java.lang.Throwable th) {
                            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                            innerSubscription.dispose();
                            if (io.reactivex.internal.util.NotificationLite.isError(obj) || io.reactivex.internal.util.NotificationLite.isComplete(obj)) {
                                return;
                            }
                            subscriber.onError(th);
                            return;
                        }
                    }
                    if (j3 != 0) {
                        innerSubscription.index = java.lang.Integer.valueOf(intValue);
                        if (j != Long.MAX_VALUE) {
                            innerSubscription.produced(j3);
                        }
                    }
                    synchronized (innerSubscription) {
                        if (!innerSubscription.missed) {
                            innerSubscription.emitting = false;
                            return;
                        }
                        innerSubscription.missed = false;
                    }
                }
            }
        }
    }

    public FlowableReplay(org.reactivestreams.Publisher<T> publisher, io.reactivex.Flowable<T> flowable, java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableReplay.ReplaySubscriber<T>> atomicReference, java.util.concurrent.Callable<? extends io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer<T>> callable) {
        this.w = publisher;
        this.t = flowable;
        this.u = atomicReference;
        this.v = callable;
    }

    public static <T> io.reactivex.flowables.ConnectableFlowable<T> create(io.reactivex.Flowable<T> flowable, int i) {
        return i == Integer.MAX_VALUE ? createFrom(flowable) : f(flowable, new io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBufferTask(i));
    }

    public static <T> io.reactivex.flowables.ConnectableFlowable<T> create(io.reactivex.Flowable<T> flowable, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return create(flowable, j, timeUnit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> io.reactivex.flowables.ConnectableFlowable<T> create(io.reactivex.Flowable<T> flowable, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, int i) {
        return f(flowable, new io.reactivex.internal.operators.flowable.FlowableReplay.ScheduledReplayBufferTask(i, j, timeUnit, scheduler));
    }

    public static <T> io.reactivex.flowables.ConnectableFlowable<T> createFrom(io.reactivex.Flowable<? extends T> flowable) {
        return f(flowable, x);
    }

    public static <T> io.reactivex.flowables.ConnectableFlowable<T> f(io.reactivex.Flowable<T> flowable, java.util.concurrent.Callable<? extends io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer<T>> callable) {
        java.util.concurrent.atomic.AtomicReference atomicReference = new java.util.concurrent.atomic.AtomicReference();
        return io.reactivex.plugins.RxJavaPlugins.onAssembly((io.reactivex.flowables.ConnectableFlowable) new io.reactivex.internal.operators.flowable.FlowableReplay(new io.reactivex.internal.operators.flowable.FlowableReplay.ReplayPublisher(atomicReference, callable), flowable, atomicReference, callable));
    }

    public static <U, R> io.reactivex.Flowable<R> multicastSelector(java.util.concurrent.Callable<? extends io.reactivex.flowables.ConnectableFlowable<U>> callable, io.reactivex.functions.Function<? super io.reactivex.Flowable<U>, ? extends org.reactivestreams.Publisher<R>> function) {
        return new io.reactivex.internal.operators.flowable.FlowableReplay.MulticastFlowable(callable, function);
    }

    public static <T> io.reactivex.flowables.ConnectableFlowable<T> observeOn(io.reactivex.flowables.ConnectableFlowable<T> connectableFlowable, io.reactivex.Scheduler scheduler) {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly((io.reactivex.flowables.ConnectableFlowable) new io.reactivex.internal.operators.flowable.FlowableReplay.ConnectableFlowableReplay(connectableFlowable, connectableFlowable.observeOn(scheduler)));
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public void connect(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer) {
        io.reactivex.internal.operators.flowable.FlowableReplay.ReplaySubscriber<T> replaySubscriber;
        while (true) {
            replaySubscriber = this.u.get();
            if (replaySubscriber != null && !replaySubscriber.isDisposed()) {
                break;
            }
            try {
                io.reactivex.internal.operators.flowable.FlowableReplay.ReplaySubscriber<T> replaySubscriber2 = new io.reactivex.internal.operators.flowable.FlowableReplay.ReplaySubscriber<>(this.v.call());
                if (defpackage.xv0.a(this.u, replaySubscriber, replaySubscriber2)) {
                    replaySubscriber = replaySubscriber2;
                    break;
                }
            } finally {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                java.lang.RuntimeException wrapOrThrow = io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
            }
        }
        boolean z = !replaySubscriber.shouldConnect.get() && replaySubscriber.shouldConnect.compareAndSet(false, true);
        try {
            consumer.accept(replaySubscriber);
            if (z) {
                this.t.subscribe((io.reactivex.FlowableSubscriber) replaySubscriber);
            }
        } catch (java.lang.Throwable th) {
            if (z) {
                replaySubscriber.shouldConnect.compareAndSet(true, false);
            }
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.internal.disposables.ResettableConnectable
    public void resetIf(io.reactivex.disposables.Disposable disposable) {
        defpackage.xv0.a(this.u, (io.reactivex.internal.operators.flowable.FlowableReplay.ReplaySubscriber) disposable, null);
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public org.reactivestreams.Publisher<T> source() {
        return this.t;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.w.subscribe(subscriber);
    }
}
