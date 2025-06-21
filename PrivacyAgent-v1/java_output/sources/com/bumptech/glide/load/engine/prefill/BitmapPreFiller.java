package com.bumptech.glide.load.engine.prefill;

/* loaded from: classes.dex */
public final class BitmapPreFiller {
    private final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private com.bumptech.glide.load.engine.prefill.BitmapPreFillRunner current;
    private final com.bumptech.glide.load.DecodeFormat defaultFormat;
    private final android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
    private final com.bumptech.glide.load.engine.cache.MemoryCache memoryCache;

    public BitmapPreFiller(com.bumptech.glide.load.engine.cache.MemoryCache memoryCache, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.DecodeFormat decodeFormat) {
        this.memoryCache = memoryCache;
        this.bitmapPool = bitmapPool;
        this.defaultFormat = decodeFormat;
    }

    private static int getSizeInBytes(com.bumptech.glide.load.engine.prefill.PreFillType preFillType) {
        return com.bumptech.glide.util.Util.getBitmapByteSize(preFillType.getWidth(), preFillType.getHeight(), preFillType.getConfig());
    }

    @androidx.annotation.VisibleForTesting
    public com.bumptech.glide.load.engine.prefill.PreFillQueue generateAllocationOrder(com.bumptech.glide.load.engine.prefill.PreFillType... preFillTypeArr) {
        long maxSize = (this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize()) + this.bitmapPool.getMaxSize();
        int i = 0;
        for (com.bumptech.glide.load.engine.prefill.PreFillType preFillType : preFillTypeArr) {
            i += preFillType.getWeight();
        }
        float f = maxSize / i;
        java.util.HashMap hashMap = new java.util.HashMap();
        for (com.bumptech.glide.load.engine.prefill.PreFillType preFillType2 : preFillTypeArr) {
            hashMap.put(preFillType2, java.lang.Integer.valueOf(java.lang.Math.round(preFillType2.getWeight() * f) / getSizeInBytes(preFillType2)));
        }
        return new com.bumptech.glide.load.engine.prefill.PreFillQueue(hashMap);
    }

    public void preFill(com.bumptech.glide.load.engine.prefill.PreFillType.Builder... builderArr) {
        com.bumptech.glide.load.engine.prefill.BitmapPreFillRunner bitmapPreFillRunner = this.current;
        if (bitmapPreFillRunner != null) {
            bitmapPreFillRunner.cancel();
        }
        com.bumptech.glide.load.engine.prefill.PreFillType[] preFillTypeArr = new com.bumptech.glide.load.engine.prefill.PreFillType[builderArr.length];
        for (int i = 0; i < builderArr.length; i++) {
            com.bumptech.glide.load.engine.prefill.PreFillType.Builder builder = builderArr[i];
            if (builder.getConfig() == null) {
                builder.setConfig(this.defaultFormat == com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888 ? android.graphics.Bitmap.Config.ARGB_8888 : android.graphics.Bitmap.Config.RGB_565);
            }
            preFillTypeArr[i] = builder.build();
        }
        com.bumptech.glide.load.engine.prefill.BitmapPreFillRunner bitmapPreFillRunner2 = new com.bumptech.glide.load.engine.prefill.BitmapPreFillRunner(this.bitmapPool, this.memoryCache, generateAllocationOrder(preFillTypeArr));
        this.current = bitmapPreFillRunner2;
        this.handler.post(bitmapPreFillRunner2);
    }
}
