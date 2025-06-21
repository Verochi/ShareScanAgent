package com.alimm.tanx.ui.image.glide.request;

/* loaded from: classes.dex */
public interface ResourceCallback {
    void onException(java.lang.Exception exc);

    void onResourceReady(com.alimm.tanx.ui.image.glide.load.engine.Resource<?> resource);
}
