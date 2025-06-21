package com.amap.api.col.s;

/* loaded from: classes12.dex */
public class ad {
    public static volatile com.amap.api.col.s.ad b;
    public java.util.HashMap<java.lang.String, com.amap.api.col.s.ae> a = new java.util.HashMap<>();

    public static class a {
        public boolean a = true;
        public long b = com.anythink.expressad.d.a.b.aT;
        public int c = 10;
        public double d = 0.0d;

        public final void a(double d) {
            this.d = d;
        }

        public final void b(int i) {
            this.c = i;
        }

        public final void c(long j) {
            this.b = j;
        }

        public final void d(boolean z) {
            this.a = z;
        }

        public final boolean e() {
            return this.a;
        }

        public final long f() {
            return this.b;
        }

        public final int g() {
            return this.c;
        }

        public final double h() {
            return this.d;
        }
    }

    public static class b {
        public java.lang.String a;
        public java.lang.Object b;

        public final boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && com.amap.api.col.s.ad.b.class == obj.getClass()) {
                com.amap.api.col.s.ad.b bVar = (com.amap.api.col.s.ad.b) obj;
                java.lang.String str = this.a;
                if (str == null) {
                    return bVar.a == null && this.b == bVar.b;
                }
                if (str.equals(bVar.a) && this.b == bVar.b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            java.lang.String str = this.a;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            java.lang.Object obj = this.b;
            return hashCode + (obj != null ? obj.hashCode() : 0);
        }
    }

    public static class c {
        public java.lang.Object a;
        public boolean b;

        public c(java.lang.Object obj, boolean z) {
            this.a = obj;
            this.b = z;
        }
    }

    public static com.amap.api.col.s.ad a() {
        if (b == null) {
            synchronized (com.amap.api.col.s.ad.class) {
                if (b == null) {
                    b = new com.amap.api.col.s.ad();
                }
            }
        }
        return b;
    }

    public final com.amap.api.col.s.ad.c a(com.amap.api.col.s.ad.b bVar) {
        com.amap.api.col.s.ad.c a2;
        if (bVar == null) {
            return null;
        }
        for (com.amap.api.col.s.ae aeVar : this.a.values()) {
            if (aeVar != null && (a2 = aeVar.a(bVar)) != null) {
                return a2;
            }
        }
        return null;
    }

    public final synchronized com.amap.api.col.s.ae a(java.lang.String str) {
        return this.a.get(str);
    }

    public final void a(com.amap.api.col.s.ad.a aVar) {
        if (aVar == null) {
            return;
        }
        for (com.amap.api.col.s.ae aeVar : this.a.values()) {
            if (aeVar != null) {
                aeVar.c(aVar);
            }
        }
    }

    public final void a(com.amap.api.col.s.ad.b bVar, java.lang.Object obj) {
        for (com.amap.api.col.s.ae aeVar : this.a.values()) {
            if (aeVar != null) {
                aeVar.d(bVar, obj);
            }
        }
    }

    public final void a(java.lang.String str, com.amap.api.col.s.ad.a aVar) {
        com.amap.api.col.s.ae aeVar;
        if (str == null || aVar == null || (aeVar = this.a.get(str)) == null) {
            return;
        }
        aeVar.c(aVar);
    }

    public final synchronized void a(java.lang.String str, com.amap.api.col.s.ae aeVar) {
        this.a.put(str, aeVar);
    }

    public final boolean b(com.amap.api.col.s.ad.b bVar) {
        if (bVar == null) {
            return false;
        }
        for (com.amap.api.col.s.ae aeVar : this.a.values()) {
            if (aeVar != null && aeVar.j(bVar)) {
                return true;
            }
        }
        return false;
    }
}
