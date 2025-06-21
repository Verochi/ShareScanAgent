package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class IoUtils {
    private static final int BUFF_SIZE = 4096;
    private static final int MAX_SIZE = 16777216;

    private IoUtils() {
    }

    public static void close(android.database.Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    public static void closeSecure(java.io.Closeable closeable) {
        if (closeable == null) {
            com.huawei.hms.framework.common.Logger.w("IOUtil", "closeable is null");
            return;
        }
        try {
            closeable.close();
        } catch (java.io.IOException e) {
            com.huawei.hms.framework.common.Logger.w("IOUtil", "closeSecure IOException", e);
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
        java.lang.String packageName = com.huawei.hms.framework.common.ContextHolder.getAppContext() != null ? com.huawei.hms.framework.common.ContextHolder.getAppContext().getPackageName() : "";
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            if (j > 16777216 && !"com.huawei.health".equals(packageName)) {
                throw new java.io.IOException("input data too large for byte.");
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
}
