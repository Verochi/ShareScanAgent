package io.reactivex.internal.util;

/* loaded from: classes13.dex */
public enum ArrayListSupplier implements java.util.concurrent.Callable<java.util.List<java.lang.Object>>, io.reactivex.functions.Function<java.lang.Object, java.util.List<java.lang.Object>> {
    INSTANCE;

    public static <T> java.util.concurrent.Callable<java.util.List<T>> asCallable() {
        return INSTANCE;
    }

    public static <T, O> io.reactivex.functions.Function<O, java.util.List<T>> asFunction() {
        return INSTANCE;
    }

    @Override // io.reactivex.functions.Function
    public java.util.List<java.lang.Object> apply(java.lang.Object obj) throws java.lang.Exception {
        return new java.util.ArrayList();
    }

    @Override // java.util.concurrent.Callable
    public java.util.List<java.lang.Object> call() throws java.lang.Exception {
        return new java.util.ArrayList();
    }
}
