package com.alimm.tanx.ui.image.glide.load.data;

/* loaded from: classes.dex */
public interface DataFetcher<T> {
    void cancel();

    void cleanup();

    java.lang.String getId();

    T loadData(com.alimm.tanx.ui.image.glide.Priority priority) throws java.lang.Exception;
}
