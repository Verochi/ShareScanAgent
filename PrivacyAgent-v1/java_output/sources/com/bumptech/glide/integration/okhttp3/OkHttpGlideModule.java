package com.bumptech.glide.integration.okhttp3;

@java.lang.Deprecated
/* loaded from: classes.dex */
public class OkHttpGlideModule implements com.bumptech.glide.module.GlideModule {
    @Override // com.bumptech.glide.module.GlideModule, com.bumptech.glide.module.AppliesOptions
    public void applyOptions(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.bumptech.glide.GlideBuilder glideBuilder) {
    }

    @Override // com.bumptech.glide.module.GlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(android.content.Context context, com.bumptech.glide.Glide glide, com.bumptech.glide.Registry registry) {
        registry.replace(com.bumptech.glide.load.model.GlideUrl.class, java.io.InputStream.class, new com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader.Factory());
    }
}
