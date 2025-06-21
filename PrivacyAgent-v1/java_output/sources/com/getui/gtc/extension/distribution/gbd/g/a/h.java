package com.getui.gtc.extension.distribution.gbd.g.a;

/* loaded from: classes22.dex */
public final class h extends com.getui.gtc.extension.distribution.gbd.g.a.g {
    private static final java.lang.String A = "GBD_UBRTLP";

    private h(byte[] bArr, int i, java.util.List<com.getui.gtc.extension.distribution.gbd.c.p> list) {
        super(bArr, i, list);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.g.a.g, com.getui.gtc.extension.distribution.gbd.g.d
    public final void a(int i) {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(A, "type = " + this.y + "requestFailed doReport failed...");
            com.getui.gtc.extension.distribution.gbd.c.s sVar = new com.getui.gtc.extension.distribution.gbd.c.s();
            sVar.a = false;
            sVar.b = this.z;
            com.getui.gtc.extension.distribution.gbd.g.c cVar = this.m;
            if (cVar != null) {
                cVar.a(sVar);
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.g.a.g, com.getui.gtc.extension.distribution.gbd.g.d
    public final void a(java.lang.Throwable th) {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(A, "type = " + this.y + "exceptionHandler doReport error..." + th.toString());
            com.getui.gtc.extension.distribution.gbd.c.s sVar = new com.getui.gtc.extension.distribution.gbd.c.s();
            sVar.a = false;
            sVar.b = this.z;
            com.getui.gtc.extension.distribution.gbd.g.c cVar = this.m;
            if (cVar != null) {
                cVar.a(sVar);
            }
        } catch (java.lang.Throwable unused) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.g.a.g, com.getui.gtc.extension.distribution.gbd.g.d
    public final void a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, byte[] bArr) {
        try {
            java.lang.String str = new java.lang.String(bArr);
            com.getui.gtc.extension.distribution.gbd.n.j.b(A, "type " + this.y + " bi data upload result:" + str);
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (jSONObject.has("result")) {
                java.lang.String string = jSONObject.getString("result");
                com.getui.gtc.extension.distribution.gbd.c.s sVar = new com.getui.gtc.extension.distribution.gbd.c.s();
                if (string.equals("ok")) {
                    sVar.a = true;
                } else {
                    sVar.a = false;
                }
                sVar.b = this.z;
                com.getui.gtc.extension.distribution.gbd.g.c cVar = this.m;
                if (cVar != null) {
                    cVar.a(sVar);
                }
                com.getui.gtc.extension.distribution.gbd.n.j.b(A, "do " + this.y + " over ");
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }
}
