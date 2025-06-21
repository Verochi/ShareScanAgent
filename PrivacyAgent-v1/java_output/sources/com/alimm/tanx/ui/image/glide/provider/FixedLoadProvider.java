package com.alimm.tanx.ui.image.glide.provider;

/* loaded from: classes.dex */
public class FixedLoadProvider<A, T, Z, R> implements com.alimm.tanx.ui.image.glide.provider.LoadProvider<A, T, Z, R> {
    private final com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<T, Z> dataLoadProvider;
    private final com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, T> modelLoader;
    private final com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<Z, R> transcoder;

    public FixedLoadProvider(com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, T> modelLoader, com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<Z, R> resourceTranscoder, com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<T, Z> dataLoadProvider) {
        if (modelLoader == null) {
            throw new java.lang.NullPointerException("ModelLoader must not be null");
        }
        this.modelLoader = modelLoader;
        if (resourceTranscoder == null) {
            throw new java.lang.NullPointerException("Transcoder must not be null");
        }
        this.transcoder = resourceTranscoder;
        if (dataLoadProvider == null) {
            throw new java.lang.NullPointerException("DataLoadProvider must not be null");
        }
        this.dataLoadProvider = dataLoadProvider;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, Z> getCacheDecoder() {
        return this.dataLoadProvider.getCacheDecoder();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceEncoder<Z> getEncoder() {
        return this.dataLoadProvider.getEncoder();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.LoadProvider
    public com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, T> getModelLoader() {
        return this.modelLoader;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceDecoder<T, Z> getSourceDecoder() {
        return this.dataLoadProvider.getSourceDecoder();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.Encoder<T> getSourceEncoder() {
        return this.dataLoadProvider.getSourceEncoder();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.LoadProvider
    public com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<Z, R> getTranscoder() {
        return this.transcoder;
    }
}
