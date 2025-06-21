package com.alimm.tanx.ui.image.glide.load;

/* loaded from: classes.dex */
public interface ResourceDecoder<T, Z> {
    com.alimm.tanx.ui.image.glide.load.engine.Resource<Z> decode(T t, int i, int i2) throws java.io.IOException;

    java.lang.String getId();
}
