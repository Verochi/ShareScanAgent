package io.reactivex.internal.util;

/* loaded from: classes13.dex */
public enum ListAddBiConsumer implements io.reactivex.functions.BiFunction<java.util.List, java.lang.Object, java.util.List> {
    INSTANCE;

    public static <T> io.reactivex.functions.BiFunction<java.util.List<T>, T, java.util.List<T>> instance() {
        return INSTANCE;
    }

    @Override // io.reactivex.functions.BiFunction
    public java.util.List apply(java.util.List list, java.lang.Object obj) throws java.lang.Exception {
        list.add(obj);
        return list;
    }
}
