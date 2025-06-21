package com.vivo.push.b;

/* loaded from: classes19.dex */
public class c extends com.vivo.push.o {
    private java.lang.String a;
    private java.lang.String b;
    private long c;
    private int d;
    private int e;
    private java.lang.String f;

    public c(int i, java.lang.String str) {
        super(i);
        this.c = -1L;
        this.d = -1;
        this.a = null;
        this.b = str;
    }

    public final int a(android.content.Context context) {
        if (this.d == -1) {
            java.lang.String str = this.b;
            if (android.text.TextUtils.isEmpty(str)) {
                com.vivo.push.util.p.a("BaseAppCommand", "pkg name is null");
                str = a();
                if (android.text.TextUtils.isEmpty(str)) {
                    com.vivo.push.util.p.a("BaseAppCommand", "src is null");
                    return -1;
                }
            }
            this.d = com.vivo.push.util.t.b(context, str);
            if (!android.text.TextUtils.isEmpty(this.f)) {
                this.d = 2;
            }
        }
        return this.d;
    }

    public final void a(int i) {
        this.e = i;
    }

    public final void b(java.lang.String str) {
        this.a = str;
    }

    @Override // com.vivo.push.o
    public void c(com.vivo.push.a aVar) {
        aVar.a(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.reqId, this.a);
        aVar.a("package_name", this.b);
        aVar.a("sdk_version", 323L);
        aVar.a("PUSH_APP_STATUS", this.d);
        if (android.text.TextUtils.isEmpty(this.f)) {
            return;
        }
        aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f);
    }

    @Override // com.vivo.push.o
    public void d(com.vivo.push.a aVar) {
        this.a = aVar.a(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.reqId);
        this.b = aVar.a("package_name");
        this.c = aVar.b("sdk_version", 0L);
        this.d = aVar.b("PUSH_APP_STATUS", 0);
        this.f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
    }

    public final int f() {
        return this.e;
    }

    public final void g() {
        this.f = null;
    }

    public final java.lang.String h() {
        return this.a;
    }

    @Override // com.vivo.push.o
    public java.lang.String toString() {
        return "BaseAppCommand";
    }
}
