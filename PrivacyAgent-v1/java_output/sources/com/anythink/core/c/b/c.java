package com.anythink.core.c.b;

/* loaded from: classes12.dex */
public final class c implements com.anythink.core.c.b.a {
    private static final java.lang.String a = "PlacementStatisticRecord";
    private final com.anythink.core.d.f b = com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f());
    private final com.anythink.core.c.b.d c;
    private final com.anythink.core.c.b.e d;
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.c.a.b> e;
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> f;

    /* renamed from: com.anythink.core.c.b.c$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.c.b.c.this.e.remove(this.a);
            com.anythink.core.c.b.c.this.c.a(this.a);
        }
    }

    public c() {
        com.anythink.core.c.b.d c = com.anythink.core.c.b.d.c();
        this.c = c;
        this.d = new com.anythink.core.c.b.e(c);
        this.e = new java.util.concurrent.ConcurrentHashMap<>();
        this.f = new java.util.concurrent.ConcurrentHashMap<>();
    }

    private double a(java.lang.String str, org.json.JSONArray jSONArray) {
        com.anythink.core.c.a.b d = d(str);
        if (!d.e()) {
            d.g();
            return d.g();
        }
        if (jSONArray == null) {
            return -1.0d;
        }
        try {
            if (jSONArray.length() > 0) {
                return jSONArray.getJSONObject(0).getDouble("ecpm");
            }
            return -1.0d;
        } catch (java.lang.Exception e) {
            e.getMessage();
            return -1.0d;
        }
    }

    private void a(com.anythink.core.c.a.a aVar) {
        aVar.toString();
        java.lang.String i = aVar.i();
        com.anythink.core.c.a.b d = d(i);
        com.anythink.core.c.b.d dVar = this.c;
        if (dVar != null) {
            dVar.a(aVar);
        }
        if (aVar.j() == 4) {
            a(i, d);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        if (r12 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004e, code lost:
    
        if (r2[1] == r12[1]) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(java.lang.String str, com.anythink.core.c.a.b bVar) {
        double[][] f;
        if (bVar == null || (f = bVar.f()) == null) {
            return;
        }
        if (bVar.e()) {
            f(str);
            return;
        }
        double[] b = b(str, bVar);
        boolean z = false;
        double d = b[0];
        boolean z2 = true;
        double d2 = b[1];
        if (d == d2) {
            return;
        }
        double[] a2 = d > 0.0d ? a(f, d) : null;
        double[] a3 = d2 > 0.0d ? a(f, d2) : null;
        if (a2 != null) {
            if (a3 != null) {
                if (a2[0] == a3[0]) {
                }
                z = true;
                z2 = z;
            }
        }
        if (z2) {
            f(str);
        }
    }

    private static double[] a(double[][] dArr, double d) {
        for (double[] dArr2 : dArr) {
            if (dArr2.length == 2) {
                double d2 = dArr2[0];
                double d3 = dArr2[1];
                if (d >= d2 && d <= d3) {
                    return dArr2;
                }
            }
        }
        return null;
    }

    private static com.anythink.core.c.a.a b(com.anythink.core.common.f.at atVar, com.anythink.core.common.f.au auVar) {
        com.anythink.core.c.a.a aVar = new com.anythink.core.c.a.a();
        if (atVar != null) {
            aVar.a(atVar.ad());
            aVar.e(atVar.ac());
        }
        if (auVar != null) {
            aVar.b(auVar.u());
            com.anythink.core.common.f.q M = auVar.M();
            if (M != null) {
                com.anythink.core.common.f.bb bbVar = M.u;
                aVar.c(bbVar != null ? bbVar.d() : "");
            }
            aVar.a(auVar.aq() > 0.0d ? auVar.aq() : auVar.y());
            aVar.a(auVar.d());
        }
        aVar.d(com.anythink.core.common.b.o.a().q());
        aVar.a(java.lang.System.currentTimeMillis());
        aVar.b(4);
        return aVar;
    }

    private static com.anythink.core.c.a.a b(java.lang.String str, java.lang.String str2, com.anythink.core.common.f.au auVar) {
        com.anythink.core.c.a.a aVar = new com.anythink.core.c.a.a();
        if (auVar != null) {
            aVar.b(auVar.u());
            com.anythink.core.common.f.q M = auVar.M();
            if (M != null) {
                com.anythink.core.common.f.bb bbVar = M.u;
                aVar.c(bbVar != null ? bbVar.d() : "");
            }
            aVar.a(auVar.y());
            aVar.a(auVar.d());
        }
        aVar.a(str);
        aVar.d(com.anythink.core.common.b.o.a().q());
        aVar.a(java.lang.System.currentTimeMillis());
        aVar.e(str2);
        aVar.b(10);
        return aVar;
    }

    private org.json.JSONArray b(int i, java.lang.String str, int i2) {
        java.util.List<com.anythink.core.c.a.a> a2 = a(i, str, i2);
        if (a2 == null || a2.size() == 0) {
            return null;
        }
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Iterator<com.anythink.core.c.a.a> it = a2.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().h());
        }
        return jSONArray;
    }

    private double[] b(java.lang.String str, com.anythink.core.c.a.b bVar) {
        if (bVar == null || bVar.e()) {
            return new double[]{-1.0d, -1.0d};
        }
        double a2 = this.d.a(bVar.d(), str);
        double g = bVar.g();
        if (g != a2) {
            bVar.a(a2);
            this.e.put(str, bVar);
            com.anythink.core.common.o.r.a(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.u, str, java.lang.String.valueOf(a2));
        }
        return new double[]{a2, g};
    }

    private boolean c(java.lang.String str) {
        boolean c = d(str).c();
        java.lang.Boolean bool = this.f.get(str);
        if (bool != null) {
            boolean equals = java.lang.Boolean.TRUE.equals(bool);
            if (!c && equals) {
                e(str);
            }
        } else if (!c) {
            e(str);
        }
        this.f.put(str, java.lang.Boolean.valueOf(c));
        return c;
    }

    private com.anythink.core.c.a.b d(java.lang.String str) {
        com.anythink.core.d.e b = this.b.b(str);
        com.anythink.core.c.a.b bVar = this.e.get(str);
        if (bVar == null) {
            bVar = new com.anythink.core.c.a.b();
            java.lang.String b2 = com.anythink.core.common.o.r.b(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.u, str, "");
            if (!android.text.TextUtils.isEmpty(b2)) {
                try {
                    bVar.a(java.lang.Double.parseDouble(b2));
                } catch (java.lang.Exception e) {
                    e.getMessage();
                }
            }
            this.e.put(str, bVar);
        }
        if (b != null) {
            bVar.a(b.aM());
            bVar.a(b.aP());
            bVar.b(b.aO());
            bVar.c(b.aR());
        }
        return bVar;
    }

    private void e(java.lang.String str) {
        com.anythink.core.common.o.b.b.a().b(new com.anythink.core.c.b.c.AnonymousClass1(str));
    }

    private void f(java.lang.String str) {
        com.anythink.core.common.b.o a2 = com.anythink.core.common.b.o.a();
        this.b.a(this.b.e(str), a2.o(), a2.p(), str, null, null, true);
    }

    @Override // com.anythink.core.c.b.a
    public final java.util.List<com.anythink.core.c.a.a> a(int i, java.lang.String str, int i2) {
        com.anythink.core.c.b.d dVar = this.c;
        if (dVar != null) {
            return dVar.a(i, str, i2);
        }
        return null;
    }

    @Override // com.anythink.core.c.b.a
    public final org.json.JSONObject a(java.lang.String str) {
        return a(str, 0);
    }

    @Override // com.anythink.core.c.b.a
    public final org.json.JSONObject a(java.lang.String str, int i) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        com.anythink.core.c.a.b d = d(str);
        if (d.b()) {
            return a(str, i, d.a());
        }
        return null;
    }

    @Override // com.anythink.core.c.b.a
    public final org.json.JSONObject a(java.lang.String str, int i, int i2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            if (i == 4) {
                org.json.JSONArray b = b(4, str, i2);
                if (b != null) {
                    jSONObject.put(com.umeng.analytics.pro.ay.c, b);
                }
            } else if (i == 10) {
                org.json.JSONArray b2 = b(10, str, i2);
                if (b2 != null) {
                    jSONObject.put("fill", b2);
                }
            } else {
                org.json.JSONArray b3 = b(10, str, i2);
                if (b3 != null) {
                    jSONObject.put("fill", b3);
                }
                org.json.JSONArray b4 = b(4, str, i2);
                if (b4 != null) {
                    jSONObject.put(com.umeng.analytics.pro.ay.c, b4);
                }
                jSONObject.put("def_ecpm", java.lang.String.valueOf(a(str, b4)));
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (java.lang.Exception e) {
            e.getMessage();
            return null;
        }
    }

    @Override // com.anythink.core.c.b.a
    public final void a(com.anythink.core.common.f.at atVar, com.anythink.core.common.f.au auVar) {
        if (atVar == null || auVar == null) {
            return;
        }
        java.lang.String ac = atVar.ac();
        if (!android.text.TextUtils.isEmpty(ac) && c(ac)) {
            com.anythink.core.c.a.a aVar = new com.anythink.core.c.a.a();
            aVar.a(atVar.ad());
            aVar.e(atVar.ac());
            aVar.b(auVar.u());
            com.anythink.core.common.f.q M = auVar.M();
            if (M != null) {
                com.anythink.core.common.f.bb bbVar = M.u;
                aVar.c(bbVar != null ? bbVar.d() : "");
            }
            aVar.a(auVar.aq() > 0.0d ? auVar.aq() : auVar.y());
            aVar.a(auVar.d());
            aVar.d(com.anythink.core.common.b.o.a().q());
            aVar.a(java.lang.System.currentTimeMillis());
            aVar.b(4);
            a(aVar);
        }
    }

    @Override // com.anythink.core.c.b.a
    public final void a(java.lang.String str, java.lang.String str2, com.anythink.core.common.f.au auVar) {
        if (!android.text.TextUtils.isEmpty(str) && c(str)) {
            com.anythink.core.c.a.a aVar = new com.anythink.core.c.a.a();
            if (auVar != null) {
                aVar.b(auVar.u());
                com.anythink.core.common.f.q M = auVar.M();
                if (M != null) {
                    com.anythink.core.common.f.bb bbVar = M.u;
                    aVar.c(bbVar != null ? bbVar.d() : "");
                }
                aVar.a(auVar.y());
                aVar.a(auVar.d());
            }
            aVar.a(str2);
            aVar.d(com.anythink.core.common.b.o.a().q());
            aVar.a(java.lang.System.currentTimeMillis());
            aVar.e(str);
            aVar.b(10);
            a(aVar);
        }
    }

    @Override // com.anythink.core.c.b.a
    public final void b(java.lang.String str) {
        b(str, d(str));
    }
}
