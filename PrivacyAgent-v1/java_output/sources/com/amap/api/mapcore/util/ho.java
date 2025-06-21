package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ho {
    private android.content.Context a;
    private com.amap.api.mapcore.util.fh b;
    private java.lang.String c;

    public ho(android.content.Context context, com.amap.api.mapcore.util.fh fhVar, java.lang.String str) {
        this.a = context.getApplicationContext();
        this.b = fhVar;
        this.c = str;
    }

    private static java.lang.String a(android.content.Context context, com.amap.api.mapcore.util.fh fhVar, java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(fhVar.c());
            sb.append("\",\"product\":\"");
            sb.append(fhVar.a());
            sb.append("\",\"nt\":\"");
            sb.append(com.amap.api.mapcore.util.ez.d(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public final byte[] a() {
        return com.amap.api.mapcore.util.fi.a(a(this.a, this.b, this.c));
    }
}
