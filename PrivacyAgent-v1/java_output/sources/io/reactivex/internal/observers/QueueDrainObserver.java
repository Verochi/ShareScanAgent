package io.reactivex.internal.observers;

/* loaded from: classes9.dex */
public abstract class QueueDrainObserver<T, U, V> extends io.reactivex.internal.observers.QueueDrainSubscriberPad2 implements io.reactivex.Observer<T>, io.reactivex.internal.util.ObservableQueueDrain<U, V> {
    protected volatile boolean cancelled;
    protected volatile boolean done;
    protected final io.reactivex.Observer<? super V> downstream;
    protected java.lang.Throwable error;
    protected final io.reactivex.internal.fuseable.SimplePlainQueue<U> queue;

    public QueueDrainObserver(io.reactivex.Observer<? super V> observer, io.reactivex.internal.fuseable.SimplePlainQueue<U> simplePlainQueue) {
        this.downstream = observer;
        this.queue = simplePlainQueue;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public void accept(io.reactivex.Observer<? super V> observer, U u) {
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean cancelled() {
        return this.cancelled;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean done() {
        return this.done;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean enter() {
        return this.n.getAndIncrement() == 0;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final java.lang.Throwable error() {
        return this.error;
    }

    public final boolean fastEnter() {
        return this.n.get() == 0 && this.n.compareAndSet(0, 1);
    }

    public final void fastPathEmit(U u, boolean z, io.reactivex.disposables.Disposable disposable) {
        io.reactivex.Observer<? super V> observer = this.downstream;
        io.reactivex.internal.fuseable.SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (this.n.get() == 0 && this.n.compareAndSet(0, 1)) {
            accept(observer, u);
            if (leave(-1) == 0) {
                return;
            }
        } else {
            simplePlainQueue.offer(u);
            if (!enter()) {
                return;
            }
        }
        io.reactivex.internal.util.QueueDrainHelper.drainLoop(simplePlainQueue, observer, z, disposable, this);
    }

    public final void fastPathOrderedEmit(U u, boolean z, io.reactivex.disposables.Disposable disposable) {
        io.reactivex.Observer<? super V> observer = this.downstream;
        io.reactivex.internal.fuseable.SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (this.n.get() != 0 || !this.n.compareAndSet(0, 1)) {
            simplePlainQueue.offer(u);
            if (!enter()) {
                return;
            }
        } else if (simplePlainQueue.isEmpty()) {
            accept(observer, u);
            if (leave(-1) == 0) {
                return;
            }
        } else {
            simplePlainQueue.offer(u);
        }
        io.reactivex.internal.util.QueueDrainHelper.drainLoop(simplePlainQueue, observer, z, disposable, this);
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final int leave(int i) {
        return this.n.addAndGet(i);
    }
}
