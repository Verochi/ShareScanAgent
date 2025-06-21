package com.bumptech.glide;

/* loaded from: classes.dex */
public class Registry {
    private static final java.lang.String BUCKET_APPEND_ALL = "legacy_append";
    public static final java.lang.String BUCKET_BITMAP = "Bitmap";
    public static final java.lang.String BUCKET_BITMAP_DRAWABLE = "BitmapDrawable";
    public static final java.lang.String BUCKET_GIF = "Gif";
    private static final java.lang.String BUCKET_PREPEND_ALL = "legacy_prepend_all";
    private final com.bumptech.glide.load.data.DataRewinderRegistry dataRewinderRegistry;
    private final com.bumptech.glide.provider.ResourceDecoderRegistry decoderRegistry;
    private final com.bumptech.glide.provider.EncoderRegistry encoderRegistry;
    private final com.bumptech.glide.provider.ImageHeaderParserRegistry imageHeaderParserRegistry;
    private final com.bumptech.glide.load.model.ModelLoaderRegistry modelLoaderRegistry;
    private final com.bumptech.glide.provider.ResourceEncoderRegistry resourceEncoderRegistry;
    private final androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> throwableListPool;
    private final com.bumptech.glide.load.resource.transcode.TranscoderRegistry transcoderRegistry;
    private final com.bumptech.glide.provider.ModelToResourceClassCache modelToResourceClassCache = new com.bumptech.glide.provider.ModelToResourceClassCache();
    private final com.bumptech.glide.provider.LoadPathCache loadPathCache = new com.bumptech.glide.provider.LoadPathCache();

