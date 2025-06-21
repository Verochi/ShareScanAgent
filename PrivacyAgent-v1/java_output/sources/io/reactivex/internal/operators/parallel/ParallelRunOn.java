package io.reactivex.internal.operators.parallel;

/* loaded from: classes13.dex */
public final class ParallelRunOn<T> extends io.reactivex.parallel.ParallelFlowable<T> {
    public final io.reactivex.parallel.ParallelFlowable<? extends T> a;
    public final io.reactivex.Scheduler b;
    public final int c;

    public static abstract class BaseRunOnSubscriber<T> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription, java.lang.Runnable {
        private static final long serialVersionUID = 9222303586456402150L;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        java.lang.Throwable error;
        final int limit;
        final int prefetch;
        final io.reactivex.internal.queue.SpscArrayQueue<T> queue;
        final java.util.concurrent.atomic.AtomicLong requested = new java.util.concurrent.atomic.AtomicLong();
        org.reactivestreams.Subscription upstream;
        final io.reactivex.Scheduler.Worker worker;

        public BaseRunOnSubscriber(int i, io.reactivex.internal.queue.SpscArrayQueue<T> spscArrayQueue, io.reactivex.Scheduler.Worker worker) {
            this.prefetch = i;
            this.queue = spscArrayQueue;
            this.limit = i - (i >> 2);
            this.worker = worker;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(java.lang.Throwable th) {
            if (this.done) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.queue.offer(t)) {
                schedule();
            } else {
                this.upstream.cancel();
                onError(new io.reactivex.exceptions.MissingBackpressureException("Queue is full?!"));
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.BackpressureHelper.add(this.requested, j);
                schedule();
            }
        }

        public final void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.schedule(this);
            }
        }
    }

    public final class MultiWorkerCallback implements io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport.WorkerCallback {
        public final org.reactivestreams.Subscriber<? super T>[] a;
        public final org.reactivestreams.Subscriber<T>[] b;

        public MultiWorkerCallback(org.reactivestreams.Subscriber<? super T>[] subscriberArr, org.reactivestreams.Subscriber<T>[] subscriberArr2) {
            this.a = subscriberArr;
            this.b = subscriberArr2;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport.WorkerCallback
        public void onWorker(int i, io.reactivex.Scheduler.Worker worker) {
            io.reactivex.internal.operators.parallel.ParallelRunOn.this.a(i, this.a, this.b, worker);
        }
    }

    public static final class RunOnConditionalSubscriber<T> extends io.reactivex.internal.operators.parallel.ParallelRunOn.BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final io.reactivex.internal.fuseable.ConditionalSubscriber<? super T> downstream;

        public RunOnConditionalSubscriber(io.reactivex.internal.fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, int i, io.reactivex.internal.queue.SpscArrayQueue<T> spscArrayQueue, io.reactivex.Scheduler.Worker worker) {
            super(i, spscArrayQueue, worker);
            this.downstream = conditionalSubscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.Throwable th;
            int i = this.consumed;
            io.reactivex.internal.queue.SpscArrayQueue<T> spscArrayQueue = this.queue;
            io.reactivex.internal.fuseable.ConditionalSubscriber<? super T> conditionalSubscriber = this.downstream;
            int i2 = this.limit;
            int i3 = 1;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        spscArrayQueue.clear();
                        conditionalSubscriber.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    T poll = spscArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        conditionalSubscriber.onComplete();
                        this.worker.dispose();
                        return;
                    } else {
                        if (z2) {
                            break;
                        }
                        if (conditionalSubscriber.tryOnNext(poll)) {
                            j2++;
                        }
                        i++;
                        if (i == i2) {
                            this.upstream.request(i);
                            i = 0;
                        }
                    }
                }
                if (j2 == j) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    }
                    if (this.done) {
                        java.lang.Throwable th2 = this.error;
                        if (th2 != null) {
                            spscArrayQueue.clear();
                            conditionalSubscriber.onError(th2);
                            this.worker.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            conditionalSubscriber.onComplete();
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                int i4 = get();
                if (i4 == i3) {
                    this.consumed = i;
                    i3 = addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                } else {
                    i3 = i4;
                }
            }
        }
    }

    public static final class RunOnSubscriber<T> extends io.reactivex.internal.operators.parallel.ParallelRunOn.BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final org.reactivestreams.Subscriber<? super T> downstream;

        public RunOnSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, int i, io.reactivex.internal.queue.SpscArrayQueue<T> spscArrayQueue, io.reactivex.Scheduler.Worker worker) {
            super(i, spscArrayQueue, worker);
            this.downstream = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.Throwable th;
            int i = this.consumed;
            io.reactivex.internal.queue.SpscArrayQueue<T> spscArrayQueue = this.queue;
            org.reactivestreams.Subscriber<? super T> subscriber = this.downstream;
            int i2 = this.limit;
            int i3 = 1;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        spscArrayQueue.clear();
                        subscriber.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    T poll = spscArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        subscriber.onComplete();
                        this.worker.dispose();
                        return;
                    } else {
                        if (z2) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j2++;
                        i++;
                        if (i == i2) {
                            this.upstream.request(i);
                            i = 0;
                        }
                    }
                }
                if (j2 == j) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    }
                    if (this.done) {
                        java.lang.Throwable th2 = this.error;
                        if (th2 != null) {
                            spscArrayQueue.clear();
                            subscriber.onError(th2);
                            this.worker.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            subscriber.onComplete();
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                int i4 = get();
                if (i4 == i3) {
                    this.consumed = i;
                    i3 = addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                } else {
                    i3 = i4;
                }
            }
        }
    }

    public ParallelRunOn(io.reactivex.parallel.ParallelFlowable<? extends T> parallelFlowable, io.reactivex.Scheduler scheduler, int i) {
        this.a = parallelFlowable;
        this.b = scheduler;
        this.c = i;
    }

    public void a(int i, org.reactivestreams.Subscriber<? super T>[] subscriberArr, org.reactivestreams.Subscriber<T>[] subscriberArr2, io.reactivex.Scheduler.Worker worker) {
        org.reactivestreams.Subscriber<? super T> subscriber = subscriberArr[i];
        io.reactivex.internal.queue.SpscArrayQueue spscArrayQueue = new io.reactivex.internal.queue.SpscArrayQueue(this.c);
        if (subscriber instanceof io.reactivex.internal.fuseable.ConditionalSubscriber) {
            subscriberArr2[i] = new io.reactivex.internal.operators.parallel.ParallelRunOn.RunOnConditionalSubscriber((io.reactivex.internal.fuseable.ConditionalSubscriber) subscriber, this.c, spscArrayQueue, worker);
        } else {
            subscriberArr2[i] = new io.reactivex.internal.operators.parallel.ParallelRunOn.RunOnSubscriber(subscriber, this.c, spscArrayQueue, worker);
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(org.reactivestreams.Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            org.reactivestreams.Subscriber<T>[] subscriberArr2 = new org.reactivestreams.Subscriber[length];
            java.lang.Object obj = this.b;
            if (obj instanceof io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport) {
                ((io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport) obj).createWorkers(length, new io.reactivex.internal.operators.parallel.ParallelRunOn.MultiWorkerCallback(subscriberArr, subscriberArr2));
            } else {
                for (int i = 0; i < length; i++) {
                    a(i, subscriberArr, subscriberArr2, this.b.createWorker());
                }
            }
            this.a.subscribe(subscriberArr2);
        }
    }
}
