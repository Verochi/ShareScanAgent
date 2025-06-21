package com.ss.android.downloadlib.wg;

/* loaded from: classes19.dex */
public class vw {

    /* renamed from: com.ss.android.downloadlib.wg.vw$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.ss.android.downloadlib.wg.v {
        final /* synthetic */ org.json.JSONObject vw;
        final /* synthetic */ com.ss.android.downloadad.api.vw.vw wg;

        public AnonymousClass1(org.json.JSONObject jSONObject, com.ss.android.downloadad.api.vw.vw vwVar) {
            this.vw = jSONObject;
            this.wg = vwVar;
        }

        @Override // com.ss.android.downloadlib.wg.v
        public void vw(boolean z) {
            com.ss.android.downloadlib.v.vw.vw().wg(z ? "deeplink_success" : "deeplink_failed", this.vw, this.wg);
            if (z) {
                com.ss.android.downloadlib.addownload.z.qm();
                com.ss.android.downloadlib.addownload.z.getContext();
                this.wg.qm();
                this.wg.h();
                this.wg.n();
                this.wg.yl();
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.wg.vw$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.ss.android.downloadlib.wg.v {
        final /* synthetic */ org.json.JSONObject vw;
        final /* synthetic */ com.ss.android.downloadad.api.vw.vw wg;

        public AnonymousClass2(org.json.JSONObject jSONObject, com.ss.android.downloadad.api.vw.vw vwVar) {
            this.vw = jSONObject;
            this.wg = vwVar;
        }

        @Override // com.ss.android.downloadlib.wg.v
        public void vw(boolean z) {
            com.ss.android.downloadlib.v.vw.vw().wg(z ? "deeplink_success" : "deeplink_failed", this.vw, this.wg);
            if (z) {
                com.ss.android.downloadlib.addownload.z.qm();
                com.ss.android.downloadlib.addownload.z.getContext();
                this.wg.qm();
                this.wg.h();
                this.wg.n();
                this.wg.yl();
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.wg.vw$3, reason: invalid class name */
    public static class AnonymousClass3 implements com.ss.android.downloadlib.wg.v {
        final /* synthetic */ org.json.JSONObject t;
        final /* synthetic */ java.lang.String vw;
        final /* synthetic */ com.ss.android.downloadlib.addownload.wg.yl wg;

        public AnonymousClass3(java.lang.String str, com.ss.android.downloadlib.addownload.wg.yl ylVar, org.json.JSONObject jSONObject) {
            this.vw = str;
            this.wg = ylVar;
            this.t = jSONObject;
        }

        @Override // com.ss.android.downloadlib.wg.v
        public void vw(boolean z) {
            if (!z && !"open_market".equals(this.vw)) {
                com.ss.android.downloadlib.wg.vw.vw(com.ss.android.downloadlib.bt.x.vw(com.ss.android.downloadlib.addownload.z.getContext(), android.net.Uri.parse("market://details?id=" + this.wg.yl())), this.wg, false);
            }
            com.ss.android.downloadlib.v.vw.vw().vw(z ? "market_delay_success" : "market_delay_failed", this.t, this.wg);
            if (z) {
                com.ss.android.downloadlib.addownload.z.qm();
                com.ss.android.downloadlib.addownload.z.getContext();
                this.wg.wg.getPackageName();
            }
        }
    }

    public static void vw(@androidx.annotation.NonNull com.ss.android.downloadad.api.vw.wg wgVar) {
        java.lang.String kz = wgVar.kz();
        org.json.JSONObject vw = com.ss.android.downloadlib.bt.kz.vw(new org.json.JSONObject(), wgVar);
        com.ss.android.downloadlib.bt.vl.vw(vw, "applink_source", "notify_click_by_sdk");
        com.ss.android.downloadlib.v.vw.vw().wg("applink_click", vw, wgVar);
        com.ss.android.downloadlib.addownload.wg.bt vw2 = com.ss.android.downloadlib.bt.x.vw(kz, wgVar);
        if (vw2.getType() == 2) {
            if (!android.text.TextUtils.isEmpty(kz)) {
                wg("notify_by_url", vw2, vw, wgVar);
            }
            vw2 = com.ss.android.downloadlib.bt.x.vw(com.ss.android.downloadlib.addownload.z.getContext(), wgVar.yl(), wgVar);
        }
        int type = vw2.getType();
        if (type == 1) {
            wg("notify_by_url", vw, wgVar);
            return;
        }
        if (type == 3) {
            vw("notify_by_package", vw, wgVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.yl.t.vw().wg("AppLinkClickNotification default");
        } else {
            vw("notify_by_package", vw2, vw, wgVar);
        }
    }

    public static void vw(com.ss.android.downloadlib.addownload.wg.bt btVar, com.ss.android.downloadlib.addownload.wg.yl ylVar, boolean z) {
        java.lang.String vw = com.ss.android.downloadlib.bt.vl.vw(btVar.wg(), "open_market");
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "ttdownloader_type", "backup");
        int type = btVar.getType();
        if (type == 5) {
            vw(vw, jSONObject, ylVar, z);
        } else {
            if (type != 6) {
                return;
            }
            com.ss.android.downloadlib.bt.vl.vw(jSONObject, "error_code", java.lang.Integer.valueOf(btVar.vw()));
            com.ss.android.downloadlib.bt.vl.vw(jSONObject, "download_scene", java.lang.Integer.valueOf(ylVar.q()));
            com.ss.android.downloadlib.v.vw.vw().wg("market_open_failed", jSONObject, ylVar);
        }
    }

    public static void vw(java.lang.String str, @androidx.annotation.NonNull com.ss.android.downloadlib.addownload.wg.bt btVar, @androidx.annotation.NonNull org.json.JSONObject jSONObject, @androidx.annotation.NonNull com.ss.android.downloadad.api.vw.vw vwVar) {
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "applink_source", str);
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "error_code", java.lang.Integer.valueOf(btVar.vw()));
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "download_scene", java.lang.Integer.valueOf(vwVar.q()));
        com.ss.android.downloadlib.v.vw.vw().wg("deeplink_app_open_fail", jSONObject, vwVar);
    }

    public static void vw(java.lang.String str, @androidx.annotation.NonNull org.json.JSONObject jSONObject, @androidx.annotation.NonNull com.ss.android.downloadad.api.vw.vw vwVar) {
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "applink_source", str);
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "download_scene", java.lang.Integer.valueOf(vwVar.q()));
        com.ss.android.downloadlib.v.vw.vw().wg("deeplink_app_open", jSONObject, vwVar);
        str.hashCode();
        switch (str) {
            case "notify_by_package":
            case "auto_by_package":
            case "by_package":
            case "dialog_by_package":
                if ((com.ss.android.downloadlib.addownload.z.x().optInt("check_applink_mode") & 1) == 0) {
                    com.ss.android.downloadlib.addownload.z.wg();
                    com.ss.android.downloadlib.addownload.z.getContext();
                    vwVar.qm();
                    vwVar.h();
                    vwVar.n();
                    vwVar.yl();
                    break;
                } else {
                    com.ss.android.downloadlib.bt.vl.vw(jSONObject, "check_applink_result_by_sdk", (java.lang.Object) 1);
                    com.ss.android.downloadlib.wg.yl.vw().vw(new com.ss.android.downloadlib.wg.vw.AnonymousClass1(jSONObject, vwVar));
                    break;
                }
        }
    }

