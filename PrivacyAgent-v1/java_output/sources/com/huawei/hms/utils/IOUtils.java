package com.huawei.hms.utils;

/* loaded from: classes22.dex */
public final class IOUtils {
    public static void closeQuietly(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
                com.huawei.hms.support.log.HMSLog.e(com.baidu.mobads.sdk.internal.br.a, "An exception occurred while closing the 'Closeable' object.");
            }
        }
    }

    public static void closeQuietly(java.io.InputStream inputStream) {
        closeQuietly((java.io.Closeable) inputStream);
    }

    public static void closeQuietly(java.io.OutputStream outputStream) {
        closeQuietly((java.io.Closeable) outputStream);
    }

    public static void closeQuietly(java.io.Reader reader) {
        closeQuietly((java.io.Closeable) reader);
    }

    public static void closeQuietly(java.io.Writer writer) {
        closeQuietly((java.io.Closeable) writer);
    }

    public static long copy(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        return copy(inputStream, outputStream, new byte[4096]);
    }

    public static long copy(java.io.InputStream inputStream, java.io.OutputStream outputStream, byte[] bArr) throws java.io.IOException {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    public static byte[] toByteArray(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static java.io.InputStream toInputStream(byte[] bArr) throws java.io.IOException {
        return new java.io.ByteArrayInputStream(bArr);
    }
}
