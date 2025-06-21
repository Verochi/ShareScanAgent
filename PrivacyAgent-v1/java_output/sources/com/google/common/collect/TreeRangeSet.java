package com.google.common.collect;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public class TreeRangeSet<C extends java.lang.Comparable<?>> extends com.google.common.collect.AbstractRangeSet<C> implements java.io.Serializable {

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient java.util.Set<com.google.common.collect.Range<C>> asDescendingSetOfRanges;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient java.util.Set<com.google.common.collect.Range<C>> asRanges;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient com.google.common.collect.RangeSet<C> complement;

    @com.google.common.annotations.VisibleForTesting
    final java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> rangesByLowerBound;

    public final class AsRanges extends com.google.common.collect.ForwardingCollection<com.google.common.collect.Range<C>> implements java.util.Set<com.google.common.collect.Range<C>> {
        public final java.util.Collection<com.google.common.collect.Range<C>> n;

        public AsRanges(java.util.Collection<com.google.common.collect.Range<C>> collection) {
            this.n = collection;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public java.util.Collection<com.google.common.collect.Range<C>> delegate() {
            return this.n;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return com.google.common.collect.Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return com.google.common.collect.Sets.b(this);
        }
    }

    public final class Complement extends com.google.common.collect.TreeRangeSet<C> {
        public Complement() {
            super(new com.google.common.collect.TreeRangeSet.ComplementRangesByLowerBound(com.google.common.collect.TreeRangeSet.this.rangesByLowerBound), null);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void add(com.google.common.collect.Range<C> range) {
            com.google.common.collect.TreeRangeSet.this.remove(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
        public com.google.common.collect.RangeSet<C> complement() {
            return com.google.common.collect.TreeRangeSet.this;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public boolean contains(C c) {
            return !com.google.common.collect.TreeRangeSet.this.contains(c);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void remove(com.google.common.collect.Range<C> range) {
            com.google.common.collect.TreeRangeSet.this.add(range);
        }
    }

    public static final class ComplementRangesByLowerBound<C extends java.lang.Comparable<?>> extends com.google.common.collect.AbstractNavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> {
        public final java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> n;
        public final java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> t;
        public final com.google.common.collect.Range<com.google.common.collect.Cut<C>> u;

        /* renamed from: com.google.common.collect.TreeRangeSet$ComplementRangesByLowerBound$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.AbstractIterator<java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>>> {
            public com.google.common.collect.Cut<C> u;
            public final /* synthetic */ com.google.common.collect.Cut v;
            public final /* synthetic */ com.google.common.collect.PeekingIterator w;

            public AnonymousClass1(com.google.common.collect.Cut cut, com.google.common.collect.PeekingIterator peekingIterator) {
                this.v = cut;
                this.w = peekingIterator;
                this.u = cut;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> computeNext() {
                com.google.common.collect.Range create;
                if (com.google.common.collect.TreeRangeSet.ComplementRangesByLowerBound.this.u.upperBound.isLessThan(this.u) || this.u == com.google.common.collect.Cut.aboveAll()) {
                    return (java.util.Map.Entry) endOfData();
                }
                if (this.w.hasNext()) {
                    com.google.common.collect.Range range = (com.google.common.collect.Range) this.w.next();
                    create = com.google.common.collect.Range.create(this.u, range.lowerBound);
                    this.u = range.upperBound;
                } else {
                    create = com.google.common.collect.Range.create(this.u, com.google.common.collect.Cut.aboveAll());
                    this.u = com.google.common.collect.Cut.aboveAll();
                }
                return com.google.common.collect.Maps.immutableEntry(create.lowerBound, create);
            }
        }

        /* renamed from: com.google.common.collect.TreeRangeSet$ComplementRangesByLowerBound$2, reason: invalid class name */
        public class AnonymousClass2 extends com.google.common.collect.AbstractIterator<java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>>> {
            public com.google.common.collect.Cut<C> u;
            public final /* synthetic */ com.google.common.collect.Cut v;
            public final /* synthetic */ com.google.common.collect.PeekingIterator w;

            public AnonymousClass2(com.google.common.collect.Cut cut, com.google.common.collect.PeekingIterator peekingIterator) {
                this.v = cut;
                this.w = peekingIterator;
                this.u = cut;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> computeNext() {
                if (this.u == com.google.common.collect.Cut.belowAll()) {
                    return (java.util.Map.Entry) endOfData();
                }
                if (this.w.hasNext()) {
                    com.google.common.collect.Range range = (com.google.common.collect.Range) this.w.next();
                    com.google.common.collect.Range create = com.google.common.collect.Range.create(range.upperBound, this.u);
                    this.u = range.lowerBound;
                    if (com.google.common.collect.TreeRangeSet.ComplementRangesByLowerBound.this.u.lowerBound.isLessThan(create.lowerBound)) {
                        return com.google.common.collect.Maps.immutableEntry(create.lowerBound, create);
                    }
                } else if (com.google.common.collect.TreeRangeSet.ComplementRangesByLowerBound.this.u.lowerBound.isLessThan(com.google.common.collect.Cut.belowAll())) {
                    com.google.common.collect.Range create2 = com.google.common.collect.Range.create(com.google.common.collect.Cut.belowAll(), this.u);
                    this.u = com.google.common.collect.Cut.belowAll();
                    return com.google.common.collect.Maps.immutableEntry(com.google.common.collect.Cut.belowAll(), create2);
                }
                return (java.util.Map.Entry) endOfData();
            }
        }

        public ComplementRangesByLowerBound(java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> navigableMap) {
            this(navigableMap, com.google.common.collect.Range.all());
        }

        public ComplementRangesByLowerBound(java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> navigableMap, com.google.common.collect.Range<com.google.common.collect.Cut<C>> range) {
            this.n = navigableMap;
            this.t = new com.google.common.collect.TreeRangeSet.RangesByUpperBound(navigableMap);
            this.u = range;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public java.util.Iterator<java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>>> a() {
            java.util.Collection<com.google.common.collect.Range<C>> values;
            com.google.common.collect.Cut cut;
            if (this.u.hasLowerBound()) {
                values = this.t.tailMap(this.u.lowerEndpoint(), this.u.lowerBoundType() == com.google.common.collect.BoundType.CLOSED).values();
            } else {
                values = this.t.values();
            }
            com.google.common.collect.PeekingIterator peekingIterator = com.google.common.collect.Iterators.peekingIterator(values.iterator());
            if (this.u.contains(com.google.common.collect.Cut.belowAll()) && (!peekingIterator.hasNext() || ((com.google.common.collect.Range) peekingIterator.peek()).lowerBound != com.google.common.collect.Cut.belowAll())) {
                cut = com.google.common.collect.Cut.belowAll();
            } else {
                if (!peekingIterator.hasNext()) {
                    return com.google.common.collect.Iterators.f();
                }
                cut = ((com.google.common.collect.Range) peekingIterator.next()).upperBound;
            }
            return new com.google.common.collect.TreeRangeSet.ComplementRangesByLowerBound.AnonymousClass1(cut, peekingIterator);
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        public java.util.Iterator<java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>>> b() {
            com.google.common.collect.Cut<C> higherKey;
            com.google.common.collect.PeekingIterator peekingIterator = com.google.common.collect.Iterators.peekingIterator(this.t.headMap(this.u.hasUpperBound() ? this.u.upperEndpoint() : com.google.common.collect.Cut.aboveAll(), this.u.hasUpperBound() && this.u.upperBoundType() == com.google.common.collect.BoundType.CLOSED).descendingMap().values().iterator());
            if (peekingIterator.hasNext()) {
                higherKey = ((com.google.common.collect.Range) peekingIterator.peek()).upperBound == com.google.common.collect.Cut.aboveAll() ? ((com.google.common.collect.Range) peekingIterator.next()).lowerBound : this.n.higherKey(((com.google.common.collect.Range) peekingIterator.peek()).upperBound);
            } else {
                if (!this.u.contains(com.google.common.collect.Cut.belowAll()) || this.n.containsKey(com.google.common.collect.Cut.belowAll())) {
                    return com.google.common.collect.Iterators.f();
                }
                higherKey = this.n.higherKey(com.google.common.collect.Cut.belowAll());
            }
            return new com.google.common.collect.TreeRangeSet.ComplementRangesByLowerBound.AnonymousClass2((com.google.common.collect.Cut) com.google.common.base.MoreObjects.firstNonNull(higherKey, com.google.common.collect.Cut.aboveAll()), peekingIterator);
        }

        @Override // java.util.SortedMap
        public java.util.Comparator<? super com.google.common.collect.Cut<C>> comparator() {
            return com.google.common.collect.Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(java.lang.Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.Range<C> get(java.lang.Object obj) {
            if (obj instanceof com.google.common.collect.Cut) {
                try {
                    com.google.common.collect.Cut<C> cut = (com.google.common.collect.Cut) obj;
                    java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> firstEntry = tailMap(cut, true).firstEntry();
                    if (firstEntry != null && firstEntry.getKey().equals(cut)) {
                        return firstEntry.getValue();
                    }
                } catch (java.lang.ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> headMap(com.google.common.collect.Cut<C> cut, boolean z) {
            return h(com.google.common.collect.Range.upTo(cut, com.google.common.collect.BoundType.forBoolean(z)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> subMap(com.google.common.collect.Cut<C> cut, boolean z, com.google.common.collect.Cut<C> cut2, boolean z2) {
            return h(com.google.common.collect.Range.range(cut, com.google.common.collect.BoundType.forBoolean(z), cut2, com.google.common.collect.BoundType.forBoolean(z2)));
        }

        public final java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> h(com.google.common.collect.Range<com.google.common.collect.Cut<C>> range) {
            if (!this.u.isConnected(range)) {
                return com.google.common.collect.ImmutableSortedMap.of();
            }
            return new com.google.common.collect.TreeRangeSet.ComplementRangesByLowerBound(this.n, range.intersection(this.u));
        }

        @Override // java.util.NavigableMap
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> tailMap(com.google.common.collect.Cut<C> cut, boolean z) {
            return h(com.google.common.collect.Range.downTo(cut, com.google.common.collect.BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return com.google.common.collect.Iterators.size(a());
        }
    }

    @com.google.common.annotations.VisibleForTesting
    public static final class RangesByUpperBound<C extends java.lang.Comparable<?>> extends com.google.common.collect.AbstractNavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> {
        public final java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> n;
        public final com.google.common.collect.Range<com.google.common.collect.Cut<C>> t;

        /* renamed from: com.google.common.collect.TreeRangeSet$RangesByUpperBound$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.AbstractIterator<java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>>> {
            public final /* synthetic */ java.util.Iterator u;

            public AnonymousClass1(java.util.Iterator it) {
                this.u = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> computeNext() {
                if (!this.u.hasNext()) {
                    return (java.util.Map.Entry) endOfData();
                }
                com.google.common.collect.Range range = (com.google.common.collect.Range) this.u.next();
                return com.google.common.collect.TreeRangeSet.RangesByUpperBound.this.t.upperBound.isLessThan(range.upperBound) ? (java.util.Map.Entry) endOfData() : com.google.common.collect.Maps.immutableEntry(range.upperBound, range);
            }
        }

        /* renamed from: com.google.common.collect.TreeRangeSet$RangesByUpperBound$2, reason: invalid class name */
        public class AnonymousClass2 extends com.google.common.collect.AbstractIterator<java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>>> {
            public final /* synthetic */ com.google.common.collect.PeekingIterator u;

            public AnonymousClass2(com.google.common.collect.PeekingIterator peekingIterator) {
                this.u = peekingIterator;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> computeNext() {
                if (!this.u.hasNext()) {
                    return (java.util.Map.Entry) endOfData();
                }
                com.google.common.collect.Range range = (com.google.common.collect.Range) this.u.next();
                return com.google.common.collect.TreeRangeSet.RangesByUpperBound.this.t.lowerBound.isLessThan(range.upperBound) ? com.google.common.collect.Maps.immutableEntry(range.upperBound, range) : (java.util.Map.Entry) endOfData();
            }
        }

        public RangesByUpperBound(java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> navigableMap) {
            this.n = navigableMap;
            this.t = com.google.common.collect.Range.all();
        }

        public RangesByUpperBound(java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> navigableMap, com.google.common.collect.Range<com.google.common.collect.Cut<C>> range) {
            this.n = navigableMap;
            this.t = range;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public java.util.Iterator<java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>>> a() {
            java.util.Iterator<com.google.common.collect.Range<C>> it;
            if (this.t.hasLowerBound()) {
                java.util.Map.Entry lowerEntry = this.n.lowerEntry(this.t.lowerEndpoint());
                it = lowerEntry == null ? this.n.values().iterator() : this.t.lowerBound.isLessThan(((com.google.common.collect.Range) lowerEntry.getValue()).upperBound) ? this.n.tailMap(lowerEntry.getKey(), true).values().iterator() : this.n.tailMap(this.t.lowerEndpoint(), true).values().iterator();
            } else {
                it = this.n.values().iterator();
            }
            return new com.google.common.collect.TreeRangeSet.RangesByUpperBound.AnonymousClass1(it);
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        public java.util.Iterator<java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>>> b() {
            com.google.common.collect.PeekingIterator peekingIterator = com.google.common.collect.Iterators.peekingIterator((this.t.hasUpperBound() ? this.n.headMap(this.t.upperEndpoint(), false).descendingMap().values() : this.n.descendingMap().values()).iterator());
            if (peekingIterator.hasNext() && this.t.upperBound.isLessThan(((com.google.common.collect.Range) peekingIterator.peek()).upperBound)) {
                peekingIterator.next();
            }
            return new com.google.common.collect.TreeRangeSet.RangesByUpperBound.AnonymousClass2(peekingIterator);
        }

        @Override // java.util.SortedMap
        public java.util.Comparator<? super com.google.common.collect.Cut<C>> comparator() {
            return com.google.common.collect.Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.Range<C> get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> lowerEntry;
            if (obj instanceof com.google.common.collect.Cut) {
                try {
                    com.google.common.collect.Cut<C> cut = (com.google.common.collect.Cut) obj;
                    if (this.t.contains(cut) && (lowerEntry = this.n.lowerEntry(cut)) != null && lowerEntry.getValue().upperBound.equals(cut)) {
                        return lowerEntry.getValue();
                    }
                } catch (java.lang.ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> headMap(com.google.common.collect.Cut<C> cut, boolean z) {
            return h(com.google.common.collect.Range.upTo(cut, com.google.common.collect.BoundType.forBoolean(z)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> subMap(com.google.common.collect.Cut<C> cut, boolean z, com.google.common.collect.Cut<C> cut2, boolean z2) {
            return h(com.google.common.collect.Range.range(cut, com.google.common.collect.BoundType.forBoolean(z), cut2, com.google.common.collect.BoundType.forBoolean(z2)));
        }

        public final java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> h(com.google.common.collect.Range<com.google.common.collect.Cut<C>> range) {
            return range.isConnected(this.t) ? new com.google.common.collect.TreeRangeSet.RangesByUpperBound(this.n, range.intersection(this.t)) : com.google.common.collect.ImmutableSortedMap.of();
        }

        @Override // java.util.NavigableMap
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> tailMap(com.google.common.collect.Cut<C> cut, boolean z) {
            return h(com.google.common.collect.Range.downTo(cut, com.google.common.collect.BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.t.equals(com.google.common.collect.Range.all()) ? this.n.isEmpty() : !a().hasNext();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.t.equals(com.google.common.collect.Range.all()) ? this.n.size() : com.google.common.collect.Iterators.size(a());
        }
    }

    public final class SubRangeSet extends com.google.common.collect.TreeRangeSet<C> {
        private final com.google.common.collect.Range<C> restriction;

        public SubRangeSet(com.google.common.collect.Range<C> range) {
            super(new com.google.common.collect.TreeRangeSet.SubRangeSetRangesByLowerBound(com.google.common.collect.Range.all(), range, com.google.common.collect.TreeRangeSet.this.rangesByLowerBound, null), null);
            this.restriction = range;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void add(com.google.common.collect.Range<C> range) {
            com.google.common.base.Preconditions.checkArgument(this.restriction.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.restriction);
            super.add(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void clear() {
            com.google.common.collect.TreeRangeSet.this.remove(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public boolean contains(C c) {
            return this.restriction.contains(c) && com.google.common.collect.TreeRangeSet.this.contains(c);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public boolean encloses(com.google.common.collect.Range<C> range) {
            com.google.common.collect.Range rangeEnclosing;
            return (this.restriction.isEmpty() || !this.restriction.encloses(range) || (rangeEnclosing = com.google.common.collect.TreeRangeSet.this.rangeEnclosing(range)) == null || rangeEnclosing.intersection(this.restriction).isEmpty()) ? false : true;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.Range<C> rangeContaining(C c) {
            com.google.common.collect.Range<C> rangeContaining;
            if (this.restriction.contains(c) && (rangeContaining = com.google.common.collect.TreeRangeSet.this.rangeContaining(c)) != null) {
                return rangeContaining.intersection(this.restriction);
            }
            return null;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void remove(com.google.common.collect.Range<C> range) {
            if (range.isConnected(this.restriction)) {
                com.google.common.collect.TreeRangeSet.this.remove(range.intersection(this.restriction));
            }
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
        public com.google.common.collect.RangeSet<C> subRangeSet(com.google.common.collect.Range<C> range) {
            return range.encloses(this.restriction) ? this : range.isConnected(this.restriction) ? new com.google.common.collect.TreeRangeSet.SubRangeSet(this.restriction.intersection(range)) : com.google.common.collect.ImmutableRangeSet.of();
        }
    }

    public static final class SubRangeSetRangesByLowerBound<C extends java.lang.Comparable<?>> extends com.google.common.collect.AbstractNavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> {
        public final com.google.common.collect.Range<com.google.common.collect.Cut<C>> n;
        public final com.google.common.collect.Range<C> t;
        public final java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> u;
        public final java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> v;

        /* renamed from: com.google.common.collect.TreeRangeSet$SubRangeSetRangesByLowerBound$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.AbstractIterator<java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>>> {
            public final /* synthetic */ java.util.Iterator u;
            public final /* synthetic */ com.google.common.collect.Cut v;

            public AnonymousClass1(java.util.Iterator it, com.google.common.collect.Cut cut) {
                this.u = it;
                this.v = cut;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> computeNext() {
                if (!this.u.hasNext()) {
                    return (java.util.Map.Entry) endOfData();
                }
                com.google.common.collect.Range range = (com.google.common.collect.Range) this.u.next();
                if (this.v.isLessThan(range.lowerBound)) {
                    return (java.util.Map.Entry) endOfData();
                }
                com.google.common.collect.Range intersection = range.intersection(com.google.common.collect.TreeRangeSet.SubRangeSetRangesByLowerBound.this.t);
                return com.google.common.collect.Maps.immutableEntry(intersection.lowerBound, intersection);
            }
        }

        /* renamed from: com.google.common.collect.TreeRangeSet$SubRangeSetRangesByLowerBound$2, reason: invalid class name */
        public class AnonymousClass2 extends com.google.common.collect.AbstractIterator<java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>>> {
            public final /* synthetic */ java.util.Iterator u;

            public AnonymousClass2(java.util.Iterator it) {
                this.u = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> computeNext() {
                if (!this.u.hasNext()) {
                    return (java.util.Map.Entry) endOfData();
                }
                com.google.common.collect.Range range = (com.google.common.collect.Range) this.u.next();
                if (com.google.common.collect.TreeRangeSet.SubRangeSetRangesByLowerBound.this.t.lowerBound.compareTo((com.google.common.collect.Cut) range.upperBound) >= 0) {
                    return (java.util.Map.Entry) endOfData();
                }
                com.google.common.collect.Range intersection = range.intersection(com.google.common.collect.TreeRangeSet.SubRangeSetRangesByLowerBound.this.t);
                return com.google.common.collect.TreeRangeSet.SubRangeSetRangesByLowerBound.this.n.contains(intersection.lowerBound) ? com.google.common.collect.Maps.immutableEntry(intersection.lowerBound, intersection) : (java.util.Map.Entry) endOfData();
            }
        }

        public SubRangeSetRangesByLowerBound(com.google.common.collect.Range<com.google.common.collect.Cut<C>> range, com.google.common.collect.Range<C> range2, java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> navigableMap) {
            this.n = (com.google.common.collect.Range) com.google.common.base.Preconditions.checkNotNull(range);
            this.t = (com.google.common.collect.Range) com.google.common.base.Preconditions.checkNotNull(range2);
            this.u = (java.util.NavigableMap) com.google.common.base.Preconditions.checkNotNull(navigableMap);
            this.v = new com.google.common.collect.TreeRangeSet.RangesByUpperBound(navigableMap);
        }

        public /* synthetic */ SubRangeSetRangesByLowerBound(com.google.common.collect.Range range, com.google.common.collect.Range range2, java.util.NavigableMap navigableMap, com.google.common.collect.TreeRangeSet.AnonymousClass1 anonymousClass1) {
            this(range, range2, navigableMap);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public java.util.Iterator<java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>>> a() {
            java.util.Iterator<com.google.common.collect.Range<C>> it;
            if (!this.t.isEmpty() && !this.n.upperBound.isLessThan(this.t.lowerBound)) {
                if (this.n.lowerBound.isLessThan(this.t.lowerBound)) {
                    it = this.v.tailMap(this.t.lowerBound, false).values().iterator();
                } else {
                    it = this.u.tailMap(this.n.lowerBound.endpoint(), this.n.lowerBoundType() == com.google.common.collect.BoundType.CLOSED).values().iterator();
                }
                return new com.google.common.collect.TreeRangeSet.SubRangeSetRangesByLowerBound.AnonymousClass1(it, (com.google.common.collect.Cut) com.google.common.collect.Ordering.natural().min(this.n.upperBound, com.google.common.collect.Cut.belowValue(this.t.upperBound)));
            }
            return com.google.common.collect.Iterators.f();
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        public java.util.Iterator<java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>>> b() {
            if (this.t.isEmpty()) {
                return com.google.common.collect.Iterators.f();
            }
            com.google.common.collect.Cut cut = (com.google.common.collect.Cut) com.google.common.collect.Ordering.natural().min(this.n.upperBound, com.google.common.collect.Cut.belowValue(this.t.upperBound));
            return new com.google.common.collect.TreeRangeSet.SubRangeSetRangesByLowerBound.AnonymousClass2(this.u.headMap(cut.endpoint(), cut.typeAsUpperBound() == com.google.common.collect.BoundType.CLOSED).descendingMap().values().iterator());
        }

        @Override // java.util.SortedMap
        public java.util.Comparator<? super com.google.common.collect.Cut<C>> comparator() {
            return com.google.common.collect.Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.Range<C> get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.collect.Cut) {
                try {
                    com.google.common.collect.Cut<C> cut = (com.google.common.collect.Cut) obj;
                    if (this.n.contains(cut) && cut.compareTo(this.t.lowerBound) >= 0 && cut.compareTo(this.t.upperBound) < 0) {
                        if (cut.equals(this.t.lowerBound)) {
                            com.google.common.collect.Range range = (com.google.common.collect.Range) com.google.common.collect.Maps.R(this.u.floorEntry(cut));
                            if (range != null && range.upperBound.compareTo((com.google.common.collect.Cut) this.t.lowerBound) > 0) {
                                return range.intersection(this.t);
                            }
                        } else {
                            com.google.common.collect.Range<C> range2 = this.u.get(cut);
                            if (range2 != null) {
                                return range2.intersection(this.t);
                            }
                        }
                    }
                } catch (java.lang.ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> headMap(com.google.common.collect.Cut<C> cut, boolean z) {
            return i(com.google.common.collect.Range.upTo(cut, com.google.common.collect.BoundType.forBoolean(z)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> subMap(com.google.common.collect.Cut<C> cut, boolean z, com.google.common.collect.Cut<C> cut2, boolean z2) {
            return i(com.google.common.collect.Range.range(cut, com.google.common.collect.BoundType.forBoolean(z), cut2, com.google.common.collect.BoundType.forBoolean(z2)));
        }

        public final java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> i(com.google.common.collect.Range<com.google.common.collect.Cut<C>> range) {
            return !range.isConnected(this.n) ? com.google.common.collect.ImmutableSortedMap.of() : new com.google.common.collect.TreeRangeSet.SubRangeSetRangesByLowerBound(this.n.intersection(range), this.t, this.u);
        }

        @Override // java.util.NavigableMap
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> tailMap(com.google.common.collect.Cut<C> cut, boolean z) {
            return i(com.google.common.collect.Range.downTo(cut, com.google.common.collect.BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return com.google.common.collect.Iterators.size(a());
        }
    }

    private TreeRangeSet(java.util.NavigableMap<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> navigableMap) {
        this.rangesByLowerBound = navigableMap;
    }

    public /* synthetic */ TreeRangeSet(java.util.NavigableMap navigableMap, com.google.common.collect.TreeRangeSet.AnonymousClass1 anonymousClass1) {
        this(navigableMap);
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.TreeRangeSet<C> create() {
        return new com.google.common.collect.TreeRangeSet<>(new java.util.TreeMap());
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.TreeRangeSet<C> create(com.google.common.collect.RangeSet<C> rangeSet) {
        com.google.common.collect.TreeRangeSet<C> create = create();
        create.addAll(rangeSet);
        return create;
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.TreeRangeSet<C> create(java.lang.Iterable<com.google.common.collect.Range<C>> iterable) {
        com.google.common.collect.TreeRangeSet<C> create = create();
        create.addAll(iterable);
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public com.google.common.collect.Range<C> rangeEnclosing(com.google.common.collect.Range<C> range) {
        com.google.common.base.Preconditions.checkNotNull(range);
        java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        if (floorEntry == null || !floorEntry.getValue().encloses(range)) {
            return null;
        }
        return floorEntry.getValue();
    }

    private void replaceRangeWithSameLowerBound(com.google.common.collect.Range<C> range) {
        if (range.isEmpty()) {
            this.rangesByLowerBound.remove(range.lowerBound);
        } else {
            this.rangesByLowerBound.put(range.lowerBound, range);
        }
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public void add(com.google.common.collect.Range<C> range) {
        com.google.common.base.Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return;
        }
        com.google.common.collect.Cut<C> cut = range.lowerBound;
        com.google.common.collect.Cut<C> cut2 = range.upperBound;
        java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(cut);
        if (lowerEntry != null) {
            com.google.common.collect.Range<C> value = lowerEntry.getValue();
            if (value.upperBound.compareTo(cut) >= 0) {
                if (value.upperBound.compareTo(cut2) >= 0) {
                    cut2 = value.upperBound;
                }
                cut = value.lowerBound;
            }
        }
        java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(cut2);
        if (floorEntry != null) {
            com.google.common.collect.Range<C> value2 = floorEntry.getValue();
            if (value2.upperBound.compareTo(cut2) >= 0) {
                cut2 = value2.upperBound;
            }
        }
        this.rangesByLowerBound.subMap(cut, cut2).clear();
        replaceRangeWithSameLowerBound(com.google.common.collect.Range.create(cut, cut2));
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void addAll(com.google.common.collect.RangeSet rangeSet) {
        super.addAll(rangeSet);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void addAll(java.lang.Iterable iterable) {
        super.addAll(iterable);
    }

    @Override // com.google.common.collect.RangeSet
    public java.util.Set<com.google.common.collect.Range<C>> asDescendingSetOfRanges() {
        java.util.Set<com.google.common.collect.Range<C>> set = this.asDescendingSetOfRanges;
        if (set != null) {
            return set;
        }
        com.google.common.collect.TreeRangeSet.AsRanges asRanges = new com.google.common.collect.TreeRangeSet.AsRanges(this.rangesByLowerBound.descendingMap().values());
        this.asDescendingSetOfRanges = asRanges;
        return asRanges;
    }

    @Override // com.google.common.collect.RangeSet
    public java.util.Set<com.google.common.collect.Range<C>> asRanges() {
        java.util.Set<com.google.common.collect.Range<C>> set = this.asRanges;
        if (set != null) {
            return set;
        }
        com.google.common.collect.TreeRangeSet.AsRanges asRanges = new com.google.common.collect.TreeRangeSet.AsRanges(this.rangesByLowerBound.values());
        this.asRanges = asRanges;
        return asRanges;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.RangeSet
    public com.google.common.collect.RangeSet<C> complement() {
        com.google.common.collect.RangeSet<C> rangeSet = this.complement;
        if (rangeSet != null) {
            return rangeSet;
        }
        com.google.common.collect.TreeRangeSet.Complement complement = new com.google.common.collect.TreeRangeSet.Complement();
        this.complement = complement;
        return complement;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean contains(java.lang.Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean encloses(com.google.common.collect.Range<C> range) {
        com.google.common.base.Preconditions.checkNotNull(range);
        java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        return floorEntry != null && floorEntry.getValue().encloses(range);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(com.google.common.collect.RangeSet rangeSet) {
        return super.enclosesAll(rangeSet);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(java.lang.Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean intersects(com.google.common.collect.Range<C> range) {
        com.google.common.base.Preconditions.checkNotNull(range);
        java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> ceilingEntry = this.rangesByLowerBound.ceilingEntry(range.lowerBound);
        if (ceilingEntry != null && ceilingEntry.getValue().isConnected(range) && !ceilingEntry.getValue().intersection(range).isEmpty()) {
            return true;
        }
        java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        return (lowerEntry == null || !lowerEntry.getValue().isConnected(range) || lowerEntry.getValue().intersection(range).isEmpty()) ? false : true;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public com.google.common.collect.Range<C> rangeContaining(C c) {
        com.google.common.base.Preconditions.checkNotNull(c);
        java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(com.google.common.collect.Cut.belowValue(c));
        if (floorEntry == null || !floorEntry.getValue().contains(c)) {
            return null;
        }
        return floorEntry.getValue();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public void remove(com.google.common.collect.Range<C> range) {
        com.google.common.base.Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return;
        }
        java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        if (lowerEntry != null) {
            com.google.common.collect.Range<C> value = lowerEntry.getValue();
            if (value.upperBound.compareTo(range.lowerBound) >= 0) {
                if (range.hasUpperBound() && value.upperBound.compareTo(range.upperBound) >= 0) {
                    replaceRangeWithSameLowerBound(com.google.common.collect.Range.create(range.upperBound, value.upperBound));
                }
                replaceRangeWithSameLowerBound(com.google.common.collect.Range.create(value.lowerBound, range.lowerBound));
            }
        }
        java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.upperBound);
        if (floorEntry != null) {
            com.google.common.collect.Range<C> value2 = floorEntry.getValue();
            if (range.hasUpperBound() && value2.upperBound.compareTo(range.upperBound) >= 0) {
                replaceRangeWithSameLowerBound(com.google.common.collect.Range.create(range.upperBound, value2.upperBound));
            }
        }
        this.rangesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void removeAll(com.google.common.collect.RangeSet rangeSet) {
        super.removeAll(rangeSet);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void removeAll(java.lang.Iterable iterable) {
        super.removeAll(iterable);
    }

    @Override // com.google.common.collect.RangeSet
    public com.google.common.collect.Range<C> span() {
        java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> firstEntry = this.rangesByLowerBound.firstEntry();
        java.util.Map.Entry<com.google.common.collect.Cut<C>, com.google.common.collect.Range<C>> lastEntry = this.rangesByLowerBound.lastEntry();
        if (firstEntry != null) {
            return com.google.common.collect.Range.create(firstEntry.getValue().lowerBound, lastEntry.getValue().upperBound);
        }
        throw new java.util.NoSuchElementException();
    }

    @Override // com.google.common.collect.RangeSet
    public com.google.common.collect.RangeSet<C> subRangeSet(com.google.common.collect.Range<C> range) {
        return range.equals(com.google.common.collect.Range.all()) ? this : new com.google.common.collect.TreeRangeSet.SubRangeSet(range);
    }
}
