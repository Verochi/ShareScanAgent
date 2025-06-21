package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ey {

    public static class a {
        java.lang.String a;
        java.lang.String b;
        java.lang.String c;
        java.lang.String d;
        java.lang.String e;
        java.lang.String f;
        java.lang.String g;
        java.lang.String h;
        java.lang.String i;
        java.lang.String j;
        java.lang.String k;
        java.lang.String l;
        java.lang.String m;
        java.lang.String n;
        java.lang.String o;
        java.lang.String p;
        java.lang.String q;
        java.lang.String r;

        /* renamed from: s, reason: collision with root package name */
        java.lang.String f129s;
        java.lang.String t;
        java.lang.String u;
        java.lang.String v;
        java.lang.String w;
        java.lang.String x;
        java.lang.String y;
        java.lang.String z;

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static java.lang.String a() {
        try {
            java.lang.String valueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
            java.lang.String str = com.amap.api.mapcore.util.ev.a() ? "1" : "0";
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "CI", "TS");
            return null;
        }
    }

    public static java.lang.String a(android.content.Context context) {
        try {
            com.amap.api.mapcore.util.ey.a aVar = new com.amap.api.mapcore.util.ey.a((byte) 0);
            aVar.d = com.amap.api.mapcore.util.ev.c(context);
            aVar.i = com.amap.api.mapcore.util.ev.d(context);
            return a(aVar);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "CI", "IX");
            return null;
        }
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            return com.amap.api.mapcore.util.fd.b(com.amap.api.mapcore.util.ev.e(context) + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str.substring(0, str.length() - 3) + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str2);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "CI", "Sco");
            return null;
        }
    }

    private static java.lang.String a(com.amap.api.mapcore.util.ey.a aVar) {
        return com.amap.api.mapcore.util.fa.b(b(aVar));
    }

    private static void a(java.io.ByteArrayOutputStream byteArrayOutputStream, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.amap.api.mapcore.util.fi.a(byteArrayOutputStream, (byte) 0, new byte[0]);
        } else {
            com.amap.api.mapcore.util.fi.a(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, com.amap.api.mapcore.util.fi.a(str));
        }
    }

    public static byte[] a(android.content.Context context, boolean z, boolean z2) {
        try {
            return b(b(context, z, z2));
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "CI", "gz");
            return null;
        }
    }

    public static byte[] a(byte[] bArr) throws java.security.cert.CertificateException, java.security.spec.InvalidKeySpecException, java.security.NoSuchAlgorithmException, java.lang.NullPointerException, java.io.IOException, java.security.InvalidKeyException, javax.crypto.NoSuchPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException {
        return com.amap.api.mapcore.util.fa.a(bArr);
    }

    private static com.amap.api.mapcore.util.ey.a b(android.content.Context context, boolean z, boolean z2) {
        com.amap.api.mapcore.util.ey.a aVar = new com.amap.api.mapcore.util.ey.a((byte) 0);
        aVar.a = com.amap.api.mapcore.util.ez.s(context);
        aVar.b = com.amap.api.mapcore.util.ez.k(context);
        java.lang.String h = com.amap.api.mapcore.util.ez.h(context);
        if (h == null) {
            h = "";
        }
        aVar.c = h;
        aVar.d = com.amap.api.mapcore.util.ev.c(context);
        aVar.e = android.os.Build.MODEL;
        aVar.f = android.os.Build.MANUFACTURER;
        aVar.g = android.os.Build.DEVICE;
        aVar.h = com.amap.api.mapcore.util.ev.b(context);
        aVar.i = com.amap.api.mapcore.util.ev.d(context);
        aVar.j = java.lang.String.valueOf(android.os.Build.VERSION.SDK_INT);
        aVar.k = com.amap.api.mapcore.util.ez.v(context);
        aVar.l = com.amap.api.mapcore.util.ez.p(context);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.amap.api.mapcore.util.ez.n(context));
        aVar.m = sb.toString();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(com.amap.api.mapcore.util.ez.m(context));
        aVar.n = sb2.toString();
        aVar.o = com.amap.api.mapcore.util.ez.x(context);
        aVar.p = com.amap.api.mapcore.util.ez.l(context);
        aVar.q = "";
        aVar.r = "";
        if (z) {
            aVar.f129s = "";
            aVar.t = "";
        } else {
            java.lang.String[] d = com.amap.api.mapcore.util.ez.d();
            aVar.f129s = d[0];
            aVar.t = d[1];
        }
        aVar.w = com.amap.api.mapcore.util.ez.a();
        java.lang.String a2 = com.amap.api.mapcore.util.ez.a(context);
        if (android.text.TextUtils.isEmpty(a2)) {
            aVar.x = "";
        } else {
            aVar.x = a2;
        }
        aVar.y = "aid=" + com.amap.api.mapcore.util.ez.j(context);
        if ((z2 && com.amap.api.mapcore.util.fx.d) || com.amap.api.mapcore.util.fx.e) {
            java.lang.String g = com.amap.api.mapcore.util.ez.g(context);
            if (!android.text.TextUtils.isEmpty(g)) {
                aVar.y += "|oaid=" + g;
            }
        }
        java.lang.String a3 = com.amap.api.mapcore.util.ez.a(context, ",");
        if (!android.text.TextUtils.isEmpty(a3)) {
            aVar.y += "|multiImeis=" + a3;
        }
        java.lang.String u = com.amap.api.mapcore.util.ez.u(context);
        if (!android.text.TextUtils.isEmpty(u)) {
            aVar.y += "|meid=" + u;
        }
        aVar.y += "|serial=" + com.amap.api.mapcore.util.ez.i(context);
        java.lang.String b = com.amap.api.mapcore.util.ez.b();
        if (!android.text.TextUtils.isEmpty(b)) {
            aVar.y += "|adiuExtras=" + b;
        }
        aVar.y += "|storage=" + com.amap.api.mapcore.util.ez.e() + "|ram=" + com.amap.api.mapcore.util.ez.w(context) + "|arch=" + com.amap.api.mapcore.util.ez.f();
        java.lang.String b2 = com.amap.api.mapcore.util.fz.a().b();
        if (android.text.TextUtils.isEmpty(b2)) {
            aVar.z = "";
        } else {
            aVar.z = b2;
        }
        return aVar;
    }

    public static java.lang.String b(android.content.Context context) {
        return c(context);
    }

    private static byte[] b(com.amap.api.mapcore.util.ey.a aVar) {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            try {
                a(byteArrayOutputStream, aVar.a);
                a(byteArrayOutputStream, aVar.b);
                a(byteArrayOutputStream, aVar.c);
                a(byteArrayOutputStream, aVar.d);
                a(byteArrayOutputStream, aVar.e);
                a(byteArrayOutputStream, aVar.f);
                a(byteArrayOutputStream, aVar.g);
                a(byteArrayOutputStream, aVar.h);
                a(byteArrayOutputStream, aVar.i);
                a(byteArrayOutputStream, aVar.j);
                a(byteArrayOutputStream, aVar.k);
                a(byteArrayOutputStream, aVar.l);
                a(byteArrayOutputStream, aVar.m);
                a(byteArrayOutputStream, aVar.n);
                a(byteArrayOutputStream, aVar.o);
                a(byteArrayOutputStream, aVar.p);
                a(byteArrayOutputStream, aVar.q);
                a(byteArrayOutputStream, aVar.r);
                a(byteArrayOutputStream, aVar.f129s);
                a(byteArrayOutputStream, aVar.t);
                a(byteArrayOutputStream, aVar.u);
                a(byteArrayOutputStream, aVar.v);
                a(byteArrayOutputStream, aVar.w);
                a(byteArrayOutputStream, aVar.x);
                a(byteArrayOutputStream, aVar.y);
                a(byteArrayOutputStream, aVar.z);
                byte[] b = b(com.amap.api.mapcore.util.fi.b(byteArrayOutputStream.toByteArray()));
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                return b;
            } catch (java.lang.Throwable th2) {
                th = th2;
                try {
                    com.amap.api.mapcore.util.ga.a(th, "CI", "gzx");
                    return null;
                } finally {
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (java.lang.Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    private static byte[] b(byte[] bArr) throws java.security.cert.CertificateException, java.security.spec.InvalidKeySpecException, java.security.NoSuchAlgorithmException, java.lang.NullPointerException, java.io.IOException, java.security.InvalidKeyException, javax.crypto.NoSuchPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException {
        java.security.PublicKey d = com.amap.api.mapcore.util.fi.d();
        if (bArr.length <= 117) {
            return com.amap.api.mapcore.util.fa.a(bArr, d);
        }
        byte[] bArr2 = new byte[117];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, 117);
        byte[] a2 = com.amap.api.mapcore.util.fa.a(bArr2, d);
        byte[] bArr3 = new byte[(bArr.length + 128) - 117];
        java.lang.System.arraycopy(a2, 0, bArr3, 0, 128);
        java.lang.System.arraycopy(bArr, 117, bArr3, 128, bArr.length - 117);
        return bArr3;
    }

    private static java.lang.String c(android.content.Context context) {
        try {
            return a(b(context, false, false));
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "CI", "gCXi");
            return null;
        }
    }
}
