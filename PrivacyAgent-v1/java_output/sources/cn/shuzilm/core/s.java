package cn.shuzilm.core;

/* loaded from: classes.dex */
class s extends android.content.BroadcastReceiver {
    private s() {
    }

    public /* synthetic */ s(cn.shuzilm.core.j jVar) {
        this();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        if (intent == null) {
            return;
        }
        try {
            if (intent.getAction() == null) {
                return;
            }
            cn.shuzilm.core.DUHelper.aXZlZWNl(context, intent);
        } catch (java.lang.Exception unused) {
        }
    }
}
