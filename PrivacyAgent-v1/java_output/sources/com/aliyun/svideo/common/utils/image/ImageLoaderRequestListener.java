package com.aliyun.svideo.common.utils.image;

/* loaded from: classes.dex */
public interface ImageLoaderRequestListener<R> {
    boolean onLoadFailed(java.lang.String str, boolean z);

    boolean onResourceReady(R r, boolean z);
}
