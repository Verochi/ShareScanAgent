package com.ss.android.downloadlib.v;

/* loaded from: classes19.dex */
public class vw {

    /* renamed from: com.ss.android.downloadlib.v.vw$vw, reason: collision with other inner class name */
    public static class C0474vw {
        private static com.ss.android.downloadlib.v.vw vw = new com.ss.android.downloadlib.v.vw(null);
    }

    private vw() {
    }

    public /* synthetic */ vw(com.ss.android.downloadlib.v.vw.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.ss.android.downloadlib.v.vw vw() {
        return com.ss.android.downloadlib.v.vw.C0474vw.vw;
    }

    private org.json.JSONObject vw(com.ss.android.downloadad.api.vw.vw vwVar) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            com.ss.android.downloadlib.bt.vl.vw(vwVar.bt(), jSONObject);
            com.ss.android.downloadlib.bt.vl.vw(vwVar.j(), jSONObject);
            jSONObject.putOpt("download_url", vwVar.vw());
            jSONObject.putOpt("package_name", vwVar.yl());
            jSONObject.putOpt("android_int", java.lang.Integer.valueOf(android.os.Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.ss.android.socialbase.appdownloader.kz.yl.o());
            jSONObject.putOpt("rom_version", com.ss.android.socialbase.appdownloader.kz.yl.x());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", java.lang.Integer.valueOf(vwVar.o()));
            if (vwVar.o() == 2) {
                com.ss.android.downloadlib.bt.kz.wg(jSONObject, vwVar);
            }
            if (com.ss.android.socialbase.appdownloader.kz.yl.j()) {
                com.ss.android.downloadlib.bt.kz.vw(jSONObject);
            }
        } catch (java.lang.Exception e) {
            com.ss.android.downloadlib.addownload.z.q().vw(e, "getBaseJson");
        }
        return jSONObject;
    }

    private void vw(com.ss.android.download.api.model.t tVar) {
        if (com.ss.android.downloadlib.addownload.z.vw() == null) {
            return;
        }
        if (tVar.u()) {
            com.ss.android.downloadlib.addownload.z.vw().vw(tVar);
        } else {
            com.ss.android.downloadlib.addownload.z.vw().wg(tVar);
        }
    }

    private void vw(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject, long j, int i, com.ss.android.downloadad.api.vw.vw vwVar) {
        if (vwVar == null) {
            com.ss.android.downloadlib.yl.t.vw().vw("onEvent data null");
            return;
        }
        if ((vwVar instanceof com.ss.android.downloadlib.addownload.wg.yl) && ((com.ss.android.downloadlib.addownload.wg.yl) vwVar).iq()) {
            com.ss.android.downloadlib.yl.t.vw().vw("onEvent ModelBox notValid");
            return;
        }
        try {
            com.ss.android.download.api.model.t.vw t = new com.ss.android.download.api.model.t.vw().vw(com.ss.android.downloadlib.bt.vl.vw(str, vwVar.es(), "embeded_ad")).wg(str2).wg(vwVar.t()).vw(vwVar.wg()).t(vwVar.v());
            if (j <= 0) {
                j = vwVar.vl();
            }
            com.ss.android.download.api.model.t.vw vw = t.wg(j).v(vwVar.x()).vw(vwVar.cp()).vw(com.ss.android.downloadlib.bt.vl.vw(vw(vwVar), jSONObject)).wg(vwVar.z()).vw(vwVar.d());
            if (i <= 0) {
                i = 2;
            }
            vw(vw.vw(i).vw(vwVar.u()).vw());
        } catch (java.lang.Exception e) {
            com.ss.android.downloadlib.yl.t.vw().vw(e, "onEvent");
        }
    }

