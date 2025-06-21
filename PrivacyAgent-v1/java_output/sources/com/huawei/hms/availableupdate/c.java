package com.huawei.hms.availableupdate;

/* loaded from: classes22.dex */
public class c {
    public static final com.huawei.hms.availableupdate.c b = new com.huawei.hms.availableupdate.c();
    public static final java.lang.Object c = new java.lang.Object();
    public final java.util.List<android.app.Activity> a = new java.util.ArrayList(1);

    public void a(android.app.Activity activity) {
        synchronized (c) {
            for (android.app.Activity activity2 : this.a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.a.add(activity);
        }
    }

    public void b(android.app.Activity activity) {
        synchronized (c) {
            this.a.remove(activity);
        }
    }
}
