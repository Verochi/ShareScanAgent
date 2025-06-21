package com.amap.api.col.s;

/* loaded from: classes12.dex */
class ae {
    public boolean a = true;
    public long b = com.anythink.expressad.d.a.b.aT;
    public int c = 10;
    public long d = 0;
    public final java.util.LinkedHashMap<com.amap.api.col.s.ad.b, java.lang.Object> e = new java.util.LinkedHashMap<>();
    public final java.lang.Object f = new java.lang.Object();
    public final java.util.LinkedHashMap<com.amap.api.col.s.ad.b, java.lang.Object> g = new java.util.LinkedHashMap<>();
    public final java.lang.Object h = new java.lang.Object();
    public java.util.ArrayList<java.lang.String> i = new java.util.ArrayList<>();

    public ae(java.lang.String... strArr) {
        e(strArr);
    }

    public final com.amap.api.col.s.ad.c a(com.amap.api.col.s.ad.b bVar) {
        if (!this.a || bVar == null || !j(bVar)) {
            return null;
        }
        h();
        synchronized (this.f) {
            if (f(this.e, bVar)) {
                return new com.amap.api.col.s.ad.c(g(this.e, bVar), true);
            }
            synchronized (this.h) {
                if (f(this.g, bVar)) {
                    while (!f(this.e, bVar) && f(this.g, bVar)) {
                        try {
                            this.h.wait(1000L);
                        } catch (java.lang.InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    this.g.put(bVar, null);
                }
            }
            return new com.amap.api.col.s.ad.c(g(this.e, bVar), false);
        }
    }

    public final void b() {
        com.amap.api.col.s.ad.b bVar;
        int size = this.e.size();
        if (size <= 0 || size < this.c) {
            return;
        }
        java.util.Iterator<com.amap.api.col.s.ad.b> it = this.e.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            } else {
                bVar = it.next();
                if (bVar != null) {
                    break;
                }
            }
        }
        k(this.e, bVar);
    }

    public void c(com.amap.api.col.s.ad.a aVar) {
        if (aVar != null) {
            this.a = aVar.e();
            this.b = aVar.f();
            this.c = aVar.g();
        }
    }

    public final void d(com.amap.api.col.s.ad.b bVar, java.lang.Object obj) {
        if (this.a && bVar != null && j(bVar)) {
            i(bVar, obj);
            synchronized (this.h) {
                k(this.g, bVar);
                this.h.notify();
            }
        }
    }

    public final void e(java.lang.String... strArr) {
        this.d = java.lang.System.currentTimeMillis();
        this.e.clear();
        this.i.clear();
        for (java.lang.String str : strArr) {
            if (str != null) {
                this.i.add(str);
            }
        }
    }

    public boolean f(java.util.LinkedHashMap<com.amap.api.col.s.ad.b, java.lang.Object> linkedHashMap, com.amap.api.col.s.ad.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return false;
        }
        return linkedHashMap.containsKey(bVar);
    }

    public java.lang.Object g(java.util.LinkedHashMap<com.amap.api.col.s.ad.b, java.lang.Object> linkedHashMap, com.amap.api.col.s.ad.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        return linkedHashMap.get(bVar);
    }

    public final void h() {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if ((currentTimeMillis - this.d) / 1000 > this.b) {
            this.e.clear();
            this.d = currentTimeMillis;
        }
    }

    public final void i(com.amap.api.col.s.ad.b bVar, java.lang.Object obj) {
        synchronized (this.f) {
            b();
            h();
            this.e.put(bVar, obj);
        }
    }

    public final boolean j(com.amap.api.col.s.ad.b bVar) {
        if (bVar != null && bVar.a != null) {
            java.util.Iterator<java.lang.String> it = this.i.iterator();
            while (it.hasNext()) {
                java.lang.String next = it.next();
                if (next != null && bVar.a.contains(next)) {
                    return true;
                }
            }
        }
        return false;
    }

    public java.lang.Object k(java.util.LinkedHashMap<com.amap.api.col.s.ad.b, java.lang.Object> linkedHashMap, com.amap.api.col.s.ad.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        return linkedHashMap.remove(bVar);
    }
}
