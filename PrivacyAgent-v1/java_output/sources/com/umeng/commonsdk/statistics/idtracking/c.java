package com.umeng.commonsdk.statistics.idtracking;

/* loaded from: classes19.dex */
public class c extends com.umeng.commonsdk.statistics.idtracking.a {
    public static final java.lang.String a = com.umeng.analytics.pro.ay.b().b(com.umeng.analytics.pro.ay.l);
    public static final java.lang.String b = "key_umeng_sp_honor_oaid";
    private static final java.lang.String c = "honor_oaid";
    private android.content.Context d;

    public c(android.content.Context context) {
        super(c);
        this.d = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public java.lang.String f() {
        if (!com.umeng.commonsdk.UMConfigure.shouldCollectOaid()) {
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>*** HonorOaidTracker.getId(): oaid开关已关闭。");
            return null;
        }
        if (!com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return null;
        }
        try {
            android.content.SharedPreferences sharedPreferences = this.d.getSharedPreferences(a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(b, "");
            }
            return null;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
