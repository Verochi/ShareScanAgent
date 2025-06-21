package com.bumptech.glide.load.engine;

/* loaded from: classes.dex */
public abstract class DiskCacheStrategy {
    public static final com.bumptech.glide.load.engine.DiskCacheStrategy ALL = new com.bumptech.glide.load.engine.DiskCacheStrategy.AnonymousClass1();
    public static final com.bumptech.glide.load.engine.DiskCacheStrategy NONE = new com.bumptech.glide.load.engine.DiskCacheStrategy.AnonymousClass2();
    public static final com.bumptech.glide.load.engine.DiskCacheStrategy DATA = new com.bumptech.glide.load.engine.DiskCacheStrategy.AnonymousClass3();
    public static final com.bumptech.glide.load.engine.DiskCacheStrategy RESOURCE = new com.bumptech.glide.load.engine.DiskCacheStrategy.AnonymousClass4();
    public static final com.bumptech.glide.load.engine.DiskCacheStrategy AUTOMATIC = new com.bumptech.glide.load.engine.DiskCacheStrategy.AnonymousClass5();

    /* renamed from: com.bumptech.glide.load.engine.DiskCacheStrategy$1, reason: invalid class name */
    public class AnonymousClass1 extends com.bumptech.glide.load.engine.DiskCacheStrategy {
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedData() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedResource() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isDataCacheable(com.bumptech.glide.load.DataSource dataSource) {
            return dataSource == com.bumptech.glide.load.DataSource.REMOTE;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isResourceCacheable(boolean z, com.bumptech.glide.load.DataSource dataSource, com.bumptech.glide.load.EncodeStrategy encodeStrategy) {
            return (dataSource == com.bumptech.glide.load.DataSource.RESOURCE_DISK_CACHE || dataSource == com.bumptech.glide.load.DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.DiskCacheStrategy$2, reason: invalid class name */
    public class AnonymousClass2 extends com.bumptech.glide.load.engine.DiskCacheStrategy {
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedData() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedResource() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isDataCacheable(com.bumptech.glide.load.DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isResourceCacheable(boolean z, com.bumptech.glide.load.DataSource dataSource, com.bumptech.glide.load.EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.DiskCacheStrategy$3, reason: invalid class name */
    public class AnonymousClass3 extends com.bumptech.glide.load.engine.DiskCacheStrategy {
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedData() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedResource() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isDataCacheable(com.bumptech.glide.load.DataSource dataSource) {
            return (dataSource == com.bumptech.glide.load.DataSource.DATA_DISK_CACHE || dataSource == com.bumptech.glide.load.DataSource.MEMORY_CACHE) ? false : true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isResourceCacheable(boolean z, com.bumptech.glide.load.DataSource dataSource, com.bumptech.glide.load.EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.DiskCacheStrategy$4, reason: invalid class name */
    public class AnonymousClass4 extends com.bumptech.glide.load.engine.DiskCacheStrategy {
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedData() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedResource() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isDataCacheable(com.bumptech.glide.load.DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isResourceCacheable(boolean z, com.bumptech.glide.load.DataSource dataSource, com.bumptech.glide.load.EncodeStrategy encodeStrategy) {
            return (dataSource == com.bumptech.glide.load.DataSource.RESOURCE_DISK_CACHE || dataSource == com.bumptech.glide.load.DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.DiskCacheStrategy$5, reason: invalid class name */
    public class AnonymousClass5 extends com.bumptech.glide.load.engine.DiskCacheStrategy {
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedData() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedResource() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isDataCacheable(com.bumptech.glide.load.DataSource dataSource) {
            return dataSource == com.bumptech.glide.load.DataSource.REMOTE;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isResourceCacheable(boolean z, com.bumptech.glide.load.DataSource dataSource, com.bumptech.glide.load.EncodeStrategy encodeStrategy) {
            return ((z && dataSource == com.bumptech.glide.load.DataSource.DATA_DISK_CACHE) || dataSource == com.bumptech.glide.load.DataSource.LOCAL) && encodeStrategy == com.bumptech.glide.load.EncodeStrategy.TRANSFORMED;
        }
    }

    public abstract boolean decodeCachedData();

    public abstract boolean decodeCachedResource();

    public abstract boolean isDataCacheable(com.bumptech.glide.load.DataSource dataSource);

    public abstract boolean isResourceCacheable(boolean z, com.bumptech.glide.load.DataSource dataSource, com.bumptech.glide.load.EncodeStrategy encodeStrategy);
}
