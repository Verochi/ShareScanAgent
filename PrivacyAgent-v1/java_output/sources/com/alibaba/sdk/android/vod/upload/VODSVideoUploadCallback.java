package com.alibaba.sdk.android.vod.upload;

/* loaded from: classes.dex */
public interface VODSVideoUploadCallback {
    void onSTSTokenExpried();

    void onUploadFailed(java.lang.String str, java.lang.String str2);

    void onUploadProgress(long j, long j2);

    void onUploadRetry(java.lang.String str, java.lang.String str2);

    void onUploadRetryResume();

    void onUploadSucceed(java.lang.String str, java.lang.String str2);
}
