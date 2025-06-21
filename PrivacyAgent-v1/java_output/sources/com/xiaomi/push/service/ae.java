package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class ae {
    public static int a(com.xiaomi.push.service.ad adVar, com.xiaomi.push.gq gqVar) {
        return adVar.a(gqVar, com.xiaomi.push.service.af.a[gqVar.ordinal()] != 1 ? 0 : 1);
    }

    public static java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object>> a(java.util.List<com.xiaomi.push.gv> list, boolean z) {
        if (com.xiaomi.push.h.a(list)) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.xiaomi.push.gv gvVar : list) {
            int i = gvVar.a;
            com.xiaomi.push.gr a = com.xiaomi.push.gr.a(gvVar.b);
            if (a != null) {
                if (z && gvVar.c) {
                    arrayList.add(new android.util.Pair(java.lang.Integer.valueOf(i), null));
                } else {
                    int i2 = com.xiaomi.push.service.af.b[a.ordinal()];
                    arrayList.add(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? null : new android.util.Pair(java.lang.Integer.valueOf(i), java.lang.Boolean.valueOf(gvVar.g)) : new android.util.Pair(java.lang.Integer.valueOf(i), gvVar.f) : new android.util.Pair(java.lang.Integer.valueOf(i), java.lang.Long.valueOf(gvVar.e)) : new android.util.Pair(java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(gvVar.d)));
                }
            }
        }
        return arrayList;
    }

    public static void a(com.xiaomi.push.service.ad adVar, com.xiaomi.push.hj hjVar) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (com.xiaomi.push.gt gtVar : hjVar.a) {
            arrayList.add(new android.util.Pair<>(gtVar.c, java.lang.Integer.valueOf(gtVar.a)));
            java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object>> a = a(gtVar.b, false);
            if (!com.xiaomi.push.h.a(a)) {
                arrayList2.addAll(a);
            }
        }
        adVar.a(arrayList, arrayList2);
        adVar.b();
    }
}
