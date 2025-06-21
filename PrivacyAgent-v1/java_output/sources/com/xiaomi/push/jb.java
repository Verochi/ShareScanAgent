package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class jb {
    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            return (java.lang.String) com.xiaomi.push.jc.a(null, "android.os.SystemProperties").getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class).invoke(null, str, str2);
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("SystemProperties.get: ".concat(java.lang.String.valueOf(e)));
            return str2;
        }
    }
}
