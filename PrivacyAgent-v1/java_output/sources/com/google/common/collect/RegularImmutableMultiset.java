package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes22.dex */
class RegularImmutableMultiset<E> extends com.google.common.collect.ImmutableMultiset<E> {
    static final com.google.common.collect.RegularImmutableMultiset<java.lang.Object> EMPTY = new com.google.common.collect.RegularImmutableMultiset<>(com.google.common.collect.ObjectCountHashMap.b());
    final transient com.google.common.collect.ObjectCountHashMap<E> contents;

    @com.google.errorprone.annotations.concurrent.LazyInit
    private transient com.google.common.collect.ImmutableSet<E> elementSet;
    private final transient int size;

    public final class ElementSet extends com.google.common.collect.IndexedImmutableSet<E> {
        private ElementSet() {
        }

        public /* synthetic */ ElementSet(com.google.common.collect.RegularImmutableMultiset regularImmutableMultiset, com.google.common.collect.RegularImmutableMultiset.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return com.google.common.collect.RegularImmutableMultiset.this.contains(obj);
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public E get(int i) {
            return com.google.common.collect.RegularImmutableMultiset.this.contents.i(i);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.collect.RegularImmutableMultiset.this.contents.C();
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static class SerializedForm implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final java.lang.Object[] elements;

        public SerializedForm(com.google.common.collect.Multiset<?> multiset) {
            int size = multiset.entrySet().size();
            this.elements = new java.lang.Object[size];
            this.counts = new int[size];
            int i = 0;
            for (com.google.common.collect.Multiset.Entry<?> entry : multiset.entrySet()) {
                this.elements[i] = entry.getElement();
                this.counts[i] = entry.getCount();
                i++;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public java.lang.Object readResolve() {
            com.google.common.collect.ImmutableMultiset.Builder builder = new com.google.common.collect.ImmutableMultiset.Builder(this.elements.length);
            int i = 0;
            while (true) {
                java.lang.Object[] objArr = this.elements;
                if (i >= objArr.length) {
                    return builder.build();
                }
                builder.addCopies(objArr[i], this.counts[i]);
                i++;
            }
        }
    }

    public RegularImmutableMultiset(com.google.common.collect.ObjectCountHashMap<E> objectCountHashMap) {
        this.contents = objectCountHashMap;
        long j = 0;
        for (int i = 0; i < objectCountHashMap.C(); i++) {
            j += objectCountHashMap.k(i);
        }
        this.size = com.google.common.primitives.Ints.saturatedCast(j);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return this.contents.f(obj);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public com.google.common.collect.ImmutableSet<E> elementSet() {
        com.google.common.collect.ImmutableSet<E> immutableSet = this.elementSet;
        if (immutableSet != null) {
            return immutableSet;
        }
        com.google.common.collect.RegularImmutableMultiset.ElementSet elementSet = new com.google.common.collect.RegularImmutableMultiset.ElementSet(this, null);
        this.elementSet = elementSet;
        return elementSet;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public com.google.common.collect.Multiset.Entry<E> getEntry(int i) {
        return this.contents.g(i);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    @com.google.common.annotations.GwtIncompatible
    public java.lang.Object writeReplace() {
        return new com.google.common.collect.RegularImmutableMultiset.SerializedForm(this);
    }
}
