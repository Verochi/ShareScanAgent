package com.jd.ad.sdk.jad_lo;

/* loaded from: classes23.dex */
public final class jad_hu {
    public static java.lang.String jad_an(java.lang.String str, java.lang.String str2) {
        try {
            return (java.lang.String) java.lang.Class.forName("android.os.SystemProperties").getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class).invoke(null, str, str2);
        } catch (java.lang.Throwable th) {
            com.jd.android.sdk.coreinfo.util.Logger.w("CoreInfo.SystemPropertyUtil", "An exception happends when call get(), key='" + str + "':\n" + th.toString());
            return str2;
        }
    }
}
