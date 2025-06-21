package com.autonavi.amap.mapcore.tools;

/* loaded from: classes12.dex */
public class GlMapUtil {
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_1 = 2;
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_1_EAGLE_EYE = 3;
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_2 = 4;
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_2_EAGLE_EYE = 5;
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_3 = 6;
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_3_EAGLE_EYE = 7;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_1 = 3;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_1_EAGLE_EYE = 4;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_2 = 5;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_2_EAGLE_EYE = 6;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_3 = 7;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_3_EAGLE_EYE = 8;
    public static final int AN_ENGINE_ID_EAGLE_EYE = 2;
    public static final int AN_ENGINE_ID_INVALID = -1;
    public static final int AN_ENGINE_ID_MAIN = 1;
    public static final int DEVICE_DISPLAY_DPI_HIGH = 320;
    public static final int DEVICE_DISPLAY_DPI_LOW = 120;
    public static final int DEVICE_DISPLAY_DPI_MEDIAN = 240;
    public static final int DEVICE_DISPLAY_DPI_NORMAL = 160;
    public static final int DEVICE_DISPLAY_DPI_XHIGH = 480;
    public static final int DEVICE_DISPLAY_DPI_XXHIGH = 640;

    public static byte[] decodeAssetResData(android.content.Context context, java.lang.String str) {
        try {
            java.io.InputStream open = context.getAssets().open(str);
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read < 0) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    open.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (java.io.IOException | java.lang.OutOfMemoryError unused) {
            return null;
        }
    }

    public static int dipToPixel(android.content.Context context, int i) {
        if (context == null) {
            return i;
        }
        try {
            return (int) android.util.TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
        } catch (java.lang.Exception unused) {
            return i;
        }
    }

    public static java.lang.String getAppVersionName(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static java.lang.String getString(android.content.Context context, int i) {
        return context.getResources().getString(i);
    }

    public static boolean isAssic(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (c >= 256 || c <= 0) {
                return false;
            }
        }
        return true;
    }

    public static int spToPixel(android.content.Context context, int i) {
        return (int) android.util.TypedValue.applyDimension(2, i, context.getResources().getDisplayMetrics());
    }
}
