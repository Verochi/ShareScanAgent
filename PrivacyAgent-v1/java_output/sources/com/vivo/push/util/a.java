package com.vivo.push.util;

/* loaded from: classes19.dex */
public class a {
    private static volatile com.vivo.push.util.a c;
    private byte[] a;
    private byte[] b;

    private a(android.content.Context context) {
        com.vivo.push.util.w.b().a(com.vivo.push.util.ContextDelegate.getContext(context));
        com.vivo.push.util.w b = com.vivo.push.util.w.b();
        this.a = b.c();
        this.b = b.d();
    }

    public static com.vivo.push.util.a a(android.content.Context context) {
        if (c == null) {
            synchronized (com.vivo.push.util.a.class) {
                if (c == null) {
                    c = new com.vivo.push.util.a(context.getApplicationContext());
                }
            }
        }
        return c;
    }

    private byte[] a() {
        byte[] bArr = this.a;
        return (bArr == null || bArr.length <= 0) ? com.vivo.push.util.w.b().c() : bArr;
    }

    private byte[] b() {
        byte[] bArr = this.b;
        return (bArr == null || bArr.length <= 0) ? com.vivo.push.util.w.b().d() : bArr;
    }

    public final java.lang.String a(java.lang.String str) {
        java.lang.String a = com.vivo.push.util.f.a(a());
        java.lang.String a2 = com.vivo.push.util.f.a(b());
        byte[] bytes = str.getBytes("utf-8");
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(a2.getBytes("utf-8"), "AES");
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new javax.crypto.spec.IvParameterSpec(a.getBytes("utf-8")));
        return android.util.Base64.encodeToString(cipher.doFinal(bytes), 2);
    }

    public final java.lang.String b(java.lang.String str) {
        return new java.lang.String(com.vivo.push.util.f.a(com.vivo.push.util.f.a(a()), com.vivo.push.util.f.a(b()), android.util.Base64.decode(str, 2)), "utf-8");
    }
}
