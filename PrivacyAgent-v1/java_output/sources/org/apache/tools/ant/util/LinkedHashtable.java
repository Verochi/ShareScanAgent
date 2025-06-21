package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class LinkedHashtable<K, V> extends java.util.Hashtable<K, V> {
    private static final long serialVersionUID = 1;
    private final java.util.LinkedHashMap<K, V> map;

    public LinkedHashtable() {
        this.map = new java.util.LinkedHashMap<>();
    }

    public LinkedHashtable(int i) {
        this.map = new java.util.LinkedHashMap<>(i);
    }

    public LinkedHashtable(int i, float f) {
        this.map = new java.util.LinkedHashMap<>(i, f);
    }

    public LinkedHashtable(java.util.Map<K, V> map) {
        this.map = new java.util.LinkedHashMap<>(map);
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized void clear() {
        this.map.clear();
    }

    @Override // java.util.Hashtable
    public boolean contains(java.lang.Object obj) {
        return containsKey(obj);
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized boolean containsKey(java.lang.Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized boolean containsValue(java.lang.Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // java.util.Hashtable, java.util.Dictionary
    public java.util.Enumeration<V> elements() {
        return org.apache.tools.ant.util.CollectionUtils.asEnumeration(values().iterator());
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
        return this.map.entrySet();
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized boolean equals(java.lang.Object obj) {
        return this.map.equals(obj);
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized V get(java.lang.Object obj) {
        return this.map.get(obj);
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized int hashCode() {
        return this.map.hashCode();
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized java.util.Set<K> keySet() {
        return this.map.keySet();
    }

    @Override // java.util.Hashtable, java.util.Dictionary
    public java.util.Enumeration<K> keys() {
        return org.apache.tools.ant.util.CollectionUtils.asEnumeration(keySet().iterator());
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized V put(K k, V v) {
        return this.map.put(k, v);
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized void putAll(java.util.Map<? extends K, ? extends V> map) {
        this.map.putAll(map);
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized V remove(java.lang.Object obj) {
        return this.map.remove(obj);
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized int size() {
        return this.map.size();
    }

    @Override // java.util.Hashtable
    public synchronized java.lang.String toString() {
        return this.map.toString();
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized java.util.Collection<V> values() {
        return this.map.values();
    }
}
