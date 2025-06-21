package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class gl {
    private com.amap.api.mapcore.util.fh a;
    private volatile int b = -1;

    public static class a {
        public static java.util.Map<java.lang.String, com.amap.api.mapcore.util.gl> a = new java.util.HashMap();
    }

    private gl(com.amap.api.mapcore.util.fh fhVar) {
        this.a = fhVar;
    }

    public static com.amap.api.mapcore.util.gl a(com.amap.api.mapcore.util.fh fhVar) {
        if (com.amap.api.mapcore.util.gl.a.a.get(fhVar.a()) == null) {
            com.amap.api.mapcore.util.gl.a.a.put(fhVar.a(), new com.amap.api.mapcore.util.gl(fhVar));
        }
        return com.amap.api.mapcore.util.gl.a.a.get(fhVar.a());
    }

    public final void a(android.content.Context context, boolean z, boolean z2) {
        com.amap.api.mapcore.util.gp.a(context, this.a, "sckey", java.lang.String.valueOf(z));
        if (z) {
            com.amap.api.mapcore.util.gp.a(context, this.a, "scisf", java.lang.String.valueOf(z2));
        }
    }

    public final boolean a(android.content.Context context) {
        try {
            return java.lang.Boolean.parseBoolean(com.amap.api.mapcore.util.gp.a(context, this.a, "sckey"));
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public final boolean b(android.content.Context context) {
        try {
            return java.lang.Boolean.parseBoolean(com.amap.api.mapcore.util.gp.a(context, this.a, "scisf"));
        } catch (java.lang.Throwable unused) {
            return true;
        }
    }
}
