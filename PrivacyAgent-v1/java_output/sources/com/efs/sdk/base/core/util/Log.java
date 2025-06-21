package com.efs.sdk.base.core.util;

/* loaded from: classes22.dex */
public class Log {
    public static void d(java.lang.String str) {
        d("efs.base", str, null);
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        d(str, str2, null);
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().isDebug();
    }

    public static void d(java.lang.String str, java.lang.Throwable th) {
        d("efs.base", str, th);
    }

    public static void e(java.lang.String str) {
        e("efs.base", str, null);
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        e(str, str2, null);
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().isDebug();
    }

    public static void e(java.lang.String str, java.lang.Throwable th) {
        e("efs.base", str, th);
    }

    public static void i(java.lang.String str) {
        i("efs.base", str, null);
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        i(str, str2, null);
    }

    public static void i(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().isDebug();
    }

    public static void i(java.lang.String str, java.lang.Throwable th) {
        i("efs.base", str, th);
    }

    public static void v(java.lang.String str) {
        v("efs.base", str, null);
    }

    public static void v(java.lang.String str, java.lang.String str2) {
        v(str, str2, null);
    }

    public static void v(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().isDebug();
    }

    public static void v(java.lang.String str, java.lang.Throwable th) {
        v("efs.base", str, th);
    }

    public static void w(java.lang.String str) {
        w("efs.base", str, null);
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        w(str, str2, null);
    }

    public static void w(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().isDebug();
    }

    public static void w(java.lang.String str, java.lang.Throwable th) {
        w("efs.base", str, th);
    }
}
