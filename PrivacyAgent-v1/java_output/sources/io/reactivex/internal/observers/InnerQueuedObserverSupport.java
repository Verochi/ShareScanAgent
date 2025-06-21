package io.reactivex.internal.observers;

/* loaded from: classes9.dex */
public interface InnerQueuedObserverSupport<T> {
    void drain();

    void innerComplete(io.reactivex.internal.observers.InnerQueuedObserver<T> innerQueuedObserver);

    void innerError(io.reactivex.internal.observers.InnerQueuedObserver<T> innerQueuedObserver, java.lang.Throwable th);

    void innerNext(io.reactivex.internal.observers.InnerQueuedObserver<T> innerQueuedObserver, T t);
}
