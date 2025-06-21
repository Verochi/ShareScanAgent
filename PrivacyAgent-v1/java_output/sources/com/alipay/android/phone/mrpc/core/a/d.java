package com.alipay.android.phone.mrpc.core.a;

/* loaded from: classes.dex */
public final class d extends com.alipay.android.phone.mrpc.core.a.a {
    public d(java.lang.reflect.Type type, byte[] bArr) {
        super(type, bArr);
    }

    @Override // com.alipay.android.phone.mrpc.core.a.c
    public final java.lang.Object a() {
        try {
            java.lang.String str = new java.lang.String(this.b);
            java.lang.Thread.currentThread().getId();
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            int i = jSONObject.getInt(com.alipay.sdk.m.u.l.a);
            if (i == 1000) {
                return this.a == java.lang.String.class ? jSONObject.optString("result") : com.alipay.sdk.m.e.e.a(jSONObject.optString("result"), this.a);
            }
            throw new com.alipay.android.phone.mrpc.core.RpcException(java.lang.Integer.valueOf(i), jSONObject.optString("tips"));
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("response  =");
            sb.append(new java.lang.String(this.b));
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(e);
            throw new com.alipay.android.phone.mrpc.core.RpcException((java.lang.Integer) 10, sb.toString() == null ? "" : e.getMessage());
        }
    }
}
