package com.anythink.expressad.exoplayer.j.a;

/* loaded from: classes12.dex */
public final class k {
    private final java.util.Map<java.lang.String, java.lang.Object> a = new java.util.HashMap();
    private final java.util.List<java.lang.String> b = new java.util.ArrayList();

    private com.anythink.expressad.exoplayer.j.a.k a(java.lang.String str, java.lang.Object obj) {
        this.a.put((java.lang.String) com.anythink.expressad.exoplayer.k.a.a(str), com.anythink.expressad.exoplayer.k.a.a(obj));
        this.b.remove(str);
        return this;
    }

    private com.anythink.expressad.exoplayer.j.a.k a(java.lang.String str, byte[] bArr) {
        return a(str, (java.lang.Object) java.util.Arrays.copyOf(bArr, bArr.length));
    }

    public final com.anythink.expressad.exoplayer.j.a.k a(java.lang.String str) {
        this.b.add(str);
        this.a.remove(str);
        return this;
    }

    public final com.anythink.expressad.exoplayer.j.a.k a(java.lang.String str, long j) {
        return a(str, java.lang.Long.valueOf(j));
    }

    public final com.anythink.expressad.exoplayer.j.a.k a(java.lang.String str, java.lang.String str2) {
        return a(str, (java.lang.Object) str2);
    }

    public final java.util.List<java.lang.String> a() {
        return java.util.Collections.unmodifiableList(new java.util.ArrayList(this.b));
    }

    public final java.util.Map<java.lang.String, java.lang.Object> b() {
        java.util.HashMap hashMap = new java.util.HashMap(this.a);
        for (java.util.Map.Entry entry : hashMap.entrySet()) {
            java.lang.Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(java.util.Arrays.copyOf(bArr, bArr.length));
            }
        }
        return java.util.Collections.unmodifiableMap(hashMap);
    }
}