    public static class MissingComponentException extends java.lang.RuntimeException {
        public MissingComponentException(@androidx.annotation.NonNull java.lang.String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends com.bumptech.glide.Registry.MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends com.bumptech.glide.Registry.MissingComponentException {
        public NoModelLoaderAvailableException(@androidx.annotation.NonNull java.lang.Class<?> cls, @androidx.annotation.NonNull java.lang.Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }

        public NoModelLoaderAvailableException(@androidx.annotation.NonNull java.lang.Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(@androidx.annotation.NonNull M m, @androidx.annotation.NonNull java.util.List<com.bumptech.glide.load.model.ModelLoader<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }
    }

    public static class NoResultEncoderAvailableException extends com.bumptech.glide.Registry.MissingComponentException {
        public NoResultEncoderAvailableException(@androidx.annotation.NonNull java.lang.Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends com.bumptech.glide.Registry.MissingComponentException {
        public NoSourceEncoderAvailableException(@androidx.annotation.NonNull java.lang.Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> threadSafeList = com.bumptech.glide.util.pool.FactoryPools.threadSafeList();
        this.throwableListPool = threadSafeList;
        this.modelLoaderRegistry = new com.bumptech.glide.load.model.ModelLoaderRegistry(threadSafeList);
        this.encoderRegistry = new com.bumptech.glide.provider.EncoderRegistry();
        this.decoderRegistry = new com.bumptech.glide.provider.ResourceDecoderRegistry();
        this.resourceEncoderRegistry = new com.bumptech.glide.provider.ResourceEncoderRegistry();
        this.dataRewinderRegistry = new com.bumptech.glide.load.data.DataRewinderRegistry();
        this.transcoderRegistry = new com.bumptech.glide.load.resource.transcode.TranscoderRegistry();
        this.imageHeaderParserRegistry = new com.bumptech.glide.provider.ImageHeaderParserRegistry();
        setResourceDecoderBucketPriorityList(java.util.Arrays.asList(BUCKET_GIF, BUCKET_BITMAP, BUCKET_BITMAP_DRAWABLE));
    }

    @androidx.annotation.NonNull
    private <Data, TResource, Transcode> java.util.List<com.bumptech.glide.load.engine.DecodePath<Data, TResource, Transcode>> getDecodePaths(@androidx.annotation.NonNull java.lang.Class<Data> cls, @androidx.annotation.NonNull java.lang.Class<TResource> cls2, @androidx.annotation.NonNull java.lang.Class<Transcode> cls3) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Class cls4 : this.decoderRegistry.getResourceClasses(cls, cls2)) {
            for (java.lang.Class cls5 : this.transcoderRegistry.getTranscodeClasses(cls4, cls3)) {
                arrayList.add(new com.bumptech.glide.load.engine.DecodePath(cls, cls4, cls5, this.decoderRegistry.getDecoders(cls, cls4), this.transcoderRegistry.get(cls4, cls5), this.throwableListPool));
            }
        }
        return arrayList;
    }

    @androidx.annotation.NonNull
    public <Data> com.bumptech.glide.Registry append(@androidx.annotation.NonNull java.lang.Class<Data> cls, @androidx.annotation.NonNull com.bumptech.glide.load.Encoder<Data> encoder) {
        this.encoderRegistry.append(cls, encoder);
        return this;
    }

    @androidx.annotation.NonNull
    public <TResource> com.bumptech.glide.Registry append(@androidx.annotation.NonNull java.lang.Class<TResource> cls, @androidx.annotation.NonNull com.bumptech.glide.load.ResourceEncoder<TResource> resourceEncoder) {
        this.resourceEncoderRegistry.append(cls, resourceEncoder);
        return this;
    }

    @androidx.annotation.NonNull
    public <Data, TResource> com.bumptech.glide.Registry append(@androidx.annotation.NonNull java.lang.Class<Data> cls, @androidx.annotation.NonNull java.lang.Class<TResource> cls2, @androidx.annotation.NonNull com.bumptech.glide.load.ResourceDecoder<Data, TResource> resourceDecoder) {
        append(BUCKET_APPEND_ALL, cls, cls2, resourceDecoder);
        return this;
    }

    @androidx.annotation.NonNull
    public <Model, Data> com.bumptech.glide.Registry append(@androidx.annotation.NonNull java.lang.Class<Model> cls, @androidx.annotation.NonNull java.lang.Class<Data> cls2, @androidx.annotation.NonNull com.bumptech.glide.load.model.ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.modelLoaderRegistry.append(cls, cls2, modelLoaderFactory);
        return this;
    }

    @androidx.annotation.NonNull
    public <Data, TResource> com.bumptech.glide.Registry append(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.Class<Data> cls, @androidx.annotation.NonNull java.lang.Class<TResource> cls2, @androidx.annotation.NonNull com.bumptech.glide.load.ResourceDecoder<Data, TResource> resourceDecoder) {
        this.decoderRegistry.append(str, resourceDecoder, cls, cls2);
        return this;
    }

    @androidx.annotation.NonNull
    public java.util.List<com.bumptech.glide.load.ImageHeaderParser> getImageHeaderParsers() {
        java.util.List<com.bumptech.glide.load.ImageHeaderParser> parsers = this.imageHeaderParserRegistry.getParsers();
        if (parsers.isEmpty()) {
            throw new com.bumptech.glide.Registry.NoImageHeaderParserException();
        }
        return parsers;
    }

    @androidx.annotation.Nullable
    public <Data, TResource, Transcode> com.bumptech.glide.load.engine.LoadPath<Data, TResource, Transcode> getLoadPath(@androidx.annotation.NonNull java.lang.Class<Data> cls, @androidx.annotation.NonNull java.lang.Class<TResource> cls2, @androidx.annotation.NonNull java.lang.Class<Transcode> cls3) {
        com.bumptech.glide.load.engine.LoadPath<Data, TResource, Transcode> loadPath = this.loadPathCache.get(cls, cls2, cls3);
        if (this.loadPathCache.isEmptyLoadPath(loadPath)) {
            return null;
        }
        if (loadPath == null) {
            java.util.List<com.bumptech.glide.load.engine.DecodePath<Data, TResource, Transcode>> decodePaths = getDecodePaths(cls, cls2, cls3);
            loadPath = decodePaths.isEmpty() ? null : new com.bumptech.glide.load.engine.LoadPath<>(cls, cls2, cls3, decodePaths, this.throwableListPool);
            this.loadPathCache.put(cls, cls2, cls3, loadPath);
        }
        return loadPath;
    }

    @androidx.annotation.NonNull
    public <Model> java.util.List<com.bumptech.glide.load.model.ModelLoader<Model, ?>> getModelLoaders(@androidx.annotation.NonNull Model model) {
        return this.modelLoaderRegistry.getModelLoaders(model);
    }

    @androidx.annotation.NonNull
    public <Model, TResource, Transcode> java.util.List<java.lang.Class<?>> getRegisteredResourceClasses(@androidx.annotation.NonNull java.lang.Class<Model> cls, @androidx.annotation.NonNull java.lang.Class<TResource> cls2, @androidx.annotation.NonNull java.lang.Class<Transcode> cls3) {
        java.util.List<java.lang.Class<?>> list = this.modelToResourceClassCache.get(cls, cls2, cls3);
        if (list == null) {
            list = new java.util.ArrayList<>();
            java.util.Iterator<java.lang.Class<?>> it = this.modelLoaderRegistry.getDataClasses(cls).iterator();
            while (it.hasNext()) {
                for (java.lang.Class<?> cls4 : this.decoderRegistry.getResourceClasses(it.next(), cls2)) {
                    if (!this.transcoderRegistry.getTranscodeClasses(cls4, cls3).isEmpty() && !list.contains(cls4)) {
                        list.add(cls4);
                    }
                }
            }
            this.modelToResourceClassCache.put(cls, cls2, cls3, java.util.Collections.unmodifiableList(list));
        }
        return list;
    }

    @androidx.annotation.NonNull
    public <X> com.bumptech.glide.load.ResourceEncoder<X> getResultEncoder(@androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<X> resource) throws com.bumptech.glide.Registry.NoResultEncoderAvailableException {
        com.bumptech.glide.load.ResourceEncoder<X> resourceEncoder = this.resourceEncoderRegistry.get(resource.getResourceClass());
        if (resourceEncoder != null) {
            return resourceEncoder;
        }
        throw new com.bumptech.glide.Registry.NoResultEncoderAvailableException(resource.getResourceClass());
    }

    @androidx.annotation.NonNull
    public <X> com.bumptech.glide.load.data.DataRewinder<X> getRewinder(@androidx.annotation.NonNull X x) {
        return this.dataRewinderRegistry.build(x);
    }

    @androidx.annotation.NonNull
    public <X> com.bumptech.glide.load.Encoder<X> getSourceEncoder(@androidx.annotation.NonNull X x) throws com.bumptech.glide.Registry.NoSourceEncoderAvailableException {
        com.bumptech.glide.load.Encoder<X> encoder = this.encoderRegistry.getEncoder(x.getClass());
        if (encoder != null) {
            return encoder;
        }
        throw new com.bumptech.glide.Registry.NoSourceEncoderAvailableException(x.getClass());
    }

    public boolean isResourceEncoderAvailable(@androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<?> resource) {
        return this.resourceEncoderRegistry.get(resource.getResourceClass()) != null;
    }

    @androidx.annotation.NonNull
    public <Data> com.bumptech.glide.Registry prepend(@androidx.annotation.NonNull java.lang.Class<Data> cls, @androidx.annotation.NonNull com.bumptech.glide.load.Encoder<Data> encoder) {
        this.encoderRegistry.prepend(cls, encoder);
        return this;
    }

    @androidx.annotation.NonNull
    public <TResource> com.bumptech.glide.Registry prepend(@androidx.annotation.NonNull java.lang.Class<TResource> cls, @androidx.annotation.NonNull com.bumptech.glide.load.ResourceEncoder<TResource> resourceEncoder) {
        this.resourceEncoderRegistry.prepend(cls, resourceEncoder);
        return this;
    }

    @androidx.annotation.NonNull
    public <Data, TResource> com.bumptech.glide.Registry prepend(@androidx.annotation.NonNull java.lang.Class<Data> cls, @androidx.annotation.NonNull java.lang.Class<TResource> cls2, @androidx.annotation.NonNull com.bumptech.glide.load.ResourceDecoder<Data, TResource> resourceDecoder) {
        prepend(BUCKET_PREPEND_ALL, cls, cls2, resourceDecoder);
        return this;
    }

    @androidx.annotation.NonNull
    public <Model, Data> com.bumptech.glide.Registry prepend(@androidx.annotation.NonNull java.lang.Class<Model> cls, @androidx.annotation.NonNull java.lang.Class<Data> cls2, @androidx.annotation.NonNull com.bumptech.glide.load.model.ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.modelLoaderRegistry.prepend(cls, cls2, modelLoaderFactory);
        return this;
    }

    @androidx.annotation.NonNull
    public <Data, TResource> com.bumptech.glide.Registry prepend(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.Class<Data> cls, @androidx.annotation.NonNull java.lang.Class<TResource> cls2, @androidx.annotation.NonNull com.bumptech.glide.load.ResourceDecoder<Data, TResource> resourceDecoder) {
        this.decoderRegistry.prepend(str, resourceDecoder, cls, cls2);
        return this;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.Registry register(@androidx.annotation.NonNull com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) {
        this.imageHeaderParserRegistry.add(imageHeaderParser);
        return this;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.Registry register(@androidx.annotation.NonNull com.bumptech.glide.load.data.DataRewinder.Factory<?> factory) {
        this.dataRewinderRegistry.register(factory);
        return this;
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public <Data> com.bumptech.glide.Registry register(@androidx.annotation.NonNull java.lang.Class<Data> cls, @androidx.annotation.NonNull com.bumptech.glide.load.Encoder<Data> encoder) {
        return append(cls, encoder);
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public <TResource> com.bumptech.glide.Registry register(@androidx.annotation.NonNull java.lang.Class<TResource> cls, @androidx.annotation.NonNull com.bumptech.glide.load.ResourceEncoder<TResource> resourceEncoder) {
        return append((java.lang.Class) cls, (com.bumptech.glide.load.ResourceEncoder) resourceEncoder);
    }

    @androidx.annotation.NonNull
    public <TResource, Transcode> com.bumptech.glide.Registry register(@androidx.annotation.NonNull java.lang.Class<TResource> cls, @androidx.annotation.NonNull java.lang.Class<Transcode> cls2, @androidx.annotation.NonNull com.bumptech.glide.load.resource.transcode.ResourceTranscoder<TResource, Transcode> resourceTranscoder) {
        this.transcoderRegistry.register(cls, cls2, resourceTranscoder);
        return this;
    }

    @androidx.annotation.NonNull
    public <Model, Data> com.bumptech.glide.Registry replace(@androidx.annotation.NonNull java.lang.Class<Model> cls, @androidx.annotation.NonNull java.lang.Class<Data> cls2, @androidx.annotation.NonNull com.bumptech.glide.load.model.ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.modelLoaderRegistry.replace(cls, cls2, modelLoaderFactory);
        return this;
    }

    @androidx.annotation.NonNull
    public final com.bumptech.glide.Registry setResourceDecoderBucketPriorityList(@androidx.annotation.NonNull java.util.List<java.lang.String> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, BUCKET_PREPEND_ALL);
        arrayList.add(BUCKET_APPEND_ALL);
        this.decoderRegistry.setBucketPriorityList(arrayList);
        return this;
    }
}
