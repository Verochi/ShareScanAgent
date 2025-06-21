package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
class z implements com.umeng.analytics.pro.y {
    private long a = com.umeng.analytics.AnalyticsConfig.kContinueSessionMillis;

    @Override // com.umeng.analytics.pro.y
    public long a() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.y
    public java.lang.String a(android.content.Context context) {
        java.lang.String appkey = com.umeng.commonsdk.utils.UMUtils.getAppkey(context);
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (appkey == null) {
            throw new java.lang.RuntimeException("Appkey is null or empty, Please check!");
        }
        return com.umeng.commonsdk.utils.UMUtils.MD5(currentTimeMillis + appkey + "02:00:00:00:00:00");
    }

    @Override // com.umeng.analytics.pro.y
    public void a(long j) {
        this.a = j;
    }

    @Override // com.umeng.analytics.pro.y
    public void a(android.content.Context context, java.lang.String str) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            android.content.SharedPreferences.Editor edit = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context).edit();
            edit.putString("session_id", str);
            edit.putLong(com.umeng.analytics.pro.w.b, 0L);
            edit.putLong(com.umeng.analytics.pro.w.e, currentTimeMillis);
            edit.putLong(com.umeng.analytics.pro.w.f, 0L);
            edit.commit();
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // com.umeng.analytics.pro.y
    public boolean a(long j, long j2) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        return (j == 0 || currentTimeMillis - j >= this.a) && j2 > 0 && currentTimeMillis - j2 > this.a;
    }
}
