package com.aliyun.vod.common.logger;

/* loaded from: classes12.dex */
public final class Logger {
    public static final java.lang.String DEFAULT_TAG = "QuLogger";
    private static boolean debug;
    private static com.aliyun.vod.common.logger.LoggerPrinter loggerPrinter;

    public static com.aliyun.vod.common.logger.LoggerPrinter getDefaultLogger() {
        if (loggerPrinter == null) {
            loggerPrinter = com.aliyun.vod.common.logger.LoggerFactory.getFactory("QuLogger", debug);
        }
        return loggerPrinter;
    }

    public static void setDebug(boolean z) {
        debug = z;
    }
}
