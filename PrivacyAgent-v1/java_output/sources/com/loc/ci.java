package com.loc;

/* loaded from: classes23.dex */
public final class ci extends com.loc.ck {
    public static int a = 13;
    public static int b = 6;
    private android.content.Context e;

    public ci(android.content.Context context, com.loc.ck ckVar) {
        super(ckVar);
        this.e = context;
    }

    private static byte[] a(android.content.Context context) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            try {
                com.loc.y.a(byteArrayOutputStream, "1.2." + a + "." + b);
                com.loc.y.a(byteArrayOutputStream, "Android");
                com.loc.y.a(byteArrayOutputStream, com.loc.p.k());
                com.loc.y.a(byteArrayOutputStream, com.loc.p.h());
                com.loc.y.a(byteArrayOutputStream, com.loc.p.f(context));
                com.loc.y.a(byteArrayOutputStream, android.os.Build.MANUFACTURER);
                com.loc.y.a(byteArrayOutputStream, android.os.Build.MODEL);
                com.loc.y.a(byteArrayOutputStream, android.os.Build.DEVICE);
                com.loc.y.a(byteArrayOutputStream, com.loc.p.n());
                com.loc.y.a(byteArrayOutputStream, com.loc.m.c(context));
                com.loc.y.a(byteArrayOutputStream, com.loc.m.d(context));
                com.loc.y.a(byteArrayOutputStream, com.loc.m.f(context));
                byteArrayOutputStream.write(new byte[]{0});
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        } catch (java.lang.Throwable th2) {
            try {
                com.loc.aw.b(th2, "sm", "gh");
                byteArrayOutputStream.close();
            } catch (java.lang.Throwable th3) {
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th4) {
                    th4.printStackTrace();
                }
                throw th3;
            }
        }
        return bArr;
    }

    @Override // com.loc.ck
    public final byte[] a(byte[] bArr) {
        byte[] a2 = a(this.e);
        byte[] bArr2 = new byte[a2.length + bArr.length];
        java.lang.System.arraycopy(a2, 0, bArr2, 0, a2.length);
        java.lang.System.arraycopy(bArr, 0, bArr2, a2.length, bArr.length);
        return bArr2;
    }
}
