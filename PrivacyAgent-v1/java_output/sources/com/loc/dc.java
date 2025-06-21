package com.loc;

/* loaded from: classes23.dex */
public final class dc {
    private static volatile com.loc.dc g;
    private static java.lang.Object h = new java.lang.Object();
    private long c;
    private com.loc.eh d;
    private com.loc.eh f = new com.loc.eh();
    private com.loc.db a = new com.loc.db();
    private com.loc.dd b = new com.loc.dd();
    private com.loc.cy e = new com.loc.cy();

    public static class a {
        public com.loc.eh a;
        public java.util.List<com.loc.ei> b;
        public long c;
        public long d;
        public boolean e;
        public long f;
        public byte g;
        public java.lang.String h;
        public java.util.List<com.loc.eb> i;
        public boolean j;
    }

    private dc() {
    }

    public static com.loc.dc a() {
        if (g == null) {
            synchronized (h) {
                if (g == null) {
                    g = new com.loc.dc();
                }
            }
        }
        return g;
    }

    public final com.loc.de a(com.loc.dc.a aVar) {
        com.loc.de deVar = null;
        if (aVar == null) {
            return null;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        com.loc.eh ehVar = this.d;
        if (ehVar == null || aVar.a.a(ehVar) >= 10.0d) {
            com.loc.db.a a2 = this.a.a(aVar.a, aVar.j, aVar.g, aVar.h, aVar.i);
            java.util.List<com.loc.ei> a3 = this.b.a(aVar.a, aVar.b, aVar.e, aVar.d, currentTimeMillis);
            if (a2 != null || a3 != null) {
                com.loc.dz.a(this.f, aVar.a, aVar.f, currentTimeMillis);
                deVar = new com.loc.de(0, this.e.a(this.f, a2, aVar.c, a3));
            }
            this.d = aVar.a;
            this.c = elapsedRealtime;
        }
        return deVar;
    }
}
