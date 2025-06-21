package com.heytap.mcssdk.utils;

/* loaded from: classes22.dex */
public class a {
    private static final java.lang.String a = "file";
    private static final java.lang.String b = "ro.crypto.type";

    private static java.lang.String a(java.lang.String str) {
        try {
            return (java.lang.String) java.lang.Class.forName("android.os.SystemProperties").getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class).invoke(null, str);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static boolean a() {
        return "file".equals(a(b));
    }
}
