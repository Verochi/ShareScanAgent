package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class Logger {
    private static boolean sDisablePushLog;
    private static com.xiaomi.channel.commonutils.logger.LoggerInterface sUserLogger;

    public static void disablePushFileLog(android.content.Context context) {
        sDisablePushLog = true;
        setPushLog(context);
    }

    public static void enablePushFileLog(android.content.Context context) {
        sDisablePushLog = false;
        setPushLog(context);
    }

    @java.lang.Deprecated
    public static java.io.File getLogFile(java.lang.String str) {
        return null;
    }

    public static com.xiaomi.channel.commonutils.logger.LoggerInterface getUserLogger() {
        return sUserLogger;
    }

    private static boolean hasWritePermission(android.content.Context context) {
        try {
            java.lang.String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (java.lang.String str : strArr) {
                    if (com.anythink.china.common.d.b.equals(str)) {
                        return true;
                    }
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return false;
    }

    public static void setLogger(android.content.Context context, com.xiaomi.channel.commonutils.logger.LoggerInterface loggerInterface) {
        sUserLogger = loggerInterface;
        setPushLog(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (hasWritePermission(r4) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void setPushLog(android.content.Context context) {
        boolean z = true;
        boolean z2 = false;
        boolean z3 = sUserLogger != null;
        if (!sDisablePushLog) {
            z2 = z3;
        }
        z = false;
        com.xiaomi.channel.commonutils.logger.b.a(new com.xiaomi.push.cj(z2 ? sUserLogger : null, z ? com.xiaomi.push.ck.a(context) : null));
    }

    @java.lang.Deprecated
    public static void uploadLogFile(android.content.Context context, boolean z) {
    }
}
