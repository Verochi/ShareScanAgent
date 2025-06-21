package com.sijla.b;

/* loaded from: classes19.dex */
final class q extends android.content.BroadcastReceiver {
    final /* synthetic */ com.sijla.b.m a;

    public q(com.sijla.b.m mVar) {
        this.a = mVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        try {
            java.lang.String action = intent.getAction();
            java.lang.String str = intent.getPackage();
            if (action == null || str == null || !str.equals(context.getPackageName())) {
                return;
            }
            com.sijla.a.a.a(new com.sijla.b.r(this, action, context, intent));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
