package com.alimm.tanx.ui.image.glide.load.resource.gif;

/* loaded from: classes.dex */
class GifFrameLoader {
    private final com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.FrameCallback callback;
    private com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.DelayTarget current;
    private final com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder gifDecoder;
    private final android.os.Handler handler;
    private boolean isCleared;
    private boolean isLoadPending;
    private boolean isRunning;
    private com.alimm.tanx.ui.image.glide.GenericRequestBuilder<com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder, com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder, android.graphics.Bitmap, android.graphics.Bitmap> requestBuilder;

    public static class DelayTarget extends com.alimm.tanx.ui.image.glide.request.target.SimpleTarget<android.graphics.Bitmap> {
        private final android.os.Handler handler;
        private final int index;
        private android.graphics.Bitmap resource;
        private final long targetTime;

        public DelayTarget(android.os.Handler handler, int i, long j) {
            this.handler = handler;
            this.index = i;
            this.targetTime = j;
        }

        public android.graphics.Bitmap getResource() {
            return this.resource;
        }

        public void onResourceReady(android.graphics.Bitmap bitmap, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<? super android.graphics.Bitmap> glideAnimation) {
            this.resource = bitmap;
            this.handler.sendMessageAtTime(this.handler.obtainMessage(1, this), this.targetTime);
        }

        @Override // com.alimm.tanx.ui.image.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(java.lang.Object obj, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation glideAnimation) {
            onResourceReady((android.graphics.Bitmap) obj, (com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<? super android.graphics.Bitmap>) glideAnimation);
        }
    }

    public interface FrameCallback {
        void onFrameReady(int i);
    }

    public class FrameLoaderCallback implements android.os.Handler.Callback {
        public static final int MSG_CLEAR = 2;
        public static final int MSG_DELAY = 1;

        private FrameLoaderCallback() {
        }

        public /* synthetic */ FrameLoaderCallback(com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.AnonymousClass1 anonymousClass1) {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 1) {
                com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.this.onFrameReady((com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.DelayTarget) message.obj);
                return true;
            }
            if (i != 2) {
                return false;
            }
            com.alimm.tanx.ui.image.glide.Glide.clear((com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.DelayTarget) message.obj);
            return false;
        }
    }

    public static class FrameSignature implements com.alimm.tanx.ui.image.glide.load.Key {
        private final java.util.UUID uuid;

        public FrameSignature() {
            this(java.util.UUID.randomUUID());
        }

        public FrameSignature(java.util.UUID uuid) {
            this.uuid = uuid;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.Key
        public boolean equals(java.lang.Object obj) {
            if (obj instanceof com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.FrameSignature) {
                return ((com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.FrameSignature) obj).uuid.equals(this.uuid);
            }
            return false;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.Key
        public int hashCode() {
            return this.uuid.hashCode();
        }

        @Override // com.alimm.tanx.ui.image.glide.load.Key
        public void updateDiskCacheKey(java.security.MessageDigest messageDigest) throws java.io.UnsupportedEncodingException {
            throw new java.lang.UnsupportedOperationException("Not implemented");
        }
    }

    public GifFrameLoader(android.content.Context context, com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.FrameCallback frameCallback, com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder gifDecoder, int i, int i2) {
        this(frameCallback, gifDecoder, null, getRequestBuilder(context, gifDecoder, i, i2, com.alimm.tanx.ui.image.glide.Glide.get(context).getBitmapPool()));
    }

    public GifFrameLoader(com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.FrameCallback frameCallback, com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder gifDecoder, android.os.Handler handler, com.alimm.tanx.ui.image.glide.GenericRequestBuilder<com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder, com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder, android.graphics.Bitmap, android.graphics.Bitmap> genericRequestBuilder) {
        this.isRunning = false;
        this.isLoadPending = false;
        handler = handler == null ? new android.os.Handler(android.os.Looper.getMainLooper(), new com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.FrameLoaderCallback(null)) : handler;
        this.callback = frameCallback;
        this.gifDecoder = gifDecoder;
        this.handler = handler;
        this.requestBuilder = genericRequestBuilder;
    }

    private static com.alimm.tanx.ui.image.glide.GenericRequestBuilder<com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder, com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder, android.graphics.Bitmap, android.graphics.Bitmap> getRequestBuilder(android.content.Context context, com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder gifDecoder, int i, int i2, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameResourceDecoder gifFrameResourceDecoder = new com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameResourceDecoder(bitmapPool);
        com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameModelLoader gifFrameModelLoader = new com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameModelLoader();
        return com.alimm.tanx.ui.image.glide.Glide.with(context).using(gifFrameModelLoader, com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.class).load(gifDecoder).as(android.graphics.Bitmap.class).sourceEncoder(com.alimm.tanx.ui.image.glide.load.resource.NullEncoder.get()).decoder(gifFrameResourceDecoder).skipMemoryCache(true).diskCacheStrategy(com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy.NONE).override(i, i2);
    }

    private void loadNextFrame() {
        if (!this.isRunning || this.isLoadPending) {
            return;
        }
        this.isLoadPending = true;
        long uptimeMillis = android.os.SystemClock.uptimeMillis() + this.gifDecoder.getNextDelay();
        this.gifDecoder.advance();
        this.requestBuilder.signature(new com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.FrameSignature()).into((com.alimm.tanx.ui.image.glide.GenericRequestBuilder<com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder, com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder, android.graphics.Bitmap, android.graphics.Bitmap>) new com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.DelayTarget(this.handler, this.gifDecoder.getCurrentFrameIndex(), uptimeMillis));
    }

    public void clear() {
        stop();
        com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.DelayTarget delayTarget = this.current;
        if (delayTarget != null) {
            com.alimm.tanx.ui.image.glide.Glide.clear(delayTarget);
            this.current = null;
        }
        this.isCleared = true;
    }

    public android.graphics.Bitmap getCurrentFrame() {
        com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.DelayTarget delayTarget = this.current;
        if (delayTarget != null) {
            return delayTarget.getResource();
        }
        return null;
    }

    public void onFrameReady(com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.DelayTarget delayTarget) {
        if (this.isCleared) {
            this.handler.obtainMessage(2, delayTarget).sendToTarget();
            return;
        }
        com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.DelayTarget delayTarget2 = this.current;
        this.current = delayTarget;
        this.callback.onFrameReady(delayTarget.index);
        if (delayTarget2 != null) {
            this.handler.obtainMessage(2, delayTarget2).sendToTarget();
        }
        this.isLoadPending = false;
        loadNextFrame();
    }

    public void setFrameTransformation(com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap> transformation) {
        if (transformation == null) {
            throw new java.lang.NullPointerException("Transformation must not be null");
        }
        this.requestBuilder = this.requestBuilder.transform(transformation);
    }

    public void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.isCleared = false;
        loadNextFrame();
    }

    public void stop() {
        this.isRunning = false;
    }
}
