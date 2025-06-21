package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class PushServiceReceiver extends android.content.BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        android.content.Intent intent2 = new android.content.Intent(context, (java.lang.Class<?>) com.xiaomi.mipush.sdk.PushMessageHandler.class);
        intent2.putExtras(intent);
        intent2.setAction(intent.getAction());
        com.xiaomi.mipush.sdk.PushMessageHandler.a(context, intent2);
    }
}
