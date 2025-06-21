package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class ContainerUtils {
    public static final java.lang.String FIELD_DELIMITER = "&";
    public static final java.lang.String KEY_VALUE_DELIMITER = "=";

    public static <K, V> boolean equals(java.util.Map<K, V> map, java.util.Map<K, V> map2) {
        if (map == map2) {
            return true;
        }
        boolean z = false;
        if (map == null || map2 == null || map.size() != map2.size()) {
            return false;
        }
        java.util.Iterator<java.util.Map.Entry<K, V>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            java.util.Map.Entry<K, V> next = it.next();
            if (map2.get(next.getKey()) != next.getValue()) {
                z = true;
                break;
            }
        }
        return !z;
    }

    public static <K, V> int hashCode(java.util.Map<K, V> map) {
        return toString(map).hashCode();
    }

    public static <K> java.lang.String toString(java.util.List<K> list) {
        if (list == null) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = 0;
        for (K k : list) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append("&");
            }
            sb.append(k.toString());
            i = i2;
        }
        return sb.toString();
    }

    public static <K, V> java.lang.String toString(java.util.Map<K, V> map) {
        if (map == null) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = 0;
        for (java.util.Map.Entry<K, V> entry : map.entrySet()) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey().toString());
            sb.append(KEY_VALUE_DELIMITER);
            sb.append(entry.getValue().toString());
            i = i2;
        }
        return sb.toString();
    }

    public static <K> java.lang.String toString(java.util.Set<K> set) {
        if (set == null) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = 0;
        for (K k : set) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append("&");
            }
            sb.append(k.toString());
            i = i2;
        }
        return sb.toString();
    }
}
