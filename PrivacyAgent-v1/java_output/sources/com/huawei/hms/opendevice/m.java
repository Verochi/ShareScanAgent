package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public class m extends java.lang.Thread {
    public final /* synthetic */ android.content.Context a;
    public final /* synthetic */ java.lang.String b;

    public m(android.content.Context context, java.lang.String str) {
        this.a = context;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean b;
        boolean d;
        java.lang.String c;
        if (!com.huawei.hms.opendevice.p.b()) {
            com.huawei.hms.support.log.HMSLog.d("ReportAaidToken", "Not HW Phone.");
            return;
        }
        b = com.huawei.hms.opendevice.n.b(this.a);
        if (b) {
            return;
        }
        java.lang.String a = com.huawei.hms.opendevice.o.a(this.a);
        if (android.text.TextUtils.isEmpty(a)) {
            com.huawei.hms.support.log.HMSLog.w("ReportAaidToken", "AAID is empty.");
            return;
        }
        d = com.huawei.hms.opendevice.n.d(this.a, a, this.b);
        if (!d) {
            com.huawei.hms.support.log.HMSLog.d("ReportAaidToken", "This time need not report.");
            return;
        }
        java.lang.String string = com.huawei.agconnect.config.AGConnectServicesConfig.fromContext(this.a).getString("region");
        if (android.text.TextUtils.isEmpty(string)) {
            com.huawei.hms.support.log.HMSLog.i("ReportAaidToken", "The data storage region is empty.");
            return;
        }
        java.lang.String a2 = com.huawei.hms.opendevice.e.a(this.a, "com.huawei.hms.opendevicesdk", "ROOT", null, string);
        if (android.text.TextUtils.isEmpty(a2)) {
            return;
        }
        c = com.huawei.hms.opendevice.n.c(this.a, a, this.b);
        com.huawei.hms.opendevice.n.b(this.a, com.huawei.hms.opendevice.d.a(this.a, a2 + "/rest/appdata/v1/aaid/report", c, (java.util.Map<java.lang.String, java.lang.String>) null), a, this.b);
    }
}
