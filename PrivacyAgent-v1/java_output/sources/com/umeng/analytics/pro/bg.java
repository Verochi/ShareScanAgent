package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
class bg implements com.umeng.analytics.pro.az {
    @Override // com.umeng.analytics.pro.az
    public java.lang.String a(android.content.Context context) {
        if (context == null) {
            return null;
        }
        boolean a = org.repackage.com.meizu.flyme.openidsdk.OpenIdHelper.a();
        com.umeng.analytics.pro.bn.a("getOAID", "isSupported", java.lang.Boolean.valueOf(a));
        if (a) {
            return org.repackage.com.meizu.flyme.openidsdk.OpenIdHelper.b(context);
        }
        return null;
    }
}
