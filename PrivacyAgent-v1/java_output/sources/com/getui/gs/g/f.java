package com.getui.gs.g;

/* loaded from: classes22.dex */
public final class f {
    private final java.util.concurrent.atomic.AtomicBoolean a;
    private final java.util.concurrent.atomic.AtomicBoolean b;
    private final java.util.concurrent.atomic.AtomicBoolean c;
    private final java.util.List<com.getui.gs.f.c> d;

    public static class a {
        private static final com.getui.gs.g.f a = new com.getui.gs.g.f((byte) 0);
    }

    private f() {
        this.a = new java.util.concurrent.atomic.AtomicBoolean(true);
        this.b = new java.util.concurrent.atomic.AtomicBoolean(true);
        this.c = new java.util.concurrent.atomic.AtomicBoolean(true);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.d = arrayList;
        arrayList.add(new com.getui.gs.f.d(11));
        arrayList.add(new com.getui.gs.f.d(8));
    }

    public /* synthetic */ f(byte b) {
        this();
    }

    private long a(int i) {
        com.getui.gs.b.e eVar;
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean;
        eVar = com.getui.gs.b.e.a.a;
        long a2 = eVar.a.a();
        boolean z = false;
        if (i != 8) {
            if (i == 11) {
                atomicBoolean = this.c;
            }
            if (com.getui.gs.a.d.a != 1 && z) {
                return a2;
            }
        }
        atomicBoolean = this.a;
        z = atomicBoolean.getAndSet(false);
        return com.getui.gs.a.d.a != 1 ? 0L : 0L;
    }

    private com.getui.gs.g.e a(int i, java.lang.String str, long j, long j2) {
        com.getui.gs.g.e eVar = new com.getui.gs.g.e();
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        eVar.b = currentTimeMillis;
        eVar.c = i;
        eVar.e = str;
        eVar.d = currentTimeMillis + "|" + a(i) + "|" + j + "#" + j2;
        eVar.f = com.getui.gs.a.d.f();
        eVar.g = com.getui.gs.h.d.a();
        eVar.h = com.getui.gs.a.d.h();
        eVar.i = com.getui.gs.h.a.a.b();
        eVar.j = com.getui.gs.a.d.i();
        return eVar;
    }

    private static long d(long j) {
        com.getui.gs.b.e eVar;
        eVar = com.getui.gs.b.e.a.a;
        long a2 = eVar.a.a(6);
        return (j <= 0 || java.lang.Math.abs(j - a2) <= 2000) ? a2 : j;
    }

    public final void a() throws java.lang.Throwable {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        a(currentTimeMillis, false);
        c(currentTimeMillis);
        b();
    }

    public final void a(int i, long j, long j2) throws java.lang.Throwable {
        com.getui.gs.b.e eVar;
        com.getui.gs.b.e eVar2;
        com.getui.gtc.base.log.Logger logger;
        java.lang.String str;
        if (i == 11 && !com.getui.gs.c.a.a("sdk.ido.type11.enable", true)) {
            logger = com.getui.gs.h.b.a.a.a;
            str = "t11 closed";
        } else {
            if (i != 8 || com.getui.gs.c.a.a("sdk.ido.type8.enable", true)) {
                com.getui.gs.g.e a2 = a(i, com.getui.gs.h.e.a(com.getui.gs.a.d.d(), com.getui.gs.a.d.e(), j), j, j2);
                eVar = com.getui.gs.b.e.a.a;
                com.getui.gs.b.f fVar = eVar.c;
                com.getui.gs.g.e a3 = fVar.a(a2.e, a2.c);
                if (a3 == null) {
                    fVar.a(a2);
                } else {
                    org.json.JSONObject jSONObject = a3.k;
                    jSONObject.put(com.liulishuo.filedownloader.model.FileDownloadModel.TOTAL, com.getui.gs.g.c.a(i, jSONObject.getString(com.liulishuo.filedownloader.model.FileDownloadModel.TOTAL)));
                    a2.a(jSONObject);
                    fVar.a(a3, a2);
                }
                if (i == 11 || i == 8) {
                    com.getui.gs.g.a aVar = new com.getui.gs.g.a();
                    aVar.b = a2.b;
                    aVar.d = a2.e;
                    aVar.c = i;
                    aVar.e = j;
                    aVar.f = j2;
                    eVar2 = com.getui.gs.b.e.a.a;
                    eVar2.d.a(aVar, com.getui.gs.g.c.a(i));
                    return;
                }
                return;
            }
            logger = com.getui.gs.h.b.a.a.a;
            str = "t8 closed";
        }
        logger.d(str);
    }

    public final void a(long j) throws java.lang.Throwable {
        if (com.getui.gtc.base.util.CommonUtil.isAppForeground() && this.b.getAndSet(false)) {
            b(j);
        }
    }

    public final void a(long j, boolean z) throws java.lang.Throwable {
        com.getui.gs.b.e eVar;
        com.getui.gs.b.e eVar2;
        if (z || com.getui.gtc.base.util.CommonUtil.isAppForeground()) {
            eVar = com.getui.gs.b.e.a.a;
            eVar.a.a(5, j);
            com.getui.gs.h.b.a.a.a.d("Type8 onSessionUpdate: session end time updated");
            eVar2 = com.getui.gs.b.e.a.a;
            long c = eVar2.a.c();
            long j2 = j - c;
            if (j2 >= com.getui.gs.ias.core.GsConfig.getMinAppActiveDuration() && j2 <= com.getui.gs.ias.core.GsConfig.getMaxAppActiveDuration()) {
                a(8, c, j);
                return;
            }
            com.getui.gs.h.b.a.a.a.d("Type8 onSessionUpdate: the session duration " + j2 + " is invalid, must be the area of " + com.getui.gs.ias.core.GsConfig.getMinAppActiveDuration() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR + com.getui.gs.ias.core.GsConfig.getMaxAppActiveDuration());
        }
    }

    public final void b() {
        java.util.Iterator<com.getui.gs.f.c> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public final void b(long j) throws java.lang.Throwable {
        com.getui.gs.b.e eVar;
        com.getui.gs.b.e eVar2;
        if (com.getui.gtc.base.util.CommonUtil.isAppForeground()) {
            long d = d(j);
            eVar = com.getui.gs.b.e.a.a;
            eVar.a.a(4, d);
            eVar2 = com.getui.gs.b.e.a.a;
            eVar2.a.a(5, d);
            if (com.getui.gs.ias.core.GsConfig.getMinAppActiveDuration() <= 0) {
                com.getui.gs.h.b.a.a.a.d("Type8 onNewSession: new session created");
                a(8, d, d);
            }
        }
    }

    public final void c(long j) throws java.lang.Throwable {
        com.getui.gs.b.e eVar;
        com.getui.gs.b.e eVar2;
        eVar = com.getui.gs.b.e.a.a;
        eVar.a.a(7, j);
        com.getui.gs.h.b.a.a.a.d("Type11 onSessionUpdate: session end time updated");
        eVar2 = com.getui.gs.b.e.a.a;
        a(11, eVar2.a.a(6), j);
    }
}
