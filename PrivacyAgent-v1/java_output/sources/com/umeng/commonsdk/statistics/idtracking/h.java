package com.umeng.commonsdk.statistics.idtracking;

/* loaded from: classes19.dex */
public class h extends com.umeng.commonsdk.statistics.idtracking.a {
    private static final java.lang.String a = "mac";
    private android.content.Context b;

    public h(android.content.Context context) {
        super("mac");
        this.b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public java.lang.String f() {
        try {
            return com.umeng.commonsdk.statistics.common.DeviceConfig.getMac(this.b);
        } catch (java.lang.Exception e) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                e.printStackTrace();
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(this.b, e);
            return null;
        }
    }
}
