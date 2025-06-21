package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(serializable = true)
/* loaded from: classes22.dex */
final class AllEqualOrdering extends com.google.common.collect.Ordering<java.lang.Object> implements java.io.Serializable {
    static final com.google.common.collect.AllEqualOrdering INSTANCE = new com.google.common.collect.AllEqualOrdering();
    private static final long serialVersionUID = 0;

    private java.lang.Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        return 0;
    }

    @Override // com.google.common.collect.Ordering
    public <E> com.google.common.collect.ImmutableList<E> immutableSortedCopy(java.lang.Iterable<E> iterable) {
        return com.google.common.collect.ImmutableList.copyOf(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public <S> com.google.common.collect.Ordering<S> reverse() {
        return this;
    }

    @Override // com.google.common.collect.Ordering
    public <E> java.util.List<E> sortedCopy(java.lang.Iterable<E> iterable) {
        return com.google.common.collect.Lists.newArrayList(iterable);
    }

    public java.lang.String toString() {
        return "Ordering.allEqual()";
    }
}
