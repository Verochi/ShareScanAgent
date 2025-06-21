package com.ss.android.socialbase.appdownloader.vw;

/* loaded from: classes19.dex */
public abstract class vw implements com.ss.android.socialbase.appdownloader.vw.yl {
    protected final java.lang.String t;
    protected final android.content.Context vw;
    protected final com.ss.android.socialbase.downloader.setting.DownloadSetting wg;

    public vw(android.content.Context context, com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting, java.lang.String str) {
        this.vw = context;
        this.wg = downloadSetting;
        this.t = str;
    }

    public boolean vw() {
        if (this.vw == null) {
            return false;
        }
        try {
        } catch (java.lang.Throwable unused) {
            com.ss.android.socialbase.downloader.logger.Logger.debug();
        }
        return wg().resolveActivity(this.vw.getPackageManager()) != null;
    }
}
