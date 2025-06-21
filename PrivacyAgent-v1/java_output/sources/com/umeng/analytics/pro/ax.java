package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class ax {
    public static void a(byte[] bArr, java.io.OutputStream outputStream) {
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        java.util.zip.GZIPOutputStream gZIPOutputStream2 = null;
        try {
            gZIPOutputStream = new java.util.zip.GZIPOutputStream(outputStream);
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            gZIPOutputStream.write(bArr);
            com.umeng.analytics.pro.as.a(gZIPOutputStream);
        } catch (java.lang.Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            try {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "gzip error: " + th.getMessage());
            } finally {
                com.umeng.analytics.pro.as.a(gZIPOutputStream2);
            }
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) ((bArr[i] ^ bArr2[i % bArr2.length]) ^ (i & 255));
            }
        }
        return bArr;
    }

    public static void b(byte[] bArr, java.io.OutputStream outputStream) {
        java.util.zip.GZIPInputStream gZIPInputStream;
        java.util.zip.GZIPInputStream gZIPInputStream2 = null;
        try {
            gZIPInputStream = new java.util.zip.GZIPInputStream(new java.io.ByteArrayInputStream(bArr));
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read == -1) {
                    com.umeng.analytics.pro.as.a(gZIPInputStream);
                    return;
                }
                outputStream.write(bArr2, 0, read);
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            gZIPInputStream2 = gZIPInputStream;
            try {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "unGzip error: " + th.getMessage());
            } finally {
                com.umeng.analytics.pro.as.a(gZIPInputStream2);
            }
        }
    }
}
