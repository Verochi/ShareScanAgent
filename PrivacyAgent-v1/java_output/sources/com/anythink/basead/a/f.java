package com.anythink.basead.a;

/* loaded from: classes12.dex */
public final class f extends android.content.BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        java.lang.String stringExtra;
        java.lang.String stringExtra2;
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        java.lang.String action = intent.getAction();
        if (action != null) {
            stringExtra = intent.getStringExtra(com.anythink.china.common.a.f);
            stringExtra2 = intent.getStringExtra(com.anythink.china.common.a.g);
            switch (action) {
                case "action_offer_download_end":
                    com.anythink.basead.a.g.a(context.getApplicationContext()).b(stringExtra, stringExtra2);
                    break;
                case "action_offer_download_start":
                    com.anythink.basead.a.g.a(context.getApplicationContext()).a(stringExtra, stringExtra2);
                    break;
                case "action_offer_install_successful":
                    com.anythink.basead.a.g.a(context.getApplicationContext()).d(stringExtra, stringExtra2);
                    break;
                case "action_offer_install_start":
                    com.anythink.basead.a.g.a(context.getApplicationContext()).c(stringExtra, stringExtra2);
                    break;
            }
        }
    }
}
