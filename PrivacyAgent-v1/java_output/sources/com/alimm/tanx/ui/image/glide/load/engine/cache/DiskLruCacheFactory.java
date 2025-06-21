package com.alimm.tanx.ui.image.glide.load.engine.cache;

/* loaded from: classes.dex */
public class DiskLruCacheFactory implements com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache.Factory {
    private final com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter cacheDirectoryGetter;
    private final int diskCacheSize;

    /* renamed from: com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter {
        final /* synthetic */ java.lang.String val$diskCacheFolder;

        public AnonymousClass1(java.lang.String str) {
            this.val$diskCacheFolder = str;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public java.io.File getCacheDirectory() {
            return new java.io.File(this.val$diskCacheFolder);
        }
    }

    /* renamed from: com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter {
        final /* synthetic */ java.lang.String val$diskCacheFolder;
        final /* synthetic */ java.lang.String val$diskCacheName;

        public AnonymousClass2(java.lang.String str, java.lang.String str2) {
            this.val$diskCacheFolder = str;
            this.val$diskCacheName = str2;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public java.io.File getCacheDirectory() {
            return new java.io.File(this.val$diskCacheFolder, this.val$diskCacheName);
        }
    }

    public interface CacheDirectoryGetter {
        java.io.File getCacheDirectory();
    }

    public DiskLruCacheFactory(com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter cacheDirectoryGetter, int i) {
        this.diskCacheSize = i;
        this.cacheDirectoryGetter = cacheDirectoryGetter;
    }

    public DiskLruCacheFactory(java.lang.String str, int i) {
        com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.AnonymousClass1 anonymousClass1 = new com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.AnonymousClass1(str);
        this.diskCacheSize = i;
        this.cacheDirectoryGetter = anonymousClass1;
    }

    public DiskLruCacheFactory(java.lang.String str, java.lang.String str2, int i) {
        com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.AnonymousClass2 anonymousClass2 = new com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.AnonymousClass2(str, str2);
        this.diskCacheSize = i;
        this.cacheDirectoryGetter = anonymousClass2;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache.Factory
    public com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache build() {
        java.io.File cacheDirectory = this.cacheDirectoryGetter.getCacheDirectory();
        if (cacheDirectory == null) {
            return null;
        }
        if (cacheDirectory.mkdirs() || (cacheDirectory.exists() && cacheDirectory.isDirectory())) {
            return com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheWrapper.get(cacheDirectory, this.diskCacheSize);
        }
        return null;
    }
}
