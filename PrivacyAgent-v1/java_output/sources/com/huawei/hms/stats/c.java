package com.huawei.hms.stats;

/* loaded from: classes22.dex */
public class c {
    public static final java.lang.Object a = new java.lang.Object();
    public static boolean b;
    public static boolean c;

    public static boolean a() {
        synchronized (a) {
            if (!b) {
                try {
                    java.lang.Class.forName("com.huawei.hianalytics.process.HiAnalyticsInstance");
                } catch (java.lang.ClassNotFoundException unused) {
                    com.huawei.hms.support.log.HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HiAnalyticsConfig.");
                }
                b = true;
                com.huawei.hms.support.log.HMSLog.i("HianalyticsExist", "hianalytics exist: " + c);
            }
        }
        return c;
    }
}
