package com.alimm.tanx.ui.image.glide.load.engine.prefill;

/* loaded from: classes.dex */
final class BitmapPreFillRunner implements java.lang.Runnable {
    static final int BACKOFF_RATIO = 4;
    static final long INITIAL_BACKOFF_MS = 40;
    static final long MAX_DURATION_MS = 32;
    private static final java.lang.String TAG = "PreFillRunner";
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private final com.alimm.tanx.ui.image.glide.load.engine.prefill.BitmapPreFillRunner.Clock clock;
    private long currentDelay;
    private final android.os.Handler handler;
    private boolean isCancelled;
    private final com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache memoryCache;
    private final java.util.Set<com.alimm.tanx.ui.image.glide.load.engine.prefill.PreFillType> seenTypes;
    private final com.alimm.tanx.ui.image.glide.load.engine.prefill.PreFillQueue toPrefill;
    private static final com.alimm.tanx.ui.image.glide.load.engine.prefill.BitmapPreFillRunner.Clock DEFAULT_CLOCK = new com.alimm.tanx.ui.image.glide.load.engine.prefill.BitmapPreFillRunner.Clock();
    static final long MAX_BACKOFF_MS = java.util.concurrent.TimeUnit.SECONDS.toMillis(1);

    public static class Clock {
        public long now() {
            return android.os.SystemClock.currentThreadTimeMillis();
        }
    }

    public static class UniqueKey implements com.alimm.tanx.ui.image.glide.load.Key {
        private UniqueKey() {
        }

        public /* synthetic */ UniqueKey(com.alimm.tanx.ui.image.glide.load.engine.prefill.BitmapPreFillRunner.AnonymousClass1 anonymousClass1) {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.Key
        public void updateDiskCacheKey(java.security.MessageDigest messageDigest) throws java.io.UnsupportedEncodingException {
        }
    }

    public BitmapPreFillRunner(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache memoryCache, com.alimm.tanx.ui.image.glide.load.engine.prefill.PreFillQueue preFillQueue) {
        this(bitmapPool, memoryCache, preFillQueue, DEFAULT_CLOCK, new android.os.Handler(android.os.Looper.getMainLooper()));
    }

    public BitmapPreFillRunner(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache memoryCache, com.alimm.tanx.ui.image.glide.load.engine.prefill.PreFillQueue preFillQueue, com.alimm.tanx.ui.image.glide.load.engine.prefill.BitmapPreFillRunner.Clock clock, android.os.Handler handler) {
        this.seenTypes = new java.util.HashSet();
        this.currentDelay = INITIAL_BACKOFF_MS;
        this.bitmapPool = bitmapPool;
        this.memoryCache = memoryCache;
        this.toPrefill = preFillQueue;
        this.clock = clock;
        this.handler = handler;
    }

    private void addToBitmapPool(com.alimm.tanx.ui.image.glide.load.engine.prefill.PreFillType preFillType, android.graphics.Bitmap bitmap) {
        android.graphics.Bitmap bitmap2;
        if (this.seenTypes.add(preFillType) && (bitmap2 = this.bitmapPool.get(preFillType.getWidth(), preFillType.getHeight(), preFillType.getConfig())) != null) {
            this.bitmapPool.put(bitmap2);
        }
        this.bitmapPool.put(bitmap);
    }

    private boolean allocate() {
        long now = this.clock.now();
        while (!this.toPrefill.isEmpty() && !isGcDetected(now)) {
            com.alimm.tanx.ui.image.glide.load.engine.prefill.PreFillType remove = this.toPrefill.remove();
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(remove.getWidth(), remove.getHeight(), remove.getConfig());
            if (getFreeMemoryCacheBytes() >= com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(createBitmap)) {
                this.memoryCache.put(new com.alimm.tanx.ui.image.glide.load.engine.prefill.BitmapPreFillRunner.UniqueKey(null), com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapResource.obtain(createBitmap, this.bitmapPool));
            } else {
                addToBitmapPool(remove, createBitmap);
            }
            if (android.util.Log.isLoggable(TAG, 3)) {
                java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("allocated [");
                tanxu_do2.append(remove.getWidth());
                tanxu_do2.append("x");
                tanxu_do2.append(remove.getHeight());
                tanxu_do2.append("] ");
                tanxu_do2.append(remove.getConfig());
                tanxu_do2.append(" size: ");
                tanxu_do2.append(com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(createBitmap));
            }
        }
        return (this.isCancelled || this.toPrefill.isEmpty()) ? false : true;
    }

    private int getFreeMemoryCacheBytes() {
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
