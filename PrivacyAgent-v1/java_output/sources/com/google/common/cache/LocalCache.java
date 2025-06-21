package com.google.common.cache;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
class LocalCache<K, V> extends java.util.AbstractMap<K, V> implements java.util.concurrent.ConcurrentMap<K, V> {
    public static final java.util.logging.Logger O = java.util.logging.Logger.getLogger(com.google.common.cache.LocalCache.class.getName());
    public static final com.google.common.cache.LocalCache.ValueReference<java.lang.Object, java.lang.Object> P = new com.google.common.cache.LocalCache.AnonymousClass1();
    public static final java.util.Queue<?> Q = new com.google.common.cache.LocalCache.AnonymousClass2();
    public final long A;
    public final com.google.common.cache.Weigher<K, V> B;
    public final long C;
    public final long D;
    public final long E;
    public final java.util.Queue<com.google.common.cache.RemovalNotification<K, V>> F;
    public final com.google.common.cache.RemovalListener<K, V> G;
    public final com.google.common.base.Ticker H;
    public final com.google.common.cache.LocalCache.EntryFactory I;
    public final com.google.common.cache.AbstractCache.StatsCounter J;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public final com.google.common.cache.CacheLoader<? super K, V> K;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public java.util.Set<K> L;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public java.util.Collection<V> M;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public java.util.Set<java.util.Map.Entry<K, V>> N;
    public final int n;
    public final int t;
    public final com.google.common.cache.LocalCache.Segment<K, V>[] u;
    public final int v;
    public final com.google.common.base.Equivalence<java.lang.Object> w;
    public final com.google.common.base.Equivalence<java.lang.Object> x;
    public final com.google.common.cache.LocalCache.Strength y;
    public final com.google.common.cache.LocalCache.Strength z;

    /* renamed from: com.google.common.cache.LocalCache$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.common.cache.LocalCache.ValueReference<java.lang.Object, java.lang.Object> {
        @Override // com.google.common.cache.LocalCache.ValueReference
        public void a(java.lang.Object obj) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int b() {
            return 0;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public java.lang.Object c() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public com.google.common.cache.LocalCache.ValueReference<java.lang.Object, java.lang.Object> d(java.lang.ref.ReferenceQueue<java.lang.Object> referenceQueue, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, com.google.common.cache.ReferenceEntry<java.lang.Object, java.lang.Object> referenceEntry) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public java.lang.Object get() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public com.google.common.cache.ReferenceEntry<java.lang.Object, java.lang.Object> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }
    }

    /* renamed from: com.google.common.cache.LocalCache$2, reason: invalid class name */
    public static class AnonymousClass2 extends java.util.AbstractQueue<java.lang.Object> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public java.util.Iterator<java.lang.Object> iterator() {
            return com.google.common.collect.ImmutableSet.of().iterator();
        }

