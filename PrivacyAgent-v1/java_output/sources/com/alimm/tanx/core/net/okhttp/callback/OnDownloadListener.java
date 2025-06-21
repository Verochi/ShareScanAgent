package com.alimm.tanx.core.net.okhttp.callback;

/* loaded from: classes.dex */
public interface OnDownloadListener {
    void onDownLoadTotal(long j);

    void onDownloadFailed(int i, java.lang.String str);

    void onDownloadSuccess(java.io.File file);

    void onDownloading(int i);
}
