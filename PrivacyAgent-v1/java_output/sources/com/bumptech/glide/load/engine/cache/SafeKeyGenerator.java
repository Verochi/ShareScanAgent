package com.bumptech.glide.load.engine.cache;

/* loaded from: classes.dex */
public class SafeKeyGenerator {
    private final com.bumptech.glide.util.LruCache<com.bumptech.glide.load.Key, java.lang.String> loadIdToSafeHash = new com.bumptech.glide.util.LruCache<>(1000);
    private final androidx.core.util.Pools.Pool<com.bumptech.glide.load.engine.cache.SafeKeyGenerator.PoolableDigestContainer> digestPool = com.bumptech.glide.util.pool.FactoryPools.threadSafe(10, new com.bumptech.glide.load.engine.cache.SafeKeyGenerator.AnonymousClass1());

    /* renamed from: com.bumptech.glide.load.engine.cache.SafeKeyGenerator$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bumptech.glide.util.pool.FactoryPools.Factory<com.bumptech.glide.load.engine.cache.SafeKeyGenerator.PoolableDigestContainer> {
        public AnonymousClass1() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        public com.bumptech.glide.load.engine.cache.SafeKeyGenerator.PoolableDigestContainer create() {
            try {
                return new com.bumptech.glide.load.engine.cache.SafeKeyGenerator.PoolableDigestContainer(java.security.MessageDigest.getInstance("SHA-256"));
            } catch (java.security.NoSuchAlgorithmException e) {
                throw new java.lang.RuntimeException(e);
            }
        }
    }

    public static final class PoolableDigestContainer implements com.bumptech.glide.util.pool.FactoryPools.Poolable {
        final java.security.MessageDigest messageDigest;
        private final com.bumptech.glide.util.pool.StateVerifier stateVerifier = com.bumptech.glide.util.pool.StateVerifier.newInstance();

        public PoolableDigestContainer(java.security.MessageDigest messageDigest) {
            this.messageDigest = messageDigest;
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
        @androidx.annotation.NonNull
        public com.bumptech.glide.util.pool.StateVerifier getVerifier() {
            return this.stateVerifier;
        }
    }

    private java.lang.String calculateHexStringDigest(com.bumptech.glide.load.Key key) {
        com.bumptech.glide.load.engine.cache.SafeKeyGenerator.PoolableDigestContainer poolableDigestContainer = (com.bumptech.glide.load.engine.cache.SafeKeyGenerator.PoolableDigestContainer) com.bumptech.glide.util.Preconditions.checkNotNull(this.digestPool.acquire());
        try {
            key.updateDiskCacheKey(poolableDigestContainer.messageDigest);
            return com.bumptech.glide.util.Util.sha256BytesToHex(poolableDigestContainer.messageDigest.digest());
        } finally {
            this.digestPool.release(poolableDigestContainer);
        }
    }

    public java.lang.String getSafeKey(com.bumptech.glide.load.Key key) {
        java.lang.String str;
        synchronized (this.loadIdToSafeHash) {
            str = this.loadIdToSafeHash.get(key);
        }
        if (str == null) {
            str = calculateHexStringDigest(key);
        }
        synchronized (this.loadIdToSafeHash) {
            this.loadIdToSafeHash.put(key, str);
        }
        return str;
    }
}
