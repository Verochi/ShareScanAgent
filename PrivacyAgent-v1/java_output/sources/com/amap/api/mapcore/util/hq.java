package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class hq {
    private android.content.Context a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;

    public hq(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) throws com.amap.api.mapcore.util.eu {
        if (android.text.TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new com.amap.api.mapcore.util.eu("无效的参数 - IllegalArgumentException");
        }
        this.a = context.getApplicationContext();
        this.c = str;
        this.d = str2;
        this.b = str3;
    }

    private static byte[] a(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    private byte[] b(java.lang.String str) {
        byte[] a;
        if (!android.text.TextUtils.isEmpty(str) && (a = com.amap.api.mapcore.util.fi.a(this.e)) != null) {
            return com.amap.api.mapcore.util.fi.a(a.length);
        }
        return new byte[]{0, 0};
    }

    public final void a(java.lang.String str) throws com.amap.api.mapcore.util.eu {
        if (android.text.TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new com.amap.api.mapcore.util.eu("无效的参数 - IllegalArgumentException");
        }
        this.e = str;
    }

    public final byte[] a() {
        int i = 0;
        byte[] bArr = new byte[0];
        java.io.ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                try {
                    com.amap.api.mapcore.util.fi.a(byteArrayOutputStream2, this.c);
                    com.amap.api.mapcore.util.fi.a(byteArrayOutputStream2, this.d);
                    com.amap.api.mapcore.util.fi.a(byteArrayOutputStream2, this.b);
                    com.amap.api.mapcore.util.fi.a(byteArrayOutputStream2, java.lang.String.valueOf(com.amap.api.mapcore.util.ez.n(this.a)));
                    try {
                        i = (int) (java.lang.System.currentTimeMillis() / 1000);
                    } catch (java.lang.Throwable unused) {
                    }
                    byteArrayOutputStream2.write(a(i));
                    byteArrayOutputStream2.write(b(this.e));
                    byteArrayOutputStream2.write(com.amap.api.mapcore.util.fi.a(this.e));
                    bArr = byteArrayOutputStream2.toByteArray();
                    byteArrayOutputStream2.close();
                } catch (java.lang.Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        com.amap.api.mapcore.util.gd.c(th, "se", "tds");
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return bArr;
                    } catch (java.lang.Throwable th2) {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (java.lang.Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
            }
        } catch (java.lang.Throwable th5) {
            th5.printStackTrace();
        }
        return bArr;
    }
}
