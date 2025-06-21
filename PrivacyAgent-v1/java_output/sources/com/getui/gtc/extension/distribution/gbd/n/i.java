package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class i {
    private static final java.lang.String a = "FileUtils";

    public static void a(byte[] bArr, java.lang.String str) {
        java.io.FileOutputStream fileOutputStream = null;
        try {
            java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(str, false);
            try {
                fileOutputStream2.write(bArr);
                try {
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                try {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (java.lang.Throwable th3) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(th3);
                        }
                    }
                } catch (java.lang.Throwable th4) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (java.lang.Throwable th5) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(th5);
                        }
                    }
                    throw th4;
                }
            }
        } catch (java.lang.Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0054 -> B:19:0x0079). Please report as a decompilation issue!!! */
    public static byte[] a(java.lang.String str) {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.FileInputStream fileInputStream;
        byte[] bArr = null;
        if (!new java.io.File(str).exists()) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "|get data from file = " + str + " file not exist ######");
            return null;
        }
        byte[] bArr2 = new byte[1024];
        try {
            try {
                fileInputStream = new java.io.FileInputStream(str);
                try {
                    byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = fileInputStream.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } catch (java.lang.Throwable th) {
                            th = th;
                            try {
                                com.getui.gtc.extension.distribution.gbd.n.j.b(a, th.toString());
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (java.lang.Throwable th2) {
                                        com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.flush();
                                    byteArrayOutputStream.close();
                                }
                                return bArr;
                            } finally {
                            }
                        }
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    try {
                        fileInputStream.close();
                    } catch (java.lang.Throwable th3) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th3);
                    }
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                }
            } catch (java.lang.Throwable th5) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th5);
            }
        } catch (java.lang.Throwable th6) {
            th = th6;
            byteArrayOutputStream = null;
            fileInputStream = null;
        }
        return bArr;
    }
}
