package com.alipay.sdk.m.f0;

/* loaded from: classes.dex */
public class b {
    public static com.alipay.sdk.m.f0.c a(com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult dataReportResult) {
        com.alipay.sdk.m.f0.c cVar = new com.alipay.sdk.m.f0.c();
        if (dataReportResult == null) {
            return null;
        }
        cVar.a = dataReportResult.success;
        cVar.b = dataReportResult.resultCode;
        java.util.Map<java.lang.String, java.lang.String> map = dataReportResult.resultData;
        if (map != null) {
            cVar.c = map.get("apdid");
            cVar.d = map.get("apdidToken");
            cVar.g = map.get("dynamicKey");
            cVar.h = map.get("timeInterval");
            cVar.i = map.get("webrtcUrl");
            cVar.j = "";
            java.lang.String str = map.get("drmSwitch");
            if (com.alipay.sdk.m.z.a.b(str)) {
                if (str.length() > 0) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(str.charAt(0));
                    cVar.e = sb.toString();
                }
                if (str.length() >= 3) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append(str.charAt(2));
                    cVar.f = sb2.toString();
                }
            }
            if (map.containsKey("apse_degrade")) {
                cVar.k = map.get("apse_degrade");
            }
        }
        return cVar;
    }

    public static com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest a(com.alipay.sdk.m.f0.d dVar) {
        com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest dataReportRequest = new com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest();
        if (dVar == null) {
            return null;
        }
        dataReportRequest.os = dVar.a;
        dataReportRequest.rpcVersion = dVar.j;
        dataReportRequest.bizType = "1";
        java.util.HashMap hashMap = new java.util.HashMap();
        dataReportRequest.bizData = hashMap;
        hashMap.put("apdid", dVar.b);
        dataReportRequest.bizData.put("apdidToken", dVar.c);
        dataReportRequest.bizData.put("umidToken", dVar.d);
        dataReportRequest.bizData.put("dynamicKey", dVar.e);
        dataReportRequest.deviceData = dVar.f;
        return dataReportRequest;
    }
}
