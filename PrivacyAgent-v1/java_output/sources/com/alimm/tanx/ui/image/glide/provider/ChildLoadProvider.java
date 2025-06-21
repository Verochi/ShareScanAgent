package com.alimm.tanx.ui.image.glide.provider;

/* loaded from: classes.dex */
public class ChildLoadProvider<A, T, Z, R> implements com.alimm.tanx.ui.image.glide.provider.LoadProvider<A, T, Z, R>, java.lang.Cloneable {
    private com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, Z> cacheDecoder;
    private com.alimm.tanx.ui.image.glide.load.ResourceEncoder<Z> encoder;
    private final com.alimm.tanx.ui.image.glide.provider.LoadProvider<A, T, Z, R> parent;
    private com.alimm.tanx.ui.image.glide.load.ResourceDecoder<T, Z> sourceDecoder;
    private com.alimm.tanx.ui.image.glide.load.Encoder<T> sourceEncoder;
    private com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<Z, R> transcoder;

    public ChildLoadProvider(com.alimm.tanx.ui.image.glide.provider.LoadProvider<A, T, Z, R> loadProvider) {
        this.parent = loadProvider;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.alimm.tanx.ui.image.glide.provider.ChildLoadProvider<A, T, Z, R> m10clone() {
        try {
            return (com.alimm.tanx.ui.image.glide.provider.ChildLoadProvider) super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, Z> getCacheDecoder() {
        com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, Z> resourceDecoder = this.cacheDecoder;
        return resourceDecoder != null ? resourceDecoder : this.parent.getCacheDecoder();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceEncoder<Z> getEncoder() {
        com.alimm.tanx.ui.image.glide.load.ResourceEncoder<Z> resourceEncoder = this.encoder;
        return resourceEncoder != null ? resourceEncoder : this.parent.getEncoder();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.LoadProvider
    public com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, T> getModelLoader() {
        return this.parent.getModelLoader();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceDecoder<T, Z> getSourceDecoder() {
        com.alimm.tanx.ui.image.glide.load.ResourceDecoder<T, Z> resourceDecoder = this.sourceDecoder;
        return resourceDecoder != null ? resourceDecoder : this.parent.getSourceDecoder();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.Encoder<T> getSourceEncoder() {
        com.alimm.tanx.ui.image.glide.load.Encoder<T> encoder = this.sourceEncoder;
        return encoder != null ? encoder : this.parent.getSourceEncoder();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.LoadProvider
    public com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<Z, R> getTranscoder() {
        com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<Z, R> resourceTranscoder = this.transcoder;
        return resourceTranscoder != null ? resourceTranscoder : this.parent.getTranscoder();
    }

    public void setCacheDecoder(com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, Z> resourceDecoder) {
        this.cacheDecoder = resourceDecoder;
    }

    public void setEncoder(com.alimm.tanx.ui.image.glide.load.ResourceEncoder<Z> resourceEncoder) {
        this.encoder = resourceEncoder;
    }

    public void setSourceDecoder(com.alimm.tanx.ui.image.glide.load.ResourceDecoder<T, Z> resourceDecoder) {
        this.sourceDecoder = resourceDecoder;
    }

    public void setSourceEncoder(com.alimm.tanx.ui.image.glide.load.Encoder<T> encoder) {
        this.sourceEncoder = encoder;
    }

    public void setTranscoder(com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<Z, R> resourceTranscoder) {
        this.transcoder = resourceTranscoder;
    }
}
