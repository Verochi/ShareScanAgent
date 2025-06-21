package com.meizu.flyme.openidsdk;

/* loaded from: classes23.dex */
public class a extends android.content.BroadcastReceiver {
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        if (r0 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0034, code lost:
    
        if (android.text.TextUtils.equals(r6.getStringExtra("openIdPackage"), r5.getPackageName()) != false) goto L17;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        if (context == null || intent == null) {
            return;
        }
        boolean z = false;
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        com.meizu.flyme.openidsdk.b.b("shouldUpdateId, notifyFlag : " + intExtra);
        if (intExtra != 1) {
            if (intExtra == 2) {
                java.util.ArrayList<java.lang.String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
                if (stringArrayListExtra != null) {
                    z = stringArrayListExtra.contains(context.getPackageName());
                }
            }
        }
        if (z) {
            com.meizu.flyme.openidsdk.OpenId a = com.meizu.flyme.openidsdk.b.a().a(intent.getStringExtra("openIdType"));
            if (a == null) {
                return;
            }
            a.b();
        }
    }
}
