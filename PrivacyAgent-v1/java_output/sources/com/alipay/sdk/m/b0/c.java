package com.alipay.sdk.m.b0;

/* loaded from: classes.dex */
public final class c {
    public static java.lang.String a(java.lang.String str) {
        try {
            if (!a()) {
                return null;
            }
            java.io.File file = new java.io.File(android.os.Environment.getExternalStorageDirectory().getAbsolutePath(), str);
            if (!file.exists()) {
                return null;
            }
            file.delete();
            return "";
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static boolean a() {
        java.lang.String externalStorageState = android.os.Environment.getExternalStorageState();
        if (externalStorageState == null || externalStorageState.length() <= 0) {
            return false;
        }
        return (externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro")) && android.os.Environment.getExternalStorageDirectory() != null;
    }
}
