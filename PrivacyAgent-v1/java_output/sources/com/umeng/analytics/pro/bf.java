package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class bf implements com.umeng.analytics.pro.az {
    private static final int a = 1;
    private org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId b;
    private boolean c = false;
    private boolean d = false;

    @Override // com.umeng.analytics.pro.az
    public java.lang.String a(android.content.Context context) {
        if (context == null) {
            return null;
        }
        if (!this.c) {
            org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId openDeviceId = new org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId();
            this.b = openDeviceId;
            this.d = openDeviceId.a(context, null) == 1;
            this.c = true;
        }
        com.umeng.analytics.pro.bn.a("getOAID", "isSupported", java.lang.Boolean.valueOf(this.d));
        if (this.d && this.b.c()) {
            return this.b.a();
        }
        return null;
    }
}
