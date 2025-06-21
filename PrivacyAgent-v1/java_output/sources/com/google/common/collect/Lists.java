package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class Lists {

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* renamed from: com.google.common.collect.Lists$1, reason: invalid class name */
    public static class AnonymousClass1<E> extends com.google.common.collect.Lists.RandomAccessListWrapper<E> {
        private static final long serialVersionUID = 0;

        public AnonymousClass1(java.util.List list) {
            super(list);
        }

        @Override // java.util.AbstractList, java.util.List
        public java.util.ListIterator<E> listIterator(int i) {
            return this.n.listIterator(i);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* renamed from: com.google.common.collect.Lists$2, reason: invalid class name */
    public static class AnonymousClass2<E> extends com.google.common.collect.Lists.AbstractListWrapper<E> {
        private static final long serialVersionUID = 0;

        public AnonymousClass2(java.util.List list) {
            super(list);
        }

        @Override // java.util.AbstractList, java.util.List
        public java.util.ListIterator<E> listIterator(int i) {
            return this.n.listIterator(i);
        }
    }

    public static class AbstractListWrapper<E> extends java.util.AbstractList<E> {
        public final java.util.List<E> n;

        public AbstractListWrapper(java.util.List<E> list) {
            this.n = (java.util.List) com.google.common.base.Preconditions.checkNotNull(list);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, E e) {
            this.n.add(i, e);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i, java.util.Collection<? extends E> collection) {
            return this.n.addAll(i, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(java.lang.Object obj) {
            return this.n.contains(obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            return this.n.get(i);
        }

        @Override // java.util.AbstractList, java.util.List
        public E remove(int i) {
            return this.n.remove(i);
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int i, E e) {
            return this.n.set(i, e);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.n.size();
        }
    }

    public static final class CharSequenceAsList extends java.util.AbstractList<java.lang.Character> {
        public final java.lang.CharSequence n;

        public CharSequenceAsList(java.lang.CharSequence charSequence) {
            this.n = charSequence;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.Character get(int i) {
            com.google.common.base.Preconditions.checkElementIndex(i, size());
            return java.lang.Character.valueOf(this.n.charAt(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.n.length();
        }
    }

    public static class OnePlusArrayList<E> extends java.util.AbstractList<E> implements java.io.Serializable, java.util.RandomAccess {
        private static final long serialVersionUID = 0;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        final E first;
        final E[] rest;

        public OnePlusArrayList(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, E[] eArr) {
            this.first = e;
            this.rest = (E[]) ((java.lang.Object[]) com.google.common.base.Preconditions.checkNotNull(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            com.google.common.base.Preconditions.checkElementIndex(i, size());
            return i == 0 ? this.first : this.rest[i - 1];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return com.google.common.math.IntMath.saturatedAdd(this.rest.length, 1);
        }
    }

    public static class Partition<T> extends java.util.AbstractList<java.util.List<T>> {
        public final java.util.List<T> n;
        public final int t;

        public Partition(java.util.List<T> list, int i) {
            this.n = list;
            this.t = i;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.List<T> get(int i) {
            com.google.common.base.Preconditions.checkElementIndex(i, size());
            int i2 = this.t;
            int i3 = i * i2;
            return this.n.subList(i3, java.lang.Math.min(i2 + i3, this.n.size()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.n.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return com.google.common.math.IntMath.divide(this.n.size(), this.t, java.math.RoundingMode.CEILING);
        }
    }

    public static class RandomAccessListWrapper<E> extends com.google.common.collect.Lists.AbstractListWrapper<E> implements java.util.RandomAccess {
        public RandomAccessListWrapper(java.util.List<E> list) {
            super(list);
        }
    }

    public static class RandomAccessPartition<T> extends com.google.common.collect.Lists.Partition<T> implements java.util.RandomAccess {
        public RandomAccessPartition(java.util.List<T> list, int i) {
            super(list, i);
        }
    }

    public static class RandomAccessReverseList<T> extends com.google.common.collect.Lists.ReverseList<T> implements java.util.RandomAccess {
        public RandomAccessReverseList(java.util.List<T> list) {
            super(list);
        }
    }

    public static class ReverseList<T> extends java.util.AbstractList<T> {
        public final java.util.List<T> n;

        /* renamed from: com.google.common.collect.Lists$ReverseList$1, reason: invalid class name */
        public class AnonymousClass1 implements java.util.ListIterator<T> {
            public boolean n;
            public final /* synthetic */ java.util.ListIterator t;

            public AnonymousClass1(java.util.ListIterator listIterator) {
                this.t = listIterator;
            }

            @Override // java.util.ListIterator
            public void add(T t) {
                this.t.add(t);
                this.t.previous();
                this.n = false;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.t.hasPrevious();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.t.hasNext();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public T next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                this.n = true;
                return (T) this.t.previous();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return com.google.common.collect.Lists.ReverseList.this.d(this.t.nextIndex());
            }

            @Override // java.util.ListIterator
            public T previous() {
                if (!hasPrevious()) {
                    throw new java.util.NoSuchElementException();
                }
                this.n = true;
                return (T) this.t.next();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return nextIndex() - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                com.google.common.collect.CollectPreconditions.e(this.n);
                this.t.remove();
                this.n = false;
            }

            @Override // java.util.ListIterator
            public void set(T t) {
                com.google.common.base.Preconditions.checkState(this.n);
                this.t.set(t);
            }
        }

        public ReverseList(java.util.List<T> list) {
            this.n = (java.util.List) com.google.common.base.Preconditions.checkNotNull(list);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
            this.n.add(d(i), t);
        }

        public java.util.List<T> b() {
            return this.n;
        }

        public final int c(int i) {
            int size = size();
            com.google.common.base.Preconditions.checkElementIndex(i, size);
            return (size - 1) - i;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.n.clear();
        }

        public final int d(int i) {
            int size = size();
            com.google.common.base.Preconditions.checkPositionIndex(i, size);
            return size - i;
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            return this.n.get(c(i));
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public java.util.Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public java.util.ListIterator<T> listIterator(int i) {
            return new com.google.common.collect.Lists.ReverseList.AnonymousClass1(this.n.listIterator(d(i)));
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i) {
            return this.n.remove(c(i));
        }

        @Override // java.util.AbstractList
        public void removeRange(int i, int i2) {
            subList(i, i2).clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T set(int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
            return this.n.set(c(i), t);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.n.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public java.util.List<T> subList(int i, int i2) {
            com.google.common.base.Preconditions.checkPositionIndexes(i, i2, size());
            return com.google.common.collect.Lists.reverse(this.n.subList(d(i2), d(i)));
        }
    }

    public static final class StringAsImmutableList extends com.google.common.collect.ImmutableList<java.lang.Character> {
        private final java.lang.String string;

        public StringAsImmutableList(java.lang.String str) {
            this.string = str;
        }

        @Override // java.util.List
        public java.lang.Character get(int i) {
            com.google.common.base.Preconditions.checkElementIndex(i, size());
            return java.lang.Character.valueOf(this.string.charAt(i));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof java.lang.Character) {
                return this.string.indexOf(((java.lang.Character) obj).charValue());
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof java.lang.Character) {
                return this.string.lastIndexOf(((java.lang.Character) obj).charValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.string.length();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public com.google.common.collect.ImmutableList<java.lang.Character> subList(int i, int i2) {
            com.google.common.base.Preconditions.checkPositionIndexes(i, i2, size());
            return com.google.common.collect.Lists.charactersOf(this.string.substring(i, i2));
        }
    }

    public static class TransformingRandomAccessList<F, T> extends java.util.AbstractList<T> implements java.util.RandomAccess, java.io.Serializable {
        private static final long serialVersionUID = 0;
        final java.util.List<F> fromList;
        final com.google.common.base.Function<? super F, ? extends T> function;

        /* renamed from: com.google.common.collect.Lists$TransformingRandomAccessList$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.TransformedListIterator<F, T> {
            public AnonymousClass1(java.util.ListIterator listIterator) {
                super(listIterator);
            }

            @Override // com.google.common.collect.TransformedIterator
            public T a(F f) {
                return com.google.common.collect.Lists.TransformingRandomAccessList.this.function.apply(f);
            }
        }

        public TransformingRandomAccessList(java.util.List<F> list, com.google.common.base.Function<? super F, ? extends T> function) {
            this.fromList = (java.util.List) com.google.common.base.Preconditions.checkNotNull(list);
            this.function = (com.google.common.base.Function) com.google.common.base.Preconditions.checkNotNull(function);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            return this.function.apply(this.fromList.get(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public java.util.Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public java.util.ListIterator<T> listIterator(int i) {
            return new com.google.common.collect.Lists.TransformingRandomAccessList.AnonymousClass1(this.fromList.listIterator(i));
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i) {
            return this.function.apply(this.fromList.remove(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    public static class TransformingSequentialList<F, T> extends java.util.AbstractSequentialList<T> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        final java.util.List<F> fromList;
        final com.google.common.base.Function<? super F, ? extends T> function;

        /* renamed from: com.google.common.collect.Lists$TransformingSequentialList$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.TransformedListIterator<F, T> {
            public AnonymousClass1(java.util.ListIterator listIterator) {
                super(listIterator);
            }

            @Override // com.google.common.collect.TransformedIterator
            public T a(F f) {
                return com.google.common.collect.Lists.TransformingSequentialList.this.function.apply(f);
            }
        }

        public TransformingSequentialList(java.util.List<F> list, com.google.common.base.Function<? super F, ? extends T> function) {
            this.fromList = (java.util.List) com.google.common.base.Preconditions.checkNotNull(list);
            this.function = (com.google.common.base.Function) com.google.common.base.Preconditions.checkNotNull(function);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public java.util.ListIterator<T> listIterator(int i) {
            return new com.google.common.collect.Lists.TransformingSequentialList.AnonymousClass1(this.fromList.listIterator(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    public static class TwoPlusArrayList<E> extends java.util.AbstractList<E> implements java.io.Serializable, java.util.RandomAccess {
        private static final long serialVersionUID = 0;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        final E first;
        final E[] rest;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        final E second;

        public TwoPlusArrayList(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, @org.checkerframework.checker.nullness.compatqual.NullableDecl E e2, E[] eArr) {
            this.first = e;
            this.second = e2;
            this.rest = (E[]) ((java.lang.Object[]) com.google.common.base.Preconditions.checkNotNull(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            if (i == 0) {
                return this.first;
            }
            if (i == 1) {
                return this.second;
            }
            com.google.common.base.Preconditions.checkElementIndex(i, size());
            return this.rest[i - 2];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return com.google.common.math.IntMath.saturatedAdd(this.rest.length, 2);
        }
    }

    public static <E> boolean a(java.util.List<E> list, int i, java.lang.Iterable<? extends E> iterable) {
        java.util.ListIterator<E> listIterator = list.listIterator(i);
        java.util.Iterator<? extends E> it = iterable.iterator();
        boolean z = false;
        while (it.hasNext()) {
            listIterator.add(it.next());
            z = true;
        }
        return z;
    }

    public static <E> java.util.List<E> asList(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, @org.checkerframework.checker.nullness.compatqual.NullableDecl E e2, E[] eArr) {
        return new com.google.common.collect.Lists.TwoPlusArrayList(e, e2, eArr);
    }

    public static <E> java.util.List<E> asList(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, E[] eArr) {
        return new com.google.common.collect.Lists.OnePlusArrayList(e, eArr);
    }

    public static <T> java.util.List<T> b(java.lang.Iterable<T> iterable) {
        return (java.util.List) iterable;
    }

    @com.google.common.annotations.VisibleForTesting
    public static int c(int i) {
        com.google.common.collect.CollectPreconditions.b(i, "arraySize");
        return com.google.common.primitives.Ints.saturatedCast(i + 5 + (i / 10));
    }

    public static <B> java.util.List<java.util.List<B>> cartesianProduct(java.util.List<? extends java.util.List<? extends B>> list) {
        return com.google.common.collect.CartesianList.c(list);
    }

    @java.lang.SafeVarargs
    public static <B> java.util.List<java.util.List<B>> cartesianProduct(java.util.List<? extends B>... listArr) {
        return cartesianProduct(java.util.Arrays.asList(listArr));
    }

    public static com.google.common.collect.ImmutableList<java.lang.Character> charactersOf(java.lang.String str) {
        return new com.google.common.collect.Lists.StringAsImmutableList((java.lang.String) com.google.common.base.Preconditions.checkNotNull(str));
    }

    @com.google.common.annotations.Beta
    public static java.util.List<java.lang.Character> charactersOf(java.lang.CharSequence charSequence) {
        return new com.google.common.collect.Lists.CharSequenceAsList((java.lang.CharSequence) com.google.common.base.Preconditions.checkNotNull(charSequence));
    }

    public static boolean d(java.util.List<?> list, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == com.google.common.base.Preconditions.checkNotNull(list)) {
            return true;
        }
        if (!(obj instanceof java.util.List)) {
            return false;
        }
        java.util.List list2 = (java.util.List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof java.util.RandomAccess) || !(list2 instanceof java.util.RandomAccess)) {
            return com.google.common.collect.Iterators.elementsEqual(list.iterator(), list2.iterator());
        }
        for (int i = 0; i < size; i++) {
            if (!com.google.common.base.Objects.equal(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static int e(java.util.List<?> list) {
        java.util.Iterator<?> it = list.iterator();
        int i = 1;
        while (it.hasNext()) {
            java.lang.Object next = it.next();
            i = ~(~((i * 31) + (next == null ? 0 : next.hashCode())));
        }
        return i;
    }

    public static int f(java.util.List<?> list, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (list instanceof java.util.RandomAccess) {
            return g(list, obj);
        }
        java.util.ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (com.google.common.base.Objects.equal(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public static int g(java.util.List<?> list, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        int size = list.size();
        int i = 0;
        if (obj == null) {
            while (i < size) {
                if (list.get(i) == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        while (i < size) {
            if (obj.equals(list.get(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int h(java.util.List<?> list, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (list instanceof java.util.RandomAccess) {
            return i(list, obj);
        }
        java.util.ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (com.google.common.base.Objects.equal(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static int i(java.util.List<?> list, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static <E> java.util.ListIterator<E> j(java.util.List<E> list, int i) {
        return new com.google.common.collect.Lists.AbstractListWrapper(list).listIterator(i);
    }

    public static <E> java.util.List<E> k(java.util.List<E> list, int i, int i2) {
        return (list instanceof java.util.RandomAccess ? new com.google.common.collect.Lists.AnonymousClass1(list) : new com.google.common.collect.Lists.AnonymousClass2(list)).subList(i, i2);
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <E> java.util.ArrayList<E> newArrayList() {
        return new java.util.ArrayList<>();
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <E> java.util.ArrayList<E> newArrayList(java.lang.Iterable<? extends E> iterable) {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        return iterable instanceof java.util.Collection ? new java.util.ArrayList<>(com.google.common.collect.Collections2.b(iterable)) : newArrayList(iterable.iterator());
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <E> java.util.ArrayList<E> newArrayList(java.util.Iterator<? extends E> it) {
        java.util.ArrayList<E> newArrayList = newArrayList();
        com.google.common.collect.Iterators.addAll(newArrayList, it);
        return newArrayList;
    }

    @java.lang.SafeVarargs
    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <E> java.util.ArrayList<E> newArrayList(E... eArr) {
        com.google.common.base.Preconditions.checkNotNull(eArr);
        java.util.ArrayList<E> arrayList = new java.util.ArrayList<>(c(eArr.length));
        java.util.Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <E> java.util.ArrayList<E> newArrayListWithCapacity(int i) {
        com.google.common.collect.CollectPreconditions.b(i, "initialArraySize");
        return new java.util.ArrayList<>(i);
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <E> java.util.ArrayList<E> newArrayListWithExpectedSize(int i) {
        return new java.util.ArrayList<>(c(i));
    }

    @com.google.common.annotations.GwtIncompatible
    public static <E> java.util.concurrent.CopyOnWriteArrayList<E> newCopyOnWriteArrayList() {
        return new java.util.concurrent.CopyOnWriteArrayList<>();
    }

    @com.google.common.annotations.GwtIncompatible
    public static <E> java.util.concurrent.CopyOnWriteArrayList<E> newCopyOnWriteArrayList(java.lang.Iterable<? extends E> iterable) {
        return new java.util.concurrent.CopyOnWriteArrayList<>(iterable instanceof java.util.Collection ? com.google.common.collect.Collections2.b(iterable) : newArrayList(iterable));
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <E> java.util.LinkedList<E> newLinkedList() {
        return new java.util.LinkedList<>();
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <E> java.util.LinkedList<E> newLinkedList(java.lang.Iterable<? extends E> iterable) {
        java.util.LinkedList<E> newLinkedList = newLinkedList();
        com.google.common.collect.Iterables.addAll(newLinkedList, iterable);
        return newLinkedList;
    }

    public static <T> java.util.List<java.util.List<T>> partition(java.util.List<T> list, int i) {
        com.google.common.base.Preconditions.checkNotNull(list);
        com.google.common.base.Preconditions.checkArgument(i > 0);
        return list instanceof java.util.RandomAccess ? new com.google.common.collect.Lists.RandomAccessPartition(list, i) : new com.google.common.collect.Lists.Partition(list, i);
    }

    public static <T> java.util.List<T> reverse(java.util.List<T> list) {
        return list instanceof com.google.common.collect.ImmutableList ? ((com.google.common.collect.ImmutableList) list).reverse() : list instanceof com.google.common.collect.Lists.ReverseList ? ((com.google.common.collect.Lists.ReverseList) list).b() : list instanceof java.util.RandomAccess ? new com.google.common.collect.Lists.RandomAccessReverseList(list) : new com.google.common.collect.Lists.ReverseList(list);
    }

    public static <F, T> java.util.List<T> transform(java.util.List<F> list, com.google.common.base.Function<? super F, ? extends T> function) {
        return list instanceof java.util.RandomAccess ? new com.google.common.collect.Lists.TransformingRandomAccessList(list, function) : new com.google.common.collect.Lists.TransformingSequentialList(list, function);
    }
}
