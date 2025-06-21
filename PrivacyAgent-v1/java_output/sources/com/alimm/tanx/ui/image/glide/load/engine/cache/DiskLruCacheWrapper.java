package com.alimm.tanx.ui.image.glide.load.engine.cache;

/* loaded from: classes.dex */
public class DiskLruCacheWrapper implements com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache {
    private static final int APP_VERSION = 1;
    private static final java.lang.String TAG = "DiskLruCacheWrapper";
    private static final int VALUE_COUNT = 1;
    private static com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheWrapper wrapper;
    private final java.io.File directory;
    private com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache diskLruCache;
    private final int maxSize;
    private final com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCacheWriteLocker writeLocker = new com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCacheWriteLocker();
    private final com.alimm.tanx.ui.image.glide.load.engine.cache.SafeKeyGenerator safeKeyGenerator = new com.alimm.tanx.ui.image.glide.load.engine.cache.SafeKeyGenerator();

    public DiskLruCacheWrapper(java.io.File file, int i) {
        this.directory = file;
        this.maxSize = i;
    }

    public static synchronized com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache get(java.io.File file, int i) {
        com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheWrapper diskLruCacheWrapper;
        synchronized (com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheWrapper.class) {
            if (wrapper == null) {
                wrapper = new com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheWrapper(file, i);
            }
            diskLruCacheWrapper = wrapper;
        }
        return diskLruCacheWrapper;
    }

    private synchronized com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache getDiskCache() throws java.io.IOException {
        if (this.diskLruCache == null) {
            this.diskLruCache = com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.open(this.directory, 1, 1, this.maxSize);
        }
        return this.diskLruCache;
    }

    private synchronized void resetDiskCache() {
        this.diskLruCache = null;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache
    public synchronized void clear() {
        try {
            getDiskCache().delete();
            resetDiskCache();
        } catch (java.io.IOException unused) {
            android.util.Log.isLoggable(TAG, 5);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache
    public void delete(com.alimm.tanx.ui.image.glide.load.Key key) {
        try {
            getDiskCache().remove(this.safeKeyGenerator.getSafeKey(key));
        } catch (java.io.IOException unused) {
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache
    public java.io.File get(com.alimm.tanx.ui.image.glide.load.Key key) {
        try {
            com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Value value = getDiskCache().get(this.safeKeyGenerator.getSafeKey(key));
            if (value != null) {
                return value.getFile(0);
            }
        } catch (java.io.IOException unused) {
        }
        return null;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache
    public void put(com.alimm.tanx.ui.image.glide.load.Key key, com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache.Writer writer) {
        java.lang.String safeKey = this.safeKeyGenerator.getSafeKey(key);
        this.writeLocker.acquire(key);
        try {
            try {
                com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Editor edit = getDiskCache().edit(safeKey);
                if (edit != null) {
                    try {
                        if (writer.write(edit.getFile(0))) {
                            edit.commit();
                        }
                        edit.abortUnlessCommitted();
                    } catch (java.lang.Throwable th) {
                        edit.abortUnlessCommitted();
                        throw th;
                    }
                }
            } catch (java.io.IOException unused) {
                android.util.Log.isLoggable(TAG, 5);
            }
        } finally {
            this.writeLocker.release(key);
        }
    }
}
