package com.umeng.commonsdk.statistics.idtracking;

/* loaded from: classes19.dex */
public class k extends com.umeng.commonsdk.statistics.idtracking.a {
    private static final java.lang.String a = "utdid";
    private android.content.Context b;

    public k(android.content.Context context) {
        super("utdid");
        this.b = context;
    }

    private java.lang.String g() {
        try {
            return this.b.getSharedPreferences("Alvin2", 0).getString("UTDID2", null);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private java.lang.String h() {
        try {
            return this.b.getSharedPreferences("um_push_ut", 0).getString("d_id", null);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public java.lang.String f() {
        try {
            if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.u)) {
                java.lang.String h = h();
                return android.text.TextUtils.isEmpty(h) ? g() : h;
            }
        } catch (java.lang.Throwable unused) {
        }
        return null;
    }
}
