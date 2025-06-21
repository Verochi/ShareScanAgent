package com.ss.android.downloadlib;

/* loaded from: classes19.dex */
public class wg implements com.ss.android.downloadad.api.wg {
    private static java.lang.String vw = "wg";
    private static volatile com.ss.android.downloadlib.wg wg;
    private com.ss.android.downloadlib.o t = com.ss.android.downloadlib.o.vw(com.ss.android.downloadlib.addownload.z.getContext());

    /* renamed from: com.ss.android.downloadlib.wg$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.downloadlib.yl.wg.vw<android.app.Dialog> {
        final /* synthetic */ com.ss.android.download.api.download.DownloadStatusChangeListener bt;
        final /* synthetic */ com.ss.android.download.api.config.IDownloadButtonClickListener es;
        final /* synthetic */ com.ss.android.download.api.download.DownloadController kz;
        final /* synthetic */ int o;
        final /* synthetic */ boolean t;
        final /* synthetic */ com.ss.android.download.api.download.DownloadModel v;
        final /* synthetic */ android.content.Context vw;
        final /* synthetic */ java.lang.String wg;
        final /* synthetic */ boolean x;
        final /* synthetic */ com.ss.android.download.api.download.DownloadEventConfig yl;

        public AnonymousClass1(android.content.Context context, java.lang.String str, boolean z, com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.download.DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2, com.ss.android.download.api.config.IDownloadButtonClickListener iDownloadButtonClickListener) {
            this.vw = context;
            this.wg = str;
            this.t = z;
            this.v = downloadModel;
            this.yl = downloadEventConfig;
            this.kz = downloadController;
            this.bt = downloadStatusChangeListener;
            this.o = i;
            this.x = z2;
            this.es = iDownloadButtonClickListener;
        }

