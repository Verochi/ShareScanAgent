package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes22.dex */
public final class LinkedHashMultimap<K, V> extends com.google.common.collect.LinkedHashMultimapGwtSerializationDependencies<K, V> {
    private static final int DEFAULT_KEY_CAPACITY = 16;
    private static final int DEFAULT_VALUE_SET_CAPACITY = 2;

    @com.google.common.annotations.VisibleForTesting
    static final double VALUE_SET_LOAD_FACTOR = 1.0d;

    @com.google.common.annotations.GwtIncompatible
    private static final long serialVersionUID = 1;
    private transient com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> multimapHeaderEntry;

    @com.google.common.annotations.VisibleForTesting
    transient int valueSetCapacity;

    /* renamed from: com.google.common.collect.LinkedHashMultimap$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Iterator<java.util.Map.Entry<K, V>> {
        public com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> n;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> t;

        public AnonymousClass1() {
            this.n = com.google.common.collect.LinkedHashMultimap.this.multimapHeaderEntry.successorInMultimap;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> valueEntry = this.n;
            this.t = valueEntry;
            this.n = valueEntry.successorInMultimap;
            return valueEntry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n != com.google.common.collect.LinkedHashMultimap.this.multimapHeaderEntry;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.collect.CollectPreconditions.e(this.t != null);
            com.google.common.collect.LinkedHashMultimap.this.remove(this.t.getKey(), this.t.getValue());
            this.t = null;
        }
    }

    @com.google.common.annotations.VisibleForTesting
    public static final class ValueEntry<K, V> extends com.google.common.collect.ImmutableEntry<K, V> implements com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> {

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> nextInValueBucket;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> predecessorInMultimap;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> predecessorInValueSet;
        final int smearedValueHash;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> successorInMultimap;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> successorInValueSet;

        public ValueEntry(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> valueEntry) {
            super(k, v);
            this.smearedValueHash = i;
            this.nextInValueBucket = valueEntry;
        }

        public com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> getPredecessorInMultimap() {
            return this.predecessorInMultimap;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> getPredecessorInValueSet() {
            return this.predecessorInValueSet;
        }

        public com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> getSuccessorInMultimap() {
            return this.successorInMultimap;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> getSuccessorInValueSet() {
            return this.successorInValueSet;
        }

        public boolean matchesValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, int i) {
            return this.smearedValueHash == i && com.google.common.base.Objects.equal(getValue(), obj);
        }

        public void setPredecessorInMultimap(com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> valueEntry) {
            this.predecessorInMultimap = valueEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public void setPredecessorInValueSet(com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> valueSetLink) {
            this.predecessorInValueSet = valueSetLink;
        }

        public void setSuccessorInMultimap(com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> valueEntry) {
            this.successorInMultimap = valueEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public void setSuccessorInValueSet(com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> valueSetLink) {
            this.successorInValueSet = valueSetLink;
        }
    }

    @com.google.common.annotations.VisibleForTesting
    public final class ValueSet extends com.google.common.collect.Sets.ImprovedAbstractSet<V> implements com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> {
        public final K n;

        @com.google.common.annotations.VisibleForTesting
        public com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V>[] t;
        public int u = 0;
        public int v = 0;
        public com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> w = this;
        public com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> x = this;

        /* renamed from: com.google.common.collect.LinkedHashMultimap$ValueSet$1, reason: invalid class name */
        public class AnonymousClass1 implements java.util.Iterator<V> {
            public com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> n;

            @org.checkerframework.checker.nullness.compatqual.NullableDecl
            public com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> t;
            public int u;

            public AnonymousClass1() {
                this.n = com.google.common.collect.LinkedHashMultimap.ValueSet.this.w;
                this.u = com.google.common.collect.LinkedHashMultimap.ValueSet.this.v;
            }

            public final void a() {
                if (com.google.common.collect.LinkedHashMultimap.ValueSet.this.v != this.u) {
                    throw new java.util.ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.n != com.google.common.collect.LinkedHashMultimap.ValueSet.this;
            }

            @Override // java.util.Iterator
            public V next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> valueEntry = (com.google.common.collect.LinkedHashMultimap.ValueEntry) this.n;
                V value = valueEntry.getValue();
                this.t = valueEntry;
                this.n = valueEntry.getSuccessorInValueSet();
                return value;
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                com.google.common.collect.CollectPreconditions.e(this.t != null);
                com.google.common.collect.LinkedHashMultimap.ValueSet.this.remove(this.t.getValue());
                this.u = com.google.common.collect.LinkedHashMultimap.ValueSet.this.v;
                this.t = null;
            }
        }

