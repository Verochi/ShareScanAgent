package com.meizu.cloud.pushsdk.b.a;

/* loaded from: classes23.dex */
public class a {
    private android.app.AlarmManager a;
    private android.content.Context b;
    private java.lang.Runnable c;
    private long d;
    private int e;
    private com.meizu.cloud.pushsdk.b.a.a.C0420a f;
    private android.app.PendingIntent g;
    private java.lang.String h;
    private boolean i;

    /* renamed from: com.meizu.cloud.pushsdk.b.a.a$a, reason: collision with other inner class name */
    public class C0420a extends android.content.BroadcastReceiver {
        private C0420a() {
        }

        public /* synthetic */ C0420a(com.meizu.cloud.pushsdk.b.a.a aVar, com.meizu.cloud.pushsdk.b.a.a.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            if (intent == null || !intent.getAction().equals("alarm.util")) {
                return;
            }
            com.meizu.cloud.pushinternal.DebugLogger.i("AlarmUtils", "on receive delayed task, keyword: " + com.meizu.cloud.pushsdk.b.a.a.this.h);
            com.meizu.cloud.pushsdk.b.a.a.this.i = true;
            com.meizu.cloud.pushsdk.b.a.a.this.c();
            com.meizu.cloud.pushsdk.b.a.a.this.c.run();
        }
    }

    public a(android.content.Context context, java.lang.Runnable runnable, long j) {
        this(context, runnable, j, true);
    }

    public a(android.content.Context context, java.lang.Runnable runnable, long j, boolean z) {
        android.content.Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.c = runnable;
        this.d = j;
        this.e = !z ? 1 : 0;
        this.a = (android.app.AlarmManager) applicationContext.getSystemService(androidx.core.app.NotificationCompat.CATEGORY_ALARM);
        this.i = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            com.meizu.cloud.pushsdk.b.a.a.C0420a c0420a = this.f;
            if (c0420a != null) {
                this.b.unregisterReceiver(c0420a);
                this.f = null;
            }
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("AlarmUtils", "clean error, " + e.getMessage());
        }
    }

    public boolean a() {
        if (!this.i) {
            com.meizu.cloud.pushinternal.DebugLogger.e("AlarmUtils", "last task not completed");
            return false;
        }
        this.i = false;
        com.meizu.cloud.pushsdk.b.a.a.C0420a c0420a = new com.meizu.cloud.pushsdk.b.a.a.C0420a(this, null);
        this.f = c0420a;
        this.b.registerReceiver(c0420a, new android.content.IntentFilter("alarm.util"));
        this.h = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
        this.g = android.app.PendingIntent.getBroadcast(this.b, 0, new android.content.Intent("alarm.util"), 1073741824);
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            this.a.setExactAndAllowWhileIdle(this.e, java.lang.System.currentTimeMillis() + this.d, this.g);
        } else {
            this.a.setExact(this.e, java.lang.System.currentTimeMillis() + this.d, this.g);
        }
        com.meizu.cloud.pushinternal.DebugLogger.i("AlarmUtils", "start delayed task, keyword: " + this.h);
        return true;
    }

    public void b() {
        if (this.a != null && this.g != null && !this.i) {
            com.meizu.cloud.pushinternal.DebugLogger.i("AlarmUtils", "cancel  delayed task, keyword: " + this.h);
            this.a.cancel(this.g);
        }
        c();
    }
}
