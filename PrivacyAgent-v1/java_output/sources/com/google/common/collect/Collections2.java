package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class Collections2 {

    public static class FilteredCollection<E> extends java.util.AbstractCollection<E> {
        public final java.util.Collection<E> n;
        public final com.google.common.base.Predicate<? super E> t;

        public FilteredCollection(java.util.Collection<E> collection, com.google.common.base.Predicate<? super E> predicate) {
            this.n = collection;
            this.t = predicate;
        }

        public com.google.common.collect.Collections2.FilteredCollection<E> a(com.google.common.base.Predicate<? super E> predicate) {
            return new com.google.common.collect.Collections2.FilteredCollection<>(this.n, com.google.common.base.Predicates.and(this.t, predicate));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(E e) {
            com.google.common.base.Preconditions.checkArgument(this.t.apply(e));
            return this.n.add(e);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(java.util.Collection<? extends E> collection) {
            java.util.Iterator<? extends E> it = collection.iterator();
            while (it.hasNext()) {
                com.google.common.base.Preconditions.checkArgument(this.t.apply(it.next()));
            }
            return this.n.addAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            com.google.common.collect.Iterables.removeIf(this.n, this.t);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (com.google.common.collect.Collections2.g(this.n, obj)) {
                return this.t.apply(obj);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(java.util.Collection<?> collection) {
            return com.google.common.collect.Collections2.c(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !com.google.common.collect.Iterables.any(this.n, this.t);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public java.util.Iterator<E> iterator() {
            return com.google.common.collect.Iterators.filter(this.n.iterator(), this.t);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(java.lang.Object obj) {
            return contains(obj) && this.n.remove(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(java.util.Collection<?> collection) {
            java.util.Iterator<E> it = this.n.iterator();
            boolean z = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.t.apply(next) && collection.contains(next)) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(java.util.Collection<?> collection) {
            java.util.Iterator<E> it = this.n.iterator();
            boolean z = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.t.apply(next) && !collection.contains(next)) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            java.util.Iterator<E> it = this.n.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (this.t.apply(it.next())) {
                    i++;
                }
            }
            return i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public java.lang.Object[] toArray() {
            return com.google.common.collect.Lists.newArrayList(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) com.google.common.collect.Lists.newArrayList(iterator()).toArray(tArr);
        }
    }

    public static final class OrderedPermutationCollection<E> extends java.util.AbstractCollection<java.util.List<E>> {
        public final com.google.common.collect.ImmutableList<E> n;
        public final java.util.Comparator<? super E> t;
        public final int u;

        public OrderedPermutationCollection(java.lang.Iterable<E> iterable, java.util.Comparator<? super E> comparator) {
            com.google.common.collect.ImmutableList<E> sortedCopyOf = com.google.common.collect.ImmutableList.sortedCopyOf(comparator, iterable);
            this.n = sortedCopyOf;
            this.t = comparator;
            this.u = a(sortedCopyOf, comparator);
        }

        public static <E> int a(java.util.List<E> list, java.util.Comparator<? super E> comparator) {
            int i = 1;
            int i2 = 1;
            int i3 = 1;
            while (i < list.size()) {
                if (comparator.compare(list.get(i - 1), list.get(i)) < 0) {
                    i2 = com.google.common.math.IntMath.saturatedMultiply(i2, com.google.common.math.IntMath.binomial(i, i3));
                    if (i2 == Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    i3 = 0;
                }
                i++;
                i3++;
            }
            return com.google.common.math.IntMath.saturatedMultiply(i2, com.google.common.math.IntMath.binomial(i, i3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof java.util.List)) {
                return false;
            }
            return com.google.common.collect.Collections2.e(this.n, (java.util.List) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public java.util.Iterator<java.util.List<E>> iterator() {
            return new com.google.common.collect.Collections2.OrderedPermutationIterator(this.n, this.t);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.u;
        }

        @Override // java.util.AbstractCollection
        public java.lang.String toString() {
            return "orderedPermutationCollection(" + this.n + ")";
        }
    }

    public static final class OrderedPermutationIterator<E> extends com.google.common.collect.AbstractIterator<java.util.List<E>> {

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public java.util.List<E> u;
        public final java.util.Comparator<? super E> v;

        public OrderedPermutationIterator(java.util.List<E> list, java.util.Comparator<? super E> comparator) {
            this.u = com.google.common.collect.Lists.newArrayList(list);
            this.v = comparator;
        }

        public void b() {
            int d = d();
            if (d == -1) {
                this.u = null;
                return;
            }
            java.util.Collections.swap(this.u, d, e(d));
            java.util.Collections.reverse(this.u.subList(d + 1, this.u.size()));
        }

        @Override // com.google.common.collect.AbstractIterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public java.util.List<E> computeNext() {
            java.util.List<E> list = this.u;
            if (list == null) {
                return endOfData();
            }
            com.google.common.collect.ImmutableList copyOf = com.google.common.collect.ImmutableList.copyOf((java.util.Collection) list);
            b();
            return copyOf;
        }

        public int d() {
            for (int size = this.u.size() - 2; size >= 0; size--) {
                if (this.v.compare(this.u.get(size), this.u.get(size + 1)) < 0) {
                    return size;
                }
            }
            return -1;
        }

        public int e(int i) {
            E e = this.u.get(i);
            for (int size = this.u.size() - 1; size > i; size--) {
                if (this.v.compare(e, this.u.get(size)) < 0) {
                    return size;
                }
            }
            throw new java.lang.AssertionError("this statement should be unreachable");
        }
    }

    public static final class PermutationCollection<E> extends java.util.AbstractCollection<java.util.List<E>> {
        public final com.google.common.collect.ImmutableList<E> n;

        public PermutationCollection(com.google.common.collect.ImmutableList<E> immutableList) {
            this.n = immutableList;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof java.util.List)) {
                return false;
            }
            return com.google.common.collect.Collections2.e(this.n, (java.util.List) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public java.util.Iterator<java.util.List<E>> iterator() {
            return new com.google.common.collect.Collections2.PermutationIterator(this.n);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return com.google.common.math.IntMath.factorial(this.n.size());
        }

        @Override // java.util.AbstractCollection
        public java.lang.String toString() {
            return "permutations(" + this.n + ")";
        }
    }

    public static class PermutationIterator<E> extends com.google.common.collect.AbstractIterator<java.util.List<E>> {
        public final java.util.List<E> u;
        public final int[] v;
        public final int[] w;
        public int x;

        public PermutationIterator(java.util.List<E> list) {
            this.u = new java.util.ArrayList(list);
            int size = list.size();
            int[] iArr = new int[size];
            this.v = iArr;
            int[] iArr2 = new int[size];
            this.w = iArr2;
            java.util.Arrays.fill(iArr, 0);
            java.util.Arrays.fill(iArr2, 1);
            this.x = Integer.MAX_VALUE;
        }

        public void b() {
            int size = this.u.size() - 1;
            this.x = size;
            if (size == -1) {
                return;
            }
            int i = 0;
            while (true) {
                int[] iArr = this.v;
                int i2 = this.x;
                int i3 = iArr[i2];
                int i4 = this.w[i2] + i3;
                if (i4 < 0) {
                    d();
                } else if (i4 != i2 + 1) {
                    java.util.Collections.swap(this.u, (i2 - i3) + i, (i2 - i4) + i);
                    this.v[this.x] = i4;
                    return;
                } else {
                    if (i2 == 0) {
                        return;
                    }
                    i++;
                    d();
                }
            }
        }

        @Override // com.google.common.collect.AbstractIterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public java.util.List<E> computeNext() {
            if (this.x <= 0) {
                return endOfData();
            }
            com.google.common.collect.ImmutableList copyOf = com.google.common.collect.ImmutableList.copyOf((java.util.Collection) this.u);
            b();
            return copyOf;
        }

        public void d() {
            int[] iArr = this.w;
            int i = this.x;
            iArr[i] = -iArr[i];
            this.x = i - 1;
        }
    }

    public static class TransformedCollection<F, T> extends java.util.AbstractCollection<T> {
        public final java.util.Collection<F> n;
        public final com.google.common.base.Function<? super F, ? extends T> t;

        public TransformedCollection(java.util.Collection<F> collection, com.google.common.base.Function<? super F, ? extends T> function) {
            this.n = (java.util.Collection) com.google.common.base.Preconditions.checkNotNull(collection);
            this.t = (com.google.common.base.Function) com.google.common.base.Preconditions.checkNotNull(function);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.n.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.n.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public java.util.Iterator<T> iterator() {
            return com.google.common.collect.Iterators.transform(this.n.iterator(), this.t);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.n.size();
        }
    }

    public static <T> java.util.Collection<T> b(java.lang.Iterable<T> iterable) {
        return (java.util.Collection) iterable;
    }

    public static boolean c(java.util.Collection<?> collection, java.util.Collection<?> collection2) {
        java.util.Iterator<?> it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <E> com.google.common.collect.ObjectCountHashMap<E> d(java.util.Collection<E> collection) {
        com.google.common.collect.ObjectCountHashMap<E> objectCountHashMap = new com.google.common.collect.ObjectCountHashMap<>();
        for (E e : collection) {
            objectCountHashMap.u(e, objectCountHashMap.f(e) + 1);
        }
        return objectCountHashMap;
    }

    public static boolean e(java.util.List<?> list, java.util.List<?> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        com.google.common.collect.ObjectCountHashMap d = d(list);
        com.google.common.collect.ObjectCountHashMap d2 = d(list2);
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (d.k(i) != d2.f(d.i(i))) {
                return false;
            }
        }
        return true;
    }

    public static java.lang.StringBuilder f(int i) {
        com.google.common.collect.CollectPreconditions.b(i, com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE);
        return new java.lang.StringBuilder((int) java.lang.Math.min(i * 8, 1073741824L));
    }

    public static <E> java.util.Collection<E> filter(java.util.Collection<E> collection, com.google.common.base.Predicate<? super E> predicate) {
        return collection instanceof com.google.common.collect.Collections2.FilteredCollection ? ((com.google.common.collect.Collections2.FilteredCollection) collection).a(predicate) : new com.google.common.collect.Collections2.FilteredCollection((java.util.Collection) com.google.common.base.Preconditions.checkNotNull(collection), (com.google.common.base.Predicate) com.google.common.base.Preconditions.checkNotNull(predicate));
    }

    public static boolean g(java.util.Collection<?> collection, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        com.google.common.base.Preconditions.checkNotNull(collection);
        try {
            return collection.contains(obj);
        } catch (java.lang.ClassCastException | java.lang.NullPointerException unused) {
            return false;
        }
    }

    public static boolean h(java.util.Collection<?> collection, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        com.google.common.base.Preconditions.checkNotNull(collection);
        try {
            return collection.remove(obj);
        } catch (java.lang.ClassCastException | java.lang.NullPointerException unused) {
            return false;
        }
    }

    public static java.lang.String i(java.util.Collection<?> collection) {
        java.lang.StringBuilder f = f(collection.size());
        f.append('[');
        boolean z = true;
        for (java.lang.Object obj : collection) {
            if (!z) {
                f.append(", ");
            }
            if (obj == collection) {
                f.append("(this Collection)");
            } else {
                f.append(obj);
            }
            z = false;
        }
        f.append(']');
        return f.toString();
    }

    @com.google.common.annotations.Beta
    public static <E extends java.lang.Comparable<? super E>> java.util.Collection<java.util.List<E>> orderedPermutations(java.lang.Iterable<E> iterable) {
        return orderedPermutations(iterable, com.google.common.collect.Ordering.natural());
    }

    @com.google.common.annotations.Beta
    public static <E> java.util.Collection<java.util.List<E>> orderedPermutations(java.lang.Iterable<E> iterable, java.util.Comparator<? super E> comparator) {
        return new com.google.common.collect.Collections2.OrderedPermutationCollection(iterable, comparator);
    }

    @com.google.common.annotations.Beta
    public static <E> java.util.Collection<java.util.List<E>> permutations(java.util.Collection<E> collection) {
        return new com.google.common.collect.Collections2.PermutationCollection(com.google.common.collect.ImmutableList.copyOf((java.util.Collection) collection));
    }

    public static <F, T> java.util.Collection<T> transform(java.util.Collection<F> collection, com.google.common.base.Function<? super F, T> function) {
        return new com.google.common.collect.Collections2.TransformedCollection(collection, function);
    }
}
