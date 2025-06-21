package com.aliyun.vod.log.core;

/* loaded from: classes12.dex */
public class AliyunLoggerManager {
    private static java.util.Map<java.lang.String, com.aliyun.vod.log.core.AliyunLogger> mLoggers = new java.util.HashMap();
    private static boolean sLoggerOpen = true;

    public static com.aliyun.vod.log.core.AliyunLogger createLogger(android.content.Context context, java.lang.String str) {
        if (!sLoggerOpen) {
            return null;
        }
        com.aliyun.vod.log.core.AliyunLogger aliyunLogger = mLoggers.get(str);
        if (aliyunLogger != null) {
            return aliyunLogger;
        }
        com.aliyun.vod.log.core.AliyunLogger aliyunLogger2 = new com.aliyun.vod.log.core.AliyunLogger(new com.aliyun.vod.log.core.LogService(str));
        aliyunLogger2.init(context);
        mLoggers.put(str, aliyunLogger2);
        return aliyunLogger2;
    }

    public static void destroyLogger(java.lang.String str) {
        com.aliyun.vod.log.core.AliyunLogger remove = mLoggers.remove(str);
        if (remove != null) {
            remove.destroy();
        }
    }

    public static com.aliyun.vod.log.core.AliyunLogger getLogger(java.lang.String str) {
        if (sLoggerOpen) {
            return mLoggers.get(str);
        }
        return null;
    }

    public static boolean isLoggerOpen() {
        return sLoggerOpen;
    }

    public static void toggleLogger(boolean z) {
        sLoggerOpen = z;
    }
}
