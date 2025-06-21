package com.alipay.sdk.m.u;

/* loaded from: classes.dex */
public class b {
    public static final long a = 3000;
    public static long b = -1;

    public static synchronized boolean a() {
        synchronized (com.alipay.sdk.m.u.b.class) {
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            if (elapsedRealtime - b < 3000) {
                return true;
            }
            b = elapsedRealtime;
            return false;
        }
    }
}
