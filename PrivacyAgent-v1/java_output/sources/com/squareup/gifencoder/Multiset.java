package com.squareup.gifencoder;

/* loaded from: classes19.dex */
public interface Multiset<E> extends java.util.Collection<E> {
    void add(E e, int i);

    int count(java.lang.Object obj);

    java.util.Set<E> getDistinctElements();

    int remove(java.lang.Object obj, int i);
}
