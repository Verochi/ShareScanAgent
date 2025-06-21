package com.aliyun.svideosdk.multirecorder.impl.c;

/* loaded from: classes12.dex */
public class c {
    private static int i;
    private volatile com.aliyun.svideosdk.multirecorder.impl.c.c.EnumC0105c a;
    private long b;
    private boolean c;
    private java.lang.Object d;
    private android.os.HandlerThread e;
    private android.os.Handler f;
    private int g;
    private com.aliyun.svideosdk.multirecorder.impl.c.c.b h;

    public class a extends android.os.Handler {
        public a(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what != 101) {
                return;
            }
            com.aliyun.svideosdk.multirecorder.impl.c.c.this.b();
        }
    }

    public interface b {
        void g();
    }

    /* renamed from: com.aliyun.svideosdk.multirecorder.impl.c.c$c, reason: collision with other inner class name */
    public enum EnumC0105c {
        START,
        STOP,
        DESTROY
    }

    public c(int i2, com.aliyun.svideosdk.multirecorder.impl.c.c.b bVar) {
        this.a = com.aliyun.svideosdk.multirecorder.impl.c.c.EnumC0105c.STOP;
        this.b = 33L;
        this.c = false;
        this.d = new java.lang.Object();
        this.g = i2;
        this.h = bVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c(com.aliyun.svideosdk.multirecorder.impl.c.c.b bVar) {
        this(r0, bVar);
        int i2 = i + 1;
        i = i2;
    }

    private void a(com.aliyun.svideosdk.multirecorder.impl.c.c.EnumC0105c enumC0105c) {
        this.a = enumC0105c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.a != com.aliyun.svideosdk.multirecorder.impl.c.c.EnumC0105c.START) {
            return;
        }
        com.aliyun.svideosdk.multirecorder.impl.c.c.b bVar = this.h;
        if (bVar != null) {
            bVar.g();
        }
        synchronized (this.d) {
            android.os.Handler handler = this.f;
            if (handler != null) {
                handler.removeMessages(101);
                this.f.sendEmptyMessageDelayed(101, this.b);
            }
        }
    }

    private void c() {
        if (this.c) {
            return;
        }
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("CaptureTimer_" + this.g);
        this.e = handlerThread;
        handlerThread.start();
        this.f = new com.aliyun.svideosdk.multirecorder.impl.c.c.a(this.e.getLooper());
    }

    public synchronized void a() {
        com.aliyun.svideosdk.multirecorder.impl.c.c.EnumC0105c enumC0105c = this.a;
        com.aliyun.svideosdk.multirecorder.impl.c.c.EnumC0105c enumC0105c2 = com.aliyun.svideosdk.multirecorder.impl.c.c.EnumC0105c.DESTROY;
        if (enumC0105c == enumC0105c2) {
            return;
        }
        d();
        a(enumC0105c2);
        if (this.c) {
            synchronized (this.d) {
                try {
                    this.e.interrupt();
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                this.e = null;
                this.f = null;
            }
        }
    }

    public void a(int i2) {
        if (i2 <= 0) {
            throw new java.lang.RuntimeException("Fps should be greater than 0");
        }
        this.b = (long) (1000.0f / i2);
    }

    public synchronized void a(boolean z) {
        c();
        if (this.a != com.aliyun.svideosdk.multirecorder.impl.c.c.EnumC0105c.STOP) {
            return;
        }
        a(com.aliyun.svideosdk.multirecorder.impl.c.c.EnumC0105c.START);
        if (z) {
            this.f.sendEmptyMessage(101);
        } else {
            this.f.sendEmptyMessageDelayed(101, this.b);
        }
    }

    public synchronized void d() {
        if (this.a != com.aliyun.svideosdk.multirecorder.impl.c.c.EnumC0105c.START) {
            return;
        }
        a(com.aliyun.svideosdk.multirecorder.impl.c.c.EnumC0105c.STOP);
        this.f.removeMessages(101);
    }
}
