package com.bytedance.pangle.download;

/* loaded from: classes12.dex */
public class a {
    private static volatile com.bytedance.pangle.download.a b;
    public final java.util.List<java.lang.String> a = new java.util.concurrent.CopyOnWriteArrayList();

    /* renamed from: com.bytedance.pangle.download.a$1, reason: invalid class name */
    public class AnonymousClass1 extends com.bytedance.pangle.a {
        public AnonymousClass1() {
        }

        @Override // com.bytedance.pangle.a, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(android.app.Activity activity) {
            java.util.Iterator it = com.bytedance.pangle.download.a.this.a.iterator();
            while (it.hasNext()) {
                it.next();
                com.bytedance.pangle.download.b.a();
            }
        }
    }

    public a() {
        com.bytedance.pangle.Zeus.getAppApplication().registerActivityLifecycleCallbacks(new com.bytedance.pangle.download.a.AnonymousClass1());
    }

    public static com.bytedance.pangle.download.a a() {
        if (b == null) {
            synchronized (com.bytedance.pangle.download.a.class) {
                if (b == null) {
                    b = new com.bytedance.pangle.download.a();
                }
            }
        }
        return b;
    }
}
