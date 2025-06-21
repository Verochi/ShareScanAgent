package com.bumptech.glide.load.engine;

/* loaded from: classes.dex */
class EngineKey implements com.bumptech.glide.load.Key {
    private int hashCode;
    private final int height;
    private final java.lang.Object model;
    private final com.bumptech.glide.load.Options options;
    private final java.lang.Class<?> resourceClass;
    private final com.bumptech.glide.load.Key signature;
    private final java.lang.Class<?> transcodeClass;
    private final java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.Transformation<?>> transformations;
    private final int width;

    public EngineKey(java.lang.Object obj, com.bumptech.glide.load.Key key, int i, int i2, java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.Transformation<?>> map, java.lang.Class<?> cls, java.lang.Class<?> cls2, com.bumptech.glide.load.Options options) {
        this.model = com.bumptech.glide.util.Preconditions.checkNotNull(obj);
        this.signature = (com.bumptech.glide.load.Key) com.bumptech.glide.util.Preconditions.checkNotNull(key, "Signature must not be null");
        this.width = i;
        this.height = i2;
        this.transformations = (java.util.Map) com.bumptech.glide.util.Preconditions.checkNotNull(map);
        this.resourceClass = (java.lang.Class) com.bumptech.glide.util.Preconditions.checkNotNull(cls, "Resource class must not be null");
        this.transcodeClass = (java.lang.Class) com.bumptech.glide.util.Preconditions.checkNotNull(cls2, "Transcode class must not be null");
        this.options = (com.bumptech.glide.load.Options) com.bumptech.glide.util.Preconditions.checkNotNull(options);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.bumptech.glide.load.engine.EngineKey)) {
            return false;
        }
        com.bumptech.glide.load.engine.EngineKey engineKey = (com.bumptech.glide.load.engine.EngineKey) obj;
        return this.model.equals(engineKey.model) && this.signature.equals(engineKey.signature) && this.height == engineKey.height && this.width == engineKey.width && this.transformations.equals(engineKey.transformations) && this.resourceClass.equals(engineKey.resourceClass) && this.transcodeClass.equals(engineKey.transcodeClass) && this.options.equals(engineKey.options);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.hashCode == 0) {
            int hashCode = this.model.hashCode();
            this.hashCode = hashCode;
            int hashCode2 = (((((hashCode * 31) + this.signature.hashCode()) * 31) + this.width) * 31) + this.height;
            this.hashCode = hashCode2;
            int hashCode3 = (hashCode2 * 31) + this.transformations.hashCode();
            this.hashCode = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.resourceClass.hashCode();
            this.hashCode = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.transcodeClass.hashCode();
            this.hashCode = hashCode5;
            this.hashCode = (hashCode5 * 31) + this.options.hashCode();
        }
        return this.hashCode;
    }

    public java.lang.String toString() {
        return "EngineKey{model=" + this.model + ", width=" + this.width + ", height=" + this.height + ", resourceClass=" + this.resourceClass + ", transcodeClass=" + this.transcodeClass + ", signature=" + this.signature + ", hashCode=" + this.hashCode + ", transformations=" + this.transformations + ", options=" + this.options + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        throw new java.lang.UnsupportedOperationException();
    }
}
