package com.bumptech.glide.load.engine.cache;

/* loaded from: classes.dex */
public final class InternalCacheDiskCacheFactory extends com.bumptech.glide.load.engine.cache.DiskLruCacheFactory {

    /* renamed from: com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ java.lang.String val$diskCacheName;

        public AnonymousClass1(android.content.Context context, java.lang.String str) {
            this.val$context = context;
            this.val$diskCacheName = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public java.io.File getCacheDirectory() {
            java.io.File cacheDir = this.val$context.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.val$diskCacheName != null ? new java.io.File(cacheDir, this.val$diskCacheName) : cacheDir;
        }
    }

    public InternalCacheDiskCacheFactory(android.content.Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public InternalCacheDiskCacheFactory(android.content.Context context, long j) {
        this(context, "image_manager_disk_cache", j);
    }

    public InternalCacheDiskCacheFactory(android.content.Context context, java.lang.String str, long j) {
        super(new com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory.AnonymousClass1(context, str), j);
    }
}
