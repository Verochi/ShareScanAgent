package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes22.dex */
final class RegularImmutableSet<E> extends com.google.common.collect.ImmutableSet<E> {
    static final com.google.common.collect.RegularImmutableSet<java.lang.Object> EMPTY = new com.google.common.collect.RegularImmutableSet<>(new java.lang.Object[0], 0, null, 0, 0);

    @com.google.common.annotations.VisibleForTesting
    final transient java.lang.Object[] elements;
    private final transient int hashCode;
    private final transient int mask;
    private final transient int size;

    @com.google.common.annotations.VisibleForTesting
    final transient java.lang.Object[] table;

    public RegularImmutableSet(java.lang.Object[] objArr, int i, java.lang.Object[] objArr2, int i2, int i3) {
        this.elements = objArr;
        this.table = objArr2;
        this.mask = i2;
        this.hashCode = i;
        this.size = i3;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        java.lang.Object[] objArr = this.table;
        if (obj == null || objArr == null) {
            return false;
        }
        int d = com.google.common.collect.Hashing.d(obj);
        while (true) {
            int i = d & this.mask;
            java.lang.Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            d = i + 1;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(java.lang.Object[] objArr, int i) {
        java.lang.System.arraycopy(this.elements, 0, objArr, i, this.size);
        return i + this.size;
    }

    @Override // com.google.common.collect.ImmutableSet
    public com.google.common.collect.ImmutableList<E> createAsList() {
        return com.google.common.collect.ImmutableList.asImmutableList(this.elements, this.size);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.hashCode;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public java.lang.Object[] internalArray() {
        return this.elements;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSet
    public boolean isHashCodeFast() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public com.google.common.collect.UnmodifiableIterator<E> iterator() {
        return asList().iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }
}
