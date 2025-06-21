package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class Sets {

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* renamed from: com.google.common.collect.Sets$1, reason: invalid class name */
    public static class AnonymousClass1<E> extends com.google.common.collect.Sets.SetView<E> {
        public final /* synthetic */ java.util.Set n;
        public final /* synthetic */ java.util.Set t;

        /* renamed from: com.google.common.collect.Sets$1$1, reason: invalid class name and collision with other inner class name */
        public class C03451 extends com.google.common.collect.AbstractIterator<E> {
            public final java.util.Iterator<? extends E> u;
            public final java.util.Iterator<? extends E> v;

            public C03451() {
                this.u = com.google.common.collect.Sets.AnonymousClass1.this.n.iterator();
                this.v = com.google.common.collect.Sets.AnonymousClass1.this.t.iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            public E computeNext() {
                if (this.u.hasNext()) {
                    return this.u.next();
                }
                while (this.v.hasNext()) {
                    E next = this.v.next();
                    if (!com.google.common.collect.Sets.AnonymousClass1.this.n.contains(next)) {
                        return next;
                    }
                }
                return endOfData();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.util.Set set, java.util.Set set2) {
            super(null);
            this.n = set;
            this.t = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return this.n.contains(obj) || this.t.contains(obj);
        }

        @Override // com.google.common.collect.Sets.SetView
        public <S extends java.util.Set<E>> S copyInto(S s2) {
            s2.addAll(this.n);
            s2.addAll(this.t);
            return s2;
        }

        @Override // com.google.common.collect.Sets.SetView
        public com.google.common.collect.ImmutableSet<E> immutableCopy() {
            return new com.google.common.collect.ImmutableSet.Builder().addAll((java.lang.Iterable) this.n).addAll((java.lang.Iterable) this.t).build();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.n.isEmpty() && this.t.isEmpty();
        }

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public com.google.common.collect.UnmodifiableIterator<E> iterator() {
            return new com.google.common.collect.Sets.AnonymousClass1.C03451();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int size = this.n.size();
            java.util.Iterator<E> it = this.t.iterator();
            while (it.hasNext()) {
                if (!this.n.contains(it.next())) {
                    size++;
                }
            }
            return size;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* renamed from: com.google.common.collect.Sets$2, reason: invalid class name */
    public static class AnonymousClass2<E> extends com.google.common.collect.Sets.SetView<E> {
        public final /* synthetic */ java.util.Set n;
        public final /* synthetic */ java.util.Set t;

        /* renamed from: com.google.common.collect.Sets$2$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.AbstractIterator<E> {
            public final java.util.Iterator<E> u;

            public AnonymousClass1() {
                this.u = com.google.common.collect.Sets.AnonymousClass2.this.n.iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            public E computeNext() {
                while (this.u.hasNext()) {
                    E next = this.u.next();
                    if (com.google.common.collect.Sets.AnonymousClass2.this.t.contains(next)) {
                        return next;
                    }
                }
                return endOfData();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(java.util.Set set, java.util.Set set2) {
            super(null);
            this.n = set;
            this.t = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return this.n.contains(obj) && this.t.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(java.util.Collection<?> collection) {
            return this.n.containsAll(collection) && this.t.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return java.util.Collections.disjoint(this.t, this.n);
        }

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public com.google.common.collect.UnmodifiableIterator<E> iterator() {
            return new com.google.common.collect.Sets.AnonymousClass2.AnonymousClass1();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            java.util.Iterator<E> it = this.n.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (this.t.contains(it.next())) {
                    i++;
                }
            }
            return i;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* renamed from: com.google.common.collect.Sets$3, reason: invalid class name */
    public static class AnonymousClass3<E> extends com.google.common.collect.Sets.SetView<E> {
        public final /* synthetic */ java.util.Set n;
        public final /* synthetic */ java.util.Set t;

        /* renamed from: com.google.common.collect.Sets$3$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.AbstractIterator<E> {
            public final java.util.Iterator<E> u;

            public AnonymousClass1() {
                this.u = com.google.common.collect.Sets.AnonymousClass3.this.n.iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            public E computeNext() {
                while (this.u.hasNext()) {
                    E next = this.u.next();
                    if (!com.google.common.collect.Sets.AnonymousClass3.this.t.contains(next)) {
                        return next;
                    }
                }
                return endOfData();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(java.util.Set set, java.util.Set set2) {
            super(null);
            this.n = set;
            this.t = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return this.n.contains(obj) && !this.t.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.t.containsAll(this.n);
        }

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public com.google.common.collect.UnmodifiableIterator<E> iterator() {
            return new com.google.common.collect.Sets.AnonymousClass3.AnonymousClass1();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            java.util.Iterator<E> it = this.n.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (!this.t.contains(it.next())) {
                    i++;
                }
            }
            return i;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* renamed from: com.google.common.collect.Sets$4, reason: invalid class name */
    public static class AnonymousClass4<E> extends com.google.common.collect.Sets.SetView<E> {
        public final /* synthetic */ java.util.Set n;
        public final /* synthetic */ java.util.Set t;

        /* renamed from: com.google.common.collect.Sets$4$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.AbstractIterator<E> {
            public final /* synthetic */ java.util.Iterator u;
            public final /* synthetic */ java.util.Iterator v;

            public AnonymousClass1(java.util.Iterator it, java.util.Iterator it2) {
                this.u = it;
                this.v = it2;
            }

            @Override // com.google.common.collect.AbstractIterator
            public E computeNext() {
                while (this.u.hasNext()) {
                    E e = (E) this.u.next();
                    if (!com.google.common.collect.Sets.AnonymousClass4.this.t.contains(e)) {
                        return e;
                    }
                }
                while (this.v.hasNext()) {
                    E e2 = (E) this.v.next();
                    if (!com.google.common.collect.Sets.AnonymousClass4.this.n.contains(e2)) {
                        return e2;
                    }
                }
                return endOfData();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(java.util.Set set, java.util.Set set2) {
            super(null);
            this.n = set;
            this.t = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return this.t.contains(obj) ^ this.n.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.n.equals(this.t);
        }

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public com.google.common.collect.UnmodifiableIterator<E> iterator() {
            return new com.google.common.collect.Sets.AnonymousClass4.AnonymousClass1(this.n.iterator(), this.t.iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            java.util.Iterator<E> it = this.n.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (!this.t.contains(it.next())) {
                    i++;
                }
            }
            java.util.Iterator<E> it2 = this.t.iterator();
            while (it2.hasNext()) {
                if (!this.n.contains(it2.next())) {
                    i++;
                }
            }
            return i;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* renamed from: com.google.common.collect.Sets$5, reason: invalid class name */
    public static class AnonymousClass5<E> extends java.util.AbstractSet<java.util.Set<E>> {
        public final /* synthetic */ int n;
        public final /* synthetic */ com.google.common.collect.ImmutableMap t;

        /* renamed from: com.google.common.collect.Sets$5$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.AbstractIterator<java.util.Set<E>> {
            public final java.util.BitSet u;

            /* renamed from: com.google.common.collect.Sets$5$1$1, reason: invalid class name and collision with other inner class name */
            public class C03461 extends java.util.AbstractSet<E> {
                public final /* synthetic */ java.util.BitSet n;

                /* renamed from: com.google.common.collect.Sets$5$1$1$1, reason: invalid class name and collision with other inner class name */
                public class C03471 extends com.google.common.collect.AbstractIterator<E> {
                    public int u = -1;

                    public C03471() {
                    }

                    @Override // com.google.common.collect.AbstractIterator
                    public E computeNext() {
                        int nextSetBit = com.google.common.collect.Sets.AnonymousClass5.AnonymousClass1.C03461.this.n.nextSetBit(this.u + 1);
                        this.u = nextSetBit;
                        return nextSetBit == -1 ? endOfData() : com.google.common.collect.Sets.AnonymousClass5.this.t.keySet().asList().get(this.u);
                    }
                }

                public C03461(java.util.BitSet bitSet) {
                    this.n = bitSet;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
                    java.lang.Integer num = (java.lang.Integer) com.google.common.collect.Sets.AnonymousClass5.this.t.get(obj);
                    return num != null && this.n.get(num.intValue());
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public java.util.Iterator<E> iterator() {
                    return new com.google.common.collect.Sets.AnonymousClass5.AnonymousClass1.C03461.C03471();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return com.google.common.collect.Sets.AnonymousClass5.this.n;
                }
            }

            public AnonymousClass1() {
                this.u = new java.util.BitSet(com.google.common.collect.Sets.AnonymousClass5.this.t.size());
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public java.util.Set<E> computeNext() {
                if (this.u.isEmpty()) {
                    this.u.set(0, com.google.common.collect.Sets.AnonymousClass5.this.n);
                } else {
                    int nextSetBit = this.u.nextSetBit(0);
                    int nextClearBit = this.u.nextClearBit(nextSetBit);
                    if (nextClearBit == com.google.common.collect.Sets.AnonymousClass5.this.t.size()) {
                        return endOfData();
                    }
                    int i = (nextClearBit - nextSetBit) - 1;
                    this.u.set(0, i);
                    this.u.clear(i, nextClearBit);
                    this.u.set(nextClearBit);
                }
                return new com.google.common.collect.Sets.AnonymousClass5.AnonymousClass1.C03461((java.util.BitSet) this.u.clone());
            }
        }

        public AnonymousClass5(int i, com.google.common.collect.ImmutableMap immutableMap) {
            this.n = i;
            this.t = immutableMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof java.util.Set)) {
                return false;
            }
            java.util.Set set = (java.util.Set) obj;
            return set.size() == this.n && this.t.keySet().containsAll(set);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<java.util.Set<E>> iterator() {
            return new com.google.common.collect.Sets.AnonymousClass5.AnonymousClass1();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.math.IntMath.binomial(this.t.size(), this.n);
        }

        @Override // java.util.AbstractCollection
        public java.lang.String toString() {
            return "Sets.combinations(" + this.t.keySet() + ", " + this.n + ")";
        }
    }

    public static final class CartesianSet<E> extends com.google.common.collect.ForwardingCollection<java.util.List<E>> implements java.util.Set<java.util.List<E>> {
        public final transient com.google.common.collect.ImmutableList<com.google.common.collect.ImmutableSet<E>> n;
        public final transient com.google.common.collect.CartesianList<E> t;

        /* renamed from: com.google.common.collect.Sets$CartesianSet$1, reason: invalid class name */
        public static class AnonymousClass1 extends com.google.common.collect.ImmutableList<java.util.List<E>> {
            final /* synthetic */ com.google.common.collect.ImmutableList val$axes;

            public AnonymousClass1(com.google.common.collect.ImmutableList immutableList) {
                this.val$axes = immutableList;
            }

            @Override // java.util.List
            public java.util.List<E> get(int i) {
                return ((com.google.common.collect.ImmutableSet) this.val$axes.get(i)).asList();
            }

            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return this.val$axes.size();
            }
        }

        public CartesianSet(com.google.common.collect.ImmutableList<com.google.common.collect.ImmutableSet<E>> immutableList, com.google.common.collect.CartesianList<E> cartesianList) {
            this.n = immutableList;
            this.t = cartesianList;
        }

        public static <E> java.util.Set<java.util.List<E>> a(java.util.List<? extends java.util.Set<? extends E>> list) {
            com.google.common.collect.ImmutableList.Builder builder = new com.google.common.collect.ImmutableList.Builder(list.size());
            java.util.Iterator<? extends java.util.Set<? extends E>> it = list.iterator();
            while (it.hasNext()) {
                com.google.common.collect.ImmutableSet copyOf = com.google.common.collect.ImmutableSet.copyOf((java.util.Collection) it.next());
                if (copyOf.isEmpty()) {
                    return com.google.common.collect.ImmutableSet.of();
                }
                builder.add((com.google.common.collect.ImmutableList.Builder) copyOf);
            }
            com.google.common.collect.ImmutableList<E> build = builder.build();
            return new com.google.common.collect.Sets.CartesianSet(build, new com.google.common.collect.CartesianList(new com.google.common.collect.Sets.CartesianSet.AnonymousClass1(build)));
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public java.util.Collection<java.util.List<E>> delegate() {
            return this.t;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return obj instanceof com.google.common.collect.Sets.CartesianSet ? this.n.equals(((com.google.common.collect.Sets.CartesianSet) obj).n) : super.equals(obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int i = 1;
            int size = size() - 1;
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                size = ~(~(size * 31));
            }
            com.google.common.collect.UnmodifiableIterator<com.google.common.collect.ImmutableSet<E>> it = this.n.iterator();
            while (it.hasNext()) {
                com.google.common.collect.ImmutableSet<E> next = it.next();
                i = ~(~((i * 31) + ((size() / next.size()) * next.hashCode())));
            }
            return ~(~(i + size));
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static class DescendingSet<E> extends com.google.common.collect.ForwardingNavigableSet<E> {
        public final java.util.NavigableSet<E> n;

        public DescendingSet(java.util.NavigableSet<E> navigableSet) {
            this.n = navigableSet;
        }

        public static <T> com.google.common.collect.Ordering<T> a(java.util.Comparator<T> comparator) {
            return com.google.common.collect.Ordering.from(comparator).reverse();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E ceiling(E e) {
            return this.n.floor(e);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public java.util.Comparator<? super E> comparator() {
            java.util.Comparator<? super E> comparator = this.n.comparator();
            return comparator == null ? com.google.common.collect.Ordering.natural().reverse() : a(comparator);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public java.util.NavigableSet<E> delegate() {
            return this.n;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public java.util.Iterator<E> descendingIterator() {
            return this.n.iterator();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public java.util.NavigableSet<E> descendingSet() {
            return this.n;
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public E first() {
            return this.n.last();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E floor(E e) {
            return this.n.ceiling(e);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public java.util.NavigableSet<E> headSet(E e, boolean z) {
            return this.n.tailSet(e, z).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public java.util.SortedSet<E> headSet(E e) {
            return standardHeadSet(e);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E higher(E e) {
            return this.n.lower(e);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<E> iterator() {
            return this.n.descendingIterator();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public E last() {
            return this.n.first();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E lower(E e) {
            return this.n.higher(e);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E pollFirst() {
            return this.n.pollLast();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E pollLast() {
            return this.n.pollFirst();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public java.util.NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            return this.n.subSet(e2, z2, e, z).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public java.util.SortedSet<E> subSet(E e, E e2) {
            return standardSubSet(e, e2);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public java.util.NavigableSet<E> tailSet(E e, boolean z) {
            return this.n.headSet(e, z).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public java.util.SortedSet<E> tailSet(E e) {
            return standardTailSet(e);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public java.lang.Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        @Override // com.google.common.collect.ForwardingObject
        public java.lang.String toString() {
            return standardToString();
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static class FilteredNavigableSet<E> extends com.google.common.collect.Sets.FilteredSortedSet<E> implements java.util.NavigableSet<E> {
        public FilteredNavigableSet(java.util.NavigableSet<E> navigableSet, com.google.common.base.Predicate<? super E> predicate) {
            super(navigableSet, predicate);
        }

        public java.util.NavigableSet<E> b() {
            return (java.util.NavigableSet) this.n;
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e) {
            return (E) com.google.common.collect.Iterables.find(b().tailSet(e, true), this.t, null);
        }

        @Override // java.util.NavigableSet
        public java.util.Iterator<E> descendingIterator() {
            return com.google.common.collect.Iterators.filter(b().descendingIterator(), this.t);
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<E> descendingSet() {
            return com.google.common.collect.Sets.filter((java.util.NavigableSet) b().descendingSet(), (com.google.common.base.Predicate) this.t);
        }

        @Override // java.util.NavigableSet
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public E floor(E e) {
            return (E) com.google.common.collect.Iterators.find(b().headSet(e, true).descendingIterator(), this.t, null);
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<E> headSet(E e, boolean z) {
            return com.google.common.collect.Sets.filter((java.util.NavigableSet) b().headSet(e, z), (com.google.common.base.Predicate) this.t);
        }

        @Override // java.util.NavigableSet
        public E higher(E e) {
            return (E) com.google.common.collect.Iterables.find(b().tailSet(e, false), this.t, null);
        }

        @Override // com.google.common.collect.Sets.FilteredSortedSet, java.util.SortedSet
        public E last() {
            return (E) com.google.common.collect.Iterators.find(b().descendingIterator(), this.t);
        }

        @Override // java.util.NavigableSet
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public E lower(E e) {
            return (E) com.google.common.collect.Iterators.find(b().headSet(e, false).descendingIterator(), this.t, null);
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            return (E) com.google.common.collect.Iterables.c(b(), this.t);
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            return (E) com.google.common.collect.Iterables.c(b().descendingSet(), this.t);
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            return com.google.common.collect.Sets.filter((java.util.NavigableSet) b().subSet(e, z, e2, z2), (com.google.common.base.Predicate) this.t);
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<E> tailSet(E e, boolean z) {
            return com.google.common.collect.Sets.filter((java.util.NavigableSet) b().tailSet(e, z), (com.google.common.base.Predicate) this.t);
        }
    }

    public static class FilteredSet<E> extends com.google.common.collect.Collections2.FilteredCollection<E> implements java.util.Set<E> {
        public FilteredSet(java.util.Set<E> set, com.google.common.base.Predicate<? super E> predicate) {
            super(set, predicate);
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

    public static class FilteredSortedSet<E> extends com.google.common.collect.Sets.FilteredSet<E> implements java.util.SortedSet<E> {
        public FilteredSortedSet(java.util.SortedSet<E> sortedSet, com.google.common.base.Predicate<? super E> predicate) {
            super(sortedSet, predicate);
        }

        @Override // java.util.SortedSet
        public java.util.Comparator<? super E> comparator() {
            return ((java.util.SortedSet) this.n).comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) com.google.common.collect.Iterators.find(this.n.iterator(), this.t);
        }

        @Override // java.util.SortedSet
        public java.util.SortedSet<E> headSet(E e) {
            return new com.google.common.collect.Sets.FilteredSortedSet(((java.util.SortedSet) this.n).headSet(e), this.t);
        }

        public E last() {
            java.util.SortedSet sortedSet = (java.util.SortedSet) this.n;
            while (true) {
                E e = (java.lang.Object) sortedSet.last();
                if (this.t.apply(e)) {
                    return e;
                }
                sortedSet = sortedSet.headSet(e);
            }
        }

        @Override // java.util.SortedSet
        public java.util.SortedSet<E> subSet(E e, E e2) {
            return new com.google.common.collect.Sets.FilteredSortedSet(((java.util.SortedSet) this.n).subSet(e, e2), this.t);
        }

        @Override // java.util.SortedSet
        public java.util.SortedSet<E> tailSet(E e) {
            return new com.google.common.collect.Sets.FilteredSortedSet(((java.util.SortedSet) this.n).tailSet(e), this.t);
        }
    }

    public static abstract class ImprovedAbstractSet<E> extends java.util.AbstractSet<E> {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(java.util.Collection<?> collection) {
            return com.google.common.collect.Sets.d(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(java.util.Collection<?> collection) {
            return super.retainAll((java.util.Collection) com.google.common.base.Preconditions.checkNotNull(collection));
        }
    }

    public static final class PowerSet<E> extends java.util.AbstractSet<java.util.Set<E>> {
        public final com.google.common.collect.ImmutableMap<E, java.lang.Integer> n;

        /* renamed from: com.google.common.collect.Sets$PowerSet$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.AbstractIndexedListIterator<java.util.Set<E>> {
            public AnonymousClass1(int i) {
                super(i);
            }

            @Override // com.google.common.collect.AbstractIndexedListIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public java.util.Set<E> a(int i) {
                return new com.google.common.collect.Sets.SubSet(com.google.common.collect.Sets.PowerSet.this.n, i);
            }
        }

        public PowerSet(java.util.Set<E> set) {
            com.google.common.base.Preconditions.checkArgument(set.size() <= 30, "Too many elements to create power set: %s > 30", set.size());
            this.n = com.google.common.collect.Maps.u(set);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof java.util.Set)) {
                return false;
            }
            return this.n.keySet().containsAll((java.util.Set) obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return obj instanceof com.google.common.collect.Sets.PowerSet ? this.n.equals(((com.google.common.collect.Sets.PowerSet) obj).n) : super.equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.n.keySet().hashCode() << (this.n.size() - 1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<java.util.Set<E>> iterator() {
            return new com.google.common.collect.Sets.PowerSet.AnonymousClass1(size());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1 << this.n.size();
        }

        @Override // java.util.AbstractCollection
        public java.lang.String toString() {
            return "powerSet(" + this.n + ")";
        }
    }

    public static abstract class SetView<E> extends java.util.AbstractSet<E> {
        public SetView() {
        }

        public /* synthetic */ SetView(com.google.common.collect.Sets.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @java.lang.Deprecated
        public final boolean add(E e) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @java.lang.Deprecated
        public final boolean addAll(java.util.Collection<? extends E> collection) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @java.lang.Deprecated
        public final void clear() {
            throw new java.lang.UnsupportedOperationException();
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public <S extends java.util.Set<E>> S copyInto(S s2) {
            s2.addAll(this);
            return s2;
        }

        public com.google.common.collect.ImmutableSet<E> immutableCopy() {
            return com.google.common.collect.ImmutableSet.copyOf((java.util.Collection) this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public abstract com.google.common.collect.UnmodifiableIterator<E> iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @java.lang.Deprecated
        public final boolean remove(java.lang.Object obj) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @java.lang.Deprecated
        public final boolean removeAll(java.util.Collection<?> collection) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @java.lang.Deprecated
        public final boolean retainAll(java.util.Collection<?> collection) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public static final class SubSet<E> extends java.util.AbstractSet<E> {
        public final com.google.common.collect.ImmutableMap<E, java.lang.Integer> n;
        public final int t;

        /* renamed from: com.google.common.collect.Sets$SubSet$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.UnmodifiableIterator<E> {
            public final com.google.common.collect.ImmutableList<E> n;
            public int t;

            public AnonymousClass1() {
                this.n = com.google.common.collect.Sets.SubSet.this.n.keySet().asList();
                this.t = com.google.common.collect.Sets.SubSet.this.t;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.t != 0;
            }

            @Override // java.util.Iterator
            public E next() {
                int numberOfTrailingZeros = java.lang.Integer.numberOfTrailingZeros(this.t);
                if (numberOfTrailingZeros == 32) {
                    throw new java.util.NoSuchElementException();
                }
                this.t &= ~(1 << numberOfTrailingZeros);
                return this.n.get(numberOfTrailingZeros);
            }
        }

        public SubSet(com.google.common.collect.ImmutableMap<E, java.lang.Integer> immutableMap, int i) {
            this.n = immutableMap;
            this.t = i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            java.lang.Integer num = this.n.get(obj);
            if (num != null) {
                if (((1 << num.intValue()) & this.t) != 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<E> iterator() {
            return new com.google.common.collect.Sets.SubSet.AnonymousClass1();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return java.lang.Integer.bitCount(this.t);
        }
    }

    public static final class UnmodifiableNavigableSet<E> extends com.google.common.collect.ForwardingSortedSet<E> implements java.util.NavigableSet<E>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final java.util.NavigableSet<E> delegate;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        private transient com.google.common.collect.Sets.UnmodifiableNavigableSet<E> descendingSet;
        private final java.util.SortedSet<E> unmodifiableDelegate;

        public UnmodifiableNavigableSet(java.util.NavigableSet<E> navigableSet) {
            this.delegate = (java.util.NavigableSet) com.google.common.base.Preconditions.checkNotNull(navigableSet);
            this.unmodifiableDelegate = java.util.Collections.unmodifiableSortedSet(navigableSet);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e) {
            return this.delegate.ceiling(e);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public java.util.SortedSet<E> delegate() {
            return this.unmodifiableDelegate;
        }

        @Override // java.util.NavigableSet
        public java.util.Iterator<E> descendingIterator() {
            return com.google.common.collect.Iterators.unmodifiableIterator(this.delegate.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<E> descendingSet() {
            com.google.common.collect.Sets.UnmodifiableNavigableSet<E> unmodifiableNavigableSet = this.descendingSet;
            if (unmodifiableNavigableSet != null) {
                return unmodifiableNavigableSet;
            }
            com.google.common.collect.Sets.UnmodifiableNavigableSet<E> unmodifiableNavigableSet2 = new com.google.common.collect.Sets.UnmodifiableNavigableSet<>(this.delegate.descendingSet());
            this.descendingSet = unmodifiableNavigableSet2;
            unmodifiableNavigableSet2.descendingSet = this;
            return unmodifiableNavigableSet2;
        }

        @Override // java.util.NavigableSet
        public E floor(E e) {
            return this.delegate.floor(e);
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<E> headSet(E e, boolean z) {
            return com.google.common.collect.Sets.unmodifiableNavigableSet(this.delegate.headSet(e, z));
        }

        @Override // java.util.NavigableSet
        public E higher(E e) {
            return this.delegate.higher(e);
        }

        @Override // java.util.NavigableSet
        public E lower(E e) {
            return this.delegate.lower(e);
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            return com.google.common.collect.Sets.unmodifiableNavigableSet(this.delegate.subSet(e, z, e2, z2));
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<E> tailSet(E e, boolean z) {
            return com.google.common.collect.Sets.unmodifiableNavigableSet(this.delegate.tailSet(e, z));
        }
    }

    public static boolean a(java.util.Set<?> set, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof java.util.Set) {
            java.util.Set set2 = (java.util.Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (java.lang.ClassCastException | java.lang.NullPointerException unused) {
            }
        }
        return false;
    }

    public static int b(java.util.Set<?> set) {
        java.util.Iterator<?> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            java.lang.Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    public static <E extends java.lang.Enum<E>> java.util.EnumSet<E> c(java.util.Collection<E> collection, java.lang.Class<E> cls) {
        java.util.EnumSet<E> allOf = java.util.EnumSet.allOf(cls);
        allOf.removeAll(collection);
        return allOf;
    }

    public static <B> java.util.Set<java.util.List<B>> cartesianProduct(java.util.List<? extends java.util.Set<? extends B>> list) {
        return com.google.common.collect.Sets.CartesianSet.a(list);
    }

    @java.lang.SafeVarargs
    public static <B> java.util.Set<java.util.List<B>> cartesianProduct(java.util.Set<? extends B>... setArr) {
        return cartesianProduct(java.util.Arrays.asList(setArr));
    }

    @com.google.common.annotations.Beta
    public static <E> java.util.Set<java.util.Set<E>> combinations(java.util.Set<E> set, int i) {
        com.google.common.collect.ImmutableMap u = com.google.common.collect.Maps.u(set);
        com.google.common.collect.CollectPreconditions.b(i, com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE);
        com.google.common.base.Preconditions.checkArgument(i <= u.size(), "size (%s) must be <= set.size() (%s)", i, u.size());
        return i == 0 ? com.google.common.collect.ImmutableSet.of(com.google.common.collect.ImmutableSet.of()) : i == u.size() ? com.google.common.collect.ImmutableSet.of(u.keySet()) : new com.google.common.collect.Sets.AnonymousClass5(i, u);
    }

    public static <E extends java.lang.Enum<E>> java.util.EnumSet<E> complementOf(java.util.Collection<E> collection) {
        if (collection instanceof java.util.EnumSet) {
            return java.util.EnumSet.complementOf((java.util.EnumSet) collection);
        }
        com.google.common.base.Preconditions.checkArgument(!collection.isEmpty(), "collection is empty; use the other version of this method");
        return c(collection, collection.iterator().next().getDeclaringClass());
    }

    public static <E extends java.lang.Enum<E>> java.util.EnumSet<E> complementOf(java.util.Collection<E> collection, java.lang.Class<E> cls) {
        com.google.common.base.Preconditions.checkNotNull(collection);
        return collection instanceof java.util.EnumSet ? java.util.EnumSet.complementOf((java.util.EnumSet) collection) : c(collection, cls);
    }

    public static boolean d(java.util.Set<?> set, java.util.Collection<?> collection) {
        com.google.common.base.Preconditions.checkNotNull(collection);
        if (collection instanceof com.google.common.collect.Multiset) {
            collection = ((com.google.common.collect.Multiset) collection).elementSet();
        }
        return (!(collection instanceof java.util.Set) || collection.size() <= set.size()) ? e(set, collection.iterator()) : com.google.common.collect.Iterators.removeAll(set.iterator(), collection);
    }

    public static <E> com.google.common.collect.Sets.SetView<E> difference(java.util.Set<E> set, java.util.Set<?> set2) {
        com.google.common.base.Preconditions.checkNotNull(set, "set1");
        com.google.common.base.Preconditions.checkNotNull(set2, "set2");
        return new com.google.common.collect.Sets.AnonymousClass3(set, set2);
    }

    public static boolean e(java.util.Set<?> set, java.util.Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.google.common.annotations.GwtIncompatible
    public static <E> java.util.NavigableSet<E> filter(java.util.NavigableSet<E> navigableSet, com.google.common.base.Predicate<? super E> predicate) {
        if (!(navigableSet instanceof com.google.common.collect.Sets.FilteredSet)) {
            return new com.google.common.collect.Sets.FilteredNavigableSet((java.util.NavigableSet) com.google.common.base.Preconditions.checkNotNull(navigableSet), (com.google.common.base.Predicate) com.google.common.base.Preconditions.checkNotNull(predicate));
        }
        com.google.common.collect.Sets.FilteredSet filteredSet = (com.google.common.collect.Sets.FilteredSet) navigableSet;
        return new com.google.common.collect.Sets.FilteredNavigableSet((java.util.NavigableSet) filteredSet.n, com.google.common.base.Predicates.and(filteredSet.t, predicate));
    }

    public static <E> java.util.Set<E> filter(java.util.Set<E> set, com.google.common.base.Predicate<? super E> predicate) {
        if (set instanceof java.util.SortedSet) {
            return filter((java.util.SortedSet) set, (com.google.common.base.Predicate) predicate);
        }
        if (!(set instanceof com.google.common.collect.Sets.FilteredSet)) {
            return new com.google.common.collect.Sets.FilteredSet((java.util.Set) com.google.common.base.Preconditions.checkNotNull(set), (com.google.common.base.Predicate) com.google.common.base.Preconditions.checkNotNull(predicate));
        }
        com.google.common.collect.Sets.FilteredSet filteredSet = (com.google.common.collect.Sets.FilteredSet) set;
        return new com.google.common.collect.Sets.FilteredSet((java.util.Set) filteredSet.n, com.google.common.base.Predicates.and(filteredSet.t, predicate));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> java.util.SortedSet<E> filter(java.util.SortedSet<E> sortedSet, com.google.common.base.Predicate<? super E> predicate) {
        if (!(sortedSet instanceof com.google.common.collect.Sets.FilteredSet)) {
            return new com.google.common.collect.Sets.FilteredSortedSet((java.util.SortedSet) com.google.common.base.Preconditions.checkNotNull(sortedSet), (com.google.common.base.Predicate) com.google.common.base.Preconditions.checkNotNull(predicate));
        }
        com.google.common.collect.Sets.FilteredSet filteredSet = (com.google.common.collect.Sets.FilteredSet) sortedSet;
        return new com.google.common.collect.Sets.FilteredSortedSet((java.util.SortedSet) filteredSet.n, com.google.common.base.Predicates.and(filteredSet.t, predicate));
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <E extends java.lang.Enum<E>> com.google.common.collect.ImmutableSet<E> immutableEnumSet(E e, E... eArr) {
        return com.google.common.collect.ImmutableEnumSet.asImmutable(java.util.EnumSet.of((java.lang.Enum) e, (java.lang.Enum[]) eArr));
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <E extends java.lang.Enum<E>> com.google.common.collect.ImmutableSet<E> immutableEnumSet(java.lang.Iterable<E> iterable) {
        if (iterable instanceof com.google.common.collect.ImmutableEnumSet) {
            return (com.google.common.collect.ImmutableEnumSet) iterable;
        }
        if (iterable instanceof java.util.Collection) {
            java.util.Collection collection = (java.util.Collection) iterable;
            return collection.isEmpty() ? com.google.common.collect.ImmutableSet.of() : com.google.common.collect.ImmutableEnumSet.asImmutable(java.util.EnumSet.copyOf(collection));
        }
        java.util.Iterator<E> it = iterable.iterator();
        if (!it.hasNext()) {
            return com.google.common.collect.ImmutableSet.of();
        }
        java.util.EnumSet of = java.util.EnumSet.of((java.lang.Enum) it.next());
        com.google.common.collect.Iterators.addAll(of, it);
        return com.google.common.collect.ImmutableEnumSet.asImmutable(of);
    }

    public static <E> com.google.common.collect.Sets.SetView<E> intersection(java.util.Set<E> set, java.util.Set<?> set2) {
        com.google.common.base.Preconditions.checkNotNull(set, "set1");
        com.google.common.base.Preconditions.checkNotNull(set2, "set2");
        return new com.google.common.collect.Sets.AnonymousClass2(set, set2);
    }

    public static <E> java.util.Set<E> newConcurrentHashSet() {
        return java.util.Collections.newSetFromMap(new java.util.concurrent.ConcurrentHashMap());
    }

    public static <E> java.util.Set<E> newConcurrentHashSet(java.lang.Iterable<? extends E> iterable) {
        java.util.Set<E> newConcurrentHashSet = newConcurrentHashSet();
        com.google.common.collect.Iterables.addAll(newConcurrentHashSet, iterable);
        return newConcurrentHashSet;
    }

    @com.google.common.annotations.GwtIncompatible
    public static <E> java.util.concurrent.CopyOnWriteArraySet<E> newCopyOnWriteArraySet() {
        return new java.util.concurrent.CopyOnWriteArraySet<>();
    }

    @com.google.common.annotations.GwtIncompatible
    public static <E> java.util.concurrent.CopyOnWriteArraySet<E> newCopyOnWriteArraySet(java.lang.Iterable<? extends E> iterable) {
        return new java.util.concurrent.CopyOnWriteArraySet<>(iterable instanceof java.util.Collection ? com.google.common.collect.Collections2.b(iterable) : com.google.common.collect.Lists.newArrayList(iterable));
    }

    public static <E extends java.lang.Enum<E>> java.util.EnumSet<E> newEnumSet(java.lang.Iterable<E> iterable, java.lang.Class<E> cls) {
        java.util.EnumSet<E> noneOf = java.util.EnumSet.noneOf(cls);
        com.google.common.collect.Iterables.addAll(noneOf, iterable);
        return noneOf;
    }

    public static <E> java.util.HashSet<E> newHashSet() {
        return new java.util.HashSet<>();
    }

    public static <E> java.util.HashSet<E> newHashSet(java.lang.Iterable<? extends E> iterable) {
        return iterable instanceof java.util.Collection ? new java.util.HashSet<>(com.google.common.collect.Collections2.b(iterable)) : newHashSet(iterable.iterator());
    }

    public static <E> java.util.HashSet<E> newHashSet(java.util.Iterator<? extends E> it) {
        java.util.HashSet<E> newHashSet = newHashSet();
        com.google.common.collect.Iterators.addAll(newHashSet, it);
        return newHashSet;
    }

    public static <E> java.util.HashSet<E> newHashSet(E... eArr) {
        java.util.HashSet<E> newHashSetWithExpectedSize = newHashSetWithExpectedSize(eArr.length);
        java.util.Collections.addAll(newHashSetWithExpectedSize, eArr);
        return newHashSetWithExpectedSize;
    }

    public static <E> java.util.HashSet<E> newHashSetWithExpectedSize(int i) {
        return new java.util.HashSet<>(com.google.common.collect.Maps.k(i));
    }

    public static <E> java.util.Set<E> newIdentityHashSet() {
        return java.util.Collections.newSetFromMap(com.google.common.collect.Maps.newIdentityHashMap());
    }

    public static <E> java.util.LinkedHashSet<E> newLinkedHashSet() {
        return new java.util.LinkedHashSet<>();
    }

    public static <E> java.util.LinkedHashSet<E> newLinkedHashSet(java.lang.Iterable<? extends E> iterable) {
        if (iterable instanceof java.util.Collection) {
            return new java.util.LinkedHashSet<>(com.google.common.collect.Collections2.b(iterable));
        }
        java.util.LinkedHashSet<E> newLinkedHashSet = newLinkedHashSet();
        com.google.common.collect.Iterables.addAll(newLinkedHashSet, iterable);
        return newLinkedHashSet;
    }

    public static <E> java.util.LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int i) {
        return new java.util.LinkedHashSet<>(com.google.common.collect.Maps.k(i));
    }

    @java.lang.Deprecated
    public static <E> java.util.Set<E> newSetFromMap(java.util.Map<E, java.lang.Boolean> map) {
        return java.util.Collections.newSetFromMap(map);
    }

    public static <E extends java.lang.Comparable> java.util.TreeSet<E> newTreeSet() {
        return new java.util.TreeSet<>();
    }

    public static <E extends java.lang.Comparable> java.util.TreeSet<E> newTreeSet(java.lang.Iterable<? extends E> iterable) {
        java.util.TreeSet<E> newTreeSet = newTreeSet();
        com.google.common.collect.Iterables.addAll(newTreeSet, iterable);
        return newTreeSet;
    }

    public static <E> java.util.TreeSet<E> newTreeSet(java.util.Comparator<? super E> comparator) {
        return new java.util.TreeSet<>((java.util.Comparator) com.google.common.base.Preconditions.checkNotNull(comparator));
    }

    @com.google.common.annotations.GwtCompatible(serializable = false)
    public static <E> java.util.Set<java.util.Set<E>> powerSet(java.util.Set<E> set) {
        return new com.google.common.collect.Sets.PowerSet(set);
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static <K extends java.lang.Comparable<? super K>> java.util.NavigableSet<K> subSet(java.util.NavigableSet<K> navigableSet, com.google.common.collect.Range<K> range) {
        if (navigableSet.comparator() != null && navigableSet.comparator() != com.google.common.collect.Ordering.natural() && range.hasLowerBound() && range.hasUpperBound()) {
            com.google.common.base.Preconditions.checkArgument(navigableSet.comparator().compare(range.lowerEndpoint(), range.upperEndpoint()) <= 0, "set is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.hasLowerBound() && range.hasUpperBound()) {
            K lowerEndpoint = range.lowerEndpoint();
            com.google.common.collect.BoundType lowerBoundType = range.lowerBoundType();
            com.google.common.collect.BoundType boundType = com.google.common.collect.BoundType.CLOSED;
            return navigableSet.subSet(lowerEndpoint, lowerBoundType == boundType, range.upperEndpoint(), range.upperBoundType() == boundType);
        }
        if (range.hasLowerBound()) {
            return navigableSet.tailSet(range.lowerEndpoint(), range.lowerBoundType() == com.google.common.collect.BoundType.CLOSED);
        }
        if (range.hasUpperBound()) {
            return navigableSet.headSet(range.upperEndpoint(), range.upperBoundType() == com.google.common.collect.BoundType.CLOSED);
        }
        return (java.util.NavigableSet) com.google.common.base.Preconditions.checkNotNull(navigableSet);
    }

    public static <E> com.google.common.collect.Sets.SetView<E> symmetricDifference(java.util.Set<? extends E> set, java.util.Set<? extends E> set2) {
        com.google.common.base.Preconditions.checkNotNull(set, "set1");
        com.google.common.base.Preconditions.checkNotNull(set2, "set2");
        return new com.google.common.collect.Sets.AnonymousClass4(set, set2);
    }

    @com.google.common.annotations.GwtIncompatible
    public static <E> java.util.NavigableSet<E> synchronizedNavigableSet(java.util.NavigableSet<E> navigableSet) {
        return com.google.common.collect.Synchronized.q(navigableSet);
    }

    public static <E> com.google.common.collect.Sets.SetView<E> union(java.util.Set<? extends E> set, java.util.Set<? extends E> set2) {
        com.google.common.base.Preconditions.checkNotNull(set, "set1");
        com.google.common.base.Preconditions.checkNotNull(set2, "set2");
        return new com.google.common.collect.Sets.AnonymousClass1(set, set2);
    }

    public static <E> java.util.NavigableSet<E> unmodifiableNavigableSet(java.util.NavigableSet<E> navigableSet) {
        return ((navigableSet instanceof com.google.common.collect.ImmutableCollection) || (navigableSet instanceof com.google.common.collect.Sets.UnmodifiableNavigableSet)) ? navigableSet : new com.google.common.collect.Sets.UnmodifiableNavigableSet(navigableSet);
    }
}
