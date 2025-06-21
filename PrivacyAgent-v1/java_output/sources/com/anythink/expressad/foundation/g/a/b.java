package com.anythink.expressad.foundation.g.a;

/* loaded from: classes12.dex */
public abstract class b<K, V> extends com.anythink.expressad.foundation.g.a.a<K, V> {
    private static final int b = 16;
    private static final int c = 16777216;
    private final int d;
    private final java.util.List<V> f = java.util.Collections.synchronizedList(new java.util.LinkedList());
    private final java.util.concurrent.atomic.AtomicInteger e = new java.util.concurrent.atomic.AtomicInteger();

    private b(int i) {
        this.d = i;
        if (i > 16777216) {
            java.lang.String.format("You set too large memory cache size (more than %1$d Mb)", 16);
        }
    }

    private int e() {
        return this.d;
    }

    @Override // com.anythink.expressad.foundation.g.a.a, com.anythink.expressad.foundation.g.a.e
    public final void a(K k) {
        java.lang.Object b2 = super.b(k);
        if (b2 != null && this.f.remove(b2)) {
            this.e.addAndGet(-c());
        }
        super.a(k);
    }

    @Override // com.anythink.expressad.foundation.g.a.a, com.anythink.expressad.foundation.g.a.e
    public final boolean a(K k, V v) {
        boolean z;
        int c2 = c();
        int i = this.d;
        int i2 = this.e.get();
        if (c2 < i) {
            while (i2 + c2 > i) {
                if (this.f.remove(d())) {
                    i2 = this.e.addAndGet(-c());
                }
            }
            this.f.add(v);
            this.e.addAndGet(c2);
            z = true;
        } else {
            z = false;
        }
        super.a(k, v);
        return z;
    }

    @Override // com.anythink.expressad.foundation.g.a.a, com.anythink.expressad.foundation.g.a.e
    public final void b() {
        this.f.clear();
        this.e.set(0);
        super.b();
    }

    public abstract int c();

    public abstract V d();
}