    public void vw(long j, int i) {
        com.ss.android.downloadlib.addownload.wg.yl yl = com.ss.android.downloadlib.addownload.wg.kz.vw().yl(j);
        if (yl.iq()) {
            com.ss.android.downloadlib.yl.t.vw().vw("sendClickEvent ModelBox notValid");
            return;
        }
        if (yl.t.isEnableClickEvent()) {
            int i2 = 1;
            com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig = yl.t;
            java.lang.String clickItemTag = i == 1 ? downloadEventConfig.getClickItemTag() : downloadEventConfig.getClickButtonTag();
            java.lang.String vw = com.ss.android.downloadlib.bt.vl.vw(yl.t.getClickLabel(), com.anythink.expressad.foundation.d.c.ca);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.putOpt("download_click_type", java.lang.Integer.valueOf(i));
                jSONObject.putOpt("permission_notification", java.lang.Integer.valueOf(com.ss.android.socialbase.appdownloader.yl.v.vw() ? 1 : 2));
                if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.isNetworkConnected(com.ss.android.downloadlib.addownload.z.getContext())) {
                    i2 = 2;
                }
                jSONObject.putOpt("network_available", java.lang.Integer.valueOf(i2));
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            vw(clickItemTag, vw, jSONObject, yl);
            if (!com.anythink.expressad.foundation.d.c.ca.equals(vw) || yl.wg == null) {
                return;
            }
            com.ss.android.downloadlib.v.t.vw().vw(j, yl.wg.getLogExtra());
        }
    }

    public void vw(long j, int i, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        java.lang.String vw;
        com.ss.android.downloadlib.addownload.wg.yl yl = com.ss.android.downloadlib.addownload.wg.kz.vw().yl(j);
        if (yl.iq()) {
            com.ss.android.downloadlib.yl.t.vw().vw("sendEvent ModelBox notValid");
            return;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "download_scene", java.lang.Integer.valueOf(yl.q()));
        if (i == 1) {
            vw = com.ss.android.downloadlib.bt.vl.vw(yl.t.getStorageDenyLabel(), "storage_deny");
        } else if (i == 2) {
            vw = com.ss.android.downloadlib.bt.vl.vw(yl.t.getClickStartLabel(), "click_start");
            com.ss.android.downloadlib.bt.kz.vw(downloadInfo, jSONObject);
        } else if (i == 3) {
            vw = com.ss.android.downloadlib.bt.vl.vw(yl.t.getClickPauseLabel(), "click_pause");
            com.ss.android.downloadlib.bt.kz.wg(downloadInfo, jSONObject);
        } else if (i == 4) {
            vw = com.ss.android.downloadlib.bt.vl.vw(yl.t.getClickContinueLabel(), "click_continue");
            com.ss.android.downloadlib.bt.kz.t(downloadInfo, jSONObject);
        } else if (i != 5) {
            vw = null;
        } else {
            if (downloadInfo != null) {
                try {
                    com.ss.android.downloadlib.bt.kz.vw(jSONObject, downloadInfo.getId());
                    com.ss.android.downloadlib.vw.wg(jSONObject, downloadInfo);
                } catch (java.lang.Throwable unused) {
                }
            }
            vw = com.ss.android.downloadlib.bt.vl.vw(yl.t.getClickInstallLabel(), "click_install");
        }
        vw(null, vw, jSONObject, 0L, 1, yl);
    }

    public void vw(long j, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        com.ss.android.downloadlib.addownload.wg.yl yl = com.ss.android.downloadlib.addownload.wg.kz.vw().yl(j);
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_TIME, 0);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", java.lang.Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        wg("download_failed", jSONObject, yl);
    }

    public void vw(long j, boolean z, int i) {
        com.ss.android.downloadlib.addownload.wg.yl yl = com.ss.android.downloadlib.addownload.wg.kz.vw().yl(j);
        if (yl.iq()) {
            com.ss.android.downloadlib.yl.t.vw().vw("sendQuickAppEvent ModelBox notValid");
            return;
        }
        if (yl.wg.getQuickAppModel() == null) {
            return;
        }
        com.ss.android.download.api.download.DownloadModel downloadModel = yl.wg;
        if (downloadModel instanceof com.ss.android.downloadad.api.download.AdDownloadModel) {
            ((com.ss.android.downloadad.api.download.AdDownloadModel) downloadModel).setFunnelType(3);
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("download_click_type", java.lang.Integer.valueOf(i));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        wg(z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, yl);
    }

    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        com.ss.android.downloadad.api.vw.wg vw = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo);
        if (vw == null) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            com.ss.android.downloadlib.bt.kz.t(downloadInfo, jSONObject);
            vw.vw(java.lang.System.currentTimeMillis());
            vw(vw.es(), "download_resume", jSONObject, vw);
            com.ss.android.downloadlib.addownload.wg.x.vw().vw(vw);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        com.ss.android.downloadad.api.vw.wg vw;
        if (downloadInfo == null || (vw = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo)) == null || vw.t.get()) {
            return;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            com.ss.android.downloadlib.vw.vw(jSONObject, downloadInfo);
            jSONObject.putOpt("fail_status", java.lang.Integer.valueOf(vw.up()));
            jSONObject.putOpt("fail_msg", vw.tv());
            jSONObject.put("download_failed_times", vw.iq());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            jSONObject.put(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_STATUS, downloadInfo.getRealStatus());
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (vw.e() > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - vw.e());
            }
            if (vw.zl() > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - vw.zl());
            }
            int i = 1;
            jSONObject.put("is_update_download", vw.ih() ? 1 : 2);
            jSONObject.put("can_show_notification", com.ss.android.socialbase.appdownloader.yl.v.vw() ? 1 : 2);
            if (!vw.v.get()) {
                i = 2;
            }
            jSONObject.put("has_send_download_failed_finally", i);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        vw(vw.es(), "download_cancel", jSONObject, vw);
    }

    public void vw(java.lang.String str, int i, com.ss.android.downloadlib.addownload.wg.yl ylVar) {
        vw(null, str, null, i, 0, ylVar);
    }

    public void vw(java.lang.String str, long j) {
        com.ss.android.downloadad.api.vw.wg v = com.ss.android.downloadlib.addownload.wg.kz.vw().v(j);
        if (v != null) {
            wg(str, v);
        } else {
            wg(str, com.ss.android.downloadlib.addownload.wg.kz.vw().yl(j));
        }
    }

    public void vw(java.lang.String str, @androidx.annotation.NonNull com.ss.android.download.api.download.DownloadModel downloadModel, @androidx.annotation.NonNull com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, @androidx.annotation.NonNull com.ss.android.download.api.download.DownloadController downloadController) {
        wg(str, new com.ss.android.downloadlib.addownload.wg.yl(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
    }

    public void vw(java.lang.String str, com.ss.android.downloadad.api.vw.vw vwVar) {
        vw(str, (org.json.JSONObject) null, vwVar);
    }

    public void vw(java.lang.String str, java.lang.String str2, com.ss.android.downloadad.api.vw.vw vwVar) {
        vw(str, str2, (org.json.JSONObject) null, vwVar);
    }

    public void vw(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject, com.ss.android.downloadad.api.vw.vw vwVar) {
        vw(str, str2, jSONObject, 0L, 0, vwVar);
    }

    public void vw(java.lang.String str, org.json.JSONObject jSONObject, long j) {
        com.ss.android.downloadad.api.vw.vw v = com.ss.android.downloadlib.addownload.wg.kz.vw().v(j);
        if (v != null) {
            vw(str, jSONObject, v);
            return;
        }
        com.ss.android.downloadlib.addownload.wg.yl yl = com.ss.android.downloadlib.addownload.wg.kz.vw().yl(j);
        if (yl.iq()) {
            com.ss.android.downloadlib.yl.t.vw().vw("sendUnityEvent ModelBox notValid");
        } else {
            vw(str, jSONObject, yl);
        }
    }

    public void vw(java.lang.String str, org.json.JSONObject jSONObject, com.ss.android.downloadad.api.vw.vw vwVar) {
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        com.ss.android.downloadlib.bt.vl.vw(jSONObject2, "unity_label", str);
        vw("embeded_ad", "ttdownloader_unity", com.ss.android.downloadlib.bt.vl.vw(jSONObject, jSONObject2), vwVar);
    }

    public void vw(org.json.JSONObject jSONObject, @androidx.annotation.NonNull com.ss.android.downloadad.api.vw.wg wgVar) {
        vw(wgVar.es(), "install_finish", jSONObject, wgVar);
    }

    public void wg(long j, int i) {
        vw(j, i, (com.ss.android.socialbase.downloader.model.DownloadInfo) null);
    }

    public void wg(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadad.api.vw.wg vw = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo);
        if (vw == null) {
            com.ss.android.downloadlib.yl.t.vw().vw("sendDownloadFailedEvent nativeModel null");
            return;
        }
        if (vw.t.get()) {
            return;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            com.ss.android.downloadlib.bt.kz.t(downloadInfo, jSONObject);
            com.ss.android.downloadlib.vw.vw(jSONObject, downloadInfo);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", java.lang.Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                vw.v(baseException.getErrorCode());
                vw.vw(baseException.getErrorMessage());
            }
            vw.iz();
            jSONObject.put("download_failed_times", vw.iq());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            int i = 1;
            jSONObject.put("has_send_download_failed_finally", vw.v.get() ? 1 : 2);
            com.ss.android.downloadlib.bt.kz.vw(vw, jSONObject);
            if (!vw.ih()) {
                i = 2;
            }
            jSONObject.put("is_update_download", i);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        vw(vw.es(), "download_failed", jSONObject, vw);
        com.ss.android.downloadlib.addownload.wg.x.vw().vw(vw);
    }

    public void wg(java.lang.String str, com.ss.android.downloadad.api.vw.vw vwVar) {
        vw((java.lang.String) null, str, vwVar);
    }

    public void wg(java.lang.String str, org.json.JSONObject jSONObject, com.ss.android.downloadad.api.vw.vw vwVar) {
        vw((java.lang.String) null, str, jSONObject, vwVar);
    }
}
