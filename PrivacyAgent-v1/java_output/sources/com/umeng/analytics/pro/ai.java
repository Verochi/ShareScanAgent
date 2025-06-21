package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class ai implements com.umeng.analytics.pro.ac {
    private int a;

    public ai(int i) {
        this.a = i;
    }

    @Override // com.umeng.analytics.pro.ac
    public boolean a() {
        long j = 0;
        try {
            android.content.SharedPreferences a = com.umeng.analytics.pro.au.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext());
            if (a != null) {
                j = a.getLong(com.umeng.analytics.pro.au.a, 0L);
                if (j >= this.a) {
                    return true;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "launch times skipped. times: " + j + " ; config: " + this.a);
        return false;
    }

    @Override // com.umeng.analytics.pro.ac
    public boolean b() {
        return !a();
    }

    @Override // com.umeng.analytics.pro.ac
    public long c() {
        return 0L;
    }
}
