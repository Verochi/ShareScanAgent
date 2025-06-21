package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
final class ImmutableMapValues<K, V> extends com.google.common.collect.ImmutableCollection<V> {
    private final com.google.common.collect.ImmutableMap<K, V> map;

    /* renamed from: com.google.common.collect.ImmutableMapValues$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.collect.UnmodifiableIterator<V> {
        public final com.google.common.collect.UnmodifiableIterator<java.util.Map.Entry<K, V>> n;

        public AnonymousClass1() {
            this.n = com.google.common.collect.ImmutableMapValues.this.map.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return this.n.next().getValue();
        }
    }

    /* renamed from: com.google.common.collect.ImmutableMapValues$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.common.collect.ImmutableList<V> {
        final /* synthetic */ com.google.common.collect.ImmutableList val$entryList;

        public AnonymousClass2(com.google.common.collect.ImmutableList immutableList) {
            this.val$entryList = immutableList;
        }

        @Override // java.util.List
        public V get(int i) {
            return (V) ((java.util.Map.Entry) this.val$entryList.get(i)).getValue();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.val$entryList.size();
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static class SerializedForm<V> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        final com.google.common.collect.ImmutableMap<?, V> map;

        public SerializedForm(com.google.common.collect.ImmutableMap<?, V> immutableMap) {
            this.map = immutableMap;
        }

        public java.lang.Object readResolve() {
            return this.map.values();
        }
    }

    public ImmutableMapValues(com.google.common.collect.ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public com.google.common.collect.ImmutableList<V> asList() {
        return new com.google.common.collect.ImmutableMapValues.AnonymousClass2(this.map.entrySet().asList());
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return obj != null && com.google.common.collect.Iterators.contains(iterator(), obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public com.google.common.collect.UnmodifiableIterator<V> iterator() {
        return new com.google.common.collect.ImmutableMapValues.AnonymousClass1();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.map.size();
    }

    @Override // com.google.common.collect.ImmutableCollection
    @com.google.common.annotations.GwtIncompatible
    public java.lang.Object writeReplace() {
        return new com.google.common.collect.ImmutableMapValues.SerializedForm(this.map);
    }
}
