package org.repackage.com.meizu.flyme.openidsdk;

/* loaded from: classes26.dex */
final class a extends android.content.BroadcastReceiver {
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0046, code lost:
    
        if (r0 == 0) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002e, code lost:
    
        if (android.text.TextUtils.equals(r6.getStringExtra("openIdPackage"), r5.getPackageName()) != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0030, code lost:
    
        r1 = true;
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
        org.repackage.com.meizu.flyme.openidsdk.b.e("shouldUpdateId, notifyFlag : ".concat(java.lang.String.valueOf(intExtra)));
        if (intExtra != 1) {
            if (intExtra == 2) {
                java.util.ArrayList<java.lang.String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
                if (stringArrayListExtra != null) {
                    z = stringArrayListExtra.contains(context.getPackageName());
                }
            }
            if (z) {
                java.lang.String stringExtra = intent.getStringExtra("openIdType");
                org.repackage.com.meizu.flyme.openidsdk.b d = org.repackage.com.meizu.flyme.openidsdk.b.d();
                org.repackage.com.meizu.flyme.openidsdk.OpenId openId = "oaid".equals(stringExtra) ? d.b : "vaid".equals(stringExtra) ? d.d : "aaid".equals(stringExtra) ? d.c : "udid".equals(stringExtra) ? d.a : null;
                if (openId == null) {
                    return;
                }
                openId.e();
            }
        }
    }
}
