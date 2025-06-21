package com.ss.android.socialbase.appdownloader;

/* loaded from: classes19.dex */
public class v {
    private static boolean bt = false;
    private static boolean kz = false;
    private static boolean o = false;
    private static final java.lang.String vw = "v";
    private static volatile com.ss.android.socialbase.appdownloader.v wg;
    private com.ss.android.socialbase.appdownloader.t.o cp;
    private com.ss.android.socialbase.appdownloader.t.bt d;
    private int es;
    private com.ss.android.socialbase.appdownloader.t.u j;
    private com.ss.android.socialbase.appdownloader.t.kz k;
    private com.ss.android.socialbase.downloader.depend.IOpenInstallerListener q;
    private java.lang.String t;
    private com.ss.android.socialbase.appdownloader.t.es te;
    private com.ss.android.socialbase.downloader.depend.IInstallAppHandler tq;
    private com.ss.android.socialbase.appdownloader.t.v u;
    private java.lang.String v;
    private com.ss.android.socialbase.appdownloader.t.t vl;
    private java.util.concurrent.Future x;
    private com.ss.android.socialbase.appdownloader.DownloadReceiver yl = new com.ss.android.socialbase.appdownloader.DownloadReceiver();
    private boolean z = false;

    /* renamed from: com.ss.android.socialbase.appdownloader.v$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.logger.Logger.d(com.ss.android.socialbase.appdownloader.v.vw, "registerDownloadReceiver tryUnRegisterTempAppInstallDownloadReceiver run inner");
            com.ss.android.socialbase.appdownloader.v.this.vl();
            com.ss.android.socialbase.appdownloader.v.this.tq();
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.v$2, reason: invalid class name */
    public class AnonymousClass2 implements com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler {
        public AnonymousClass2() {
        }

        @Override // com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler
        public void cancelRetry(int i) {
            com.ss.android.socialbase.appdownloader.RetryJobSchedulerService.vw(i);
        }