        @Override // java.util.Queue
        public boolean offer(java.lang.Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public java.lang.Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public java.lang.Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }
    }

    public abstract class AbstractCacheSet<T> extends java.util.AbstractSet<T> {

        @com.google.j2objc.annotations.Weak
        public final java.util.concurrent.ConcurrentMap<?, ?> n;

        public AbstractCacheSet(java.util.concurrent.ConcurrentMap<?, ?> concurrentMap) {
            this.n = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.n.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.n.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.n.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public java.lang.Object[] toArray() {
            return com.google.common.cache.LocalCache.K(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) com.google.common.cache.LocalCache.K(this).toArray(eArr);
        }
    }

    public static abstract class AbstractReferenceEntry<K, V> implements com.google.common.cache.ReferenceEntry<K, V> {
        @Override // com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public K getKey() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getNext() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public com.google.common.cache.LocalCache.ValueReference<K, V> getValueReference() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(com.google.common.cache.LocalCache.ValueReference<K, V> valueReference) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public static final class AccessQueue<K, V> extends java.util.AbstractQueue<com.google.common.cache.ReferenceEntry<K, V>> {
        public final com.google.common.cache.ReferenceEntry<K, V> n = new com.google.common.cache.LocalCache.AccessQueue.AnonymousClass1();

        /* renamed from: com.google.common.cache.LocalCache$AccessQueue$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.cache.LocalCache.AbstractReferenceEntry<K, V> {
            public com.google.common.cache.ReferenceEntry<K, V> n = this;
            public com.google.common.cache.ReferenceEntry<K, V> t = this;

            public AnonymousClass1() {
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public long getAccessTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public com.google.common.cache.ReferenceEntry<K, V> getNextInAccessQueue() {
                return this.n;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public com.google.common.cache.ReferenceEntry<K, V> getPreviousInAccessQueue() {
                return this.t;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setAccessTime(long j) {
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setNextInAccessQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
                this.n = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setPreviousInAccessQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
                this.t = referenceEntry;
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$AccessQueue$2, reason: invalid class name */
        public class AnonymousClass2 extends com.google.common.collect.AbstractSequentialIterator<com.google.common.cache.ReferenceEntry<K, V>> {
            public AnonymousClass2(com.google.common.cache.ReferenceEntry referenceEntry) {
                super(referenceEntry);
            }

            @Override // com.google.common.collect.AbstractSequentialIterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.google.common.cache.ReferenceEntry<K, V> computeNext(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
                com.google.common.cache.ReferenceEntry<K, V> nextInAccessQueue = referenceEntry.getNextInAccessQueue();
                if (nextInAccessQueue == com.google.common.cache.LocalCache.AccessQueue.this.n) {
                    return null;
                }
                return nextInAccessQueue;
            }
        }

        @Override // java.util.Queue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            com.google.common.cache.LocalCache.d(referenceEntry.getPreviousInAccessQueue(), referenceEntry.getNextInAccessQueue());
            com.google.common.cache.LocalCache.d(this.n.getPreviousInAccessQueue(), referenceEntry);
            com.google.common.cache.LocalCache.d(referenceEntry, this.n);
            return true;
        }

        @Override // java.util.Queue
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.ReferenceEntry<K, V> peek() {
            com.google.common.cache.ReferenceEntry<K, V> nextInAccessQueue = this.n.getNextInAccessQueue();
            if (nextInAccessQueue == this.n) {
                return null;
            }
            return nextInAccessQueue;
        }

        @Override // java.util.Queue
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.ReferenceEntry<K, V> poll() {
            com.google.common.cache.ReferenceEntry<K, V> nextInAccessQueue = this.n.getNextInAccessQueue();
            if (nextInAccessQueue == this.n) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            com.google.common.cache.ReferenceEntry<K, V> nextInAccessQueue = this.n.getNextInAccessQueue();
            while (true) {
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry = this.n;
                if (nextInAccessQueue == referenceEntry) {
                    referenceEntry.setNextInAccessQueue(referenceEntry);
                    com.google.common.cache.ReferenceEntry<K, V> referenceEntry2 = this.n;
                    referenceEntry2.setPreviousInAccessQueue(referenceEntry2);
                    return;
                } else {
                    com.google.common.cache.ReferenceEntry<K, V> nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    com.google.common.cache.LocalCache.y(nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(java.lang.Object obj) {
            return ((com.google.common.cache.ReferenceEntry) obj).getNextInAccessQueue() != com.google.common.cache.LocalCache.NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.n.getNextInAccessQueue() == this.n;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public java.util.Iterator<com.google.common.cache.ReferenceEntry<K, V>> iterator() {
            return new com.google.common.cache.LocalCache.AccessQueue.AnonymousClass2(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(java.lang.Object obj) {
            com.google.common.cache.ReferenceEntry referenceEntry = (com.google.common.cache.ReferenceEntry) obj;
            com.google.common.cache.ReferenceEntry<K, V> previousInAccessQueue = referenceEntry.getPreviousInAccessQueue();
            com.google.common.cache.ReferenceEntry<K, V> nextInAccessQueue = referenceEntry.getNextInAccessQueue();
            com.google.common.cache.LocalCache.d(previousInAccessQueue, nextInAccessQueue);
            com.google.common.cache.LocalCache.y(referenceEntry);
            return nextInAccessQueue != com.google.common.cache.LocalCache.NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (com.google.common.cache.ReferenceEntry<K, V> nextInAccessQueue = this.n.getNextInAccessQueue(); nextInAccessQueue != this.n; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i++;
            }
            return i;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class EntryFactory {
        private static final /* synthetic */ com.google.common.cache.LocalCache.EntryFactory[] $VALUES;
        static final int ACCESS_MASK = 1;
        public static final com.google.common.cache.LocalCache.EntryFactory STRONG;
        public static final com.google.common.cache.LocalCache.EntryFactory STRONG_ACCESS;
        public static final com.google.common.cache.LocalCache.EntryFactory STRONG_ACCESS_WRITE;
        public static final com.google.common.cache.LocalCache.EntryFactory STRONG_WRITE;
        public static final com.google.common.cache.LocalCache.EntryFactory WEAK;
        public static final com.google.common.cache.LocalCache.EntryFactory WEAK_ACCESS;
        public static final com.google.common.cache.LocalCache.EntryFactory WEAK_ACCESS_WRITE;
        static final int WEAK_MASK = 4;
        public static final com.google.common.cache.LocalCache.EntryFactory WEAK_WRITE;
        static final int WRITE_MASK = 2;
        static final com.google.common.cache.LocalCache.EntryFactory[] factories;

        /* renamed from: com.google.common.cache.LocalCache$EntryFactory$1, reason: invalid class name */
        public enum AnonymousClass1 extends com.google.common.cache.LocalCache.EntryFactory {
            public AnonymousClass1(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.ReferenceEntry<K, V> newEntry(com.google.common.cache.LocalCache.Segment<K, V> segment, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
                return new com.google.common.cache.LocalCache.StrongEntry(k, i, referenceEntry);
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$EntryFactory$2, reason: invalid class name */
        public enum AnonymousClass2 extends com.google.common.cache.LocalCache.EntryFactory {
            public AnonymousClass2(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.ReferenceEntry<K, V> copyEntry(com.google.common.cache.LocalCache.Segment<K, V> segment, com.google.common.cache.ReferenceEntry<K, V> referenceEntry, com.google.common.cache.ReferenceEntry<K, V> referenceEntry2) {
                com.google.common.cache.ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.ReferenceEntry<K, V> newEntry(com.google.common.cache.LocalCache.Segment<K, V> segment, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
                return new com.google.common.cache.LocalCache.StrongAccessEntry(k, i, referenceEntry);
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$EntryFactory$3, reason: invalid class name */
        public enum AnonymousClass3 extends com.google.common.cache.LocalCache.EntryFactory {
            public AnonymousClass3(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.ReferenceEntry<K, V> copyEntry(com.google.common.cache.LocalCache.Segment<K, V> segment, com.google.common.cache.ReferenceEntry<K, V> referenceEntry, com.google.common.cache.ReferenceEntry<K, V> referenceEntry2) {
                com.google.common.cache.ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.ReferenceEntry<K, V> newEntry(com.google.common.cache.LocalCache.Segment<K, V> segment, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
                return new com.google.common.cache.LocalCache.StrongWriteEntry(k, i, referenceEntry);
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$EntryFactory$4, reason: invalid class name */
        public enum AnonymousClass4 extends com.google.common.cache.LocalCache.EntryFactory {
            public AnonymousClass4(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.ReferenceEntry<K, V> copyEntry(com.google.common.cache.LocalCache.Segment<K, V> segment, com.google.common.cache.ReferenceEntry<K, V> referenceEntry, com.google.common.cache.ReferenceEntry<K, V> referenceEntry2) {
                com.google.common.cache.ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.ReferenceEntry<K, V> newEntry(com.google.common.cache.LocalCache.Segment<K, V> segment, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
                return new com.google.common.cache.LocalCache.StrongAccessWriteEntry(k, i, referenceEntry);
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$EntryFactory$5, reason: invalid class name */
        public enum AnonymousClass5 extends com.google.common.cache.LocalCache.EntryFactory {
            public AnonymousClass5(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.ReferenceEntry<K, V> newEntry(com.google.common.cache.LocalCache.Segment<K, V> segment, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
                return new com.google.common.cache.LocalCache.WeakEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$EntryFactory$6, reason: invalid class name */
        public enum AnonymousClass6 extends com.google.common.cache.LocalCache.EntryFactory {
            public AnonymousClass6(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.ReferenceEntry<K, V> copyEntry(com.google.common.cache.LocalCache.Segment<K, V> segment, com.google.common.cache.ReferenceEntry<K, V> referenceEntry, com.google.common.cache.ReferenceEntry<K, V> referenceEntry2) {
                com.google.common.cache.ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.ReferenceEntry<K, V> newEntry(com.google.common.cache.LocalCache.Segment<K, V> segment, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
                return new com.google.common.cache.LocalCache.WeakAccessEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$EntryFactory$7, reason: invalid class name */
        public enum AnonymousClass7 extends com.google.common.cache.LocalCache.EntryFactory {
            public AnonymousClass7(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.ReferenceEntry<K, V> copyEntry(com.google.common.cache.LocalCache.Segment<K, V> segment, com.google.common.cache.ReferenceEntry<K, V> referenceEntry, com.google.common.cache.ReferenceEntry<K, V> referenceEntry2) {
                com.google.common.cache.ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.ReferenceEntry<K, V> newEntry(com.google.common.cache.LocalCache.Segment<K, V> segment, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
                return new com.google.common.cache.LocalCache.WeakWriteEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$EntryFactory$8, reason: invalid class name */
        public enum AnonymousClass8 extends com.google.common.cache.LocalCache.EntryFactory {
            public AnonymousClass8(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.ReferenceEntry<K, V> copyEntry(com.google.common.cache.LocalCache.Segment<K, V> segment, com.google.common.cache.ReferenceEntry<K, V> referenceEntry, com.google.common.cache.ReferenceEntry<K, V> referenceEntry2) {
                com.google.common.cache.ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.ReferenceEntry<K, V> newEntry(com.google.common.cache.LocalCache.Segment<K, V> segment, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
                return new com.google.common.cache.LocalCache.WeakAccessWriteEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }
        }

        static {
            com.google.common.cache.LocalCache.EntryFactory.AnonymousClass1 anonymousClass1 = new com.google.common.cache.LocalCache.EntryFactory.AnonymousClass1("STRONG", 0);
            STRONG = anonymousClass1;
            com.google.common.cache.LocalCache.EntryFactory.AnonymousClass2 anonymousClass2 = new com.google.common.cache.LocalCache.EntryFactory.AnonymousClass2("STRONG_ACCESS", 1);
            STRONG_ACCESS = anonymousClass2;
            com.google.common.cache.LocalCache.EntryFactory.AnonymousClass3 anonymousClass3 = new com.google.common.cache.LocalCache.EntryFactory.AnonymousClass3("STRONG_WRITE", 2);
            STRONG_WRITE = anonymousClass3;
            com.google.common.cache.LocalCache.EntryFactory.AnonymousClass4 anonymousClass4 = new com.google.common.cache.LocalCache.EntryFactory.AnonymousClass4("STRONG_ACCESS_WRITE", 3);
            STRONG_ACCESS_WRITE = anonymousClass4;
            com.google.common.cache.LocalCache.EntryFactory.AnonymousClass5 anonymousClass5 = new com.google.common.cache.LocalCache.EntryFactory.AnonymousClass5("WEAK", 4);
            WEAK = anonymousClass5;
            com.google.common.cache.LocalCache.EntryFactory.AnonymousClass6 anonymousClass6 = new com.google.common.cache.LocalCache.EntryFactory.AnonymousClass6("WEAK_ACCESS", 5);
            WEAK_ACCESS = anonymousClass6;
            com.google.common.cache.LocalCache.EntryFactory.AnonymousClass7 anonymousClass7 = new com.google.common.cache.LocalCache.EntryFactory.AnonymousClass7("WEAK_WRITE", 6);
            WEAK_WRITE = anonymousClass7;
            com.google.common.cache.LocalCache.EntryFactory.AnonymousClass8 anonymousClass8 = new com.google.common.cache.LocalCache.EntryFactory.AnonymousClass8("WEAK_ACCESS_WRITE", 7);
            WEAK_ACCESS_WRITE = anonymousClass8;
            $VALUES = new com.google.common.cache.LocalCache.EntryFactory[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, anonymousClass5, anonymousClass6, anonymousClass7, anonymousClass8};
            factories = new com.google.common.cache.LocalCache.EntryFactory[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, anonymousClass5, anonymousClass6, anonymousClass7, anonymousClass8};
        }

        private EntryFactory(java.lang.String str, int i) {
        }

        public /* synthetic */ EntryFactory(java.lang.String str, int i, com.google.common.cache.LocalCache.AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static com.google.common.cache.LocalCache.EntryFactory getFactory(com.google.common.cache.LocalCache.Strength strength, boolean z, boolean z2) {
            return factories[(strength == com.google.common.cache.LocalCache.Strength.WEAK ? (char) 4 : (char) 0) | (z ? 1 : 0) | (z2 ? 2 : 0)];
        }

        public static com.google.common.cache.LocalCache.EntryFactory valueOf(java.lang.String str) {
            return (com.google.common.cache.LocalCache.EntryFactory) java.lang.Enum.valueOf(com.google.common.cache.LocalCache.EntryFactory.class, str);
        }

        public static com.google.common.cache.LocalCache.EntryFactory[] values() {
            return (com.google.common.cache.LocalCache.EntryFactory[]) $VALUES.clone();
        }

        public <K, V> void copyAccessEntry(com.google.common.cache.ReferenceEntry<K, V> referenceEntry, com.google.common.cache.ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setAccessTime(referenceEntry.getAccessTime());
            com.google.common.cache.LocalCache.d(referenceEntry.getPreviousInAccessQueue(), referenceEntry2);
            com.google.common.cache.LocalCache.d(referenceEntry2, referenceEntry.getNextInAccessQueue());
            com.google.common.cache.LocalCache.y(referenceEntry);
        }

        public <K, V> com.google.common.cache.ReferenceEntry<K, V> copyEntry(com.google.common.cache.LocalCache.Segment<K, V> segment, com.google.common.cache.ReferenceEntry<K, V> referenceEntry, com.google.common.cache.ReferenceEntry<K, V> referenceEntry2) {
            return newEntry(segment, referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry2);
        }

        public <K, V> void copyWriteEntry(com.google.common.cache.ReferenceEntry<K, V> referenceEntry, com.google.common.cache.ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setWriteTime(referenceEntry.getWriteTime());
            com.google.common.cache.LocalCache.e(referenceEntry.getPreviousInWriteQueue(), referenceEntry2);
            com.google.common.cache.LocalCache.e(referenceEntry2, referenceEntry.getNextInWriteQueue());
            com.google.common.cache.LocalCache.z(referenceEntry);
        }

        public abstract <K, V> com.google.common.cache.ReferenceEntry<K, V> newEntry(com.google.common.cache.LocalCache.Segment<K, V> segment, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.cache.ReferenceEntry<K, V> referenceEntry);
    }

    public final class EntryIterator extends com.google.common.cache.LocalCache<K, V>.HashIterator<java.util.Map.Entry<K, V>> {
        public EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public java.util.Map.Entry<K, V> next() {
            return c();
        }
    }

    public final class EntrySet extends com.google.common.cache.LocalCache<K, V>.AbstractCacheSet<java.util.Map.Entry<K, V>> {
        public EntrySet(java.util.concurrent.ConcurrentMap<?, ?> concurrentMap) {
            super(concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            java.util.Map.Entry entry;
            java.lang.Object key;
            java.lang.Object obj2;
            return (obj instanceof java.util.Map.Entry) && (key = (entry = (java.util.Map.Entry) obj).getKey()) != null && (obj2 = com.google.common.cache.LocalCache.this.get(key)) != null && com.google.common.cache.LocalCache.this.x.equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
            return new com.google.common.cache.LocalCache.EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            java.util.Map.Entry entry;
            java.lang.Object key;
            return (obj instanceof java.util.Map.Entry) && (key = (entry = (java.util.Map.Entry) obj).getKey()) != null && com.google.common.cache.LocalCache.this.remove(key, entry.getValue());
        }
    }

    public abstract class HashIterator<T> implements java.util.Iterator<T> {
        public int n;
        public int t = -1;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public com.google.common.cache.LocalCache.Segment<K, V> u;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> v;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.cache.ReferenceEntry<K, V> w;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.cache.LocalCache<K, V>.WriteThroughEntry x;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.cache.LocalCache<K, V>.WriteThroughEntry y;

        public HashIterator() {
            this.n = com.google.common.cache.LocalCache.this.u.length - 1;
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
                com.google.common.cache.LocalCache.Segment<K, V>[] segmentArr = com.google.common.cache.LocalCache.this.u;
                this.n = i - 1;
                com.google.common.cache.LocalCache.Segment<K, V> segment = segmentArr[i];
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

        public boolean b(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            try {
                long read = com.google.common.cache.LocalCache.this.H.read();
                K key = referenceEntry.getKey();
                java.lang.Object p = com.google.common.cache.LocalCache.this.p(referenceEntry, read);
                if (p == null) {
                    this.u.postReadCleanup();
                    return false;
                }
                this.x = new com.google.common.cache.LocalCache.WriteThroughEntry(key, p);
                this.u.postReadCleanup();
                return true;
            } catch (java.lang.Throwable th) {
                this.u.postReadCleanup();
                throw th;
            }
        }

        public com.google.common.cache.LocalCache<K, V>.WriteThroughEntry c() {
            com.google.common.cache.LocalCache<K, V>.WriteThroughEntry writeThroughEntry = this.x;
            if (writeThroughEntry == null) {
                throw new java.util.NoSuchElementException();
            }
            this.y = writeThroughEntry;
            a();
            return this.y;
        }

        public boolean d() {
            com.google.common.cache.ReferenceEntry<K, V> referenceEntry = this.w;
            if (referenceEntry == null) {
                return false;
            }
            while (true) {
                this.w = referenceEntry.getNext();
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry2 = this.w;
                if (referenceEntry2 == null) {
                    return false;
                }
                if (b(referenceEntry2)) {
                    return true;
                }
                referenceEntry = this.w;
            }
        }

        public boolean e() {
            while (true) {
                int i = this.t;
                if (i < 0) {
                    return false;
                }
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> atomicReferenceArray = this.v;
                this.t = i - 1;
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i);
                this.w = referenceEntry;
                if (referenceEntry != null && (b(referenceEntry) || d())) {
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
            com.google.common.base.Preconditions.checkState(this.y != null);
            com.google.common.cache.LocalCache.this.remove(this.y.getKey());
            this.y = null;
        }
    }

    public final class KeyIterator extends com.google.common.cache.LocalCache<K, V>.HashIterator<K> {
        public KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    public final class KeySet extends com.google.common.cache.LocalCache<K, V>.AbstractCacheSet<K> {
        public KeySet(java.util.concurrent.ConcurrentMap<?, ?> concurrentMap) {
            super(concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return this.n.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<K> iterator() {
            return new com.google.common.cache.LocalCache.KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            return this.n.remove(obj) != null;
        }
    }

    public static final class LoadingSerializationProxy<K, V> extends com.google.common.cache.LocalCache.ManualSerializationProxy<K, V> implements com.google.common.cache.LoadingCache<K, V> {
        private static final long serialVersionUID = 1;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient com.google.common.cache.LoadingCache<K, V> autoDelegate;

        public LoadingSerializationProxy(com.google.common.cache.LocalCache<K, V> localCache) {
            super(localCache);
        }

        private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.autoDelegate = (com.google.common.cache.LoadingCache<K, V>) recreateCacheBuilder().build(this.loader);
        }

        private java.lang.Object readResolve() {
            return this.autoDelegate;
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K k) {
            return this.autoDelegate.apply(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K k) throws java.util.concurrent.ExecutionException {
            return this.autoDelegate.get(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public com.google.common.collect.ImmutableMap<K, V> getAll(java.lang.Iterable<? extends K> iterable) throws java.util.concurrent.ExecutionException {
            return this.autoDelegate.getAll(iterable);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K k) {
            return this.autoDelegate.getUnchecked(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K k) {
            this.autoDelegate.refresh(k);
        }
    }

    public static class LoadingValueReference<K, V> implements com.google.common.cache.LocalCache.ValueReference<K, V> {
        public volatile com.google.common.cache.LocalCache.ValueReference<K, V> n;
        public final com.google.common.util.concurrent.SettableFuture<V> t;
        public final com.google.common.base.Stopwatch u;

        /* renamed from: com.google.common.cache.LocalCache$LoadingValueReference$1, reason: invalid class name */
        public class AnonymousClass1 implements com.google.common.base.Function<V, V> {
            public AnonymousClass1() {
            }

            @Override // com.google.common.base.Function
            public V apply(V v) {
                com.google.common.cache.LocalCache.LoadingValueReference.this.i(v);
                return v;
            }
        }

        public LoadingValueReference() {
            this(com.google.common.cache.LocalCache.L());
        }

        public LoadingValueReference(com.google.common.cache.LocalCache.ValueReference<K, V> valueReference) {
            this.t = com.google.common.util.concurrent.SettableFuture.create();
            this.u = com.google.common.base.Stopwatch.createUnstarted();
            this.n = valueReference;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void a(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
            if (v != null) {
                i(v);
            } else {
                this.n = com.google.common.cache.LocalCache.L();
            }
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int b() {
            return this.n.b();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V c() throws java.util.concurrent.ExecutionException {
            return (V) com.google.common.util.concurrent.Uninterruptibles.getUninterruptibly(this.t);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public com.google.common.cache.LocalCache.ValueReference<K, V> d(java.lang.ref.ReferenceQueue<V> referenceQueue, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v, com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public long e() {
            return this.u.elapsed(java.util.concurrent.TimeUnit.NANOSECONDS);
        }

        public final com.google.common.util.concurrent.ListenableFuture<V> f(java.lang.Throwable th) {
            return com.google.common.util.concurrent.Futures.immediateFailedFuture(th);
        }

        public com.google.common.cache.LocalCache.ValueReference<K, V> g() {
            return this.n;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V get() {
            return this.n.get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public com.google.common.cache.ReferenceEntry<K, V> getEntry() {
            return null;
        }

        public com.google.common.util.concurrent.ListenableFuture<V> h(K k, com.google.common.cache.CacheLoader<? super K, V> cacheLoader) {
            try {
                this.u.start();
                V v = this.n.get();
                if (v == null) {
                    V load = cacheLoader.load(k);
                    return i(load) ? this.t : com.google.common.util.concurrent.Futures.immediateFuture(load);
                }
                com.google.common.util.concurrent.ListenableFuture<V> reload = cacheLoader.reload(k, v);
                return reload == null ? com.google.common.util.concurrent.Futures.immediateFuture(null) : com.google.common.util.concurrent.Futures.transform(reload, new com.google.common.cache.LocalCache.LoadingValueReference.AnonymousClass1(), com.google.common.util.concurrent.MoreExecutors.directExecutor());
            } catch (java.lang.Throwable th) {
                com.google.common.util.concurrent.ListenableFuture<V> f = j(th) ? this.t : f(th);
                if (th instanceof java.lang.InterruptedException) {
                    java.lang.Thread.currentThread().interrupt();
                }
                return f;
            }
        }

        public boolean i(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
            return this.t.set(v);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return this.n.isActive();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return true;
        }

        public boolean j(java.lang.Throwable th) {
            return this.t.setException(th);
        }
    }

    public static class LocalLoadingCache<K, V> extends com.google.common.cache.LocalCache.LocalManualCache<K, V> implements com.google.common.cache.LoadingCache<K, V> {
        private static final long serialVersionUID = 1;

        public LocalLoadingCache(com.google.common.cache.CacheBuilder<? super K, ? super V> cacheBuilder, com.google.common.cache.CacheLoader<? super K, V> cacheLoader) {
            super(new com.google.common.cache.LocalCache(cacheBuilder, (com.google.common.cache.CacheLoader) com.google.common.base.Preconditions.checkNotNull(cacheLoader)), null);
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K k) {
            return getUnchecked(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K k) throws java.util.concurrent.ExecutionException {
            return this.localCache.q(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public com.google.common.collect.ImmutableMap<K, V> getAll(java.lang.Iterable<? extends K> iterable) throws java.util.concurrent.ExecutionException {
            return this.localCache.m(iterable);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K k) {
            try {
                return get(k);
            } catch (java.util.concurrent.ExecutionException e) {
                throw new com.google.common.util.concurrent.UncheckedExecutionException(e.getCause());
            }
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K k) {
            this.localCache.G(k);
        }

        @Override // com.google.common.cache.LocalCache.LocalManualCache
        public java.lang.Object writeReplace() {
            return new com.google.common.cache.LocalCache.LoadingSerializationProxy(this.localCache);
        }
    }

    public static class LocalManualCache<K, V> implements com.google.common.cache.Cache<K, V>, java.io.Serializable {
        private static final long serialVersionUID = 1;
        final com.google.common.cache.LocalCache<K, V> localCache;

        /* renamed from: com.google.common.cache.LocalCache$LocalManualCache$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.cache.CacheLoader<java.lang.Object, V> {
            public final /* synthetic */ java.util.concurrent.Callable n;

            public AnonymousClass1(java.util.concurrent.Callable callable) {
                this.n = callable;
            }

            @Override // com.google.common.cache.CacheLoader
            public V load(java.lang.Object obj) throws java.lang.Exception {
                return (V) this.n.call();
            }
        }

        public LocalManualCache(com.google.common.cache.CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new com.google.common.cache.LocalCache(cacheBuilder, null));
        }

        private LocalManualCache(com.google.common.cache.LocalCache<K, V> localCache) {
            this.localCache = localCache;
        }

        public /* synthetic */ LocalManualCache(com.google.common.cache.LocalCache localCache, com.google.common.cache.LocalCache.AnonymousClass1 anonymousClass1) {
            this(localCache);
        }

        @Override // com.google.common.cache.Cache
        public java.util.concurrent.ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        @Override // com.google.common.cache.Cache
        public void cleanUp() {
            this.localCache.b();
        }

        @Override // com.google.common.cache.Cache
        public V get(K k, java.util.concurrent.Callable<? extends V> callable) throws java.util.concurrent.ExecutionException {
            com.google.common.base.Preconditions.checkNotNull(callable);
            return this.localCache.l(k, new com.google.common.cache.LocalCache.LocalManualCache.AnonymousClass1(callable));
        }

        @Override // com.google.common.cache.Cache
        public com.google.common.collect.ImmutableMap<K, V> getAllPresent(java.lang.Iterable<?> iterable) {
            return this.localCache.n(iterable);
        }

        @Override // com.google.common.cache.Cache
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public V getIfPresent(java.lang.Object obj) {
            return this.localCache.o(obj);
        }

        @Override // com.google.common.cache.Cache
        public void invalidate(java.lang.Object obj) {
            com.google.common.base.Preconditions.checkNotNull(obj);
            this.localCache.remove(obj);
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll() {
            this.localCache.clear();
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll(java.lang.Iterable<?> iterable) {
            this.localCache.s(iterable);
        }

        @Override // com.google.common.cache.Cache
        public void put(K k, V v) {
            this.localCache.put(k, v);
        }

        @Override // com.google.common.cache.Cache
        public void putAll(java.util.Map<? extends K, ? extends V> map) {
            this.localCache.putAll(map);
        }

        @Override // com.google.common.cache.Cache
        public long size() {
            return this.localCache.v();
        }

        @Override // com.google.common.cache.Cache
        public com.google.common.cache.CacheStats stats() {
            com.google.common.cache.AbstractCache.SimpleStatsCounter simpleStatsCounter = new com.google.common.cache.AbstractCache.SimpleStatsCounter();
            simpleStatsCounter.incrementBy(this.localCache.J);
            for (com.google.common.cache.LocalCache.Segment<K, V> segment : this.localCache.u) {
                simpleStatsCounter.incrementBy(segment.statsCounter);
            }
            return simpleStatsCounter.snapshot();
        }

        java.lang.Object writeReplace() {
            return new com.google.common.cache.LocalCache.ManualSerializationProxy(this.localCache);
        }
    }

    public static class ManualSerializationProxy<K, V> extends com.google.common.cache.ForwardingCache<K, V> implements java.io.Serializable {
        private static final long serialVersionUID = 1;
        final int concurrencyLevel;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient com.google.common.cache.Cache<K, V> delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final com.google.common.base.Equivalence<java.lang.Object> keyEquivalence;
        final com.google.common.cache.LocalCache.Strength keyStrength;
        final com.google.common.cache.CacheLoader<? super K, V> loader;
        final long maxWeight;
        final com.google.common.cache.RemovalListener<? super K, ? super V> removalListener;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        final com.google.common.base.Ticker ticker;
        final com.google.common.base.Equivalence<java.lang.Object> valueEquivalence;
        final com.google.common.cache.LocalCache.Strength valueStrength;
        final com.google.common.cache.Weigher<K, V> weigher;

        private ManualSerializationProxy(com.google.common.cache.LocalCache.Strength strength, com.google.common.cache.LocalCache.Strength strength2, com.google.common.base.Equivalence<java.lang.Object> equivalence, com.google.common.base.Equivalence<java.lang.Object> equivalence2, long j, long j2, long j3, com.google.common.cache.Weigher<K, V> weigher, int i, com.google.common.cache.RemovalListener<? super K, ? super V> removalListener, com.google.common.base.Ticker ticker, com.google.common.cache.CacheLoader<? super K, V> cacheLoader) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = j;
            this.expireAfterAccessNanos = j2;
            this.maxWeight = j3;
            this.weigher = weigher;
            this.concurrencyLevel = i;
            this.removalListener = removalListener;
            this.ticker = (ticker == com.google.common.base.Ticker.systemTicker() || ticker == com.google.common.cache.CacheBuilder.t) ? null : ticker;
            this.loader = cacheLoader;
        }

        public ManualSerializationProxy(com.google.common.cache.LocalCache<K, V> localCache) {
            this(localCache.y, localCache.z, localCache.w, localCache.x, localCache.D, localCache.C, localCache.A, localCache.B, localCache.v, localCache.G, localCache.H, localCache.K);
        }

        private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = (com.google.common.cache.Cache<K, V>) recreateCacheBuilder().build();
        }

        private java.lang.Object readResolve() {
            return this.delegate;
        }

        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        public com.google.common.cache.Cache<K, V> delegate() {
            return this.delegate;
        }

        public com.google.common.cache.CacheBuilder<K, V> recreateCacheBuilder() {
            com.google.common.cache.CacheBuilder<K, V> cacheBuilder = (com.google.common.cache.CacheBuilder<K, V>) com.google.common.cache.CacheBuilder.newBuilder().s(this.keyStrength).t(this.valueStrength).q(this.keyEquivalence).u(this.valueEquivalence).concurrencyLevel(this.concurrencyLevel).removalListener(this.removalListener);
            cacheBuilder.a = false;
            long j = this.expireAfterWriteNanos;
            if (j > 0) {
                cacheBuilder.expireAfterWrite(j, java.util.concurrent.TimeUnit.NANOSECONDS);
            }
            long j2 = this.expireAfterAccessNanos;
            if (j2 > 0) {
                cacheBuilder.expireAfterAccess(j2, java.util.concurrent.TimeUnit.NANOSECONDS);
            }
            com.google.common.cache.Weigher weigher = this.weigher;
            if (weigher != com.google.common.cache.CacheBuilder.OneWeigher.INSTANCE) {
                cacheBuilder.weigher(weigher);
                long j3 = this.maxWeight;
                if (j3 != -1) {
                    cacheBuilder.maximumWeight(j3);
                }
            } else {
                long j4 = this.maxWeight;
                if (j4 != -1) {
                    cacheBuilder.maximumSize(j4);
                }
            }
            com.google.common.base.Ticker ticker = this.ticker;
            if (ticker != null) {
                cacheBuilder.ticker(ticker);
            }
            return cacheBuilder;
        }
    }

    public enum NullEntry implements com.google.common.cache.ReferenceEntry<java.lang.Object, java.lang.Object> {
        INSTANCE;

        @Override // com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return 0L;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            return 0;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public java.lang.Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<java.lang.Object, java.lang.Object> getNext() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<java.lang.Object, java.lang.Object> getNextInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<java.lang.Object, java.lang.Object> getNextInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<java.lang.Object, java.lang.Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<java.lang.Object, java.lang.Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public com.google.common.cache.LocalCache.ValueReference<java.lang.Object, java.lang.Object> getValueReference() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return 0L;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(com.google.common.cache.ReferenceEntry<java.lang.Object, java.lang.Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(com.google.common.cache.ReferenceEntry<java.lang.Object, java.lang.Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(com.google.common.cache.ReferenceEntry<java.lang.Object, java.lang.Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(com.google.common.cache.ReferenceEntry<java.lang.Object, java.lang.Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(com.google.common.cache.LocalCache.ValueReference<java.lang.Object, java.lang.Object> valueReference) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
        }
    }

    public static class Segment<K, V> extends java.util.concurrent.locks.ReentrantLock {

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        final java.util.Queue<com.google.common.cache.ReferenceEntry<K, V>> accessQueue;
        volatile int count;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        final java.lang.ref.ReferenceQueue<K> keyReferenceQueue;

        @com.google.j2objc.annotations.Weak
        final com.google.common.cache.LocalCache<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final java.util.concurrent.atomic.AtomicInteger readCount = new java.util.concurrent.atomic.AtomicInteger();
        final java.util.Queue<com.google.common.cache.ReferenceEntry<K, V>> recencyQueue;
        final com.google.common.cache.AbstractCache.StatsCounter statsCounter;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        volatile java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> table;
        int threshold;

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        long totalWeight;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        final java.lang.ref.ReferenceQueue<V> valueReferenceQueue;

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        final java.util.Queue<com.google.common.cache.ReferenceEntry<K, V>> writeQueue;

        /* renamed from: com.google.common.cache.LocalCache$Segment$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public final /* synthetic */ java.lang.Object n;
            public final /* synthetic */ int t;
            public final /* synthetic */ com.google.common.cache.LocalCache.LoadingValueReference u;
            public final /* synthetic */ com.google.common.util.concurrent.ListenableFuture v;

            public AnonymousClass1(java.lang.Object obj, int i, com.google.common.cache.LocalCache.LoadingValueReference loadingValueReference, com.google.common.util.concurrent.ListenableFuture listenableFuture) {
                this.n = obj;
                this.t = i;
                this.u = loadingValueReference;
                this.v = listenableFuture;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.google.common.cache.LocalCache.Segment.this.getAndRecordStats(this.n, this.t, this.u, this.v);
                } catch (java.lang.Throwable th) {
                    com.google.common.cache.LocalCache.O.log(java.util.logging.Level.WARNING, "Exception thrown during refresh", th);
                    this.u.j(th);
                }
            }
        }

        public Segment(com.google.common.cache.LocalCache<K, V> localCache, int i, long j, com.google.common.cache.AbstractCache.StatsCounter statsCounter) {
            this.map = localCache;
            this.maxSegmentWeight = j;
            this.statsCounter = (com.google.common.cache.AbstractCache.StatsCounter) com.google.common.base.Preconditions.checkNotNull(statsCounter);
            initTable(newEntryArray(i));
            this.keyReferenceQueue = localCache.O() ? new java.lang.ref.ReferenceQueue<>() : null;
            this.valueReferenceQueue = localCache.P() ? new java.lang.ref.ReferenceQueue<>() : null;
            this.recencyQueue = localCache.N() ? new java.util.concurrent.ConcurrentLinkedQueue<>() : com.google.common.cache.LocalCache.h();
            this.writeQueue = localCache.R() ? new com.google.common.cache.LocalCache.WriteQueue<>() : com.google.common.cache.LocalCache.h();
            this.accessQueue = localCache.N() ? new com.google.common.cache.LocalCache.AccessQueue<>() : com.google.common.cache.LocalCache.h();
        }

        public void cleanUp() {
            runLockedCleanup(this.map.H.read());
            runUnlockedCleanup();
        }

        public void clear() {
            com.google.common.cache.RemovalCause removalCause;
            if (this.count != 0) {
                lock();
                try {
                    preWriteCleanup(this.map.H.read());
                    java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (com.google.common.cache.ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                            if (referenceEntry.getValueReference().isActive()) {
                                K key = referenceEntry.getKey();
                                V v = referenceEntry.getValueReference().get();
                                if (key != null && v != null) {
                                    removalCause = com.google.common.cache.RemovalCause.EXPLICIT;
                                    enqueueNotification(key, referenceEntry.getHash(), v, referenceEntry.getValueReference().b(), removalCause);
                                }
                                removalCause = com.google.common.cache.RemovalCause.COLLECTED;
                                enqueueNotification(key, referenceEntry.getHash(), v, referenceEntry.getValueReference().b(), removalCause);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    clearReferenceQueues();
                    this.writeQueue.clear();
                    this.accessQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
        }

        public void clearKeyReferenceQueue() {
            while (this.keyReferenceQueue.poll() != null) {
            }
        }

        public void clearReferenceQueues() {
            if (this.map.O()) {
                clearKeyReferenceQueue();
            }
            if (this.map.P()) {
                clearValueReferenceQueue();
            }
        }

        public void clearValueReferenceQueue() {
            while (this.valueReferenceQueue.poll() != null) {
            }
        }

        public boolean containsKey(java.lang.Object obj, int i) {
            try {
                if (this.count == 0) {
                    return false;
                }
                com.google.common.cache.ReferenceEntry<K, V> liveEntry = getLiveEntry(obj, i, this.map.H.read());
                if (liveEntry == null) {
                    return false;
                }
                return liveEntry.getValueReference().get() != null;
            } finally {
                postReadCleanup();
            }
        }

        @com.google.common.annotations.VisibleForTesting
        public boolean containsValue(java.lang.Object obj) {
            try {
                if (this.count != 0) {
                    long read = this.map.H.read();
                    java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        for (com.google.common.cache.ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                            V liveValue = getLiveValue(referenceEntry, read);
                            if (liveValue != null && this.map.x.equivalent(obj, liveValue)) {
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

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public com.google.common.cache.ReferenceEntry<K, V> copyEntry(com.google.common.cache.ReferenceEntry<K, V> referenceEntry, com.google.common.cache.ReferenceEntry<K, V> referenceEntry2) {
            if (referenceEntry.getKey() == null) {
                return null;
            }
            com.google.common.cache.LocalCache.ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            V v = valueReference.get();
            if (v == null && valueReference.isActive()) {
                return null;
            }
            com.google.common.cache.ReferenceEntry<K, V> copyEntry = this.map.I.copyEntry(this, referenceEntry, referenceEntry2);
            copyEntry.setValueReference(valueReference.d(this.valueReferenceQueue, v, copyEntry));
            return copyEntry;
        }

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public void drainKeyReferenceQueue() {
            int i = 0;
            do {
                java.lang.ref.Reference<? extends K> poll = this.keyReferenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.B((com.google.common.cache.ReferenceEntry) poll);
                i++;
            } while (i != 16);
        }

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public void drainRecencyQueue() {
            while (true) {
                com.google.common.cache.ReferenceEntry<K, V> poll = this.recencyQueue.poll();
                if (poll == null) {
                    return;
                }
                if (this.accessQueue.contains(poll)) {
                    this.accessQueue.add(poll);
                }
            }
        }

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public void drainReferenceQueues() {
            if (this.map.O()) {
                drainKeyReferenceQueue();
            }
            if (this.map.P()) {
                drainValueReferenceQueue();
            }
        }

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public void drainValueReferenceQueue() {
            int i = 0;
            do {
                java.lang.ref.Reference<? extends V> poll = this.valueReferenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.C((com.google.common.cache.LocalCache.ValueReference) poll);
                i++;
            } while (i != 16);
        }

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public void enqueueNotification(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v, int i2, com.google.common.cache.RemovalCause removalCause) {
            this.totalWeight -= i2;
            if (removalCause.wasEvicted()) {
                this.statsCounter.recordEviction();
            }
            if (this.map.F != com.google.common.cache.LocalCache.Q) {
                this.map.F.offer(com.google.common.cache.RemovalNotification.create(k, v, removalCause));
            }
        }

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public void evictEntries(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            if (this.map.i()) {
                drainRecencyQueue();
                if (referenceEntry.getValueReference().b() > this.maxSegmentWeight && !removeEntry(referenceEntry, referenceEntry.getHash(), com.google.common.cache.RemovalCause.SIZE)) {
                    throw new java.lang.AssertionError();
                }
                while (this.totalWeight > this.maxSegmentWeight) {
                    com.google.common.cache.ReferenceEntry<K, V> nextEvictable = getNextEvictable();
                    if (!removeEntry(nextEvictable, nextEvictable.getHash(), com.google.common.cache.RemovalCause.SIZE)) {
                        throw new java.lang.AssertionError();
                    }
                }
            }
        }

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public void expand() {
            java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i = this.count;
            java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> newEntryArray = newEntryArray(length << 1);
            this.threshold = (newEntryArray.length() * 3) / 4;
            int length2 = newEntryArray.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i2);
                if (referenceEntry != null) {
                    com.google.common.cache.ReferenceEntry<K, V> next = referenceEntry.getNext();
                    int hash = referenceEntry.getHash() & length2;
                    if (next == null) {
                        newEntryArray.set(hash, referenceEntry);
                    } else {
                        com.google.common.cache.ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                referenceEntry2 = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        newEntryArray.set(hash, referenceEntry2);
                        while (referenceEntry != referenceEntry2) {
                            int hash3 = referenceEntry.getHash() & length2;
                            com.google.common.cache.ReferenceEntry<K, V> copyEntry = copyEntry(referenceEntry, newEntryArray.get(hash3));
                            if (copyEntry != null) {
                                newEntryArray.set(hash3, copyEntry);
                            } else {
                                removeCollectedEntry(referenceEntry);
                                i--;
                            }
                            referenceEntry = referenceEntry.getNext();
                        }
                    }
                }
            }
            this.table = newEntryArray;
            this.count = i;
        }

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public void expireEntries(long j) {
            com.google.common.cache.ReferenceEntry<K, V> peek;
            com.google.common.cache.ReferenceEntry<K, V> peek2;
            drainRecencyQueue();
            do {
                peek = this.writeQueue.peek();
                if (peek == null || !this.map.t(peek, j)) {
                    do {
                        peek2 = this.accessQueue.peek();
                        if (peek2 == null || !this.map.t(peek2, j)) {
                            return;
                        }
                    } while (removeEntry(peek2, peek2.getHash(), com.google.common.cache.RemovalCause.EXPIRED));
                    throw new java.lang.AssertionError();
                }
            } while (removeEntry(peek, peek.getHash(), com.google.common.cache.RemovalCause.EXPIRED));
            throw new java.lang.AssertionError();
        }

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public V get(java.lang.Object obj, int i) {
            try {
                if (this.count != 0) {
                    long read = this.map.H.read();
                    com.google.common.cache.ReferenceEntry<K, V> liveEntry = getLiveEntry(obj, i, read);
                    if (liveEntry == null) {
                        return null;
                    }
                    V v = liveEntry.getValueReference().get();
                    if (v != null) {
                        recordRead(liveEntry, read);
                        return scheduleRefresh(liveEntry, liveEntry.getKey(), i, v, read, this.map.K);
                    }
                    tryDrainReferenceQueues();
                }
                return null;
            } finally {
                postReadCleanup();
            }
        }

        public V get(K k, int i, com.google.common.cache.CacheLoader<? super K, V> cacheLoader) throws java.util.concurrent.ExecutionException {
            com.google.common.cache.ReferenceEntry<K, V> entry;
            com.google.common.base.Preconditions.checkNotNull(k);
            com.google.common.base.Preconditions.checkNotNull(cacheLoader);
            try {
                try {
                    if (this.count != 0 && (entry = getEntry(k, i)) != null) {
                        long read = this.map.H.read();
                        V liveValue = getLiveValue(entry, read);
                        if (liveValue != null) {
                            recordRead(entry, read);
                            this.statsCounter.recordHits(1);
                            return scheduleRefresh(entry, k, i, liveValue, read, cacheLoader);
                        }
                        com.google.common.cache.LocalCache.ValueReference<K, V> valueReference = entry.getValueReference();
                        if (valueReference.isLoading()) {
                            return waitForLoadingValue(entry, k, valueReference);
                        }
                    }
                    return lockedGetOrLoad(k, i, cacheLoader);
                } catch (java.util.concurrent.ExecutionException e) {
                    java.lang.Throwable cause = e.getCause();
                    if (cause instanceof java.lang.Error) {
                        throw new com.google.common.util.concurrent.ExecutionError((java.lang.Error) cause);
                    }
                    if (cause instanceof java.lang.RuntimeException) {
                        throw new com.google.common.util.concurrent.UncheckedExecutionException(cause);
                    }
                    throw e;
                }
            } finally {
                postReadCleanup();
            }
        }

        public V getAndRecordStats(K k, int i, com.google.common.cache.LocalCache.LoadingValueReference<K, V> loadingValueReference, com.google.common.util.concurrent.ListenableFuture<V> listenableFuture) throws java.util.concurrent.ExecutionException {
            V v;
            try {
                v = (V) com.google.common.util.concurrent.Uninterruptibles.getUninterruptibly(listenableFuture);
            } catch (java.lang.Throwable th) {
                th = th;
                v = null;
            }
            try {
                if (v != null) {
                    this.statsCounter.recordLoadSuccess(loadingValueReference.e());
                    storeLoadedValue(k, i, loadingValueReference, v);
                    return v;
                }
                throw new com.google.common.cache.CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (v == null) {
                    this.statsCounter.recordLoadException(loadingValueReference.e());
                    removeLoadingValue(k, i, loadingValueReference);
                }
                throw th;
            }
        }

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.cache.ReferenceEntry<K, V> getEntry(java.lang.Object obj, int i) {
            for (com.google.common.cache.ReferenceEntry<K, V> first = getFirst(i); first != null; first = first.getNext()) {
                if (first.getHash() == i) {
                    K key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.w.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        public com.google.common.cache.ReferenceEntry<K, V> getFirst(int i) {
            return this.table.get(i & (r0.length() - 1));
        }

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.cache.ReferenceEntry<K, V> getLiveEntry(java.lang.Object obj, int i, long j) {
            com.google.common.cache.ReferenceEntry<K, V> entry = getEntry(obj, i);
            if (entry == null) {
                return null;
            }
            if (!this.map.t(entry, j)) {
                return entry;
            }
            tryExpireEntries(j);
            return null;
        }

        public V getLiveValue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry, long j) {
            if (referenceEntry.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = referenceEntry.getValueReference().get();
            if (v == null) {
                tryDrainReferenceQueues();
                return null;
            }
            if (!this.map.t(referenceEntry, j)) {
                return v;
            }
            tryExpireEntries(j);
            return null;
        }

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public com.google.common.cache.ReferenceEntry<K, V> getNextEvictable() {
            for (com.google.common.cache.ReferenceEntry<K, V> referenceEntry : this.accessQueue) {
                if (referenceEntry.getValueReference().b() > 0) {
                    return referenceEntry;
                }
            }
            throw new java.lang.AssertionError();
        }

        public void initTable(java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (!this.map.g()) {
                int i = this.threshold;
                if (i == this.maxSegmentWeight) {
                    this.threshold = i + 1;
                }
            }
            this.table = atomicReferenceArray;
        }

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.cache.LocalCache.LoadingValueReference<K, V> insertLoadingValueReference(K k, int i, boolean z) {
            lock();
            try {
                long read = this.map.H.read();
                preWriteCleanup(read);
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry = (com.google.common.cache.ReferenceEntry) atomicReferenceArray.get(length);
                for (com.google.common.cache.ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    java.lang.Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.w.equivalent(k, key)) {
                        com.google.common.cache.LocalCache.ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                        if (!valueReference.isLoading() && (!z || read - referenceEntry2.getWriteTime() >= this.map.E)) {
                            this.modCount++;
                            com.google.common.cache.LocalCache.LoadingValueReference<K, V> loadingValueReference = new com.google.common.cache.LocalCache.LoadingValueReference<>(valueReference);
                            referenceEntry2.setValueReference(loadingValueReference);
                            return loadingValueReference;
                        }
                        unlock();
                        postWriteCleanup();
                        return null;
                    }
                }
                this.modCount++;
                com.google.common.cache.LocalCache.LoadingValueReference<K, V> loadingValueReference2 = new com.google.common.cache.LocalCache.LoadingValueReference<>();
                com.google.common.cache.ReferenceEntry<K, V> newEntry = newEntry(k, i, referenceEntry);
                newEntry.setValueReference(loadingValueReference2);
                atomicReferenceArray.set(length, newEntry);
                return loadingValueReference2;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public com.google.common.util.concurrent.ListenableFuture<V> loadAsync(K k, int i, com.google.common.cache.LocalCache.LoadingValueReference<K, V> loadingValueReference, com.google.common.cache.CacheLoader<? super K, V> cacheLoader) {
            com.google.common.util.concurrent.ListenableFuture<V> h = loadingValueReference.h(k, cacheLoader);
            h.addListener(new com.google.common.cache.LocalCache.Segment.AnonymousClass1(k, i, loadingValueReference, h), com.google.common.util.concurrent.MoreExecutors.directExecutor());
            return h;
        }

        public V loadSync(K k, int i, com.google.common.cache.LocalCache.LoadingValueReference<K, V> loadingValueReference, com.google.common.cache.CacheLoader<? super K, V> cacheLoader) throws java.util.concurrent.ExecutionException {
            return getAndRecordStats(k, i, loadingValueReference, loadingValueReference.h(k, cacheLoader));
        }

        public V lockedGetOrLoad(K k, int i, com.google.common.cache.CacheLoader<? super K, V> cacheLoader) throws java.util.concurrent.ExecutionException {
            com.google.common.cache.LocalCache.LoadingValueReference<K, V> loadingValueReference;
            com.google.common.cache.LocalCache.ValueReference<K, V> valueReference;
            boolean z;
            V loadSync;
            lock();
            try {
                long read = this.map.H.read();
                preWriteCleanup(read);
                int i2 = this.count - 1;
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    loadingValueReference = null;
                    if (referenceEntry2 == null) {
                        valueReference = null;
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.w.equivalent(k, key)) {
                        com.google.common.cache.LocalCache.ValueReference<K, V> valueReference2 = referenceEntry2.getValueReference();
                        if (valueReference2.isLoading()) {
                            z = false;
                            valueReference = valueReference2;
                        } else {
                            V v = valueReference2.get();
                            if (v == null) {
                                enqueueNotification(key, i, v, valueReference2.b(), com.google.common.cache.RemovalCause.COLLECTED);
                            } else {
                                if (!this.map.t(referenceEntry2, read)) {
                                    recordLockedRead(referenceEntry2, read);
                                    this.statsCounter.recordHits(1);
                                    return v;
                                }
                                enqueueNotification(key, i, v, valueReference2.b(), com.google.common.cache.RemovalCause.EXPIRED);
                            }
                            this.writeQueue.remove(referenceEntry2);
                            this.accessQueue.remove(referenceEntry2);
                            this.count = i2;
                            valueReference = valueReference2;
                        }
                    } else {
                        referenceEntry2 = referenceEntry2.getNext();
                    }
                }
                z = true;
                if (z) {
                    loadingValueReference = new com.google.common.cache.LocalCache.LoadingValueReference<>();
                    if (referenceEntry2 == null) {
                        referenceEntry2 = newEntry(k, i, referenceEntry);
                        referenceEntry2.setValueReference(loadingValueReference);
                        atomicReferenceArray.set(length, referenceEntry2);
                    } else {
                        referenceEntry2.setValueReference(loadingValueReference);
                    }
                }
                if (!z) {
                    return waitForLoadingValue(referenceEntry2, k, valueReference);
                }
                try {
                    synchronized (referenceEntry2) {
                        loadSync = loadSync(k, i, loadingValueReference, cacheLoader);
                    }
                    return loadSync;
                } finally {
                    this.statsCounter.recordMisses(1);
                }
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public com.google.common.cache.ReferenceEntry<K, V> newEntry(K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            return this.map.I.newEntry(this, com.google.common.base.Preconditions.checkNotNull(k), i, referenceEntry);
        }

        public java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> newEntryArray(int i) {
            return new java.util.concurrent.atomic.AtomicReferenceArray<>(i);
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        public void postWriteCleanup() {
            runUnlockedCleanup();
        }

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public void preWriteCleanup(long j) {
            runLockedCleanup(j);
        }

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public V put(K k, int i, V v, boolean z) {
            int i2;
            lock();
            try {
                long read = this.map.H.read();
                preWriteCleanup(read);
                if (this.count + 1 > this.threshold) {
                    expand();
                }
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        this.modCount++;
                        com.google.common.cache.ReferenceEntry<K, V> newEntry = newEntry(k, i, referenceEntry);
                        setValue(newEntry, k, v, read);
                        atomicReferenceArray.set(length, newEntry);
                        this.count++;
                        evictEntries(newEntry);
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.w.equivalent(k, key)) {
                        com.google.common.cache.LocalCache.ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                        V v2 = valueReference.get();
                        if (v2 != null) {
                            if (z) {
                                recordLockedRead(referenceEntry2, read);
                            } else {
                                this.modCount++;
                                enqueueNotification(k, i, v2, valueReference.b(), com.google.common.cache.RemovalCause.REPLACED);
                                setValue(referenceEntry2, k, v, read);
                                evictEntries(referenceEntry2);
                            }
                            return v2;
                        }
                        this.modCount++;
                        if (valueReference.isActive()) {
                            enqueueNotification(k, i, v2, valueReference.b(), com.google.common.cache.RemovalCause.COLLECTED);
                            setValue(referenceEntry2, k, v, read);
                            i2 = this.count;
                        } else {
                            setValue(referenceEntry2, k, v, read);
                            i2 = this.count + 1;
                        }
                        this.count = i2;
                        evictEntries(referenceEntry2);
                    } else {
                        referenceEntry2 = referenceEntry2.getNext();
                    }
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public boolean reclaimKey(com.google.common.cache.ReferenceEntry<K, V> referenceEntry, int i) {
            lock();
            try {
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
                for (com.google.common.cache.ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                    if (referenceEntry3 == referenceEntry) {
                        this.modCount++;
                        com.google.common.cache.ReferenceEntry<K, V> removeValueFromChain = removeValueFromChain(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i, referenceEntry3.getValueReference().get(), referenceEntry3.getValueReference(), com.google.common.cache.RemovalCause.COLLECTED);
                        int i2 = this.count - 1;
                        atomicReferenceArray.set(length, removeValueFromChain);
                        this.count = i2;
                        return true;
                    }
                }
                unlock();
                postWriteCleanup();
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public boolean reclaimValue(K k, int i, com.google.common.cache.LocalCache.ValueReference<K, V> valueReference) {
            lock();
            try {
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (com.google.common.cache.ReferenceEntry<K, V> referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.w.equivalent(k, key)) {
                        if (referenceEntry2.getValueReference() != valueReference) {
                            unlock();
                            if (!isHeldByCurrentThread()) {
                                postWriteCleanup();
                            }
                            return false;
                        }
                        this.modCount++;
                        com.google.common.cache.ReferenceEntry<K, V> removeValueFromChain = removeValueFromChain(referenceEntry, referenceEntry2, key, i, valueReference.get(), valueReference, com.google.common.cache.RemovalCause.COLLECTED);
                        int i2 = this.count - 1;
                        atomicReferenceArray.set(length, removeValueFromChain);
                        this.count = i2;
                        return true;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
            }
        }

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public void recordLockedRead(com.google.common.cache.ReferenceEntry<K, V> referenceEntry, long j) {
            if (this.map.D()) {
                referenceEntry.setAccessTime(j);
            }
            this.accessQueue.add(referenceEntry);
        }

        public void recordRead(com.google.common.cache.ReferenceEntry<K, V> referenceEntry, long j) {
            if (this.map.D()) {
                referenceEntry.setAccessTime(j);
            }
            this.recencyQueue.add(referenceEntry);
        }

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public void recordWrite(com.google.common.cache.ReferenceEntry<K, V> referenceEntry, int i, long j) {
            drainRecencyQueue();
            this.totalWeight += i;
            if (this.map.D()) {
                referenceEntry.setAccessTime(j);
            }
            if (this.map.F()) {
                referenceEntry.setWriteTime(j);
            }
            this.accessQueue.add(referenceEntry);
            this.writeQueue.add(referenceEntry);
        }

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public V refresh(K k, int i, com.google.common.cache.CacheLoader<? super K, V> cacheLoader, boolean z) {
            com.google.common.cache.LocalCache.LoadingValueReference<K, V> insertLoadingValueReference = insertLoadingValueReference(k, i, z);
            if (insertLoadingValueReference == null) {
                return null;
            }
            com.google.common.util.concurrent.ListenableFuture<V> loadAsync = loadAsync(k, i, insertLoadingValueReference, cacheLoader);
            if (loadAsync.isDone()) {
                try {
                    return (V) com.google.common.util.concurrent.Uninterruptibles.getUninterruptibly(loadAsync);
                } catch (java.lang.Throwable unused) {
                }
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        
            r9 = r5.getValueReference();
            r12 = r9.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        
            if (r12 == null) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
        
            r2 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
        
            r10 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
        
            r11.modCount++;
            r13 = removeValueFromChain(r4, r5, r6, r13, r12, r9, r10);
            r2 = r11.count - 1;
            r0.set(r1, r13);
            r11.count = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x006b, code lost:
        
            return r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        
            if (r9.isActive() == false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
        
            r2 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public V remove(java.lang.Object obj, int i) {
            lock();
            try {
                preWriteCleanup(this.map.H.read());
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.w.equivalent(obj, key)) {
                        break;
                    }
                    referenceEntry2 = referenceEntry2.getNext();
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        
            r10 = r6.getValueReference();
            r9 = r10.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
        
            if (r12.map.x.equivalent(r15, r9) == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
        
            r13 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
        
            r12.modCount++;
            r14 = removeValueFromChain(r5, r6, r7, r14, r9, r10, r13);
            r15 = r12.count - 1;
            r0.set(r1, r14);
            r12.count = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x006d, code lost:
        
            if (r13 != com.google.common.cache.RemovalCause.EXPLICIT) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0070, code lost:
        
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        
            if (r9 != null) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
        
            if (r10.isActive() == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
        
            r13 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean remove(java.lang.Object obj, int i, java.lang.Object obj2) {
            lock();
            try {
                preWriteCleanup(this.map.H.read());
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                boolean z = true;
                int length = (atomicReferenceArray.length() - 1) & i;
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.w.equivalent(obj, key)) {
                        break;
                    }
                    referenceEntry2 = referenceEntry2.getNext();
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public void removeCollectedEntry(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            enqueueNotification(referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry.getValueReference().get(), referenceEntry.getValueReference().b(), com.google.common.cache.RemovalCause.COLLECTED);
            this.writeQueue.remove(referenceEntry);
            this.accessQueue.remove(referenceEntry);
        }

        @com.google.common.annotations.VisibleForTesting
        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public boolean removeEntry(com.google.common.cache.ReferenceEntry<K, V> referenceEntry, int i, com.google.common.cache.RemovalCause removalCause) {
            java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i;
            com.google.common.cache.ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
            for (com.google.common.cache.ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                if (referenceEntry3 == referenceEntry) {
                    this.modCount++;
                    com.google.common.cache.ReferenceEntry<K, V> removeValueFromChain = removeValueFromChain(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i, referenceEntry3.getValueReference().get(), referenceEntry3.getValueReference(), removalCause);
                    int i2 = this.count - 1;
                    atomicReferenceArray.set(length, removeValueFromChain);
                    this.count = i2;
                    return true;
                }
            }
            return false;
        }

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public com.google.common.cache.ReferenceEntry<K, V> removeEntryFromChain(com.google.common.cache.ReferenceEntry<K, V> referenceEntry, com.google.common.cache.ReferenceEntry<K, V> referenceEntry2) {
            int i = this.count;
            com.google.common.cache.ReferenceEntry<K, V> next = referenceEntry2.getNext();
            while (referenceEntry != referenceEntry2) {
                com.google.common.cache.ReferenceEntry<K, V> copyEntry = copyEntry(referenceEntry, next);
                if (copyEntry != null) {
                    next = copyEntry;
                } else {
                    removeCollectedEntry(referenceEntry);
                    i--;
                }
                referenceEntry = referenceEntry.getNext();
            }
            this.count = i;
            return next;
        }

        public boolean removeLoadingValue(K k, int i, com.google.common.cache.LocalCache.LoadingValueReference<K, V> loadingValueReference) {
            lock();
            try {
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.w.equivalent(k, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else if (referenceEntry2.getValueReference() == loadingValueReference) {
                        if (loadingValueReference.isActive()) {
                            referenceEntry2.setValueReference(loadingValueReference.g());
                        } else {
                            atomicReferenceArray.set(length, removeEntryFromChain(referenceEntry, referenceEntry2));
                        }
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public com.google.common.cache.ReferenceEntry<K, V> removeValueFromChain(com.google.common.cache.ReferenceEntry<K, V> referenceEntry, com.google.common.cache.ReferenceEntry<K, V> referenceEntry2, @org.checkerframework.checker.nullness.compatqual.NullableDecl K k, int i, V v, com.google.common.cache.LocalCache.ValueReference<K, V> valueReference, com.google.common.cache.RemovalCause removalCause) {
            enqueueNotification(k, i, v, valueReference.b(), removalCause);
            this.writeQueue.remove(referenceEntry2);
            this.accessQueue.remove(referenceEntry2);
            if (!valueReference.isLoading()) {
                return removeEntryFromChain(referenceEntry, referenceEntry2);
            }
            valueReference.a(null);
            return referenceEntry;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0072, code lost:
        
            return null;
         */
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public V replace(K k, int i, V v) {
            lock();
            try {
                long read = this.map.H.read();
                preWriteCleanup(read);
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null) {
                        if (this.map.w.equivalent(k, key)) {
                            com.google.common.cache.LocalCache.ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                            V v2 = valueReference.get();
                            if (v2 != null) {
                                this.modCount++;
                                enqueueNotification(k, i, v2, valueReference.b(), com.google.common.cache.RemovalCause.REPLACED);
                                setValue(referenceEntry2, k, v, read);
                                evictEntries(referenceEntry2);
                                return v2;
                            }
                            if (valueReference.isActive()) {
                                this.modCount++;
                                com.google.common.cache.ReferenceEntry<K, V> removeValueFromChain = removeValueFromChain(referenceEntry, referenceEntry2, key, i, v2, valueReference, com.google.common.cache.RemovalCause.COLLECTED);
                                int i2 = this.count - 1;
                                atomicReferenceArray.set(length, removeValueFromChain);
                                this.count = i2;
                            }
                        }
                    }
                    referenceEntry2 = referenceEntry2.getNext();
                }
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x006f, code lost:
        
            return false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean replace(K k, int i, V v, V v2) {
            lock();
            try {
                long read = this.map.H.read();
                preWriteCleanup(read);
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null) {
                        if (this.map.w.equivalent(k, key)) {
                            com.google.common.cache.LocalCache.ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                            V v3 = valueReference.get();
                            if (v3 == null) {
                                if (valueReference.isActive()) {
                                    this.modCount++;
                                    com.google.common.cache.ReferenceEntry<K, V> removeValueFromChain = removeValueFromChain(referenceEntry, referenceEntry2, key, i, v3, valueReference, com.google.common.cache.RemovalCause.COLLECTED);
                                    int i2 = this.count - 1;
                                    atomicReferenceArray.set(length, removeValueFromChain);
                                    this.count = i2;
                                }
                            } else {
                                if (this.map.x.equivalent(v, v3)) {
                                    this.modCount++;
                                    enqueueNotification(k, i, v3, valueReference.b(), com.google.common.cache.RemovalCause.REPLACED);
                                    setValue(referenceEntry2, k, v2, read);
                                    evictEntries(referenceEntry2);
                                    return true;
                                }
                                recordLockedRead(referenceEntry2, read);
                            }
                        }
                    }
                    referenceEntry2 = referenceEntry2.getNext();
                }
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public void runLockedCleanup(long j) {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries(j);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public void runUnlockedCleanup() {
            if (isHeldByCurrentThread()) {
                return;
            }
            this.map.A();
        }

        public V scheduleRefresh(com.google.common.cache.ReferenceEntry<K, V> referenceEntry, K k, int i, V v, long j, com.google.common.cache.CacheLoader<? super K, V> cacheLoader) {
            V refresh;
            return (!this.map.H() || j - referenceEntry.getWriteTime() <= this.map.E || referenceEntry.getValueReference().isLoading() || (refresh = refresh(k, i, cacheLoader, true)) == null) ? v : refresh;
        }

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public void setValue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry, K k, V v, long j) {
            com.google.common.cache.LocalCache.ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            int weigh = this.map.B.weigh(k, v);
            com.google.common.base.Preconditions.checkState(weigh >= 0, "Weights must be non-negative");
            referenceEntry.setValueReference(this.map.z.referenceValue(this, referenceEntry, v, weigh));
            recordWrite(referenceEntry, weigh, j);
            valueReference.a(v);
        }

        public boolean storeLoadedValue(K k, int i, com.google.common.cache.LocalCache.LoadingValueReference<K, V> loadingValueReference, V v) {
            lock();
            try {
                long read = this.map.H.read();
                preWriteCleanup(read);
                int i2 = this.count + 1;
                if (i2 > this.threshold) {
                    expand();
                    i2 = this.count + 1;
                }
                int i3 = i2;
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        this.modCount++;
                        com.google.common.cache.ReferenceEntry<K, V> newEntry = newEntry(k, i, referenceEntry);
                        setValue(newEntry, k, v, read);
                        atomicReferenceArray.set(length, newEntry);
                        this.count = i3;
                        evictEntries(newEntry);
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.w.equivalent(k, key)) {
                        com.google.common.cache.LocalCache.ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                        V v2 = valueReference.get();
                        if (loadingValueReference != valueReference && (v2 != null || valueReference == com.google.common.cache.LocalCache.P)) {
                            enqueueNotification(k, i, v, 0, com.google.common.cache.RemovalCause.REPLACED);
                            unlock();
                            postWriteCleanup();
                            return false;
                        }
                        this.modCount++;
                        if (loadingValueReference.isActive()) {
                            enqueueNotification(k, i, v2, loadingValueReference.b(), v2 == null ? com.google.common.cache.RemovalCause.COLLECTED : com.google.common.cache.RemovalCause.REPLACED);
                            i3--;
                        }
                        setValue(referenceEntry2, k, v, read);
                        this.count = i3;
                        evictEntries(referenceEntry2);
                    } else {
                        referenceEntry2 = referenceEntry2.getNext();
                    }
                }
                return true;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        public void tryExpireEntries(long j) {
            if (tryLock()) {
                try {
                    expireEntries(j);
                } finally {
                    unlock();
                }
            }
        }

        public V waitForLoadingValue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry, K k, com.google.common.cache.LocalCache.ValueReference<K, V> valueReference) throws java.util.concurrent.ExecutionException {
            if (!valueReference.isLoading()) {
                throw new java.lang.AssertionError();
            }
            com.google.common.base.Preconditions.checkState(!java.lang.Thread.holdsLock(referenceEntry), "Recursive load of: %s", k);
            try {
                V c = valueReference.c();
                if (c != null) {
                    recordRead(referenceEntry, this.map.H.read());
                    return c;
                }
                throw new com.google.common.cache.CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
            } finally {
                this.statsCounter.recordMisses(1);
            }
        }
    }

    public static class SoftValueReference<K, V> extends java.lang.ref.SoftReference<V> implements com.google.common.cache.LocalCache.ValueReference<K, V> {
        public final com.google.common.cache.ReferenceEntry<K, V> n;

        public SoftValueReference(java.lang.ref.ReferenceQueue<V> referenceQueue, V v, com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.n = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void a(V v) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int b() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V c() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public com.google.common.cache.LocalCache.ValueReference<K, V> d(java.lang.ref.ReferenceQueue<V> referenceQueue, V v, com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            return new com.google.common.cache.LocalCache.SoftValueReference(referenceQueue, v, referenceEntry);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public com.google.common.cache.ReferenceEntry<K, V> getEntry() {
            return this.n;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class Strength {
        private static final /* synthetic */ com.google.common.cache.LocalCache.Strength[] $VALUES;
        public static final com.google.common.cache.LocalCache.Strength SOFT;
        public static final com.google.common.cache.LocalCache.Strength STRONG;
        public static final com.google.common.cache.LocalCache.Strength WEAK;

        /* renamed from: com.google.common.cache.LocalCache$Strength$1, reason: invalid class name */
        public enum AnonymousClass1 extends com.google.common.cache.LocalCache.Strength {
            public AnonymousClass1(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public com.google.common.base.Equivalence<java.lang.Object> defaultEquivalence() {
                return com.google.common.base.Equivalence.equals();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> com.google.common.cache.LocalCache.ValueReference<K, V> referenceValue(com.google.common.cache.LocalCache.Segment<K, V> segment, com.google.common.cache.ReferenceEntry<K, V> referenceEntry, V v, int i) {
                return i == 1 ? new com.google.common.cache.LocalCache.StrongValueReference(v) : new com.google.common.cache.LocalCache.WeightedStrongValueReference(v, i);
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$Strength$2, reason: invalid class name */
        public enum AnonymousClass2 extends com.google.common.cache.LocalCache.Strength {
            public AnonymousClass2(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public com.google.common.base.Equivalence<java.lang.Object> defaultEquivalence() {
                return com.google.common.base.Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> com.google.common.cache.LocalCache.ValueReference<K, V> referenceValue(com.google.common.cache.LocalCache.Segment<K, V> segment, com.google.common.cache.ReferenceEntry<K, V> referenceEntry, V v, int i) {
                return i == 1 ? new com.google.common.cache.LocalCache.SoftValueReference(segment.valueReferenceQueue, v, referenceEntry) : new com.google.common.cache.LocalCache.WeightedSoftValueReference(segment.valueReferenceQueue, v, referenceEntry, i);
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$Strength$3, reason: invalid class name */
        public enum AnonymousClass3 extends com.google.common.cache.LocalCache.Strength {
            public AnonymousClass3(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public com.google.common.base.Equivalence<java.lang.Object> defaultEquivalence() {
                return com.google.common.base.Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> com.google.common.cache.LocalCache.ValueReference<K, V> referenceValue(com.google.common.cache.LocalCache.Segment<K, V> segment, com.google.common.cache.ReferenceEntry<K, V> referenceEntry, V v, int i) {
                return i == 1 ? new com.google.common.cache.LocalCache.WeakValueReference(segment.valueReferenceQueue, v, referenceEntry) : new com.google.common.cache.LocalCache.WeightedWeakValueReference(segment.valueReferenceQueue, v, referenceEntry, i);
            }
        }

        static {
            com.google.common.cache.LocalCache.Strength.AnonymousClass1 anonymousClass1 = new com.google.common.cache.LocalCache.Strength.AnonymousClass1("STRONG", 0);
            STRONG = anonymousClass1;
            com.google.common.cache.LocalCache.Strength.AnonymousClass2 anonymousClass2 = new com.google.common.cache.LocalCache.Strength.AnonymousClass2("SOFT", 1);
            SOFT = anonymousClass2;
            com.google.common.cache.LocalCache.Strength.AnonymousClass3 anonymousClass3 = new com.google.common.cache.LocalCache.Strength.AnonymousClass3("WEAK", 2);
            WEAK = anonymousClass3;
            $VALUES = new com.google.common.cache.LocalCache.Strength[]{anonymousClass1, anonymousClass2, anonymousClass3};
        }

        private Strength(java.lang.String str, int i) {
        }

        public /* synthetic */ Strength(java.lang.String str, int i, com.google.common.cache.LocalCache.AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        public static com.google.common.cache.LocalCache.Strength valueOf(java.lang.String str) {
            return (com.google.common.cache.LocalCache.Strength) java.lang.Enum.valueOf(com.google.common.cache.LocalCache.Strength.class, str);
        }

        public static com.google.common.cache.LocalCache.Strength[] values() {
            return (com.google.common.cache.LocalCache.Strength[]) $VALUES.clone();
        }

        public abstract com.google.common.base.Equivalence<java.lang.Object> defaultEquivalence();

        public abstract <K, V> com.google.common.cache.LocalCache.ValueReference<K, V> referenceValue(com.google.common.cache.LocalCache.Segment<K, V> segment, com.google.common.cache.ReferenceEntry<K, V> referenceEntry, V v, int i);
    }

    public static final class StrongAccessEntry<K, V> extends com.google.common.cache.LocalCache.StrongEntry<K, V> {
        public volatile long w;
        public com.google.common.cache.ReferenceEntry<K, V> x;
        public com.google.common.cache.ReferenceEntry<K, V> y;

        public StrongAccessEntry(K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
            this.w = Long.MAX_VALUE;
            this.x = com.google.common.cache.LocalCache.x();
            this.y = com.google.common.cache.LocalCache.x();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.w;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.x;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.y;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.w = j;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            this.x = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            this.y = referenceEntry;
        }
    }

    public static final class StrongAccessWriteEntry<K, V> extends com.google.common.cache.LocalCache.StrongEntry<K, V> {
        public com.google.common.cache.ReferenceEntry<K, V> A;
        public com.google.common.cache.ReferenceEntry<K, V> B;
        public volatile long w;
        public com.google.common.cache.ReferenceEntry<K, V> x;
        public com.google.common.cache.ReferenceEntry<K, V> y;
        public volatile long z;

        public StrongAccessWriteEntry(K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
            this.w = Long.MAX_VALUE;
            this.x = com.google.common.cache.LocalCache.x();
            this.y = com.google.common.cache.LocalCache.x();
            this.z = Long.MAX_VALUE;
            this.A = com.google.common.cache.LocalCache.x();
            this.B = com.google.common.cache.LocalCache.x();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.w;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.x;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.A;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.y;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.B;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.z;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.w = j;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            this.x = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            this.A = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            this.y = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            this.B = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.z = j;
        }
    }

    public static class StrongEntry<K, V> extends com.google.common.cache.LocalCache.AbstractReferenceEntry<K, V> {
        public final K n;
        public final int t;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final com.google.common.cache.ReferenceEntry<K, V> u;
        public volatile com.google.common.cache.LocalCache.ValueReference<K, V> v = com.google.common.cache.LocalCache.L();

        public StrongEntry(K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            this.n = k;
            this.t = i;
            this.u = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public int getHash() {
            return this.t;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public K getKey() {
            return this.n;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getNext() {
            return this.u;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public com.google.common.cache.LocalCache.ValueReference<K, V> getValueReference() {
            return this.v;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setValueReference(com.google.common.cache.LocalCache.ValueReference<K, V> valueReference) {
            this.v = valueReference;
        }
    }

    public static class StrongValueReference<K, V> implements com.google.common.cache.LocalCache.ValueReference<K, V> {
        public final V n;

        public StrongValueReference(V v) {
            this.n = v;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void a(V v) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int b() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V c() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public com.google.common.cache.LocalCache.ValueReference<K, V> d(java.lang.ref.ReferenceQueue<V> referenceQueue, V v, com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V get() {
            return this.n;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public com.google.common.cache.ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }
    }

    public static final class StrongWriteEntry<K, V> extends com.google.common.cache.LocalCache.StrongEntry<K, V> {
        public volatile long w;
        public com.google.common.cache.ReferenceEntry<K, V> x;
        public com.google.common.cache.ReferenceEntry<K, V> y;

        public StrongWriteEntry(K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
            this.w = Long.MAX_VALUE;
            this.x = com.google.common.cache.LocalCache.x();
            this.y = com.google.common.cache.LocalCache.x();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.x;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.y;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.w;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            this.x = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            this.y = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.w = j;
        }
    }

    public final class ValueIterator extends com.google.common.cache.LocalCache<K, V>.HashIterator<V> {
        public ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    public interface ValueReference<K, V> {
        void a(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v);

        int b();

        V c() throws java.util.concurrent.ExecutionException;

        com.google.common.cache.LocalCache.ValueReference<K, V> d(java.lang.ref.ReferenceQueue<V> referenceQueue, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v, com.google.common.cache.ReferenceEntry<K, V> referenceEntry);

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        V get();

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        com.google.common.cache.ReferenceEntry<K, V> getEntry();

        boolean isActive();

        boolean isLoading();
    }

    public final class Values extends java.util.AbstractCollection<V> {
        public final java.util.concurrent.ConcurrentMap<?, ?> n;

        public Values(java.util.concurrent.ConcurrentMap<?, ?> concurrentMap) {
            this.n = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.n.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(java.lang.Object obj) {
            return this.n.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.n.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public java.util.Iterator<V> iterator() {
            return new com.google.common.cache.LocalCache.ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.n.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public java.lang.Object[] toArray() {
            return com.google.common.cache.LocalCache.K(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            return (E[]) com.google.common.cache.LocalCache.K(this).toArray(eArr);
        }
    }

    public static final class WeakAccessEntry<K, V> extends com.google.common.cache.LocalCache.WeakEntry<K, V> {
        public volatile long v;
        public com.google.common.cache.ReferenceEntry<K, V> w;
        public com.google.common.cache.ReferenceEntry<K, V> x;

        public WeakAccessEntry(java.lang.ref.ReferenceQueue<K> referenceQueue, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
            this.v = Long.MAX_VALUE;
            this.w = com.google.common.cache.LocalCache.x();
            this.x = com.google.common.cache.LocalCache.x();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.v;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.w;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.x;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.v = j;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            this.w = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            this.x = referenceEntry;
        }
    }

    public static final class WeakAccessWriteEntry<K, V> extends com.google.common.cache.LocalCache.WeakEntry<K, V> {
        public com.google.common.cache.ReferenceEntry<K, V> A;
        public volatile long v;
        public com.google.common.cache.ReferenceEntry<K, V> w;
        public com.google.common.cache.ReferenceEntry<K, V> x;
        public volatile long y;
        public com.google.common.cache.ReferenceEntry<K, V> z;

        public WeakAccessWriteEntry(java.lang.ref.ReferenceQueue<K> referenceQueue, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
            this.v = Long.MAX_VALUE;
            this.w = com.google.common.cache.LocalCache.x();
            this.x = com.google.common.cache.LocalCache.x();
            this.y = Long.MAX_VALUE;
            this.z = com.google.common.cache.LocalCache.x();
            this.A = com.google.common.cache.LocalCache.x();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.v;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.w;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.z;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.x;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.A;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.y;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.v = j;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            this.w = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            this.z = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            this.x = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            this.A = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.y = j;
        }
    }

    public static class WeakEntry<K, V> extends java.lang.ref.WeakReference<K> implements com.google.common.cache.ReferenceEntry<K, V> {
        public final int n;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final com.google.common.cache.ReferenceEntry<K, V> t;
        public volatile com.google.common.cache.LocalCache.ValueReference<K, V> u;

        public WeakEntry(java.lang.ref.ReferenceQueue<K> referenceQueue, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            super(k, referenceQueue);
            this.u = com.google.common.cache.LocalCache.L();
            this.n = i;
            this.t = referenceEntry;
        }

        public long getAccessTime() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            return this.n;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public K getKey() {
            return get();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getNext() {
            return this.t;
        }

        public com.google.common.cache.ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new java.lang.UnsupportedOperationException();
        }

        public com.google.common.cache.ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new java.lang.UnsupportedOperationException();
        }

        public com.google.common.cache.ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new java.lang.UnsupportedOperationException();
        }

        public com.google.common.cache.ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public com.google.common.cache.LocalCache.ValueReference<K, V> getValueReference() {
            return this.u;
        }

        public long getWriteTime() {
            throw new java.lang.UnsupportedOperationException();
        }

        public void setAccessTime(long j) {
            throw new java.lang.UnsupportedOperationException();
        }

        public void setNextInAccessQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            throw new java.lang.UnsupportedOperationException();
        }

        public void setNextInWriteQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            throw new java.lang.UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            throw new java.lang.UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(com.google.common.cache.LocalCache.ValueReference<K, V> valueReference) {
            this.u = valueReference;
        }

        public void setWriteTime(long j) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public static class WeakValueReference<K, V> extends java.lang.ref.WeakReference<V> implements com.google.common.cache.LocalCache.ValueReference<K, V> {
        public final com.google.common.cache.ReferenceEntry<K, V> n;

        public WeakValueReference(java.lang.ref.ReferenceQueue<V> referenceQueue, V v, com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.n = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void a(V v) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int b() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V c() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public com.google.common.cache.LocalCache.ValueReference<K, V> d(java.lang.ref.ReferenceQueue<V> referenceQueue, V v, com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            return new com.google.common.cache.LocalCache.WeakValueReference(referenceQueue, v, referenceEntry);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public com.google.common.cache.ReferenceEntry<K, V> getEntry() {
            return this.n;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }
    }

    public static final class WeakWriteEntry<K, V> extends com.google.common.cache.LocalCache.WeakEntry<K, V> {
        public volatile long v;
        public com.google.common.cache.ReferenceEntry<K, V> w;
        public com.google.common.cache.ReferenceEntry<K, V> x;

        public WeakWriteEntry(java.lang.ref.ReferenceQueue<K> referenceQueue, K k, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
            this.v = Long.MAX_VALUE;
            this.w = com.google.common.cache.LocalCache.x();
            this.x = com.google.common.cache.LocalCache.x();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.w;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public com.google.common.cache.ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.x;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.v;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            this.w = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            this.x = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.v = j;
        }
    }

    public static final class WeightedSoftValueReference<K, V> extends com.google.common.cache.LocalCache.SoftValueReference<K, V> {
        public final int t;

        public WeightedSoftValueReference(java.lang.ref.ReferenceQueue<V> referenceQueue, V v, com.google.common.cache.ReferenceEntry<K, V> referenceEntry, int i) {
            super(referenceQueue, v, referenceEntry);
            this.t = i;
        }

        @Override // com.google.common.cache.LocalCache.SoftValueReference, com.google.common.cache.LocalCache.ValueReference
        public int b() {
            return this.t;
        }

        @Override // com.google.common.cache.LocalCache.SoftValueReference, com.google.common.cache.LocalCache.ValueReference
        public com.google.common.cache.LocalCache.ValueReference<K, V> d(java.lang.ref.ReferenceQueue<V> referenceQueue, V v, com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            return new com.google.common.cache.LocalCache.WeightedSoftValueReference(referenceQueue, v, referenceEntry, this.t);
        }
    }

    public static final class WeightedStrongValueReference<K, V> extends com.google.common.cache.LocalCache.StrongValueReference<K, V> {
        public final int t;

        public WeightedStrongValueReference(V v, int i) {
            super(v);
            this.t = i;
        }

        @Override // com.google.common.cache.LocalCache.StrongValueReference, com.google.common.cache.LocalCache.ValueReference
        public int b() {
            return this.t;
        }
    }

    public static final class WeightedWeakValueReference<K, V> extends com.google.common.cache.LocalCache.WeakValueReference<K, V> {
        public final int t;

        public WeightedWeakValueReference(java.lang.ref.ReferenceQueue<V> referenceQueue, V v, com.google.common.cache.ReferenceEntry<K, V> referenceEntry, int i) {
            super(referenceQueue, v, referenceEntry);
            this.t = i;
        }

        @Override // com.google.common.cache.LocalCache.WeakValueReference, com.google.common.cache.LocalCache.ValueReference
        public int b() {
            return this.t;
        }

        @Override // com.google.common.cache.LocalCache.WeakValueReference, com.google.common.cache.LocalCache.ValueReference
        public com.google.common.cache.LocalCache.ValueReference<K, V> d(java.lang.ref.ReferenceQueue<V> referenceQueue, V v, com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            return new com.google.common.cache.LocalCache.WeightedWeakValueReference(referenceQueue, v, referenceEntry, this.t);
        }
    }

    public static final class WriteQueue<K, V> extends java.util.AbstractQueue<com.google.common.cache.ReferenceEntry<K, V>> {
        public final com.google.common.cache.ReferenceEntry<K, V> n = new com.google.common.cache.LocalCache.WriteQueue.AnonymousClass1();

        /* renamed from: com.google.common.cache.LocalCache$WriteQueue$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.cache.LocalCache.AbstractReferenceEntry<K, V> {
            public com.google.common.cache.ReferenceEntry<K, V> n = this;
            public com.google.common.cache.ReferenceEntry<K, V> t = this;

            public AnonymousClass1() {
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public com.google.common.cache.ReferenceEntry<K, V> getNextInWriteQueue() {
                return this.n;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public com.google.common.cache.ReferenceEntry<K, V> getPreviousInWriteQueue() {
                return this.t;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public long getWriteTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setNextInWriteQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
                this.n = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setPreviousInWriteQueue(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
                this.t = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setWriteTime(long j) {
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$WriteQueue$2, reason: invalid class name */
        public class AnonymousClass2 extends com.google.common.collect.AbstractSequentialIterator<com.google.common.cache.ReferenceEntry<K, V>> {
            public AnonymousClass2(com.google.common.cache.ReferenceEntry referenceEntry) {
                super(referenceEntry);
            }

            @Override // com.google.common.collect.AbstractSequentialIterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.google.common.cache.ReferenceEntry<K, V> computeNext(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
                com.google.common.cache.ReferenceEntry<K, V> nextInWriteQueue = referenceEntry.getNextInWriteQueue();
                if (nextInWriteQueue == com.google.common.cache.LocalCache.WriteQueue.this.n) {
                    return null;
                }
                return nextInWriteQueue;
            }
        }

        @Override // java.util.Queue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
            com.google.common.cache.LocalCache.e(referenceEntry.getPreviousInWriteQueue(), referenceEntry.getNextInWriteQueue());
            com.google.common.cache.LocalCache.e(this.n.getPreviousInWriteQueue(), referenceEntry);
            com.google.common.cache.LocalCache.e(referenceEntry, this.n);
            return true;
        }

        @Override // java.util.Queue
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.ReferenceEntry<K, V> peek() {
            com.google.common.cache.ReferenceEntry<K, V> nextInWriteQueue = this.n.getNextInWriteQueue();
            if (nextInWriteQueue == this.n) {
                return null;
            }
            return nextInWriteQueue;
        }

        @Override // java.util.Queue
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.ReferenceEntry<K, V> poll() {
            com.google.common.cache.ReferenceEntry<K, V> nextInWriteQueue = this.n.getNextInWriteQueue();
            if (nextInWriteQueue == this.n) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            com.google.common.cache.ReferenceEntry<K, V> nextInWriteQueue = this.n.getNextInWriteQueue();
            while (true) {
                com.google.common.cache.ReferenceEntry<K, V> referenceEntry = this.n;
                if (nextInWriteQueue == referenceEntry) {
                    referenceEntry.setNextInWriteQueue(referenceEntry);
                    com.google.common.cache.ReferenceEntry<K, V> referenceEntry2 = this.n;
                    referenceEntry2.setPreviousInWriteQueue(referenceEntry2);
                    return;
                } else {
                    com.google.common.cache.ReferenceEntry<K, V> nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    com.google.common.cache.LocalCache.z(nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(java.lang.Object obj) {
            return ((com.google.common.cache.ReferenceEntry) obj).getNextInWriteQueue() != com.google.common.cache.LocalCache.NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.n.getNextInWriteQueue() == this.n;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public java.util.Iterator<com.google.common.cache.ReferenceEntry<K, V>> iterator() {
            return new com.google.common.cache.LocalCache.WriteQueue.AnonymousClass2(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(java.lang.Object obj) {
            com.google.common.cache.ReferenceEntry referenceEntry = (com.google.common.cache.ReferenceEntry) obj;
            com.google.common.cache.ReferenceEntry<K, V> previousInWriteQueue = referenceEntry.getPreviousInWriteQueue();
            com.google.common.cache.ReferenceEntry<K, V> nextInWriteQueue = referenceEntry.getNextInWriteQueue();
            com.google.common.cache.LocalCache.e(previousInWriteQueue, nextInWriteQueue);
            com.google.common.cache.LocalCache.z(referenceEntry);
            return nextInWriteQueue != com.google.common.cache.LocalCache.NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (com.google.common.cache.ReferenceEntry<K, V> nextInWriteQueue = this.n.getNextInWriteQueue(); nextInWriteQueue != this.n; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i++;
            }
            return i;
        }
    }

    public final class WriteThroughEntry implements java.util.Map.Entry<K, V> {
        public final K n;
        public V t;

        public WriteThroughEntry(K k, V v) {
            this.n = k;
            this.t = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            return this.n.equals(entry.getKey()) && this.t.equals(entry.getValue());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.n;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.t;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.n.hashCode() ^ this.t.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) com.google.common.cache.LocalCache.this.put(this.n, v);
            this.t = v;
            return v2;
        }

        public java.lang.String toString() {
            return getKey() + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + getValue();
        }
    }

    public LocalCache(com.google.common.cache.CacheBuilder<? super K, ? super V> cacheBuilder, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.cache.CacheLoader<? super K, V> cacheLoader) {
        this.v = java.lang.Math.min(cacheBuilder.c(), 65536);
        com.google.common.cache.LocalCache.Strength h = cacheBuilder.h();
        this.y = h;
        this.z = cacheBuilder.o();
        this.w = cacheBuilder.g();
        this.x = cacheBuilder.n();
        long i = cacheBuilder.i();
        this.A = i;
        this.B = (com.google.common.cache.Weigher<K, V>) cacheBuilder.p();
        this.C = cacheBuilder.d();
        this.D = cacheBuilder.e();
        this.E = cacheBuilder.j();
        com.google.common.cache.CacheBuilder.NullListener nullListener = (com.google.common.cache.RemovalListener<K, V>) cacheBuilder.k();
        this.G = nullListener;
        this.F = nullListener == com.google.common.cache.CacheBuilder.NullListener.INSTANCE ? h() : new java.util.concurrent.ConcurrentLinkedQueue<>();
        this.H = cacheBuilder.m(E());
        this.I = com.google.common.cache.LocalCache.EntryFactory.getFactory(h, M(), Q());
        this.J = cacheBuilder.l().get();
        this.K = cacheLoader;
        int min = java.lang.Math.min(cacheBuilder.f(), 1073741824);
        if (i() && !g()) {
            min = (int) java.lang.Math.min(min, i);
        }
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        int i5 = 0;
        while (i4 < this.v && (!i() || i4 * 20 <= this.A)) {
            i5++;
            i4 <<= 1;
        }
        this.t = 32 - i5;
        this.n = i4 - 1;
        this.u = w(i4);
        int i6 = min / i4;
        while (i3 < (i6 * i4 < min ? i6 + 1 : i6)) {
            i3 <<= 1;
        }
        if (i()) {
            long j = this.A;
            long j2 = i4;
            long j3 = (j / j2) + 1;
            long j4 = j % j2;
            while (true) {
                com.google.common.cache.LocalCache.Segment<K, V>[] segmentArr = this.u;
                if (i2 >= segmentArr.length) {
                    return;
                }
                if (i2 == j4) {
                    j3--;
                }
                segmentArr[i2] = f(i3, j3, cacheBuilder.l().get());
                i2++;
            }
        } else {
            while (true) {
                com.google.common.cache.LocalCache.Segment<K, V>[] segmentArr2 = this.u;
                if (i2 >= segmentArr2.length) {
                    return;
                }
                segmentArr2[i2] = f(i3, -1L, cacheBuilder.l().get());
                i2++;
            }
        }
    }

    public static int I(int i) {
        int i2 = i + ((i << 15) ^ (-12931));
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = i5 + (i5 << 2) + (i5 << 14);
        return i6 ^ (i6 >>> 16);
    }

    public static <E> java.util.ArrayList<E> K(java.util.Collection<E> collection) {
        java.util.ArrayList<E> arrayList = new java.util.ArrayList<>(collection.size());
        com.google.common.collect.Iterators.addAll(arrayList, collection.iterator());
        return arrayList;
    }

    public static <K, V> com.google.common.cache.LocalCache.ValueReference<K, V> L() {
        return (com.google.common.cache.LocalCache.ValueReference<K, V>) P;
    }

    public static <K, V> void d(com.google.common.cache.ReferenceEntry<K, V> referenceEntry, com.google.common.cache.ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInAccessQueue(referenceEntry2);
        referenceEntry2.setPreviousInAccessQueue(referenceEntry);
    }

    public static <K, V> void e(com.google.common.cache.ReferenceEntry<K, V> referenceEntry, com.google.common.cache.ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInWriteQueue(referenceEntry2);
        referenceEntry2.setPreviousInWriteQueue(referenceEntry);
    }

    public static <E> java.util.Queue<E> h() {
        return (java.util.Queue<E>) Q;
    }

    public static <K, V> com.google.common.cache.ReferenceEntry<K, V> x() {
        return com.google.common.cache.LocalCache.NullEntry.INSTANCE;
    }

    public static <K, V> void y(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
        com.google.common.cache.ReferenceEntry<K, V> x = x();
        referenceEntry.setNextInAccessQueue(x);
        referenceEntry.setPreviousInAccessQueue(x);
    }

    public static <K, V> void z(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
        com.google.common.cache.ReferenceEntry<K, V> x = x();
        referenceEntry.setNextInWriteQueue(x);
        referenceEntry.setPreviousInWriteQueue(x);
    }

    public void A() {
        while (true) {
            com.google.common.cache.RemovalNotification<K, V> poll = this.F.poll();
            if (poll == null) {
                return;
            }
            try {
                this.G.onRemoval(poll);
            } catch (java.lang.Throwable th) {
                O.log(java.util.logging.Level.WARNING, "Exception thrown by removal listener", th);
            }
        }
    }

    public void B(com.google.common.cache.ReferenceEntry<K, V> referenceEntry) {
        int hash = referenceEntry.getHash();
        J(hash).reclaimKey(referenceEntry, hash);
    }

    public void C(com.google.common.cache.LocalCache.ValueReference<K, V> valueReference) {
        com.google.common.cache.ReferenceEntry<K, V> entry = valueReference.getEntry();
        int hash = entry.getHash();
        J(hash).reclaimValue(entry.getKey(), hash, valueReference);
    }

    public boolean D() {
        return j();
    }

    public boolean E() {
        return F() || D();
    }

    public boolean F() {
        return k() || H();
    }

    public void G(K k) {
        int r = r(com.google.common.base.Preconditions.checkNotNull(k));
        J(r).refresh(k, r, this.K, false);
    }

    public boolean H() {
        return this.E > 0;
    }

    public com.google.common.cache.LocalCache.Segment<K, V> J(int i) {
        return this.u[(i >>> this.t) & this.n];
    }

    public boolean M() {
        return N() || D();
    }

    public boolean N() {
        return j() || i();
    }

    public boolean O() {
        return this.y != com.google.common.cache.LocalCache.Strength.STRONG;
    }

    public boolean P() {
        return this.z != com.google.common.cache.LocalCache.Strength.STRONG;
    }

    public boolean Q() {
        return R() || F();
    }

    public boolean R() {
        return k();
    }

    public void b() {
        for (com.google.common.cache.LocalCache.Segment<K, V> segment : this.u) {
            segment.cleanUp();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (com.google.common.cache.LocalCache.Segment<K, V> segment : this.u) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        int r = r(obj);
        return J(r).containsKey(obj, r);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        long read = this.H.read();
        com.google.common.cache.LocalCache.Segment<K, V>[] segmentArr = this.u;
        long j = -1;
        int i = 0;
        while (i < 3) {
            int length = segmentArr.length;
            long j2 = 0;
            int i2 = 0;
            while (i2 < length) {
                com.google.common.cache.LocalCache.Segment<K, V> segment = segmentArr[i2];
                int i3 = segment.count;
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> atomicReferenceArray = segment.table;
                for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                    com.google.common.cache.ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i4);
                    while (referenceEntry != null) {
                        com.google.common.cache.LocalCache.Segment<K, V>[] segmentArr2 = segmentArr;
                        V liveValue = segment.getLiveValue(referenceEntry, read);
                        long j3 = read;
                        if (liveValue != null && this.x.equivalent(obj, liveValue)) {
                            return true;
                        }
                        referenceEntry = referenceEntry.getNext();
                        segmentArr = segmentArr2;
                        read = j3;
                    }
                }
                j2 += segment.modCount;
                i2++;
                read = read;
            }
            long j4 = read;
            com.google.common.cache.LocalCache.Segment<K, V>[] segmentArr3 = segmentArr;
            if (j2 == j) {
                return false;
            }
            i++;
            j = j2;
            segmentArr = segmentArr3;
            read = j4;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @com.google.common.annotations.GwtIncompatible
    public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
        java.util.Set<java.util.Map.Entry<K, V>> set = this.N;
        if (set != null) {
            return set;
        }
        com.google.common.cache.LocalCache.EntrySet entrySet = new com.google.common.cache.LocalCache.EntrySet(this);
        this.N = entrySet;
        return entrySet;
    }

    public com.google.common.cache.LocalCache.Segment<K, V> f(int i, long j, com.google.common.cache.AbstractCache.StatsCounter statsCounter) {
        return new com.google.common.cache.LocalCache.Segment<>(this, i, j, statsCounter);
    }

    public boolean g() {
        return this.B != com.google.common.cache.CacheBuilder.OneWeigher.INSTANCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        int r = r(obj);
        return J(r).get(obj, r);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public V getOrDefault(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public boolean i() {
        return this.A >= 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        com.google.common.cache.LocalCache.Segment<K, V>[] segmentArr = this.u;
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

    public boolean j() {
        return this.C > 0;
    }

    public boolean k() {
        return this.D > 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set<K> keySet() {
        java.util.Set<K> set = this.L;
        if (set != null) {
            return set;
        }
        com.google.common.cache.LocalCache.KeySet keySet = new com.google.common.cache.LocalCache.KeySet(this);
        this.L = keySet;
        return keySet;
    }

    public V l(K k, com.google.common.cache.CacheLoader<? super K, V> cacheLoader) throws java.util.concurrent.ExecutionException {
        int r = r(com.google.common.base.Preconditions.checkNotNull(k));
        return J(r).get(k, r, cacheLoader);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.google.common.collect.ImmutableMap<K, V> m(java.lang.Iterable<? extends K> iterable) throws java.util.concurrent.ExecutionException {
        java.util.LinkedHashMap newLinkedHashMap = com.google.common.collect.Maps.newLinkedHashMap();
        java.util.LinkedHashSet newLinkedHashSet = com.google.common.collect.Sets.newLinkedHashSet();
        int i = 0;
        int i2 = 0;
        for (K k : iterable) {
            java.lang.Object obj = get(k);
            if (!newLinkedHashMap.containsKey(k)) {
                newLinkedHashMap.put(k, obj);
                if (obj == null) {
                    i2++;
                    newLinkedHashSet.add(k);
                } else {
                    i++;
                }
            }
        }
        try {
            if (!newLinkedHashSet.isEmpty()) {
                try {
                    java.util.Map u = u(newLinkedHashSet, this.K);
                    for (java.lang.Object obj2 : newLinkedHashSet) {
                        java.lang.Object obj3 = u.get(obj2);
                        if (obj3 == null) {
                            throw new com.google.common.cache.CacheLoader.InvalidCacheLoadException("loadAll failed to return a value for " + obj2);
                        }
                        newLinkedHashMap.put(obj2, obj3);
                    }
                } catch (com.google.common.cache.CacheLoader.UnsupportedLoadingOperationException unused) {
                    for (java.lang.Object obj4 : newLinkedHashSet) {
                        i2--;
                        newLinkedHashMap.put(obj4, l(obj4, this.K));
                    }
                }
            }
            return com.google.common.collect.ImmutableMap.copyOf((java.util.Map) newLinkedHashMap);
        } finally {
            this.J.recordHits(i);
            this.J.recordMisses(i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.google.common.collect.ImmutableMap<K, V> n(java.lang.Iterable<?> iterable) {
        java.util.LinkedHashMap newLinkedHashMap = com.google.common.collect.Maps.newLinkedHashMap();
        int i = 0;
        int i2 = 0;
        for (java.lang.Object obj : iterable) {
            V v = get(obj);
            if (v == null) {
                i2++;
            } else {
                newLinkedHashMap.put(obj, v);
                i++;
            }
        }
        this.J.recordHits(i);
        this.J.recordMisses(i2);
        return com.google.common.collect.ImmutableMap.copyOf((java.util.Map) newLinkedHashMap);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public V o(java.lang.Object obj) {
        int r = r(com.google.common.base.Preconditions.checkNotNull(obj));
        V v = J(r).get(obj, r);
        if (v == null) {
            this.J.recordMisses(1);
        } else {
            this.J.recordHits(1);
        }
        return v;
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public V p(com.google.common.cache.ReferenceEntry<K, V> referenceEntry, long j) {
        V v;
        if (referenceEntry.getKey() == null || (v = referenceEntry.getValueReference().get()) == null || t(referenceEntry, j)) {
            return null;
        }
        return v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        com.google.common.base.Preconditions.checkNotNull(k);
        com.google.common.base.Preconditions.checkNotNull(v);
        int r = r(k);
        return J(r).put(k, r, v, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(java.util.Map<? extends K, ? extends V> map) {
        for (java.util.Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k, V v) {
        com.google.common.base.Preconditions.checkNotNull(k);
        com.google.common.base.Preconditions.checkNotNull(v);
        int r = r(k);
        return J(r).put(k, r, v, true);
    }

    public V q(K k) throws java.util.concurrent.ExecutionException {
        return l(k, this.K);
    }

    public int r(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return I(this.w.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        int r = r(obj);
        return J(r).remove(obj, r);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int r = r(obj);
        return J(r).remove(obj, r, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k, V v) {
        com.google.common.base.Preconditions.checkNotNull(k);
        com.google.common.base.Preconditions.checkNotNull(v);
        int r = r(k);
        return J(r).replace(k, r, v);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v, V v2) {
        com.google.common.base.Preconditions.checkNotNull(k);
        com.google.common.base.Preconditions.checkNotNull(v2);
        if (v == null) {
            return false;
        }
        int r = r(k);
        return J(r).replace(k, r, v, v2);
    }

    public void s(java.lang.Iterable<?> iterable) {
        java.util.Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return com.google.common.primitives.Ints.saturatedCast(v());
    }

    public boolean t(com.google.common.cache.ReferenceEntry<K, V> referenceEntry, long j) {
        com.google.common.base.Preconditions.checkNotNull(referenceEntry);
        if (!j() || j - referenceEntry.getAccessTime() < this.C) {
            return k() && j - referenceEntry.getWriteTime() >= this.D;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b9  */
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.util.Map<K, V> u(java.util.Set<? extends K> set, com.google.common.cache.CacheLoader<? super K, V> cacheLoader) throws java.util.concurrent.ExecutionException {
        com.google.common.base.Preconditions.checkNotNull(cacheLoader);
        com.google.common.base.Preconditions.checkNotNull(set);
        com.google.common.base.Stopwatch createStarted = com.google.common.base.Stopwatch.createStarted();
        boolean z = true;
        boolean z2 = false;
        try {
            try {
                try {
                    java.util.Map<? super K, V> loadAll = cacheLoader.loadAll(set);
                    if (loadAll == null) {
                        this.J.recordLoadException(createStarted.elapsed(java.util.concurrent.TimeUnit.NANOSECONDS));
                        throw new com.google.common.cache.CacheLoader.InvalidCacheLoadException(cacheLoader + " returned null map from loadAll");
                    }
                    createStarted.stop();
                    for (java.util.Map.Entry<K, V> entry : loadAll.entrySet()) {
                        K key = entry.getKey();
                        V value = entry.getValue();
                        if (key == null || value == null) {
                            z2 = true;
                        } else {
                            put(key, value);
                        }
                    }
                    if (!z2) {
                        this.J.recordLoadSuccess(createStarted.elapsed(java.util.concurrent.TimeUnit.NANOSECONDS));
                        return loadAll;
                    }
                    this.J.recordLoadException(createStarted.elapsed(java.util.concurrent.TimeUnit.NANOSECONDS));
                    throw new com.google.common.cache.CacheLoader.InvalidCacheLoadException(cacheLoader + " returned null keys or values from loadAll");
                } catch (com.google.common.cache.CacheLoader.UnsupportedLoadingOperationException e) {
                    try {
                        throw e;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        if (!z) {
                            this.J.recordLoadException(createStarted.elapsed(java.util.concurrent.TimeUnit.NANOSECONDS));
                        }
                        throw th;
                    }
                } catch (java.lang.Exception e2) {
                    throw new java.util.concurrent.ExecutionException(e2);
                }
            } catch (java.lang.Error e3) {
                throw new com.google.common.util.concurrent.ExecutionError(e3);
            } catch (java.lang.InterruptedException e4) {
                java.lang.Thread.currentThread().interrupt();
                throw new java.util.concurrent.ExecutionException(e4);
            } catch (java.lang.RuntimeException e5) {
                throw new com.google.common.util.concurrent.UncheckedExecutionException(e5);
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            z = false;
            if (!z) {
            }
            throw th;
        }
    }

    public long v() {
        long j = 0;
        for (int i = 0; i < this.u.length; i++) {
            j += java.lang.Math.max(0, r0[i].count);
        }
        return j;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Collection<V> values() {
        java.util.Collection<V> collection = this.M;
        if (collection != null) {
            return collection;
        }
        com.google.common.cache.LocalCache.Values values = new com.google.common.cache.LocalCache.Values(this);
        this.M = values;
        return values;
    }

    public final com.google.common.cache.LocalCache.Segment<K, V>[] w(int i) {
        return new com.google.common.cache.LocalCache.Segment[i];
    }
}
