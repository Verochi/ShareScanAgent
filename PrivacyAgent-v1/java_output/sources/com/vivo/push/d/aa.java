package com.vivo.push.d;

/* loaded from: classes19.dex */
final class aa extends com.vivo.push.d.z {
    public aa(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        com.vivo.push.b.t tVar = (com.vivo.push.b.t) oVar;
        java.util.ArrayList<java.lang.String> d = tVar.d();
        java.util.List<java.lang.String> e = tVar.e();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        java.util.ArrayList arrayList4 = new java.util.ArrayList();
        int h = tVar.h();
        java.lang.String g = tVar.g();
        if (d != null) {
            for (java.lang.String str : d) {
                if (str.startsWith("ali/")) {
                    arrayList2.add(str.replace("ali/", ""));
                } else if (str.startsWith("tag/")) {
                    arrayList.add(str.replace("tag/", ""));
                }
            }
        }
        if (e != null) {
            for (java.lang.String str2 : e) {
                if (str2.startsWith("ali/")) {
                    arrayList4.add(str2.replace("ali/", ""));
                } else if (str2.startsWith("tag/")) {
                    arrayList3.add(str2.replace("tag/", ""));
                }
            }
        }
        if (arrayList.size() > 0 || arrayList3.size() > 0) {
            if (arrayList.size() > 0) {
                com.vivo.push.e.a().a(arrayList);
            }
            com.vivo.push.e.a().a(tVar.g(), arrayList3.size() > 0 ? 10000 : h);
            com.vivo.push.m.b(new com.vivo.push.d.ab(this, h, arrayList, arrayList3, g));
        }
        if (arrayList2.size() > 0 || arrayList4.size() > 0) {
            if (arrayList2.size() > 0) {
                com.vivo.push.e.a().b((java.lang.String) arrayList2.get(0));
            }
            com.vivo.push.e.a().a(tVar.g(), h);
            com.vivo.push.m.b(new com.vivo.push.d.ac(this, h, arrayList2, arrayList4, g));
        }
    }
}
