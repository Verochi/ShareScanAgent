package com.anythink.china.api;

/* loaded from: classes12.dex */
public interface CustomAdapterDownloadListener extends com.anythink.core.api.ATEventInterface {
    void onDownloadFail(long j, long j2, java.lang.String str, java.lang.String str2);

    void onDownloadFinish(long j, java.lang.String str, java.lang.String str2);

    void onDownloadPause(long j, long j2, java.lang.String str, java.lang.String str2);

    void onDownloadStart(long j, long j2, java.lang.String str, java.lang.String str2);

    void onDownloadUpdate(long j, long j2, java.lang.String str, java.lang.String str2);

    void onInstalled(java.lang.String str, java.lang.String str2);
}
