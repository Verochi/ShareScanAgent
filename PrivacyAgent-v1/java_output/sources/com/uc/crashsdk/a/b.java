package com.uc.crashsdk.a;

/* loaded from: classes19.dex */
public final class b {
    private static final int[] a = {126, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_NAME, 115, 241, 101, 198, 215, 134};
    private static final int[] b = {125, 185, 233, 226, 129, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, 151, 176};
    private static final int[] c = {238, 185, 233, 179, 129, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, 151, 167};

    public static java.lang.String a(java.lang.String str) {
        java.io.FileInputStream fileInputStream;
        java.io.FileInputStream fileInputStream2;
        java.io.File file = new java.io.File(str);
        java.io.FileInputStream fileInputStream3 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream2 = new java.io.FileInputStream(file);
        } catch (java.lang.Exception e) {
            e = e;
            fileInputStream = null;
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream2.read(bArr);
            com.uc.crashsdk.a.g.a(fileInputStream2);
            byte[] a2 = a(bArr, a);
            if (a2 == null || a2.length <= 0) {
                com.uc.crashsdk.a.g.a((java.io.Closeable) null);
                return null;
            }
            int length = a2.length - 1;
            java.lang.String str2 = a2[length] == 10 ? new java.lang.String(a2, 0, length) : new java.lang.String(a2);
            com.uc.crashsdk.a.g.a((java.io.Closeable) null);
            return str2;
        } catch (java.lang.Exception e2) {
            fileInputStream = fileInputStream2;
            e = e2;
            try {
                com.uc.crashsdk.a.g.a(e);
                com.uc.crashsdk.a.g.a(fileInputStream);
                return null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileInputStream3 = fileInputStream;
                com.uc.crashsdk.a.g.a(fileInputStream3);
                throw th;
            }
        } catch (java.lang.Throwable th3) {
            fileInputStream3 = fileInputStream2;
            th = th3;
            com.uc.crashsdk.a.g.a(fileInputStream3);
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        r1 = com.uc.crashsdk.a.g.e(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a(java.lang.String str, java.lang.String str2, boolean z) {
        byte[] e;
        java.lang.String str3;
        boolean z2;
        java.lang.String str4;
        boolean z3;
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        java.lang.Throwable th;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        boolean z4;
        if (!z || com.uc.crashsdk.a.g.a(str)) {
            return str;
        }
        java.io.File file = new java.io.File(str);
        if (file.exists() && file.length() <= 3145728 && e != null && e.length > 0) {
            boolean z5 = true;
            if (z) {
                try {
                    byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    try {
                        gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
                        try {
                            gZIPOutputStream.write(e);
                            byteArrayOutputStream.flush();
                            com.uc.crashsdk.a.g.a(byteArrayOutputStream);
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            try {
                                com.uc.crashsdk.a.g.a(th);
                                com.uc.crashsdk.a.g.a(byteArrayOutputStream);
                                com.uc.crashsdk.a.g.a(gZIPOutputStream);
                                e = byteArrayOutputStream.toByteArray();
                                z4 = true;
                                if (z4) {
                                }
                                return str;
                            } catch (java.lang.Throwable th3) {
                                com.uc.crashsdk.a.g.a(byteArrayOutputStream);
                                com.uc.crashsdk.a.g.a(gZIPOutputStream);
                                throw th3;
                            }
                        }
                    } catch (java.lang.Throwable th4) {
                        gZIPOutputStream = null;
                        th = th4;
                    }
                } catch (java.lang.Throwable th5) {
                    gZIPOutputStream = null;
                    th = th5;
                    byteArrayOutputStream = null;
                }
                com.uc.crashsdk.a.g.a(gZIPOutputStream);
                try {
                    e = byteArrayOutputStream.toByteArray();
                    z4 = true;
                } catch (java.lang.Throwable th6) {
                    com.uc.crashsdk.a.g.a(th6);
                    z4 = false;
                }
                if (z4 || e == null || e.length <= 0) {
                    return str;
                }
                str3 = str + str2;
                z2 = true;
            } else {
                str3 = str;
                z2 = false;
            }
            if (z2) {
                if (str3.equals(file.getName())) {
                    str4 = str3 + com.baidu.mobads.sdk.internal.al.k;
                    z3 = true;
                } else {
                    str4 = str3;
                    z3 = false;
                }
                java.io.File file2 = new java.io.File(str4);
                if (!com.uc.crashsdk.a.g.a(file2, e)) {
                    z5 = false;
                } else if (z3) {
                    file.delete();
                    file2.renameTo(file);
                }
                if (z5) {
                    return str3;
                }
            }
        }
        return str;
    }

    public static boolean a(java.lang.String str, java.lang.String str2) {
        java.io.FileOutputStream fileOutputStream;
        try {
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new java.io.FileOutputStream(file);
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            fileOutputStream = null;
        }
        if (fileOutputStream == null) {
            return false;
        }
        byte[] b2 = b(str2.getBytes(), a);
        if (b2 == null) {
            return false;
        }
        try {
            fileOutputStream.write(b2);
            com.uc.crashsdk.a.g.a(fileOutputStream);
            return true;
        } catch (java.lang.Throwable th2) {
            try {
                com.uc.crashsdk.a.g.a(th2);
                return false;
            } finally {
                com.uc.crashsdk.a.g.a(fileOutputStream);
            }
        }
    }

    private static byte[] a(byte[] bArr, int[] iArr) {
        if (bArr.length - 0 >= 2 && iArr != null && iArr.length == 8) {
            int length = (bArr.length - 2) - 0;
            try {
                byte[] bArr2 = new byte[length];
                byte b2 = 0;
                for (int i = 0; i < length; i++) {
                    byte b3 = (byte) (bArr[i + 0] ^ iArr[i % 8]);
                    bArr2[i] = b3;
                    b2 = (byte) (b2 ^ b3);
                }
                if (bArr[length + 0] == ((byte) ((iArr[0] ^ b2) & 255)) && bArr[length + 1 + 0] == ((byte) ((iArr[1] ^ b2) & 255))) {
                    return bArr2;
                }
                return null;
            } catch (java.lang.Exception e) {
                com.uc.crashsdk.a.g.a(e);
            }
        }
        return null;
    }

    private static byte[] b(byte[] bArr, int[] iArr) {
        if (bArr != null && iArr != null && iArr.length == 8) {
            int length = bArr.length;
            try {
                byte[] bArr2 = new byte[length + 2];
                byte b2 = 0;
                for (int i = 0; i < length; i++) {
                    byte b3 = bArr[i];
                    bArr2[i] = (byte) (iArr[i % 8] ^ b3);
                    b2 = (byte) (b2 ^ b3);
                }
                bArr2[length] = (byte) (iArr[0] ^ b2);
                bArr2[length + 1] = (byte) (iArr[1] ^ b2);
                return bArr2;
            } catch (java.lang.Exception e) {
                com.uc.crashsdk.a.g.a(e);
            }
        }
        return null;
    }
}
