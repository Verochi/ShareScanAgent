package com.igexin.assist.control.xiaomi;

/* loaded from: classes22.dex */
public class XmSystemUtils {
    public static final java.lang.String KEY_VERSION_CODE = "ro.miui.ui.version.code";
    public static final java.lang.String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final java.lang.String XIAOMI = "Xiaomi".toLowerCase();
    private static java.lang.Boolean isXiaoMi;

    private static java.lang.String getProp(java.lang.String str) {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("getprop ".concat(java.lang.String.valueOf(str))).getInputStream()), 1024);
            try {
                java.lang.String readLine = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
                return readLine;
            } catch (java.lang.Exception unused) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception unused2) {
            bufferedReader = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static boolean isBrandXiaoMi() {
        try {
            java.lang.Boolean bool = isXiaoMi;
            if (bool != null) {
                return bool.booleanValue();
            }
            java.lang.Boolean valueOf = java.lang.Boolean.valueOf(isMIUI());
            isXiaoMi = valueOf;
            return valueOf.booleanValue();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static boolean isMIUI() {
        return (android.text.TextUtils.isEmpty(getProp(KEY_VERSION_MIUI)) && android.text.TextUtils.isEmpty(getProp(KEY_VERSION_CODE))) ? false : true;
    }
}
