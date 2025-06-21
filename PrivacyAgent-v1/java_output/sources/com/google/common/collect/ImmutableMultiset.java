package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes22.dex */
public abstract class ImmutableMultiset<E> extends com.google.common.collect.ImmutableMultisetGwtSerializationDependencies<E> implements com.google.common.collect.Multiset<E> {

    @com.google.errorprone.annotations.concurrent.LazyInit
    private transient com.google.common.collect.ImmutableList<E> asList;

    @com.google.errorprone.annotations.concurrent.LazyInit
    private transient com.google.common.collect.ImmutableSet<com.google.common.collect.Multiset.Entry<E>> entrySet;

    /* renamed from: com.google.common.collect.ImmutableMultiset$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.collect.UnmodifiableIterator<E> {
        public int n;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public E t;
        public final /* synthetic */ java.util.Iterator u;

        public AnonymousClass1(java.util.Iterator it) {
            this.u = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n > 0 || this.u.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.n <= 0) {
                com.google.common.collect.Multiset.Entry entry = (com.google.common.collect.Multiset.Entry) this.u.next();
                this.t = (E) entry.getElement();
                this.n = entry.getCount();
            }
            this.n--;
            return this.t;
        }
    }

    public static class Builder<E> extends com.google.common.collect.ImmutableCollection.Builder<E> {
        public com.google.common.collect.ObjectCountHashMap<E> a;
        public boolean b;
        public boolean c;

        public Builder() {
            this(4);
        }

        public Builder(int i) {
            this.b = false;
            this.c = false;
            this.a = com.google.common.collect.ObjectCountHashMap.c(i);
        }

        public Builder(boolean z) {
            this.b = false;
            this.c = false;
            this.a = null;
        }

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public static <T> com.google.common.collect.ObjectCountHashMap<T> b(java.lang.Iterable<T> iterable) {
            if (iterable instanceof com.google.common.collect.RegularImmutableMultiset) {
                return ((com.google.common.collect.RegularImmutableMultiset) iterable).contents;
            }
            if (iterable instanceof com.google.common.collect.AbstractMapBasedMultiset) {
                return ((com.google.common.collect.AbstractMapBasedMultiset) iterable).backingMap;
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ com.google.common.collect.ImmutableCollection.Builder add(java.lang.Object obj) {
            return add((com.google.common.collect.ImmutableMultiset.Builder<E>) obj);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableMultiset.Builder<E> add(E e) {
            return addCopies(e, 1);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableMultiset.Builder<E> add(E... eArr) {
            super.add((java.lang.Object[]) eArr);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableMultiset.Builder<E> addAll(java.lang.Iterable<? extends E> iterable) {
            if (iterable instanceof com.google.common.collect.Multiset) {
                com.google.common.collect.Multiset d = com.google.common.collect.Multisets.d(iterable);
                com.google.common.collect.ObjectCountHashMap b = b(d);
                if (b != null) {
                    com.google.common.collect.ObjectCountHashMap<E> objectCountHashMap = this.a;
                    objectCountHashMap.d(java.lang.Math.max(objectCountHashMap.C(), b.C()));
                    for (int e = b.e(); e >= 0; e = b.s(e)) {
                        addCopies(b.i(e), b.k(e));
                    }
                } else {
                    java.util.Set<com.google.common.collect.Multiset.Entry<E>> entrySet = d.entrySet();
                    com.google.common.collect.ObjectCountHashMap<E> objectCountHashMap2 = this.a;
                    objectCountHashMap2.d(java.lang.Math.max(objectCountHashMap2.C(), entrySet.size()));
                    for (com.google.common.collect.Multiset.Entry<E> entry : d.entrySet()) {
                        addCopies(entry.getElement(), entry.getCount());
                    }
                }
            } else {
                super.addAll((java.lang.Iterable) iterable);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableMultiset.Builder<E> addAll(java.util.Iterator<? extends E> it) {
            super.addAll((java.util.Iterator) it);
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableMultiset.Builder<E> addCopies(E e, int i) {
            if (i == 0) {
                return this;
            }
            if (this.b) {
                this.a = new com.google.common.collect.ObjectCountHashMap<>(this.a);
                this.c = false;
            }
            this.b = false;
            com.google.common.base.Preconditions.checkNotNull(e);
            com.google.common.collect.ObjectCountHashMap<E> objectCountHashMap = this.a;
            objectCountHashMap.u(e, i + objectCountHashMap.f(e));
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public com.google.common.collect.ImmutableMultiset<E> build() {
            if (this.a.C() == 0) {
                return com.google.common.collect.ImmutableMultiset.of();
            }
            if (this.c) {
                this.a = new com.google.common.collect.ObjectCountHashMap<>(this.a);
                this.c = false;
            }
            this.b = true;
            return new com.google.common.collect.RegularImmutableMultiset(this.a);
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableMultiset.Builder<E> setCount(E e, int i) {
            if (i == 0 && !this.c) {
                this.a = new com.google.common.collect.ObjectCountLinkedHashMap(this.a);
                this.c = true;
            } else if (this.b) {
                this.a = new com.google.common.collect.ObjectCountHashMap<>(this.a);
                this.c = false;
            }
            this.b = false;
            com.google.common.base.Preconditions.checkNotNull(e);
            if (i == 0) {
                this.a.v(e);
            } else {
                this.a.u(com.google.common.base.Preconditions.checkNotNull(e), i);
            }
            return this;
        }
    }

    public final class EntrySet extends com.google.common.collect.IndexedImmutableSet<com.google.common.collect.Multiset.Entry<E>> {
        private static final long serialVersionUID = 0;

        private EntrySet() {
        }

        public /* synthetic */ EntrySet(com.google.common.collect.ImmutableMultiset immutableMultiset, com.google.common.collect.ImmutableMultiset.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            if (!(obj instanceof com.google.common.collect.Multiset.Entry)) {
                return false;
            }
            com.google.common.collect.Multiset.Entry entry = (com.google.common.collect.Multiset.Entry) obj;
            return entry.getCount() > 0 && com.google.common.collect.ImmutableMultiset.this.count(entry.getElement()) == entry.getCount();
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public com.google.common.collect.Multiset.Entry<E> get(int i) {
            return com.google.common.collect.ImmutableMultiset.this.getEntry(i);
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return com.google.common.collect.ImmutableMultiset.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return com.google.common.collect.ImmutableMultiset.this.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.collect.ImmutableMultiset.this.elementSet().size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        @com.google.common.annotations.GwtIncompatible
        public java.lang.Object writeReplace() {
            return new com.google.common.collect.ImmutableMultiset.EntrySetSerializedForm(com.google.common.collect.ImmutableMultiset.this);
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static class EntrySetSerializedForm<E> implements java.io.Serializable {
        final com.google.common.collect.ImmutableMultiset<E> multiset;

        public EntrySetSerializedForm(com.google.common.collect.ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }

        public java.lang.Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    public static <E> com.google.common.collect.ImmutableMultiset.Builder<E> builder() {
        return new com.google.common.collect.ImmutableMultiset.Builder<>();
    }

    private static <E> com.google.common.collect.ImmutableMultiset<E> copyFromElements(E... eArr) {
        return new com.google.common.collect.ImmutableMultiset.Builder().add((java.lang.Object[]) eArr).build();
    }

    public static <E> com.google.common.collect.ImmutableMultiset<E> copyFromEntries(java.util.Collection<? extends com.google.common.collect.Multiset.Entry<? extends E>> collection) {
        com.google.common.collect.ImmutableMultiset.Builder builder = new com.google.common.collect.ImmutableMultiset.Builder(collection.size());
        for (com.google.common.collect.Multiset.Entry<? extends E> entry : collection) {
            builder.addCopies(entry.getElement(), entry.getCount());
        }
        return builder.build();
    }

    public static <E> com.google.common.collect.ImmutableMultiset<E> copyOf(java.lang.Iterable<? extends E> iterable) {
        if (iterable instanceof com.google.common.collect.ImmutableMultiset) {
            com.google.common.collect.ImmutableMultiset<E> immutableMultiset = (com.google.common.collect.ImmutableMultiset) iterable;
            if (!immutableMultiset.isPartialView()) {
                return immutableMultiset;
            }
        }
        com.google.common.collect.ImmutableMultiset.Builder builder = new com.google.common.collect.ImmutableMultiset.Builder(com.google.common.collect.Multisets.g(iterable));
        builder.addAll((java.lang.Iterable) iterable);
        return builder.build();
    }

    public static <E> com.google.common.collect.ImmutableMultiset<E> copyOf(java.util.Iterator<? extends E> it) {
        return new com.google.common.collect.ImmutableMultiset.Builder().addAll((java.util.Iterator) it).build();
    }

    public static <E> com.google.common.collect.ImmutableMultiset<E> copyOf(E[] eArr) {
        return copyFromElements(eArr);
    }

    private com.google.common.collect.ImmutableSet<com.google.common.collect.Multiset.Entry<E>> createEntrySet() {
        return isEmpty() ? com.google.common.collect.ImmutableSet.of() : new com.google.common.collect.ImmutableMultiset.EntrySet(this, null);
    }

    public static <E> com.google.common.collect.ImmutableMultiset<E> of() {
        return com.google.common.collect.RegularImmutableMultiset.EMPTY;
    }

    public static <E> com.google.common.collect.ImmutableMultiset<E> of(E e) {
        return copyFromElements(e);
    }

    public static <E> com.google.common.collect.ImmutableMultiset<E> of(E e, E e2) {
        return copyFromElements(e, e2);
    }

    public static <E> com.google.common.collect.ImmutableMultiset<E> of(E e, E e2, E e3) {
        return copyFromElements(e, e2, e3);
    }

    public static <E> com.google.common.collect.ImmutableMultiset<E> of(E e, E e2, E e3, E e4) {
        return copyFromElements(e, e2, e3, e4);
    }

    public static <E> com.google.common.collect.ImmutableMultiset<E> of(E e, E e2, E e3, E e4, E e5) {
        return copyFromElements(e, e2, e3, e4, e5);
    }

    public static <E> com.google.common.collect.ImmutableMultiset<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        return new com.google.common.collect.ImmutableMultiset.Builder().add((com.google.common.collect.ImmutableMultiset.Builder) e).add((com.google.common.collect.ImmutableMultiset.Builder<E>) e2).add((com.google.common.collect.ImmutableMultiset.Builder<E>) e3).add((com.google.common.collect.ImmutableMultiset.Builder<E>) e4).add((com.google.common.collect.ImmutableMultiset.Builder<E>) e5).add((com.google.common.collect.ImmutableMultiset.Builder<E>) e6).add((java.lang.Object[]) eArr).build();
    }

    @Override // com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public final int add(E e, int i) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public com.google.common.collect.ImmutableList<E> asList() {
        com.google.common.collect.ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        com.google.common.collect.ImmutableList<E> asList = super.asList();
        this.asList = asList;
        return asList;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return count(obj) > 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    @com.google.common.annotations.GwtIncompatible
    public int copyIntoArray(java.lang.Object[] objArr, int i) {
        com.google.common.collect.UnmodifiableIterator<com.google.common.collect.Multiset.Entry<E>> it = entrySet().iterator();
        while (it.hasNext()) {
            com.google.common.collect.Multiset.Entry<E> next = it.next();
            java.util.Arrays.fill(objArr, i, next.getCount() + i, next.getElement());
            i += next.getCount();
        }
        return i;
    }

    @Override // com.google.common.collect.Multiset
    public abstract com.google.common.collect.ImmutableSet<E> elementSet();

    @Override // com.google.common.collect.Multiset
    public com.google.common.collect.ImmutableSet<com.google.common.collect.Multiset.Entry<E>> entrySet() {
        com.google.common.collect.ImmutableSet<com.google.common.collect.Multiset.Entry<E>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        com.google.common.collect.ImmutableSet<com.google.common.collect.Multiset.Entry<E>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return com.google.common.collect.Multisets.f(this, obj);
    }

    public abstract com.google.common.collect.Multiset.Entry<E> getEntry(int i);

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return com.google.common.collect.Sets.b(entrySet());
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public com.google.common.collect.UnmodifiableIterator<E> iterator() {
        return new com.google.common.collect.ImmutableMultiset.AnonymousClass1(entrySet().iterator());
    }

    @Override // com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public final int remove(java.lang.Object obj, int i) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public final int setCount(E e, int i) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public final boolean setCount(E e, int i, int i2) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.Multiset
    public java.lang.String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ImmutableCollection
    @com.google.common.annotations.GwtIncompatible
    abstract java.lang.Object writeReplace();
}
