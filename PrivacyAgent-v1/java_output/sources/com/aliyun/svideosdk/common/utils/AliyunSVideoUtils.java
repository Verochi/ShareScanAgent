package com.aliyun.svideosdk.common.utils;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunSVideoUtils {
    private static final java.lang.String MIME_HEIC = "image/heic";
    private static final java.lang.String MIME_HEIF = "image/heif";

    @android.annotation.TargetApi(28)
    public static boolean convertHEIFImage(java.lang.String str, java.lang.String str2, android.graphics.Bitmap.CompressFormat compressFormat, int i) {
        boolean z;
        android.graphics.ImageDecoder.Source createSource;
        android.graphics.Bitmap bitmap = null;
        try {
            createSource = android.graphics.ImageDecoder.createSource(new java.io.File(str));
            bitmap = android.graphics.ImageDecoder.decodeBitmap(createSource);
            z = com.aliyun.common.utils.BitmapUtil.writeBitmap(str2, bitmap, bitmap.getWidth(), bitmap.getHeight(), compressFormat, i);
        } catch (java.lang.Throwable th) {
            try {
                th.printStackTrace();
                z = false;
            } finally {
                if (bitmap != null) {
                    bitmap.recycle();
                }
            }
        }
        return z;
    }

    public static boolean isHEIFImage(java.lang.String str) {
        try {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeFile(str, options);
            java.lang.String str2 = options.outMimeType;
            if (!MIME_HEIC.equalsIgnoreCase(str2.trim())) {
                if (!MIME_HEIF.equalsIgnoreCase(str2.trim())) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
