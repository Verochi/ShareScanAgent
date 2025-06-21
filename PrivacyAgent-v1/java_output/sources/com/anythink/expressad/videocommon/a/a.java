package com.anythink.expressad.videocommon.a;

/* loaded from: classes12.dex */
public class a {
    public static final int a = 1;
    public static final int b = 2;
    private static final java.lang.String c = "com.anythink.expressad.videocommon.a.a";
    private static com.anythink.expressad.videocommon.a.a d;

    private a() {
        try {
            com.anythink.core.common.b.o.a().f();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static com.anythink.expressad.videocommon.a.a a() {
        if (d == null) {
            synchronized (com.anythink.expressad.videocommon.a.a.class) {
                if (d == null) {
                    d = new com.anythink.expressad.videocommon.a.a();
                }
            }
        }
        return d;
    }

    public static java.util.List<com.anythink.expressad.foundation.d.c> a(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        java.util.ArrayList arrayList = null;
        if (list == null) {
            return null;
        }
        try {
            com.anythink.expressad.videocommon.e.a b2 = com.anythink.expressad.videocommon.e.c.a().b();
            long c2 = b2 != null ? b2.c() : 0L;
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (list.size() <= 0) {
                return null;
            }
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            try {
                for (com.anythink.expressad.foundation.d.c cVar : list) {
                    if (cVar != null) {
                        long o = cVar.o() * 1000;
                        long bg = currentTimeMillis - cVar.bg();
                        if ((o > 0 && o >= bg) || (o <= 0 && c2 >= bg)) {
                            arrayList2.add(cVar);
                        }
                    }
                }
                return arrayList2;
            } catch (java.lang.Exception e) {
                e = e;
                arrayList = arrayList2;
                e.printStackTrace();
                return arrayList;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
    }

    private static void a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        android.text.TextUtils.isEmpty(str2);
    }

    public static boolean a(com.anythink.expressad.foundation.d.c cVar) {
        try {
            com.anythink.expressad.videocommon.e.a b2 = com.anythink.expressad.videocommon.e.c.a().b();
            long c2 = b2 != null ? b2.c() : 0L;
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (cVar != null) {
                long o = cVar.o() * 1000;
                long bg = currentTimeMillis - cVar.bg();
                if (o > 0 && o >= bg) {
                    return false;
                }
                if (o <= 0 && c2 >= bg) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    private static void b() {
    }

    private static void c() {
    }

    private static void d() {
    }

    private static void e() {
    }

    private static void f() {
    }
}
