package com.sijla.mla;

/* loaded from: classes19.dex */
public final class a<K, V> {
    private int a;
    private int b;
    private com.sijla.mla.a.C0455a<K, V> c;
    private com.sijla.mla.a.C0455a<K, V> d;

    /* renamed from: com.sijla.mla.a$a, reason: collision with other inner class name */
    public static class C0455a<K, V> {
        public K a;
        public V b;
        public com.sijla.mla.a.C0455a<K, V> c;
        public com.sijla.mla.a.C0455a<K, V> d;
        private long e;

        private C0455a() {
        }

        public /* synthetic */ C0455a(byte b) {
            this();
        }
    }

    public a(int i) {
        this.a = i;
    }

    public final synchronized V a(K k) {
        com.sijla.mla.a.C0455a<K, V> c0455a = this.c;
        while (c0455a != null && !c0455a.a.equals(k)) {
            c0455a = c0455a.d;
        }
        if (c0455a == null) {
            return null;
        }
        com.sijla.mla.a.C0455a<K, V> c0455a2 = c0455a.c;
        if (c0455a2 != null) {
            com.sijla.mla.a.C0455a<K, V> c0455a3 = c0455a.d;
            if (c0455a3 == null) {
                c0455a2.d = null;
                this.d = this.d.c;
            } else {
                c0455a2.d = c0455a3;
                c0455a.d.c = c0455a2;
            }
            c0455a.c = null;
            com.sijla.mla.a.C0455a<K, V> c0455a4 = this.c;
            c0455a.d = c0455a4;
            c0455a4.c = c0455a;
            this.c = c0455a;
        }
        return c0455a.b;
    }

    public final synchronized boolean a(K k, V v) {
        if (k != null) {
            if (this.a > 0) {
                com.sijla.mla.a.C0455a<K, V> c0455a = null;
                while (true) {
                    int i = this.b;
                    if (i < this.a) {
                        break;
                    }
                    c0455a = this.d;
                    com.sijla.mla.a.C0455a<K, V> c0455a2 = c0455a.c;
                    this.d = c0455a2;
                    c0455a2.d = null;
                    this.b = i - 1;
                }
                if (c0455a == null) {
                    c0455a = new com.sijla.mla.a.C0455a<>((byte) 0);
                }
                ((com.sijla.mla.a.C0455a) c0455a).e = java.lang.System.currentTimeMillis();
                c0455a.a = k;
                c0455a.b = v;
                c0455a.c = null;
                com.sijla.mla.a.C0455a<K, V> c0455a3 = this.c;
                c0455a.d = c0455a3;
                int i2 = this.b;
                if (i2 == 0) {
                    this.d = c0455a;
                } else {
                    c0455a3.c = c0455a;
                }
                this.c = c0455a;
                this.b = i2 + 1;
                return true;
            }
        }
        return false;
    }
}
