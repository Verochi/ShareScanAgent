package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes22.dex */
final class ImmutableEnumSet<E extends java.lang.Enum<E>> extends com.google.common.collect.ImmutableSet<E> {
    private final transient java.util.EnumSet<E> delegate;

    @com.google.errorprone.annotations.concurrent.LazyInit
    private transient int hashCode;

    public static class EnumSerializedForm<E extends java.lang.Enum<E>> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        final java.util.EnumSet<E> delegate;

        public EnumSerializedForm(java.util.EnumSet<E> enumSet) {
            this.delegate = enumSet;
        }

        public java.lang.Object readResolve() {
            return new com.google.common.collect.ImmutableEnumSet(this.delegate.clone(), null);
        }
    }

    private ImmutableEnumSet(java.util.EnumSet<E> enumSet) {
        this.delegate = enumSet;
    }

    public /* synthetic */ ImmutableEnumSet(java.util.EnumSet enumSet, com.google.common.collect.ImmutableEnumSet.AnonymousClass1 anonymousClass1) {
        this(enumSet);
    }

    public static com.google.common.collect.ImmutableSet asImmutable(java.util.EnumSet enumSet) {
        int size = enumSet.size();
        return size != 0 ? size != 1 ? new com.google.common.collect.ImmutableEnumSet(enumSet) : com.google.common.collect.ImmutableSet.of(com.google.common.collect.Iterables.getOnlyElement(enumSet)) : com.google.common.collect.ImmutableSet.of();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(java.lang.Object obj) {
        return this.delegate.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(java.util.Collection<?> collection) {
        if (collection instanceof com.google.common.collect.ImmutableEnumSet) {
            collection = ((com.google.common.collect.ImmutableEnumSet) collection).delegate;
        }
        return this.delegate.containsAll(collection);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof com.google.common.collect.ImmutableEnumSet) {
            obj = ((com.google.common.collect.ImmutableEnumSet) obj).delegate;
        }
        return this.delegate.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = this.delegate.hashCode();
        this.hashCode = hashCode;
        return hashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.delegate.isEmpty();
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
        return com.google.common.collect.Iterators.unmodifiableIterator(this.delegate.iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.delegate.size();
    }

    @Override // java.util.AbstractCollection
    public java.lang.String toString() {
        return this.delegate.toString();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public java.lang.Object writeReplace() {
        return new com.google.common.collect.ImmutableEnumSet.EnumSerializedForm(this.delegate);
    }
}
