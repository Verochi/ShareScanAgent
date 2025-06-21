package com.bumptech.glide.load.engine.bitmap_recycle;

/* loaded from: classes.dex */
public class LruBitmapPool implements com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool {
    private static final android.graphics.Bitmap.Config DEFAULT_CONFIG = android.graphics.Bitmap.Config.ARGB_8888;
    private static final java.lang.String TAG = "LruBitmapPool";
    private final java.util.Set<android.graphics.Bitmap.Config> allowedConfigs;
    private long currentSize;
    private int evictions;
    private int hits;
    private final long initialMaxSize;
    private long maxSize;
    private int misses;
    private int puts;
    private final com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy strategy;
    private final com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker tracker;

    public interface BitmapTracker {
        void add(android.graphics.Bitmap bitmap);

        void remove(android.graphics.Bitmap bitmap);
    }

    public static final class NullBitmapTracker implements com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(android.graphics.Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(android.graphics.Bitmap bitmap) {
        }
    }

    public static class ThrowingBitmapTracker implements com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker {
        private final java.util.Set<android.graphics.Bitmap> bitmaps = java.util.Collections.synchronizedSet(new java.util.HashSet());

        private ThrowingBitmapTracker() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(android.graphics.Bitmap bitmap) {
            if (!this.bitmaps.contains(bitmap)) {
                this.bitmaps.add(bitmap);
                return;
            }
            throw new java.lang.IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(android.graphics.Bitmap bitmap) {
            if (!this.bitmaps.contains(bitmap)) {
                throw new java.lang.IllegalStateException("Cannot remove bitmap not in tracker");
            }
            this.bitmaps.remove(bitmap);
        }
    }

    public LruBitmapPool(long j) {
        this(j, getDefaultStrategy(), getDefaultAllowedConfigs());
    }

    public LruBitmapPool(long j, com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy lruPoolStrategy, java.util.Set<android.graphics.Bitmap.Config> set) {
        this.initialMaxSize = j;
        this.maxSize = j;
        this.strategy = lruPoolStrategy;
        this.allowedConfigs = set;
        this.tracker = new com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.NullBitmapTracker();
    }

    public LruBitmapPool(long j, java.util.Set<android.graphics.Bitmap.Config> set) {
        this(j, getDefaultStrategy(), set);
    }

    @android.annotation.TargetApi(26)
    private static void assertNotHardwareConfig(android.graphics.Bitmap.Config config) {
        android.graphics.Bitmap.Config config2;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return;
        }
        config2 = android.graphics.Bitmap.Config.HARDWARE;
        if (config != config2) {
            return;
        }
        throw new java.lang.IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
    }

    @androidx.annotation.NonNull
    private static android.graphics.Bitmap createBitmap(int i, int i2, @androidx.annotation.Nullable android.graphics.Bitmap.Config config) {
        if (config == null) {
            config = DEFAULT_CONFIG;
        }
        return android.graphics.Bitmap.createBitmap(i, i2, config);
    }

    private void dump() {
        if (android.util.Log.isLoggable(TAG, 2)) {
            dumpUnchecked();
        }
    }

