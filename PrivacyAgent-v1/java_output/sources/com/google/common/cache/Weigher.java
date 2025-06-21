package com.google.common.cache;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public interface Weigher<K, V> {
    int weigh(K k, V v);
}
