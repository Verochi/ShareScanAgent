package com.getui.gtc.a.a;

/* loaded from: classes22.dex */
public final class e {
    public static byte[] a(byte[] bArr) {
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr2 = null;
        try {
            try {
                gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.finish();
                    bArr2 = byteArrayOutputStream.toByteArray();
                    try {
                        gZIPOutputStream.close();
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (java.lang.Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        byteArrayOutputStream.close();
                        return bArr2;
                    } finally {
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                gZIPOutputStream = null;
            }
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return bArr2;
    }

    public static byte[] b(byte[] bArr) {
        java.util.zip.GZIPInputStream gZIPInputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        byte[] bArr2 = null;
        try {
            try {
                gZIPInputStream = new java.util.zip.GZIPInputStream(byteArrayInputStream);
                try {
                    byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = gZIPInputStream.read();
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(read);
                        } catch (java.lang.Throwable th) {
                            th = th;
                            try {
                                th.printStackTrace();
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (java.lang.Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (gZIPInputStream != null) {
                                    try {
                                        gZIPInputStream.close();
                                    } catch (java.lang.Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                byteArrayInputStream.close();
                                return bArr2;
                            } finally {
                            }
                        }
                    }
                    bArr2 = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (java.lang.Exception e3) {
                        e3.printStackTrace();
                    }
                    try {
                        gZIPInputStream.close();
                    } catch (java.lang.Exception e4) {
                        e4.printStackTrace();
                    }
                    byteArrayInputStream.close();
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                }
            } catch (java.lang.Exception e5) {
                e5.printStackTrace();
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            gZIPInputStream = null;
            byteArrayOutputStream = null;
        }
        return bArr2;
    }
}
