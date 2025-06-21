package com.google.protobuf;

/* loaded from: classes22.dex */
public class LazyStringArrayList extends java.util.AbstractList<java.lang.String> implements com.google.protobuf.LazyStringList, java.util.RandomAccess {
    public static final com.google.protobuf.LazyStringList EMPTY = new com.google.protobuf.UnmodifiableLazyStringList(new com.google.protobuf.LazyStringArrayList());
    private final java.util.List<java.lang.Object> list;

    public LazyStringArrayList() {
        this.list = new java.util.ArrayList();
    }

    public LazyStringArrayList(java.util.List<java.lang.String> list) {
        this.list = new java.util.ArrayList(list);
    }

    private java.lang.String asString(java.lang.Object obj) {
        return obj instanceof java.lang.String ? (java.lang.String) obj : ((com.google.protobuf.ByteString) obj).toStringUtf8();
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, java.lang.String str) {
        this.list.add(i, str);
        ((java.util.AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(com.google.protobuf.ByteString byteString) {
        this.list.add(byteString);
        ((java.util.AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, java.util.Collection<? extends java.lang.String> collection) {
        boolean addAll = this.list.addAll(i, collection);
        ((java.util.AbstractList) this).modCount++;
        return addAll;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.list.clear();
        ((java.util.AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public java.lang.String get(int i) {
        java.lang.Object obj = this.list.get(i);
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
        java.lang.String stringUtf8 = byteString.toStringUtf8();
        if (com.google.protobuf.Internal.isValidUtf8(byteString)) {
            this.list.set(i, stringUtf8);
        }
        return stringUtf8;
    }

    @Override // com.google.protobuf.LazyStringList
    public com.google.protobuf.ByteString getByteString(int i) {
        java.lang.Object obj = this.list.get(i);
        if (!(obj instanceof java.lang.String)) {
            return (com.google.protobuf.ByteString) obj;
        }
        com.google.protobuf.ByteString copyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
        this.list.set(i, copyFromUtf8);
        return copyFromUtf8;
    }

    @Override // java.util.AbstractList, java.util.List
    public java.lang.String remove(int i) {
        java.lang.Object remove = this.list.remove(i);
        ((java.util.AbstractList) this).modCount++;
        return asString(remove);
    }

    @Override // java.util.AbstractList, java.util.List
    public java.lang.String set(int i, java.lang.String str) {
        return asString(this.list.set(i, str));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }
}
