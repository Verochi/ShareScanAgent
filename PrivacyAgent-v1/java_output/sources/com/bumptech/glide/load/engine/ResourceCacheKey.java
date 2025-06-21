package com.bumptech.glide.load.engine;

/* loaded from: classes.dex */
final class ResourceCacheKey implements com.bumptech.glide.load.Key {
    private static final com.bumptech.glide.util.LruCache<java.lang.Class<?>, byte[]> RESOURCE_CLASS_BYTES = new com.bumptech.glide.util.LruCache<>(50);
    private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool;
    private final java.lang.Class<?> decodedResourceClass;
    private final int height;
    private final com.bumptech.glide.load.Options options;
    private final com.bumptech.glide.load.Key signature;
    private final com.bumptech.glide.load.Key sourceKey;
    private final com.bumptech.glide.load.Transformation<?> transformation;
    private final int width;

    public ResourceCacheKey(com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool, com.bumptech.glide.load.Key key, com.bumptech.glide.load.Key key2, int i, int i2, com.bumptech.glide.load.Transformation<?> transformation, java.lang.Class<?> cls, com.bumptech.glide.load.Options options) {
        this.arrayPool = arrayPool;
        this.sourceKey = key;
        this.signature = key2;
        this.width = i;
        this.height = i2;
        this.transformation = transformation;
        this.decodedResourceClass = cls;
        this.options = options;
    }

    private byte[] getResourceClassBytes() {
        com.bumptech.glide.util.LruCache<java.lang.Class<?>, byte[]> lruCache = RESOURCE_CLASS_BYTES;
        byte[] bArr = lruCache.get(this.decodedResourceClass);
        if (bArr != null) {
            return bArr;
        }
        byte[] bytes = this.decodedResourceClass.getName().getBytes(com.bumptech.glide.load.Key.CHARSET);
        lruCache.put(this.decodedResourceClass, bytes);
        return bytes;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.bumptech.glide.load.engine.ResourceCacheKey)) {
            return false;
        }
        com.bumptech.glide.load.engine.ResourceCacheKey resourceCacheKey = (com.bumptech.glide.load.engine.ResourceCacheKey) obj;
        return this.height == resourceCacheKey.height && this.width == resourceCacheKey.width && com.bumptech.glide.util.Util.bothNullOrEqual(this.transformation, resourceCacheKey.transformation) && this.decodedResourceClass.equals(resourceCacheKey.decodedResourceClass) && this.sourceKey.equals(resourceCacheKey.sourceKey) && this.signature.equals(resourceCacheKey.signature) && this.options.equals(resourceCacheKey.options);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int hashCode = (((((this.sourceKey.hashCode() * 31) + this.signature.hashCode()) * 31) + this.width) * 31) + this.height;
        com.bumptech.glide.load.Transformation<?> transformation = this.transformation;
        if (transformation != null) {
            hashCode = (hashCode * 31) + transformation.hashCode();
        }
        return (((hashCode * 31) + this.decodedResourceClass.hashCode()) * 31) + this.options.hashCode();
    }

    public java.lang.String toString() {
        return "ResourceCacheKey{sourceKey=" + this.sourceKey + ", signature=" + this.signature + ", width=" + this.width + ", height=" + this.height + ", decodedResourceClass=" + this.decodedResourceClass + ", transformation='" + this.transformation + "', options=" + this.options + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.arrayPool.getExact(8, byte[].class);
        java.nio.ByteBuffer.wrap(bArr).putInt(this.width).putInt(this.height).array();
        this.signature.updateDiskCacheKey(messageDigest);
        this.sourceKey.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        com.bumptech.glide.load.Transformation<?> transformation = this.transformation;
        if (transformation != null) {
            transformation.updateDiskCacheKey(messageDigest);
        }
        this.options.updateDiskCacheKey(messageDigest);
        messageDigest.update(getResourceClassBytes());
        this.arrayPool.put(bArr);
    }
}
