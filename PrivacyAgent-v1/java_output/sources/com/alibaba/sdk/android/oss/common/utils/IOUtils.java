package com.alibaba.sdk.android.oss.common.utils;

/* loaded from: classes.dex */
public class IOUtils {
    private static final int BUFFER_SIZE = 4096;

    public static byte[] readStreamAsBytesArray(java.io.InputStream inputStream) throws java.io.IOException {
        if (inputStream == null) {
            return new byte[0];
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= -1) {
                byteArrayOutputStream.flush();
                safeClose(byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static byte[] readStreamAsBytesArray(java.io.InputStream inputStream, int i) throws java.io.IOException {
        int read;
        if (inputStream == null) {
            return new byte[0];
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            long j2 = i;
            if (j >= j2 || (read = inputStream.read(bArr, 0, java.lang.Math.min(2048, (int) (j2 - j)))) <= -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
            j += read;
        }
        byteArrayOutputStream.flush();
        safeClose(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static java.lang.String readStreamAsString(java.io.InputStream inputStream, java.lang.String str) throws java.io.IOException {
        if (inputStream == null) {
            return "";
        }
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        char[] cArr = new char[4096];
        java.io.BufferedReader bufferedReader = null;
        try {
            java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream, str));
            while (true) {
                try {
                    int read = bufferedReader2.read(cArr);
                    if (read <= 0) {
                        java.lang.String obj = stringWriter.toString();
                        safeClose(inputStream);
                        bufferedReader2.close();
                        stringWriter.close();
                        return obj;
                    }
                    stringWriter.write(cArr, 0, read);
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    safeClose(inputStream);
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    stringWriter.close();
                    throw th;
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static void safeClose(java.io.InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void safeClose(java.io.OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (java.io.IOException unused) {
            }
        }
    }
}
