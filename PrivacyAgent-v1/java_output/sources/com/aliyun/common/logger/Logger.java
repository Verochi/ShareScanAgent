package com.aliyun.common.logger;

/* loaded from: classes.dex */
public final class Logger {
    public static final java.lang.String DEFAULT_TAG = "QuLogger";
    private static boolean debug;
    private static com.aliyun.common.logger.LoggerPrinter loggerPrinter;

    public static com.aliyun.common.logger.LoggerPrinter getDefaultLogger() {
        if (loggerPrinter == null) {
            loggerPrinter = com.aliyun.common.logger.LoggerFactory.getFactory("QuLogger", debug);
        }
        return loggerPrinter;
    }

    public static void setDebug(boolean z) {
        debug = z;
    }
}
