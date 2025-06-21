package com.bumptech.glide.request;

/* loaded from: classes.dex */
public interface ResourceCallback {
    java.lang.Object getLock();

    void onLoadFailed(com.bumptech.glide.load.engine.GlideException glideException);

    void onResourceReady(com.bumptech.glide.load.engine.Resource<?> resource, com.bumptech.glide.load.DataSource dataSource);
}
