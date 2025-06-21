package com.ss.android.socialbase.appdownloader.view;

/* loaded from: classes19.dex */
public class DownloadTaskDeleteActivity extends android.app.Activity {
    private com.ss.android.socialbase.appdownloader.t.z vw;
    private android.content.Intent wg;

    /* renamed from: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.DialogInterface.OnCancelListener {
        public AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(android.content.DialogInterface dialogInterface) {
            com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.this.finish();
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ int t;
        final /* synthetic */ boolean vw;
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo wg;

        public AnonymousClass2(boolean z, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, int i) {
            this.vw = z;
            this.wg = downloadInfo;
            this.t = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            if (this.vw) {
                com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.this.vw(this.wg, this.t);
            }
            com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.this.finish();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ int t;
        final /* synthetic */ boolean vw;
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo wg;

        /* renamed from: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.this).resume(com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.AnonymousClass3.this.wg.getId());
            }
        }

        public AnonymousClass3(boolean z, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, int i) {
            this.vw = z;
            this.wg = downloadInfo;
            this.t = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            if (this.vw) {
                this.wg.setOnlyWifi(true);
                com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.this).pause(this.wg.getId());
                new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.AnonymousClass3.AnonymousClass1(), 100L);
            } else {
                com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.this.vw(this.wg, this.t);
            }
            com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.this.finish();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    private void vw() {
        android.view.Window window = getWindow();
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, int i) {
        com.ss.android.socialbase.appdownloader.t.v wg = com.ss.android.socialbase.appdownloader.v.es().wg();
        if (wg != null) {
            wg.vw(downloadInfo);
        }
        com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener downloadNotificationEventListener = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).getDownloadNotificationEventListener(i);
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.onNotificationEvent(10, downloadInfo, "", "");
        }
        if (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext() != null) {
            com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).cancel(i);
        }
    }

    private void wg() {
        android.content.Intent intent;
        if (this.vw != null || (intent = this.wg) == null) {
            return;
        }
        try {
            boolean z = false;
            int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(getApplicationContext()).getDownloadInfo(intExtra);
            if (downloadInfo == null) {
                return;
            }
            java.lang.String title = downloadInfo.getTitle();
            if (android.text.TextUtils.isEmpty(title)) {
                return;
            }
            java.lang.String format = java.lang.String.format(getString(com.ss.android.socialbase.appdownloader.x.vw(this, "tt_appdownloader_notification_download_delete")), title);
            com.ss.android.socialbase.appdownloader.t.t vw = com.ss.android.socialbase.appdownloader.v.es().vw();
            com.ss.android.socialbase.appdownloader.t.vl vw2 = vw != null ? vw.vw(this) : null;
            if (vw2 == null) {
                vw2 = new com.ss.android.socialbase.appdownloader.v.vw(this);
            }
            int vw3 = com.ss.android.socialbase.appdownloader.x.vw(this, "tt_appdownloader_tip");
            int vw4 = com.ss.android.socialbase.appdownloader.x.vw(this, "tt_appdownloader_label_ok");
            int vw5 = com.ss.android.socialbase.appdownloader.x.vw(this, "tt_appdownloader_label_cancel");
            if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.CANCEL_WITH_NET_OPT, 0) == 1 && com.ss.android.socialbase.downloader.utils.DownloadUtils.isNoWifiAndInNet() && downloadInfo.getCurBytes() != downloadInfo.getTotalBytes()) {
                z = true;
            }
            if (z) {
                vw4 = com.ss.android.socialbase.appdownloader.x.vw(this, "tt_appdownloader_label_reserve_wifi");
                vw5 = com.ss.android.socialbase.appdownloader.x.vw(this, "tt_appdownloader_label_cancel_directly");
                format = getResources().getString(com.ss.android.socialbase.appdownloader.x.vw(this, "tt_appdownloader_resume_in_wifi"));
            }
            vw2.vw(vw3).vw(format).vw(vw4, new com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.AnonymousClass3(z, downloadInfo, intExtra)).wg(vw5, new com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.AnonymousClass2(z, downloadInfo, intExtra)).vw(new com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.AnonymousClass1());
            this.vw = vw2.vw();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        vw();
    }

    @Override // android.app.Activity
    public void onNewIntent(android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.wg = getIntent();
        wg();
        com.ss.android.socialbase.appdownloader.t.z zVar = this.vw;
        if (zVar != null && !zVar.wg()) {
            this.vw.vw();
        } else if (this.vw == null) {
            finish();
        }
    }
}
