package com.getui.gtc.extension.distribution.gbd.d;

/* loaded from: classes22.dex */
public class c {
    public static java.lang.String a = "";
    public static java.lang.String b = "";
    public static java.lang.String c = "";
    public static android.content.Context d = null;
    public static java.lang.String e = null;
    public static java.lang.String f = null;
    public static java.lang.String g = null;
    public static java.lang.String h = null;
    public static java.io.File i = null;
    public static long j = 0;
    public static boolean k = false;
    private static final java.lang.String l = "GBD_CoreRuntimeInfo";
    private static com.getui.gtc.extension.distribution.gbd.d.c m;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.d.c$1, reason: invalid class name */
    public class AnonymousClass1 implements com.getui.gtc.extension.distribution.gbd.f.j<android.content.Context, java.io.File> {
        public AnonymousClass1() {
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.io.File a2(android.content.Context context) {
            return context.getExternalFilesDir(null).getParentFile().getParentFile();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.io.File a(android.content.Context context) {
            return context.getExternalFilesDir(null).getParentFile().getParentFile();
        }
    }

    public static com.getui.gtc.extension.distribution.gbd.d.c a() {
        if (m == null) {
            synchronized (com.getui.gtc.extension.distribution.gbd.d.c.class) {
                if (m == null) {
                    m = new com.getui.gtc.extension.distribution.gbd.d.c();
                }
            }
        }
        return m;
    }

    private static void b() {
        try {
            f = com.getui.gtc.extension.distribution.gbd.n.l.f();
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.getui.gtc.extension.distribution.gbd.n.j.a(l, "gbd coreruntimeinfo init");
        com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_CoreRuntimeInfo|gbd coreruntimeinfo init");
        if (!str2.equals(e) && !android.text.TextUtils.isEmpty(e)) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(l, "gbd has start, gicid = " + str2 + ", coreRuntimeInfo.cid = " + e);
            com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_CoreRuntimeInfo|gbd has start, gicid = " + str2 + ", coreRuntimeInfo.cid = " + e);
            e = str2;
            return;
        }
        d = context;
        e = str2;
        a = str;
        c = context.getPackageName();
        b = com.getui.gtc.extension.distribution.gbd.d.i.c();
        com.getui.gtc.extension.distribution.gbd.n.j.a(l, "cid = " + str2 + ", appid = " + str + ",pkgname = " + c);
        com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_CoreRuntimeInfo|cid = " + str2 + ", appid = " + str + ",pkgname = " + c);
        k = com.getui.gtc.extension.distribution.gbd.n.l.H();
        try {
            f = com.getui.gtc.extension.distribution.gbd.n.l.f();
        } catch (java.lang.Throwable unused) {
        }
        try {
            java.lang.String str3 = f;
            if (str3 == null) {
                str3 = "cantgetimei";
            }
            java.lang.String a2 = com.getui.gtc.extension.distribution.gbd.n.ad.a(str3);
            h = a2;
            if (android.text.TextUtils.isEmpty(a2)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(l, "create storeKey=" + h);
                com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_CoreRuntimeInfo|gbd runTimerInfo init success ##########");
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(l, "throwable = ".concat(java.lang.String.valueOf(th)));
            com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_CoreRuntimeInfo|throwable = ".concat(java.lang.String.valueOf(th)));
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        try {
            java.io.File file = (java.io.File) com.getui.gtc.extension.distribution.gbd.h.a.a(true, com.getui.gtc.extension.distribution.gbd.f.b.f, context, new com.getui.gtc.extension.distribution.gbd.d.c.AnonymousClass1());
            i = file;
            if (file == null) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(l, "no a d dir.");
                return;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(l, "a d dir = " + i.getAbsolutePath());
        } catch (java.lang.Throwable th2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(l, "read f throwable = ".concat(java.lang.String.valueOf(th2)));
            com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_CoreRuntimeInfo|read f throwable = ".concat(java.lang.String.valueOf(th2)));
            com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
        }
    }
}
