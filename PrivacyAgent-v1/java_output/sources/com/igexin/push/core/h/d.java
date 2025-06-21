package com.igexin.push.core.h;

/* loaded from: classes23.dex */
public class d extends com.igexin.push.g.a.d {
    public static final java.lang.String a = "UploadBiLogPlugin";
    public boolean b;
    private int c;

    public d(java.lang.String str, byte[] bArr, int i) {
        super(str);
        this.c = i;
        a(bArr, i);
    }

    private d(byte[] bArr, int i) {
        super(com.igexin.push.config.SDKUrlConfig.getBiUploadServiceUrl());
        a(bArr, i);
    }

    private void a(byte[] bArr, int i) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("action", "upload_BI");
            jSONObject.put("BIType", java.lang.String.valueOf(i));
            jSONObject.put("cid", com.igexin.push.core.e.A);
            jSONObject.put("BIData", new java.lang.String(com.igexin.c.a.b.g.c(bArr), "UTF-8"));
            this.g = jSONObject.toString().getBytes();
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    @Override // com.igexin.push.g.a.d
    public void a(byte[] bArr) throws java.lang.Exception {
        org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(bArr));
        if (jSONObject.has("result") && "ok".equals(jSONObject.getString("result"))) {
            this.b = true;
            if (this.c == 10) {
                com.igexin.c.a.c.a.b("UploadBITask", "upload type 10 success ####");
            }
        }
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return 0;
    }
}
