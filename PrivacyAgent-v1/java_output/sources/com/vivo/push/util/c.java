package com.vivo.push.util;

/* loaded from: classes19.dex */
public final class c {
    public static android.graphics.Bitmap a(android.graphics.Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = i / width;
        float f2 = i2 / height;
        try {
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.postScale(f, f2);
            return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (java.lang.Exception unused) {
            return bitmap;
        }
    }
}
