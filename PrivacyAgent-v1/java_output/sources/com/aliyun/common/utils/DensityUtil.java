package com.aliyun.common.utils;

/* loaded from: classes.dex */
public class DensityUtil {
    public static int dip2px(float f) {
        return (int) ((f * com.aliyun.common.utils.MySystemParams.getInstance().scale) + 0.5f);
    }

    public static int dip2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getActualScreenHeight() {
        com.aliyun.common.utils.MySystemParams mySystemParams = com.aliyun.common.utils.MySystemParams.getInstance();
        return mySystemParams.screenOrientation == 2 ? mySystemParams.screenWidth : mySystemParams.screenHeight;
    }

    public static int getActualScreenWidth() {
        com.aliyun.common.utils.MySystemParams mySystemParams = com.aliyun.common.utils.MySystemParams.getInstance();
        return mySystemParams.screenOrientation == 2 ? mySystemParams.screenHeight : mySystemParams.screenWidth;
    }

    public static int px2dip(float f) {
        return (int) ((f / com.aliyun.common.utils.MySystemParams.getInstance().scale) + 0.5f);
    }

    public static int px2dip(android.content.Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int sp2px(float f) {
        return (int) ((f * com.aliyun.common.utils.MySystemParams.getInstance().fontScale) + 0.5f);
    }

    public static int sp2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
