package com.getui.gtc.extension.distribution.gbd.d;

/* loaded from: classes22.dex */
public class e {
    public static final java.lang.String a = ",";
    public static java.util.Map<java.lang.String, java.lang.String> b = new java.util.concurrent.ConcurrentHashMap();
    private static final java.lang.String c = "key";
    private static final java.lang.String d = "value";
    private static final java.lang.String e = "GBD_ConfigCore";
    private static com.getui.gtc.extension.distribution.gbd.d.e f;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.d.e$1, reason: invalid class name */
    public class AnonymousClass1 extends com.getui.gtc.extension.distribution.gbd.d.k {
        public AnonymousClass1() {
        }

        @Override // com.getui.gtc.extension.distribution.gbd.d.k
        public final void a(java.util.Map<java.lang.String, java.lang.String> map) {
            com.getui.gtc.extension.distribution.gbd.d.e.this.a(map);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.d.e$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.d.e.e, "start dl wlp file");
            com.getui.gtc.extension.distribution.gbd.n.b.l();
        }
    }

    public static int a(java.lang.String str, int i) {
        if (!b(str)) {
            return i;
        }
        try {
            return java.lang.Integer.valueOf(a(str)).intValue();
        } catch (java.lang.Exception e2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e, e2);
            return i;
        }
    }

    public static com.getui.gtc.extension.distribution.gbd.d.e a() {
        if (f == null) {
            synchronized (com.getui.gtc.extension.distribution.gbd.d.e.class) {
                if (f == null) {
                    f = new com.getui.gtc.extension.distribution.gbd.d.e();
                }
            }
        }
        return f;
    }

    private static java.lang.Boolean a(java.lang.String str, java.lang.Boolean bool) {
        if (!b(str)) {
            return bool;
        }
        try {
            return java.lang.Boolean.valueOf(a(str));
        } catch (java.lang.Exception e2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e, e2);
            return bool;
        }
    }

    private static java.lang.Long a(java.lang.String str, java.lang.Long l) {
        if (!b(str)) {
            return l;
        }
        try {
            return java.lang.Long.valueOf(a(str));
        } catch (java.lang.Exception e2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e, e2);
            return l;
        }
    }

    private static java.lang.Short a(java.lang.String str, java.lang.Short sh) {
        if (!b(str)) {
            return sh;
        }
        try {
            return java.lang.Short.valueOf(java.lang.Short.valueOf(a(str)).shortValue());
        } catch (java.lang.Exception e2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e, e2);
            return sh;
        }
    }

    private static java.lang.String a(java.lang.String str) {
        return b.get(str);
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (!b(str)) {
            return str2;
        }
        try {
            return a(str);
        } catch (java.lang.Exception e2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e, e2);
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map != null) {
            try {
                if (map.size() != 0) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(e, "| parseSdkConfig :  " + map.toString());
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                        b.put(entry.getKey(), entry.getValue());
                    }
                    c();
                    return;
                }
            } catch (java.lang.Throwable unused) {
                return;
            }
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_ConfigCore | parse sdk config data = null ");
    }

    private static byte[] a(java.lang.String str, byte[] bArr) {
        if (!b(str)) {
            return bArr;
        }
        try {
            return a(str).getBytes();
        } catch (java.lang.Exception e2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e, e2);
            return bArr;
        }
    }

    private static boolean b(java.lang.String str) {
        return b.containsKey(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0bd2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0d64  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0da6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0dae  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0f10  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0e0d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0db0  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0da8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c() {
        boolean z;
        boolean z2;
        java.lang.String a2;
        int a3;
        int a4;
        java.lang.String a5;
        java.lang.String a6;
        java.lang.String a7;
        com.getui.gtc.extension.distribution.gbd.b.a aVar;
        java.lang.String a8;
        long longValue;
        try {
            z = com.getui.gtc.extension.distribution.gbd.n.l.c(com.getui.gtc.extension.distribution.gbd.d.c.d);
            try {
                z2 = com.getui.gtc.extension.distribution.gbd.n.l.a();
            } catch (java.lang.Throwable th) {
                th = th;
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                z2 = true;
                java.lang.StringBuilder sb = new java.lang.StringBuilder("isAdbModeSafe = ");
                sb.append(!z);
                sb.append(", isAppDebug = ");
                sb.append(z2);
                com.getui.gtc.extension.distribution.gbd.n.j.a(e, sb.toString());
                a();
                com.getui.gtc.extension.distribution.gbd.d.d.v = a(com.getui.gtc.extension.distribution.gbd.d.a.S, com.getui.gtc.extension.distribution.gbd.d.d.v);
                com.getui.gtc.extension.distribution.gbd.d.d.x = a(com.getui.gtc.extension.distribution.gbd.d.a.c, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.x)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bT = a(com.getui.gtc.extension.distribution.gbd.d.a.ah, com.getui.gtc.extension.distribution.gbd.d.d.bT);
                com.getui.gtc.extension.distribution.gbd.d.d.bU = a(com.getui.gtc.extension.distribution.gbd.d.a.ai, com.getui.gtc.extension.distribution.gbd.d.d.bU);
                com.getui.gtc.extension.distribution.gbd.d.d.bV = a(com.getui.gtc.extension.distribution.gbd.d.a.aj, java.lang.Short.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bV)).shortValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bo = a(com.getui.gtc.extension.distribution.gbd.d.a.al, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bo)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bq = a(com.getui.gtc.extension.distribution.gbd.d.a.am, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bq)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.dl = a(com.getui.gtc.extension.distribution.gbd.d.a.dd, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dl)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.dm = a(com.getui.gtc.extension.distribution.gbd.d.a.de, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dm)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bJ = a(com.getui.gtc.extension.distribution.gbd.d.a.W, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bJ)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bI = a(com.getui.gtc.extension.distribution.gbd.d.a.X, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bI)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bK = a(com.getui.gtc.extension.distribution.gbd.d.a.Y, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bK)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bL = a(com.getui.gtc.extension.distribution.gbd.d.a.Z, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bL)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.at = a(com.getui.gtc.extension.distribution.gbd.d.a.d, com.getui.gtc.extension.distribution.gbd.d.d.at);
                com.getui.gtc.extension.distribution.gbd.d.d.aA = a(com.getui.gtc.extension.distribution.gbd.d.a.e, com.getui.gtc.extension.distribution.gbd.d.d.aA);
                com.getui.gtc.extension.distribution.gbd.d.d.aB = a(com.getui.gtc.extension.distribution.gbd.d.a.g, com.getui.gtc.extension.distribution.gbd.d.d.aB);
                com.getui.gtc.extension.distribution.gbd.d.d.aO = a(com.getui.gtc.extension.distribution.gbd.d.a.h, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aO)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.aP = a(com.getui.gtc.extension.distribution.gbd.d.a.i, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aP)).longValue();
                com.getui.gtc.extension.distribution.gbd.k.a.k.e().f();
                com.getui.gtc.extension.distribution.gbd.d.d.aR = a(com.getui.gtc.extension.distribution.gbd.d.a.j, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aR)).longValue();
                com.getui.gtc.extension.distribution.gbd.k.a.q.e().f();
                com.getui.gtc.extension.distribution.gbd.d.d.aS = a(com.getui.gtc.extension.distribution.gbd.d.a.k, com.getui.gtc.extension.distribution.gbd.d.d.aS);
                com.getui.gtc.extension.distribution.gbd.d.d.aT = a(com.getui.gtc.extension.distribution.gbd.d.a.l, com.getui.gtc.extension.distribution.gbd.d.d.aT);
                com.getui.gtc.extension.distribution.gbd.d.d.aU = a(com.getui.gtc.extension.distribution.gbd.d.a.m, com.getui.gtc.extension.distribution.gbd.d.d.aU);
                com.getui.gtc.extension.distribution.gbd.d.d.aV = a(com.getui.gtc.extension.distribution.gbd.d.a.n, com.getui.gtc.extension.distribution.gbd.d.d.aV);
                com.getui.gtc.extension.distribution.gbd.d.d.aW = a(com.getui.gtc.extension.distribution.gbd.d.a.o, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aW)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.aZ = a(com.getui.gtc.extension.distribution.gbd.d.a.p, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aZ)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.ba = a(com.getui.gtc.extension.distribution.gbd.d.a.q, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ba)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bb = a(com.getui.gtc.extension.distribution.gbd.d.a.r, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bb)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.be = a(com.getui.gtc.extension.distribution.gbd.d.a.f321s, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.be)).longValue();
                java.lang.String a9 = a(com.getui.gtc.extension.distribution.gbd.d.a.v, com.getui.gtc.extension.distribution.gbd.d.d.bf);
                com.getui.gtc.extension.distribution.gbd.d.d.bf = a9;
                a2 = com.getui.gtc.extension.distribution.gbd.n.y.a(a9);
                if (!android.text.TextUtils.isEmpty(a2)) {
                }
                com.getui.gtc.extension.distribution.gbd.d.d.bc = a(com.getui.gtc.extension.distribution.gbd.d.a.t, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bc)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bd = a(com.getui.gtc.extension.distribution.gbd.d.a.u, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bd)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bg = a(com.getui.gtc.extension.distribution.gbd.d.a.w, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bg)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bh = a(com.getui.gtc.extension.distribution.gbd.d.a.x, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bh)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bi = a(com.getui.gtc.extension.distribution.gbd.d.a.y, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bi)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bj = a(com.getui.gtc.extension.distribution.gbd.d.a.z, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bj)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bk = a(com.getui.gtc.extension.distribution.gbd.d.a.A, com.getui.gtc.extension.distribution.gbd.d.d.bk);
                com.getui.gtc.extension.distribution.gbd.d.d.aX = a(com.getui.gtc.extension.distribution.gbd.d.a.B, com.getui.gtc.extension.distribution.gbd.d.d.aX);
                com.getui.gtc.extension.distribution.gbd.d.d.bl = a(com.getui.gtc.extension.distribution.gbd.d.a.f, com.getui.gtc.extension.distribution.gbd.d.d.bl);
                com.getui.gtc.extension.distribution.gbd.d.d.aY = a(com.getui.gtc.extension.distribution.gbd.d.a.C, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aY)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bt = a(com.getui.gtc.extension.distribution.gbd.d.a.D, com.getui.gtc.extension.distribution.gbd.d.d.bt);
                com.getui.gtc.extension.distribution.gbd.d.d.bw = a(com.getui.gtc.extension.distribution.gbd.d.a.E, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bw)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.by = a("tag", com.getui.gtc.extension.distribution.gbd.d.d.by);
                com.getui.gtc.extension.distribution.gbd.d.d.bx = a(com.getui.gtc.extension.distribution.gbd.d.a.F, com.getui.gtc.extension.distribution.gbd.d.d.bx);
                com.getui.gtc.extension.distribution.gbd.d.d.bu = a(com.getui.gtc.extension.distribution.gbd.d.a.G, com.getui.gtc.extension.distribution.gbd.d.d.bu);
                com.getui.gtc.extension.distribution.gbd.d.d.bv = a(com.getui.gtc.extension.distribution.gbd.d.a.H, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bv)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bz = a(com.getui.gtc.extension.distribution.gbd.d.a.I, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bz)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bA = a(com.getui.gtc.extension.distribution.gbd.d.a.J, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bA)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bC = a(com.getui.gtc.extension.distribution.gbd.d.a.K, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bC)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bB = a(com.getui.gtc.extension.distribution.gbd.d.a.L, com.getui.gtc.extension.distribution.gbd.d.d.bB);
                com.getui.gtc.extension.distribution.gbd.d.d.bE = a(com.getui.gtc.extension.distribution.gbd.d.a.O, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bE)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bF = a(com.getui.gtc.extension.distribution.gbd.d.a.P, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bF)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bD = a(com.getui.gtc.extension.distribution.gbd.d.a.N, com.getui.gtc.extension.distribution.gbd.d.d.bD);
                com.getui.gtc.extension.distribution.gbd.d.d.bG = a(com.getui.gtc.extension.distribution.gbd.d.a.Q, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bG)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bH = a(com.getui.gtc.extension.distribution.gbd.d.a.R, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bH)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bQ = a(com.getui.gtc.extension.distribution.gbd.d.a.T, com.getui.gtc.extension.distribution.gbd.d.d.bQ);
                com.getui.gtc.extension.distribution.gbd.d.d.bn = a(com.getui.gtc.extension.distribution.gbd.d.a.U, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bn)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bp = a(com.getui.gtc.extension.distribution.gbd.d.a.V, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bp)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bR = a(com.getui.gtc.extension.distribution.gbd.d.a.aa, com.getui.gtc.extension.distribution.gbd.d.d.bR);
                a3 = a(com.getui.gtc.extension.distribution.gbd.d.a.ab, com.getui.gtc.extension.distribution.gbd.d.h.aK);
                if (com.getui.gtc.extension.distribution.gbd.d.d.x) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(e, "old v = " + com.getui.gtc.extension.distribution.gbd.d.h.aK + ", new v = " + a3);
                    com.getui.gtc.extension.distribution.gbd.d.h.aL = true;
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    com.getui.gtc.extension.distribution.gbd.d.h.aK = a3;
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a(311, java.lang.String.valueOf(a3));
                    com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_RDM", "saveAppListVersion = ".concat(java.lang.String.valueOf(a3)));
                    if (com.getui.gtc.extension.distribution.gbd.d.h.b != null) {
                    }
                }
                com.getui.gtc.extension.distribution.gbd.d.d.de = a(com.getui.gtc.extension.distribution.gbd.d.a.cV, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.de)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cV = a(com.getui.gtc.extension.distribution.gbd.d.a.cN, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cV)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.h.aM = a(com.getui.gtc.extension.distribution.gbd.d.a.cM, com.getui.gtc.extension.distribution.gbd.d.h.aM);
                if (com.getui.gtc.extension.distribution.gbd.d.d.x) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(e, "url for 24 =  " + com.getui.gtc.extension.distribution.gbd.d.h.aM);
                    com.getui.gtc.extension.distribution.gbd.d.h.aN = true;
                    if (com.getui.gtc.extension.distribution.gbd.d.h.b != null) {
                    }
                }
                com.getui.gtc.extension.distribution.gbd.d.d.bM = a(com.getui.gtc.extension.distribution.gbd.d.a.ac, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bM)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bN = a(com.getui.gtc.extension.distribution.gbd.d.a.ad, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bN)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bO = a(com.getui.gtc.extension.distribution.gbd.d.a.ae, com.getui.gtc.extension.distribution.gbd.d.d.bO);
                com.getui.gtc.extension.distribution.gbd.d.d.bS = a(com.getui.gtc.extension.distribution.gbd.d.a.af, com.getui.gtc.extension.distribution.gbd.d.d.bS);
                com.getui.gtc.extension.distribution.gbd.d.d.bm = a(com.getui.gtc.extension.distribution.gbd.d.a.ag, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bm)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.bY = a(com.getui.gtc.extension.distribution.gbd.d.a.an, com.getui.gtc.extension.distribution.gbd.d.d.bY);
                com.getui.gtc.extension.distribution.gbd.d.d.bZ = a(com.getui.gtc.extension.distribution.gbd.d.a.ao, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bZ)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.ca = a(com.getui.gtc.extension.distribution.gbd.d.a.ap, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ca)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.ck = a(com.getui.gtc.extension.distribution.gbd.d.a.aq, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ck)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cm = a(com.getui.gtc.extension.distribution.gbd.d.a.ar, com.getui.gtc.extension.distribution.gbd.d.d.cm);
                com.getui.gtc.extension.distribution.gbd.d.d.bW = a(com.getui.gtc.extension.distribution.gbd.d.a.ak, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bW)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cb = a(com.getui.gtc.extension.distribution.gbd.d.a.as, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cb)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cc = a(com.getui.gtc.extension.distribution.gbd.d.a.at, com.getui.gtc.extension.distribution.gbd.d.d.cc);
                com.getui.gtc.extension.distribution.gbd.d.d.ce = a(com.getui.gtc.extension.distribution.gbd.d.a.av, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ce)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cf = a(com.getui.gtc.extension.distribution.gbd.d.a.aw, com.getui.gtc.extension.distribution.gbd.d.d.cf);
                com.getui.gtc.extension.distribution.gbd.d.d.cg = a(com.getui.gtc.extension.distribution.gbd.d.a.ay, com.getui.gtc.extension.distribution.gbd.d.d.cg);
                com.getui.gtc.extension.distribution.gbd.d.d.ch = a(com.getui.gtc.extension.distribution.gbd.d.a.ax, com.getui.gtc.extension.distribution.gbd.d.d.ch);
                com.getui.gtc.extension.distribution.gbd.d.d.ci = a(com.getui.gtc.extension.distribution.gbd.d.a.az, com.getui.gtc.extension.distribution.gbd.d.d.ci);
                com.getui.gtc.extension.distribution.gbd.d.d.cj = a(com.getui.gtc.extension.distribution.gbd.d.a.aA, com.getui.gtc.extension.distribution.gbd.d.d.cj);
                com.getui.gtc.extension.distribution.gbd.d.d.aG = a(com.getui.gtc.extension.distribution.gbd.d.a.aB, com.getui.gtc.extension.distribution.gbd.d.d.aG);
                com.getui.gtc.extension.distribution.gbd.d.d.az = a(com.getui.gtc.extension.distribution.gbd.d.a.aC, com.getui.gtc.extension.distribution.gbd.d.d.az);
                com.getui.gtc.extension.distribution.gbd.d.d.ay = a(com.getui.gtc.extension.distribution.gbd.d.a.aD, com.getui.gtc.extension.distribution.gbd.d.d.ay);
                com.getui.gtc.extension.distribution.gbd.d.d.aQ = a(com.getui.gtc.extension.distribution.gbd.d.a.aE, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aQ)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.aK = a(com.getui.gtc.extension.distribution.gbd.d.a.aF, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aK)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.aL = a(com.getui.gtc.extension.distribution.gbd.d.a.aG, com.getui.gtc.extension.distribution.gbd.d.d.aL);
                com.getui.gtc.extension.distribution.gbd.d.d.aM = a(com.getui.gtc.extension.distribution.gbd.d.a.aH, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aM)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.aN = a(com.getui.gtc.extension.distribution.gbd.d.a.aJ, com.getui.gtc.extension.distribution.gbd.d.d.aN);
                com.getui.gtc.extension.distribution.gbd.d.d.D = a(com.getui.gtc.extension.distribution.gbd.d.a.aM, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.D)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.L = a(com.getui.gtc.extension.distribution.gbd.d.a.aI, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.L)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.as = a(com.getui.gtc.extension.distribution.gbd.d.a.aL, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.as)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.aD = a(com.getui.gtc.extension.distribution.gbd.d.a.aP, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aD)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.aE = a(com.getui.gtc.extension.distribution.gbd.d.a.aK, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aE)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.aF = a(com.getui.gtc.extension.distribution.gbd.d.a.aN, com.getui.gtc.extension.distribution.gbd.d.d.aF);
                com.getui.gtc.extension.distribution.gbd.d.d.cl = a(com.getui.gtc.extension.distribution.gbd.d.a.aO, com.getui.gtc.extension.distribution.gbd.d.d.cl);
                com.getui.gtc.extension.distribution.gbd.d.d.aH = a(com.getui.gtc.extension.distribution.gbd.d.a.aQ, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aH)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.aI = a(com.getui.gtc.extension.distribution.gbd.d.a.aR, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aI)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.aJ = a(com.getui.gtc.extension.distribution.gbd.d.a.aU, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aJ)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.l = a(com.getui.gtc.extension.distribution.gbd.d.a.aV, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.l)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.h = a(com.getui.gtc.extension.distribution.gbd.d.a.aW, com.getui.gtc.extension.distribution.gbd.d.d.h);
                com.getui.gtc.extension.distribution.gbd.d.d.ap = a(com.getui.gtc.extension.distribution.gbd.d.a.aX, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ap)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.au = a(com.getui.gtc.extension.distribution.gbd.d.a.aY, com.getui.gtc.extension.distribution.gbd.d.d.au);
                com.getui.gtc.extension.distribution.gbd.d.d.av = a(com.getui.gtc.extension.distribution.gbd.d.a.aZ, com.getui.gtc.extension.distribution.gbd.d.d.av);
                com.getui.gtc.extension.distribution.gbd.d.d.aw = a(com.getui.gtc.extension.distribution.gbd.d.a.ba, com.getui.gtc.extension.distribution.gbd.d.d.aw);
                com.getui.gtc.extension.distribution.gbd.d.d.ax = a(com.getui.gtc.extension.distribution.gbd.d.a.bb, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ax)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.F = a(com.getui.gtc.extension.distribution.gbd.d.a.bc, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.F)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.A = a(com.getui.gtc.extension.distribution.gbd.d.a.bd, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.A)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.B = a(com.getui.gtc.extension.distribution.gbd.d.a.be, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.B)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.E = a(com.getui.gtc.extension.distribution.gbd.d.a.bf, com.getui.gtc.extension.distribution.gbd.d.d.E);
                com.getui.gtc.extension.distribution.gbd.d.d.M = a(com.getui.gtc.extension.distribution.gbd.d.a.bg, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.M)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.P = a(com.getui.gtc.extension.distribution.gbd.d.a.bj, com.getui.gtc.extension.distribution.gbd.d.d.P);
                com.getui.gtc.extension.distribution.gbd.d.d.aa = a(com.getui.gtc.extension.distribution.gbd.d.a.bh, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aa)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.ab = a(com.getui.gtc.extension.distribution.gbd.d.a.bi, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ab)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.ac = a(com.getui.gtc.extension.distribution.gbd.d.a.bQ, com.getui.gtc.extension.distribution.gbd.d.d.ac);
                com.getui.gtc.extension.distribution.gbd.d.d.Q = a(com.getui.gtc.extension.distribution.gbd.d.a.bR, com.getui.gtc.extension.distribution.gbd.d.d.Q);
                com.getui.gtc.extension.distribution.gbd.d.d.N = a(com.getui.gtc.extension.distribution.gbd.d.a.bk, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.N)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.O = a(com.getui.gtc.extension.distribution.gbd.d.a.bS, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.O)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.m = a(com.getui.gtc.extension.distribution.gbd.d.a.bT, com.getui.gtc.extension.distribution.gbd.d.d.m);
                com.getui.gtc.extension.distribution.gbd.d.d.n = a(com.getui.gtc.extension.distribution.gbd.d.a.bU, com.getui.gtc.extension.distribution.gbd.d.d.n);
                com.getui.gtc.extension.distribution.gbd.d.d.G = a(com.getui.gtc.extension.distribution.gbd.d.a.bn, com.getui.gtc.extension.distribution.gbd.d.d.G);
                com.getui.gtc.extension.distribution.gbd.d.d.H = a(com.getui.gtc.extension.distribution.gbd.d.a.dh, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.H)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.I = a(com.getui.gtc.extension.distribution.gbd.d.a.di, com.getui.gtc.extension.distribution.gbd.d.d.I);
                com.getui.gtc.extension.distribution.gbd.d.d.J = a(com.getui.gtc.extension.distribution.gbd.d.a.dj, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.J)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.K = a(com.getui.gtc.extension.distribution.gbd.d.a.dk, com.getui.gtc.extension.distribution.gbd.d.d.K);
                com.getui.gtc.extension.distribution.gbd.d.d.ad = a(com.getui.gtc.extension.distribution.gbd.d.a.bo, com.getui.gtc.extension.distribution.gbd.d.d.ad);
                com.getui.gtc.extension.distribution.gbd.d.d.ae = a(com.getui.gtc.extension.distribution.gbd.d.a.bE, com.getui.gtc.extension.distribution.gbd.d.d.ae);
                com.getui.gtc.extension.distribution.gbd.d.d.af = a(com.getui.gtc.extension.distribution.gbd.d.a.bD, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.af)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.ag = a(com.getui.gtc.extension.distribution.gbd.d.a.bF, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ag)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.ah = a(com.getui.gtc.extension.distribution.gbd.d.a.bH, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ah)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.ai = a(com.getui.gtc.extension.distribution.gbd.d.a.bG, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ai)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.aj = a(com.getui.gtc.extension.distribution.gbd.d.a.bI, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aj)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.ak = a(com.getui.gtc.extension.distribution.gbd.d.a.bJ, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ak)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.al = a(com.getui.gtc.extension.distribution.gbd.d.a.bK, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.al)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.an = a(com.getui.gtc.extension.distribution.gbd.d.a.bN, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.an)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.ao = a(com.getui.gtc.extension.distribution.gbd.d.a.bO, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ao)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.am = a(com.getui.gtc.extension.distribution.gbd.d.a.bP, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.am)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.R = a(com.getui.gtc.extension.distribution.gbd.d.a.bV, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.R)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.W = a(com.getui.gtc.extension.distribution.gbd.d.a.ca, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.W)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.X = a(com.getui.gtc.extension.distribution.gbd.d.a.cb, com.getui.gtc.extension.distribution.gbd.d.d.X);
                com.getui.gtc.extension.distribution.gbd.d.d.Z = a(com.getui.gtc.extension.distribution.gbd.d.a.cd, com.getui.gtc.extension.distribution.gbd.d.d.Z);
                com.getui.gtc.extension.distribution.gbd.d.d.S = a(com.getui.gtc.extension.distribution.gbd.d.a.bW, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.S)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.T = a(com.getui.gtc.extension.distribution.gbd.d.a.bX, com.getui.gtc.extension.distribution.gbd.d.d.T);
                com.getui.gtc.extension.distribution.gbd.d.d.U = a(com.getui.gtc.extension.distribution.gbd.d.a.bY, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.U)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.V = a(com.getui.gtc.extension.distribution.gbd.d.a.bZ, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.V)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.f = a(com.getui.gtc.extension.distribution.gbd.d.a.cg, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.f)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.g = a(com.getui.gtc.extension.distribution.gbd.d.a.ch, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.g)).longValue();
                com.getui.gtc.extension.distribution.gbd.n.j.b(e, "from config, e_p=" + com.getui.gtc.extension.distribution.gbd.d.d.f + ", e_i=" + com.getui.gtc.extension.distribution.gbd.d.d.g);
                com.getui.gtc.extension.distribution.gbd.d.d.aq = a(com.getui.gtc.extension.distribution.gbd.d.a.bl, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aq)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.ar = a(com.getui.gtc.extension.distribution.gbd.d.a.bm, com.getui.gtc.extension.distribution.gbd.d.d.ar);
                com.getui.gtc.extension.distribution.gbd.d.d.y = a(com.getui.gtc.extension.distribution.gbd.d.a.bp, com.getui.gtc.extension.distribution.gbd.d.d.y);
                com.getui.gtc.extension.distribution.gbd.d.d.C = a(com.getui.gtc.extension.distribution.gbd.d.a.bq, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.C)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.z = a(com.getui.gtc.extension.distribution.gbd.d.a.br, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.z)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.w = a(com.getui.gtc.extension.distribution.gbd.d.a.bs, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.w)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.i = a(com.getui.gtc.extension.distribution.gbd.d.a.bt, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.i)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.j = a(com.getui.gtc.extension.distribution.gbd.d.a.bC, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.j)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.k = a(com.getui.gtc.extension.distribution.gbd.d.a.bu, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.k)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.u = a(com.getui.gtc.extension.distribution.gbd.d.a.bv, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.u)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.q = a(com.getui.gtc.extension.distribution.gbd.d.a.bw, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.q)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.r = a(com.getui.gtc.extension.distribution.gbd.d.a.bx, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.r)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.f323s = a(com.getui.gtc.extension.distribution.gbd.d.a.by, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.f323s)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.t = a(com.getui.gtc.extension.distribution.gbd.d.a.bz, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.t)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.o = a(com.getui.gtc.extension.distribution.gbd.d.a.bA, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.o)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.p = a(com.getui.gtc.extension.distribution.gbd.d.a.bB, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.p)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.f322cn = a(com.getui.gtc.extension.distribution.gbd.d.a.ce, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.f322cn)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cp = a(com.getui.gtc.extension.distribution.gbd.d.a.cf, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cp)).booleanValue();
                int i = com.getui.gtc.extension.distribution.gbd.d.h.aJ;
                com.getui.gtc.extension.distribution.gbd.d.d.Y = i;
                a4 = a(com.getui.gtc.extension.distribution.gbd.d.a.cc, -1);
                com.getui.gtc.extension.distribution.gbd.n.j.b(e, "old_v=" + i + ", new_v=" + a4);
                if (com.getui.gtc.extension.distribution.gbd.d.d.x) {
                    com.getui.gtc.extension.distribution.gbd.d.d.Y = a4;
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    com.getui.gtc.extension.distribution.gbd.d.h.aJ = a4;
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a(293, java.lang.String.valueOf(a4));
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a(true);
                    com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.d.e.AnonymousClass2());
                }
                com.getui.gtc.extension.distribution.gbd.d.d.cq = a(com.getui.gtc.extension.distribution.gbd.d.a.ci, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cq)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cr = a(com.getui.gtc.extension.distribution.gbd.d.a.cj, com.getui.gtc.extension.distribution.gbd.d.d.cr);
                com.getui.gtc.extension.distribution.gbd.d.d.cs = a(com.getui.gtc.extension.distribution.gbd.d.a.ck, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cs)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.ct = a(com.getui.gtc.extension.distribution.gbd.d.a.cl, com.getui.gtc.extension.distribution.gbd.d.d.ct);
                com.getui.gtc.extension.distribution.gbd.d.d.cu = a(com.getui.gtc.extension.distribution.gbd.d.a.cm, com.getui.gtc.extension.distribution.gbd.d.d.cu);
                com.getui.gtc.extension.distribution.gbd.d.d.cv = a(com.getui.gtc.extension.distribution.gbd.d.a.f320cn, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cv)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cw = a(com.getui.gtc.extension.distribution.gbd.d.a.co, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cw)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cx = a(com.getui.gtc.extension.distribution.gbd.d.a.cp, com.getui.gtc.extension.distribution.gbd.d.d.cx);
                com.getui.gtc.extension.distribution.gbd.d.d.cA = a(com.getui.gtc.extension.distribution.gbd.d.a.cq, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cA)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cB = a(com.getui.gtc.extension.distribution.gbd.d.a.cr, com.getui.gtc.extension.distribution.gbd.d.d.cB);
                com.getui.gtc.extension.distribution.gbd.d.d.cy = a(com.getui.gtc.extension.distribution.gbd.d.a.cs, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cy)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cz = a(com.getui.gtc.extension.distribution.gbd.d.a.ct, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cz)).booleanValue();
                a5 = a(com.getui.gtc.extension.distribution.gbd.d.a.cu, com.getui.gtc.extension.distribution.gbd.d.d.cE);
                com.getui.gtc.extension.distribution.gbd.d.d.cE = a5;
                if (!android.text.TextUtils.isEmpty(a5)) {
                }
                com.getui.gtc.extension.distribution.gbd.n.j.b(e, "* interval = " + com.getui.gtc.extension.distribution.gbd.d.d.cA + ", cu path = " + com.getui.gtc.extension.distribution.gbd.d.d.cE);
                com.getui.gtc.extension.distribution.gbd.d.d.cF = a(com.getui.gtc.extension.distribution.gbd.d.a.cv, com.getui.gtc.extension.distribution.gbd.d.d.cF);
                com.getui.gtc.extension.distribution.gbd.d.d.cC = a(com.getui.gtc.extension.distribution.gbd.d.a.cw, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cC)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cD = a(com.getui.gtc.extension.distribution.gbd.d.a.cx, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cD)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cG = a(com.getui.gtc.extension.distribution.gbd.d.a.cy, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cG)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cH = a(com.getui.gtc.extension.distribution.gbd.d.a.cz, com.getui.gtc.extension.distribution.gbd.d.d.cH);
                com.getui.gtc.extension.distribution.gbd.d.d.cI = a(com.getui.gtc.extension.distribution.gbd.d.a.cA, com.getui.gtc.extension.distribution.gbd.d.d.cI);
                com.getui.gtc.extension.distribution.gbd.d.d.cO = a(com.getui.gtc.extension.distribution.gbd.d.a.cB, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cO)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cP = a(com.getui.gtc.extension.distribution.gbd.d.a.cH, com.getui.gtc.extension.distribution.gbd.d.d.cP);
                com.getui.gtc.extension.distribution.gbd.d.d.cQ = a(com.getui.gtc.extension.distribution.gbd.d.a.cI, com.getui.gtc.extension.distribution.gbd.d.d.cQ);
                com.getui.gtc.extension.distribution.gbd.d.d.cJ = a(com.getui.gtc.extension.distribution.gbd.d.a.cC, com.getui.gtc.extension.distribution.gbd.d.d.cJ);
                com.getui.gtc.extension.distribution.gbd.d.d.cK = a(com.getui.gtc.extension.distribution.gbd.d.a.cD, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cK)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cY = a(com.getui.gtc.extension.distribution.gbd.d.a.cO, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cY)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cX = a(com.getui.gtc.extension.distribution.gbd.d.a.cP, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cX)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cW = a(com.getui.gtc.extension.distribution.gbd.d.a.cQ, com.getui.gtc.extension.distribution.gbd.d.d.cW);
                com.getui.gtc.extension.distribution.gbd.d.d.cZ = a(com.getui.gtc.extension.distribution.gbd.d.a.cT, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cZ)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.db = a(com.getui.gtc.extension.distribution.gbd.d.a.cR, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.db)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.da = a(com.getui.gtc.extension.distribution.gbd.d.a.cS, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.da)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cL = a(com.getui.gtc.extension.distribution.gbd.d.a.cE, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cL)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cN = a(com.getui.gtc.extension.distribution.gbd.d.a.cG, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cN)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.cM = a(com.getui.gtc.extension.distribution.gbd.d.a.cF, com.getui.gtc.extension.distribution.gbd.d.d.cM);
                if (com.getui.gtc.extension.distribution.gbd.d.d.x) {
                    com.getui.gtc.extension.distribution.gbd.d.h.aO = true;
                    if (com.getui.gtc.extension.distribution.gbd.d.h.b != null) {
                        android.os.Message obtain = android.os.Message.obtain();
                        obtain.what = 202;
                        com.getui.gtc.extension.distribution.gbd.d.h.b.sendMessage(obtain);
                    }
                }
                a6 = a(com.getui.gtc.extension.distribution.gbd.d.a.cJ, "");
                com.getui.gtc.extension.distribution.gbd.d.d.cR.clear();
                if (!android.text.TextUtils.isEmpty(a6)) {
                    while (r5 < r3) {
                    }
                }
                com.getui.gtc.extension.distribution.gbd.d.d.cS = a(com.getui.gtc.extension.distribution.gbd.d.a.cK, com.getui.gtc.extension.distribution.gbd.d.d.cS);
                int a10 = a(com.getui.gtc.extension.distribution.gbd.d.a.cL, 1);
                com.getui.gtc.extension.distribution.gbd.d.d.cU = (a10 & 2) == 0;
                com.getui.gtc.extension.distribution.gbd.d.d.cT = (a10 & 1) == 0;
                com.getui.gtc.extension.distribution.gbd.d.d.dc = a(com.getui.gtc.extension.distribution.gbd.d.a.cU, com.getui.gtc.extension.distribution.gbd.d.d.dc);
                com.getui.gtc.extension.distribution.gbd.d.d.dd = a(com.getui.gtc.extension.distribution.gbd.d.a.cW, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dd)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.df = a(com.getui.gtc.extension.distribution.gbd.d.a.cX, com.getui.gtc.extension.distribution.gbd.d.d.df);
                com.getui.gtc.extension.distribution.gbd.d.d.dg = a(com.getui.gtc.extension.distribution.gbd.d.a.cY, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dg)).longValue();
                com.getui.gtc.extension.distribution.gbd.f.h.a(a(com.getui.gtc.extension.distribution.gbd.d.a.da, java.lang.Boolean.FALSE).booleanValue(), a(com.getui.gtc.extension.distribution.gbd.d.a.cZ, (java.lang.String) null));
                a7 = a(com.getui.gtc.extension.distribution.gbd.d.a.db, "");
                if (!android.text.TextUtils.isEmpty(a7)) {
                }
                com.getui.gtc.extension.distribution.gbd.d.d.dk = a(com.getui.gtc.extension.distribution.gbd.d.a.dc, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dk)).booleanValue();
                aVar = com.getui.gtc.extension.distribution.gbd.b.a.b.a;
                aVar.a = a(com.getui.gtc.extension.distribution.gbd.d.a.M, aVar.a);
                int a11 = a(com.getui.gtc.extension.distribution.gbd.d.a.aT, aVar.b);
                aVar.b = a11;
                aVar.b = java.lang.Math.max(a11, 29);
                com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_ArpHelper", "ap mc = " + aVar.a + ", x sdk int = " + aVar.b);
                a8 = a(com.getui.gtc.extension.distribution.gbd.d.a.aS, "nl:0,ipn:1");
                if (a8 != null) {
                    aVar.a(a8, aVar.a);
                }
                com.getui.gtc.extension.distribution.gbd.d.d.dn = a(com.getui.gtc.extension.distribution.gbd.d.a.df, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dn)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.f3do = a(com.getui.gtc.extension.distribution.gbd.d.a.dg, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.f3do)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.dp = a(com.getui.gtc.extension.distribution.gbd.d.a.dl, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dp)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.dq = a(com.getui.gtc.extension.distribution.gbd.d.a.dm, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dq)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.dr = a(com.getui.gtc.extension.distribution.gbd.d.a.dn, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dr)).booleanValue();
                longValue = a(com.getui.gtc.extension.distribution.gbd.d.a.f2do, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ds)).longValue();
                com.getui.gtc.extension.distribution.gbd.d.d.ds = longValue;
                if (longValue <= 2) {
                }
                com.getui.gtc.extension.distribution.gbd.d.d.dt = a(com.getui.gtc.extension.distribution.gbd.d.a.dp, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dt)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.du = a(com.getui.gtc.extension.distribution.gbd.d.a.dq, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.du)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.dv = a(com.getui.gtc.extension.distribution.gbd.d.a.dr, com.getui.gtc.extension.distribution.gbd.d.d.dv);
                com.getui.gtc.extension.distribution.gbd.d.d.dw = a(com.getui.gtc.extension.distribution.gbd.d.a.ds, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dw)).booleanValue();
                com.getui.gtc.extension.distribution.gbd.d.d.dx = a(com.getui.gtc.extension.distribution.gbd.d.a.dt, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dx)).booleanValue();
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            z = true;
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder("isAdbModeSafe = ");
        sb2.append(!z);
        sb2.append(", isAppDebug = ");
        sb2.append(z2);
        com.getui.gtc.extension.distribution.gbd.n.j.a(e, sb2.toString());
        a();
        com.getui.gtc.extension.distribution.gbd.d.d.v = a(com.getui.gtc.extension.distribution.gbd.d.a.S, com.getui.gtc.extension.distribution.gbd.d.d.v);
        com.getui.gtc.extension.distribution.gbd.d.d.x = a(com.getui.gtc.extension.distribution.gbd.d.a.c, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.x)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bT = a(com.getui.gtc.extension.distribution.gbd.d.a.ah, com.getui.gtc.extension.distribution.gbd.d.d.bT);
        com.getui.gtc.extension.distribution.gbd.d.d.bU = a(com.getui.gtc.extension.distribution.gbd.d.a.ai, com.getui.gtc.extension.distribution.gbd.d.d.bU);
        com.getui.gtc.extension.distribution.gbd.d.d.bV = a(com.getui.gtc.extension.distribution.gbd.d.a.aj, java.lang.Short.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bV)).shortValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bo = a(com.getui.gtc.extension.distribution.gbd.d.a.al, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bo)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bq = a(com.getui.gtc.extension.distribution.gbd.d.a.am, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bq)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.dl = a(com.getui.gtc.extension.distribution.gbd.d.a.dd, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dl)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.dm = a(com.getui.gtc.extension.distribution.gbd.d.a.de, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dm)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bJ = a(com.getui.gtc.extension.distribution.gbd.d.a.W, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bJ)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bI = a(com.getui.gtc.extension.distribution.gbd.d.a.X, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bI)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bK = a(com.getui.gtc.extension.distribution.gbd.d.a.Y, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bK)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bL = a(com.getui.gtc.extension.distribution.gbd.d.a.Z, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bL)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.at = a(com.getui.gtc.extension.distribution.gbd.d.a.d, com.getui.gtc.extension.distribution.gbd.d.d.at);
        com.getui.gtc.extension.distribution.gbd.d.d.aA = a(com.getui.gtc.extension.distribution.gbd.d.a.e, com.getui.gtc.extension.distribution.gbd.d.d.aA);
        com.getui.gtc.extension.distribution.gbd.d.d.aB = a(com.getui.gtc.extension.distribution.gbd.d.a.g, com.getui.gtc.extension.distribution.gbd.d.d.aB);
        com.getui.gtc.extension.distribution.gbd.d.d.aO = a(com.getui.gtc.extension.distribution.gbd.d.a.h, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aO)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.aP = a(com.getui.gtc.extension.distribution.gbd.d.a.i, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aP)).longValue();
        com.getui.gtc.extension.distribution.gbd.k.a.k.e().f();
        com.getui.gtc.extension.distribution.gbd.d.d.aR = a(com.getui.gtc.extension.distribution.gbd.d.a.j, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aR)).longValue();
        com.getui.gtc.extension.distribution.gbd.k.a.q.e().f();
        com.getui.gtc.extension.distribution.gbd.d.d.aS = a(com.getui.gtc.extension.distribution.gbd.d.a.k, com.getui.gtc.extension.distribution.gbd.d.d.aS);
        com.getui.gtc.extension.distribution.gbd.d.d.aT = a(com.getui.gtc.extension.distribution.gbd.d.a.l, com.getui.gtc.extension.distribution.gbd.d.d.aT);
        com.getui.gtc.extension.distribution.gbd.d.d.aU = a(com.getui.gtc.extension.distribution.gbd.d.a.m, com.getui.gtc.extension.distribution.gbd.d.d.aU);
        com.getui.gtc.extension.distribution.gbd.d.d.aV = a(com.getui.gtc.extension.distribution.gbd.d.a.n, com.getui.gtc.extension.distribution.gbd.d.d.aV);
        com.getui.gtc.extension.distribution.gbd.d.d.aW = a(com.getui.gtc.extension.distribution.gbd.d.a.o, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aW)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.aZ = a(com.getui.gtc.extension.distribution.gbd.d.a.p, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aZ)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.ba = a(com.getui.gtc.extension.distribution.gbd.d.a.q, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ba)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bb = a(com.getui.gtc.extension.distribution.gbd.d.a.r, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bb)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.be = a(com.getui.gtc.extension.distribution.gbd.d.a.f321s, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.be)).longValue();
        java.lang.String a92 = a(com.getui.gtc.extension.distribution.gbd.d.a.v, com.getui.gtc.extension.distribution.gbd.d.d.bf);
        com.getui.gtc.extension.distribution.gbd.d.d.bf = a92;
        a2 = com.getui.gtc.extension.distribution.gbd.n.y.a(a92);
        if (!android.text.TextUtils.isEmpty(a2)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(e, "enc 151: ".concat(java.lang.String.valueOf(a2)));
            com.getui.gtc.extension.distribution.gbd.d.h.at = new java.util.ArrayList(java.util.Arrays.asList(a2.split(",")));
        }
        com.getui.gtc.extension.distribution.gbd.d.d.bc = a(com.getui.gtc.extension.distribution.gbd.d.a.t, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bc)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bd = a(com.getui.gtc.extension.distribution.gbd.d.a.u, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bd)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bg = a(com.getui.gtc.extension.distribution.gbd.d.a.w, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bg)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bh = a(com.getui.gtc.extension.distribution.gbd.d.a.x, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bh)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bi = a(com.getui.gtc.extension.distribution.gbd.d.a.y, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bi)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bj = a(com.getui.gtc.extension.distribution.gbd.d.a.z, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bj)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bk = a(com.getui.gtc.extension.distribution.gbd.d.a.A, com.getui.gtc.extension.distribution.gbd.d.d.bk);
        com.getui.gtc.extension.distribution.gbd.d.d.aX = a(com.getui.gtc.extension.distribution.gbd.d.a.B, com.getui.gtc.extension.distribution.gbd.d.d.aX);
        com.getui.gtc.extension.distribution.gbd.d.d.bl = a(com.getui.gtc.extension.distribution.gbd.d.a.f, com.getui.gtc.extension.distribution.gbd.d.d.bl);
        com.getui.gtc.extension.distribution.gbd.d.d.aY = a(com.getui.gtc.extension.distribution.gbd.d.a.C, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aY)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bt = a(com.getui.gtc.extension.distribution.gbd.d.a.D, com.getui.gtc.extension.distribution.gbd.d.d.bt);
        com.getui.gtc.extension.distribution.gbd.d.d.bw = a(com.getui.gtc.extension.distribution.gbd.d.a.E, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bw)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.by = a("tag", com.getui.gtc.extension.distribution.gbd.d.d.by);
        com.getui.gtc.extension.distribution.gbd.d.d.bx = a(com.getui.gtc.extension.distribution.gbd.d.a.F, com.getui.gtc.extension.distribution.gbd.d.d.bx);
        com.getui.gtc.extension.distribution.gbd.d.d.bu = a(com.getui.gtc.extension.distribution.gbd.d.a.G, com.getui.gtc.extension.distribution.gbd.d.d.bu);
        com.getui.gtc.extension.distribution.gbd.d.d.bv = a(com.getui.gtc.extension.distribution.gbd.d.a.H, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bv)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bz = a(com.getui.gtc.extension.distribution.gbd.d.a.I, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bz)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bA = a(com.getui.gtc.extension.distribution.gbd.d.a.J, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bA)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bC = a(com.getui.gtc.extension.distribution.gbd.d.a.K, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bC)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bB = a(com.getui.gtc.extension.distribution.gbd.d.a.L, com.getui.gtc.extension.distribution.gbd.d.d.bB);
        com.getui.gtc.extension.distribution.gbd.d.d.bE = a(com.getui.gtc.extension.distribution.gbd.d.a.O, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bE)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bF = a(com.getui.gtc.extension.distribution.gbd.d.a.P, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bF)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bD = a(com.getui.gtc.extension.distribution.gbd.d.a.N, com.getui.gtc.extension.distribution.gbd.d.d.bD);
        com.getui.gtc.extension.distribution.gbd.d.d.bG = a(com.getui.gtc.extension.distribution.gbd.d.a.Q, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bG)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bH = a(com.getui.gtc.extension.distribution.gbd.d.a.R, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bH)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bQ = a(com.getui.gtc.extension.distribution.gbd.d.a.T, com.getui.gtc.extension.distribution.gbd.d.d.bQ);
        com.getui.gtc.extension.distribution.gbd.d.d.bn = a(com.getui.gtc.extension.distribution.gbd.d.a.U, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bn)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bp = a(com.getui.gtc.extension.distribution.gbd.d.a.V, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bp)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bR = a(com.getui.gtc.extension.distribution.gbd.d.a.aa, com.getui.gtc.extension.distribution.gbd.d.d.bR);
        a3 = a(com.getui.gtc.extension.distribution.gbd.d.a.ab, com.getui.gtc.extension.distribution.gbd.d.h.aK);
        if (com.getui.gtc.extension.distribution.gbd.d.d.x && a3 > com.getui.gtc.extension.distribution.gbd.d.h.aK && !z && !z2) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(e, "old v = " + com.getui.gtc.extension.distribution.gbd.d.h.aK + ", new v = " + a3);
            com.getui.gtc.extension.distribution.gbd.d.h.aL = true;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.d.h.aK = a3;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a(311, java.lang.String.valueOf(a3));
            com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_RDM", "saveAppListVersion = ".concat(java.lang.String.valueOf(a3)));
            if (com.getui.gtc.extension.distribution.gbd.d.h.b != null) {
                android.os.Message obtain2 = android.os.Message.obtain();
                obtain2.what = 201;
                com.getui.gtc.extension.distribution.gbd.d.h.b.sendMessage(obtain2);
            }
        }
        com.getui.gtc.extension.distribution.gbd.d.d.de = a(com.getui.gtc.extension.distribution.gbd.d.a.cV, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.de)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cV = a(com.getui.gtc.extension.distribution.gbd.d.a.cN, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cV)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.h.aM = a(com.getui.gtc.extension.distribution.gbd.d.a.cM, com.getui.gtc.extension.distribution.gbd.d.h.aM);
        if (com.getui.gtc.extension.distribution.gbd.d.d.x && com.getui.gtc.extension.distribution.gbd.d.d.de && com.getui.gtc.extension.distribution.gbd.d.d.cV && !z && !z2) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(e, "url for 24 =  " + com.getui.gtc.extension.distribution.gbd.d.h.aM);
            com.getui.gtc.extension.distribution.gbd.d.h.aN = true;
            if (com.getui.gtc.extension.distribution.gbd.d.h.b != null) {
                android.os.Message obtain3 = android.os.Message.obtain();
                obtain3.what = 203;
                com.getui.gtc.extension.distribution.gbd.d.h.b.sendMessage(obtain3);
            }
        }
        com.getui.gtc.extension.distribution.gbd.d.d.bM = a(com.getui.gtc.extension.distribution.gbd.d.a.ac, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bM)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bN = a(com.getui.gtc.extension.distribution.gbd.d.a.ad, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bN)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bO = a(com.getui.gtc.extension.distribution.gbd.d.a.ae, com.getui.gtc.extension.distribution.gbd.d.d.bO);
        com.getui.gtc.extension.distribution.gbd.d.d.bS = a(com.getui.gtc.extension.distribution.gbd.d.a.af, com.getui.gtc.extension.distribution.gbd.d.d.bS);
        com.getui.gtc.extension.distribution.gbd.d.d.bm = a(com.getui.gtc.extension.distribution.gbd.d.a.ag, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bm)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.bY = a(com.getui.gtc.extension.distribution.gbd.d.a.an, com.getui.gtc.extension.distribution.gbd.d.d.bY);
        com.getui.gtc.extension.distribution.gbd.d.d.bZ = a(com.getui.gtc.extension.distribution.gbd.d.a.ao, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bZ)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.ca = a(com.getui.gtc.extension.distribution.gbd.d.a.ap, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ca)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.ck = a(com.getui.gtc.extension.distribution.gbd.d.a.aq, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ck)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cm = a(com.getui.gtc.extension.distribution.gbd.d.a.ar, com.getui.gtc.extension.distribution.gbd.d.d.cm);
        com.getui.gtc.extension.distribution.gbd.d.d.bW = a(com.getui.gtc.extension.distribution.gbd.d.a.ak, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bW)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cb = a(com.getui.gtc.extension.distribution.gbd.d.a.as, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cb)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cc = a(com.getui.gtc.extension.distribution.gbd.d.a.at, com.getui.gtc.extension.distribution.gbd.d.d.cc);
        com.getui.gtc.extension.distribution.gbd.d.d.ce = a(com.getui.gtc.extension.distribution.gbd.d.a.av, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ce)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cf = a(com.getui.gtc.extension.distribution.gbd.d.a.aw, com.getui.gtc.extension.distribution.gbd.d.d.cf);
        com.getui.gtc.extension.distribution.gbd.d.d.cg = a(com.getui.gtc.extension.distribution.gbd.d.a.ay, com.getui.gtc.extension.distribution.gbd.d.d.cg);
        com.getui.gtc.extension.distribution.gbd.d.d.ch = a(com.getui.gtc.extension.distribution.gbd.d.a.ax, com.getui.gtc.extension.distribution.gbd.d.d.ch);
        com.getui.gtc.extension.distribution.gbd.d.d.ci = a(com.getui.gtc.extension.distribution.gbd.d.a.az, com.getui.gtc.extension.distribution.gbd.d.d.ci);
        com.getui.gtc.extension.distribution.gbd.d.d.cj = a(com.getui.gtc.extension.distribution.gbd.d.a.aA, com.getui.gtc.extension.distribution.gbd.d.d.cj);
        com.getui.gtc.extension.distribution.gbd.d.d.aG = a(com.getui.gtc.extension.distribution.gbd.d.a.aB, com.getui.gtc.extension.distribution.gbd.d.d.aG);
        com.getui.gtc.extension.distribution.gbd.d.d.az = a(com.getui.gtc.extension.distribution.gbd.d.a.aC, com.getui.gtc.extension.distribution.gbd.d.d.az);
        com.getui.gtc.extension.distribution.gbd.d.d.ay = a(com.getui.gtc.extension.distribution.gbd.d.a.aD, com.getui.gtc.extension.distribution.gbd.d.d.ay);
        com.getui.gtc.extension.distribution.gbd.d.d.aQ = a(com.getui.gtc.extension.distribution.gbd.d.a.aE, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aQ)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.aK = a(com.getui.gtc.extension.distribution.gbd.d.a.aF, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aK)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.aL = a(com.getui.gtc.extension.distribution.gbd.d.a.aG, com.getui.gtc.extension.distribution.gbd.d.d.aL);
        com.getui.gtc.extension.distribution.gbd.d.d.aM = a(com.getui.gtc.extension.distribution.gbd.d.a.aH, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aM)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.aN = a(com.getui.gtc.extension.distribution.gbd.d.a.aJ, com.getui.gtc.extension.distribution.gbd.d.d.aN);
        com.getui.gtc.extension.distribution.gbd.d.d.D = a(com.getui.gtc.extension.distribution.gbd.d.a.aM, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.D)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.L = a(com.getui.gtc.extension.distribution.gbd.d.a.aI, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.L)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.as = a(com.getui.gtc.extension.distribution.gbd.d.a.aL, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.as)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.aD = a(com.getui.gtc.extension.distribution.gbd.d.a.aP, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aD)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.aE = a(com.getui.gtc.extension.distribution.gbd.d.a.aK, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aE)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.aF = a(com.getui.gtc.extension.distribution.gbd.d.a.aN, com.getui.gtc.extension.distribution.gbd.d.d.aF);
        com.getui.gtc.extension.distribution.gbd.d.d.cl = a(com.getui.gtc.extension.distribution.gbd.d.a.aO, com.getui.gtc.extension.distribution.gbd.d.d.cl);
        com.getui.gtc.extension.distribution.gbd.d.d.aH = a(com.getui.gtc.extension.distribution.gbd.d.a.aQ, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aH)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.aI = a(com.getui.gtc.extension.distribution.gbd.d.a.aR, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aI)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.aJ = a(com.getui.gtc.extension.distribution.gbd.d.a.aU, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aJ)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.l = a(com.getui.gtc.extension.distribution.gbd.d.a.aV, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.l)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.h = a(com.getui.gtc.extension.distribution.gbd.d.a.aW, com.getui.gtc.extension.distribution.gbd.d.d.h);
        com.getui.gtc.extension.distribution.gbd.d.d.ap = a(com.getui.gtc.extension.distribution.gbd.d.a.aX, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ap)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.au = a(com.getui.gtc.extension.distribution.gbd.d.a.aY, com.getui.gtc.extension.distribution.gbd.d.d.au);
        com.getui.gtc.extension.distribution.gbd.d.d.av = a(com.getui.gtc.extension.distribution.gbd.d.a.aZ, com.getui.gtc.extension.distribution.gbd.d.d.av);
        com.getui.gtc.extension.distribution.gbd.d.d.aw = a(com.getui.gtc.extension.distribution.gbd.d.a.ba, com.getui.gtc.extension.distribution.gbd.d.d.aw);
        com.getui.gtc.extension.distribution.gbd.d.d.ax = a(com.getui.gtc.extension.distribution.gbd.d.a.bb, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ax)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.F = a(com.getui.gtc.extension.distribution.gbd.d.a.bc, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.F)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.A = a(com.getui.gtc.extension.distribution.gbd.d.a.bd, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.A)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.B = a(com.getui.gtc.extension.distribution.gbd.d.a.be, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.B)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.E = a(com.getui.gtc.extension.distribution.gbd.d.a.bf, com.getui.gtc.extension.distribution.gbd.d.d.E);
        com.getui.gtc.extension.distribution.gbd.d.d.M = a(com.getui.gtc.extension.distribution.gbd.d.a.bg, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.M)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.P = a(com.getui.gtc.extension.distribution.gbd.d.a.bj, com.getui.gtc.extension.distribution.gbd.d.d.P);
        com.getui.gtc.extension.distribution.gbd.d.d.aa = a(com.getui.gtc.extension.distribution.gbd.d.a.bh, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aa)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.ab = a(com.getui.gtc.extension.distribution.gbd.d.a.bi, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ab)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.ac = a(com.getui.gtc.extension.distribution.gbd.d.a.bQ, com.getui.gtc.extension.distribution.gbd.d.d.ac);
        com.getui.gtc.extension.distribution.gbd.d.d.Q = a(com.getui.gtc.extension.distribution.gbd.d.a.bR, com.getui.gtc.extension.distribution.gbd.d.d.Q);
        com.getui.gtc.extension.distribution.gbd.d.d.N = a(com.getui.gtc.extension.distribution.gbd.d.a.bk, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.N)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.O = a(com.getui.gtc.extension.distribution.gbd.d.a.bS, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.O)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.m = a(com.getui.gtc.extension.distribution.gbd.d.a.bT, com.getui.gtc.extension.distribution.gbd.d.d.m);
        com.getui.gtc.extension.distribution.gbd.d.d.n = a(com.getui.gtc.extension.distribution.gbd.d.a.bU, com.getui.gtc.extension.distribution.gbd.d.d.n);
        com.getui.gtc.extension.distribution.gbd.d.d.G = a(com.getui.gtc.extension.distribution.gbd.d.a.bn, com.getui.gtc.extension.distribution.gbd.d.d.G);
        com.getui.gtc.extension.distribution.gbd.d.d.H = a(com.getui.gtc.extension.distribution.gbd.d.a.dh, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.H)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.I = a(com.getui.gtc.extension.distribution.gbd.d.a.di, com.getui.gtc.extension.distribution.gbd.d.d.I);
        com.getui.gtc.extension.distribution.gbd.d.d.J = a(com.getui.gtc.extension.distribution.gbd.d.a.dj, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.J)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.K = a(com.getui.gtc.extension.distribution.gbd.d.a.dk, com.getui.gtc.extension.distribution.gbd.d.d.K);
        com.getui.gtc.extension.distribution.gbd.d.d.ad = a(com.getui.gtc.extension.distribution.gbd.d.a.bo, com.getui.gtc.extension.distribution.gbd.d.d.ad);
        com.getui.gtc.extension.distribution.gbd.d.d.ae = a(com.getui.gtc.extension.distribution.gbd.d.a.bE, com.getui.gtc.extension.distribution.gbd.d.d.ae);
        com.getui.gtc.extension.distribution.gbd.d.d.af = a(com.getui.gtc.extension.distribution.gbd.d.a.bD, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.af)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.ag = a(com.getui.gtc.extension.distribution.gbd.d.a.bF, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ag)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.ah = a(com.getui.gtc.extension.distribution.gbd.d.a.bH, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ah)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.ai = a(com.getui.gtc.extension.distribution.gbd.d.a.bG, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ai)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.aj = a(com.getui.gtc.extension.distribution.gbd.d.a.bI, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aj)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.ak = a(com.getui.gtc.extension.distribution.gbd.d.a.bJ, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ak)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.al = a(com.getui.gtc.extension.distribution.gbd.d.a.bK, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.al)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.an = a(com.getui.gtc.extension.distribution.gbd.d.a.bN, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.an)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.ao = a(com.getui.gtc.extension.distribution.gbd.d.a.bO, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ao)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.am = a(com.getui.gtc.extension.distribution.gbd.d.a.bP, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.am)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.R = a(com.getui.gtc.extension.distribution.gbd.d.a.bV, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.R)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.W = a(com.getui.gtc.extension.distribution.gbd.d.a.ca, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.W)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.X = a(com.getui.gtc.extension.distribution.gbd.d.a.cb, com.getui.gtc.extension.distribution.gbd.d.d.X);
        com.getui.gtc.extension.distribution.gbd.d.d.Z = a(com.getui.gtc.extension.distribution.gbd.d.a.cd, com.getui.gtc.extension.distribution.gbd.d.d.Z);
        com.getui.gtc.extension.distribution.gbd.d.d.S = a(com.getui.gtc.extension.distribution.gbd.d.a.bW, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.S)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.T = a(com.getui.gtc.extension.distribution.gbd.d.a.bX, com.getui.gtc.extension.distribution.gbd.d.d.T);
        com.getui.gtc.extension.distribution.gbd.d.d.U = a(com.getui.gtc.extension.distribution.gbd.d.a.bY, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.U)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.V = a(com.getui.gtc.extension.distribution.gbd.d.a.bZ, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.V)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.f = a(com.getui.gtc.extension.distribution.gbd.d.a.cg, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.f)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.g = a(com.getui.gtc.extension.distribution.gbd.d.a.ch, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.g)).longValue();
        com.getui.gtc.extension.distribution.gbd.n.j.b(e, "from config, e_p=" + com.getui.gtc.extension.distribution.gbd.d.d.f + ", e_i=" + com.getui.gtc.extension.distribution.gbd.d.d.g);
        com.getui.gtc.extension.distribution.gbd.d.d.aq = a(com.getui.gtc.extension.distribution.gbd.d.a.bl, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.aq)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.ar = a(com.getui.gtc.extension.distribution.gbd.d.a.bm, com.getui.gtc.extension.distribution.gbd.d.d.ar);
        com.getui.gtc.extension.distribution.gbd.d.d.y = a(com.getui.gtc.extension.distribution.gbd.d.a.bp, com.getui.gtc.extension.distribution.gbd.d.d.y);
        com.getui.gtc.extension.distribution.gbd.d.d.C = a(com.getui.gtc.extension.distribution.gbd.d.a.bq, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.C)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.z = a(com.getui.gtc.extension.distribution.gbd.d.a.br, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.z)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.w = a(com.getui.gtc.extension.distribution.gbd.d.a.bs, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.w)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.i = a(com.getui.gtc.extension.distribution.gbd.d.a.bt, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.i)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.j = a(com.getui.gtc.extension.distribution.gbd.d.a.bC, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.j)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.k = a(com.getui.gtc.extension.distribution.gbd.d.a.bu, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.k)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.u = a(com.getui.gtc.extension.distribution.gbd.d.a.bv, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.u)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.q = a(com.getui.gtc.extension.distribution.gbd.d.a.bw, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.q)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.r = a(com.getui.gtc.extension.distribution.gbd.d.a.bx, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.r)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.f323s = a(com.getui.gtc.extension.distribution.gbd.d.a.by, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.f323s)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.t = a(com.getui.gtc.extension.distribution.gbd.d.a.bz, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.t)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.o = a(com.getui.gtc.extension.distribution.gbd.d.a.bA, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.o)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.p = a(com.getui.gtc.extension.distribution.gbd.d.a.bB, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.p)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.f322cn = a(com.getui.gtc.extension.distribution.gbd.d.a.ce, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.f322cn)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cp = a(com.getui.gtc.extension.distribution.gbd.d.a.cf, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cp)).booleanValue();
        int i2 = com.getui.gtc.extension.distribution.gbd.d.h.aJ;
        com.getui.gtc.extension.distribution.gbd.d.d.Y = i2;
        a4 = a(com.getui.gtc.extension.distribution.gbd.d.a.cc, -1);
        com.getui.gtc.extension.distribution.gbd.n.j.b(e, "old_v=" + i2 + ", new_v=" + a4);
        if (com.getui.gtc.extension.distribution.gbd.d.d.x && a4 > 0 && a4 > i2) {
            com.getui.gtc.extension.distribution.gbd.d.d.Y = a4;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.d.h.aJ = a4;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a(293, java.lang.String.valueOf(a4));
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.a(true);
            com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.d.e.AnonymousClass2());
        }
        com.getui.gtc.extension.distribution.gbd.d.d.cq = a(com.getui.gtc.extension.distribution.gbd.d.a.ci, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cq)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cr = a(com.getui.gtc.extension.distribution.gbd.d.a.cj, com.getui.gtc.extension.distribution.gbd.d.d.cr);
        com.getui.gtc.extension.distribution.gbd.d.d.cs = a(com.getui.gtc.extension.distribution.gbd.d.a.ck, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cs)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.ct = a(com.getui.gtc.extension.distribution.gbd.d.a.cl, com.getui.gtc.extension.distribution.gbd.d.d.ct);
        com.getui.gtc.extension.distribution.gbd.d.d.cu = a(com.getui.gtc.extension.distribution.gbd.d.a.cm, com.getui.gtc.extension.distribution.gbd.d.d.cu);
        com.getui.gtc.extension.distribution.gbd.d.d.cv = a(com.getui.gtc.extension.distribution.gbd.d.a.f320cn, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cv)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cw = a(com.getui.gtc.extension.distribution.gbd.d.a.co, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cw)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cx = a(com.getui.gtc.extension.distribution.gbd.d.a.cp, com.getui.gtc.extension.distribution.gbd.d.d.cx);
        com.getui.gtc.extension.distribution.gbd.d.d.cA = a(com.getui.gtc.extension.distribution.gbd.d.a.cq, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cA)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cB = a(com.getui.gtc.extension.distribution.gbd.d.a.cr, com.getui.gtc.extension.distribution.gbd.d.d.cB);
        com.getui.gtc.extension.distribution.gbd.d.d.cy = a(com.getui.gtc.extension.distribution.gbd.d.a.cs, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cy)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cz = a(com.getui.gtc.extension.distribution.gbd.d.a.ct, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cz)).booleanValue();
        a5 = a(com.getui.gtc.extension.distribution.gbd.d.a.cu, com.getui.gtc.extension.distribution.gbd.d.d.cE);
        com.getui.gtc.extension.distribution.gbd.d.d.cE = a5;
        if (!android.text.TextUtils.isEmpty(a5)) {
            com.getui.gtc.extension.distribution.gbd.d.h.aR = com.getui.gtc.extension.distribution.gbd.n.ab.c();
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(e, "* interval = " + com.getui.gtc.extension.distribution.gbd.d.d.cA + ", cu path = " + com.getui.gtc.extension.distribution.gbd.d.d.cE);
        com.getui.gtc.extension.distribution.gbd.d.d.cF = a(com.getui.gtc.extension.distribution.gbd.d.a.cv, com.getui.gtc.extension.distribution.gbd.d.d.cF);
        com.getui.gtc.extension.distribution.gbd.d.d.cC = a(com.getui.gtc.extension.distribution.gbd.d.a.cw, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cC)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cD = a(com.getui.gtc.extension.distribution.gbd.d.a.cx, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cD)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cG = a(com.getui.gtc.extension.distribution.gbd.d.a.cy, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cG)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cH = a(com.getui.gtc.extension.distribution.gbd.d.a.cz, com.getui.gtc.extension.distribution.gbd.d.d.cH);
        com.getui.gtc.extension.distribution.gbd.d.d.cI = a(com.getui.gtc.extension.distribution.gbd.d.a.cA, com.getui.gtc.extension.distribution.gbd.d.d.cI);
        com.getui.gtc.extension.distribution.gbd.d.d.cO = a(com.getui.gtc.extension.distribution.gbd.d.a.cB, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cO)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cP = a(com.getui.gtc.extension.distribution.gbd.d.a.cH, com.getui.gtc.extension.distribution.gbd.d.d.cP);
        com.getui.gtc.extension.distribution.gbd.d.d.cQ = a(com.getui.gtc.extension.distribution.gbd.d.a.cI, com.getui.gtc.extension.distribution.gbd.d.d.cQ);
        com.getui.gtc.extension.distribution.gbd.d.d.cJ = a(com.getui.gtc.extension.distribution.gbd.d.a.cC, com.getui.gtc.extension.distribution.gbd.d.d.cJ);
        com.getui.gtc.extension.distribution.gbd.d.d.cK = a(com.getui.gtc.extension.distribution.gbd.d.a.cD, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cK)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cY = a(com.getui.gtc.extension.distribution.gbd.d.a.cO, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cY)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cX = a(com.getui.gtc.extension.distribution.gbd.d.a.cP, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cX)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cW = a(com.getui.gtc.extension.distribution.gbd.d.a.cQ, com.getui.gtc.extension.distribution.gbd.d.d.cW);
        com.getui.gtc.extension.distribution.gbd.d.d.cZ = a(com.getui.gtc.extension.distribution.gbd.d.a.cT, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cZ)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.db = a(com.getui.gtc.extension.distribution.gbd.d.a.cR, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.db)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.da = a(com.getui.gtc.extension.distribution.gbd.d.a.cS, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.da)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cL = a(com.getui.gtc.extension.distribution.gbd.d.a.cE, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cL)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cN = a(com.getui.gtc.extension.distribution.gbd.d.a.cG, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cN)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.cM = a(com.getui.gtc.extension.distribution.gbd.d.a.cF, com.getui.gtc.extension.distribution.gbd.d.d.cM);
        if (com.getui.gtc.extension.distribution.gbd.d.d.x && com.getui.gtc.extension.distribution.gbd.d.d.cL && !z && !z2) {
            com.getui.gtc.extension.distribution.gbd.d.h.aO = true;
            if (com.getui.gtc.extension.distribution.gbd.d.h.b != null && com.getui.gtc.extension.distribution.gbd.d.d.cN) {
                android.os.Message obtain4 = android.os.Message.obtain();
                obtain4.what = 202;
                com.getui.gtc.extension.distribution.gbd.d.h.b.sendMessage(obtain4);
            }
        }
        a6 = a(com.getui.gtc.extension.distribution.gbd.d.a.cJ, "");
        com.getui.gtc.extension.distribution.gbd.d.d.cR.clear();
        if (!android.text.TextUtils.isEmpty(a6) && !a6.equals("*")) {
            for (java.lang.String str : a6.split(",")) {
                if (!android.text.TextUtils.isEmpty(str) && str.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                    try {
                        com.getui.gtc.extension.distribution.gbd.d.d.cR.put(str.substring(0, str.lastIndexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)), str.substring(str.lastIndexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) + 1));
                    } catch (java.lang.Throwable th3) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th3);
                    }
                }
            }
        }
        com.getui.gtc.extension.distribution.gbd.d.d.cS = a(com.getui.gtc.extension.distribution.gbd.d.a.cK, com.getui.gtc.extension.distribution.gbd.d.d.cS);
        int a102 = a(com.getui.gtc.extension.distribution.gbd.d.a.cL, 1);
        com.getui.gtc.extension.distribution.gbd.d.d.cU = (a102 & 2) == 0;
        com.getui.gtc.extension.distribution.gbd.d.d.cT = (a102 & 1) == 0;
        com.getui.gtc.extension.distribution.gbd.d.d.dc = a(com.getui.gtc.extension.distribution.gbd.d.a.cU, com.getui.gtc.extension.distribution.gbd.d.d.dc);
        com.getui.gtc.extension.distribution.gbd.d.d.dd = a(com.getui.gtc.extension.distribution.gbd.d.a.cW, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dd)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.df = a(com.getui.gtc.extension.distribution.gbd.d.a.cX, com.getui.gtc.extension.distribution.gbd.d.d.df);
        com.getui.gtc.extension.distribution.gbd.d.d.dg = a(com.getui.gtc.extension.distribution.gbd.d.a.cY, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dg)).longValue();
        com.getui.gtc.extension.distribution.gbd.f.h.a(a(com.getui.gtc.extension.distribution.gbd.d.a.da, java.lang.Boolean.FALSE).booleanValue(), a(com.getui.gtc.extension.distribution.gbd.d.a.cZ, (java.lang.String) null));
        a7 = a(com.getui.gtc.extension.distribution.gbd.d.a.db, "");
        if (!android.text.TextUtils.isEmpty(a7)) {
            try {
                java.lang.String[] split = a7.split("\\|");
                if (split != null && split.length >= 3) {
                    int parseInt = java.lang.Integer.parseInt(split[0]);
                    int parseInt2 = java.lang.Integer.parseInt(split[1]);
                    int parseInt3 = java.lang.Integer.parseInt(split[2]);
                    com.getui.gtc.extension.distribution.gbd.d.d.dh = parseInt;
                    com.getui.gtc.extension.distribution.gbd.d.d.di = parseInt2;
                    com.getui.gtc.extension.distribution.gbd.d.d.dj = parseInt3;
                }
            } catch (java.lang.Throwable th4) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th4);
            }
        }
        com.getui.gtc.extension.distribution.gbd.d.d.dk = a(com.getui.gtc.extension.distribution.gbd.d.a.dc, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dk)).booleanValue();
        aVar = com.getui.gtc.extension.distribution.gbd.b.a.b.a;
        aVar.a = a(com.getui.gtc.extension.distribution.gbd.d.a.M, aVar.a);
        int a112 = a(com.getui.gtc.extension.distribution.gbd.d.a.aT, aVar.b);
        aVar.b = a112;
        aVar.b = java.lang.Math.max(a112, 29);
        com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_ArpHelper", "ap mc = " + aVar.a + ", x sdk int = " + aVar.b);
        a8 = a(com.getui.gtc.extension.distribution.gbd.d.a.aS, "nl:0,ipn:1");
        if (a8 != null && a8.length() != 0) {
            aVar.a(a8, aVar.a);
        }
        com.getui.gtc.extension.distribution.gbd.d.d.dn = a(com.getui.gtc.extension.distribution.gbd.d.a.df, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dn)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.f3do = a(com.getui.gtc.extension.distribution.gbd.d.a.dg, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.f3do)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.dp = a(com.getui.gtc.extension.distribution.gbd.d.a.dl, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dp)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.dq = a(com.getui.gtc.extension.distribution.gbd.d.a.dm, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dq)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.dr = a(com.getui.gtc.extension.distribution.gbd.d.a.dn, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dr)).booleanValue();
        longValue = a(com.getui.gtc.extension.distribution.gbd.d.a.f2do, java.lang.Long.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.ds)).longValue();
        com.getui.gtc.extension.distribution.gbd.d.d.ds = longValue;
        if (longValue <= 2) {
            com.getui.gtc.extension.distribution.gbd.d.d.ds = 10L;
        }
        com.getui.gtc.extension.distribution.gbd.d.d.dt = a(com.getui.gtc.extension.distribution.gbd.d.a.dp, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dt)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.du = a(com.getui.gtc.extension.distribution.gbd.d.a.dq, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.du)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.dv = a(com.getui.gtc.extension.distribution.gbd.d.a.dr, com.getui.gtc.extension.distribution.gbd.d.d.dv);
        com.getui.gtc.extension.distribution.gbd.d.d.dw = a(com.getui.gtc.extension.distribution.gbd.d.a.ds, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dw)).booleanValue();
        com.getui.gtc.extension.distribution.gbd.d.d.dx = a(com.getui.gtc.extension.distribution.gbd.d.a.dt, java.lang.Boolean.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.dx)).booleanValue();
    }

    public final void b() {
        com.getui.gtc.extension.distribution.gbd.n.j.a(e, "  get gbd config form " + com.getui.gtc.extension.distribution.gbd.d.i.a() + " cid = " + com.getui.gtc.extension.distribution.gbd.d.c.e + " appid = " + com.getui.gtc.extension.distribution.gbd.d.c.a + "-->start GTC-DYC");
        com.getui.gtc.extension.distribution.gbd.d.j.a aVar = new com.getui.gtc.extension.distribution.gbd.d.j.a();
        aVar.a.b("gbd");
        aVar.a.a(com.getui.gtc.extension.distribution.gbd.d.i.a());
        aVar.a.f("GBD-2.10.5.2");
        aVar.a.c(com.getui.gtc.extension.distribution.gbd.d.c.a);
        aVar.a.d(com.getui.gtc.extension.distribution.gbd.d.c.e);
        aVar.a.e("sdkconfig");
        aVar.a.g(86400000L);
        aVar.a.h(new com.getui.gtc.extension.distribution.gbd.d.e.AnonymousClass1().b);
        a(com.getui.gtc.dyc.b.a.a(com.getui.gtc.extension.distribution.gbd.d.c.d, new com.getui.gtc.extension.distribution.gbd.d.j(aVar, (byte) 0).a));
    }
}
