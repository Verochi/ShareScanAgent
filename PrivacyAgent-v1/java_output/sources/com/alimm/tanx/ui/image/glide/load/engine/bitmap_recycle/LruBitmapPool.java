package com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle;

/* loaded from: classes.dex */
public class LruBitmapPool implements com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool {
    private static final android.graphics.Bitmap.Config DEFAULT_CONFIG = android.graphics.Bitmap.Config.ARGB_8888;
    private static final java.lang.String TAG = "LruBitmapPool";
    private final java.util.Set<android.graphics.Bitmap.Config> allowedConfigs;
    private int currentSize;
    private int evictions;
    private int hits;
    private final int initialMaxSize;
    private int maxSize;
    private int misses;
    private int puts;
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy strategy;
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker tracker;

    public interface BitmapTracker {
        void add(android.graphics.Bitmap bitmap);

        void remove(android.graphics.Bitmap bitmap);
    }

    public static class NullBitmapTracker implements com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker {
        private NullBitmapTracker() {
        }

        public /* synthetic */ NullBitmapTracker(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.AnonymousClass1 anonymousClass1) {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(android.graphics.Bitmap bitmap) {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(android.graphics.Bitmap bitmap) {
        }
    }

    public static class ThrowingBitmapTracker implements com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker {
        private final java.util.Set<android.graphics.Bitmap> bitmaps = java.util.Collections.synchronizedSet(new java.util.HashSet());

        private ThrowingBitmapTracker() {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(android.graphics.Bitmap bitmap) {
            if (!this.bitmaps.contains(bitmap)) {
                this.bitmaps.add(bitmap);
                return;
            }
            throw new java.lang.IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(android.graphics.Bitmap bitmap) {
            if (!this.bitmaps.contains(bitmap)) {
                throw new java.lang.IllegalStateException("Cannot remove bitmap not in tracker");
            }
            this.bitmaps.remove(bitmap);
        }
    }

    public LruBitmapPool(int i) {
        this(i, getDefaultStrategy(), getDefaultAllowedConfigs());
    }

    public LruBitmapPool(int i, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy lruPoolStrategy, java.util.Set<android.graphics.Bitmap.Config> set) {
        this.initialMaxSize = i;
        this.maxSize = i;
        this.strategy = lruPoolStrategy;
        this.allowedConfigs = set;
        this.tracker = new com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.NullBitmapTracker(null);
    }

    public LruBitmapPool(int i, java.util.Set<android.graphics.Bitmap.Config> set) {
        this(i, getDefaultStrategy(), set);
    }

    private void dump() {
        if (android.util.Log.isLoggable(TAG, 2)) {
            dumpUnchecked();
        }
    }

    private void dumpUnchecked() {
        java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("Hits=");
        tanxu_do2.append(this.hits);
        tanxu_do2.append(", misses=");
        tanxu_do2.append(this.misses);
        tanxu_do2.append(", puts=");
        tanxu_do2.append(this.puts);
        tanxu_do2.append(", evictions=");
        tanxu_do2.append(this.evictions);
        tanxu_do2.append(", currentSize=");
        tanxu_do2.append(this.currentSize);
        tanxu_do2.append(", maxSize=");
        tanxu_do2.append(this.maxSize);
        tanxu_do2.append("\nStrategy=");
        tanxu_do2.append(this.strategy);
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    private static java.util.Set<android.graphics.Bitmap.Config> getDefaultAllowedConfigs() {
        java.util.HashSet hashSet = new java.util.HashSet();
        hashSet.addAll(java.util.Arrays.asList(android.graphics.Bitmap.Config.values()));
        hashSet.add(null);
        return java.util.Collections.unmodifiableSet(hashSet);
    }

    private static com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy getDefaultStrategy() {
        return new com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy();
    }

    private synchronized void trimToSize(int i) {
        while (this.currentSize > i) {
            android.graphics.Bitmap removeLast = this.strategy.removeLast();
            if (removeLast == null) {
                if (android.util.Log.isLoggable(TAG, 5)) {
                    dumpUnchecked();
                }
                this.currentSize = 0;
                return;
            } else {
                this.tracker.remove(removeLast);
                this.currentSize -= this.strategy.getSize(removeLast);
                removeLast.recycle();
                this.evictions++;
                if (android.util.Log.isLoggable(TAG, 3)) {
                    tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("Evicting bitmap=").append(this.strategy.logBitmap(removeLast));
                }
                dump();
            }
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
        trimToSize(0);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized android.graphics.Bitmap get(int i, int i2, android.graphics.Bitmap.Config config) {
        android.graphics.Bitmap dirty;
        dirty = getDirty(i, i2, config);
        if (dirty != null) {
            dirty.eraseColor(0);
        }
        return dirty;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    @android.annotation.TargetApi(12)
    public synchronized android.graphics.Bitmap getDirty(int i, int i2, android.graphics.Bitmap.Config config) {
        android.graphics.Bitmap bitmap;
        bitmap = this.strategy.get(i, i2, config != null ? config : DEFAULT_CONFIG);
        if (bitmap == null) {
            if (android.util.Log.isLoggable(TAG, 3)) {
                tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("Missing bitmap=").append(this.strategy.logBitmap(i, i2, config));
            }
            this.misses++;
        } else {
            this.hits++;
            this.currentSize -= this.strategy.getSize(bitmap);
            this.tracker.remove(bitmap);
            bitmap.setHasAlpha(true);
        }
        if (android.util.Log.isLoggable(TAG, 2)) {
            tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("Get bitmap=").append(this.strategy.logBitmap(i, i2, config));
        }
        dump();
        return bitmap;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public int getMaxSize() {
        return this.maxSize;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized boolean put(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            throw new java.lang.NullPointerException("Bitmap must not be null");
        }
        if (bitmap.isMutable() && this.strategy.getSize(bitmap) <= this.maxSize && this.allowedConfigs.contains(bitmap.getConfig())) {
            int size = this.strategy.getSize(bitmap);
            this.strategy.put(bitmap);
            this.tracker.add(bitmap);
            this.puts++;
            this.currentSize += size;
            if (android.util.Log.isLoggable(TAG, 2)) {
                tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("Put bitmap in pool=").append(this.strategy.logBitmap(bitmap));
            }
            dump();
            evict();
            return true;
        }
        if (android.util.Log.isLoggable(TAG, 2)) {
            java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("Reject bitmap from pool, bitmap: ");
            tanxu_do2.append(this.strategy.logBitmap(bitmap));
            tanxu_do2.append(", is mutable: ");
            tanxu_do2.append(bitmap.isMutable());
            tanxu_do2.append(", is allowed config: ");
            tanxu_do2.append(this.allowedConfigs.contains(bitmap.getConfig()));
        }
        return false;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void setSizeMultiplier(float f) {
        this.maxSize = java.lang.Math.round(this.initialMaxSize * f);
        evict();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    @android.annotation.SuppressLint({"InlinedApi"})
    public void trimMemory(int i) {
        if (android.util.Log.isLoggable(TAG, 3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("trimMemory, level=");
            sb.append(i);
        }
        if (i >= 60) {
            clearMemory();
        } else if (i >= 40) {
            trimToSize(this.maxSize / 2);
        }
    }
}
