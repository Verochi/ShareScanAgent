package com.aliyun.common.utils;

/* loaded from: classes.dex */
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

    public static boolean generateFileFromBitmap(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2) throws java.io.IOException {
        android.graphics.Bitmap.CompressFormat compressFormat;
        if (str == null || bitmap == null) {
            return false;
        }
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            java.io.File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            file.createNewFile();
        }
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG;
        }
        if (str.endsWith(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPG) || str.endsWith(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG) || str2.endsWith(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPG) || str2.endsWith(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG)) {
            compressFormat = android.graphics.Bitmap.CompressFormat.JPEG;
        } else if (str.endsWith(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_PNG) || str2.endsWith(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_PNG)) {
            compressFormat = android.graphics.Bitmap.CompressFormat.PNG;
        } else {
            if (!str.endsWith("webp") && !str2.endsWith("webp")) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("not supported image format for '");
                sb.append(str);
                sb.append("'");
                fileOutputStream.flush();
                fileOutputStream.close();
                if (file.exists()) {
                    file.delete();
                }
                return false;
            }
            compressFormat = android.graphics.Bitmap.CompressFormat.WEBP;
        }
        bitmap.compress(compressFormat, 100, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        return true;
    }

    public static android.graphics.Bitmap rotateBitmap(android.graphics.Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setRotate(f);
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        if (createBitmap.equals(bitmap)) {
            return createBitmap;
        }
        bitmap.recycle();
        return createBitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    public static final android.graphics.Bitmap safeDecodeFile(java.lang.String str, android.graphics.BitmapFactory.Options options) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str = options != null ? android.graphics.BitmapFactory.decodeFile(str, options) : android.graphics.BitmapFactory.decodeFile(str);
            return str;
        } catch (java.lang.Throwable unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("load bmp failed!path[");
            sb.append(str);
            sb.append("]");
            return null;
        }
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
