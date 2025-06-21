package com.xiaomi.mipush.sdk.help;

/* loaded from: classes19.dex */
public class HelpService extends android.app.IntentService {
    public HelpService() {
        super("intentService");
    }

    @Override // android.app.IntentService
    public void onHandleIntent(android.content.Intent intent) {
        if (android.text.TextUtils.isEmpty(intent.getStringExtra("awake_info"))) {
            return;
        }
        com.xiaomi.mipush.sdk.o.a(this, intent, null);
    }
}
