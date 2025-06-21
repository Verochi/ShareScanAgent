package com.efs.sdk.base.core.util;

/* loaded from: classes22.dex */
public final class b {
    public static byte[] a(byte[] bArr) {
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            java.util.zip.GZIPOutputStream gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (java.lang.Exception e) {
            com.efs.sdk.base.core.util.Log.e("efs.base", "gzip error", e);
            return null;
        }
    }
}
