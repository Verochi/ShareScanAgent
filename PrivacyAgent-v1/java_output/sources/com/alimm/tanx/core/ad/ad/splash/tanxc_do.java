package com.alimm.tanx.core.ad.ad.splash;

/* loaded from: classes.dex */
public class tanxc_do {
    private static com.alimm.tanx.core.ad.ad.splash.tanxc_do tanxc_do;
    private java.util.List<com.alimm.tanx.core.ad.ad.splash.RsDownloadStatus> tanxc_if = new java.util.ArrayList();
    private java.util.Queue<java.lang.String> tanxc_for = new java.util.LinkedList();
    private long tanxc_int = 0;

    private tanxc_do() {
    }

    public static com.alimm.tanx.core.ad.ad.splash.tanxc_do tanxc_do() {
        if (tanxc_do == null) {
            synchronized (com.alimm.tanx.core.ad.ad.splash.tanxc_do.class) {
                if (tanxc_do == null) {
                    tanxc_do = new com.alimm.tanx.core.ad.ad.splash.tanxc_do();
                }
            }
        }
        return tanxc_do;
    }

    private void tanxc_do(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.alimm.tanx.core.ad.ad.splash.RsDownloadStatus rsDownloadStatus) {
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences("mm_adsdk_rs_download_info", 0).edit();
        edit.putInt(rsDownloadStatus.getFileName(), rsDownloadStatus.getStatus());
        edit.apply();
    }

    public synchronized void tanxc_do(@androidx.annotation.NonNull android.content.Context context) {
        this.tanxc_if.clear();
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences("mm_adsdk_rs_download_info", 0).edit();
        edit.clear();
        edit.apply();
    }

    public synchronized void tanxc_do(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str, int i) {
        com.alimm.tanx.core.utils.LogUtils.d("SplashAdAnalytics", "setRsDownloadStatus: resourceName = " + str + ", status = " + i);
        if (i == 0) {
            com.alimm.tanx.core.ad.ad.splash.RsDownloadStatus rsDownloadStatus = new com.alimm.tanx.core.ad.ad.splash.RsDownloadStatus(str, i);
            this.tanxc_if.add(rsDownloadStatus);
            tanxc_do(context, rsDownloadStatus);
        } else {
            for (com.alimm.tanx.core.ad.ad.splash.RsDownloadStatus rsDownloadStatus2 : this.tanxc_if) {
                if (android.text.TextUtils.equals(rsDownloadStatus2.getFileName(), str)) {
                    rsDownloadStatus2.setStatus(i);
                    tanxc_do(context, rsDownloadStatus2);
                }
            }
        }
    }
}
