package com.meizu.cloud.pushsdk.notification.c;

/* loaded from: classes23.dex */
public class e {
    private final java.io.File a;
    private final java.io.File b;
    private final java.lang.String c;

    public e(java.lang.String str, java.lang.String str2) {
        java.io.File file = new java.io.File(str);
        this.a = file;
        java.io.File file2 = new java.io.File(str2);
        this.b = file2;
        this.c = file2.getAbsolutePath();
        com.meizu.cloud.pushinternal.DebugLogger.i("ZipExtractTask", "Extract mInput file = " + file.toString());
        com.meizu.cloud.pushinternal.DebugLogger.i("ZipExtractTask", "Extract mOutput file = " + file2.toString());
    }

    private int a(java.io.InputStream inputStream, java.io.OutputStream outputStream) {
        java.lang.StringBuilder sb;
        byte[] bArr = new byte[8192];
        java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(inputStream, 8192);
        java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(outputStream, 8192);
        int i = 0;
        while (true) {
            try {
                try {
                    int read = bufferedInputStream.read(bArr, 0, 8192);
                    if (read == -1) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                    i += read;
                } catch (java.io.IOException e) {
                    com.meizu.cloud.pushinternal.DebugLogger.e("ZipExtractTask", "Extracted IOException:" + e.toString());
                    try {
                        bufferedOutputStream.close();
                    } catch (java.io.IOException e2) {
                        com.meizu.cloud.pushinternal.DebugLogger.e("ZipExtractTask", "out.close() IOException e=" + e2.toString());
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (java.io.IOException e3) {
                        e = e3;
                        sb = new java.lang.StringBuilder();
                        sb.append("in.close() IOException e=");
                        sb.append(e.toString());
                        com.meizu.cloud.pushinternal.DebugLogger.e("ZipExtractTask", sb.toString());
                        return i;
                    }
                }
            } catch (java.lang.Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (java.io.IOException e4) {
                    com.meizu.cloud.pushinternal.DebugLogger.e("ZipExtractTask", "out.close() IOException e=" + e4.toString());
                }
                try {
                    bufferedInputStream.close();
                    throw th;
                } catch (java.io.IOException e5) {
                    com.meizu.cloud.pushinternal.DebugLogger.e("ZipExtractTask", "in.close() IOException e=" + e5.toString());
                    throw th;
                }
            }
        }
        bufferedOutputStream.flush();
        try {
            bufferedOutputStream.close();
        } catch (java.io.IOException e6) {
            com.meizu.cloud.pushinternal.DebugLogger.e("ZipExtractTask", "out.close() IOException e=" + e6.toString());
        }
        try {
            bufferedInputStream.close();
        } catch (java.io.IOException e7) {
            e = e7;
            sb = new java.lang.StringBuilder();
            sb.append("in.close() IOException e=");
            sb.append(e.toString());
            com.meizu.cloud.pushinternal.DebugLogger.e("ZipExtractTask", sb.toString());
            return i;
        }
        return i;
    }

    private void b() {
        java.lang.StringBuilder sb;
        java.lang.String str;
        java.io.File file = this.a;
        if (file == null || !file.exists()) {
            return;
        }
        if (this.a.delete()) {
            sb = new java.lang.StringBuilder();
            str = "Delete file:";
        } else {
            sb = new java.lang.StringBuilder();
            str = "Can't delete file:";
        }
        sb.append(str);
        sb.append(this.a.toString());
        sb.append(" after extracted.");
        com.meizu.cloud.pushinternal.DebugLogger.i("ZipExtractTask", sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
    
        if (r13 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
    
        r10 = r13.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)[0];
        com.meizu.cloud.pushinternal.DebugLogger.i("ZipExtractTask", "Extract temp directory=" + r17.b + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + r10);
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long c() {
        java.lang.String str;
        java.lang.Throwable th;
        java.io.IOException iOException;
        java.lang.StringBuilder sb;
        java.util.zip.ZipFile zipFile;
        java.lang.String str2;
        long currentThreadTimeMillis = android.os.SystemClock.currentThreadTimeMillis();
        long j = 0;
        boolean z = false;
        java.util.zip.ZipFile zipFile2 = null;
        java.lang.String str3 = null;
        java.util.zip.ZipFile zipFile3 = null;
        java.util.zip.ZipFile zipFile4 = null;
        java.util.zip.ZipFile zipFile5 = null;
        try {
            try {
                zipFile = new java.util.zip.ZipFile(this.a);
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.util.zip.ZipException e) {
            e = e;
            str = null;
        } catch (java.io.IOException e2) {
            e = e2;
            str = null;
        } catch (java.lang.Exception e3) {
            e = e3;
            str = null;
        }
        try {
            java.util.Enumeration<? extends java.util.zip.ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                java.util.zip.ZipEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory()) {
                    java.lang.String name = nextElement.getName();
                    if (name != null && name.contains("../")) {
                        throw new java.lang.Exception("Unsafe zip file");
                    }
                    if (name != null) {
                        java.io.File file = new java.io.File(this.b, name);
                        if (!file.getParentFile().exists()) {
                            if (file.getParentFile().mkdirs()) {
                                str2 = "Make Destination directory=" + file.getParentFile().getAbsolutePath();
                            } else {
                                str2 = "Can't make destination directory=" + file.getParentFile().getAbsolutePath();
                            }
                            com.meizu.cloud.pushinternal.DebugLogger.i("ZipExtractTask", str2);
                        }
                        j += a(zipFile.getInputStream(nextElement), r13);
                        new java.io.FileOutputStream(file).close();
                    }
                }
            }
            java.lang.String str4 = this.b + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str3;
            if (!this.c.equals(str4)) {
                com.meizu.cloud.pushsdk.notification.c.a.a(str4, this.c);
                z = true;
            }
            try {
                zipFile.close();
            } catch (java.io.IOException e4) {
                com.meizu.cloud.pushinternal.DebugLogger.e("ZipExtractTask", "Extracted IOException:" + e4.toString());
            }
        } catch (java.util.zip.ZipException e5) {
            e = e5;
            str = null;
            zipFile4 = zipFile;
            com.meizu.cloud.pushinternal.DebugLogger.e("ZipExtractTask", "ZipException :" + e.toString());
            if (zipFile4 != null) {
                try {
                    zipFile4.close();
                } catch (java.io.IOException e6) {
                    iOException = e6;
                    sb = new java.lang.StringBuilder();
                    sb.append("Extracted IOException:");
                    sb.append(iOException.toString());
                    com.meizu.cloud.pushinternal.DebugLogger.e("ZipExtractTask", sb.toString());
                    str3 = str;
                    com.meizu.cloud.pushinternal.DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (android.os.SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
                    if (z) {
                    }
                    b();
                    return j;
                }
            }
            str3 = str;
            com.meizu.cloud.pushinternal.DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (android.os.SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
            if (z) {
            }
            b();
            return j;
        } catch (java.io.IOException e7) {
            e = e7;
            str = null;
            zipFile5 = zipFile;
            com.meizu.cloud.pushinternal.DebugLogger.e("ZipExtractTask", "Extracted IOException:" + e.toString());
            if (zipFile5 != null) {
                try {
                    zipFile5.close();
                } catch (java.io.IOException e8) {
                    iOException = e8;
                    sb = new java.lang.StringBuilder();
                    sb.append("Extracted IOException:");
                    sb.append(iOException.toString());
                    com.meizu.cloud.pushinternal.DebugLogger.e("ZipExtractTask", sb.toString());
                    str3 = str;
                    com.meizu.cloud.pushinternal.DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (android.os.SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
                    if (z) {
                    }
                    b();
                    return j;
                }
            }
            str3 = str;
            com.meizu.cloud.pushinternal.DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (android.os.SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
            if (z) {
            }
            b();
            return j;
        } catch (java.lang.Exception e9) {
            e = e9;
            str = null;
            zipFile2 = zipFile;
            com.meizu.cloud.pushinternal.DebugLogger.e("ZipExtractTask", "Extracted Exception " + e.toString());
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (java.io.IOException e10) {
                    iOException = e10;
                    sb = new java.lang.StringBuilder();
                    sb.append("Extracted IOException:");
                    sb.append(iOException.toString());
                    com.meizu.cloud.pushinternal.DebugLogger.e("ZipExtractTask", sb.toString());
                    str3 = str;
                    com.meizu.cloud.pushinternal.DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (android.os.SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
                    if (z) {
                    }
                    b();
                    return j;
                }
            }
            str3 = str;
            com.meizu.cloud.pushinternal.DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (android.os.SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
            if (z) {
            }
            b();
            return j;
        } catch (java.lang.Throwable th3) {
            th = th3;
            zipFile3 = zipFile;
            if (zipFile3 == null) {
                throw th;
            }
            try {
                zipFile3.close();
                throw th;
            } catch (java.io.IOException e11) {
                com.meizu.cloud.pushinternal.DebugLogger.e("ZipExtractTask", "Extracted IOException:" + e11.toString());
                throw th;
            }
        }
        com.meizu.cloud.pushinternal.DebugLogger.i("ZipExtractTask", "Extract file " + this.a + ", UseTime =" + (android.os.SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
        if (z) {
            com.meizu.cloud.pushsdk.notification.c.a.b(this.b + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str3);
        }
        b();
        return j;
    }

    public boolean a() {
        return c() > 0;
    }
}
