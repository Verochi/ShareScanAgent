package com.google.android.gms.common.util;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public final class CollectionUtils {
    public static <T> java.util.Set<T> a(int i, boolean z) {
        return i <= (z ? 128 : 256) ? new androidx.collection.ArraySet(i) : new java.util.HashSet(i, z ? 0.75f : 1.0f);
    }

    public static <K, V> java.util.Map<K, V> b(int i, boolean z) {
        return i <= 256 ? new androidx.collection.ArrayMap(i) : new java.util.HashMap(i, 1.0f);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isEmpty(@androidx.annotation.Nullable java.util.Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static <T> java.util.List<T> listOf() {
        return java.util.Collections.emptyList();
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static <T> java.util.List<T> listOf(@androidx.annotation.RecentlyNonNull T t) {
        return java.util.Collections.singletonList(t);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static <T> java.util.List<T> listOf(@androidx.annotation.RecentlyNonNull T... tArr) {
        int length = tArr.length;
        return length != 0 ? length != 1 ? java.util.Collections.unmodifiableList(java.util.Arrays.asList(tArr)) : listOf(tArr[0]) : listOf();
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static <K, V> java.util.Map<K, V> mapOf(@androidx.annotation.RecentlyNonNull K k, @androidx.annotation.RecentlyNonNull V v, @androidx.annotation.RecentlyNonNull K k2, @androidx.annotation.RecentlyNonNull V v2, @androidx.annotation.RecentlyNonNull K k3, @androidx.annotation.RecentlyNonNull V v3) {
        java.util.Map b = b(3, false);
        b.put(k, v);
        b.put(k2, v2);
        b.put(k3, v3);
        return java.util.Collections.unmodifiableMap(b);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static <K, V> java.util.Map<K, V> mapOf(@androidx.annotation.RecentlyNonNull K k, @androidx.annotation.RecentlyNonNull V v, @androidx.annotation.RecentlyNonNull K k2, @androidx.annotation.RecentlyNonNull V v2, @androidx.annotation.RecentlyNonNull K k3, @androidx.annotation.RecentlyNonNull V v3, @androidx.annotation.RecentlyNonNull K k4, @androidx.annotation.RecentlyNonNull V v4, @androidx.annotation.RecentlyNonNull K k5, @androidx.annotation.RecentlyNonNull V v5, @androidx.annotation.RecentlyNonNull K k6, @androidx.annotation.RecentlyNonNull V v6) {
        java.util.Map b = b(6, false);
        b.put(k, v);
        b.put(k2, v2);
        b.put(k3, v3);
        b.put(k4, v4);
        b.put(k5, v5);
        b.put(k6, v6);
        return java.util.Collections.unmodifiableMap(b);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static <K, V> java.util.Map<K, V> mapOfKeyValueArrays(@androidx.annotation.RecentlyNonNull K[] kArr, @androidx.annotation.RecentlyNonNull V[] vArr) {
        if (kArr.length != vArr.length) {
            int length = kArr.length;
            int length2 = vArr.length;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(66);
            sb.append("Key and values array lengths not equal: ");
            sb.append(length);
            sb.append(" != ");
            sb.append(length2);
            throw new java.lang.IllegalArgumentException(sb.toString());
        }
        int length3 = kArr.length;
        if (length3 == 0) {
            return java.util.Collections.emptyMap();
        }
        if (length3 == 1) {
            return java.util.Collections.singletonMap(kArr[0], vArr[0]);
        }
        java.util.Map b = b(kArr.length, false);
        for (int i = 0; i < kArr.length; i++) {
            b.put(kArr[i], vArr[i]);
        }
        return java.util.Collections.unmodifiableMap(b);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static <T> java.util.Set<T> mutableSetOfWithSize(@androidx.annotation.RecentlyNonNull int i) {
        return i == 0 ? new androidx.collection.ArraySet() : a(i, true);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static <T> java.util.Set<T> setOf(@androidx.annotation.RecentlyNonNull T t, @androidx.annotation.RecentlyNonNull T t2, @androidx.annotation.RecentlyNonNull T t3) {
        java.util.Set a = a(3, false);
        a.add(t);
        a.add(t2);
        a.add(t3);
        return java.util.Collections.unmodifiableSet(a);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static <T> java.util.Set<T> setOf(@androidx.annotation.RecentlyNonNull T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return java.util.Collections.emptySet();
        }
        if (length == 1) {
            return java.util.Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t = tArr[0];
            T t2 = tArr[1];
            java.util.Set a = a(2, false);
            a.add(t);
            a.add(t2);
            return java.util.Collections.unmodifiableSet(a);
        }
        if (length == 3) {
            return setOf(tArr[0], tArr[1], tArr[2]);
        }
        if (length != 4) {
            java.util.Set a2 = a(tArr.length, false);
            java.util.Collections.addAll(a2, tArr);
            return java.util.Collections.unmodifiableSet(a2);
        }
        T t3 = tArr[0];
        T t4 = tArr[1];
        T t5 = tArr[2];
        T t6 = tArr[3];
        java.util.Set a3 = a(4, false);
        a3.add(t3);
        a3.add(t4);
        a3.add(t5);
        a3.add(t6);
        return java.util.Collections.unmodifiableSet(a3);
    }
}
