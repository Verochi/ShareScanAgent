package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class dq extends com.amap.api.col.s.ds {
    public static int a = 13;
    public static int b = 6;
    public android.content.Context e;

    public dq(android.content.Context context, com.amap.api.col.s.ds dsVar) {
        super(dsVar);
        this.e = context;
    }

    public static byte[] c(android.content.Context context) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            try {
                com.amap.api.col.s.bu.a(byteArrayOutputStream, "1.2." + a + "." + b);
                com.amap.api.col.s.bu.a(byteArrayOutputStream, "Android");
                com.amap.api.col.s.bu.a(byteArrayOutputStream, com.amap.api.col.s.bm.r(context));
                com.amap.api.col.s.bu.a(byteArrayOutputStream, com.amap.api.col.s.bm.k(context));
                com.amap.api.col.s.bu.a(byteArrayOutputStream, com.amap.api.col.s.bm.h(context));
                com.amap.api.col.s.bu.a(byteArrayOutputStream, android.os.Build.MANUFACTURER);
                com.amap.api.col.s.bu.a(byteArrayOutputStream, android.os.Build.MODEL);
                com.amap.api.col.s.bu.a(byteArrayOutputStream, android.os.Build.DEVICE);
                com.amap.api.col.s.bu.a(byteArrayOutputStream, com.amap.api.col.s.bm.t(context));
                com.amap.api.col.s.bu.a(byteArrayOutputStream, com.amap.api.col.s.bi.c(context));
                com.amap.api.col.s.bu.a(byteArrayOutputStream, com.amap.api.col.s.bi.d(context));
                com.amap.api.col.s.bu.a(byteArrayOutputStream, com.amap.api.col.s.bi.f(context));
                byteArrayOutputStream.write(new byte[]{0});
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        } catch (java.lang.Throwable th2) {
            try {
                com.amap.api.col.s.cj.c(th2, "sm", "gh");
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

    @Override // com.amap.api.col.s.ds
    public final byte[] a(byte[] bArr) {
        byte[] c = c(this.e);
        byte[] bArr2 = new byte[c.length + bArr.length];
        java.lang.System.arraycopy(c, 0, bArr2, 0, c.length);
        java.lang.System.arraycopy(bArr, 0, bArr2, c.length, bArr.length);
        return bArr2;
    }
}
