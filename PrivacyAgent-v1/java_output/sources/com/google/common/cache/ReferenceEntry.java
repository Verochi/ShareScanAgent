package com.google.common.cache;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
interface ReferenceEntry<K, V> {
    long getAccessTime();

    int getHash();

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    K getKey();

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    com.google.common.cache.ReferenceEntry<K, V> getNext();

    com.google.common.cache.ReferenceEntry<K, V> getNextInAccessQueue();

    com.google.common.cache.ReferenceEntry<K, V> getNextInWriteQueue();

    com.google.common.cache.ReferenceEntry<K, V> getPreviousInAccessQueue();

    com.google.common.cache.ReferenceEntry<K, V> getPreviousInWriteQueue();

    com.google.common.cache.LocalCache.ValueReference<K, V> getValueReference();

    long getWriteTime();

    void setAccessTime(long j);

    void setNextInAccessQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry);

    void setNextInWriteQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry);

    void setPreviousInAccessQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry);

    void setPreviousInWriteQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry);

    void setValueReference(com.google.common.cache.LocalCache.ValueReference<K, V> valueReference);

    void setWriteTime(long j);
}
