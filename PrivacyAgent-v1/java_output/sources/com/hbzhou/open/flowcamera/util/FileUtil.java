package com.hbzhou.open.flowcamera.util;

/* loaded from: classes22.dex */
public class FileUtil {
    public static final java.lang.String a = com.moji.tool.FilePathUtil.getRootMojiPath();
    public static java.lang.String b = "";
    public static java.lang.String c = "JCamera";

    public static java.lang.String a() {
        if (b.equals("")) {
            b = a + java.io.File.separator + c;
            java.io.File file = new java.io.File(b);
            if (!file.exists()) {
                file.mkdir();
            }
        }
        return b;
    }

    public static boolean deleteFile(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0081 A[Catch: Exception -> 0x007d, TRY_LEAVE, TryCatch #1 {Exception -> 0x007d, blocks: (B:42:0x0079, B:35:0x0081), top: B:41:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String saveBitmap(java.lang.String str, android.graphics.Bitmap bitmap) {
        java.io.BufferedOutputStream bufferedOutputStream;
        java.io.FileOutputStream fileOutputStream;
        c = str;
        java.lang.String str2 = a() + java.io.File.separator + "picture_" + java.lang.System.currentTimeMillis() + ".jpg";
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new java.io.FileOutputStream(str2);
            try {
                bufferedOutputStream = new java.io.BufferedOutputStream(fileOutputStream);
            } catch (java.io.IOException e) {
                e = e;
                bufferedOutputStream = null;
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedOutputStream = null;
            }
        } catch (java.io.IOException e2) {
            e = e2;
            bufferedOutputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
        try {
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            try {
                fileOutputStream.close();
                bufferedOutputStream.close();
            } catch (java.lang.Exception e3) {
                com.moji.tool.log.MJLogger.e("CameraFileUtil", e3);
            }
            return str2;
        } catch (java.io.IOException e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            try {
                com.moji.tool.log.MJLogger.e("CameraFileUtil", e);
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (java.lang.Exception e5) {
                        com.moji.tool.log.MJLogger.e("CameraFileUtil", e5);
                        return "";
                    }
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                return "";
            } catch (java.lang.Throwable th3) {
                th = th3;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (java.lang.Exception e6) {
                        com.moji.tool.log.MJLogger.e("CameraFileUtil", e6);
                        throw th;
                    }
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
            }
            if (bufferedOutputStream != null) {
            }
            throw th;
        }
    }
}
