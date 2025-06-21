package com.ss.android.downloadlib.addownload;

/* loaded from: classes19.dex */
public class yl implements com.ss.android.downloadlib.addownload.bt, com.ss.android.downloadlib.bt.u.vw {
    private static final java.lang.String vw = "yl";
    private com.ss.android.download.api.model.DownloadShortInfo bt;
    private long cp;
    private com.ss.android.download.api.download.DownloadModel d;
    private final com.ss.android.socialbase.downloader.depend.IDownloadListener es;
    private com.ss.android.download.api.download.DownloadEventConfig j;
    private com.ss.android.download.api.download.DownloadController k;
    private final java.util.Map<java.lang.Integer, java.lang.Object> kz;
    private com.ss.android.socialbase.downloader.model.DownloadInfo o;
    private final boolean q;
    private java.lang.ref.SoftReference<com.ss.android.download.api.config.IDownloadButtonClickListener> qm;
    private com.ss.android.downloadlib.addownload.o t;
    private java.lang.ref.SoftReference<com.ss.android.download.api.config.OnItemClickListener> te;
    private boolean tq;
    private java.lang.String u;
    private com.ss.android.downloadlib.addownload.v v;
    private long vl;
    private final com.ss.android.downloadlib.bt.u wg;
    private com.ss.android.downloadlib.addownload.yl.t x;
    private java.lang.ref.WeakReference<android.content.Context> yl;
    private boolean z;

    /* renamed from: com.ss.android.downloadlib.addownload.yl$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.downloadlib.addownload.compliance.o {
        final /* synthetic */ int vw;

        public AnonymousClass1(int i) {
            this.vw = i;
        }

        @Override // com.ss.android.downloadlib.addownload.compliance.o
        public void vw() {
            int i = this.vw;
            if (i == 1) {
                com.ss.android.socialbase.downloader.logger.Logger.d(com.ss.android.downloadlib.addownload.yl.vw, "miui new get miui deeplink fail: handleDownload id:" + com.ss.android.downloadlib.addownload.yl.this.cp + ",tryPerformButtonClick:", null);
                com.ss.android.downloadlib.addownload.yl.this.t(true);
                return;
            }
            if (i != 2) {
                return;
            }
            com.ss.android.socialbase.downloader.logger.Logger.d(com.ss.android.downloadlib.addownload.yl.vw, "miui new get miui deeplink fail: handleDownload id:" + com.ss.android.downloadlib.addownload.yl.this.cp + ",tryPerformButtonClick:", null);
            com.ss.android.downloadlib.addownload.yl.this.wg(true);
        }

