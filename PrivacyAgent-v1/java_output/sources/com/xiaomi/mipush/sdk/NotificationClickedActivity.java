package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public final class NotificationClickedActivity extends android.app.Activity {
    private android.content.BroadcastReceiver a;

    /* renamed from: a, reason: collision with other field name */
    private android.os.Handler f17a;

    private void a(android.content.Intent intent) {
        if (intent != null) {
            try {
                android.content.Intent intent2 = (android.content.Intent) intent.getParcelableExtra("mipush_serviceIntent");
                if (intent2 != null) {
                    intent2.setComponent(new android.content.ComponentName(getPackageName(), "com.xiaomi.mipush.sdk.PushMessageHandler"));
                    intent2.putExtra("is_clicked_activity_call", true);
                    com.xiaomi.channel.commonutils.logger.b.b("clicked activity start service.");
                    startService(intent2);
                }
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }

    @Override // android.app.Activity
    public final void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        android.view.Window window = getWindow();
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = 1;
        attributes.width = 1;
        attributes.gravity = com.google.android.material.badge.BadgeDrawable.TOP_START;
        window.setAttributes(attributes);
        android.os.Handler handler = new android.os.Handler();
        this.f17a = handler;
        handler.postDelayed(new com.xiaomi.mipush.sdk.ac(this), 3000L);
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction("action_clicked_activity_finish");
        com.xiaomi.mipush.sdk.ad adVar = new com.xiaomi.mipush.sdk.ad(this);
        this.a = adVar;
        try {
            registerReceiver(adVar, intentFilter, com.xiaomi.mipush.sdk.d.a(this), null);
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        this.f17a.removeCallbacksAndMessages(null);
        try {
            unregisterReceiver(this.a);
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.app.Activity
    public final void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        a(getIntent());
    }
}
