package com.huawei.hms.adapter.ui;

/* loaded from: classes22.dex */
public class NotInstalledHmsAdapter implements com.huawei.hms.activity.IBridgeActivityDelegate {
    public static final java.lang.Object c = new java.lang.Object();
    public static boolean d;
    public android.app.Activity a;
    public android.app.Dialog b;

    public static class a implements android.content.DialogInterface.OnCancelListener {
        public final android.app.Activity a;

        public a(android.app.Activity activity) {
            this.a = activity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(android.content.DialogInterface dialogInterface) {
            com.huawei.hms.support.log.HMSLog.i("NotInstalledHmsAdapter", "<Dialog onCancel>");
            com.huawei.hms.adapter.sysobs.SystemManager.getInstance().notifyUpdateResult(13);
            this.a.finish();
        }
    }

    public static class b implements android.content.DialogInterface.OnClickListener {
        public final android.app.Activity a;

        public b(android.app.Activity activity) {
            this.a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.huawei.hms.support.log.HMSLog.i("NotInstalledHmsAdapter", "<Dialog onClick>");
            com.huawei.hms.adapter.sysobs.SystemManager.getInstance().notifyUpdateResult(30);
            this.a.finish();
        }
    }

    public static boolean getShowLock() {
        synchronized (c) {
            com.huawei.hms.support.log.HMSLog.i("NotInstalledHmsAdapter", "<canShowDialog> sIsShowingDialog: " + d);
            if (d) {
                return false;
            }
            d = true;
            return true;
        }
    }

    public final void a(android.app.Activity activity) {
        android.app.Dialog dialog = this.b;
        if (dialog != null && dialog.isShowing()) {
            this.b.setOnCancelListener(null);
            this.b.cancel();
        }
        this.b = com.huawei.hms.update.ui.NotInstalledHmsDialogHelper.getDialogBuilder(activity).setPositiveButton(com.huawei.hms.update.ui.NotInstalledHmsDialogHelper.getConfirmResId(activity), new com.huawei.hms.adapter.ui.NotInstalledHmsAdapter.b(activity)).setOnCancelListener(new com.huawei.hms.adapter.ui.NotInstalledHmsAdapter.a(activity)).show();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        com.huawei.hms.support.log.HMSLog.i("NotInstalledHmsAdapter", "<getRequestCode>");
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(android.app.Activity activity) {
        com.huawei.hms.support.log.HMSLog.i("NotInstalledHmsAdapter", "<onBridgeActivityCreate>");
        if (activity == null || activity.isFinishing()) {
            com.huawei.hms.support.log.HMSLog.e("NotInstalledHmsAdapter", "<onBridgeActivityCreate> activity is null or finishing");
        } else {
            this.a = activity;
            a(activity);
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        com.huawei.hms.support.log.HMSLog.i("NotInstalledHmsAdapter", "<onBridgeActivityDestroy>");
        synchronized (c) {
            d = false;
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, android.content.Intent intent) {
        com.huawei.hms.support.log.HMSLog.i("NotInstalledHmsAdapter", "<onBridgeActivityResult>");
        return false;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        com.huawei.hms.support.log.HMSLog.i("NotInstalledHmsAdapter", "<onBridgeConfigurationChanged>");
        android.app.Activity activity = this.a;
        if (activity == null || activity.isFinishing()) {
            com.huawei.hms.support.log.HMSLog.e("NotInstalledHmsAdapter", "<onBridgeConfigurationChanged> mActivity is null or finishing");
        } else {
            a(this.a);
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, android.view.KeyEvent keyEvent) {
        com.huawei.hms.support.log.HMSLog.i("NotInstalledHmsAdapter", "<onKeyUp>");
    }
}