        public ValueSet(K k, int i) {
            this.n = k;
            this.t = new com.google.common.collect.LinkedHashMultimap.ValueEntry[com.google.common.collect.Hashing.a(i, 1.0d)];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
            int d = com.google.common.collect.Hashing.d(v);
            int c = c() & d;
            com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> valueEntry = this.t[c];
            for (com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> valueEntry2 = valueEntry; valueEntry2 != null; valueEntry2 = valueEntry2.nextInValueBucket) {
                if (valueEntry2.matchesValue(v, d)) {
                    return false;
                }
            }
            com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> valueEntry3 = new com.google.common.collect.LinkedHashMultimap.ValueEntry<>(this.n, v, d, valueEntry);
            com.google.common.collect.LinkedHashMultimap.succeedsInValueSet(this.x, valueEntry3);
            com.google.common.collect.LinkedHashMultimap.succeedsInValueSet(valueEntry3, this);
            com.google.common.collect.LinkedHashMultimap.succeedsInMultimap(com.google.common.collect.LinkedHashMultimap.this.multimapHeaderEntry.getPredecessorInMultimap(), valueEntry3);
            com.google.common.collect.LinkedHashMultimap.succeedsInMultimap(valueEntry3, com.google.common.collect.LinkedHashMultimap.this.multimapHeaderEntry);
            this.t[c] = valueEntry3;
            this.u++;
            this.v++;
            d();
            return true;
        }

        public final int c() {
            return this.t.length - 1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            java.util.Arrays.fill(this.t, (java.lang.Object) null);
            this.u = 0;
            for (com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> valueSetLink = this.w; valueSetLink != this; valueSetLink = valueSetLink.getSuccessorInValueSet()) {
                com.google.common.collect.LinkedHashMultimap.deleteFromMultimap((com.google.common.collect.LinkedHashMultimap.ValueEntry) valueSetLink);
            }
            com.google.common.collect.LinkedHashMultimap.succeedsInValueSet(this, this);
            this.v++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            int d = com.google.common.collect.Hashing.d(obj);
            for (com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> valueEntry = this.t[c() & d]; valueEntry != null; valueEntry = valueEntry.nextInValueBucket) {
                if (valueEntry.matchesValue(obj, d)) {
                    return true;
                }
            }
            return false;
        }

