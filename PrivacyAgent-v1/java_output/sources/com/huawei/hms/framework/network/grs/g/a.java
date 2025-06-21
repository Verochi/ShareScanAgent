package com.huawei.hms.framework.network.grs.g;

/* loaded from: classes22.dex */
public class a {
    protected com.huawei.hms.framework.network.grs.g.d a;
    private final java.lang.String b;
    private final com.huawei.hms.framework.network.grs.g.c c;
    private final int d;
    private final android.content.Context e;
    private final java.lang.String f;
    private final com.huawei.hms.framework.network.grs.GrsBaseInfo g;
    private final com.huawei.hms.framework.network.grs.e.c h;

    /* renamed from: com.huawei.hms.framework.network.grs.g.a$a, reason: collision with other inner class name */
    public enum EnumC0364a {
        GRSPOST,
        GRSGET,
        GRSDEFAULT
    }

    public a(java.lang.String str, int i, com.huawei.hms.framework.network.grs.g.c cVar, android.content.Context context, java.lang.String str2, com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.c cVar2) {
        this.b = str;
        this.c = cVar;
        this.d = i;
        this.e = context;
        this.f = str2;
        this.g = grsBaseInfo;
        this.h = cVar2;
    }

    private java.lang.String a(java.lang.String str) {
        return android.net.Uri.parse(str).getPath();
    }

    private com.huawei.hms.framework.network.grs.g.a.EnumC0364a h() {
        if (this.b.isEmpty()) {
            return com.huawei.hms.framework.network.grs.g.a.EnumC0364a.GRSDEFAULT;
        }
        java.lang.String a = a(this.b);
        return a.contains("1.0") ? com.huawei.hms.framework.network.grs.g.a.EnumC0364a.GRSGET : a.contains("2.0") ? com.huawei.hms.framework.network.grs.g.a.EnumC0364a.GRSPOST : com.huawei.hms.framework.network.grs.g.a.EnumC0364a.GRSDEFAULT;
    }

    public android.content.Context a() {
        return this.e;
    }

    public com.huawei.hms.framework.network.grs.g.c b() {
        return this.c;
    }

    public java.lang.String c() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public java.lang.String e() {
        return this.f;
    }

    public com.huawei.hms.framework.network.grs.e.c f() {
        return this.h;
    }

    public java.util.concurrent.Callable<com.huawei.hms.framework.network.grs.g.d> g() {
        if (com.huawei.hms.framework.network.grs.g.a.EnumC0364a.GRSDEFAULT.equals(h())) {
            return null;
        }
        return com.huawei.hms.framework.network.grs.g.a.EnumC0364a.GRSGET.equals(h()) ? new com.huawei.hms.framework.network.grs.g.f(this.b, this.d, this.c, this.e, this.f, this.g) : new com.huawei.hms.framework.network.grs.g.g(this.b, this.d, this.c, this.e, this.f, this.g, this.h);
    }
}
