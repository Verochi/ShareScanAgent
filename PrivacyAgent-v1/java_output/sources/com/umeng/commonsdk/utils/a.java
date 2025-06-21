package com.umeng.commonsdk.utils;

/* loaded from: classes19.dex */
public abstract class a {
    private static final int e = 1;
    private final long a;
    private final long b;
    private long c;
    private android.os.HandlerThread f;
    private android.os.Handler g;
    private boolean d = false;
    private android.os.Handler.Callback h = new com.umeng.commonsdk.utils.a.AnonymousClass1();

    /* renamed from: com.umeng.commonsdk.utils.a$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Handler.Callback {
        public AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            synchronized (com.umeng.commonsdk.utils.a.this) {
                if (com.umeng.commonsdk.utils.a.this.d) {
                    return true;
                }
                long elapsedRealtime = com.umeng.commonsdk.utils.a.this.c - android.os.SystemClock.elapsedRealtime();
                if (elapsedRealtime <= 0) {
                    com.umeng.commonsdk.utils.a.this.c();
                    if (com.umeng.commonsdk.utils.a.this.f != null) {
                        com.umeng.commonsdk.utils.a.this.f.quit();
                    }
                } else if (elapsedRealtime < com.umeng.commonsdk.utils.a.this.b) {
                    com.umeng.commonsdk.utils.a.this.g.sendMessageDelayed(com.umeng.commonsdk.utils.a.this.g.obtainMessage(1), elapsedRealtime);
                } else {
                    long elapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
                    com.umeng.commonsdk.utils.a.this.a(elapsedRealtime);
                    long elapsedRealtime3 = (elapsedRealtime2 + com.umeng.commonsdk.utils.a.this.b) - android.os.SystemClock.elapsedRealtime();
                    while (elapsedRealtime3 < 0) {
                        elapsedRealtime3 += com.umeng.commonsdk.utils.a.this.b;
                    }
                    com.umeng.commonsdk.utils.a.this.g.sendMessageDelayed(com.umeng.commonsdk.utils.a.this.g.obtainMessage(1), elapsedRealtime3);
                }
                return false;
            }
        }
    }

    public a(long j, long j2) {
        this.a = j;
        this.b = j2;
        if (d()) {
            this.g = new android.os.Handler(this.h);
            return;
        }
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("CountDownTimerThread");
        this.f = handlerThread;
        handlerThread.start();
        this.g = new android.os.Handler(this.f.getLooper(), this.h);
    }

    private boolean d() {
        return android.os.Looper.getMainLooper().getThread().equals(java.lang.Thread.currentThread());
    }

    public final synchronized void a() {
        this.d = true;
        this.g.removeMessages(1);
    }

    public abstract void a(long j);

    public final synchronized com.umeng.commonsdk.utils.a b() {
        this.d = false;
        if (this.a <= 0) {
            c();
            return this;
        }
        this.c = android.os.SystemClock.elapsedRealtime() + this.a;
        android.os.Handler handler = this.g;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }

    public abstract void c();
}
