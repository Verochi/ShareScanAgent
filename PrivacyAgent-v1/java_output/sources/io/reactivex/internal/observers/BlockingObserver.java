package io.reactivex.internal.observers;

/* loaded from: classes9.dex */
public final class BlockingObserver<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
    public static final java.lang.Object TERMINATED = new java.lang.Object();
    private static final long serialVersionUID = -4875965440900746268L;
    final java.util.Queue<java.lang.Object> queue;

    public BlockingObserver(java.util.Queue<java.lang.Object> queue) {
        this.queue = queue;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (io.reactivex.internal.disposables.DisposableHelper.dispose(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return get() == io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.queue.offer(io.reactivex.internal.util.NotificationLite.complete());
    }

    @Override // io.reactivex.Observer
    public void onError(java.lang.Throwable th) {
        this.queue.offer(io.reactivex.internal.util.NotificationLite.error(th));
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        this.queue.offer(io.reactivex.internal.util.NotificationLite.next(t));
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
        io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
    }
}
