package com.getui.gtc.extension.distribution.gbd.g.a;

/* loaded from: classes22.dex */
public final class c extends com.getui.gtc.extension.distribution.gbd.g.d {
    private static final java.lang.String A = "GBD_DefaultHttpPlugin";
    public static final java.lang.String y = "header";
    public static final java.lang.String z = "data";

    public c(com.getui.gtc.extension.distribution.gbd.g.c cVar) {
        this.m = cVar;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.g.d
    public final void a(int i) {
        com.getui.gtc.extension.distribution.gbd.g.c cVar = this.m;
        if (cVar != null) {
            try {
                cVar.a(null);
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.g.d
    public final void a(java.lang.Throwable th) {
        com.getui.gtc.extension.distribution.gbd.g.c cVar = this.m;
        if (cVar != null) {
            try {
                cVar.a(null);
            } catch (java.lang.Throwable th2) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
            }
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.g.d
    public final void a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, byte[] bArr) {
        try {
            if (this.m != null) {
                java.util.HashMap hashMap = new java.util.HashMap();
                hashMap.put("header", map);
                hashMap.put("data", new java.lang.String(bArr, "utf-8"));
                this.m.a(hashMap);
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }
}
