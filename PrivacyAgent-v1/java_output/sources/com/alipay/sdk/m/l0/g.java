package com.alipay.sdk.m.l0;

/* loaded from: classes.dex */
public class g {
    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            return (java.lang.String) cls.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class).invoke(cls, str, str2);
        } catch (java.lang.Exception unused) {
            return str2;
        }
    }
}
