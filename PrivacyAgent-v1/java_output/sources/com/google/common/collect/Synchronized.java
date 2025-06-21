package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
final class Synchronized {

    public static class SynchronizedAsMap<K, V> extends com.google.common.collect.Synchronized.SynchronizedMap<K, java.util.Collection<V>> {
        private static final long serialVersionUID = 0;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.Set<java.util.Map.Entry<K, java.util.Collection<V>>> asMapEntrySet;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.Collection<java.util.Collection<V>> asMapValues;

        public SynchronizedAsMap(java.util.Map<K, java.util.Collection<V>> map, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            super(map, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public boolean containsValue(java.lang.Object obj) {
            return values().contains(obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public java.util.Set<java.util.Map.Entry<K, java.util.Collection<V>>> entrySet() {
            java.util.Set<java.util.Map.Entry<K, java.util.Collection<V>>> set;
            synchronized (this.mutex) {
                if (this.asMapEntrySet == null) {
                    this.asMapEntrySet = new com.google.common.collect.Synchronized.SynchronizedAsMapEntries(delegate().entrySet(), this.mutex);
                }
                set = this.asMapEntrySet;
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public java.util.Collection<V> get(java.lang.Object obj) {
            java.util.Collection<V> A;
            synchronized (this.mutex) {
                java.util.Collection collection = (java.util.Collection) super.get(obj);
                A = collection == null ? null : com.google.common.collect.Synchronized.A(collection, this.mutex);
            }
            return A;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public java.util.Collection<java.util.Collection<V>> values() {
            java.util.Collection<java.util.Collection<V>> collection;
            synchronized (this.mutex) {
                if (this.asMapValues == null) {
                    this.asMapValues = new com.google.common.collect.Synchronized.SynchronizedAsMapValues(delegate().values(), this.mutex);
                }
                collection = this.asMapValues;
            }
            return collection;
        }
    }

    public static class SynchronizedAsMapEntries<K, V> extends com.google.common.collect.Synchronized.SynchronizedSet<java.util.Map.Entry<K, java.util.Collection<V>>> {
        private static final long serialVersionUID = 0;

        /* renamed from: com.google.common.collect.Synchronized$SynchronizedAsMapEntries$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.TransformedIterator<java.util.Map.Entry<K, java.util.Collection<V>>, java.util.Map.Entry<K, java.util.Collection<V>>> {

            /* renamed from: com.google.common.collect.Synchronized$SynchronizedAsMapEntries$1$1, reason: invalid class name and collision with other inner class name */
            public class C03481 extends com.google.common.collect.ForwardingMapEntry<K, java.util.Collection<V>> {
                public final /* synthetic */ java.util.Map.Entry n;

                public C03481(java.util.Map.Entry entry) {
                    this.n = entry;
                }

                @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
                public java.util.Map.Entry<K, java.util.Collection<V>> delegate() {
                    return this.n;
                }

                @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                /* renamed from: k, reason: merged with bridge method [inline-methods] */
                public java.util.Collection<V> getValue() {
                    return com.google.common.collect.Synchronized.A((java.util.Collection) this.n.getValue(), com.google.common.collect.Synchronized.SynchronizedAsMapEntries.this.mutex);
                }
            }

            public AnonymousClass1(java.util.Iterator it) {
                super(it);
            }

            @Override // com.google.common.collect.TransformedIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public java.util.Map.Entry<K, java.util.Collection<V>> a(java.util.Map.Entry<K, java.util.Collection<V>> entry) {
                return new com.google.common.collect.Synchronized.SynchronizedAsMapEntries.AnonymousClass1.C03481(entry);
            }
        }

        public SynchronizedAsMapEntries(java.util.Set<java.util.Map.Entry<K, java.util.Collection<V>>> set, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            super(set, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            boolean l;
            synchronized (this.mutex) {
                l = com.google.common.collect.Maps.l(delegate(), obj);
            }
            return l;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean containsAll(java.util.Collection<?> collection) {
            boolean c;
            synchronized (this.mutex) {
                c = com.google.common.collect.Collections2.c(delegate(), collection);
            }
            return c;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, java.util.Collection, java.util.Set
        public boolean equals(java.lang.Object obj) {
            boolean a;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                a = com.google.common.collect.Sets.a(delegate(), obj);
            }
            return a;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<java.util.Map.Entry<K, java.util.Collection<V>>> iterator() {
            return new com.google.common.collect.Synchronized.SynchronizedAsMapEntries.AnonymousClass1(super.iterator());
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            boolean B;
            synchronized (this.mutex) {
                B = com.google.common.collect.Maps.B(delegate(), obj);
            }
            return B;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean removeAll(java.util.Collection<?> collection) {
            boolean removeAll;
            synchronized (this.mutex) {
                removeAll = com.google.common.collect.Iterators.removeAll(delegate().iterator(), collection);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean retainAll(java.util.Collection<?> collection) {
            boolean retainAll;
            synchronized (this.mutex) {
                retainAll = com.google.common.collect.Iterators.retainAll(delegate().iterator(), collection);
            }
            return retainAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public java.lang.Object[] toArray() {
            java.lang.Object[] e;
            synchronized (this.mutex) {
                e = com.google.common.collect.ObjectArrays.e(delegate());
            }
            return e;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.mutex) {
                tArr2 = (T[]) com.google.common.collect.ObjectArrays.f(delegate(), tArr);
            }
            return tArr2;
        }
    }

    public static class SynchronizedAsMapValues<V> extends com.google.common.collect.Synchronized.SynchronizedCollection<java.util.Collection<V>> {
        private static final long serialVersionUID = 0;

        /* renamed from: com.google.common.collect.Synchronized$SynchronizedAsMapValues$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.TransformedIterator<java.util.Collection<V>, java.util.Collection<V>> {
            public AnonymousClass1(java.util.Iterator it) {
                super(it);
            }

            @Override // com.google.common.collect.TransformedIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public java.util.Collection<V> a(java.util.Collection<V> collection) {
                return com.google.common.collect.Synchronized.A(collection, com.google.common.collect.Synchronized.SynchronizedAsMapValues.this.mutex);
            }
        }

        public SynchronizedAsMapValues(java.util.Collection<java.util.Collection<V>> collection, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            super(collection, obj, null);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<java.util.Collection<V>> iterator() {
            return new com.google.common.collect.Synchronized.SynchronizedAsMapValues.AnonymousClass1(super.iterator());
        }
    }

    @com.google.common.annotations.VisibleForTesting
    public static class SynchronizedBiMap<K, V> extends com.google.common.collect.Synchronized.SynchronizedMap<K, V> implements com.google.common.collect.BiMap<K, V> {
        private static final long serialVersionUID = 0;

        @com.google.j2objc.annotations.RetainedWith
        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        private transient com.google.common.collect.BiMap<V, K> inverse;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        private transient java.util.Set<V> valueSet;

        private SynchronizedBiMap(com.google.common.collect.BiMap<K, V> biMap, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.BiMap<V, K> biMap2) {
            super(biMap, obj);
            this.inverse = biMap2;
        }

        public /* synthetic */ SynchronizedBiMap(com.google.common.collect.BiMap biMap, java.lang.Object obj, com.google.common.collect.BiMap biMap2, com.google.common.collect.Synchronized.AnonymousClass1 anonymousClass1) {
            this(biMap, obj, biMap2);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public com.google.common.collect.BiMap<K, V> delegate() {
            return (com.google.common.collect.BiMap) super.delegate();
        }

        @Override // com.google.common.collect.BiMap
        public V forcePut(K k, V v) {
            V forcePut;
            synchronized (this.mutex) {
                forcePut = delegate().forcePut(k, v);
            }
            return forcePut;
        }

        @Override // com.google.common.collect.BiMap
        public com.google.common.collect.BiMap<V, K> inverse() {
            com.google.common.collect.BiMap<V, K> biMap;
            synchronized (this.mutex) {
                if (this.inverse == null) {
                    this.inverse = new com.google.common.collect.Synchronized.SynchronizedBiMap(delegate().inverse(), this.mutex, this);
                }
                biMap = this.inverse;
            }
            return biMap;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public java.util.Set<V> values() {
            java.util.Set<V> set;
            synchronized (this.mutex) {
                if (this.valueSet == null) {
                    this.valueSet = com.google.common.collect.Synchronized.u(delegate().values(), this.mutex);
                }
                set = this.valueSet;
            }
            return set;
        }
    }

    @com.google.common.annotations.VisibleForTesting
    public static class SynchronizedCollection<E> extends com.google.common.collect.Synchronized.SynchronizedObject implements java.util.Collection<E> {
        private static final long serialVersionUID = 0;

        private SynchronizedCollection(java.util.Collection<E> collection, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            super(collection, obj);
        }

        public /* synthetic */ SynchronizedCollection(java.util.Collection collection, java.lang.Object obj, com.google.common.collect.Synchronized.AnonymousClass1 anonymousClass1) {
            this(collection, obj);
        }

        @Override // java.util.Collection
        public boolean add(E e) {
            boolean add;
            synchronized (this.mutex) {
                add = delegate().add(e);
            }
            return add;
        }

        @Override // java.util.Collection
        public boolean addAll(java.util.Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = delegate().addAll(collection);
            }
            return addAll;
        }

        @Override // java.util.Collection
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        public boolean contains(java.lang.Object obj) {
            boolean contains;
            synchronized (this.mutex) {
                contains = delegate().contains(obj);
            }
            return contains;
        }

        public boolean containsAll(java.util.Collection<?> collection) {
            boolean containsAll;
            synchronized (this.mutex) {
                containsAll = delegate().containsAll(collection);
            }
            return containsAll;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public java.util.Collection<E> delegate() {
            return (java.util.Collection) super.delegate();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        public java.util.Iterator<E> iterator() {
            return delegate().iterator();
        }

        public boolean remove(java.lang.Object obj) {
            boolean remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj);
            }
            return remove;
        }

        public boolean removeAll(java.util.Collection<?> collection) {
            boolean removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(collection);
            }
            return removeAll;
        }

        public boolean retainAll(java.util.Collection<?> collection) {
            boolean retainAll;
            synchronized (this.mutex) {
                retainAll = delegate().retainAll(collection);
            }
            return retainAll;
        }

        @Override // java.util.Collection
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        public java.lang.Object[] toArray() {
            java.lang.Object[] array;
            synchronized (this.mutex) {
                array = delegate().toArray();
            }
            return array;
        }

        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.mutex) {
                tArr2 = (T[]) delegate().toArray(tArr);
            }
            return tArr2;
        }
    }

    public static final class SynchronizedDeque<E> extends com.google.common.collect.Synchronized.SynchronizedQueue<E> implements java.util.Deque<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedDeque(java.util.Deque<E> deque, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            super(deque, obj);
        }

        @Override // java.util.Deque
        public void addFirst(E e) {
            synchronized (this.mutex) {
                delegate().addFirst(e);
            }
        }

        @Override // java.util.Deque
        public void addLast(E e) {
            synchronized (this.mutex) {
                delegate().addLast(e);
            }
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public java.util.Deque<E> delegate() {
            return (java.util.Deque) super.delegate();
        }

        @Override // java.util.Deque
        public java.util.Iterator<E> descendingIterator() {
            java.util.Iterator<E> descendingIterator;
            synchronized (this.mutex) {
                descendingIterator = delegate().descendingIterator();
            }
            return descendingIterator;
        }

        @Override // java.util.Deque
        public E getFirst() {
            E first;
            synchronized (this.mutex) {
                first = delegate().getFirst();
            }
            return first;
        }

        @Override // java.util.Deque
        public E getLast() {
            E last;
            synchronized (this.mutex) {
                last = delegate().getLast();
            }
            return last;
        }

        @Override // java.util.Deque
        public boolean offerFirst(E e) {
            boolean offerFirst;
            synchronized (this.mutex) {
                offerFirst = delegate().offerFirst(e);
            }
            return offerFirst;
        }

        @Override // java.util.Deque
        public boolean offerLast(E e) {
            boolean offerLast;
            synchronized (this.mutex) {
                offerLast = delegate().offerLast(e);
            }
            return offerLast;
        }

        @Override // java.util.Deque
        public E peekFirst() {
            E peekFirst;
            synchronized (this.mutex) {
                peekFirst = delegate().peekFirst();
            }
            return peekFirst;
        }

        @Override // java.util.Deque
        public E peekLast() {
            E peekLast;
            synchronized (this.mutex) {
                peekLast = delegate().peekLast();
            }
            return peekLast;
        }

        @Override // java.util.Deque
        public E pollFirst() {
            E pollFirst;
            synchronized (this.mutex) {
                pollFirst = delegate().pollFirst();
            }
            return pollFirst;
        }

        @Override // java.util.Deque
        public E pollLast() {
            E pollLast;
            synchronized (this.mutex) {
                pollLast = delegate().pollLast();
            }
            return pollLast;
        }

        @Override // java.util.Deque
        public E pop() {
            E pop;
            synchronized (this.mutex) {
                pop = delegate().pop();
            }
            return pop;
        }

        @Override // java.util.Deque
        public void push(E e) {
            synchronized (this.mutex) {
                delegate().push(e);
            }
        }

        @Override // java.util.Deque
        public E removeFirst() {
            E removeFirst;
            synchronized (this.mutex) {
                removeFirst = delegate().removeFirst();
            }
            return removeFirst;
        }

        @Override // java.util.Deque
        public boolean removeFirstOccurrence(java.lang.Object obj) {
            boolean removeFirstOccurrence;
            synchronized (this.mutex) {
                removeFirstOccurrence = delegate().removeFirstOccurrence(obj);
            }
            return removeFirstOccurrence;
        }

        @Override // java.util.Deque
        public E removeLast() {
            E removeLast;
            synchronized (this.mutex) {
                removeLast = delegate().removeLast();
            }
            return removeLast;
        }

        @Override // java.util.Deque
        public boolean removeLastOccurrence(java.lang.Object obj) {
            boolean removeLastOccurrence;
            synchronized (this.mutex) {
                removeLastOccurrence = delegate().removeLastOccurrence(obj);
            }
            return removeLastOccurrence;
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static class SynchronizedEntry<K, V> extends com.google.common.collect.Synchronized.SynchronizedObject implements java.util.Map.Entry<K, V> {
        private static final long serialVersionUID = 0;

        public SynchronizedEntry(java.util.Map.Entry<K, V> entry, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            super(entry, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public java.util.Map.Entry<K, V> delegate() {
            return (java.util.Map.Entry) super.delegate();
        }

        @Override // java.util.Map.Entry
        public boolean equals(java.lang.Object obj) {
            boolean equals;
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            K key;
            synchronized (this.mutex) {
                key = delegate().getKey();
            }
            return key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            V value;
            synchronized (this.mutex) {
                value = delegate().getValue();
            }
            return value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V value;
            synchronized (this.mutex) {
                value = delegate().setValue(v);
            }
            return value;
        }
    }

    public static class SynchronizedList<E> extends com.google.common.collect.Synchronized.SynchronizedCollection<E> implements java.util.List<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedList(java.util.List<E> list, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            super(list, obj, null);
        }

        @Override // java.util.List
        public void add(int i, E e) {
            synchronized (this.mutex) {
                delegate().add(i, e);
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, java.util.Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = delegate().addAll(i, collection);
            }
            return addAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public java.util.List<E> delegate() {
            return (java.util.List) super.delegate();
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(java.lang.Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.List
        public E get(int i) {
            E e;
            synchronized (this.mutex) {
                e = delegate().get(i);
            }
            return e;
        }

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.List
        public int indexOf(java.lang.Object obj) {
            int indexOf;
            synchronized (this.mutex) {
                indexOf = delegate().indexOf(obj);
            }
            return indexOf;
        }

        @Override // java.util.List
        public int lastIndexOf(java.lang.Object obj) {
            int lastIndexOf;
            synchronized (this.mutex) {
                lastIndexOf = delegate().lastIndexOf(obj);
            }
            return lastIndexOf;
        }

        @Override // java.util.List
        public java.util.ListIterator<E> listIterator() {
            return delegate().listIterator();
        }

        @Override // java.util.List
        public java.util.ListIterator<E> listIterator(int i) {
            return delegate().listIterator(i);
        }

        @Override // java.util.List
        public E remove(int i) {
            E remove;
            synchronized (this.mutex) {
                remove = delegate().remove(i);
            }
            return remove;
        }

        @Override // java.util.List
        public E set(int i, E e) {
            E e2;
            synchronized (this.mutex) {
                e2 = delegate().set(i, e);
            }
            return e2;
        }

        @Override // java.util.List
        public java.util.List<E> subList(int i, int i2) {
            java.util.List<E> j;
            synchronized (this.mutex) {
                j = com.google.common.collect.Synchronized.j(delegate().subList(i, i2), this.mutex);
            }
            return j;
        }
    }

    public static class SynchronizedListMultimap<K, V> extends com.google.common.collect.Synchronized.SynchronizedMultimap<K, V> implements com.google.common.collect.ListMultimap<K, V> {
        private static final long serialVersionUID = 0;

        public SynchronizedListMultimap(com.google.common.collect.ListMultimap<K, V> listMultimap, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            super(listMultimap, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public com.google.common.collect.ListMultimap<K, V> delegate() {
            return (com.google.common.collect.ListMultimap) super.delegate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ java.util.Collection get(java.lang.Object obj) {
            return get((com.google.common.collect.Synchronized.SynchronizedListMultimap<K, V>) obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public java.util.List<V> get(K k) {
            java.util.List<V> j;
            synchronized (this.mutex) {
                j = com.google.common.collect.Synchronized.j(delegate().get((com.google.common.collect.ListMultimap<K, V>) k), this.mutex);
            }
            return j;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public java.util.List<V> removeAll(java.lang.Object obj) {
            java.util.List<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ java.util.Collection replaceValues(java.lang.Object obj, java.lang.Iterable iterable) {
            return replaceValues((com.google.common.collect.Synchronized.SynchronizedListMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public java.util.List<V> replaceValues(K k, java.lang.Iterable<? extends V> iterable) {
            java.util.List<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((com.google.common.collect.ListMultimap<K, V>) k, (java.lang.Iterable) iterable);
            }
            return replaceValues;
        }
    }

    public static class SynchronizedMap<K, V> extends com.google.common.collect.Synchronized.SynchronizedObject implements java.util.Map<K, V> {
        private static final long serialVersionUID = 0;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.Set<java.util.Map.Entry<K, V>> entrySet;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.Set<K> keySet;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.Collection<V> values;

        public SynchronizedMap(java.util.Map<K, V> map, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            super(map, obj);
        }

        @Override // java.util.Map
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // java.util.Map
        public boolean containsKey(java.lang.Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = delegate().containsKey(obj);
            }
            return containsKey;
        }

        public boolean containsValue(java.lang.Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public java.util.Map<K, V> delegate() {
            return (java.util.Map) super.delegate();
        }

        public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
            java.util.Set<java.util.Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                if (this.entrySet == null) {
                    this.entrySet = com.google.common.collect.Synchronized.u(delegate().entrySet(), this.mutex);
                }
                set = this.entrySet;
            }
            return set;
        }

        @Override // java.util.Map
        public boolean equals(java.lang.Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        public V get(java.lang.Object obj) {
            V v;
            synchronized (this.mutex) {
                v = delegate().get(obj);
            }
            return v;
        }

        @Override // java.util.Map
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        @Override // java.util.Map
        public java.util.Set<K> keySet() {
            java.util.Set<K> set;
            synchronized (this.mutex) {
                if (this.keySet == null) {
                    this.keySet = com.google.common.collect.Synchronized.u(delegate().keySet(), this.mutex);
                }
                set = this.keySet;
            }
            return set;
        }

        @Override // java.util.Map
        public V put(K k, V v) {
            V put;
            synchronized (this.mutex) {
                put = delegate().put(k, v);
            }
            return put;
        }

        @Override // java.util.Map
        public void putAll(java.util.Map<? extends K, ? extends V> map) {
            synchronized (this.mutex) {
                delegate().putAll(map);
            }
        }

        @Override // java.util.Map
        public V remove(java.lang.Object obj) {
            V remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj);
            }
            return remove;
        }

        @Override // java.util.Map
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        public java.util.Collection<V> values() {
            java.util.Collection<V> collection;
            synchronized (this.mutex) {
                if (this.values == null) {
                    this.values = com.google.common.collect.Synchronized.h(delegate().values(), this.mutex);
                }
                collection = this.values;
            }
            return collection;
        }
    }

    public static class SynchronizedMultimap<K, V> extends com.google.common.collect.Synchronized.SynchronizedObject implements com.google.common.collect.Multimap<K, V> {
        private static final long serialVersionUID = 0;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.Map<K, java.util.Collection<V>> asMap;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.Collection<java.util.Map.Entry<K, V>> entries;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.Set<K> keySet;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient com.google.common.collect.Multiset<K> keys;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.Collection<V> valuesCollection;

        public SynchronizedMultimap(com.google.common.collect.Multimap<K, V> multimap, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            super(multimap, obj);
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public java.util.Map<K, java.util.Collection<V>> asMap() {
            java.util.Map<K, java.util.Collection<V>> map;
            synchronized (this.mutex) {
                if (this.asMap == null) {
                    this.asMap = new com.google.common.collect.Synchronized.SynchronizedAsMap(delegate().asMap(), this.mutex);
                }
                map = this.asMap;
            }
            return map;
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsEntry(java.lang.Object obj, java.lang.Object obj2) {
            boolean containsEntry;
            synchronized (this.mutex) {
                containsEntry = delegate().containsEntry(obj, obj2);
            }
            return containsEntry;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(java.lang.Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = delegate().containsKey(obj);
            }
            return containsKey;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsValue(java.lang.Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public com.google.common.collect.Multimap<K, V> delegate() {
            return (com.google.common.collect.Multimap) super.delegate();
        }

        @Override // com.google.common.collect.Multimap
        public java.util.Collection<java.util.Map.Entry<K, V>> entries() {
            java.util.Collection<java.util.Map.Entry<K, V>> collection;
            synchronized (this.mutex) {
                if (this.entries == null) {
                    this.entries = com.google.common.collect.Synchronized.A(delegate().entries(), this.mutex);
                }
                collection = this.entries;
            }
            return collection;
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public boolean equals(java.lang.Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        public java.util.Collection<V> get(K k) {
            java.util.Collection<V> A;
            synchronized (this.mutex) {
                A = com.google.common.collect.Synchronized.A(delegate().get(k), this.mutex);
            }
            return A;
        }

        @Override // com.google.common.collect.Multimap
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.Multimap
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        @Override // com.google.common.collect.Multimap
        public java.util.Set<K> keySet() {
            java.util.Set<K> set;
            synchronized (this.mutex) {
                if (this.keySet == null) {
                    this.keySet = com.google.common.collect.Synchronized.B(delegate().keySet(), this.mutex);
                }
                set = this.keySet;
            }
            return set;
        }

        @Override // com.google.common.collect.Multimap
        public com.google.common.collect.Multiset<K> keys() {
            com.google.common.collect.Multiset<K> multiset;
            synchronized (this.mutex) {
                if (this.keys == null) {
                    this.keys = com.google.common.collect.Synchronized.n(delegate().keys(), this.mutex);
                }
                multiset = this.keys;
            }
            return multiset;
        }

        @Override // com.google.common.collect.Multimap
        public boolean put(K k, V v) {
            boolean put;
            synchronized (this.mutex) {
                put = delegate().put(k, v);
            }
            return put;
        }

        @Override // com.google.common.collect.Multimap
        public boolean putAll(com.google.common.collect.Multimap<? extends K, ? extends V> multimap) {
            boolean putAll;
            synchronized (this.mutex) {
                putAll = delegate().putAll(multimap);
            }
            return putAll;
        }

        @Override // com.google.common.collect.Multimap
        public boolean putAll(K k, java.lang.Iterable<? extends V> iterable) {
            boolean putAll;
            synchronized (this.mutex) {
                putAll = delegate().putAll(k, iterable);
            }
            return putAll;
        }

        @Override // com.google.common.collect.Multimap
        public boolean remove(java.lang.Object obj, java.lang.Object obj2) {
            boolean remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, obj2);
            }
            return remove;
        }

        public java.util.Collection<V> removeAll(java.lang.Object obj) {
            java.util.Collection<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        public java.util.Collection<V> replaceValues(K k, java.lang.Iterable<? extends V> iterable) {
            java.util.Collection<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues(k, iterable);
            }
            return replaceValues;
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        @Override // com.google.common.collect.Multimap
        public java.util.Collection<V> values() {
            java.util.Collection<V> collection;
            synchronized (this.mutex) {
                if (this.valuesCollection == null) {
                    this.valuesCollection = com.google.common.collect.Synchronized.h(delegate().values(), this.mutex);
                }
                collection = this.valuesCollection;
            }
            return collection;
        }
    }

    public static class SynchronizedMultiset<E> extends com.google.common.collect.Synchronized.SynchronizedCollection<E> implements com.google.common.collect.Multiset<E> {
        private static final long serialVersionUID = 0;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.Set<E> elementSet;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.Set<com.google.common.collect.Multiset.Entry<E>> entrySet;

        public SynchronizedMultiset(com.google.common.collect.Multiset<E> multiset, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            super(multiset, obj, null);
        }

        @Override // com.google.common.collect.Multiset
        public int add(E e, int i) {
            int add;
            synchronized (this.mutex) {
                add = delegate().add(e, i);
            }
            return add;
        }

        @Override // com.google.common.collect.Multiset
        public int count(java.lang.Object obj) {
            int count;
            synchronized (this.mutex) {
                count = delegate().count(obj);
            }
            return count;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public com.google.common.collect.Multiset<E> delegate() {
            return (com.google.common.collect.Multiset) super.delegate();
        }

        @Override // com.google.common.collect.Multiset
        public java.util.Set<E> elementSet() {
            java.util.Set<E> set;
            synchronized (this.mutex) {
                if (this.elementSet == null) {
                    this.elementSet = com.google.common.collect.Synchronized.B(delegate().elementSet(), this.mutex);
                }
                set = this.elementSet;
            }
            return set;
        }

        @Override // com.google.common.collect.Multiset
        public java.util.Set<com.google.common.collect.Multiset.Entry<E>> entrySet() {
            java.util.Set<com.google.common.collect.Multiset.Entry<E>> set;
            synchronized (this.mutex) {
                if (this.entrySet == null) {
                    this.entrySet = com.google.common.collect.Synchronized.B(delegate().entrySet(), this.mutex);
                }
                set = this.entrySet;
            }
            return set;
        }

        @Override // java.util.Collection, com.google.common.collect.Multiset
        public boolean equals(java.lang.Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.Collection, com.google.common.collect.Multiset
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.Multiset
        public int remove(java.lang.Object obj, int i) {
            int remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, i);
            }
            return remove;
        }

        @Override // com.google.common.collect.Multiset
        public int setCount(E e, int i) {
            int count;
            synchronized (this.mutex) {
                count = delegate().setCount(e, i);
            }
            return count;
        }

        @Override // com.google.common.collect.Multiset
        public boolean setCount(E e, int i, int i2) {
            boolean count;
            synchronized (this.mutex) {
                count = delegate().setCount(e, i, i2);
            }
            return count;
        }
    }

    @com.google.common.annotations.GwtIncompatible
    @com.google.common.annotations.VisibleForTesting
    public static class SynchronizedNavigableMap<K, V> extends com.google.common.collect.Synchronized.SynchronizedSortedMap<K, V> implements java.util.NavigableMap<K, V> {
        private static final long serialVersionUID = 0;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.NavigableSet<K> descendingKeySet;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.NavigableMap<K, V> descendingMap;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.NavigableSet<K> navigableKeySet;

        public SynchronizedNavigableMap(java.util.NavigableMap<K, V> navigableMap, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            super(navigableMap, obj);
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> ceilingEntry(K k) {
            java.util.Map.Entry<K, V> s2;
            synchronized (this.mutex) {
                s2 = com.google.common.collect.Synchronized.s(delegate().ceilingEntry(k), this.mutex);
            }
            return s2;
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            K ceilingKey;
            synchronized (this.mutex) {
                ceilingKey = delegate().ceilingKey(k);
            }
            return ceilingKey;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public java.util.NavigableMap<K, V> delegate() {
            return (java.util.NavigableMap) super.delegate();
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableSet<K> descendingKeySet() {
            synchronized (this.mutex) {
                java.util.NavigableSet<K> navigableSet = this.descendingKeySet;
                if (navigableSet != null) {
                    return navigableSet;
                }
                java.util.NavigableSet<K> r = com.google.common.collect.Synchronized.r(delegate().descendingKeySet(), this.mutex);
                this.descendingKeySet = r;
                return r;
            }
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V> descendingMap() {
            synchronized (this.mutex) {
                java.util.NavigableMap<K, V> navigableMap = this.descendingMap;
                if (navigableMap != null) {
                    return navigableMap;
                }
                java.util.NavigableMap<K, V> p = com.google.common.collect.Synchronized.p(delegate().descendingMap(), this.mutex);
                this.descendingMap = p;
                return p;
            }
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> firstEntry() {
            java.util.Map.Entry<K, V> s2;
            synchronized (this.mutex) {
                s2 = com.google.common.collect.Synchronized.s(delegate().firstEntry(), this.mutex);
            }
            return s2;
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> floorEntry(K k) {
            java.util.Map.Entry<K, V> s2;
            synchronized (this.mutex) {
                s2 = com.google.common.collect.Synchronized.s(delegate().floorEntry(k), this.mutex);
            }
            return s2;
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            K floorKey;
            synchronized (this.mutex) {
                floorKey = delegate().floorKey(k);
            }
            return floorKey;
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V> headMap(K k, boolean z) {
            java.util.NavigableMap<K, V> p;
            synchronized (this.mutex) {
                p = com.google.common.collect.Synchronized.p(delegate().headMap(k, z), this.mutex);
            }
            return p;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public java.util.SortedMap<K, V> headMap(K k) {
            return headMap(k, false);
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> higherEntry(K k) {
            java.util.Map.Entry<K, V> s2;
            synchronized (this.mutex) {
                s2 = com.google.common.collect.Synchronized.s(delegate().higherEntry(k), this.mutex);
            }
            return s2;
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            K higherKey;
            synchronized (this.mutex) {
                higherKey = delegate().higherKey(k);
            }
            return higherKey;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public java.util.Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> lastEntry() {
            java.util.Map.Entry<K, V> s2;
            synchronized (this.mutex) {
                s2 = com.google.common.collect.Synchronized.s(delegate().lastEntry(), this.mutex);
            }
            return s2;
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> lowerEntry(K k) {
            java.util.Map.Entry<K, V> s2;
            synchronized (this.mutex) {
                s2 = com.google.common.collect.Synchronized.s(delegate().lowerEntry(k), this.mutex);
            }
            return s2;
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            K lowerKey;
            synchronized (this.mutex) {
                lowerKey = delegate().lowerKey(k);
            }
            return lowerKey;
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableSet<K> navigableKeySet() {
            synchronized (this.mutex) {
                java.util.NavigableSet<K> navigableSet = this.navigableKeySet;
                if (navigableSet != null) {
                    return navigableSet;
                }
                java.util.NavigableSet<K> r = com.google.common.collect.Synchronized.r(delegate().navigableKeySet(), this.mutex);
                this.navigableKeySet = r;
                return r;
            }
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> pollFirstEntry() {
            java.util.Map.Entry<K, V> s2;
            synchronized (this.mutex) {
                s2 = com.google.common.collect.Synchronized.s(delegate().pollFirstEntry(), this.mutex);
            }
            return s2;
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> pollLastEntry() {
            java.util.Map.Entry<K, V> s2;
            synchronized (this.mutex) {
                s2 = com.google.common.collect.Synchronized.s(delegate().pollLastEntry(), this.mutex);
            }
            return s2;
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            java.util.NavigableMap<K, V> p;
            synchronized (this.mutex) {
                p = com.google.common.collect.Synchronized.p(delegate().subMap(k, z, k2, z2), this.mutex);
            }
            return p;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public java.util.SortedMap<K, V> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V> tailMap(K k, boolean z) {
            java.util.NavigableMap<K, V> p;
            synchronized (this.mutex) {
                p = com.google.common.collect.Synchronized.p(delegate().tailMap(k, z), this.mutex);
            }
            return p;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public java.util.SortedMap<K, V> tailMap(K k) {
            return tailMap(k, true);
        }
    }

    @com.google.common.annotations.GwtIncompatible
    @com.google.common.annotations.VisibleForTesting
    public static class SynchronizedNavigableSet<E> extends com.google.common.collect.Synchronized.SynchronizedSortedSet<E> implements java.util.NavigableSet<E> {
        private static final long serialVersionUID = 0;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.NavigableSet<E> descendingSet;

        public SynchronizedNavigableSet(java.util.NavigableSet<E> navigableSet, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            super(navigableSet, obj);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e) {
            E ceiling;
            synchronized (this.mutex) {
                ceiling = delegate().ceiling(e);
            }
            return ceiling;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public java.util.NavigableSet<E> delegate() {
            return (java.util.NavigableSet) super.delegate();
        }

        @Override // java.util.NavigableSet
        public java.util.Iterator<E> descendingIterator() {
            return delegate().descendingIterator();
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<E> descendingSet() {
            synchronized (this.mutex) {
                java.util.NavigableSet<E> navigableSet = this.descendingSet;
                if (navigableSet != null) {
                    return navigableSet;
                }
                java.util.NavigableSet<E> r = com.google.common.collect.Synchronized.r(delegate().descendingSet(), this.mutex);
                this.descendingSet = r;
                return r;
            }
        }

        @Override // java.util.NavigableSet
        public E floor(E e) {
            E floor;
            synchronized (this.mutex) {
                floor = delegate().floor(e);
            }
            return floor;
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<E> headSet(E e, boolean z) {
            java.util.NavigableSet<E> r;
            synchronized (this.mutex) {
                r = com.google.common.collect.Synchronized.r(delegate().headSet(e, z), this.mutex);
            }
            return r;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public java.util.SortedSet<E> headSet(E e) {
            return headSet(e, false);
        }

        @Override // java.util.NavigableSet
        public E higher(E e) {
            E higher;
            synchronized (this.mutex) {
                higher = delegate().higher(e);
            }
            return higher;
        }

        @Override // java.util.NavigableSet
        public E lower(E e) {
            E lower;
            synchronized (this.mutex) {
                lower = delegate().lower(e);
            }
            return lower;
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            E pollFirst;
            synchronized (this.mutex) {
                pollFirst = delegate().pollFirst();
            }
            return pollFirst;
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            E pollLast;
            synchronized (this.mutex) {
                pollLast = delegate().pollLast();
            }
            return pollLast;
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            java.util.NavigableSet<E> r;
            synchronized (this.mutex) {
                r = com.google.common.collect.Synchronized.r(delegate().subSet(e, z, e2, z2), this.mutex);
            }
            return r;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public java.util.SortedSet<E> subSet(E e, E e2) {
            return subSet(e, true, e2, false);
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<E> tailSet(E e, boolean z) {
            java.util.NavigableSet<E> r;
            synchronized (this.mutex) {
                r = com.google.common.collect.Synchronized.r(delegate().tailSet(e, z), this.mutex);
            }
            return r;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public java.util.SortedSet<E> tailSet(E e) {
            return tailSet(e, true);
        }
    }

    public static class SynchronizedObject implements java.io.Serializable {

        @com.google.common.annotations.GwtIncompatible
        private static final long serialVersionUID = 0;
        final java.lang.Object delegate;
        final java.lang.Object mutex;

        public SynchronizedObject(java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
            this.delegate = com.google.common.base.Preconditions.checkNotNull(obj);
            this.mutex = obj2 == null ? this : obj2;
        }

        @com.google.common.annotations.GwtIncompatible
        private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
            synchronized (this.mutex) {
                objectOutputStream.defaultWriteObject();
            }
        }

        java.lang.Object delegate() {
            return this.delegate;
        }

        public java.lang.String toString() {
            java.lang.String obj;
            synchronized (this.mutex) {
                obj = this.delegate.toString();
            }
            return obj;
        }
    }

    public static class SynchronizedQueue<E> extends com.google.common.collect.Synchronized.SynchronizedCollection<E> implements java.util.Queue<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedQueue(java.util.Queue<E> queue, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            super(queue, obj, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public java.util.Queue<E> delegate() {
            return (java.util.Queue) super.delegate();
        }

        @Override // java.util.Queue
        public E element() {
            E element;
            synchronized (this.mutex) {
                element = delegate().element();
            }
            return element;
        }

        @Override // java.util.Queue
        public boolean offer(E e) {
            boolean offer;
            synchronized (this.mutex) {
                offer = delegate().offer(e);
            }
            return offer;
        }

        @Override // java.util.Queue
        public E peek() {
            E peek;
            synchronized (this.mutex) {
                peek = delegate().peek();
            }
            return peek;
        }

        @Override // java.util.Queue
        public E poll() {
            E poll;
            synchronized (this.mutex) {
                poll = delegate().poll();
            }
            return poll;
        }

        @Override // java.util.Queue
        public E remove() {
            E remove;
            synchronized (this.mutex) {
                remove = delegate().remove();
            }
            return remove;
        }
    }

    public static class SynchronizedRandomAccessList<E> extends com.google.common.collect.Synchronized.SynchronizedList<E> implements java.util.RandomAccess {
        private static final long serialVersionUID = 0;

        public SynchronizedRandomAccessList(java.util.List<E> list, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            super(list, obj);
        }
    }

    public static class SynchronizedSet<E> extends com.google.common.collect.Synchronized.SynchronizedCollection<E> implements java.util.Set<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedSet(java.util.Set<E> set, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            super(set, obj, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public java.util.Set<E> delegate() {
            return (java.util.Set) super.delegate();
        }

        public boolean equals(java.lang.Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }
    }

    public static class SynchronizedSetMultimap<K, V> extends com.google.common.collect.Synchronized.SynchronizedMultimap<K, V> implements com.google.common.collect.SetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.Set<java.util.Map.Entry<K, V>> entrySet;

        public SynchronizedSetMultimap(com.google.common.collect.SetMultimap<K, V> setMultimap, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            super(setMultimap, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public com.google.common.collect.SetMultimap<K, V> delegate() {
            return (com.google.common.collect.SetMultimap) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public java.util.Set<java.util.Map.Entry<K, V>> entries() {
            java.util.Set<java.util.Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                if (this.entrySet == null) {
                    this.entrySet = com.google.common.collect.Synchronized.u(delegate().entries(), this.mutex);
                }
                set = this.entrySet;
            }
            return set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ java.util.Collection get(java.lang.Object obj) {
            return get((com.google.common.collect.Synchronized.SynchronizedSetMultimap<K, V>) obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public java.util.Set<V> get(K k) {
            java.util.Set<V> u;
            synchronized (this.mutex) {
                u = com.google.common.collect.Synchronized.u(delegate().get((com.google.common.collect.SetMultimap<K, V>) k), this.mutex);
            }
            return u;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public java.util.Set<V> removeAll(java.lang.Object obj) {
            java.util.Set<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ java.util.Collection replaceValues(java.lang.Object obj, java.lang.Iterable iterable) {
            return replaceValues((com.google.common.collect.Synchronized.SynchronizedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public java.util.Set<V> replaceValues(K k, java.lang.Iterable<? extends V> iterable) {
            java.util.Set<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((com.google.common.collect.SetMultimap<K, V>) k, (java.lang.Iterable) iterable);
            }
            return replaceValues;
        }
    }

    public static class SynchronizedSortedMap<K, V> extends com.google.common.collect.Synchronized.SynchronizedMap<K, V> implements java.util.SortedMap<K, V> {
        private static final long serialVersionUID = 0;

        public SynchronizedSortedMap(java.util.SortedMap<K, V> sortedMap, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            super(sortedMap, obj);
        }

        @Override // java.util.SortedMap
        public java.util.Comparator<? super K> comparator() {
            java.util.Comparator<? super K> comparator;
            synchronized (this.mutex) {
                comparator = delegate().comparator();
            }
            return comparator;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public java.util.SortedMap<K, V> delegate() {
            return (java.util.SortedMap) super.delegate();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            K firstKey;
            synchronized (this.mutex) {
                firstKey = delegate().firstKey();
            }
            return firstKey;
        }

        public java.util.SortedMap<K, V> headMap(K k) {
            java.util.SortedMap<K, V> w;
            synchronized (this.mutex) {
                w = com.google.common.collect.Synchronized.w(delegate().headMap(k), this.mutex);
            }
            return w;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            K lastKey;
            synchronized (this.mutex) {
                lastKey = delegate().lastKey();
            }
            return lastKey;
        }

        public java.util.SortedMap<K, V> subMap(K k, K k2) {
            java.util.SortedMap<K, V> w;
            synchronized (this.mutex) {
                w = com.google.common.collect.Synchronized.w(delegate().subMap(k, k2), this.mutex);
            }
            return w;
        }

        public java.util.SortedMap<K, V> tailMap(K k) {
            java.util.SortedMap<K, V> w;
            synchronized (this.mutex) {
                w = com.google.common.collect.Synchronized.w(delegate().tailMap(k), this.mutex);
            }
            return w;
        }
    }

    public static class SynchronizedSortedSet<E> extends com.google.common.collect.Synchronized.SynchronizedSet<E> implements java.util.SortedSet<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedSortedSet(java.util.SortedSet<E> sortedSet, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            super(sortedSet, obj);
        }

        @Override // java.util.SortedSet
        public java.util.Comparator<? super E> comparator() {
            java.util.Comparator<? super E> comparator;
            synchronized (this.mutex) {
                comparator = delegate().comparator();
            }
            return comparator;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public java.util.SortedSet<E> delegate() {
            return (java.util.SortedSet) super.delegate();
        }

        @Override // java.util.SortedSet
        public E first() {
            E first;
            synchronized (this.mutex) {
                first = delegate().first();
            }
            return first;
        }

        public java.util.SortedSet<E> headSet(E e) {
            java.util.SortedSet<E> x;
            synchronized (this.mutex) {
                x = com.google.common.collect.Synchronized.x(delegate().headSet(e), this.mutex);
            }
            return x;
        }

        @Override // java.util.SortedSet
        public E last() {
            E last;
            synchronized (this.mutex) {
                last = delegate().last();
            }
            return last;
        }

        public java.util.SortedSet<E> subSet(E e, E e2) {
            java.util.SortedSet<E> x;
            synchronized (this.mutex) {
                x = com.google.common.collect.Synchronized.x(delegate().subSet(e, e2), this.mutex);
            }
            return x;
        }

        public java.util.SortedSet<E> tailSet(E e) {
            java.util.SortedSet<E> x;
            synchronized (this.mutex) {
                x = com.google.common.collect.Synchronized.x(delegate().tailSet(e), this.mutex);
            }
            return x;
        }
    }

    public static class SynchronizedSortedSetMultimap<K, V> extends com.google.common.collect.Synchronized.SynchronizedSetMultimap<K, V> implements com.google.common.collect.SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        public SynchronizedSortedSetMultimap(com.google.common.collect.SortedSetMultimap<K, V> sortedSetMultimap, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            super(sortedSetMultimap, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public com.google.common.collect.SortedSetMultimap<K, V> delegate() {
            return (com.google.common.collect.SortedSetMultimap) super.delegate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ java.util.Collection get(java.lang.Object obj) {
            return get((com.google.common.collect.Synchronized.SynchronizedSortedSetMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ java.util.Set get(java.lang.Object obj) {
            return get((com.google.common.collect.Synchronized.SynchronizedSortedSetMultimap<K, V>) obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public java.util.SortedSet<V> get(K k) {
            java.util.SortedSet<V> x;
            synchronized (this.mutex) {
                x = com.google.common.collect.Synchronized.x(delegate().get((com.google.common.collect.SortedSetMultimap<K, V>) k), this.mutex);
            }
            return x;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public java.util.SortedSet<V> removeAll(java.lang.Object obj) {
            java.util.SortedSet<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ java.util.Collection replaceValues(java.lang.Object obj, java.lang.Iterable iterable) {
            return replaceValues((com.google.common.collect.Synchronized.SynchronizedSortedSetMultimap<K, V>) obj, iterable);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ java.util.Set replaceValues(java.lang.Object obj, java.lang.Iterable iterable) {
            return replaceValues((com.google.common.collect.Synchronized.SynchronizedSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public java.util.SortedSet<V> replaceValues(K k, java.lang.Iterable<? extends V> iterable) {
            java.util.SortedSet<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((com.google.common.collect.SortedSetMultimap<K, V>) k, (java.lang.Iterable) iterable);
            }
            return replaceValues;
        }

        @Override // com.google.common.collect.SortedSetMultimap
        public java.util.Comparator<? super V> valueComparator() {
            java.util.Comparator<? super V> valueComparator;
            synchronized (this.mutex) {
                valueComparator = delegate().valueComparator();
            }
            return valueComparator;
        }
    }

    public static final class SynchronizedTable<R, C, V> extends com.google.common.collect.Synchronized.SynchronizedObject implements com.google.common.collect.Table<R, C, V> {

        /* renamed from: com.google.common.collect.Synchronized$SynchronizedTable$1, reason: invalid class name */
        public class AnonymousClass1 implements com.google.common.base.Function<java.util.Map<C, V>, java.util.Map<C, V>> {
            public AnonymousClass1() {
            }

            @Override // com.google.common.base.Function
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public java.util.Map<C, V> apply(java.util.Map<C, V> map) {
                return com.google.common.collect.Synchronized.l(map, com.google.common.collect.Synchronized.SynchronizedTable.this.mutex);
            }
        }

        /* renamed from: com.google.common.collect.Synchronized$SynchronizedTable$2, reason: invalid class name */
        public class AnonymousClass2 implements com.google.common.base.Function<java.util.Map<R, V>, java.util.Map<R, V>> {
            public AnonymousClass2() {
            }

            @Override // com.google.common.base.Function
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public java.util.Map<R, V> apply(java.util.Map<R, V> map) {
                return com.google.common.collect.Synchronized.l(map, com.google.common.collect.Synchronized.SynchronizedTable.this.mutex);
            }
        }

        public SynchronizedTable(com.google.common.collect.Table<R, C, V> table, java.lang.Object obj) {
            super(table, obj);
        }

        @Override // com.google.common.collect.Table
        public java.util.Set<com.google.common.collect.Table.Cell<R, C, V>> cellSet() {
            java.util.Set<com.google.common.collect.Table.Cell<R, C, V>> u;
            synchronized (this.mutex) {
                u = com.google.common.collect.Synchronized.u(delegate().cellSet(), this.mutex);
            }
            return u;
        }

        @Override // com.google.common.collect.Table
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // com.google.common.collect.Table
        public java.util.Map<R, V> column(@org.checkerframework.checker.nullness.compatqual.NullableDecl C c) {
            java.util.Map<R, V> l;
            synchronized (this.mutex) {
                l = com.google.common.collect.Synchronized.l(delegate().column(c), this.mutex);
            }
            return l;
        }

        @Override // com.google.common.collect.Table
        public java.util.Set<C> columnKeySet() {
            java.util.Set<C> u;
            synchronized (this.mutex) {
                u = com.google.common.collect.Synchronized.u(delegate().columnKeySet(), this.mutex);
            }
            return u;
        }

        @Override // com.google.common.collect.Table
        public java.util.Map<C, java.util.Map<R, V>> columnMap() {
            java.util.Map<C, java.util.Map<R, V>> l;
            synchronized (this.mutex) {
                l = com.google.common.collect.Synchronized.l(com.google.common.collect.Maps.transformValues(delegate().columnMap(), new com.google.common.collect.Synchronized.SynchronizedTable.AnonymousClass2()), this.mutex);
            }
            return l;
        }

        @Override // com.google.common.collect.Table
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
            boolean contains;
            synchronized (this.mutex) {
                contains = delegate().contains(obj, obj2);
            }
            return contains;
        }

        @Override // com.google.common.collect.Table
        public boolean containsColumn(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            boolean containsColumn;
            synchronized (this.mutex) {
                containsColumn = delegate().containsColumn(obj);
            }
            return containsColumn;
        }

        @Override // com.google.common.collect.Table
        public boolean containsRow(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            boolean containsRow;
            synchronized (this.mutex) {
                containsRow = delegate().containsRow(obj);
            }
            return containsRow;
        }

        @Override // com.google.common.collect.Table
        public boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public com.google.common.collect.Table<R, C, V> delegate() {
            return (com.google.common.collect.Table) super.delegate();
        }

        @Override // com.google.common.collect.Table
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            boolean equals;
            if (this == obj) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // com.google.common.collect.Table
        public V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
            V v;
            synchronized (this.mutex) {
                v = delegate().get(obj, obj2);
            }
            return v;
        }

        @Override // com.google.common.collect.Table
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.Table
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        @Override // com.google.common.collect.Table
        public V put(@org.checkerframework.checker.nullness.compatqual.NullableDecl R r, @org.checkerframework.checker.nullness.compatqual.NullableDecl C c, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
            V put;
            synchronized (this.mutex) {
                put = delegate().put(r, c, v);
            }
            return put;
        }

        @Override // com.google.common.collect.Table
        public void putAll(com.google.common.collect.Table<? extends R, ? extends C, ? extends V> table) {
            synchronized (this.mutex) {
                delegate().putAll(table);
            }
        }

        @Override // com.google.common.collect.Table
        public V remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
            V remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, obj2);
            }
            return remove;
        }

        @Override // com.google.common.collect.Table
        public java.util.Map<C, V> row(@org.checkerframework.checker.nullness.compatqual.NullableDecl R r) {
            java.util.Map<C, V> l;
            synchronized (this.mutex) {
                l = com.google.common.collect.Synchronized.l(delegate().row(r), this.mutex);
            }
            return l;
        }

        @Override // com.google.common.collect.Table
        public java.util.Set<R> rowKeySet() {
            java.util.Set<R> u;
            synchronized (this.mutex) {
                u = com.google.common.collect.Synchronized.u(delegate().rowKeySet(), this.mutex);
            }
            return u;
        }

        @Override // com.google.common.collect.Table
        public java.util.Map<R, java.util.Map<C, V>> rowMap() {
            java.util.Map<R, java.util.Map<C, V>> l;
            synchronized (this.mutex) {
                l = com.google.common.collect.Synchronized.l(com.google.common.collect.Maps.transformValues(delegate().rowMap(), new com.google.common.collect.Synchronized.SynchronizedTable.AnonymousClass1()), this.mutex);
            }
            return l;
        }

        @Override // com.google.common.collect.Table
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        @Override // com.google.common.collect.Table
        public java.util.Collection<V> values() {
            java.util.Collection<V> h;
            synchronized (this.mutex) {
                h = com.google.common.collect.Synchronized.h(delegate().values(), this.mutex);
            }
            return h;
        }
    }

    public static <E> java.util.Collection<E> A(java.util.Collection<E> collection, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return collection instanceof java.util.SortedSet ? x((java.util.SortedSet) collection, obj) : collection instanceof java.util.Set ? u((java.util.Set) collection, obj) : collection instanceof java.util.List ? j((java.util.List) collection, obj) : h(collection, obj);
    }

    public static <E> java.util.Set<E> B(java.util.Set<E> set, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return set instanceof java.util.SortedSet ? x((java.util.SortedSet) set, obj) : u(set, obj);
    }

    public static <K, V> com.google.common.collect.BiMap<K, V> g(com.google.common.collect.BiMap<K, V> biMap, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return ((biMap instanceof com.google.common.collect.Synchronized.SynchronizedBiMap) || (biMap instanceof com.google.common.collect.ImmutableBiMap)) ? biMap : new com.google.common.collect.Synchronized.SynchronizedBiMap(biMap, obj, null, null);
    }

    public static <E> java.util.Collection<E> h(java.util.Collection<E> collection, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return new com.google.common.collect.Synchronized.SynchronizedCollection(collection, obj, null);
    }

    public static <E> java.util.Deque<E> i(java.util.Deque<E> deque, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return new com.google.common.collect.Synchronized.SynchronizedDeque(deque, obj);
    }

    public static <E> java.util.List<E> j(java.util.List<E> list, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return list instanceof java.util.RandomAccess ? new com.google.common.collect.Synchronized.SynchronizedRandomAccessList(list, obj) : new com.google.common.collect.Synchronized.SynchronizedList(list, obj);
    }

    public static <K, V> com.google.common.collect.ListMultimap<K, V> k(com.google.common.collect.ListMultimap<K, V> listMultimap, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return ((listMultimap instanceof com.google.common.collect.Synchronized.SynchronizedListMultimap) || (listMultimap instanceof com.google.common.collect.BaseImmutableMultimap)) ? listMultimap : new com.google.common.collect.Synchronized.SynchronizedListMultimap(listMultimap, obj);
    }

    @com.google.common.annotations.VisibleForTesting
    public static <K, V> java.util.Map<K, V> l(java.util.Map<K, V> map, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return new com.google.common.collect.Synchronized.SynchronizedMap(map, obj);
    }

    public static <K, V> com.google.common.collect.Multimap<K, V> m(com.google.common.collect.Multimap<K, V> multimap, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return ((multimap instanceof com.google.common.collect.Synchronized.SynchronizedMultimap) || (multimap instanceof com.google.common.collect.BaseImmutableMultimap)) ? multimap : new com.google.common.collect.Synchronized.SynchronizedMultimap(multimap, obj);
    }

    public static <E> com.google.common.collect.Multiset<E> n(com.google.common.collect.Multiset<E> multiset, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return ((multiset instanceof com.google.common.collect.Synchronized.SynchronizedMultiset) || (multiset instanceof com.google.common.collect.ImmutableMultiset)) ? multiset : new com.google.common.collect.Synchronized.SynchronizedMultiset(multiset, obj);
    }

    @com.google.common.annotations.GwtIncompatible
    public static <K, V> java.util.NavigableMap<K, V> o(java.util.NavigableMap<K, V> navigableMap) {
        return p(navigableMap, null);
    }

    @com.google.common.annotations.GwtIncompatible
    public static <K, V> java.util.NavigableMap<K, V> p(java.util.NavigableMap<K, V> navigableMap, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return new com.google.common.collect.Synchronized.SynchronizedNavigableMap(navigableMap, obj);
    }

    @com.google.common.annotations.GwtIncompatible
    public static <E> java.util.NavigableSet<E> q(java.util.NavigableSet<E> navigableSet) {
        return r(navigableSet, null);
    }

    @com.google.common.annotations.GwtIncompatible
    public static <E> java.util.NavigableSet<E> r(java.util.NavigableSet<E> navigableSet, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return new com.google.common.collect.Synchronized.SynchronizedNavigableSet(navigableSet, obj);
    }

    @com.google.common.annotations.GwtIncompatible
    public static <K, V> java.util.Map.Entry<K, V> s(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.Map.Entry<K, V> entry, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (entry == null) {
            return null;
        }
        return new com.google.common.collect.Synchronized.SynchronizedEntry(entry, obj);
    }

    public static <E> java.util.Queue<E> t(java.util.Queue<E> queue, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return queue instanceof com.google.common.collect.Synchronized.SynchronizedQueue ? queue : new com.google.common.collect.Synchronized.SynchronizedQueue(queue, obj);
    }

    @com.google.common.annotations.VisibleForTesting
    public static <E> java.util.Set<E> u(java.util.Set<E> set, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return new com.google.common.collect.Synchronized.SynchronizedSet(set, obj);
    }

    public static <K, V> com.google.common.collect.SetMultimap<K, V> v(com.google.common.collect.SetMultimap<K, V> setMultimap, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return ((setMultimap instanceof com.google.common.collect.Synchronized.SynchronizedSetMultimap) || (setMultimap instanceof com.google.common.collect.BaseImmutableMultimap)) ? setMultimap : new com.google.common.collect.Synchronized.SynchronizedSetMultimap(setMultimap, obj);
    }

    public static <K, V> java.util.SortedMap<K, V> w(java.util.SortedMap<K, V> sortedMap, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return new com.google.common.collect.Synchronized.SynchronizedSortedMap(sortedMap, obj);
    }

    public static <E> java.util.SortedSet<E> x(java.util.SortedSet<E> sortedSet, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return new com.google.common.collect.Synchronized.SynchronizedSortedSet(sortedSet, obj);
    }

    public static <K, V> com.google.common.collect.SortedSetMultimap<K, V> y(com.google.common.collect.SortedSetMultimap<K, V> sortedSetMultimap, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return sortedSetMultimap instanceof com.google.common.collect.Synchronized.SynchronizedSortedSetMultimap ? sortedSetMultimap : new com.google.common.collect.Synchronized.SynchronizedSortedSetMultimap(sortedSetMultimap, obj);
    }

    public static <R, C, V> com.google.common.collect.Table<R, C, V> z(com.google.common.collect.Table<R, C, V> table, java.lang.Object obj) {
        return new com.google.common.collect.Synchronized.SynchronizedTable(table, obj);
    }
}
