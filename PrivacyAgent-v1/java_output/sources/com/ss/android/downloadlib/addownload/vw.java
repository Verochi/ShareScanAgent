package com.ss.android.downloadlib.addownload;

/* loaded from: classes19.dex */
public class vw implements com.ss.android.downloadlib.bt.u.vw {
    private static final java.lang.String vw = "vw";
    private static com.ss.android.downloadlib.addownload.vw wg;
    private com.ss.android.downloadlib.bt.u t = new com.ss.android.downloadlib.bt.u(android.os.Looper.getMainLooper(), this);
    private long v;

    private vw() {
    }

    public static com.ss.android.downloadlib.addownload.vw vw() {
        if (wg == null) {
            synchronized (com.ss.android.downloadlib.addownload.vw.class) {
                if (wg == null) {
                    wg = new com.ss.android.downloadlib.addownload.vw();
                }
            }
        }
        return wg;
    }

    private void vw(com.ss.android.downloadlib.addownload.wg.vw vwVar, int i) {
        int i2;
        if (com.ss.android.downloadlib.addownload.z.vl() == null || com.ss.android.downloadlib.addownload.z.vl().vw() || vwVar == null) {
            return;
        }
        if (2 == i) {
            com.ss.android.downloadad.api.vw.wg v = com.ss.android.downloadlib.addownload.wg.kz.vw().v(vwVar.wg);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (com.ss.android.downloadlib.bt.vl.yl(com.ss.android.downloadlib.addownload.z.getContext(), vwVar.v)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i2 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i2 = 5;
                }
            } catch (java.lang.Exception unused) {
                i2 = -1;
            }
            com.ss.android.downloadlib.addownload.z.kz().vw(null, new com.ss.android.socialbase.downloader.exception.BaseException(i2, jSONObject.toString()), i2);
            com.ss.android.downloadlib.v.vw.vw().vw("embeded_ad", "ah_result", jSONObject, v);
        }
        if (com.ss.android.downloadlib.bt.vl.yl(com.ss.android.downloadlib.addownload.z.getContext(), vwVar.v)) {
            com.ss.android.downloadlib.v.vw.vw().vw("delayinstall_installed", vwVar.wg);
            return;
        }
        if (!com.ss.android.downloadlib.bt.vl.vw(vwVar.bt)) {
            com.ss.android.downloadlib.v.vw.vw().vw("delayinstall_file_lost", vwVar.wg);
        } else if (com.ss.android.downloadlib.addownload.vw.vw.vw().vw(vwVar.v)) {
            com.ss.android.downloadlib.v.vw.vw().vw("delayinstall_conflict_with_back_dialog", vwVar.wg);
        } else {
            com.ss.android.downloadlib.v.vw.vw().vw("delayinstall_install_start", vwVar.wg);
            com.ss.android.socialbase.appdownloader.v.vw(com.ss.android.downloadlib.addownload.z.getContext(), (int) vwVar.vw);
        }
    }

    @Override // com.ss.android.downloadlib.bt.u.vw
    public void vw(android.os.Message message) {
        if (message.what != 200) {
            return;
        }
        vw((com.ss.android.downloadlib.addownload.wg.vw) message.obj, message.arg1);
    }

    public void vw(@androidx.annotation.NonNull com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, long j, long j2, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        int i;
        com.ss.android.downloadlib.addownload.wg.vw vwVar = new com.ss.android.downloadlib.addownload.wg.vw(downloadInfo.getId(), j, j2, str, str2, str3, str4);
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt("back_miui_silent_install", 1) == 0 && ((com.ss.android.socialbase.appdownloader.kz.yl.u() || com.ss.android.socialbase.appdownloader.kz.yl.cp()) && com.ss.android.socialbase.downloader.utils.SystemUtils.checkServiceExists(com.ss.android.downloadlib.addownload.z.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (com.ss.android.socialbase.downloader.utils.DownloadUtils.getBoolean(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                android.os.Message obtainMessage = this.t.obtainMessage(200, vwVar);
                obtainMessage.arg1 = 2;
                this.t.sendMessageDelayed(obtainMessage, r1.optInt("check_silent_install_interval", 60000));
                return;
            }
            com.ss.android.downloadad.api.vw.wg v = com.ss.android.downloadlib.addownload.wg.kz.vw().v(vwVar.wg);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i = 5;
            } catch (java.lang.Exception unused) {
                i = -1;
            }
            com.ss.android.downloadlib.addownload.z.kz().vw(null, new com.ss.android.socialbase.downloader.exception.BaseException(i, jSONObject.toString()), i);
            com.ss.android.downloadlib.v.vw.vw().vw("embeded_ad", "ah_result", jSONObject, v);
        }
        if (com.ss.android.downloadlib.bt.yl.t()) {
            long currentTimeMillis = java.lang.System.currentTimeMillis() - this.v;
            long v2 = com.ss.android.downloadlib.bt.yl.v();
            if (currentTimeMillis < com.ss.android.downloadlib.bt.yl.yl()) {
                long yl = com.ss.android.downloadlib.bt.yl.yl() - currentTimeMillis;
                v2 += yl;
                this.v = java.lang.System.currentTimeMillis() + yl;
            } else {
                this.v = java.lang.System.currentTimeMillis();
            }
            com.ss.android.downloadlib.bt.u uVar = this.t;
            uVar.sendMessageDelayed(uVar.obtainMessage(200, vwVar), v2);
        }
    }
}
