package com.bumptech.glide.integration.okhttp3;

@com.bumptech.glide.annotation.GlideModule
/* loaded from: classes.dex */
public final class OkHttpLibraryGlideModule extends com.bumptech.glide.module.LibraryGlideModule {
    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.bumptech.glide.Glide glide, @androidx.annotation.NonNull com.bumptech.glide.Registry registry) {
        registry.replace(com.bumptech.glide.load.model.GlideUrl.class, java.io.InputStream.class, new com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader.Factory());
    }
}
