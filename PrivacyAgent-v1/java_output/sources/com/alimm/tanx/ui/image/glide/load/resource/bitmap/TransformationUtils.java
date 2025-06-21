package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public final class TransformationUtils {
    public static final int PAINT_FLAGS = 6;
    private static final java.lang.String TAG = "TransformationUtils";

    private TransformationUtils() {
    }

    public static android.graphics.Bitmap centerCrop(android.graphics.Bitmap bitmap, android.graphics.Bitmap bitmap2, int i, int i2) {
        float width;
        float height;
        if (bitmap2 == null) {
            return null;
        }
        if (bitmap2.getWidth() == i && bitmap2.getHeight() == i2) {
            return bitmap2;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        float f = 0.0f;
        if (bitmap2.getWidth() * i2 > bitmap2.getHeight() * i) {
            width = i2 / bitmap2.getHeight();
            f = (i - (bitmap2.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i / bitmap2.getWidth();
            height = (i2 - (bitmap2.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f + 0.5f), (int) (height + 0.5f));
        if (bitmap == null) {
            bitmap = android.graphics.Bitmap.createBitmap(i, i2, bitmap2.getConfig() != null ? bitmap2.getConfig() : android.graphics.Bitmap.Config.ARGB_8888);
        }
        setAlpha(bitmap2, bitmap);
        new android.graphics.Canvas(bitmap).drawBitmap(bitmap2, matrix, new android.graphics.Paint(6));
        return bitmap;
    }

    public static android.graphics.Bitmap fitCenter(android.graphics.Bitmap bitmap, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        float min = java.lang.Math.min(i / bitmap.getWidth(), i2 / bitmap.getHeight());
        int width = (int) (bitmap.getWidth() * min);
        int height = (int) (bitmap.getHeight() * min);
        if (bitmap.getWidth() == width && bitmap.getHeight() == height) {
            return bitmap;
        }
        android.graphics.Bitmap.Config config = bitmap.getConfig() != null ? bitmap.getConfig() : android.graphics.Bitmap.Config.ARGB_8888;
        android.graphics.Bitmap bitmap2 = bitmapPool.get(width, height, config);
        if (bitmap2 == null) {
            bitmap2 = android.graphics.Bitmap.createBitmap(width, height, config);
        }
        setAlpha(bitmap, bitmap2);
        if (android.util.Log.isLoggable(TAG, 2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("request: ");
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("toFit:   ");
            sb2.append(bitmap.getWidth());
            sb2.append("x");
            sb2.append(bitmap.getHeight());
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append("toReuse: ");
            sb3.append(bitmap2.getWidth());
            sb3.append("x");
            sb3.append(bitmap2.getHeight());
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
            sb4.append("minPct:   ");
            sb4.append(min);
        }
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmap2);
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setScale(min, min);
        canvas.drawBitmap(bitmap, matrix, new android.graphics.Paint(6));
        return bitmap2;
    }

    public static int getExifOrientationDegrees(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    @android.annotation.TargetApi(5)
    @java.lang.Deprecated
    public static int getOrientation(java.lang.String str) {
        try {
            return getExifOrientationDegrees(new android.media.ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0));
        } catch (java.lang.Exception unused) {
            if (android.util.Log.isLoggable(TAG, 6)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Unable to get orientation for image with path=");
                sb.append(str);
            }
            return 0;
        }
    }

    private static android.graphics.Bitmap.Config getSafeConfig(android.graphics.Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : android.graphics.Bitmap.Config.ARGB_8888;
    }

    public static void initializeMatrixForRotation(int i, android.graphics.Matrix matrix) {
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
    }

    @java.lang.Deprecated
    public static android.graphics.Bitmap orientImage(java.lang.String str, android.graphics.Bitmap bitmap) {
        return rotateImage(bitmap, getOrientation(str));
    }

    public static android.graphics.Bitmap rotateImage(android.graphics.Bitmap bitmap, int i) {
        if (i == 0) {
            return bitmap;
        }
        try {
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.setRotate(i);
            return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (java.lang.Exception unused) {
            return bitmap;
        }
    }

    public static android.graphics.Bitmap rotateImageExif(android.graphics.Bitmap bitmap, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, int i) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        initializeMatrixForRotation(i, matrix);
        if (matrix.isIdentity()) {
            return bitmap;
        }
        android.graphics.RectF rectF = new android.graphics.RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        int round = java.lang.Math.round(rectF.width());
        int round2 = java.lang.Math.round(rectF.height());
        android.graphics.Bitmap.Config config = bitmap.getConfig() != null ? bitmap.getConfig() : android.graphics.Bitmap.Config.ARGB_8888;
        android.graphics.Bitmap bitmap2 = bitmapPool.get(round, round2, config);
        if (bitmap2 == null) {
            bitmap2 = android.graphics.Bitmap.createBitmap(round, round2, config);
        }
        matrix.postTranslate(-rectF.left, -rectF.top);
        new android.graphics.Canvas(bitmap2).drawBitmap(bitmap, matrix, new android.graphics.Paint(6));
        return bitmap2;
    }

    @android.annotation.TargetApi(12)
    public static void setAlpha(android.graphics.Bitmap bitmap, android.graphics.Bitmap bitmap2) {
        if (bitmap2 != null) {
            bitmap2.setHasAlpha(bitmap.hasAlpha());
        }
    }
}
