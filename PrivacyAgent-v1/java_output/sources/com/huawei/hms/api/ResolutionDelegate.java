package com.huawei.hms.api;

/* loaded from: classes22.dex */
public class ResolutionDelegate implements com.huawei.hms.activity.IBridgeActivityDelegate {
    public static final java.lang.String CALLBACK_METHOD = "CALLBACK_METHOD";
    private static final int REQUEST_CODE = 1002;
    private static final java.lang.String TAG = "ResolutionDelegate";
    private java.lang.ref.WeakReference<android.app.Activity> mThisWeakRef;

    private void finishBridgeActivity() {
        android.app.Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
    }

    private android.app.Activity getActivity() {
        java.lang.ref.WeakReference<android.app.Activity> weakReference = this.mThisWeakRef;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private com.huawei.hms.activity.internal.BusResponseCallback getResponseCallback(java.lang.String str) {
        return com.huawei.hms.activity.internal.ForegroundBusResponseMgr.getInstance().get(str);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1002;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(android.app.Activity activity) {
        this.mThisWeakRef = new java.lang.ref.WeakReference<>(activity);
        android.os.Bundle extras = activity.getIntent().getExtras();
        if (extras != null) {
            activity.startActivityForResult((android.content.Intent) extras.getParcelable("resolution"), 1002);
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        this.mThisWeakRef = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, android.content.Intent intent) {
        if (i != getRequestCode()) {
            return false;
        }
        com.huawei.hms.activity.internal.BusResponseCallback responseCallback = getResponseCallback(CALLBACK_METHOD);
        int isHuaweiMobileServicesAvailable = com.huawei.hms.api.HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this.mThisWeakRef.get(), 30000000);
        if (i2 == -1 && isHuaweiMobileServicesAvailable == 0) {
            com.huawei.hms.support.log.HMSLog.i(TAG, "Make service available success.");
        } else {
            responseCallback.innerError(this.mThisWeakRef.get(), i2, "Make service available failed.");
        }
        finishBridgeActivity();
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, android.view.KeyEvent keyEvent) {
    }
}
