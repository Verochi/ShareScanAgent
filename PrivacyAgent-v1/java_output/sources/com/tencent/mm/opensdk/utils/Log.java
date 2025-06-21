package com.tencent.mm.opensdk.utils;

/* loaded from: classes19.dex */
public class Log {
    private static com.tencent.mm.opensdk.utils.ILog logImpl;

    public static void d(java.lang.String str, java.lang.String str2) {
        com.tencent.mm.opensdk.utils.ILog iLog = logImpl;
        if (iLog == null) {
            return;
        }
        iLog.d(str, str2);
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        com.tencent.mm.opensdk.utils.ILog iLog = logImpl;
        if (iLog == null) {
            return;
        }
        iLog.e(str, str2);
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        com.tencent.mm.opensdk.utils.ILog iLog = logImpl;
        if (iLog == null) {
            return;
        }
        iLog.i(str, str2);
    }

    public static void setLogImpl(com.tencent.mm.opensdk.utils.ILog iLog) {
        logImpl = iLog;
    }

    public static void v(java.lang.String str, java.lang.String str2) {
        com.tencent.mm.opensdk.utils.ILog iLog = logImpl;
        if (iLog == null) {
            return;
        }
        iLog.v(str, str2);
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        com.tencent.mm.opensdk.utils.ILog iLog = logImpl;
        if (iLog == null) {
            return;
        }
        iLog.w(str, str2);
    }
}
