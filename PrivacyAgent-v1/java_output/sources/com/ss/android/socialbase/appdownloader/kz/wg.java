package com.ss.android.socialbase.appdownloader.kz;

/* loaded from: classes19.dex */
public class wg {

    /* renamed from: com.ss.android.socialbase.appdownloader.kz.wg$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ int t;
        final /* synthetic */ android.content.Context vw;
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo wg;

        public AnonymousClass1(android.content.Context context, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, int i) {
            this.vw = context;
            this.wg = downloadInfo;
            this.t = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.appdownloader.t.v wg = com.ss.android.socialbase.appdownloader.v.es().wg();
            com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener downloadNotificationEventListener = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(this.vw).getDownloadNotificationEventListener(this.wg.getId());
            if (wg == null && downloadNotificationEventListener == null) {
                return;
            }
            java.io.File file = new java.io.File(this.wg.getSavePath(), this.wg.getName());
            if (file.exists()) {
                try {
                    android.content.pm.PackageInfo vw = com.ss.android.socialbase.appdownloader.t.vw(this.wg, file);
                    if (vw != null) {
                        java.lang.String packageName = (this.t == 1 || android.text.TextUtils.isEmpty(this.wg.getPackageName())) ? vw.packageName : this.wg.getPackageName();
                        if (wg != null) {
                            wg.vw(this.wg.getId(), 1, packageName, -3, this.wg.getDownloadTime());
                        }
                        if (downloadNotificationEventListener != null) {
                            downloadNotificationEventListener.onNotificationEvent(1, this.wg, packageName, "");
                        }
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        wg(downloadInfo);
    }

    private static void wg(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        android.content.Context appContext = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext();
        boolean z = true;
        if (((downloadInfo.isAutoResumed() && !downloadInfo.isShowNotificationForNetworkResumed()) || com.ss.android.socialbase.appdownloader.t.wg(downloadInfo.getExtra()) || android.text.TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals("application/vnd.android.package-archive")) && com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt("auto_install_when_resume", 0) != 1) {
            z = false;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getCPUThreadExecutor().execute(new com.ss.android.socialbase.appdownloader.kz.wg.AnonymousClass1(appContext, downloadInfo, z ? com.ss.android.socialbase.appdownloader.t.vw(appContext, downloadInfo.getId(), false) : 2));
    }
}
