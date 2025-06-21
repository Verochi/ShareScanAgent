package com.alipay.android.phone.mrpc.core.a;

/* loaded from: classes.dex */
public final class e extends com.alipay.android.phone.mrpc.core.a.b {
    public int c;
    public java.lang.Object d;

    public e(int i, java.lang.String str, java.lang.Object obj) {
        super(str, obj);
        this.c = i;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final void a(java.lang.Object obj) {
        this.d = obj;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final byte[] a() {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (this.d != null) {
                arrayList.add(new org.apache.http.message.BasicNameValuePair("extParam", com.alipay.sdk.m.e.f.a(this.d)));
            }
            arrayList.add(new org.apache.http.message.BasicNameValuePair("operationType", this.a));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(this.c);
            arrayList.add(new org.apache.http.message.BasicNameValuePair("id", sb.toString()));
            java.util.Objects.toString(this.b);
            java.lang.Object obj = this.b;
            arrayList.add(new org.apache.http.message.BasicNameValuePair("requestData", obj == null ? "[]" : com.alipay.sdk.m.e.f.a(obj)));
            return org.apache.http.client.utils.URLEncodedUtils.format(arrayList, "utf-8").getBytes();
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("request  =");
            sb2.append(this.b);
            sb2.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb2.append(e);
            throw new com.alipay.android.phone.mrpc.core.RpcException(9, sb2.toString() == null ? "" : e.getMessage(), e);
        }
    }
}
