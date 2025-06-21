package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class bi implements com.umeng.analytics.pro.az {
    private boolean a = false;

    @Override // com.umeng.analytics.pro.az
    public java.lang.String a(android.content.Context context) {
        if (context == null) {
            return null;
        }
        if (!this.a) {
            org.repackage.com.heytap.openid.sdk.OpenIDSDK.a(context);
            this.a = true;
        }
        boolean a = org.repackage.com.heytap.openid.sdk.OpenIDSDK.a();
        com.umeng.analytics.pro.bn.a("getOAID", "isSupported", java.lang.Boolean.valueOf(a));
        if (a) {
            return org.repackage.com.heytap.openid.sdk.OpenIDSDK.c(context);
        }
        return null;
    }
}