        public final void d() {
            if (com.google.common.collect.Hashing.b(this.u, this.t.length, 1.0d)) {
                int length = this.t.length * 2;
                com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V>[] valueEntryArr = new com.google.common.collect.LinkedHashMultimap.ValueEntry[length];
                this.t = valueEntryArr;
                int i = length - 1;
                for (com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> valueSetLink = this.w; valueSetLink != this; valueSetLink = valueSetLink.getSuccessorInValueSet()) {
                    com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> valueEntry = (com.google.common.collect.LinkedHashMultimap.ValueEntry) valueSetLink;
                    int i2 = valueEntry.smearedValueHash & i;
                    valueEntry.nextInValueBucket = valueEntryArr[i2];
                    valueEntryArr[i2] = valueEntry;
                }
            }
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> getPredecessorInValueSet() {
            return this.x;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> getSuccessorInValueSet() {
            return this.w;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<V> iterator() {
            return new com.google.common.collect.LinkedHashMultimap.ValueSet.AnonymousClass1();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            int d = com.google.common.collect.Hashing.d(obj);
            int c = c() & d;
            com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> valueEntry = null;
            for (com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> valueEntry2 = this.t[c]; valueEntry2 != null; valueEntry2 = valueEntry2.nextInValueBucket) {
                if (valueEntry2.matchesValue(obj, d)) {
                    if (valueEntry == null) {
                        this.t[c] = valueEntry2.nextInValueBucket;
                    } else {
                        valueEntry.nextInValueBucket = valueEntry2.nextInValueBucket;
                    }
                    com.google.common.collect.LinkedHashMultimap.deleteFromValueSet(valueEntry2);
                    com.google.common.collect.LinkedHashMultimap.deleteFromMultimap(valueEntry2);
                    this.u--;
                    this.v++;
                    return true;
                }
                valueEntry = valueEntry2;
            }
            return false;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public void setPredecessorInValueSet(com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> valueSetLink) {
            this.x = valueSetLink;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public void setSuccessorInValueSet(com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> valueSetLink) {
            this.w = valueSetLink;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.u;
        }
    }

    public interface ValueSetLink<K, V> {
        com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> getPredecessorInValueSet();

        com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> getSuccessorInValueSet();

        void setPredecessorInValueSet(com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> valueSetLink);

        void setSuccessorInValueSet(com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> valueSetLink);
    }

    private LinkedHashMultimap(int i, int i2) {
        super(com.google.common.collect.Platform.e(i));
        this.valueSetCapacity = 2;
        com.google.common.collect.CollectPreconditions.b(i2, "expectedValuesPerKey");
        this.valueSetCapacity = i2;
        com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> valueEntry = new com.google.common.collect.LinkedHashMultimap.ValueEntry<>(null, null, 0, null);
        this.multimapHeaderEntry = valueEntry;
        succeedsInMultimap(valueEntry, valueEntry);
    }

    public static <K, V> com.google.common.collect.LinkedHashMultimap<K, V> create() {
        return new com.google.common.collect.LinkedHashMultimap<>(16, 2);
    }

    public static <K, V> com.google.common.collect.LinkedHashMultimap<K, V> create(int i, int i2) {
        return new com.google.common.collect.LinkedHashMultimap<>(com.google.common.collect.Maps.k(i), com.google.common.collect.Maps.k(i2));
    }

    public static <K, V> com.google.common.collect.LinkedHashMultimap<K, V> create(com.google.common.collect.Multimap<? extends K, ? extends V> multimap) {
        com.google.common.collect.LinkedHashMultimap<K, V> create = create(multimap.keySet().size(), 2);
        create.putAll(multimap);
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void deleteFromMultimap(com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> valueEntry) {
        succeedsInMultimap(valueEntry.getPredecessorInMultimap(), valueEntry.getSuccessorInMultimap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void deleteFromValueSet(com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> valueSetLink) {
        succeedsInValueSet(valueSetLink.getPredecessorInValueSet(), valueSetLink.getSuccessorInValueSet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.google.common.annotations.GwtIncompatible
    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        objectInputStream.defaultReadObject();
        com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> valueEntry = new com.google.common.collect.LinkedHashMultimap.ValueEntry<>(null, null, 0, null);
        this.multimapHeaderEntry = valueEntry;
        succeedsInMultimap(valueEntry, valueEntry);
        this.valueSetCapacity = 2;
        int readInt = objectInputStream.readInt();
        java.util.Map e = com.google.common.collect.Platform.e(12);
        for (int i = 0; i < readInt; i++) {
            java.lang.Object readObject = objectInputStream.readObject();
            e.put(readObject, createCollection(readObject));
        }
        int readInt2 = objectInputStream.readInt();
        for (int i2 = 0; i2 < readInt2; i2++) {
            java.lang.Object readObject2 = objectInputStream.readObject();
            ((java.util.Collection) e.get(readObject2)).add(objectInputStream.readObject());
        }
        setMap(e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void succeedsInMultimap(com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> valueEntry, com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> valueEntry2) {
        valueEntry.setSuccessorInMultimap(valueEntry2);
        valueEntry2.setPredecessorInMultimap(valueEntry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void succeedsInValueSet(com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> valueSetLink, com.google.common.collect.LinkedHashMultimap.ValueSetLink<K, V> valueSetLink2) {
        valueSetLink.setSuccessorInValueSet(valueSetLink2);
        valueSetLink2.setPredecessorInValueSet(valueSetLink);
    }

    @com.google.common.annotations.GwtIncompatible
    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(keySet().size());
        java.util.Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
        objectOutputStream.writeInt(size());
        for (java.util.Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ java.util.Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public void clear() {
        super.clear();
        com.google.common.collect.LinkedHashMultimap.ValueEntry<K, V> valueEntry = this.multimapHeaderEntry;
        succeedsInMultimap(valueEntry, valueEntry);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public java.util.Collection<V> createCollection(K k) {
        return new com.google.common.collect.LinkedHashMultimap.ValueSet(k, this.valueSetCapacity);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public java.util.Set<V> createCollection() {
        return com.google.common.collect.Platform.f(this.valueSetCapacity);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public java.util.Set<java.util.Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
    public java.util.Iterator<java.util.Map.Entry<K, V>> entryIterator() {
        return new com.google.common.collect.LinkedHashMultimap.AnonymousClass1();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ java.util.Set get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.get((com.google.common.collect.LinkedHashMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public java.util.Set<K> keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ com.google.common.collect.Multiset keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean put(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(com.google.common.collect.Multimap multimap) {
        return super.putAll(multimap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, java.lang.Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ java.util.Set removeAll(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.removeAll(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ java.util.Collection replaceValues(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, java.lang.Iterable iterable) {
        return replaceValues((com.google.common.collect.LinkedHashMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public java.util.Set<V> replaceValues(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, java.lang.Iterable<? extends V> iterable) {
        return super.replaceValues((com.google.common.collect.LinkedHashMultimap<K, V>) k, (java.lang.Iterable) iterable);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ java.lang.String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
    public java.util.Iterator<V> valueIterator() {
        return com.google.common.collect.Maps.Q(entryIterator());
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public java.util.Collection<V> values() {
        return super.values();
    }
}
