package com.aliyun.svideo.base.widget;

/* loaded from: classes.dex */
public class CircularImageDrawable extends android.graphics.drawable.Drawable {
    private android.graphics.Bitmap _Bitmap;
    private final android.graphics.Matrix _Matrix;
    private final android.graphics.Paint _Paint;

    public CircularImageDrawable() {
        android.graphics.Paint paint = new android.graphics.Paint();
        this._Paint = paint;
        this._Matrix = new android.graphics.Matrix();
        paint.setAntiAlias(true);
    }

    private void createShader(android.graphics.Bitmap bitmap) {
        android.graphics.Paint paint = this._Paint;
        android.graphics.Shader.TileMode tileMode = android.graphics.Shader.TileMode.CLAMP;
        paint.setShader(new android.graphics.BitmapShader(bitmap, tileMode, tileMode));
        updateShaderMatrix(getBounds());
    }

    private void updateShaderMatrix(android.graphics.Rect rect) {
        android.graphics.BitmapShader bitmapShader = (android.graphics.BitmapShader) this._Paint.getShader();
        if (bitmapShader == null) {
            return;
        }
        float width = rect.width();
        float height = rect.height();
        float min = java.lang.Math.min(width / this._Bitmap.getWidth(), height / this._Bitmap.getHeight());
        this._Matrix.setScale(min, min);
        this._Matrix.postTranslate((width / 2.0f) - ((this._Bitmap.getWidth() * min) / 2.0f), (height / 2.0f) - ((this._Bitmap.getHeight() * min) / 2.0f));
        bitmapShader.setLocalMatrix(this._Matrix);
        this._Paint.setShader(bitmapShader);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        if (this._Bitmap == null) {
            return;
        }
        android.graphics.Rect bounds = getBounds();
        float width = bounds.width() / 2.0f;
        float height = bounds.height() / 2.0f;
        canvas.drawCircle(width, height, java.lang.Math.min(width, height), this._Paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        android.graphics.Bitmap bitmap = this._Bitmap;
        if (bitmap == null) {
            return -1;
        }
        return bitmap.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        android.graphics.Bitmap bitmap = this._Bitmap;
        if (bitmap == null) {
            return -1;
        }
        return bitmap.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(android.graphics.Rect rect) {
        updateShaderMatrix(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    public void setBitmap(android.graphics.Bitmap bitmap) {
        this._Bitmap = bitmap;
        if (bitmap == null) {
            this._Paint.setShader(null);
        } else {
            createShader(bitmap);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
    }
}
