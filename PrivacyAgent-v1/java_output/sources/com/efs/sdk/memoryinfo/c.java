package com.efs.sdk.memoryinfo;

/* loaded from: classes22.dex */
final class c {
    final java.lang.String activity;
    final java.lang.String bg;
    final long n;
    final long o;
    final long p;
    final long q;
    final float r;

    /* renamed from: s, reason: collision with root package name */
    final long f305s;
    final long t;

    public c(android.content.Context context) {
        android.os.Debug.MemoryInfo[] processMemoryInfo;
        android.os.Debug.MemoryInfo memoryInfo = null;
        try {
            android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{android.os.Process.myPid()})) != null && processMemoryInfo.length > 0) {
                memoryInfo = processMemoryInfo[0];
            }
        } catch (java.lang.Throwable unused) {
        }
        if (memoryInfo == null) {
            memoryInfo = new android.os.Debug.MemoryInfo();
            android.os.Debug.getMemoryInfo(memoryInfo);
        }
        this.bg = com.efs.sdk.memoryinfo.UMMemoryMonitor.get().isForeground() ? "fg" : "bg";
        this.n = memoryInfo.getTotalPss() * 1024;
        this.o = memoryInfo.dalvikPss * 1024;
        this.p = memoryInfo.nativePss * 1024;
        this.f305s = com.efs.sdk.memoryinfo.f.a(memoryInfo) * 1024;
        long freeMemory = java.lang.Runtime.getRuntime().totalMemory() - java.lang.Runtime.getRuntime().freeMemory();
        this.q = freeMemory;
        long maxMemory = java.lang.Runtime.getRuntime().maxMemory();
        if (maxMemory != 0) {
            this.r = (freeMemory * 1.0f) / maxMemory;
        } else {
            this.r = 1.0f;
        }
        this.t = com.efs.sdk.memoryinfo.f.a() * 1024;
        this.activity = com.efs.sdk.memoryinfo.UMMemoryMonitor.get().getCurrentActivity();
    }
}
