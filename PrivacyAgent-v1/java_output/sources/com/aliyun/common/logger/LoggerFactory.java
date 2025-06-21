package com.aliyun.common.logger;

/* loaded from: classes.dex */
public class LoggerFactory {
    public static com.aliyun.common.logger.LoggerPrinter getFactory(java.lang.String str, boolean z) {
        com.aliyun.common.logger.LoggerPrinter loggerPrinter = new com.aliyun.common.logger.LoggerPrinter();
        loggerPrinter.init(str);
        com.aliyun.common.logger.LogLevel logLevel = com.aliyun.common.logger.LogLevel.NONE;
        if (z) {
            logLevel = com.aliyun.common.logger.LogLevel.FULL;
        }
        loggerPrinter.getSettings().methodCount(3).logLevel(logLevel);
        return loggerPrinter;
    }
}
