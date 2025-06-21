package com.airbnb.lottie.utils;

/* loaded from: classes.dex */
public class LogcatLogger implements com.airbnb.lottie.LottieLogger {
    public static final java.util.Set<java.lang.String> a = new java.util.HashSet();

    @Override // com.airbnb.lottie.LottieLogger
    public void debug(java.lang.String str) {
        debug(str, null);
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void debug(java.lang.String str, java.lang.Throwable th) {
        boolean z = com.airbnb.lottie.L.DBG;
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void error(java.lang.String str, java.lang.Throwable th) {
        boolean z = com.airbnb.lottie.L.DBG;
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void warning(java.lang.String str) {
        warning(str, null);
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void warning(java.lang.String str, java.lang.Throwable th) {
        java.util.Set<java.lang.String> set = a;
        if (set.contains(str)) {
            return;
        }
        set.add(str);
    }
}
