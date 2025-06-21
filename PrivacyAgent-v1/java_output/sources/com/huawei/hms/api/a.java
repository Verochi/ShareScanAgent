package com.huawei.hms.api;

/* loaded from: classes22.dex */
class a {
    static final com.huawei.hms.api.a b = new com.huawei.hms.api.a();
    private static final java.lang.Object c = new java.lang.Object();
    java.util.List<android.app.Activity> a = new java.util.ArrayList(1);

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
