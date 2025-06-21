package io.reactivex.internal.util;

/* loaded from: classes13.dex */
public enum HashMapSupplier implements java.util.concurrent.Callable<java.util.Map<java.lang.Object, java.lang.Object>> {
    INSTANCE;

    public static <K, V> java.util.concurrent.Callable<java.util.Map<K, V>> asCallable() {
        return INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    public java.util.Map<java.lang.Object, java.lang.Object> call() throws java.lang.Exception {
        return new java.util.HashMap();
    }
}
