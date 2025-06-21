package com.getui.gtc.dim.b;

/* loaded from: classes22.dex */
public final class c {
    private static final java.util.List<java.lang.String> b = java.util.Arrays.asList(com.getui.gtc.extension.distribution.gbd.f.e.b.O, com.getui.gtc.extension.distribution.gbd.f.e.b.M, com.getui.gtc.extension.distribution.gbd.f.e.b.L, com.getui.gtc.extension.distribution.gbd.f.e.b.K);
    private final java.util.Map<java.lang.String, com.getui.gtc.dim.b.h> a;

    public static class a {
        private static final com.getui.gtc.dim.b.c a = new com.getui.gtc.dim.b.c((byte) 0);
    }

    private c() {
        this.a = new java.util.concurrent.ConcurrentHashMap();
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    public static com.getui.gtc.dim.b.c a() {
        return com.getui.gtc.dim.b.c.a.a;
    }

    public final com.getui.gtc.dim.b.h a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        com.getui.gtc.dim.b.h hVar = this.a.get(str);
        if (hVar != null) {
            java.lang.Object obj = hVar.a;
            if (obj instanceof java.util.List) {
                java.util.List list = (java.util.List) obj;
                return new com.getui.gtc.dim.b.h(list.isEmpty() ? java.util.Collections.emptyList() : new java.util.ArrayList(list), hVar.b);
            }
        }
        return hVar;
    }

    public final void a(java.lang.String str, java.lang.Object obj, long j) {
        if (com.getui.gtc.dim.b.f.h(str)) {
            com.getui.gtc.dim.e.b.a(str + " skip dim ram cache = " + obj);
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (j <= 0) {
            j = java.lang.System.currentTimeMillis();
        }
        com.getui.gtc.dim.b.h hVar = new com.getui.gtc.dim.b.h(obj, j);
        com.getui.gtc.dim.e.b.a(str + " update dim ram cache = " + obj);
        this.a.put(str, hVar);
    }
}
