package com.vivo.push;

/* loaded from: classes19.dex */
public abstract class q {
    protected android.content.Context a;
    protected android.os.Handler b;
    private final java.lang.Object c = new java.lang.Object();

    public class a extends android.os.Handler {
        public a(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            com.vivo.push.q.this.b(message);
        }
    }

    public q() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread(getClass().getSimpleName(), 1);
        handlerThread.start();
        this.b = new com.vivo.push.q.a(handlerThread.getLooper());
    }

    public final void a(android.content.Context context) {
        this.a = context;
    }

    public final void a(android.os.Message message) {
        synchronized (this.c) {
            android.os.Handler handler = this.b;
            if (handler == null) {
                java.lang.String str = "Dead worker dropping a message: " + message.what;
                com.vivo.push.util.p.e(getClass().getSimpleName(), str + " (Thread " + java.lang.Thread.currentThread().getId() + ")");
            } else {
                handler.sendMessage(message);
            }
        }
    }

    public abstract void b(android.os.Message message);
}
