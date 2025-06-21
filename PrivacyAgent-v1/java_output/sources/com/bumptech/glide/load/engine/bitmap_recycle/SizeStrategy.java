package com.bumptech.glide.load.engine.bitmap_recycle;

@androidx.annotation.RequiresApi(19)
/* loaded from: classes.dex */
final class SizeStrategy implements com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy {
    private static final int MAX_SIZE_MULTIPLE = 8;
    private final com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy.KeyPool keyPool = new com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy.KeyPool();
    private final com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap<com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy.Key, android.graphics.Bitmap> groupedMap = new com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap<>();
    private final java.util.NavigableMap<java.lang.Integer, java.lang.Integer> sortedSizes = new com.bumptech.glide.load.engine.bitmap_recycle.PrettyPrintTreeMap();

    @androidx.annotation.VisibleForTesting
    public static final class Key implements com.bumptech.glide.load.engine.bitmap_recycle.Poolable {
        private final com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy.KeyPool pool;
        int size;

        public Key(com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy.KeyPool keyPool) {
            this.pool = keyPool;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj instanceof com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy.Key) && this.size == ((com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy.Key) obj).size;
        }

        public int hashCode() {
            return this.size;
        }

        public void init(int i) {
            this.size = i;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public java.lang.String toString() {
            return com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy.getBitmapString(this.size);
        }
    }

    @androidx.annotation.VisibleForTesting
    public static class KeyPool extends com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool<com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy.Key> {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy.Key create() {
            return new com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy.Key(this);
        }

        public com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy.Key get(int i) {
            com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy.Key key = (com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy.Key) super.get();
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

    public static java.lang.String getBitmapString(int i) {
        return "[" + i + "]";
    }

    private static java.lang.String getBitmapString(android.graphics.Bitmap bitmap) {
        return getBitmapString(com.bumptech.glide.util.Util.getBitmapByteSize(bitmap));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    @androidx.annotation.Nullable
    public android.graphics.Bitmap get(int i, int i2, android.graphics.Bitmap.Config config) {
        int bitmapByteSize = com.bumptech.glide.util.Util.getBitmapByteSize(i, i2, config);
        com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy.Key key = this.keyPool.get(bitmapByteSize);
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

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(android.graphics.Bitmap bitmap) {
        return com.bumptech.glide.util.Util.getBitmapByteSize(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public java.lang.String logBitmap(int i, int i2, android.graphics.Bitmap.Config config) {
        return getBitmapString(com.bumptech.glide.util.Util.getBitmapByteSize(i, i2, config));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public java.lang.String logBitmap(android.graphics.Bitmap bitmap) {
        return getBitmapString(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(android.graphics.Bitmap bitmap) {
        com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy.Key key = this.keyPool.get(com.bumptech.glide.util.Util.getBitmapByteSize(bitmap));
        this.groupedMap.put(key, bitmap);
        java.lang.Integer num = this.sortedSizes.get(java.lang.Integer.valueOf(key.size));
        this.sortedSizes.put(java.lang.Integer.valueOf(key.size), java.lang.Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    @androidx.annotation.Nullable
    public android.graphics.Bitmap removeLast() {
        android.graphics.Bitmap removeLast = this.groupedMap.removeLast();
        if (removeLast != null) {
            decrementBitmapOfSize(java.lang.Integer.valueOf(com.bumptech.glide.util.Util.getBitmapByteSize(removeLast)));
        }
        return removeLast;
    }

    public java.lang.String toString() {
        return "SizeStrategy:\n  " + this.groupedMap + "\n  SortedSizes" + this.sortedSizes;
    }
}
