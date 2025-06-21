package com.huawei.hms.adapter;

/* loaded from: classes22.dex */
public class AvailableAdapter {
    public final int a;
    public com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack b;
    public com.huawei.hms.adapter.sysobs.SystemObserver d = new com.huawei.hms.adapter.AvailableAdapter.a();
    public boolean c = false;

    public interface AvailableCallBack {
        void onComplete(int i);
    }

    public class a implements com.huawei.hms.adapter.sysobs.SystemObserver {
        public a() {
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onNoticeResult(int i) {
            com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack a = com.huawei.hms.adapter.AvailableAdapter.this.a();
            if (a == null) {
                com.huawei.hms.support.log.HMSLog.e("AvailableAdapter", "onNoticeResult baseCallBack null");
                return true;
            }
            a.onComplete(i);
            return true;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onSolutionResult(android.content.Intent intent, java.lang.String str) {
            return false;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onUpdateResult(int i) {
            com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack a = com.huawei.hms.adapter.AvailableAdapter.this.a();
            if (a == null) {
                com.huawei.hms.support.log.HMSLog.e("AvailableAdapter", "onUpdateResult baseCallBack null");
                return true;
            }
            a.onComplete(i);
            return true;
        }
    }

    public AvailableAdapter(int i) {
        this.a = i;
    }

    public final int a(android.content.Context context) {
        com.huawei.hms.utils.PackageManagerHelper.PackageStates hMSPackageStatesForMultiService = com.huawei.hms.utils.HMSPackageManager.getInstance(context).getHMSPackageStatesForMultiService();
        if (com.huawei.hms.utils.PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(hMSPackageStatesForMultiService)) {
            com.huawei.hms.support.log.HMSLog.i("AvailableAdapter", "HMS is not installed");
            return 1;
        }
        if (com.huawei.hms.utils.PackageManagerHelper.PackageStates.SPOOF.equals(hMSPackageStatesForMultiService)) {
            com.huawei.hms.support.log.HMSLog.i("AvailableAdapter", "HMS is spoofed");
            return 29;
        }
        if (!com.huawei.hms.utils.PackageManagerHelper.PackageStates.DISABLED.equals(hMSPackageStatesForMultiService)) {
            return 0;
        }
        com.huawei.hms.support.log.HMSLog.i("AvailableAdapter", "HMS is disabled");
        return 3;
    }

    public final com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack a() {
        return this.b;
    }

    public final void a(android.app.Activity activity, com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack availableCallBack) {
        com.huawei.hms.support.log.HMSLog.i("AvailableAdapter", "<showHmsApkNotInstalledDialog> startResolution");
        if (!com.huawei.hms.adapter.ui.NotInstalledHmsAdapter.getShowLock()) {
            availableCallBack.onComplete(31);
            return;
        }
        this.b = availableCallBack;
        com.huawei.hms.adapter.sysobs.SystemManager.getSystemNotifier().registerObserver(this.d);
        activity.startActivity(com.huawei.hms.activity.BridgeActivity.getIntentStartBridgeActivity(activity, com.huawei.hms.adapter.ui.NotInstalledHmsAdapter.class.getName()));
    }

    public final boolean a(android.app.Activity activity) {
        if (com.huawei.hms.utils.HMSPackageManager.getInstance(activity).getHmsVersionCode() < 40000000) {
            return false;
        }
        com.huawei.hms.support.log.HMSLog.i("AvailableAdapter", "enter 4.0 HmsCore upgrade process");
        return true;
    }

    public int checkHuaweiMobileServicesForUpdate(android.content.Context context) {
        com.huawei.hms.utils.Checker.checkNonNull(context, "context must not be null.");
        int a2 = a(context);
        if (a2 != 0 || !com.huawei.hms.utils.HMSPackageManager.getInstance(context).isApkNeedUpdate(this.a)) {
            return a2;
        }
        com.huawei.hms.support.log.HMSLog.i("AvailableAdapter", "The current version does not meet the target version requirements");
        return 2;
    }

    public int isHuaweiMobileServicesAvailable(android.content.Context context) {
        com.huawei.hms.utils.Checker.checkNonNull(context, "context must not be null.");
        int a2 = a(context);
        if (a2 != 0 || !com.huawei.hms.utils.HMSPackageManager.getInstance(context).isApkUpdateNecessary(this.a)) {
            return a2;
        }
        com.huawei.hms.support.log.HMSLog.i("AvailableAdapter", "The current version does not meet the minimum version requirements");
        return 2;
    }

    public boolean isUserNoticeError(int i) {
        return i == 29;
    }

    public boolean isUserResolvableError(int i) {
        return i == 1 || i == 2;
    }

    public void setCalledBySolutionInstallHms(boolean z) {
        this.c = z;
    }

    public void startNotice(android.app.Activity activity, com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack availableCallBack) {
        if (activity == null || availableCallBack == null) {
            return;
        }
        if (com.huawei.hms.utils.UIUtil.isBackground(activity)) {
            com.huawei.hms.support.log.HMSLog.i("AvailableAdapter", "current app is in Background");
            availableCallBack.onComplete(28);
        } else {
            com.huawei.hms.support.log.HMSLog.i("AvailableAdapter", "startNotice");
            this.b = availableCallBack;
            com.huawei.hms.adapter.sysobs.SystemManager.getSystemNotifier().registerObserver(this.d);
            activity.startActivity(com.huawei.hms.activity.BridgeActivity.getIntentStartBridgeActivity(activity, com.huawei.hms.update.note.AppSpoofResolution.class.getName()));
        }
    }

    public void startResolution(android.app.Activity activity, com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack availableCallBack) {
        if (activity == null || availableCallBack == null) {
            return;
        }
        if (com.huawei.hms.utils.UIUtil.isBackground(activity)) {
            com.huawei.hms.support.log.HMSLog.i("AvailableAdapter", "current app is in Background");
            availableCallBack.onComplete(28);
            return;
        }
        if (!a(activity)) {
            a(activity, availableCallBack);
            return;
        }
        com.huawei.hms.support.log.HMSLog.i("AvailableAdapter", "startResolution");
        this.b = availableCallBack;
        com.huawei.hms.adapter.sysobs.SystemManager.getSystemNotifier().registerObserver(this.d);
        android.content.Intent intentStartBridgeActivity = com.huawei.hms.activity.BridgeActivity.getIntentStartBridgeActivity(activity, com.huawei.hms.adapter.ui.UpdateAdapter.class.getName());
        intentStartBridgeActivity.putExtra("update_version", this.a);
        if (this.c) {
            intentStartBridgeActivity.putExtra("installHMS", "installHMS");
        }
        intentStartBridgeActivity.putExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.NEW_UPDATE, true);
        activity.startActivity(intentStartBridgeActivity);
    }
}
