package com.alipay.sdk.m.i0;

/* loaded from: classes.dex */
public final class e extends android.content.BroadcastReceiver {
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0047, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0045, code lost:
    
        if (r0 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002e, code lost:
    
        if (android.text.TextUtils.equals(r6.getStringExtra("openIdPackage"), r5.getPackageName()) != false) goto L17;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        if (context == null || intent == null) {
            return;
        }
        boolean z = false;
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        com.alipay.sdk.m.i0.f.a("shouldUpdateId, notifyFlag : ".concat(java.lang.String.valueOf(intExtra)));
        if (intExtra != 1) {
            if (intExtra == 2) {
                java.util.ArrayList<java.lang.String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
                if (stringArrayListExtra != null) {
                    z = stringArrayListExtra.contains(context.getPackageName());
                }
            }
        }
        if (z) {
            java.lang.String stringExtra = intent.getStringExtra("openIdType");
            com.alipay.sdk.m.i0.f a = com.alipay.sdk.m.i0.f.a();
            com.alipay.sdk.m.i0.a aVar = "oaid".equals(stringExtra) ? a.b : "vaid".equals(stringExtra) ? a.d : "aaid".equals(stringExtra) ? a.c : "udid".equals(stringExtra) ? a.a : null;
            if (aVar == null) {
                return;
            }
            aVar.b();
        }
    }
}
