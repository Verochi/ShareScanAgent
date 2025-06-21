package com.getui.gtc.extension.distribution.gbd.g.a;

/* loaded from: classes22.dex */
public class g extends com.getui.gtc.extension.distribution.gbd.g.d {
    private static final java.lang.String A = "GBD_UBLP";
    private static final java.lang.String B = "action";
    private static final java.lang.String C = "upload_BI";
    private static final java.lang.String D = "BIType";
    private static final java.lang.String E = "cid";
    private static final java.lang.String F = "BIData";
    private static final java.lang.String G = "result";
    private static final java.lang.String H = "ok";
    int y;
    java.util.List<com.getui.gtc.extension.distribution.gbd.c.p> z;

    public g(byte[] bArr, int i, java.util.List<com.getui.gtc.extension.distribution.gbd.c.p> list) {
        super(com.getui.gtc.extension.distribution.gbd.g.b.a());
        this.l = true;
        this.z = list;
        this.y = i;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("action", C);
            jSONObject.put(D, java.lang.String.valueOf(i));
            jSONObject.put("cid", com.getui.gtc.extension.distribution.gbd.d.c.e);
            jSONObject.put(F, new java.lang.String(com.getui.gtc.extension.distribution.gbd.n.n.c(bArr), "UTF-8"));
            this.f = jSONObject.toString().getBytes();
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(A, "gbdreportReq|".concat(java.lang.String.valueOf(i)));
    }

    private void a(byte[] bArr, int i) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("action", C);
            jSONObject.put(D, java.lang.String.valueOf(i));
            jSONObject.put("cid", com.getui.gtc.extension.distribution.gbd.d.c.e);
            jSONObject.put(F, new java.lang.String(com.getui.gtc.extension.distribution.gbd.n.n.c(bArr), "UTF-8"));
            this.f = jSONObject.toString().getBytes();
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(A, "gbdreportReq|".concat(java.lang.String.valueOf(i)));
    }

    @Override // com.getui.gtc.extension.distribution.gbd.g.d
    public void a(int i) {
        try {
            com.getui.gtc.extension.distribution.gbd.c.b bVar = new com.getui.gtc.extension.distribution.gbd.c.b();
            bVar.b = false;
            bVar.a = this.z;
            this.m.a(bVar);
            com.getui.gtc.extension.distribution.gbd.n.j.b(A, "type = " + this.y + " requestFailed doReport failed...");
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.g.d
    public void a(java.lang.Throwable th) {
        try {
            if (this.m != null) {
                com.getui.gtc.extension.distribution.gbd.c.b bVar = new com.getui.gtc.extension.distribution.gbd.c.b();
                bVar.b = false;
                bVar.a = this.z;
                this.m.a(bVar);
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(A, "type = " + this.y + " exceptionHandler doReport error..." + th.toString());
        } catch (java.lang.Throwable th2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.g.d
    public void a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, byte[] bArr) {
        try {
            java.lang.String str = new java.lang.String(bArr);
            com.getui.gtc.extension.distribution.gbd.n.j.a(A, "parseData = ".concat(str));
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (jSONObject.has("result")) {
                java.lang.String string = jSONObject.getString("result");
                if (this.z == null || this.m == null) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(A, "send list = null type = " + this.y);
                    return;
                }
                com.getui.gtc.extension.distribution.gbd.c.b bVar = new com.getui.gtc.extension.distribution.gbd.c.b();
                bVar.a = this.z;
                if (string.equals("ok")) {
                    bVar.b = true;
                    this.m.a(bVar);
                    com.getui.gtc.extension.distribution.gbd.n.j.b(A, "gbdreportRsp|" + this.y);
                    return;
                }
                bVar.b = false;
                this.m.a(bVar);
                com.getui.gtc.extension.distribution.gbd.n.j.a(A, "result error type = " + this.y);
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }
}
