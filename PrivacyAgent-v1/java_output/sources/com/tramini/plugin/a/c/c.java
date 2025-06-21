package com.tramini.plugin.a.c;

/* loaded from: classes19.dex */
public class c extends com.tramini.plugin.a.c.b {
    private static com.tramini.plugin.a.c.c a;

    private c(android.content.Context context) {
        super(context);
    }

    public static com.tramini.plugin.a.c.c a(android.content.Context context) {
        if (a == null) {
            synchronized (com.tramini.plugin.a.c.c.class) {
                a = new com.tramini.plugin.a.c.c(context.getApplicationContext());
            }
        }
        return a;
    }

    private void h() {
        try {
            b().execSQL("DROP TABLE IF EXISTS 'il'");
            b().execSQL("DROP TABLE IF EXISTS 'il_all'");
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.tramini.plugin.a.c.b
    public final java.lang.String c() {
        return "tramini.db";
    }

    @Override // com.tramini.plugin.a.c.b
    public final int d() {
        return 2;
    }

    @Override // com.tramini.plugin.a.c.b
    public final void e() {
    }

    @Override // com.tramini.plugin.a.c.b
    public final void f() {
    }

    @Override // com.tramini.plugin.a.c.b
    public final void g() {
    }
}
