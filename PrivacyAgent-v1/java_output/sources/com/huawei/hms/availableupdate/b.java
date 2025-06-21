package com.huawei.hms.availableupdate;

/* loaded from: classes22.dex */
public class b {
    public static final com.huawei.hms.availableupdate.b c = new com.huawei.hms.availableupdate.b();
    public static final java.lang.Object d = new java.lang.Object();
    public final java.util.concurrent.atomic.AtomicBoolean a = new java.util.concurrent.atomic.AtomicBoolean(false);
    public java.util.List<android.app.Activity> b = new java.util.ArrayList(1);

    public java.util.concurrent.atomic.AtomicBoolean a() {
        return this.a;
    }

    public void a(android.app.Activity activity) {
        synchronized (d) {
            for (android.app.Activity activity2 : this.b) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.b.add(activity);
        }
    }

    public void a(boolean z) {
        this.a.set(z);
    }

    public void b(android.app.Activity activity) {
        synchronized (d) {
            this.b.remove(activity);
        }
    }
}
