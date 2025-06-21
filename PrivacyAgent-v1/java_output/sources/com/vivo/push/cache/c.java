package com.vivo.push.cache;

/* loaded from: classes19.dex */
public abstract class c<T> {
    protected static final java.lang.Object a = new java.lang.Object();
    protected java.util.List<T> b = new java.util.ArrayList();
    protected android.content.Context c;
    private byte[] d;
    private byte[] e;

    public c(android.content.Context context) {
        this.c = com.vivo.push.util.ContextDelegate.getContext(context);
        com.vivo.push.util.w b = com.vivo.push.util.w.b();
        b.a(this.c);
        this.d = b.c();
        this.e = b.d();
        c();
    }

    private java.lang.String b() {
        return com.vivo.push.util.y.b(this.c).a(a(), null);
    }

    private void c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.vivo.push.util.p.d("CacheSettings", "ClientManager init " + a() + " strApps empty.");
            return;
        }
        if (str.length() > 10000) {
            com.vivo.push.util.p.d("CacheSettings", "sync " + a() + " strApps lenght too large");
            d();
            return;
        }
        try {
            com.vivo.push.util.p.d("CacheSettings", "ClientManager init " + a() + " strApps : " + str);
            java.util.List<T> a2 = a(b(str));
            if (a2 != null) {
                this.b.addAll(a2);
            }
        } catch (java.lang.Exception e) {
            d();
            com.vivo.push.util.p.d("CacheSettings", com.vivo.push.util.p.a(e));
        }
    }

    private void d(java.lang.String str) {
        com.vivo.push.util.y.b(this.c).b(a(), str);
    }

    public abstract java.lang.String a();

    public abstract java.util.List<T> a(java.lang.String str);

    public abstract java.lang.String b(java.lang.String str);

    public final void c() {
        synchronized (a) {
            com.vivo.push.util.g.a(a());
            this.b.clear();
            c(b());
        }
    }

    public final void d() {
        synchronized (a) {
            this.b.clear();
            d("");
            com.vivo.push.util.p.d("CacheSettings", "clear " + a() + " strApps");
        }
    }

    public final byte[] e() {
        byte[] bArr = this.d;
        return (bArr == null || bArr.length <= 0) ? com.vivo.push.util.w.b().c() : bArr;
    }

    public final byte[] f() {
        byte[] bArr = this.e;
        return (bArr == null || bArr.length <= 0) ? com.vivo.push.util.w.b().d() : bArr;
    }
}
