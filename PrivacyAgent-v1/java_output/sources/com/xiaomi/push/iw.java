package com.xiaomi.push;

/* loaded from: classes19.dex */
public class iw {
    private static volatile android.os.Handler a;
    private static volatile android.os.Handler b;
    private static final java.lang.Object c = new java.lang.Object();

    public static android.content.Intent a(android.content.Context context, android.content.BroadcastReceiver broadcastReceiver, android.content.IntentFilter intentFilter) {
        if (context == null) {
            return null;
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, null, b());
    }

    public static android.os.Handler a() {
        if (b == null) {
            synchronized (c) {
                if (b == null) {
                    android.os.HandlerThread handlerThread = new android.os.HandlerThread("receiver_task");
                    handlerThread.start();
                    b = new android.os.Handler(handlerThread.getLooper());
                }
            }
        }
        return b;
    }

    public static void a(android.content.Context context, java.lang.Class<?> cls) {
        if (context == null) {
            return;
        }
        b().post(new com.xiaomi.push.ix(context, new android.content.ComponentName(context, cls)));
    }

    private static android.os.Handler b() {
        if (a == null) {
            synchronized (com.xiaomi.push.iw.class) {
                if (a == null) {
                    android.os.HandlerThread handlerThread = new android.os.HandlerThread("handle_receiver");
                    handlerThread.start();
                    a = new android.os.Handler(handlerThread.getLooper());
                }
            }
        }
        return a;
    }
}
