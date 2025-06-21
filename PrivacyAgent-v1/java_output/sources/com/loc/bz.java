package com.loc;

/* loaded from: classes23.dex */
public final class bz {
    private android.content.Context a;
    private com.loc.x b;
    private java.lang.String c;

    public bz(android.content.Context context, com.loc.x xVar, java.lang.String str) {
        this.a = context.getApplicationContext();
        this.b = xVar;
        this.c = str;
    }

    private static java.lang.String a(android.content.Context context, com.loc.x xVar, java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(xVar.c());
            sb.append("\",\"product\":\"");
            sb.append(xVar.a());
            sb.append("\",\"nt\":\"");
            sb.append(com.loc.p.c(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public final byte[] a() {
        return com.loc.y.a(a(this.a, this.b, this.c));
    }
}
