package com.alimm.tanx.ui.image.glide.provider;

/* loaded from: classes.dex */
public class EmptyDataLoadProvider<T, Z> implements com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<T, Z> {
    private static final com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<?, ?> EMPTY_DATA_LOAD_PROVIDER = new com.alimm.tanx.ui.image.glide.provider.EmptyDataLoadProvider();

    public static <T, Z> com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<T, Z> get() {
        return (com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<T, Z>) EMPTY_DATA_LOAD_PROVIDER;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, Z> getCacheDecoder() {
        return null;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceEncoder<Z> getEncoder() {
        return null;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceDecoder<T, Z> getSourceDecoder() {
        return null;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.Encoder<T> getSourceEncoder() {
        return null;
    }
}
