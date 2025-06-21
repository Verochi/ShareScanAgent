package com.ss.android.downloadlib.addownload;

/* loaded from: classes19.dex */
public class x {
    public static int vw(@androidx.annotation.NonNull com.ss.android.downloadlib.addownload.wg.yl ylVar, boolean z, com.ss.android.socialbase.appdownloader.kz kzVar) {
        int i;
        if (kzVar == null || android.text.TextUtils.isEmpty(kzVar.vw()) || kzVar.getContext() == null) {
            return 0;
        }
        try {
            i = vw(kzVar, kzVar.vw());
        } catch (java.lang.Throwable th) {
            com.ss.android.downloadlib.addownload.z.q().vw(th, "redirectSavePathIfPossible");
            i = 4;
        }
        kzVar.vw(i);
        if (i == 0) {
            kzVar.vw(new com.ss.android.downloadlib.t.vw());
        }
        if (!kzVar.fu()) {
            kzVar.vw(new com.ss.android.downloadlib.t.wg());
        }
        int vw = com.ss.android.socialbase.appdownloader.v.es().vw(kzVar);
        com.ss.android.downloadad.api.vw.wg vw2 = vw(ylVar, vw);
        com.ss.android.downloadlib.addownload.wg.kz.vw().vw(vw2);
        vw2.bt(vw);
        vw2.o(java.lang.System.currentTimeMillis());
        vw2.x(0L);
        com.ss.android.socialbase.downloader.setting.DownloadSetting obtain = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(kzVar.ol());
        if (!vw(kzVar, obtain, vw) && ylVar.wg.isShowToast()) {
            java.lang.String startToast = ylVar.wg.getStartToast();
            if (android.text.TextUtils.isEmpty(startToast)) {
                startToast = obtain.optString("download_start_toast_text");
            }
            if (android.text.TextUtils.isEmpty(startToast)) {
                startToast = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            com.ss.android.downloadlib.addownload.z.t().vw(2, kzVar.getContext(), ylVar.wg, startToast, null, 0);
        }
        return vw;
    }

    private static int vw(com.ss.android.socialbase.appdownloader.kz kzVar, java.lang.String str) {
        com.ss.android.socialbase.downloader.setting.DownloadSetting obtain = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(kzVar.ol());
        org.json.JSONObject optJSONObject = obtain.optJSONObject(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
        if (optJSONObject == null || android.text.TextUtils.isEmpty(optJSONObject.optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME))) {
            return -1;
        }
        java.lang.String wg = kzVar.wg();
        java.lang.String kk = kzVar.kk();
        if (android.text.TextUtils.isEmpty(kk)) {
            kk = com.ss.android.socialbase.appdownloader.t.vw(str, wg, kzVar.vl(), true);
        }
        if (kk.length() > 255) {
            kk = kk.substring(kk.length() - 255);
        }
        if (android.text.TextUtils.isEmpty(wg)) {
            wg = kk;
        }
        java.lang.String t = kzVar.t();
        if (android.text.TextUtils.isEmpty(t)) {
            t = com.ss.android.socialbase.appdownloader.t.wg();
        }
        java.lang.String str2 = t + java.io.File.separator + com.ss.android.socialbase.appdownloader.t.vw(wg, obtain);
        com.ss.android.socialbase.downloader.model.DownloadInfo vw = com.ss.android.socialbase.appdownloader.v.es().vw(kzVar.getContext(), str);
        if (vw != null && vw.isSavePathRedirected()) {
            kzVar.t(vw.getSavePath());
            try {
                kzVar.vw(new org.json.JSONObject(vw.getDownloadSettingString()));
            } catch (java.lang.Throwable unused) {
            }
            return 0;
        }
        if (vw != null || !"application/vnd.android.package-archive".equalsIgnoreCase(com.ss.android.socialbase.appdownloader.v.es().vw(kk, kzVar.vl()))) {
            return vw != null ? 8 : 9;
        }
        int vw2 = com.ss.android.socialbase.appdownloader.wg.vw(obtain);
        if (vw2 == 0) {
            kzVar.t(str2);
        }
        return vw2;
    }

    private static com.ss.android.downloadad.api.vw.wg vw(com.ss.android.downloadlib.addownload.wg.yl ylVar, int i) {
        com.ss.android.downloadad.api.vw.wg wgVar = new com.ss.android.downloadad.api.vw.wg(ylVar.wg, ylVar.t, ylVar.v, i);
        boolean z = true;
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optInt("download_event_opt", 1) > 1) {
            try {
                java.lang.String packageName = ylVar.wg.getPackageName();
                if (!android.text.TextUtils.isEmpty(packageName)) {
                    if (com.ss.android.downloadlib.addownload.z.getContext().getPackageManager().getPackageInfo(packageName, 0) == null) {
                        z = false;
                    }
                    wgVar.o(z);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return wgVar;
    }

    public static java.lang.String vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            java.lang.String extra = downloadInfo.getExtra();
            if (!android.text.TextUtils.isEmpty(extra)) {
                return new org.json.JSONObject(extra).optString("notification_jump_url", null);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean vw(int i) {
        return i == 0 || i == 1;
    }

    public static boolean vw(com.ss.android.download.api.download.DownloadModel downloadModel) {
        return downloadModel.isAd() && (downloadModel instanceof com.ss.android.downloadad.api.download.AdDownloadModel) && downloadModel.getModelType() == 1;
    }

    public static boolean vw(com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.config.IDownloadButtonClickListener iDownloadButtonClickListener) {
        return downloadModel.isAd() && iDownloadButtonClickListener != null;
    }

    private static boolean vw(com.ss.android.socialbase.appdownloader.kz kzVar, @androidx.annotation.NonNull com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting, int i) {
        java.lang.String optString;
        org.json.JSONArray optJSONArray = downloadSetting.optJSONArray(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.KEY_AH_PLANS);
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int length = optJSONArray.length();
            org.json.JSONObject jSONObject = null;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null && ((optString = optJSONObject.optString("type")) == "plan_c" || com.ss.android.socialbase.appdownloader.kz.vw.vw(optJSONObject))) {
                        optString.hashCode();
                        switch (optString) {
                            case "plan_a":
                            case "plan_b":
                            case "plan_e":
                            case "plan_f":
                                if (com.ss.android.socialbase.appdownloader.wg.vw(optJSONObject, downloadSetting).wg != 0) {
                                    break;
                                } else {
                                    break;
                                }
                            case "plan_c":
                                jSONObject = optJSONObject;
                                continue;
                            case "plan_g":
                                if (com.ss.android.socialbase.appdownloader.wg.wg(optJSONObject, downloadSetting).wg != 0) {
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    i2++;
                }
            }
            if (jSONObject != null) {
                if (jSONObject.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1) {
                    return com.ss.android.socialbase.appdownloader.wg.vw(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), (android.content.Intent) null, jSONObject, i, new com.ss.android.socialbase.appdownloader.vw());
                }
            }
        }
        return false;
    }

    public static boolean wg(int i) {
        return i == 2 || i == 1;
    }

    public static boolean wg(com.ss.android.download.api.download.DownloadModel downloadModel) {
        return downloadModel != null && downloadModel.getModelType() == 2;
    }
}
