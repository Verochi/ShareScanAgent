package com.alimm.tanx.ui.image.glide.load.engine.cache;

/* loaded from: classes.dex */
public final class InternalCacheDiskCacheFactory extends com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory {

    /* renamed from: com.alimm.tanx.ui.image.glide.load.engine.cache.InternalCacheDiskCacheFactory$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ java.lang.String val$diskCacheName;

        public AnonymousClass1(android.content.Context context, java.lang.String str) {
            this.val$context = context;
            this.val$diskCacheName = str;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public java.io.File getCacheDirectory() {
            java.io.File cacheDir = this.val$context.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            java.lang.String str = this.val$diskCacheName;
            return str != null ? new java.io.File(cacheDir, str) : cacheDir;
        }
    }

    public InternalCacheDiskCacheFactory(android.content.Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public InternalCacheDiskCacheFactory(android.content.Context context, int i) {
        this(context, "image_manager_disk_cache", i);
    }

    public InternalCacheDiskCacheFactory(android.content.Context context, java.lang.String str, int i) {
        super(new com.alimm.tanx.ui.image.glide.load.engine.cache.InternalCacheDiskCacheFactory.AnonymousClass1(context, str), i);
    }
}
