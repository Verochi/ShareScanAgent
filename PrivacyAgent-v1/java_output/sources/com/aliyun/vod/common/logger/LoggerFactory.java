package com.aliyun.vod.common.logger;

/* loaded from: classes12.dex */
public class LoggerFactory {
    public static com.aliyun.vod.common.logger.LoggerPrinter getFactory(java.lang.String str, boolean z) {
        com.aliyun.vod.common.logger.LoggerPrinter loggerPrinter = new com.aliyun.vod.common.logger.LoggerPrinter();
        loggerPrinter.init(str);
        com.aliyun.vod.common.logger.LogLevel logLevel = com.aliyun.vod.common.logger.LogLevel.NONE;
        if (z) {
            logLevel = com.aliyun.vod.common.logger.LogLevel.FULL;
        }
        loggerPrinter.getSettings().methodCount(3).logLevel(logLevel);
        return loggerPrinter;
    }
}
