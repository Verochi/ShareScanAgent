package com.huawei.secure.android.common.util;

/* loaded from: classes22.dex */
public class IOUtil {
    public static void close(android.database.Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    public static void closeSecure(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void closeSecure(java.io.InputStream inputStream) {
        closeSecure((java.io.Closeable) inputStream);
    }

    public static void closeSecure(java.io.OutputStream outputStream) {
        closeSecure((java.io.Closeable) outputStream);
    }

    public static void closeSecure(java.io.Reader reader) {
        closeSecure((java.io.Closeable) reader);
    }

    public static void closeSecure(java.io.Writer writer) {
        closeSecure((java.io.Closeable) writer);
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

    public static void deleteSecure(java.io.File file) {
        if (file == null || !file.exists()) {
            return;
        }
        file.delete();
    }

    public static void deleteSecure(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        deleteSecure(new java.io.File(str));
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