    public static void vw(java.lang.String str, @androidx.annotation.Nullable org.json.JSONObject jSONObject, com.ss.android.downloadlib.addownload.wg.yl ylVar, boolean z) {
        if (jSONObject == null) {
            try {
                jSONObject = new org.json.JSONObject();
            } catch (java.lang.Exception e) {
                com.ss.android.downloadlib.yl.t.vw().vw(e, "onMarketSuccess");
                return;
            }
        }
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "applink_source", str);
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "download_scene", java.lang.Integer.valueOf(ylVar.q()));
        if (z) {
            com.ss.android.downloadlib.v.vw.vw().wg("market_open_success", jSONObject, ylVar);
        }
        if ((com.ss.android.downloadlib.addownload.z.x().optInt("check_applink_mode") & 4) != 0) {
            com.ss.android.downloadlib.wg.yl.vw().wg(new com.ss.android.downloadlib.wg.vw.AnonymousClass3(str, ylVar, jSONObject));
        } else {
            com.ss.android.downloadlib.addownload.z.wg();
            com.ss.android.downloadlib.addownload.z.getContext();
            ylVar.wg.getPackageName();
        }
        com.ss.android.downloadad.api.vw.wg wgVar = new com.ss.android.downloadad.api.vw.wg(ylVar.wg, ylVar.t, ylVar.v);
        wgVar.yl(2);
        wgVar.kz(java.lang.System.currentTimeMillis());
        wgVar.o(4);
        wgVar.x(2);
        com.ss.android.downloadlib.addownload.wg.kz.vw().vw(wgVar);
    }

    public static boolean vw(long j) {
        return com.ss.android.downloadlib.addownload.wg.kz.vw().v(j) == null;
    }

    public static boolean vw(@androidx.annotation.NonNull com.ss.android.downloadlib.addownload.wg.yl ylVar) {
        boolean z;
        com.ss.android.download.api.model.DeepLink deepLink = ylVar.wg.getDeepLink();
        java.lang.String openUrl = deepLink == null ? null : deepLink.getOpenUrl();
        org.json.JSONObject vw = com.ss.android.downloadlib.bt.kz.vw(new org.json.JSONObject(), ylVar);
        com.ss.android.downloadlib.bt.vl.vw(vw, "applink_source", "click_by_sdk");
        com.ss.android.downloadlib.v.vw.vw().wg("applink_click", vw, ylVar);
        com.ss.android.downloadlib.addownload.wg.bt vw2 = com.ss.android.downloadlib.bt.x.vw(openUrl, ylVar);
        if (vw2.getType() == 2) {
            if (!android.text.TextUtils.isEmpty(openUrl)) {
                wg("by_url", vw2, vw, ylVar);
            }
            vw2 = com.ss.android.downloadlib.bt.x.vw(com.ss.android.downloadlib.addownload.z.getContext(), ylVar.wg.getPackageName(), ylVar);
        }
        boolean z2 = false;
        if (vw(ylVar.vw) && com.ss.android.downloadlib.addownload.z.x().optInt("link_ad_click_event") == 1) {
            com.ss.android.download.api.download.DownloadModel downloadModel = ylVar.wg;
            if (downloadModel instanceof com.ss.android.downloadad.api.download.AdDownloadModel) {
                ((com.ss.android.downloadad.api.download.AdDownloadModel) downloadModel).setFunnelType(4);
            }
            com.ss.android.downloadlib.v.vw.vw().vw(ylVar.vw, 0);
            z = true;
        } else {
            z = false;
        }
        int type = vw2.getType();
        if (type == 1) {
            wg("by_url", vw, ylVar);
        } else {
            if (type != 3) {
                if (type != 4) {
                    com.ss.android.downloadlib.yl.t.vw().wg("AppLinkClick default");
                } else {
                    vw("by_package", vw2, vw, ylVar);
                }
                if (z2 && !z && ((com.ss.android.downloadlib.v.t.vw().wg() && !com.ss.android.downloadlib.v.t.vw().wg(ylVar.vw, ylVar.wg.getLogExtra())) || com.ss.android.downloadlib.v.t.vw().t())) {
                    com.ss.android.downloadlib.v.vw.vw().vw(ylVar.vw, 2);
                }
                return z2;
            }
            vw("by_package", vw, ylVar);
        }
        z2 = true;
        if (z2) {
            com.ss.android.downloadlib.v.vw.vw().vw(ylVar.vw, 2);
        }
        return z2;
    }

    public static boolean vw(@androidx.annotation.NonNull com.ss.android.downloadlib.addownload.wg.yl ylVar, int i) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "download_scene", java.lang.Integer.valueOf(ylVar.q()));
        com.ss.android.downloadlib.v.vw.vw().wg("market_click_open", jSONObject, ylVar);
        com.ss.android.downloadlib.addownload.wg.bt vw = com.ss.android.downloadlib.bt.x.vw(com.ss.android.downloadlib.addownload.z.getContext(), ylVar, ylVar.wg.getPackageName());
        java.lang.String vw2 = com.ss.android.downloadlib.bt.vl.vw(vw.wg(), "open_market");
        int type = vw.getType();
        if (type == 5) {
            vw(vw2, jSONObject, ylVar, true);
        } else {
            if (type == 6) {
                com.ss.android.downloadlib.bt.vl.vw(jSONObject, "error_code", java.lang.Integer.valueOf(vw.vw()));
                com.ss.android.downloadlib.bt.vl.vw(jSONObject, "download_scene", java.lang.Integer.valueOf(ylVar.q()));
                com.ss.android.downloadlib.v.vw.vw().wg("market_open_failed", jSONObject, ylVar);
                return false;
            }
            if (type != 7) {
                return false;
            }
        }
        com.ss.android.downloadlib.v.vw.vw().vw(ylVar.vw, i);
        return true;
    }

    public static boolean vw(java.lang.String str, @androidx.annotation.NonNull com.ss.android.downloadad.api.vw.wg wgVar) {
        if (!com.ss.android.downloadlib.addownload.x.wg(wgVar.a())) {
            return false;
        }
        if (android.text.TextUtils.isEmpty(wgVar.kz()) && android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().cancelNotification(wgVar.tq());
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.ss.android.downloadlib.bt.kz.vw(jSONObject, wgVar);
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "applink_source", "auto_click");
        com.ss.android.downloadlib.v.vw.vw().wg("applink_click", wgVar);
        com.ss.android.downloadlib.addownload.wg.bt vw = com.ss.android.downloadlib.bt.x.vw(wgVar, wgVar.kz(), wgVar.yl());
        int type = vw.getType();
        if (type == 1) {
            wg("auto_by_url", jSONObject, wgVar);
            return true;
        }
        if (type == 2) {
            wg("auto_by_url", vw, jSONObject, wgVar);
            return false;
        }
        if (type == 3) {
            vw("auto_by_package", jSONObject, wgVar);
            return true;
        }
        if (type != 4) {
            return false;
        }
        vw("auto_by_package", vw, jSONObject, wgVar);
        return false;
    }

    public static void wg(com.ss.android.downloadad.api.vw.wg wgVar) {
        if (wgVar == null) {
            return;
        }
        java.lang.String kz = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optInt("app_link_opt") == 1 ? wgVar.kz() : null;
        org.json.JSONObject vw = com.ss.android.downloadlib.bt.kz.vw(new org.json.JSONObject(), wgVar);
        com.ss.android.downloadlib.bt.vl.vw(vw, "applink_source", "dialog_click_by_sdk");
        com.ss.android.downloadlib.v.vw.vw().wg("applink_click", vw, wgVar);
        com.ss.android.downloadlib.addownload.wg.bt vw2 = com.ss.android.downloadlib.bt.x.vw(kz, wgVar);
        if (vw2.getType() == 2) {
            if (!android.text.TextUtils.isEmpty(kz)) {
                wg("dialog_by_url", vw2, vw, wgVar);
            }
            vw2 = com.ss.android.downloadlib.bt.x.vw(com.ss.android.downloadlib.addownload.z.getContext(), wgVar.yl(), wgVar);
        }
        int type = vw2.getType();
        if (type == 1) {
            wg("dialog_by_url", vw, wgVar);
            return;
        }
        if (type == 3) {
            vw("dialog_by_package", vw, wgVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.yl.t.vw().wg("AppLinkClickDialog default");
        } else {
            vw("dialog_by_package", vw2, vw, wgVar);
        }
    }

    public static void wg(java.lang.String str, @androidx.annotation.NonNull com.ss.android.downloadlib.addownload.wg.bt btVar, @androidx.annotation.NonNull org.json.JSONObject jSONObject, @androidx.annotation.NonNull com.ss.android.downloadad.api.vw.vw vwVar) {
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "applink_source", str);
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "error_code", java.lang.Integer.valueOf(btVar.vw()));
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "download_scene", java.lang.Integer.valueOf(vwVar.q()));
        com.ss.android.downloadlib.v.vw.vw().wg("deeplink_url_open_fail", jSONObject, vwVar);
    }

    public static void wg(java.lang.String str, @androidx.annotation.NonNull org.json.JSONObject jSONObject, @androidx.annotation.NonNull com.ss.android.downloadad.api.vw.vw vwVar) {
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "applink_source", str);
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "download_scene", java.lang.Integer.valueOf(vwVar.q()));
        com.ss.android.downloadlib.v.vw.vw().wg("deeplink_url_open", jSONObject, vwVar);
        str.hashCode();
        switch (str) {
            case "auto_by_url":
            case "by_url":
            case "notify_by_url":
            case "dialog_by_url":
                if ((com.ss.android.downloadlib.addownload.z.x().optInt("check_applink_mode") & 1) == 0) {
                    com.ss.android.downloadlib.addownload.z.wg();
                    com.ss.android.downloadlib.addownload.z.getContext();
                    vwVar.qm();
                    vwVar.h();
                    vwVar.n();
                    vwVar.yl();
                    break;
                } else {
                    com.ss.android.downloadlib.bt.vl.vw(jSONObject, "check_applink_result_by_sdk", (java.lang.Object) 1);
                    com.ss.android.downloadlib.wg.yl.vw().vw(new com.ss.android.downloadlib.wg.vw.AnonymousClass2(jSONObject, vwVar));
                    break;
                }
        }
    }
}
