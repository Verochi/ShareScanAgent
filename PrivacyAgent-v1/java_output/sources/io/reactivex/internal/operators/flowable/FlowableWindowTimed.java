package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableWindowTimed<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, io.reactivex.Flowable<T>> {
    public final long t;
    public final long u;
    public final java.util.concurrent.TimeUnit v;
    public final io.reactivex.Scheduler w;
    public final long x;
    public final int y;
    public final boolean z;

    public static final class WindowExactBoundedSubscriber<T> extends io.reactivex.internal.subscribers.QueueDrainSubscriber<T, java.lang.Object, io.reactivex.Flowable<T>> implements org.reactivestreams.Subscription {
        public final io.reactivex.Scheduler.Worker A;
        public long B;
        public long C;
        public org.reactivestreams.Subscription D;
        public io.reactivex.processors.UnicastProcessor<T> E;
        public volatile boolean F;
        public final io.reactivex.internal.disposables.SequentialDisposable G;
        public final long u;
        public final java.util.concurrent.TimeUnit v;
        public final io.reactivex.Scheduler w;
        public final int x;
        public final boolean y;
        public final long z;

        public static final class ConsumerIndexHolder implements java.lang.Runnable {
            public final long n;
            public final io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactBoundedSubscriber<?> t;

            public ConsumerIndexHolder(long j, io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber) {
                this.n = j;
                this.t = windowExactBoundedSubscriber;
            }

            @Override // java.lang.Runnable
            public void run() {
                io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber = this.t;
                if (((io.reactivex.internal.subscribers.QueueDrainSubscriber) windowExactBoundedSubscriber).cancelled) {
                    windowExactBoundedSubscriber.F = true;
                } else {
                    ((io.reactivex.internal.subscribers.QueueDrainSubscriber) windowExactBoundedSubscriber).queue.offer(this);
                }
                if (windowExactBoundedSubscriber.enter()) {
                    windowExactBoundedSubscriber.d();
                }
            }
        }

        public WindowExactBoundedSubscriber(org.reactivestreams.Subscriber<? super io.reactivex.Flowable<T>> subscriber, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, int i, long j2, boolean z) {
            super(subscriber, new io.reactivex.internal.queue.MpscLinkedQueue());
            this.G = new io.reactivex.internal.disposables.SequentialDisposable();
            this.u = j;
            this.v = timeUnit;
            this.w = scheduler;
            this.x = i;
            this.z = j2;
            this.y = z;
            if (z) {
                this.A = scheduler.createWorker();
            } else {
                this.A = null;
            }
        }

        public void c() {
            this.G.dispose();
            io.reactivex.Scheduler.Worker worker = this.A;
            if (worker != null) {
                worker.dispose();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
        
            if (r17.C == r7.n) goto L33;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void d() {
            io.reactivex.internal.fuseable.SimpleQueue simpleQueue = this.queue;
            org.reactivestreams.Subscriber<? super V> subscriber = this.downstream;
            io.reactivex.processors.UnicastProcessor<T> unicastProcessor = this.E;
            int i = 1;
            while (!this.F) {
                boolean z = this.done;
                java.lang.Object poll = simpleQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactBoundedSubscriber.ConsumerIndexHolder;
                if (z && (z2 || z3)) {
                    this.E = null;
                    simpleQueue.clear();
                    java.lang.Throwable th = this.error;
                    if (th != null) {
                        ((io.reactivex.processors.UnicastProcessor) unicastProcessor).onError(th);
                    } else {
                        ((io.reactivex.processors.UnicastProcessor) unicastProcessor).onComplete();
                    }
                    c();
                    return;
                }
                if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    int i2 = i;
                    if (z3) {
                        io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactBoundedSubscriber.ConsumerIndexHolder consumerIndexHolder = (io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactBoundedSubscriber.ConsumerIndexHolder) poll;
                        if (this.y) {
                            unicastProcessor = unicastProcessor;
                        }
                        ((io.reactivex.processors.UnicastProcessor) unicastProcessor).onComplete();
                        this.B = 0L;
                        io.reactivex.processors.UnicastProcessor<T> create = io.reactivex.processors.UnicastProcessor.create(this.x);
                        this.E = create;
                        long requested = requested();
                        if (requested == 0) {
                            this.E = null;
                            this.queue.clear();
                            this.D.cancel();
                            subscriber.onError(new io.reactivex.exceptions.MissingBackpressureException("Could not deliver first window due to lack of requests."));
                            c();
                            return;
                        }
                        subscriber.onNext(create);
                        unicastProcessor = create;
                        if (requested != Long.MAX_VALUE) {
                            produced(1L);
                            unicastProcessor = create;
                        }
                    } else {
                        ((io.reactivex.processors.UnicastProcessor) unicastProcessor).onNext(io.reactivex.internal.util.NotificationLite.getValue(poll));
                        long j = this.B + 1;
                        if (j >= this.z) {
                            this.C++;
                            this.B = 0L;
                            ((io.reactivex.processors.UnicastProcessor) unicastProcessor).onComplete();
                            long requested2 = requested();
                            if (requested2 == 0) {
                                this.E = null;
                                this.D.cancel();
                                this.downstream.onError(new io.reactivex.exceptions.MissingBackpressureException("Could not deliver window due to lack of requests"));
                                c();
                                return;
                            }
                            io.reactivex.processors.UnicastProcessor<T> create2 = io.reactivex.processors.UnicastProcessor.create(this.x);
                            this.E = create2;
                            this.downstream.onNext(create2);
                            if (requested2 != Long.MAX_VALUE) {
                                produced(1L);
                            }
                            if (this.y) {
                                this.G.get().dispose();
                                io.reactivex.Scheduler.Worker worker = this.A;
                                io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactBoundedSubscriber.ConsumerIndexHolder consumerIndexHolder2 = new io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactBoundedSubscriber.ConsumerIndexHolder(this.C, this);
                                long j2 = this.u;
                                this.G.replace(worker.schedulePeriodically(consumerIndexHolder2, j2, j2, this.v));
                            }
                            unicastProcessor = create2;
                        } else {
                            this.B = j;
                            unicastProcessor = unicastProcessor;
                        }
                    }
                    i = i2;
                }
            }
            this.D.cancel();
            simpleQueue.clear();
            c();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter()) {
                d();
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                d();
            }
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.F) {
                return;
            }
            if (fastEnter()) {
                io.reactivex.processors.UnicastProcessor<T> unicastProcessor = this.E;
                unicastProcessor.onNext(t);
                long j = this.B + 1;
                if (j >= this.z) {
                    this.C++;
                    this.B = 0L;
                    unicastProcessor.onComplete();
                    long requested = requested();
                    if (requested == 0) {
                        this.E = null;
                        this.D.cancel();
                        this.downstream.onError(new io.reactivex.exceptions.MissingBackpressureException("Could not deliver window due to lack of requests"));
                        c();
                        return;
                    }
                    io.reactivex.processors.UnicastProcessor<T> create = io.reactivex.processors.UnicastProcessor.create(this.x);
                    this.E = create;
                    this.downstream.onNext(create);
                    if (requested != Long.MAX_VALUE) {
                        produced(1L);
                    }
                    if (this.y) {
                        this.G.get().dispose();
                        io.reactivex.Scheduler.Worker worker = this.A;
                        io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactBoundedSubscriber.ConsumerIndexHolder consumerIndexHolder = new io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactBoundedSubscriber.ConsumerIndexHolder(this.C, this);
                        long j2 = this.u;
                        this.G.replace(worker.schedulePeriodically(consumerIndexHolder, j2, j2, this.v));
                    }
                } else {
                    this.B = j;
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
            d();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            io.reactivex.disposables.Disposable schedulePeriodicallyDirect;
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.D, subscription)) {
                this.D = subscription;
                org.reactivestreams.Subscriber<? super V> subscriber = this.downstream;
                subscriber.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                io.reactivex.processors.UnicastProcessor<T> create = io.reactivex.processors.UnicastProcessor.create(this.x);
                this.E = create;
                long requested = requested();
                if (requested == 0) {
                    this.cancelled = true;
                    subscription.cancel();
                    subscriber.onError(new io.reactivex.exceptions.MissingBackpressureException("Could not deliver initial window due to lack of requests."));
                    return;
                }
                subscriber.onNext(create);
                if (requested != Long.MAX_VALUE) {
                    produced(1L);
                }
                io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactBoundedSubscriber.ConsumerIndexHolder consumerIndexHolder = new io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactBoundedSubscriber.ConsumerIndexHolder(this.C, this);
                if (this.y) {
                    io.reactivex.Scheduler.Worker worker = this.A;
                    long j = this.u;
                    schedulePeriodicallyDirect = worker.schedulePeriodically(consumerIndexHolder, j, j, this.v);
                } else {
                    io.reactivex.Scheduler scheduler = this.w;
                    long j2 = this.u;
                    schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(consumerIndexHolder, j2, j2, this.v);
                }
                if (this.G.replace(schedulePeriodicallyDirect)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }
    }

    public static final class WindowExactUnboundedSubscriber<T> extends io.reactivex.internal.subscribers.QueueDrainSubscriber<T, java.lang.Object, io.reactivex.Flowable<T>> implements org.reactivestreams.Subscription, java.lang.Runnable {
        public static final java.lang.Object C = new java.lang.Object();
        public final io.reactivex.internal.disposables.SequentialDisposable A;
        public volatile boolean B;
        public final long u;
        public final java.util.concurrent.TimeUnit v;
        public final io.reactivex.Scheduler w;
        public final int x;
        public org.reactivestreams.Subscription y;
        public io.reactivex.processors.UnicastProcessor<T> z;

        public WindowExactUnboundedSubscriber(org.reactivestreams.Subscriber<? super io.reactivex.Flowable<T>> subscriber, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, int i) {
            super(subscriber, new io.reactivex.internal.queue.MpscLinkedQueue());
            this.A = new io.reactivex.internal.disposables.SequentialDisposable();
            this.u = j;
            this.v = timeUnit;
            this.w = scheduler;
            this.x = i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
        
            r10.A.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
        
            r10.z = null;
            r0.clear();
            r0 = r10.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
        
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.processors.UnicastProcessor<T>] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a() {
            io.reactivex.internal.fuseable.SimpleQueue simpleQueue = this.queue;
            org.reactivestreams.Subscriber<? super V> subscriber = this.downstream;
            io.reactivex.processors.UnicastProcessor<T> unicastProcessor = this.z;
            int i = 1;
            while (true) {
                boolean z = this.B;
                boolean z2 = this.done;
                java.lang.Object poll = simpleQueue.poll();
                if (!z2 || (poll != null && poll != C)) {
                    if (poll == null) {
                        i = leave(-i);
                        if (i == 0) {
                            return;
                        }
                    } else if (poll == C) {
                        unicastProcessor.onComplete();
                        if (z) {
                            this.y.cancel();
                        } else {
                            unicastProcessor = (io.reactivex.processors.UnicastProcessor<T>) io.reactivex.processors.UnicastProcessor.create(this.x);
                            this.z = unicastProcessor;
                            long requested = requested();
                            if (requested == 0) {
                                this.z = null;
                                this.queue.clear();
                                this.y.cancel();
                                subscriber.onError(new io.reactivex.exceptions.MissingBackpressureException("Could not deliver first window due to lack of requests."));
                                this.A.dispose();
                                return;
                            }
                            subscriber.onNext(unicastProcessor);
                            if (requested != Long.MAX_VALUE) {
                                produced(1L);
                            }
                        }
                    } else {
                        unicastProcessor.onNext(io.reactivex.internal.util.NotificationLite.getValue(poll));
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter()) {
                a();
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                a();
            }
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.B) {
                return;
            }
            if (fastEnter()) {
                this.z.onNext(t);
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(io.reactivex.internal.util.NotificationLite.next(t));
                if (!enter()) {
                    return;
                }
            }
            a();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.y, subscription)) {
                this.y = subscription;
                this.z = io.reactivex.processors.UnicastProcessor.create(this.x);
                org.reactivestreams.Subscriber<? super V> subscriber = this.downstream;
                subscriber.onSubscribe(this);
                long requested = requested();
                if (requested == 0) {
                    this.cancelled = true;
                    subscription.cancel();
                    subscriber.onError(new io.reactivex.exceptions.MissingBackpressureException("Could not deliver first window due to lack of requests."));
                    return;
                }
                subscriber.onNext(this.z);
                if (requested != Long.MAX_VALUE) {
                    produced(1L);
                }
                if (this.cancelled) {
                    return;
                }
                io.reactivex.internal.disposables.SequentialDisposable sequentialDisposable = this.A;
                io.reactivex.Scheduler scheduler = this.w;
                long j = this.u;
                if (sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, j, j, this.v))) {
                    subscription.request(Long.MAX_VALUE);
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
                this.B = true;
            }
            this.queue.offer(C);
            if (enter()) {
                a();
            }
        }
    }

    public static final class WindowSkipSubscriber<T> extends io.reactivex.internal.subscribers.QueueDrainSubscriber<T, java.lang.Object, io.reactivex.Flowable<T>> implements org.reactivestreams.Subscription, java.lang.Runnable {
        public org.reactivestreams.Subscription A;
        public volatile boolean B;
        public final long u;
        public final long v;
        public final java.util.concurrent.TimeUnit w;
        public final io.reactivex.Scheduler.Worker x;
        public final int y;
        public final java.util.List<io.reactivex.processors.UnicastProcessor<T>> z;

        public final class Completion implements java.lang.Runnable {
            public final io.reactivex.processors.UnicastProcessor<T> n;

            public Completion(io.reactivex.processors.UnicastProcessor<T> unicastProcessor) {
                this.n = unicastProcessor;
            }

            @Override // java.lang.Runnable
            public void run() {
                io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowSkipSubscriber.this.a(this.n);
            }
        }

        public static final class SubjectWork<T> {
            public final io.reactivex.processors.UnicastProcessor<T> a;
            public final boolean b;

            public SubjectWork(io.reactivex.processors.UnicastProcessor<T> unicastProcessor, boolean z) {
                this.a = unicastProcessor;
                this.b = z;
            }
        }

        public WindowSkipSubscriber(org.reactivestreams.Subscriber<? super io.reactivex.Flowable<T>> subscriber, long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler.Worker worker, int i) {
            super(subscriber, new io.reactivex.internal.queue.MpscLinkedQueue());
            this.u = j;
            this.v = j2;
            this.w = timeUnit;
            this.x = worker;
            this.y = i;
            this.z = new java.util.LinkedList();
        }

        public void a(io.reactivex.processors.UnicastProcessor<T> unicastProcessor) {
            this.queue.offer(new io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowSkipSubscriber.SubjectWork(unicastProcessor, false));
            if (enter()) {
                b();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void b() {
            io.reactivex.internal.fuseable.SimpleQueue simpleQueue = this.queue;
            org.reactivestreams.Subscriber<? super V> subscriber = this.downstream;
            java.util.List<io.reactivex.processors.UnicastProcessor<T>> list = this.z;
            int i = 1;
            while (!this.B) {
                boolean z = this.done;
                java.lang.Object poll = simpleQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowSkipSubscriber.SubjectWork;
                if (z && (z2 || z3)) {
                    simpleQueue.clear();
                    java.lang.Throwable th = this.error;
                    if (th != null) {
                        java.util.Iterator<io.reactivex.processors.UnicastProcessor<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        java.util.Iterator<io.reactivex.processors.UnicastProcessor<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    this.x.dispose();
                    return;
                }
                if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowSkipSubscriber.SubjectWork subjectWork = (io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowSkipSubscriber.SubjectWork) poll;
                    if (!subjectWork.b) {
                        list.remove(subjectWork.a);
                        subjectWork.a.onComplete();
                        if (list.isEmpty() && this.cancelled) {
                            this.B = true;
                        }
                    } else if (!this.cancelled) {
                        long requested = requested();
                        if (requested != 0) {
                            io.reactivex.processors.UnicastProcessor<T> create = io.reactivex.processors.UnicastProcessor.create(this.y);
                            list.add(create);
                            subscriber.onNext(create);
                            if (requested != Long.MAX_VALUE) {
                                produced(1L);
                            }
                            this.x.schedule(new io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowSkipSubscriber.Completion(create), this.u, this.w);
                        } else {
                            subscriber.onError(new io.reactivex.exceptions.MissingBackpressureException("Can't emit window due to lack of requests"));
                        }
                    }
                } else {
                    java.util.Iterator<io.reactivex.processors.UnicastProcessor<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(poll);
                    }
                }
            }
            this.A.cancel();
            simpleQueue.clear();
            list.clear();
            this.x.dispose();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter()) {
                b();
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                b();
            }
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (fastEnter()) {
                java.util.Iterator<io.reactivex.processors.UnicastProcessor<T>> it = this.z.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(t);
                if (!enter()) {
                    return;
                }
            }
            b();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.A, subscription)) {
                this.A = subscription;
                this.downstream.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                long requested = requested();
                if (requested == 0) {
                    subscription.cancel();
                    this.downstream.onError(new io.reactivex.exceptions.MissingBackpressureException("Could not emit the first window due to lack of requests"));
                    return;
                }
                io.reactivex.processors.UnicastProcessor<T> create = io.reactivex.processors.UnicastProcessor.create(this.y);
                this.z.add(create);
                this.downstream.onNext(create);
                if (requested != Long.MAX_VALUE) {
                    produced(1L);
                }
                this.x.schedule(new io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowSkipSubscriber.Completion(create), this.u, this.w);
                io.reactivex.Scheduler.Worker worker = this.x;
                long j = this.v;
                worker.schedulePeriodically(this, j, j, this.w);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowSkipSubscriber.SubjectWork subjectWork = new io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowSkipSubscriber.SubjectWork(io.reactivex.processors.UnicastProcessor.create(this.y), true);
            if (!this.cancelled) {
                this.queue.offer(subjectWork);
            }
            if (enter()) {
                b();
            }
        }
    }

    public FlowableWindowTimed(io.reactivex.Flowable<T> flowable, long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, long j3, int i, boolean z) {
        super(flowable);
        this.t = j;
        this.u = j2;
        this.v = timeUnit;
        this.w = scheduler;
        this.x = j3;
        this.y = i;
        this.z = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super io.reactivex.Flowable<T>> subscriber) {
        io.reactivex.subscribers.SerializedSubscriber serializedSubscriber = new io.reactivex.subscribers.SerializedSubscriber(subscriber);
        long j = this.t;
        long j2 = this.u;
        if (j != j2) {
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowSkipSubscriber(serializedSubscriber, j, j2, this.v, this.w.createWorker(), this.y));
            return;
        }
        long j3 = this.x;
        if (j3 == Long.MAX_VALUE) {
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactUnboundedSubscriber(serializedSubscriber, this.t, this.v, this.w, this.y));
        } else {
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactBoundedSubscriber(serializedSubscriber, j, this.v, this.w, this.y, j3, this.z));
        }
    }
}
