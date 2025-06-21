package com.sensorsdata.sf.core.utils;

/* loaded from: classes19.dex */
public class Utils {
    public static final java.lang.String SENSORS_FOCUS_LOCAL = "sensors_focus_local_plans.json";
    public static final java.lang.String SENSORS_FOCUS_REMOTE_PLANS = "sensors_focus_remote_plans.json";

    public static void deleteFile(java.io.File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    file.delete();
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            }
        }
    }

    public static java.lang.String getJsonFromAssets(java.lang.String str, android.content.Context context) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(context.getAssets().open(str)));
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
        } catch (java.io.IOException e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
        return sb.toString();
    }

    public static android.graphics.Bitmap getRoundedCornerBitmap(android.graphics.Bitmap bitmap, float f) {
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
        android.graphics.Paint paint = new android.graphics.Paint();
        android.graphics.Rect rect = new android.graphics.Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        android.graphics.RectF rectF = new android.graphics.RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static java.lang.String loadJsonFromFile(java.io.File file) {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(fileInputStream));
            while (true) {
                try {
                    java.lang.String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(bufferedReader);
                        com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(fileInputStream);
                        return sb.toString();
                    }
                    sb.append(readLine);
                } catch (java.lang.Throwable th) {
                    com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(bufferedReader);
                    com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(fileInputStream);
                    throw th;
                }
            }
        } catch (java.io.IOException unused) {
            return null;
        }
    }

    public static void saveJsonToFile(java.lang.String str, java.io.File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            java.io.OutputStreamWriter outputStreamWriter = new java.io.OutputStreamWriter(new java.io.FileOutputStream(file), "utf-8");
            java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(outputStreamWriter);
            try {
                bufferedWriter.write(str);
                com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(bufferedWriter);
                com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(outputStreamWriter);
            } catch (java.lang.Throwable th) {
                com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(bufferedWriter);
                com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(outputStreamWriter);
                throw th;
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public static void setPlaceholderBackground(android.view.View view, android.content.Context context) {
        android.graphics.Bitmap placeholderImage;
        try {
            int placeholderResourceId = com.sensorsdata.sf.core.SFContextManger.getInstance().getSFConfigOptions().getPlaceholderResourceId();
            if (placeholderResourceId != -1) {
                placeholderImage = android.graphics.BitmapFactory.decodeResource(context.getResources(), placeholderResourceId);
            } else {
                placeholderImage = com.sensorsdata.sf.core.SFContextManger.getInstance().getSFConfigOptions().getPlaceholderImage();
                if (placeholderImage == null) {
                    placeholderImage = android.graphics.BitmapFactory.decodeResource(context.getResources(), com.sensorsdata.sf.android.sdk.R.drawable.sensors_focus_loading_image);
                }
            }
            setViewBackground(placeholderImage, view, context);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public static void setViewBackground(android.graphics.Bitmap bitmap, android.view.View view, android.content.Context context) {
        if (bitmap == null || view == null || context == null) {
            return;
        }
        try {
            byte[] ninePatchChunk = bitmap.getNinePatchChunk();
            view.setBackground(android.graphics.NinePatch.isNinePatchChunk(ninePatchChunk) ? new android.graphics.drawable.NinePatchDrawable(context.getResources(), bitmap, ninePatchChunk, new android.graphics.Rect(), null) : new android.graphics.drawable.BitmapDrawable(context.getResources(), bitmap));
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public static byte[] streamToBytes(java.io.InputStream inputStream) throws java.io.IOException, java.lang.OutOfMemoryError {
        byte[] bArr = new byte[1024];
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                try {
                    break;
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            }
        }
        inputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static java.lang.String toHex(int i, int i2) {
        java.lang.String upperCase = java.lang.Integer.toHexString(i).toUpperCase();
        if (upperCase.length() >= i2) {
            return upperCase.length() > i2 ? upperCase.substring(upperCase.length() - i2) : upperCase;
        }
        while (upperCase.length() < i2) {
            upperCase = "0" + upperCase;
        }
        return upperCase;
    }
}
