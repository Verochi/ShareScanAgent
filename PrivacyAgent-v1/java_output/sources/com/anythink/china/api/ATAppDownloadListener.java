package com.anythink.china.api;

/* loaded from: classes12.dex */
public interface ATAppDownloadListener extends com.anythink.core.api.ATEventInterface {
    void onDownloadFail(com.anythink.core.api.ATAdInfo aTAdInfo, long j, long j2, java.lang.String str, java.lang.String str2);

    void onDownloadFinish(com.anythink.core.api.ATAdInfo aTAdInfo, long j, java.lang.String str, java.lang.String str2);

    void onDownloadPause(com.anythink.core.api.ATAdInfo aTAdInfo, long j, long j2, java.lang.String str, java.lang.String str2);

    void onDownloadStart(com.anythink.core.api.ATAdInfo aTAdInfo, long j, long j2, java.lang.String str, java.lang.String str2);

    void onDownloadUpdate(com.anythink.core.api.ATAdInfo aTAdInfo, long j, long j2, java.lang.String str, java.lang.String str2);

    void onInstalled(com.anythink.core.api.ATAdInfo aTAdInfo, java.lang.String str, java.lang.String str2);
}
