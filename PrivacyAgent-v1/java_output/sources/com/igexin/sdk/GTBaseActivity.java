package com.igexin.sdk;

/* loaded from: classes23.dex */
public class GTBaseActivity extends android.app.Activity {
    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.igexin.sdk.GTServiceManager.getInstance().onActivityCreate(this);
    }
}
