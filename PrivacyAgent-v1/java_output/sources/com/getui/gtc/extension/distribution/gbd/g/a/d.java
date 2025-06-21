package com.getui.gtc.extension.distribution.gbd.g.a;

/* loaded from: classes22.dex */
public final class d extends com.getui.gtc.extension.distribution.gbd.g.d {
    private static final java.lang.String A = "GBD_IPHttpPlugin";
    private static final java.lang.String B = "http://sdk.open.phone.igexin.com/api/addr.htm";
    public static final java.lang.String y = "ip";
    public static final java.lang.String z = "UTF-8";

    private d(com.getui.gtc.extension.distribution.gbd.g.c cVar) {
        this.e = B;
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
        com.getui.gtc.extension.distribution.gbd.g.c cVar;
        if (bArr == null) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(bArr, "UTF-8"));
            java.lang.String string = jSONObject.has("ip") ? jSONObject.getString("ip") : null;
            com.getui.gtc.extension.distribution.gbd.n.j.a(A, "IP ===== ".concat(java.lang.String.valueOf(string)));
            if (android.text.TextUtils.isEmpty(string) || (cVar = this.m) == null) {
                return;
            }
            cVar.a(string);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }
}
