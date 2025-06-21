package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class bl {

    public static class a {
        public java.lang.String a;
        public java.lang.String b;
        public java.lang.String c;
        public java.lang.String d;
        public java.lang.String e;
        public java.lang.String f;
        public java.lang.String g;
        public java.lang.String h;
        public java.lang.String i;
        public java.lang.String j;
        public java.lang.String k;
        public java.lang.String l;
        public java.lang.String m;
        public java.lang.String n;
        public java.lang.String o;
        public java.lang.String p;
        public java.lang.String q;
        public java.lang.String r;

        /* renamed from: s, reason: collision with root package name */
        public java.lang.String f108s;
        public java.lang.String t;
        public java.lang.String u;
        public java.lang.String v;
        public java.lang.String w;
        public java.lang.String x;
        public java.lang.String y;
        public java.lang.String z;

        public a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static java.lang.String a() {
        try {
            java.lang.String valueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
            java.lang.String str = com.amap.api.col.s.bi.c() ? "1" : "0";
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cg.a(th, "CI", "TS");
            return null;
        }
    }

    public static java.lang.String a(android.content.Context context) {
        return e(context);
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            return com.amap.api.col.s.bq.a(com.amap.api.col.s.bi.e(context) + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str.substring(0, str.length() - 3) + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str2);
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cg.a(th, "CI", "Sco");
            return null;
        }
    }

    public static byte[] a(android.content.Context context, boolean z) {
        try {
            return f(d(context, z));
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cg.a(th, "CI", "gz");
            return null;
        }
    }

    public static byte[] a(byte[] bArr) throws java.security.cert.CertificateException, java.security.spec.InvalidKeySpecException, java.security.NoSuchAlgorithmException, java.lang.NullPointerException, java.io.IOException, java.security.InvalidKeyException, javax.crypto.NoSuchPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException {
        return com.amap.api.col.s.bn.a(bArr);
    }

    public static java.lang.String b(com.amap.api.col.s.bl.a aVar) {
        return com.amap.api.col.s.bn.b(f(aVar));
    }

    public static void c(java.io.ByteArrayOutputStream byteArrayOutputStream, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.amap.api.col.s.bu.a(byteArrayOutputStream, (byte) 0, new byte[0]);
        } else {
            com.amap.api.col.s.bu.a(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, com.amap.api.col.s.bu.a(str));
        }
    }

    public static com.amap.api.col.s.bl.a d(android.content.Context context, boolean z) {
        com.amap.api.col.s.bl.a aVar = new com.amap.api.col.s.bl.a((byte) 0);
        aVar.a = com.amap.api.col.s.bm.r(context);
        aVar.b = com.amap.api.col.s.bm.k(context);
        java.lang.String h = com.amap.api.col.s.bm.h(context);
        if (h == null) {
            h = "";
        }
        aVar.c = h;
        aVar.d = com.amap.api.col.s.bi.c(context);
        aVar.e = android.os.Build.MODEL;
        aVar.f = android.os.Build.MANUFACTURER;
        aVar.g = android.os.Build.DEVICE;
        aVar.h = com.amap.api.col.s.bi.b(context);
        aVar.i = com.amap.api.col.s.bi.d(context);
        aVar.j = java.lang.String.valueOf(android.os.Build.VERSION.SDK_INT);
        aVar.k = com.amap.api.col.s.bm.t(context);
        aVar.l = com.amap.api.col.s.bm.R(context);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.amap.api.col.s.bm.n(context));
        aVar.m = sb.toString();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(com.amap.api.col.s.bm.m(context));
        aVar.n = sb2.toString();
        aVar.o = com.amap.api.col.s.bm.S(context);
        aVar.p = com.amap.api.col.s.bm.Q(context);
        aVar.q = "";
        aVar.r = "";
        java.lang.String[] O = com.amap.api.col.s.bm.O();
        aVar.f108s = O[0];
        aVar.t = O[1];
        aVar.w = com.amap.api.col.s.bm.a();
        java.lang.String a2 = com.amap.api.col.s.bm.a(context);
        if (android.text.TextUtils.isEmpty(a2)) {
            aVar.x = "";
        } else {
            aVar.x = a2;
        }
        aVar.y = "aid=" + com.amap.api.col.s.bm.j(context);
        if ((z && com.amap.api.col.s.cd.d) || com.amap.api.col.s.cd.e) {
            java.lang.String g = com.amap.api.col.s.bm.g(context);
            if (!android.text.TextUtils.isEmpty(g)) {
                aVar.y += "|oaid=" + g;
            }
        }
        java.lang.String a3 = com.amap.api.col.s.bm.a(context, ",");
        if (!android.text.TextUtils.isEmpty(a3)) {
            aVar.y += "|multiImeis=" + a3;
        }
        java.lang.String s2 = com.amap.api.col.s.bm.s(context);
        if (!android.text.TextUtils.isEmpty(s2)) {
            aVar.y += "|meid=" + s2;
        }
        aVar.y += "|serial=" + com.amap.api.col.s.bm.i(context);
        java.lang.String b = com.amap.api.col.s.bm.b();
        if (!android.text.TextUtils.isEmpty(b)) {
            aVar.y += "|adiuExtras=" + b;
        }
        aVar.y += "|storage=" + com.amap.api.col.s.bm.e() + "|ram=" + com.amap.api.col.s.bm.u(context) + "|arch=" + com.amap.api.col.s.bm.f();
        java.lang.String b2 = com.amap.api.col.s.cf.a().b();
        if (android.text.TextUtils.isEmpty(b2)) {
            aVar.z = "";
        } else {
            aVar.z = b2;
        }
        return aVar;
    }

    public static java.lang.String e(android.content.Context context) {
        try {
            return b(d(context, false));
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cg.a(th, "CI", "gCXi");
            return null;
        }
    }

    public static byte[] f(com.amap.api.col.s.bl.a aVar) {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            try {
                c(byteArrayOutputStream, aVar.a);
                c(byteArrayOutputStream, aVar.b);
                c(byteArrayOutputStream, aVar.c);
                c(byteArrayOutputStream, aVar.d);
                c(byteArrayOutputStream, aVar.e);
                c(byteArrayOutputStream, aVar.f);
                c(byteArrayOutputStream, aVar.g);
                c(byteArrayOutputStream, aVar.h);
                c(byteArrayOutputStream, aVar.i);
                c(byteArrayOutputStream, aVar.j);
                c(byteArrayOutputStream, aVar.k);
                c(byteArrayOutputStream, aVar.l);
                c(byteArrayOutputStream, aVar.m);
                c(byteArrayOutputStream, aVar.n);
                c(byteArrayOutputStream, aVar.o);
                c(byteArrayOutputStream, aVar.p);
                c(byteArrayOutputStream, aVar.q);
                c(byteArrayOutputStream, aVar.r);
                c(byteArrayOutputStream, aVar.f108s);
                c(byteArrayOutputStream, aVar.t);
                c(byteArrayOutputStream, aVar.u);
                c(byteArrayOutputStream, aVar.v);
                c(byteArrayOutputStream, aVar.w);
                c(byteArrayOutputStream, aVar.x);
                c(byteArrayOutputStream, aVar.y);
                c(byteArrayOutputStream, aVar.z);
                byte[] g = g(com.amap.api.col.s.bu.b(byteArrayOutputStream.toByteArray()));
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                return g;
            } catch (java.lang.Throwable th2) {
                th = th2;
                try {
                    com.amap.api.col.s.cg.a(th, "CI", "gzx");
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

    public static byte[] g(byte[] bArr) throws java.security.cert.CertificateException, java.security.spec.InvalidKeySpecException, java.security.NoSuchAlgorithmException, java.lang.NullPointerException, java.io.IOException, java.security.InvalidKeyException, javax.crypto.NoSuchPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException {
        java.security.PublicKey d = com.amap.api.col.s.bu.d();
        if (bArr.length <= 117) {
            return com.amap.api.col.s.bn.b(bArr, d);
        }
        byte[] bArr2 = new byte[117];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, 117);
        byte[] b = com.amap.api.col.s.bn.b(bArr2, d);
        byte[] bArr3 = new byte[(bArr.length + 128) - 117];
        java.lang.System.arraycopy(b, 0, bArr3, 0, 128);
        java.lang.System.arraycopy(bArr, 117, bArr3, 128, bArr.length - 117);
        return bArr3;
    }
}