        @Override // com.ss.android.downloadlib.yl.wg.vw
        /* renamed from: vw, reason: merged with bridge method [inline-methods] */
        public android.app.Dialog wg() {
            return com.ss.android.downloadlib.wg.this.wg(this.vw, this.wg, this.t, this.v, this.yl, this.kz, this.bt, this.o, this.x, this.es);
        }
    }

    /* renamed from: com.ss.android.downloadlib.wg$2, reason: invalid class name */
    public class AnonymousClass2 implements com.ss.android.download.api.model.wg.InterfaceC0468wg {
        final /* synthetic */ com.ss.android.download.api.download.DownloadController t;
        final /* synthetic */ com.ss.android.download.api.download.DownloadModel vw;
        final /* synthetic */ com.ss.android.download.api.download.DownloadEventConfig wg;

        public AnonymousClass2(com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController) {
            this.vw = downloadModel;
            this.wg = downloadEventConfig;
            this.t = downloadController;
        }

        @Override // com.ss.android.download.api.model.wg.InterfaceC0468wg
        public void t(android.content.DialogInterface dialogInterface) {
            com.ss.android.downloadlib.v.vw.vw().vw("landing_download_dialog_cancel", this.vw, this.wg, this.t);
        }

        @Override // com.ss.android.download.api.model.wg.InterfaceC0468wg
        public void vw(android.content.DialogInterface dialogInterface) {
            com.ss.android.downloadlib.wg.this.t.vw(this.vw.getDownloadUrl(), this.vw.getId(), 2, this.wg, this.t);
            com.ss.android.downloadlib.v.vw.vw().vw("landing_download_dialog_confirm", this.vw, this.wg, this.t);
            dialogInterface.dismiss();
        }

        @Override // com.ss.android.download.api.model.wg.InterfaceC0468wg
        public void wg(android.content.DialogInterface dialogInterface) {
            com.ss.android.downloadlib.v.vw.vw().vw("landing_download_dialog_cancel", this.vw, this.wg, this.t);
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.ss.android.downloadlib.wg$3, reason: invalid class name */
    public class AnonymousClass3 implements com.ss.android.downloadlib.yl.wg.vw<java.lang.Boolean> {
        final /* synthetic */ com.ss.android.download.api.config.IDownloadButtonClickListener kz;
        final /* synthetic */ com.ss.android.download.api.download.DownloadModel t;
        final /* synthetic */ com.ss.android.download.api.download.DownloadEventConfig v;
        final /* synthetic */ android.content.Context vw;
        final /* synthetic */ android.net.Uri wg;
        final /* synthetic */ com.ss.android.download.api.download.DownloadController yl;

        public AnonymousClass3(android.content.Context context, android.net.Uri uri, com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.config.IDownloadButtonClickListener iDownloadButtonClickListener) {
            this.vw = context;
            this.wg = uri;
            this.t = downloadModel;
            this.v = downloadEventConfig;
            this.yl = downloadController;
            this.kz = iDownloadButtonClickListener;
        }

        @Override // com.ss.android.downloadlib.yl.wg.vw
        /* renamed from: vw, reason: merged with bridge method [inline-methods] */
        public java.lang.Boolean wg() {
            return java.lang.Boolean.valueOf(com.ss.android.downloadlib.wg.this.wg(this.vw, this.wg, this.t, this.v, this.yl, this.kz));
        }
    }

    private wg() {
    }

    public static com.ss.android.download.api.download.DownloadEventConfig t() {
        return new com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder().setClickButtonTag("landing_h5_download_ad_button").setClickItemTag("landing_h5_download_ad_button").setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setClickOpenLabel("click_open_detail").setStorageDenyLabel("storage_deny_detail").setDownloadScene(1).setIsEnableClickEvent(false).setIsEnableNoChargeClickEvent(true).setIsEnableV3Event(false).build();
    }

    public static com.ss.android.download.api.download.DownloadController vw(boolean z) {
        com.ss.android.downloadad.api.download.AdDownloadController.Builder shouldUseNewWebView = new com.ss.android.downloadad.api.download.AdDownloadController.Builder().setLinkMode(0).setIsEnableBackDialog(true).setIsEnableMultipleDownload(false).setShouldUseNewWebView(false);
        if (z) {
            shouldUseNewWebView.setDownloadMode(2);
        } else {
            shouldUseNewWebView.setDownloadMode(0);
        }
        return shouldUseNewWebView.build();
    }

    public static com.ss.android.downloadlib.wg vw() {
        if (wg == null) {
            synchronized (com.ss.android.downloadlib.wg.class) {
                if (wg == null) {
                    wg = new com.ss.android.downloadlib.wg();
                }
            }
        }
        return wg;
    }

    public static com.ss.android.download.api.download.DownloadController wg() {
        return vw(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wg(android.content.Context context, android.net.Uri uri, com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.config.IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.download.api.download.DownloadController downloadController2 = downloadController;
        if (!com.ss.android.download.api.t.vw.vw(uri) || com.ss.android.downloadlib.addownload.z.x().optInt("disable_market") == 1) {
            return false;
        }
        android.content.Context context2 = context == null ? com.ss.android.downloadlib.addownload.z.getContext() : context;
        java.lang.String wg2 = com.ss.android.download.api.t.vw.wg(uri);
        if (downloadModel == null) {
            return com.ss.android.downloadlib.bt.x.vw(context2, wg2).getType() == 5;
        }
        if (!android.text.TextUtils.isEmpty(wg2) && (downloadModel instanceof com.ss.android.downloadad.api.download.AdDownloadModel)) {
            ((com.ss.android.downloadad.api.download.AdDownloadModel) downloadModel).setPackageName(wg2);
        }
        if (downloadController2 != null) {
            downloadController2.setDownloadMode(2);
        } else if ((downloadModel instanceof com.ss.android.downloadad.api.download.AdDownloadModel) && android.text.TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            ((com.ss.android.downloadad.api.download.AdDownloadModel) downloadModel).setDownloadUrl(uri.toString());
            downloadController2 = vw(true);
        } else {
            downloadController2 = downloadModel.getDownloadUrl().startsWith("market") ? vw(true) : wg();
        }
        com.ss.android.downloadlib.addownload.wg.yl ylVar = new com.ss.android.downloadlib.addownload.wg.yl(downloadModel.getId(), downloadModel, (com.ss.android.download.api.download.DownloadEventConfig) com.ss.android.downloadlib.bt.vl.vw(downloadEventConfig, t()), downloadController2);
        com.ss.android.downloadlib.addownload.wg.kz.vw().vw(ylVar.wg);
        com.ss.android.downloadlib.addownload.wg.kz.vw().vw(ylVar.vw, ylVar.t);
        com.ss.android.downloadlib.addownload.wg.kz.vw().vw(ylVar.vw, ylVar.v);
        if (com.ss.android.downloadlib.bt.vl.vw(downloadModel) && com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optInt("app_link_opt") == 1 && com.ss.android.downloadlib.wg.vw.vw(ylVar)) {
            return true;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "market_url", uri.toString());
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "download_scene", (java.lang.Object) 1);
        com.ss.android.downloadlib.v.vw.vw().wg("market_click_open", jSONObject, ylVar);
        com.ss.android.downloadlib.addownload.wg.bt vw2 = com.ss.android.downloadlib.bt.x.vw(context2, ylVar, wg2);
        java.lang.String vw3 = com.ss.android.downloadlib.bt.vl.vw(vw2.wg(), "open_market");
        if (vw2.getType() == 5) {
            com.ss.android.downloadlib.wg.vw.vw(vw3, jSONObject, ylVar, true);
            return true;
        }
        if (vw2.getType() != 6) {
            return true;
        }
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "error_code", java.lang.Integer.valueOf(vw2.vw()));
        com.ss.android.downloadlib.v.vw.vw().wg("market_open_failed", jSONObject, ylVar);
        if (com.ss.android.downloadlib.addownload.x.vw(downloadModel, iDownloadButtonClickListener)) {
            iDownloadButtonClickListener.handleMarketFailedComplianceDialog();
        }
        return false;
    }

    @Override // com.ss.android.downloadad.api.wg
    public android.app.Dialog vw(android.content.Context context, java.lang.String str, boolean z, @androidx.annotation.NonNull com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.download.DownloadStatusChangeListener downloadStatusChangeListener, int i) {
        return vw(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, false);
    }

    @Override // com.ss.android.downloadad.api.wg
    public android.app.Dialog vw(android.content.Context context, java.lang.String str, boolean z, @androidx.annotation.NonNull com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.download.DownloadStatusChangeListener downloadStatusChangeListener, int i, com.ss.android.download.api.config.IDownloadButtonClickListener iDownloadButtonClickListener) {
        return vw(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, false, iDownloadButtonClickListener);
    }

    public android.app.Dialog vw(android.content.Context context, java.lang.String str, boolean z, @androidx.annotation.NonNull com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.download.DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2) {
        return vw(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, z2, null);
    }

    public android.app.Dialog vw(android.content.Context context, java.lang.String str, boolean z, @androidx.annotation.NonNull com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.download.DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2, com.ss.android.download.api.config.IDownloadButtonClickListener iDownloadButtonClickListener) {
        return (android.app.Dialog) com.ss.android.downloadlib.yl.wg.vw(new com.ss.android.downloadlib.wg.AnonymousClass1(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, z2, iDownloadButtonClickListener));
    }

    public void vw(long j, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController) {
        com.ss.android.download.api.download.DownloadModel vw2 = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(j);
        com.ss.android.downloadad.api.vw.wg v = com.ss.android.downloadlib.addownload.wg.kz.vw().v(j);
        if (vw2 == null && v != null) {
            vw2 = v.wj();
        }
        if (vw2 == null) {
            return;
        }
        if (downloadEventConfig == null || downloadController == null || (downloadEventConfig instanceof com.ss.android.download.api.download.t) || (downloadController instanceof com.ss.android.download.api.download.wg)) {
            wg(j);
        } else {
            downloadEventConfig.setDownloadScene(1);
            this.t.vw(vw2.getDownloadUrl(), j, 2, downloadEventConfig, downloadController);
        }
    }

    @Override // com.ss.android.downloadad.api.wg
    public boolean vw(long j) {
        return (com.ss.android.downloadlib.addownload.wg.kz.vw().vw(j) == null && com.ss.android.downloadlib.addownload.wg.kz.vw().v(j) == null) ? false : true;
    }

    @Override // com.ss.android.downloadad.api.wg
    public boolean vw(long j, int i) {
        com.ss.android.download.api.download.DownloadModel vw2 = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(j);
        if (vw2 == null) {
            return false;
        }
        this.t.vw(vw2.getDownloadUrl(), i);
        return true;
    }

    @Override // com.ss.android.downloadad.api.wg
    public boolean vw(android.content.Context context, long j, java.lang.String str, com.ss.android.download.api.download.DownloadStatusChangeListener downloadStatusChangeListener, int i) {
        com.ss.android.downloadad.api.vw.wg v = com.ss.android.downloadlib.addownload.wg.kz.vw().v(j);
        if (v != null) {
            this.t.vw(context, i, downloadStatusChangeListener, v.wj());
            return true;
        }
        com.ss.android.download.api.download.DownloadModel vw2 = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(j);
        if (vw2 == null) {
            return false;
        }
        this.t.vw(context, i, downloadStatusChangeListener, vw2);
        return true;
    }

    @Override // com.ss.android.downloadad.api.wg
    public boolean vw(android.content.Context context, android.net.Uri uri, com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController) {
        return vw(context, uri, downloadModel, downloadEventConfig, downloadController, null);
    }

    @Override // com.ss.android.downloadad.api.wg
    public boolean vw(android.content.Context context, android.net.Uri uri, com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.config.IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ((java.lang.Boolean) com.ss.android.downloadlib.yl.wg.vw(new com.ss.android.downloadlib.wg.AnonymousClass3(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener))).booleanValue();
    }

    public android.app.Dialog wg(android.content.Context context, java.lang.String str, boolean z, com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.download.DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2, com.ss.android.download.api.config.IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (vw(downloadModel.getId())) {
            if (z2) {
                vw(downloadModel.getId(), downloadEventConfig, downloadController);
            } else {
                wg(downloadModel.getId());
            }
            return null;
        }
        if (context == null || android.text.TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return null;
        }
        this.t.vw(context, i, downloadStatusChangeListener, downloadModel);
        com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig2 = (com.ss.android.download.api.download.DownloadEventConfig) com.ss.android.downloadlib.bt.vl.vw(downloadEventConfig, t());
        com.ss.android.download.api.download.DownloadController downloadController2 = (com.ss.android.download.api.download.DownloadController) com.ss.android.downloadlib.bt.vl.vw(downloadController, wg());
        downloadEventConfig2.setDownloadScene(1);
        if ((downloadController2.enableShowComplianceDialog() && com.ss.android.downloadlib.addownload.compliance.wg.vw().vw(downloadModel)) ? true : (com.ss.android.downloadlib.addownload.z.x().optInt("disable_lp_dialog", 0) == 1) | z) {
            this.t.vw(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2, iDownloadButtonClickListener);
            return null;
        }
        com.ss.android.downloadlib.bt.z.vw(vw, "tryStartDownload show dialog appName:" + downloadModel.getDownloadUrl(), null);
        android.app.Dialog wg2 = com.ss.android.downloadlib.addownload.z.t().wg(new com.ss.android.download.api.model.wg.vw(context).vw(downloadModel.getName()).wg("确认要下载此应用吗？").t("确认").v("取消").vw(new com.ss.android.downloadlib.wg.AnonymousClass2(downloadModel, downloadEventConfig2, downloadController2)).vw(0).vw());
        com.ss.android.downloadlib.v.vw.vw().vw("landing_download_dialog_show", downloadModel, downloadEventConfig2, downloadController2);
        return wg2;
    }

    public void wg(long j) {
        com.ss.android.download.api.download.DownloadModel vw2 = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(j);
        com.ss.android.downloadad.api.vw.wg v = com.ss.android.downloadlib.addownload.wg.kz.vw().v(j);
        if (vw2 == null && v != null) {
            vw2 = v.wj();
        }
        if (vw2 == null) {
            return;
        }
        com.ss.android.download.api.download.DownloadEventConfig wg2 = com.ss.android.downloadlib.addownload.wg.kz.vw().wg(j);
        com.ss.android.download.api.download.DownloadController t = com.ss.android.downloadlib.addownload.wg.kz.vw().t(j);
        if (wg2 instanceof com.ss.android.download.api.download.t) {
            wg2 = null;
        }
        if (t instanceof com.ss.android.download.api.download.wg) {
            t = null;
        }
        if (v == null) {
            if (wg2 == null) {
                wg2 = t();
            }
            if (t == null) {
                t = wg();
            }
        } else {
            if (wg2 == null) {
                wg2 = new com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder().setClickButtonTag(v.es()).setRefer(v.x()).setIsEnableV3Event(v.u()).setIsEnableClickEvent(false).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setStorageDenyLabel("storage_deny_detail").build();
            }
            if (t == null) {
                t = v.am();
            }
        }
        com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig = wg2;
        downloadEventConfig.setDownloadScene(1);
        this.t.vw(vw2.getDownloadUrl(), j, 2, downloadEventConfig, t);
    }
}
