package com.aliyun.svideo.base.widget.pagerecyclerview;

/* loaded from: classes.dex */
public class DimensionConvert {
    public static int dip2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(android.content.Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
