package com.alimm.tanx.ui.image.glide.request;

/* loaded from: classes.dex */
public interface RequestListener<T, R> {
    boolean onException(java.lang.Exception exc, T t, com.alimm.tanx.ui.image.glide.request.target.Target<R> target, boolean z);

    boolean onResourceReady(R r, T t, com.alimm.tanx.ui.image.glide.request.target.Target<R> target, boolean z, boolean z2);
}
