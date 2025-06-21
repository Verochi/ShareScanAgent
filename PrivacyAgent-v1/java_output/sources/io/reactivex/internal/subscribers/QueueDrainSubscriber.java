package io.reactivex.internal.subscribers;

/* loaded from: classes13.dex */
public abstract class QueueDrainSubscriber<T, U, V> extends io.reactivex.internal.subscribers.QueueDrainSubscriberPad4 implements io.reactivex.FlowableSubscriber<T>, io.reactivex.internal.util.QueueDrain<U, V> {
    protected volatile boolean cancelled;
    protected volatile boolean done;
    protected final org.reactivestreams.Subscriber<? super V> downstream;
    protected java.lang.Throwable error;
    protected final io.reactivex.internal.fuseable.SimplePlainQueue<U> queue;

    public QueueDrainSubscriber(org.reactivestreams.Subscriber<? super V> subscriber, io.reactivex.internal.fuseable.SimplePlainQueue<U> simplePlainQueue) {
        this.downstream = subscriber;
        this.queue = simplePlainQueue;
    }

    public boolean accept(org.reactivestreams.Subscriber<? super V> subscriber, U u) {
        return false;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean cancelled() {
        return this.cancelled;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean done() {
        return this.done;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean enter() {
        return this.n.getAndIncrement() == 0;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final java.lang.Throwable error() {
        return this.error;
    }

    public final boolean fastEnter() {
        return this.n.get() == 0 && this.n.compareAndSet(0, 1);
    }

    public final void fastPathEmitMax(U u, boolean z, io.reactivex.disposables.Disposable disposable) {
        org.reactivestreams.Subscriber<? super V> subscriber = this.downstream;
        io.reactivex.internal.fuseable.SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (fastEnter()) {
            long j = this.t.get();
            if (j == 0) {
                disposable.dispose();
                subscriber.onError(new io.reactivex.exceptions.MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            } else {
                if (accept(subscriber, u) && j != Long.MAX_VALUE) {
                    produced(1L);
                }
                if (leave(-1) == 0) {
                    return;
                }
            }
        } else {
            simplePlainQueue.offer(u);
            if (!enter()) {
                return;
            }
        }
        io.reactivex.internal.util.QueueDrainHelper.drainMaxLoop(simplePlainQueue, subscriber, z, disposable, this);
    }

    public final void fastPathOrderedEmitMax(U u, boolean z, io.reactivex.disposables.Disposable disposable) {
        org.reactivestreams.Subscriber<? super V> subscriber = this.downstream;
        io.reactivex.internal.fuseable.SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (fastEnter()) {
            long j = this.t.get();
            if (j == 0) {
                this.cancelled = true;
                disposable.dispose();
                subscriber.onError(new io.reactivex.exceptions.MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            } else if (simplePlainQueue.isEmpty()) {
                if (accept(subscriber, u) && j != Long.MAX_VALUE) {
                    produced(1L);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                simplePlainQueue.offer(u);
            }
        } else {
            simplePlainQueue.offer(u);
            if (!enter()) {
                return;
            }
        }
        io.reactivex.internal.util.QueueDrainHelper.drainMaxLoop(simplePlainQueue, subscriber, z, disposable, this);
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final int leave(int i) {
        return this.n.addAndGet(i);
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final long produced(long j) {
        return this.t.addAndGet(-j);
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final long requested() {
        return this.t.get();
    }

    public final void requested(long j) {
        if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
            io.reactivex.internal.util.BackpressureHelper.add(this.t, j);
        }
    }
}
