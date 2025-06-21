package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class cc {
    private static android.graphics.Paint a = new android.graphics.Paint();
    private static android.graphics.Rect b = new android.graphics.Rect();

    public static float a(int i, boolean z) {
        if (z) {
            if (i != 1) {
                return i != 2 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }
        if (i != 8) {
            return i != 16 ? 0.5f : 1.0f;
        }
        return 0.0f;
    }

    public static com.amap.api.maps.model.MarkerOptions a(com.amap.api.maps.model.TextOptions textOptions) {
        if (textOptions == null) {
            return null;
        }
        com.amap.api.maps.model.MarkerOptions markerOptions = new com.amap.api.maps.model.MarkerOptions();
        markerOptions.position(textOptions.getPosition());
        markerOptions.visible(textOptions.isVisible());
        markerOptions.zIndex(textOptions.getZIndex());
        markerOptions.rotateAngle(textOptions.getRotate());
        markerOptions.icon(b(textOptions));
        markerOptions.anchor(a(textOptions.getAlignX(), true), a(textOptions.getAlignY(), false));
        return markerOptions;
    }

    public static com.amap.api.maps.model.BitmapDescriptor b(com.amap.api.maps.model.TextOptions textOptions) {
        if (textOptions == null) {
            return null;
        }
        a.setTypeface(textOptions.getTypeface());
        a.setSubpixelText(true);
        a.setAntiAlias(true);
        a.setStrokeWidth(5.0f);
        a.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        a.setTextSize(textOptions.getFontSize());
        a.setTextAlign(android.graphics.Paint.Align.CENTER);
        a.setColor(textOptions.getFontColor());
        android.graphics.Paint.FontMetrics fontMetrics = a.getFontMetrics();
        int i = (int) (fontMetrics.descent - fontMetrics.ascent);
        int i2 = (int) (((i - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        if (textOptions.getText() != null) {
            a.getTextBounds(textOptions.getText(), 0, textOptions.getText().length(), b);
        }
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(b.width() + 6, i, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
        canvas.drawColor(textOptions.getBackgroundColor());
        if (textOptions.getText() != null) {
            canvas.drawText(textOptions.getText(), b.centerX() + 3, i2, a);
        }
        return com.amap.api.maps.model.BitmapDescriptorFactory.fromBitmap(createBitmap);
    }
}
