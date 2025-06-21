package com.bumptech.glide.load.engine;

/* loaded from: classes.dex */
class DataCacheWriter<DataType> implements com.bumptech.glide.load.engine.cache.DiskCache.Writer {
    private final DataType data;
    private final com.bumptech.glide.load.Encoder<DataType> encoder;
    private final com.bumptech.glide.load.Options options;

    public DataCacheWriter(com.bumptech.glide.load.Encoder<DataType> encoder, DataType datatype, com.bumptech.glide.load.Options options) {
        this.encoder = encoder;
        this.data = datatype;
        this.options = options;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Writer
    public boolean write(@androidx.annotation.NonNull java.io.File file) {
        return this.encoder.encode(this.data, file, this.options);
    }
}
