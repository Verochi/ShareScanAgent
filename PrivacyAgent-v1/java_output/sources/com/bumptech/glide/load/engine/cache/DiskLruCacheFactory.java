package com.bumptech.glide.load.engine.cache;

/* loaded from: classes.dex */
public class DiskLruCacheFactory implements com.bumptech.glide.load.engine.cache.DiskCache.Factory {
    private final com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter cacheDirectoryGetter;
    private final long diskCacheSize;

    /* renamed from: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter {
        final /* synthetic */ java.lang.String val$diskCacheFolder;

        public AnonymousClass1(java.lang.String str) {
            this.val$diskCacheFolder = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public java.io.File getCacheDirectory() {
            return new java.io.File(this.val$diskCacheFolder);
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$2, reason: invalid class name */
    public class AnonymousClass2 implements com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter {
        final /* synthetic */ java.lang.String val$diskCacheFolder;
        final /* synthetic */ java.lang.String val$diskCacheName;

        public AnonymousClass2(java.lang.String str, java.lang.String str2) {
            this.val$diskCacheFolder = str;
            this.val$diskCacheName = str2;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public java.io.File getCacheDirectory() {
            return new java.io.File(this.val$diskCacheFolder, this.val$diskCacheName);
        }
    }

    public interface CacheDirectoryGetter {
        java.io.File getCacheDirectory();
    }

    public DiskLruCacheFactory(com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter cacheDirectoryGetter, long j) {
        this.diskCacheSize = j;
        this.cacheDirectoryGetter = cacheDirectoryGetter;
    }

    public DiskLruCacheFactory(java.lang.String str, long j) {
        this(new com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.AnonymousClass1(str), j);
    }

    public DiskLruCacheFactory(java.lang.String str, java.lang.String str2, long j) {
        this(new com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.AnonymousClass2(str, str2), j);
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
    public com.bumptech.glide.load.engine.cache.DiskCache build() {
        java.io.File cacheDirectory = this.cacheDirectoryGetter.getCacheDirectory();
        if (cacheDirectory == null) {
            return null;
        }
        if (cacheDirectory.mkdirs() || (cacheDirectory.exists() && cacheDirectory.isDirectory())) {
            return com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper.create(cacheDirectory, this.diskCacheSize);
        }
        return null;
    }
}
