package com.anythink.expressad.foundation.h;

/* loaded from: classes12.dex */
public final class n {
    public static android.graphics.Bitmap a(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            if (bitmap.isRecycled()) {
                return null;
            }
            int width = bitmap.getWidth();
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(width, width, android.graphics.Bitmap.Config.ARGB_4444);
            android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
            android.graphics.Paint paint = new android.graphics.Paint();
            paint.setAntiAlias(true);
            canvas.drawCircle(width / 2, width / 2, width / 2, paint);
            paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return createBitmap;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static android.graphics.Bitmap a(android.graphics.Bitmap bitmap, int i) {
        if (i == 0) {
            return bitmap;
        }
        android.graphics.Bitmap bitmap2 = null;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            bitmap2 = android.graphics.Bitmap.createBitmap(width, height, android.graphics.Bitmap.Config.ARGB_4444);
            android.graphics.Canvas canvas = new android.graphics.Canvas(bitmap2);
            android.graphics.Paint paint = new android.graphics.Paint();
            android.graphics.Rect rect = new android.graphics.Rect(0, 0, width, height);
            android.graphics.RectF rectF = new android.graphics.RectF(rect);
            float f = i;
            paint.setAntiAlias(true);
            paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_OVER));
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawRoundRect(rectF, f, f, paint);
            paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
            return bitmap2;
        } catch (java.lang.Error | java.lang.Exception unused) {
            return bitmap2;
        }
    }

    @android.annotation.TargetApi(17)
    private static android.graphics.Bitmap b(android.graphics.Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_4444);
                    android.renderscript.RenderScript create = android.renderscript.RenderScript.create(com.anythink.core.common.b.o.a().f());
                    android.renderscript.ScriptIntrinsicBlur create2 = android.renderscript.ScriptIntrinsicBlur.create(create, android.renderscript.Element.U8_4(create));
                    android.renderscript.Allocation createFromBitmap = android.renderscript.Allocation.createFromBitmap(create, bitmap);
                    android.renderscript.Allocation createFromBitmap2 = android.renderscript.Allocation.createFromBitmap(create, createBitmap);
                    create2.setRadius(25.0f);
                    create2.setInput(createFromBitmap);
                    create2.forEach(createFromBitmap2);
                    createFromBitmap2.copyTo(createBitmap);
                    create.destroy();
                    return createBitmap;
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return null;
    }
}
