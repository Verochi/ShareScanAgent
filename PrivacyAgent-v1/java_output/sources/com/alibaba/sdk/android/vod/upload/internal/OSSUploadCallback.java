package com.alibaba.sdk.android.vod.upload.internal;

/* loaded from: classes.dex */
public interface OSSUploadCallback {
    void onUploadFailed(java.lang.String str, java.lang.String str2);

    void onUploadProgress(long j, long j2);

    void onUploadSucceed();

    void onUploadTokenExpired();
}
