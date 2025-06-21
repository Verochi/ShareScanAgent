package com.bytedance.sdk.openadsdk.downloadnew;

/* loaded from: classes31.dex */
public class t {
    private static final com.ss.android.download.api.download.vw.vw bt;
    private static java.util.Map<java.lang.Integer, com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter.OnEventLogHandler> kz;
    public static com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor t;
    public static volatile java.lang.String vw;
    private static android.content.Context yl;
    private static final java.util.concurrent.atomic.AtomicBoolean v = new java.util.concurrent.atomic.AtomicBoolean(false);
    public static boolean wg = true;

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.t$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static class AnonymousClass1 implements com.ss.android.download.api.config.k {
        @Override // com.ss.android.download.api.config.k
        public byte[] vw(byte[] bArr, int i) {
            return new byte[0];
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.t$2, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static class AnonymousClass2 implements com.ss.android.download.api.config.wg {
        @Override // com.ss.android.download.api.config.wg
        public boolean vw() {
            if (com.bytedance.sdk.openadsdk.downloadnew.t.yl() != null) {
                return com.bytedance.sdk.openadsdk.downloadnew.t.yl().getAppIsBackground();
            }
            return false;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.t$3, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static class AnonymousClass3 implements com.ss.android.download.api.config.es {
        @Override // com.ss.android.download.api.config.es
        public org.json.JSONObject vw() {
            return com.bytedance.sdk.openadsdk.downloadnew.t.yl() != null ? com.bytedance.sdk.openadsdk.downloadnew.t.yl().getDownloadSettings() : new org.json.JSONObject();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.t$4, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static class AnonymousClass4 implements com.ss.android.socialbase.downloader.depend.IInstallAppHandler {
        @Override // com.ss.android.socialbase.downloader.depend.IInstallAppHandler
        public boolean installApp(android.content.Intent intent) {
            return false;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.t$5, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static class AnonymousClass5 implements com.ss.android.socialbase.downloader.depend.IDownloadSettings {
        @Override // com.ss.android.socialbase.downloader.depend.IDownloadSettings
        public org.json.JSONObject get() {
            return com.bytedance.sdk.openadsdk.downloadnew.t.yl() != null ? com.bytedance.sdk.openadsdk.downloadnew.t.yl().getDownloadSettings() : new org.json.JSONObject();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.t$6, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static class AnonymousClass6 implements com.ss.android.download.api.download.vw.vw {
        @Override // com.ss.android.download.api.download.vw.vw
        public void vw(com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig) {
            com.bytedance.sdk.openadsdk.api.t.wg("TTDownloadVisitor", "completeListener: onDownloadStart");
        }

        @Override // com.ss.android.download.api.download.vw.vw
        public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            com.bytedance.sdk.openadsdk.api.t.wg("TTDownloadVisitor", "completeListener: onCanceled");
        }

        @Override // com.ss.android.download.api.download.vw.vw
        public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException, java.lang.String str) {
            com.bytedance.sdk.openadsdk.api.t.wg("TTDownloadVisitor", "completeListener: onDownloadFailed");
        }

        @Override // com.ss.android.download.api.download.vw.vw
        public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str) {
            com.bytedance.sdk.openadsdk.api.t.wg("TTDownloadVisitor", "completeListener: onDownloadFinished");
        }

        @Override // com.ss.android.download.api.download.vw.vw
        public void wg(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str) {
            com.bytedance.sdk.openadsdk.api.t.wg("TTDownloadVisitor", "completeListener: onInstalled");
            com.bytedance.sdk.openadsdk.downloadnew.t.t(str);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.t$7, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static class AnonymousClass7 implements com.ss.android.downloadlib.addownload.vw.vw.InterfaceC0470vw {
        final /* synthetic */ com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener vw;

        public AnonymousClass7(com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener exitInstallListener) {
            this.vw = exitInstallListener;
        }

        @Override // com.ss.android.downloadlib.addownload.vw.vw.InterfaceC0470vw
        public void vw() {
            com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener exitInstallListener = this.vw;
            if (exitInstallListener != null) {
                exitInstallListener.onExitInstall();
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.t$t, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C0276t implements com.ss.android.download.api.config.x {

        /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.t$t$1, reason: invalid class name */
        public class AnonymousClass1 implements com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback {
            final /* synthetic */ com.ss.android.download.api.config.q vw;

            public AnonymousClass1(com.ss.android.download.api.config.q qVar) {
                this.vw = qVar;
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
            public void onDenied(java.lang.String str) {
                com.ss.android.download.api.config.q qVar = this.vw;
                if (qVar != null) {
                    qVar.vw(str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
            public void onGranted() {
                com.ss.android.download.api.config.q qVar = this.vw;
                if (qVar != null) {
                    qVar.vw();
                }
            }
        }

        @Override // com.ss.android.download.api.config.x
        public void vw(android.app.Activity activity, int i, java.lang.String[] strArr, int[] iArr) {
        }

        @Override // com.ss.android.download.api.config.x
        public void vw(android.app.Activity activity, java.lang.String[] strArr, com.ss.android.download.api.config.q qVar) {
            if (com.bytedance.sdk.openadsdk.downloadnew.t.yl() != null) {
                com.bytedance.sdk.openadsdk.downloadnew.t.yl().requestPermission(activity, strArr, new com.bytedance.sdk.openadsdk.downloadnew.t.C0276t.AnonymousClass1(qVar));
            }
        }

        @Override // com.ss.android.download.api.config.x
        public boolean vw(android.content.Context context, java.lang.String str) {
            if (com.bytedance.sdk.openadsdk.downloadnew.t.yl() != null) {
                return com.bytedance.sdk.openadsdk.downloadnew.t.yl().hasPermission(context, str);
            }
            return false;
        }
    }

    /* loaded from: classes22.dex */
    public static class v implements com.ss.android.download.api.config.vl {
        private final java.lang.ref.WeakReference<android.content.Context> vw;

        /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.t$v$1, reason: invalid class name */
        public class AnonymousClass1 implements com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener {
            final /* synthetic */ com.ss.android.download.api.model.wg vw;

            public AnonymousClass1(com.ss.android.download.api.model.wg wgVar) {
                this.vw = wgVar;
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
            public void onCancel(android.content.DialogInterface dialogInterface) {
                com.ss.android.download.api.model.wg.InterfaceC0468wg interfaceC0468wg = this.vw.o;
                if (interfaceC0468wg != null) {
                    interfaceC0468wg.t(dialogInterface);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
            public void onNegativeBtnClick(android.content.DialogInterface dialogInterface) {
                com.ss.android.download.api.model.wg.InterfaceC0468wg interfaceC0468wg = this.vw.o;
                if (interfaceC0468wg != null) {
                    try {
                        interfaceC0468wg.wg(dialogInterface);
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
            public void onPositiveBtnClick(android.content.DialogInterface dialogInterface) {
                com.ss.android.download.api.model.wg.InterfaceC0468wg interfaceC0468wg = this.vw.o;
                if (interfaceC0468wg != null) {
                    interfaceC0468wg.vw(dialogInterface);
                }
            }
        }

        public v(android.content.Context context) {
            this.vw = new java.lang.ref.WeakReference<>(context);
        }

        private com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder t(com.ss.android.download.api.model.wg wgVar) {
            return com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder.builder().setTitle(wgVar.wg).setMessage(wgVar.t).setNegativeBtnText(wgVar.yl).setPositiveBtnText(wgVar.v).setIcon(wgVar.bt).setDialogStatusChangedListener(new com.bytedance.sdk.openadsdk.downloadnew.t.v.AnonymousClass1(wgVar));
        }

        @Override // com.ss.android.download.api.config.vl
        /* renamed from: vw, reason: merged with bridge method [inline-methods] */
        public android.app.AlertDialog wg(com.ss.android.download.api.model.wg wgVar) {
            if (wgVar != null && com.bytedance.sdk.openadsdk.downloadnew.t.yl() != null) {
                android.content.Context context = wgVar.vw;
                if (context != null && (context instanceof android.app.Activity)) {
                    return com.bytedance.sdk.openadsdk.downloadnew.t.yl().showDialogBySelf((android.app.Activity) wgVar.vw, wgVar.es == 1, t(wgVar));
                }
                com.bytedance.sdk.openadsdk.downloadnew.t.yl().showDialogByDelegate(this.vw, wgVar.es == 1, t(wgVar));
            }
            return null;
        }

        @Override // com.ss.android.download.api.config.vl
        public void vw(int i, android.content.Context context, com.ss.android.download.api.download.DownloadModel downloadModel, java.lang.String str, android.graphics.drawable.Drawable drawable, int i2) {
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                android.widget.Toast.makeText(context, str, 0).show();
            } catch (java.lang.Exception e) {
                com.ss.android.socialbase.downloader.logger.Logger.e("LibUIFactory", "showToastWithDuration e " + e.getMessage());
            }
        }
    }

    /* loaded from: classes22.dex */
    public static class vw implements com.ss.android.download.api.config.bt {
        private void t(com.ss.android.download.api.model.t tVar) {
            if (tVar == null) {
                return;
            }
            java.lang.Object vl = tVar.vl();
            com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel label = com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel.builder().setTag(tVar.wg()).setExtJson(tVar.o()).setMaterialMeta(vl instanceof org.json.JSONObject ? (org.json.JSONObject) vl : null).setLabel(tVar.t());
            boolean z = "download_notification".equals(tVar.wg()) || "landing_h5_download_ad_button".equals(tVar.wg());
            if (com.bytedance.sdk.openadsdk.downloadnew.t.yl() != null) {
                com.bytedance.sdk.openadsdk.downloadnew.t.yl().executeLogUpload(label, z);
            }
        }

        private void vw(com.ss.android.download.api.model.t tVar, boolean z) {
            com.bytedance.sdk.openadsdk.TTDownloadEventLogger tTDownloadEventLogger;
            if (com.bytedance.sdk.openadsdk.downloadnew.t.yl() == null || (tTDownloadEventLogger = com.bytedance.sdk.openadsdk.downloadnew.t.yl().getTTDownloadEventLogger()) == null || tVar == null) {
                return;
            }
            if (tTDownloadEventLogger.shouldFilterOpenSdkLog() && com.bytedance.sdk.openadsdk.downloadnew.t.yl().isOpenSdkEvent(tVar.toString())) {
                return;
            }
            if (z) {
                tTDownloadEventLogger.onV3Event(com.bytedance.sdk.openadsdk.downloadnew.t.wg(tVar));
            } else {
                tTDownloadEventLogger.onEvent(com.bytedance.sdk.openadsdk.downloadnew.t.wg(tVar));
            }
        }

        @Override // com.ss.android.download.api.config.bt
        public void vw(com.ss.android.download.api.model.t tVar) {
            com.bytedance.sdk.openadsdk.api.t.wg("LibEventLogger", "onV3Event");
            vw(tVar, true);
        }

        @Override // com.ss.android.download.api.config.bt
        public void wg(com.ss.android.download.api.model.t tVar) {
            com.bytedance.sdk.openadsdk.api.t.wg("LibEventLogger", "onEvent called");
            vw(tVar, false);
            t(tVar);
        }
    }

    /* loaded from: classes22.dex */
    public static class wg implements com.ss.android.download.api.config.o {

        /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.t$wg$1, reason: invalid class name */
        public class AnonymousClass1 implements com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback {
            final /* synthetic */ com.ss.android.download.api.config.te vw;

            public AnonymousClass1(com.ss.android.download.api.config.te teVar) {
                this.vw = teVar;
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
            public void onError(java.lang.Throwable th) {
                com.ss.android.download.api.config.te teVar = this.vw;
                if (teVar != null) {
                    teVar.vw(th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
            public void onResponse(java.lang.String str) {
                com.ss.android.download.api.config.te teVar = this.vw;
                if (teVar != null) {
                    teVar.vw(str);
                }
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.t$wg$2, reason: invalid class name */
        public class AnonymousClass2 implements com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback {
            final /* synthetic */ com.ss.android.download.api.config.te vw;

            public AnonymousClass2(com.ss.android.download.api.config.te teVar) {
                this.vw = teVar;
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
            public void onError(java.lang.Throwable th) {
                com.ss.android.download.api.config.te teVar = this.vw;
                if (teVar != null) {
                    teVar.vw(th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
            public void onResponse(java.lang.String str) {
                com.ss.android.download.api.config.te teVar = this.vw;
                if (teVar != null) {
                    teVar.vw(str);
                }
            }
        }

        private wg() {
        }

        public /* synthetic */ wg(com.bytedance.sdk.openadsdk.downloadnew.t.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.ss.android.download.api.config.o
        public void vw(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map, com.ss.android.download.api.config.te teVar) {
            str.hashCode();
            int i = 0;
            if (!str.equals("GET") && str.equals("POST")) {
                i = 1;
            }
            if (com.bytedance.sdk.openadsdk.downloadnew.t.yl() != null) {
                com.bytedance.sdk.openadsdk.downloadnew.t.yl().execute(i, str2, map, new com.bytedance.sdk.openadsdk.downloadnew.t.wg.AnonymousClass1(teVar));
            }
        }

        @Override // com.ss.android.download.api.config.o
        public void vw(java.lang.String str, byte[] bArr, java.lang.String str2, int i, com.ss.android.download.api.config.te teVar) {
            if (com.bytedance.sdk.openadsdk.downloadnew.t.yl() != null) {
                com.bytedance.sdk.openadsdk.downloadnew.t.yl().postBody(str, bArr, str2, new com.bytedance.sdk.openadsdk.downloadnew.t.wg.AnonymousClass2(teVar));
            }
        }
    }

    /* loaded from: classes22.dex */
    public static class yl implements com.ss.android.socialbase.downloader.network.IDownloadHttpService {

        /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.t$yl$1, reason: invalid class name */
        public class AnonymousClass1 implements com.ss.android.socialbase.downloader.network.IDownloadHttpConnection {
            final /* synthetic */ com.bytedance.sdk.openadsdk.downloadnew.wg.vw vw;

            public AnonymousClass1(com.bytedance.sdk.openadsdk.downloadnew.wg.vw vwVar) {
                this.vw = vwVar;
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
            public void cancel() {
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
            public void end() {
                try {
                    this.vw.v.disconnect();
                } catch (java.lang.Exception unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
            public java.io.InputStream getInputStream() {
                return this.vw.vw;
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
            public int getResponseCode() {
                return this.vw.t;
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
            public java.lang.String getResponseHeaderField(java.lang.String str) {
                java.util.Map<java.lang.String, java.lang.String> map = this.vw.wg;
                if (map != null) {
                    return map.get(str);
                }
                return null;
            }
        }

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
        public com.ss.android.socialbase.downloader.network.IDownloadHttpConnection downloadWithConnection(int i, java.lang.String str, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list) throws java.io.IOException {
            com.bytedance.sdk.openadsdk.downloadnew.wg.vw vw = com.bytedance.sdk.openadsdk.downloadnew.wg.vw(str, list);
            if (vw != null) {
                return new com.bytedance.sdk.openadsdk.downloadnew.t.yl.AnonymousClass1(vw);
            }
            return null;
        }
    }

    static {
        try {
            vw = getContext().getExternalFilesDir(android.os.Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (java.lang.Throwable unused) {
        }
        bt = new com.bytedance.sdk.openadsdk.downloadnew.t.AnonymousClass6();
    }

    private static android.content.Context getContext() {
        android.content.Context context = yl;
        return context == null ? com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext() : context;
    }

    private static boolean kz() {
        return false;
    }

    public static java.util.Map<java.lang.Integer, com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter.OnEventLogHandler> t() {
        return kz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t(java.lang.String str) {
        com.ss.android.downloadad.api.vw.wg vw2;
        org.json.JSONObject bt2;
        if (android.text.TextUtils.isEmpty(str) || (vw2 = com.ss.android.downloadlib.addownload.wg.kz.vw().vw(str)) == null || (bt2 = vw2.bt()) == null || yl() == null) {
            return;
        }
        yl().checkAutoControl(bt2, str);
    }

    public static com.ss.android.downloadlib.o vw() {
        vw(getContext());
        return com.ss.android.downloadlib.o.vw(getContext());
    }

    private static com.ss.android.socialbase.downloader.downloader.DownloaderBuilder vw(android.content.Context context, org.json.JSONObject jSONObject) {
        return new com.ss.android.socialbase.downloader.downloader.DownloaderBuilder(context).downloadSetting(new com.bytedance.sdk.openadsdk.downloadnew.t.AnonymousClass5()).downloadExpSwitch(jSONObject.optInt("download_exp_switch_temp", 1040187391)).httpService(new com.bytedance.sdk.openadsdk.downloadnew.t.yl());
    }

    public static void vw(int i) {
        java.util.Map<java.lang.Integer, com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter.OnEventLogHandler> map = kz;
        if (map != null) {
            map.remove(java.lang.Integer.valueOf(i));
        }
    }

    public static void vw(int i, com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter.OnEventLogHandler onEventLogHandler) {
        if (onEventLogHandler != null) {
            if (kz == null) {
                kz = java.util.Collections.synchronizedMap(new java.util.WeakHashMap());
            }
            kz.put(java.lang.Integer.valueOf(i), onEventLogHandler);
        }
    }

    public static void vw(android.content.Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext();
        }
        if (context == null) {
            return;
        }
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean = v;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (com.bytedance.sdk.openadsdk.downloadnew.t.class) {
            if (!atomicBoolean.get()) {
                yl = context.getApplicationContext();
                if (yl() != null) {
                    java.lang.String initPath = yl().initPath(wg);
                    if (!android.text.TextUtils.isEmpty(initPath)) {
                        vw = initPath;
                    }
                }
                atomicBoolean.set(wg(yl));
            }
        }
    }

    public static void vw(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        vw = str;
    }

    public static boolean vw(android.app.Activity activity, com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener exitInstallListener) {
        return com.ss.android.downloadlib.addownload.vw.vw.vw().vw(activity, false, new com.bytedance.sdk.openadsdk.downloadnew.t.AnonymousClass7(exitInstallListener));
    }

    public static boolean vw(android.content.Context context, android.net.Uri uri, com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController) {
        return vw().yl().vw(context, uri, downloadModel, downloadEventConfig, downloadController);
    }

    public static boolean vw(android.content.Context context, android.net.Uri uri, com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.config.IDownloadButtonClickListener iDownloadButtonClickListener) {
        return vw().yl().vw(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener);
    }

    public static boolean vw(android.content.Context context, java.lang.String str) {
        if (context != null && !android.text.TextUtils.isEmpty(str)) {
            java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> wg2 = com.ss.android.socialbase.appdownloader.v.es().wg(context);
            if (!wg2.isEmpty()) {
                for (com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo : wg2) {
                    if (downloadInfo != null && str.equals(downloadInfo.getUrl())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean vw(android.net.Uri uri) {
        return com.ss.android.downloadlib.wg.es.vw(uri);
    }

    public static boolean vw(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject, java.lang.Object obj) {
        java.util.Map<java.lang.Integer, com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter.OnEventLogHandler> t2;
        boolean z = false;
        if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2) && jSONObject != null && (t2 = t()) != null) {
            for (java.util.Map.Entry<java.lang.Integer, com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter.OnEventLogHandler> entry : t2.entrySet()) {
                int intValue = entry.getKey().intValue();
                com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter.OnEventLogHandler value = entry.getValue();
                if (value != null) {
                    boolean onEventLog = value.onEventLog(intValue, jSONObject.toString(), str, str2, obj);
                    if (!z && !onEventLog) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static org.json.JSONObject wg(com.ss.android.download.api.model.t tVar) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("category", tVar.vw());
            jSONObject.put("tag", tVar.wg());
            jSONObject.put("label", tVar.t());
            jSONObject.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_IS_AD, tVar.v());
            jSONObject.put("adId", tVar.yl());
            jSONObject.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_LOG_EXTRA, tVar.kz());
            jSONObject.put("extValue", tVar.bt());
            jSONObject.put("extJson", tVar.o());
            jSONObject.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_PARAMS_JSON, tVar.x());
            jSONObject.put("eventSource", tVar.z());
            jSONObject.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_EXTRA_OBJECT, tVar.vl());
            jSONObject.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_CLICK_TRACK_URL, tVar.es());
            jSONObject.put("isV3", tVar.u());
            jSONObject.put("V3EventName", tVar.cp());
            jSONObject.put("V3EventParams", tVar.d());
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static void wg() {
        vw().bt();
        if (yl() != null) {
            yl().clearAllData(vw);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean wg(android.content.Context context) {
        com.ss.android.download.api.vw vw2;
        if (context == null) {
            return false;
        }
        android.content.Context applicationContext = context.getApplicationContext();
        java.lang.String packageName = applicationContext.getPackageName();
        if (android.text.TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        if (kz()) {
            try {
                vw2 = com.ss.android.downloadlib.o.vw(applicationContext).vw("pangolin");
            } catch (java.lang.Throwable unused) {
            }
            if (vw2 != null) {
                return false;
            }
            vw2.vw(new com.bytedance.sdk.openadsdk.downloadnew.t.C0276t()).vw(new com.bytedance.sdk.openadsdk.downloadnew.t.vw()).vw(new com.bytedance.sdk.openadsdk.downloadnew.t.v(applicationContext)).vw(new com.bytedance.sdk.openadsdk.downloadnew.t.wg(null)).vw(new com.bytedance.sdk.openadsdk.downloadnew.t.AnonymousClass3()).vw(new com.bytedance.sdk.openadsdk.downloadnew.t.AnonymousClass2()).vw(new com.ss.android.download.api.model.vw.C0467vw().wg("143").vw("open_news").t("6.2.1.9").v("6219").vw()).vw(new com.bytedance.sdk.openadsdk.downloadnew.t.AnonymousClass1()).vw(packageName + ".TTFileProvider").vw(vw(applicationContext, yl() != null ? yl().getDownloadSettings() : new org.json.JSONObject())).vw();
            com.ss.android.downloadlib.bt.vw.vw();
            com.ss.android.downloadlib.o.vw(applicationContext).v().vw(1);
            com.ss.android.downloadlib.o.vw(applicationContext).vw(bt);
            com.ss.android.socialbase.appdownloader.v.es().vw(new com.bytedance.sdk.openadsdk.downloadnew.t.AnonymousClass4());
            com.bytedance.sdk.openadsdk.TTDownloadEventLogger tTDownloadEventLogger = yl() != null ? yl().getTTDownloadEventLogger() : null;
            if (tTDownloadEventLogger != null) {
                tTDownloadEventLogger.onDownloadConfigReady();
            }
            return true;
        }
        vw2 = com.ss.android.downloadlib.o.vw(applicationContext).vw();
        if (vw2 != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor yl() {
        com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor iTTDownloadVisitor = t;
        if (iTTDownloadVisitor != null) {
            return iTTDownloadVisitor;
        }
        com.bytedance.sdk.openadsdk.TTAdManager adManager = com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager();
        if (adManager == null) {
            return null;
        }
        return (com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor) adManager.getExtra(com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor.class, com.bytedance.sdk.openadsdk.downloadnew.vw.vw(1));
    }
}
