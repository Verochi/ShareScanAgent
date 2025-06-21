package com.aliyun.svideo.common.utils;

/* loaded from: classes.dex */
public class FastClickUtil {
    private static final int MIN_DELAY_TIME = 500;
    private static final int MIN_DELAY_TIME_ACTIVITY = 800;
    private static final java.lang.String TAG = "FastClickUtil";
    private static java.lang.String sLastActivitySimpleName;
    private static long sLastClickTime;

    public static boolean isFastClick() {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        boolean z = currentTimeMillis - sLastClickTime <= 500;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("log_common_FastClickUtil : ");
        sb.append(currentTimeMillis - sLastClickTime);
        sLastClickTime = currentTimeMillis;
        return z;
    }

    public static boolean isFastClickActivity(@androidx.annotation.NonNull java.lang.String str) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        boolean z = currentTimeMillis - sLastClickTime <= 800;
        sLastClickTime = currentTimeMillis;
        if (str.equals(sLastActivitySimpleName)) {
            return z;
        }
        sLastActivitySimpleName = str;
        return false;
    }
}
