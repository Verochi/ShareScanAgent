package com.aliyun.common.utils;

/* loaded from: classes.dex */
public class MapUtil {
    public static <T, K> T parseMapValue(java.util.Map<K, T> map, K k, T t) {
        return (map == null || !map.containsKey(k)) ? t : map.get(k);
    }
}
