package com.alibaba.fastjson.util;

/* loaded from: classes.dex */
public class IdentityHashMap<V> {
    private final com.alibaba.fastjson.util.IdentityHashMap.Entry<V>[] buckets;
    private final int indexMask;

    public static final class Entry<V> {
        public final int hashCode;
        public final java.lang.reflect.Type key;
        public final com.alibaba.fastjson.util.IdentityHashMap.Entry<V> next;
        public V value;

        public Entry(java.lang.reflect.Type type, V v, int i, com.alibaba.fastjson.util.IdentityHashMap.Entry<V> entry) {
            this.key = type;
            this.value = v;
            this.next = entry;
            this.hashCode = i;
        }
    }

    public IdentityHashMap(int i) {
        this.indexMask = i - 1;
        this.buckets = new com.alibaba.fastjson.util.IdentityHashMap.Entry[i];
    }

    public java.lang.Class findClass(java.lang.String str) {
        int i = 0;
        while (true) {
            com.alibaba.fastjson.util.IdentityHashMap.Entry<V>[] entryArr = this.buckets;
            if (i >= entryArr.length) {
                return null;
            }
            com.alibaba.fastjson.util.IdentityHashMap.Entry<V> entry = entryArr[i];
            if (entry != null) {
                for (com.alibaba.fastjson.util.IdentityHashMap.Entry<V> entry2 = entry; entry2 != null; entry2 = entry2.next) {
                    java.lang.reflect.Type type = entry.key;
                    if (type instanceof java.lang.Class) {
                        java.lang.Class cls = (java.lang.Class) type;
                        if (cls.getName().equals(str)) {
                            return cls;
                        }
                    }
                }
            }
            i++;
        }
    }

    public final V get(java.lang.reflect.Type type) {
        for (com.alibaba.fastjson.util.IdentityHashMap.Entry<V> entry = this.buckets[java.lang.System.identityHashCode(type) & this.indexMask]; entry != null; entry = entry.next) {
            if (type == entry.key) {
                return entry.value;
            }
        }
        return null;
    }

    public boolean put(java.lang.reflect.Type type, V v) {
        int identityHashCode = java.lang.System.identityHashCode(type);
        int i = this.indexMask & identityHashCode;
        for (com.alibaba.fastjson.util.IdentityHashMap.Entry<V> entry = this.buckets[i]; entry != null; entry = entry.next) {
            if (type == entry.key) {
                entry.value = v;
                return true;
            }
        }
        this.buckets[i] = new com.alibaba.fastjson.util.IdentityHashMap.Entry<>(type, v, identityHashCode, this.buckets[i]);
        return false;
    }
}
