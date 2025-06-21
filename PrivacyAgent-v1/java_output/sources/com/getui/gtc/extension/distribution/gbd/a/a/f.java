package com.getui.gtc.extension.distribution.gbd.a.a;

/* loaded from: classes22.dex */
public final class f implements com.getui.gtc.extension.distribution.gbd.a.a {
    private static final java.lang.String a = "RUTA";
    private final android.content.Context b;

    public static class a {
        private static final com.getui.gtc.extension.distribution.gbd.a.a.f a = new com.getui.gtc.extension.distribution.gbd.a.a.f((byte) 0);

        private a() {
        }
    }

    private f() {
        this.b = com.getui.gtc.extension.distribution.gbd.d.c.d;
    }

    public /* synthetic */ f(byte b) {
        this();
    }

    private static void a(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "save type = 0");
        if (com.getui.gtc.extension.distribution.gbd.n.l.d(0)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "instant r 0");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().a(str, 0);
        } else {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "not instant r 0");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().b(str, 0);
        }
    }

    private static com.getui.gtc.extension.distribution.gbd.a.a.f f() {
        return com.getui.gtc.extension.distribution.gbd.a.a.f.a.a;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void a() {
        boolean p = com.getui.gtc.extension.distribution.gbd.n.l.p(this.b);
        boolean n = com.getui.gtc.extension.distribution.gbd.n.l.n(this.b);
        java.lang.String displayName = java.util.TimeZone.getDefault().getDisplayName(false, 0);
        java.lang.String language = java.util.Locale.getDefault().getLanguage();
        java.lang.String country = java.util.Locale.getDefault().getCountry();
        java.lang.String str = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(com.getui.gtc.extension.distribution.gbd.n.l.C())) + "|" + com.getui.gtc.extension.distribution.gbd.d.c.e + "|" + com.getui.gtc.extension.distribution.gbd.d.c.a + "|" + p + "|" + n + "|" + displayName + "|" + language + "|" + country;
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "save type = 0");
        if (com.getui.gtc.extension.distribution.gbd.n.l.d(0)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "instant r 0");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().a(str, 0);
        } else {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "not instant r 0");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().b(str, 0);
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void b() {
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final int c() {
        return 0;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final java.lang.String d() {
        return null;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final java.lang.String e() {
        return null;
    }
}
