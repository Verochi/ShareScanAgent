package com.aliyun.svideo.base.utils;

/* loaded from: classes.dex */
public class FastClickUtil {
    public static final int MIN_DELAY_TIME = 500;
    private static long lastClickTime;
    private static long lastNoRecordClickTime;

    public static boolean isFastClick() {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        boolean z = currentTimeMillis - lastClickTime < 500;
        lastClickTime = currentTimeMillis;
        lastNoRecordClickTime = currentTimeMillis;
        return z;
    }

    public static boolean isRecordWithOtherClick() {
        lastClickTime = java.lang.System.currentTimeMillis();
        return false;
    }
}
