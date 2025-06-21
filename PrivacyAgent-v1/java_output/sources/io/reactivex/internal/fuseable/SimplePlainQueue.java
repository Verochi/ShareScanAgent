package io.reactivex.internal.fuseable;

/* loaded from: classes9.dex */
public interface SimplePlainQueue<T> extends io.reactivex.internal.fuseable.SimpleQueue<T> {
    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @io.reactivex.annotations.Nullable
    T poll();
}
