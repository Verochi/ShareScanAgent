package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class y {
    public static java.lang.String a() {
        try {
            if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.h.ap)) {
                com.getui.gtc.extension.distribution.gbd.d.h.ap = com.getui.gtc.extension.distribution.gbd.n.a.a();
            }
            return com.getui.gtc.extension.distribution.gbd.n.e.a(com.getui.gtc.extension.distribution.gbd.n.u.a(com.getui.gtc.extension.distribution.gbd.n.a.a(com.getui.gtc.extension.distribution.gbd.d.h.ap.getBytes("UTF-8")), com.getui.gtc.extension.distribution.gbd.n.u.a(com.getui.gtc.extension.distribution.gbd.n.e.a(com.getui.gtc.extension.distribution.gbd.d.g.Z.getBytes("UTF-8")))), 0);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "";
        }
    }

    public static java.lang.String a(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && !"none".equalsIgnoreCase(str)) {
            try {
                java.lang.String[] split = str.split(",");
                if (split.length < 2) {
                    return null;
                }
                return com.getui.gtc.extension.distribution.gbd.n.a.a(com.getui.gtc.extension.distribution.gbd.n.a.a(split[0]), split[1], com.getui.gtc.extension.distribution.gbd.n.p.a("".getBytes("UTF-8")));
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
        return null;
    }

    private static java.lang.String a(java.lang.String str, byte[] bArr) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            byte[] bArr2 = new byte[bytes.length + bArr.length];
            int a = com.getui.gtc.extension.distribution.gbd.n.f.a(bytes, bArr2, 0, bytes.length);
            if (bArr.length > 0) {
                com.getui.gtc.extension.distribution.gbd.n.f.a(bArr, bArr2, a, bArr.length);
            }
            return com.getui.gtc.extension.distribution.gbd.n.e.b(com.getui.gtc.extension.distribution.gbd.n.p.b(bArr2));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return com.getui.gtc.extension.distribution.gbd.n.a.b(android.util.Base64.decode(com.getui.gtc.extension.distribution.gbd.d.h.as, 0), bArr, com.getui.gtc.extension.distribution.gbd.n.p.a(com.getui.gtc.extension.distribution.gbd.d.g.aa.getBytes("UTF-8")));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            return com.getui.gtc.extension.distribution.gbd.n.a.d(com.getui.gtc.extension.distribution.gbd.d.h.ap.getBytes("UTF-8"), bArr, bArr2);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    public static java.lang.String b(java.lang.String str) {
        try {
            return new java.lang.String(com.getui.gtc.extension.distribution.gbd.n.t.a(com.getui.gtc.extension.distribution.gbd.n.e.a(com.getui.gtc.extension.distribution.gbd.n.a.b(android.util.Base64.decode(com.getui.gtc.extension.distribution.gbd.d.g.ac, 0), str, com.getui.gtc.extension.distribution.gbd.n.p.a(com.getui.gtc.extension.distribution.gbd.d.g.aa.getBytes("UTF-8"))).toCharArray(), 0), com.getui.gtc.extension.distribution.gbd.d.g.aa), "UTF-8");
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    private static void b() {
        com.getui.gtc.extension.distribution.gbd.d.h.ap = com.getui.gtc.extension.distribution.gbd.n.a.a();
    }

    private static byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            return com.getui.gtc.extension.distribution.gbd.n.a.f(com.getui.gtc.extension.distribution.gbd.d.h.ap.getBytes("UTF-8"), bArr, bArr2);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    private static byte[] c() {
        try {
            return com.getui.gtc.extension.distribution.gbd.d.g.X.getBytes("UTF-8");
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    public static byte[] c(java.lang.String str) {
        if (str == null) {
            return null;
        }
        try {
            return com.getui.gtc.extension.distribution.gbd.n.a.a(android.util.Base64.decode(com.getui.gtc.extension.distribution.gbd.d.h.as, 0), str.getBytes("UTF-8"), com.getui.gtc.extension.distribution.gbd.n.p.a(com.getui.gtc.extension.distribution.gbd.d.g.aa.getBytes("UTF-8")));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    public static java.lang.String d(java.lang.String str) {
        try {
            return com.getui.gtc.extension.distribution.gbd.n.a.c(com.getui.gtc.extension.distribution.gbd.d.h.ap.getBytes("UTF-8"), str.getBytes("UTF-8"), com.getui.gtc.extension.distribution.gbd.n.p.a(com.getui.gtc.extension.distribution.gbd.d.g.aa.getBytes("UTF-8")));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    private static byte[] d() {
        try {
            if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.h.ap)) {
                com.getui.gtc.extension.distribution.gbd.d.h.ap = com.getui.gtc.extension.distribution.gbd.n.a.a();
            }
            return com.getui.gtc.extension.distribution.gbd.n.u.a(com.getui.gtc.extension.distribution.gbd.n.a.a(com.getui.gtc.extension.distribution.gbd.d.h.ap.getBytes("UTF-8")), com.getui.gtc.extension.distribution.gbd.n.u.a(com.getui.gtc.extension.distribution.gbd.n.e.a(com.getui.gtc.extension.distribution.gbd.d.g.Y.getBytes("UTF-8"))));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return new byte[0];
        }
    }

    private static java.lang.String e() {
        try {
            byte[] d = d();
            byte[] bytes = com.getui.gtc.extension.distribution.gbd.n.ad.a().getBytes("UTF-8");
            byte[] bArr = new byte[bytes.length + d.length];
            com.getui.gtc.extension.distribution.gbd.n.f.a(d, bArr, com.getui.gtc.extension.distribution.gbd.n.f.a(bytes, bArr, 0, bytes.length), d.length);
            return com.getui.gtc.extension.distribution.gbd.n.e.b(bArr);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    public static java.lang.String e(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return com.getui.gtc.extension.distribution.gbd.n.a.e(android.util.Base64.decode(android.os.Build.VERSION.SDK_INT >= 28 ? com.getui.gtc.extension.distribution.gbd.d.h.ar : com.getui.gtc.extension.distribution.gbd.d.h.aq, 0), str.getBytes("UTF-8"), com.getui.gtc.extension.distribution.gbd.n.p.a(com.getui.gtc.extension.distribution.gbd.d.g.aa.getBytes("UTF-8")));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    private static java.lang.String f(java.lang.String str) {
        try {
            return com.getui.gtc.extension.distribution.gbd.n.a.c(com.getui.gtc.extension.distribution.gbd.d.h.ap.getBytes("UTF-8"), str, com.getui.gtc.extension.distribution.gbd.n.p.a(com.getui.gtc.extension.distribution.gbd.d.g.aa.getBytes("UTF-8")));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }
}
