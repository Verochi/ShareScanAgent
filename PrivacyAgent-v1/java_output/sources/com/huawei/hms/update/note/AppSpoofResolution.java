package com.huawei.hms.update.note;

/* loaded from: classes22.dex */
public class AppSpoofResolution implements com.huawei.hms.activity.IBridgeActivityDelegate {
    public android.app.Activity a;
    public com.huawei.hms.update.note.AppSpoofResolution.b b;

    public class a implements com.huawei.hms.ui.AbstractDialog.Callback {
        public a() {
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onCancel(com.huawei.hms.ui.AbstractDialog abstractDialog) {
            com.huawei.hms.availableupdate.b.c.a(true);
            com.huawei.hms.update.note.AppSpoofResolution.this.b = null;
            com.huawei.hms.update.note.AppSpoofResolution.this.a();
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onDoWork(com.huawei.hms.ui.AbstractDialog abstractDialog) {
            com.huawei.hms.availableupdate.b.c.a(true);
            com.huawei.hms.update.note.AppSpoofResolution.this.b = null;
            com.huawei.hms.update.note.AppSpoofResolution.this.a();
        }
    }

    public static class b extends com.huawei.hms.ui.AbstractPromptDialog {
        public b() {
        }

        public /* synthetic */ b(com.huawei.hms.update.note.AppSpoofResolution.a aVar) {
            this();
        }

        @Override // com.huawei.hms.ui.AbstractDialog
        public java.lang.String onGetMessageString(android.content.Context context) {
            java.lang.String applicationName = new com.huawei.hms.utils.PackageManagerHelper(context).getApplicationName("com.huawei.hwid");
            java.lang.String str = android.text.TextUtils.isEmpty(applicationName) ? "com.huawei.hwid" : applicationName;
            if (com.huawei.hms.utils.ResourceLoaderUtil.getmContext() == null) {
                com.huawei.hms.utils.ResourceLoaderUtil.setmContext(context);
            }
            return com.huawei.hms.utils.ResourceLoaderUtil.getString("hms_is_spoof", str);
        }

        @Override // com.huawei.hms.ui.AbstractDialog
        public java.lang.String onGetPositiveButtonString(android.content.Context context) {
            if (com.huawei.hms.utils.ResourceLoaderUtil.getmContext() == null) {
                com.huawei.hms.utils.ResourceLoaderUtil.setmContext(context);
            }
            return com.huawei.hms.utils.ResourceLoaderUtil.getString("hms_confirm");
        }

        @Override // com.huawei.hms.ui.AbstractPromptDialog, com.huawei.hms.ui.AbstractDialog
        public java.lang.String onGetTitleString(android.content.Context context) {
            if (com.huawei.hms.utils.ResourceLoaderUtil.getmContext() == null) {
                com.huawei.hms.utils.ResourceLoaderUtil.setmContext(context);
            }
            return com.huawei.hms.utils.ResourceLoaderUtil.getString("hms_spoof_hints");
        }
    }

    public final void a() {
        android.app.Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        com.huawei.hms.support.log.HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution finishBridgeActivity：");
        if (com.huawei.hms.availableupdate.b.c.a().compareAndSet(true, false)) {
            com.huawei.hms.adapter.sysobs.SystemManager.getInstance().notifyNoticeResult(29);
        }
        activity.finish();
    }

    public final void b() {
        android.app.Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        com.huawei.hms.update.note.AppSpoofResolution.b bVar = this.b;
        if (bVar == null) {
            this.b = new com.huawei.hms.update.note.AppSpoofResolution.b(null);
        } else {
            bVar.dismiss();
        }
        com.huawei.hms.support.log.HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution showPromptdlg to resolve conn error");
        this.b.show(activity, new com.huawei.hms.update.note.AppSpoofResolution.a());
    }

    public android.app.Activity getActivity() {
        return this.a;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(android.app.Activity activity) {
        com.huawei.hms.support.log.HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityCreate");
        this.a = activity;
        com.huawei.hms.availableupdate.b bVar = com.huawei.hms.availableupdate.b.c;
        bVar.a(activity);
        bVar.a(false);
        b();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        com.huawei.hms.support.log.HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityDestroy");
        com.huawei.hms.availableupdate.b bVar = com.huawei.hms.availableupdate.b.c;
        if (bVar.a().compareAndSet(true, false)) {
            com.huawei.hms.adapter.sysobs.SystemManager.getInstance().notifyNoticeResult(29);
        }
        bVar.b(this.a);
        this.a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, android.content.Intent intent) {
        if (i != getRequestCode()) {
            return false;
        }
        com.huawei.hms.support.log.HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityResult");
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        if (this.b == null) {
            return;
        }
        com.huawei.hms.support.log.HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution re show prompt dialog");
        b();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, android.view.KeyEvent keyEvent) {
        com.huawei.hms.support.log.HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution On key up when resolve spoof error");
    }
}
