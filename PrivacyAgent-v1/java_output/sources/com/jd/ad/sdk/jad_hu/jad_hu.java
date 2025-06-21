package com.jd.ad.sdk.jad_hu;

/* loaded from: classes23.dex */
public class jad_hu {
    public static android.graphics.Bitmap jad_an(android.graphics.Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postScale(i / width, i2 / height);
        return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}
