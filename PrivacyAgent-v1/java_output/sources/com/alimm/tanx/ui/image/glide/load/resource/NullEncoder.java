package com.alimm.tanx.ui.image.glide.load.resource;

/* loaded from: classes.dex */
public class NullEncoder<T> implements com.alimm.tanx.ui.image.glide.load.Encoder<T> {
    private static final com.alimm.tanx.ui.image.glide.load.resource.NullEncoder<?> NULL_ENCODER = new com.alimm.tanx.ui.image.glide.load.resource.NullEncoder<>();

    public static <T> com.alimm.tanx.ui.image.glide.load.Encoder<T> get() {
        return NULL_ENCODER;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public boolean encode(T t, java.io.OutputStream outputStream) {
        return false;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public java.lang.String getId() {
        return "";
    }
}
