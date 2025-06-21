package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public interface TTAppDownloadListener {
    void onDownloadActive(long j, long j2, java.lang.String str, java.lang.String str2);

    void onDownloadFailed(long j, long j2, java.lang.String str, java.lang.String str2);

    void onDownloadFinished(long j, java.lang.String str, java.lang.String str2);

    void onDownloadPaused(long j, long j2, java.lang.String str, java.lang.String str2);

    void onIdle();

    void onInstalled(java.lang.String str, java.lang.String str2);
}
