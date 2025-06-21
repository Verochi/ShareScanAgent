package com.huawei.hms.ads.identifier;

/* loaded from: classes22.dex */
public final class a implements android.content.ServiceConnection {
    public static final java.util.concurrent.ThreadPoolExecutor a = new java.util.concurrent.ThreadPoolExecutor(0, 3, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(2048), new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy());
    public boolean b = false;
    public final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> c = new java.util.concurrent.LinkedBlockingQueue<>(1);

    /* renamed from: com.huawei.hms.ads.identifier.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.os.IBinder a;

        public AnonymousClass1(android.os.IBinder iBinder) {
            this.a = iBinder;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                new java.lang.StringBuilder("onServiceConnected ").append(java.lang.System.currentTimeMillis());
                com.huawei.hms.ads.identifier.a.this.c.offer(this.a);
            } catch (java.lang.Throwable th) {
                new java.lang.StringBuilder("onServiceConnected  ").append(th.getClass().getSimpleName());
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        a.execute(new com.huawei.hms.ads.identifier.a.AnonymousClass1(iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(android.content.ComponentName componentName) {
        new java.lang.StringBuilder("onServiceDisconnected ").append(java.lang.System.currentTimeMillis());
    }
}
