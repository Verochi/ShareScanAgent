package com.anythink.core.d;

/* loaded from: classes12.dex */
public final class k {
    private static com.anythink.core.common.f.au a(int i, int i2, org.json.JSONObject jSONObject) {
        com.anythink.core.api.ATCustomAdapterConfig b;
        org.json.JSONArray optJSONArray;
        int i3 = (i2 == 0 || i2 == 4 || i2 == 8) ? 0 : 1;
        com.anythink.core.common.f.au auVar = new com.anythink.core.common.f.au(i);
        auVar.e(i2);
        auVar.d(i3);
        if (jSONObject.isNull(com.anythink.core.common.j.B)) {
            auVar.c("");
        } else {
            auVar.c(jSONObject.optString(com.anythink.core.common.j.B));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.y)) {
            auVar.b(-1);
        } else {
            auVar.b(jSONObject.optInt(com.anythink.core.common.j.y));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.z)) {
            auVar.c(-1);
        } else {
            auVar.c(jSONObject.optInt(com.anythink.core.common.j.z));
        }
        if (jSONObject.isNull("content")) {
            auVar.b("");
        } else {
            auVar.b(jSONObject.optString("content"));
        }
        if (jSONObject.isNull("nw_firm_id")) {
            auVar.a(-1);
        } else {
            auVar.a(jSONObject.optInt("nw_firm_id"));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.x)) {
            auVar.a("");
        } else {
            auVar.a(jSONObject.optString(com.anythink.core.common.j.x));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.C)) {
            auVar.d("unknown");
        } else {
            auVar.d(jSONObject.optString(com.anythink.core.common.j.C));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.v)) {
            auVar.c(0L);
        } else {
            auVar.c(jSONObject.optInt(com.anythink.core.common.j.v));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.t)) {
            auVar.d(0L);
        } else {
            auVar.d(jSONObject.optInt(com.anythink.core.common.j.t));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.u)) {
            auVar.h(1);
        } else {
            auVar.h(jSONObject.optInt(com.anythink.core.common.j.u));
        }
        if (jSONObject.isNull("pacing")) {
            auVar.e(-1L);
        } else {
            auVar.e(jSONObject.optLong("pacing"));
        }
        if (jSONObject.isNull("unit_id")) {
            auVar.e("");
        } else {
            auVar.e(jSONObject.optString("unit_id"));
        }
        if (jSONObject.isNull("ecpm")) {
            auVar.a(0.0d);
        } else {
            auVar.a(jSONObject.optDouble("ecpm", 0.0d));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.G)) {
            auVar.f(2000L);
        } else {
            auVar.f(jSONObject.optInt(com.anythink.core.common.j.G));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.I)) {
            auVar.f("");
        } else {
            auVar.f(jSONObject.optString(com.anythink.core.common.j.I));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.J)) {
            auVar.i(0);
        } else {
            auVar.i(jSONObject.optInt(com.anythink.core.common.j.J));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.K)) {
            auVar.j(3000);
        } else {
            auVar.j(jSONObject.optInt(com.anythink.core.common.j.K));
        }
        if (jSONObject.isNull("payload")) {
            auVar.g("");
        } else {
            auVar.g(jSONObject.optString("payload"));
        }
        if (jSONObject.isNull("error")) {
            auVar.h("");
        } else {
            auVar.h(jSONObject.optString("error"));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.L)) {
            auVar.g(1800000L);
        } else {
            auVar.g(jSONObject.optLong(com.anythink.core.common.j.L));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.M)) {
            auVar.h(-1L);
        } else {
            auVar.h(jSONObject.optLong(com.anythink.core.common.j.M));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.N)) {
            auVar.b(1800000L);
        } else {
            auVar.b(jSONObject.optLong(com.anythink.core.common.j.N));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.ak)) {
            auVar.g(i3 ^ 1);
        } else {
            auVar.g(jSONObject.optInt(com.anythink.core.common.j.ak));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.O)) {
            auVar.k(1);
        } else {
            auVar.k(jSONObject.optInt(com.anythink.core.common.j.O));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.P)) {
            auVar.l(1);
        } else {
            auVar.l(jSONObject.optInt(com.anythink.core.common.j.P));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.Q)) {
            auVar.m(-1);
        } else {
            auVar.m(jSONObject.optInt(com.anythink.core.common.j.Q));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.R)) {
            auVar.i("publisher_defined");
        } else {
            auVar.i(jSONObject.optString(com.anythink.core.common.j.R));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.S)) {
            auVar.i(0L);
        } else {
            auVar.i(jSONObject.optLong(com.anythink.core.common.j.S));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.T)) {
            auVar.j(0L);
        } else {
            auVar.j(jSONObject.optLong(com.anythink.core.common.j.T));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.U)) {
            auVar.b(0.0d);
        } else {
            auVar.b(jSONObject.optDouble(com.anythink.core.common.j.U, 0.0d));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.V)) {
            auVar.n(1);
        } else {
            auVar.n(jSONObject.optInt(com.anythink.core.common.j.V));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.W)) {
            auVar.o(1);
        } else {
            auVar.o(jSONObject.optInt(com.anythink.core.common.j.W));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.X)) {
            auVar.p(2);
        } else {
            auVar.p(jSONObject.optInt(com.anythink.core.common.j.X));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.Y)) {
            auVar.f(1);
        } else {
            auVar.f(jSONObject.optInt(com.anythink.core.common.j.Y));
        }
        if (jSONObject.isNull("s2s_sw")) {
            auVar.q(2);
        } else {
            auVar.q(jSONObject.optInt("s2s_sw"));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.Z)) {
            auVar.s(2);
        } else {
            auVar.s(jSONObject.optInt(com.anythink.core.common.j.Z));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.aa)) {
            auVar.r(0);
        } else {
            auVar.r(jSONObject.optInt(com.anythink.core.common.j.aa));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.ac)) {
            auVar.t(1);
        } else {
            auVar.t(jSONObject.optInt(com.anythink.core.common.j.ac));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.af)) {
            auVar.j("");
        } else {
            auVar.j(jSONObject.optString(com.anythink.core.common.j.af));
        }
        if (i2 == 7) {
            com.anythink.core.common.d.c.a(com.anythink.core.common.b.o.a().f()).a(auVar.u(), auVar.U());
        }
        if (jSONObject.isNull(com.anythink.core.common.j.ad)) {
            auVar.u(2);
        } else {
            auVar.u(jSONObject.optInt(com.anythink.core.common.j.ad));
        }
        if (jSONObject.isNull("ad_type")) {
            auVar.v(-1);
        } else {
            auVar.v(jSONObject.optInt("ad_type", -1));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.ag)) {
            auVar.w(-1);
        } else {
            auVar.w(jSONObject.optInt(com.anythink.core.common.j.ag, -1));
        }
        if (auVar.m() != 2) {
            auVar.a(com.anythink.core.api.ATAdConst.CURRENCY.USD);
        } else if (auVar.d() == 22) {
            auVar.a(com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT);
        } else {
            auVar.a(com.anythink.core.api.ATAdConst.CURRENCY.USD);
        }
        if (jSONObject.isNull(com.anythink.core.common.j.ah)) {
            auVar.y(0);
        } else {
            auVar.y(jSONObject.optInt(com.anythink.core.common.j.ah, 0));
        }
        if (jSONObject.isNull("bid_floor")) {
            auVar.c(0.0d);
        } else {
            auVar.c(jSONObject.optDouble("bid_floor", 0.0d));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.an)) {
            auVar.z(-1);
        } else {
            auVar.z(jSONObject.optInt(com.anythink.core.common.j.an, -1));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.ao)) {
            auVar.d(auVar.y());
        } else {
            auVar.d(jSONObject.optDouble(com.anythink.core.common.j.ao, auVar.y()));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.ap)) {
            auVar.k("CNY");
        } else {
            auVar.k(jSONObject.optString(com.anythink.core.common.j.ap, "CNY"));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.aq)) {
            auVar.A(2);
        } else {
            auVar.A(jSONObject.optInt(com.anythink.core.common.j.aq, 2));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.ar)) {
            auVar.D(1);
        } else {
            auVar.D(jSONObject.optInt(com.anythink.core.common.j.ar));
        }
        if (jSONObject.isNull(com.anythink.core.common.j.as)) {
            auVar.E(2);
        } else {
            auVar.E(jSONObject.optInt(com.anythink.core.common.j.as, 2));
        }
        if (jSONObject.has(com.anythink.core.common.j.at)) {
            auVar.l(jSONObject.optString(com.anythink.core.common.j.at));
        } else {
            auVar.l("AT");
        }
        auVar.k(jSONObject.optLong(com.anythink.core.common.j.au, 15000L));
        int[] iArr = null;
        if (!jSONObject.isNull(com.anythink.core.d.e.a.as) && (optJSONArray = jSONObject.optJSONArray(com.anythink.core.d.e.a.as)) != null && optJSONArray.length() > 0) {
            try {
                iArr = new int[optJSONArray.length()];
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    iArr[i4] = optJSONArray.getInt(i4);
                }
            } catch (java.lang.Exception unused) {
            }
        }
        auVar.a(iArr);
        auVar.f(jSONObject.optDouble(com.anythink.core.common.j.av, 0.0d) / 100.0d);
        auVar.g(jSONObject.optDouble(com.anythink.core.common.j.aw, 0.0d) / 100.0d);
        auVar.h(jSONObject.optDouble(com.anythink.core.common.j.ax, 0.0d) / 100.0d);
        auVar.i(jSONObject.optDouble(com.anythink.core.common.j.ay, 0.0d) / 100.0d);
        auVar.F(jSONObject.optInt(com.anythink.core.common.j.az, 1));
        auVar.G(jSONObject.optInt(com.anythink.core.common.j.aA, 1));
        if (!jSONObject.isNull(com.anythink.core.common.j.aB)) {
            auVar.a(jSONObject.optJSONArray(com.anythink.core.common.j.aB));
        }
        if (!jSONObject.isNull(com.anythink.core.common.j.aC)) {
            auVar.H(jSONObject.optInt(com.anythink.core.common.j.aC));
        }
        if (auVar.d() >= 100000 && (b = com.anythink.core.common.b.o.a().b(auVar.i())) != null) {
            auVar.f(b.isRealTimeBidSwitch() ? 2 : 1);
            auVar.c(b.getAdCacheTime());
            if (b.getLossNoticePostion() > 0) {
                auVar.z(b.getLossNoticePostion());
            }
        }
        return auVar;
    }

    public static java.util.List<com.anythink.core.common.f.au> a(com.anythink.core.d.e eVar) {
        java.util.List<com.anythink.core.common.f.au> a = a(eVar, eVar.aq(), 1, 3);
        java.util.List<com.anythink.core.common.f.au> a2 = a(eVar, eVar.O(), 3, 4);
        java.util.List<com.anythink.core.common.f.au> a3 = a(eVar, eVar.ar(), 2, 2);
        java.util.List<com.anythink.core.common.f.au> a4 = a(eVar, eVar.M(), 5, 7);
        java.util.List<com.anythink.core.common.f.au> a5 = a(eVar, eVar.E(), 6, 11);
        java.util.List<com.anythink.core.common.f.au> a6 = a(eVar, eVar.ax(), 7, 8);
        java.util.List<com.anythink.core.common.f.au> a7 = a(eVar, eVar.aA(), 3, 5);
        a.addAll(a2);
        a.addAll(a3);
        a.addAll(a4);
        a.addAll(a5);
        a.addAll(a6);
        a.addAll(a7);
        return a;
    }

    public static java.util.List<com.anythink.core.common.f.au> a(com.anythink.core.d.e eVar, java.lang.String str) {
        return a(eVar, str, 3, 4);
    }

    private static java.util.List<com.anythink.core.common.f.au> a(com.anythink.core.d.e eVar, java.lang.String str, int i, int i2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject != null) {
                    com.anythink.core.common.f.au a = a(i2, i, jSONObject);
                    a(eVar, a);
                    arrayList.add(a);
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return arrayList;
    }

    private static void a(com.anythink.core.d.e eVar, com.anythink.core.common.f.au auVar) {
        if (auVar.ad() > 0.0d || eVar == null) {
            return;
        }
        double aD = eVar.aD();
        if (aD > 0.0d) {
            auVar.c(aD);
        }
    }

    public static void a(com.anythink.core.d.e eVar, java.util.Map<java.lang.String, com.anythink.core.common.f.au> map, java.util.List<com.anythink.core.common.f.au> list) {
        a(eVar, map, list, eVar.ao(), 0, 1);
        a(eVar, map, list, eVar.ap(), 0, 6);
        a(eVar, map, list, eVar.aq(), 1, 3);
        a(eVar, map, list, eVar.O(), 3, 4);
        a(eVar, map, list, eVar.ar(), 2, 2);
        a(eVar, map, list, eVar.M(), 5, 7);
        a(eVar, map, list, eVar.E(), 6, 11);
        a(eVar, map, list, eVar.ax(), 7, 8);
        a(eVar, map, list, eVar.aA(), 3, 5);
        a(eVar, map, list, eVar.z(), 8, 10);
        a(eVar, map, list, eVar.s(), 2, 9);
    }

    private static void a(com.anythink.core.d.e eVar, java.util.Map<java.lang.String, com.anythink.core.common.f.au> map, java.util.List<com.anythink.core.common.f.au> list, java.lang.String str, int i, int i2) {
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    com.anythink.core.common.f.au a = a(i2, i, optJSONObject);
                    map.put(a.u(), a);
                    if (a.d() == 35) {
                        list.add(a);
                    }
                    a(eVar, a);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static java.util.List<com.anythink.core.common.f.au> b(com.anythink.core.d.e eVar) {
        java.util.List<com.anythink.core.common.f.au> a = a(eVar, eVar.ao(), 0, 1);
        a.addAll(a(eVar, eVar.ap(), 4, 6));
        java.util.Collections.sort(a);
        return a;
    }

    public static java.util.List<com.anythink.core.common.f.au> c(com.anythink.core.d.e eVar) {
        return a(eVar, eVar.z(), 8, 10);
    }

    public static java.util.List<com.anythink.core.common.f.au> d(com.anythink.core.d.e eVar) {
        java.util.List<com.anythink.core.common.f.au> a = a(eVar, eVar.s(), 2, 9);
        java.util.Iterator<com.anythink.core.common.f.au> it = a.iterator();
        while (it.hasNext()) {
            it.next().ai();
        }
        return a;
    }
}
