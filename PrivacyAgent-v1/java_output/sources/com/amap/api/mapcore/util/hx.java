package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class hx extends com.amap.api.mapcore.util.hz {
    public static int a = 13;
    public static int b = 6;
    private android.content.Context e;

    public hx(android.content.Context context, com.amap.api.mapcore.util.hz hzVar) {
        super(hzVar);
        this.e = context;
    }

    private static byte[] a(android.content.Context context) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            try {
                com.amap.api.mapcore.util.fi.a(byteArrayOutputStream, "1.2." + a + "." + b);
                com.amap.api.mapcore.util.fi.a(byteArrayOutputStream, "Android");
                com.amap.api.mapcore.util.fi.a(byteArrayOutputStream, com.amap.api.mapcore.util.ez.s(context));
                com.amap.api.mapcore.util.fi.a(byteArrayOutputStream, com.amap.api.mapcore.util.ez.k(context));
                com.amap.api.mapcore.util.fi.a(byteArrayOutputStream, com.amap.api.mapcore.util.ez.h(context));
                com.amap.api.mapcore.util.fi.a(byteArrayOutputStream, android.os.Build.MANUFACTURER);
                com.amap.api.mapcore.util.fi.a(byteArrayOutputStream, android.os.Build.MODEL);
                com.amap.api.mapcore.util.fi.a(byteArrayOutputStream, android.os.Build.DEVICE);
                com.amap.api.mapcore.util.fi.a(byteArrayOutputStream, com.amap.api.mapcore.util.ez.v(context));
                com.amap.api.mapcore.util.fi.a(byteArrayOutputStream, com.amap.api.mapcore.util.ev.c(context));
                com.amap.api.mapcore.util.fi.a(byteArrayOutputStream, com.amap.api.mapcore.util.ev.d(context));
                com.amap.api.mapcore.util.fi.a(byteArrayOutputStream, com.amap.api.mapcore.util.ev.f(context));
                byteArrayOutputStream.write(new byte[]{0});
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        } catch (java.lang.Throwable th2) {
            try {
                com.amap.api.mapcore.util.gd.c(th2, "sm", "gh");
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

    @Override // com.amap.api.mapcore.util.hz
    public final byte[] a(byte[] bArr) {
        byte[] a2 = a(this.e);
        byte[] bArr2 = new byte[a2.length + bArr.length];
        java.lang.System.arraycopy(a2, 0, bArr2, 0, a2.length);
        java.lang.System.arraycopy(bArr, 0, bArr2, a2.length, bArr.length);
        return bArr2;
    }
}
