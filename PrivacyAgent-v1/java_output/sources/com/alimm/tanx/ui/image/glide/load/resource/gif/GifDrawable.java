package com.alimm.tanx.ui.image.glide.load.resource.gif;

/* loaded from: classes.dex */
public class GifDrawable extends com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable implements com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.FrameCallback {
    private boolean applyGravity;
    private final com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder decoder;
    private final android.graphics.Rect destRect;
    private final com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader frameLoader;
    private boolean isRecycled;
    private boolean isRunning;
    private boolean isStarted;
    private boolean isVisible;
    private int loopCount;
    private int maxLoopCount;
    private final android.graphics.Paint paint;
    private final com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable.GifState state;

    public static class GifState extends android.graphics.drawable.Drawable.ConstantState {
        private static final int GRAVITY = 119;
        com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
        com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.BitmapProvider bitmapProvider;
        android.content.Context context;
        byte[] data;
        android.graphics.Bitmap firstFrame;
        com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap> frameTransformation;
        com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader gifHeader;
        int targetHeight;
        int targetWidth;

        public GifState(com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader gifHeader, byte[] bArr, android.content.Context context, com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap> transformation, int i, int i2, com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.BitmapProvider bitmapProvider, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, android.graphics.Bitmap bitmap) {
            if (bitmap == null) {
                throw new java.lang.NullPointerException("The first frame of the GIF must not be null");
            }
            this.gifHeader = gifHeader;
            this.data = bArr;
            this.bitmapPool = bitmapPool;
            this.firstFrame = bitmap;
            this.context = context.getApplicationContext();
            this.frameTransformation = transformation;
            this.targetWidth = i;
            this.targetHeight = i2;
            this.bitmapProvider = bitmapProvider;
        }

