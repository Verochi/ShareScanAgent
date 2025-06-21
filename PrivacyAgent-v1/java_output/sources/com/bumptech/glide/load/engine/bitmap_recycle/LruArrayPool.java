package com.bumptech.glide.load.engine.bitmap_recycle;

/* loaded from: classes.dex */
public final class LruArrayPool implements com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool {
    private static final int DEFAULT_SIZE = 4194304;

    @androidx.annotation.VisibleForTesting
    static final int MAX_OVER_SIZE_MULTIPLE = 8;
    private static final int SINGLE_ARRAY_MAX_SIZE_DIVISOR = 2;
    private final java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface<?>> adapters;
    private int currentSize;
    private final com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap<com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key, java.lang.Object> groupedMap;
    private final com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.KeyPool keyPool;
    private final int maxSize;
    private final java.util.Map<java.lang.Class<?>, java.util.NavigableMap<java.lang.Integer, java.lang.Integer>> sortedSizes;

    public static final class Key implements com.bumptech.glide.load.engine.bitmap_recycle.Poolable {
        private java.lang.Class<?> arrayClass;
        private final com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.KeyPool pool;
        int size;

        public Key(com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.KeyPool keyPool) {
            this.pool = keyPool;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key)) {
                return false;
            }
            com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key key = (com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key) obj;
            return this.size == key.size && this.arrayClass == key.arrayClass;
        }

        public int hashCode() {
            int i = this.size * 31;
            java.lang.Class<?> cls = this.arrayClass;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        public void init(int i, java.lang.Class<?> cls) {
            this.size = i;
            this.arrayClass = cls;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public java.lang.String toString() {
            return "Key{size=" + this.size + "array=" + this.arrayClass + '}';
        }
    }

    public static final class KeyPool extends com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool<com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key create() {
            return new com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key(this);
        }

        public com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key get(int i, java.lang.Class<?> cls) {
            com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key key = get();
            key.init(i, cls);
            return key;
        }
    }

    @androidx.annotation.VisibleForTesting
    public LruArrayPool() {
        this.groupedMap = new com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap<>();
        this.keyPool = new com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.KeyPool();
        this.sortedSizes = new java.util.HashMap();
        this.adapters = new java.util.HashMap();
        this.maxSize = 4194304;
    }

    public LruArrayPool(int i) {
        this.groupedMap = new com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap<>();
        this.keyPool = new com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.KeyPool();
        this.sortedSizes = new java.util.HashMap();
        this.adapters = new java.util.HashMap();
        this.maxSize = i;
    }

    private void decrementArrayOfSize(int i, java.lang.Class<?> cls) {
        java.util.NavigableMap<java.lang.Integer, java.lang.Integer> sizesForAdapter = getSizesForAdapter(cls);
        java.lang.Integer num = sizesForAdapter.get(java.lang.Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                sizesForAdapter.remove(java.lang.Integer.valueOf(i));
                return;
            } else {
                sizesForAdapter.put(java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new java.lang.NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
    }

    private void evict() {
        evictToSize(this.maxSize);
    }

    private void evictToSize(int i) {
        while (this.currentSize > i) {
            java.lang.Object removeLast = this.groupedMap.removeLast();
            com.bumptech.glide.util.Preconditions.checkNotNull(removeLast);
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface adapterFromObject = getAdapterFromObject(removeLast);
            this.currentSize -= adapterFromObject.getArrayLength(removeLast) * adapterFromObject.getElementSizeInBytes();
            decrementArrayOfSize(adapterFromObject.getArrayLength(removeLast), removeLast.getClass());
            if (android.util.Log.isLoggable(adapterFromObject.getTag(), 2)) {
                adapterFromObject.getTag();
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("evicted: ");
                sb.append(adapterFromObject.getArrayLength(removeLast));
            }
        }
    }

    private <T> com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface<T> getAdapterFromObject(T t) {
        return getAdapterFromType(t.getClass());
    }

    private <T> com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface<T> getAdapterFromType(java.lang.Class<T> cls) {
        com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface<T> arrayAdapterInterface = (com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface) this.adapters.get(cls);
        if (arrayAdapterInterface == null) {
            if (cls.equals(int[].class)) {
                arrayAdapterInterface = new com.bumptech.glide.load.engine.bitmap_recycle.IntegerArrayAdapter();
            } else {
                if (!cls.equals(byte[].class)) {
                    throw new java.lang.IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
                }
                arrayAdapterInterface = new com.bumptech.glide.load.engine.bitmap_recycle.ByteArrayAdapter();
            }
            this.adapters.put(cls, arrayAdapterInterface);
        }
        return arrayAdapterInterface;
    }

    @androidx.annotation.Nullable
    private <T> T getArrayForKey(com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key key) {
        return (T) this.groupedMap.get(key);
    }

    private <T> T getForKey(com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key key, java.lang.Class<T> cls) {
        com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface<T> adapterFromType = getAdapterFromType(cls);
        T t = (T) getArrayForKey(key);
        if (t != null) {
            this.currentSize -= adapterFromType.getArrayLength(t) * adapterFromType.getElementSizeInBytes();
            decrementArrayOfSize(adapterFromType.getArrayLength(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (android.util.Log.isLoggable(adapterFromType.getTag(), 2)) {
            adapterFromType.getTag();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Allocated ");
            sb.append(key.size);
            sb.append(" bytes");
        }
        return adapterFromType.newArray(key.size);
    }

    private java.util.NavigableMap<java.lang.Integer, java.lang.Integer> getSizesForAdapter(java.lang.Class<?> cls) {
        java.util.NavigableMap<java.lang.Integer, java.lang.Integer> navigableMap = this.sortedSizes.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        java.util.TreeMap treeMap = new java.util.TreeMap();
        this.sortedSizes.put(cls, treeMap);
        return treeMap;
    }

    private boolean isNoMoreThanHalfFull() {
        int i = this.currentSize;
        return i == 0 || this.maxSize / i >= 2;
    }

    private boolean isSmallEnoughForReuse(int i) {
        return i <= this.maxSize / 2;
    }

    private boolean mayFillRequest(int i, java.lang.Integer num) {
        return num != null && (isNoMoreThanHalfFull() || num.intValue() <= i * 8);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void clearMemory() {
        evictToSize(0);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T get(int i, java.lang.Class<T> cls) {
        java.lang.Integer ceilingKey;
        ceilingKey = getSizesForAdapter(cls).ceilingKey(java.lang.Integer.valueOf(i));
        return (T) getForKey(mayFillRequest(i, ceilingKey) ? this.keyPool.get(ceilingKey.intValue(), cls) : this.keyPool.get(i, cls), cls);
    }

    public int getCurrentSize() {
        int i = 0;
        for (java.lang.Class<?> cls : this.sortedSizes.keySet()) {
            for (java.lang.Integer num : this.sortedSizes.get(cls).keySet()) {
                i += num.intValue() * this.sortedSizes.get(cls).get(num).intValue() * getAdapterFromType(cls).getElementSizeInBytes();
            }
        }
        return i;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T getExact(int i, java.lang.Class<T> cls) {
        return (T) getForKey(this.keyPool.get(i, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> void put(T t) {
        java.lang.Class<?> cls = t.getClass();
        com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface<T> adapterFromType = getAdapterFromType(cls);
        int arrayLength = adapterFromType.getArrayLength(t);
        int elementSizeInBytes = adapterFromType.getElementSizeInBytes() * arrayLength;
        if (isSmallEnoughForReuse(elementSizeInBytes)) {
            com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key key = this.keyPool.get(arrayLength, cls);
            this.groupedMap.put(key, t);
            java.util.NavigableMap<java.lang.Integer, java.lang.Integer> sizesForAdapter = getSizesForAdapter(cls);
            java.lang.Integer num = sizesForAdapter.get(java.lang.Integer.valueOf(key.size));
            java.lang.Integer valueOf = java.lang.Integer.valueOf(key.size);
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            sizesForAdapter.put(valueOf, java.lang.Integer.valueOf(i));
            this.currentSize += elementSizeInBytes;
            evict();
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    @java.lang.Deprecated
    public <T> void put(T t, java.lang.Class<T> cls) {
        put(t);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void trimMemory(int i) {
        try {
            if (i >= 40) {
                clearMemory();
            } else if (i >= 20 || i == 15) {
                evictToSize(this.maxSize / 2);
            }
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }
}
