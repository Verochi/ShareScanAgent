package com.airbnb.lottie.utils;

/* loaded from: classes.dex */
public class Logger {
    public static com.airbnb.lottie.LottieLogger a = new com.airbnb.lottie.utils.LogcatLogger();

    public static void debug(java.lang.String str) {
        a.debug(str);
    }

    public static void debug(java.lang.String str, java.lang.Throwable th) {
        a.debug(str, th);
    }

    public static void error(java.lang.String str, java.lang.Throwable th) {
        a.error(str, th);
    }

    public static void setInstance(com.airbnb.lottie.LottieLogger lottieLogger) {
        a = lottieLogger;
    }

    public static void warning(java.lang.String str) {
        a.warning(str);
    }

    public static void warning(java.lang.String str, java.lang.Throwable th) {
        a.warning(str, th);
    }
}
