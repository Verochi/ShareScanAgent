package com.alipay.sdk.m.d0;

/* loaded from: classes.dex */
public class b implements java.lang.Runnable {
    public final /* synthetic */ com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest a;
    public final /* synthetic */ com.alipay.sdk.m.d0.c b;

    public b(com.alipay.sdk.m.d0.c cVar, com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest dataReportRequest) {
        this.b = cVar;
        this.a = dataReportRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult dataReportResult;
        com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult dataReportResult2;
        com.alipay.tscenter.biz.rpc.report.general.DataReportService dataReportService;
        try {
            dataReportService = this.b.c;
            com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult unused = com.alipay.sdk.m.d0.c.e = dataReportService.reportData(this.a);
        } catch (java.lang.Throwable th) {
            com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult unused2 = com.alipay.sdk.m.d0.c.e = new com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult();
            dataReportResult = com.alipay.sdk.m.d0.c.e;
            dataReportResult.success = false;
            dataReportResult2 = com.alipay.sdk.m.d0.c.e;
            dataReportResult2.resultCode = "static data rpc upload error, " + com.alipay.sdk.m.z.a.a(th);
            com.alipay.sdk.m.z.a.a(th);
        }
    }
}
