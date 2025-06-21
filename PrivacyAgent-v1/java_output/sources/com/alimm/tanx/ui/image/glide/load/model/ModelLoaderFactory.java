package com.alimm.tanx.ui.image.glide.load.model;

/* loaded from: classes.dex */
public interface ModelLoaderFactory<T, Y> {
    com.alimm.tanx.ui.image.glide.load.model.ModelLoader<T, Y> build(android.content.Context context, com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory genericLoaderFactory);

    void teardown();
}
