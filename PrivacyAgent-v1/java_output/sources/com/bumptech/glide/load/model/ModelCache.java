package com.bumptech.glide.load.model;

/* loaded from: classes.dex */
public class ModelCache<A, B> {
    private static final int DEFAULT_SIZE = 250;
    private final com.bumptech.glide.util.LruCache<com.bumptech.glide.load.model.ModelCache.ModelKey<A>, B> cache;

    /* renamed from: com.bumptech.glide.load.model.ModelCache$1, reason: invalid class name */
    public class AnonymousClass1 extends com.bumptech.glide.util.LruCache<com.bumptech.glide.load.model.ModelCache.ModelKey<A>, B> {
        public AnonymousClass1(long j) {
            super(j);
        }

        public void onItemEvicted(@androidx.annotation.NonNull com.bumptech.glide.load.model.ModelCache.ModelKey<A> modelKey, @androidx.annotation.Nullable B b) {
            modelKey.release();
        }

        @Override // com.bumptech.glide.util.LruCache
        public /* bridge */ /* synthetic */ void onItemEvicted(@androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.Nullable java.lang.Object obj2) {
            onItemEvicted((com.bumptech.glide.load.model.ModelCache.ModelKey) obj, (com.bumptech.glide.load.model.ModelCache.ModelKey<A>) obj2);
        }
    }

    @androidx.annotation.VisibleForTesting
    public static final class ModelKey<A> {
        private static final java.util.Queue<com.bumptech.glide.load.model.ModelCache.ModelKey<?>> KEY_QUEUE = com.bumptech.glide.util.Util.createQueue(0);
        private int height;
        private A model;
        private int width;

        private ModelKey() {
        }

        public static <A> com.bumptech.glide.load.model.ModelCache.ModelKey<A> get(A a, int i, int i2) {
            com.bumptech.glide.load.model.ModelCache.ModelKey<A> modelKey;
            java.util.Queue<com.bumptech.glide.load.model.ModelCache.ModelKey<?>> queue = KEY_QUEUE;
            synchronized (queue) {
                modelKey = (com.bumptech.glide.load.model.ModelCache.ModelKey) queue.poll();
            }
            if (modelKey == null) {
                modelKey = new com.bumptech.glide.load.model.ModelCache.ModelKey<>();
            }
            modelKey.init(a, i, i2);
            return modelKey;
        }

        private void init(A a, int i, int i2) {
            this.model = a;
            this.width = i;
            this.height = i2;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof com.bumptech.glide.load.model.ModelCache.ModelKey)) {
                return false;
            }
            com.bumptech.glide.load.model.ModelCache.ModelKey modelKey = (com.bumptech.glide.load.model.ModelCache.ModelKey) obj;
            return this.width == modelKey.width && this.height == modelKey.height && this.model.equals(modelKey.model);
        }

        public int hashCode() {
            return (((this.height * 31) + this.width) * 31) + this.model.hashCode();
        }

        public void release() {
            java.util.Queue<com.bumptech.glide.load.model.ModelCache.ModelKey<?>> queue = KEY_QUEUE;
            synchronized (queue) {
                queue.offer(this);
            }
        }
    }

    public ModelCache() {
        this(250L);
    }

    public ModelCache(long j) {
        this.cache = new com.bumptech.glide.load.model.ModelCache.AnonymousClass1(j);
    }

    public void clear() {
        this.cache.clearMemory();
    }

    @androidx.annotation.Nullable
    public B get(A a, int i, int i2) {
        com.bumptech.glide.load.model.ModelCache.ModelKey<A> modelKey = com.bumptech.glide.load.model.ModelCache.ModelKey.get(a, i, i2);
        B b = this.cache.get(modelKey);
        modelKey.release();
        return b;
    }

    public void put(A a, int i, int i2, B b) {
        this.cache.put(com.bumptech.glide.load.model.ModelCache.ModelKey.get(a, i, i2), b);
    }
}
