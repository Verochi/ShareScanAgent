package io.reactivex.internal.schedulers;

/* loaded from: classes13.dex */
public final class ScheduledRunnable extends java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> implements java.lang.Runnable, java.util.concurrent.Callable<java.lang.Object>, io.reactivex.disposables.Disposable {
    static final int FUTURE_INDEX = 1;
    static final int PARENT_INDEX = 0;
    static final int THREAD_INDEX = 2;
    private static final long serialVersionUID = -6120223772001106981L;
    final java.lang.Runnable actual;
    static final java.lang.Object PARENT_DISPOSED = new java.lang.Object();
    static final java.lang.Object SYNC_DISPOSED = new java.lang.Object();
    static final java.lang.Object ASYNC_DISPOSED = new java.lang.Object();
    static final java.lang.Object DONE = new java.lang.Object();

    public ScheduledRunnable(java.lang.Runnable runnable, io.reactivex.internal.disposables.DisposableContainer disposableContainer) {
        super(3);
        this.actual = runnable;
        lazySet(0, disposableContainer);
    }

    @Override // java.util.concurrent.Callable
    public java.lang.Object call() {
        run();
        return null;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.lang.Object obj3;
        java.lang.Object obj4;
        while (true) {
            java.lang.Object obj5 = get(1);
            if (obj5 == DONE || obj5 == (obj3 = SYNC_DISPOSED) || obj5 == (obj4 = ASYNC_DISPOSED)) {
                break;
            }
            boolean z = get(2) != java.lang.Thread.currentThread();
            if (z) {
                obj3 = obj4;
            }
            if (compareAndSet(1, obj5, obj3)) {
                if (obj5 != null) {
                    ((java.util.concurrent.Future) obj5).cancel(z);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == DONE || obj == (obj2 = PARENT_DISPOSED) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((io.reactivex.internal.disposables.DisposableContainer) obj).delete(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        java.lang.Object obj = get(0);
        return obj == PARENT_DISPOSED || obj == DONE;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.lang.Object obj3;
        boolean compareAndSet;
        java.lang.Object obj4;
        java.lang.Object obj5;
        lazySet(2, java.lang.Thread.currentThread());
        try {
            this.actual.run();
        } finally {
            try {
                lazySet(2, null);
                obj4 = get(0);
                if (obj4 != PARENT_DISPOSED) {
                    ((io.reactivex.internal.disposables.DisposableContainer) obj4).delete(this);
                }
                do {
                    obj5 = get(1);
                    if (obj5 != SYNC_DISPOSED) {
                        return;
                    } else {
                        return;
                    }
                } while (!compareAndSet(1, obj5, DONE));
            } catch (java.lang.Throwable th) {
                do {
                    if (obj == obj2) {
                        break;
                    } else if (obj == obj3) {
                        break;
                    }
                } while (!compareAndSet);
            }
        }
        lazySet(2, null);
        obj4 = get(0);
        if (obj4 != PARENT_DISPOSED && compareAndSet(0, obj4, DONE) && obj4 != null) {
            ((io.reactivex.internal.disposables.DisposableContainer) obj4).delete(this);
        }
        do {
            obj5 = get(1);
            if (obj5 != SYNC_DISPOSED || obj5 == ASYNC_DISPOSED) {
                return;
            }
        } while (!compareAndSet(1, obj5, DONE));
    }

    public void setFuture(java.util.concurrent.Future<?> future) {
        java.lang.Object obj;
        do {
            obj = get(1);
            if (obj == DONE) {
                return;
            }
            if (obj == SYNC_DISPOSED) {
                future.cancel(false);
                return;
            } else if (obj == ASYNC_DISPOSED) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }
}
