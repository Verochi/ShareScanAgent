package com.igexin.sdk;

/* loaded from: classes23.dex */
public class PushReceiver extends android.content.BroadcastReceiver {
    private static final java.lang.String TAG = "p-receive";

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        try {
            android.content.Context applicationContext = context.getApplicationContext();
            if (intent != null && intent.getAction() != null) {
                com.getui.gtc.base.GtcProvider.setContext(applicationContext.getApplicationContext());
                java.lang.String action = intent.getAction();
                if (com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(action) || com.igexin.sdk.PushConsts.ACTION_BROADCAST_USER_PRESENT.equals(action)) {
                    android.content.Context applicationContext2 = applicationContext.getApplicationContext();
                    com.igexin.push.core.a.b.d();
                    android.content.Intent intent2 = new android.content.Intent(applicationContext2, (java.lang.Class<?>) com.igexin.push.core.a.b.a(applicationContext));
                    intent2.putExtra("action", action);
                    com.igexin.push.core.ServiceManager.getInstance().b(applicationContext, intent2);
                }
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a("p-receive|" + th.toString(), new java.lang.Object[0]);
        }
    }
}
