package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public abstract class FluentIterable<E> implements java.lang.Iterable<E> {
    public final com.google.common.base.Optional<java.lang.Iterable<E>> n;

    /* renamed from: com.google.common.collect.FluentIterable$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.google.common.collect.FluentIterable<E> {
        public final /* synthetic */ java.lang.Iterable t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.lang.Iterable iterable, java.lang.Iterable iterable2) {
            super(iterable);
            this.t = iterable2;
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<E> iterator() {
            return this.t.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.FluentIterable$2, reason: invalid class name */
    public static class AnonymousClass2<T> extends com.google.common.collect.FluentIterable<T> {
        public final /* synthetic */ java.lang.Iterable t;

        public AnonymousClass2(java.lang.Iterable iterable) {
            this.t = iterable;
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<T> iterator() {
            return com.google.common.collect.Iterators.concat(com.google.common.collect.Iterators.transform(this.t.iterator(), com.google.common.collect.Iterables.h()));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.FluentIterable$3, reason: invalid class name */
    public static class AnonymousClass3<T> extends com.google.common.collect.FluentIterable<T> {
        public final /* synthetic */ java.lang.Iterable[] t;

        /* renamed from: com.google.common.collect.FluentIterable$3$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.AbstractIndexedListIterator<java.util.Iterator<? extends T>> {
            public AnonymousClass1(int i) {
                super(i);
            }

            @Override // com.google.common.collect.AbstractIndexedListIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public java.util.Iterator<? extends T> a(int i) {
                return com.google.common.collect.FluentIterable.AnonymousClass3.this.t[i].iterator();
            }
        }

        public AnonymousClass3(java.lang.Iterable[] iterableArr) {
            this.t = iterableArr;
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<T> iterator() {
            return com.google.common.collect.Iterators.concat(new com.google.common.collect.FluentIterable.AnonymousClass3.AnonymousClass1(this.t.length));
        }
    }

    public static class FromIterableFunction<E> implements com.google.common.base.Function<java.lang.Iterable<E>, com.google.common.collect.FluentIterable<E>> {
        @Override // com.google.common.base.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.FluentIterable<E> apply(java.lang.Iterable<E> iterable) {
            return com.google.common.collect.FluentIterable.from(iterable);
        }
    }

    public FluentIterable() {
        this.n = com.google.common.base.Optional.absent();
    }

    public FluentIterable(java.lang.Iterable<E> iterable) {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        this.n = com.google.common.base.Optional.fromNullable(this == iterable ? null : iterable);
    }

    public static <T> com.google.common.collect.FluentIterable<T> a(java.lang.Iterable<? extends T>... iterableArr) {
        for (java.lang.Iterable<? extends T> iterable : iterableArr) {
            com.google.common.base.Preconditions.checkNotNull(iterable);
        }
        return new com.google.common.collect.FluentIterable.AnonymousClass3(iterableArr);
    }

    @com.google.common.annotations.Beta
    public static <T> com.google.common.collect.FluentIterable<T> concat(java.lang.Iterable<? extends java.lang.Iterable<? extends T>> iterable) {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        return new com.google.common.collect.FluentIterable.AnonymousClass2(iterable);
    }

    @com.google.common.annotations.Beta
    public static <T> com.google.common.collect.FluentIterable<T> concat(java.lang.Iterable<? extends T> iterable, java.lang.Iterable<? extends T> iterable2) {
        return a(iterable, iterable2);
    }

    @com.google.common.annotations.Beta
    public static <T> com.google.common.collect.FluentIterable<T> concat(java.lang.Iterable<? extends T> iterable, java.lang.Iterable<? extends T> iterable2, java.lang.Iterable<? extends T> iterable3) {
        return a(iterable, iterable2, iterable3);
    }

    @com.google.common.annotations.Beta
    public static <T> com.google.common.collect.FluentIterable<T> concat(java.lang.Iterable<? extends T> iterable, java.lang.Iterable<? extends T> iterable2, java.lang.Iterable<? extends T> iterable3, java.lang.Iterable<? extends T> iterable4) {
        return a(iterable, iterable2, iterable3, iterable4);
    }

    @com.google.common.annotations.Beta
    public static <T> com.google.common.collect.FluentIterable<T> concat(java.lang.Iterable<? extends T>... iterableArr) {
        return a((java.lang.Iterable[]) java.util.Arrays.copyOf(iterableArr, iterableArr.length));
    }

    @java.lang.Deprecated
    public static <E> com.google.common.collect.FluentIterable<E> from(com.google.common.collect.FluentIterable<E> fluentIterable) {
        return (com.google.common.collect.FluentIterable) com.google.common.base.Preconditions.checkNotNull(fluentIterable);
    }

    public static <E> com.google.common.collect.FluentIterable<E> from(java.lang.Iterable<E> iterable) {
        return iterable instanceof com.google.common.collect.FluentIterable ? (com.google.common.collect.FluentIterable) iterable : new com.google.common.collect.FluentIterable.AnonymousClass1(iterable, iterable);
    }

    @com.google.common.annotations.Beta
    public static <E> com.google.common.collect.FluentIterable<E> from(E[] eArr) {
        return from(java.util.Arrays.asList(eArr));
    }

    @com.google.common.annotations.Beta
    public static <E> com.google.common.collect.FluentIterable<E> of() {
        return from(com.google.common.collect.ImmutableList.of());
    }

    @com.google.common.annotations.Beta
    public static <E> com.google.common.collect.FluentIterable<E> of(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, E... eArr) {
        return from(com.google.common.collect.Lists.asList(e, eArr));
    }

    public final boolean allMatch(com.google.common.base.Predicate<? super E> predicate) {
        return com.google.common.collect.Iterables.all(b(), predicate);
    }

    public final boolean anyMatch(com.google.common.base.Predicate<? super E> predicate) {
        return com.google.common.collect.Iterables.any(b(), predicate);
    }

    @com.google.common.annotations.Beta
    public final com.google.common.collect.FluentIterable<E> append(java.lang.Iterable<? extends E> iterable) {
        return concat(b(), iterable);
    }

    @com.google.common.annotations.Beta
    public final com.google.common.collect.FluentIterable<E> append(E... eArr) {
        return concat(b(), java.util.Arrays.asList(eArr));
    }

    public final java.lang.Iterable<E> b() {
        return this.n.or((com.google.common.base.Optional<java.lang.Iterable<E>>) this);
    }

    public final boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return com.google.common.collect.Iterables.contains(b(), obj);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final <C extends java.util.Collection<? super E>> C copyInto(C c) {
        com.google.common.base.Preconditions.checkNotNull(c);
        java.lang.Iterable<E> b = b();
        if (b instanceof java.util.Collection) {
            c.addAll(com.google.common.collect.Collections2.b(b));
        } else {
            java.util.Iterator<E> it = b.iterator();
            while (it.hasNext()) {
                c.add(it.next());
            }
        }
        return c;
    }

    public final com.google.common.collect.FluentIterable<E> cycle() {
        return from(com.google.common.collect.Iterables.cycle(b()));
    }

    public final com.google.common.collect.FluentIterable<E> filter(com.google.common.base.Predicate<? super E> predicate) {
        return from(com.google.common.collect.Iterables.filter(b(), predicate));
    }

    @com.google.common.annotations.GwtIncompatible
    public final <T> com.google.common.collect.FluentIterable<T> filter(java.lang.Class<T> cls) {
        return from(com.google.common.collect.Iterables.filter((java.lang.Iterable<?>) b(), (java.lang.Class) cls));
    }

    public final com.google.common.base.Optional<E> first() {
        java.util.Iterator<E> it = b().iterator();
        return it.hasNext() ? com.google.common.base.Optional.of(it.next()) : com.google.common.base.Optional.absent();
    }

    public final com.google.common.base.Optional<E> firstMatch(com.google.common.base.Predicate<? super E> predicate) {
        return com.google.common.collect.Iterables.tryFind(b(), predicate);
    }

    public final E get(int i) {
        return (E) com.google.common.collect.Iterables.get(b(), i);
    }

    public final <K> com.google.common.collect.ImmutableListMultimap<K, E> index(com.google.common.base.Function<? super E, K> function) {
        return com.google.common.collect.Multimaps.index(b(), function);
    }

    public final boolean isEmpty() {
        return !b().iterator().hasNext();
    }

    @com.google.common.annotations.Beta
    public final java.lang.String join(com.google.common.base.Joiner joiner) {
        return joiner.join(this);
    }

    public final com.google.common.base.Optional<E> last() {
        E next;
        java.lang.Iterable<E> b = b();
        if (b instanceof java.util.List) {
            java.util.List list = (java.util.List) b;
            return list.isEmpty() ? com.google.common.base.Optional.absent() : com.google.common.base.Optional.of(list.get(list.size() - 1));
        }
        java.util.Iterator<E> it = b.iterator();
        if (!it.hasNext()) {
            return com.google.common.base.Optional.absent();
        }
        if (b instanceof java.util.SortedSet) {
            return com.google.common.base.Optional.of(((java.util.SortedSet) b).last());
        }
        do {
            next = it.next();
        } while (it.hasNext());
        return com.google.common.base.Optional.of(next);
    }

    public final com.google.common.collect.FluentIterable<E> limit(int i) {
        return from(com.google.common.collect.Iterables.limit(b(), i));
    }

    public final int size() {
        return com.google.common.collect.Iterables.size(b());
    }

    public final com.google.common.collect.FluentIterable<E> skip(int i) {
        return from(com.google.common.collect.Iterables.skip(b(), i));
    }

    @com.google.common.annotations.GwtIncompatible
    public final E[] toArray(java.lang.Class<E> cls) {
        return (E[]) com.google.common.collect.Iterables.toArray(b(), cls);
    }

    public final com.google.common.collect.ImmutableList<E> toList() {
        return com.google.common.collect.ImmutableList.copyOf(b());
    }

    public final <V> com.google.common.collect.ImmutableMap<E, V> toMap(com.google.common.base.Function<? super E, V> function) {
        return com.google.common.collect.Maps.toMap(b(), function);
    }

    public final com.google.common.collect.ImmutableMultiset<E> toMultiset() {
        return com.google.common.collect.ImmutableMultiset.copyOf(b());
    }

    public final com.google.common.collect.ImmutableSet<E> toSet() {
        return com.google.common.collect.ImmutableSet.copyOf(b());
    }

    public final com.google.common.collect.ImmutableList<E> toSortedList(java.util.Comparator<? super E> comparator) {
        return com.google.common.collect.Ordering.from(comparator).immutableSortedCopy(b());
    }

    public final com.google.common.collect.ImmutableSortedSet<E> toSortedSet(java.util.Comparator<? super E> comparator) {
        return com.google.common.collect.ImmutableSortedSet.copyOf(comparator, b());
    }

    public java.lang.String toString() {
        return com.google.common.collect.Iterables.toString(b());
    }

    public final <T> com.google.common.collect.FluentIterable<T> transform(com.google.common.base.Function<? super E, T> function) {
        return from(com.google.common.collect.Iterables.transform(b(), function));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> com.google.common.collect.FluentIterable<T> transformAndConcat(com.google.common.base.Function<? super E, ? extends java.lang.Iterable<? extends T>> function) {
        return concat(transform(function));
    }

    public final <K> com.google.common.collect.ImmutableMap<K, E> uniqueIndex(com.google.common.base.Function<? super E, K> function) {
        return com.google.common.collect.Maps.uniqueIndex(b(), function);
    }
}
