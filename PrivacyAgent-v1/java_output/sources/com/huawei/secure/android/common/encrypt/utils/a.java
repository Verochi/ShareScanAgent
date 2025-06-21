package com.huawei.secure.android.common.encrypt.utils;

/* loaded from: classes22.dex */
public class a {
    public static long a(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        return a(inputStream, outputStream, new byte[4096]);
    }

    public static long a(java.io.InputStream inputStream, java.io.OutputStream outputStream, byte[] bArr) throws java.io.IOException {
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

    public static java.io.InputStream a(byte[] bArr) throws java.io.IOException {
        return new java.io.ByteArrayInputStream(bArr);
    }

    public static void a(android.database.Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    public static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
                com.huawei.secure.android.common.encrypt.utils.b.b("IOUtil", "closeSecure IOException");
            }
        }
    }

    public static void a(java.io.File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        com.huawei.secure.android.common.encrypt.utils.b.b("IOUtil", "deleteSecure exception");
    }

    public static void a(java.io.InputStream inputStream) {
        a((java.io.Closeable) inputStream);
    }

    public static void a(java.io.OutputStream outputStream) {
        a((java.io.Closeable) outputStream);
    }

    public static void a(java.io.Reader reader) {
        a((java.io.Closeable) reader);
    }

    public static void a(java.io.Writer writer) {
        a((java.io.Closeable) writer);
    }

    public static void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        a(new java.io.File(str));
    }

    public static byte[] b(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
