package com.xiaomi.push;

/* loaded from: classes19.dex */
public class aw {
    private static volatile com.xiaomi.push.aw i;
    android.content.Context a;
    java.lang.String b;
    java.lang.String c;
    public com.xiaomi.push.bm d;
    private com.xiaomi.push.bn j;
    private final java.lang.String e = "push_stat_sp";
    private final java.lang.String f = "upload_time";
    private final java.lang.String g = "delete_time";
    private final java.lang.String h = "check_time";
    private com.xiaomi.push.m.a k = new com.xiaomi.push.ax(this);
    private com.xiaomi.push.m.a l = new com.xiaomi.push.ay(this);
    private com.xiaomi.push.m.a m = new com.xiaomi.push.ba(this);

    private aw(android.content.Context context) {
        this.a = context;
    }

    public static com.xiaomi.push.aw a(android.content.Context context) {
        if (i == null) {
            synchronized (com.xiaomi.push.aw.class) {
                if (i == null) {
                    i = new com.xiaomi.push.aw(context);
                }
            }
        }
        return i;
    }

    public static /* synthetic */ void a(com.xiaomi.push.aw awVar, java.lang.String str) {
        android.content.SharedPreferences.Editor edit = awVar.a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, java.lang.System.currentTimeMillis());
        edit.apply();
    }

    public final boolean a() {
        return com.xiaomi.push.service.ad.a(this.a).a(com.xiaomi.push.gp.StatDataSwitch.bw, true);
    }

    public final java.lang.String b() {
        return this.a.getDatabasePath(com.xiaomi.push.bb.a).getAbsolutePath();
    }
}
