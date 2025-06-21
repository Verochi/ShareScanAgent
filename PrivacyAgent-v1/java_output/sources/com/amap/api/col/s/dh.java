package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class dh {
    public android.content.Context a;
    public com.amap.api.col.s.bt b;
    public java.lang.String c;

    public static java.lang.String a(android.content.Context context, com.amap.api.col.s.bt btVar, java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(btVar.d());
            sb.append("\",\"product\":\"");
            sb.append(btVar.b());
            sb.append("\",\"nt\":\"");
            sb.append(com.amap.api.col.s.bm.d(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public final byte[] b() {
        return com.amap.api.col.s.bu.a(a(this.a, this.b, this.c));
    }
}
