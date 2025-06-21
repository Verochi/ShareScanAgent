package com.aliyun.svideosdk.common.b.c;

/* loaded from: classes12.dex */
public class a {
    private static final java.lang.String a = "com.aliyun.svideosdk.common.b.c.a";

    private boolean a(java.lang.String str, java.lang.String str2, android.graphics.Bitmap bitmap) {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeFile(str, options);
        try {
            boolean generateFileFromBitmap = com.aliyun.common.utils.BitmapUtil.generateFileFromBitmap(bitmap, str2, options.outMimeType);
            if (bitmap != null) {
                bitmap.recycle();
            }
            return generateFileFromBitmap;
        } catch (java.io.IOException unused) {
            if (bitmap == null) {
                return false;
            }
            bitmap.recycle();
            return false;
        } catch (java.lang.Throwable th) {
            if (bitmap != null) {
                bitmap.recycle();
            }
            throw th;
        }
    }

    public android.graphics.Bitmap a(java.lang.String str, int i, int i2, int i3, int i4, int i5, int i6, android.graphics.Bitmap.Config config) {
        int i7;
        float f;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        android.graphics.Canvas canvas = new android.graphics.Canvas();
        float f2 = i3;
        float f3 = (i * 1.0f) / f2;
        float f4 = i4;
        float f5 = (i2 * 1.0f) / f4;
        if (f3 > f5) {
            i7 = (int) (f2 * f5);
            f = f4 * f5;
        } else {
            i7 = (int) (f2 * f3);
            f = f4 * f3;
        }
        int i8 = (int) f;
        options.inSampleSize = (int) (1.0f / java.lang.Math.min(f3, f5));
        android.graphics.Bitmap decodeFile = android.graphics.BitmapFactory.decodeFile(str, options);
        if (decodeFile == null || i7 <= 0 || i8 <= 0) {
            return null;
        }
        android.graphics.Bitmap createScaledBitmap = android.graphics.Bitmap.createScaledBitmap(decodeFile, i7, i8, false);
        if (createScaledBitmap == decodeFile) {
            decodeFile = null;
        }
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(i, i2, config);
        createBitmap.eraseColor(i6);
        canvas.setBitmap(createBitmap);
        canvas.drawBitmap(createScaledBitmap, (i - i7) / 2, (i2 - i8) / 2, (android.graphics.Paint) null);
        if (decodeFile != null) {
            decodeFile.recycle();
        }
        createScaledBitmap.recycle();
        return i5 != 0 ? com.aliyun.common.utils.BitmapUtil.rotateBitmap(createBitmap, i5) : createBitmap;
    }

    public android.graphics.Bitmap a(java.lang.String str, android.graphics.Rect rect, int i, int i2, int i3, android.graphics.Bitmap.Config config) {
        android.graphics.BitmapRegionDecoder bitmapRegionDecoder;
        rect.width();
        rect.height();
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPreferredConfig = config;
        android.graphics.BitmapFactory.decodeFile(str, options);
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (rect.width() <= 0 || rect.height() <= 0) {
            rect.left = 0;
            rect.right = i4;
            rect.top = 0;
            rect.bottom = i5;
        }
        options.inJustDecodeBounds = false;
        android.graphics.Bitmap bitmap = null;
        try {
            bitmapRegionDecoder = android.graphics.BitmapRegionDecoder.newInstance(str, true);
        } catch (java.io.IOException unused) {
            bitmapRegionDecoder = null;
        }
        if (bitmapRegionDecoder != null) {
            android.graphics.Bitmap decodeRegion = bitmapRegionDecoder.decodeRegion(rect, options);
            if (decodeRegion == null) {
                bitmapRegionDecoder.recycle();
                return null;
            }
            android.graphics.Bitmap createScaledBitmap = android.graphics.Bitmap.createScaledBitmap(decodeRegion, i, i2, false);
            if (createScaledBitmap != decodeRegion) {
                decodeRegion.recycle();
            }
            bitmapRegionDecoder.recycle();
            return i3 != 0 ? com.aliyun.common.utils.BitmapUtil.rotateBitmap(createScaledBitmap, i3) : createScaledBitmap;
        }
        android.graphics.Bitmap safeDecodeFile = com.aliyun.common.utils.BitmapUtil.safeDecodeFile(str, options);
        if (safeDecodeFile == null) {
            return null;
        }
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(safeDecodeFile, rect.left, rect.top, rect.width(), rect.height());
        if (createBitmap == safeDecodeFile) {
            safeDecodeFile = null;
        }
        if (createBitmap != null && (bitmap = android.graphics.Bitmap.createScaledBitmap(createBitmap, i, i2, false)) != createBitmap) {
            createBitmap.recycle();
        }
        if (safeDecodeFile != null) {
            safeDecodeFile.recycle();
        }
        return i3 != 0 ? com.aliyun.common.utils.BitmapUtil.rotateBitmap(bitmap, i3) : bitmap;
    }

    public boolean a(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, int i6, android.graphics.Bitmap.Config config) {
        return a(str, str2, a(str, i, i2, i3, i4, i6, i5, config));
    }

    public boolean a(java.lang.String str, java.lang.String str2, android.graphics.Rect rect, int i, int i2, int i3, android.graphics.Bitmap.Config config) {
        return a(str, str2, a(str, rect, i, i2, i3, config));
    }
}
