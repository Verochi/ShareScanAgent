package com.bumptech.glide;

/* loaded from: classes.dex */
public class GlideContext extends android.content.ContextWrapper {

    @androidx.annotation.VisibleForTesting
    static final com.bumptech.glide.TransitionOptions<?, ?> DEFAULT_TRANSITION_OPTIONS = new com.bumptech.glide.GenericTransitionOptions();
    private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool;
    private final java.util.List<com.bumptech.glide.request.RequestListener<java.lang.Object>> defaultRequestListeners;

    @androidx.annotation.Nullable
    @androidx.annotation.GuardedBy("this")
    private com.bumptech.glide.request.RequestOptions defaultRequestOptions;
    private final com.bumptech.glide.Glide.RequestOptionsFactory defaultRequestOptionsFactory;
    private final java.util.Map<java.lang.Class<?>, com.bumptech.glide.TransitionOptions<?, ?>> defaultTransitionOptions;
    private final com.bumptech.glide.load.engine.Engine engine;
    private final com.bumptech.glide.request.target.ImageViewTargetFactory imageViewTargetFactory;
    private final boolean isLoggingRequestOriginsEnabled;
    private final int logLevel;
    private final com.bumptech.glide.Registry registry;

    public GlideContext(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool, @androidx.annotation.NonNull com.bumptech.glide.Registry registry, @androidx.annotation.NonNull com.bumptech.glide.request.target.ImageViewTargetFactory imageViewTargetFactory, @androidx.annotation.NonNull com.bumptech.glide.Glide.RequestOptionsFactory requestOptionsFactory, @androidx.annotation.NonNull java.util.Map<java.lang.Class<?>, com.bumptech.glide.TransitionOptions<?, ?>> map, @androidx.annotation.NonNull java.util.List<com.bumptech.glide.request.RequestListener<java.lang.Object>> list, @androidx.annotation.NonNull com.bumptech.glide.load.engine.Engine engine, boolean z, int i) {
        super(context.getApplicationContext());
        this.arrayPool = arrayPool;
        this.registry = registry;
        this.imageViewTargetFactory = imageViewTargetFactory;
        this.defaultRequestOptionsFactory = requestOptionsFactory;
        this.defaultRequestListeners = list;
        this.defaultTransitionOptions = map;
        this.engine = engine;
        this.isLoggingRequestOriginsEnabled = z;
        this.logLevel = i;
    }

    @androidx.annotation.NonNull
    public <X> com.bumptech.glide.request.target.ViewTarget<android.widget.ImageView, X> buildImageViewTarget(@androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull java.lang.Class<X> cls) {
        return this.imageViewTargetFactory.buildTarget(imageView, cls);
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool getArrayPool() {
        return this.arrayPool;
    }

    public java.util.List<com.bumptech.glide.request.RequestListener<java.lang.Object>> getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    public synchronized com.bumptech.glide.request.RequestOptions getDefaultRequestOptions() {
        if (this.defaultRequestOptions == null) {
            this.defaultRequestOptions = this.defaultRequestOptionsFactory.build().lock();
        }
        return this.defaultRequestOptions;
    }

    @androidx.annotation.NonNull
    public <T> com.bumptech.glide.TransitionOptions<?, T> getDefaultTransitionOptions(@androidx.annotation.NonNull java.lang.Class<T> cls) {
        com.bumptech.glide.TransitionOptions<?, T> transitionOptions = (com.bumptech.glide.TransitionOptions) this.defaultTransitionOptions.get(cls);
        if (transitionOptions == null) {
            for (java.util.Map.Entry<java.lang.Class<?>, com.bumptech.glide.TransitionOptions<?, ?>> entry : this.defaultTransitionOptions.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    transitionOptions = (com.bumptech.glide.TransitionOptions) entry.getValue();
                }
            }
        }
        return transitionOptions == null ? (com.bumptech.glide.TransitionOptions<?, T>) DEFAULT_TRANSITION_OPTIONS : transitionOptions;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.load.engine.Engine getEngine() {
        return this.engine;
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.Registry getRegistry() {
        return this.registry;
    }

    public boolean isLoggingRequestOriginsEnabled() {
        return this.isLoggingRequestOriginsEnabled;
    }
}
