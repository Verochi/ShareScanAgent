package com.efs.sdk.base.core.cache;

/* loaded from: classes22.dex */
public interface IFileFilter {
    boolean filter(java.io.File file);

    void finish();

    void finish(boolean z, boolean z2);

    boolean hasTask();
}
