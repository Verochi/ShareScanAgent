package com.aliyun.vod.common.utils;

/* loaded from: classes12.dex */
public class MySystemParams {
    public static final int SCREEN_ORIENTATION_HORIZONTAL = 2;
    public static final int SCREEN_ORIENTATION_VERTICAL = 1;
    private static com.aliyun.vod.common.utils.MySystemParams params;
    private final java.lang.String TAG = "SystemParams";
    public int densityDpi;
    public float fontScale;
    public float scale;
    public int screenHeight;
    public int screenOrientation;
    public int screenWidth;

    private MySystemParams() {
    }

    public static com.aliyun.vod.common.utils.MySystemParams getInstance() {
        if (params == null) {
            params = new com.aliyun.vod.common.utils.MySystemParams();
        }
        return params;
    }

    public void init(android.content.Context context) {
        android.util.DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        this.screenWidth = i;
        int i2 = displayMetrics.heightPixels;
        this.screenHeight = i2;
        this.densityDpi = displayMetrics.densityDpi;
        this.scale = displayMetrics.density;
        this.fontScale = displayMetrics.scaledDensity;
        if (i2 > i) {
            this.screenOrientation = 1;
        } else {
            this.screenOrientation = 2;
        }
    }
}
