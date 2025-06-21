package com.google.common.graph;

/* loaded from: classes22.dex */
final class EdgesConnecting<E> extends java.util.AbstractSet<E> {
    public final java.util.Map<?, E> n;
    public final java.lang.Object t;

    public EdgesConnecting(java.util.Map<?, E> map, java.lang.Object obj) {
        this.n = (java.util.Map) com.google.common.base.Preconditions.checkNotNull(map);
        this.t = com.google.common.base.Preconditions.checkNotNull(obj);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public final E a() {
        return this.n.get(this.t);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.google.common.collect.UnmodifiableIterator<E> iterator() {
        E a = a();
        return a == null ? com.google.common.collect.ImmutableSet.of().iterator() : com.google.common.collect.Iterators.singletonIterator(a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        E a = a();
        return a != null && a.equals(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return a() == null ? 0 : 1;
    }
}
