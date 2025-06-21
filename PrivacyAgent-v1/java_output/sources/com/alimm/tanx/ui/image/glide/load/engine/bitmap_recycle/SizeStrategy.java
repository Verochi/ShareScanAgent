package com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle;

@android.annotation.TargetApi(19)
/* loaded from: classes.dex */
class SizeStrategy implements com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy {
    private static final int MAX_SIZE_MULTIPLE = 8;
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeStrategy.KeyPool keyPool = new com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeStrategy.KeyPool();
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.GroupedLinkedMap<com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeStrategy.Key, android.graphics.Bitmap> groupedMap = new com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.GroupedLinkedMap<>();
    private final java.util.TreeMap<java.lang.Integer, java.lang.Integer> sortedSizes = new com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.PrettyPrintTreeMap();

    public static final class Key implements com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.Poolable {
        private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeStrategy.KeyPool pool;
        private int size;

        public Key(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeStrategy.KeyPool keyPool) {
            this.pool = keyPool;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj instanceof com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeStrategy.Key) && this.size == ((com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeStrategy.Key) obj).size;
        }

        public int hashCode() {
            return this.size;
        }

        public void init(int i) {
            this.size = i;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public java.lang.String toString() {
            return com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeStrategy.getBitmapString(this.size);
        }
    }

    public static class KeyPool extends com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BaseKeyPool<com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeStrategy.Key> {
        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BaseKeyPool
        public com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeStrategy.Key create() {
            return new com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeStrategy.Key(this);
        }

        public com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeStrategy.Key get(int i) {
            com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeStrategy.Key key = get();
            key.init(i);
            return key;
        }
    }

    private void decrementBitmapOfSize(java.lang.Integer num) {
        java.lang.Integer num2 = this.sortedSizes.get(num);
        if (num2.intValue() == 1) {
            this.sortedSizes.remove(num);
        } else {
            this.sortedSizes.put(num, java.lang.Integer.valueOf(num2.intValue() - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String getBitmapString(int i) {
        return "[" + i + "]";
    }

    private static java.lang.String getBitmapString(android.graphics.Bitmap bitmap) {
        return getBitmapString(com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(bitmap));
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public android.graphics.Bitmap get(int i, int i2, android.graphics.Bitmap.Config config) {
        int bitmapByteSize = com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(i, i2, config);
        com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeStrategy.Key key = this.keyPool.get(bitmapByteSize);
        java.lang.Integer ceilingKey = this.sortedSizes.ceilingKey(java.lang.Integer.valueOf(bitmapByteSize));
        if (ceilingKey != null && ceilingKey.intValue() != bitmapByteSize && ceilingKey.intValue() <= bitmapByteSize * 8) {
            this.keyPool.offer(key);
            key = this.keyPool.get(ceilingKey.intValue());
        }
        android.graphics.Bitmap bitmap = this.groupedMap.get(key);
        if (bitmap != null) {
            bitmap.reconfigure(i, i2, config);
            decrementBitmapOfSize(ceilingKey);
        }
        return bitmap;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(android.graphics.Bitmap bitmap) {
        return com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(bitmap);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public java.lang.String logBitmap(int i, int i2, android.graphics.Bitmap.Config config) {
        return getBitmapString(com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(i, i2, config));
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public java.lang.String logBitmap(android.graphics.Bitmap bitmap) {
        return getBitmapString(bitmap);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(android.graphics.Bitmap bitmap) {
        com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeStrategy.Key key = this.keyPool.get(com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(bitmap));
        this.groupedMap.put(key, bitmap);
        java.lang.Integer num = this.sortedSizes.get(java.lang.Integer.valueOf(key.size));
        this.sortedSizes.put(java.lang.Integer.valueOf(key.size), java.lang.Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public android.graphics.Bitmap removeLast() {
        android.graphics.Bitmap removeLast = this.groupedMap.removeLast();
        if (removeLast != null) {
            decrementBitmapOfSize(java.lang.Integer.valueOf(com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(removeLast)));
        }
        return removeLast;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("SizeStrategy:\n  ");
        tanxu_do2.append(this.groupedMap);
        tanxu_do2.append("\n");
        tanxu_do2.append("  SortedSizes");
        tanxu_do2.append(this.sortedSizes);
        return tanxu_do2.toString();
    }
}
