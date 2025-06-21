package com.ss.android.downloadlib.addownload;

/* loaded from: classes19.dex */
public class o implements com.ss.android.downloadlib.bt.u.vw {
    private boolean t = false;
    private com.ss.android.downloadlib.addownload.yl v;
    public com.ss.android.downloadlib.addownload.wg.yl vw;
    private long wg;
    private com.ss.android.downloadlib.addownload.o.wg yl;

    /* renamed from: com.ss.android.downloadlib.addownload.o$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.download.api.config.q {
        final /* synthetic */ com.ss.android.download.api.config.q vw;

        public AnonymousClass1(com.ss.android.download.api.config.q qVar) {
            this.vw = qVar;
        }

        @Override // com.ss.android.download.api.config.q
        public void vw() {
            this.vw.vw();
        }

        @Override // com.ss.android.download.api.config.q
        public void vw(java.lang.String str) {
            com.ss.android.downloadlib.addownload.z.t().vw(1, com.ss.android.downloadlib.addownload.z.getContext(), com.ss.android.downloadlib.addownload.o.this.vw.wg, "您已禁止使用存储权限，请授权后再下载", null, 1);
            com.ss.android.downloadlib.v.vw.vw().wg(com.ss.android.downloadlib.addownload.o.this.wg, 1);
            this.vw.vw(str);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.o$2, reason: invalid class name */
    public class AnonymousClass2 implements com.ss.android.downloadlib.bt.es.vw {
        final /* synthetic */ com.ss.android.download.api.config.q vw;

        public AnonymousClass2(com.ss.android.download.api.config.q qVar) {
            this.vw = qVar;
        }

        @Override // com.ss.android.downloadlib.bt.es.vw
        public void vw() {
            com.ss.android.download.api.config.q qVar = this.vw;
            if (qVar != null) {
                qVar.vw();
            }
        }

        @Override // com.ss.android.downloadlib.bt.es.vw
        public void vw(java.lang.String str) {
            com.ss.android.download.api.config.q qVar = this.vw;
            if (qVar != null) {
                qVar.vw(str);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.o$3, reason: invalid class name */
    public class AnonymousClass3 implements com.ss.android.downloadlib.addownload.o.wg {
        public AnonymousClass3() {
        }

        @Override // com.ss.android.downloadlib.addownload.o.wg
        public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            com.ss.android.downloadlib.v.vw.vw().vw(com.ss.android.downloadlib.addownload.o.this.wg, 2, downloadInfo);
        }
    }

    public static class vw extends com.ss.android.socialbase.downloader.depend.AbsDownloadExtListener {
        private com.ss.android.downloadlib.bt.u vw;

        public vw(com.ss.android.downloadlib.bt.u uVar) {
            this.vw = uVar;
        }

        private void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, int i) {
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 3;
            obtain.obj = downloadInfo;
            obtain.arg1 = i;
            this.vw.sendMessage(obtain);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            vw(downloadInfo, -4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
            vw(downloadInfo, -1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPause(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            vw(downloadInfo, -2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPrepare(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            vw(downloadInfo, 1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            vw(downloadInfo, 4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            vw(downloadInfo, 2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            vw(downloadInfo, -3);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadExtListener, com.ss.android.socialbase.downloader.depend.IDownloadExtListener
        public void onWaitingDownloadCompleteHandler(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            vw(downloadInfo, 11);
        }
    }

    public interface wg {
        void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo);
    }

    public o(com.ss.android.downloadlib.addownload.yl ylVar) {
        this.v = ylVar;
    }

    private boolean kz() {
        return com.ss.android.downloadlib.bt.vl.vw(this.vw.wg) && com.ss.android.downloadlib.addownload.x.vw(this.vw.v.getLinkMode());
    }

    private boolean kz(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3 && com.ss.android.socialbase.downloader.utils.DownloadUtils.isFileExist(downloadInfo.getSavePath(), downloadInfo.getName());
    }

    private boolean t() {
        return v() && yl();
    }

    private boolean v() {
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw.wg;
        return (downloadModel == null || android.text.TextUtils.isEmpty(downloadModel.getPackageName()) || android.text.TextUtils.isEmpty(this.vw.wg.getDownloadUrl())) ? false : true;
    }

    private com.ss.android.socialbase.downloader.model.HttpHeader vw(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            return new com.ss.android.socialbase.downloader.model.HttpHeader("clickid", new org.json.JSONObject(str).optString("clickid"));
        } catch (org.json.JSONException e) {
            com.ss.android.downloadlib.addownload.z.q().vw(e, "parseLogExtra Error");
            return null;
        }
    }

    private java.lang.String vw(com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting) {
        java.lang.String str;
        if (!android.text.TextUtils.isEmpty(this.vw.wg.getFilePath())) {
            return this.vw.wg.getFilePath();
        }
        com.ss.android.socialbase.downloader.model.DownloadInfo vw2 = com.ss.android.socialbase.appdownloader.v.es().vw(com.ss.android.downloadlib.addownload.z.getContext(), this.vw.wg.getDownloadUrl());
        boolean wg2 = !com.ss.android.downloadlib.bt.vl.vw() ? com.ss.android.downloadlib.bt.es.wg(com.anythink.china.common.d.b) : com.ss.android.downloadlib.bt.es.wg("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.bt.es.wg("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.bt.es.wg("android.permission.READ_MEDIA_VIDEO");
        java.lang.String wg3 = wg();
        if (vw2 != null && !android.text.TextUtils.isEmpty(vw2.getSavePath())) {
            java.lang.String savePath = vw2.getSavePath();
            if (wg2 || savePath.startsWith(android.os.Environment.getDataDirectory().getAbsolutePath())) {
                return savePath;
            }
            try {
                if (!android.text.TextUtils.isEmpty(wg3)) {
                    if (savePath.startsWith(wg3)) {
                        return savePath;
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).cancel(vw2.getId());
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", java.lang.Integer.valueOf(wg2 ? 1 : 2));
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.v.vw.vw().vw("label_external_permission", jSONObject, this.vw);
        try {
            str = com.ss.android.socialbase.appdownloader.t.wg();
        } catch (java.lang.Exception unused) {
            str = null;
        }
        int vw3 = com.ss.android.downloadlib.bt.yl.vw(downloadSetting);
        if (vw3 != 0) {
            if (vw3 == 4 || (!wg2 && vw3 == 2)) {
                java.io.File filesDir = com.ss.android.downloadlib.addownload.z.getContext().getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.mkdirs();
                }
                if (filesDir.exists()) {
                    return filesDir.getAbsolutePath();
                }
            } else if ((vw3 == 3 || (!wg2 && vw3 == 1)) && !android.text.TextUtils.isEmpty(wg3)) {
                return wg3;
            }
        }
        return str;
    }

    @androidx.annotation.NonNull
    public static java.util.List<com.ss.android.download.api.download.DownloadStatusChangeListener> vw(java.util.Map<java.lang.Integer, java.lang.Object> map) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (map != null && !map.isEmpty()) {
            for (java.lang.Object obj : map.values()) {
                if (obj instanceof com.ss.android.download.api.download.DownloadStatusChangeListener) {
                    arrayList.add((com.ss.android.download.api.download.DownloadStatusChangeListener) obj);
                } else {
                    if (obj instanceof java.lang.ref.SoftReference) {
                        java.lang.ref.SoftReference softReference = (java.lang.ref.SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.DownloadStatusChangeListener) {
                            arrayList.add((com.ss.android.download.api.download.DownloadStatusChangeListener) softReference.get());
                        }
                    }
                    if (obj instanceof java.lang.ref.WeakReference) {
                        java.lang.ref.WeakReference weakReference = (java.lang.ref.WeakReference) obj;
                        if (weakReference.get() instanceof com.ss.android.download.api.download.DownloadStatusChangeListener) {
                            arrayList.add((com.ss.android.download.api.download.DownloadStatusChangeListener) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @androidx.annotation.NonNull
    public static java.util.List<com.ss.android.download.api.download.vw> wg(java.util.Map<java.lang.Integer, java.lang.Object> map) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (map != null && !map.isEmpty()) {
            for (java.lang.Object obj : map.values()) {
                if (obj instanceof com.ss.android.download.api.download.vw) {
                    arrayList.add((com.ss.android.download.api.download.vw) obj);
                } else {
                    if (obj instanceof java.lang.ref.SoftReference) {
                        java.lang.ref.SoftReference softReference = (java.lang.ref.SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.vw) {
                            arrayList.add((com.ss.android.download.api.download.vw) softReference.get());
                        }
                    }
                    if (obj instanceof java.lang.ref.WeakReference) {
                        java.lang.ref.WeakReference weakReference = (java.lang.ref.WeakReference) obj;
                        if (weakReference.get() instanceof com.ss.android.download.api.download.vw) {
                            arrayList.add((com.ss.android.download.api.download.vw) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private void wg(com.ss.android.download.api.config.q qVar) {
        java.lang.String str;
        if (com.ss.android.downloadlib.bt.es.wg(com.anythink.china.common.d.b)) {
            if (qVar != null) {
                qVar.vw();
                return;
            }
            return;
        }
        if (com.ss.android.downloadlib.bt.vl.vw()) {
            str = "android.permission.READ_MEDIA_IMAGES";
            if (com.ss.android.downloadlib.bt.es.wg("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.bt.es.wg("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.bt.es.wg("android.permission.READ_MEDIA_VIDEO")) {
                if (qVar != null) {
                    qVar.vw();
                    return;
                }
                return;
            }
        } else {
            str = "android.permission.READ_EXTERNAL_STORAGE";
        }
        com.ss.android.downloadlib.bt.es.vw(new java.lang.String[]{str}, new com.ss.android.downloadlib.addownload.o.AnonymousClass2(qVar));
    }

    private boolean yl() {
        return this.vw.v.isAddToDownloadManage();
    }

    private boolean yl(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        return !com.ss.android.downloadlib.bt.vl.vw(this.vw.wg) && kz(downloadInfo);
    }

    public void t(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (!com.ss.android.downloadlib.addownload.x.vw(this.vw.wg) || this.t) {
            return;
        }
        com.ss.android.downloadlib.v.vw.vw().vw("file_status", (downloadInfo == null || !com.ss.android.downloadlib.bt.vl.wg(downloadInfo.getTargetFilePath())) ? 2 : 1, this.vw);
        this.t = true;
    }

    public boolean v(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        return kz() || yl(downloadInfo);
    }

    public int vw(android.content.Context context, com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener) {
        com.ss.android.downloadlib.addownload.t.vw vwVar;
        com.ss.android.socialbase.downloader.model.HttpHeader vw2;
        if (context == null) {
            return 0;
        }
        java.util.Map<java.lang.String, java.lang.String> headers = this.vw.wg.getHeaders();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (com.ss.android.downloadlib.addownload.z.x().optInt("enable_send_click_id_in_apk", 1) == 1 && !android.text.TextUtils.isEmpty(this.vw.wg.getLogExtra()) && (vw2 = vw(this.vw.wg.getLogExtra())) != null) {
            arrayList.add(vw2);
        }
        if (headers != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : headers.entrySet()) {
                if (entry != null) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.HttpHeader(entry.getKey(), entry.getValue()));
                }
            }
        }
        java.lang.String vw3 = com.ss.android.downloadlib.bt.v.vw(java.lang.String.valueOf(this.vw.wg.getId()), this.vw.wg.getNotificationJumpUrl(), this.vw.wg.isShowToast(), java.lang.String.valueOf(this.vw.wg.getModelType()));
        com.ss.android.socialbase.downloader.setting.DownloadSetting wg2 = com.ss.android.downloadlib.bt.yl.wg(this.vw.wg);
        org.json.JSONObject vw4 = com.ss.android.downloadlib.bt.yl.vw(this.vw.wg);
        if (!this.vw.v.enableAH()) {
            vw4 = com.ss.android.downloadlib.bt.vl.vw(vw4);
            com.ss.android.downloadlib.bt.vl.vw(vw4, com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.KEY_AH_PLANS, new org.json.JSONArray());
        }
        int executorGroup = this.vw.wg.getExecutorGroup();
        if (this.vw.wg.isAd() || com.ss.android.downloadlib.addownload.x.wg(this.vw.wg)) {
            executorGroup = 4;
        }
        java.lang.String vw5 = vw(wg2);
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadId(this.vw.wg.getDownloadUrl(), vw5));
        if (downloadInfo != null && 3 == this.vw.wg.getModelType()) {
            downloadInfo.setFirstDownload(true);
        }
        com.ss.android.socialbase.appdownloader.kz d = new com.ss.android.socialbase.appdownloader.kz(context, this.vw.wg.getDownloadUrl()).wg(this.vw.wg.getBackupUrls()).vw(this.vw.wg.getName()).yl(vw3).vw(arrayList).vw(this.vw.wg.isShowNotification()).t(this.vw.wg.isNeedWifi()).wg(this.vw.wg.getFileName()).t(vw5).z(this.vw.wg.getAppIcon()).o(this.vw.wg.getMd5()).es(this.vw.wg.getSdkMonitorScene()).vw(this.vw.wg.getExpectFileLength()).vw(iDownloadListener).vl(this.vw.wg.needIndependentProcess() || wg2.optInt(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_NEED_INDEPENDENT_PROCESS, 0) == 1).vw(this.vw.wg.getDownloadFileUriProvider()).wg(this.vw.wg.autoInstallWithoutNotification()).bt(this.vw.wg.getPackageName()).v(1000).yl(100).vw(vw4).x(true).es(true).wg(wg2.optInt("retry_count", 5)).t(wg2.optInt("backup_url_retry_count", 0)).es(true).u(wg2.optInt("need_head_connection", 0) == 1).v(wg2.optInt("need_https_to_http_retry", 0) == 1).o(wg2.optInt(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_NEED_CHUNK_DOWNGRADE_RETRY, 1) == 1).bt(wg2.optInt(com.ss.android.socialbase.downloader.constants.MonitorConstants.EXTRA_DOWNLOAD_NEED_RETRY_DELAY, 0) == 1).x(wg2.optString("retry_delay_time_array")).z(wg2.optInt("need_reuse_runnable", 0) == 1).kz(executorGroup).j(this.vw.wg.isAutoInstall()).d(this.vw.wg.distinctDir());
        if (android.text.TextUtils.isEmpty(this.vw.wg.getMimeType())) {
            d.kz("application/vnd.android.package-archive");
        } else {
            d.kz(this.vw.wg.getMimeType());
        }
        if (wg2.optInt("notification_opt_2", 0) == 1) {
            d.vw(false);
            d.wg(true);
        }
        if (wg2.optInt("clear_space_use_disk_handler", 0) == 1) {
            vwVar = new com.ss.android.downloadlib.addownload.t.vw();
            d.vw(vwVar);
        } else {
            vwVar = null;
        }
        com.ss.android.download.api.download.DownloadModel downloadModel = this.vw.wg;
        if ((downloadModel instanceof com.ss.android.downloadad.api.download.AdDownloadModel) && !android.text.TextUtils.isEmpty(((com.ss.android.downloadad.api.download.AdDownloadModel) downloadModel).getTaskKey())) {
            d.v(((com.ss.android.downloadad.api.download.AdDownloadModel) this.vw.wg).getTaskKey());
        }
        int vw6 = com.ss.android.downloadlib.addownload.x.vw(this.vw, t(), d);
        if (vwVar != null) {
            vwVar.vw(vw6);
        }
        return vw6;
    }

    public void vw() {
        if (this.yl == null) {
            this.yl = new com.ss.android.downloadlib.addownload.o.AnonymousClass3();
        }
    }

    public void vw(long j) {
        this.wg = j;
        com.ss.android.downloadlib.addownload.wg.yl yl = com.ss.android.downloadlib.addownload.wg.kz.vw().yl(j);
        this.vw = yl;
        if (yl.iq()) {
            com.ss.android.downloadlib.yl.t.vw().vw("setAdId ModelBox notValid");
        }
    }

    @Override // com.ss.android.downloadlib.bt.u.vw
    public void vw(android.os.Message message) {
    }

    public void vw(android.os.Message message, com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo, java.util.Map<java.lang.Integer, java.lang.Object> map) {
        com.ss.android.downloadlib.addownload.o.wg wgVar;
        if (message == null || message.what != 3) {
            return;
        }
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = (com.ss.android.socialbase.downloader.model.DownloadInfo) message.obj;
        int i = message.arg1;
        if (i != 1 && i != 6 && i == 2) {
            if (downloadInfo.getIsFirstDownload()) {
                com.ss.android.downloadlib.bt vw2 = com.ss.android.downloadlib.bt.vw();
                com.ss.android.downloadlib.addownload.wg.yl ylVar = this.vw;
                vw2.vw(ylVar.wg, ylVar.v, ylVar.t);
                downloadInfo.setFirstDownload(false);
            }
            com.ss.android.downloadlib.v.vw.vw().vw(downloadInfo);
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        com.ss.android.downloadlib.addownload.es.vw(downloadShortInfo);
        int vw3 = com.ss.android.socialbase.appdownloader.t.vw(downloadInfo.getStatus());
        long totalBytes = downloadInfo.getTotalBytes();
        int curBytes = totalBytes > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
        if ((totalBytes > 0 || com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) && (wgVar = this.yl) != null) {
            wgVar.vw(downloadInfo);
            this.yl = null;
        }
        for (com.ss.android.download.api.download.DownloadStatusChangeListener downloadStatusChangeListener : vw(map)) {
            if (vw3 != 1) {
                if (vw3 == 2) {
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, com.ss.android.downloadlib.addownload.es.vw(downloadInfo.getId(), curBytes));
                } else if (vw3 == 3) {
                    if (downloadInfo.getStatus() == -4) {
                        downloadStatusChangeListener.onIdle();
                    } else if (downloadInfo.getStatus() == -1) {
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                    } else if (downloadInfo.getStatus() == -3) {
                        if (com.ss.android.downloadlib.bt.vl.vw(this.vw.wg)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                    }
                }
            } else if (downloadInfo.getStatus() != 11) {
                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, com.ss.android.downloadlib.addownload.es.vw(downloadInfo.getId(), curBytes));
            } else {
                java.util.Iterator<com.ss.android.download.api.download.vw> it = wg(map).iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    public void vw(@androidx.annotation.NonNull com.ss.android.download.api.config.q qVar) {
        if (!android.text.TextUtils.isEmpty(this.vw.wg.getFilePath())) {
            java.lang.String filePath = this.vw.wg.getFilePath();
            if (filePath.startsWith(android.os.Environment.getDataDirectory().getAbsolutePath())) {
                qVar.vw();
                return;
            } else {
                try {
                    if (filePath.startsWith(com.ss.android.downloadlib.addownload.z.getContext().getExternalCacheDir().getParent())) {
                        qVar.vw();
                        return;
                    }
                } catch (java.lang.Exception unused) {
                }
            }
        }
        wg(new com.ss.android.downloadlib.addownload.o.AnonymousClass1(qVar));
    }

    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        this.t = false;
        wg(downloadInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo, java.util.List<com.ss.android.download.api.download.DownloadStatusChangeListener> list) {
        int i;
        if (list.isEmpty()) {
            return;
        }
        if (downloadInfo == null || downloadShortInfo == null) {
            java.util.Iterator<com.ss.android.download.api.download.DownloadStatusChangeListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onIdle();
            }
            return;
        }
        try {
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        if (downloadInfo.getTotalBytes() > 0) {
            i = (int) ((downloadInfo.getCurBytes() * 100) / downloadInfo.getTotalBytes());
            int i2 = i >= 0 ? i : 0;
            downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
            com.ss.android.downloadlib.addownload.es.vw(downloadShortInfo);
            for (com.ss.android.download.api.download.DownloadStatusChangeListener downloadStatusChangeListener : list) {
                switch (downloadInfo.getStatus()) {
                    case -4:
                    case 0:
                        if (com.ss.android.downloadlib.bt.vl.vw(this.vw.wg)) {
                            downloadShortInfo.status = -3;
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                            break;
                        } else {
                            downloadStatusChangeListener.onIdle();
                            break;
                        }
                    case -3:
                        if (com.ss.android.downloadlib.bt.vl.vw(this.vw.wg)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                            break;
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                            break;
                        }
                    case -2:
                        downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, com.ss.android.downloadlib.addownload.es.vw(downloadInfo.getId(), i2));
                        break;
                    case -1:
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 7:
                    case 8:
                        downloadStatusChangeListener.onDownloadActive(downloadShortInfo, com.ss.android.downloadlib.addownload.es.vw(downloadInfo.getId(), i2));
                        break;
                    case 11:
                        if (downloadStatusChangeListener instanceof com.ss.android.download.api.download.vw) {
                            break;
                        } else {
                            downloadStatusChangeListener.onDownloadActive(downloadShortInfo, com.ss.android.downloadlib.addownload.es.vw(downloadInfo.getId(), i2));
                            break;
                        }
                }
            }
        }
        i = 0;
        if (i >= 0) {
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        com.ss.android.downloadlib.addownload.es.vw(downloadShortInfo);
        while (r9.hasNext()) {
        }
    }

    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, boolean z) {
        if (this.vw.wg == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status == -1 || status == -4) {
            com.ss.android.downloadlib.v.vw.vw().vw(this.wg, 2);
        } else if (com.ss.android.downloadlib.addownload.x.vw(this.vw.wg) || (z && com.ss.android.downloadlib.v.t.vw().t() && (status == -2 || status == -3))) {
            com.ss.android.downloadlib.v.vw.vw().vw(this.wg, 2);
        }
        switch (status) {
            case -4:
            case -1:
                vw();
                com.ss.android.downloadlib.addownload.wg.kz vw2 = com.ss.android.downloadlib.addownload.wg.kz.vw();
                com.ss.android.downloadlib.addownload.wg.yl ylVar = this.vw;
                vw2.vw(new com.ss.android.downloadad.api.vw.wg(ylVar.wg, ylVar.t, ylVar.v, downloadInfo.getId()));
                break;
            case -3:
                if (!com.ss.android.downloadlib.bt.vl.vw(this.vw.wg)) {
                    com.ss.android.downloadlib.v.vw.vw().vw(this.wg, 5, downloadInfo);
                    if (z && com.ss.android.downloadlib.v.t.vw().wg() && !com.ss.android.downloadlib.v.t.vw().wg(this.wg, this.vw.wg.getLogExtra())) {
                        com.ss.android.downloadlib.v.vw.vw().vw(this.wg, 2);
                        break;
                    }
                } else {
                    com.ss.android.downloadlib.yl.t.vw().wg("SUCCESSED isInstalledApp");
                    break;
                }
                break;
            case -2:
                com.ss.android.downloadlib.v.vw.vw().vw(this.wg, 4, downloadInfo);
                if (z && com.ss.android.downloadlib.v.t.vw().wg() && !com.ss.android.downloadlib.v.t.vw().wg(this.wg, this.vw.wg.getLogExtra())) {
                    com.ss.android.downloadlib.v.vw.vw().vw(this.wg, 2);
                    break;
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                com.ss.android.downloadlib.v.vw.vw().vw(this.wg, 3, downloadInfo);
                break;
        }
    }

    public boolean vw(int i) {
        if (this.vw.v.getDownloadMode() == 2 && i == 2) {
            return true;
        }
        return this.vw.v.getDownloadMode() == 2 && i == 1 && com.ss.android.downloadlib.addownload.z.x().optInt("disable_lp_if_market", 0) == 1;
    }

    public boolean vw(int i, com.ss.android.download.api.download.DownloadModel downloadModel) {
        return com.ss.android.socialbase.appdownloader.kz.yl.t() && vw(i) && !com.ss.android.downloadlib.bt.vl.vw(downloadModel);
    }

    public boolean vw(android.content.Context context, int i, boolean z) {
        if (com.ss.android.downloadlib.bt.vl.vw(this.vw.wg)) {
            com.ss.android.downloadad.api.vw.wg v = com.ss.android.downloadlib.addownload.wg.kz.vw().v(this.vw.vw);
            if (v != null) {
                com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().cancelNotification(v.tq());
            }
            return com.ss.android.downloadlib.wg.vw.vw(this.vw);
        }
        if (vw(i) && !android.text.TextUtils.isEmpty(this.vw.wg.getPackageName()) && com.ss.android.downloadlib.addownload.z.x().optInt("disable_market") != 1) {
            if (com.ss.android.downloadlib.wg.vw.vw(this.vw, i)) {
                return true;
            }
            return this.v.x() && this.v.v(true);
        }
        if (!z || this.vw.v.getDownloadMode() != 4 || this.v.yl()) {
            return false;
        }
        this.v.t(true);
        return true;
    }

    public boolean vw(boolean z) {
        return !z && this.vw.v.getDownloadMode() == 1;
    }

    @androidx.annotation.Nullable
    public java.lang.String wg() {
        java.io.File externalFilesDir = com.ss.android.downloadlib.addownload.z.getContext().getExternalFilesDir(android.os.Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir == null) {
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        if (externalFilesDir.exists()) {
            return externalFilesDir.getAbsolutePath();
        }
        return null;
    }

    public void wg(@androidx.annotation.Nullable com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        com.ss.android.downloadlib.addownload.o.wg wgVar = this.yl;
        if (wgVar != null) {
            wgVar.vw(downloadInfo);
            this.yl = null;
        }
    }
}
