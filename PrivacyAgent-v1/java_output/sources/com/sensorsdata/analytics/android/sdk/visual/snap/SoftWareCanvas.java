package com.sensorsdata.analytics.android.sdk.visual.snap;

/* loaded from: classes19.dex */
public class SoftWareCanvas extends android.graphics.Canvas {
    private static final java.lang.String TAG = "SA.SoftWareCanvas";
    private com.sensorsdata.analytics.android.sdk.util.WeakSet<android.graphics.Bitmap> bitmapWeakSet;
    private android.graphics.Bitmap mBitmap;

    public SoftWareCanvas(android.graphics.Bitmap bitmap) {
        super(bitmap);
        this.bitmapWeakSet = new com.sensorsdata.analytics.android.sdk.util.WeakSet<>();
        this.mBitmap = bitmap;
    }

    private android.graphics.Bitmap drawOnSFCanvas(android.graphics.Bitmap bitmap) {
        android.graphics.Bitmap.Config config;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return bitmap;
        }
        android.graphics.Bitmap.Config config2 = bitmap.getConfig();
        config = android.graphics.Bitmap.Config.HARDWARE;
        if (config2 != config) {
            return bitmap;
        }
        android.graphics.Bitmap copy = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, false);
        this.bitmapWeakSet.add(copy);
        return copy;
    }

    private android.graphics.Paint replaceBitmapShader(android.graphics.Paint paint) {
        android.graphics.Bitmap.Config config;
        if (paint == null) {
            return null;
        }
        if (android.os.Build.VERSION.SDK_INT >= 26 && (paint.getShader() instanceof android.graphics.BitmapShader)) {
            android.graphics.Paint paint2 = new android.graphics.Paint(paint);
            android.graphics.BitmapShader bitmapShader = (android.graphics.BitmapShader) paint2.getShader();
            try {
                java.lang.reflect.Field field = android.graphics.BitmapShader.class.getField("mBitmap");
                field.setAccessible(true);
                android.graphics.Bitmap.Config config2 = ((android.graphics.Bitmap) field.get(bitmapShader)).getConfig();
                config = android.graphics.Bitmap.Config.HARDWARE;
                if (config2 == config) {
                    java.lang.reflect.Field declaredField = android.graphics.BitmapShader.class.getDeclaredField("mTileX");
                    java.lang.reflect.Field declaredField2 = android.graphics.BitmapShader.class.getDeclaredField("mTileY");
                    declaredField.setAccessible(true);
                    declaredField2.setAccessible(true);
                    android.graphics.Bitmap copy = ((android.graphics.Bitmap) field.get(bitmapShader)).copy(android.graphics.Bitmap.Config.ARGB_8888, false);
                    this.bitmapWeakSet.add(copy);
                    java.lang.Class cls = java.lang.Integer.TYPE;
                    java.lang.reflect.Constructor declaredConstructor = android.graphics.BitmapShader.class.getDeclaredConstructor(android.graphics.Bitmap.class, cls, cls);
                    declaredConstructor.setAccessible(true);
                    android.graphics.BitmapShader bitmapShader2 = (android.graphics.BitmapShader) declaredConstructor.newInstance(copy, declaredField.get(bitmapShader), declaredField2.get(bitmapShader));
                    android.graphics.Matrix matrix = new android.graphics.Matrix();
                    paint.getShader().getLocalMatrix(matrix);
                    bitmapShader2.setLocalMatrix(matrix);
                    paint2.setShader(bitmapShader2);
                    return paint2;
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return paint;
    }

    public void destroy() {
        java.util.Iterator<android.graphics.Bitmap> it = this.bitmapWeakSet.iterator();
        while (it.hasNext()) {
            it.next().recycle();
        }
        this.bitmapWeakSet.clear();
    }

    @Override // android.graphics.Canvas
    public void drawArc(android.graphics.RectF rectF, float f, float f2, boolean z, android.graphics.Paint paint) {
        try {
            super.drawArc(rectF, f, f2, z, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(android.graphics.Bitmap bitmap, float f, float f2, android.graphics.Paint paint) {
        android.graphics.Bitmap drawOnSFCanvas = drawOnSFCanvas(bitmap);
        if (drawOnSFCanvas.getDensity() == this.mBitmap.getDensity()) {
            super.drawBitmap(drawOnSFCanvas, f, f2, replaceBitmapShader(paint));
            return;
        }
        int i = (int) f;
        int i2 = (int) f2;
        android.graphics.Rect rect = new android.graphics.Rect(i, i2, drawOnSFCanvas.getWidth() + i, drawOnSFCanvas.getHeight() + i2);
        super.drawBitmap(drawOnSFCanvas, rect, rect, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(android.graphics.Bitmap bitmap, android.graphics.Matrix matrix, android.graphics.Paint paint) {
        try {
            super.drawBitmap(drawOnSFCanvas(bitmap), matrix, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(android.graphics.Bitmap bitmap, android.graphics.Rect rect, android.graphics.Rect rect2, android.graphics.Paint paint) {
        super.drawBitmap(drawOnSFCanvas(bitmap), rect, rect2, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(android.graphics.Bitmap bitmap, android.graphics.Rect rect, android.graphics.RectF rectF, android.graphics.Paint paint) {
        super.drawBitmap(drawOnSFCanvas(bitmap), rect, rectF, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(int[] iArr, int i, int i2, float f, float f2, int i3, int i4, boolean z, android.graphics.Paint paint) {
        try {
            super.drawBitmap(iArr, i, i2, f, f2, i3, i4, z, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z, android.graphics.Paint paint) {
        try {
            super.drawBitmap(iArr, i, i2, i3, i4, i5, i6, z, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawBitmapMesh(android.graphics.Bitmap bitmap, int i, int i2, float[] fArr, int i3, int[] iArr, int i4, android.graphics.Paint paint) {
        super.drawBitmapMesh(drawOnSFCanvas(bitmap), i, i2, fArr, i3, iArr, i4, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawCircle(float f, float f2, float f3, android.graphics.Paint paint) {
        try {
            super.drawCircle(f, f2, f3, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawLine(float f, float f2, float f3, float f4, android.graphics.Paint paint) {
        try {
            super.drawLine(f, f2, f3, f4, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawLines(float[] fArr, int i, int i2, android.graphics.Paint paint) {
        try {
            super.drawLines(fArr, i, i2, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawLines(float[] fArr, android.graphics.Paint paint) {
        try {
            super.drawLines(fArr, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawOval(float f, float f2, float f3, float f4, android.graphics.Paint paint) {
        try {
            super.drawOval(f, f2, f3, f4, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawOval(android.graphics.RectF rectF, android.graphics.Paint paint) {
        try {
            super.drawOval(rectF, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawPaint(android.graphics.Paint paint) {
        try {
            super.drawPaint(replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawPath(android.graphics.Path path, android.graphics.Paint paint) {
        try {
            super.drawPath(path, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawPoint(float f, float f2, android.graphics.Paint paint) {
        try {
            super.drawPoint(f, f2, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] fArr, int i, int i2, android.graphics.Paint paint) {
        try {
            super.drawPoints(fArr, i, i2, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] fArr, android.graphics.Paint paint) {
        try {
            super.drawPoints(fArr, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawPosText(java.lang.String str, float[] fArr, android.graphics.Paint paint) {
        try {
            super.drawPosText(str, fArr, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawPosText(char[] cArr, int i, int i2, float[] fArr, android.graphics.Paint paint) {
        try {
            super.drawPosText(cArr, i, i2, fArr, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawRect(float f, float f2, float f3, float f4, android.graphics.Paint paint) {
        try {
            super.drawRect(f, f2, f3, f4, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawRect(android.graphics.Rect rect, android.graphics.Paint paint) {
        try {
            super.drawRect(rect, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawRect(android.graphics.RectF rectF, android.graphics.Paint paint) {
        try {
            super.drawRect(rectF, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, android.graphics.Paint paint) {
        try {
            super.drawRoundRect(f, f2, f3, f4, f5, f6, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawRoundRect(android.graphics.RectF rectF, float f, float f2, android.graphics.Paint paint) {
        try {
            super.drawRoundRect(rectF, f, f2, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawText(java.lang.CharSequence charSequence, int i, int i2, float f, float f2, android.graphics.Paint paint) {
        try {
            super.drawText(charSequence, i, i2, f, f2, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawText(java.lang.String str, float f, float f2, android.graphics.Paint paint) {
        try {
            super.drawText(str, f, f2, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawText(java.lang.String str, int i, int i2, float f, float f2, android.graphics.Paint paint) {
        try {
            super.drawText(str, i, i2, f, f2, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawText(char[] cArr, int i, int i2, float f, float f2, android.graphics.Paint paint) {
        try {
            super.drawText(cArr, i, i2, f, f2, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(java.lang.String str, android.graphics.Path path, float f, float f2, android.graphics.Paint paint) {
        try {
            super.drawTextOnPath(str, path, f, f2, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(char[] cArr, int i, int i2, android.graphics.Path path, float f, float f2, android.graphics.Paint paint) {
        try {
            super.drawTextOnPath(cArr, i, i2, path, f, f2, replaceBitmapShader(paint));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.graphics.Canvas
    public int saveLayer(float f, float f2, float f3, float f4, android.graphics.Paint paint) {
        return super.saveLayer(f, f2, f3, f4, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public int saveLayer(float f, float f2, float f3, float f4, android.graphics.Paint paint, int i) {
        return super.saveLayer(f, f2, f3, f4, replaceBitmapShader(paint), i);
    }

    @Override // android.graphics.Canvas
    public int saveLayer(android.graphics.RectF rectF, android.graphics.Paint paint) {
        return super.saveLayer(rectF, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public int saveLayer(android.graphics.RectF rectF, android.graphics.Paint paint, int i) {
        return super.saveLayer(rectF, replaceBitmapShader(paint), i);
    }

    @Override // android.graphics.Canvas
    public void setBitmap(android.graphics.Bitmap bitmap) {
        super.setBitmap(drawOnSFCanvas(bitmap));
    }
}
