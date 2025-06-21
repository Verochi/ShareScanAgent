package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class ForwardingMap<K, V> extends com.google.common.collect.ForwardingObject implements java.util.Map<K, V> {

    @com.google.common.annotations.Beta
    public abstract class StandardEntrySet extends com.google.common.collect.Maps.EntrySet<K, V> {
        public StandardEntrySet() {
        }

        @Override // com.google.common.collect.Maps.EntrySet
        public java.util.Map<K, V> a() {
            return com.google.common.collect.ForwardingMap.this;
        }
    }

    @com.google.common.annotations.Beta
    public class StandardKeySet extends com.google.common.collect.Maps.KeySet<K, V> {
        public StandardKeySet() {
            super(com.google.common.collect.ForwardingMap.this);
        }
    }

    @com.google.common.annotations.Beta
    public class StandardValues extends com.google.common.collect.Maps.Values<K, V> {
        public StandardValues() {
            super(com.google.common.collect.ForwardingMap.this);
        }
    }

    public void clear() {
        delegate().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return delegate().containsKey(obj);
    }

    public boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return delegate().containsValue(obj);
    }

    @Override // com.google.common.collect.ForwardingObject
    public abstract java.util.Map<K, V> delegate();

    public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Map
    public V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return delegate().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public java.util.Set<K> keySet() {
        return delegate().keySet();
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V put(K k, V v) {
        return delegate().put(k, v);
    }

    public void putAll(java.util.Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V remove(java.lang.Object obj) {
        return delegate().remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return delegate().size();
    }

    public void standardClear() {
        com.google.common.collect.Iterators.c(entrySet().iterator());
    }

    @com.google.common.annotations.Beta
    public boolean standardContainsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return com.google.common.collect.Maps.m(this, obj);
    }

    public boolean standardContainsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return com.google.common.collect.Maps.n(this, obj);
    }

    public boolean standardEquals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return com.google.common.collect.Maps.p(this, obj);
    }

    public int standardHashCode() {
        return com.google.common.collect.Sets.b(entrySet());
    }

    public boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    public void standardPutAll(java.util.Map<? extends K, ? extends V> map) {
        com.google.common.collect.Maps.A(this, map);
    }

    @com.google.common.annotations.Beta
    public V standardRemove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        java.util.Iterator<java.util.Map.Entry<K, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            java.util.Map.Entry<K, V> next = it.next();
            if (com.google.common.base.Objects.equal(next.getKey(), obj)) {
                V value = next.getValue();
                it.remove();
                return value;
            }
        }
        return null;
    }

    public java.lang.String standardToString() {
        return com.google.common.collect.Maps.I(this);
    }

    public java.util.Collection<V> values() {
        return delegate().values();
    }
}
