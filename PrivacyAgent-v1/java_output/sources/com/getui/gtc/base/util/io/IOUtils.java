package com.getui.gtc.base.util.io;

/* loaded from: classes22.dex */
public class IOUtils {
    public static final java.lang.String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    /* renamed from: pad, reason: collision with root package name */
    static final char f311pad = '=';

    public static void copy(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    public static void copy(byte[] bArr, java.io.OutputStream outputStream) throws java.io.IOException {
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        try {
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = byteArrayInputStream.read(bArr2);
                if (read == -1) {
                    return;
                } else {
                    outputStream.write(bArr2, 0, read);
                }
            }
        } catch (java.io.IOException e) {
            safeClose(byteArrayInputStream);
            throw e;
        }
    }

    public static void encode(java.io.InputStream inputStream, java.io.OutputStream outputStream, int i) throws java.io.IOException {
        com.getui.gtc.base.util.io.Base64OutputStream base64OutputStream = new com.getui.gtc.base.util.io.Base64OutputStream(outputStream, i);
        copy(inputStream, base64OutputStream);
        base64OutputStream.commit();
    }

    public static byte[] encode(byte[] bArr, int i) throws java.lang.RuntimeException {
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            try {
                encode(byteArrayInputStream, byteArrayOutputStream, i);
                safeClose(byteArrayInputStream);
                safeClose(byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            } catch (java.io.IOException e) {
                throw new java.lang.RuntimeException("Unexpected I/O error", e);
            }
        } catch (java.lang.Throwable th) {
            safeClose(byteArrayInputStream);
            safeClose(byteArrayOutputStream);
            throw th;
        }
    }

    public static byte[] gzip(byte[] bArr) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.util.zip.GZIPOutputStream gZIPOutputStream = null;
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            try {
                java.util.zip.GZIPOutputStream gZIPOutputStream2 = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(bArr);
                    gZIPOutputStream2.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    safeClose(gZIPOutputStream2);
                    safeClose(byteArrayOutputStream);
                    return byteArray;
                } catch (java.lang.Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    safeClose(gZIPOutputStream);
                    safeClose(byteArrayOutputStream);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] readFile(java.io.File file) throws java.io.IOException {
        java.io.FileInputStream fileInputStream;
        java.lang.Throwable th;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        try {
            fileInputStream = new java.io.FileInputStream(file);
            try {
                byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        fileInputStream.close();
                    } catch (java.io.IOException unused) {
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (java.io.IOException unused2) {
                    }
                    return byteArray;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.io.IOException unused3) {
                        }
                    }
                    if (byteArrayOutputStream == null) {
                        throw th;
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (java.io.IOException unused4) {
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (java.lang.Throwable th4) {
            fileInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static void safeClose(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void saveToFile(java.io.InputStream inputStream, java.io.File file) throws java.io.IOException {
        java.io.FileOutputStream fileOutputStream = null;
        try {
            java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        safeClose(fileOutputStream2);
                        return;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                safeClose(fileOutputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static void saveToFile(java.io.InputStream inputStream, java.lang.String str) throws java.io.IOException {
        java.io.FileOutputStream fileOutputStream = null;
        try {
            java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(str);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        safeClose(fileOutputStream2);
                        return;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                safeClose(fileOutputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static void saveToFile(byte[] bArr, java.io.File file) throws java.io.IOException {
        java.io.FileOutputStream fileOutputStream;
        java.io.ByteArrayInputStream byteArrayInputStream = null;
        try {
            java.io.ByteArrayInputStream byteArrayInputStream2 = new java.io.ByteArrayInputStream(bArr);
            try {
                fileOutputStream = new java.io.FileOutputStream(file);
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = byteArrayInputStream2.read(bArr2);
                        if (read == -1) {
                            safeClose(byteArrayInputStream2);
                            safeClose(fileOutputStream);
                            return;
                        }
                        fileOutputStream.write(bArr2, 0, read);
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    byteArrayInputStream = byteArrayInputStream2;
                    safeClose(byteArrayInputStream);
                    safeClose(fileOutputStream);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.Closeable, java.io.InputStream, java.util.zip.GZIPInputStream] */
    public static byte[] unGzip(byte[] bArr) throws java.io.IOException {
        java.io.ByteArrayInputStream byteArrayInputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.lang.Throwable th;
        ?? r5;
        try {
            byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
            try {
                r5 = new java.util.zip.GZIPInputStream(byteArrayInputStream);
                try {
                    byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = r5.read();
                            if (read == -1) {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                safeClose(r5);
                                safeClose(byteArrayOutputStream);
                                safeClose(byteArrayInputStream);
                                return byteArray;
                            }
                            byteArrayOutputStream.write(read);
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            safeClose(r5);
                            safeClose(byteArrayOutputStream);
                            safeClose(byteArrayInputStream);
                            throw th;
                        }
                    }
                } catch (java.lang.Throwable th3) {
                    byteArrayOutputStream = null;
                    th = th3;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                th = th;
                r5 = byteArrayOutputStream;
                safeClose(r5);
                safeClose(byteArrayOutputStream);
                safeClose(byteArrayInputStream);
                throw th;
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            byteArrayInputStream = null;
            byteArrayOutputStream = null;
        }
    }
}
