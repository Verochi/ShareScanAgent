package com.bumptech.glide.load.resource.gif;

/* loaded from: classes.dex */
class GifFrameLoader {
    private final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private final java.util.List<com.bumptech.glide.load.resource.gif.GifFrameLoader.FrameCallback> callbacks;
    private com.bumptech.glide.load.resource.gif.GifFrameLoader.DelayTarget current;
    private android.graphics.Bitmap firstFrame;
    private int firstFrameSize;
    private final com.bumptech.glide.gifdecoder.GifDecoder gifDecoder;
    private final android.os.Handler handler;
    private int height;
    private boolean isCleared;
    private boolean isLoadPending;
    private boolean isRunning;
    private com.bumptech.glide.load.resource.gif.GifFrameLoader.DelayTarget next;

    @androidx.annotation.Nullable
    private com.bumptech.glide.load.resource.gif.GifFrameLoader.OnEveryFrameListener onEveryFrameListener;
    private com.bumptech.glide.load.resource.gif.GifFrameLoader.DelayTarget pendingTarget;
    private com.bumptech.glide.RequestBuilder<android.graphics.Bitmap> requestBuilder;
    final com.bumptech.glide.RequestManager requestManager;
    private boolean startFromFirstFrame;
    private com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation;
    private int width;

    @androidx.annotation.VisibleForTesting
    public static class DelayTarget extends com.bumptech.glide.request.target.CustomTarget<android.graphics.Bitmap> {
        private final android.os.Handler handler;
        final int index;
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

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
            this.resource = null;
        }

        public void onResourceReady(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, @androidx.annotation.Nullable com.bumptech.glide.request.transition.Transition<? super android.graphics.Bitmap> transition) {
            this.resource = bitmap;
            this.handler.sendMessageAtTime(this.handler.obtainMessage(1, this), this.targetTime);
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(@androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.Nullable com.bumptech.glide.request.transition.Transition transition) {
            onResourceReady((android.graphics.Bitmap) obj, (com.bumptech.glide.request.transition.Transition<? super android.graphics.Bitmap>) transition);
        }
    }

    public interface FrameCallback {
        void onFrameReady();
    }

    public class FrameLoaderCallback implements android.os.Handler.Callback {
        static final int MSG_CLEAR = 2;
        static final int MSG_DELAY = 1;

