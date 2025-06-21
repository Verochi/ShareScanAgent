package com.airbnb.lottie;

/* loaded from: classes.dex */
public interface LottieLogger {
    void debug(java.lang.String str);

    void debug(java.lang.String str, java.lang.Throwable th);

    void error(java.lang.String str, java.lang.Throwable th);

    void warning(java.lang.String str);

    void warning(java.lang.String str, java.lang.Throwable th);
}
