package com.bumptech.glide;

/* loaded from: classes.dex */
final class GeneratedAppGlideModuleImpl extends com.bumptech.glide.GeneratedAppGlideModule {
    private final com.moji.mjweather.glide.MJGlideAppModule appGlideModule = new com.moji.mjweather.glide.MJGlideAppModule();

    public GeneratedAppGlideModuleImpl(android.content.Context context) {
    }

    @Override // com.bumptech.glide.module.AppGlideModule, com.bumptech.glide.module.AppliesOptions
    public void applyOptions(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.bumptech.glide.GlideBuilder glideBuilder) {
        this.appGlideModule.applyOptions(context, glideBuilder);
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    @androidx.annotation.NonNull
    public java.util.Set<java.lang.Class<?>> getExcludedModuleClasses() {
        return java.util.Collections.emptySet();
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    @androidx.annotation.NonNull
    public com.bumptech.glide.GeneratedRequestManagerFactory getRequestManagerFactory() {
        return new com.bumptech.glide.GeneratedRequestManagerFactory();
    }

    @Override // com.bumptech.glide.module.AppGlideModule
    public boolean isManifestParsingEnabled() {
        return this.appGlideModule.isManifestParsingEnabled();
    }

    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.bumptech.glide.Glide glide, @androidx.annotation.NonNull com.bumptech.glide.Registry registry) {
        new com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule().registerComponents(context, glide, registry);
        new com.moji.glide.CustomGlideLibraryModule().registerComponents(context, glide, registry);
        new com.moji.glide.MJGlideModule().registerComponents(context, glide, registry);
        new com.moji.glide.webp.WebpGlideLibraryModule().registerComponents(context, glide, registry);
        this.appGlideModule.registerComponents(context, glide, registry);
    }
}
