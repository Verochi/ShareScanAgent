package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class t extends com.amap.api.col.s.b<java.lang.String, java.lang.Integer> {
    public android.content.Context t;
    public java.lang.String u;

    public t(android.content.Context context, java.lang.String str) {
        super(context, str);
        this.t = context;
        this.u = str;
    }

    public static java.lang.Integer G() throws com.amap.api.services.core.AMapException {
        return 0;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ java.lang.Object a(java.lang.String str) throws com.amap.api.services.core.AMapException {
        return G();
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final java.lang.String a_() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(com.amap.api.col.s.bi.f(this.t));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.u);
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        return com.amap.api.col.s.h.c() + "/nearby/data/delete";
    }
}
