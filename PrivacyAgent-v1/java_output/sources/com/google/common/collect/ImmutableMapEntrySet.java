package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
abstract class ImmutableMapEntrySet<K, V> extends com.google.common.collect.ImmutableSet<java.util.Map.Entry<K, V>> {

    @com.google.common.annotations.GwtIncompatible
    public static class EntrySetSerializedForm<K, V> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        final com.google.common.collect.ImmutableMap<K, V> map;

        public EntrySetSerializedForm(com.google.common.collect.ImmutableMap<K, V> immutableMap) {
            this.map = immutableMap;
        }

        public java.lang.Object readResolve() {
            return this.map.entrySet();
        }
    }

    public static final class RegularEntrySet<K, V> extends com.google.common.collect.ImmutableMapEntrySet<K, V> {
        private final transient com.google.common.collect.ImmutableList<java.util.Map.Entry<K, V>> entries;

        @com.google.j2objc.annotations.Weak
        private final transient com.google.common.collect.ImmutableMap<K, V> map;

        public RegularEntrySet(com.google.common.collect.ImmutableMap<K, V> immutableMap, com.google.common.collect.ImmutableList<java.util.Map.Entry<K, V>> immutableList) {
            this.map = immutableMap;
            this.entries = immutableList;
        }

        public RegularEntrySet(com.google.common.collect.ImmutableMap<K, V> immutableMap, java.util.Map.Entry<K, V>[] entryArr) {
            this(immutableMap, com.google.common.collect.ImmutableList.asImmutableList(entryArr));
        }

        @Override // com.google.common.collect.ImmutableCollection
        @com.google.common.annotations.GwtIncompatible("not used in GWT")
        public int copyIntoArray(java.lang.Object[] objArr, int i) {
            return this.entries.copyIntoArray(objArr, i);
        }

        @Override // com.google.common.collect.ImmutableSet
        public com.google.common.collect.ImmutableList<java.util.Map.Entry<K, V>> createAsList() {
            return this.entries;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public com.google.common.collect.UnmodifiableIterator<java.util.Map.Entry<K, V>> iterator() {
            return this.entries.iterator();
        }

        @Override // com.google.common.collect.ImmutableMapEntrySet
        public com.google.common.collect.ImmutableMap<K, V> map() {
            return this.map;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!(obj instanceof java.util.Map.Entry)) {
            return false;
        }
        java.util.Map.Entry entry = (java.util.Map.Entry) obj;
        V v = map().get(entry.getKey());
        return v != null && v.equals(entry.getValue());
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return map().hashCode();
    }

    @Override // com.google.common.collect.ImmutableSet
    @com.google.common.annotations.GwtIncompatible
    public boolean isHashCodeFast() {
        return map().isHashCodeFast();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return map().isPartialView();
    }

    public abstract com.google.common.collect.ImmutableMap<K, V> map();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return map().size();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    @com.google.common.annotations.GwtIncompatible
    public java.lang.Object writeReplace() {
        return new com.google.common.collect.ImmutableMapEntrySet.EntrySetSerializedForm(map());
    }
}
