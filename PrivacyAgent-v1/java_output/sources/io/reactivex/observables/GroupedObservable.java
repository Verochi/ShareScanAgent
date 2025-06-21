package io.reactivex.observables;

/* loaded from: classes13.dex */
public abstract class GroupedObservable<K, T> extends io.reactivex.Observable<T> {
    public final K n;

    public GroupedObservable(@io.reactivex.annotations.Nullable K k) {
        this.n = k;
    }

    @io.reactivex.annotations.Nullable
    public K getKey() {
        return this.n;
    }
}
