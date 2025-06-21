package com.alimm.tanx.ui.image.glide.load.engine.prefill;

/* loaded from: classes.dex */
public final class BitmapPreFiller {
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private com.alimm.tanx.ui.image.glide.load.engine.prefill.BitmapPreFillRunner current;
    private final com.alimm.tanx.ui.image.glide.load.DecodeFormat defaultFormat;
    private final android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
    private final com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache memoryCache;

    public BitmapPreFiller(com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache memoryCache, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat) {
        this.memoryCache = memoryCache;
        this.bitmapPool = bitmapPool;
        this.defaultFormat = decodeFormat;
    }

    private static int getSizeInBytes(com.alimm.tanx.ui.image.glide.load.engine.prefill.PreFillType preFillType) {
        return com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(preFillType.getWidth(), preFillType.getHeight(), preFillType.getConfig());
    }

    public com.alimm.tanx.ui.image.glide.load.engine.prefill.PreFillQueue generateAllocationOrder(com.alimm.tanx.ui.image.glide.load.engine.prefill.PreFillType[] preFillTypeArr) {
        int maxSize = this.bitmapPool.getMaxSize() + (this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize());
        int i = 0;
        for (com.alimm.tanx.ui.image.glide.load.engine.prefill.PreFillType preFillType : preFillTypeArr) {
            i += preFillType.getWeight();
        }
        float f = maxSize / i;
        java.util.HashMap hashMap = new java.util.HashMap();
        for (com.alimm.tanx.ui.image.glide.load.engine.prefill.PreFillType preFillType2 : preFillTypeArr) {
            hashMap.put(preFillType2, java.lang.Integer.valueOf(java.lang.Math.round(preFillType2.getWeight() * f) / com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(preFillType2.getWidth(), preFillType2.getHeight(), preFillType2.getConfig())));
        }
        return new com.alimm.tanx.ui.image.glide.load.engine.prefill.PreFillQueue(hashMap);
    }

    public void preFill(com.alimm.tanx.ui.image.glide.load.engine.prefill.PreFillType.Builder... builderArr) {
        com.alimm.tanx.ui.image.glide.load.engine.prefill.BitmapPreFillRunner bitmapPreFillRunner = this.current;
        if (bitmapPreFillRunner != null) {
            bitmapPreFillRunner.cancel();
        }
        com.alimm.tanx.ui.image.glide.load.engine.prefill.PreFillType[] preFillTypeArr = new com.alimm.tanx.ui.image.glide.load.engine.prefill.PreFillType[builderArr.length];
        for (int i = 0; i < builderArr.length; i++) {
            com.alimm.tanx.ui.image.glide.load.engine.prefill.PreFillType.Builder builder = builderArr[i];
            if (builder.getConfig() == null) {
                com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat = this.defaultFormat;
                builder.setConfig((decodeFormat == com.alimm.tanx.ui.image.glide.load.DecodeFormat.ALWAYS_ARGB_8888 || decodeFormat == com.alimm.tanx.ui.image.glide.load.DecodeFormat.PREFER_ARGB_8888) ? android.graphics.Bitmap.Config.ARGB_8888 : android.graphics.Bitmap.Config.RGB_565);
            }
            preFillTypeArr[i] = builder.build();
        }
        com.alimm.tanx.ui.image.glide.load.engine.prefill.BitmapPreFillRunner bitmapPreFillRunner2 = new com.alimm.tanx.ui.image.glide.load.engine.prefill.BitmapPreFillRunner(this.bitmapPool, this.memoryCache, generateAllocationOrder(preFillTypeArr));
        this.current = bitmapPreFillRunner2;
        this.handler.post(bitmapPreFillRunner2);
    }
}
