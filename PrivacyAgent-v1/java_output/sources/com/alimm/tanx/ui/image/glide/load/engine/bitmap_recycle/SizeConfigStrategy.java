package com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle;

@android.annotation.TargetApi(19)
/* loaded from: classes.dex */
public class SizeConfigStrategy implements com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy {
    private static final int MAX_SIZE_MULTIPLE = 8;
    private static final android.graphics.Bitmap.Config[] ARGB_8888_IN_CONFIGS = {android.graphics.Bitmap.Config.ARGB_8888, null};
    private static final android.graphics.Bitmap.Config[] RGB_565_IN_CONFIGS = {android.graphics.Bitmap.Config.RGB_565};
    private static final android.graphics.Bitmap.Config[] ARGB_4444_IN_CONFIGS = {android.graphics.Bitmap.Config.ARGB_4444};
    private static final android.graphics.Bitmap.Config[] ALPHA_8_IN_CONFIGS = {android.graphics.Bitmap.Config.ALPHA_8};
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy.KeyPool keyPool = new com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy.KeyPool();
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.GroupedLinkedMap<com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy.Key, android.graphics.Bitmap> groupedMap = new com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.GroupedLinkedMap<>();
    private final java.util.Map<android.graphics.Bitmap.Config, java.util.NavigableMap<java.lang.Integer, java.lang.Integer>> sortedSizes = new java.util.HashMap();

    /* renamed from: com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] iArr = new int[android.graphics.Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[android.graphics.Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public static final class Key implements com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.Poolable {
        private android.graphics.Bitmap.Config config;
        private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy.KeyPool pool;
        private int size;

        public Key(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy.KeyPool keyPool) {
            this.pool = keyPool;
        }

        public Key(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy.KeyPool keyPool, int i, android.graphics.Bitmap.Config config) {
            this.pool = keyPool;
            init(i, config);
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy.Key)) {
                return false;
            }
            com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy.Key key = (com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy.Key) obj;
            if (this.size != key.size) {
                return false;
            }
            android.graphics.Bitmap.Config config = this.config;
            android.graphics.Bitmap.Config config2 = key.config;
            if (config == null) {
                if (config2 != null) {
                    return false;
                }
            } else if (!config.equals(config2)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.size * 31;
            android.graphics.Bitmap.Config config = this.config;
            return i + (config != null ? config.hashCode() : 0);
        }

        public void init(int i, android.graphics.Bitmap.Config config) {
            this.size = i;
            this.config = config;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public java.lang.String toString() {
            return com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy.getBitmapString(this.size, this.config);
        }
    }

    public static class KeyPool extends com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BaseKeyPool<com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy.Key> {
        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BaseKeyPool
        public com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy.Key create() {
            return new com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy.Key(this);
        }

        public com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy.Key get(int i, android.graphics.Bitmap.Config config) {
            com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy.Key key = get();
            key.init(i, config);
            return key;
        }
    }

    private void decrementBitmapOfSize(java.lang.Integer num, android.graphics.Bitmap.Config config) {
        java.util.NavigableMap<java.lang.Integer, java.lang.Integer> sizesForConfig = getSizesForConfig(config);
        java.lang.Integer num2 = sizesForConfig.get(num);
        if (num2.intValue() == 1) {
            sizesForConfig.remove(num);
        } else {
            sizesForConfig.put(num, java.lang.Integer.valueOf(num2.intValue() - 1));
        }
    }

    private com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy.Key findBestKey(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy.Key key, int i, android.graphics.Bitmap.Config config) {
        for (android.graphics.Bitmap.Config config2 : getInConfigs(config)) {
            java.lang.Integer ceilingKey = getSizesForConfig(config2).ceilingKey(java.lang.Integer.valueOf(i));
            if (ceilingKey != null && ceilingKey.intValue() <= i * 8) {
                if (ceilingKey.intValue() == i && config2 != null && config2.equals(config)) {
                    return key;
                }
                this.keyPool.offer(key);
                return this.keyPool.get(ceilingKey.intValue(), config2);
            }
        }
        return key;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String getBitmapString(int i, android.graphics.Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    private static android.graphics.Bitmap.Config[] getInConfigs(android.graphics.Bitmap.Config config) {
        int i = com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy.AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? new android.graphics.Bitmap.Config[]{config} : ALPHA_8_IN_CONFIGS : ARGB_4444_IN_CONFIGS : RGB_565_IN_CONFIGS : ARGB_8888_IN_CONFIGS;
    }

    private java.util.NavigableMap<java.lang.Integer, java.lang.Integer> getSizesForConfig(android.graphics.Bitmap.Config config) {
        java.util.NavigableMap<java.lang.Integer, java.lang.Integer> navigableMap = this.sortedSizes.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        java.util.TreeMap treeMap = new java.util.TreeMap();
        this.sortedSizes.put(config, treeMap);
        return treeMap;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public android.graphics.Bitmap get(int i, int i2, android.graphics.Bitmap.Config config) {
        int bitmapByteSize = com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(i, i2, config);
        android.graphics.Bitmap bitmap = this.groupedMap.get(findBestKey(this.keyPool.get(bitmapByteSize, config), bitmapByteSize, config));
        if (bitmap != null) {
            decrementBitmapOfSize(java.lang.Integer.valueOf(com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(bitmap)), bitmap.getConfig());
            bitmap.reconfigure(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : android.graphics.Bitmap.Config.ARGB_8888);
        }
        return bitmap;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(android.graphics.Bitmap bitmap) {
        return com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(bitmap);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public java.lang.String logBitmap(int i, int i2, android.graphics.Bitmap.Config config) {
        return getBitmapString(com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(i, i2, config), config);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public java.lang.String logBitmap(android.graphics.Bitmap bitmap) {
        return getBitmapString(com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(bitmap), bitmap.getConfig());
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(android.graphics.Bitmap bitmap) {
        com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.SizeConfigStrategy.Key key = this.keyPool.get(com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(bitmap), bitmap.getConfig());
        this.groupedMap.put(key, bitmap);
        java.util.NavigableMap<java.lang.Integer, java.lang.Integer> sizesForConfig = getSizesForConfig(bitmap.getConfig());
        java.lang.Integer num = sizesForConfig.get(java.lang.Integer.valueOf(key.size));
        sizesForConfig.put(java.lang.Integer.valueOf(key.size), java.lang.Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public android.graphics.Bitmap removeLast() {
        android.graphics.Bitmap removeLast = this.groupedMap.removeLast();
        if (removeLast != null) {
            decrementBitmapOfSize(java.lang.Integer.valueOf(com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(removeLast)), removeLast.getConfig());
        }
        return removeLast;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("SizeConfigStrategy{groupedMap=");
        tanxu_do2.append(this.groupedMap);
        tanxu_do2.append(", sortedSizes=(");
        for (java.util.Map.Entry<android.graphics.Bitmap.Config, java.util.NavigableMap<java.lang.Integer, java.lang.Integer>> entry : this.sortedSizes.entrySet()) {
            tanxu_do2.append(entry.getKey());
            tanxu_do2.append('[');
            tanxu_do2.append(entry.getValue());
            tanxu_do2.append("], ");
        }
        if (!this.sortedSizes.isEmpty()) {
            tanxu_do2.replace(tanxu_do2.length() - 2, tanxu_do2.length(), "");
        }
        tanxu_do2.append(")}");
        return tanxu_do2.toString();
    }
}
