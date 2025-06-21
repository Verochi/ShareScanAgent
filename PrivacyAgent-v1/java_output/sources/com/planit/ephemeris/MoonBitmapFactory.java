package com.planit.ephemeris;

/* loaded from: classes19.dex */
public class MoonBitmapFactory {
    public static android.graphics.Bitmap getMoonBitmap(android.content.Context context, int i, float f, float f2, float f3) {
        android.graphics.Bitmap bitmap = ((android.graphics.drawable.BitmapDrawable) context.getResources().getDrawable(i, context.getTheme())).getBitmap();
        android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        android.graphics.Paint paint = new android.graphics.Paint(1);
        paint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        paint.setColor(5066061);
        paint.setAlpha(220);
        android.graphics.Paint paint2 = new android.graphics.Paint(1);
        paint2.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(displayMetrics, width, height, bitmap.getConfig());
        android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
        float f4 = width;
        float f5 = f4 * f;
        float f6 = f4 / 2.0f;
        float f7 = height / 2.0f;
        paint.setMaskFilter(new android.graphics.BlurMaskFilter(f4 * 0.01f, android.graphics.BlurMaskFilter.Blur.NORMAL));
        canvas.rotate(f3, f6, f7);
        canvas.drawBitmap(bitmap, new android.graphics.Rect(0, 0, width, height), new android.graphics.Rect(0, 0, createBitmap.getWidth(), createBitmap.getHeight()), paint2);
        float abs = (float) (f5 * java.lang.Math.abs(java.lang.Math.cos(java.lang.Math.toRadians(f2))));
        android.graphics.Path path = new android.graphics.Path();
        if (f2 < 0.0f || f2 > 180.0f) {
            float f8 = f6 - f5;
            float f9 = f7 - f5;
            float f10 = f6 + f5;
            float f11 = f5 + f7;
            path.addArc(new android.graphics.RectF(f8, f9, f10, f11), 270.0f, 180.0f);
            if (f2 <= 270.0f) {
                path.addArc(new android.graphics.RectF(f6 - abs, f9, abs + f6, f11), 90.0f, 180.0f);
            } else {
                path.addArc(new android.graphics.RectF(f6 - abs, f9, abs + f6, f11), 90.0f, -180.0f);
            }
        } else {
            float f12 = f6 - f5;
            float f13 = f7 - f5;
            float f14 = f6 + f5;
            float f15 = f5 + f7;
            path.addArc(new android.graphics.RectF(f12, f13, f14, f15), 90.0f, 180.0f);
            if (f2 <= 90.0f) {
                path.addArc(new android.graphics.RectF(f6 - abs, f13, abs + f6, f15), 270.0f, -180.0f);
            } else {
                path.addArc(new android.graphics.RectF(f6 - abs, f13, abs + f6, f15), 270.0f, 180.0f);
            }
        }
        path.close();
        canvas.drawPath(path, paint);
        canvas.rotate(-f3, f6, f7);
        return createBitmap;
    }
}
