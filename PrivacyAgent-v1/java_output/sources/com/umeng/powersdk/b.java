package com.umeng.powersdk;

/* loaded from: classes19.dex */
public final class b {
    private static android.content.Context a;

    public static class a {
        private static final com.umeng.powersdk.b a = new com.umeng.powersdk.b((byte) 0);
    }

    private b() {
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static com.umeng.powersdk.b a(android.content.Context context) {
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
        return com.umeng.powersdk.b.a.a;
    }

    public final synchronized com.umeng.powersdk.a a() {
        com.umeng.powersdk.a aVar;
        com.umeng.powersdk.a aVar2 = null;
        try {
            android.content.Intent registerReceiver = a.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int i = 0;
            int intExtra = registerReceiver.getIntExtra(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, 0);
            int intExtra2 = registerReceiver.getIntExtra("voltage", 0);
            int intExtra3 = registerReceiver.getIntExtra("temperature", 0);
            int intExtra4 = registerReceiver.getIntExtra("status", 0);
            int i2 = -1;
            if (intExtra4 != 1) {
                if (intExtra4 == 2) {
                    i2 = 1;
                } else if (intExtra4 == 3 || intExtra4 == 4) {
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
            aVar = new com.umeng.powersdk.a();
            try {
                aVar.a = intExtra;
                aVar.b = intExtra2;
                aVar.d = i2;
                aVar.c = intExtra3;
                aVar.e = i;
                aVar.f = java.lang.System.currentTimeMillis();
            } catch (java.lang.Throwable unused) {
                aVar2 = aVar;
                aVar = aVar2;
                return aVar;
            }
        } catch (java.lang.Throwable unused2) {
        }
        return aVar;
    }
}
