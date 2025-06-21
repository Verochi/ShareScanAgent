package com.google.common.collect;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class ConcurrentHashMultiset<E> extends com.google.common.collect.AbstractMultiset<E> implements java.io.Serializable {
    private static final long serialVersionUID = 1;
    private final transient java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> countMap;

    /* renamed from: com.google.common.collect.ConcurrentHashMultiset$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.collect.ForwardingSet<E> {
        public final /* synthetic */ java.util.Set n;

        public AnonymousClass1(java.util.Set set) {
            this.n = set;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return obj != null && com.google.common.collect.Collections2.g(this.n, obj);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean containsAll(java.util.Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public java.util.Set<E> delegate() {
            return this.n;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            return obj != null && com.google.common.collect.Collections2.h(this.n, obj);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(java.util.Collection<?> collection) {
            return standardRemoveAll(collection);
        }
    }

    /* renamed from: com.google.common.collect.ConcurrentHashMultiset$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.common.collect.AbstractIterator<com.google.common.collect.Multiset.Entry<E>> {
        public final java.util.Iterator<java.util.Map.Entry<E, java.util.concurrent.atomic.AtomicInteger>> u;

        public AnonymousClass2() {
            this.u = com.google.common.collect.ConcurrentHashMultiset.this.countMap.entrySet().iterator();
        }

        @Override // com.google.common.collect.AbstractIterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.Multiset.Entry<E> computeNext() {
            while (this.u.hasNext()) {
                java.util.Map.Entry<E, java.util.concurrent.atomic.AtomicInteger> next = this.u.next();
                int i = next.getValue().get();
                if (i != 0) {
                    return com.google.common.collect.Multisets.immutableEntry(next.getKey(), i);
                }
            }
            return endOfData();
        }
    }

    /* renamed from: com.google.common.collect.ConcurrentHashMultiset$3, reason: invalid class name */
    public class AnonymousClass3 extends com.google.common.collect.ForwardingIterator<com.google.common.collect.Multiset.Entry<E>> {

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.Multiset.Entry<E> n;
        public final /* synthetic */ java.util.Iterator t;

        public AnonymousClass3(java.util.Iterator it) {
            this.t = it;
        }

        @Override // com.google.common.collect.ForwardingIterator, com.google.common.collect.ForwardingObject
        public java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> delegate() {
            return this.t;
        }

        @Override // com.google.common.collect.ForwardingIterator, java.util.Iterator
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.Multiset.Entry<E> next() {
            com.google.common.collect.Multiset.Entry<E> entry = (com.google.common.collect.Multiset.Entry) super.next();
            this.n = entry;
            return entry;
        }

        @Override // com.google.common.collect.ForwardingIterator, java.util.Iterator
        public void remove() {
            com.google.common.collect.CollectPreconditions.e(this.n != null);
            com.google.common.collect.ConcurrentHashMultiset.this.setCount(this.n.getElement(), 0);
            this.n = null;
        }
    }

    public class EntrySet extends com.google.common.collect.AbstractMultiset<E>.EntrySet {
        public EntrySet() {
            super();
        }

        public /* synthetic */ EntrySet(com.google.common.collect.ConcurrentHashMultiset concurrentHashMultiset, com.google.common.collect.ConcurrentHashMultiset.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.collect.AbstractMultiset.EntrySet, com.google.common.collect.Multisets.EntrySet
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.ConcurrentHashMultiset<E> a() {
            return com.google.common.collect.ConcurrentHashMultiset.this;
        }

        public final java.util.List<com.google.common.collect.Multiset.Entry<E>> c() {
            java.util.ArrayList newArrayListWithExpectedSize = com.google.common.collect.Lists.newArrayListWithExpectedSize(size());
            com.google.common.collect.Iterators.addAll(newArrayListWithExpectedSize, iterator());
            return newArrayListWithExpectedSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public java.lang.Object[] toArray() {
            return c().toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) c().toArray(tArr);
        }
    }

    public static class FieldSettersHolder {
        public static final com.google.common.collect.Serialization.FieldSetter<com.google.common.collect.ConcurrentHashMultiset> a = com.google.common.collect.Serialization.a(com.google.common.collect.ConcurrentHashMultiset.class, "countMap");
    }

    @com.google.common.annotations.VisibleForTesting
    public ConcurrentHashMultiset(java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> concurrentMap) {
        com.google.common.base.Preconditions.checkArgument(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.countMap = concurrentMap;
    }

    public static <E> com.google.common.collect.ConcurrentHashMultiset<E> create() {
        return new com.google.common.collect.ConcurrentHashMultiset<>(new java.util.concurrent.ConcurrentHashMap());
    }

    public static <E> com.google.common.collect.ConcurrentHashMultiset<E> create(java.lang.Iterable<? extends E> iterable) {
        com.google.common.collect.ConcurrentHashMultiset<E> create = create();
        com.google.common.collect.Iterables.addAll(create, iterable);
        return create;
    }

    @com.google.common.annotations.Beta
    public static <E> com.google.common.collect.ConcurrentHashMultiset<E> create(java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> concurrentMap) {
        return new com.google.common.collect.ConcurrentHashMultiset<>(concurrentMap);
    }

    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        objectInputStream.defaultReadObject();
        com.google.common.collect.ConcurrentHashMultiset.FieldSettersHolder.a.b(this, (java.util.concurrent.ConcurrentMap) objectInputStream.readObject());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private java.util.List<E> snapshot() {
        java.util.ArrayList newArrayListWithExpectedSize = com.google.common.collect.Lists.newArrayListWithExpectedSize(size());
        for (com.google.common.collect.Multiset.Entry entry : entrySet()) {
            java.lang.Object element = entry.getElement();
            for (int count = entry.getCount(); count > 0; count--) {
                newArrayListWithExpectedSize.add(element);
            }
        }
        return newArrayListWithExpectedSize;
    }

    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.countMap);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int add(E e, int i) {
        java.util.concurrent.atomic.AtomicInteger atomicInteger;
        int i2;
        java.util.concurrent.atomic.AtomicInteger atomicInteger2;
        com.google.common.base.Preconditions.checkNotNull(e);
        if (i == 0) {
            return count(e);
        }
        com.google.common.collect.CollectPreconditions.d(i, "occurences");
        do {
            atomicInteger = (java.util.concurrent.atomic.AtomicInteger) com.google.common.collect.Maps.G(this.countMap, e);
            if (atomicInteger == null && (atomicInteger = this.countMap.putIfAbsent(e, new java.util.concurrent.atomic.AtomicInteger(i))) == null) {
                return 0;
            }
            do {
                i2 = atomicInteger.get();
                if (i2 == 0) {
                    atomicInteger2 = new java.util.concurrent.atomic.AtomicInteger(i);
                    if (this.countMap.putIfAbsent(e, atomicInteger2) == null) {
                        break;
                    }
                } else {
                    try {
                    } catch (java.lang.ArithmeticException unused) {
                        throw new java.lang.IllegalArgumentException("Overflow adding " + i + " occurrences to a count of " + i2);
                    }
                }
            } while (!atomicInteger.compareAndSet(i2, com.google.common.math.IntMath.checkedAdd(i2, i)));
            return i2;
        } while (!this.countMap.replace(e, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.countMap.clear();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        java.util.concurrent.atomic.AtomicInteger atomicInteger = (java.util.concurrent.atomic.AtomicInteger) com.google.common.collect.Maps.G(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public java.util.Set<E> createElementSet() {
        return new com.google.common.collect.ConcurrentHashMultiset.AnonymousClass1(this.countMap.keySet());
    }

    @Override // com.google.common.collect.AbstractMultiset
    @java.lang.Deprecated
    public java.util.Set<com.google.common.collect.Multiset.Entry<E>> createEntrySet() {
        return new com.google.common.collect.ConcurrentHashMultiset.EntrySet(this, null);
    }

    @Override // com.google.common.collect.AbstractMultiset
    public int distinctElements() {
        return this.countMap.size();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public java.util.Iterator<E> elementIterator() {
        throw new java.lang.AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ java.util.Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> entryIterator() {
        return new com.google.common.collect.ConcurrentHashMultiset.AnonymousClass3(new com.google.common.collect.ConcurrentHashMultiset.AnonymousClass2());
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ java.util.Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public java.util.Iterator<E> iterator() {
        return com.google.common.collect.Multisets.h(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, int i) {
        int i2;
        int max;
        if (i == 0) {
            return count(obj);
        }
        com.google.common.collect.CollectPreconditions.d(i, "occurences");
        java.util.concurrent.atomic.AtomicInteger atomicInteger = (java.util.concurrent.atomic.AtomicInteger) com.google.common.collect.Maps.G(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 == 0) {
                return 0;
            }
            max = java.lang.Math.max(0, i2 - i);
        } while (!atomicInteger.compareAndSet(i2, max));
        if (max == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return i2;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean removeExactly(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, int i) {
        int i2;
        int i3;
        if (i == 0) {
            return true;
        }
        com.google.common.collect.CollectPreconditions.d(i, "occurences");
        java.util.concurrent.atomic.AtomicInteger atomicInteger = (java.util.concurrent.atomic.AtomicInteger) com.google.common.collect.Maps.G(this.countMap, obj);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 < i) {
                return false;
            }
            i3 = i2 - i;
        } while (!atomicInteger.compareAndSet(i2, i3));
        if (i3 == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return true;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int setCount(E e, int i) {
        java.util.concurrent.atomic.AtomicInteger atomicInteger;
        int i2;
        java.util.concurrent.atomic.AtomicInteger atomicInteger2;
        com.google.common.base.Preconditions.checkNotNull(e);
        com.google.common.collect.CollectPreconditions.b(i, me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT);
        do {
            atomicInteger = (java.util.concurrent.atomic.AtomicInteger) com.google.common.collect.Maps.G(this.countMap, e);
            if (atomicInteger == null && (i == 0 || (atomicInteger = this.countMap.putIfAbsent(e, new java.util.concurrent.atomic.AtomicInteger(i))) == null)) {
                return 0;
            }
            do {
                i2 = atomicInteger.get();
                if (i2 == 0) {
                    if (i != 0) {
                        atomicInteger2 = new java.util.concurrent.atomic.AtomicInteger(i);
                        if (this.countMap.putIfAbsent(e, atomicInteger2) == null) {
                            break;
                        }
                    } else {
                        return 0;
                    }
                }
            } while (!atomicInteger.compareAndSet(i2, i));
            if (i == 0) {
                this.countMap.remove(e, atomicInteger);
            }
            return i2;
        } while (!this.countMap.replace(e, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean setCount(E e, int i, int i2) {
        com.google.common.base.Preconditions.checkNotNull(e);
        com.google.common.collect.CollectPreconditions.b(i, "oldCount");
        com.google.common.collect.CollectPreconditions.b(i2, "newCount");
        java.util.concurrent.atomic.AtomicInteger atomicInteger = (java.util.concurrent.atomic.AtomicInteger) com.google.common.collect.Maps.G(this.countMap, e);
        if (atomicInteger == null) {
            if (i != 0) {
                return false;
            }
            return i2 == 0 || this.countMap.putIfAbsent(e, new java.util.concurrent.atomic.AtomicInteger(i2)) == null;
        }
        int i3 = atomicInteger.get();
        if (i3 == i) {
            if (i3 == 0) {
                if (i2 == 0) {
                    this.countMap.remove(e, atomicInteger);
                    return true;
                }
                java.util.concurrent.atomic.AtomicInteger atomicInteger2 = new java.util.concurrent.atomic.AtomicInteger(i2);
                return this.countMap.putIfAbsent(e, atomicInteger2) == null || this.countMap.replace(e, atomicInteger, atomicInteger2);
            }
            if (atomicInteger.compareAndSet(i3, i2)) {
                if (i2 == 0) {
                    this.countMap.remove(e, atomicInteger);
                }
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        long j = 0;
        while (this.countMap.values().iterator().hasNext()) {
            j += r0.next().get();
        }
        return com.google.common.primitives.Ints.saturatedCast(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public java.lang.Object[] toArray() {
        return snapshot().toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) snapshot().toArray(tArr);
    }
}
