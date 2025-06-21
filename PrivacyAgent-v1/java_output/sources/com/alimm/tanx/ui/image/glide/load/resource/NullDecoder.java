package com.alimm.tanx.ui.image.glide.load.resource;

/* loaded from: classes.dex */
public class NullDecoder<T, Z> implements com.alimm.tanx.ui.image.glide.load.ResourceDecoder<T, Z> {
    private static final com.alimm.tanx.ui.image.glide.load.resource.NullDecoder<?, ?> NULL_DECODER = new com.alimm.tanx.ui.image.glide.load.resource.NullDecoder<>();

    public static <T, Z> com.alimm.tanx.ui.image.glide.load.resource.NullDecoder<T, Z> get() {
        return (com.alimm.tanx.ui.image.glide.load.resource.NullDecoder<T, Z>) NULL_DECODER;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<Z> decode(T t, int i, int i2) {
        return null;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public java.lang.String getId() {
        return "";
    }
}
