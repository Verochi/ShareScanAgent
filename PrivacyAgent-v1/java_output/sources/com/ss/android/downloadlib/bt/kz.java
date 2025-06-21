package com.ss.android.downloadlib.bt;

/* loaded from: classes19.dex */
public class kz {
    public static void t(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, org.json.JSONObject jSONObject) {
        if (downloadInfo != null) {
            try {
                jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_TOTAL_BYTES, java.lang.Long.valueOf(downloadInfo.getTotalBytes()));
                jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, java.lang.Long.valueOf(downloadInfo.getCurBytes()));
                jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_CHUNK_COUNT, java.lang.Integer.valueOf(downloadInfo.getChunkCount()));
                jSONObject.putOpt("app_name", downloadInfo.getTitle());
                jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_NETWORK_QUALITY, downloadInfo.getNetworkQuality());
                jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_SAVE_PATH, downloadInfo.getSavePath());
                jSONObject.putOpt("file_name", downloadInfo.getName());
                jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_STATUS, java.lang.Integer.valueOf(downloadInfo.getRealStatus()));
                com.ss.android.downloadad.api.vw.wg vw = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo.getId());
                if (vw != null) {
                    jSONObject.putOpt("click_download_time", java.lang.Long.valueOf(vw.kn()));
                    jSONObject.putOpt("click_download_size", java.lang.Long.valueOf(vw.ml()));
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return;
            }
        }
        int i = 1;
        jSONObject.putOpt("permission_notification", java.lang.Integer.valueOf(com.ss.android.socialbase.appdownloader.yl.v.vw() ? 1 : 2));
        jSONObject.putOpt("network_available", java.lang.Integer.valueOf(com.ss.android.socialbase.downloader.utils.DownloadUtils.isNetworkConnected(com.ss.android.downloadlib.addownload.z.getContext()) ? 1 : 2));
        if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.isWifi(com.ss.android.downloadlib.addownload.z.getContext())) {
            i = 2;
        }
        jSONObject.putOpt("network_is_wifi", java.lang.Integer.valueOf(i));
    }

    public static org.json.JSONObject vw(@androidx.annotation.NonNull org.json.JSONObject jSONObject, com.ss.android.downloadad.api.vw.vw vwVar) {
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "open_url", com.ss.android.downloadlib.bt.vl.vw(vwVar.kz(), "open_url_not_exist"));
        return jSONObject;
    }

    public static void vw(com.ss.android.downloadad.api.vw.wg wgVar, org.json.JSONObject jSONObject) {
        if (jSONObject == null || wgVar == null) {
            return;
        }
        try {
            jSONObject.put("is_patch_apply_handled", wgVar.vs() ? 1 : 0);
            jSONObject.put("origin_mime_type", wgVar.m());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, org.json.JSONObject jSONObject) {
        try {
            t(downloadInfo, jSONObject);
            com.ss.android.downloadad.api.vw.wg vw = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo);
            if (vw == null) {
                return;
            }
            jSONObject.put("is_update_download", vw.ih() ? 1 : 2);
            vw(vw, jSONObject);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void vw(@androidx.annotation.NonNull org.json.JSONObject jSONObject) {
        try {
            jSONObject.putOpt("harmony_api_version", com.ss.android.socialbase.appdownloader.kz.v.vw());
            jSONObject.putOpt("harmony_release_type", com.ss.android.socialbase.appdownloader.kz.v.t());
            jSONObject.putOpt("harmony_build_version", com.ss.android.socialbase.appdownloader.kz.v.v());
            int i = 1;
            jSONObject.putOpt("pure_mode", java.lang.Integer.valueOf(com.ss.android.socialbase.appdownloader.kz.v.vw(com.ss.android.downloadlib.addownload.z.getContext()) ? 1 : 2));
            jSONObject.putOpt("pure_mode_enable", java.lang.Integer.valueOf(com.ss.android.socialbase.appdownloader.kz.v.yl() ? 1 : 2));
            jSONObject.putOpt("harmony_version", com.ss.android.socialbase.appdownloader.kz.v.wg());
            jSONObject.putOpt("pure_enhanced_mode", java.lang.Integer.valueOf(com.ss.android.socialbase.appdownloader.kz.v.wg(com.ss.android.downloadlib.addownload.z.getContext()) ? 1 : 2));
            if (!com.ss.android.socialbase.appdownloader.kz.v.kz()) {
                i = 2;
            }
            jSONObject.putOpt("pure_enhanced_mode_enable", java.lang.Integer.valueOf(i));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void vw(org.json.JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return;
        }
        org.json.JSONArray optJSONArray = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optJSONArray("ah_report_config");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    java.lang.String string = optJSONArray.getString(i2);
                    com.ss.android.socialbase.appdownloader.bt.vw vw = com.ss.android.socialbase.appdownloader.kz.vw.vw(string);
                    if (vw != null) {
                        jSONObject.put(string.replaceAll("\\.", "_"), vw.kz() + "_" + vw.bt());
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        try {
            jSONObject.put("is_unknown_source_enabled", com.ss.android.socialbase.appdownloader.wg.vw(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()) ? 1 : 2);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static org.json.JSONObject wg(@androidx.annotation.NonNull org.json.JSONObject jSONObject, com.ss.android.downloadad.api.vw.vw vwVar) {
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, com.ss.android.socialbase.appdownloader.kz.yl.es().replaceAll("\\.", "_") + " versionCode", java.lang.Integer.valueOf(com.ss.android.downloadlib.bt.vl.wg(com.ss.android.downloadlib.addownload.z.getContext(), com.ss.android.socialbase.appdownloader.kz.yl.es())));
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, com.ss.android.socialbase.appdownloader.kz.yl.es().replaceAll("\\.", "_") + " versionName", com.ss.android.downloadlib.bt.vl.t(com.ss.android.downloadlib.addownload.z.getContext(), com.ss.android.socialbase.appdownloader.kz.yl.es()));
        return jSONObject;
    }

    public static void wg(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, org.json.JSONObject jSONObject) {
        com.ss.android.downloadad.api.vw.wg vw;
        if (jSONObject == null || (vw = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo)) == null) {
            return;
        }
        try {
            t(downloadInfo, jSONObject);
            jSONObject.putOpt("time_after_click", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - vw.kn()));
            jSONObject.putOpt("click_download_size", java.lang.Long.valueOf(vw.ml()));
            jSONObject.putOpt("download_length", java.lang.Long.valueOf(downloadInfo.getCurBytes()));
            jSONObject.putOpt("download_apk_size", java.lang.Long.valueOf(downloadInfo.getTotalBytes()));
            vw.w();
            com.ss.android.downloadlib.addownload.wg.x.vw().vw(vw);
            jSONObject.put("click_pause_times", vw.tj());
            long totalBytes = downloadInfo.getTotalBytes();
            long curBytes = downloadInfo.getCurBytes();
            jSONObject.put("download_percent", (curBytes < 0 || totalBytes <= 0) ? 0.0d : curBytes / totalBytes);
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_STATUS, downloadInfo.getRealStatus());
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            long e = vw.e();
            if (e > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - e);
            }
            long zl = vw.zl();
            if (zl > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - zl);
            }
            jSONObject.putOpt("fail_status", java.lang.Integer.valueOf(vw.up()));
            jSONObject.putOpt("fail_msg", vw.tv());
            jSONObject.put("download_failed_times", vw.iq());
            jSONObject.put("can_show_notification", com.ss.android.socialbase.appdownloader.yl.v.vw() ? 1 : 2);
            jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
            jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
            jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_TIME, downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
