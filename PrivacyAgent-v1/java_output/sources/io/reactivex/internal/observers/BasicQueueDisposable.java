package io.reactivex.internal.observers;

/* loaded from: classes9.dex */
public abstract class BasicQueueDisposable<T> implements io.reactivex.internal.fuseable.QueueDisposable<T> {
    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(T t) {
        throw new java.lang.UnsupportedOperationException("Should not be called");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(T t, T t2) {
        throw new java.lang.UnsupportedOperationException("Should not be called");
    }
}
