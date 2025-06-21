package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
final class RegularContiguousSet<C extends java.lang.Comparable> extends com.google.common.collect.ContiguousSet<C> {
    private static final long serialVersionUID = 0;
    private final com.google.common.collect.Range<C> range;

    /* renamed from: com.google.common.collect.RegularContiguousSet$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.collect.AbstractSequentialIterator<C> {
        public final C t;

        public AnonymousClass1(java.lang.Comparable comparable) {
            super(comparable);
            this.t = (C) com.google.common.collect.RegularContiguousSet.this.last();
        }

        @Override // com.google.common.collect.AbstractSequentialIterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C computeNext(C c) {
            if (com.google.common.collect.RegularContiguousSet.equalsOrThrow(c, this.t)) {
                return null;
            }
            return com.google.common.collect.RegularContiguousSet.this.domain.next(c);
        }
    }

    /* renamed from: com.google.common.collect.RegularContiguousSet$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.common.collect.AbstractSequentialIterator<C> {
        public final C t;

        public AnonymousClass2(java.lang.Comparable comparable) {
            super(comparable);
            this.t = (C) com.google.common.collect.RegularContiguousSet.this.first();
        }

        @Override // com.google.common.collect.AbstractSequentialIterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C computeNext(C c) {
            if (com.google.common.collect.RegularContiguousSet.equalsOrThrow(c, this.t)) {
                return null;
            }
            return com.google.common.collect.RegularContiguousSet.this.domain.previous(c);
        }
    }

    /* renamed from: com.google.common.collect.RegularContiguousSet$3, reason: invalid class name */
    public class AnonymousClass3 extends com.google.common.collect.ImmutableAsList<C> {
        public AnonymousClass3() {
        }

