package com.huawei.hms.adapter.ui;

/* loaded from: classes22.dex */
public class UpdateAdapter implements com.huawei.hms.activity.IBridgeActivityDelegate {
    public java.lang.ref.WeakReference<android.app.Activity> a;
    public int b;
    public boolean c = false;

    public final void a() {
        android.app.Activity b = b();
        if (b == null || b.isFinishing()) {
            return;
        }
        b.finish();
    }

    public final void a(android.content.Intent intent) {
        int intExtra = intent.getIntExtra(com.huawei.hms.activity.BridgeActivity.EXTRA_RESULT, -1);
        if (intExtra == 0) {
            com.huawei.hms.support.log.HMSLog.i("UpdateAdapter", "Error resolved successfully!");
            com.huawei.hms.adapter.sysobs.SystemManager.getInstance().notifyUpdateResult(0);
        } else if (intExtra == 13) {
            com.huawei.hms.support.log.HMSLog.i("UpdateAdapter", "Resolve error process canceled by user!");
            com.huawei.hms.adapter.sysobs.SystemManager.getInstance().notifyUpdateResult(13);
        } else if (intExtra == 8) {
            com.huawei.hms.support.log.HMSLog.i("UpdateAdapter", "Internal error occurred, recommended retry.");
            com.huawei.hms.adapter.sysobs.SystemManager.getInstance().notifyUpdateResult(8);
        } else {
            com.huawei.hms.support.log.HMSLog.i("UpdateAdapter", "Other error codes.");
            com.huawei.hms.adapter.sysobs.SystemManager.getInstance().notifyUpdateResult(intExtra);
        }
    }

    public final boolean a(android.content.Context context, java.lang.String str, int i) {
        if (context == null || android.text.TextUtils.isEmpty(str) || i == 0) {
            return false;
        }
        com.huawei.hms.utils.PackageManagerHelper packageManagerHelper = new com.huawei.hms.utils.PackageManagerHelper(context);
        return com.huawei.hms.utils.PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageManagerHelper.getPackageStates(str)) || packageManagerHelper.getPackageVersionCode(str) < i;
    }

    public final boolean a(android.content.Intent intent, android.app.Activity activity) {
        if (!intent.getBooleanExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.NEW_UPDATE, false)) {
            return false;
        }
        com.huawei.hms.support.log.HMSLog.i("UpdateAdapter", "4.0 framework HMSCore upgrade process");
        java.lang.String hMSPackageName = com.huawei.hms.utils.HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
        android.content.ComponentName componentName = new android.content.ComponentName(hMSPackageName, "com.huawei.hms.fwksdk.stub.UpdateStubActivity");
        android.content.Intent intent2 = new android.content.Intent();
        intent2.putExtra(com.huawei.hms.update.kpms.KpmsConstant.CALLER_PACKAGE_NAME, activity.getApplicationContext().getPackageName());
        intent2.putExtra(com.huawei.hms.update.kpms.KpmsConstant.UPDATE_PACKAGE_NAME, hMSPackageName);
        intent2.setComponent(componentName);
        activity.startActivityForResult(intent2, 1001);
        return true;
    }

    public final android.app.Activity b() {
        java.lang.ref.WeakReference<android.app.Activity> weakReference = this.a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final void c() {
        com.huawei.hms.adapter.sysobs.SystemManager.getInstance().notifyUpdateResult(8);
        a();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1001;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(android.app.Activity activity) {
        if (activity == null) {
            com.huawei.hms.support.log.HMSLog.i("UpdateAdapter", "activity == null");
            c();
            return;
        }
        activity.getApplicationContext();
        this.a = new java.lang.ref.WeakReference<>(activity);
        if (com.huawei.hms.availableupdate.a.b.a(b())) {
            android.content.Intent intent = activity.getIntent();
            if (intent == null) {
                c();
                return;
            }
            int intExtra = intent.getIntExtra("update_version", 0);
            this.b = intExtra;
            if (intExtra == 0) {
                c();
                return;
            }
            if (intent.hasExtra("installHMS")) {
                this.c = true;
            }
            a(intent, activity);
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        com.huawei.hms.support.log.HMSLog.i("UpdateAdapter", "onBridgeActivityDestroy");
        com.huawei.hms.availableupdate.a.b.b(b());
        this.a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, android.content.Intent intent) {
        if (i != getRequestCode()) {
            return false;
        }
        com.huawei.hms.support.log.HMSLog.i("UpdateAdapter", "onBridgeActivityResult " + i2);
        if (i2 == -1) {
            if (intent != null) {
                if (intent.getIntExtra(com.huawei.hms.update.kpms.KpmsConstant.KIT_UPDATE_RESULT, 0) == 1) {
                    com.huawei.hms.support.log.HMSLog.i("UpdateAdapter", "new framework update process,Error resolved successfully!");
                    com.huawei.hms.adapter.sysobs.SystemManager.getInstance().notifyUpdateResult(0);
                    a();
                    return true;
                }
                a(intent);
            }
        } else if (i2 == 0) {
            com.huawei.hms.support.log.HMSLog.i("UpdateAdapter", "Activity.RESULT_CANCELED");
            android.app.Activity b = b();
            if (b == null) {
                return true;
            }
            java.lang.String hMSPackageName = com.huawei.hms.utils.HMSPackageManager.getInstance(b.getApplicationContext()).getHMSPackageName();
            if (this.c || a(b, hMSPackageName, this.b)) {
                com.huawei.hms.support.log.HMSLog.i("UpdateAdapter", "Resolve error, process canceled by user clicking back button!");
                com.huawei.hms.adapter.sysobs.SystemManager.getInstance().notifyUpdateResult(13);
            } else {
                com.huawei.hms.adapter.sysobs.SystemManager.getInstance().notifyUpdateResult(0);
            }
        } else if (i2 == 1) {
            com.huawei.hms.adapter.sysobs.SystemManager.getInstance().notifyUpdateResult(28);
        }
        a();
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        com.huawei.hms.support.log.HMSLog.i("UpdateAdapter", "onBridgeConfigurationChanged");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, android.view.KeyEvent keyEvent) {
        com.huawei.hms.support.log.HMSLog.i("UpdateAdapter", "On key up when resolve conn error");
    }
}
