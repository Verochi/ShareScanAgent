package com.qq.e.comm.pi;

/* loaded from: classes19.dex */
public interface ACTD {
    public static final java.lang.String APPID_KEY = "appid";
    public static final java.lang.String DELEGATE_NAME_KEY = "gdt_activity_delegate_name";

    void onActivityResult(int i, int i2, android.content.Intent intent);

    void onAfterCreate(android.os.Bundle bundle);

    void onBackPressed();

    void onBeforeCreate(android.os.Bundle bundle);

    void onConfigurationChanged(android.content.res.Configuration configuration);

    void onDestroy();

    void onPause();

    void onResume();

    void onStop();
}
