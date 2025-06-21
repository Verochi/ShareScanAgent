package com.google.protobuf;

/* loaded from: classes22.dex */
public class UnmodifiableLazyStringList extends java.util.AbstractList<java.lang.String> implements com.google.protobuf.LazyStringList, java.util.RandomAccess {
    private final com.google.protobuf.LazyStringList list;

    /* renamed from: com.google.protobuf.UnmodifiableLazyStringList$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.ListIterator<java.lang.String> {
        java.util.ListIterator<java.lang.String> iter;
        final /* synthetic */ int val$index;

        public AnonymousClass1(int i) {
            this.val$index = i;
            this.iter = com.google.protobuf.UnmodifiableLazyStringList.this.list.listIterator(i);
        }

        @Override // java.util.ListIterator
        public void add(java.lang.String str) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.iter.hasPrevious();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public java.lang.String next() {
            return this.iter.next();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.iter.nextIndex();
        }

        @Override // java.util.ListIterator
        public java.lang.String previous() {
            return this.iter.previous();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.iter.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public void set(java.lang.String str) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    /* renamed from: com.google.protobuf.UnmodifiableLazyStringList$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.Iterator<java.lang.String> {
        java.util.Iterator<java.lang.String> iter;

        public AnonymousClass2() {
            this.iter = com.google.protobuf.UnmodifiableLazyStringList.this.list.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public java.lang.String next() {
            return this.iter.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public UnmodifiableLazyStringList(com.google.protobuf.LazyStringList lazyStringList) {
        this.list = lazyStringList;
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(com.google.protobuf.ByteString byteString) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public java.lang.String get(int i) {
        return this.list.get(i);
    }

    @Override // com.google.protobuf.LazyStringList
    public com.google.protobuf.ByteString getByteString(int i) {
        return this.list.getByteString(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public java.util.Iterator<java.lang.String> iterator() {
        return new com.google.protobuf.UnmodifiableLazyStringList.AnonymousClass2();
    }

    @Override // java.util.AbstractList, java.util.List
    public java.util.ListIterator<java.lang.String> listIterator(int i) {
        return new com.google.protobuf.UnmodifiableLazyStringList.AnonymousClass1(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }
}
