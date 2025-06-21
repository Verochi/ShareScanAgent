package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class BlockingFlowableIterable<T> implements java.lang.Iterable<T> {
    public final io.reactivex.Flowable<T> n;
    public final int t;

    public static final class BlockingFlowableIterator<T> extends java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> implements io.reactivex.FlowableSubscriber<T>, java.util.Iterator<T>, java.lang.Runnable, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 6695226475494099826L;
        final long batchSize;
        final java.util.concurrent.locks.Condition condition;
        volatile boolean done;
        volatile java.lang.Throwable error;
        final long limit;
        final java.util.concurrent.locks.Lock lock;
        long produced;
        final io.reactivex.internal.queue.SpscArrayQueue<T> queue;

        public BlockingFlowableIterator(int i) {
            this.queue = new io.reactivex.internal.queue.SpscArrayQueue<>(i);
            this.batchSize = i;
            this.limit = i - (i >> 2);
            java.util.concurrent.locks.ReentrantLock reentrantLock = new java.util.concurrent.locks.ReentrantLock();
            this.lock = reentrantLock;
            this.condition = reentrantLock.newCondition();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this);
            signalConsumer();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!isDisposed()) {
                boolean z = this.done;
                boolean isEmpty = this.queue.isEmpty();
                if (z) {
                    java.lang.Throwable th = this.error;
                    if (th != null) {
                        throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
                    }
                    if (isEmpty) {
                        return false;
                    }
                }
                if (!isEmpty) {
                    return true;
                }
                io.reactivex.internal.util.BlockingHelper.verifyNonBlocking();
                this.lock.lock();
                while (!this.done && this.queue.isEmpty() && !isDisposed()) {
                    try {
                        try {
                            this.condition.await();
                        } catch (java.lang.InterruptedException e) {
                            run();
                            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(e);
                        }
                    } finally {
                        this.lock.unlock();
                    }
                }
            }
            java.lang.Throwable th2 = this.error;
            if (th2 == null) {
                return false;
            }
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th2);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            T poll = this.queue.poll();
            long j = this.produced + 1;
            if (j == this.limit) {
                this.produced = 0L;
                get().request(j);
            } else {
                this.produced = j;
            }
            return poll;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            signalConsumer();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.error = th;
            this.done = true;
            signalConsumer();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.queue.offer(t)) {
                signalConsumer();
            } else {
                io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this);
                onError(new io.reactivex.exceptions.MissingBackpressureException("Queue full?!"));
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this, subscription, this.batchSize);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException("remove");
        }

        @Override // java.lang.Runnable
        public void run() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this);
            signalConsumer();
        }

        public void signalConsumer() {
            this.lock.lock();
            try {
                this.condition.signalAll();
            } finally {
                this.lock.unlock();
            }
        }
    }

    public BlockingFlowableIterable(io.reactivex.Flowable<T> flowable, int i) {
        this.n = flowable;
        this.t = i;
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        io.reactivex.internal.operators.flowable.BlockingFlowableIterable.BlockingFlowableIterator blockingFlowableIterator = new io.reactivex.internal.operators.flowable.BlockingFlowableIterable.BlockingFlowableIterator(this.t);
        this.n.subscribe((io.reactivex.FlowableSubscriber) blockingFlowableIterator);
        return blockingFlowableIterator;
    }
}
