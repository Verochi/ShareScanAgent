package com.alimm.tanx.ui.image.glide;

/* loaded from: classes.dex */
public class GenericTranscodeRequest<ModelType, DataType, ResourceType> extends com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, ResourceType> implements com.alimm.tanx.ui.image.glide.DownloadOptions {
    private final java.lang.Class<DataType> dataClass;
    private final com.alimm.tanx.ui.image.glide.load.model.ModelLoader<ModelType, DataType> modelLoader;
    private final com.alimm.tanx.ui.image.glide.RequestManager.OptionsApplier optionsApplier;
    private final java.lang.Class<ResourceType> resourceClass;

    public GenericTranscodeRequest(android.content.Context context, com.alimm.tanx.ui.image.glide.Glide glide, java.lang.Class<ModelType> cls, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<ModelType, DataType> modelLoader, java.lang.Class<DataType> cls2, java.lang.Class<ResourceType> cls3, com.alimm.tanx.ui.image.glide.manager.RequestTracker requestTracker, com.alimm.tanx.ui.image.glide.manager.Lifecycle lifecycle, com.alimm.tanx.ui.image.glide.RequestManager.OptionsApplier optionsApplier) {
        super(context, cls, new com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider(modelLoader, com.alimm.tanx.ui.image.glide.load.resource.transcode.UnitTranscoder.get(), glide.buildDataProvider(cls2, cls3)), cls3, glide, requestTracker, lifecycle);
        this.modelLoader = modelLoader;
        this.dataClass = cls2;
        this.resourceClass = cls3;
        this.optionsApplier = optionsApplier;
    }

    public GenericTranscodeRequest(java.lang.Class<ResourceType> cls, com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, ?, ?, ?> genericRequestBuilder, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<ModelType, DataType> modelLoader, java.lang.Class<DataType> cls2, java.lang.Class<ResourceType> cls3, com.alimm.tanx.ui.image.glide.RequestManager.OptionsApplier optionsApplier) {
        super(build(genericRequestBuilder.glide, modelLoader, cls2, cls3, com.alimm.tanx.ui.image.glide.load.resource.transcode.UnitTranscoder.get()), cls, genericRequestBuilder);
        this.modelLoader = modelLoader;
        this.dataClass = cls2;
        this.resourceClass = cls3;
        this.optionsApplier = optionsApplier;
    }

    private static <A, T, Z, R> com.alimm.tanx.ui.image.glide.provider.LoadProvider<A, T, Z, R> build(com.alimm.tanx.ui.image.glide.Glide glide, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, T> modelLoader, java.lang.Class<T> cls, java.lang.Class<Z> cls2, com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<Z, R> resourceTranscoder) {
        return new com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider(modelLoader, resourceTranscoder, glide.buildDataProvider(cls, cls2));
    }

    private com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, java.io.File, java.io.File> getDownloadOnlyRequest() {
        return this.optionsApplier.apply(new com.alimm.tanx.ui.image.glide.GenericRequestBuilder(new com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider(this.modelLoader, com.alimm.tanx.ui.image.glide.load.resource.transcode.UnitTranscoder.get(), this.glide.buildDataProvider(this.dataClass, java.io.File.class)), java.io.File.class, this)).priority(com.alimm.tanx.ui.image.glide.Priority.LOW).diskCacheStrategy(com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy.SOURCE).skipMemoryCache(true);
    }

    @Override // com.alimm.tanx.ui.image.glide.DownloadOptions
    public com.alimm.tanx.ui.image.glide.request.FutureTarget<java.io.File> downloadOnly(int i, int i2) {
        return getDownloadOnlyRequest().into(i, i2);
    }

    @Override // com.alimm.tanx.ui.image.glide.DownloadOptions
    public <Y extends com.alimm.tanx.ui.image.glide.request.target.Target<java.io.File>> Y downloadOnly(Y y) {
        return (Y) getDownloadOnlyRequest().into((com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, java.io.File, java.io.File>) y);
    }

    public <TranscodeType> com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> transcode(com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<ResourceType, TranscodeType> resourceTranscoder, java.lang.Class<TranscodeType> cls) {
        return this.optionsApplier.apply(new com.alimm.tanx.ui.image.glide.GenericRequestBuilder(build(this.glide, this.modelLoader, this.dataClass, this.resourceClass, resourceTranscoder), cls, this));
    }
}
