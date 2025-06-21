package com.alipay.sdk.m.d0;

/* loaded from: classes.dex */
public class c implements com.alipay.sdk.m.d0.a {
    public static com.alipay.sdk.m.d0.c d;
    public static com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult e;
    public com.alipay.android.phone.mrpc.core.w a;
    public com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService b;
    public com.alipay.tscenter.biz.rpc.report.general.DataReportService c;

    public c(android.content.Context context, java.lang.String str) {
        this.a = null;
        this.b = null;
        this.c = null;
        com.alipay.android.phone.mrpc.core.aa aaVar = new com.alipay.android.phone.mrpc.core.aa();
        aaVar.a(str);
        com.alipay.android.phone.mrpc.core.h hVar = new com.alipay.android.phone.mrpc.core.h(context);
        this.a = hVar;
        this.b = (com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService) hVar.a(com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService.class, aaVar);
        this.c = (com.alipay.tscenter.biz.rpc.report.general.DataReportService) this.a.a(com.alipay.tscenter.biz.rpc.report.general.DataReportService.class, aaVar);
    }

    public static synchronized com.alipay.sdk.m.d0.c a(android.content.Context context, java.lang.String str) {
        com.alipay.sdk.m.d0.c cVar;
        synchronized (com.alipay.sdk.m.d0.c.class) {
            if (d == null) {
                d = new com.alipay.sdk.m.d0.c(context, str);
            }
            cVar = d;
        }
        return cVar;
    }

    @Override // com.alipay.sdk.m.d0.a
    public com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult a(com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest dataReportRequest) {
        if (dataReportRequest == null) {
            return null;
        }
        if (this.c != null) {
            e = null;
            new java.lang.Thread(new com.alipay.sdk.m.d0.b(this, dataReportRequest)).start();
            for (int i = com.alipay.sdk.m.e0.a.a; e == null && i >= 0; i -= 50) {
                java.lang.Thread.sleep(50L);
            }
        }
        return e;
    }

    @Override // com.alipay.sdk.m.d0.a
    public boolean logCollect(java.lang.String str) {
        com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService bugTrackMessageService;
        java.lang.String str2;
        if (com.alipay.sdk.m.z.a.a(str) || (bugTrackMessageService = this.b) == null) {
            return false;
        }
        try {
            str2 = bugTrackMessageService.logCollect(com.alipay.sdk.m.z.a.f(str));
        } catch (java.lang.Throwable unused) {
            str2 = null;
        }
        if (com.alipay.sdk.m.z.a.a(str2)) {
            return false;
        }
        return ((java.lang.Boolean) new org.json.JSONObject(str2).get("success")).booleanValue();
    }
}
