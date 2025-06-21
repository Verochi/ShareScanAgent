package com.anythink.expressad.foundation.g.a;

/* loaded from: classes12.dex */
public abstract class a<K, V> implements com.anythink.expressad.foundation.g.a.e<K, V> {
    protected static final java.lang.String a = "cache";
    private final java.util.Map<K, java.lang.ref.Reference<V>> b = java.util.Collections.synchronizedMap(new java.util.HashMap());

    @Override // com.anythink.expressad.foundation.g.a.e
    public final java.util.Collection<K> a() {
        java.util.HashSet hashSet;
        synchronized (this.b) {
            hashSet = new java.util.HashSet(this.b.keySet());
        }
        return hashSet;
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public void a(K k) {
        this.b.remove(k);
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public boolean a(K k, V v) {
        this.b.put(k, c(v));
        return true;
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final V b(K k) {
        java.lang.ref.Reference<V> reference = this.b.get(k);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public void b() {
        this.b.clear();
    }

    public abstract java.lang.ref.Reference<V> c(V v);
}
