package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(serializable = true)
/* loaded from: classes22.dex */
final class NaturalOrdering extends com.google.common.collect.Ordering<java.lang.Comparable> implements java.io.Serializable {
    static final com.google.common.collect.NaturalOrdering INSTANCE = new com.google.common.collect.NaturalOrdering();
    private static final long serialVersionUID = 0;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient com.google.common.collect.Ordering<java.lang.Comparable> nullsFirst;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient com.google.common.collect.Ordering<java.lang.Comparable> nullsLast;

    private NaturalOrdering() {
    }

    private java.lang.Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(java.lang.Comparable comparable, java.lang.Comparable comparable2) {
        com.google.common.base.Preconditions.checkNotNull(comparable);
        com.google.common.base.Preconditions.checkNotNull(comparable2);
        return comparable.compareTo(comparable2);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends java.lang.Comparable> com.google.common.collect.Ordering<S> nullsFirst() {
        com.google.common.collect.Ordering<S> ordering = (com.google.common.collect.Ordering<S>) this.nullsFirst;
        if (ordering != null) {
            return ordering;
        }
        com.google.common.collect.Ordering<S> nullsFirst = super.nullsFirst();
        this.nullsFirst = nullsFirst;
        return nullsFirst;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends java.lang.Comparable> com.google.common.collect.Ordering<S> nullsLast() {
        com.google.common.collect.Ordering<S> ordering = (com.google.common.collect.Ordering<S>) this.nullsLast;
        if (ordering != null) {
            return ordering;
        }
        com.google.common.collect.Ordering<S> nullsLast = super.nullsLast();
        this.nullsLast = nullsLast;
        return nullsLast;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends java.lang.Comparable> com.google.common.collect.Ordering<S> reverse() {
        return com.google.common.collect.ReverseNaturalOrdering.INSTANCE;
    }

    public java.lang.String toString() {
        return "Ordering.natural()";
    }
}
