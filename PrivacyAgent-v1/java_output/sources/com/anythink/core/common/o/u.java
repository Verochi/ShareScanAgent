package com.anythink.core.common.o;

/* loaded from: classes12.dex */
public final class u {
    public static com.anythink.core.common.f.h a(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.f.h hVar, com.anythink.core.common.f.au auVar) {
        aTBaseAdAdapter.setUnitGroupInfo(auVar);
        aTBaseAdAdapter.setRefresh(hVar.K() == 1);
        try {
            hVar.u = aTBaseAdAdapter.getInternalNetworkSDKVersion();
        } catch (java.lang.Throwable unused) {
        }
        if (android.text.TextUtils.isEmpty(hVar.Z())) {
            hVar.u(aTBaseAdAdapter.getInternalNetworkName());
        }
        hVar.e(aTBaseAdAdapter.getClass().getName());
        aTBaseAdAdapter.setTrackingInfo(hVar);
        return hVar;
    }

    public static com.anythink.core.common.f.h a(java.lang.String str, java.lang.String str2, com.anythink.core.d.e eVar, int i, int i2, java.util.Map<java.lang.String, java.lang.Object> map, com.anythink.core.common.f.c cVar) {
        com.anythink.core.common.f.h hVar = new com.anythink.core.common.f.h();
        hVar.w(str2);
        hVar.x(str);
        hVar.x(i);
        hVar.r = 0;
        hVar.q = 2;
        hVar.f170s = 0;
        a(hVar, eVar);
        hVar.X();
        hVar.K(com.anythink.core.common.b.o.a().i());
        hVar.L(i2);
        if (eVar != null) {
            hVar.I(eVar.f());
        } else {
            hVar.I(2);
        }
        a(map, hVar);
        hVar.a(cVar);
        return hVar;
    }

    public static void a(android.content.Context context, com.anythink.core.common.f.h hVar) {
        java.lang.System.currentTimeMillis();
        int parseInt = java.lang.Integer.parseInt(hVar.ae());
        int[] a = com.anythink.core.a.a.a(context).a(java.lang.Integer.parseInt(hVar.ae()));
        int i = a[0];
        int i2 = a[1];
        com.anythink.core.common.f.an a2 = com.anythink.core.a.a.a(context).a(hVar.ac(), parseInt);
        hVar.j(i + 1);
        hVar.k(i2 + 1);
        hVar.l((a2 != null ? a2.c : 0) + 1);
        hVar.m((a2 != null ? a2.d : 0) + 1);
        java.lang.System.currentTimeMillis();
    }

