package com.tencent.open.web.security;

/* loaded from: classes19.dex */
public class JniInterface {
    public static boolean isJniOk;

    public static native boolean BackSpaceChar(boolean z, int i);

    public static native boolean clearAllPWD();

    public static native java.lang.String d1(java.lang.String str);

    public static native java.lang.String d2(java.lang.String str);

    public static native java.lang.String getPWDKeyToMD5(java.lang.String str);

    public static native boolean insetTextToArray(int i, java.lang.String str, int i2);

    public static void loadSo() {
        if (isJniOk) {
            return;
        }
        try {
            android.content.Context a = com.tencent.open.utils.f.a();
            if (a != null) {
                if (new java.io.File(a.getFilesDir().toString() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + com.tencent.connect.auth.AuthAgent.SECURE_LIB_NAME).exists()) {
                    java.lang.System.load(a.getFilesDir().toString() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + com.tencent.connect.auth.AuthAgent.SECURE_LIB_NAME);
                    isJniOk = true;
                    com.tencent.open.log.SLog.i("openSDK_LOG.JniInterface", "-->load lib success:" + com.tencent.connect.auth.AuthAgent.SECURE_LIB_NAME);
                } else {
                    com.tencent.open.log.SLog.i("openSDK_LOG.JniInterface", "-->fail, because so is not exists:" + com.tencent.connect.auth.AuthAgent.SECURE_LIB_NAME);
                }
            } else {
                com.tencent.open.log.SLog.i("openSDK_LOG.JniInterface", "-->load lib fail, because context is null:" + com.tencent.connect.auth.AuthAgent.SECURE_LIB_NAME);
            }
        } catch (java.lang.Throwable th) {
            com.tencent.open.log.SLog.e("openSDK_LOG.JniInterface", "-->load lib error:" + com.tencent.connect.auth.AuthAgent.SECURE_LIB_NAME, th);
        }
    }
}
