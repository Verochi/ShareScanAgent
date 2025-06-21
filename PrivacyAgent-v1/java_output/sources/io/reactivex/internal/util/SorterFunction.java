package io.reactivex.internal.util;

/* loaded from: classes13.dex */
public final class SorterFunction<T> implements io.reactivex.functions.Function<java.util.List<T>, java.util.List<T>> {
    public final java.util.Comparator<? super T> n;

    public SorterFunction(java.util.Comparator<? super T> comparator) {
        this.n = comparator;
    }

    @Override // io.reactivex.functions.Function
    public java.util.List<T> apply(java.util.List<T> list) throws java.lang.Exception {
        java.util.Collections.sort(list, this.n);
        return list;
    }
}
