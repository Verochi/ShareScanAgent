package com.getui.gtc.extension.distribution.gbd.i;

/* loaded from: classes22.dex */
public final class b extends android.content.BroadcastReceiver {
    private static final java.lang.String a = "GBD_NCRRT";

    /* renamed from: com.getui.gtc.extension.distribution.gbd.i.b$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ long a;

        public AnonymousClass1(long j) {
            this.a = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            long j = this.a;
            com.getui.gtc.extension.distribution.gbd.d.h.j = j;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a(com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_PACKET_SIZE, java.lang.String.valueOf(j));
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.i.b$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gtc.extension.distribution.gbd.n.j.b("NetworkChangeReceiver", "event collect in 5s.");
            com.getui.gtc.extension.distribution.gbd.a.b.f.f().a(2);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.i.b$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.i.b.a, "event collect in 5s.");
            com.getui.gtc.extension.distribution.gbd.a.a.c.f().a();
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        boolean z;
        boolean z2;
        if (intent == null) {
            return;
        }
        try {
            if (com.getui.gtc.extension.distribution.gbd.f.g.a.a.a()) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "gbd cron ido closed, NCRRT can't be executed");
                return;
            }
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z3 = false;
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                z = false;
                z2 = false;
            } else {
                z2 = activeNetworkInfo.getType() == 1;
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "isWifiMode = " + z2 + ", isConnected = true");
                z = activeNetworkInfo.getType() == 0;
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "isMobileMode = " + z + ", isConnected = true");
            }
            if (z2) {
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                long j = currentTimeMillis - com.getui.gtc.extension.distribution.gbd.d.h.j;
                long j2 = currentTimeMillis - com.getui.gtc.extension.distribution.gbd.d.h.R;
                long j3 = com.getui.gtc.extension.distribution.gbd.d.d.r;
                if (j >= j3 * 1000 && j2 >= j3 * 1000) {
                    z3 = true;
                }
                com.getui.gtc.extension.distribution.gbd.n.j.b("NetworkChangeReceiver", "eventEvent interval = " + (j / 1000) + ", eventTimer interval = " + (j2 / 1000) + ", type27CollectByEvent = " + com.getui.gtc.extension.distribution.gbd.d.d.q);
                if (z3 && com.getui.gtc.extension.distribution.gbd.d.d.q && com.getui.gtc.extension.distribution.gbd.d.h.b != null) {
                    com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.i.b.AnonymousClass1(currentTimeMillis));
                    com.getui.gtc.extension.distribution.gbd.d.h.b.postDelayed(new com.getui.gtc.extension.distribution.gbd.i.b.AnonymousClass2(), 5000L);
                }
            }
            try {
                intent.getAction();
                if (java.lang.System.currentTimeMillis() - com.getui.gtc.extension.distribution.gbd.d.h.bo > 1000) {
                    if (!com.getui.gtc.extension.distribution.gbd.d.h.bn) {
                        com.getui.gtc.extension.distribution.gbd.d.h.bn = true;
                        return;
                    }
                    com.getui.gtc.extension.distribution.gbd.n.j.a(a, " action = ".concat(java.lang.String.valueOf(intent)));
                    com.getui.gtc.extension.distribution.gbd.d.h.bn = true;
                    if (z) {
                        com.getui.gtc.extension.distribution.gbd.d.h.bo = java.lang.System.currentTimeMillis();
                        com.getui.gtc.extension.distribution.gbd.d.h.b.postDelayed(new com.getui.gtc.extension.distribution.gbd.i.b.AnonymousClass3(), 5000L);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        } catch (java.lang.Throwable th2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
        }
    }
}
