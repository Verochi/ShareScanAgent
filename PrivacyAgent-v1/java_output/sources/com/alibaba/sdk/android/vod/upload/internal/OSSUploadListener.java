package com.alibaba.sdk.android.vod.upload.internal;

/* loaded from: classes.dex */
public interface OSSUploadListener {
    void onUploadFailed(java.lang.String str, java.lang.String str2);

    void onUploadProgress(java.lang.Object obj, long j, long j2);

    void onUploadRetry(java.lang.String str, java.lang.String str2);

    void onUploadRetryResume();

    void onUploadSucceed();

    void onUploadTokenExpired();
}
