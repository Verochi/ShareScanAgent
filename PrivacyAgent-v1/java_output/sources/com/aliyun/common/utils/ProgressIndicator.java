package com.aliyun.common.utils;

/* loaded from: classes.dex */
public interface ProgressIndicator {

    public interface ProgressListener {
        void onLimitReached();

        void onProgress(long j);
    }

    long getDuration();

    void setDurationLimit(long j);

    void setProgressListener(com.aliyun.common.utils.ProgressIndicator.ProgressListener progressListener);
}
