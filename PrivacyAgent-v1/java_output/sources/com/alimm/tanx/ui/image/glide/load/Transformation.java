package com.alimm.tanx.ui.image.glide.load;

/* loaded from: classes.dex */
public interface Transformation<T> {
    java.lang.String getId();

    com.alimm.tanx.ui.image.glide.load.engine.Resource<T> transform(com.alimm.tanx.ui.image.glide.load.engine.Resource<T> resource, int i, int i2);
}
