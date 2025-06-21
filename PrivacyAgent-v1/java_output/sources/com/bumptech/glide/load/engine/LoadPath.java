package com.bumptech.glide.load.engine;

/* loaded from: classes.dex */
public class LoadPath<Data, ResourceType, Transcode> {
    private final java.lang.Class<Data> dataClass;
    private final java.util.List<? extends com.bumptech.glide.load.engine.DecodePath<Data, ResourceType, Transcode>> decodePaths;
    private final java.lang.String failureMessage;
    private final androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> listPool;

    public LoadPath(java.lang.Class<Data> cls, java.lang.Class<ResourceType> cls2, java.lang.Class<Transcode> cls3, java.util.List<com.bumptech.glide.load.engine.DecodePath<Data, ResourceType, Transcode>> list, androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> pool) {
        this.dataClass = cls;
        this.listPool = pool;
        this.decodePaths = (java.util.List) com.bumptech.glide.util.Preconditions.checkNotEmpty(list);
        this.failureMessage = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + com.alipay.sdk.m.u.i.d;
    }

    private com.bumptech.glide.load.engine.Resource<Transcode> loadWithExceptionList(com.bumptech.glide.load.data.DataRewinder<Data> dataRewinder, @androidx.annotation.NonNull com.bumptech.glide.load.Options options, int i, int i2, com.bumptech.glide.load.engine.DecodePath.DecodeCallback<ResourceType> decodeCallback, java.util.List<java.lang.Throwable> list) throws com.bumptech.glide.load.engine.GlideException {
        int size = this.decodePaths.size();
        com.bumptech.glide.load.engine.Resource<Transcode> resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                resource = this.decodePaths.get(i3).decode(dataRewinder, i, i2, options, decodeCallback);
            } catch (com.bumptech.glide.load.engine.GlideException e) {
                list.add(e);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new com.bumptech.glide.load.engine.GlideException(this.failureMessage, new java.util.ArrayList(list));
    }

    public java.lang.Class<Data> getDataClass() {
        return this.dataClass;
    }

    public com.bumptech.glide.load.engine.Resource<Transcode> load(com.bumptech.glide.load.data.DataRewinder<Data> dataRewinder, @androidx.annotation.NonNull com.bumptech.glide.load.Options options, int i, int i2, com.bumptech.glide.load.engine.DecodePath.DecodeCallback<ResourceType> decodeCallback) throws com.bumptech.glide.load.engine.GlideException {
        java.util.List<java.lang.Throwable> list = (java.util.List) com.bumptech.glide.util.Preconditions.checkNotNull(this.listPool.acquire());
        try {
            return loadWithExceptionList(dataRewinder, options, i, i2, decodeCallback, list);
        } finally {
            this.listPool.release(list);
        }
    }

    public java.lang.String toString() {
        return "LoadPath{decodePaths=" + java.util.Arrays.toString(this.decodePaths.toArray()) + '}';
    }
}
