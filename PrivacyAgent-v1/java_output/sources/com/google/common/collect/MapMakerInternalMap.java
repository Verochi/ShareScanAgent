package com.google.common.collect;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
class MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap.Segment<K, V, E, S>> extends java.util.AbstractMap<K, V> implements java.util.concurrent.ConcurrentMap<K, V>, java.io.Serializable {
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final com.google.common.collect.MapMakerInternalMap.WeakValueReference<java.lang.Object, java.lang.Object, com.google.common.collect.MapMakerInternalMap.DummyInternalEntry> UNSET_WEAK_VALUE_REFERENCE = new com.google.common.collect.MapMakerInternalMap.AnonymousClass1();
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient com.google.common.collect.MapMakerInternalMap.InternalEntryHelper<K, V, E, S> entryHelper;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    transient java.util.Set<java.util.Map.Entry<K, V>> entrySet;
    final com.google.common.base.Equivalence<java.lang.Object> keyEquivalence;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    transient java.util.Set<K> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient com.google.common.collect.MapMakerInternalMap.Segment<K, V, E, S>[] segments;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    transient java.util.Collection<V> values;

    /* renamed from: com.google.common.collect.MapMakerInternalMap$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.common.collect.MapMakerInternalMap.WeakValueReference<java.lang.Object, java.lang.Object, com.google.common.collect.MapMakerInternalMap.DummyInternalEntry> {
        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.MapMakerInternalMap.WeakValueReference<java.lang.Object, java.lang.Object, com.google.common.collect.MapMakerInternalMap.DummyInternalEntry> a(java.lang.ref.ReferenceQueue<java.lang.Object> referenceQueue, com.google.common.collect.MapMakerInternalMap.DummyInternalEntry dummyInternalEntry) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.MapMakerInternalMap.DummyInternalEntry getEntry() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public void clear() {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public java.lang.Object get() {
            return null;
        }
    }

    public static abstract class AbstractSerializationProxy<K, V> extends com.google.common.collect.ForwardingConcurrentMap<K, V> implements java.io.Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient java.util.concurrent.ConcurrentMap<K, V> delegate;
        final com.google.common.base.Equivalence<java.lang.Object> keyEquivalence;
        final com.google.common.collect.MapMakerInternalMap.Strength keyStrength;
        final com.google.common.base.Equivalence<java.lang.Object> valueEquivalence;
        final com.google.common.collect.MapMakerInternalMap.Strength valueStrength;

        public AbstractSerializationProxy(com.google.common.collect.MapMakerInternalMap.Strength strength, com.google.common.collect.MapMakerInternalMap.Strength strength2, com.google.common.base.Equivalence<java.lang.Object> equivalence, com.google.common.base.Equivalence<java.lang.Object> equivalence2, int i, java.util.concurrent.ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.concurrencyLevel = i;
            this.delegate = concurrentMap;
        }

        @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public java.util.concurrent.ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void readEntries(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
            while (true) {
                java.lang.Object readObject = objectInputStream.readObject();
                if (readObject == null) {
                    return;
                }
                this.delegate.put(readObject, objectInputStream.readObject());
            }
        }

        public com.google.common.collect.MapMaker readMapMaker(java.io.ObjectInputStream objectInputStream) throws java.io.IOException {
            return new com.google.common.collect.MapMaker().initialCapacity(objectInputStream.readInt()).g(this.keyStrength).h(this.valueStrength).f(this.keyEquivalence).concurrencyLevel(this.concurrencyLevel);
        }

        public void writeMapTo(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
            objectOutputStream.writeInt(this.delegate.size());
            for (java.util.Map.Entry<K, V> entry : this.delegate.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }
    }

    public static abstract class AbstractStrongKeyEntry<K, V, E extends com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, E>> implements com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, E> {
        public final K n;
        public final int t;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final E u;

        public AbstractStrongKeyEntry(K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl E e) {
            this.n = k;
            this.t = i;
            this.u = e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            return this.t;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public K getKey() {
            return this.n;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public E getNext() {
            return this.u;
        }
    }

    public static abstract class AbstractWeakKeyEntry<K, V, E extends com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, E>> extends java.lang.ref.WeakReference<K> implements com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, E> {
        public final int n;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final E t;

        public AbstractWeakKeyEntry(java.lang.ref.ReferenceQueue<K> referenceQueue, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl E e) {
            super(k, referenceQueue);
            this.n = i;
            this.t = e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            return this.n;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public K getKey() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public E getNext() {
            return this.t;
        }
    }

    public static final class CleanupMapTask implements java.lang.Runnable {
        public final java.lang.ref.WeakReference<com.google.common.collect.MapMakerInternalMap<?, ?, ?, ?>> n;

        @Override // java.lang.Runnable
        public void run() {
            com.google.common.collect.MapMakerInternalMap<?, ?, ?, ?> mapMakerInternalMap = this.n.get();
            if (mapMakerInternalMap == null) {
                throw new java.util.concurrent.CancellationException();
            }
            for (com.google.common.collect.MapMakerInternalMap.Segment<?, ?, ?, ?> segment : mapMakerInternalMap.segments) {
                segment.runCleanup();
            }
        }
    }

    public static final class DummyInternalEntry implements com.google.common.collect.MapMakerInternalMap.InternalEntry<java.lang.Object, java.lang.Object, com.google.common.collect.MapMakerInternalMap.DummyInternalEntry> {
        public DummyInternalEntry() {
            throw new java.lang.AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.MapMakerInternalMap.DummyInternalEntry getNext() {
            throw new java.lang.AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            throw new java.lang.AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public java.lang.Object getKey() {
            throw new java.lang.AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public java.lang.Object getValue() {
            throw new java.lang.AssertionError();
        }
    }

    public final class EntryIterator extends com.google.common.collect.MapMakerInternalMap<K, V, E, S>.HashIterator<java.util.Map.Entry<K, V>> {
        public EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public java.util.Map.Entry<K, V> next() {
            return c();
        }
    }

    public final class EntrySet extends com.google.common.collect.MapMakerInternalMap.SafeToArraySet<java.util.Map.Entry<K, V>> {
        public EntrySet() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.google.common.collect.MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            java.util.Map.Entry entry;
            java.lang.Object key;
            java.lang.Object obj2;
            return (obj instanceof java.util.Map.Entry) && (key = (entry = (java.util.Map.Entry) obj).getKey()) != null && (obj2 = com.google.common.collect.MapMakerInternalMap.this.get(key)) != null && com.google.common.collect.MapMakerInternalMap.this.valueEquivalence().equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return com.google.common.collect.MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
            return new com.google.common.collect.MapMakerInternalMap.EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            java.util.Map.Entry entry;
            java.lang.Object key;
            return (obj instanceof java.util.Map.Entry) && (key = (entry = (java.util.Map.Entry) obj).getKey()) != null && com.google.common.collect.MapMakerInternalMap.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.collect.MapMakerInternalMap.this.size();
        }
    }

    public abstract class HashIterator<T> implements java.util.Iterator<T> {
        public int n;
        public int t = -1;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public com.google.common.collect.MapMakerInternalMap.Segment<K, V, E, S> u;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public java.util.concurrent.atomic.AtomicReferenceArray<E> v;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public E w;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.MapMakerInternalMap<K, V, E, S>.WriteThroughEntry x;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.MapMakerInternalMap<K, V, E, S>.WriteThroughEntry y;

        public HashIterator() {
            this.n = com.google.common.collect.MapMakerInternalMap.this.segments.length - 1;
            a();
        }

        public final void a() {
            this.x = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i = this.n;
                if (i < 0) {
                    return;
                }
                com.google.common.collect.MapMakerInternalMap.Segment<K, V, E, S>[] segmentArr = com.google.common.collect.MapMakerInternalMap.this.segments;
                this.n = i - 1;
                com.google.common.collect.MapMakerInternalMap.Segment<K, V, E, S> segment = segmentArr[i];
                this.u = segment;
                if (segment.count != 0) {
                    this.v = this.u.table;
                    this.t = r0.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        public boolean b(E e) {
            try {
                java.lang.Object key = e.getKey();
                java.lang.Object liveValue = com.google.common.collect.MapMakerInternalMap.this.getLiveValue(e);
                if (liveValue == null) {
                    this.u.postReadCleanup();
                    return false;
                }
                this.x = new com.google.common.collect.MapMakerInternalMap.WriteThroughEntry(key, liveValue);
                this.u.postReadCleanup();
                return true;
            } catch (java.lang.Throwable th) {
                this.u.postReadCleanup();
                throw th;
            }
        }

        public com.google.common.collect.MapMakerInternalMap<K, V, E, S>.WriteThroughEntry c() {
            com.google.common.collect.MapMakerInternalMap<K, V, E, S>.WriteThroughEntry writeThroughEntry = this.x;
            if (writeThroughEntry == null) {
                throw new java.util.NoSuchElementException();
            }
            this.y = writeThroughEntry;
            a();
            return this.y;
        }

        public boolean d() {
            E e = this.w;
            if (e == null) {
                return false;
            }
            while (true) {
                this.w = (E) e.getNext();
                E e2 = this.w;
                if (e2 == null) {
                    return false;
                }
                if (b(e2)) {
                    return true;
                }
                e = this.w;
            }
        }

        public boolean e() {
            while (true) {
                int i = this.t;
                if (i < 0) {
                    return false;
                }
                java.util.concurrent.atomic.AtomicReferenceArray<E> atomicReferenceArray = this.v;
                this.t = i - 1;
                E e = atomicReferenceArray.get(i);
                this.w = e;
                if (e != null && (b(e) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.x != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.collect.CollectPreconditions.e(this.y != null);
            com.google.common.collect.MapMakerInternalMap.this.remove(this.y.getKey());
            this.y = null;
        }
    }

    public interface InternalEntry<K, V, E extends com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, E>> {
        int getHash();

        K getKey();

        E getNext();

        V getValue();
    }

    public interface InternalEntryHelper<K, V, E extends com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap.Segment<K, V, E, S>> {
        void a(S s2, E e, V v);

        com.google.common.collect.MapMakerInternalMap.Strength b();

        E c(S s2, E e, @org.checkerframework.checker.nullness.compatqual.NullableDecl E e2);

        com.google.common.collect.MapMakerInternalMap.Strength d();

        E e(S s2, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl E e);

        S f(com.google.common.collect.MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i, int i2);
    }

    public final class KeyIterator extends com.google.common.collect.MapMakerInternalMap<K, V, E, S>.HashIterator<K> {
        public KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    public final class KeySet extends com.google.common.collect.MapMakerInternalMap.SafeToArraySet<K> {
        public KeySet() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.google.common.collect.MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return com.google.common.collect.MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return com.google.common.collect.MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<K> iterator() {
            return new com.google.common.collect.MapMakerInternalMap.KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            return com.google.common.collect.MapMakerInternalMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.collect.MapMakerInternalMap.this.size();
        }
    }

    public static abstract class SafeToArraySet<E> extends java.util.AbstractSet<E> {
        public SafeToArraySet() {
        }

        public /* synthetic */ SafeToArraySet(com.google.common.collect.MapMakerInternalMap.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public java.lang.Object[] toArray() {
            return com.google.common.collect.MapMakerInternalMap.toArrayList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) com.google.common.collect.MapMakerInternalMap.toArrayList(this).toArray(tArr);
        }
    }

    public static abstract class Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap.Segment<K, V, E, S>> extends java.util.concurrent.locks.ReentrantLock {
        volatile int count;

        @com.google.j2objc.annotations.Weak
        final com.google.common.collect.MapMakerInternalMap<K, V, E, S> map;
        final int maxSegmentSize;
        int modCount;
        final java.util.concurrent.atomic.AtomicInteger readCount = new java.util.concurrent.atomic.AtomicInteger();

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        volatile java.util.concurrent.atomic.AtomicReferenceArray<E> table;
        int threshold;

        public Segment(com.google.common.collect.MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i, int i2) {
            this.map = mapMakerInternalMap;
            this.maxSegmentSize = i2;
            initTable(newEntryArray(i));
        }

        public static <K, V, E extends com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, E>> boolean isCollected(E e) {
            return e.getValue() == null;
        }

        public abstract E castForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry);

        public void clear() {
            if (this.count != 0) {
                lock();
                try {
                    java.util.concurrent.atomic.AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        atomicReferenceArray.set(i, null);
                    }
                    maybeClearReferenceQueues();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                }
            }
        }

        public <T> void clearReferenceQueue(java.lang.ref.ReferenceQueue<T> referenceQueue) {
            while (referenceQueue.poll() != null) {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public boolean clearValueForTesting(K k, int i, com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, ? extends com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?>> weakValueReference) {
            lock();
            try {
                java.util.concurrent.atomic.AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                com.google.common.collect.MapMakerInternalMap.InternalEntry internalEntry = (com.google.common.collect.MapMakerInternalMap.InternalEntry) atomicReferenceArray.get(length);
                for (com.google.common.collect.MapMakerInternalMap.InternalEntry internalEntry2 = internalEntry; internalEntry2 != null; internalEntry2 = internalEntry2.getNext()) {
                    java.lang.Object key = internalEntry2.getKey();
                    if (internalEntry2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        if (((com.google.common.collect.MapMakerInternalMap.WeakValueEntry) internalEntry2).getValueReference() != weakValueReference) {
                            return false;
                        }
                        atomicReferenceArray.set(length, removeFromChain(internalEntry, internalEntry2));
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public boolean containsKey(java.lang.Object obj, int i) {
            try {
                boolean z = false;
                if (this.count == 0) {
                    return false;
                }
                E liveEntry = getLiveEntry(obj, i);
                if (liveEntry != null) {
                    if (liveEntry.getValue() != null) {
                        z = true;
                    }
                }
                return z;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @com.google.common.annotations.VisibleForTesting
        public boolean containsValue(java.lang.Object obj) {
            try {
                if (this.count != 0) {
                    java.util.concurrent.atomic.AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        for (E e = atomicReferenceArray.get(i); e != null; e = e.getNext()) {
                            java.lang.Object liveValue = getLiveValue(e);
                            if (liveValue != null && this.map.valueEquivalence().equivalent(obj, liveValue)) {
                                postReadCleanup();
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        public E copyEntry(E e, E e2) {
            return this.map.entryHelper.c(self(), e, e2);
        }

        public E copyForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry2) {
            return this.map.entryHelper.c(self(), castForTesting(internalEntry), castForTesting(internalEntry2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public void drainKeyReferenceQueue(java.lang.ref.ReferenceQueue<K> referenceQueue) {
            int i = 0;
            do {
                java.lang.ref.Reference<? extends K> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimKey((com.google.common.collect.MapMakerInternalMap.InternalEntry) poll);
                i++;
            } while (i != 16);
        }

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public void drainValueReferenceQueue(java.lang.ref.ReferenceQueue<V> referenceQueue) {
            int i = 0;
            do {
                java.lang.ref.Reference<? extends V> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimValue((com.google.common.collect.MapMakerInternalMap.WeakValueReference) poll);
                i++;
            } while (i != 16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public void expand() {
            java.util.concurrent.atomic.AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i = this.count;
            io.reactivex.internal.subscriptions.ArrayCompositeSubscription arrayCompositeSubscription = (java.util.concurrent.atomic.AtomicReferenceArray<E>) newEntryArray(length << 1);
            this.threshold = (arrayCompositeSubscription.length() * 3) / 4;
            int length2 = arrayCompositeSubscription.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                E e = atomicReferenceArray.get(i2);
                if (e != null) {
                    com.google.common.collect.MapMakerInternalMap.InternalEntry next = e.getNext();
                    int hash = e.getHash() & length2;
                    if (next == null) {
                        arrayCompositeSubscription.set(hash, e);
                    } else {
                        com.google.common.collect.MapMakerInternalMap.InternalEntry internalEntry = e;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                internalEntry = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        arrayCompositeSubscription.set(hash, internalEntry);
                        while (e != internalEntry) {
                            int hash3 = e.getHash() & length2;
                            com.google.common.collect.MapMakerInternalMap.InternalEntry copyEntry = copyEntry(e, (com.google.common.collect.MapMakerInternalMap.InternalEntry) arrayCompositeSubscription.get(hash3));
                            if (copyEntry != null) {
                                arrayCompositeSubscription.set(hash3, copyEntry);
                            } else {
                                i--;
                            }
                            e = e.getNext();
                        }
                    }
                }
            }
            this.table = arrayCompositeSubscription;
            this.count = i;
        }

        public V get(java.lang.Object obj, int i) {
            try {
                E liveEntry = getLiveEntry(obj, i);
                if (liveEntry == null) {
                    postReadCleanup();
                    return null;
                }
                V v = (V) liveEntry.getValue();
                if (v == null) {
                    tryDrainReferenceQueues();
                }
                return v;
            } finally {
                postReadCleanup();
            }
        }

        public E getEntry(java.lang.Object obj, int i) {
            if (this.count == 0) {
                return null;
            }
            for (E first = getFirst(i); first != null; first = (E) first.getNext()) {
                if (first.getHash() == i) {
                    java.lang.Object key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        public E getFirst(int i) {
            return this.table.get(i & (r0.length() - 1));
        }

        public java.lang.ref.ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new java.lang.AssertionError();
        }

        public E getLiveEntry(java.lang.Object obj, int i) {
            return getEntry(obj, i);
        }

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public V getLiveValue(E e) {
            if (e.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = (V) e.getValue();
            if (v != null) {
                return v;
            }
            tryDrainReferenceQueues();
            return null;
        }

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public V getLiveValueForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry) {
            return getLiveValue(castForTesting(internalEntry));
        }

        public java.lang.ref.ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new java.lang.AssertionError();
        }

        public com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, E> getWeakValueReferenceForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry) {
            throw new java.lang.AssertionError();
        }

        public void initTable(java.util.concurrent.atomic.AtomicReferenceArray<E> atomicReferenceArray) {
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.threshold = length;
            if (length == this.maxSegmentSize) {
                this.threshold = length + 1;
            }
            this.table = atomicReferenceArray;
        }

        public void maybeClearReferenceQueues() {
        }

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public void maybeDrainReferenceQueues() {
        }

        public java.util.concurrent.atomic.AtomicReferenceArray<E> newEntryArray(int i) {
            return new java.util.concurrent.atomic.AtomicReferenceArray<>(i);
        }

        public E newEntryForTesting(K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry) {
            return this.map.entryHelper.e(self(), k, i, castForTesting(internalEntry));
        }

        public com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, E> newWeakValueReferenceForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry, V v) {
            throw new java.lang.AssertionError();
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                runCleanup();
            }
        }

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public void preWriteCleanup() {
            runLockedCleanup();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public V put(K k, int i, V v, boolean z) {
            lock();
            try {
                preWriteCleanup();
                int i2 = this.count + 1;
                if (i2 > this.threshold) {
                    expand();
                    i2 = this.count + 1;
                }
                java.util.concurrent.atomic.AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                com.google.common.collect.MapMakerInternalMap.InternalEntry internalEntry = (com.google.common.collect.MapMakerInternalMap.InternalEntry) atomicReferenceArray.get(length);
                for (com.google.common.collect.MapMakerInternalMap.InternalEntry internalEntry2 = internalEntry; internalEntry2 != null; internalEntry2 = internalEntry2.getNext()) {
                    java.lang.Object key = internalEntry2.getKey();
                    if (internalEntry2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        V v2 = (V) internalEntry2.getValue();
                        if (v2 == null) {
                            this.modCount++;
                            setValue(internalEntry2, v);
                            this.count = this.count;
                            return null;
                        }
                        if (z) {
                            return v2;
                        }
                        this.modCount++;
                        setValue(internalEntry2, v);
                        return v2;
                    }
                }
                this.modCount++;
                com.google.common.collect.MapMakerInternalMap.InternalEntry e = this.map.entryHelper.e(self(), k, i, internalEntry);
                setValue(e, v);
                atomicReferenceArray.set(length, e);
                this.count = i2;
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public boolean reclaimKey(E e, int i) {
            lock();
            try {
                java.util.concurrent.atomic.AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                com.google.common.collect.MapMakerInternalMap.InternalEntry internalEntry = (com.google.common.collect.MapMakerInternalMap.InternalEntry) atomicReferenceArray.get(length);
                for (com.google.common.collect.MapMakerInternalMap.InternalEntry internalEntry2 = internalEntry; internalEntry2 != null; internalEntry2 = internalEntry2.getNext()) {
                    if (internalEntry2 == e) {
                        this.modCount++;
                        com.google.common.collect.MapMakerInternalMap.InternalEntry removeFromChain = removeFromChain(internalEntry, internalEntry2);
                        int i2 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i2;
                        return true;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public boolean reclaimValue(K k, int i, com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, E> weakValueReference) {
            lock();
            try {
                java.util.concurrent.atomic.AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                com.google.common.collect.MapMakerInternalMap.InternalEntry internalEntry = (com.google.common.collect.MapMakerInternalMap.InternalEntry) atomicReferenceArray.get(length);
                for (com.google.common.collect.MapMakerInternalMap.InternalEntry internalEntry2 = internalEntry; internalEntry2 != null; internalEntry2 = internalEntry2.getNext()) {
                    java.lang.Object key = internalEntry2.getKey();
                    if (internalEntry2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        if (((com.google.common.collect.MapMakerInternalMap.WeakValueEntry) internalEntry2).getValueReference() != weakValueReference) {
                            return false;
                        }
                        this.modCount++;
                        com.google.common.collect.MapMakerInternalMap.InternalEntry removeFromChain = removeFromChain(internalEntry, internalEntry2);
                        int i2 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i2;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public V remove(java.lang.Object obj, int i) {
            lock();
            try {
                preWriteCleanup();
                java.util.concurrent.atomic.AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                com.google.common.collect.MapMakerInternalMap.InternalEntry internalEntry = (com.google.common.collect.MapMakerInternalMap.InternalEntry) atomicReferenceArray.get(length);
                for (com.google.common.collect.MapMakerInternalMap.InternalEntry internalEntry2 = internalEntry; internalEntry2 != null; internalEntry2 = internalEntry2.getNext()) {
                    java.lang.Object key = internalEntry2.getKey();
                    if (internalEntry2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        V v = (V) internalEntry2.getValue();
                        if (v == null && !isCollected(internalEntry2)) {
                            return null;
                        }
                        this.modCount++;
                        com.google.common.collect.MapMakerInternalMap.InternalEntry removeFromChain = removeFromChain(internalEntry, internalEntry2);
                        int i2 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i2;
                        return v;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        
            if (r8.map.valueEquivalence().equivalent(r11, r4.getValue()) == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
        
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        
            r8.modCount++;
            r9 = removeFromChain(r3, r4);
            r10 = r8.count - 1;
            r0.set(r1, r9);
            r8.count = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
        
            if (isCollected(r4) == false) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x005f, code lost:
        
            return false;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean remove(java.lang.Object obj, int i, java.lang.Object obj2) {
            lock();
            try {
                preWriteCleanup();
                java.util.concurrent.atomic.AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                com.google.common.collect.MapMakerInternalMap.InternalEntry internalEntry = (com.google.common.collect.MapMakerInternalMap.InternalEntry) atomicReferenceArray.get(length);
                com.google.common.collect.MapMakerInternalMap.InternalEntry internalEntry2 = internalEntry;
                while (true) {
                    boolean z = false;
                    if (internalEntry2 == null) {
                        return false;
                    }
                    java.lang.Object key = internalEntry2.getKey();
                    if (internalEntry2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        break;
                    }
                    internalEntry2 = internalEntry2.getNext();
                }
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public boolean removeEntryForTesting(E e) {
            int hash = e.getHash();
            java.util.concurrent.atomic.AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = hash & (atomicReferenceArray.length() - 1);
            com.google.common.collect.MapMakerInternalMap.InternalEntry internalEntry = (com.google.common.collect.MapMakerInternalMap.InternalEntry) atomicReferenceArray.get(length);
            for (com.google.common.collect.MapMakerInternalMap.InternalEntry internalEntry2 = internalEntry; internalEntry2 != null; internalEntry2 = internalEntry2.getNext()) {
                if (internalEntry2 == e) {
                    this.modCount++;
                    com.google.common.collect.MapMakerInternalMap.InternalEntry removeFromChain = removeFromChain(internalEntry, internalEntry2);
                    int i = this.count - 1;
                    atomicReferenceArray.set(length, removeFromChain);
                    this.count = i;
                    return true;
                }
            }
            return false;
        }

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public E removeFromChain(E e, E e2) {
            int i = this.count;
            E e3 = (E) e2.getNext();
            while (e != e2) {
                E copyEntry = copyEntry(e, e3);
                if (copyEntry != null) {
                    e3 = copyEntry;
                } else {
                    i--;
                }
                e = (E) e.getNext();
            }
            this.count = i;
            return e3;
        }

        public E removeFromChainForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry2) {
            return removeFromChain(castForTesting(internalEntry), castForTesting(internalEntry2));
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public boolean removeTableEntryForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry) {
            return removeEntryForTesting(castForTesting(internalEntry));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public V replace(K k, int i, V v) {
            lock();
            try {
                preWriteCleanup();
                java.util.concurrent.atomic.AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                com.google.common.collect.MapMakerInternalMap.InternalEntry internalEntry = (com.google.common.collect.MapMakerInternalMap.InternalEntry) atomicReferenceArray.get(length);
                for (com.google.common.collect.MapMakerInternalMap.InternalEntry internalEntry2 = internalEntry; internalEntry2 != null; internalEntry2 = internalEntry2.getNext()) {
                    java.lang.Object key = internalEntry2.getKey();
                    if (internalEntry2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        V v2 = (V) internalEntry2.getValue();
                        if (v2 != null) {
                            this.modCount++;
                            setValue(internalEntry2, v);
                            return v2;
                        }
                        if (isCollected(internalEntry2)) {
                            this.modCount++;
                            com.google.common.collect.MapMakerInternalMap.InternalEntry removeFromChain = removeFromChain(internalEntry, internalEntry2);
                            int i2 = this.count - 1;
                            atomicReferenceArray.set(length, removeFromChain);
                            this.count = i2;
                        }
                        return null;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean replace(K k, int i, V v, V v2) {
            lock();
            try {
                preWriteCleanup();
                java.util.concurrent.atomic.AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                com.google.common.collect.MapMakerInternalMap.InternalEntry internalEntry = (com.google.common.collect.MapMakerInternalMap.InternalEntry) atomicReferenceArray.get(length);
                for (com.google.common.collect.MapMakerInternalMap.InternalEntry internalEntry2 = internalEntry; internalEntry2 != null; internalEntry2 = internalEntry2.getNext()) {
                    java.lang.Object key = internalEntry2.getKey();
                    if (internalEntry2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        java.lang.Object value = internalEntry2.getValue();
                        if (value != null) {
                            if (!this.map.valueEquivalence().equivalent(v, value)) {
                                return false;
                            }
                            this.modCount++;
                            setValue(internalEntry2, v2);
                            return true;
                        }
                        if (isCollected(internalEntry2)) {
                            this.modCount++;
                            com.google.common.collect.MapMakerInternalMap.InternalEntry removeFromChain = removeFromChain(internalEntry, internalEntry2);
                            int i2 = this.count - 1;
                            atomicReferenceArray.set(length, removeFromChain);
                            this.count = i2;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public void runCleanup() {
            runLockedCleanup();
        }

        public void runLockedCleanup() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public abstract S self();

        public void setTableEntryForTesting(int i, com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry) {
            this.table.set(i, castForTesting(internalEntry));
        }

        public void setValue(E e, V v) {
            this.map.entryHelper.a(self(), e, v);
        }

        public void setValueForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry, V v) {
            this.map.entryHelper.a(self(), castForTesting(internalEntry), v);
        }

        public void setWeakValueReferenceForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry, com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, ? extends com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?>> weakValueReference) {
            throw new java.lang.AssertionError();
        }

        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }
    }

    public static final class SerializationProxy<K, V> extends com.google.common.collect.MapMakerInternalMap.AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        public SerializationProxy(com.google.common.collect.MapMakerInternalMap.Strength strength, com.google.common.collect.MapMakerInternalMap.Strength strength2, com.google.common.base.Equivalence<java.lang.Object> equivalence, com.google.common.base.Equivalence<java.lang.Object> equivalence2, int i, java.util.concurrent.ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, i, concurrentMap);
        }

        private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).makeMap();
            readEntries(objectInputStream);
        }

        private java.lang.Object readResolve() {
            return this.delegate;
        }

        private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class Strength {
        private static final /* synthetic */ com.google.common.collect.MapMakerInternalMap.Strength[] $VALUES;
        public static final com.google.common.collect.MapMakerInternalMap.Strength STRONG;
        public static final com.google.common.collect.MapMakerInternalMap.Strength WEAK;

        /* renamed from: com.google.common.collect.MapMakerInternalMap$Strength$1, reason: invalid class name */
        public enum AnonymousClass1 extends com.google.common.collect.MapMakerInternalMap.Strength {
            public AnonymousClass1(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public com.google.common.base.Equivalence<java.lang.Object> defaultEquivalence() {
                return com.google.common.base.Equivalence.equals();
            }
        }

        /* renamed from: com.google.common.collect.MapMakerInternalMap$Strength$2, reason: invalid class name */
        public enum AnonymousClass2 extends com.google.common.collect.MapMakerInternalMap.Strength {
            public AnonymousClass2(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public com.google.common.base.Equivalence<java.lang.Object> defaultEquivalence() {
                return com.google.common.base.Equivalence.identity();
            }
        }

        static {
            com.google.common.collect.MapMakerInternalMap.Strength.AnonymousClass1 anonymousClass1 = new com.google.common.collect.MapMakerInternalMap.Strength.AnonymousClass1("STRONG", 0);
            STRONG = anonymousClass1;
            com.google.common.collect.MapMakerInternalMap.Strength.AnonymousClass2 anonymousClass2 = new com.google.common.collect.MapMakerInternalMap.Strength.AnonymousClass2("WEAK", 1);
            WEAK = anonymousClass2;
            $VALUES = new com.google.common.collect.MapMakerInternalMap.Strength[]{anonymousClass1, anonymousClass2};
        }

        private Strength(java.lang.String str, int i) {
        }

        public /* synthetic */ Strength(java.lang.String str, int i, com.google.common.collect.MapMakerInternalMap.AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        public static com.google.common.collect.MapMakerInternalMap.Strength valueOf(java.lang.String str) {
            return (com.google.common.collect.MapMakerInternalMap.Strength) java.lang.Enum.valueOf(com.google.common.collect.MapMakerInternalMap.Strength.class, str);
        }

        public static com.google.common.collect.MapMakerInternalMap.Strength[] values() {
            return (com.google.common.collect.MapMakerInternalMap.Strength[]) $VALUES.clone();
        }

        public abstract com.google.common.base.Equivalence<java.lang.Object> defaultEquivalence();
    }

    public static final class StrongKeyDummyValueEntry<K> extends com.google.common.collect.MapMakerInternalMap.AbstractStrongKeyEntry<K, com.google.common.collect.MapMaker.Dummy, com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry<K>> implements com.google.common.collect.MapMakerInternalMap.StrongValueEntry<K, com.google.common.collect.MapMaker.Dummy, com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry<K>> {

        public static final class Helper<K> implements com.google.common.collect.MapMakerInternalMap.InternalEntryHelper<K, com.google.common.collect.MapMaker.Dummy, com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry<K>, com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueSegment<K>> {
            public static final com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry.Helper<?> a = new com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry.Helper<>();

            public static <K> com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry.Helper<K> h() {
                return (com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry.Helper<K>) a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public com.google.common.collect.MapMakerInternalMap.Strength b() {
                return com.google.common.collect.MapMakerInternalMap.Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public com.google.common.collect.MapMakerInternalMap.Strength d() {
                return com.google.common.collect.MapMakerInternalMap.Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry<K> c(com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry2) {
                return strongKeyDummyValueEntry.a(strongKeyDummyValueEntry2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry<K> e(com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry) {
                return new com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry<>(k, i, strongKeyDummyValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueSegment<K> f(com.google.common.collect.MapMakerInternalMap<K, com.google.common.collect.MapMaker.Dummy, com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry<K>, com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
                return new com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void a(com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry, com.google.common.collect.MapMaker.Dummy dummy) {
            }
        }

        public StrongKeyDummyValueEntry(K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry) {
            super(k, i, strongKeyDummyValueEntry);
        }

        public com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry<K> a(com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry) {
            return new com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry<>(this.n, this.t, strongKeyDummyValueEntry);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.MapMaker.Dummy getValue() {
            return com.google.common.collect.MapMaker.Dummy.VALUE;
        }
    }

    public static final class StrongKeyDummyValueSegment<K> extends com.google.common.collect.MapMakerInternalMap.Segment<K, com.google.common.collect.MapMaker.Dummy, com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry<K>, com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueSegment<K>> {
        public StrongKeyDummyValueSegment(com.google.common.collect.MapMakerInternalMap<K, com.google.common.collect.MapMaker.Dummy, com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry<K>, com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry<K> castForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, com.google.common.collect.MapMaker.Dummy, ?> internalEntry) {
            return (com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry) internalEntry;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueSegment<K> self() {
            return this;
        }
    }

    public static final class StrongKeyStrongValueEntry<K, V> extends com.google.common.collect.MapMakerInternalMap.AbstractStrongKeyEntry<K, V, com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry<K, V>> implements com.google.common.collect.MapMakerInternalMap.StrongValueEntry<K, V, com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry<K, V>> {

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public volatile V v;

        public static final class Helper<K, V> implements com.google.common.collect.MapMakerInternalMap.InternalEntryHelper<K, V, com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry<K, V>, com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueSegment<K, V>> {
            public static final com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry.Helper<?, ?> a = new com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry.Helper<>();

            public static <K, V> com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry.Helper<K, V> h() {
                return (com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry.Helper<K, V>) a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public com.google.common.collect.MapMakerInternalMap.Strength b() {
                return com.google.common.collect.MapMakerInternalMap.Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public com.google.common.collect.MapMakerInternalMap.Strength d() {
                return com.google.common.collect.MapMakerInternalMap.Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> c(com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry2) {
                return strongKeyStrongValueEntry.a(strongKeyStrongValueEntry2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> e(com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry) {
                return new com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry<>(k, i, strongKeyStrongValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> f(com.google.common.collect.MapMakerInternalMap<K, V, com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry<K, V>, com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void a(com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry, V v) {
                strongKeyStrongValueEntry.b(v);
            }
        }

        public StrongKeyStrongValueEntry(K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry) {
            super(k, i, strongKeyStrongValueEntry);
            this.v = null;
        }

        public com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> a(com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry) {
            com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry2 = new com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry<>(this.n, this.t, strongKeyStrongValueEntry);
            strongKeyStrongValueEntry2.v = this.v;
            return strongKeyStrongValueEntry2;
        }

        public void b(V v) {
            this.v = v;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public V getValue() {
            return this.v;
        }
    }

    public static final class StrongKeyStrongValueSegment<K, V> extends com.google.common.collect.MapMakerInternalMap.Segment<K, V, com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry<K, V>, com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueSegment<K, V>> {
        public StrongKeyStrongValueSegment(com.google.common.collect.MapMakerInternalMap<K, V, com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry<K, V>, com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> castForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry) {
            return (com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry) internalEntry;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> self() {
            return this;
        }
    }

    public static final class StrongKeyWeakValueEntry<K, V> extends com.google.common.collect.MapMakerInternalMap.AbstractStrongKeyEntry<K, V, com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>> implements com.google.common.collect.MapMakerInternalMap.WeakValueEntry<K, V, com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>> {
        public volatile com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>> v;

        public static final class Helper<K, V> implements com.google.common.collect.MapMakerInternalMap.InternalEntryHelper<K, V, com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>, com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueSegment<K, V>> {
            public static final com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry.Helper<?, ?> a = new com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry.Helper<>();

            public static <K, V> com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry.Helper<K, V> h() {
                return (com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry.Helper<K, V>) a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public com.google.common.collect.MapMakerInternalMap.Strength b() {
                return com.google.common.collect.MapMakerInternalMap.Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public com.google.common.collect.MapMakerInternalMap.Strength d() {
                return com.google.common.collect.MapMakerInternalMap.Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> c(com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry2) {
                if (com.google.common.collect.MapMakerInternalMap.Segment.isCollected(strongKeyWeakValueEntry)) {
                    return null;
                }
                return strongKeyWeakValueEntry.c(((com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues, strongKeyWeakValueEntry2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> e(com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry) {
                return new com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<>(k, i, strongKeyWeakValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> f(com.google.common.collect.MapMakerInternalMap<K, V, com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>, com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void a(com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry, V v) {
                strongKeyWeakValueEntry.d(v, ((com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues);
            }
        }

        public StrongKeyWeakValueEntry(K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry) {
            super(k, i, strongKeyWeakValueEntry);
            this.v = com.google.common.collect.MapMakerInternalMap.unsetWeakValueReference();
        }

        public com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> c(java.lang.ref.ReferenceQueue<V> referenceQueue, com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry) {
            com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry2 = new com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<>(this.n, this.t, strongKeyWeakValueEntry);
            strongKeyWeakValueEntry2.v = this.v.a(referenceQueue, strongKeyWeakValueEntry2);
            return strongKeyWeakValueEntry2;
        }

        public void d(V v, java.lang.ref.ReferenceQueue<V> referenceQueue) {
            com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>> weakValueReference = this.v;
            this.v = new com.google.common.collect.MapMakerInternalMap.WeakValueReferenceImpl(referenceQueue, v, this);
            weakValueReference.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public V getValue() {
            return this.v.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>> getValueReference() {
            return this.v;
        }
    }

    public static final class StrongKeyWeakValueSegment<K, V> extends com.google.common.collect.MapMakerInternalMap.Segment<K, V, com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>, com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueSegment<K, V>> {
        private final java.lang.ref.ReferenceQueue<V> queueForValues;

        public StrongKeyWeakValueSegment(com.google.common.collect.MapMakerInternalMap<K, V, com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>, com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
            this.queueForValues = new java.lang.ref.ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> castForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry) {
            return (com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry) internalEntry;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public java.lang.ref.ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>> getWeakValueReferenceForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry) {
            return castForTesting((com.google.common.collect.MapMakerInternalMap.InternalEntry) internalEntry).getValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>> newWeakValueReferenceForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry, V v) {
            return new com.google.common.collect.MapMakerInternalMap.WeakValueReferenceImpl(this.queueForValues, v, castForTesting((com.google.common.collect.MapMakerInternalMap.InternalEntry) internalEntry));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry, com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, ? extends com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?>> weakValueReference) {
            com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> castForTesting = castForTesting((com.google.common.collect.MapMakerInternalMap.InternalEntry) internalEntry);
            com.google.common.collect.MapMakerInternalMap.WeakValueReference weakValueReference2 = castForTesting.v;
            castForTesting.v = weakValueReference;
            weakValueReference2.clear();
        }
    }

    public interface StrongValueEntry<K, V, E extends com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, E>> extends com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, E> {
    }

    public final class ValueIterator extends com.google.common.collect.MapMakerInternalMap<K, V, E, S>.HashIterator<V> {
        public ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    public final class Values extends java.util.AbstractCollection<V> {
        public Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            com.google.common.collect.MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(java.lang.Object obj) {
            return com.google.common.collect.MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return com.google.common.collect.MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public java.util.Iterator<V> iterator() {
            return new com.google.common.collect.MapMakerInternalMap.ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return com.google.common.collect.MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public java.lang.Object[] toArray() {
            return com.google.common.collect.MapMakerInternalMap.toArrayList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) com.google.common.collect.MapMakerInternalMap.toArrayList(this).toArray(tArr);
        }
    }

    public static final class WeakKeyDummyValueEntry<K> extends com.google.common.collect.MapMakerInternalMap.AbstractWeakKeyEntry<K, com.google.common.collect.MapMaker.Dummy, com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry<K>> implements com.google.common.collect.MapMakerInternalMap.StrongValueEntry<K, com.google.common.collect.MapMaker.Dummy, com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry<K>> {

        public static final class Helper<K> implements com.google.common.collect.MapMakerInternalMap.InternalEntryHelper<K, com.google.common.collect.MapMaker.Dummy, com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry<K>, com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueSegment<K>> {
            public static final com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry.Helper<?> a = new com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry.Helper<>();

            public static <K> com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry.Helper<K> h() {
                return (com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry.Helper<K>) a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public com.google.common.collect.MapMakerInternalMap.Strength b() {
                return com.google.common.collect.MapMakerInternalMap.Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public com.google.common.collect.MapMakerInternalMap.Strength d() {
                return com.google.common.collect.MapMakerInternalMap.Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry<K> c(com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry2) {
                if (weakKeyDummyValueEntry.getKey() == null) {
                    return null;
                }
                return weakKeyDummyValueEntry.a(((com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueSegment) weakKeyDummyValueSegment).queueForKeys, weakKeyDummyValueEntry2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry<K> e(com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry) {
                return new com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry<>(((com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueSegment) weakKeyDummyValueSegment).queueForKeys, k, i, weakKeyDummyValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueSegment<K> f(com.google.common.collect.MapMakerInternalMap<K, com.google.common.collect.MapMaker.Dummy, com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry<K>, com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
                return new com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void a(com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry, com.google.common.collect.MapMaker.Dummy dummy) {
            }
        }

        public WeakKeyDummyValueEntry(java.lang.ref.ReferenceQueue<K> referenceQueue, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry) {
            super(referenceQueue, k, i, weakKeyDummyValueEntry);
        }

        public com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry<K> a(java.lang.ref.ReferenceQueue<K> referenceQueue, com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry) {
            return new com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry<>(referenceQueue, getKey(), this.n, weakKeyDummyValueEntry);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.MapMaker.Dummy getValue() {
            return com.google.common.collect.MapMaker.Dummy.VALUE;
        }
    }

    public static final class WeakKeyDummyValueSegment<K> extends com.google.common.collect.MapMakerInternalMap.Segment<K, com.google.common.collect.MapMaker.Dummy, com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry<K>, com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueSegment<K>> {
        private final java.lang.ref.ReferenceQueue<K> queueForKeys;

        public WeakKeyDummyValueSegment(com.google.common.collect.MapMakerInternalMap<K, com.google.common.collect.MapMaker.Dummy, com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry<K>, com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
            this.queueForKeys = new java.lang.ref.ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry<K> castForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, com.google.common.collect.MapMaker.Dummy, ?> internalEntry) {
            return (com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry) internalEntry;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public java.lang.ref.ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueSegment<K> self() {
            return this;
        }
    }

    public static final class WeakKeyStrongValueEntry<K, V> extends com.google.common.collect.MapMakerInternalMap.AbstractWeakKeyEntry<K, V, com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry<K, V>> implements com.google.common.collect.MapMakerInternalMap.StrongValueEntry<K, V, com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry<K, V>> {

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public volatile V u;

        public static final class Helper<K, V> implements com.google.common.collect.MapMakerInternalMap.InternalEntryHelper<K, V, com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry<K, V>, com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueSegment<K, V>> {
            public static final com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry.Helper<?, ?> a = new com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry.Helper<>();

            public static <K, V> com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry.Helper<K, V> h() {
                return (com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry.Helper<K, V>) a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public com.google.common.collect.MapMakerInternalMap.Strength b() {
                return com.google.common.collect.MapMakerInternalMap.Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public com.google.common.collect.MapMakerInternalMap.Strength d() {
                return com.google.common.collect.MapMakerInternalMap.Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> c(com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry2) {
                if (weakKeyStrongValueEntry.getKey() == null) {
                    return null;
                }
                return weakKeyStrongValueEntry.a(((com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, weakKeyStrongValueEntry2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> e(com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry) {
                return new com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry<>(((com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, k, i, weakKeyStrongValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> f(com.google.common.collect.MapMakerInternalMap<K, V, com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry<K, V>, com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void a(com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry, V v) {
                weakKeyStrongValueEntry.b(v);
            }
        }

        public WeakKeyStrongValueEntry(java.lang.ref.ReferenceQueue<K> referenceQueue, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry) {
            super(referenceQueue, k, i, weakKeyStrongValueEntry);
            this.u = null;
        }

        public com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> a(java.lang.ref.ReferenceQueue<K> referenceQueue, com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry) {
            com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry2 = new com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry<>(referenceQueue, getKey(), this.n, weakKeyStrongValueEntry);
            weakKeyStrongValueEntry2.b(this.u);
            return weakKeyStrongValueEntry2;
        }

        public void b(V v) {
            this.u = v;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public V getValue() {
            return this.u;
        }
    }

    public static final class WeakKeyStrongValueSegment<K, V> extends com.google.common.collect.MapMakerInternalMap.Segment<K, V, com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry<K, V>, com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueSegment<K, V>> {
        private final java.lang.ref.ReferenceQueue<K> queueForKeys;

        public WeakKeyStrongValueSegment(com.google.common.collect.MapMakerInternalMap<K, V, com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry<K, V>, com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
            this.queueForKeys = new java.lang.ref.ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> castForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry) {
            return (com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry) internalEntry;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public java.lang.ref.ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> self() {
            return this;
        }
    }

    public static final class WeakKeyWeakValueEntry<K, V> extends com.google.common.collect.MapMakerInternalMap.AbstractWeakKeyEntry<K, V, com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>> implements com.google.common.collect.MapMakerInternalMap.WeakValueEntry<K, V, com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>> {
        public volatile com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>> u;

        public static final class Helper<K, V> implements com.google.common.collect.MapMakerInternalMap.InternalEntryHelper<K, V, com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>, com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueSegment<K, V>> {
            public static final com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry.Helper<?, ?> a = new com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry.Helper<>();

            public static <K, V> com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry.Helper<K, V> h() {
                return (com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry.Helper<K, V>) a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public com.google.common.collect.MapMakerInternalMap.Strength b() {
                return com.google.common.collect.MapMakerInternalMap.Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public com.google.common.collect.MapMakerInternalMap.Strength d() {
                return com.google.common.collect.MapMakerInternalMap.Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> c(com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry2) {
                if (weakKeyWeakValueEntry.getKey() == null || com.google.common.collect.MapMakerInternalMap.Segment.isCollected(weakKeyWeakValueEntry)) {
                    return null;
                }
                return weakKeyWeakValueEntry.c(((com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, ((com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues, weakKeyWeakValueEntry2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> e(com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry) {
                return new com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<>(((com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, k, i, weakKeyWeakValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> f(com.google.common.collect.MapMakerInternalMap<K, V, com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>, com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void a(com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry, V v) {
                weakKeyWeakValueEntry.d(v, ((com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues);
            }
        }

        public WeakKeyWeakValueEntry(java.lang.ref.ReferenceQueue<K> referenceQueue, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry) {
            super(referenceQueue, k, i, weakKeyWeakValueEntry);
            this.u = com.google.common.collect.MapMakerInternalMap.unsetWeakValueReference();
        }

        public com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> c(java.lang.ref.ReferenceQueue<K> referenceQueue, java.lang.ref.ReferenceQueue<V> referenceQueue2, com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry) {
            com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry2 = new com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<>(referenceQueue, getKey(), this.n, weakKeyWeakValueEntry);
            weakKeyWeakValueEntry2.u = this.u.a(referenceQueue2, weakKeyWeakValueEntry2);
            return weakKeyWeakValueEntry2;
        }

        public void d(V v, java.lang.ref.ReferenceQueue<V> referenceQueue) {
            com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>> weakValueReference = this.u;
            this.u = new com.google.common.collect.MapMakerInternalMap.WeakValueReferenceImpl(referenceQueue, v, this);
            weakValueReference.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public V getValue() {
            return this.u.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>> getValueReference() {
            return this.u;
        }
    }

    public static final class WeakKeyWeakValueSegment<K, V> extends com.google.common.collect.MapMakerInternalMap.Segment<K, V, com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>, com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueSegment<K, V>> {
        private final java.lang.ref.ReferenceQueue<K> queueForKeys;
        private final java.lang.ref.ReferenceQueue<V> queueForValues;

        public WeakKeyWeakValueSegment(com.google.common.collect.MapMakerInternalMap<K, V, com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>, com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
            this.queueForKeys = new java.lang.ref.ReferenceQueue<>();
            this.queueForValues = new java.lang.ref.ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> castForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry) {
            return (com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry) internalEntry;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public java.lang.ref.ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public java.lang.ref.ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>> getWeakValueReferenceForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry) {
            return castForTesting((com.google.common.collect.MapMakerInternalMap.InternalEntry) internalEntry).getValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>> newWeakValueReferenceForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry, V v) {
            return new com.google.common.collect.MapMakerInternalMap.WeakValueReferenceImpl(this.queueForValues, v, castForTesting((com.google.common.collect.MapMakerInternalMap.InternalEntry) internalEntry));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry, com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, ? extends com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?>> weakValueReference) {
            com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> castForTesting = castForTesting((com.google.common.collect.MapMakerInternalMap.InternalEntry) internalEntry);
            com.google.common.collect.MapMakerInternalMap.WeakValueReference weakValueReference2 = castForTesting.u;
            castForTesting.u = weakValueReference;
            weakValueReference2.clear();
        }
    }

    public interface WeakValueEntry<K, V, E extends com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, E>> extends com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, E> {
        com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, E> getValueReference();
    }

    public interface WeakValueReference<K, V, E extends com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, E>> {
        com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, E> a(java.lang.ref.ReferenceQueue<V> referenceQueue, E e);

        void clear();

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        V get();

        E getEntry();
    }

    public static final class WeakValueReferenceImpl<K, V, E extends com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, E>> extends java.lang.ref.WeakReference<V> implements com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, E> {

        @com.google.j2objc.annotations.Weak
        public final E n;

        public WeakValueReferenceImpl(java.lang.ref.ReferenceQueue<V> referenceQueue, V v, E e) {
            super(v, referenceQueue);
            this.n = e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, E> a(java.lang.ref.ReferenceQueue<V> referenceQueue, E e) {
            return new com.google.common.collect.MapMakerInternalMap.WeakValueReferenceImpl(referenceQueue, get(), e);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public E getEntry() {
            return this.n;
        }
    }

    public final class WriteThroughEntry extends com.google.common.collect.AbstractMapEntry<K, V> {
        public final K n;
        public V t;

        public WriteThroughEntry(K k, V v) {
            this.n = k;
            this.t = v;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            return this.n.equals(entry.getKey()) && this.t.equals(entry.getValue());
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.n;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            return this.t;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public int hashCode() {
            return this.n.hashCode() ^ this.t.hashCode();
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) com.google.common.collect.MapMakerInternalMap.this.put(this.n, v);
            this.t = v;
            return v2;
        }
    }

    private MapMakerInternalMap(com.google.common.collect.MapMaker mapMaker, com.google.common.collect.MapMakerInternalMap.InternalEntryHelper<K, V, E, S> internalEntryHelper) {
        this.concurrencyLevel = java.lang.Math.min(mapMaker.a(), 65536);
        this.keyEquivalence = mapMaker.c();
        this.entryHelper = internalEntryHelper;
        int min = java.lang.Math.min(mapMaker.b(), 1073741824);
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        int i4 = 0;
        while (i3 < this.concurrencyLevel) {
            i4++;
            i3 <<= 1;
        }
        this.segmentShift = 32 - i4;
        this.segmentMask = i3 - 1;
        this.segments = newSegmentArray(i3);
        int i5 = min / i3;
        while (i2 < (i3 * i5 < min ? i5 + 1 : i5)) {
            i2 <<= 1;
        }
        while (true) {
            com.google.common.collect.MapMakerInternalMap.Segment<K, V, E, S>[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                return;
            }
            segmentArr[i] = createSegment(i2, -1);
            i++;
        }
    }

    public static <K, V> com.google.common.collect.MapMakerInternalMap<K, V, ? extends com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?>, ?> create(com.google.common.collect.MapMaker mapMaker) {
        com.google.common.collect.MapMakerInternalMap.Strength d = mapMaker.d();
        com.google.common.collect.MapMakerInternalMap.Strength strength = com.google.common.collect.MapMakerInternalMap.Strength.STRONG;
        if (d == strength && mapMaker.e() == strength) {
            return new com.google.common.collect.MapMakerInternalMap<>(mapMaker, com.google.common.collect.MapMakerInternalMap.StrongKeyStrongValueEntry.Helper.h());
        }
        if (mapMaker.d() == strength && mapMaker.e() == com.google.common.collect.MapMakerInternalMap.Strength.WEAK) {
            return new com.google.common.collect.MapMakerInternalMap<>(mapMaker, com.google.common.collect.MapMakerInternalMap.StrongKeyWeakValueEntry.Helper.h());
        }
        com.google.common.collect.MapMakerInternalMap.Strength d2 = mapMaker.d();
        com.google.common.collect.MapMakerInternalMap.Strength strength2 = com.google.common.collect.MapMakerInternalMap.Strength.WEAK;
        if (d2 == strength2 && mapMaker.e() == strength) {
            return new com.google.common.collect.MapMakerInternalMap<>(mapMaker, com.google.common.collect.MapMakerInternalMap.WeakKeyStrongValueEntry.Helper.h());
        }
        if (mapMaker.d() == strength2 && mapMaker.e() == strength2) {
            return new com.google.common.collect.MapMakerInternalMap<>(mapMaker, com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueEntry.Helper.h());
        }
        throw new java.lang.AssertionError();
    }

    public static <K> com.google.common.collect.MapMakerInternalMap<K, com.google.common.collect.MapMaker.Dummy, ? extends com.google.common.collect.MapMakerInternalMap.InternalEntry<K, com.google.common.collect.MapMaker.Dummy, ?>, ?> createWithDummyValues(com.google.common.collect.MapMaker mapMaker) {
        com.google.common.collect.MapMakerInternalMap.Strength d = mapMaker.d();
        com.google.common.collect.MapMakerInternalMap.Strength strength = com.google.common.collect.MapMakerInternalMap.Strength.STRONG;
        if (d == strength && mapMaker.e() == strength) {
            return new com.google.common.collect.MapMakerInternalMap<>(mapMaker, com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry.Helper.h());
        }
        com.google.common.collect.MapMakerInternalMap.Strength d2 = mapMaker.d();
        com.google.common.collect.MapMakerInternalMap.Strength strength2 = com.google.common.collect.MapMakerInternalMap.Strength.WEAK;
        if (d2 == strength2 && mapMaker.e() == strength) {
            return new com.google.common.collect.MapMakerInternalMap<>(mapMaker, com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry.Helper.h());
        }
        if (mapMaker.e() == strength2) {
            throw new java.lang.IllegalArgumentException("Map cannot have both weak and dummy values");
        }
        throw new java.lang.AssertionError();
    }

    public static int rehash(int i) {
        int i2 = i + ((i << 15) ^ (-12931));
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = i5 + (i5 << 2) + (i5 << 14);
        return i6 ^ (i6 >>> 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> java.util.ArrayList<E> toArrayList(java.util.Collection<E> collection) {
        java.util.ArrayList<E> arrayList = new java.util.ArrayList<>(collection.size());
        com.google.common.collect.Iterators.addAll(arrayList, collection.iterator());
        return arrayList;
    }

    public static <K, V, E extends com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, E>> com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, E> unsetWeakValueReference() {
        return (com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, E>) UNSET_WEAK_VALUE_REFERENCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (com.google.common.collect.MapMakerInternalMap.Segment<K, V, E, S> segment : this.segments) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).containsKey(obj, hash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        com.google.common.collect.MapMakerInternalMap.Segment<K, V, E, S>[] segmentArr = this.segments;
        long j = -1;
        int i = 0;
        while (i < 3) {
            long j2 = 0;
            for (com.google.common.collect.MapMakerInternalMap.WeakKeyWeakValueSegment weakKeyWeakValueSegment : segmentArr) {
                int i2 = weakKeyWeakValueSegment.count;
                java.util.concurrent.atomic.AtomicReferenceArray<E> atomicReferenceArray = weakKeyWeakValueSegment.table;
                for (int i3 = 0; i3 < atomicReferenceArray.length(); i3++) {
                    for (E e = atomicReferenceArray.get(i3); e != null; e = e.getNext()) {
                        java.lang.Object liveValue = weakKeyWeakValueSegment.getLiveValue(e);
                        if (liveValue != null && valueEquivalence().equivalent(obj, liveValue)) {
                            return true;
                        }
                    }
                }
                j2 += weakKeyWeakValueSegment.modCount;
            }
            if (j2 == j) {
                return false;
            }
            i++;
            j = j2;
        }
        return false;
    }

    @com.google.common.annotations.VisibleForTesting
    public E copyEntry(E e, E e2) {
        return segmentFor(e.getHash()).copyEntry(e, e2);
    }

    public com.google.common.collect.MapMakerInternalMap.Segment<K, V, E, S> createSegment(int i, int i2) {
        return this.entryHelper.f(this, i, i2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
        java.util.Set<java.util.Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        com.google.common.collect.MapMakerInternalMap.EntrySet entrySet = new com.google.common.collect.MapMakerInternalMap.EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).get(obj, hash);
    }

    public E getEntry(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).getEntry(obj, hash);
    }

    public V getLiveValue(E e) {
        V v;
        if (e.getKey() == null || (v = (V) e.getValue()) == null) {
            return null;
        }
        return v;
    }

    public int hash(java.lang.Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        com.google.common.collect.MapMakerInternalMap.Segment<K, V, E, S>[] segmentArr = this.segments;
        long j = 0;
        for (int i = 0; i < segmentArr.length; i++) {
            if (segmentArr[i].count != 0) {
                return false;
            }
            j += segmentArr[i].modCount;
        }
        if (j == 0) {
            return true;
        }
        for (int i2 = 0; i2 < segmentArr.length; i2++) {
            if (segmentArr[i2].count != 0) {
                return false;
            }
            j -= segmentArr[i2].modCount;
        }
        return j == 0;
    }

    @com.google.common.annotations.VisibleForTesting
    public boolean isLiveForTesting(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> internalEntry) {
        return segmentFor(internalEntry.getHash()).getLiveValueForTesting(internalEntry) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set<K> keySet() {
        java.util.Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        com.google.common.collect.MapMakerInternalMap.KeySet keySet = new com.google.common.collect.MapMakerInternalMap.KeySet();
        this.keySet = keySet;
        return keySet;
    }

    @com.google.common.annotations.VisibleForTesting
    public com.google.common.collect.MapMakerInternalMap.Strength keyStrength() {
        return this.entryHelper.b();
    }

    public final com.google.common.collect.MapMakerInternalMap.Segment<K, V, E, S>[] newSegmentArray(int i) {
        return new com.google.common.collect.MapMakerInternalMap.Segment[i];
    }

    @Override // java.util.AbstractMap, java.util.Map
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V put(K k, V v) {
        com.google.common.base.Preconditions.checkNotNull(k);
        com.google.common.base.Preconditions.checkNotNull(v);
        int hash = hash(k);
        return segmentFor(hash).put(k, hash, v, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(java.util.Map<? extends K, ? extends V> map) {
        for (java.util.Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V putIfAbsent(K k, V v) {
        com.google.common.base.Preconditions.checkNotNull(k);
        com.google.common.base.Preconditions.checkNotNull(v);
        int hash = hash(k);
        return segmentFor(hash).put(k, hash, v, true);
    }

    public void reclaimKey(E e) {
        int hash = e.getHash();
        segmentFor(hash).reclaimKey(e, hash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void reclaimValue(com.google.common.collect.MapMakerInternalMap.WeakValueReference<K, V, E> weakValueReference) {
        E entry = weakValueReference.getEntry();
        int hash = entry.getHash();
        segmentFor(hash).reclaimValue(entry.getKey(), hash, weakValueReference);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V replace(K k, V v) {
        com.google.common.base.Preconditions.checkNotNull(k);
        com.google.common.base.Preconditions.checkNotNull(v);
        int hash = hash(k);
        return segmentFor(hash).replace(k, hash, v);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean replace(K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v, V v2) {
        com.google.common.base.Preconditions.checkNotNull(k);
        com.google.common.base.Preconditions.checkNotNull(v2);
        if (v == null) {
            return false;
        }
        int hash = hash(k);
        return segmentFor(hash).replace(k, hash, v, v2);
    }

    public com.google.common.collect.MapMakerInternalMap.Segment<K, V, E, S> segmentFor(int i) {
        return this.segments[(i >>> this.segmentShift) & this.segmentMask];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j = 0;
        for (int i = 0; i < this.segments.length; i++) {
            j += r0[i].count;
        }
        return com.google.common.primitives.Ints.saturatedCast(j);
    }

    @com.google.common.annotations.VisibleForTesting
    public com.google.common.base.Equivalence<java.lang.Object> valueEquivalence() {
        return this.entryHelper.d().defaultEquivalence();
    }

    @com.google.common.annotations.VisibleForTesting
    public com.google.common.collect.MapMakerInternalMap.Strength valueStrength() {
        return this.entryHelper.d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Collection<V> values() {
        java.util.Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        com.google.common.collect.MapMakerInternalMap.Values values = new com.google.common.collect.MapMakerInternalMap.Values();
        this.values = values;
        return values;
    }

    public java.lang.Object writeReplace() {
        return new com.google.common.collect.MapMakerInternalMap.SerializationProxy(this.entryHelper.b(), this.entryHelper.d(), this.keyEquivalence, this.entryHelper.d().defaultEquivalence(), this.concurrencyLevel, this);
    }
}
