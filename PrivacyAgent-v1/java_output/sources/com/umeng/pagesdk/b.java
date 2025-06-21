package com.umeng.pagesdk;

/* loaded from: classes19.dex */
public final class b {
    private static boolean a;
    private static android.content.Context b;
    private com.umeng.pagesdk.b.InterfaceC0528b c;
    private android.content.BroadcastReceiver d;

    /* renamed from: com.umeng.pagesdk.b$1, reason: invalid class name */
    public class AnonymousClass1 extends android.content.BroadcastReceiver {
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            try {
                if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
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
                    com.umeng.pagesdk.a aVar = new com.umeng.pagesdk.a();
                    aVar.a = intExtra;
                    aVar.b = intExtra2;
                    aVar.d = i2;
                    aVar.c = intExtra3;
                    aVar.e = i;
                    aVar.f = java.lang.System.currentTimeMillis();
                    if (com.umeng.pagesdk.b.this.c != null) {
                        com.umeng.pagesdk.b.this.c.a(aVar);
                    }
                    com.umeng.pagesdk.b.this.b();
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static class a {
        private static final com.umeng.pagesdk.b a = new com.umeng.pagesdk.b((byte) 0);
    }

    /* renamed from: com.umeng.pagesdk.b$b, reason: collision with other inner class name */
    public interface InterfaceC0528b {
        void a(com.umeng.pagesdk.a aVar);
    }

    private b() {
        this.d = new com.umeng.pagesdk.b.AnonymousClass1();
    }

    public /* synthetic */ b(byte b2) {
        this();
    }

    public static com.umeng.pagesdk.b a(android.content.Context context) {
        if (b == null && context != null) {
            b = context.getApplicationContext();
        }
        return com.umeng.pagesdk.b.a.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        try {
            b.unregisterReceiver(this.d);
            a = false;
        } catch (java.lang.Throwable unused) {
        }
    }

    public final synchronized com.umeng.pagesdk.a a() {
        com.umeng.pagesdk.a aVar;
        int i;
        int intExtra;
        int intExtra2;
        int intExtra3;
        int i2;
        com.umeng.pagesdk.a aVar2 = null;
        try {
            android.content.Intent registerReceiver = b.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
            i = 0;
            intExtra = registerReceiver.getIntExtra(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, 0);
            intExtra2 = registerReceiver.getIntExtra("voltage", 0);
            intExtra3 = registerReceiver.getIntExtra("temperature", 0);
            int intExtra4 = registerReceiver.getIntExtra("status", 0);
            i2 = -1;
            if (intExtra4 != 1) {
                if (intExtra4 == 2) {
                    i2 = 1;
                } else if (intExtra4 == 4) {
                    i2 = 0;
                } else if (intExtra4 == 5) {
                    i2 = 2;
                }
            }
            int intExtra5 = registerReceiver.getIntExtra("plugged", 0);
            if (intExtra5 == 1) {
                i = 1;
            } else if (intExtra5 == 2) {
                i = 2;
            }
            aVar = new com.umeng.pagesdk.a();
        } catch (java.lang.Throwable unused) {
        }
        try {
            aVar.a = intExtra;
            aVar.b = intExtra2;
            aVar.d = i2;
            aVar.c = intExtra3;
            aVar.e = i;
            aVar.f = java.lang.System.currentTimeMillis();
        } catch (java.lang.Throwable unused2) {
            aVar2 = aVar;
            aVar = aVar2;
            return aVar;
        }
        return aVar;
    }

    public final synchronized void a(com.umeng.pagesdk.b.InterfaceC0528b interfaceC0528b) {
        try {
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            b.registerReceiver(this.d, intentFilter);
            a = true;
            this.c = interfaceC0528b;
        } catch (java.lang.Throwable unused) {
        }
    }
}
