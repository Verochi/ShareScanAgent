package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes22.dex */
class RegularImmutableList<E> extends com.google.common.collect.ImmutableList<E> {
    static final com.google.common.collect.ImmutableList<java.lang.Object> EMPTY = new com.google.common.collect.RegularImmutableList(new java.lang.Object[0], 0);

    @com.google.common.annotations.VisibleForTesting
    final transient java.lang.Object[] array;
    private final transient int size;

    public RegularImmutableList(java.lang.Object[] objArr, int i) {
        this.array = objArr;
        this.size = i;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public int copyIntoArray(java.lang.Object[] objArr, int i) {
        java.lang.System.arraycopy(this.array, 0, objArr, i, this.size);
        return i + this.size;
    }

    @Override // java.util.List
    public E get(int i) {
        com.google.common.base.Preconditions.checkElementIndex(i, this.size);
        return (E) this.array[i];
    }

    @Override // com.google.common.collect.ImmutableCollection
    public java.lang.Object[] internalArray() {
        return this.array;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }
}
