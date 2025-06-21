package com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle;

/* loaded from: classes.dex */
class AttributeStrategy implements com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy {
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.AttributeStrategy.KeyPool keyPool = new com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.AttributeStrategy.KeyPool();
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.GroupedLinkedMap<com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.AttributeStrategy.Key, android.graphics.Bitmap> groupedMap = new com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.GroupedLinkedMap<>();

    public static class Key implements com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.Poolable {
        private android.graphics.Bitmap.Config config;
        private int height;
        private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.AttributeStrategy.KeyPool pool;
        private int width;

        public Key(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.AttributeStrategy.KeyPool keyPool) {
            this.pool = keyPool;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.AttributeStrategy.Key)) {
                return false;
            }
            com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.AttributeStrategy.Key key = (com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.AttributeStrategy.Key) obj;
            return this.width == key.width && this.height == key.height && this.config == key.config;
        }

        public int hashCode() {
            int i = ((this.width * 31) + this.height) * 31;
            android.graphics.Bitmap.Config config = this.config;
            return i + (config != null ? config.hashCode() : 0);
        }

        public void init(int i, int i2, android.graphics.Bitmap.Config config) {
            this.width = i;
            this.height = i2;
            this.config = config;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public java.lang.String toString() {
            return com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.AttributeStrategy.getBitmapString(this.width, this.height, this.config);
        }
    }

    public static class KeyPool extends com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BaseKeyPool<com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.AttributeStrategy.Key> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BaseKeyPool
        public com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.AttributeStrategy.Key create() {
            return new com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.AttributeStrategy.Key(this);
        }

        public com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.AttributeStrategy.Key get(int i, int i2, android.graphics.Bitmap.Config config) {
            com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.AttributeStrategy.Key key = get();
            key.init(i, i2, config);
            return key;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String getBitmapString(int i, int i2, android.graphics.Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    private static java.lang.String getBitmapString(android.graphics.Bitmap bitmap) {
        return getBitmapString(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public android.graphics.Bitmap get(int i, int i2, android.graphics.Bitmap.Config config) {
        return this.groupedMap.get(this.keyPool.get(i, i2, config));
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(android.graphics.Bitmap bitmap) {
        return com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(bitmap);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public java.lang.String logBitmap(int i, int i2, android.graphics.Bitmap.Config config) {
        return getBitmapString(i, i2, config);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public java.lang.String logBitmap(android.graphics.Bitmap bitmap) {
        return getBitmapString(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(android.graphics.Bitmap bitmap) {
        this.groupedMap.put(this.keyPool.get(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public android.graphics.Bitmap removeLast() {
        return this.groupedMap.removeLast();
    }

    public java.lang.String toString() {
        java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("AttributeStrategy:\n  ");
        tanxu_do2.append(this.groupedMap);
        return tanxu_do2.toString();
    }
}
