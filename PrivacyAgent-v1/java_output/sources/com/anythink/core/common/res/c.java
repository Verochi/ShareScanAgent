package com.anythink.core.common.res;

/* loaded from: classes12.dex */
public class c<K, V> {
    private final java.util.LinkedHashMap<K, V> a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public c(int i) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("maxSize <= 0");
        }
        this.c = i;
        this.a = new java.util.LinkedHashMap<>(0, 0.75f, true);
    }

    private void a(int i) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.c = i;
        }
        b(i);
    }

    private static V b() {
        return null;
    }

    private V b(K k) {
        V remove;
        if (k == null) {
            throw new java.lang.NullPointerException("key == null");
        }
        synchronized (this) {
            remove = this.a.remove(k);
            if (remove != null) {
                this.b -= c(k, remove);
            }
        }
        if (remove != null) {
            a(false, k, remove, null);
        }
        return remove;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x005c, code lost:
    
        r5.b = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x008f, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results! --> size: " + r5.b + ", map.isEmpty(): " + r5.a.isEmpty());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(int i) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                try {
                    if (this.b < 0 || (this.a.isEmpty() && this.b != 0)) {
                        break;
                    }
                    if (this.b <= i) {
                        return;
                    }
                    java.util.Map.Entry<K, V> next = this.a.entrySet().size() > 0 ? this.a.entrySet().iterator().next() : null;
                    if (next == null) {
                        return;
                    }
                    key = next.getKey();
                    value = next.getValue();
                    this.a.remove(key);
                    this.b -= c(key, value);
                    this.f++;
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            a(true, key, value, null);
        }
    }

    private synchronized int c() {
        return this.b;
    }

    private int c(K k, V v) {
        int a = a(k, v);
        if (a >= 0) {
            return a;
        }
        throw new java.lang.IllegalStateException("Negative size: " + k + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + v);
    }

    private synchronized int d() {
        return this.c;
    }

    private synchronized int e() {
        return this.g;
    }

    private synchronized int f() {
        return this.h;
    }

    private synchronized int g() {
        return this.e;
    }

    private synchronized int h() {
        return this.d;
    }

    private synchronized int i() {
        return this.f;
    }

    private synchronized java.util.Map<K, V> j() {
        return new java.util.LinkedHashMap(this.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0082, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void k() {
        K key;
        V value;
        synchronized (this.a) {
            while (true) {
                synchronized (this) {
                    if (this.b < 0 || (this.a.isEmpty() && this.b != 0)) {
                        break;
                    }
                    if (this.b != 0) {
                        java.util.Map.Entry<K, V> next = this.a.entrySet().size() > 0 ? this.a.entrySet().iterator().next() : null;
                        if (next != null) {
                            key = next.getKey();
                            value = next.getValue();
                            this.a.remove(key);
                            this.b -= c(key, value);
                            this.f++;
                        }
                    }
                }
                a(true, key, value, null);
            }
            this.a.clear();
        }
    }

    public int a(K k, V v) {
        return 1;
    }

    public final V a(K k) {
        if (k == null) {
            throw new java.lang.NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.a.get(k);
            if (v != null) {
                this.g++;
                return v;
            }
            this.h++;
            return null;
        }
    }

    public final void a() {
        b(-1);
    }

    public void a(boolean z, K k, V v, V v2) {
    }

    public final V b(K k, V v) {
        V put;
        if (k == null) {
            throw new java.lang.NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.d++;
            this.b += c(k, v);
            put = this.a.put(k, v);
            if (put != null) {
                this.b -= c(k, put);
            }
        }
        if (put != null) {
            a(false, k, put, v);
        }
        b(this.c);
        return put;
    }

    public final synchronized java.lang.String toString() {
        int i;
        int i2;
        i = this.g;
        i2 = this.h + i;
        return java.lang.String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", java.lang.Integer.valueOf(this.c), java.lang.Integer.valueOf(this.g), java.lang.Integer.valueOf(this.h), java.lang.Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}
