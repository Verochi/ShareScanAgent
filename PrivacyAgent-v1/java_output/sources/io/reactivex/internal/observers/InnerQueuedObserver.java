package io.reactivex.internal.observers;

/* loaded from: classes9.dex */
public final class InnerQueuedObserver<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
    private static final long serialVersionUID = -5417183359794346637L;
    volatile boolean done;
    int fusionMode;
    final io.reactivex.internal.observers.InnerQueuedObserverSupport<T> parent;
    final int prefetch;
    io.reactivex.internal.fuseable.SimpleQueue<T> queue;

    public InnerQueuedObserver(io.reactivex.internal.observers.InnerQueuedObserverSupport<T> innerQueuedObserverSupport, int i) {
        this.parent = innerQueuedObserverSupport;
        this.prefetch = i;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        io.reactivex.internal.disposables.DisposableHelper.dispose(this);
    }

    public int fusionMode() {
        return this.fusionMode;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return io.reactivex.internal.disposables.DisposableHelper.isDisposed(get());
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // io.reactivex.Observer
    public void onError(java.lang.Throwable th) {
        this.parent.innerError(this, th);
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t);
        } else {
            this.parent.drain();
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
        if (io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable)) {
            if (disposable instanceof io.reactivex.internal.fuseable.QueueDisposable) {
                io.reactivex.internal.fuseable.QueueDisposable queueDisposable = (io.reactivex.internal.fuseable.QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = queueDisposable;
                    this.done = true;
                    this.parent.innerComplete(this);
                    return;
                }
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = queueDisposable;
                    return;
                }
            }
            this.queue = io.reactivex.internal.util.QueueDrainHelper.createQueue(-this.prefetch);
        }
    }

    public io.reactivex.internal.fuseable.SimpleQueue<T> queue() {
        return this.queue;
    }

    public void setDone() {
        this.done = true;
    }
}
