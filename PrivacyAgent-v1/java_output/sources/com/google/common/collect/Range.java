package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class Range<C extends java.lang.Comparable> extends com.google.common.collect.RangeGwtSerializationDependencies implements com.google.common.base.Predicate<C> {
    private static final com.google.common.collect.Range<java.lang.Comparable> ALL = new com.google.common.collect.Range<>(com.google.common.collect.Cut.belowAll(), com.google.common.collect.Cut.aboveAll());
    private static final long serialVersionUID = 0;
    final com.google.common.collect.Cut<C> lowerBound;
    final com.google.common.collect.Cut<C> upperBound;

    /* renamed from: com.google.common.collect.Range$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.google.common.collect.BoundType.values().length];
            a = iArr;
            try {
                iArr[com.google.common.collect.BoundType.OPEN.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.google.common.collect.BoundType.CLOSED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public static class LowerBoundFn implements com.google.common.base.Function<com.google.common.collect.Range, com.google.common.collect.Cut> {
        public static final com.google.common.collect.Range.LowerBoundFn n = new com.google.common.collect.Range.LowerBoundFn();

        @Override // com.google.common.base.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.Cut apply(com.google.common.collect.Range range) {
            return range.lowerBound;
        }
    }

    public static class RangeLexOrdering extends com.google.common.collect.Ordering<com.google.common.collect.Range<?>> implements java.io.Serializable {
        static final com.google.common.collect.Ordering<com.google.common.collect.Range<?>> INSTANCE = new com.google.common.collect.Range.RangeLexOrdering();
        private static final long serialVersionUID = 0;

        private RangeLexOrdering() {
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(com.google.common.collect.Range<?> range, com.google.common.collect.Range<?> range2) {
            return com.google.common.collect.ComparisonChain.start().compare(range.lowerBound, range2.lowerBound).compare(range.upperBound, range2.upperBound).result();
        }
    }

    public static class UpperBoundFn implements com.google.common.base.Function<com.google.common.collect.Range, com.google.common.collect.Cut> {
        public static final com.google.common.collect.Range.UpperBoundFn n = new com.google.common.collect.Range.UpperBoundFn();

        @Override // com.google.common.base.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.Cut apply(com.google.common.collect.Range range) {
            return range.upperBound;
        }
    }

    private Range(com.google.common.collect.Cut<C> cut, com.google.common.collect.Cut<C> cut2) {
        this.lowerBound = (com.google.common.collect.Cut) com.google.common.base.Preconditions.checkNotNull(cut);
        this.upperBound = (com.google.common.collect.Cut) com.google.common.base.Preconditions.checkNotNull(cut2);
        if (cut.compareTo((com.google.common.collect.Cut) cut2) > 0 || cut == com.google.common.collect.Cut.aboveAll() || cut2 == com.google.common.collect.Cut.belowAll()) {
            throw new java.lang.IllegalArgumentException("Invalid range: " + toString(cut, cut2));
        }
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.Range<C> all() {
        return (com.google.common.collect.Range<C>) ALL;
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.Range<C> atLeast(C c) {
        return create(com.google.common.collect.Cut.belowValue(c), com.google.common.collect.Cut.aboveAll());
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.Range<C> atMost(C c) {
        return create(com.google.common.collect.Cut.belowAll(), com.google.common.collect.Cut.aboveValue(c));
    }

    private static <T> java.util.SortedSet<T> cast(java.lang.Iterable<T> iterable) {
        return (java.util.SortedSet) iterable;
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.Range<C> closed(C c, C c2) {
        return create(com.google.common.collect.Cut.belowValue(c), com.google.common.collect.Cut.aboveValue(c2));
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.Range<C> closedOpen(C c, C c2) {
        return create(com.google.common.collect.Cut.belowValue(c), com.google.common.collect.Cut.belowValue(c2));
    }

    public static int compareOrThrow(java.lang.Comparable comparable, java.lang.Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.Range<C> create(com.google.common.collect.Cut<C> cut, com.google.common.collect.Cut<C> cut2) {
        return new com.google.common.collect.Range<>(cut, cut2);
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.Range<C> downTo(C c, com.google.common.collect.BoundType boundType) {
        int i = com.google.common.collect.Range.AnonymousClass1.a[boundType.ordinal()];
        if (i == 1) {
            return greaterThan(c);
        }
        if (i == 2) {
            return atLeast(c);
        }
        throw new java.lang.AssertionError();
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.Range<C> encloseAll(java.lang.Iterable<C> iterable) {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        if (iterable instanceof java.util.SortedSet) {
            java.util.SortedSet cast = cast(iterable);
            java.util.Comparator comparator = cast.comparator();
            if (com.google.common.collect.Ordering.natural().equals(comparator) || comparator == null) {
                return closed((java.lang.Comparable) cast.first(), (java.lang.Comparable) cast.last());
            }
        }
        java.util.Iterator<C> it = iterable.iterator();
        java.lang.Comparable comparable = (java.lang.Comparable) com.google.common.base.Preconditions.checkNotNull(it.next());
        java.lang.Comparable comparable2 = comparable;
        while (it.hasNext()) {
            java.lang.Comparable comparable3 = (java.lang.Comparable) com.google.common.base.Preconditions.checkNotNull(it.next());
            comparable = (java.lang.Comparable) com.google.common.collect.Ordering.natural().min(comparable, comparable3);
            comparable2 = (java.lang.Comparable) com.google.common.collect.Ordering.natural().max(comparable2, comparable3);
        }
        return closed(comparable, comparable2);
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.Range<C> greaterThan(C c) {
        return create(com.google.common.collect.Cut.aboveValue(c), com.google.common.collect.Cut.aboveAll());
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.Range<C> lessThan(C c) {
        return create(com.google.common.collect.Cut.belowAll(), com.google.common.collect.Cut.belowValue(c));
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.base.Function<com.google.common.collect.Range<C>, com.google.common.collect.Cut<C>> lowerBoundFn() {
        return com.google.common.collect.Range.LowerBoundFn.n;
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.Range<C> open(C c, C c2) {
        return create(com.google.common.collect.Cut.aboveValue(c), com.google.common.collect.Cut.belowValue(c2));
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.Range<C> openClosed(C c, C c2) {
        return create(com.google.common.collect.Cut.aboveValue(c), com.google.common.collect.Cut.aboveValue(c2));
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.Range<C> range(C c, com.google.common.collect.BoundType boundType, C c2, com.google.common.collect.BoundType boundType2) {
        com.google.common.base.Preconditions.checkNotNull(boundType);
        com.google.common.base.Preconditions.checkNotNull(boundType2);
        com.google.common.collect.BoundType boundType3 = com.google.common.collect.BoundType.OPEN;
        return create(boundType == boundType3 ? com.google.common.collect.Cut.aboveValue(c) : com.google.common.collect.Cut.belowValue(c), boundType2 == boundType3 ? com.google.common.collect.Cut.belowValue(c2) : com.google.common.collect.Cut.aboveValue(c2));
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.Ordering<com.google.common.collect.Range<C>> rangeLexOrdering() {
        return (com.google.common.collect.Ordering<com.google.common.collect.Range<C>>) com.google.common.collect.Range.RangeLexOrdering.INSTANCE;
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.Range<C> singleton(C c) {
        return closed(c, c);
    }

    private static java.lang.String toString(com.google.common.collect.Cut<?> cut, com.google.common.collect.Cut<?> cut2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(16);
        cut.describeAsLowerBound(sb);
        sb.append("..");
        cut2.describeAsUpperBound(sb);
        return sb.toString();
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.Range<C> upTo(C c, com.google.common.collect.BoundType boundType) {
        int i = com.google.common.collect.Range.AnonymousClass1.a[boundType.ordinal()];
        if (i == 1) {
            return lessThan(c);
        }
        if (i == 2) {
            return atMost(c);
        }
        throw new java.lang.AssertionError();
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.base.Function<com.google.common.collect.Range<C>, com.google.common.collect.Cut<C>> upperBoundFn() {
        return com.google.common.collect.Range.UpperBoundFn.n;
    }

    @Override // com.google.common.base.Predicate
    @java.lang.Deprecated
    public boolean apply(C c) {
        return contains(c);
    }

    public com.google.common.collect.Range<C> canonical(com.google.common.collect.DiscreteDomain<C> discreteDomain) {
        com.google.common.base.Preconditions.checkNotNull(discreteDomain);
        com.google.common.collect.Cut<C> canonical = this.lowerBound.canonical(discreteDomain);
        com.google.common.collect.Cut<C> canonical2 = this.upperBound.canonical(discreteDomain);
        return (canonical == this.lowerBound && canonical2 == this.upperBound) ? this : create(canonical, canonical2);
    }

    public boolean contains(C c) {
        com.google.common.base.Preconditions.checkNotNull(c);
        return this.lowerBound.isLessThan(c) && !this.upperBound.isLessThan(c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsAll(java.lang.Iterable<? extends C> iterable) {
        if (com.google.common.collect.Iterables.isEmpty(iterable)) {
            return true;
        }
        if (iterable instanceof java.util.SortedSet) {
            java.util.SortedSet cast = cast(iterable);
            java.util.Comparator comparator = cast.comparator();
            if (com.google.common.collect.Ordering.natural().equals(comparator) || comparator == null) {
                return contains((java.lang.Comparable) cast.first()) && contains((java.lang.Comparable) cast.last());
            }
        }
        java.util.Iterator<? extends C> it = iterable.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean encloses(com.google.common.collect.Range<C> range) {
        return this.lowerBound.compareTo((com.google.common.collect.Cut) range.lowerBound) <= 0 && this.upperBound.compareTo((com.google.common.collect.Cut) range.upperBound) >= 0;
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!(obj instanceof com.google.common.collect.Range)) {
            return false;
        }
        com.google.common.collect.Range range = (com.google.common.collect.Range) obj;
        return this.lowerBound.equals(range.lowerBound) && this.upperBound.equals(range.upperBound);
    }

    public com.google.common.collect.Range<C> gap(com.google.common.collect.Range<C> range) {
        boolean z = this.lowerBound.compareTo((com.google.common.collect.Cut) range.lowerBound) < 0;
        com.google.common.collect.Range<C> range2 = z ? this : range;
        if (!z) {
            range = this;
        }
        return create(range2.upperBound, range.lowerBound);
    }

    public boolean hasLowerBound() {
        return this.lowerBound != com.google.common.collect.Cut.belowAll();
    }

    public boolean hasUpperBound() {
        return this.upperBound != com.google.common.collect.Cut.aboveAll();
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public com.google.common.collect.Range<C> intersection(com.google.common.collect.Range<C> range) {
        int compareTo = this.lowerBound.compareTo((com.google.common.collect.Cut) range.lowerBound);
        int compareTo2 = this.upperBound.compareTo((com.google.common.collect.Cut) range.upperBound);
        if (compareTo >= 0 && compareTo2 <= 0) {
            return this;
        }
        if (compareTo > 0 || compareTo2 < 0) {
            return create(compareTo >= 0 ? this.lowerBound : range.lowerBound, compareTo2 <= 0 ? this.upperBound : range.upperBound);
        }
        return range;
    }

    public boolean isConnected(com.google.common.collect.Range<C> range) {
        return this.lowerBound.compareTo((com.google.common.collect.Cut) range.upperBound) <= 0 && range.lowerBound.compareTo((com.google.common.collect.Cut) this.upperBound) <= 0;
    }

    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public com.google.common.collect.BoundType lowerBoundType() {
        return this.lowerBound.typeAsLowerBound();
    }

    public C lowerEndpoint() {
        return this.lowerBound.endpoint();
    }

    public java.lang.Object readResolve() {
        return equals(ALL) ? all() : this;
    }

    public com.google.common.collect.Range<C> span(com.google.common.collect.Range<C> range) {
        int compareTo = this.lowerBound.compareTo((com.google.common.collect.Cut) range.lowerBound);
        int compareTo2 = this.upperBound.compareTo((com.google.common.collect.Cut) range.upperBound);
        if (compareTo <= 0 && compareTo2 >= 0) {
            return this;
        }
        if (compareTo < 0 || compareTo2 > 0) {
            return create(compareTo <= 0 ? this.lowerBound : range.lowerBound, compareTo2 >= 0 ? this.upperBound : range.upperBound);
        }
        return range;
    }

    public java.lang.String toString() {
        return toString(this.lowerBound, this.upperBound);
    }

    public com.google.common.collect.BoundType upperBoundType() {
        return this.upperBound.typeAsUpperBound();
    }

    public C upperEndpoint() {
        return this.upperBound.endpoint();
    }
}
