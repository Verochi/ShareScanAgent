package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class Iterables {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.Iterables$1, reason: invalid class name */
    public static class AnonymousClass1<T> extends com.google.common.collect.FluentIterable<T> {
        public final /* synthetic */ java.lang.Iterable t;

        public AnonymousClass1(java.lang.Iterable iterable) {
            this.t = iterable;
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<T> iterator() {
            return com.google.common.collect.Iterators.cycle(this.t);
        }

        @Override // com.google.common.collect.FluentIterable
        public java.lang.String toString() {
            return this.t.toString() + " (cycled)";
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.Iterables$10, reason: invalid class name */
    public static class AnonymousClass10<T> implements com.google.common.base.Function<java.lang.Iterable<? extends T>, java.util.Iterator<? extends T>> {
        @Override // com.google.common.base.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.Iterator<? extends T> apply(java.lang.Iterable<? extends T> iterable) {
            return iterable.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.Iterables$2, reason: invalid class name */
    public static class AnonymousClass2<T> extends com.google.common.collect.FluentIterable<java.util.List<T>> {
        public final /* synthetic */ java.lang.Iterable t;
        public final /* synthetic */ int u;

        public AnonymousClass2(java.lang.Iterable iterable, int i) {
            this.t = iterable;
            this.u = i;
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<java.util.List<T>> iterator() {
            return com.google.common.collect.Iterators.partition(this.t.iterator(), this.u);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.Iterables$3, reason: invalid class name */
    public static class AnonymousClass3<T> extends com.google.common.collect.FluentIterable<java.util.List<T>> {
        public final /* synthetic */ java.lang.Iterable t;
        public final /* synthetic */ int u;

        public AnonymousClass3(java.lang.Iterable iterable, int i) {
            this.t = iterable;
            this.u = i;
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<java.util.List<T>> iterator() {
            return com.google.common.collect.Iterators.paddedPartition(this.t.iterator(), this.u);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.Iterables$4, reason: invalid class name */
    public static class AnonymousClass4<T> extends com.google.common.collect.FluentIterable<T> {
        public final /* synthetic */ java.lang.Iterable t;
        public final /* synthetic */ com.google.common.base.Predicate u;

        public AnonymousClass4(java.lang.Iterable iterable, com.google.common.base.Predicate predicate) {
            this.t = iterable;
            this.u = predicate;
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<T> iterator() {
            return com.google.common.collect.Iterators.filter(this.t.iterator(), this.u);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.Iterables$5, reason: invalid class name */
    public static class AnonymousClass5<T> extends com.google.common.collect.FluentIterable<T> {
        public final /* synthetic */ java.lang.Iterable t;
        public final /* synthetic */ com.google.common.base.Function u;

        public AnonymousClass5(java.lang.Iterable iterable, com.google.common.base.Function function) {
            this.t = iterable;
            this.u = function;
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<T> iterator() {
            return com.google.common.collect.Iterators.transform(this.t.iterator(), this.u);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.Iterables$6, reason: invalid class name */
    public static class AnonymousClass6<T> extends com.google.common.collect.FluentIterable<T> {
        public final /* synthetic */ java.lang.Iterable t;
        public final /* synthetic */ int u;

        /* renamed from: com.google.common.collect.Iterables$6$1, reason: invalid class name */
        public class AnonymousClass1 implements java.util.Iterator<T> {
            public boolean n = true;
            public final /* synthetic */ java.util.Iterator t;

            public AnonymousClass1(java.util.Iterator it) {
                this.t = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.t.hasNext();
            }

            @Override // java.util.Iterator
            public T next() {
                T t = (T) this.t.next();
                this.n = false;
                return t;
            }

            @Override // java.util.Iterator
            public void remove() {
                com.google.common.collect.CollectPreconditions.e(!this.n);
                this.t.remove();
            }
        }

        public AnonymousClass6(java.lang.Iterable iterable, int i) {
            this.t = iterable;
            this.u = i;
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<T> iterator() {
            java.lang.Iterable iterable = this.t;
            if (iterable instanceof java.util.List) {
                java.util.List list = (java.util.List) iterable;
                return list.subList(java.lang.Math.min(list.size(), this.u), list.size()).iterator();
            }
            java.util.Iterator<T> it = iterable.iterator();
            com.google.common.collect.Iterators.advance(it, this.u);
            return new com.google.common.collect.Iterables.AnonymousClass6.AnonymousClass1(it);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.Iterables$7, reason: invalid class name */
    public static class AnonymousClass7<T> extends com.google.common.collect.FluentIterable<T> {
        public final /* synthetic */ java.lang.Iterable t;
        public final /* synthetic */ int u;

        public AnonymousClass7(java.lang.Iterable iterable, int i) {
            this.t = iterable;
            this.u = i;
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<T> iterator() {
            return com.google.common.collect.Iterators.limit(this.t.iterator(), this.u);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.Iterables$8, reason: invalid class name */
    public static class AnonymousClass8<T> extends com.google.common.collect.FluentIterable<T> {
        public final /* synthetic */ java.lang.Iterable t;

        public AnonymousClass8(java.lang.Iterable iterable) {
            this.t = iterable;
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<T> iterator() {
            java.lang.Iterable iterable = this.t;
            return iterable instanceof java.util.Queue ? new com.google.common.collect.ConsumingQueueIterator((java.util.Queue) iterable) : com.google.common.collect.Iterators.consumingIterator(iterable.iterator());
        }

        @Override // com.google.common.collect.FluentIterable
        public java.lang.String toString() {
            return "Iterables.consumingIterable(...)";
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.Iterables$9, reason: invalid class name */
    public static class AnonymousClass9<T> extends com.google.common.collect.FluentIterable<T> {
        public final /* synthetic */ java.lang.Iterable t;
        public final /* synthetic */ java.util.Comparator u;

        public AnonymousClass9(java.lang.Iterable iterable, java.util.Comparator comparator) {
            this.t = iterable;
            this.u = comparator;
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<T> iterator() {
            return com.google.common.collect.Iterators.mergeSorted(com.google.common.collect.Iterables.transform(this.t, com.google.common.collect.Iterables.h()), this.u);
        }
    }

    public static final class UnmodifiableIterable<T> extends com.google.common.collect.FluentIterable<T> {
        public final java.lang.Iterable<? extends T> t;

        public UnmodifiableIterable(java.lang.Iterable<? extends T> iterable) {
            this.t = iterable;
        }

        public /* synthetic */ UnmodifiableIterable(java.lang.Iterable iterable, com.google.common.collect.Iterables.AnonymousClass1 anonymousClass1) {
            this(iterable);
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<T> iterator() {
            return com.google.common.collect.Iterators.unmodifiableIterator(this.t.iterator());
        }

        @Override // com.google.common.collect.FluentIterable
        public java.lang.String toString() {
            return this.t.toString();
        }
    }

    public static <E> java.util.Collection<E> a(java.lang.Iterable<E> iterable) {
        return iterable instanceof java.util.Collection ? (java.util.Collection) iterable : com.google.common.collect.Lists.newArrayList(iterable.iterator());
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <T> boolean addAll(java.util.Collection<T> collection, java.lang.Iterable<? extends T> iterable) {
        return iterable instanceof java.util.Collection ? collection.addAll(com.google.common.collect.Collections2.b(iterable)) : com.google.common.collect.Iterators.addAll(collection, ((java.lang.Iterable) com.google.common.base.Preconditions.checkNotNull(iterable)).iterator());
    }

    public static <T> boolean all(java.lang.Iterable<T> iterable, com.google.common.base.Predicate<? super T> predicate) {
        return com.google.common.collect.Iterators.all(iterable.iterator(), predicate);
    }

    public static <T> boolean any(java.lang.Iterable<T> iterable, com.google.common.base.Predicate<? super T> predicate) {
        return com.google.common.collect.Iterators.any(iterable.iterator(), predicate);
    }

    public static <T> T b(java.util.List<T> list) {
        return list.get(list.size() - 1);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static <T> T c(java.lang.Iterable<T> iterable, com.google.common.base.Predicate<? super T> predicate) {
        com.google.common.base.Preconditions.checkNotNull(predicate);
        java.util.Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    public static <T> java.lang.Iterable<T> concat(java.lang.Iterable<? extends java.lang.Iterable<? extends T>> iterable) {
        return com.google.common.collect.FluentIterable.concat(iterable);
    }

    public static <T> java.lang.Iterable<T> concat(java.lang.Iterable<? extends T> iterable, java.lang.Iterable<? extends T> iterable2) {
        return com.google.common.collect.FluentIterable.concat(iterable, iterable2);
    }

    public static <T> java.lang.Iterable<T> concat(java.lang.Iterable<? extends T> iterable, java.lang.Iterable<? extends T> iterable2, java.lang.Iterable<? extends T> iterable3) {
        return com.google.common.collect.FluentIterable.concat(iterable, iterable2, iterable3);
    }

    public static <T> java.lang.Iterable<T> concat(java.lang.Iterable<? extends T> iterable, java.lang.Iterable<? extends T> iterable2, java.lang.Iterable<? extends T> iterable3, java.lang.Iterable<? extends T> iterable4) {
        return com.google.common.collect.FluentIterable.concat(iterable, iterable2, iterable3, iterable4);
    }

    @java.lang.SafeVarargs
    public static <T> java.lang.Iterable<T> concat(java.lang.Iterable<? extends T>... iterableArr) {
        return com.google.common.collect.FluentIterable.concat(iterableArr);
    }

    public static <T> java.lang.Iterable<T> consumingIterable(java.lang.Iterable<T> iterable) {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        return new com.google.common.collect.Iterables.AnonymousClass8(iterable);
    }

    public static boolean contains(java.lang.Iterable<?> iterable, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return iterable instanceof java.util.Collection ? com.google.common.collect.Collections2.g((java.util.Collection) iterable, obj) : com.google.common.collect.Iterators.contains(iterable.iterator(), obj);
    }

    public static <T> java.lang.Iterable<T> cycle(java.lang.Iterable<T> iterable) {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        return new com.google.common.collect.Iterables.AnonymousClass1(iterable);
    }

    @java.lang.SafeVarargs
    public static <T> java.lang.Iterable<T> cycle(T... tArr) {
        return cycle(com.google.common.collect.Lists.newArrayList(tArr));
    }

    public static <T> boolean d(java.util.List<T> list, com.google.common.base.Predicate<? super T> predicate) {
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            T t = list.get(i);
            if (!predicate.apply(t)) {
                if (i > i2) {
                    try {
                        list.set(i2, t);
                    } catch (java.lang.IllegalArgumentException unused) {
                        e(list, predicate, i2, i);
                        return true;
                    } catch (java.lang.UnsupportedOperationException unused2) {
                        e(list, predicate, i2, i);
                        return true;
                    }
                }
                i2++;
            }
            i++;
        }
        list.subList(i2, list.size()).clear();
        return i != i2;
    }

    public static <T> void e(java.util.List<T> list, com.google.common.base.Predicate<? super T> predicate, int i, int i2) {
        for (int size = list.size() - 1; size > i2; size--) {
            if (predicate.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            list.remove(i3);
        }
    }

    public static boolean elementsEqual(java.lang.Iterable<?> iterable, java.lang.Iterable<?> iterable2) {
        if ((iterable instanceof java.util.Collection) && (iterable2 instanceof java.util.Collection) && ((java.util.Collection) iterable).size() != ((java.util.Collection) iterable2).size()) {
            return false;
        }
        return com.google.common.collect.Iterators.elementsEqual(iterable.iterator(), iterable2.iterator());
    }

    public static java.lang.Object[] f(java.lang.Iterable<?> iterable) {
        return a(iterable).toArray();
    }

    public static <T> java.lang.Iterable<T> filter(java.lang.Iterable<T> iterable, com.google.common.base.Predicate<? super T> predicate) {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        com.google.common.base.Preconditions.checkNotNull(predicate);
        return new com.google.common.collect.Iterables.AnonymousClass4(iterable, predicate);
    }

    @com.google.common.annotations.GwtIncompatible
    public static <T> java.lang.Iterable<T> filter(java.lang.Iterable<?> iterable, java.lang.Class<T> cls) {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        com.google.common.base.Preconditions.checkNotNull(cls);
        return filter(iterable, com.google.common.base.Predicates.instanceOf(cls));
    }

    public static <T> T find(java.lang.Iterable<T> iterable, com.google.common.base.Predicate<? super T> predicate) {
        return (T) com.google.common.collect.Iterators.find(iterable.iterator(), predicate);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static <T> T find(java.lang.Iterable<? extends T> iterable, com.google.common.base.Predicate<? super T> predicate, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        return (T) com.google.common.collect.Iterators.find(iterable.iterator(), predicate, t);
    }

    public static int frequency(java.lang.Iterable<?> iterable, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return iterable instanceof com.google.common.collect.Multiset ? ((com.google.common.collect.Multiset) iterable).count(obj) : iterable instanceof java.util.Set ? ((java.util.Set) iterable).contains(obj) ? 1 : 0 : com.google.common.collect.Iterators.frequency(iterable.iterator(), obj);
    }

    public static <T> T[] g(java.lang.Iterable<? extends T> iterable, T[] tArr) {
        return (T[]) a(iterable).toArray(tArr);
    }

    public static <T> T get(java.lang.Iterable<T> iterable, int i) {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        return iterable instanceof java.util.List ? (T) ((java.util.List) iterable).get(i) : (T) com.google.common.collect.Iterators.get(iterable.iterator(), i);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static <T> T get(java.lang.Iterable<? extends T> iterable, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        com.google.common.collect.Iterators.b(i);
        if (iterable instanceof java.util.List) {
            java.util.List b = com.google.common.collect.Lists.b(iterable);
            return i < b.size() ? (T) b.get(i) : t;
        }
        java.util.Iterator<? extends T> it = iterable.iterator();
        com.google.common.collect.Iterators.advance(it, i);
        return (T) com.google.common.collect.Iterators.getNext(it, t);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static <T> T getFirst(java.lang.Iterable<? extends T> iterable, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        return (T) com.google.common.collect.Iterators.getNext(iterable.iterator(), t);
    }

    public static <T> T getLast(java.lang.Iterable<T> iterable) {
        if (!(iterable instanceof java.util.List)) {
            return (T) com.google.common.collect.Iterators.getLast(iterable.iterator());
        }
        java.util.List list = (java.util.List) iterable;
        if (list.isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return (T) b(list);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static <T> T getLast(java.lang.Iterable<? extends T> iterable, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        if (iterable instanceof java.util.Collection) {
            if (com.google.common.collect.Collections2.b(iterable).isEmpty()) {
                return t;
            }
            if (iterable instanceof java.util.List) {
                return (T) b(com.google.common.collect.Lists.b(iterable));
            }
        }
        return (T) com.google.common.collect.Iterators.getLast(iterable.iterator(), t);
    }

    public static <T> T getOnlyElement(java.lang.Iterable<T> iterable) {
        return (T) com.google.common.collect.Iterators.getOnlyElement(iterable.iterator());
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static <T> T getOnlyElement(java.lang.Iterable<? extends T> iterable, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        return (T) com.google.common.collect.Iterators.getOnlyElement(iterable.iterator(), t);
    }

    public static <T> com.google.common.base.Function<java.lang.Iterable<? extends T>, java.util.Iterator<? extends T>> h() {
        return new com.google.common.collect.Iterables.AnonymousClass10();
    }

    public static <T> int indexOf(java.lang.Iterable<T> iterable, com.google.common.base.Predicate<? super T> predicate) {
        return com.google.common.collect.Iterators.indexOf(iterable.iterator(), predicate);
    }

    public static boolean isEmpty(java.lang.Iterable<?> iterable) {
        return iterable instanceof java.util.Collection ? ((java.util.Collection) iterable).isEmpty() : !iterable.iterator().hasNext();
    }

    public static <T> java.lang.Iterable<T> limit(java.lang.Iterable<T> iterable, int i) {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        com.google.common.base.Preconditions.checkArgument(i >= 0, "limit is negative");
        return new com.google.common.collect.Iterables.AnonymousClass7(iterable, i);
    }

    @com.google.common.annotations.Beta
    public static <T> java.lang.Iterable<T> mergeSorted(java.lang.Iterable<? extends java.lang.Iterable<? extends T>> iterable, java.util.Comparator<? super T> comparator) {
        com.google.common.base.Preconditions.checkNotNull(iterable, "iterables");
        com.google.common.base.Preconditions.checkNotNull(comparator, "comparator");
        return new com.google.common.collect.Iterables.UnmodifiableIterable(new com.google.common.collect.Iterables.AnonymousClass9(iterable, comparator), null);
    }

    public static <T> java.lang.Iterable<java.util.List<T>> paddedPartition(java.lang.Iterable<T> iterable, int i) {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        com.google.common.base.Preconditions.checkArgument(i > 0);
        return new com.google.common.collect.Iterables.AnonymousClass3(iterable, i);
    }

    public static <T> java.lang.Iterable<java.util.List<T>> partition(java.lang.Iterable<T> iterable, int i) {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        com.google.common.base.Preconditions.checkArgument(i > 0);
        return new com.google.common.collect.Iterables.AnonymousClass2(iterable, i);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static boolean removeAll(java.lang.Iterable<?> iterable, java.util.Collection<?> collection) {
        return iterable instanceof java.util.Collection ? ((java.util.Collection) iterable).removeAll((java.util.Collection) com.google.common.base.Preconditions.checkNotNull(collection)) : com.google.common.collect.Iterators.removeAll(iterable.iterator(), collection);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <T> boolean removeIf(java.lang.Iterable<T> iterable, com.google.common.base.Predicate<? super T> predicate) {
        return ((iterable instanceof java.util.RandomAccess) && (iterable instanceof java.util.List)) ? d((java.util.List) iterable, (com.google.common.base.Predicate) com.google.common.base.Preconditions.checkNotNull(predicate)) : com.google.common.collect.Iterators.removeIf(iterable.iterator(), predicate);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static boolean retainAll(java.lang.Iterable<?> iterable, java.util.Collection<?> collection) {
        return iterable instanceof java.util.Collection ? ((java.util.Collection) iterable).retainAll((java.util.Collection) com.google.common.base.Preconditions.checkNotNull(collection)) : com.google.common.collect.Iterators.retainAll(iterable.iterator(), collection);
    }

    public static int size(java.lang.Iterable<?> iterable) {
        return iterable instanceof java.util.Collection ? ((java.util.Collection) iterable).size() : com.google.common.collect.Iterators.size(iterable.iterator());
    }

    public static <T> java.lang.Iterable<T> skip(java.lang.Iterable<T> iterable, int i) {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        com.google.common.base.Preconditions.checkArgument(i >= 0, "number to skip cannot be negative");
        return new com.google.common.collect.Iterables.AnonymousClass6(iterable, i);
    }

    @com.google.common.annotations.GwtIncompatible
    public static <T> T[] toArray(java.lang.Iterable<? extends T> iterable, java.lang.Class<T> cls) {
        return (T[]) g(iterable, com.google.common.collect.ObjectArrays.newArray(cls, 0));
    }

    public static java.lang.String toString(java.lang.Iterable<?> iterable) {
        return com.google.common.collect.Iterators.toString(iterable.iterator());
    }

    public static <F, T> java.lang.Iterable<T> transform(java.lang.Iterable<F> iterable, com.google.common.base.Function<? super F, ? extends T> function) {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        com.google.common.base.Preconditions.checkNotNull(function);
        return new com.google.common.collect.Iterables.AnonymousClass5(iterable, function);
    }

    public static <T> com.google.common.base.Optional<T> tryFind(java.lang.Iterable<T> iterable, com.google.common.base.Predicate<? super T> predicate) {
        return com.google.common.collect.Iterators.tryFind(iterable.iterator(), predicate);
    }

    @java.lang.Deprecated
    public static <E> java.lang.Iterable<E> unmodifiableIterable(com.google.common.collect.ImmutableCollection<E> immutableCollection) {
        return (java.lang.Iterable) com.google.common.base.Preconditions.checkNotNull(immutableCollection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> java.lang.Iterable<T> unmodifiableIterable(java.lang.Iterable<? extends T> iterable) {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        return ((iterable instanceof com.google.common.collect.Iterables.UnmodifiableIterable) || (iterable instanceof com.google.common.collect.ImmutableCollection)) ? iterable : new com.google.common.collect.Iterables.UnmodifiableIterable(iterable, null);
    }
}
