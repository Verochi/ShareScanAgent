package com.umeng.commonsdk.statistics.idtracking;

/* loaded from: classes19.dex */
public abstract class a {
    private final int a = 10;
    private final int b = 100;
    private final java.lang.String c;
    private java.util.List<com.umeng.commonsdk.statistics.proto.a> d;
    private com.umeng.commonsdk.statistics.proto.b e;

    public a(java.lang.String str) {
        this.c = str;
    }

    private boolean g() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.e;
        java.lang.String b = bVar == null ? null : bVar.b();
        int h = bVar == null ? 0 : bVar.h();
        java.lang.String a = a(f());
        if (a == null || a.equals(b)) {
            return false;
        }
        if (bVar == null) {
            bVar = new com.umeng.commonsdk.statistics.proto.b();
        }
        bVar.a(a);
        bVar.a(java.lang.System.currentTimeMillis());
        bVar.a(h + 1);
        com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
        aVar.a(this.c);
        aVar.c(a);
        aVar.b(b);
        aVar.a(bVar.e());
        if (this.d == null) {
            this.d = new java.util.ArrayList(2);
        }
        this.d.add(aVar);
        if (this.d.size() > 10) {
            this.d.remove(0);
        }
        this.e = bVar;
        return true;
    }

    public java.lang.String a(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.lang.String trim = str.trim();
        if (trim.length() == 0 || "0".equals(trim) || "unknown".equals(trim.toLowerCase(java.util.Locale.US))) {
            return null;
        }
        return trim;
    }

    public void a(com.umeng.commonsdk.statistics.proto.b bVar) {
        this.e = bVar;
    }

    public void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        this.e = cVar.c().get(this.c);
        java.util.List<com.umeng.commonsdk.statistics.proto.a> h = cVar.h();
        if (h == null || h.size() <= 0) {
            return;
        }
        if (this.d == null) {
            this.d = new java.util.ArrayList();
        }
        for (com.umeng.commonsdk.statistics.proto.a aVar : h) {
            if (this.c.equals(aVar.a)) {
                this.d.add(aVar);
            }
        }
    }

    public void a(java.util.List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.d = list;
    }

    public boolean a() {
        return g();
    }

    public java.lang.String b() {
        return this.c;
    }

    public boolean c() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.e;
        return bVar == null || bVar.h() <= 100;
    }

    public com.umeng.commonsdk.statistics.proto.b d() {
        return this.e;
    }

    public java.util.List<com.umeng.commonsdk.statistics.proto.a> e() {
        return this.d;
    }

    public abstract java.lang.String f();
}
