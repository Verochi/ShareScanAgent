package com.tramini.plugin.a;

/* loaded from: classes19.dex */
public class a {
    private static volatile com.tramini.plugin.a.a a;

    private a() {
    }

    public static com.tramini.plugin.a.a a() {
        if (a == null) {
            synchronized (com.tramini.plugin.a.a.class) {
                if (a == null) {
                    a = new com.tramini.plugin.a.a();
                }
            }
        }
        return a;
    }

    private static java.lang.String a(java.lang.String str, java.lang.String str2) {
        return android.text.TextUtils.isEmpty(str) ? str2 : str;
    }

    public static java.lang.String b() {
        com.tramini.plugin.b.b b = com.tramini.plugin.b.c.b(com.tramini.plugin.a.b.c.a().b());
        return b != null ? a(b.o(), com.tramini.plugin.a.b.a.C0505a.b) : com.tramini.plugin.a.b.a.C0505a.b;
    }

    public static java.lang.String c() {
        com.tramini.plugin.b.b b = com.tramini.plugin.b.c.b(com.tramini.plugin.a.b.c.a().b());
        return b != null ? a(b.p(), com.tramini.plugin.a.b.a.C0505a.c) : com.tramini.plugin.a.b.a.C0505a.c;
    }
}
