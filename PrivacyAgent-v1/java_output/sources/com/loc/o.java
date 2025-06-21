package com.loc;

/* loaded from: classes23.dex */
public final class o {

    public static class a {
        java.lang.String A;
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
        java.lang.String f416s;
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
            java.lang.String str = com.loc.m.a() ? "1" : "0";
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (java.lang.Throwable th) {
            com.loc.at.a(th, "CI", "TS");
            return null;
        }
    }

    public static java.lang.String a(android.content.Context context) {
        return b(context);
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            return com.loc.t.a(com.loc.m.e(context) + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str.substring(0, str.length() - 3) + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str2);
        } catch (java.lang.Throwable th) {
            com.loc.at.a(th, "CI", "Sco");
            return null;
        }
    }

    private static java.lang.String a(com.loc.o.a aVar) {
        return com.loc.q.b(b(aVar));
    }

    private static void a(java.io.ByteArrayOutputStream byteArrayOutputStream, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.loc.y.a(byteArrayOutputStream, (byte) 0, new byte[0]);
        } else {
            com.loc.y.a(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, com.loc.y.a(str));
        }
    }

    public static byte[] a(android.content.Context context, boolean z, boolean z2) {
        try {
            return b(b(context, z, z2));
        } catch (java.lang.Throwable th) {
            com.loc.at.a(th, "CI", "gz");
            return null;
        }
    }

    public static byte[] a(byte[] bArr) throws java.security.cert.CertificateException, java.security.spec.InvalidKeySpecException, java.security.NoSuchAlgorithmException, java.lang.NullPointerException, java.io.IOException, java.security.InvalidKeyException, javax.crypto.NoSuchPaddingException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException {
        return com.loc.q.a(bArr);
    }

    private static com.loc.o.a b(android.content.Context context, boolean z, boolean z2) {
        com.loc.o.a aVar = new com.loc.o.a((byte) 0);
        aVar.a = com.loc.p.k();
        aVar.b = com.loc.p.h();
        java.lang.String f = com.loc.p.f(context);
        if (f == null) {
            f = "";
        }
        aVar.c = f;
        aVar.d = com.loc.m.c(context);
        aVar.e = android.os.Build.MODEL;
        aVar.f = android.os.Build.MANUFACTURER;
        aVar.g = android.os.Build.DEVICE;
        aVar.h = com.loc.m.b(context);
        aVar.i = com.loc.m.d(context);
        aVar.j = java.lang.String.valueOf(android.os.Build.VERSION.SDK_INT);
        aVar.k = com.loc.p.n();
        aVar.l = com.loc.p.m(context);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.loc.p.j(context));
        aVar.m = sb.toString();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(com.loc.p.i(context));
        aVar.n = sb2.toString();
        aVar.o = com.loc.p.s(context);
        aVar.p = com.loc.p.h(context);
        aVar.q = "";
        aVar.r = "";
        if (z) {
            aVar.f416s = "";
            aVar.t = "";
        } else {
            java.lang.String[] i = com.loc.p.i();
            aVar.f416s = i[0];
            aVar.t = i[1];
        }
        aVar.w = com.loc.p.a();
        java.lang.String a2 = com.loc.p.a(context);
        if (android.text.TextUtils.isEmpty(a2)) {
            aVar.x = "";
        } else {
            aVar.x = a2;
        }
        aVar.y = "aid=" + com.loc.p.g();
        if ((z2 && com.loc.ah.d) || com.loc.ah.e) {
            java.lang.String e = com.loc.p.e(context);
            if (!android.text.TextUtils.isEmpty(e)) {
                aVar.y += "|oaid=" + e;
            }
        }
        java.lang.String j = com.loc.p.j();
        if (!android.text.TextUtils.isEmpty(j)) {
            aVar.y += "|multiImeis=" + j;
        }
        java.lang.String m = com.loc.p.m();
        if (!android.text.TextUtils.isEmpty(m)) {
            aVar.y += "|meid=" + m;
        }
        aVar.y += "|serial=" + com.loc.p.f();
        java.lang.String b = com.loc.p.b();
        if (!android.text.TextUtils.isEmpty(b)) {
            aVar.y += "|adiuExtras=" + b;
        }
        aVar.y += "|storage=" + com.loc.p.o() + "|ram=" + com.loc.p.r(context) + "|arch=" + com.loc.p.p();
        java.lang.String b2 = com.loc.as.a().b();
        if (android.text.TextUtils.isEmpty(b2)) {
            aVar.z = "";
        } else {
            aVar.z = b2;
        }
        if (z) {
            java.lang.String a3 = com.loc.ad.a(context).a();
            if (!android.text.TextUtils.isEmpty(a3)) {
                aVar.A = a3;
            }
        }
        return aVar;
    }

    private static java.lang.String b(android.content.Context context) {
        try {
            return a(b(context, false, false));
        } catch (java.lang.Throwable th) {
            com.loc.at.a(th, "CI", "gCXi");
            return null;
        }
    }

    private static byte[] b(com.loc.o.a aVar) {
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
                a(byteArrayOutputStream, aVar.f416s);
                a(byteArrayOutputStream, aVar.t);
                a(byteArrayOutputStream, aVar.u);
                a(byteArrayOutputStream, aVar.v);
                a(byteArrayOutputStream, aVar.w);
                a(byteArrayOutputStream, aVar.x);
                a(byteArrayOutputStream, aVar.y);
                a(byteArrayOutputStream, aVar.z);
                a(byteArrayOutputStream, aVar.A);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                new java.lang.String(byteArray);
                byte[] b = b(com.loc.y.b(byteArray));
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                return b;
            } catch (java.lang.Throwable th2) {
                th = th2;
                try {
                    com.loc.at.a(th, "CI", "gzx");
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
        java.security.PublicKey d = com.loc.y.d();
        if (bArr.length <= 117) {
            return com.loc.q.a(bArr, d);
        }
        byte[] bArr2 = new byte[117];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, 117);
        byte[] a2 = com.loc.q.a(bArr2, d);
        byte[] bArr3 = new byte[(bArr.length + 128) - 117];
        java.lang.System.arraycopy(a2, 0, bArr3, 0, 128);
        java.lang.System.arraycopy(bArr, 117, bArr3, 128, bArr.length - 117);
        return bArr3;
    }
}
