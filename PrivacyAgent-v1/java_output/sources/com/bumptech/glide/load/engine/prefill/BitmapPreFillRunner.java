package com.bumptech.glide.load.engine.prefill;

/* loaded from: classes.dex */
final class BitmapPreFillRunner implements java.lang.Runnable {
    static final int BACKOFF_RATIO = 4;
    static final long INITIAL_BACKOFF_MS = 40;
    static final long MAX_DURATION_MS = 32;

    @androidx.annotation.VisibleForTesting
    static final java.lang.String TAG = "PreFillRunner";
    private final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private final com.bumptech.glide.load.engine.prefill.BitmapPreFillRunner.Clock clock;
    private long currentDelay;
    private final android.os.Handler handler;
    private boolean isCancelled;
    private final com.bumptech.glide.load.engine.cache.MemoryCache memoryCache;
    private final java.util.Set<com.bumptech.glide.load.engine.prefill.PreFillType> seenTypes;
    private final com.bumptech.glide.load.engine.prefill.PreFillQueue toPrefill;
    private static final com.bumptech.glide.load.engine.prefill.BitmapPreFillRunner.Clock DEFAULT_CLOCK = new com.bumptech.glide.load.engine.prefill.BitmapPreFillRunner.Clock();
    static final long MAX_BACKOFF_MS = java.util.concurrent.TimeUnit.SECONDS.toMillis(1);

    @androidx.annotation.VisibleForTesting
    public static class Clock {
        public long now() {
            return android.os.SystemClock.currentThreadTimeMillis();
        }
    }

    public static final class UniqueKey implements com.bumptech.glide.load.Key {
        @Override // com.bumptech.glide.load.Key
        public void updateDiskCacheKey(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public BitmapPreFillRunner(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.engine.cache.MemoryCache memoryCache, com.bumptech.glide.load.engine.prefill.PreFillQueue preFillQueue) {
        this(bitmapPool, memoryCache, preFillQueue, DEFAULT_CLOCK, new android.os.Handler(android.os.Looper.getMainLooper()));
    }

    @androidx.annotation.VisibleForTesting
    public BitmapPreFillRunner(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.engine.cache.MemoryCache memoryCache, com.bumptech.glide.load.engine.prefill.PreFillQueue preFillQueue, com.bumptech.glide.load.engine.prefill.BitmapPreFillRunner.Clock clock, android.os.Handler handler) {
        this.seenTypes = new java.util.HashSet();
        this.currentDelay = INITIAL_BACKOFF_MS;
        this.bitmapPool = bitmapPool;
        this.memoryCache = memoryCache;
        this.toPrefill = preFillQueue;
        this.clock = clock;
        this.handler = handler;
    }

    private long getFreeMemoryCacheBytes() {
        return this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize();
    }

    private long getNextDelay() {
        long j = this.currentDelay;
        this.currentDelay = java.lang.Math.min(4 * j, MAX_BACKOFF_MS);
        return j;
    }

    private boolean isGcDetected(long j) {
        return this.clock.now() - j >= 32;
    }

    @androidx.annotation.VisibleForTesting
    public boolean allocate() {
        android.graphics.Bitmap createBitmap;
        long now = this.clock.now();
        while (!this.toPrefill.isEmpty() && !isGcDetected(now)) {
            com.bumptech.glide.load.engine.prefill.PreFillType remove = this.toPrefill.remove();
            if (this.seenTypes.contains(remove)) {
                createBitmap = android.graphics.Bitmap.createBitmap(remove.getWidth(), remove.getHeight(), remove.getConfig());
            } else {
                this.seenTypes.add(remove);
                createBitmap = this.bitmapPool.getDirty(remove.getWidth(), remove.getHeight(), remove.getConfig());
            }
            int bitmapByteSize = com.bumptech.glide.util.Util.getBitmapByteSize(createBitmap);
            if (getFreeMemoryCacheBytes() >= bitmapByteSize) {
                this.memoryCache.put(new com.bumptech.glide.load.engine.prefill.BitmapPreFillRunner.UniqueKey(), com.bumptech.glide.load.resource.bitmap.BitmapResource.obtain(createBitmap, this.bitmapPool));
            } else {
                this.bitmapPool.put(createBitmap);
            }
            if (android.util.Log.isLoggable(TAG, 3)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("allocated [");
                sb.append(remove.getWidth());
                sb.append("x");
                sb.append(remove.getHeight());
                sb.append("] ");
                sb.append(remove.getConfig());
                sb.append(" size: ");
                sb.append(bitmapByteSize);
            }
        }
        return (this.isCancelled || this.toPrefill.isEmpty()) ? false : true;
    }

    public void cancel() {
        this.isCancelled = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (allocate()) {
            this.handler.postDelayed(this, getNextDelay());
        }
    }
}
