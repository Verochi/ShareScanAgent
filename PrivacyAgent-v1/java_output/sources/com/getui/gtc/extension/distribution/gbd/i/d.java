package com.getui.gtc.extension.distribution.gbd.i;

/* loaded from: classes22.dex */
public final class d extends android.content.BroadcastReceiver {
    private static final java.lang.String a = "GBD_SDRRT";

    /* renamed from: com.getui.gtc.extension.distribution.gbd.i.d$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            int i = com.getui.gtc.extension.distribution.gbd.d.h.ad + 1;
            com.getui.gtc.extension.distribution.gbd.d.h.ad = i;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a(i);
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.d(com.getui.gtc.extension.distribution.gbd.d.h.ae);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        java.lang.StringBuilder sb;
        java.lang.String str;
        if (com.getui.gtc.extension.distribution.gbd.f.g.a.a.a()) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "gbd cron ido closed, SDRRT can't be executed");
            return;
        }
        if (com.getui.gtc.extension.distribution.gbd.d.h.ad < 50) {
            long C = com.getui.gtc.extension.distribution.gbd.n.l.C();
            if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.h.ae)) {
                sb = new java.lang.StringBuilder();
                str = com.getui.gtc.extension.distribution.gbd.d.h.ae;
            } else {
                sb = new java.lang.StringBuilder();
                sb.append(com.getui.gtc.extension.distribution.gbd.d.h.ae);
                str = "#";
            }
            sb.append(str);
            sb.append(C);
            com.getui.gtc.extension.distribution.gbd.d.h.ae = sb.toString();
            com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.i.d.AnonymousClass1());
        }
    }
}
