package com.vivo.push;

/* loaded from: classes19.dex */
public final class m {
    private static final android.os.Handler a = new android.os.Handler(android.os.Looper.getMainLooper());
    private static final android.os.HandlerThread b;
    private static final android.os.Handler c;

    static {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("push_client_thread");
        b = handlerThread;
        handlerThread.start();
        c = new com.vivo.push.n(handlerThread.getLooper());
    }

    public static void a(com.vivo.push.l lVar) {
        if (lVar == null) {
            com.vivo.push.util.p.a("PushClientThread", "client thread error, task is null!");
            return;
        }
        int a2 = lVar.a();
        android.os.Message message = new android.os.Message();
        message.what = a2;
        message.obj = lVar;
        c.sendMessageDelayed(message, 0L);
    }

    public static void a(java.lang.Runnable runnable) {
        android.os.Handler handler = c;
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 15000L);
    }

    public static void b(java.lang.Runnable runnable) {
        a.post(runnable);
    }

    public static void c(java.lang.Runnable runnable) {
        android.os.Handler handler = c;
        if (handler != null) {
            handler.post(runnable);
        }
    }
}
