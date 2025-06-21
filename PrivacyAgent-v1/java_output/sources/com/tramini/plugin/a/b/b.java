package com.tramini.plugin.a.b;

/* loaded from: classes19.dex */
public class b {
    private static volatile com.tramini.plugin.a.b.b b;
    android.content.Context a;

    private b(android.content.Context context) {
        this.a = context;
    }

    public static com.tramini.plugin.a.b.b a(android.content.Context context) {
        if (b == null) {
            synchronized (com.tramini.plugin.a.b.b.class) {
                if (b == null) {
                    b = new com.tramini.plugin.a.b.b(context.getApplicationContext());
                }
            }
        }
        return b;
    }

    public final void a(android.content.BroadcastReceiver broadcastReceiver) {
        try {
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this.a).unregisterReceiver(broadcastReceiver);
        } catch (java.lang.Throwable unused) {
        }
        try {
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this.a).unregisterReceiver(broadcastReceiver);
        } catch (java.lang.Throwable unused2) {
        }
    }

    public final void a(android.content.BroadcastReceiver broadcastReceiver, android.content.IntentFilter intentFilter) {
        try {
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this.a).registerReceiver(broadcastReceiver, intentFilter);
        } catch (java.lang.Throwable unused) {
        }
        try {
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this.a).registerReceiver(broadcastReceiver, intentFilter);
        } catch (java.lang.Throwable unused2) {
        }
    }

    public final void a(android.content.Intent intent) {
        try {
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this.a).sendBroadcast(intent);
        } catch (java.lang.Throwable unused) {
        }
        try {
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this.a).sendBroadcast(intent);
        } catch (java.lang.Throwable unused2) {
        }
    }
}
