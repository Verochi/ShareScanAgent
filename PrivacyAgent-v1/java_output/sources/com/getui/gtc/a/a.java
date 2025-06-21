package com.getui.gtc.a;

/* loaded from: classes22.dex */
public final class a {
    private static final java.util.concurrent.atomic.AtomicBoolean a = new java.util.concurrent.atomic.AtomicBoolean(false);

    public static java.lang.String a(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? "" : str.contains("|") ? str.replace("|", "$") : str;
    }

    public static void a() {
        if (a.getAndSet(true)) {
            return;
        }
        com.getui.gtc.a.b[] bVarArr = {new com.getui.gtc.a.d(), new com.getui.gtc.a.e(), new com.getui.gtc.a.f()};
        for (int i = 0; i < 3; i++) {
            com.getui.gtc.base.util.ScheduleQueue.getInstance().addSchedule(bVarArr[i], 10000L);
        }
    }

    public static void a(int i) {
        if (i == 256) {
            com.getui.gtc.a.c.a();
        }
    }
}
