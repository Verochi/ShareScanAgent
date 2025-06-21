package com.alimm.tanx.ui.image.glide.load.model;

/* loaded from: classes.dex */
public class ModelCache<A, B> {
    private static final int DEFAULT_SIZE = 250;
    private final com.alimm.tanx.ui.image.glide.util.LruCache<com.alimm.tanx.ui.image.glide.load.model.ModelCache.ModelKey<A>, B> cache;

    /* renamed from: com.alimm.tanx.ui.image.glide.load.model.ModelCache$1, reason: invalid class name */
    public class AnonymousClass1 extends com.alimm.tanx.ui.image.glide.util.LruCache<com.alimm.tanx.ui.image.glide.load.model.ModelCache.ModelKey<A>, B> {
        public AnonymousClass1(int i) {
            super(i);
        }

        public void onItemEvicted(com.alimm.tanx.ui.image.glide.load.model.ModelCache.ModelKey<A> modelKey, B b) {
            modelKey.release();
        }

        @Override // com.alimm.tanx.ui.image.glide.util.LruCache
        public /* bridge */ /* synthetic */ void onItemEvicted(java.lang.Object obj, java.lang.Object obj2) {
            onItemEvicted((com.alimm.tanx.ui.image.glide.load.model.ModelCache.ModelKey) obj, (com.alimm.tanx.ui.image.glide.load.model.ModelCache.ModelKey<A>) obj2);
        }
    }

    public static final class ModelKey<A> {
        private static final java.util.Queue<com.alimm.tanx.ui.image.glide.load.model.ModelCache.ModelKey<?>> KEY_QUEUE = com.alimm.tanx.ui.image.glide.util.Util.createQueue(0);
        private int height;
        private A model;
        private int width;

        private ModelKey() {
        }

        public static <A> com.alimm.tanx.ui.image.glide.load.model.ModelCache.ModelKey<A> get(A a, int i, int i2) {
            com.alimm.tanx.ui.image.glide.load.model.ModelCache.ModelKey<A> modelKey = (com.alimm.tanx.ui.image.glide.load.model.ModelCache.ModelKey) KEY_QUEUE.poll();
            if (modelKey == null) {
                modelKey = new com.alimm.tanx.ui.image.glide.load.model.ModelCache.ModelKey<>();
            }
            ((com.alimm.tanx.ui.image.glide.load.model.ModelCache.ModelKey) modelKey).model = a;
            ((com.alimm.tanx.ui.image.glide.load.model.ModelCache.ModelKey) modelKey).width = i;
            ((com.alimm.tanx.ui.image.glide.load.model.ModelCache.ModelKey) modelKey).height = i2;
            return modelKey;
        }

        private void init(A a, int i, int i2) {
            this.model = a;
            this.width = i;
            this.height = i2;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof com.alimm.tanx.ui.image.glide.load.model.ModelCache.ModelKey)) {
                return false;
            }
            com.alimm.tanx.ui.image.glide.load.model.ModelCache.ModelKey modelKey = (com.alimm.tanx.ui.image.glide.load.model.ModelCache.ModelKey) obj;
            return this.width == modelKey.width && this.height == modelKey.height && this.model.equals(modelKey.model);
        }

        public int hashCode() {
            return this.model.hashCode() + (((this.height * 31) + this.width) * 31);
        }

        public void release() {
            KEY_QUEUE.offer(this);
        }
    }

    public ModelCache() {
        this(250);
    }

    public ModelCache(int i) {
        this.cache = new com.alimm.tanx.ui.image.glide.load.model.ModelCache.AnonymousClass1(i);
    }

    public B get(A a, int i, int i2) {
        com.alimm.tanx.ui.image.glide.load.model.ModelCache.ModelKey<A> modelKey = com.alimm.tanx.ui.image.glide.load.model.ModelCache.ModelKey.get(a, i, i2);
        B b = this.cache.get(modelKey);
        modelKey.release();
        return b;
    }

    public void put(A a, int i, int i2, B b) {
        this.cache.put(com.alimm.tanx.ui.image.glide.load.model.ModelCache.ModelKey.get(a, i, i2), b);
    }
}
