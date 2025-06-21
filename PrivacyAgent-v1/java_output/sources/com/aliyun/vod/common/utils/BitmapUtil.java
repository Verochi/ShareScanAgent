package com.aliyun.vod.common.utils;

/* loaded from: classes12.dex */
public class BitmapUtil {
    private static final java.lang.String TAG = "BitmapUtil";

    public static android.graphics.Bitmap drawableToBitmap(android.graphics.drawable.Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? android.graphics.Bitmap.Config.ARGB_8888 : android.graphics.Bitmap.Config.RGB_565);
        android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    public static boolean writeBitmap(java.lang.String str, android.graphics.Bitmap bitmap, int i, int i2, android.graphics.Bitmap.CompressFormat compressFormat, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setScale(i / width, i2 / height);
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        boolean writeBitmap = writeBitmap(str, createBitmap, compressFormat, i3);
        createBitmap.recycle();
        return writeBitmap;
    }

    public static boolean writeBitmap(java.lang.String str, android.graphics.Bitmap bitmap, android.graphics.Bitmap.CompressFormat compressFormat, int i) {
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(str);
            boolean compress = bitmap.compress(compressFormat, i, fileOutputStream);
            fileOutputStream.close();
            return compress;
        } catch (java.io.FileNotFoundException | java.io.IOException unused) {
            return false;
        }
    }
}