    private void dumpUnchecked() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Hits=");
        sb.append(this.hits);
        sb.append(", misses=");
        sb.append(this.misses);
        sb.append(", puts=");
        sb.append(this.puts);
        sb.append(", evictions=");
        sb.append(this.evictions);
        sb.append(", currentSize=");
        sb.append(this.currentSize);
        sb.append(", maxSize=");
        sb.append(this.maxSize);
        sb.append("\nStrategy=");
        sb.append(this.strategy);
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    @android.annotation.TargetApi(26)
    private static java.util.Set<android.graphics.Bitmap.Config> getDefaultAllowedConfigs() {
        android.graphics.Bitmap.Config config;
        java.util.HashSet hashSet = new java.util.HashSet(java.util.Arrays.asList(android.graphics.Bitmap.Config.values()));
        int i = android.os.Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i >= 26) {
            config = android.graphics.Bitmap.Config.HARDWARE;
            hashSet.remove(config);
        }
        return java.util.Collections.unmodifiableSet(hashSet);
    }

    private static com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy getDefaultStrategy() {
        return new com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy();
    }

    @androidx.annotation.Nullable
    private synchronized android.graphics.Bitmap getDirtyOrNull(int i, int i2, @androidx.annotation.Nullable android.graphics.Bitmap.Config config) {
        android.graphics.Bitmap bitmap;
        assertNotHardwareConfig(config);
        bitmap = this.strategy.get(i, i2, config != null ? config : DEFAULT_CONFIG);
        if (bitmap == null) {
            if (android.util.Log.isLoggable(TAG, 3)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Missing bitmap=");
                sb.append(this.strategy.logBitmap(i, i2, config));
            }
            this.misses++;
        } else {
            this.hits++;
            this.currentSize -= this.strategy.getSize(bitmap);
            this.tracker.remove(bitmap);
            normalize(bitmap);
        }
        if (android.util.Log.isLoggable(TAG, 2)) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Get bitmap=");
            sb2.append(this.strategy.logBitmap(i, i2, config));
        }
        dump();
        return bitmap;
    }

    @android.annotation.TargetApi(19)
    private static void maybeSetPreMultiplied(android.graphics.Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    private static void normalize(android.graphics.Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        maybeSetPreMultiplied(bitmap);
    }

    private synchronized void trimToSize(long j) {
        while (this.currentSize > j) {
            android.graphics.Bitmap removeLast = this.strategy.removeLast();
            if (removeLast == null) {
                if (android.util.Log.isLoggable(TAG, 5)) {
                    dumpUnchecked();
                }
                this.currentSize = 0L;
                return;
            }
            this.tracker.remove(removeLast);
            this.currentSize -= this.strategy.getSize(removeLast);
            this.evictions++;
            if (android.util.Log.isLoggable(TAG, 3)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Evicting bitmap=");
                sb.append(this.strategy.logBitmap(removeLast));
            }
            dump();
            removeLast.recycle();
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
        trimToSize(0L);
    }

    public long evictionCount() {
        return this.evictions;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @androidx.annotation.NonNull
    public android.graphics.Bitmap get(int i, int i2, android.graphics.Bitmap.Config config) {
        android.graphics.Bitmap dirtyOrNull = getDirtyOrNull(i, i2, config);
        if (dirtyOrNull == null) {
            return createBitmap(i, i2, config);
        }
        dirtyOrNull.eraseColor(0);
        return dirtyOrNull;
    }

    public long getCurrentSize() {
        return this.currentSize;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @androidx.annotation.NonNull
    public android.graphics.Bitmap getDirty(int i, int i2, android.graphics.Bitmap.Config config) {
        android.graphics.Bitmap dirtyOrNull = getDirtyOrNull(i, i2, config);
        return dirtyOrNull == null ? createBitmap(i, i2, config) : dirtyOrNull;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public long getMaxSize() {
        return this.maxSize;
    }

    public long hitCount() {
        return this.hits;
    }

    public long missCount() {
        return this.misses;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void put(android.graphics.Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new java.lang.NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new java.lang.IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.strategy.getSize(bitmap) <= this.maxSize && this.allowedConfigs.contains(bitmap.getConfig())) {
                int size = this.strategy.getSize(bitmap);
                this.strategy.put(bitmap);
                this.tracker.add(bitmap);
                this.puts++;
                this.currentSize += size;
                if (android.util.Log.isLoggable(TAG, 2)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Put bitmap in pool=");
                    sb.append(this.strategy.logBitmap(bitmap));
                }
                dump();
                evict();
                return;
            }
            if (android.util.Log.isLoggable(TAG, 2)) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Reject bitmap from pool, bitmap: ");
                sb2.append(this.strategy.logBitmap(bitmap));
                sb2.append(", is mutable: ");
                sb2.append(bitmap.isMutable());
                sb2.append(", is allowed config: ");
                sb2.append(this.allowedConfigs.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void setSizeMultiplier(float f) {
        this.maxSize = java.lang.Math.round(this.initialMaxSize * f);
        evict();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @android.annotation.SuppressLint({"InlinedApi"})
    public void trimMemory(int i) {
        if (android.util.Log.isLoggable(TAG, 3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("trimMemory, level=");
            sb.append(i);
        }
        if (i >= 40 || (android.os.Build.VERSION.SDK_INT >= 23 && i >= 20)) {
            clearMemory();
        } else if (i >= 20 || i == 15) {
            trimToSize(getMaxSize() / 2);
        }
    }
}
