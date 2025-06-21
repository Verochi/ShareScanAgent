package com.google.android.material.textfield;

/* loaded from: classes22.dex */
class CutoutDrawable extends com.google.android.material.shape.MaterialShapeDrawable {

    @androidx.annotation.NonNull
    private final android.graphics.RectF cutoutBounds;

    @androidx.annotation.NonNull
    private final android.graphics.Paint cutoutPaint;
    private int savedLayer;

    public CutoutDrawable() {
        this(null);
    }

    public CutoutDrawable(@androidx.annotation.Nullable com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        super(shapeAppearanceModel == null ? new com.google.android.material.shape.ShapeAppearanceModel() : shapeAppearanceModel);
        this.cutoutPaint = new android.graphics.Paint(1);
        setPaintStyles();
        this.cutoutBounds = new android.graphics.RectF();
    }

    private void postDraw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        if (useHardwareLayer(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.savedLayer);
    }

    private void preDraw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (!useHardwareLayer(callback)) {
            saveCanvasLayer(canvas);
            return;
        }
        android.view.View view = (android.view.View) callback;
        if (view.getLayerType() != 2) {
            view.setLayerType(2, null);
        }
    }

    private void saveCanvasLayer(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        this.savedLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
    }

    private void setPaintStyles() {
        this.cutoutPaint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        this.cutoutPaint.setColor(-1);
        this.cutoutPaint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
    }

    private boolean useHardwareLayer(android.graphics.drawable.Drawable.Callback callback) {
        return callback instanceof android.view.View;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        preDraw(canvas);
        super.draw(canvas);
        canvas.drawRect(this.cutoutBounds, this.cutoutPaint);
        postDraw(canvas);
    }

    public boolean hasCutout() {
        return !this.cutoutBounds.isEmpty();
    }

    public void removeCutout() {
        setCutout(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void setCutout(float f, float f2, float f3, float f4) {
        android.graphics.RectF rectF = this.cutoutBounds;
        if (f == rectF.left && f2 == rectF.top && f3 == rectF.right && f4 == rectF.bottom) {
            return;
        }
        rectF.set(f, f2, f3, f4);
        invalidateSelf();
    }

    public void setCutout(@androidx.annotation.NonNull android.graphics.RectF rectF) {
        setCutout(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