        public FrameLoaderCallback() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 1) {
                com.bumptech.glide.load.resource.gif.GifFrameLoader.this.onFrameReady((com.bumptech.glide.load.resource.gif.GifFrameLoader.DelayTarget) message.obj);
                return true;
            }
            if (i != 2) {
                return false;
            }
            com.bumptech.glide.load.resource.gif.GifFrameLoader.this.requestManager.clear((com.bumptech.glide.load.resource.gif.GifFrameLoader.DelayTarget) message.obj);
            return false;
        }
    }

    @androidx.annotation.VisibleForTesting
    public interface OnEveryFrameListener {
        void onFrameReady();
    }

    public GifFrameLoader(com.bumptech.glide.Glide glide, com.bumptech.glide.gifdecoder.GifDecoder gifDecoder, int i, int i2, com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation, android.graphics.Bitmap bitmap) {
        this(glide.getBitmapPool(), com.bumptech.glide.Glide.with(glide.getContext()), gifDecoder, null, getRequestBuilder(com.bumptech.glide.Glide.with(glide.getContext()), i, i2), transformation, bitmap);
    }

    public GifFrameLoader(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.RequestManager requestManager, com.bumptech.glide.gifdecoder.GifDecoder gifDecoder, android.os.Handler handler, com.bumptech.glide.RequestBuilder<android.graphics.Bitmap> requestBuilder, com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation, android.graphics.Bitmap bitmap) {
        this.callbacks = new java.util.ArrayList();
        this.requestManager = requestManager;
        handler = handler == null ? new android.os.Handler(android.os.Looper.getMainLooper(), new com.bumptech.glide.load.resource.gif.GifFrameLoader.FrameLoaderCallback()) : handler;
        this.bitmapPool = bitmapPool;
        this.handler = handler;
        this.requestBuilder = requestBuilder;
        this.gifDecoder = gifDecoder;
        setFrameTransformation(transformation, bitmap);
    }

    private static com.bumptech.glide.load.Key getFrameSignature() {
        return new com.bumptech.glide.signature.ObjectKey(java.lang.Double.valueOf(java.lang.Math.random()));
    }

    private static com.bumptech.glide.RequestBuilder<android.graphics.Bitmap> getRequestBuilder(com.bumptech.glide.RequestManager requestManager, int i, int i2) {
        return requestManager.asBitmap().apply((com.bumptech.glide.request.BaseRequestOptions<?>) com.bumptech.glide.request.RequestOptions.diskCacheStrategyOf(com.bumptech.glide.load.engine.DiskCacheStrategy.NONE).useAnimationPool(true).skipMemoryCache(true).override(i, i2));
    }

    private void loadNextFrame() {
        if (!this.isRunning || this.isLoadPending) {
            return;
        }
        if (this.startFromFirstFrame) {
            com.bumptech.glide.util.Preconditions.checkArgument(this.pendingTarget == null, "Pending target must be null when starting from the first frame");
            this.gifDecoder.resetFrameIndex();
            this.startFromFirstFrame = false;
        }
        com.bumptech.glide.load.resource.gif.GifFrameLoader.DelayTarget delayTarget = this.pendingTarget;
        if (delayTarget != null) {
            this.pendingTarget = null;
            onFrameReady(delayTarget);
            return;
        }
        this.isLoadPending = true;
        long uptimeMillis = android.os.SystemClock.uptimeMillis() + this.gifDecoder.getNextDelay();
        this.gifDecoder.advance();
        this.next = new com.bumptech.glide.load.resource.gif.GifFrameLoader.DelayTarget(this.handler, this.gifDecoder.getCurrentFrameIndex(), uptimeMillis);
        this.requestBuilder.apply((com.bumptech.glide.request.BaseRequestOptions<?>) com.bumptech.glide.request.RequestOptions.signatureOf(getFrameSignature())).load((java.lang.Object) this.gifDecoder).into((com.bumptech.glide.RequestBuilder<android.graphics.Bitmap>) this.next);
    }

    private void recycleFirstFrame() {
        android.graphics.Bitmap bitmap = this.firstFrame;
        if (bitmap != null) {
            this.bitmapPool.put(bitmap);
            this.firstFrame = null;
        }
    }

    private void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.isCleared = false;
        loadNextFrame();
    }

    private void stop() {
        this.isRunning = false;
    }

    public void clear() {
        this.callbacks.clear();
        recycleFirstFrame();
        stop();
        com.bumptech.glide.load.resource.gif.GifFrameLoader.DelayTarget delayTarget = this.current;
        if (delayTarget != null) {
            this.requestManager.clear(delayTarget);
            this.current = null;
        }
        com.bumptech.glide.load.resource.gif.GifFrameLoader.DelayTarget delayTarget2 = this.next;
        if (delayTarget2 != null) {
            this.requestManager.clear(delayTarget2);
            this.next = null;
        }
        com.bumptech.glide.load.resource.gif.GifFrameLoader.DelayTarget delayTarget3 = this.pendingTarget;
        if (delayTarget3 != null) {
            this.requestManager.clear(delayTarget3);
            this.pendingTarget = null;
        }
        this.gifDecoder.clear();
        this.isCleared = true;
    }

    public java.nio.ByteBuffer getBuffer() {
        return this.gifDecoder.getData().asReadOnlyBuffer();
    }

    public android.graphics.Bitmap getCurrentFrame() {
        com.bumptech.glide.load.resource.gif.GifFrameLoader.DelayTarget delayTarget = this.current;
        return delayTarget != null ? delayTarget.getResource() : this.firstFrame;
    }

    public int getCurrentIndex() {
        com.bumptech.glide.load.resource.gif.GifFrameLoader.DelayTarget delayTarget = this.current;
        if (delayTarget != null) {
            return delayTarget.index;
        }
        return -1;
    }

    public android.graphics.Bitmap getFirstFrame() {
        return this.firstFrame;
    }

    public int getFrameCount() {
        return this.gifDecoder.getFrameCount();
    }

    public com.bumptech.glide.load.Transformation<android.graphics.Bitmap> getFrameTransformation() {
        return this.transformation;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLoopCount() {
        return this.gifDecoder.getTotalIterationCount();
    }

    public int getSize() {
        return this.gifDecoder.getByteSize() + this.firstFrameSize;
    }

    public int getWidth() {
        return this.width;
    }

    @androidx.annotation.VisibleForTesting
    public void onFrameReady(com.bumptech.glide.load.resource.gif.GifFrameLoader.DelayTarget delayTarget) {
        com.bumptech.glide.load.resource.gif.GifFrameLoader.OnEveryFrameListener onEveryFrameListener = this.onEveryFrameListener;
        if (onEveryFrameListener != null) {
            onEveryFrameListener.onFrameReady();
        }
        this.isLoadPending = false;
        if (this.isCleared) {
            this.handler.obtainMessage(2, delayTarget).sendToTarget();
            return;
        }
        if (!this.isRunning) {
            this.pendingTarget = delayTarget;
            return;
        }
        if (delayTarget.getResource() != null) {
            recycleFirstFrame();
            com.bumptech.glide.load.resource.gif.GifFrameLoader.DelayTarget delayTarget2 = this.current;
            this.current = delayTarget;
            for (int size = this.callbacks.size() - 1; size >= 0; size--) {
                this.callbacks.get(size).onFrameReady();
            }
            if (delayTarget2 != null) {
                this.handler.obtainMessage(2, delayTarget2).sendToTarget();
            }
        }
        loadNextFrame();
    }

    public void setFrameTransformation(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation, android.graphics.Bitmap bitmap) {
        this.transformation = (com.bumptech.glide.load.Transformation) com.bumptech.glide.util.Preconditions.checkNotNull(transformation);
        this.firstFrame = (android.graphics.Bitmap) com.bumptech.glide.util.Preconditions.checkNotNull(bitmap);
        this.requestBuilder = this.requestBuilder.apply((com.bumptech.glide.request.BaseRequestOptions<?>) new com.bumptech.glide.request.RequestOptions().transform(transformation));
        this.firstFrameSize = com.bumptech.glide.util.Util.getBitmapByteSize(bitmap);
        this.width = bitmap.getWidth();
        this.height = bitmap.getHeight();
    }

    public void setNextStartFromFirstFrame() {
        com.bumptech.glide.util.Preconditions.checkArgument(!this.isRunning, "Can't restart a running animation");
        this.startFromFirstFrame = true;
        com.bumptech.glide.load.resource.gif.GifFrameLoader.DelayTarget delayTarget = this.pendingTarget;
        if (delayTarget != null) {
            this.requestManager.clear(delayTarget);
            this.pendingTarget = null;
        }
    }

    @androidx.annotation.VisibleForTesting
    public void setOnEveryFrameReadyListener(@androidx.annotation.Nullable com.bumptech.glide.load.resource.gif.GifFrameLoader.OnEveryFrameListener onEveryFrameListener) {
        this.onEveryFrameListener = onEveryFrameListener;
    }

    public void subscribe(com.bumptech.glide.load.resource.gif.GifFrameLoader.FrameCallback frameCallback) {
        if (this.isCleared) {
            throw new java.lang.IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.callbacks.contains(frameCallback)) {
            throw new java.lang.IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean isEmpty = this.callbacks.isEmpty();
        this.callbacks.add(frameCallback);
        if (isEmpty) {
            start();
        }
    }

    public void unsubscribe(com.bumptech.glide.load.resource.gif.GifFrameLoader.FrameCallback frameCallback) {
        this.callbacks.remove(frameCallback);
        if (this.callbacks.isEmpty()) {
            stop();
        }
    }
}
