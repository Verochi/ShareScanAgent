package com.alimm.tanx.ui.image.glide.load.resource;

/* loaded from: classes.dex */
public class NullResourceEncoder<T> implements com.alimm.tanx.ui.image.glide.load.ResourceEncoder<T> {
    private static final com.alimm.tanx.ui.image.glide.load.resource.NullResourceEncoder<?> NULL_ENCODER = new com.alimm.tanx.ui.image.glide.load.resource.NullResourceEncoder<>();

    public static <T> com.alimm.tanx.ui.image.glide.load.resource.NullResourceEncoder<T> get() {
        return (com.alimm.tanx.ui.image.glide.load.resource.NullResourceEncoder<T>) NULL_ENCODER;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public boolean encode(com.alimm.tanx.ui.image.glide.load.engine.Resource<T> resource, java.io.OutputStream outputStream) {
        return false;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public java.lang.String getId() {
        return "";
    }
}
