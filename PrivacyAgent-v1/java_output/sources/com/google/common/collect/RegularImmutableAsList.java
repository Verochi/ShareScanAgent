package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
class RegularImmutableAsList<E> extends com.google.common.collect.ImmutableAsList<E> {
    private final com.google.common.collect.ImmutableCollection<E> delegate;
    private final com.google.common.collect.ImmutableList<? extends E> delegateList;

    public RegularImmutableAsList(com.google.common.collect.ImmutableCollection<E> immutableCollection, com.google.common.collect.ImmutableList<? extends E> immutableList) {
        this.delegate = immutableCollection;
        this.delegateList = immutableList;
    }

    public RegularImmutableAsList(com.google.common.collect.ImmutableCollection<E> immutableCollection, java.lang.Object[] objArr) {
        this(immutableCollection, com.google.common.collect.ImmutableList.asImmutableList(objArr));
    }

    public RegularImmutableAsList(com.google.common.collect.ImmutableCollection<E> immutableCollection, java.lang.Object[] objArr, int i) {
        this(immutableCollection, com.google.common.collect.ImmutableList.asImmutableList(objArr, i));
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    @com.google.common.annotations.GwtIncompatible
    public int copyIntoArray(java.lang.Object[] objArr, int i) {
        return this.delegateList.copyIntoArray(objArr, i);
    }

    @Override // com.google.common.collect.ImmutableAsList
    public com.google.common.collect.ImmutableCollection<E> delegateCollection() {
        return this.delegate;
    }

    public com.google.common.collect.ImmutableList<? extends E> delegateList() {
        return this.delegateList;
    }

    @Override // java.util.List
    public E get(int i) {
        return this.delegateList.get(i);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public java.lang.Object[] internalArray() {
        return this.delegateList.internalArray();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.delegateList.internalArrayEnd();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return this.delegateList.internalArrayStart();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public com.google.common.collect.UnmodifiableListIterator<E> listIterator(int i) {
        return this.delegateList.listIterator(i);
    }
}
