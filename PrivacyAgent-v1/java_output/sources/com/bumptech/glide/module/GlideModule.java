package com.bumptech.glide.module;

@java.lang.Deprecated
/* loaded from: classes.dex */
public interface GlideModule extends com.bumptech.glide.module.RegistersComponents, com.bumptech.glide.module.AppliesOptions {
    /* synthetic */ void applyOptions(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.bumptech.glide.GlideBuilder glideBuilder);

    @Override // com.bumptech.glide.module.RegistersComponents
    /* synthetic */ void registerComponents(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.bumptech.glide.Glide glide, @androidx.annotation.NonNull com.bumptech.glide.Registry registry);
}
