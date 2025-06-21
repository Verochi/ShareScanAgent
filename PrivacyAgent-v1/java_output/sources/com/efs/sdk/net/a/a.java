package com.efs.sdk.net.a;

/* loaded from: classes22.dex */
public final class a {
    private static com.efs.sdk.net.a.a c;
    private java.util.HashMap<java.lang.String, com.efs.sdk.net.a.c> a;
    private java.util.HashMap<java.lang.String, com.efs.sdk.net.a.d> b;

    private a() {
        b();
    }

    public static com.efs.sdk.net.a.a a() {
        if (c == null) {
            c = new com.efs.sdk.net.a.a();
        }
        return c;
    }

    private void b() {
        if (this.a == null) {
            this.a = new java.util.HashMap<>();
        }
        this.a.clear();
    }

    public final com.efs.sdk.net.a.c a(java.lang.String str) {
        if (this.a == null) {
            b();
        }
        com.efs.sdk.net.a.c cVar = this.a.get(str);
        if (cVar != null) {
            return cVar;
        }
        com.efs.sdk.net.a.c cVar2 = new com.efs.sdk.net.a.c();
        cVar2.a = str;
        cVar2.b = java.lang.System.currentTimeMillis();
        this.a.put(str, cVar2);
        return cVar2;
    }

    public final void b(java.lang.String str) {
        java.util.HashMap<java.lang.String, com.efs.sdk.net.a.c> hashMap = this.a;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return;
        }
        this.a.remove(str);
    }

    public final com.efs.sdk.net.a.d c(java.lang.String str) {
        if (this.b == null) {
            this.b = new java.util.HashMap<>();
        }
        if (this.b.containsKey(str)) {
            return this.b.get(str);
        }
        com.efs.sdk.net.a.d dVar = new com.efs.sdk.net.a.d();
        dVar.A = str;
        dVar.D = java.lang.System.currentTimeMillis();
        this.b.put(str, dVar);
        return dVar;
    }

    public final void d(java.lang.String str) {
        java.util.HashMap<java.lang.String, com.efs.sdk.net.a.d> hashMap = this.b;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return;
        }
        this.b.remove(str);
    }
}
