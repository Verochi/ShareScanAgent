package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
final class CartesianList<E> extends java.util.AbstractList<java.util.List<E>> implements java.util.RandomAccess {
    public final transient com.google.common.collect.ImmutableList<java.util.List<E>> n;
    public final transient int[] t;

    /* renamed from: com.google.common.collect.CartesianList$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.collect.ImmutableList<E> {
        final /* synthetic */ int val$index;

        public AnonymousClass1(int i) {
            this.val$index = i;
        }

        @Override // java.util.List
        public E get(int i) {
            com.google.common.base.Preconditions.checkElementIndex(i, size());
            return (E) ((java.util.List) com.google.common.collect.CartesianList.this.n.get(i)).get(com.google.common.collect.CartesianList.this.e(this.val$index, i));
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return com.google.common.collect.CartesianList.this.n.size();
        }
    }

    public CartesianList(com.google.common.collect.ImmutableList<java.util.List<E>> immutableList) {
        this.n = immutableList;
        int[] iArr = new int[immutableList.size() + 1];
        iArr[immutableList.size()] = 1;
        try {
            for (int size = immutableList.size() - 1; size >= 0; size--) {
                iArr[size] = com.google.common.math.IntMath.checkedMultiply(iArr[size + 1], immutableList.get(size).size());
            }
            this.t = iArr;
        } catch (java.lang.ArithmeticException unused) {
            throw new java.lang.IllegalArgumentException("Cartesian product too large; must have size at most Integer.MAX_VALUE");
        }
    }

    public static <E> java.util.List<java.util.List<E>> c(java.util.List<? extends java.util.List<? extends E>> list) {
        com.google.common.collect.ImmutableList.Builder builder = new com.google.common.collect.ImmutableList.Builder(list.size());
        java.util.Iterator<? extends java.util.List<? extends E>> it = list.iterator();
        while (it.hasNext()) {
            com.google.common.collect.ImmutableList copyOf = com.google.common.collect.ImmutableList.copyOf((java.util.Collection) it.next());
            if (copyOf.isEmpty()) {
                return com.google.common.collect.ImmutableList.of();
            }
            builder.add((com.google.common.collect.ImmutableList.Builder) copyOf);
        }
        return new com.google.common.collect.CartesianList(builder.build());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public com.google.common.collect.ImmutableList<E> get(int i) {
        com.google.common.base.Preconditions.checkElementIndex(i, size());
        return new com.google.common.collect.CartesianList.AnonymousClass1(i);
    }

    public final int e(int i, int i2) {
        return (i / this.t[i2 + 1]) % this.n.get(i2).size();
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(java.lang.Object obj) {
        if (!(obj instanceof java.util.List)) {
            return -1;
        }
        java.util.List list = (java.util.List) obj;
        if (list.size() != this.n.size()) {
            return -1;
        }
        java.util.ListIterator<E> listIterator = list.listIterator();
        int i = 0;
        while (listIterator.hasNext()) {
            int nextIndex = listIterator.nextIndex();
            int indexOf = this.n.get(nextIndex).indexOf(listIterator.next());
            if (indexOf == -1) {
                return -1;
            }
            i += indexOf * this.t[nextIndex + 1];
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.t[0];
    }
}
