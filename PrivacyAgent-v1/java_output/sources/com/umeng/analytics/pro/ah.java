package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class ah implements com.umeng.analytics.pro.ac {
    private java.lang.String a;
    private long b;

    public ah(java.lang.String str, long j) {
        this.a = str;
        this.b = j;
    }

    @Override // com.umeng.analytics.pro.ac
    public boolean a() {
        try {
            java.lang.String str = com.umeng.analytics.pro.au.b + this.a;
            android.content.SharedPreferences a = com.umeng.analytics.pro.au.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext());
            if (a == null) {
                return false;
            }
            long currentTimeMillis = java.lang.System.currentTimeMillis() - a.getLong(str, 0L);
            if (currentTimeMillis > this.b * 1000) {
                return true;
            }
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "internal period skipped. elapse: " + currentTimeMillis + "; config: " + (this.b * 1000));
            return false;
        } catch (java.lang.Throwable unused) {
            return false;
        }
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
