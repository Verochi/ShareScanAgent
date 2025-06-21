package com.bumptech.glide.load.engine;

/* loaded from: classes.dex */
public class DecodePath<DataType, ResourceType, Transcode> {
    private static final java.lang.String TAG = "DecodePath";
    private final java.lang.Class<DataType> dataClass;
    private final java.util.List<? extends com.bumptech.glide.load.ResourceDecoder<DataType, ResourceType>> decoders;
    private final java.lang.String failureMessage;
    private final androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> listPool;
    private final com.bumptech.glide.load.resource.transcode.ResourceTranscoder<ResourceType, Transcode> transcoder;

    public interface DecodeCallback<ResourceType> {
        @androidx.annotation.NonNull
        com.bumptech.glide.load.engine.Resource<ResourceType> onResourceDecoded(@androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<ResourceType> resource);
    }

    public DecodePath(java.lang.Class<DataType> cls, java.lang.Class<ResourceType> cls2, java.lang.Class<Transcode> cls3, java.util.List<? extends com.bumptech.glide.load.ResourceDecoder<DataType, ResourceType>> list, com.bumptech.glide.load.resource.transcode.ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> pool) {
        this.dataClass = cls;
        this.decoders = list;
        this.transcoder = resourceTranscoder;
        this.listPool = pool;
        this.failureMessage = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + com.alipay.sdk.m.u.i.d;
    }

    @androidx.annotation.NonNull
    private com.bumptech.glide.load.engine.Resource<ResourceType> decodeResource(com.bumptech.glide.load.data.DataRewinder<DataType> dataRewinder, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) throws com.bumptech.glide.load.engine.GlideException {
        java.util.List<java.lang.Throwable> list = (java.util.List) com.bumptech.glide.util.Preconditions.checkNotNull(this.listPool.acquire());
        try {
            return decodeResourceWithList(dataRewinder, i, i2, options, list);
        } finally {
            this.listPool.release(list);
        }
    }

    @androidx.annotation.NonNull
    private com.bumptech.glide.load.engine.Resource<ResourceType> decodeResourceWithList(com.bumptech.glide.load.data.DataRewinder<DataType> dataRewinder, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options, java.util.List<java.lang.Throwable> list) throws com.bumptech.glide.load.engine.GlideException {
        int size = this.decoders.size();
        com.bumptech.glide.load.engine.Resource<ResourceType> resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            com.bumptech.glide.load.ResourceDecoder<DataType, ResourceType> resourceDecoder = this.decoders.get(i3);
            try {
                if (resourceDecoder.handles(dataRewinder.rewindAndGet(), options)) {
                    resource = resourceDecoder.decode(dataRewinder.rewindAndGet(), i, i2, options);
                }
            } catch (java.io.IOException | java.lang.OutOfMemoryError | java.lang.RuntimeException e) {
                if (android.util.Log.isLoggable(TAG, 2)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Failed to decode data for ");
                    sb.append(resourceDecoder);
                }
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

    public com.bumptech.glide.load.engine.Resource<Transcode> decode(com.bumptech.glide.load.data.DataRewinder<DataType> dataRewinder, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options, com.bumptech.glide.load.engine.DecodePath.DecodeCallback<ResourceType> decodeCallback) throws com.bumptech.glide.load.engine.GlideException {
        return this.transcoder.transcode(decodeCallback.onResourceDecoded(decodeResource(dataRewinder, i, i2, options)), options);
    }

    public java.lang.String toString() {
        return "DecodePath{ dataClass=" + this.dataClass + ", decoders=" + this.decoders + ", transcoder=" + this.transcoder + '}';
    }
}
