package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public abstract class AbsDownloadForbiddenCallback implements com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback {
    private boolean hasCallback = false;

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback
    public boolean hasCallback() {
        return this.hasCallback;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback
    public void onCallback(java.util.List<java.lang.String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.hasCallback = true;
    }
}
