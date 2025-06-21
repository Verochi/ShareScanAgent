package com.bumptech.glide.load.engine.cache;

@java.lang.Deprecated
/* loaded from: classes.dex */
public final class ExternalCacheDiskCacheFactory extends com.bumptech.glide.load.engine.cache.DiskLruCacheFactory {

    /* renamed from: com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ java.lang.String val$diskCacheName;

        public AnonymousClass1(android.content.Context context, java.lang.String str) {
            this.val$context = context;
            this.val$diskCacheName = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public java.io.File getCacheDirectory() {
            java.io.File externalCacheDir = this.val$context.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            return this.val$diskCacheName != null ? new java.io.File(externalCacheDir, this.val$diskCacheName) : externalCacheDir;
        }
    }

    public ExternalCacheDiskCacheFactory(android.content.Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public ExternalCacheDiskCacheFactory(android.content.Context context, int i) {
        this(context, "image_manager_disk_cache", i);
    }

    public ExternalCacheDiskCacheFactory(android.content.Context context, java.lang.String str, int i) {
        super(new com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory.AnonymousClass1(context, str), i);
    }
}
