package com.google.android.material.circularreveal;

/* loaded from: classes22.dex */
public class CircularRevealHelper {
    public static final int BITMAP_SHADER = 0;
    public static final int CLIP_PATH = 1;
    private static final boolean DEBUG = false;
    public static final int REVEAL_ANIMATOR = 2;
    public static final int STRATEGY = 2;
    private boolean buildingCircularRevealCache;
    private android.graphics.Paint debugPaint;
    private final com.google.android.material.circularreveal.CircularRevealHelper.Delegate delegate;
    private boolean hasCircularRevealCache;

    @androidx.annotation.Nullable
    private android.graphics.drawable.Drawable overlayDrawable;

    @androidx.annotation.Nullable
    private com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo;

    @androidx.annotation.NonNull
    private final android.graphics.Paint revealPaint;

    @androidx.annotation.NonNull
    private final android.graphics.Path revealPath;

    @androidx.annotation.NonNull
    private final android.graphics.Paint scrimPaint;

    @androidx.annotation.NonNull
    private final android.view.View view;

    public interface Delegate {
        void actualDraw(android.graphics.Canvas canvas);

        boolean actualIsOpaque();
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Strategy {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CircularRevealHelper(com.google.android.material.circularreveal.CircularRevealHelper.Delegate delegate) {
        this.delegate = delegate;
        android.view.View view = (android.view.View) delegate;
        this.view = view;
        view.setWillNotDraw(false);
        this.revealPath = new android.graphics.Path();
        this.revealPaint = new android.graphics.Paint(7);
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.scrimPaint = paint;
        paint.setColor(0);
    }

    private void drawDebugCircle(@androidx.annotation.NonNull android.graphics.Canvas canvas, int i, float f) {
        this.debugPaint.setColor(i);
        this.debugPaint.setStrokeWidth(f);
        com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo = this.revealInfo;
        canvas.drawCircle(revealInfo.centerX, revealInfo.centerY, revealInfo.radius - (f / 2.0f), this.debugPaint);
    }

    private void drawDebugMode(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        this.delegate.actualDraw(canvas);
        if (shouldDrawScrim()) {
            com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo = this.revealInfo;
            canvas.drawCircle(revealInfo.centerX, revealInfo.centerY, revealInfo.radius, this.scrimPaint);
        }
        if (shouldDrawCircularReveal()) {
            drawDebugCircle(canvas, androidx.core.view.ViewCompat.MEASURED_STATE_MASK, 10.0f);
            drawDebugCircle(canvas, androidx.core.internal.view.SupportMenu.CATEGORY_MASK, 5.0f);
        }
        drawOverlayDrawable(canvas);
    }

    private void drawOverlayDrawable(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        if (shouldDrawOverlayDrawable()) {
            android.graphics.Rect bounds = this.overlayDrawable.getBounds();
            float width = this.revealInfo.centerX - (bounds.width() / 2.0f);
            float height = this.revealInfo.centerY - (bounds.height() / 2.0f);
            canvas.translate(width, height);
            this.overlayDrawable.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    private float getDistanceToFurthestCorner(@androidx.annotation.NonNull com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo) {
        return com.google.android.material.math.MathUtils.distanceToFurthestCorner(revealInfo.centerX, revealInfo.centerY, 0.0f, 0.0f, this.view.getWidth(), this.view.getHeight());
    }

    private void invalidateRevealInfo() {
        if (STRATEGY == 1) {
            this.revealPath.rewind();
            com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo = this.revealInfo;
            if (revealInfo != null) {
                this.revealPath.addCircle(revealInfo.centerX, revealInfo.centerY, revealInfo.radius, android.graphics.Path.Direction.CW);
            }
        }
        this.view.invalidate();
    }

    private boolean shouldDrawCircularReveal() {
        com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo = this.revealInfo;
        boolean z = revealInfo == null || revealInfo.isInvalid();
        return STRATEGY == 0 ? !z && this.hasCircularRevealCache : !z;
    }

    private boolean shouldDrawOverlayDrawable() {
        return (this.buildingCircularRevealCache || this.overlayDrawable == null || this.revealInfo == null) ? false : true;
    }

    private boolean shouldDrawScrim() {
        return (this.buildingCircularRevealCache || android.graphics.Color.alpha(this.scrimPaint.getColor()) == 0) ? false : true;
    }

    public void buildCircularRevealCache() {
        if (STRATEGY == 0) {
            this.buildingCircularRevealCache = true;
            this.hasCircularRevealCache = false;
            this.view.buildDrawingCache();
            android.graphics.Bitmap drawingCache = this.view.getDrawingCache();
            if (drawingCache == null && this.view.getWidth() != 0 && this.view.getHeight() != 0) {
                drawingCache = android.graphics.Bitmap.createBitmap(this.view.getWidth(), this.view.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
                this.view.draw(new android.graphics.Canvas(drawingCache));
            }
            if (drawingCache != null) {
                android.graphics.Paint paint = this.revealPaint;
                android.graphics.Shader.TileMode tileMode = android.graphics.Shader.TileMode.CLAMP;
                paint.setShader(new android.graphics.BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.buildingCircularRevealCache = false;
            this.hasCircularRevealCache = true;
        }
    }

    public void destroyCircularRevealCache() {
        if (STRATEGY == 0) {
            this.hasCircularRevealCache = false;
            this.view.destroyDrawingCache();
            this.revealPaint.setShader(null);
            this.view.invalidate();
        }
    }

    public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        if (shouldDrawCircularReveal()) {
            int i = STRATEGY;
            if (i == 0) {
                com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo = this.revealInfo;
                canvas.drawCircle(revealInfo.centerX, revealInfo.centerY, revealInfo.radius, this.revealPaint);
                if (shouldDrawScrim()) {
                    com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
                    canvas.drawCircle(revealInfo2.centerX, revealInfo2.centerY, revealInfo2.radius, this.scrimPaint);
                }
            } else if (i == 1) {
                int save = canvas.save();
                canvas.clipPath(this.revealPath);
                this.delegate.actualDraw(canvas);
                if (shouldDrawScrim()) {
                    canvas.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
                }
                canvas.restoreToCount(save);
            } else {
                if (i != 2) {
                    throw new java.lang.IllegalStateException("Unsupported strategy " + i);
                }
                this.delegate.actualDraw(canvas);
                if (shouldDrawScrim()) {
                    canvas.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
                }
            }
        } else {
            this.delegate.actualDraw(canvas);
            if (shouldDrawScrim()) {
                canvas.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
            }
        }
        drawOverlayDrawable(canvas);
    }

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getCircularRevealOverlayDrawable() {
        return this.overlayDrawable;
    }

    @androidx.annotation.ColorInt
    public int getCircularRevealScrimColor() {
        return this.scrimPaint.getColor();
    }

    @androidx.annotation.Nullable
    public com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo getRevealInfo() {
        com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo = this.revealInfo;
        if (revealInfo == null) {
            return null;
        }
        com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo2 = new com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo(revealInfo);
        if (revealInfo2.isInvalid()) {
            revealInfo2.radius = getDistanceToFurthestCorner(revealInfo2);
        }
        return revealInfo2;
    }

    public boolean isOpaque() {
        return this.delegate.actualIsOpaque() && !shouldDrawCircularReveal();
    }

    public void setCircularRevealOverlayDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.overlayDrawable = drawable;
        this.view.invalidate();
    }

    public void setCircularRevealScrimColor(@androidx.annotation.ColorInt int i) {
        this.scrimPaint.setColor(i);
        this.view.invalidate();
    }

    public void setRevealInfo(@androidx.annotation.Nullable com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo) {
        if (revealInfo == null) {
            this.revealInfo = null;
        } else {
            com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
            if (revealInfo2 == null) {
                this.revealInfo = new com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo(revealInfo);
            } else {
                revealInfo2.set(revealInfo);
            }
            if (com.google.android.material.math.MathUtils.geq(revealInfo.radius, getDistanceToFurthestCorner(revealInfo), 1.0E-4f)) {
                this.revealInfo.radius = Float.MAX_VALUE;
            }
        }
        invalidateRevealInfo();
    }
}
