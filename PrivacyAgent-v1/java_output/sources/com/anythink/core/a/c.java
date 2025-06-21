package com.anythink.core.a;

/* loaded from: classes12.dex */
public final class c {
    private static com.anythink.core.a.c a;
    private final java.lang.String b = "pacing_";

    /* renamed from: com.anythink.core.a.c$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass1(java.lang.String str, java.lang.String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.anythink.core.common.o.r.a(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.p, "pacing_" + this.a + "_" + this.b, java.lang.System.currentTimeMillis());
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static com.anythink.core.a.c a() {
        if (a == null) {
            a = new com.anythink.core.a.c();
        }
        return a;
    }

    public static void a(java.lang.String str) {
        try {
            com.anythink.core.common.o.r.a(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.p, "pacing_".concat(java.lang.String.valueOf(str)), java.lang.System.currentTimeMillis());
        } catch (java.lang.Exception unused) {
        }
    }

    public static boolean a(java.lang.String str, com.anythink.core.d.e eVar) {
        if (eVar == null) {
            return true;
        }
        if (eVar.am() == -1) {
            return false;
        }
        long longValue = com.anythink.core.common.o.r.a(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.p, "pacing_".concat(java.lang.String.valueOf(str)), (java.lang.Long) 0L).longValue();
        if (java.lang.System.currentTimeMillis() - longValue >= 0) {
            return java.lang.System.currentTimeMillis() - longValue < eVar.am();
        }
        a(str);
        return false;
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.a.c.AnonymousClass1(str, str2), 2, true);
    }

    public final boolean a(java.lang.String str, com.anythink.core.common.f.au auVar) {
        if (auVar == null) {
            return true;
        }
        if (auVar.t() == -1) {
            return false;
        }
        long longValue = com.anythink.core.common.o.r.a(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.p, "pacing_" + str + "_" + auVar.u(), (java.lang.Long) 0L).longValue();
        if (java.lang.System.currentTimeMillis() - longValue >= 0) {
            return java.lang.System.currentTimeMillis() - longValue < auVar.t();
        }
        a(str, auVar.u());
        return false;
    }
}
