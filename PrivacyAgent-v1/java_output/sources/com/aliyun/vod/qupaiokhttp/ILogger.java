package com.aliyun.vod.qupaiokhttp;

/* loaded from: classes12.dex */
public class ILogger {
    protected static boolean DEBUG = false;
    public static final java.lang.String DEFAULT_TAG = "OkHttpFinal";
    private static com.aliyun.vod.common.logger.LoggerPrinter printer;

    private ILogger() {
        printer = com.aliyun.vod.common.logger.LoggerFactory.getFactory("OkHttpFinal", DEBUG);
    }

    public static void clear() {
        createInstance();
        printer.clear();
    }

    private static void createInstance() {
        if (printer == null) {
            new com.aliyun.vod.qupaiokhttp.ILogger();
        }
    }

    public static void d(java.lang.String str, java.lang.Object... objArr) {
        createInstance();
        printer.d(str, objArr);
    }

    public static void e(java.lang.String str, java.lang.Object... objArr) {
        createInstance();
        printer.e(null, str, objArr);
    }

    public static void e(java.lang.Throwable th) {
        createInstance();
        printer.e(th);
    }

    public static void e(java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        createInstance();
        printer.e(th, str, objArr);
    }

    public static com.aliyun.vod.common.logger.Settings getSettings() {
        createInstance();
        return printer.getSettings();
    }

    public static void i(java.lang.String str, java.lang.Object... objArr) {
        createInstance();
        printer.i(str, objArr);
    }

    public static void json(java.lang.String str) {
        createInstance();
        printer.json(str);
    }

    public static com.aliyun.vod.common.logger.Printer t(int i) {
        createInstance();
        return printer.t(null, i);
    }

    public static com.aliyun.vod.common.logger.Printer t(java.lang.String str) {
        createInstance();
        com.aliyun.vod.common.logger.LoggerPrinter loggerPrinter = printer;
        return loggerPrinter.t(str, loggerPrinter.getSettings().getMethodCount());
    }

    public static com.aliyun.vod.common.logger.Printer t(java.lang.String str, int i) {
        createInstance();
        return printer.t(str, i);
    }

    public static void v(java.lang.String str, java.lang.Object... objArr) {
        createInstance();
        printer.v(str, objArr);
    }

    public static void w(java.lang.String str, java.lang.Object... objArr) {
        createInstance();
        printer.w(str, objArr);
    }

    public static void wtf(java.lang.String str, java.lang.Object... objArr) {
        createInstance();
        printer.wtf(str, objArr);
    }

    public static void xml(java.lang.String str) {
        createInstance();
        printer.xml(str);
    }
}
