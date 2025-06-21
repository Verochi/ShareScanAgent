package com.aliyun.svideo.common.utils;

/* loaded from: classes.dex */
public class BitmapUtils {
    private static java.lang.String TAG = "BitmapUtils";

    public static boolean checkAndAmendImgOrientation(java.lang.String str) {
        int bitmapDegree;
        if (android.text.TextUtils.isEmpty(str) || !new java.io.File(str).exists() || (bitmapDegree = getBitmapDegree(str)) == 0) {
            return false;
        }
        saveBitmap(rotateBitmap(android.graphics.BitmapFactory.decodeFile(str), bitmapDegree), str);
        return true;
    }

    public static int getBitmapDegree(java.lang.String str) {
        try {
            int attributeInt = new android.media.ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (java.io.IOException e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("getBitmapDegree failure msg : ");
            sb.append(e.getMessage());
            return 0;
        }
    }

    public static android.graphics.Bitmap rotateBitmap(android.graphics.Bitmap bitmap, int i) {
        if (i == 0 || bitmap == null) {
            return bitmap;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setRotate(i, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        return createBitmap;
    }

    public static void saveBitmap(android.graphics.Bitmap bitmap, java.lang.String str) {
        if (android.os.Environment.getExternalStorageState().equals("mounted")) {
            try {
                java.io.File file = new java.io.File(str);
                if (file.exists()) {
                    file.delete();
                } else {
                    file.getParentFile().mkdirs();
                }
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
                bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                bitmap.recycle();
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("saveBitmap success: ");
                sb.append(file.getAbsolutePath());
            } catch (java.io.IOException e) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("saveBitmap: ");
                sb2.append(e.getMessage());
                bitmap.recycle();
            }
        }
    }
}
