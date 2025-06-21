package com.alimm.tanx.ui.image.glide.provider;

/* loaded from: classes.dex */
public interface DataLoadProvider<T, Z> {
    com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, Z> getCacheDecoder();

    com.alimm.tanx.ui.image.glide.load.ResourceEncoder<Z> getEncoder();

    com.alimm.tanx.ui.image.glide.load.ResourceDecoder<T, Z> getSourceDecoder();

    com.alimm.tanx.ui.image.glide.load.Encoder<T> getSourceEncoder();
}
