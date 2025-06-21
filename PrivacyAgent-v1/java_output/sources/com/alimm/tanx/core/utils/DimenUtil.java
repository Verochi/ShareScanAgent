package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class DimenUtil implements com.alimm.tanx.core.utils.NotConfused {
    public static int dp2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float dpToPixel(float f) {
        return f * android.content.res.Resources.getSystem().getDisplayMetrics().density;
    }

    public static float px2dp(android.content.Context context, int i) {
        return (i / context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int sp2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
