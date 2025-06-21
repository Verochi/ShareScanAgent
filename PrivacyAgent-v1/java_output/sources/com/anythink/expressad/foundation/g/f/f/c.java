package com.anythink.expressad.foundation.g.f.f;

/* loaded from: classes12.dex */
public final class c {
    public final int a;
    public final byte[] b;
    public final java.util.Map<java.lang.String, java.lang.String> c;
    public final java.util.List<com.anythink.expressad.foundation.g.f.c.c> d;

    public c(int i, byte[] bArr, java.util.List<com.anythink.expressad.foundation.g.f.c.c> list) {
        this(i, bArr, a(list), list);
    }

    private c(int i, byte[] bArr, java.util.Map<java.lang.String, java.lang.String> map, java.util.List<com.anythink.expressad.foundation.g.f.c.c> list) {
        this.a = i;
        this.b = bArr;
        this.c = map;
        if (list == null) {
            this.d = null;
        } else {
            this.d = java.util.Collections.unmodifiableList(list);
        }
    }

    private static java.util.Map<java.lang.String, java.lang.String> a(java.util.List<com.anythink.expressad.foundation.g.f.c.c> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return java.util.Collections.emptyMap();
        }
        java.util.TreeMap treeMap = new java.util.TreeMap(java.lang.String.CASE_INSENSITIVE_ORDER);
        for (com.anythink.expressad.foundation.g.f.c.c cVar : list) {
            treeMap.put(cVar.a(), cVar.b());
        }
        return treeMap;
    }
}
