package com.igexin.push.h;

/* loaded from: classes23.dex */
public class g {
    public static java.lang.String a = "MHwwDQYJKoZIhvcNAQEBBQADawAwaAJhAJp1rROuvBF7sBSnvLaesj2iFhMcY8aXyLvpnNLKs2wjL3JmEnyr++SlVa35liUlzi83tnAFkn3A9GB7pHBNzawyUkBh8WUhq5bnFIkk2RaDa6+5MpG84DEv52p7RR+aWwIDAQAB";
    public static java.lang.String b = "69d747c4b9f641baf4004be4297e9f3b";
    public static java.lang.String c = "";
    public static java.lang.String d = "";
    private static final java.lang.String e = "com.igexin.push.h.g";
    private static boolean f = false;
    private static int g = 0;
    private static byte[] h = null;
    private static byte[] i = null;
    private static final int j = 200;

    static {
        try {
            h = h();
            byte[] g2 = g();
            i = g2;
            f = (h == null || g2 == null || b.getBytes() == null) ? false : true;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(e + "|load key error = " + th.toString(), new java.lang.Object[0]);
            f = false;
            d = th.getMessage();
        }
        if (f) {
            java.lang.String str = e;
            com.igexin.c.a.c.a.a(str, "load Encrypt key success ~~~~~~~");
            com.igexin.c.a.c.a.a(str + "|load  Encrypt key success ~~~~~~~", new java.lang.Object[0]);
            return;
        }
        java.lang.String str2 = e;
        com.igexin.c.a.c.a.a(str2, "load key error ++++++++");
        com.igexin.c.a.c.a.a(str2 + "|load key error ++++++++", new java.lang.Object[0]);
        if (android.text.TextUtils.isEmpty(d)) {
            d = "value = null, normal error";
        }
    }

    public static java.lang.String a(java.lang.String str, byte[] bArr) throws java.lang.Exception {
        byte[] bytes = str.getBytes();
        byte[] bArr2 = new byte[bytes.length + bArr.length];
        int a2 = com.igexin.c.a.b.g.a(bytes, bArr2, 0, bytes.length);
        if (bArr.length > 0) {
            com.igexin.c.a.b.g.a(bArr, bArr2, a2, bArr.length);
        }
        return android.util.Base64.encodeToString(d(bArr2), 2);
    }

    public static boolean a() {
        return f;
    }

    public static byte[] a(com.igexin.push.d.c.a aVar, int i2, int i3) {
        byte[] bArr = new byte[aVar.a + 11];
        com.igexin.c.a.b.g.a(i2, bArr, 0);
        com.igexin.c.a.b.g.a(i3, bArr, 4);
        com.igexin.c.a.b.g.b((short) aVar.a, bArr, 8);
        bArr[10] = aVar.b;
        com.igexin.c.a.b.g.a(aVar.e, bArr, 11, aVar.a);
        return d(bArr);
    }

