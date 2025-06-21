package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
final class Platform {
    public static <T> T[] a(java.lang.Object[] objArr, int i, int i2, T[] tArr) {
        return (T[]) java.util.Arrays.copyOfRange(objArr, i, i2, tArr.getClass());
    }

    public static <T> T[] b(T[] tArr, int i) {
        return (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), i));
    }

    public static <K, V> java.util.Map<K, V> c(int i) {
        return com.google.common.collect.CompactHashMap.createWithExpectedSize(i);
    }

    public static <E> java.util.Set<E> d(int i) {
        return com.google.common.collect.CompactHashSet.createWithExpectedSize(i);
    }

    public static <K, V> java.util.Map<K, V> e(int i) {
        return com.google.common.collect.CompactLinkedHashMap.createWithExpectedSize(i);
    }

    public static <E> java.util.Set<E> f(int i) {
        return com.google.common.collect.CompactLinkedHashSet.createWithExpectedSize(i);
    }

    public static <E> java.util.Set<E> g() {
        return com.google.common.collect.CompactHashSet.create();
    }

    public static <K, V> java.util.Map<K, V> h() {
        return com.google.common.collect.CompactHashMap.create();
    }

    public static com.google.common.collect.MapMaker i(com.google.common.collect.MapMaker mapMaker) {
        return mapMaker.weakKeys();
    }
}
