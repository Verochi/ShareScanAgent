package com.anythink.core.common.b;

/* loaded from: classes12.dex */
public class l {
    private static volatile com.anythink.core.common.b.l b;
    android.content.Context a;

    private l(android.content.Context context) {
        this.a = context;
    }

    public static com.anythink.core.common.b.l a(android.content.Context context) {
        if (b == null) {
            synchronized (com.anythink.core.common.b.l.class) {
                if (b == null) {
                    b = new com.anythink.core.common.b.l(context.getApplicationContext());
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
