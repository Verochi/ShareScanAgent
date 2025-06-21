package com.alipay.sdk.m.n;

/* loaded from: classes.dex */
public class b {
    public static byte[] a(byte[] bArr) throws java.io.IOException {
        java.lang.Throwable th;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        java.io.ByteArrayInputStream byteArrayInputStream = null;
        try {
            java.io.ByteArrayInputStream byteArrayInputStream2 = new java.io.ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
                    try {
                        byte[] bArr2 = new byte[4096];
                        while (true) {
                            int read = byteArrayInputStream2.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            gZIPOutputStream.write(bArr2, 0, read);
                        }
                        gZIPOutputStream.flush();
                        gZIPOutputStream.finish();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            byteArrayInputStream2.close();
                        } catch (java.lang.Exception unused) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (java.lang.Exception unused2) {
                        }
                        try {
                            gZIPOutputStream.close();
                        } catch (java.lang.Exception unused3) {
                        }
                        return byteArray;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        byteArrayInputStream = byteArrayInputStream2;
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (java.lang.Exception unused4) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (java.lang.Exception unused5) {
                            }
                        }
                        if (gZIPOutputStream == null) {
                            throw th;
                        }
                        try {
                            gZIPOutputStream.close();
                            throw th;
                        } catch (java.lang.Exception unused6) {
                            throw th;
                        }
                    }
                } catch (java.lang.Throwable th3) {
                    gZIPOutputStream = null;
                    byteArrayInputStream = byteArrayInputStream2;
                    th = th3;
                }
            } catch (java.lang.Throwable th4) {
                gZIPOutputStream = null;
                byteArrayInputStream = byteArrayInputStream2;
                th = th4;
                byteArrayOutputStream = null;
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            gZIPOutputStream = null;
        }
    }

    public static byte[] b(byte[] bArr) throws java.io.IOException {
        java.lang.Throwable th;
        java.util.zip.GZIPInputStream gZIPInputStream;
        java.io.ByteArrayInputStream byteArrayInputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new java.util.zip.GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] bArr2 = new byte[4096];
                    java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = gZIPInputStream.read(bArr2, 0, 4096);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr2, 0, read);
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            try {
                                byteArrayOutputStream.close();
                            } catch (java.lang.Exception unused) {
                            }
                            try {
                                gZIPInputStream.close();
                            } catch (java.lang.Exception unused2) {
                            }
                            try {
                                byteArrayInputStream.close();
                                throw th;
                            } catch (java.lang.Exception unused3) {
                                throw th;
                            }
                        }
                    }
                    byteArrayOutputStream2.flush();
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    try {
                        byteArrayOutputStream2.close();
                    } catch (java.lang.Exception unused4) {
                    }
                    try {
                        gZIPInputStream.close();
                    } catch (java.lang.Exception unused5) {
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (java.lang.Exception unused6) {
                    }
                    return byteArray;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                gZIPInputStream = null;
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            gZIPInputStream = null;
            byteArrayInputStream = null;
        }
    }
}
