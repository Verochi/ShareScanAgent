package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class Ordering<T> implements java.util.Comparator<T> {
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;

    @com.google.common.annotations.VisibleForTesting
    public static class ArbitraryOrdering extends com.google.common.collect.Ordering<java.lang.Object> {
        public final java.util.concurrent.atomic.AtomicInteger n = new java.util.concurrent.atomic.AtomicInteger(0);
        public final java.util.concurrent.ConcurrentMap<java.lang.Object, java.lang.Integer> t = com.google.common.collect.Platform.i(new com.google.common.collect.MapMaker()).makeMap();

        public final java.lang.Integer a(java.lang.Object obj) {
            java.lang.Integer num = this.t.get(obj);
            if (num != null) {
                return num;
            }
            java.lang.Integer valueOf = java.lang.Integer.valueOf(this.n.getAndIncrement());
            java.lang.Integer putIfAbsent = this.t.putIfAbsent(obj, valueOf);
            return putIfAbsent != null ? putIfAbsent : valueOf;
        }

        public int b(java.lang.Object obj) {
            return java.lang.System.identityHashCode(obj);
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(java.lang.Object obj, java.lang.Object obj2) {
            if (obj == obj2) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            int b = b(obj);
            int b2 = b(obj2);
            if (b != b2) {
                return b < b2 ? -1 : 1;
            }
            int compareTo = a(obj).compareTo(a(obj2));
            if (compareTo != 0) {
                return compareTo;
            }
            throw new java.lang.AssertionError();
        }

        public java.lang.String toString() {
            return "Ordering.arbitrary()";
        }
    }

    public static class ArbitraryOrderingHolder {
        public static final com.google.common.collect.Ordering<java.lang.Object> a = new com.google.common.collect.Ordering.ArbitraryOrdering();
    }

    @com.google.common.annotations.VisibleForTesting
    public static class IncomparableValueException extends java.lang.ClassCastException {
        private static final long serialVersionUID = 0;
        final java.lang.Object value;

        public IncomparableValueException(java.lang.Object obj) {
            super("Cannot compare value: " + obj);
            this.value = obj;
        }
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static com.google.common.collect.Ordering<java.lang.Object> allEqual() {
        return com.google.common.collect.AllEqualOrdering.INSTANCE;
    }

    public static com.google.common.collect.Ordering<java.lang.Object> arbitrary() {
        return com.google.common.collect.Ordering.ArbitraryOrderingHolder.a;
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <T> com.google.common.collect.Ordering<T> compound(java.lang.Iterable<? extends java.util.Comparator<? super T>> iterable) {
        return new com.google.common.collect.CompoundOrdering(iterable);
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <T> com.google.common.collect.Ordering<T> explicit(T t, T... tArr) {
        return explicit(com.google.common.collect.Lists.asList(t, tArr));
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <T> com.google.common.collect.Ordering<T> explicit(java.util.List<T> list) {
        return new com.google.common.collect.ExplicitOrdering(list);
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    @java.lang.Deprecated
    public static <T> com.google.common.collect.Ordering<T> from(com.google.common.collect.Ordering<T> ordering) {
        return (com.google.common.collect.Ordering) com.google.common.base.Preconditions.checkNotNull(ordering);
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <T> com.google.common.collect.Ordering<T> from(java.util.Comparator<T> comparator) {
        return comparator instanceof com.google.common.collect.Ordering ? (com.google.common.collect.Ordering) comparator : new com.google.common.collect.ComparatorOrdering(comparator);
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <C extends java.lang.Comparable> com.google.common.collect.Ordering<C> natural() {
        return com.google.common.collect.NaturalOrdering.INSTANCE;
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static com.google.common.collect.Ordering<java.lang.Object> usingToString() {
        return com.google.common.collect.UsingToStringOrdering.INSTANCE;
    }

    @java.lang.Deprecated
    public int binarySearch(java.util.List<? extends T> list, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        return java.util.Collections.binarySearch(list, t, this);
    }

    @Override // java.util.Comparator
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public abstract int compare(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t2);

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public <U extends T> com.google.common.collect.Ordering<U> compound(java.util.Comparator<? super U> comparator) {
        return new com.google.common.collect.CompoundOrdering(this, (java.util.Comparator) com.google.common.base.Preconditions.checkNotNull(comparator));
    }

    public <E extends T> java.util.List<E> greatestOf(java.lang.Iterable<E> iterable, int i) {
        return reverse().leastOf(iterable, i);
    }

    public <E extends T> java.util.List<E> greatestOf(java.util.Iterator<E> it, int i) {
        return reverse().leastOf(it, i);
    }

    public <E extends T> com.google.common.collect.ImmutableList<E> immutableSortedCopy(java.lang.Iterable<E> iterable) {
        return com.google.common.collect.ImmutableList.sortedCopyOf(this, iterable);
    }

    public boolean isOrdered(java.lang.Iterable<? extends T> iterable) {
        java.util.Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (compare(next, next2) > 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public boolean isStrictlyOrdered(java.lang.Iterable<? extends T> iterable) {
        java.util.Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (compare(next, next2) >= 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public <E extends T> java.util.List<E> leastOf(java.lang.Iterable<E> iterable, int i) {
        if (iterable instanceof java.util.Collection) {
            java.util.Collection collection = (java.util.Collection) iterable;
            if (collection.size() <= i * 2) {
                java.lang.Object[] array = collection.toArray();
                java.util.Arrays.sort(array, this);
                if (array.length > i) {
                    array = java.util.Arrays.copyOf(array, i);
                }
                return java.util.Collections.unmodifiableList(java.util.Arrays.asList(array));
            }
        }
        return leastOf(iterable.iterator(), i);
    }

    public <E extends T> java.util.List<E> leastOf(java.util.Iterator<E> it, int i) {
        com.google.common.base.Preconditions.checkNotNull(it);
        com.google.common.collect.CollectPreconditions.b(i, "k");
        if (i == 0 || !it.hasNext()) {
            return java.util.Collections.emptyList();
        }
        if (i < 1073741823) {
            com.google.common.collect.TopKSelector a = com.google.common.collect.TopKSelector.a(i, this);
            a.c(it);
            return a.f();
        }
        java.util.ArrayList newArrayList = com.google.common.collect.Lists.newArrayList(it);
        java.util.Collections.sort(newArrayList, this);
        if (newArrayList.size() > i) {
            newArrayList.subList(i, newArrayList.size()).clear();
        }
        newArrayList.trimToSize();
        return java.util.Collections.unmodifiableList(newArrayList);
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public <S extends T> com.google.common.collect.Ordering<java.lang.Iterable<S>> lexicographical() {
        return new com.google.common.collect.LexicographicalOrdering(this);
    }

    public <E extends T> E max(java.lang.Iterable<E> iterable) {
        return (E) max(iterable.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E max(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, @org.checkerframework.checker.nullness.compatqual.NullableDecl E e2) {
        return compare(e, e2) >= 0 ? e : e2;
    }

    public <E extends T> E max(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, @org.checkerframework.checker.nullness.compatqual.NullableDecl E e2, @org.checkerframework.checker.nullness.compatqual.NullableDecl E e3, E... eArr) {
        E e4 = (E) max(max(e, e2), e3);
        for (E e5 : eArr) {
            e4 = (E) max(e4, e5);
        }
        return e4;
    }

    public <E extends T> E max(java.util.Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) max(next, it.next());
        }
        return next;
    }

    public <E extends T> E min(java.lang.Iterable<E> iterable) {
        return (E) min(iterable.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E min(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, @org.checkerframework.checker.nullness.compatqual.NullableDecl E e2) {
        return compare(e, e2) <= 0 ? e : e2;
    }

    public <E extends T> E min(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, @org.checkerframework.checker.nullness.compatqual.NullableDecl E e2, @org.checkerframework.checker.nullness.compatqual.NullableDecl E e3, E... eArr) {
        E e4 = (E) min(min(e, e2), e3);
        for (E e5 : eArr) {
            e4 = (E) min(e4, e5);
        }
        return e4;
    }

    public <E extends T> E min(java.util.Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) min(next, it.next());
        }
        return next;
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public <S extends T> com.google.common.collect.Ordering<S> nullsFirst() {
        return new com.google.common.collect.NullsFirstOrdering(this);
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public <S extends T> com.google.common.collect.Ordering<S> nullsLast() {
        return new com.google.common.collect.NullsLastOrdering(this);
    }

    public <T2 extends T> com.google.common.collect.Ordering<java.util.Map.Entry<T2, ?>> onKeys() {
        return (com.google.common.collect.Ordering<java.util.Map.Entry<T2, ?>>) onResultOf(com.google.common.collect.Maps.v());
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public <F> com.google.common.collect.Ordering<F> onResultOf(com.google.common.base.Function<F, ? extends T> function) {
        return new com.google.common.collect.ByFunctionOrdering(function, this);
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public <S extends T> com.google.common.collect.Ordering<S> reverse() {
        return new com.google.common.collect.ReverseOrdering(this);
    }

    public <E extends T> java.util.List<E> sortedCopy(java.lang.Iterable<E> iterable) {
        java.lang.Object[] f = com.google.common.collect.Iterables.f(iterable);
        java.util.Arrays.sort(f, this);
        return com.google.common.collect.Lists.newArrayList(java.util.Arrays.asList(f));
    }
}
