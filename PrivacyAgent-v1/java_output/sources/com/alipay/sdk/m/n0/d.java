package com.alipay.sdk.m.n0;

/* loaded from: classes.dex */
public class d {
    public static com.alipay.sdk.m.n0.d j;
    public android.content.Context a;
    public com.alipay.sdk.m.n0.e c;
    public java.lang.String d;
    public java.lang.String e;
    public com.alipay.sdk.m.m0.a f;
    public com.alipay.sdk.m.m0.a g;
    public static final java.lang.Object i = new java.lang.Object();
    public static final java.lang.String k = ".UTSystemConfig" + java.io.File.separator + "Global";
    public java.lang.String b = null;
    public java.util.regex.Pattern h = java.util.regex.Pattern.compile("[^0-9a-zA-Z=/+]+");

    public d(android.content.Context context) {
        this.a = null;
        this.c = null;
        this.d = "xx_utdid_key";
        this.e = "xx_utdid_domain";
        this.f = null;
        this.g = null;
        this.a = context;
        this.g = new com.alipay.sdk.m.m0.a(context, k, "Alvin2", false, true);
        this.f = new com.alipay.sdk.m.m0.a(context, ".DataStorage", "ContextData", false, true);
        this.c = new com.alipay.sdk.m.n0.e();
        this.d = java.lang.String.format("K_%d", java.lang.Integer.valueOf(com.alipay.sdk.m.l0.f.a(this.d)));
        this.e = java.lang.String.format("D_%d", java.lang.Integer.valueOf(com.alipay.sdk.m.l0.f.a(this.e)));
    }

    public static com.alipay.sdk.m.n0.d a(android.content.Context context) {
        if (context != null && j == null) {
            synchronized (i) {
                if (j == null) {
                    com.alipay.sdk.m.n0.d dVar = new com.alipay.sdk.m.n0.d(context);
                    j = dVar;
                    dVar.d();
                }
            }
        }
        return j;
    }

    public static java.lang.String a(byte[] bArr) throws java.lang.Exception {
        byte[] bArr2 = {69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, com.google.common.primitives.SignedBytes.MAX_POWER_OF_TWO, com.google.common.base.Ascii.ETB, -95, -126, -82, -64, 113, 116, -16, -103, org.apache.tools.tar.TarConstants.LF_LINK, -30, 9, -39, 33, -80, -68, -78, -117, org.apache.tools.tar.TarConstants.LF_DIR, com.google.common.base.Ascii.RS, -122, com.google.common.primitives.SignedBytes.MAX_POWER_OF_TWO, -104, 74, -49, 106, 85, -38, -93};
        javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA1");
        mac.init(new javax.crypto.spec.SecretKeySpec(com.alipay.sdk.m.l0.e.a(bArr2), mac.getAlgorithm()));
        return com.alipay.sdk.m.l0.b.c(mac.doFinal(bArr), 2);
    }

    private boolean a(java.lang.String str) {
        if (str != null) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !this.h.matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    private void b(java.lang.String str) {
        com.alipay.sdk.m.m0.a aVar;
        if (a(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() != 24 || (aVar = this.g) == null) {
                return;
            }
            aVar.a("UTDID2", str);
            this.g.a();
        }
    }

    private void c(java.lang.String str) {
        com.alipay.sdk.m.m0.a aVar;
        if (str == null || (aVar = this.f) == null || str.equals(aVar.a(this.d))) {
            return;
        }
        this.f.a(this.d, str);
        this.f.a();
    }

    private void d() {
        boolean z;
        com.alipay.sdk.m.m0.a aVar = this.g;
        if (aVar != null) {
            if (com.alipay.sdk.m.l0.f.m12a(aVar.a("UTDID2"))) {
                java.lang.String a = this.g.a("UTDID");
                if (!com.alipay.sdk.m.l0.f.m12a(a)) {
                    b(a);
                }
            }
            boolean z2 = true;
            if (com.alipay.sdk.m.l0.f.m12a(this.g.a("DID"))) {
                z = false;
            } else {
                this.g.b("DID");
                z = true;
            }
            if (!com.alipay.sdk.m.l0.f.m12a(this.g.a("EI"))) {
                this.g.b("EI");
                z = true;
            }
            if (com.alipay.sdk.m.l0.f.m12a(this.g.a("SI"))) {
                z2 = z;
            } else {
                this.g.b("SI");
            }
            if (z2) {
                this.g.a();
            }
        }
    }

    private byte[] e() throws java.lang.Exception {
        java.lang.String str;
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        int currentTimeMillis = (int) (java.lang.System.currentTimeMillis() / 1000);
        int nextInt = new java.util.Random().nextInt();
        byte[] a = com.alipay.sdk.m.l0.c.a(currentTimeMillis);
        byte[] a2 = com.alipay.sdk.m.l0.c.a(nextInt);
        byteArrayOutputStream.write(a, 0, 4);
        byteArrayOutputStream.write(a2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = com.alipay.sdk.m.l0.d.a(this.a);
        } catch (java.lang.Exception unused) {
            str = "" + new java.util.Random().nextInt();
        }
        byteArrayOutputStream.write(com.alipay.sdk.m.l0.c.a(com.alipay.sdk.m.l0.f.a(str)), 0, 4);
        byteArrayOutputStream.write(com.alipay.sdk.m.l0.c.a(com.alipay.sdk.m.l0.f.a(a(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    private java.lang.String f() {
        com.alipay.sdk.m.m0.a aVar = this.g;
        if (aVar == null) {
            return null;
        }
        java.lang.String a = aVar.a("UTDID2");
        if (com.alipay.sdk.m.l0.f.m12a(a) || this.c.a(a) == null) {
            return null;
        }
        return a;
    }

    public synchronized java.lang.String a() {
        java.lang.String c = c();
        this.b = c;
        if (!android.text.TextUtils.isEmpty(c)) {
            return this.b;
        }
        try {
            byte[] e = e();
            if (e != null) {
                java.lang.String c2 = com.alipay.sdk.m.l0.b.c(e, 2);
                this.b = c2;
                b(c2);
                java.lang.String a = this.c.a(e);
                if (a != null) {
                    c(a);
                }
                return this.b;
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public synchronized java.lang.String b() {
        java.lang.String str = this.b;
        if (str != null) {
            return str;
        }
        return a();
    }

    public synchronized java.lang.String c() {
        java.lang.String f = f();
        if (a(f)) {
            c(this.c.a(f));
            this.b = f;
            return f;
        }
        java.lang.String a = this.f.a(this.d);
        if (!com.alipay.sdk.m.l0.f.m12a(a)) {
            java.lang.String a2 = new com.alipay.sdk.m.n0.f().a(a);
            if (!a(a2)) {
                a2 = this.c.b(a);
            }
            if (a(a2) && !com.alipay.sdk.m.l0.f.m12a(a2)) {
                this.b = a2;
                b(a2);
                return this.b;
            }
        }
        return null;
    }
}
