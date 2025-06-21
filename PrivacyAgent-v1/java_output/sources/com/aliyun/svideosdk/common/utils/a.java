package com.aliyun.svideosdk.common.utils;

/* loaded from: classes12.dex */
public class a {
    public static <T extends java.lang.Comparable<T>> T a(T t, T t2, T t3) {
        return t.compareTo(t2) < 0 ? t2 : t.compareTo(t3) > 0 ? t3 : t;
    }
}
