package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class eg implements com.xiaomi.push.ey {
    com.xiaomi.push.service.c a;
    com.xiaomi.push.ev b;
    java.lang.Exception c;
    private int d;
    private long j;
    private long k;
    private long f = 0;
    private long g = 0;
    private long h = 0;
    private long i = 0;
    private java.lang.String e = "";

    public eg(com.xiaomi.push.service.c cVar) {
        this.j = 0L;
        this.k = 0L;
        this.a = cVar;
        b();
        int myUid = android.os.Process.myUid();
        try {
            this.k = android.net.TrafficStats.getUidRxBytes(myUid);
            this.j = android.net.TrafficStats.getUidTxBytes(myUid);
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("Failed to obtain traffic data during initialization: ".concat(java.lang.String.valueOf(e)));
            this.k = -1L;
            this.j = -1L;
        }
    }

    private void b() {
        this.g = 0L;
        this.i = 0L;
        this.f = 0L;
        this.h = 0L;
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        if (com.xiaomi.push.ai.a(this.a)) {
            this.f = elapsedRealtime;
        }
        if (this.a.b()) {
            this.h = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.e + " netDuration = " + this.g + " ChannelDuration = " + this.i + " channelConnectedTime = " + this.h);
        com.xiaomi.push.ea eaVar = new com.xiaomi.push.ea();
        eaVar.a = (byte) 0;
        eaVar.a(com.xiaomi.push.dy.CHANNEL_ONLINE_RATE.af);
        eaVar.d = this.e;
        eaVar.d((int) (java.lang.System.currentTimeMillis() / 1000));
        eaVar.b((int) (this.g / 1000));
        eaVar.c((int) (this.i / 1000));
        com.xiaomi.push.eh.a.a.a(eaVar);
        b();
    }

    public final synchronized void a() {
        com.xiaomi.push.service.c cVar = this.a;
        if (cVar == null) {
            return;
        }
        java.lang.String i = com.xiaomi.push.ai.i(cVar);
        boolean b = com.xiaomi.push.ai.b(this.a);
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        long j = this.f;
        if (j > 0) {
            this.g += elapsedRealtime - j;
            this.f = 0L;
        }
        long j2 = this.h;
        if (j2 != 0) {
            this.i += elapsedRealtime - j2;
            this.h = 0L;
        }
        if (b) {
            if ((!android.text.TextUtils.equals(this.e, i) && this.g > 30000) || this.g > 5400000) {
                c();
            }
            this.e = i;
            if (this.f == 0) {
                this.f = elapsedRealtime;
            }
            if (this.a.b()) {
                this.h = elapsedRealtime;
            }
        }
    }

    @Override // com.xiaomi.push.ey
    public final void a(com.xiaomi.push.ev evVar) {
        this.d = 0;
        this.c = null;
        this.b = evVar;
        this.e = com.xiaomi.push.ai.i(this.a);
        com.xiaomi.push.ej.a(com.xiaomi.push.dy.CONN_SUCCESS.af);
    }

    @Override // com.xiaomi.push.ey
    public final void a(com.xiaomi.push.ev evVar, int i, java.lang.Exception exc) {
        long j;
        long j2;
        if (this.d == 0 && this.c == null) {
            this.d = i;
            this.c = exc;
            com.xiaomi.push.ej.b(evVar.e(), exc);
        }
        if (i == 22 && this.h != 0) {
            long g = evVar.g() - this.h;
            if (g < 0) {
                g = 0;
            }
            this.i += g + (com.xiaomi.push.fc.c() / 2);
            this.h = 0L;
        }
        a();
        int myUid = android.os.Process.myUid();
        try {
            j = android.net.TrafficStats.getUidRxBytes(myUid);
            j2 = android.net.TrafficStats.getUidTxBytes(myUid);
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("Failed to obtain traffic data: ".concat(java.lang.String.valueOf(e)));
            j = -1;
            j2 = -1;
        }
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j - this.k) + ", tx=" + (j2 - this.j));
        this.k = j;
        this.j = j2;
    }

    @Override // com.xiaomi.push.ey
    public final void a(com.xiaomi.push.ev evVar, java.lang.Exception exc) {
        com.xiaomi.push.ej.a(com.xiaomi.push.dy.CHANNEL_CON_FAIL.af, 1, evVar.e(), com.xiaomi.push.ai.b(this.a) ? 1 : 0);
        a();
    }

    @Override // com.xiaomi.push.ey
    public final void b(com.xiaomi.push.ev evVar) {
        a();
        this.h = android.os.SystemClock.elapsedRealtime();
        com.xiaomi.push.ej.a(com.xiaomi.push.dy.CONN_SUCCESS.af, evVar.e(), evVar.k());
    }
}