        @Override // com.ss.android.downloadlib.addownload.compliance.o
        public void vw(java.lang.String str) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.putOpt("download_miui_new_market", 1);
                jSONObject.putOpt("download_miui_market_deeplink", str);
                if (com.ss.android.downloadlib.bt.o.vw(com.ss.android.downloadlib.addownload.yl.this.getContext(), com.ss.android.downloadlib.addownload.yl.this.t.vw, str, jSONObject, true, this.vw)) {
                    jSONObject.putOpt("download_miui_jump_market_success", 1);
                    com.ss.android.downloadlib.addownload.compliance.kz.vw().vw(0, com.ss.android.downloadlib.addownload.yl.this.t.vw, jSONObject);
                    return;
                }
                jSONObject.putOpt("download_miui_jump_market_success", 0);
                com.ss.android.downloadlib.addownload.compliance.kz.vw().vw(1, com.ss.android.downloadlib.addownload.yl.this.t.vw, jSONObject);
                int i = this.vw;
                if (i == 1) {
                    com.ss.android.socialbase.downloader.logger.Logger.d(com.ss.android.downloadlib.addownload.yl.vw, "miui new rollback fail: handleDownload id:" + com.ss.android.downloadlib.addownload.yl.this.cp + ",tryPerformButtonClick:", null);
                    com.ss.android.downloadlib.addownload.yl.this.t(true);
                    return;
                }
                if (i != 2) {
                    return;
                }
                com.ss.android.socialbase.downloader.logger.Logger.d(com.ss.android.downloadlib.addownload.yl.vw, "miui new rollback fail: handleDownload id:" + com.ss.android.downloadlib.addownload.yl.this.cp + ",tryPerformButtonClick:", null);
                com.ss.android.downloadlib.addownload.yl.this.wg(true);
            } catch (java.lang.Exception e) {
                com.ss.android.downloadlib.yl.t.vw().vw(e, "generate miui new market param error");
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.yl$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.Iterator<com.ss.android.download.api.download.DownloadStatusChangeListener> it = com.ss.android.downloadlib.addownload.o.vw((java.util.Map<java.lang.Integer, java.lang.Object>) com.ss.android.downloadlib.addownload.yl.this.kz).iterator();
            while (it.hasNext()) {
                it.next().onInstalled(com.ss.android.downloadlib.addownload.yl.this.k());
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.yl$3, reason: invalid class name */
    public class AnonymousClass3 implements com.ss.android.downloadlib.addownload.yl.vw {
        final /* synthetic */ int vw;
        final /* synthetic */ int wg;

        public AnonymousClass3(int i, int i2) {
            this.vw = i;
            this.wg = i2;
        }

        @Override // com.ss.android.downloadlib.addownload.yl.vw
        public void vw() {
            if (com.ss.android.downloadlib.addownload.yl.this.v.vw()) {
                return;
            }
            com.ss.android.downloadlib.addownload.yl ylVar = com.ss.android.downloadlib.addownload.yl.this;
            ylVar.vw(this.vw, this.wg, ylVar.o);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.yl$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.addownload.z.t().vw(13, com.ss.android.downloadlib.addownload.z.getContext(), com.ss.android.downloadlib.addownload.yl.this.d, "已恢复下载", null, 0);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.yl$5, reason: invalid class name */
    public class AnonymousClass5 implements com.ss.android.downloadlib.addownload.vw.t {
        public AnonymousClass5() {
        }

        @Override // com.ss.android.downloadlib.addownload.vw.t
        public void delete() {
            com.ss.android.downloadlib.addownload.yl.this.vw(true);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.yl$6, reason: invalid class name */
    public class AnonymousClass6 implements com.ss.android.downloadlib.addownload.v.o {
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg t;
        final /* synthetic */ int v;
        final /* synthetic */ int vw;
        final /* synthetic */ boolean wg;

        public AnonymousClass6(int i, boolean z, com.ss.android.downloadad.api.vw.wg wgVar, int i2) {
            this.vw = i;
            this.wg = z;
            this.t = wgVar;
            this.v = i2;
        }

        @Override // com.ss.android.downloadlib.addownload.v.o
        public void vw(com.ss.android.downloadad.api.vw.wg wgVar) {
            if (com.ss.android.downloadlib.addownload.yl.this.o == null && com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix("fix_handle_pause")) {
                com.ss.android.downloadlib.addownload.yl.this.o = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(this.vw);
            }
            com.ss.android.downloadlib.addownload.yl.this.t.vw(com.ss.android.downloadlib.addownload.yl.this.o, this.wg);
            if (com.ss.android.downloadlib.addownload.yl.this.o != null && com.ss.android.socialbase.downloader.utils.DownloadUtils.isWifi(com.ss.android.downloadlib.addownload.z.getContext()) && com.ss.android.downloadlib.addownload.yl.this.o.isPauseReserveOnWifi()) {
                com.ss.android.downloadlib.addownload.yl.this.o.stopPauseReserveOnWifi();
                com.ss.android.downloadlib.v.vw.vw().vw("cancel_pause_reserve_wifi_cancel_on_wifi", this.t);
            } else {
                com.ss.android.downloadlib.addownload.yl ylVar = com.ss.android.downloadlib.addownload.yl.this;
                ylVar.vw(this.vw, this.v, ylVar.o);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.yl$7, reason: invalid class name */
    public class AnonymousClass7 implements com.ss.android.downloadlib.addownload.v.o {
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg t;
        final /* synthetic */ int v;
        final /* synthetic */ int vw;
        final /* synthetic */ boolean wg;

        public AnonymousClass7(int i, boolean z, com.ss.android.downloadad.api.vw.wg wgVar, int i2) {
            this.vw = i;
            this.wg = z;
            this.t = wgVar;
            this.v = i2;
        }

        @Override // com.ss.android.downloadlib.addownload.v.o
        public void vw(com.ss.android.downloadad.api.vw.wg wgVar) {
            if (com.ss.android.downloadlib.addownload.yl.this.o == null && com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix("fix_handle_pause")) {
                com.ss.android.downloadlib.addownload.yl.this.o = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(this.vw);
            }
            com.ss.android.downloadlib.addownload.yl.this.t.vw(com.ss.android.downloadlib.addownload.yl.this.o, this.wg);
            if (com.ss.android.downloadlib.addownload.yl.this.o != null && com.ss.android.socialbase.downloader.utils.DownloadUtils.isWifi(com.ss.android.downloadlib.addownload.z.getContext()) && com.ss.android.downloadlib.addownload.yl.this.o.isPauseReserveOnWifi()) {
                com.ss.android.downloadlib.addownload.yl.this.o.stopPauseReserveOnWifi();
                com.ss.android.downloadlib.v.vw.vw().wg("pause_reserve_wifi_cancel_on_wifi", this.t);
            } else {
                com.ss.android.downloadlib.addownload.yl ylVar = com.ss.android.downloadlib.addownload.yl.this;
                ylVar.vw(this.vw, this.v, ylVar.o);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.yl$8, reason: invalid class name */
    public class AnonymousClass8 implements com.ss.android.download.api.config.q {
        final /* synthetic */ boolean vw;

        public AnonymousClass8(boolean z) {
            this.vw = z;
        }

        @Override // com.ss.android.download.api.config.q
        public void vw() {
            com.ss.android.downloadlib.bt.z.vw(com.ss.android.downloadlib.addownload.yl.vw, "pBCD start download", null);
            com.ss.android.downloadlib.addownload.yl.this.bt(this.vw);
        }

        @Override // com.ss.android.download.api.config.q
        public void vw(java.lang.String str) {
            com.ss.android.downloadlib.bt.z.vw(com.ss.android.downloadlib.addownload.yl.vw, "pBCD onDenied", null);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.yl$9, reason: invalid class name */
    public class AnonymousClass9 implements com.ss.android.downloadlib.addownload.yl.vw {
        final /* synthetic */ boolean vw;

        public AnonymousClass9(boolean z) {
            this.vw = z;
        }

        @Override // com.ss.android.downloadlib.addownload.yl.vw
        public void vw() {
            if (com.ss.android.downloadlib.addownload.yl.this.v.vw()) {
                return;
            }
            com.ss.android.downloadlib.addownload.yl.this.o(this.vw);
        }
    }

    public class t extends android.os.AsyncTask<java.lang.String, java.lang.Void, com.ss.android.socialbase.downloader.model.DownloadInfo> {
        private t() {
        }

        public /* synthetic */ t(com.ss.android.downloadlib.addownload.yl ylVar, com.ss.android.downloadlib.addownload.yl.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.os.AsyncTask
        /* renamed from: vw, reason: merged with bridge method [inline-methods] */
        public com.ss.android.socialbase.downloader.model.DownloadInfo doInBackground(java.lang.String... strArr) {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = null;
            if (strArr == null) {
                return null;
            }
            if (strArr.length > 0 && android.text.TextUtils.isEmpty(strArr[0])) {
                return null;
            }
            java.lang.String str = (strArr.length < 3 || android.text.TextUtils.isEmpty(strArr[2])) ? "" : strArr[2];
            java.lang.String str2 = strArr[0];
            if (com.ss.android.downloadlib.addownload.yl.this.d != null && !android.text.TextUtils.isEmpty(com.ss.android.downloadlib.addownload.yl.this.d.getFilePath())) {
                downloadInfo = !android.text.TextUtils.isEmpty(str) ? com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadId(str, com.ss.android.downloadlib.addownload.yl.this.d.getFilePath())) : com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(str2, com.ss.android.downloadlib.addownload.yl.this.d.getFilePath());
            }
            return downloadInfo == null ? !android.text.TextUtils.isEmpty(str) ? com.ss.android.socialbase.appdownloader.v.es().vw(com.ss.android.downloadlib.addownload.z.getContext(), str) : com.ss.android.socialbase.appdownloader.v.es().vw(com.ss.android.downloadlib.addownload.z.getContext(), str2) : downloadInfo;
        }

        @Override // android.os.AsyncTask
        /* renamed from: vw, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (isCancelled() || com.ss.android.downloadlib.addownload.yl.this.d == null) {
                return;
            }
            try {
                com.ss.android.downloadlib.addownload.wg.t vw = com.ss.android.downloadlib.bt.vl.vw(com.ss.android.downloadlib.addownload.yl.this.d.getPackageName(), com.ss.android.downloadlib.addownload.yl.this.d.getVersionCode(), com.ss.android.downloadlib.addownload.yl.this.d.getVersionName());
                com.ss.android.downloadlib.addownload.wg.o.vw().vw(com.ss.android.downloadlib.addownload.yl.this.d.getVersionCode(), vw.wg(), com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadInfo));
                boolean vw2 = vw.vw();
                if (downloadInfo == null || downloadInfo.getId() == 0 || (!vw2 && com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                    if (downloadInfo != null && com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                        com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().cancelNotification(downloadInfo.getId());
                        com.ss.android.downloadlib.addownload.yl.this.o = null;
                    }
                    if (com.ss.android.downloadlib.addownload.yl.this.o != null) {
                        com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).removeTaskMainListener(com.ss.android.downloadlib.addownload.yl.this.o.getId());
                        if (com.ss.android.downloadlib.addownload.yl.this.q) {
                            com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.yl.this.getContext()).setMainThreadListener(com.ss.android.downloadlib.addownload.yl.this.o.getId(), com.ss.android.downloadlib.addownload.yl.this.es, false);
                        } else {
                            com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.yl.this.getContext()).setMainThreadListener(com.ss.android.downloadlib.addownload.yl.this.o.getId(), com.ss.android.downloadlib.addownload.yl.this.es);
                        }
                    }
                    if (vw2) {
                        com.ss.android.downloadlib.addownload.yl ylVar = com.ss.android.downloadlib.addownload.yl.this;
                        ylVar.o = new com.ss.android.socialbase.downloader.model.DownloadInfo.Builder(ylVar.d.getDownloadUrl()).build();
                        com.ss.android.downloadlib.addownload.yl.this.o.setStatus(-3);
                        com.ss.android.downloadlib.addownload.yl.this.t.vw(com.ss.android.downloadlib.addownload.yl.this.o, com.ss.android.downloadlib.addownload.yl.this.k(), com.ss.android.downloadlib.addownload.o.vw((java.util.Map<java.lang.Integer, java.lang.Object>) com.ss.android.downloadlib.addownload.yl.this.kz));
                    } else {
                        java.util.Iterator<com.ss.android.download.api.download.DownloadStatusChangeListener> it = com.ss.android.downloadlib.addownload.o.vw((java.util.Map<java.lang.Integer, java.lang.Object>) com.ss.android.downloadlib.addownload.yl.this.kz).iterator();
                        while (it.hasNext()) {
                            it.next().onIdle();
                        }
                        com.ss.android.downloadlib.addownload.yl.this.o = null;
                    }
                } else {
                    com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).removeTaskMainListener(downloadInfo.getId());
                    if (com.ss.android.downloadlib.addownload.yl.this.o == null || com.ss.android.downloadlib.addownload.yl.this.o.getStatus() != -4) {
                        com.ss.android.downloadlib.addownload.yl.this.o = downloadInfo;
                        if (com.ss.android.downloadlib.addownload.yl.this.q) {
                            com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).setMainThreadListener(com.ss.android.downloadlib.addownload.yl.this.o.getId(), com.ss.android.downloadlib.addownload.yl.this.es, false);
                        } else {
                            com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).setMainThreadListener(com.ss.android.downloadlib.addownload.yl.this.o.getId(), com.ss.android.downloadlib.addownload.yl.this.es);
                        }
                    } else {
                        com.ss.android.downloadlib.addownload.yl.this.o = null;
                    }
                    com.ss.android.downloadlib.addownload.yl.this.t.vw(com.ss.android.downloadlib.addownload.yl.this.o, com.ss.android.downloadlib.addownload.yl.this.k(), com.ss.android.downloadlib.addownload.o.vw((java.util.Map<java.lang.Integer, java.lang.Object>) com.ss.android.downloadlib.addownload.yl.this.kz));
                }
                com.ss.android.downloadlib.addownload.yl.this.t.t(com.ss.android.downloadlib.addownload.yl.this.o);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public interface vw {
        void vw();
    }

    public interface wg {
        void vw(long j);
    }

    public yl() {
        com.ss.android.downloadlib.bt.u uVar = new com.ss.android.downloadlib.bt.u(android.os.Looper.getMainLooper(), this);
        this.wg = uVar;
        this.kz = new java.util.concurrent.ConcurrentHashMap();
        this.es = new com.ss.android.downloadlib.addownload.o.vw(uVar);
        this.cp = -1L;
        this.d = null;
        this.j = null;
        this.k = null;
        this.t = new com.ss.android.downloadlib.addownload.o(this);
        this.v = new com.ss.android.downloadlib.addownload.v(uVar);
        this.q = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix("ttdownloader_callback_twice");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(boolean z) {
        this.v.vw(new com.ss.android.downloadlib.addownload.wg.yl(this.cp, this.d, vl(), u()));
        this.v.vw(0, 0L, 0L, new com.ss.android.downloadlib.addownload.yl.AnonymousClass9(z));
    }

    private void cp() {
        java.lang.String str = vw;
        com.ss.android.downloadlib.bt.z.vw(str, "pICD", null);
        if (this.t.v(this.o)) {
            com.ss.android.downloadlib.bt.z.vw(str, "pICD BC", null);
            kz(false);
        } else {
            com.ss.android.downloadlib.bt.z.vw(str, "pICD IC", null);
            z();
        }
    }

    private boolean d() {
        if (!com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.o;
            if (downloadInfo == null) {
                return true;
            }
            return !(downloadInfo.getStatus() == -3 || com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).canResume(this.o.getId())) || this.o.getStatus() == 0;
        }
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo2 = this.o;
        if (downloadInfo2 == null) {
            return true;
        }
        if ((downloadInfo2.getStatus() == -3 && this.o.getCurBytes() <= 0) || this.o.getStatus() == 0 || this.o.getStatus() == -4) {
            return true;
        }
        return com.ss.android.socialbase.downloader.utils.DownloadUtils.isDownloadSuccessAndFileNotExist(this.o.getStatus(), this.o.getSavePath(), this.o.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.content.Context getContext() {
        java.lang.ref.WeakReference<android.content.Context> weakReference = this.yl;
        return (weakReference == null || weakReference.get() == null) ? com.ss.android.downloadlib.addownload.z.getContext() : this.yl.get();
    }

    private void j() {
        com.ss.android.downloadlib.addownload.yl.t tVar = this.x;
        if (tVar != null && tVar.getStatus() != android.os.AsyncTask.Status.FINISHED) {
            this.x.cancel(true);
        }
        this.x = new com.ss.android.downloadlib.addownload.yl.t(this, null);
        if (android.text.TextUtils.isEmpty(this.u)) {
            com.ss.android.downloadlib.bt.wg.vw(this.x, this.d.getDownloadUrl(), this.d.getPackageName());
        } else {
            com.ss.android.downloadlib.bt.wg.vw(this.x, this.d.getDownloadUrl(), this.d.getPackageName(), this.u);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.download.api.model.DownloadShortInfo k() {
        if (this.bt == null) {
            this.bt = new com.ss.android.download.api.model.DownloadShortInfo();
        }
        return this.bt;
    }

    private void kz(boolean z) {
        com.ss.android.download.api.download.DownloadModel downloadModel;
        com.ss.android.download.api.download.DownloadController downloadController;
        com.ss.android.download.api.download.DownloadController downloadController2;
        java.lang.String str = vw;
        com.ss.android.downloadlib.bt.z.vw(str, "pBCD", null);
        if (d()) {
            com.ss.android.downloadlib.addownload.wg.yl yl = com.ss.android.downloadlib.addownload.wg.kz.vw().yl(this.cp);
            if (this.tq) {
                if (!x()) {
                    vw(z, true);
                    return;
                } else {
                    if (v(false) && (downloadController2 = yl.v) != null && downloadController2.isAutoDownloadOnCardShow()) {
                        vw(z, true);
                        return;
                    }
                    return;
                }
            }
            if (this.d.isAd() && (downloadController = yl.v) != null && downloadController.enableShowComplianceDialog() && yl.wg != null && com.ss.android.downloadlib.addownload.compliance.wg.vw().vw(yl.wg) && com.ss.android.downloadlib.addownload.compliance.wg.vw().vw(yl)) {
                return;
            }
            vw(z, true);
            return;
        }
        com.ss.android.downloadlib.bt.z.vw(str, "pBCD continue download, status:" + this.o.getStatus(), null);
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.o;
        if (downloadInfo != null && (downloadModel = this.d) != null) {
            downloadInfo.setOnlyWifi(downloadModel.isNeedWifi());
        }
        int status = this.o.getStatus();
        int id = this.o.getId();
        com.ss.android.downloadad.api.vw.wg vw2 = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(this.o);
        if (status == -2 || status == -1) {
            this.t.vw(this.o, z);
            if (vw2 != null) {
                vw2.o(java.lang.System.currentTimeMillis());
                vw2.x(this.o.getCurBytes());
            }
            this.o.setDownloadFromReserveWifi(false);
            this.v.vw(new com.ss.android.downloadlib.addownload.wg.yl(this.cp, this.d, vl(), u()));
            this.v.vw(id, this.o.getCurBytes(), this.o.getTotalBytes(), new com.ss.android.downloadlib.addownload.yl.AnonymousClass3(id, status));
            if (status == -2 && com.ss.android.downloadlib.bt.yl.vw(vw2).optInt("show_pause_continue_toast", 0) == 1) {
                com.ss.android.downloadlib.bt.vw().wg().postDelayed(new com.ss.android.downloadlib.addownload.yl.AnonymousClass4(), 500L);
                return;
            }
            return;
        }
        if (!com.ss.android.downloadlib.addownload.u.vw(status)) {
            this.t.vw(this.o, z);
            vw(id, status, this.o);
        } else if (this.d.enablePause()) {
            this.v.vw(true);
            com.ss.android.downloadlib.t.o.vw().wg(com.ss.android.downloadlib.addownload.wg.kz.vw().v(this.cp));
            if (com.ss.android.downloadlib.bt.yl.vw(vw2).optInt("cancel_pause_optimise_switch", 0) == 1) {
                com.ss.android.downloadlib.addownload.v.v.vw().vw(vw2, status, new com.ss.android.downloadlib.addownload.yl.AnonymousClass6(id, z, vw2, status), new com.ss.android.downloadlib.addownload.yl.AnonymousClass5());
            } else {
                com.ss.android.downloadlib.addownload.v.z.vw().vw(vw2, status, new com.ss.android.downloadlib.addownload.yl.AnonymousClass7(id, z, vw2, status));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z) {
        java.util.Iterator<com.ss.android.download.api.download.DownloadStatusChangeListener> it = com.ss.android.downloadlib.addownload.o.vw(this.kz).iterator();
        while (it.hasNext()) {
            it.next().onDownloadStart(this.d, u());
        }
        int vw2 = this.t.vw(com.ss.android.downloadlib.addownload.z.getContext(), this.es);
        java.lang.String str = vw;
        com.ss.android.downloadlib.bt.z.vw(str, "beginDown id:".concat(java.lang.String.valueOf(vw2)), null);
        if (vw2 == 0) {
            com.ss.android.socialbase.downloader.model.DownloadInfo build = new com.ss.android.socialbase.downloader.model.DownloadInfo.Builder(this.d.getDownloadUrl()).build();
            build.setStatus(-1);
            vw(build);
            com.ss.android.downloadlib.v.vw.vw().vw(this.cp, new com.ss.android.socialbase.downloader.exception.BaseException(2, "start download failed, id=0"));
            com.ss.android.downloadlib.yl.t.vw().wg("beginDown");
        } else if (this.o != null && !com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) {
            this.t.vw(this.o, false);
        } else if (z) {
            this.t.vw();
        }
        if (this.t.vw(t())) {
            com.ss.android.downloadlib.bt.z.vw(str, "beginDown IC id:".concat(java.lang.String.valueOf(vw2)), null);
            z();
        }
    }

    private boolean t(int i) {
        if (!yl()) {
            return false;
        }
        java.lang.String vw2 = this.d.getQuickAppModel().vw();
        int i2 = i != 1 ? i != 2 ? -1 : 4 : 5;
        com.ss.android.download.api.download.DownloadModel downloadModel = this.d;
        if (downloadModel instanceof com.ss.android.downloadad.api.download.AdDownloadModel) {
            ((com.ss.android.downloadad.api.download.AdDownloadModel) downloadModel).setFunnelType(3);
        }
        boolean t2 = com.ss.android.downloadlib.bt.x.t(com.ss.android.downloadlib.addownload.z.getContext(), vw2);
        if (t2) {
            com.ss.android.downloadlib.v.vw.vw().vw(this.cp, i);
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = i2;
            obtain.obj = java.lang.Long.valueOf(this.d.getId());
            com.ss.android.downloadlib.addownload.t.vw().vw(this, i2, this.d);
        } else {
            com.ss.android.downloadlib.v.vw.vw().vw(this.cp, false, 0);
        }
        return t2;
    }

    @androidx.annotation.NonNull
    private com.ss.android.download.api.download.DownloadController u() {
        if (this.k == null) {
            this.k = new com.ss.android.download.api.download.wg();
        }
        return this.k;
    }

    @androidx.annotation.NonNull
    private com.ss.android.download.api.download.DownloadEventConfig vl() {
        com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig = this.j;
        return downloadEventConfig == null ? new com.ss.android.download.api.download.t.vw().vw() : downloadEventConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vw(int i, int i2, @androidx.annotation.NonNull com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) {
            com.ss.android.socialbase.appdownloader.v.es().vw(com.ss.android.downloadlib.addownload.z.getContext(), i, i2);
        } else if (i2 == -3 || com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().canResume(i)) {
            com.ss.android.socialbase.appdownloader.v.es().vw(com.ss.android.downloadlib.addownload.z.getContext(), i, i2);
        } else {
            vw(false, false);
        }
    }

    private void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = 3;
        obtain.obj = downloadInfo;
        this.wg.sendMessage(obtain);
    }

    private void yl(boolean z) {
        if (com.ss.android.downloadlib.bt.yl.wg(this.d).optInt("notification_opt_2") == 1 && this.o != null) {
            com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().cancelNotification(this.o.getId());
        }
        kz(z);
    }

    private void z() {
        java.lang.ref.SoftReference<com.ss.android.download.api.config.OnItemClickListener> softReference = this.te;
        if (softReference != null && softReference.get() != null) {
            this.te.get().onItemClick(this.d, vl(), u());
            this.te = null;
        } else {
            com.ss.android.downloadlib.addownload.z.wg();
            getContext();
            u();
            vl();
        }
    }

    public void bt() {
        if (this.kz.size() == 0) {
            return;
        }
        java.util.Iterator<com.ss.android.download.api.download.DownloadStatusChangeListener> it = com.ss.android.downloadlib.addownload.o.vw(this.kz).iterator();
        while (it.hasNext()) {
            it.next().onIdle();
        }
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.o;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    public void kz() {
        this.wg.post(new com.ss.android.downloadlib.addownload.yl.AnonymousClass2());
    }

    @Override // com.ss.android.downloadlib.addownload.bt
    public void o() {
        com.ss.android.downloadlib.addownload.wg.kz.vw().kz(this.cp);
    }

    public void t(boolean z) {
        if (z) {
            com.ss.android.downloadlib.v.vw.vw().vw(this.cp, 1);
        }
        cp();
    }

    public boolean t() {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.o;
        return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
    }

    @Override // com.ss.android.downloadlib.addownload.bt
    public long v() {
        return this.vl;
    }

    public boolean v(boolean z) {
        java.lang.ref.SoftReference<com.ss.android.download.api.config.IDownloadButtonClickListener> softReference = this.qm;
        if (softReference == null || softReference.get() == null) {
            com.ss.android.downloadlib.yl.t.vw().wg("mDownloadButtonClickListener has recycled");
            return false;
        }
        try {
            if (z) {
                this.qm.get().handleMarketFailedComplianceDialog();
            } else {
                this.qm.get().handleComplianceDialog(true);
            }
            this.qm = null;
            return true;
        } catch (java.lang.Exception unused) {
            com.ss.android.downloadlib.yl.t.vw().wg("mDownloadButtonClickListener has recycled");
            return false;
        }
    }

    @Override // com.ss.android.downloadlib.addownload.bt
    public com.ss.android.downloadlib.addownload.bt vw(long j) {
        if (j != 0) {
            com.ss.android.download.api.download.DownloadModel vw2 = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(j);
            if (vw2 != null) {
                this.d = vw2;
                this.cp = j;
                this.t.vw(j);
            }
        } else {
            com.ss.android.downloadlib.yl.t.vw().vw(false, "setModelId");
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.bt
    public com.ss.android.downloadlib.addownload.bt vw(com.ss.android.download.api.config.IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            this.qm = null;
        } else {
            this.qm = new java.lang.ref.SoftReference<>(iDownloadButtonClickListener);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.bt
    public com.ss.android.downloadlib.addownload.bt vw(com.ss.android.download.api.config.OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            this.te = null;
        } else {
            this.te = new java.lang.ref.SoftReference<>(onItemClickListener);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.bt
    public com.ss.android.downloadlib.addownload.bt vw(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            this.u = str;
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.bt
    /* renamed from: vw, reason: merged with bridge method [inline-methods] */
    public com.ss.android.downloadlib.addownload.yl wg(int i, com.ss.android.download.api.download.DownloadStatusChangeListener downloadStatusChangeListener) {
        if (downloadStatusChangeListener != null) {
            if (com.ss.android.downloadlib.addownload.z.x().optInt("back_use_softref_listener") == 1) {
                this.kz.put(java.lang.Integer.valueOf(i), downloadStatusChangeListener);
            } else if (com.ss.android.downloadlib.addownload.z.x().optInt("use_weakref_listener") == 1) {
                this.kz.put(java.lang.Integer.valueOf(i), new java.lang.ref.WeakReference(downloadStatusChangeListener));
            } else {
                this.kz.put(java.lang.Integer.valueOf(i), new java.lang.ref.SoftReference(downloadStatusChangeListener));
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.bt
    /* renamed from: vw, reason: merged with bridge method [inline-methods] */
    public com.ss.android.downloadlib.addownload.yl wg(android.content.Context context) {
        if (context != null) {
            this.yl = new java.lang.ref.WeakReference<>(context);
        }
        com.ss.android.downloadlib.addownload.z.wg(context);
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.bt
    /* renamed from: vw, reason: merged with bridge method [inline-methods] */
    public com.ss.android.downloadlib.addownload.yl wg(com.ss.android.download.api.download.DownloadController downloadController) {
        org.json.JSONObject extra;
        this.k = downloadController;
        if (com.ss.android.downloadlib.bt.yl.wg(this.d).optInt("force_auto_open") == 1) {
            u().setLinkMode(1);
        }
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix("fix_show_dialog") && (extra = this.d.getExtra()) != null && extra.optInt("subprocess") > 0) {
            u().setEnableNewActivity(false);
        }
        com.ss.android.downloadlib.addownload.wg.kz.vw().vw(this.cp, u());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.bt
    /* renamed from: vw, reason: merged with bridge method [inline-methods] */
    public com.ss.android.downloadlib.addownload.yl wg(com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig) {
        this.j = downloadEventConfig;
        this.tq = vl().getDownloadScene() == 0;
        com.ss.android.downloadlib.addownload.wg.kz.vw().vw(this.cp, vl());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.bt
    /* renamed from: vw, reason: merged with bridge method [inline-methods] */
    public com.ss.android.downloadlib.addownload.yl wg(com.ss.android.download.api.download.DownloadModel downloadModel) {
        if (downloadModel != null) {
            if (downloadModel.isAd()) {
                if (downloadModel.getId() <= 0 || android.text.TextUtils.isEmpty(downloadModel.getLogExtra())) {
                    com.ss.android.downloadlib.yl.t.vw().vw("setDownloadModel ad error");
                }
            } else if (downloadModel.getId() == 0 && (downloadModel instanceof com.ss.android.downloadad.api.download.AdDownloadModel)) {
                com.ss.android.downloadlib.yl.t.vw().vw(false, "setDownloadModel id=0");
                if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix("fix_model_id")) {
                    ((com.ss.android.downloadad.api.download.AdDownloadModel) downloadModel).setId(downloadModel.getDownloadUrl().hashCode());
                }
            }
            com.ss.android.downloadlib.addownload.wg.kz.vw().vw(downloadModel);
            this.cp = downloadModel.getId();
            this.d = downloadModel;
            if (com.ss.android.downloadlib.addownload.x.vw(downloadModel)) {
                ((com.ss.android.downloadad.api.download.AdDownloadModel) downloadModel).setExtraValue(3L);
                com.ss.android.downloadad.api.vw.wg v = com.ss.android.downloadlib.addownload.wg.kz.vw().v(this.cp);
                if (v != null && v.vl() != 3) {
                    v.yl(3L);
                    com.ss.android.downloadlib.addownload.wg.x.vw().vw(v);
                }
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.bt
    public void vw() {
        this.z = true;
        com.ss.android.downloadlib.addownload.wg.kz.vw().vw(this.cp, vl());
        com.ss.android.downloadlib.addownload.wg.kz.vw().vw(this.cp, u());
        this.t.vw(this.cp);
        j();
        if (com.ss.android.downloadlib.addownload.z.x().optInt("enable_empty_listener", 1) == 1 && this.kz.get(Integer.MIN_VALUE) == null) {
            wg(Integer.MIN_VALUE, new com.ss.android.download.api.config.vw());
        }
    }

    @Override // com.ss.android.downloadlib.bt.u.vw
    public void vw(android.os.Message message) {
        if (message != null && this.z && message.what == 3) {
            this.o = (com.ss.android.socialbase.downloader.model.DownloadInfo) message.obj;
            this.t.vw(message, k(), this.kz);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.bt
    public void vw(boolean z) {
        if (this.o != null) {
            if (z) {
                com.ss.android.socialbase.appdownloader.t.v wg2 = com.ss.android.socialbase.appdownloader.v.es().wg();
                if (wg2 != null) {
                    wg2.vw(this.o);
                }
                com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).cancel(this.o.getId(), true);
                return;
            }
            android.content.Intent intent = new android.content.Intent(com.ss.android.downloadlib.addownload.z.getContext(), (java.lang.Class<?>) com.ss.android.socialbase.appdownloader.DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.o.getId());
            com.ss.android.downloadlib.addownload.z.getContext().startService(intent);
        }
    }

    public void vw(boolean z, boolean z2) {
        if (z) {
            com.ss.android.downloadlib.v.vw.vw().vw(this.cp, 2);
        }
        if (com.ss.android.downloadlib.bt.vl.vw()) {
            if (!com.ss.android.downloadlib.bt.es.wg("android.permission.READ_MEDIA_IMAGES") && !com.ss.android.downloadlib.bt.es.wg("android.permission.READ_MEDIA_AUDIO") && !com.ss.android.downloadlib.bt.es.wg("android.permission.READ_MEDIA_VIDEO") && !u().enableNewActivity()) {
                this.d.setFilePath(this.t.wg());
            }
        } else if (!com.ss.android.downloadlib.bt.es.wg(com.anythink.china.common.d.b) && !u().enableNewActivity()) {
            this.d.setFilePath(this.t.wg());
        }
        if (com.ss.android.downloadlib.bt.yl.t(this.d) != 0) {
            bt(z2);
        } else {
            com.ss.android.downloadlib.bt.z.vw(vw, "pBCD not start", null);
            this.t.vw(new com.ss.android.downloadlib.addownload.yl.AnonymousClass8(z2));
        }
    }

    @Override // com.ss.android.downloadlib.addownload.bt
    public boolean vw(int i) {
        if (i == 0) {
            this.kz.clear();
        } else {
            this.kz.remove(java.lang.Integer.valueOf(i));
        }
        if (!this.kz.isEmpty()) {
            if (this.kz.size() == 1 && this.kz.containsKey(Integer.MIN_VALUE)) {
                this.t.wg(this.o);
            }
            return false;
        }
        this.z = false;
        this.vl = java.lang.System.currentTimeMillis();
        if (this.o != null) {
            com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).removeTaskMainListener(this.o.getId());
        }
        com.ss.android.downloadlib.addownload.yl.t tVar = this.x;
        if (tVar != null && tVar.getStatus() != android.os.AsyncTask.Status.FINISHED) {
            this.x.cancel(true);
        }
        this.t.vw(this.o);
        java.lang.String str = vw;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("onUnbind removeCallbacksAndMessages, downloadUrl:");
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.o;
        sb.append(downloadInfo == null ? "" : downloadInfo.getUrl());
        com.ss.android.downloadlib.bt.z.vw(str, sb.toString(), null);
        this.wg.removeCallbacksAndMessages(null);
        this.bt = null;
        this.o = null;
        return true;
    }

    @Override // com.ss.android.downloadlib.addownload.bt
    public void wg(int i) {
        if (i != 1 && i != 2) {
            throw new java.lang.IllegalArgumentException("error actionType");
        }
        this.t.vw(this.cp);
        if (!com.ss.android.downloadlib.addownload.wg.kz.vw().yl(this.cp).iz()) {
            com.ss.android.downloadlib.yl.t.vw().vw("handleDownload ModelBox !isStrictValid");
        }
        if (this.t.vw(i, this.d)) {
            com.ss.android.downloadlib.addownload.compliance.kz.vw().vw(this.t.vw, new com.ss.android.downloadlib.addownload.yl.AnonymousClass1(i));
            return;
        }
        if (this.t.vw(getContext(), i, this.tq)) {
            return;
        }
        boolean t2 = t(i);
        if (i == 1) {
            if (t2) {
                return;
            }
            com.ss.android.downloadlib.bt.z.vw(vw, "handleDownload id:" + this.cp + ",pIC:", null);
            t(true);
            return;
        }
        if (i == 2 && !t2) {
            com.ss.android.downloadlib.bt.z.vw(vw, "handleDownload id:" + this.cp + ",pBC:", null);
            wg(true);
        }
    }

    public void wg(boolean z) {
        yl(z);
    }

    @Override // com.ss.android.downloadlib.addownload.bt
    public boolean wg() {
        return this.z;
    }

    public boolean x() {
        java.lang.ref.SoftReference<com.ss.android.download.api.config.IDownloadButtonClickListener> softReference = this.qm;
        if (softReference == null) {
            return false;
        }
        return com.ss.android.downloadlib.addownload.x.vw(this.d, softReference.get());
    }

    public boolean yl() {
        return com.ss.android.downloadlib.addownload.z.x().optInt("quick_app_enable_switch", 0) == 0 && this.d.getQuickAppModel() != null && !android.text.TextUtils.isEmpty(this.d.getQuickAppModel().vw()) && com.ss.android.downloadlib.addownload.t.vw(this.o) && com.ss.android.downloadlib.bt.vl.vw(getContext(), new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(this.d.getQuickAppModel().vw())));
    }
}
