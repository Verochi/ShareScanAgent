package com.google.common.collect;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
class CompactLinkedHashMap<K, V> extends com.google.common.collect.CompactHashMap<K, V> {
    private static final int ENDPOINT = -2;
    private final boolean accessOrder;
    private transient int firstEntry;
    private transient int lastEntry;

    @com.google.common.annotations.VisibleForTesting
    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    transient long[] links;

    public CompactLinkedHashMap() {
        this(3);
    }

    public CompactLinkedHashMap(int i) {
        this(i, 1.0f, false);
    }

    public CompactLinkedHashMap(int i, float f, boolean z) {
        super(i, f);
        this.accessOrder = z;
    }

    public static <K, V> com.google.common.collect.CompactLinkedHashMap<K, V> create() {
        return new com.google.common.collect.CompactLinkedHashMap<>();
    }

    public static <K, V> com.google.common.collect.CompactLinkedHashMap<K, V> createWithExpectedSize(int i) {
        return new com.google.common.collect.CompactLinkedHashMap<>(i);
    }

    private int getPredecessor(int i) {
        return (int) (this.links[i] >>> 32);
    }

    private void setPredecessor(int i, int i2) {
        long[] jArr = this.links;
        jArr[i] = (jArr[i] & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) | (i2 << 32);
    }

    private void setSucceeds(int i, int i2) {
        if (i == -2) {
            this.firstEntry = i2;
        } else {
            setSuccessor(i, i2);
        }
        if (i2 == -2) {
            this.lastEntry = i;
        } else {
            setPredecessor(i2, i);
        }
    }

    private void setSuccessor(int i, int i2) {
        long[] jArr = this.links;
        jArr[i] = (jArr[i] & (-4294967296L)) | (i2 & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void accessEntry(int i) {
        if (this.accessOrder) {
            setSucceeds(getPredecessor(i), getSuccessor(i));
            setSucceeds(this.lastEntry, i);
            setSucceeds(i, -2);
            this.modCount++;
        }
    }

    @Override // com.google.common.collect.CompactHashMap
    public int adjustAfterRemove(int i, int i2) {
        return i >= size() ? i2 : i;
    }

    @Override // com.google.common.collect.CompactHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    @Override // com.google.common.collect.CompactHashMap
    public int firstEntryIndex() {
        return this.firstEntry;
    }

    @Override // com.google.common.collect.CompactHashMap
    public int getSuccessor(int i) {
        return (int) this.links[i];
    }

    @Override // com.google.common.collect.CompactHashMap
    public void init(int i, float f) {
        super.init(i, f);
        this.firstEntry = -2;
        this.lastEntry = -2;
        long[] jArr = new long[i];
        this.links = jArr;
        java.util.Arrays.fill(jArr, -1L);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void insertEntry(int i, K k, V v, int i2) {
        super.insertEntry(i, k, v, i2);
        setSucceeds(this.lastEntry, i);
        setSucceeds(i, -2);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void moveLastEntry(int i) {
        int size = size() - 1;
        setSucceeds(getPredecessor(i), getSuccessor(i));
        if (i < size) {
            setSucceeds(getPredecessor(size), i);
            setSucceeds(i, getSuccessor(size));
        }
        super.moveLastEntry(i);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void resizeEntries(int i) {
        super.resizeEntries(i);
        this.links = java.util.Arrays.copyOf(this.links, i);
    }
}
