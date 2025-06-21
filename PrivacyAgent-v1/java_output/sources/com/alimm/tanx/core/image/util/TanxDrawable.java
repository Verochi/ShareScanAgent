package com.alimm.tanx.core.image.util;

/* loaded from: classes.dex */
public class TanxDrawable extends android.graphics.drawable.Drawable implements com.alimm.tanx.core.utils.NotConfused {
    private final android.graphics.Bitmap bm;
    private final com.alimm.tanx.core.image.util.tanxc_do config;
    private final android.graphics.Paint paint = new android.graphics.Paint(1);
    private final android.graphics.Rect srcRect = new android.graphics.Rect();
    private final android.graphics.Rect distRect = new android.graphics.Rect();

    public TanxDrawable(android.graphics.Bitmap bitmap, com.alimm.tanx.core.image.util.tanxc_do tanxc_doVar) {
        this.bm = transform(bitmap, tanxc_doVar);
        this.config = tanxc_doVar;
    }

    private android.graphics.Bitmap transform(android.graphics.Bitmap bitmap, com.alimm.tanx.core.image.util.tanxc_do tanxc_doVar) {
        if (tanxc_doVar == null || tanxc_doVar.tanxc_if() != com.alimm.tanx.core.image.util.ShapeMode.RECT_ROUND || tanxc_doVar.tanxc_for() <= 0) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(width, height, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
        android.graphics.Paint paint = new android.graphics.Paint();
        paint.setAntiAlias(true);
        android.graphics.Shader.TileMode tileMode = android.graphics.Shader.TileMode.CLAMP;
        paint.setShader(new android.graphics.BitmapShader(bitmap, tileMode, tileMode));
        canvas.drawRoundRect(new android.graphics.RectF(0.0f, 0.0f, width, height), tanxc_doVar.tanxc_for(), tanxc_doVar.tanxc_for(), paint);
        return createBitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        float height;
        float f;
        android.graphics.Rect bounds = getBounds();
        android.graphics.Bitmap bitmap = this.bm;
        if (bitmap == null || bitmap.getHeight() == 0 || this.bm.getWidth() == 0 || bounds == null || bounds.width() <= 0 || bounds.height() <= 0) {
            return;
        }
        com.alimm.tanx.core.image.util.tanxc_do tanxc_doVar = this.config;
        com.alimm.tanx.core.image.util.ScaleMode tanxc_do = tanxc_doVar == null ? com.alimm.tanx.core.image.util.ScaleMode.CENTER_CROP : tanxc_doVar.tanxc_do();
        if (tanxc_do == com.alimm.tanx.core.image.util.ScaleMode.FIT_XY) {
            android.graphics.Rect rect = this.srcRect;
            rect.left = 0;
            rect.top = 0;
            rect.right = this.bm.getWidth();
            this.srcRect.bottom = this.bm.getHeight();
            android.graphics.Rect rect2 = this.distRect;
            rect2.left = 0;
            rect2.top = 0;
            rect2.right = getBounds().width();
            this.distRect.bottom = getBounds().height();
        } else {
            float f2 = 0.0f;
            if (tanxc_do == com.alimm.tanx.core.image.util.ScaleMode.CENTER_CROP) {
                if (this.bm.getWidth() * bounds.height() < bounds.width() * this.bm.getHeight()) {
                    f = (this.bm.getHeight() - (bounds.height() * (this.bm.getWidth() / bounds.width()))) * 0.5f;
                } else {
                    f2 = (this.bm.getWidth() - (bounds.width() * (this.bm.getHeight() / bounds.height()))) * 0.5f;
                    f = 0.0f;
                }
                android.graphics.Rect rect3 = this.srcRect;
                rect3.left = (int) f2;
                rect3.right = (int) (this.bm.getWidth() - f2);
                android.graphics.Rect rect4 = this.srcRect;
                rect4.top = (int) f;
                rect4.bottom = (int) (this.bm.getHeight() - f);
                android.graphics.Rect rect5 = this.distRect;
                rect5.left = 0;
                rect5.top = 0;
                rect5.right = getBounds().right;
                this.distRect.bottom = getBounds().bottom;
            } else {
                if (this.bm.getWidth() * bounds.height() < bounds.width() * this.bm.getHeight()) {
                    f2 = (bounds.width() - (this.bm.getWidth() * (bounds.height() / this.bm.getHeight()))) * 0.5f;
                    height = 0.0f;
                } else {
                    height = (bounds.height() - (this.bm.getHeight() * (bounds.width() / this.bm.getWidth()))) * 0.5f;
                }
                android.graphics.Rect rect6 = this.srcRect;
                rect6.left = 0;
                rect6.top = 0;
                rect6.right = this.bm.getWidth();
                this.srcRect.bottom = this.bm.getHeight();
                android.graphics.Rect rect7 = this.distRect;
                rect7.left = (int) f2;
                rect7.top = (int) height;
                int width = bounds.width();
                android.graphics.Rect rect8 = this.distRect;
                rect7.right = width - rect8.left;
                rect8.bottom = bounds.height() - this.distRect.top;
            }
        }
        canvas.drawBitmap(this.bm, this.srcRect, this.distRect, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@androidx.annotation.Nullable android.graphics.ColorFilter colorFilter) {
    }
}
