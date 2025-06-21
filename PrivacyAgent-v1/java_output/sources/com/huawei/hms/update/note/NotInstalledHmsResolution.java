package com.huawei.hms.update.note;

/* loaded from: classes22.dex */
public class NotInstalledHmsResolution implements com.huawei.hms.activity.IBridgeActivityDelegate {
    public android.app.Dialog a;
    public android.app.Activity b;

    public static class a implements android.content.DialogInterface.OnClickListener {
        public final android.app.Activity a;

        public a(android.app.Activity activity) {
            this.a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.huawei.hms.support.log.HMSLog.i("NotInstalledHmsResolution", "<Dialog onClick>");
            this.a.finish();
        }
    }

    public final void a() {
        android.app.Dialog dialog = this.a;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.a.cancel();
    }

    public final void a(android.app.Activity activity) {
        a();
        this.a = com.huawei.hms.update.ui.NotInstalledHmsDialogHelper.getDialogBuilder(activity).setPositiveButton(com.huawei.hms.update.ui.NotInstalledHmsDialogHelper.getConfirmResId(activity), new com.huawei.hms.update.note.NotInstalledHmsResolution.a(activity)).show();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        com.huawei.hms.support.log.HMSLog.i("NotInstalledHmsResolution", "<Resolution getRequestCode>");
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(android.app.Activity activity) {
        com.huawei.hms.support.log.HMSLog.i("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate>");
        if (activity == null || activity.isFinishing()) {
            com.huawei.hms.support.log.HMSLog.e("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate> activity is null or finishing");
            return;
        }
        this.b = activity;
        com.huawei.hms.availableupdate.c.b.a(activity);
        a(activity);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        com.huawei.hms.support.log.HMSLog.i("NotInstalledHmsResolution", "<Resolution onBridgeActivityDestroy>");
        a();
        com.huawei.hms.availableupdate.c.b.b(this.b);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, android.content.Intent intent) {
        com.huawei.hms.support.log.HMSLog.i("NotInstalledHmsResolution", "<Resolution onBridgeActivityResult>");
        return false;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        com.huawei.hms.support.log.HMSLog.i("NotInstalledHmsResolution", "<Resolution onBridgeConfigurationChanged>");
        android.app.Activity activity = this.b;
        if (activity == null || activity.isFinishing()) {
            com.huawei.hms.support.log.HMSLog.e("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate> mActivity is null or finishing");
        } else {
            a(this.b);
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, android.view.KeyEvent keyEvent) {
        com.huawei.hms.support.log.HMSLog.i("NotInstalledHmsResolution", "<Resolution onKeyUp>");
    }
}