        @Override // com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler
        public void scheduleRetry(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, long j, boolean z, int i) {
            com.ss.android.socialbase.appdownloader.RetryJobSchedulerService.vw(downloadInfo, j, z, i);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.v$3, reason: invalid class name */
    public class AnonymousClass3 implements com.ss.android.socialbase.downloader.depend.IDownloadDepend {
        public AnonymousClass3() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDepend
        public void monitorLogSend(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException, int i) {
            if (com.ss.android.socialbase.appdownloader.v.this.cp != null) {
                com.ss.android.socialbase.appdownloader.v.this.cp.vw(downloadInfo, baseException, i);
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.v$4, reason: invalid class name */
    public class AnonymousClass4 implements com.ss.android.socialbase.appdownloader.t.cp {
        final /* synthetic */ int t;
        final /* synthetic */ boolean v;
        final /* synthetic */ java.lang.String vw;
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadTask wg;

        public AnonymousClass4(java.lang.String str, com.ss.android.socialbase.downloader.model.DownloadTask downloadTask, int i, boolean z) {
            this.vw = str;
            this.wg = downloadTask;
            this.t = i;
            this.v = z;
        }

        @Override // com.ss.android.socialbase.appdownloader.t.cp
        public void vw() {
            com.ss.android.socialbase.downloader.logger.Logger.d(com.ss.android.socialbase.appdownloader.v.vw, "notification permission granted, start download :" + this.vw);
            com.ss.android.socialbase.appdownloader.v.this.vw(this.wg, this.t, this.v);
        }

        @Override // com.ss.android.socialbase.appdownloader.t.cp
        public void wg() {
            com.ss.android.socialbase.downloader.logger.Logger.d(com.ss.android.socialbase.appdownloader.v.vw, "notification permission denied, start download :" + this.vw);
            com.ss.android.socialbase.appdownloader.v.this.vw(this.wg, this.t, this.v);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.v$5, reason: invalid class name */
    public class AnonymousClass5 implements com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener {
        final /* synthetic */ com.ss.android.socialbase.appdownloader.t.yl vw;

        public AnonymousClass5(com.ss.android.socialbase.appdownloader.t.yl ylVar) {
            this.vw = ylVar;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
        public java.lang.String getNotifyProcessName() {
            return this.vw.vw();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
        public boolean interceptAfterNotificationSuccess(boolean z) {
            return this.vw.vw(z);
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
        public void onNotificationEvent(int i, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str, java.lang.String str2) {
            if (i != 1 && i != 3) {
                switch (i) {
                    case 8:
                        downloadInfo.getPackageName();
                        break;
                    case 9:
                        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext();
                        break;
                }
                return;
            }
            downloadInfo.getStatus();
            downloadInfo.getDownloadTime();
        }
    }

    private v() {
    }

    public static com.ss.android.socialbase.appdownloader.v es() {
        if (wg == null) {
            synchronized (com.ss.android.socialbase.appdownloader.v.class) {
                if (wg == null) {
                    wg = new com.ss.android.socialbase.appdownloader.v();
                }
            }
        }
        return wg;
    }

    private void q() {
        this.es = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optInt("app_install_keep_receiver_time_s", 60);
        com.ss.android.socialbase.downloader.logger.Logger.d(vw, "tryUnRegisterTempAppInstallDownloadReceiver mAppInstallReceiverKeepTime:" + this.es);
        if (this.es <= 0) {
            return;
        }
        java.util.concurrent.Future future = this.x;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        this.x = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.submitScheduleTask(new com.ss.android.socialbase.appdownloader.v.AnonymousClass1(), this.es, java.util.concurrent.TimeUnit.SECONDS);
    }

    private void qm() {
        com.ss.android.socialbase.downloader.impls.RetryScheduler.setRetryScheduleHandler(new com.ss.android.socialbase.appdownloader.v.AnonymousClass2());
    }

    private void t(android.content.Context context) {
        if (context == null || kz) {
            return;
        }
        com.ss.android.socialbase.downloader.constants.DownloadConstants.setMimeApk("application/vnd.android.package-archive");
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.setAppContext(context);
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.setDownloadLaunchHandler(new com.ss.android.socialbase.appdownloader.v.wg());
        tq();
        qm();
        kz = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tq() {
        synchronized (this.yl) {
            if (bt) {
                return;
            }
            try {
                android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
                intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
                intentFilter.addAction("android.ss.intent.action.DOWNLOAD_COMPLETE");
                android.content.IntentFilter intentFilter2 = new android.content.IntentFilter();
                intentFilter2.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter2.addDataScheme("file");
                com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().registerReceiver(this.yl, intentFilter);
                com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().registerReceiver(this.yl, intentFilter2);
                bt = true;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            com.ss.android.socialbase.downloader.logger.Logger.d(vw, "registerDownloadReceiver mIsRegistered:" + bt);
        }
    }

    private com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener vw(com.ss.android.socialbase.appdownloader.t.yl ylVar) {
        if (ylVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.appdownloader.v.AnonymousClass5(ylVar);
    }

    private com.ss.android.socialbase.downloader.model.DownloadInfo vw(android.content.Context context, java.lang.String str, java.io.File file) {
        if (context == null || android.text.TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    private java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> vw(java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        boolean z = false;
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.HttpHeader httpHeader : list) {
                if (httpHeader != null && !android.text.TextUtils.isEmpty(httpHeader.getName()) && !android.text.TextUtils.isEmpty(httpHeader.getValue())) {
                    if (httpHeader.getName().equals("User-Agent")) {
                        z = true;
                    }
                    arrayList.add(new com.ss.android.socialbase.downloader.model.HttpHeader(httpHeader.getName(), httpHeader.getValue()));
                }
            }
        }
        if (!z) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.HttpHeader("User-Agent", com.ss.android.socialbase.appdownloader.wg.vw.vw));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vw(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask, int i, boolean z) {
        if (downloadTask == null) {
            return;
        }
        downloadTask.download();
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setAntiHijackErrorCode(i);
        }
        if (downloadInfo == null || !z) {
            return;
        }
        downloadInfo.setSavePathRedirected(z);
    }

    public static boolean vw(android.content.Context context, int i) {
        return com.ss.android.socialbase.appdownloader.t.vw(context, i, true) == 1;
    }

    private com.ss.android.socialbase.downloader.model.DownloadInfo wg(android.content.Context context, java.lang.String str) {
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> downloadInfoList = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).getDownloadInfoList(str);
        if (downloadInfoList == null) {
            return null;
        }
        for (com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo : downloadInfoList) {
            if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                return downloadInfo;
            }
        }
        return null;
    }

    public com.ss.android.socialbase.appdownloader.t.es bt() {
        return this.te;
    }

    public com.ss.android.socialbase.appdownloader.t.bt cp() {
        return this.d;
    }

    public com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener d() {
        return com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).getReserveWifiStatusListener();
    }

    public com.ss.android.socialbase.downloader.depend.IInstallAppHandler j() {
        return this.tq;
    }

    public com.ss.android.socialbase.downloader.depend.IOpenInstallerListener k() {
        return this.q;
    }

    public boolean kz() {
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.getGlobalSettings().optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.PACKAGE_FLAG_CONFIG, 1) == 1;
    }

    public java.io.File o() {
        return com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).getGlobalSaveDir();
    }

    public com.ss.android.socialbase.appdownloader.t.o t() {
        return this.cp;
    }

    public com.ss.android.socialbase.appdownloader.t.u u() {
        return this.j;
    }

    public java.lang.String v() {
        return this.v;
    }

    public void vl() {
        synchronized (this.yl) {
            try {
                if (bt) {
                    com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().unregisterReceiver(this.yl);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            bt = false;
            o = false;
        }
        com.ss.android.socialbase.downloader.logger.Logger.d(vw, "registerDownloadReceiver unRegisterDownloadReceiver");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(27:37|(1:39)|40|(2:44|45)|48|(1:116)(1:55)|56|(2:62|(1:64)(19:65|66|(1:68)|69|(3:71|(2:74|72)|75)|76|77|78|(1:80)(1:113)|81|82|(6:87|(1:110)(1:91)|92|(1:96)|(1:(1:108)(1:107))|109)|111|(1:89)|110|92|(2:94|96)|(0)|109))|115|66|(0)|69|(0)|76|77|78|(0)(0)|81|82|(8:84|87|(0)|110|92|(0)|(0)|109)|111|(0)|110|92|(0)|(0)|109) */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0176 A[Catch: all -> 0x0191, TryCatch #0 {all -> 0x0191, blocks: (B:78:0x016a, B:80:0x0170, B:81:0x017b, B:113:0x0176), top: B:77:0x016a }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0143 A[Catch: all -> 0x0394, TryCatch #1 {all -> 0x0394, blocks: (B:7:0x0010, B:11:0x0023, B:14:0x002c, B:16:0x003a, B:17:0x0042, B:19:0x004a, B:20:0x0053, B:23:0x005a, B:25:0x0066, B:28:0x0072, B:30:0x0080, B:31:0x0084, B:33:0x008b, B:37:0x0093, B:40:0x009e, B:42:0x00b2, B:48:0x00cc, B:51:0x00e5, B:53:0x00eb, B:56:0x00fc, B:58:0x0102, B:60:0x0108, B:62:0x010e, B:64:0x0114, B:65:0x0123, B:66:0x013d, B:68:0x0143, B:69:0x0148, B:71:0x0152, B:72:0x0156, B:74:0x015c, B:76:0x0166, B:82:0x0191, B:84:0x0197, B:89:0x01a3, B:91:0x01af, B:92:0x01bf, B:94:0x033b, B:96:0x0345, B:99:0x0350, B:101:0x0356, B:103:0x035c, B:105:0x0366, B:107:0x036c, B:108:0x037c), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0152 A[Catch: all -> 0x0394, TryCatch #1 {all -> 0x0394, blocks: (B:7:0x0010, B:11:0x0023, B:14:0x002c, B:16:0x003a, B:17:0x0042, B:19:0x004a, B:20:0x0053, B:23:0x005a, B:25:0x0066, B:28:0x0072, B:30:0x0080, B:31:0x0084, B:33:0x008b, B:37:0x0093, B:40:0x009e, B:42:0x00b2, B:48:0x00cc, B:51:0x00e5, B:53:0x00eb, B:56:0x00fc, B:58:0x0102, B:60:0x0108, B:62:0x010e, B:64:0x0114, B:65:0x0123, B:66:0x013d, B:68:0x0143, B:69:0x0148, B:71:0x0152, B:72:0x0156, B:74:0x015c, B:76:0x0166, B:82:0x0191, B:84:0x0197, B:89:0x01a3, B:91:0x01af, B:92:0x01bf, B:94:0x033b, B:96:0x0345, B:99:0x0350, B:101:0x0356, B:103:0x035c, B:105:0x0366, B:107:0x036c, B:108:0x037c), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0170 A[Catch: all -> 0x0191, TryCatch #0 {all -> 0x0191, blocks: (B:78:0x016a, B:80:0x0170, B:81:0x017b, B:113:0x0176), top: B:77:0x016a }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a3 A[Catch: all -> 0x0394, TryCatch #1 {all -> 0x0394, blocks: (B:7:0x0010, B:11:0x0023, B:14:0x002c, B:16:0x003a, B:17:0x0042, B:19:0x004a, B:20:0x0053, B:23:0x005a, B:25:0x0066, B:28:0x0072, B:30:0x0080, B:31:0x0084, B:33:0x008b, B:37:0x0093, B:40:0x009e, B:42:0x00b2, B:48:0x00cc, B:51:0x00e5, B:53:0x00eb, B:56:0x00fc, B:58:0x0102, B:60:0x0108, B:62:0x010e, B:64:0x0114, B:65:0x0123, B:66:0x013d, B:68:0x0143, B:69:0x0148, B:71:0x0152, B:72:0x0156, B:74:0x015c, B:76:0x0166, B:82:0x0191, B:84:0x0197, B:89:0x01a3, B:91:0x01af, B:92:0x01bf, B:94:0x033b, B:96:0x0345, B:99:0x0350, B:101:0x0356, B:103:0x035c, B:105:0x0366, B:107:0x036c, B:108:0x037c), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x033b A[Catch: all -> 0x0394, TryCatch #1 {all -> 0x0394, blocks: (B:7:0x0010, B:11:0x0023, B:14:0x002c, B:16:0x003a, B:17:0x0042, B:19:0x004a, B:20:0x0053, B:23:0x005a, B:25:0x0066, B:28:0x0072, B:30:0x0080, B:31:0x0084, B:33:0x008b, B:37:0x0093, B:40:0x009e, B:42:0x00b2, B:48:0x00cc, B:51:0x00e5, B:53:0x00eb, B:56:0x00fc, B:58:0x0102, B:60:0x0108, B:62:0x010e, B:64:0x0114, B:65:0x0123, B:66:0x013d, B:68:0x0143, B:69:0x0148, B:71:0x0152, B:72:0x0156, B:74:0x015c, B:76:0x0166, B:82:0x0191, B:84:0x0197, B:89:0x01a3, B:91:0x01af, B:92:0x01bf, B:94:0x033b, B:96:0x0345, B:99:0x0350, B:101:0x0356, B:103:0x035c, B:105:0x0366, B:107:0x036c, B:108:0x037c), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x034e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int vw(com.ss.android.socialbase.appdownloader.kz kzVar) {
        boolean z;
        int i;
        java.lang.String str;
        com.ss.android.socialbase.downloader.depend.IDownloadDepend f;
        java.util.List<com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler> downloadCompleteHandlers;
        boolean z2;
        int i2;
        com.ss.android.socialbase.downloader.model.DownloadTask with;
        com.ss.android.socialbase.downloader.model.DownloadTask autoInstall;
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        if (kzVar == null || kzVar.getContext() == null) {
            return 0;
        }
        try {
            java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> vw2 = vw(kzVar.v());
            java.lang.String vw3 = kzVar.vw();
            if (android.text.TextUtils.isEmpty(vw3)) {
                return 0;
            }
            int tq = kzVar.tq();
            boolean z3 = tq == 0;
            java.lang.String kk = kzVar.kk();
            java.lang.String wg2 = kzVar.wg();
            if (android.text.TextUtils.isEmpty(kk)) {
                kk = com.ss.android.socialbase.appdownloader.t.vw(vw3, wg2, kzVar.vl(), z3);
            }
            if (kk.length() > 255) {
                kk = kk.substring(kk.length() - 255);
            }
            if (android.text.TextUtils.isEmpty(wg2)) {
                wg2 = kk;
            }
            java.lang.String vl = kzVar.vl();
            if (kk.endsWith(com.anythink.china.common.a.a.g) && !com.ss.android.socialbase.appdownloader.t.t(kzVar.vl())) {
                vl = "application/vnd.android.package-archive";
            }
            java.lang.String t = kzVar.t();
            if (android.text.TextUtils.isEmpty(kzVar.t())) {
                t = com.ss.android.socialbase.appdownloader.t.wg();
            }
            java.lang.String str2 = t;
            if (!android.text.TextUtils.isEmpty(str2) && !android.text.TextUtils.isEmpty(kk)) {
                java.lang.String jb = kzVar.jb();
                if (android.text.TextUtils.isEmpty(jb)) {
                    jb = vw3;
                }
                int downloadId = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadId(jb, str2);
                if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(kzVar.ol()).optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.FIX_RESUME_TASK_OVERRIDE_SETTINGS) && (downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).getDownloadInfo(downloadId)) != null) {
                    try {
                        kzVar.vw(new org.json.JSONObject(downloadInfo.getDownloadSettingString()));
                    } catch (java.lang.Throwable unused) {
                    }
                }
                com.ss.android.socialbase.downloader.setting.DownloadSetting.addTaskDownloadSetting(downloadId, kzVar.ol());
                boolean lb = kzVar.lb();
                boolean z4 = (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadId).optInt("modify_force", 1) == 1 && !lb && com.ss.android.socialbase.downloader.utils.DownloadUtils.isFileExist(str2, kk) && com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(kzVar.getContext()).getDownloadInfo(downloadId) == null) ? true : lb;
                com.ss.android.socialbase.downloader.depend.IDownloadListener es = kzVar.es();
                if (es == null && (kzVar.yl() || kzVar.kz())) {
                    if (kzVar.cp() == null) {
                        z = z4;
                        i = downloadId;
                        str = str2;
                        es = new com.ss.android.socialbase.appdownloader.yl.wg(kzVar.getContext(), downloadId, wg2, str2, kk, kzVar.z());
                        f = kzVar.f();
                        if (f == null) {
                            f = new com.ss.android.socialbase.appdownloader.v.AnonymousClass3();
                        }
                        downloadCompleteHandlers = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadCompleteHandlers();
                        if (!downloadCompleteHandlers.isEmpty()) {
                            java.util.Iterator<com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler> it = downloadCompleteHandlers.iterator();
                            while (it.hasNext()) {
                                kzVar.vw(it.next());
                            }
                        }
                        java.lang.String z5 = kzVar.z();
                        org.json.JSONObject jSONObject = android.text.TextUtils.isEmpty(z5) ? new org.json.JSONObject(z5) : new org.json.JSONObject();
                        jSONObject.put("auto_install_with_notification", kzVar.bt());
                        jSONObject.put(com.ss.android.socialbase.downloader.constants.DownloadConstants.AUTO_INSTALL_WITHOUT_NOTIFICATION, kzVar.kz());
                        z5 = jSONObject.toString();
                        if (!kzVar.yl() && !kzVar.kz()) {
                            z2 = false;
                            if (z2 || com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_NOTIFICATION_UI) <= 0) {
                                i2 = i;
                            } else {
                                i2 = i;
                                com.ss.android.socialbase.appdownloader.yl.t.vw().vw(i2, kzVar.ip());
                            }
                            with = com.ss.android.socialbase.downloader.downloader.BaseDownloader.with(kzVar.getContext());
                            autoInstall = with.url(vw3).backUpUrls(kzVar.sh()).name(kk).title(wg2).savePath(str).onlyWifi(kzVar.o()).extraHeaders(vw2).depend(f).retryCount(kzVar.h()).backUpUrlRetryCount(kzVar.iq()).showNotification(z2).extra(z5).mimeType(vl).minProgressTimeMsInterval(kzVar.b()).maxProgressCount(kzVar.up()).mainThreadListener(kzVar.x()).notificationListener(es).notificationEventListener(vw(kzVar.a())).force(z).autoResumed(kzVar.k()).showNotificationForAutoResumed(kzVar.te()).chunkStategy(kzVar.d()).chunkAdjustCalculator(kzVar.j()).needHttpsToHttpRetry(kzVar.u()).packageName(kzVar.q()).md5(kzVar.qm()).expectFileLength(kzVar.n()).needRetryDelay(kzVar.iz()).retryDelayTimeArray(kzVar.tj()).needDefaultHttpServiceBackUp(kzVar.w()).needReuseFirstConnection(kzVar.zl()).needReuseChunkRunnable(kzVar.tv()).needIndependentProcess(kzVar.aq()).enqueueType(kzVar.ao()).monitorDepend(kzVar.mi()).retryDelayTimeCalculator(kzVar.wy()).headConnectionAvailable(kzVar.e()).fileUriProvider(kzVar.s()).diskSpaceHandler(kzVar.hp()).needChunkDowngradeRetry(kzVar.oo()).notificationClickCallback(kzVar.xs()).downloadSetting(kzVar.ol()).iconUrl(kzVar.ip()).needSDKMonitor(kzVar.m()).monitorScene(kzVar.vs()).extraMonitorStatus(kzVar.ki()).executorGroup(kzVar.ml()).throttleNetSpeed(kzVar.ih()).distinctDirectory(kzVar.ym()).taskKey(kzVar.jb()).setAutoInstall(kzVar.fu());
                            if (autoInstall != null && !kzVar.g().isEmpty()) {
                                autoInstall.setDownloadCompleteHandlers(kzVar.g());
                            }
                            if (autoInstall != null) {
                                if (!z2 || !kzVar.kn() || kzVar.getActivity() == null || kzVar.getActivity().isFinishing() || com.ss.android.socialbase.appdownloader.yl.v.vw()) {
                                    com.ss.android.socialbase.downloader.logger.Logger.d(vw, "notification permission need not request, start download :".concat(java.lang.String.valueOf(wg2)));
                                    vw(autoInstall, tq, z3);
                                    autoInstall.getDownloadInfo();
                                } else {
                                    com.ss.android.socialbase.appdownloader.yl.v.vw(kzVar.getActivity(), new com.ss.android.socialbase.appdownloader.v.AnonymousClass4(wg2, autoInstall, tq, z3));
                                }
                            }
                            return i2;
                        }
                        z2 = true;
                        if (z2) {
                        }
                        i2 = i;
                        with = com.ss.android.socialbase.downloader.downloader.BaseDownloader.with(kzVar.getContext());
                        autoInstall = with.url(vw3).backUpUrls(kzVar.sh()).name(kk).title(wg2).savePath(str).onlyWifi(kzVar.o()).extraHeaders(vw2).depend(f).retryCount(kzVar.h()).backUpUrlRetryCount(kzVar.iq()).showNotification(z2).extra(z5).mimeType(vl).minProgressTimeMsInterval(kzVar.b()).maxProgressCount(kzVar.up()).mainThreadListener(kzVar.x()).notificationListener(es).notificationEventListener(vw(kzVar.a())).force(z).autoResumed(kzVar.k()).showNotificationForAutoResumed(kzVar.te()).chunkStategy(kzVar.d()).chunkAdjustCalculator(kzVar.j()).needHttpsToHttpRetry(kzVar.u()).packageName(kzVar.q()).md5(kzVar.qm()).expectFileLength(kzVar.n()).needRetryDelay(kzVar.iz()).retryDelayTimeArray(kzVar.tj()).needDefaultHttpServiceBackUp(kzVar.w()).needReuseFirstConnection(kzVar.zl()).needReuseChunkRunnable(kzVar.tv()).needIndependentProcess(kzVar.aq()).enqueueType(kzVar.ao()).monitorDepend(kzVar.mi()).retryDelayTimeCalculator(kzVar.wy()).headConnectionAvailable(kzVar.e()).fileUriProvider(kzVar.s()).diskSpaceHandler(kzVar.hp()).needChunkDowngradeRetry(kzVar.oo()).notificationClickCallback(kzVar.xs()).downloadSetting(kzVar.ol()).iconUrl(kzVar.ip()).needSDKMonitor(kzVar.m()).monitorScene(kzVar.vs()).extraMonitorStatus(kzVar.ki()).executorGroup(kzVar.ml()).throttleNetSpeed(kzVar.ih()).distinctDirectory(kzVar.ym()).taskKey(kzVar.jb()).setAutoInstall(kzVar.fu());
                        if (autoInstall != null) {
                            autoInstall.setDownloadCompleteHandlers(kzVar.g());
                        }
                        if (autoInstall != null) {
                        }
                        return i2;
                    }
                    es = new com.ss.android.socialbase.appdownloader.yl.wg(kzVar.cp());
                }
                z = z4;
                i = downloadId;
                str = str2;
                f = kzVar.f();
                if (f == null) {
                }
                downloadCompleteHandlers = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadCompleteHandlers();
                if (!downloadCompleteHandlers.isEmpty()) {
                }
                java.lang.String z52 = kzVar.z();
                if (android.text.TextUtils.isEmpty(z52)) {
                }
                jSONObject.put("auto_install_with_notification", kzVar.bt());
                jSONObject.put(com.ss.android.socialbase.downloader.constants.DownloadConstants.AUTO_INSTALL_WITHOUT_NOTIFICATION, kzVar.kz());
                z52 = jSONObject.toString();
                if (!kzVar.yl()) {
                    z2 = false;
                    if (z2) {
                    }
                    i2 = i;
                    with = com.ss.android.socialbase.downloader.downloader.BaseDownloader.with(kzVar.getContext());
                    autoInstall = with.url(vw3).backUpUrls(kzVar.sh()).name(kk).title(wg2).savePath(str).onlyWifi(kzVar.o()).extraHeaders(vw2).depend(f).retryCount(kzVar.h()).backUpUrlRetryCount(kzVar.iq()).showNotification(z2).extra(z52).mimeType(vl).minProgressTimeMsInterval(kzVar.b()).maxProgressCount(kzVar.up()).mainThreadListener(kzVar.x()).notificationListener(es).notificationEventListener(vw(kzVar.a())).force(z).autoResumed(kzVar.k()).showNotificationForAutoResumed(kzVar.te()).chunkStategy(kzVar.d()).chunkAdjustCalculator(kzVar.j()).needHttpsToHttpRetry(kzVar.u()).packageName(kzVar.q()).md5(kzVar.qm()).expectFileLength(kzVar.n()).needRetryDelay(kzVar.iz()).retryDelayTimeArray(kzVar.tj()).needDefaultHttpServiceBackUp(kzVar.w()).needReuseFirstConnection(kzVar.zl()).needReuseChunkRunnable(kzVar.tv()).needIndependentProcess(kzVar.aq()).enqueueType(kzVar.ao()).monitorDepend(kzVar.mi()).retryDelayTimeCalculator(kzVar.wy()).headConnectionAvailable(kzVar.e()).fileUriProvider(kzVar.s()).diskSpaceHandler(kzVar.hp()).needChunkDowngradeRetry(kzVar.oo()).notificationClickCallback(kzVar.xs()).downloadSetting(kzVar.ol()).iconUrl(kzVar.ip()).needSDKMonitor(kzVar.m()).monitorScene(kzVar.vs()).extraMonitorStatus(kzVar.ki()).executorGroup(kzVar.ml()).throttleNetSpeed(kzVar.ih()).distinctDirectory(kzVar.ym()).taskKey(kzVar.jb()).setAutoInstall(kzVar.fu());
                    if (autoInstall != null) {
                    }
                    if (autoInstall != null) {
                    }
                    return i2;
                }
                z2 = true;
                if (z2) {
                }
                i2 = i;
                with = com.ss.android.socialbase.downloader.downloader.BaseDownloader.with(kzVar.getContext());
                autoInstall = with.url(vw3).backUpUrls(kzVar.sh()).name(kk).title(wg2).savePath(str).onlyWifi(kzVar.o()).extraHeaders(vw2).depend(f).retryCount(kzVar.h()).backUpUrlRetryCount(kzVar.iq()).showNotification(z2).extra(z52).mimeType(vl).minProgressTimeMsInterval(kzVar.b()).maxProgressCount(kzVar.up()).mainThreadListener(kzVar.x()).notificationListener(es).notificationEventListener(vw(kzVar.a())).force(z).autoResumed(kzVar.k()).showNotificationForAutoResumed(kzVar.te()).chunkStategy(kzVar.d()).chunkAdjustCalculator(kzVar.j()).needHttpsToHttpRetry(kzVar.u()).packageName(kzVar.q()).md5(kzVar.qm()).expectFileLength(kzVar.n()).needRetryDelay(kzVar.iz()).retryDelayTimeArray(kzVar.tj()).needDefaultHttpServiceBackUp(kzVar.w()).needReuseFirstConnection(kzVar.zl()).needReuseChunkRunnable(kzVar.tv()).needIndependentProcess(kzVar.aq()).enqueueType(kzVar.ao()).monitorDepend(kzVar.mi()).retryDelayTimeCalculator(kzVar.wy()).headConnectionAvailable(kzVar.e()).fileUriProvider(kzVar.s()).diskSpaceHandler(kzVar.hp()).needChunkDowngradeRetry(kzVar.oo()).notificationClickCallback(kzVar.xs()).downloadSetting(kzVar.ol()).iconUrl(kzVar.ip()).needSDKMonitor(kzVar.m()).monitorScene(kzVar.vs()).extraMonitorStatus(kzVar.ki()).executorGroup(kzVar.ml()).throttleNetSpeed(kzVar.ih()).distinctDirectory(kzVar.ym()).taskKey(kzVar.jb()).setAutoInstall(kzVar.fu());
                if (autoInstall != null) {
                }
                if (autoInstall != null) {
                }
                return i2;
            }
            return 0;
        } catch (java.lang.Throwable th) {
            com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorSendWithTaskMonitor(kzVar.mi(), null, new com.ss.android.socialbase.downloader.exception.BaseException(1003, com.ss.android.socialbase.downloader.utils.DownloadUtils.getErrorMsgWithTagPrefix(th, "addDownloadTask")), 0);
            com.ss.android.socialbase.downloader.logger.Logger.e(vw, java.lang.String.format("add download task error:%s", th));
            return 0;
        }
    }

    public com.ss.android.socialbase.appdownloader.t.t vw() {
        return this.vl;
    }

    public com.ss.android.socialbase.downloader.model.DownloadInfo vw(android.content.Context context, java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && context != null) {
            try {
                com.ss.android.socialbase.downloader.model.DownloadInfo vw2 = vw(context, str, o());
                if (vw2 == null) {
                    vw2 = vw(context, str, context.getExternalFilesDir(android.os.Environment.DIRECTORY_DOWNLOADS));
                }
                if (vw2 == null) {
                    vw2 = vw(context, str, android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DOWNLOADS));
                }
                if (vw2 == null) {
                    vw2 = vw(context, str, context.getFilesDir());
                }
                return (vw2 == null && com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.BUGFIX_GET_DOWNLOAD_INFO_BY_LIST)) ? wg(context, str) : vw2;
            } catch (java.lang.Throwable th) {
                com.ss.android.socialbase.downloader.logger.Logger.d(vw, java.lang.String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    public java.lang.String vw(java.lang.String str, java.lang.String str2) {
        return (android.text.TextUtils.isEmpty(str) || !str.endsWith(com.anythink.china.common.a.a.g) || com.ss.android.socialbase.appdownloader.t.t(str2)) ? str2 : "application/vnd.android.package-archive";
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> vw(android.content.Context context) {
        return com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    public void vw(android.content.Context context, int i, int i2) {
        try {
            switch (i2) {
                case -4:
                case -1:
                    com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).restart(i);
                    break;
                case -3:
                    com.ss.android.socialbase.appdownloader.t.vw(context, i, true);
                    break;
                case -2:
                    com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).resume(i);
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).pause(i);
                    break;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @java.lang.Deprecated
    public void vw(android.content.Context context, java.lang.String str, com.ss.android.socialbase.appdownloader.t.t tVar, com.ss.android.socialbase.appdownloader.t.v vVar, com.ss.android.socialbase.appdownloader.t.o oVar) {
        if (tVar != null) {
            this.vl = tVar;
        }
        if (vVar != null) {
            this.u = vVar;
        }
        if (oVar != null) {
            this.cp = oVar;
        }
        t(context);
    }

    public void vw(com.ss.android.socialbase.appdownloader.t.bt btVar) {
        this.d = btVar;
    }

    public void vw(com.ss.android.socialbase.appdownloader.t.es esVar) {
        this.te = esVar;
    }

    public void vw(com.ss.android.socialbase.downloader.depend.IInstallAppHandler iInstallAppHandler) {
        this.tq = iInstallAppHandler;
    }

    public void vw(com.ss.android.socialbase.downloader.depend.IOpenInstallerListener iOpenInstallerListener) {
        this.q = iOpenInstallerListener;
    }

    public void vw(com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener iReserveWifiStatusListener) {
        com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).setReserveWifiStatusListener(iReserveWifiStatusListener);
    }

    public void vw(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.v = str;
    }

    public com.ss.android.socialbase.appdownloader.t.v wg() {
        return this.u;
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> wg(android.content.Context context) {
        return com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    public void wg(java.lang.String str) {
        com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).setDefaultSavePath(str);
    }

    public java.lang.String x() {
        return this.t;
    }

    public com.ss.android.socialbase.appdownloader.t.kz yl() {
        return this.k;
    }

    public void z() {
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optInt("enable_app_install_receiver", 1) <= 0) {
            com.ss.android.socialbase.downloader.logger.Logger.d(vw, "disable app install receiver");
            return;
        }
        synchronized (this.yl) {
            try {
                if (o) {
                    return;
                }
                try {
                    android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                    intentFilter.addDataScheme("package");
                    com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().registerReceiver(this.yl, intentFilter);
                    o = true;
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                com.ss.android.socialbase.downloader.logger.Logger.d(vw, "tryRegisterTempAppInstallDownloadReceiver mIsAppInstallRegistered:" + bt);
            } finally {
                q();
            }
        }
    }
}
