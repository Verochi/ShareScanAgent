package com.umeng.commonsdk.framework;

/* loaded from: classes19.dex */
public interface UMLogDataProtocol {

    public enum UMBusinessType {
        U_APP,
        U_INTERNAL,
        U_ZeroEnv,
        U_Silent
    }

    void removeCacheData(java.lang.Object obj);

    org.json.JSONObject setupReportData(long j);

    void workEvent(java.lang.Object obj, int i);
}
