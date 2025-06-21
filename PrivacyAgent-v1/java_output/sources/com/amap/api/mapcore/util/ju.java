package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ju {
    private java.util.HashMap<java.lang.String, com.amap.api.mapcore.util.jv> a = new java.util.HashMap<>();
    private long b = 0;

    public final long a(com.amap.api.mapcore.util.jv jvVar) {
        if (jvVar == null) {
            return 0L;
        }
        java.util.HashMap<java.lang.String, com.amap.api.mapcore.util.jv> hashMap = this.a;
        java.lang.String b = jvVar.b();
        com.amap.api.mapcore.util.jv jvVar2 = hashMap.get(b);
        if (jvVar2 == null) {
            jvVar.n = com.amap.api.mapcore.util.ix.b();
            hashMap.put(b, jvVar);
            return 0L;
        }
        if (jvVar2.a() != jvVar.a()) {
            jvVar.n = com.amap.api.mapcore.util.ix.b();
            hashMap.put(b, jvVar);
            return 0L;
        }
        jvVar.n = jvVar2.n;
        hashMap.put(b, jvVar);
        return (com.amap.api.mapcore.util.ix.b() - jvVar2.n) / 1000;
    }

    public final void a() {
        this.a.clear();
        this.b = 0L;
    }

    public final void a(java.util.ArrayList<? extends com.amap.api.mapcore.util.jv> arrayList) {
        if (arrayList != null) {
            long b = com.amap.api.mapcore.util.ix.b();
            long j = this.b;
            if (j <= 0 || b - j >= 60000) {
                java.util.HashMap<java.lang.String, com.amap.api.mapcore.util.jv> hashMap = this.a;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    com.amap.api.mapcore.util.jv jvVar = arrayList.get(i);
                    com.amap.api.mapcore.util.jv jvVar2 = hashMap.get(jvVar.b());
                    if (jvVar2 != null) {
                        if (jvVar2.a() == jvVar.a()) {
                            jvVar.n = jvVar2.n;
                        } else {
                            jvVar.n = b;
                        }
                    }
                }
                hashMap.clear();
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    com.amap.api.mapcore.util.jv jvVar3 = arrayList.get(i2);
                    hashMap.put(jvVar3.b(), jvVar3);
                }
                this.b = b;
            }
        }
    }
}
