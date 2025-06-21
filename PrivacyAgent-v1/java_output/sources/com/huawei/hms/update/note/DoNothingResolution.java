package com.huawei.hms.update.note;

/* loaded from: classes22.dex */
public class DoNothingResolution implements com.huawei.hms.activity.IBridgeActivityDelegate {
    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        com.huawei.hms.support.log.HMSLog.i("DoNothingResolution", "<DoNothingResolution getRequestCode>");
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(android.app.Activity activity) {
        com.huawei.hms.support.log.HMSLog.i("DoNothingResolution", "<DoNothingResolution onBridgeActivityCreate>");
        if (activity == null || activity.isFinishing()) {
            com.huawei.hms.support.log.HMSLog.e("DoNothingResolution", "<Resolution onBridgeActivityCreate> activity is null or finishing");
        } else {
            activity.setResult(30);
            activity.finish();
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        com.huawei.hms.support.log.HMSLog.i("DoNothingResolution", "<DoNothingResolution onBridgeActivityDestroy>");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, android.content.Intent intent) {
        com.huawei.hms.support.log.HMSLog.i("DoNothingResolution", "<DoNothingResolution onBridgeActivityResult>");
        return false;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        com.huawei.hms.support.log.HMSLog.i("DoNothingResolution", "<DoNothingResolution onBridgeConfigurationChanged>");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, android.view.KeyEvent keyEvent) {
        com.huawei.hms.support.log.HMSLog.i("DoNothingResolution", "<DoNothingResolution onKeyUp>");
    }
}
