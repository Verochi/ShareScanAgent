package com.anythink.core.b;

/* loaded from: classes12.dex */
public abstract class d {
    protected com.anythink.core.common.f.a f;
    protected boolean g;
    private final java.lang.String a = getClass().getSimpleName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR;
    protected java.util.concurrent.atomic.AtomicBoolean h = new java.util.concurrent.atomic.AtomicBoolean(false);

    public d(com.anythink.core.common.f.a aVar) {
        this.f = aVar;
    }

    private static double a(com.anythink.core.d.e eVar, com.anythink.core.api.ATAdConst.CURRENCY currency) {
        if (eVar == null) {
            return 1.0d;
        }
        if (currency == com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT) {
            return (1.0d / eVar.B()) * 100.0d;
        }
        if (currency == com.anythink.core.api.ATAdConst.CURRENCY.RMB) {
            return 1.0d / eVar.B();
        }
        return 1.0d;
    }

    public static org.json.JSONArray a(java.util.List<com.anythink.core.common.f.au> list) {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        try {
            for (com.anythink.core.common.f.au auVar : list) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("network_firm_id", auVar.d());
                jSONObject.put("ad_source_id", auVar.u());
                jSONObject.put("content", auVar.h());
                if (!android.text.TextUtils.isEmpty(auVar.A())) {
                    jSONObject.put("error", auVar.A());
                }
                jSONArray.put(jSONObject);
            }
        } catch (java.lang.Exception unused) {
        }
        return jSONArray;
    }

    public static void a(com.anythink.core.common.f.au auVar, java.lang.String str, long j, int i) {
        auVar.a(j);
        auVar.a(0.0d);
        auVar.d(0.0d);
        auVar.g(i);
        auVar.c();
        if (android.text.TextUtils.isEmpty(str)) {
            auVar.h("bid error");
        } else {
            auVar.h(str);
        }
    }

    public static org.json.JSONArray b(java.util.List<org.json.JSONObject> list) {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        try {
            for (org.json.JSONObject jSONObject : list) {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put("network_firm_id", 67);
                if (jSONObject.has("unit_ids")) {
                    jSONObject2.put("unit_ids", jSONObject.get("unit_ids"));
                }
                jSONArray.put(jSONObject2);
            }
        } catch (java.lang.Exception unused) {
        }
        return jSONArray;
    }

    public final double a(double d, com.anythink.core.api.ATAdConst.CURRENCY currency) {
        if (currency == null) {
            return d;
        }
        double a = a(this.f.n.a(), currency);
        java.lang.String.valueOf(d);
        java.lang.String.valueOf(a);
        double d2 = d * a;
        java.lang.String.valueOf(d2);
        return d2;
    }

    public final double a(double d, com.anythink.core.common.f.au auVar) {
        double B;
        if (auVar.ab() == null) {
            return d;
        }
        com.anythink.core.d.e a = this.f.n.a();
        if (auVar.ab() == com.anythink.core.api.ATAdConst.CURRENCY.RMB) {
            B = a.B();
        } else {
            if (auVar.ab() != com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT) {
                return d;
            }
            d /= 100.0d;
            B = a.B();
        }
        return d * B;
    }

    public final double a(com.anythink.core.common.f.au auVar) {
        if (auVar.ab() == null) {
            return 1.0d;
        }
        double a = a(this.f.n.a(), auVar.ab());
        auVar.e();
        return a;
    }

    public abstract void a();

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        if (r0 <= 1.0d) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(int i, com.anythink.core.common.f.o oVar, double d, boolean z) {
        double d2;
        if (i != 28) {
            return;
        }
        org.json.JSONObject r = this.f.n.a().r();
        if (r != null) {
            d2 = r.optDouble(java.lang.String.valueOf(i));
            if (d2 > 0.0d) {
            }
        }
        d2 = 0.95d;
        double d3 = oVar.originPrice * d2;
        com.anythink.core.common.p.h hVar = this.f.y;
        java.util.List<com.anythink.core.common.f.au> a = hVar != null ? hVar.a() : null;
        if (a != null) {
            java.util.Iterator<com.anythink.core.common.f.au> it = a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                double a2 = com.anythink.core.common.o.h.a(it.next());
                if (a2 < oVar.originPrice) {
                    d3 = java.lang.Math.max(d3, a2);
                    break;
                }
            }
        }
        double max = java.lang.Math.max(d3, d);
        double random = max + (java.lang.Math.random() * (oVar.originPrice - max));
        oVar.setPrice(random);
        if (z) {
            oVar.setSortPrice(random);
        }
    }

    public abstract void a(com.anythink.core.b.b.a aVar);

    public abstract void a(com.anythink.core.common.f.au auVar, com.anythink.core.common.f.o oVar, long j);

    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.anythink.core.common.f.au auVar, com.anythink.core.common.f.q qVar) {
        double sortPrice;
        double d;
        boolean z;
        double d2;
        if (qVar == null) {
            return;
        }
        qVar.b(this.f.d);
        com.anythink.core.common.f.q a = com.anythink.core.b.f.a().a(this.f.e, auVar);
        if (a != null) {
            boolean a2 = a.a();
            if (a2 || qVar.getSortPrice() > a.getSortPrice()) {
                sortPrice = qVar.getSortPrice();
                if (a2) {
                    com.anythink.core.b.d.b.a(a, new com.anythink.core.common.f.y(1, auVar, this.f.f167s, sortPrice), true);
                } else {
                    d2 = sortPrice;
                    z = true;
                }
            } else {
                d2 = a.getSortPrice();
                z = false;
            }
            d = d2;
            if (z) {
                try {
                    com.anythink.core.b.d.b.a(qVar, new com.anythink.core.common.f.y(2, auVar, this.f.f167s, d), false);
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                auVar.a(a, 1, 0, 1);
                return;
            }
            if (a != null) {
                try {
                    com.anythink.core.b.d.b.a(a, new com.anythink.core.common.f.y(2, auVar, this.f.f167s, d), true);
                } catch (java.lang.Throwable th2) {
                    th2.printStackTrace();
                }
            }
            auVar.a(qVar, 2, 0, 1);
            if (auVar.K() != 2) {
                com.anythink.core.b.f a3 = com.anythink.core.b.f.a();
                java.lang.String str = this.f.e;
                a3.a.put(str + qVar.k, qVar);
                if (auVar.Y()) {
                    com.anythink.core.common.a.a.a().a(str, qVar);
                    return;
                }
                return;
            }
            return;
        }
        sortPrice = qVar.getSortPrice();
        d = sortPrice;
        z = true;
        if (z) {
        }
    }

    public void a(boolean z) {
        this.g = z;
    }

    public final boolean a(com.anythink.core.common.f.au auVar, java.lang.String str, int i) {
        return a(auVar, str, i, 0);
    }

    public final boolean a(com.anythink.core.common.f.au auVar, java.lang.String str, int i, int i2) {
        com.anythink.core.common.f.q a = com.anythink.core.b.f.a().a(this.f.e, auVar);
        if (a != null && !a.a()) {
            auVar.a(a, 0, i, i2);
            auVar.h(str);
            return true;
        }
        if (a != null) {
            try {
                com.anythink.core.common.f.h S = this.f.f167s.S();
                S.x(a.c());
                com.anythink.core.b.d.b.a(a, new com.anythink.core.common.f.y(1, auVar, S), true);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public final boolean c() {
        return this.h.get();
    }
}
