package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class ObjectArrays {
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static java.lang.Object a(java.lang.Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new java.lang.NullPointerException("at index " + i);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static java.lang.Object[] b(java.lang.Object... objArr) {
        return c(objArr, objArr.length);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static java.lang.Object[] c(java.lang.Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            a(objArr[i2], i2);
        }
        return objArr;
    }

    public static <T> T[] concat(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t, T[] tArr) {
        T[] tArr2 = (T[]) newArray(tArr, tArr.length + 1);
        tArr2[0] = t;
        java.lang.System.arraycopy(tArr, 0, tArr2, 1, tArr.length);
        return tArr2;
    }

    public static <T> T[] concat(T[] tArr, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        T[] tArr2 = (T[]) java.util.Arrays.copyOf(tArr, tArr.length + 1);
        tArr2[tArr.length] = t;
        return tArr2;
    }

    @com.google.common.annotations.GwtIncompatible
    public static <T> T[] concat(T[] tArr, T[] tArr2, java.lang.Class<T> cls) {
        T[] tArr3 = (T[]) newArray(cls, tArr.length + tArr2.length);
        java.lang.System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        java.lang.System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static java.lang.Object[] d(java.lang.Iterable<?> iterable, java.lang.Object[] objArr) {
        java.util.Iterator<?> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return objArr;
    }

    public static java.lang.Object[] e(java.util.Collection<?> collection) {
        return d(collection, new java.lang.Object[collection.size()]);
    }

    public static <T> T[] f(java.util.Collection<?> collection, T[] tArr) {
        int size = collection.size();
        if (tArr.length < size) {
            tArr = (T[]) newArray(tArr, size);
        }
        d(collection, tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    public static <T> T[] g(java.lang.Object[] objArr, int i, int i2, T[] tArr) {
        com.google.common.base.Preconditions.checkPositionIndexes(i, i + i2, objArr.length);
        if (tArr.length < i2) {
            tArr = (T[]) newArray(tArr, i2);
        } else if (tArr.length > i2) {
            tArr[i2] = null;
        }
        java.lang.System.arraycopy(objArr, i, tArr, 0, i2);
        return tArr;
    }

    @com.google.common.annotations.GwtIncompatible
    public static <T> T[] newArray(java.lang.Class<T> cls, int i) {
        return (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) cls, i));
    }

    public static <T> T[] newArray(T[] tArr, int i) {
        return (T[]) com.google.common.collect.Platform.b(tArr, i);
    }
}
