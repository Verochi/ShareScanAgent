package com.anythink.expressad.foundation.g.d;

/* loaded from: classes12.dex */
public final class a {
    private static int a(android.graphics.BitmapFactory.Options options, int i, int i2) {
        int min;
        double d = options.outWidth;
        double d2 = options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) java.lang.Math.ceil(java.lang.Math.sqrt((d * d2) / i2));
        if (i == -1) {
            min = 128;
        } else {
            double d3 = i;
            min = (int) java.lang.Math.min(java.lang.Math.floor(d / d3), java.lang.Math.floor(d2 / d3));
        }
        if (min < ceil) {
            return ceil;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        return i == -1 ? ceil : min;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000f  */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static android.graphics.Bitmap a(android.content.Context context, int i) {
        android.graphics.Bitmap bitmap;
        try {
            bitmap = android.graphics.BitmapFactory.decodeResource(context.getResources(), i);
        } catch (java.lang.Exception unused) {
            bitmap = null;
            if (bitmap == null) {
            }
        } catch (java.lang.OutOfMemoryError unused2) {
            java.lang.System.gc();
            bitmap = null;
            if (bitmap == null) {
            }
        }
        return bitmap == null ? android.graphics.Bitmap.createBitmap(1, 1, android.graphics.Bitmap.Config.ALPHA_8) : bitmap;
    }

    public static android.graphics.Bitmap a(java.lang.String str) {
        android.graphics.Bitmap bitmap = null;
        if (!com.anythink.expressad.foundation.h.m.a(str)) {
            return null;
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        try {
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeFile(str, options);
            options.inJustDecodeBounds = false;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inDither = true;
            return android.graphics.BitmapFactory.decodeFile(str, options);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        } catch (java.lang.OutOfMemoryError e2) {
            e2.printStackTrace();
            java.lang.System.gc();
            com.anythink.expressad.foundation.g.d.b.a();
            try {
                options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
                bitmap = android.graphics.BitmapFactory.decodeFile(str, options);
                options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
                return bitmap;
            } catch (java.lang.OutOfMemoryError e3) {
                e3.printStackTrace();
                return bitmap;
            }
        }
    }

    @android.annotation.SuppressLint({"NewApi"})
    private static android.graphics.drawable.Drawable a(android.content.res.Resources resources, android.graphics.Bitmap bitmap) {
        return new android.graphics.drawable.BitmapDrawable(resources, bitmap);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0041: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:35:0x0041 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.io.InputStream a(android.graphics.Bitmap bitmap) {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream2;
        java.io.ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            try {
                byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                try {
                    bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    try {
                        byteArrayOutputStream.close();
                    } catch (java.lang.Exception e) {
                        if (com.anythink.expressad.a.a) {
                            e.printStackTrace();
                        }
                    }
                    return byteArrayInputStream;
                } catch (java.lang.Exception e2) {
                    e = e2;
                    if (com.anythink.expressad.a.a) {
                        e.printStackTrace();
                    }
                    if (byteArrayOutputStream == null) {
                        return null;
                    }
                    try {
                        byteArrayOutputStream.close();
                        return null;
                    } catch (java.lang.Exception e3) {
                        if (!com.anythink.expressad.a.a) {
                            return null;
                        }
                        e3.printStackTrace();
                        return null;
                    }
                }
            } catch (java.lang.Throwable th) {
                th = th;
                byteArrayOutputStream3 = byteArrayOutputStream2;
                if (byteArrayOutputStream3 != null) {
                    try {
                        byteArrayOutputStream3.close();
                    } catch (java.lang.Exception e4) {
                        if (com.anythink.expressad.a.a) {
                            e4.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e5) {
            e = e5;
            byteArrayOutputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (byteArrayOutputStream3 != null) {
            }
            throw th;
        }
    }

    private static android.graphics.Bitmap b(android.graphics.Bitmap bitmap) {
        float f;
        float f2;
        float f3;
        float f4;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            f4 = width / 2;
            f3 = width;
            f = 0.0f;
            f2 = f3;
        } else {
            f = (width - height) / 2;
            f2 = height;
            f3 = width - f;
            width = height;
            f4 = height / 2;
        }
        try {
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(width, width, android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
            android.graphics.Paint paint = new android.graphics.Paint();
            int i = (int) f2;
            android.graphics.Rect rect = new android.graphics.Rect((int) f, 0, (int) f3, i);
            android.graphics.Rect rect2 = new android.graphics.Rect(0, 0, i, i);
            android.graphics.RectF rectF = new android.graphics.RectF(rect2);
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawRoundRect(rectF, f4, f4, paint);
            paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect2, paint);
            return createBitmap;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
