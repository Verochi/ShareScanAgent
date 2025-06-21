package com.vivo.push.util;

/* loaded from: classes19.dex */
public final class y implements com.vivo.push.util.d {
    private static final java.util.HashMap<java.lang.String, java.lang.Integer> a = new java.util.HashMap<>();
    private static final java.util.HashMap<java.lang.String, java.lang.Long> b = new java.util.HashMap<>();
    private static final java.util.HashMap<java.lang.String, java.lang.String> c = new java.util.HashMap<>();
    private static com.vivo.push.util.y d;
    private android.content.Context e;
    private com.vivo.push.util.d f;
    private boolean g;

    private y(android.content.Context context) {
        this.g = false;
        this.e = context;
        this.g = a(context);
        com.vivo.push.util.p.d("SystemCache", "init status is " + this.g + ";  curCache is " + this.f);
    }

    public static synchronized com.vivo.push.util.y b(android.content.Context context) {
        com.vivo.push.util.y yVar;
        synchronized (com.vivo.push.util.y.class) {
            if (d == null) {
                d = new com.vivo.push.util.y(context.getApplicationContext());
            }
            yVar = d;
        }
        return yVar;
    }

    @Override // com.vivo.push.util.d
    public final java.lang.String a(java.lang.String str, java.lang.String str2) {
        com.vivo.push.util.d dVar;
        java.lang.String str3 = c.get(str);
        return (str3 != null || (dVar = this.f) == null) ? str3 : dVar.a(str, str2);
    }

    public final void a() {
        com.vivo.push.util.x xVar = new com.vivo.push.util.x();
        if (xVar.a(this.e)) {
            xVar.a();
            com.vivo.push.util.p.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.d
    public final boolean a(android.content.Context context) {
        com.vivo.push.util.v vVar = new com.vivo.push.util.v();
        this.f = vVar;
        boolean a2 = vVar.a(context);
        if (!a2) {
            com.vivo.push.util.x xVar = new com.vivo.push.util.x();
            this.f = xVar;
            a2 = xVar.a(context);
        }
        if (!a2) {
            this.f = null;
        }
        return a2;
    }

    @Override // com.vivo.push.util.d
    public final void b(java.lang.String str, java.lang.String str2) {
        com.vivo.push.util.d dVar;
        c.put(str, str2);
        if (!this.g || (dVar = this.f) == null) {
            return;
        }
        dVar.b(str, str2);
    }
}
