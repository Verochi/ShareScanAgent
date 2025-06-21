package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class GlideBitmapDrawable extends com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable {
    private boolean applyGravity;
    private final android.graphics.Rect destRect;
    private int height;
    private boolean mutated;
    private com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawable.BitmapState state;
    private int width;

    public static class BitmapState extends android.graphics.drawable.Drawable.ConstantState {
        private static final android.graphics.Paint DEFAULT_PAINT = new android.graphics.Paint(6);
        private static final int DEFAULT_PAINT_FLAGS = 6;
        private static final int GRAVITY = 119;
        final android.graphics.Bitmap bitmap;
        android.graphics.Paint paint;
        int targetDensity;

        public BitmapState(android.graphics.Bitmap bitmap) {
            this.paint = DEFAULT_PAINT;
            this.bitmap = bitmap;
        }

        public BitmapState(com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawable.BitmapState bitmapState) {
            this(bitmapState.bitmap);
            this.targetDensity = bitmapState.targetDensity;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public void mutatePaint() {
            if (DEFAULT_PAINT == this.paint) {
                this.paint = new android.graphics.Paint(6);
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable() {
            return new com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawable((android.content.res.Resources) null, this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable(android.content.res.Resources resources) {
            return new com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawable(resources, this);
        }

        public void setAlpha(int i) {
            mutatePaint();
            this.paint.setAlpha(i);
        }

        public void setColorFilter(android.graphics.ColorFilter colorFilter) {
            mutatePaint();
            this.paint.setColorFilter(colorFilter);
        }
    }

    public GlideBitmapDrawable(android.content.res.Resources resources, android.graphics.Bitmap bitmap) {
        this(resources, new com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawable.BitmapState(bitmap));
    }

    public GlideBitmapDrawable(android.content.res.Resources resources, com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawable.BitmapState bitmapState) {
        int i;
        this.destRect = new android.graphics.Rect();
        if (bitmapState == null) {
            throw new java.lang.NullPointerException("BitmapState must not be null");
        }
        this.state = bitmapState;
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
            i = i == 0 ? com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL : i;
            bitmapState.targetDensity = i;
        } else {
            i = bitmapState.targetDensity;
        }
        this.width = bitmapState.bitmap.getScaledWidth(i);
        this.height = bitmapState.bitmap.getScaledHeight(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        if (this.applyGravity) {
            android.view.Gravity.apply(119, this.width, this.height, getBounds(), this.destRect);
            this.applyGravity = false;
        }
        com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawable.BitmapState bitmapState = this.state;
        canvas.drawBitmap(bitmapState.bitmap, (android.graphics.Rect) null, this.destRect, bitmapState.paint);
    }

    public android.graphics.Bitmap getBitmap() {
        return this.state.bitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable.ConstantState getConstantState() {
        return this.state;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.height;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.width;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        android.graphics.Bitmap bitmap = this.state.bitmap;
        return (bitmap == null || bitmap.hasAlpha() || this.state.paint.getAlpha() < 255) ? -3 : -1;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable
    public boolean isAnimated() {
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable mutate() {
        if (!this.mutated && super.mutate() == this) {
            this.state = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawable.BitmapState(this.state);
            this.mutated = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(android.graphics.Rect rect) {
        super.onBoundsChange(rect);
        this.applyGravity = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.state.paint.getAlpha() != i) {
            this.state.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        this.state.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable
    public void setLoopCount(int i) {
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
    }
}
