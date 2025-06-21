package com.anythink.core.common.n;

/* loaded from: classes12.dex */
public final class e {
    private static void a(com.anythink.core.common.f.h hVar, int i, int i2, java.lang.String str, java.lang.String str2, int i3, java.lang.Boolean bool, java.lang.String str3, boolean z, boolean z2, boolean z3, boolean z4) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(hVar.ae(), null);
        kVar.a = "1004684";
        kVar.b = hVar.ad();
        kVar.d = hVar.ac();
        kVar.k = java.lang.String.valueOf(i);
        kVar.m = java.lang.String.valueOf(i3);
        kVar.n = java.lang.String.valueOf(hVar.ae());
        kVar.o = z ? "1" : "2";
        kVar.p = java.lang.String.valueOf(i2);
        if (!android.text.TextUtils.isEmpty(str)) {
            kVar.q = str;
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            kVar.r = str2;
        }
        kVar.f171s = bool == null ? "0" : bool.booleanValue() ? "1" : "2";
        kVar.t = str3;
        kVar.u = z2 ? "1" : "2";
        kVar.v = z3 ? "1" : "2";
        kVar.w = java.lang.String.valueOf(i);
        kVar.x = z4 ? "1" : "2";
        com.anythink.core.common.n.c.b(kVar);
    }

    public static void a(java.lang.String str, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.api.BaseAd baseAd) {
        java.lang.String str2;
        java.lang.String str3;
        try {
            java.lang.String q = com.anythink.core.common.b.o.a().q();
            java.lang.String str4 = com.igexin.push.core.b.m;
            if (aTBaseAdAdapter != null) {
                java.lang.String obj = aTBaseAdAdapter.toString();
                com.anythink.core.common.f.h trackingInfo = aTBaseAdAdapter.getTrackingInfo();
                str3 = trackingInfo != null ? trackingInfo.toString() : com.igexin.push.core.b.m;
                com.anythink.core.common.f.au unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
                if (unitGroupInfo != null) {
                    str4 = unitGroupInfo.toString();
                }
                str2 = str4;
                str4 = obj;
            } else {
                str2 = com.igexin.push.core.b.m;
                str3 = str2;
            }
            java.lang.String str5 = "format: " + str + " | adapter: " + str4 + " | tracking: " + str3 + " | unitGroupInfo: " + str2;
            if (baseAd != null) {
                str5 = str5 + " | baseAd: " + baseAd.toString();
            }
            com.anythink.core.common.n.c.a("Empty ATAdInfo", str5, q);
        } catch (java.lang.Throwable unused) {
        }
    }
}