    public static void a(com.anythink.core.common.f.h hVar, com.anythink.core.common.f.au auVar, int i, boolean z) {
        com.anythink.core.common.f.q M;
        com.anythink.core.common.f.z b;
        com.anythink.core.common.f.an.a a = z ? com.anythink.core.a.a.a(com.anythink.core.common.b.o.a().f()).a(hVar.ac(), auVar.u(), java.lang.Integer.parseInt(hVar.ae())) : null;
        hVar.f(auVar.a());
        hVar.e(auVar.m());
        hVar.y(auVar.d());
        hVar.l(auVar.u());
        hVar.p(auVar.D());
        hVar.q(auVar.E());
        hVar.i(auVar.S());
        hVar.s(i);
        hVar.n(auVar.h());
        hVar.u(a != null ? a.e : 0);
        hVar.v(a != null ? a.d : 0);
        if (auVar.L()) {
            hVar.a(auVar.ao());
            hVar.f(auVar.y());
            hVar.c(auVar.af());
        } else {
            hVar.f(0.0d);
            hVar.c(0.0d);
        }
        if (auVar.k()) {
            if (auVar.T() != 2) {
                if (auVar.Z()) {
                    com.anythink.core.common.f.q M2 = auVar.M();
                    if (M2 != null) {
                        hVar.d(M2.o * hVar.l());
                        hVar.i(M2.p);
                    }
                } else {
                    hVar.d(auVar.y() * hVar.l());
                    hVar.i("exact");
                }
            }
            hVar.a(auVar.ad() * hVar.l());
        } else {
            hVar.d(auVar.J());
            java.lang.String G = auVar.G();
            if (android.text.TextUtils.isEmpty(G)) {
                G = "publisher_defined";
            }
            hVar.i(G);
        }
        hVar.r(auVar.j());
        hVar.f(auVar.z());
        hVar.an = auVar.v();
        hVar.ao = auVar.w();
        hVar.ap = auVar.x();
        hVar.n(auVar.F());
        hVar.h(auVar.T());
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(auVar.h());
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            if (35 == auVar.d()) {
                java.lang.String optString = jSONObject.optString("my_oid");
                com.anythink.core.d.e a2 = com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f()).a(hVar.ac());
                if (a2 != null && (b = a2.b(optString)) != null) {
                    jSONObject2.put("o_id", optString);
                    jSONObject2.put(com.bytedance.sdk.openadsdk.mediation.MediationConstant.EXTRA_CID, b.t());
                }
            }
            if ("0".equals(hVar.ae()) && (3 == auVar.m() || 7 == auVar.m())) {
                java.lang.String optString2 = jSONObject.optString("layout_type");
                if (android.text.TextUtils.isEmpty(optString2) || optString2.equals("0")) {
                    optString2 = "2";
                }
                jSONObject2.put("tpl_type", optString2);
            }
            if (28 == auVar.d() && (M = auVar.M()) != null) {
                jSONObject2.put("origin_price", M.originPrice);
            }
            hVar.p(jSONObject2.toString());
        } catch (java.lang.Throwable unused) {
        }
        com.anythink.core.common.f.q M3 = auVar.M();
        hVar.c(M3 != null ? M3.g : "");
        hVar.A(auVar.W());
        hVar.u(auVar.e());
    }

    private static void a(com.anythink.core.common.f.h hVar, com.anythink.core.common.f.az azVar) {
        if (hVar != null) {
            hVar.c(azVar.e());
            hVar.d(azVar.f());
        }
    }

    public static void a(com.anythink.core.common.f.h hVar, com.anythink.core.d.e eVar) {
        if (hVar == null || eVar == null) {
            return;
        }
        if (eVar.ag() == java.lang.Integer.parseInt("1")) {
            hVar.o("1");
        } else {
            hVar.o("0");
        }
        hVar.M(eVar.Y());
        hVar.v(eVar.ad());
        hVar.z(eVar.an());
        hVar.y(java.lang.String.valueOf(eVar.ag()));
        hVar.j(eVar.U());
        hVar.k(eVar.T());
        hVar.e(eVar.J());
        hVar.d(eVar.K());
        hVar.c(eVar.S());
        hVar.a(eVar.V());
        hVar.d(eVar.W());
        hVar.c(eVar.w());
        hVar.d(eVar.x());
        hVar.s(eVar.o());
        org.json.JSONObject aH = eVar.aH();
        if (aH != null) {
            hVar.a(aH);
        }
        hVar.I(eVar.f());
        if (com.anythink.core.common.w.a().c(hVar.ac())) {
            hVar.b(2);
        } else {
            hVar.b(1);
        }
        hVar.H(eVar.aS());
    }

    public static void a(java.lang.String str, com.anythink.core.common.f.h hVar) {
        com.anythink.core.d.e a;
        if (hVar == null || (a = com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f()).a(str)) == null || !a.aV()) {
            return;
        }
        a(str, a, hVar);
    }

    public static void a(java.lang.String str, com.anythink.core.d.e eVar, com.anythink.core.common.f.h hVar) {
        if (eVar == null || hVar == null) {
            return;
        }
        com.anythink.core.common.f.c cVar = new com.anythink.core.common.f.c();
        cVar.a(str, eVar.an(), eVar.Y());
        hVar.a(cVar);
    }

    public static void a(java.util.Map<java.lang.String, java.lang.Object> map, com.anythink.core.common.f.h hVar) {
        if (map != null) {
            java.lang.Object obj = map.get(com.anythink.core.api.ATAdConst.KEY.CP_PLACEMENT_ID);
            if (obj != null) {
                hVar.t(obj.toString());
            }
            java.lang.Object obj2 = map.get(com.anythink.core.api.ATAdConst.KEY.CP_LOAD_MODE);
            if (obj2 instanceof java.lang.Integer) {
                hVar.J(java.lang.Integer.parseInt(obj2.toString()));
            }
            java.lang.Object obj3 = map.get(com.anythink.core.common.e.b);
            if (obj3 != null) {
                hVar.a(obj3);
            }
        }
    }
}
