package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class p {
    android.os.Handler a;
    volatile boolean b;
    int c;
    volatile com.xiaomi.push.p.b d;
    private com.xiaomi.push.p.a e;
    private final boolean f;

    public class a extends java.lang.Thread {
        final java.util.concurrent.LinkedBlockingQueue<com.xiaomi.push.p.b> a;

        public a() {
            super("PackageProcessor");
            this.a = new java.util.concurrent.LinkedBlockingQueue<>();
        }

        private void a(int i, com.xiaomi.push.p.b bVar) {
            try {
                android.os.Handler handler = com.xiaomi.push.p.this.a;
                handler.sendMessage(handler.obtainMessage(i, bVar));
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            int i = com.xiaomi.push.p.this.c;
            long j = i > 0 ? i : Long.MAX_VALUE;
            while (!com.xiaomi.push.p.this.b) {
                try {
                    com.xiaomi.push.p.b poll = this.a.poll(j, java.util.concurrent.TimeUnit.SECONDS);
                    com.xiaomi.push.p.this.d = poll;
                    if (poll != null) {
                        a(0, poll);
                        poll.a();
                        a(1, poll);
                    } else {
                        com.xiaomi.push.p pVar = com.xiaomi.push.p.this;
                        if (pVar.c > 0) {
                            pVar.a();
                        }
                    }
                } catch (java.lang.InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }
    }

    public static abstract class b {
        public abstract void a();

        public void b() {
        }
    }

    public p() {
        this(false);
    }

    public p(boolean z) {
        this(z, 0);
    }

    public p(boolean z, int i) {
        this.a = null;
        this.b = false;
        this.c = 0;
        this.a = new com.xiaomi.push.q(this, android.os.Looper.getMainLooper());
        this.f = z;
        this.c = i;
    }

    public final synchronized void a() {
        this.e = null;
        this.b = true;
    }

    public final synchronized void a(com.xiaomi.push.p.b bVar) {
        if (this.e == null) {
            com.xiaomi.push.p.a aVar = new com.xiaomi.push.p.a();
            this.e = aVar;
            aVar.setDaemon(this.f);
            this.b = false;
            this.e.start();
        }
        try {
            this.e.a.add(bVar);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(com.xiaomi.push.p.b bVar, long j) {
        this.a.postDelayed(new com.xiaomi.push.r(this, bVar), j);
    }
}
