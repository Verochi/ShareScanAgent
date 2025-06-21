package com.anythink.expressad.video.dynview.d;

/* loaded from: classes12.dex */
public final class a<K, V> extends java.util.HashMap<K, V> {
    private java.lang.ref.ReferenceQueue<V> a = new java.lang.ref.ReferenceQueue<>();
    private java.util.HashMap<K, com.anythink.expressad.video.dynview.d.a<K, V>.C0227a<K, V>> b = new java.util.HashMap<>();

    /* renamed from: com.anythink.expressad.video.dynview.d.a$a, reason: collision with other inner class name */
    public class C0227a<K, V> extends java.lang.ref.SoftReference<V> {
        K a;

        public C0227a(K k, V v, java.lang.ref.ReferenceQueue referenceQueue) {
            super(v, referenceQueue);
            this.a = k;
        }
    }

    private void a() {
        while (true) {
            com.anythink.expressad.video.dynview.d.a.C0227a c0227a = (com.anythink.expressad.video.dynview.d.a.C0227a) this.a.poll();
            if (c0227a == null) {
                return;
            } else {
                this.b.remove(c0227a.a);
            }
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final boolean containsKey(java.lang.Object obj) {
        a();
        return this.b.containsKey(obj);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V get(java.lang.Object obj) {
        a();
        com.anythink.expressad.video.dynview.d.a<K, V>.C0227a<K, V> c0227a = this.b.get(obj);
        if (c0227a == null) {
            return null;
        }
        return c0227a.get();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        a();
        com.anythink.expressad.video.dynview.d.a<K, V>.C0227a<K, V> put = this.b.put(k, new com.anythink.expressad.video.dynview.d.a.C0227a<>(k, v, this.a));
        if (put == null) {
            return null;
        }
        return put.get();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(java.lang.Object obj) {
        a();
        com.anythink.expressad.video.dynview.d.a<K, V>.C0227a<K, V> remove = this.b.remove(obj);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final int size() {
        a();
        return this.b.size();
    }
}
