package com.igexin.push.d.a;

/* loaded from: classes23.dex */
public final class a extends com.igexin.c.a.b.d {
    private static final java.lang.String a = "CommandFilter";

    public a(java.lang.String str, com.igexin.c.a.b.d dVar) {
        super(str, (byte) 0);
        a(dVar);
    }

    private static boolean a(com.igexin.push.d.c.a aVar, com.igexin.push.d.c.c cVar) {
        java.lang.String string;
        if (aVar.b != 26) {
            return false;
        }
        com.igexin.push.d.c.n nVar = (com.igexin.push.d.c.n) cVar;
        if (nVar.d() && nVar.f != null) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject((java.lang.String) nVar.f);
                if (jSONObject.has("action") && (string = jSONObject.getString("action")) != null) {
                    if (string.equals(com.igexin.push.core.b.F)) {
                        return true;
                    }
                }
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
                com.igexin.c.a.c.a.a("CommandFilter|" + e.toString(), new java.lang.Object[0]);
            }
        }
        return false;
    }

    private static com.igexin.c.a.d.a.e c(java.lang.Object obj) throws java.lang.Exception {
        if (obj == null) {
            return null;
        }
        com.igexin.push.d.c.a aVar = (com.igexin.push.d.c.a) obj;
        byte b = aVar.b;
        com.igexin.push.d.c.c hVar = b != 0 ? b != 5 ? b != 9 ? b != 20 ? b != 26 ? b != 37 ? b != 97 ? null : new com.igexin.push.d.c.h() : new com.igexin.push.d.c.m() : new com.igexin.push.d.c.n() : new com.igexin.push.d.c.q() : new com.igexin.push.d.c.p() : new com.igexin.push.d.c.k() : new com.igexin.push.d.c.f();
        int i = aVar.f;
        if ((i != 1 && i != 7) || hVar == null) {
            return null;
        }
        hVar.a(aVar.e);
        if (aVar.f != 7) {
            if (a(aVar, hVar)) {
                return hVar;
            }
            return null;
        }
        if (aVar.g != 32 || a(aVar, hVar)) {
            return hVar;
        }
        com.igexin.c.a.c.a.a(a, "version = 7 and enc type = 0x20, redirect = false");
        return null;
    }

    @Override // com.igexin.c.a.b.d
    public final java.lang.Object a(java.lang.Object obj) throws java.lang.Exception {
        if (obj instanceof com.igexin.push.d.c.c) {
            com.igexin.push.d.c.c cVar = (com.igexin.push.d.c.c) obj;
            com.igexin.push.d.c.a aVar = new com.igexin.push.d.c.a();
            aVar.b = (byte) cVar.m;
            aVar.a(cVar.b());
            aVar.c = cVar.n;
            aVar.d = cVar.o;
            return aVar;
        }
        if (!(obj instanceof com.igexin.push.d.c.c[])) {
            return null;
        }
        com.igexin.push.d.c.c[] cVarArr = (com.igexin.push.d.c.c[]) obj;
        com.igexin.push.d.c.a[] aVarArr = new com.igexin.push.d.c.a[cVarArr.length];
        for (int i = 0; i < cVarArr.length; i++) {
            com.igexin.push.d.c.a aVar2 = new com.igexin.push.d.c.a();
            aVarArr[i] = aVar2;
            com.igexin.push.d.c.c cVar2 = cVarArr[i];
            aVar2.b = (byte) cVar2.m;
            aVar2.a(cVar2.b());
        }
        return aVarArr;
    }

    @Override // com.igexin.c.a.b.d
    public final /* synthetic */ java.lang.Object b(java.lang.Object obj) throws java.lang.Exception {
        return c(obj);
    }
}