    public static byte[] a(byte[] bArr) {
        return com.igexin.c.a.a.a.b(bArr, com.igexin.push.core.e.M);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            return com.getui.gtc.base.crypt.CryptTools.encrypt("AES/CFB/NoPadding", new javax.crypto.spec.SecretKeySpec(i, "AES"), new javax.crypto.spec.IvParameterSpec(bArr2), bArr);
        } catch (java.lang.Throwable unused) {
            java.lang.String str = e;
            com.igexin.c.a.c.a.a(str, " httpId encrypt  http data  fail ~~~~~~~");
            com.igexin.c.a.c.a.a(str + "| httpId encrypt  http data  fail ~~~~~~~", new java.lang.Object[0]);
            return new byte[0];
        }
    }

    public static byte[] b() {
        if (!f) {
            return new byte[0];
        }
        try {
            byte[] bArr = h;
            byte[] bArr2 = new byte[bArr.length];
            java.lang.System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return com.getui.gtc.base.crypt.CryptTools.encrypt("RSA/NONE/OAEPWithSHA1AndMGF1Padding", com.getui.gtc.base.crypt.CryptTools.parsePublicKey(com.alipay.sdk.m.n.d.a, a), bArr2);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(e + "| getSocketAESKey  fail ~~~~~~~" + th.getMessage(), new java.lang.Object[0]);
            return new byte[0];
        }
    }

    public static byte[] b(byte[] bArr) {
        return c(bArr);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            return com.getui.gtc.base.crypt.CryptTools.decrypt("AES/CFB/NoPadding", new javax.crypto.spec.SecretKeySpec(i, "AES"), new javax.crypto.spec.IvParameterSpec(bArr2), bArr);
        } catch (java.lang.Throwable unused) {
            java.lang.String str = e;
            com.igexin.c.a.c.a.a(str, " httpId decrypt  http data  fail ~~~~~~~");
            com.igexin.c.a.c.a.a(str + "| httpId decrypt  http data  fail ~~~~~~~", new java.lang.Object[0]);
            return new byte[0];
        }
    }

    public static byte[] c() {
        return b.getBytes();
    }

    public static byte[] c(byte[] bArr) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return null;
        }
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        try {
            return com.getui.gtc.base.crypt.CryptTools.encrypt("AES/CFB/NoPadding", new javax.crypto.spec.SecretKeySpec(h, "AES"), new javax.crypto.spec.IvParameterSpec(bArr2), bArr);
        } catch (java.lang.Throwable unused) {
            java.lang.String str = e;
            com.igexin.c.a.c.a.a(str, " sockeId encrypt  http data  fail ~~~~~~~");
            com.igexin.c.a.c.a.a(str + "| sockeId encrypt  http data  fail ~~~~~~~", new java.lang.Object[0]);
            return new byte[0];
        }
    }

    public static boolean d() {
        try {
            h = h();
            byte[] g2 = g();
            i = g2;
            f = (h == null || g2 == null || b.getBytes() == null) ? false : true;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(e + "|load key error = " + th.toString(), new java.lang.Object[0]);
            f = false;
        }
        if (f) {
            java.lang.String str = e;
            com.igexin.c.a.c.a.a(str, "load key success ~~~~~~~");
            com.igexin.c.a.c.a.a(str + "|load key success ~~~~~~~", new java.lang.Object[0]);
        } else {
            java.lang.String str2 = e;
            com.igexin.c.a.c.a.a(str2, "load key error ++++++++");
            com.igexin.c.a.c.a.a(str2 + "|load key error ++++++++", new java.lang.Object[0]);
        }
        return f;
    }

    private static byte[] d(byte[] bArr) {
        try {
            return java.security.MessageDigest.getInstance("SHA-1").digest(bArr);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return null;
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        try {
            return com.getui.gtc.base.crypt.CryptTools.decrypt("AES/CFB/NoPadding", new javax.crypto.spec.SecretKeySpec(h, "AES"), new javax.crypto.spec.IvParameterSpec(bArr2), bArr);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(e + "| sockeId encrypt  http data  fail ~~~~~~~", new java.lang.Object[0]);
            return new byte[0];
        }
    }

    public static int e() {
        int i2 = g;
        g = i2 + 1;
        return i2;
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        try {
            byte[] bytes = c.getBytes();
            byte[] bArr3 = new byte[bytes.length];
            for (int i2 = 0; i2 < bytes.length; i2++) {
                bArr3[i2] = (byte) (~(bytes[(bytes.length - i2) - 1] & 255));
            }
            return com.getui.gtc.base.crypt.CryptTools.decrypt("AES/CFB/NoPadding", new javax.crypto.spec.SecretKeySpec(c(bArr3), "AES"), new javax.crypto.spec.IvParameterSpec(c(bArr2)), bArr);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(e + "| altAesDecSocket  fail ~~~~~~~", new java.lang.Object[0]);
            return new byte[0];
        }
    }

    public static java.lang.String f() {
        byte[] j2 = j();
        byte[] bytes = com.igexin.push.h.p.b().getBytes();
        byte[] bArr = new byte[bytes.length + j2.length];
        com.igexin.c.a.b.g.a(j2, bArr, com.igexin.c.a.b.g.a(bytes, bArr, 0, bytes.length), j2.length);
        return android.util.Base64.encodeToString(bArr, 2);
    }

    private static byte[] f(byte[] bArr, byte[] bArr2) {
        try {
            byte[] bytes = c.getBytes();
            byte[] bArr3 = new byte[bytes.length];
            for (int i2 = 0; i2 < bytes.length; i2++) {
                bArr3[i2] = (byte) (~(bytes[(bytes.length - i2) - 1] & 255));
            }
            return com.getui.gtc.base.crypt.CryptTools.encrypt("AES/CFB/NoPadding", new javax.crypto.spec.SecretKeySpec(c(bArr3), "AES"), new javax.crypto.spec.IvParameterSpec(c(bArr2)), bArr);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(e + "| altAesEncSocket  fail ~~~~~~~", new java.lang.Object[0]);
            return new byte[0];
        }
    }

    private static byte[] g() {
        try {
            return com.getui.gtc.base.crypt.CryptTools.generateKey("AES", 128).getEncoded();
        } catch (java.lang.Throwable unused) {
            java.lang.String str = e;
            com.igexin.c.a.c.a.a(str, "generate  http key fail ~~~~~~~");
            com.igexin.c.a.c.a.a(str + "|generate  http key fail ~~~~~~~", new java.lang.Object[0]);
            return null;
        }
    }

    private static byte[] h() {
        try {
            return com.getui.gtc.base.crypt.CryptTools.generateKey("AES", 128).getEncoded();
        } catch (java.lang.Throwable unused) {
            java.lang.String str = e;
            com.igexin.c.a.c.a.a(str, "generate  socket key fail ~~~~~~~");
            com.igexin.c.a.c.a.a(str + "|generate  socket key fail ~~~~~~~", new java.lang.Object[0]);
            return null;
        }
    }

    private static byte[] i() {
        return new byte[0];
    }

    private static byte[] j() {
        try {
            byte[] bArr = i;
            byte[] bArr2 = new byte[bArr.length];
            java.lang.System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return com.getui.gtc.base.crypt.CryptTools.encrypt("RSA/NONE/OAEPWithSHA1AndMGF1Padding", com.getui.gtc.base.crypt.CryptTools.parsePublicKey(com.alipay.sdk.m.n.d.a, a), bArr2);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(e + "| getHttpAESKey  fail ~~~~~~~", new java.lang.Object[0]);
            return new byte[0];
        }
    }
}
