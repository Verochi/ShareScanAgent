package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class br {
    public static final java.lang.String a = "IOUtils";

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            a(context.getAssets().open(str), str2);
        } catch (java.lang.Exception e) {
            com.baidu.mobads.sdk.internal.bt.a().a(e);
        }
    }

    public static void a(java.io.InputStream inputStream, java.lang.String str) {
        java.io.FileOutputStream fileOutputStream = null;
        try {
            java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(str);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        inputStream.close();
                        fileOutputStream2.close();
                        inputStream.close();
                        fileOutputStream2.close();
                        return;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(java.io.File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.exists() && file.canRead()) {
                return file.length() > 0;
            }
            return false;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean a(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            java.io.File file = new java.io.File(str);
            if (file.exists() && file.canRead()) {
                return file.length() > 0;
            }
            return false;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean a(java.lang.String str, java.lang.String str2) {
        try {
            java.io.File file = new java.io.File(str);
            java.io.File file2 = new java.io.File(str2);
            if (file.exists()) {
                return file.renameTo(file2);
            }
            return false;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }
}
