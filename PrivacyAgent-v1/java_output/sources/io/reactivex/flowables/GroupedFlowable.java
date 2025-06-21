package io.reactivex.flowables;

/* loaded from: classes9.dex */
public abstract class GroupedFlowable<K, T> extends io.reactivex.Flowable<T> {
    public final K t;

    public GroupedFlowable(@io.reactivex.annotations.Nullable K k) {
        this.t = k;
    }

    @io.reactivex.annotations.Nullable
    public K getKey() {
        return this.t;
    }
}
