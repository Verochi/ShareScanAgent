package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class Iterators {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.Iterators$1, reason: invalid class name */
    public static class AnonymousClass1<T> extends com.google.common.collect.UnmodifiableIterator<T> {
        public final /* synthetic */ java.util.Iterator n;

        public AnonymousClass1(java.util.Iterator it) {
            this.n = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return (T) this.n.next();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.Iterators$10, reason: invalid class name */
    public static class AnonymousClass10<T> extends com.google.common.collect.UnmodifiableIterator<T> {
        public final /* synthetic */ java.util.Enumeration n;

        public AnonymousClass10(java.util.Enumeration enumeration) {
            this.n = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n.hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            return (T) this.n.nextElement();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.Iterators$11, reason: invalid class name */
    public static class AnonymousClass11<T> implements java.util.Enumeration<T> {
        public final /* synthetic */ java.util.Iterator a;

        public AnonymousClass11(java.util.Iterator it) {
            this.a = it;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.a.hasNext();
        }

        @Override // java.util.Enumeration
        public T nextElement() {
            return (T) this.a.next();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.Iterators$2, reason: invalid class name */
    public static class AnonymousClass2<T> implements java.util.Iterator<T> {
        public java.util.Iterator<T> n = com.google.common.collect.Iterators.h();
        public final /* synthetic */ java.lang.Iterable t;

        public AnonymousClass2(java.lang.Iterable iterable) {
            this.t = iterable;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n.hasNext() || this.t.iterator().hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.n.hasNext()) {
                java.util.Iterator<T> it = this.t.iterator();
                this.n = it;
                if (!it.hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
            }
            return this.n.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.n.remove();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.Iterators$3, reason: invalid class name */
    public static class AnonymousClass3<T> extends com.google.common.collect.UnmodifiableIterator<T> {
        public int n = 0;
        public final /* synthetic */ java.lang.Object[] t;

        public AnonymousClass3(java.lang.Object[] objArr) {
            this.t = objArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n < this.t.length;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            java.lang.Object[] objArr = this.t;
            int i = this.n;
            T t = (T) objArr[i];
            objArr[i] = null;
            this.n = i + 1;
            return t;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.Iterators$4, reason: invalid class name */
    public static class AnonymousClass4<T> extends com.google.common.collect.UnmodifiableIterator<java.util.List<T>> {
        public final /* synthetic */ java.util.Iterator n;
        public final /* synthetic */ int t;
        public final /* synthetic */ boolean u;

        public AnonymousClass4(java.util.Iterator it, int i, boolean z) {
            this.n = it;
            this.t = i;
            this.u = z;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.List<T> next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            java.lang.Object[] objArr = new java.lang.Object[this.t];
            int i = 0;
            while (i < this.t && this.n.hasNext()) {
                objArr[i] = this.n.next();
                i++;
            }
            for (int i2 = i; i2 < this.t; i2++) {
                objArr[i2] = null;
            }
            java.util.List<T> unmodifiableList = java.util.Collections.unmodifiableList(java.util.Arrays.asList(objArr));
            return (this.u || i == this.t) ? unmodifiableList : unmodifiableList.subList(0, i);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n.hasNext();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.Iterators$5, reason: invalid class name */
    public static class AnonymousClass5<T> extends com.google.common.collect.AbstractIterator<T> {
        public final /* synthetic */ java.util.Iterator u;
        public final /* synthetic */ com.google.common.base.Predicate v;

        public AnonymousClass5(java.util.Iterator it, com.google.common.base.Predicate predicate) {
            this.u = it;
            this.v = predicate;
        }

        @Override // com.google.common.collect.AbstractIterator
        public T computeNext() {
            while (this.u.hasNext()) {
                T t = (T) this.u.next();
                if (this.v.apply(t)) {
                    return t;
                }
            }
            return endOfData();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, F] */
    /* renamed from: com.google.common.collect.Iterators$6, reason: invalid class name */
    public static class AnonymousClass6<F, T> extends com.google.common.collect.TransformedIterator<F, T> {
        public final /* synthetic */ com.google.common.base.Function t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(java.util.Iterator it, com.google.common.base.Function function) {
            super(it);
            this.t = function;
        }

        @Override // com.google.common.collect.TransformedIterator
        public T a(F f) {
            return (T) this.t.apply(f);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.Iterators$7, reason: invalid class name */
    public static class AnonymousClass7<T> implements java.util.Iterator<T> {
        public int n;
        public final /* synthetic */ int t;
        public final /* synthetic */ java.util.Iterator u;

        public AnonymousClass7(int i, java.util.Iterator it) {
            this.t = i;
            this.u = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n < this.t && this.u.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            this.n++;
            return (T) this.u.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.u.remove();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.Iterators$8, reason: invalid class name */
    public static class AnonymousClass8<T> extends com.google.common.collect.UnmodifiableIterator<T> {
        public final /* synthetic */ java.util.Iterator n;

        public AnonymousClass8(java.util.Iterator it) {
            this.n = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            T t = (T) this.n.next();
            this.n.remove();
            return t;
        }

        public java.lang.String toString() {
            return "Iterators.consumingIterator(...)";
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.collect.Iterators$9, reason: invalid class name */
    public static class AnonymousClass9<T> extends com.google.common.collect.UnmodifiableIterator<T> {
        public boolean n;
        public final /* synthetic */ java.lang.Object t;

        public AnonymousClass9(java.lang.Object obj) {
            this.t = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.n;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.n) {
                throw new java.util.NoSuchElementException();
            }
            this.n = true;
            return (T) this.t;
        }
    }

    public static final class ArrayItr<T> extends com.google.common.collect.AbstractIndexedListIterator<T> {
        public static final com.google.common.collect.UnmodifiableListIterator<java.lang.Object> w = new com.google.common.collect.Iterators.ArrayItr(new java.lang.Object[0], 0, 0, 0);
        public final T[] u;
        public final int v;

        public ArrayItr(T[] tArr, int i, int i2, int i3) {
            super(i2, i3);
            this.u = tArr;
            this.v = i;
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        public T a(int i) {
            return this.u[this.v + i];
        }
    }

    public static class ConcatenatedIterator<T> implements java.util.Iterator<T> {

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public java.util.Iterator<? extends T> n;
        public java.util.Iterator<? extends T> t = com.google.common.collect.Iterators.f();
        public java.util.Iterator<? extends java.util.Iterator<? extends T>> u;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public java.util.Deque<java.util.Iterator<? extends java.util.Iterator<? extends T>>> v;

        public ConcatenatedIterator(java.util.Iterator<? extends java.util.Iterator<? extends T>> it) {
            this.u = (java.util.Iterator) com.google.common.base.Preconditions.checkNotNull(it);
        }

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final java.util.Iterator<? extends java.util.Iterator<? extends T>> a() {
            while (true) {
                java.util.Iterator<? extends java.util.Iterator<? extends T>> it = this.u;
                if (it != null && it.hasNext()) {
                    return this.u;
                }
                java.util.Deque<java.util.Iterator<? extends java.util.Iterator<? extends T>>> deque = this.v;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.u = this.v.removeFirst();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!((java.util.Iterator) com.google.common.base.Preconditions.checkNotNull(this.t)).hasNext()) {
                java.util.Iterator<? extends java.util.Iterator<? extends T>> a = a();
                this.u = a;
                if (a == null) {
                    return false;
                }
                java.util.Iterator<? extends T> next = a.next();
                this.t = next;
                if (next instanceof com.google.common.collect.Iterators.ConcatenatedIterator) {
                    com.google.common.collect.Iterators.ConcatenatedIterator concatenatedIterator = (com.google.common.collect.Iterators.ConcatenatedIterator) next;
                    this.t = concatenatedIterator.t;
                    if (this.v == null) {
                        this.v = new java.util.ArrayDeque();
                    }
                    this.v.addFirst(this.u);
                    if (concatenatedIterator.v != null) {
                        while (!concatenatedIterator.v.isEmpty()) {
                            this.v.addFirst(concatenatedIterator.v.removeLast());
                        }
                    }
                    this.u = concatenatedIterator.u;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            java.util.Iterator<? extends T> it = this.t;
            this.n = it;
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.collect.CollectPreconditions.e(this.n != null);
            this.n.remove();
            this.n = null;
        }
    }

    public enum EmptyModifiableIterator implements java.util.Iterator<java.lang.Object> {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public java.lang.Object next() {
            throw new java.util.NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.collect.CollectPreconditions.e(false);
        }
    }

    public static class MergingIterator<T> extends com.google.common.collect.UnmodifiableIterator<T> {
        public final java.util.Queue<com.google.common.collect.PeekingIterator<T>> n;

        /* renamed from: com.google.common.collect.Iterators$MergingIterator$1, reason: invalid class name */
        public class AnonymousClass1 implements java.util.Comparator<com.google.common.collect.PeekingIterator<T>> {
            public final /* synthetic */ java.util.Comparator n;

            public AnonymousClass1(java.util.Comparator comparator) {
                this.n = comparator;
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(com.google.common.collect.PeekingIterator<T> peekingIterator, com.google.common.collect.PeekingIterator<T> peekingIterator2) {
                return this.n.compare(peekingIterator.peek(), peekingIterator2.peek());
            }
        }

        public MergingIterator(java.lang.Iterable<? extends java.util.Iterator<? extends T>> iterable, java.util.Comparator<? super T> comparator) {
            this.n = new java.util.PriorityQueue(2, new com.google.common.collect.Iterators.MergingIterator.AnonymousClass1(comparator));
            for (java.util.Iterator<? extends T> it : iterable) {
                if (it.hasNext()) {
                    this.n.add(com.google.common.collect.Iterators.peekingIterator(it));
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.n.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            com.google.common.collect.PeekingIterator<T> remove = this.n.remove();
            T next = remove.next();
            if (remove.hasNext()) {
                this.n.add(remove);
            }
            return next;
        }
    }

    public static class PeekingImpl<E> implements com.google.common.collect.PeekingIterator<E> {
        public final java.util.Iterator<? extends E> n;
        public boolean t;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public E u;

        public PeekingImpl(java.util.Iterator<? extends E> it) {
            this.n = (java.util.Iterator) com.google.common.base.Preconditions.checkNotNull(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.t || this.n.hasNext();
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        public E next() {
            if (!this.t) {
                return this.n.next();
            }
            E e = this.u;
            this.t = false;
            this.u = null;
            return e;
        }

        @Override // com.google.common.collect.PeekingIterator
        public E peek() {
            if (!this.t) {
                this.u = this.n.next();
                this.t = true;
            }
            return this.u;
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        public void remove() {
            com.google.common.base.Preconditions.checkState(!this.t, "Can't remove after you've peeked at next");
            this.n.remove();
        }
    }

    public static <T> java.util.ListIterator<T> a(java.util.Iterator<T> it) {
        return (java.util.ListIterator) it;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <T> boolean addAll(java.util.Collection<T> collection, java.util.Iterator<? extends T> it) {
        com.google.common.base.Preconditions.checkNotNull(collection);
        com.google.common.base.Preconditions.checkNotNull(it);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static int advance(java.util.Iterator<?> it, int i) {
        com.google.common.base.Preconditions.checkNotNull(it);
        int i2 = 0;
        com.google.common.base.Preconditions.checkArgument(i >= 0, "numberToAdvance must be nonnegative");
        while (i2 < i && it.hasNext()) {
            it.next();
            i2++;
        }
        return i2;
    }

    public static <T> boolean all(java.util.Iterator<T> it, com.google.common.base.Predicate<? super T> predicate) {
        com.google.common.base.Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            if (!predicate.apply(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean any(java.util.Iterator<T> it, com.google.common.base.Predicate<? super T> predicate) {
        return indexOf(it, predicate) != -1;
    }

    public static <T> java.util.Enumeration<T> asEnumeration(java.util.Iterator<T> it) {
        com.google.common.base.Preconditions.checkNotNull(it);
        return new com.google.common.collect.Iterators.AnonymousClass11(it);
    }

    public static void b(int i) {
        if (i >= 0) {
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("position (" + i + ") must not be negative");
    }

    public static void c(java.util.Iterator<?> it) {
        com.google.common.base.Preconditions.checkNotNull(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> java.util.Iterator<T> concat(java.util.Iterator<? extends java.util.Iterator<? extends T>> it) {
        return new com.google.common.collect.Iterators.ConcatenatedIterator(it);
    }

    public static <T> java.util.Iterator<T> concat(java.util.Iterator<? extends T> it, java.util.Iterator<? extends T> it2) {
        com.google.common.base.Preconditions.checkNotNull(it);
        com.google.common.base.Preconditions.checkNotNull(it2);
        return concat(e(it, it2));
    }

    public static <T> java.util.Iterator<T> concat(java.util.Iterator<? extends T> it, java.util.Iterator<? extends T> it2, java.util.Iterator<? extends T> it3) {
        com.google.common.base.Preconditions.checkNotNull(it);
        com.google.common.base.Preconditions.checkNotNull(it2);
        com.google.common.base.Preconditions.checkNotNull(it3);
        return concat(e(it, it2, it3));
    }

    public static <T> java.util.Iterator<T> concat(java.util.Iterator<? extends T> it, java.util.Iterator<? extends T> it2, java.util.Iterator<? extends T> it3, java.util.Iterator<? extends T> it4) {
        com.google.common.base.Preconditions.checkNotNull(it);
        com.google.common.base.Preconditions.checkNotNull(it2);
        com.google.common.base.Preconditions.checkNotNull(it3);
        com.google.common.base.Preconditions.checkNotNull(it4);
        return concat(e(it, it2, it3, it4));
    }

    public static <T> java.util.Iterator<T> concat(java.util.Iterator<? extends T>... itArr) {
        return d((java.util.Iterator[]) java.util.Arrays.copyOf(itArr, itArr.length));
    }

    public static <T> java.util.Iterator<T> consumingIterator(java.util.Iterator<T> it) {
        com.google.common.base.Preconditions.checkNotNull(it);
        return new com.google.common.collect.Iterators.AnonymousClass8(it);
    }

    public static boolean contains(java.util.Iterator<?> it, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static <T> java.util.Iterator<T> cycle(java.lang.Iterable<T> iterable) {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        return new com.google.common.collect.Iterators.AnonymousClass2(iterable);
    }

    @java.lang.SafeVarargs
    public static <T> java.util.Iterator<T> cycle(T... tArr) {
        return cycle(com.google.common.collect.Lists.newArrayList(tArr));
    }

    public static <T> java.util.Iterator<T> d(java.util.Iterator<? extends T>... itArr) {
        for (java.util.Iterator it : (java.util.Iterator[]) com.google.common.base.Preconditions.checkNotNull(itArr)) {
            com.google.common.base.Preconditions.checkNotNull(it);
        }
        return concat(e(itArr));
    }

    public static <T> java.util.Iterator<T> e(T... tArr) {
        return new com.google.common.collect.Iterators.AnonymousClass3(tArr);
    }

    public static boolean elementsEqual(java.util.Iterator<?> it, java.util.Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !com.google.common.base.Objects.equal(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static <T> com.google.common.collect.UnmodifiableIterator<T> f() {
        return g();
    }

    public static <T> com.google.common.collect.UnmodifiableIterator<T> filter(java.util.Iterator<T> it, com.google.common.base.Predicate<? super T> predicate) {
        com.google.common.base.Preconditions.checkNotNull(it);
        com.google.common.base.Preconditions.checkNotNull(predicate);
        return new com.google.common.collect.Iterators.AnonymousClass5(it, predicate);
    }

    @com.google.common.annotations.GwtIncompatible
    public static <T> com.google.common.collect.UnmodifiableIterator<T> filter(java.util.Iterator<?> it, java.lang.Class<T> cls) {
        return filter(it, com.google.common.base.Predicates.instanceOf(cls));
    }

    public static <T> T find(java.util.Iterator<T> it, com.google.common.base.Predicate<? super T> predicate) {
        com.google.common.base.Preconditions.checkNotNull(it);
        com.google.common.base.Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        throw new java.util.NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static <T> T find(java.util.Iterator<? extends T> it, com.google.common.base.Predicate<? super T> predicate, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        com.google.common.base.Preconditions.checkNotNull(it);
        com.google.common.base.Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        return t;
    }

    @java.lang.SafeVarargs
    public static <T> com.google.common.collect.UnmodifiableIterator<T> forArray(T... tArr) {
        return i(tArr, 0, tArr.length, 0);
    }

    public static <T> com.google.common.collect.UnmodifiableIterator<T> forEnumeration(java.util.Enumeration<T> enumeration) {
        com.google.common.base.Preconditions.checkNotNull(enumeration);
        return new com.google.common.collect.Iterators.AnonymousClass10(enumeration);
    }

    public static int frequency(java.util.Iterator<?> it, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        int i = 0;
        while (contains(it, obj)) {
            i++;
        }
        return i;
    }

    public static <T> com.google.common.collect.UnmodifiableListIterator<T> g() {
        return (com.google.common.collect.UnmodifiableListIterator<T>) com.google.common.collect.Iterators.ArrayItr.w;
    }

    public static <T> T get(java.util.Iterator<T> it, int i) {
        b(i);
        int advance = advance(it, i);
        if (it.hasNext()) {
            return it.next();
        }
        throw new java.lang.IndexOutOfBoundsException("position (" + i + ") must be less than the number of elements that remained (" + advance + ")");
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static <T> T get(java.util.Iterator<? extends T> it, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        b(i);
        advance(it, i);
        return (T) getNext(it, t);
    }

    public static <T> T getLast(java.util.Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static <T> T getLast(java.util.Iterator<? extends T> it, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        return it.hasNext() ? (T) getLast(it) : t;
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static <T> T getNext(java.util.Iterator<? extends T> it, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        return it.hasNext() ? it.next() : t;
    }

    public static <T> T getOnlyElement(java.util.Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("expected one element but was: <");
        sb.append(next);
        for (int i = 0; i < 4 && it.hasNext(); i++) {
            sb.append(", ");
            sb.append(it.next());
        }
        if (it.hasNext()) {
            sb.append(", ...");
        }
        sb.append(kotlin.text.Typography.greater);
        throw new java.lang.IllegalArgumentException(sb.toString());
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static <T> T getOnlyElement(java.util.Iterator<? extends T> it, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        return it.hasNext() ? (T) getOnlyElement(it) : t;
    }

    public static <T> java.util.Iterator<T> h() {
        return com.google.common.collect.Iterators.EmptyModifiableIterator.INSTANCE;
    }

    public static <T> com.google.common.collect.UnmodifiableListIterator<T> i(T[] tArr, int i, int i2, int i3) {
        com.google.common.base.Preconditions.checkArgument(i2 >= 0);
        com.google.common.base.Preconditions.checkPositionIndexes(i, i + i2, tArr.length);
        com.google.common.base.Preconditions.checkPositionIndex(i3, i2);
        return i2 == 0 ? g() : new com.google.common.collect.Iterators.ArrayItr(tArr, i, i2, i3);
    }

    public static <T> int indexOf(java.util.Iterator<T> it, com.google.common.base.Predicate<? super T> predicate) {
        com.google.common.base.Preconditions.checkNotNull(predicate, "predicate");
        int i = 0;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static <T> com.google.common.collect.UnmodifiableIterator<java.util.List<T>> j(java.util.Iterator<T> it, int i, boolean z) {
        com.google.common.base.Preconditions.checkNotNull(it);
        com.google.common.base.Preconditions.checkArgument(i > 0);
        return new com.google.common.collect.Iterators.AnonymousClass4(it, i, z);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static <T> T k(java.util.Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    public static <T> java.util.Iterator<T> limit(java.util.Iterator<T> it, int i) {
        com.google.common.base.Preconditions.checkNotNull(it);
        com.google.common.base.Preconditions.checkArgument(i >= 0, "limit is negative");
        return new com.google.common.collect.Iterators.AnonymousClass7(i, it);
    }

    @com.google.common.annotations.Beta
    public static <T> com.google.common.collect.UnmodifiableIterator<T> mergeSorted(java.lang.Iterable<? extends java.util.Iterator<? extends T>> iterable, java.util.Comparator<? super T> comparator) {
        com.google.common.base.Preconditions.checkNotNull(iterable, "iterators");
        com.google.common.base.Preconditions.checkNotNull(comparator, "comparator");
        return new com.google.common.collect.Iterators.MergingIterator(iterable, comparator);
    }

    public static <T> com.google.common.collect.UnmodifiableIterator<java.util.List<T>> paddedPartition(java.util.Iterator<T> it, int i) {
        return j(it, i, true);
    }

    public static <T> com.google.common.collect.UnmodifiableIterator<java.util.List<T>> partition(java.util.Iterator<T> it, int i) {
        return j(it, i, false);
    }

    @java.lang.Deprecated
    public static <T> com.google.common.collect.PeekingIterator<T> peekingIterator(com.google.common.collect.PeekingIterator<T> peekingIterator) {
        return (com.google.common.collect.PeekingIterator) com.google.common.base.Preconditions.checkNotNull(peekingIterator);
    }

    public static <T> com.google.common.collect.PeekingIterator<T> peekingIterator(java.util.Iterator<? extends T> it) {
        return it instanceof com.google.common.collect.Iterators.PeekingImpl ? (com.google.common.collect.Iterators.PeekingImpl) it : new com.google.common.collect.Iterators.PeekingImpl(it);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static boolean removeAll(java.util.Iterator<?> it, java.util.Collection<?> collection) {
        com.google.common.base.Preconditions.checkNotNull(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <T> boolean removeIf(java.util.Iterator<T> it, com.google.common.base.Predicate<? super T> predicate) {
        com.google.common.base.Preconditions.checkNotNull(predicate);
        boolean z = false;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static boolean retainAll(java.util.Iterator<?> it, java.util.Collection<?> collection) {
        com.google.common.base.Preconditions.checkNotNull(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static <T> com.google.common.collect.UnmodifiableIterator<T> singletonIterator(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        return new com.google.common.collect.Iterators.AnonymousClass9(t);
    }

    public static int size(java.util.Iterator<?> it) {
        long j = 0;
        while (it.hasNext()) {
            it.next();
            j++;
        }
        return com.google.common.primitives.Ints.saturatedCast(j);
    }

    @com.google.common.annotations.GwtIncompatible
    public static <T> T[] toArray(java.util.Iterator<? extends T> it, java.lang.Class<T> cls) {
        return (T[]) com.google.common.collect.Iterables.toArray(com.google.common.collect.Lists.newArrayList(it), cls);
    }

    public static java.lang.String toString(java.util.Iterator<?> it) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append('[');
        boolean z = true;
        while (it.hasNext()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(it.next());
            z = false;
        }
        sb.append(']');
        return sb.toString();
    }

    public static <F, T> java.util.Iterator<T> transform(java.util.Iterator<F> it, com.google.common.base.Function<? super F, ? extends T> function) {
        com.google.common.base.Preconditions.checkNotNull(function);
        return new com.google.common.collect.Iterators.AnonymousClass6(it, function);
    }

    public static <T> com.google.common.base.Optional<T> tryFind(java.util.Iterator<T> it, com.google.common.base.Predicate<? super T> predicate) {
        com.google.common.base.Preconditions.checkNotNull(it);
        com.google.common.base.Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return com.google.common.base.Optional.of(next);
            }
        }
        return com.google.common.base.Optional.absent();
    }

    @java.lang.Deprecated
    public static <T> com.google.common.collect.UnmodifiableIterator<T> unmodifiableIterator(com.google.common.collect.UnmodifiableIterator<T> unmodifiableIterator) {
        return (com.google.common.collect.UnmodifiableIterator) com.google.common.base.Preconditions.checkNotNull(unmodifiableIterator);
    }

    public static <T> com.google.common.collect.UnmodifiableIterator<T> unmodifiableIterator(java.util.Iterator<? extends T> it) {
        com.google.common.base.Preconditions.checkNotNull(it);
        return it instanceof com.google.common.collect.UnmodifiableIterator ? (com.google.common.collect.UnmodifiableIterator) it : new com.google.common.collect.Iterators.AnonymousClass1(it);
    }
}
