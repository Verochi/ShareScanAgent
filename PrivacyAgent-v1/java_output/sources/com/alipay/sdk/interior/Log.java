package com.alipay.sdk.interior;

/* loaded from: classes.dex */
public class Log {
    public static long a;

    public interface ISdkLogCallback {
        void onLogLine(java.lang.String str);
    }

    public static boolean forcedLogReport(android.content.Context context) {
        try {
            com.alipay.sdk.m.s.b.d().a(context);
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime() / 1000;
            if (elapsedRealtime - a < 600) {
                return false;
            }
            a = elapsedRealtime;
            com.alipay.sdk.m.k.a.a(context);
            return true;
        } catch (java.lang.Exception e) {
            com.alipay.sdk.m.u.e.a(e);
            return false;
        }
    }

    public static void setupLogCallback(com.alipay.sdk.interior.Log.ISdkLogCallback iSdkLogCallback) {
        com.alipay.sdk.m.u.e.a(iSdkLogCallback);
    }
}
