package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(serializable = true)
/* loaded from: classes22.dex */
final class ReverseNaturalOrdering extends com.google.common.collect.Ordering<java.lang.Comparable> implements java.io.Serializable {
    static final com.google.common.collect.ReverseNaturalOrdering INSTANCE = new com.google.common.collect.ReverseNaturalOrdering();
    private static final long serialVersionUID = 0;

    private ReverseNaturalOrdering() {
    }

    private java.lang.Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(java.lang.Comparable comparable, java.lang.Comparable comparable2) {
        com.google.common.base.Preconditions.checkNotNull(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends java.lang.Comparable> E max(E e, E e2) {
        return (E) com.google.common.collect.NaturalOrdering.INSTANCE.min(e, e2);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends java.lang.Comparable> E max(E e, E e2, E e3, E... eArr) {
        return (E) com.google.common.collect.NaturalOrdering.INSTANCE.min(e, e2, e3, eArr);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends java.lang.Comparable> E max(java.lang.Iterable<E> iterable) {
        return (E) com.google.common.collect.NaturalOrdering.INSTANCE.min(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends java.lang.Comparable> E max(java.util.Iterator<E> it) {
        return (E) com.google.common.collect.NaturalOrdering.INSTANCE.min(it);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends java.lang.Comparable> E min(E e, E e2) {
        return (E) com.google.common.collect.NaturalOrdering.INSTANCE.max(e, e2);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends java.lang.Comparable> E min(E e, E e2, E e3, E... eArr) {
        return (E) com.google.common.collect.NaturalOrdering.INSTANCE.max(e, e2, e3, eArr);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends java.lang.Comparable> E min(java.lang.Iterable<E> iterable) {
        return (E) com.google.common.collect.NaturalOrdering.INSTANCE.max(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends java.lang.Comparable> E min(java.util.Iterator<E> it) {
        return (E) com.google.common.collect.NaturalOrdering.INSTANCE.max(it);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends java.lang.Comparable> com.google.common.collect.Ordering<S> reverse() {
        return com.google.common.collect.Ordering.natural();
    }

    public java.lang.String toString() {
        return "Ordering.natural().reverse()";
    }
}
