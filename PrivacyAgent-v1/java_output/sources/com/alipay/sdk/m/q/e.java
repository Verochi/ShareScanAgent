package com.alipay.sdk.m.q;

/* loaded from: classes.dex */
public class e extends com.alipay.sdk.m.p.e {
    @Override // com.alipay.sdk.m.p.e
    public com.alipay.sdk.m.p.b a(com.alipay.sdk.m.s.a aVar, android.content.Context context, java.lang.String str) throws java.lang.Throwable {
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "mdap post");
        byte[] a = com.alipay.sdk.m.n.b.a(str.getBytes(java.nio.charset.Charset.forName("UTF-8")));
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("utdId", com.alipay.sdk.m.s.b.d().c());
        hashMap.put("logHeader", "RAW");
        hashMap.put("bizCode", com.alipay.sdk.m.u.e.b);
        hashMap.put("productId", "alipaysdk_android");
        hashMap.put("Content-Encoding", "Gzip");
        hashMap.put("productVersion", "15.8.11");
        com.alipay.sdk.m.o.a.b a2 = com.alipay.sdk.m.o.a.a(context, new com.alipay.sdk.m.o.a.C0039a(com.alipay.sdk.m.l.a.d, hashMap, a));
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "mdap got " + a2);
        if (a2 == null) {
            throw new java.lang.RuntimeException("Response is null");
        }
        boolean a3 = com.alipay.sdk.m.p.e.a(a2);
        try {
            byte[] bArr = a2.c;
            if (a3) {
                bArr = com.alipay.sdk.m.n.b.b(bArr);
            }
            return new com.alipay.sdk.m.p.b("", new java.lang.String(bArr, java.nio.charset.Charset.forName("UTF-8")));
        } catch (java.lang.Exception e) {
            com.alipay.sdk.m.u.e.a(e);
            return null;
        }
    }

    @Override // com.alipay.sdk.m.p.e
    public java.lang.String a(com.alipay.sdk.m.s.a aVar, java.lang.String str, org.json.JSONObject jSONObject) {
        return str;
    }

    @Override // com.alipay.sdk.m.p.e
    public java.util.Map<java.lang.String, java.lang.String> a(boolean z, java.lang.String str) {
        return new java.util.HashMap();
    }

    @Override // com.alipay.sdk.m.p.e
    public org.json.JSONObject a() {
        return null;
    }

    @Override // com.alipay.sdk.m.p.e
    public boolean c() {
        return false;
    }
}
