package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class eh {
    public boolean a = false;
    int b;
    long c;
    private java.lang.String d;
    private com.xiaomi.push.eg e;
    private com.xiaomi.push.ak f;

    public static class a {
        public static final com.xiaomi.push.eh a = new com.xiaomi.push.eh();
    }

    public eh() {
        com.xiaomi.push.ak akVar;
        akVar = com.xiaomi.push.ak.a.d;
        this.f = akVar;
    }

    private com.xiaomi.push.eb a(int i) {
        com.xiaomi.push.ea eaVar;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.xiaomi.push.eb ebVar = new com.xiaomi.push.eb(this.d, arrayList);
        if (!com.xiaomi.push.ai.d(this.e.a)) {
            ebVar.b = com.xiaomi.push.ib.i(this.e.a);
        }
        com.xiaomi.push.ip ipVar = new com.xiaomi.push.ip(i);
        com.xiaomi.push.ih a2 = new com.xiaomi.push.in.a().a(ipVar);
        try {
            ebVar.b(a2);
        } catch (com.xiaomi.push.ia unused) {
        }
        java.util.LinkedList<com.xiaomi.push.ak.a> b = this.f.b();
        while (b.size() > 0) {
            try {
                com.xiaomi.push.ak.a last = b.getLast();
                if (last.a == 0) {
                    java.lang.Object obj = last.c;
                    eaVar = obj instanceof com.xiaomi.push.ea ? (com.xiaomi.push.ea) obj : null;
                } else {
                    com.xiaomi.push.ea c = c();
                    c.a(com.xiaomi.push.dy.CHANNEL_STATS_COUNTER.af);
                    c.c(last.a);
                    c.g = last.b;
                    eaVar = c;
                }
                if (eaVar != null) {
                    eaVar.b(a2);
                }
                if (ipVar.a.size() > i) {
                    break;
                }
                if (eaVar != null) {
                    arrayList.add(eaVar);
                }
                b.removeLast();
            } catch (com.xiaomi.push.ia | java.util.NoSuchElementException unused2) {
            }
        }
        return ebVar;
    }

    public static com.xiaomi.push.eg a() {
        com.xiaomi.push.eg egVar;
        com.xiaomi.push.eh ehVar = com.xiaomi.push.eh.a.a;
        synchronized (ehVar) {
            egVar = ehVar.e;
        }
        return egVar;
    }

    public final synchronized void a(com.xiaomi.push.ea eaVar) {
        this.f.a(eaVar);
    }

    public final synchronized void a(com.xiaomi.push.service.c cVar) {
        this.e = new com.xiaomi.push.eg(cVar);
        this.d = "";
        com.xiaomi.push.service.ay.a().a(new com.xiaomi.push.ei(this));
    }

    public final synchronized com.xiaomi.push.eb b() {
        com.xiaomi.push.eb ebVar;
        boolean z = false;
        if (this.a && java.lang.System.currentTimeMillis() - this.c > this.b) {
            this.a = false;
            this.c = 0L;
        }
        if (this.a && this.f.a() > 0) {
            z = true;
        }
        if (z) {
            ebVar = a(!com.xiaomi.push.ai.d(this.e.a) ? 375 : 750);
        } else {
            ebVar = null;
        }
        return ebVar;
    }

    public final synchronized com.xiaomi.push.ea c() {
        com.xiaomi.push.ea eaVar;
        eaVar = new com.xiaomi.push.ea();
        eaVar.d = com.xiaomi.push.ai.i(this.e.a);
        eaVar.a = (byte) 0;
        eaVar.c = 1;
        eaVar.d((int) (java.lang.System.currentTimeMillis() / 1000));
        return eaVar;
    }
}