        public GifState(com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable.GifState gifState) {
            if (gifState != null) {
                this.gifHeader = gifState.gifHeader;
                this.data = gifState.data;
                this.context = gifState.context;
                this.frameTransformation = gifState.frameTransformation;
                this.targetWidth = gifState.targetWidth;
                this.targetHeight = gifState.targetHeight;
                this.bitmapProvider = gifState.bitmapProvider;
                this.bitmapPool = gifState.bitmapPool;
                this.firstFrame = gifState.firstFrame;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable() {
            return new com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable(android.content.res.Resources resources) {
            return newDrawable();
        }
    }

    public GifDrawable(android.content.Context context, com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.BitmapProvider bitmapProvider, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap> transformation, int i, int i2, com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader gifHeader, byte[] bArr, android.graphics.Bitmap bitmap) {
        this(new com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable.GifState(gifHeader, bArr, context, transformation, i, i2, bitmapProvider, bitmapPool, bitmap));
    }

    public GifDrawable(com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder gifDecoder, com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader gifFrameLoader, android.graphics.Bitmap bitmap, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, android.graphics.Paint paint) {
        this.destRect = new android.graphics.Rect();
        this.isVisible = true;
        this.maxLoopCount = -1;
        this.decoder = gifDecoder;
        this.frameLoader = gifFrameLoader;
        com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable.GifState gifState = new com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable.GifState(null);
        this.state = gifState;
        this.paint = paint;
        gifState.bitmapPool = bitmapPool;
        gifState.firstFrame = bitmap;
    }

    public GifDrawable(com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable.GifState gifState) {
        this.destRect = new android.graphics.Rect();
        this.isVisible = true;
        this.maxLoopCount = -1;
        if (gifState == null) {
            throw new java.lang.NullPointerException("GifState must not be null");
        }
        this.state = gifState;
        com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder gifDecoder = new com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder(gifState.bitmapProvider);
        this.decoder = gifDecoder;
        this.paint = new android.graphics.Paint();
        gifDecoder.setData(gifState.gifHeader, gifState.data);
        com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader gifFrameLoader = new com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader(gifState.context, this, gifDecoder, gifState.targetWidth, gifState.targetHeight);
        this.frameLoader = gifFrameLoader;
        gifFrameLoader.setFrameTransformation(gifState.frameTransformation);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GifDrawable(com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable gifDrawable, android.graphics.Bitmap bitmap, com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap> transformation) {
        this(new com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable.GifState(r12.gifHeader, r12.data, r12.context, transformation, r12.targetWidth, r12.targetHeight, r12.bitmapProvider, r12.bitmapPool, bitmap));
        com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable.GifState gifState = gifDrawable.state;
    }

    private void reset() {
        this.frameLoader.clear();
        invalidateSelf();
    }

    private void resetLoopCount() {
        this.loopCount = 0;
    }

    private void startRunning() {
        if (this.decoder.getFrameCount() == 1) {
            invalidateSelf();
        } else {
            if (this.isRunning) {
                return;
            }
            this.isRunning = true;
            this.frameLoader.start();
            invalidateSelf();
        }
    }

    private void stopRunning() {
        this.isRunning = false;
        this.frameLoader.stop();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        if (this.isRecycled) {
            return;
        }
        if (this.applyGravity) {
            android.view.Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.destRect);
            this.applyGravity = false;
        }
        android.graphics.Bitmap currentFrame = this.frameLoader.getCurrentFrame();
        if (currentFrame == null) {
            currentFrame = this.state.firstFrame;
        }
        canvas.drawBitmap(currentFrame, (android.graphics.Rect) null, this.destRect, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable.ConstantState getConstantState() {
        return this.state;
    }

    public byte[] getData() {
        return this.state.data;
    }

    public com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder getDecoder() {
        return this.decoder;
    }

    public android.graphics.Bitmap getFirstFrame() {
        return this.state.firstFrame;
    }

    public int getFrameCount() {
        return this.decoder.getFrameCount();
    }

    public com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap> getFrameTransformation() {
        return this.state.frameTransformation;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.state.firstFrame.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.state.firstFrame.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable
    public boolean isAnimated() {
        return true;
    }

    public boolean isRecycled() {
        return this.isRecycled;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(android.graphics.Rect rect) {
        super.onBoundsChange(rect);
        this.applyGravity = true;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.FrameCallback
    @android.annotation.TargetApi(11)
    public void onFrameReady(int i) {
        if (getCallback() == null) {
            stop();
            reset();
            return;
        }
        invalidateSelf();
        if (i == this.decoder.getFrameCount() - 1) {
            this.loopCount++;
        }
        int i2 = this.maxLoopCount;
        if (i2 == -1 || this.loopCount < i2) {
            return;
        }
        stop();
    }

    public void recycle() {
        this.isRecycled = true;
        com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable.GifState gifState = this.state;
        gifState.bitmapPool.put(gifState.firstFrame);
        this.frameLoader.clear();
        this.frameLoader.stop();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.paint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    public void setFrameTransformation(com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap> transformation, android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            throw new java.lang.NullPointerException("The first frame of the GIF must not be null");
        }
        if (transformation == null) {
            throw new java.lang.NullPointerException("The frame transformation must not be null");
        }
        com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable.GifState gifState = this.state;
        gifState.frameTransformation = transformation;
        gifState.firstFrame = bitmap;
        this.frameLoader.setFrameTransformation(transformation);
    }

    public void setIsRunning(boolean z) {
        this.isRunning = z;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable
    public void setLoopCount(int i) {
        if (i <= 0 && i != -1 && i != 0) {
            throw new java.lang.IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i != 0) {
            this.maxLoopCount = i;
        } else {
            int totalIterationCount = this.decoder.getTotalIterationCount();
            this.maxLoopCount = totalIterationCount != 0 ? totalIterationCount : -1;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        this.isVisible = z;
        if (!z) {
            stopRunning();
        } else if (this.isStarted) {
            startRunning();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.isStarted = true;
        resetLoopCount();
        if (this.isVisible) {
            startRunning();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.isStarted = false;
        stopRunning();
    }
}
