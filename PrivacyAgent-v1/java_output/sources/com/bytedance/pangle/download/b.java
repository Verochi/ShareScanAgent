package com.bytedance.pangle.download;

/* loaded from: classes12.dex */
public class b {
    private static volatile com.bytedance.pangle.download.b e;
    final java.util.Map<java.lang.String, java.lang.Long> a = new java.util.concurrent.ConcurrentHashMap();
    public final android.os.Handler b = new android.os.Handler(android.os.Looper.getMainLooper());
    public final java.util.Map<java.lang.String, java.lang.Runnable> c = new java.util.concurrent.ConcurrentHashMap();
    final java.util.Map<java.lang.String, java.lang.Runnable> d = new java.util.concurrent.ConcurrentHashMap();

    /* renamed from: com.bytedance.pangle.download.b$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0024, code lost:
        
            r0 = r0.get(0).topActivity;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            java.util.List<android.app.ActivityManager.RunningTaskInfo> runningTasks;
            android.content.ComponentName componentName;
            android.app.Application appApplication = com.bytedance.pangle.Zeus.getAppApplication();
            java.lang.String packageName = appApplication.getPackageName();
            boolean z = false;
            if (!android.text.TextUtils.isEmpty(packageName) && (runningTasks = ((android.app.ActivityManager) appApplication.getSystemService("activity")).getRunningTasks(1)) != null && !runningTasks.isEmpty() && componentName != null && packageName.equals(componentName.getPackageName())) {
                z = true;
            }
            if (z) {
                com.bytedance.pangle.download.b.this.b.postDelayed(this, 1800000L);
            }
        }
    }

    private b() {
    }

    public static com.bytedance.pangle.download.b a() {
        if (e == null) {
            synchronized (com.bytedance.pangle.download.b.class) {
                if (e == null) {
                    e = new com.bytedance.pangle.download.b();
                }
            }
        }
        return e;
    }
}
