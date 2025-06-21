package com.umeng.commonsdk.internal.utils;

/* loaded from: classes19.dex */
public class c {
    private static final java.lang.String a = "BatteryUtils";
    private static boolean b;
    private static android.content.Context c;
    private android.content.BroadcastReceiver d;

    /* renamed from: com.umeng.commonsdk.internal.utils.c$1, reason: invalid class name */
    public class AnonymousClass1 extends android.content.BroadcastReceiver {
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            try {
                if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "ACTION_BATTERY_CHANGED：battery info cc.");
                    int i = 0;
                    int intExtra = intent.getIntExtra(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, 0);
                    int intExtra2 = intent.getIntExtra("voltage", 0);
                    int intExtra3 = intent.getIntExtra("temperature", 0);
                    int intExtra4 = intent.getIntExtra("status", 0);
                    int i2 = -1;
                    if (intExtra4 != 1) {
                        if (intExtra4 == 2) {
                            i2 = 1;
                        } else if (intExtra4 == 4) {
                            i2 = 0;
                        } else if (intExtra4 == 5) {
                            i2 = 2;
                        }
                    }
                    int intExtra5 = intent.getIntExtra("plugged", 0);
                    if (intExtra5 == 1) {
                        i = 1;
                    } else if (intExtra5 == 2) {
                        i = 2;
                    }
                    com.umeng.commonsdk.internal.utils.b bVar = new com.umeng.commonsdk.internal.utils.b();
                    bVar.a = intExtra;
                    bVar.b = intExtra2;
                    bVar.d = i2;
                    bVar.c = intExtra3;
                    bVar.e = i;
                    bVar.f = java.lang.System.currentTimeMillis();
                    com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, 32771, com.umeng.commonsdk.internal.b.a(com.umeng.commonsdk.internal.utils.c.c).a(), bVar);
                    com.umeng.commonsdk.internal.utils.c.this.c();
                }
            } catch (java.lang.Throwable th) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(com.umeng.commonsdk.internal.utils.c.c, th);
            }
        }
    }

    public static class a {
        private static final com.umeng.commonsdk.internal.utils.c a = new com.umeng.commonsdk.internal.utils.c(null);

        private a() {
        }
    }

    private c() {
        this.d = new com.umeng.commonsdk.internal.utils.c.AnonymousClass1();
    }

    public /* synthetic */ c(com.umeng.commonsdk.internal.utils.c.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.umeng.commonsdk.internal.utils.c a(android.content.Context context) {
        if (c == null && context != null) {
            c = context.getApplicationContext();
        }
        return com.umeng.commonsdk.internal.utils.c.a.a;
    }

    public synchronized boolean a() {
        return b;
    }

    public synchronized void b() {
        try {
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            c.registerReceiver(this.d, intentFilter);
            b = true;
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(c, th);
        }
    }

    public synchronized void c() {
        try {
            c.unregisterReceiver(this.d);
            b = false;
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(c, th);
        }
    }
}
