package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes22.dex */
final class RegularImmutableMap<K, V> extends com.google.common.collect.ImmutableMap<K, V> {
    private static final int ABSENT = -1;
    static final com.google.common.collect.ImmutableMap<java.lang.Object, java.lang.Object> EMPTY = new com.google.common.collect.RegularImmutableMap(null, new java.lang.Object[0], 0);
    private static final long serialVersionUID = 0;

    @com.google.common.annotations.VisibleForTesting
    final transient java.lang.Object[] alternatingKeysAndValues;
    private final transient int[] hashTable;
    private final transient int size;

    public static class EntrySet<K, V> extends com.google.common.collect.ImmutableSet<java.util.Map.Entry<K, V>> {
        private final transient java.lang.Object[] alternatingKeysAndValues;
        private final transient int keyOffset;
        private final transient com.google.common.collect.ImmutableMap<K, V> map;
        private final transient int size;

        /* renamed from: com.google.common.collect.RegularImmutableMap$EntrySet$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.ImmutableList<java.util.Map.Entry<K, V>> {
            public AnonymousClass1() {
            }

            @Override // java.util.List
            public java.util.Map.Entry<K, V> get(int i) {
                com.google.common.base.Preconditions.checkElementIndex(i, com.google.common.collect.RegularImmutableMap.EntrySet.this.size);
                int i2 = i * 2;
                return new java.util.AbstractMap.SimpleImmutableEntry(com.google.common.collect.RegularImmutableMap.EntrySet.this.alternatingKeysAndValues[com.google.common.collect.RegularImmutableMap.EntrySet.this.keyOffset + i2], com.google.common.collect.RegularImmutableMap.EntrySet.this.alternatingKeysAndValues[i2 + (com.google.common.collect.RegularImmutableMap.EntrySet.this.keyOffset ^ 1)]);
            }

            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return com.google.common.collect.RegularImmutableMap.EntrySet.this.size;
            }
        }

        public EntrySet(com.google.common.collect.ImmutableMap<K, V> immutableMap, java.lang.Object[] objArr, int i, int i2) {
            this.map = immutableMap;
            this.alternatingKeysAndValues = objArr;
            this.keyOffset = i;
            this.size = i2;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            java.lang.Object key = entry.getKey();
            java.lang.Object value = entry.getValue();
            return value != null && value.equals(this.map.get(key));
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(java.lang.Object[] objArr, int i) {
            return asList().copyIntoArray(objArr, i);
        }

        @Override // com.google.common.collect.ImmutableSet
        public com.google.common.collect.ImmutableList<java.util.Map.Entry<K, V>> createAsList() {
            return new com.google.common.collect.RegularImmutableMap.EntrySet.AnonymousClass1();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public com.google.common.collect.UnmodifiableIterator<java.util.Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.size;
        }
    }

    public static final class KeySet<K> extends com.google.common.collect.ImmutableSet<K> {
        private final transient com.google.common.collect.ImmutableList<K> list;
        private final transient com.google.common.collect.ImmutableMap<K, ?> map;

        public KeySet(com.google.common.collect.ImmutableMap<K, ?> immutableMap, com.google.common.collect.ImmutableList<K> immutableList) {
            this.map = immutableMap;
            this.list = immutableList;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public com.google.common.collect.ImmutableList<K> asList() {
            return this.list;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this.map.get(obj) != null;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(java.lang.Object[] objArr, int i) {
            return asList().copyIntoArray(objArr, i);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public com.google.common.collect.UnmodifiableIterator<K> iterator() {
            return asList().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }
    }

    public static final class KeysOrValuesAsList extends com.google.common.collect.ImmutableList<java.lang.Object> {
        private final transient java.lang.Object[] alternatingKeysAndValues;
        private final transient int offset;
        private final transient int size;

        public KeysOrValuesAsList(java.lang.Object[] objArr, int i, int i2) {
            this.alternatingKeysAndValues = objArr;
            this.offset = i;
            this.size = i2;
        }

        @Override // java.util.List
        public java.lang.Object get(int i) {
            com.google.common.base.Preconditions.checkElementIndex(i, this.size);
            return this.alternatingKeysAndValues[(i * 2) + this.offset];
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }
    }

    private RegularImmutableMap(int[] iArr, java.lang.Object[] objArr, int i) {
        this.hashTable = iArr;
        this.alternatingKeysAndValues = objArr;
        this.size = i;
    }

    public static <K, V> com.google.common.collect.RegularImmutableMap<K, V> create(int i, java.lang.Object[] objArr) {
        if (i == 0) {
            return (com.google.common.collect.RegularImmutableMap) EMPTY;
        }
        if (i == 1) {
            com.google.common.collect.CollectPreconditions.a(objArr[0], objArr[1]);
            return new com.google.common.collect.RegularImmutableMap<>(null, objArr, 1);
        }
        com.google.common.base.Preconditions.checkPositionIndex(i, objArr.length >> 1);
        return new com.google.common.collect.RegularImmutableMap<>(createHashTable(objArr, i, com.google.common.collect.ImmutableSet.chooseTableSize(i), 0), objArr, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        r12[r7] = r5;
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int[] createHashTable(java.lang.Object[] objArr, int i, int i2, int i3) {
        if (i == 1) {
            com.google.common.collect.CollectPreconditions.a(objArr[i3], objArr[i3 ^ 1]);
            return null;
        }
        int i4 = i2 - 1;
        int[] iArr = new int[i2];
        java.util.Arrays.fill(iArr, -1);
        int i5 = 0;
        while (i5 < i) {
            int i6 = i5 * 2;
            int i7 = i6 + i3;
            java.lang.Object obj = objArr[i7];
            java.lang.Object obj2 = objArr[i6 + (i3 ^ 1)];
            com.google.common.collect.CollectPreconditions.a(obj, obj2);
            int c = com.google.common.collect.Hashing.c(obj.hashCode());
            while (true) {
                int i8 = c & i4;
                int i9 = iArr[i8];
                if (i9 == -1) {
                    break;
                }
                if (objArr[i9].equals(obj)) {
                    throw new java.lang.IllegalArgumentException("Multiple entries with same key: " + obj + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + obj2 + " and " + objArr[i9] + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + objArr[i9 ^ 1]);
                }
                c = i8 + 1;
            }
        }
        return iArr;
    }

    public static java.lang.Object get(@org.checkerframework.checker.nullness.compatqual.NullableDecl int[] iArr, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object[] objArr, int i, int i2, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[i2].equals(obj)) {
                return objArr[i2 ^ 1];
            }
            return null;
        }
        if (iArr == null) {
            return null;
        }
        int length = iArr.length - 1;
        int c = com.google.common.collect.Hashing.c(obj.hashCode());
        while (true) {
            int i3 = c & length;
            int i4 = iArr[i3];
            if (i4 == -1) {
                return null;
            }
            if (objArr[i4].equals(obj)) {
                return objArr[i4 ^ 1];
            }
            c = i3 + 1;
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    public com.google.common.collect.ImmutableSet<java.util.Map.Entry<K, V>> createEntrySet() {
        return new com.google.common.collect.RegularImmutableMap.EntrySet(this, this.alternatingKeysAndValues, 0, this.size);
    }

    @Override // com.google.common.collect.ImmutableMap
    public com.google.common.collect.ImmutableSet<K> createKeySet() {
        return new com.google.common.collect.RegularImmutableMap.KeySet(this, new com.google.common.collect.RegularImmutableMap.KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.size));
    }

    @Override // com.google.common.collect.ImmutableMap
    public com.google.common.collect.ImmutableCollection<V> createValues() {
        return new com.google.common.collect.RegularImmutableMap.KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.size);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return (V) get(this.hashTable, this.alternatingKeysAndValues, this.size, 0, obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.size;
    }
}
