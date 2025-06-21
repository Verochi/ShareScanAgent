package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class ForwardingSet<E> extends com.google.common.collect.ForwardingCollection<E> implements java.util.Set<E> {
    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract java.util.Set<E> delegate();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return delegate().hashCode();
    }

    public boolean standardEquals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return com.google.common.collect.Sets.a(this, obj);
    }

    public int standardHashCode() {
        return com.google.common.collect.Sets.b(this);
    }

    @Override // com.google.common.collect.ForwardingCollection
    public boolean standardRemoveAll(java.util.Collection<?> collection) {
        return com.google.common.collect.Sets.d(this, (java.util.Collection) com.google.common.base.Preconditions.checkNotNull(collection));
    }
}
