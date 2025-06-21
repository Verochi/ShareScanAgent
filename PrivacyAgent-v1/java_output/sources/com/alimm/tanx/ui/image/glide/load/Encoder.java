package com.alimm.tanx.ui.image.glide.load;

/* loaded from: classes.dex */
public interface Encoder<T> {
    boolean encode(T t, java.io.OutputStream outputStream);

    java.lang.String getId();
}
