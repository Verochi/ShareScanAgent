package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class FileUtils {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r7v4 */
    public static java.lang.String readFileToString(java.io.File file) {
        java.io.BufferedInputStream bufferedInputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        try {
            try {
                bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream((java.io.File) file));
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    java.lang.String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    try {
                        bufferedInputStream.close();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (java.io.IOException e2) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
                    }
                    return byteArrayOutputStream2;
                } catch (java.io.IOException e3) {
                    e = e3;
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    try {
                        bufferedInputStream.close();
                    } catch (java.io.IOException e4) {
                        e4.printStackTrace();
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (java.io.IOException e5) {
                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e5);
                        }
                    }
                    return null;
                }
            } catch (java.io.IOException e6) {
                e = e6;
                byteArrayOutputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                file = 0;
                try {
                    bufferedInputStream.close();
                } catch (java.io.IOException e7) {
                    e7.printStackTrace();
                }
                if (file == 0) {
                    throw th;
                }
                try {
                    file.close();
                    throw th;
                } catch (java.io.IOException e8) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e8);
                    throw th;
                }
            }
        } catch (java.lang.Exception e9) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e9);
            return null;
        }
    }

    public static void writeToFile(java.io.File file, java.lang.String str) {
        java.io.FileOutputStream fileOutputStream;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new java.io.FileOutputStream(file);
                } catch (java.io.IOException e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    return;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
        } catch (java.lang.Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (java.io.IOException e4) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e4);
                }
            }
            throw th;
        }
    }
}
