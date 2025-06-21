package com.alimm.tanx.ui.image.glide.integration.okhttp3;

/* loaded from: classes.dex */
public class OkHttpGlideModule implements com.alimm.tanx.ui.image.glide.module.GlideModule {
    @Override // com.alimm.tanx.ui.image.glide.module.GlideModule
    public void applyOptions(android.content.Context context, com.alimm.tanx.ui.image.glide.GlideBuilder glideBuilder) {
    }

    @Override // com.alimm.tanx.ui.image.glide.module.GlideModule
    public void registerComponents(android.content.Context context, com.alimm.tanx.ui.image.glide.Glide glide) {
        glide.register(com.alimm.tanx.ui.image.glide.load.model.GlideUrl.class, java.io.InputStream.class, new com.alimm.tanx.ui.image.glide.integration.okhttp3.OkHttpUrlLoader.Factory());
    }
}
