package com.huawei.hms.activity;

/* loaded from: classes22.dex */
public interface IBridgeActivityDelegate {
    int getRequestCode();

    void onBridgeActivityCreate(android.app.Activity activity);

    void onBridgeActivityDestroy();

    boolean onBridgeActivityResult(int i, int i2, android.content.Intent intent);

    void onBridgeConfigurationChanged();

    void onKeyUp(int i, android.view.KeyEvent keyEvent);
}
