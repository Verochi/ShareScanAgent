package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class eo {
    public static final byte[] a = {80, 85, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 72};
    private short b;
    private byte c;
    private int d;
    private byte[] e;

    public static class a {
        public static final com.xiaomi.push.eo.c a = new com.xiaomi.push.eo.c();
        public static final com.xiaomi.push.eo.d b = new com.xiaomi.push.eo.d();

        public static byte[] a(byte[] bArr) {
            com.xiaomi.push.eo.d dVar = b;
            if (!com.xiaomi.push.eo.b(bArr)) {
                return bArr;
            }
            com.xiaomi.push.eo a2 = com.xiaomi.push.eo.a(bArr);
            return (a2.c == 0 || a2.c != 2) ? a2.e : dVar.a(a2.e, a2.d);
        }
    }

    public interface b {
        byte[] a(byte[] bArr, int i);
    }

    public static final class c {
    }

    public static final class d implements com.xiaomi.push.eo.b {
        @Override // com.xiaomi.push.eo.b
        public final byte[] a(byte[] bArr, int i) {
            java.util.zip.GZIPInputStream gZIPInputStream = null;
            try {
                java.util.zip.GZIPInputStream gZIPInputStream2 = new java.util.zip.GZIPInputStream(new java.io.ByteArrayInputStream(bArr), i);
                try {
                    byte[] bArr2 = new byte[i];
                    gZIPInputStream2.read(bArr2);
                    try {
                        gZIPInputStream2.close();
                    } catch (java.io.IOException unused) {
                    }
                    return bArr2;
                } catch (java.io.IOException unused2) {
                    gZIPInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (java.io.IOException unused3) {
                        }
                    }
                    return bArr;
                } catch (java.lang.Throwable th) {
                    th = th;
                    gZIPInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (java.io.IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (java.io.IOException unused5) {
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
    }

    private eo(int i, byte[] bArr) {
        this((short) 1, (byte) 0, i, bArr);
    }

    private eo(short s2, byte b2, int i, byte[] bArr) {
        this.b = s2;
        this.c = b2;
        this.d = i;
        this.e = bArr;
    }

    public static com.xiaomi.push.eo a(byte[] bArr) {
        if (!b(bArr)) {
            return new com.xiaomi.push.eo(bArr.length, bArr);
        }
        java.nio.ByteBuffer order = java.nio.ByteBuffer.wrap(bArr).order(java.nio.ByteOrder.BIG_ENDIAN);
        order.getInt();
        short s2 = order.getShort();
        byte b2 = order.get();
        int i = order.getInt();
        byte[] bArr2 = new byte[order.getInt()];
        order.get(bArr2);
        return new com.xiaomi.push.eo(s2, b2, i, bArr2);
    }

    private static boolean a(byte[] bArr, byte[] bArr2, int i) {
        if (bArr.length < i || bArr2.length < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(byte[] bArr) {
        byte[] bArr2 = a;
        return a(bArr2, bArr, bArr2.length);
    }
}
