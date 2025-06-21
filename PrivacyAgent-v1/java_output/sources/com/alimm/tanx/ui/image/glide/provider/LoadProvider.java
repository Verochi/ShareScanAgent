package com.alimm.tanx.ui.image.glide.provider;

/* loaded from: classes.dex */
public interface LoadProvider<A, T, Z, R> extends com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<T, Z> {
    com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, T> getModelLoader();

    com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<Z, R> getTranscoder();
}
