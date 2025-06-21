package io.reactivex.internal.fuseable;

/* loaded from: classes9.dex */
public interface SimpleQueue<T> {
    void clear();

    boolean isEmpty();

    boolean offer(@io.reactivex.annotations.NonNull T t);

    boolean offer(@io.reactivex.annotations.NonNull T t, @io.reactivex.annotations.NonNull T t2);

    @io.reactivex.annotations.Nullable
    T poll() throws java.lang.Exception;
}
