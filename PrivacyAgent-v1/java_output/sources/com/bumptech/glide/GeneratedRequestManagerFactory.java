package com.bumptech.glide;

/* loaded from: classes.dex */
final class GeneratedRequestManagerFactory implements com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory {
    @Override // com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory
    @androidx.annotation.NonNull
    public com.bumptech.glide.RequestManager build(@androidx.annotation.NonNull com.bumptech.glide.Glide glide, @androidx.annotation.NonNull com.bumptech.glide.manager.Lifecycle lifecycle, @androidx.annotation.NonNull com.bumptech.glide.manager.RequestManagerTreeNode requestManagerTreeNode, @androidx.annotation.NonNull android.content.Context context) {
        return new com.moji.mjweather.glide.GlideRequests(glide, lifecycle, requestManagerTreeNode, context);
    }
}
