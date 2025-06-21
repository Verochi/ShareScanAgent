package com.aliyun.svideo.common.utils;

/* loaded from: classes.dex */
public class DensityUtils {
    public static int dip2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(android.content.Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int sp2px(android.content.Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
