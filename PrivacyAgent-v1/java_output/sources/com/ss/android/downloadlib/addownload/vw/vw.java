package com.ss.android.downloadlib.addownload.vw;

/* loaded from: classes19.dex */
public class vw {
    private static final java.lang.String vw = "vw";
    private static com.ss.android.downloadlib.addownload.vw.vw wg;
    private com.ss.android.downloadlib.addownload.vw.wg kz;

    @androidx.annotation.NonNull
    private java.util.concurrent.CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.wg.vw> t;
    private boolean v = false;
    private java.lang.String yl;

    /* renamed from: com.ss.android.downloadlib.addownload.vw.vw$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.download.api.model.wg.InterfaceC0468wg {
        final /* synthetic */ com.ss.android.downloadlib.addownload.wg.vw t;
        final /* synthetic */ com.ss.android.downloadlib.addownload.vw.vw.InterfaceC0470vw v;
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg vw;
        final /* synthetic */ android.content.Context wg;

        public AnonymousClass1(com.ss.android.downloadad.api.vw.wg wgVar, android.content.Context context, com.ss.android.downloadlib.addownload.wg.vw vwVar, com.ss.android.downloadlib.addownload.vw.vw.InterfaceC0470vw interfaceC0470vw) {
            this.vw = wgVar;
            this.wg = context;
            this.t = vwVar;
            this.v = interfaceC0470vw;
        }

        @Override // com.ss.android.download.api.model.wg.InterfaceC0468wg
        public void t(android.content.DialogInterface dialogInterface) {
            com.ss.android.downloadlib.addownload.vw.vw.this.wg("");
        }

        @Override // com.ss.android.download.api.model.wg.InterfaceC0468wg
        public void vw(android.content.DialogInterface dialogInterface) {
            com.ss.android.downloadlib.v.vw.vw().wg("backdialog_install", this.vw);
            com.ss.android.socialbase.appdownloader.v.vw(this.wg, (int) this.t.vw);
            dialogInterface.dismiss();
        }

