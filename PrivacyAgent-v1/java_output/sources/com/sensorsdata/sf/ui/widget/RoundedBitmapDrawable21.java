package com.sensorsdata.sf.ui.widget;

@android.annotation.TargetApi(21)
/* loaded from: classes19.dex */
class RoundedBitmapDrawable21 extends com.sensorsdata.sf.ui.widget.RoundedBitmapDrawable {
    public RoundedBitmapDrawable21(android.content.res.Resources resources, android.graphics.Bitmap bitmap, boolean z) {
        super(resources, bitmap, z);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(android.graphics.Outline outline) {
        updateDstRect();
        outline.setRoundRect(this.mDstRect, getCornerRadius());
    }

    @Override // com.sensorsdata.sf.ui.widget.RoundedBitmapDrawable
    public void gravityCompatApply(int i, int i2, int i3, android.graphics.Rect rect, android.graphics.Rect rect2) {
        android.view.Gravity.apply(i, i2, i3, rect, rect2, 0);
    }

    @Override // com.sensorsdata.sf.ui.widget.RoundedBitmapDrawable
    public boolean hasMipMap() {
        android.graphics.Bitmap bitmap = this.mBitmap;
        return bitmap != null && bitmap.hasMipMap();
    }

    @Override // com.sensorsdata.sf.ui.widget.RoundedBitmapDrawable
    public void setMipMap(boolean z) {
        android.graphics.Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.setHasMipMap(z);
            invalidateSelf();
        }
    }
}
