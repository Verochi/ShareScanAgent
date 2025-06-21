package com.meizu.cloud.pushsdk.c.e;

/* loaded from: classes23.dex */
public final class a {
    private static java.lang.String a;

    public static com.meizu.cloud.pushsdk.c.c.k a(com.meizu.cloud.pushsdk.c.a.b bVar) throws com.meizu.cloud.pushsdk.c.b.a {
        try {
            com.meizu.cloud.pushsdk.c.c.i.a a2 = new com.meizu.cloud.pushsdk.c.c.i.a().a(bVar.e());
            a(a2, bVar);
            int d = bVar.d();
            if (d == 0) {
                a2 = a2.a();
            } else if (d == 1) {
                a2 = a2.a(bVar.m());
            } else if (d == 2) {
                a2 = a2.c(bVar.m());
            } else if (d == 3) {
                a2 = a2.b(bVar.m());
            } else if (d == 4) {
                a2 = a2.b();
            } else if (d == 5) {
                a2 = a2.d(bVar.m());
            }
            com.meizu.cloud.pushsdk.c.c.i c = a2.c();
            bVar.a(new com.meizu.cloud.pushsdk.c.c.e());
            return bVar.l().a(c);
        } catch (java.io.IOException e) {
            throw new com.meizu.cloud.pushsdk.c.b.a(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(com.meizu.cloud.pushsdk.c.c.i.a aVar, com.meizu.cloud.pushsdk.c.a.b bVar) {
        java.lang.String str;
        com.meizu.cloud.pushsdk.c.c.c o;
        if (bVar.h() == null) {
            java.lang.String str2 = a;
            if (str2 != null) {
                bVar.a(str2);
                str = a;
            }
            o = bVar.o();
            if (o == null) {
                aVar.a(o);
                if (bVar.h() == null || o.b().contains("User-Agent")) {
                    return;
                }
                aVar.a("User-Agent", bVar.h());
                return;
            }
            return;
        }
        str = bVar.h();
        aVar.a("User-Agent", str);
        o = bVar.o();
        if (o == null) {
        }
    }

    public static com.meizu.cloud.pushsdk.c.c.k b(com.meizu.cloud.pushsdk.c.a.b bVar) throws com.meizu.cloud.pushsdk.c.b.a {
        try {
            com.meizu.cloud.pushsdk.c.c.i.a a2 = new com.meizu.cloud.pushsdk.c.c.i.a().a(bVar.e());
            a(a2, bVar);
            com.meizu.cloud.pushsdk.c.c.i c = a2.a().c();
            bVar.a(new com.meizu.cloud.pushsdk.c.c.e());
            com.meizu.cloud.pushsdk.c.c.k a3 = bVar.l().a(c);
            com.meizu.cloud.pushsdk.c.h.b.a(a3, bVar.j(), bVar.k());
            return a3;
        } catch (java.io.IOException e) {
            try {
                java.io.File file = new java.io.File(bVar.j() + java.io.File.separator + bVar.k());
                if (file.exists()) {
                    file.delete();
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
            throw new com.meizu.cloud.pushsdk.c.b.a(e);
        }
    }

    public static com.meizu.cloud.pushsdk.c.c.k c(com.meizu.cloud.pushsdk.c.a.b bVar) throws com.meizu.cloud.pushsdk.c.b.a {
        try {
            com.meizu.cloud.pushsdk.c.c.i.a a2 = new com.meizu.cloud.pushsdk.c.c.i.a().a(bVar.e());
            a(a2, bVar);
            com.meizu.cloud.pushsdk.c.c.i c = a2.a(new com.meizu.cloud.pushsdk.c.e.b(bVar.n(), bVar.i())).c();
            bVar.a(new com.meizu.cloud.pushsdk.c.c.e());
            return bVar.l().a(c);
        } catch (java.io.IOException e) {
            throw new com.meizu.cloud.pushsdk.c.b.a(e);
        }
    }
}