        @Override // com.ss.android.download.api.model.wg.InterfaceC0468wg
        public void wg(android.content.DialogInterface dialogInterface) {
            com.ss.android.downloadlib.v.vw.vw().wg("backdialog_exit", this.vw);
            com.ss.android.downloadlib.addownload.vw.vw.InterfaceC0470vw interfaceC0470vw = this.v;
            if (interfaceC0470vw != null) {
                interfaceC0470vw.vw();
            }
            com.ss.android.downloadlib.addownload.vw.vw.this.wg("");
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.vw.vw$vw, reason: collision with other inner class name */
    public interface InterfaceC0470vw {
        void vw();
    }

    private vw() {
        com.ss.android.downloadlib.addownload.vw.wg wgVar = new com.ss.android.downloadlib.addownload.vw.wg();
        this.kz = wgVar;
        this.t = wgVar.vw("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static com.ss.android.downloadlib.addownload.vw.vw vw() {
        if (wg == null) {
            wg = new com.ss.android.downloadlib.addownload.vw.vw();
        }
        return wg;
    }

    private void vw(android.content.Context context, com.ss.android.downloadlib.addownload.wg.vw vwVar, com.ss.android.downloadlib.addownload.vw.vw.InterfaceC0470vw interfaceC0470vw, boolean z) {
        com.ss.android.downloadad.api.vw.wg v = com.ss.android.downloadlib.addownload.wg.kz.vw().v(vwVar.wg);
        if (v == null) {
            com.ss.android.downloadlib.yl.t.vw().vw("showBackInstallDialog nativeModel null");
            return;
        }
        com.ss.android.download.api.config.vl t = com.ss.android.downloadlib.addownload.z.t();
        com.ss.android.download.api.model.wg.vw vw2 = new com.ss.android.download.api.model.wg.vw(context).vw(z ? "应用安装确认" : "退出确认");
        java.lang.Object[] objArr = new java.lang.Object[1];
        objArr[0] = android.text.TextUtils.isEmpty(vwVar.yl) ? "刚刚下载的应用" : vwVar.yl;
        t.wg(vw2.wg(java.lang.String.format("%1$s下载完成，是否立即安装？", objArr)).t("立即安装").v(z ? "暂不安装" : java.lang.String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).vw(false).vw(com.ss.android.downloadlib.bt.vl.vw(context, vwVar.bt)).vw(new com.ss.android.downloadlib.addownload.vw.vw.AnonymousClass1(v, context, vwVar, interfaceC0470vw)).vw(1).vw());
        com.ss.android.downloadlib.v.vw.vw().wg("backdialog_show", v);
        this.yl = vwVar.v;
    }

    private boolean vw(android.app.Activity activity, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, boolean z, com.ss.android.downloadlib.addownload.vw.vw.InterfaceC0470vw interfaceC0470vw) {
        if (downloadInfo == null) {
            try {
                if (this.t.isEmpty()) {
                    return false;
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        if (activity != null && !activity.isFinishing()) {
            boolean z2 = true;
            if (downloadInfo != null && this.t.isEmpty()) {
                vw(activity, new com.ss.android.downloadlib.addownload.wg.vw(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0470vw);
                return true;
            }
            long lastModified = downloadInfo != null ? new java.io.File(downloadInfo.getTargetFilePath()).lastModified() : 0L;
            java.util.concurrent.CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.wg.vw> copyOnWriteArrayList = this.t;
            java.util.ListIterator<com.ss.android.downloadlib.addownload.wg.vw> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    z2 = false;
                    break;
                }
                com.ss.android.downloadlib.addownload.wg.vw previous = listIterator.previous();
                if (previous != null && !com.ss.android.downloadlib.bt.vl.yl(com.ss.android.downloadlib.addownload.z.getContext(), previous.v) && com.ss.android.downloadlib.bt.vl.vw(previous.bt)) {
                    if (new java.io.File(previous.bt).lastModified() >= lastModified) {
                        vw(activity, previous, z, interfaceC0470vw);
                    } else {
                        vw(activity, new com.ss.android.downloadlib.addownload.wg.vw(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0470vw);
                    }
                }
            }
            com.ss.android.downloadlib.bt.z.vw(vw, "tryShowInstallDialog isShow:".concat(java.lang.String.valueOf(z2)), null);
            return z2;
        }
        return false;
    }

    public com.ss.android.socialbase.downloader.model.DownloadInfo vw(android.content.Context context) {
        long wg2;
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> successedDownloadInfosWithMimeType;
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = null;
        try {
            wg2 = com.ss.android.downloadlib.o.vw(context).wg();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        if (com.ss.android.downloadlib.addownload.z.x().optInt("enable_miniapp_dialog", 0) != 0 && (successedDownloadInfosWithMimeType = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive")) != null && !successedDownloadInfosWithMimeType.isEmpty()) {
            long j = 0;
            for (com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                if (downloadInfo2 != null && !com.ss.android.downloadlib.bt.vl.yl(context, downloadInfo2.getPackageName()) && com.ss.android.downloadlib.bt.vl.vw(downloadInfo2.getTargetFilePath())) {
                    long lastModified = new java.io.File(downloadInfo2.getTargetFilePath()).lastModified();
                    if (lastModified >= wg2 && downloadInfo2.getExtra() != null) {
                        try {
                            if (new org.json.JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j == 0 || lastModified > j)) {
                                downloadInfo = downloadInfo2;
                                j = lastModified;
                            }
                        } catch (java.lang.Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return downloadInfo;
        }
        return null;
    }

    public void vw(long j, long j2, long j3, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        for (int i = 0; i < this.t.size(); i++) {
            com.ss.android.downloadlib.addownload.wg.vw vwVar = this.t.get(i);
            if (vwVar != null && vwVar.wg == j2) {
                this.t.set(i, new com.ss.android.downloadlib.addownload.wg.vw(j, j2, j3, str, str2, str3, str4));
                this.kz.vw("sp_ad_install_back_dialog", "key_uninstalled_list", this.t);
                return;
            }
        }
        this.t.add(new com.ss.android.downloadlib.addownload.wg.vw(j, j2, j3, str, str2, str3, str4));
        this.kz.vw("sp_ad_install_back_dialog", "key_uninstalled_list", this.t);
    }

    public void vw(android.content.Context context, com.ss.android.downloadlib.addownload.wg.vw vwVar, boolean z, com.ss.android.downloadlib.addownload.vw.vw.InterfaceC0470vw interfaceC0470vw) {
        this.t.clear();
        vw(context, vwVar, interfaceC0470vw, z);
        this.v = true;
        com.ss.android.downloadlib.o.vw(context).t();
        this.kz.wg("sp_ad_install_back_dialog", "key_uninstalled_list");
        com.ss.android.downloadlib.bt.z.vw(vw, "tryShowInstallDialog isShow:true", null);
    }

    public void vw(com.ss.android.downloadad.api.vw.wg wgVar) {
        if (com.ss.android.downloadlib.addownload.z.x().optInt("enable_open_app_dialog", 0) == 1 && !wgVar.ym() && wgVar.k() && android.os.Build.VERSION.SDK_INT < 34) {
            wgVar.z(true);
            com.ss.android.downloadlib.activity.TTDelegateActivity.vw(wgVar);
        }
    }

    @androidx.annotation.MainThread
    public boolean vw(android.app.Activity activity, boolean z, com.ss.android.downloadlib.addownload.vw.vw.InterfaceC0470vw interfaceC0470vw) {
        if (com.ss.android.downloadlib.addownload.z.x().optInt("disable_install_app_dialog") == 1 || this.v) {
            return false;
        }
        return vw(activity, vw(activity), z, interfaceC0470vw);
    }

    public boolean vw(java.lang.String str) {
        return android.text.TextUtils.equals(this.yl, str);
    }

    public void wg(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            this.yl = "";
        } else if (android.text.TextUtils.equals(this.yl, str)) {
            this.yl = "";
        }
    }
}
