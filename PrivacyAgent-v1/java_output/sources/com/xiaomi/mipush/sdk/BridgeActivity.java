package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class BridgeActivity extends android.app.Activity {
    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        android.view.Window window = getWindow();
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = 1;
        attributes.width = 1;
        attributes.gravity = 51;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    public void onResume() {
        android.content.Intent intent;
        super.onResume();
        try {
            android.content.Intent intent2 = getIntent();
            if (intent2 != null && (intent = (android.content.Intent) intent2.getParcelableExtra("mipush_serviceIntent")) != null) {
                com.xiaomi.mipush.sdk.PushMessageHandler.a(getApplicationContext(), intent);
            }
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        } finally {
            finish();
        }
    }
}
