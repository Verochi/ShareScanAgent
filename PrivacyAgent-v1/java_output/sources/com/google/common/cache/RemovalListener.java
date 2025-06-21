package com.google.common.cache;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public interface RemovalListener<K, V> {
    void onRemoval(com.google.common.cache.RemovalNotification<K, V> removalNotification);
}
