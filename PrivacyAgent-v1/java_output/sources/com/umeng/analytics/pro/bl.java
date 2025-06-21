package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
class bl implements com.umeng.analytics.pro.az {
    @Override // com.umeng.analytics.pro.az
    public java.lang.String a(android.content.Context context) {
        if (context == null) {
            return null;
        }
        boolean a = org.repackage.com.miui.deviceid.IdentifierManager.a();
        com.umeng.analytics.pro.bn.a("getOAID", "isSupported", java.lang.Boolean.valueOf(a));
        if (a) {
            return org.repackage.com.miui.deviceid.IdentifierManager.b(context);
        }
        return null;
    }
}
