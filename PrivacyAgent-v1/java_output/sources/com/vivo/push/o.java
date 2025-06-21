package com.vivo.push;

/* loaded from: classes19.dex */
public abstract class o {
    private int a;
    private java.lang.String b;

    public o(int i) {
        this.a = -1;
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("PushCommand: the value of command must > 0.");
        }
        this.a = i;
    }

    private void e(com.vivo.push.a aVar) {
        aVar.a(com.heytap.mcssdk.constant.b.y, this.a);
        aVar.a("client_pkgname", this.b);
        c(aVar);
    }

    public final java.lang.String a() {
        return this.b;
    }

    public final void a(android.content.Intent intent) {
        com.vivo.push.a a = com.vivo.push.a.a(intent);
        if (a == null) {
            com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            return;
        }
        a(a);
        android.os.Bundle b = a.b();
        if (b != null) {
            intent.putExtras(b);
        }
    }

    public final void a(com.vivo.push.a aVar) {
        java.lang.String a = com.vivo.push.p.a(this.a);
        if (a == null) {
            a = "";
        }
        aVar.a("method", a);
        e(aVar);
    }

    public final void a(java.lang.String str) {
        this.b = str;
    }

    public final int b() {
        return this.a;
    }

    public final void b(android.content.Intent intent) {
        com.vivo.push.a a = com.vivo.push.a.a(intent);
        if (a == null) {
            com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            return;
        }
        a.a("method", this.a);
        e(a);
        android.os.Bundle b = a.b();
        if (b != null) {
            intent.putExtras(b);
        }
    }

    public final void b(com.vivo.push.a aVar) {
        java.lang.String a = aVar.a();
        if (android.text.TextUtils.isEmpty(a)) {
            a = aVar.a("client_pkgname");
        }
        this.b = a;
        d(aVar);
    }

    public abstract void c(com.vivo.push.a aVar);

    public boolean c() {
        return false;
    }

    public abstract void d(com.vivo.push.a aVar);

    public java.lang.String toString() {
        return getClass().getSimpleName();
    }
}