        @Override // com.google.common.collect.ImmutableAsList
        public com.google.common.collect.ImmutableSortedSet<C> delegateCollection() {
            return com.google.common.collect.RegularContiguousSet.this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public C get(int i) {
            com.google.common.base.Preconditions.checkElementIndex(i, size());
            com.google.common.collect.RegularContiguousSet regularContiguousSet = com.google.common.collect.RegularContiguousSet.this;
            return (C) regularContiguousSet.domain.offset(regularContiguousSet.first(), i);
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static final class SerializedForm<C extends java.lang.Comparable> implements java.io.Serializable {
        final com.google.common.collect.DiscreteDomain<C> domain;
        final com.google.common.collect.Range<C> range;

        private SerializedForm(com.google.common.collect.Range<C> range, com.google.common.collect.DiscreteDomain<C> discreteDomain) {
            this.range = range;
            this.domain = discreteDomain;
        }

        public /* synthetic */ SerializedForm(com.google.common.collect.Range range, com.google.common.collect.DiscreteDomain discreteDomain, com.google.common.collect.RegularContiguousSet.AnonymousClass1 anonymousClass1) {
            this(range, discreteDomain);
        }

        private java.lang.Object readResolve() {
            return new com.google.common.collect.RegularContiguousSet(this.range, this.domain);
        }
    }

    public RegularContiguousSet(com.google.common.collect.Range<C> range, com.google.common.collect.DiscreteDomain<C> discreteDomain) {
        super(discreteDomain);
        this.range = range;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean equalsOrThrow(java.lang.Comparable<?> comparable, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Comparable<?> comparable2) {
        return comparable2 != null && com.google.common.collect.Range.compareOrThrow(comparable, comparable2) == 0;
    }

    private com.google.common.collect.ContiguousSet<C> intersectionInCurrentDomain(com.google.common.collect.Range<C> range) {
        return this.range.isConnected(range) ? com.google.common.collect.ContiguousSet.create(this.range.intersection(range), this.domain) : new com.google.common.collect.EmptyContiguousSet(this.domain);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.range.contains((java.lang.Comparable) obj);
        } catch (java.lang.ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(java.util.Collection<?> collection) {
        return com.google.common.collect.Collections2.c(this, collection);
    }

    @Override // com.google.common.collect.ImmutableSet
    public com.google.common.collect.ImmutableList<C> createAsList() {
        return this.domain.supportsFastOffset ? new com.google.common.collect.RegularContiguousSet.AnonymousClass3() : super.createAsList();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @com.google.common.annotations.GwtIncompatible
    public com.google.common.collect.UnmodifiableIterator<C> descendingIterator() {
        return new com.google.common.collect.RegularContiguousSet.AnonymousClass2(last());
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof com.google.common.collect.RegularContiguousSet) {
            com.google.common.collect.RegularContiguousSet regularContiguousSet = (com.google.common.collect.RegularContiguousSet) obj;
            if (this.domain.equals(regularContiguousSet.domain)) {
                return first().equals(regularContiguousSet.first()) && last().equals(regularContiguousSet.last());
            }
        }
        return super.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C first() {
        return this.range.lowerBound.leastValueAbove(this.domain);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return com.google.common.collect.Sets.b(this);
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public com.google.common.collect.ContiguousSet<C> headSetImpl(C c, boolean z) {
        return intersectionInCurrentDomain(com.google.common.collect.Range.upTo(c, com.google.common.collect.BoundType.forBoolean(z)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    @com.google.common.annotations.GwtIncompatible
    public int indexOf(java.lang.Object obj) {
        if (contains(obj)) {
            return (int) this.domain.distance(first(), (java.lang.Comparable) obj);
        }
        return -1;
    }

    @Override // com.google.common.collect.ContiguousSet
    public com.google.common.collect.ContiguousSet<C> intersection(com.google.common.collect.ContiguousSet<C> contiguousSet) {
        com.google.common.base.Preconditions.checkNotNull(contiguousSet);
        com.google.common.base.Preconditions.checkArgument(this.domain.equals(contiguousSet.domain));
        if (contiguousSet.isEmpty()) {
            return contiguousSet;
        }
        java.lang.Comparable comparable = (java.lang.Comparable) com.google.common.collect.Ordering.natural().max(first(), contiguousSet.first());
        java.lang.Comparable comparable2 = (java.lang.Comparable) com.google.common.collect.Ordering.natural().min(last(), contiguousSet.last());
        return comparable.compareTo(comparable2) <= 0 ? com.google.common.collect.ContiguousSet.create(com.google.common.collect.Range.closed(comparable, comparable2), this.domain) : new com.google.common.collect.EmptyContiguousSet(this.domain);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public com.google.common.collect.UnmodifiableIterator<C> iterator() {
        return new com.google.common.collect.RegularContiguousSet.AnonymousClass1(first());
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C last() {
        return this.range.upperBound.greatestValueBelow(this.domain);
    }

    @Override // com.google.common.collect.ContiguousSet
    public com.google.common.collect.Range<C> range() {
        com.google.common.collect.BoundType boundType = com.google.common.collect.BoundType.CLOSED;
        return range(boundType, boundType);
    }

    @Override // com.google.common.collect.ContiguousSet
    public com.google.common.collect.Range<C> range(com.google.common.collect.BoundType boundType, com.google.common.collect.BoundType boundType2) {
        return com.google.common.collect.Range.create(this.range.lowerBound.withLowerBoundType(boundType, this.domain), this.range.upperBound.withUpperBoundType(boundType2, this.domain));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        long distance = this.domain.distance(first(), last());
        if (distance >= 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return ((int) distance) + 1;
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public com.google.common.collect.ContiguousSet<C> subSetImpl(C c, boolean z, C c2, boolean z2) {
        return (c.compareTo(c2) != 0 || z || z2) ? intersectionInCurrentDomain(com.google.common.collect.Range.range(c, com.google.common.collect.BoundType.forBoolean(z), c2, com.google.common.collect.BoundType.forBoolean(z2))) : new com.google.common.collect.EmptyContiguousSet(this.domain);
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public com.google.common.collect.ContiguousSet<C> tailSetImpl(C c, boolean z) {
        return intersectionInCurrentDomain(com.google.common.collect.Range.downTo(c, com.google.common.collect.BoundType.forBoolean(z)));
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    @com.google.common.annotations.GwtIncompatible
    public java.lang.Object writeReplace() {
        return new com.google.common.collect.RegularContiguousSet.SerializedForm(this.range, this.domain, null);
    }
}
